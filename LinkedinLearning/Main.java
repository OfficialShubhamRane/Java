import java.text.NumberFormat;
import java.util.List;
import java.util.ArrayList;

import javax.swing.text.NumberFormatter;

public class Main {
    public static void main(String[] args) {
        ClothingItem obj = new ClothingItem(ClothingItem.SHIRT, ClothingSizes.M, 19.98, 3); 

        var totalPrice = obj.getPrice() * obj.getQuantity();
        var formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Your total value is: "+ formatter.format(totalPrice) +" for "+ obj.getQuantity() +" - " +obj.getType());

        List<String> list = new ArrayList<String>();

        list.add("Shubham");
        list.add("Shubham1");
        list.add("Shubham2");

        list.forEach(System.out::println);
        
    }
}
