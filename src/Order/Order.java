package Order;

import Menu.Main.MainMenuItem;
import Menu.Side.SideMenuItem;

import java.util.List;

public class Order {

    private final List<MainMenuItem> mainItem;
    private final List<SideMenuItem> sideItem;
    private final double totalPrice;

    public Order(List<MainMenuItem> mainItem, List<SideMenuItem> sideItem, double totalPrice) {
        this.mainItem = mainItem;
        this.sideItem = sideItem;
        this.totalPrice = totalPrice;
    }

    public void displayOrder(){
        System.out.println("주문 내역:");
        for(MainMenuItem item : mainItem){
            item.displayMain();
        }
        for(SideMenuItem item : sideItem){
            item.displaySide();
        }
        System.out.println("총 금액: W" + totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
