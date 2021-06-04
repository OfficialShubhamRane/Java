import java.util.Arrays;
import java.util.stream.Collectors;

public class Inverter {

    public static void main(String[] args) {

    }

    public static String invert(String s) {

        String result = null;
        if(s.equals("")){
            result =  "";
        }
        else if( s.length() == 1){
            result =  s;
        }else if(s.length() > 1){

            result = Arrays.stream(s.split(" "))
                    .map(str -> new StringBuilder(str).reverse())
                    .collect(Collectors.joining(" "));
        }

        return result;
    }
}
