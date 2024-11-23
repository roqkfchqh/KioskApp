package Menu.Main;

public enum MainMenuType {
  
    YEOP_TTEOKBOKKI("엽기떡볶이", 1.4, "압도적 1위 엽기떡볶이"),
    YEOP_ODEN("엽기오뎅", 1.6, "오뎅 가득 엽기떡볶이"),
    YEOP_CHICKENFEET("엽기 국물닭발", 1.5, "맛있게 매운 엽기 국물닭발"),
    YEOP_DAKBOKKEUM("엽기 닭볶음탕", 2.4, "한 번도 안 먹은 사람은 있어도 한번만 먹는 사람은 없다");

    private final String name;
    private final double price;
    private final String description;

    MainMenuType(String name, double price, String description) {
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
}
