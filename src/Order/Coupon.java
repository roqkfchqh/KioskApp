package Order;

import java.util.function.BiFunction;

public enum Coupon {
    NONE("일반", 0.0, (price, quantity) -> price * quantity),
    COUPON_10("매장주문 10% 할인", 0.1, (price, quantity) -> price * quantity * 0.9),
    COUPON_20("방문포장 20% 할인", 0.2, (price, quantity) -> price * quantity * 0.8),
    COUPON_33("수험생 33% 할인", 0.33, (price, quantity) -> price * quantity * 0.67);

    private final String couponName;
    private final double discountRate;
    private final BiFunction<Double, Double, Double> calculation;

    Coupon(String couponName, double discountRate, BiFunction<Double, Double, Double> calculation){
        this.couponName = couponName;
        this.discountRate = discountRate;
        this.calculation = calculation;
    }

    public String getCouponName(){
        return couponName;
    }

    public double applyCoupon(double price, double quantity){
        return calculation.apply(price, quantity);
    }
}
