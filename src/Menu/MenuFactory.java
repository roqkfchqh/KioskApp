package Menu;

import Menu.Main.MainMenuItem;
import Menu.Main.MainMenuType;
import Menu.Side.SideMenuItem;
import Menu.Side.SideMenuType;

public class MenuFactory {

    public static MainMenuItem createMainMenu(MainMenuType type, int quantity, int taste){
        return new MainMenuItem(type, quantity, taste);
    }

    public static SideMenuItem createSideMenu(SideMenuType type, int quantity){
        return new SideMenuItem(type, quantity);
    }
}
