package Order;

import Menu.Main.MainMenuFactory;
import Menu.Main.MainMenuItem;
import Menu.Main.MainMenuType;
import Menu.Side.SideMenuFactory;
import Menu.Side.SideMenuItem;
import Menu.Side.SideMenuType;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {

    private static final List<MainMenuItem> mainItem = new ArrayList<>();
    private static final List<SideMenuItem> sideItem = new ArrayList<>();

    public OrderBuilder addMain(MainMenuType type, int quantity, int taste){
        mainItem.add(MainMenuFactory.createMainMenu(type, quantity, taste));
        return this;
    }

    public OrderBuilder addSide(SideMenuType type, int quantity){
        sideItem.add(SideMenuFactory.createSideMenu(type, quantity));
        return this;
    }

    public Order build(){
        return new Order(mainItem, sideItem);
    }
}
