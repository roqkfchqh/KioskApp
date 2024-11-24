package Menu.Side;

public enum SideMenuType {
  
    TTEOK_ADD(1, "떡추가", 0.1, 1),
    CHEESE_ADD(2, "모짜렐라 치즈 추가", 0.3, 1),
    CHINESE_DANGMYEON(3, "중국당면 추가", 0.25, 1),
    RICE_BALL(4, "주먹밥(셀프)", 0.2, 10),
    SUNDAE(5, "순대", 0.3, 10),
    MANDU(6, "만두(4개)", 0.2, 1),
    DANGMYEON(7, "일반 당면사리 추가", 0.2, 1),
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

    public int getId() {
        return id;
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
