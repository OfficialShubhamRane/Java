package org.example;

public class Utils {

    public static String nodeAToBUniDir(String a, String b){
        return  a + " --> " + b;
    }

    public static String nodeAToBiDir(String a, String b){
        return  a + " <--> " + b;
    }

    public static String screenNameFromPackageName(String x){
        return  x.substring(x.indexOf(".")+1);
    }

    public static String screenNameFromFileName(String x){
        return  x.substring(0,x.indexOf("."));
    }

}
