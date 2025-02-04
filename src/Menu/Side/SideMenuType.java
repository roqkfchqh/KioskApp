package Menu.Side;

import Exception.BadInputException;

import java.util.Arrays;
import java.util.Objects;

public enum SideMenuType {
  
    TTEOK_ADD(1, "떡추가", 0.1, 1),
    CHEESE_ADD(2, "치즈추가", 0.3, 1),
    CHINESE_DANGMYEON(3, "중국당면추가", 0.25, 1),
    RICE_BALL(4, "주먹밥", 0.2, 10),
    SUNDAE(5, "순대", 0.3, 10),
    MANDU(6, "만두", 0.2, 1),
    DANGMYEON(7, "당면사리추가", 0.2, 1),
    COOLPIS(8, "쿨피스", 0.1, 10);

    private int id;
    private final String name;
    private final double price;
    private final int maxQuantity;

    SideMenuType(int id, String name, double price, int maxQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.maxQuantity = maxQuantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    /**
     * 특정 사이드메뉴 찾아주는 메서드
     * @param name 사이드메뉴 이름
     * @return name 과 같은 메뉴 타입
     */
    public static SideMenuType findName(String name){
        return Arrays.stream(values())
                .filter(type -> Objects.equals(type.getName(), name))
                .findFirst()
                .orElseThrow(() -> new BadInputException("존재하지 않는 메뉴입니다."));
    }
}
