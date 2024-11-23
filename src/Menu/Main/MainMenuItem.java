package Menu.Main;

public class MainMenuItem{
  
    private final MainMenuType type;
    private final int quantity;
    private final int taste;

    public MainMenuItem(MainMenuType type, int quantity, int taste){
        this.type = type;
        this.quantity = quantity;
        this.taste = taste;
    }

    public MainMenuType getType(){
        return type;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getTaste(){
        return taste;
    }

    public double getTotalPrice(){
        return type.getPrice() * quantity;
    }

    public void displayMain(){
        System.out.println(type.getName() + " | W " + type.getPrice() + " | " + type.getDescription());
    }
}
