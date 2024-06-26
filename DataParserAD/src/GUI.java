import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DataStructure.HashMap;
import DataStructure.LinkedList;
import Game.Game;

public class GUI {
    private final Application application;
    private final SimpleDateFormat releaseDateFormat;
    private double printTimer;
    private String currentSortingAlgorithm = "No Sorting Algorithm Selected!";
    private String currentDataStructure = "No Data Structure Selected!";
    private String linkedListLastSorted = "No Sorting Algorithm Selected!";
    private String hashMapLastSorted = "No Sorting Algorithm Selected!";
    private String arrayListLastSorted = "No Sorting Algorithm Selected!";


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
    JButton buttonLinkedList = new JButton("Use LinkedList Data Structure");
    JButton buttonHashMap = new JButton("Use HashMap Data Structure");
    JButton buttonArrayList = new JButton("Use ArrayList Data Structure");
    JButton buttonLinearSearch = new JButton("Search with Linear Search");
    JButton buttonBinarySearch = new JButton("Search with Binary Search");

    //Create Labels
    JLabel titleMainPage = new JLabel("Data Parser A&D");
    JLabel timerLabel = new JLabel("The action took " + printTimer + "s");
    JLabel currentSortingAlgorithmLabel = new JLabel("Currently Using: " + currentSortingAlgorithm);
    JLabel currentDataStructureLabel = new JLabel("Currently Using " + currentDataStructure);
    JLabel alertLabel = new JLabel("Notifications will appear here");

    //Create Text Fields
    JTextField searchInput = new JTextField("Type a game's name!");

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
        mainPage.setSize(1200, 1000);
        mainPage.setTitle("DataParserAD");
        mainPage.setVisible(true);
        mainPage.setResizable(false);

        //add mainPanel to mainPage
        createMainPanel();

        //add tables to model
        createTableModel();

