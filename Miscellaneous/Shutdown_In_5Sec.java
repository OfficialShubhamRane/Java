import java.io.IOException;

public class Shutdown_In_5Sec {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process p = runtime.exec("shutdown -s -t 5");
        System.exit(1);
    }
}
