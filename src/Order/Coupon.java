package Order;

import java.util.function.Function;

public enum Coupon {
    COUPON_10("매장주문 10% 할인", (price) -> price * 0.9),
    COUPON_20("방문포장 20% 할인", (price) -> price * 0.8),
    COUPON_33("수험생 33% 할인", (price) -> price * 0.67),
    COUPON_50("군인 50% 할인", (price) -> price * 0.5);

    private final String couponName;
    private final Function<Double, Double> calculation;

    Coupon(String couponName, Function<Double, Double> calculation){
        this.couponName = couponName;
        this.calculation = calculation;
    }

    public String getCouponName(){
        return couponName;
    }

    /**
     * 쿠폰 적용가 계산 메서드
     * @param price 쿠폰 제외 합산금액
     * @return 쿠폰 포함한 금액
     */
    public double applyCoupon(double price){
        return calculation.apply(price);
    }

    /**
     * 쿠폰 ui
     */
    public static void displayCoupon(){
        System.out.println("1. " + COUPON_10.couponName);
        System.out.println("2. " + COUPON_20.couponName);
        System.out.println("3. " + COUPON_33.couponName);
        System.out.println("4. " + COUPON_50.couponName);
        System.out.println("5. " + "적용 안함");
    }
}
