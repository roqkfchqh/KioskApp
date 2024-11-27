package Order;

import java.util.Arrays;
import java.util.function.Function;

public enum Coupon {
    COUPON_10(1, "매장주문 10% 할인", (price) -> price * 0.9),
    COUPON_20(2, "방문포장 20% 할인", (price) -> price * 0.8),
    COUPON_33(3, "수험생 33% 할인", (price) -> price * 0.67),
    COUPON_50(4, "군인 50% 할인", (price) -> price * 0.5);

    private int id;
    private final String couponName;
    private final Function<Double, Double> calculation;

    Coupon(int id, String couponName, Function<Double, Double> calculation){
        this.id = id;
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

    /**
     * id가 일치하는 coupon 값 getter
     * @param input 사용자 입력 int
     * @return Coupon
     */
    public static Coupon getCoupon(int input){
        return Arrays.stream(Coupon.values())
                .filter(coupon -> coupon.id == input)
                .findFirst()
                .orElse(null);
    }
}
