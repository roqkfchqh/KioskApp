package Order;

import Exception.BadInputException;
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
        if(mainItem.isEmpty()){
            throw new BadInputException("메인 메뉴 없이 주문할 수 없습니다.");
        }
        for(SideMenuItem item : sideItem){
            if(item.getType() == type){
                if(quantity > type.getMaxQuantity()){
                    throw new BadInputException("최대 주문 가능 수량을 초과했습니다.");
                }
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        sideItem.add(SideMenuFactory.createSideMenu(type, quantity));
    }

    public void deleteMenu(){
        System.out.println("\n\n삭제할 메뉴를 골라주세요:\n");
        for(MainMenuItem item : mainItem){
            item.displayMain();
        }
        for(SideMenuItem item : sideItem){
            item.displaySide();
        }
        String deleteInput = new java.util.Scanner(System.in).nextLine();
        int deleteChoice = Integer.parseInt(deleteInput);
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

    public String couponPrice(){
        if(coupon == null) return String.format("%.2f", totalPrice());
        return String.format("%.2f" ,coupon.applyCoupon(totalPrice()));
    }

    public void displayBuilder(){
        System.out.println("\n\n장바구니:");
        for(MainMenuItem item : mainItem){
            item.displayMain();
        }
        for(SideMenuItem item : sideItem){
            item.displaySide();
        }
        if(coupon == null){
            System.out.println("총 금액: W" + totalPrice());
        }else{
            System.out.println(coupon.getCouponName() + "을 적용한 총 금액: W" + couponPrice());
        }
    }

    public Order build(){
        return new Order(new ArrayList<>(mainItem), new ArrayList<>(sideItem), couponPrice());
    }
}
