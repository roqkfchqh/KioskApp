package Menu.Main;

public class MainMenuFactory {
  
    public static MainMenuItem createMainMenu(MainMenuType type, int quantity, int taste){
        return new MainMenuItem(type, quantity, taste);
  }
}