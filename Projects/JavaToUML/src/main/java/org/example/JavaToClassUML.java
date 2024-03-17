package org.example;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class JavaToClassUML {
    public static void main(String[] args) throws FileNotFoundException {
        // Directory containing Java files
        String directoryPath = "E:\\Java\\Projects\\JavaToUML\\src\\main\\resources\\input";
        List<File> javaFiles = getJavaFiles(directoryPath);

        // Parse Java files and generate UML class diagram
        for (File javaFile : javaFiles) {
            generateClassDiagram(javaFile);
        }
    }

    private static List<File> getJavaFiles(String directoryPath) {
        List<File> javaFiles = new ArrayList<>();
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a directory");
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    javaFiles.add(file);
                }
            }
        }
        return javaFiles;
    }

    private static void generateClassDiagram(File javaFile) throws FileNotFoundException {
        FileInputStream in = new FileInputStream(javaFile);
        CompilationUnit cu = null;
        try {
            cu = new JavaParser().parse(in).getResult().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        UMLVisitor visitor = new UMLVisitor();
        visitor.visit(cu, null);
        System.out.println(visitor.getClassDiagram());
    }

    static class UMLVisitor extends VoidVisitorAdapter<Void> {
        private StringBuilder classDiagram = new StringBuilder();

        @Override
        public void visit(ClassOrInterfaceDeclaration classDeclaration, Void arg) {
            String className = classDeclaration.getNameAsString();
            classDiagram.append("class ").append(className).append(" {\n");
            List<String> methods = new ArrayList<>();
            for (MethodDeclaration method : classDeclaration.getMethods()) {
                methods.add(method.getDeclarationAsString(false, false, false));
            }
            for (String method : methods) {
                classDiagram.append("\t").append(method).append("\n");
            }
            classDiagram.append("}\n\n");
        }

        public String getClassDiagram() {
            return classDiagram.toString();
        }
    }
}
