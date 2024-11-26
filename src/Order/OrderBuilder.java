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

    /**
     * 장바구니 비었는지 확인
     * @return main,side 둘다 empty == true
     */
    public boolean isEmpty() {
        return mainItem.isEmpty() && sideItem.isEmpty();
    }

    /**
     * 메인메뉴 있는지 확인
     * @return main empty == true
     */
    public boolean mainEmpty(){
        return mainItem.isEmpty();
    }

    /**
     * 메인메뉴 추가 메서드
     * @param type 메인메뉴 타입
     * @param taste 맵기
     */
    public void addMain(MainMenuType type, int taste){
        mainItem.stream()
                .filter(item -> item.getType() == type && item.getTaste() == taste)
                .findFirst()
                .ifPresentOrElse(
                        item -> item.setQuantity(item.getQuantity() + 1),
                        () -> mainItem.add(MenuFactory.createMainMenu(type, 1, taste))
                );
    }

    /**
     * 사이드메뉴 추가 메서드
     * @param type 사이드메뉴 타입
     */
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

    /**
     * 메인메뉴 삭제 메서드
     * @param name 메뉴 이름(한글)
     */
    public void deleteMain(String name) {
        MainMenuType type = MainMenuType.findName(name);
        mainItem.removeIf(item -> item.getType() == type);

    }

    /**
     * 사이드메뉴 삭제 메서드
     * @param name 사이드메뉴 이름(한글)
     */
    public void deleteSide(String name) {
        SideMenuType type = SideMenuType.findName(name);
        sideItem.removeIf(item -> item.getType() == type);
    }

    /**
     * 주문 완료 시 기존내역 청소하는 메서드
     */
    public void clearMenu(){
        mainItem.clear();
        sideItem.clear();
        coupon = null;
    }

    /**
     * 쿠폰 setter
     * @param coupon
     */
    public void setCoupon(Coupon coupon){
        this.coupon = coupon;
    }

    /**
     * 쿠폰 적용 안했는지 확인하는 메서드
     * @return 쿠폰 null : true
     */
    public boolean isCouponEmpty(){
        return coupon == null;
    }

    /**
     * 총 금액 계산 메서드
     * @return (쿠폰 제외) 메인메뉴 + 사이드메뉴
     */
    public double totalPrice(){
        return mainItem.stream().mapToDouble(MainMenuItem::getTotalPrice).sum()
                + sideItem.stream().mapToDouble(SideMenuItem::getTotalPrice).sum();
    }

    /**
     * 쿠폰 포함한 총 금액 계산 메서드
     * @return 쿠폰 포함 금액
     */
    public double couponPrice(){
        if(coupon == null) return totalPrice();
        return coupon.applyCoupon(totalPrice());
    }

    /**
     * 장바구니 ui
     */
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

    /**
     * 최종 build
     * @return 새로운 Order 객체를 복사하여 반환
     */
    public Order build(){
        String finalPrice = String.format("%.2f", couponPrice());
        return new Order(new ArrayList<>(mainItem), new ArrayList<>(sideItem), finalPrice);
    }
}
