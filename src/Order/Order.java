package Order;

import Menu.Main.MainMenuItem;
import Menu.Side.SideMenuItem;

import java.util.List;

public class Order {
  
    private final List<MainMenuItem> mainItem;
    private final List<SideMenuItem> sideItem;
  
    public Order(List<MainMenuItem> mainItem, List<SideMenuItem> sideItem) {
        this.mainItem = mainItem;
        this.sideItem = sideItem;
    }

    public void displayOrder(){
        System.out.println("주문 내역");
        for(MainMenuItem item : mainItem){
            item.displayMain();
        }
        for(SideMenuItem item : sideItem){
            item.displaySide();
        }
        System.out.println("총 가격: W " + getTotalPrice());
    }

    public double getTotalPrice(){
        double total = 0;
        for(MainMenuItem item : mainItem){
            total += item.getTotalPrice();
        }
        for(SideMenuItem item : sideItem){
            total += item.getTotalPrice();
        }
        return total;
    }
}
