import org.opencv.core.Core;
import org.opencv.osgi.OpenCVNativeLoader;

public class App {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static void main(String[] args){
        System.out.println(Core.VERSION);

    }
}
