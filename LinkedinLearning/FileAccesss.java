import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileAccesss {


    public static void main(String[] args) {

        try {
            Path filePath = FileSystems.getDefault().getPath("E:/Java/LinkedinLearning", "TestFile.txt");
            List<String> fileList = Files.readAllLines(filePath);
            fileList.forEach(System.out::println);
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
}
