import java.util.ArrayList;

public class Main extends Application{
    public static void main(String[] args){
        //test code
        System.out.println("here comes the date:");
        Application Application = new Application();

        //frontend start
        GUI gui = new GUI(Application.getGames(), Application);
    }
}