import javax.sql.RowSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GUI {
    private SimpleDateFormat releaseDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<Game> Games;

    //create Pages
    JFrame mainPage = new JFrame();

    //create Panels
    JPanel mainPanel = new JPanel();
    JPanel dataPanel = new JPanel();

    //create Buttons
    JButton buttonQuickSort = new JButton("Quicksort");
    JButton buttonHeapSort = new JButton("HeapSort");
    JButton buttonMergeSort = new JButton("MergeSort");
    JButton buttonBubbleSort = new JButton("BubbleSort");
    JButton refreshData = new JButton("Refresh Data");

    //Create Labels
    JLabel titleMainPage = new JLabel("Data Parser Algoritme en Datastructuren");

    //Create JTable
    DefaultTableModel model = new DefaultTableModel();

    public GUI(ArrayList<Game> Games) {
        //create MainPage
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setSize(600, 800);
        mainPage.setTitle("DataParserAD");
        mainPage.setVisible(true);
        mainPage.setResizable(false);

        //add mainPanel to mainPage
        this.Games = Games;
        createMainPanel();

        createTableModel();
    }

    public void createMainPanel()
    {
        //set panel attributes
        mainPanel.setLayout(null);
        mainPage.add(mainPanel);

        //add labels and set their locations
        titleMainPage.setBounds(50, 25, 200, 50);
        mainPanel.add(titleMainPage);

        //add buttons and set their locations
        refreshData.setBounds(350, 25, 200, 50);
        mainPanel.add(refreshData);
        buttonQuickSort.setBounds(50, 125, 200, 50);
        mainPanel.add(buttonQuickSort);
        buttonHeapSort.setBounds(350, 125, 200, 50);
        mainPanel.add(buttonHeapSort);
        buttonMergeSort.setBounds(50, 225, 200, 50);
        mainPanel.add(buttonMergeSort);
        buttonBubbleSort.setBounds(350, 225, 200, 50);
        mainPanel.add(buttonBubbleSort);
    }

    public void refreshData(ArrayList<Game> Games){
        model.setRowCount(0);
        for(Game game: Games){
            model.addRow(new Object[]{game.getName(), game.getGenre(), game.getPEGI(), game.getPrice(), parseDateToString(game.getReleaseDate())});
        }
    }

    private String parseDateToString(Date date)
    {
        return releaseDateFormat.format(date);
    }

    private void createTableModel(){
        //add columns to table model
        model.addColumn("Name");
        model.addColumn("Genre");
        model.addColumn("PEGI");
        model.addColumn("Price");
        model.addColumn("Release Date");

        //add rows to the table model
        refreshData(Games);

        //create a table with new model
        JTable dataTable = new JTable(model);
        dataTable.setBounds(0, 325, 600, 500);
        dataTable.setDefaultEditor(Object.class, null);
        mainPanel.add(dataTable);

        // Add the table to a scroll pane
        /*
        JScrollPane scrollPane = new JScrollPane(dataTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);*/
    }
}
