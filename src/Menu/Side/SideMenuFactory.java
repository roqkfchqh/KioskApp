package Menu.Side;

public class SideMenuFactory {
  
    public static SideMenuItem createSideMenu(SideMenuType type, int quantity){
        return new SideMenuItem(type, quantity);
    }
}
