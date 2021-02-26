class ClothingItem{
    private String type;
    private ClothingSizes size;
    private double price;
    private int quantity;

    public static final String SHIRT = "Shirt";
    public static final String PANT = "Pant";
    public static final String HAT = "Hat";

    public ClothingItem(String type, ClothingSizes size, double price, int quantity){
        this.type = type;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public ClothingSizes getSize(){
        return this.size;
    }

    public void setSize(ClothingSizes size){
        this.size = size;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice( double price){
        this.price = price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}