import javax.sql.RowSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GUI {
    private Application application;
    private SimpleDateFormat releaseDateFormat;
    private double printTimer;

    //create Pages
    JFrame mainPage = new JFrame();

    //create Panels
    JPanel mainPanel = new JPanel();

    //create Buttons
    JButton buttonQuickSort = new JButton("Quicksort");
    JButton buttonHeapSort = new JButton("HeapSort");
    JButton buttonMergeSort = new JButton("MergeSort");
    JButton buttonBubbleSort = new JButton("BubbleSort");
    JButton refreshData = new JButton("Refresh Data");

    //Create Labels
    JLabel titleMainPage = new JLabel("Data Parser A&D");
    JLabel timerLabel = new JLabel("The timer took " + printTimer + "ns");

    //Create JTable
    DefaultTableModel model = new DefaultTableModel();

    //Timer
    long startTimer = 0;
    long duration = 0;

    public GUI(Application application) {
        this.application = application;
        releaseDateFormat = application.getReleaseDateFormat();
        //create MainPage
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setSize(800, 800);
        mainPage.setTitle("DataParserAD");
        mainPage.setVisible(true);
        mainPage.setResizable(false);

        //add mainPanel to mainPage
        createMainPanel();

        createTableModel();

        addOnClickButtons();
    }

    public void createMainPanel() {
        //set panel attributes
        mainPanel.setLayout(null);
        mainPage.add(mainPanel);

        //add labels and set their locations
        titleMainPage.setBounds(50, 25, 200, 50);
        mainPanel.add(titleMainPage);
        timerLabel.setBounds(600, 25, 200, 50);
        mainPanel.add(timerLabel);

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

    public void printData(){
        ArrayList<Game> Games = application.getGames();
        model.setRowCount(0);
        for(Game game: Games){
            model.addRow(new Object[]{game.getName(), game.getGenre(), game.getPEGI(), game.getPrice(), parseDateToString(game.getReleaseDate())});
        }
    }

    public void refreshData(){
        application.xmlToArrayList("src/Games.xml");
        ArrayList<Game> Games = application.getGames();
        model.setRowCount(0);
        for(Game game: Games){
            model.addRow(new Object[]{game.getName(), game.getGenre(), game.getPEGI(), game.getPrice(), parseDateToString(game.getReleaseDate())});
        }
    }

    private String parseDateToString(Date date) {
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
        refreshData();

        //create a table with new model
        JTable dataTable = new JTable(model);
//        dataTable.setBounds(0, 325, 600, 500);
        dataTable.setDefaultEditor(Object.class, null);
        mainPanel.add(dataTable);

        // Add the table to a scroll pane

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(0, 325, 800, 500); // Set bounds for the scroll pane
        mainPanel.add(scrollPane);
    }

    private void addOnClickButtons(){
        buttonQuickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                initialiseTimer();
                application.quickSortData();
                endTimer();
                printData();
            }
        });

        refreshData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                printData();
            }
        });

        buttonBubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                initialiseTimer();
                application.bubbleSortData();
                endTimer();
                printData();
            }
        });

        buttonMergeSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                initialiseTimer();
                application.mergeSortData();
                endTimer();
                printData();
            }
        });

        buttonHeapSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                initialiseTimer();
                application.heapSortData();
                endTimer();
                printData();
            }
        });
    }

    public double toDouble(Long l){
        String s = l + "";
        return Double.parseDouble(s);
    }

    public void initialiseTimer(){
        //resets variables and starts timer
        startTimer = 0;
        duration = 0;
        startTimer = System.nanoTime();
    }

    public void endTimer(){
        duration = (System.nanoTime() - startTimer); //get time spend
        //write to console time spend in nanoseconds
        System.out.println("It took " + (System.nanoTime() - startTimer +" Nano Seconds to sort"));
        printTimer = toDouble(duration/1000000000); //Set to seconds
        timerLabel.setText("The timer took " + printTimer + "s"); // Display seconds to sort on frontend
    }
}