        //add on click for the buttons
        addOnClickButtons();
    }

    public void createMainPanel() {
        //set panel attributes
        mainPanel.setLayout(null);
        mainPage.add(mainPanel);

        //add labels and set their locations
        titleMainPage.setBounds(50, 25, 200, 50);
        mainPanel.add(titleMainPage);
        timerLabel.setBounds(950, 25, 200, 50);
        mainPanel.add(timerLabel);
        currentSortingAlgorithmLabel.setBounds(350, 25, 300, 50);
        mainPanel.add(currentSortingAlgorithmLabel);
        currentDataStructureLabel.setBounds(650, 25, 300, 50);
        mainPanel.add(currentDataStructureLabel);
        alertLabel.setBounds(0, 925, 800, 50);
        mainPanel.add(alertLabel);

        //add buttons and set their locations
        refreshData.setBounds(50, 125, 200, 50);
        mainPanel.add(refreshData);
        buttonQuickSort.setBounds(50, 225, 200, 50);
        mainPanel.add(buttonQuickSort);
        buttonHeapSort.setBounds(350, 225, 200, 50);
        mainPanel.add(buttonHeapSort);
        buttonMergeSort.setBounds(50, 325, 200, 50);
        mainPanel.add(buttonMergeSort);
        buttonBubbleSort.setBounds(350, 325, 200, 50);
        mainPanel.add(buttonBubbleSort);
        buttonLinkedList.setBounds(650, 125, 220, 50);
        mainPanel.add(buttonLinkedList);
        buttonHashMap.setBounds(650, 225, 220, 50);
        mainPanel.add(buttonHashMap);
        buttonArrayList.setBounds(650, 325, 220, 50);
        mainPanel.add(buttonArrayList);
        buttonLinearSearch.setBounds(950, 225, 200, 50);
        mainPanel.add(buttonLinearSearch);
        buttonBinarySearch.setBounds(950, 325, 200, 50);
        mainPanel.add(buttonBinarySearch);

        //add text field
        searchInput.setBounds(950, 125, 200, 50);
        mainPanel.add(searchInput);
    }

    public void printData(){
        if(application.getSelectedDataStructure() == Application.DataStructures.None) {
            ArrayList<Game> Games = application.getGames();
            model.setRowCount(0);
            for(Game game: Games){
                model.addRow(new Object[]{game.getName(), game.getGenre(), game.getPEGI(), game.getPrice(), parseDateToString(game.getReleaseDate())});
            }
        } else if (application.getSelectedDataStructure() == Application.DataStructures.LinkedList){
            LinkedList<Game> Games = application.getLinkedListGame();
            model.setRowCount(0);
            for(int j = 0; j < Games.size(); j++){
                model.addRow(new Object[]{
                        Games.get(j).getName(),
                        Games.get(j).getGenre(),
                        Games.get(j).getPEGI(),
                        Games.get(j).getPrice(),
                        parseDateToString(Games.get(j).getReleaseDate())});
            }
        } else if (application.getSelectedDataStructure() == Application.DataStructures.HashMap){
            HashMap<Integer, Game> Games = application.getHashMapGame();
            model.setRowCount(0);
            for(int j = 0; j < Games.size(); j++){
                model.addRow(new Object[]{
                        Games.get(j).getName(),
                        Games.get(j).getGenre(),
                        Games.get(j).getPEGI(),
                        Games.get(j).getPrice(),
                        parseDateToString(Games.get(j).getReleaseDate())});
            }
        } else if (application.getSelectedDataStructure() == Application.DataStructures.ArrayList){
            DataStructure.ArrayList<Game> Games = application.getArrayListGame();
            model.setRowCount(0);
            for(int j = 0; j < Games.size(); j++){
                model.addRow(new Object[]{
                        Games.get(j).getName(),
                        Games.get(j).getGenre(),
                        Games.get(j).getPEGI(),
                        Games.get(j).getPrice(),
                        parseDateToString(Games.get(j).getReleaseDate())});
            }
        }
    }

    public void refreshData(){
        application.xmlToArrayList("src/Games.xml");
        ArrayList<Game> Games = application.getGames();
        application.refreshListGames();
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
        //dataTable.setBounds(0, 325, 600, 500);
        dataTable.setDefaultEditor(Object.class, null);
        mainPanel.add(dataTable);

        // Add the table to a scroll pane

        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(0, 425, 1200, 500); // Set bounds for the scroll pane
        mainPanel.add(scrollPane);
    }

    private void addOnClickButtons(){
        refreshData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                printData();
                currentSortingAlgorithm = "No Sorting Algorithm Selected";
                currentSortingAlgorithmLabel.setText("Currently Using: " + currentSortingAlgorithm);
            }
        });

        buttonQuickSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                initialiseTimer();
                application.quickSortData();
                endTimer();
                printData();
                currentSortingAlgorithm = "Quicksort";
                currentSortingAlgorithmLabel.setText("Currently Using: " + currentSortingAlgorithm);
                setSort(currentSortingAlgorithm);
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
                currentSortingAlgorithm = "BubbleSort";
                currentSortingAlgorithmLabel.setText("Currently Using: " + currentSortingAlgorithm);
                setSort(currentSortingAlgorithm);
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
                currentSortingAlgorithm = "Mergesort";
                currentSortingAlgorithmLabel.setText("Currently Using: " + currentSortingAlgorithm);
                setSort(currentSortingAlgorithm);
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
                currentSortingAlgorithm = "Heapsort";
                currentSortingAlgorithmLabel.setText("Currently Using: " + currentSortingAlgorithm);
                setSort(currentSortingAlgorithm);

            }
        });

        buttonLinkedList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                application.useLinkedList();
                currentDataStructure = "LinkedList";
                currentDataStructureLabel.setText("Currently Using: " + currentDataStructure);
                currentSortingAlgorithmLabel.setText("Currently Using: " + linkedListLastSorted);
                printData();
            }
        });

        buttonHashMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                application.useHashMap();
                currentDataStructure = "HashMap";
                currentDataStructureLabel.setText("Currently Using: " + currentDataStructure);
                currentSortingAlgorithmLabel.setText("Currently Using: " + hashMapLastSorted);
                printData();
            }
        });

        buttonArrayList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                application.useArrayList();
                currentDataStructure = "ArrayList";
                currentDataStructureLabel.setText("Currently Using: " + currentDataStructure);
                currentSortingAlgorithmLabel.setText("Currently Using: " + arrayListLastSorted);
                printData();
            }
        });

        buttonLinearSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchInput != null){
                    initialiseTimer();
                    int searchResult = application.linearSearch(searchInput.getText());
                    endTimer();
                    if (searchResult != -1) {
                        alertLabel.setText("The selected item is at index: " + searchResult +
                                ". Meaning its at location " + (searchResult+1) + "in the list!");
                    } else {
                        alertLabel.setText("Please select a Data Structure " +
                                "to search for an item in the list with linear search.");
                    }
                } else {
                    alertLabel.setText("No text was entered!");
                }
            }
        });

        buttonBinarySearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(searchInput != null){
                    initialiseTimer();
                    int searchResult = application.binarySearch(searchInput.getText());
                    endTimer();
                    if (searchResult != -1) {
                        alertLabel.setText("The selected item is at index: " + searchResult +
                                ". Meaning its at location " + (searchResult + 1) + "in the list!");
                    } else {
                        alertLabel.setText("Please select a Data Structure " +
                                "and a Sorting Algorithm to search for an item in the list with binary search.");
                    }
                } else {
                    alertLabel.setText("No text was entered!");
                }
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
        System.out.println("The action took " + (System.nanoTime() - startTimer +"ns"));
        printTimer = toDouble(duration/1000000000); //Set to seconds
        timerLabel.setText("The action took " + printTimer + "s"); // Display seconds to sort on frontend
    }

    public void setSort(String sortingType){
        if (application.getSelectedDataStructure() == Application.DataStructures.LinkedList){
            linkedListLastSorted = sortingType;
        } else if (application.getSelectedDataStructure() == Application.DataStructures.HashMap){
            hashMapLastSorted = sortingType;
        } else if (application.getSelectedDataStructure() == Application.DataStructures.ArrayList){
            arrayListLastSorted = sortingType;
        }
    }
}
