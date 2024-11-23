package Menu.Side;

public enum SideMenuType {
  
    TTEOK_ADD("떡추가", 0.1, 1),
    CHEESE_ADD("모짜렐라 치즈 추가", 0.3, 1),
    CHINESE_DANGMYEON("중국당면 추가", 0.25, 1),
    RICE_BALL("주먹밥(셀프)", 0.2, 10),
    SUNDAE("순대", 0.3, 10),
    MANDU("만두(4개)", 0.2, 1),
    DANGMYEON("일반 당면사리 추가", 0.2, 1),
    COOLPIS("쿨피스", 0.1, 10);

    private final String name;
    private final double price;
    private final int maxQuantity;

    SideMenuType(String name, double price, int maxQuantity) {
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
}
