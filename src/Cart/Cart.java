package Cart;

import Menu.Main.MainMenuItem;
import Menu.Side.SideMenuItem;
import Order.Order;
import Order.OrderBuilder;
import Order.Coupon;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public Coupon coupon;

    private final List<MainMenuItem> mainMenuItems;
    private final List<SideMenuItem> sideMenuItems;

    public Cart(){
        this.mainMenuItems = new ArrayList<>();
        this.sideMenuItems = new ArrayList<>();
    }

    public void addMainMenuItem(MainMenuItem item){
        mainMenuItems.add(item);
    }

    public void addSideMenuItem(SideMenuItem item){
        sideMenuItems.add(item);
    }

    public List<MainMenuItem> getMainMenuItems(){
        return mainMenuItems;
    }

    public List<SideMenuItem> getSideMenuItems(){
        return sideMenuItems;
    }

    public double getTotalPrice(){
        return mainMenuItems.stream()
                            .mapToDouble(item -> item.getTotalPrice())
                            .sum() 
                            + sideMenuItems.stream()
                            .mapToDouble(item -> item.getTotalPrice())
                            .sum();
    }

    public double getTotalPriceCoupon(){
        return coupon.applyCoupon(getTotalPrice(), 1);
    }

    public void displayCart(){
        System.out.println("장바구니");
        for(MainMenuItem item : mainMenuItems){
            item.displayMain();
        }
        for(SideMenuItem item : sideMenuItems){
            item.displaySide();
        }
        System.out.println("총 금액 : " + getTotalPrice());
        System.out.println("쿠폰 적용 금액 : " + getTotalPriceCoupon());
    }

    public Order createOrder(){
        OrderBuilder orderBuilder = new OrderBuilder(mainMenuItems, sideMenuItems);
        return orderBuilder.build();
    }
}
