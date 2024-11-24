package Order;

import Menu.Main.MainMenuFactory;
import Menu.Main.MainMenuItem;
import Menu.Main.MainMenuType;
import Menu.Side.SideMenuFactory;
import Menu.Side.SideMenuItem;
import Menu.Side.SideMenuType;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {

    private static final List<MainMenuItem> mainItem = new ArrayList<>();
    private static final List<SideMenuItem> sideItem = new ArrayList<>();
    private Coupon coupon;

    public boolean isEmpty() {
        return mainItem.isEmpty() && sideItem.isEmpty();
    }

    public void addMain(MainMenuType type, int quantity, int taste){
        for(MainMenuItem item : mainItem){
            if(item.getType() == type && item.getTaste() == taste){
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        mainItem.add(MainMenuFactory.createMainMenu(type, quantity, taste));
    }

    public void addSide(SideMenuType type, int quantity){
        for(SideMenuItem item : sideItem){
            if(item.getType() == type){
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        sideItem.add(SideMenuFactory.createSideMenu(type, quantity));
    }

    public void setCoupon(Coupon coupon){
        this.coupon = coupon;
    }

    public double totalPrice(){
        return mainItem.stream().mapToDouble(MainMenuItem::getTotalPrice).sum()
                + sideItem.stream().mapToDouble(SideMenuItem::getTotalPrice).sum();
    }

    public double couponPrice(){
        if(coupon == null) return totalPrice();
        return coupon.applyCoupon(totalPrice());
    }

    public void displayBuilder(){
        System.out.println("장바구니:");
        for(MainMenuItem item : mainItem){
            item.displayMain();
        }
        for(SideMenuItem item : sideItem){
            item.displaySide();
        }
        if(coupon == null){
            System.out.println("총 금액: W" + totalPrice());
        }else{
            System.out.println(coupon.getCouponName() + "을 적용한 총 금액: W" + totalPrice());
        }
    }

    public Order build(){
        return new Order(new ArrayList<>(mainItem), new ArrayList<>(sideItem), couponPrice());
    }
}
