package Order;

import Menu.Main.MainMenuItem;
import Menu.Main.MainMenuType;
import Menu.Side.SideMenuItem;
import Menu.Side.SideMenuType;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
  
    private List<MainMenuItem> mainItem = new ArrayList<>();
    private final List<SideMenuItem> sideItem = new ArrayList<>();
    
    public OrderBuilder(List<MainMenuItem> mainItem){
        this.mainItem = mainItem;
    }

    public OrderBuilder addMain(MainMenuType type, int quantity, int taste){
        mainItem.add(new MainMenuItem(type, quantity, taste));
        return this;
    }

    public OrderBuilder addSide(SideMenuType type, int quantity){
        sideItem.add(new SideMenuItem(type, quantity));
        return this;
    }

    public Order build(){
        return new Order(mainItem, sideItem);
    }
}
