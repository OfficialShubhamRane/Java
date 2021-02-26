import jdk.jfr.Description;

public enum ClothingSizes{

    S("Small"), L("Large"), M("Medium"), XL("Extra Large");

    ClothingSizes (String description){
        this.description = description;
    }

    public String toString(){
        return description;
    }
    
}
