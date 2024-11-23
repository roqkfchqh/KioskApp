package Menu.Side;

public class SideMenuItem {
  
    private final SideMenuType type;
    private final int quantity;

    public SideMenuItem(SideMenuType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public SideMenuType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice(){
        return type.getPrice() * quantity;
    }

    public void displaySide(){
        System.out.println(type.getName() + " | W " + type.getPrice() + " | " + quantity + "개");
    }
}

