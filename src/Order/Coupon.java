package Order;

import java.util.function.Function;

public enum Coupon {
    COUPON_10("매장주문 10% 할인", 0.1, (price) -> price * 0.9),
    COUPON_20("방문포장 20% 할인", 0.2, (price) -> price * 0.8),
    COUPON_33("수험생 33% 할인", 0.33, (price) -> price * 0.67);

    private final String couponName;
    private final double discountRate;
    private final Function<Double, Double> calculation;

    Coupon(String couponName, double discountRate, Function<Double, Double> calculation){
        this.couponName = couponName;
        this.discountRate = discountRate;
        this.calculation = calculation;
    }

    public String getCouponName(){
        return couponName;
    }

    public double applyCoupon(double price){
        return calculation.apply(price);
    }

    public static void displayCoupon(){
        System.out.println("\n\n1. " + COUPON_10.couponName);
        System.out.println("2. " + COUPON_20.couponName);
        System.out.println("3. " + COUPON_33.couponName);
        System.out.println("4. " + "적용 안함");
    }
}
