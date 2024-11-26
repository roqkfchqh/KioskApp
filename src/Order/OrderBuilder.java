package Order;

import Exception.BadInputException;
import Menu.MenuFactory;
import Menu.Main.MainMenuItem;
import Menu.Main.MainMenuType;
import Menu.Side.SideMenuItem;
import Menu.Side.SideMenuType;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {

    private final List<MainMenuItem> mainItem = new ArrayList<>();
    private final List<SideMenuItem> sideItem = new ArrayList<>();
    private Coupon coupon;

    public boolean isEmpty() {
        return mainItem.isEmpty() && sideItem.isEmpty();
    }

    public boolean mainEmpty(){
        return mainItem.isEmpty();
    }

    public void addMain(MainMenuType type, int taste){
        mainItem.stream()
                .filter(item -> item.getType() == type && item.getTaste() == taste)
                .findFirst()
                .ifPresentOrElse(
                        item -> item.setQuantity(item.getQuantity() + 1),
                        () -> mainItem.add(MenuFactory.createMainMenu(type, 1, taste))
                );
    }

    public void addSide(SideMenuType type){
        sideItem.stream()
                .filter(item -> item.getType() == type)
                .findFirst()
                .ifPresentOrElse(
                        item -> {
                            if(item.getQuantity() + 1 > type.getMaxQuantity()){
                                throw new BadInputException("최대 주문 가능 수량을 초과했습니다.");
                            }
                            item.setQuantity(item.getQuantity() + 1);
                        },
                        () -> sideItem.add(MenuFactory.createSideMenu(type, 1))
                );
    }

    public void deleteMain(String name) {
        MainMenuType type = MainMenuType.findName(name);
        mainItem.removeIf(item -> item.getType() == type);

    }

    public void deleteSide(String name) {
        SideMenuType type = SideMenuType.findName(name);
        sideItem.removeIf(item -> item.getType() == type);
    }

    public void clearMenu(){
        mainItem.clear();
        sideItem.clear();
        coupon = null;
    }

    public void setCoupon(Coupon coupon){
        this.coupon = coupon;
    }

    public boolean isCouponEmpty(){
        return coupon == null;
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
        for(MainMenuItem item : mainItem){
            item.displayMain();
        }
        for(SideMenuItem item : sideItem){
            item.displaySide();
        }
        if(coupon == null){
            System.out.println("총 금액: W" + String.format("%.2f", totalPrice()));
        }else{
            System.out.println(coupon.getCouponName() + "을 적용한 총 금액: W" + String.format("%.2f", couponPrice()));
        }
    }

    public Order build(){
        String finalPrice = String.format("%.2f", couponPrice());
        return new Order(new ArrayList<>(mainItem), new ArrayList<>(sideItem), finalPrice);
    }
}
