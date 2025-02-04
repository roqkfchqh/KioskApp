package Menu.Main;

import Exception.BadInputException;

import java.util.Arrays;
import java.util.Objects;

public enum MainMenuType {
  
    YEOP_TTEOKBOKKI(1, "엽기떡볶이", 1.4, "압도적 1위 엽기떡볶이"),
    YEOP_ODEN(2, "엽기오뎅", 1.6, "오뎅 가득 엽기떡볶이"),
    YEOP_CHICKENFEET(3, "엽기 국물닭발", 1.5, "맛있게 매운 엽기 국물닭발"),
    YEOP_DAKBOKKEUM(4, "엽기 닭볶음탕", 2.4, "한 번도 안 먹은 사람은 있어도 한번만 먹는 사람은 없다");

    private final int id;
    private final String name;
    private final double price;
    private final String description;

    MainMenuType(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    } 

    public String getDescription() {
        return description;
    }

    /**
     * 특정 메인메뉴 찾아주는 메서드
     * @param name 메인메뉴 이름
     * @return name 과 같은 메뉴 타입
     */
    public static MainMenuType findName(String name){
        return Arrays.stream(values())
                .filter(type -> Objects.equals(type.getName(), name))
                .findFirst()
                .orElseThrow(() -> new BadInputException("존재하지 않는 메뉴입니다."));
    }
}