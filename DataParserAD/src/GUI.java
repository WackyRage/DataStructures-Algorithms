import javax.sql.RowSet;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GUI {
    private SimpleDateFormat releaseDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //create Pages
    JFrame mainPage = new JFrame();

    //create Panels
    JPanel mainPanel = new JPanel();

    //create Buttons
    JButton buttonQuickSort = new JButton("Quicksort");
    JButton buttonHeapSort = new JButton("HeapSort");
    JButton buttonMergeSort = new JButton("MergeSort");
    JButton buttonBubbleSort = new JButton("BubbleSort");

    //Create Labels
    JLabel titleMainPage = new JLabel("Main Page");

    //Create splitPane
    JSplitPane splitPaneData = new JSplitPane();

    public GUI(ArrayList<Game> Games) {
        //create MainPage
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setSize(600, 800);
        mainPage.setTitle("DataParserAD");
        mainPage.setVisible(true);
        mainPage.setResizable(false);

        //add mainPanel to mainPage
        createMainPanel(Games);
    }

    public void createMainPanel(ArrayList<Game> Games)
    {
        //set panel attributes
        mainPanel.setLayout(null);
        mainPage.add(mainPanel);

        //add labels and set their locations
        titleMainPage.setBounds(50, 25, 700, 50);
        mainPanel.add(titleMainPage);

        //add buttons and set their locations
        buttonQuickSort.setBounds(50, 125, 200, 50);
        mainPanel.add(buttonQuickSort);
        buttonHeapSort.setBounds(350, 125, 200, 50);
        mainPanel.add(buttonHeapSort);
        buttonMergeSort.setBounds(50, 225, 200, 50);
        mainPanel.add(buttonMergeSort);
        buttonBubbleSort.setBounds(350, 225, 200, 50);
        mainPanel.add(buttonBubbleSort);

        //add splitPane
        splitPaneData.setBounds(0, 425, 600, 500);
        mainPanel.add(splitPaneData);
        refreshData(Games);
    }

    public void refreshData(ArrayList<Game> Games){
        JPanel dataPanel = new JPanel();
        for(Game game: Games){
            JLabel label = new JLabel("Name: " + game.getName() + ", Genre: " + game.getGenre() + ", PEGI: " + game.getPEGI() + ", Price: " + game.getPrice() + ", Release date: " + parseDateToString(game.getReleaseDate()));
            dataPanel.add(label);
        }
        splitPaneData.setLeftComponent(new JScrollPane(dataPanel));
    }

    private String parseDateToString(Date date)
    {
        return releaseDateFormat.format(date);
    }
}
