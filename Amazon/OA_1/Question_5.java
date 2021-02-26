public class Question_5 {
    
    public boolean compareProduct(int num) {
        if (num < 10)
            return false;
        int oddProdValue = 1, evenProdValue = 1;

        while(num > 0) {
            int digit = num % 10;
            oddProdValue *= digit;
            System.out.println("odd prod: " + oddProdValue);
            num = num / 10;
            if(num == 0)
                break;
            digit = num % 10;
            evenProdValue *= digit;
            System.out.println("even prod: " + evenProdValue);
            num = num / 10;
        }
        if(evenProdValue == oddProdValue)
            return true;
        return false;
    }


    public static void main(String[] args) {
        Question_5 o = new Question_5();
        System.out.println(o.compareProduct(198));
    }
}
