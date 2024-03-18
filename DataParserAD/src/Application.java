import DataStructure.BinaryTree;
import DataStructure.DataStructureOperations;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Application {
    private SimpleDateFormat releaseDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<Game> Games = new ArrayList<>();
    enum DataStructures{
        None,
        LinkedList,
        HashMap,
        BinaryTree;
    }
    private DataStructures selectedDataStructure = DataStructures.None;
    private DataStructure.DataStructureOperations<Game> LinkedListGame = new DataStructure.LinkedList<>();
    //private DataStructure.DataStructureOperations<Game> HashMapGame = new DataStructure.HashMap<>();
    //private DataStructure.DataStructureOperations<Game> BinaryTreeGame = new DataStructure.BinaryTree<>();

    public Application(){
        xmlToArrayList("src/Games.xml");
        for (Game objGame : Games)
        {
            System.out.println(objGame.getName() + "\n" + objGame.getGenre() + "\n" + objGame.getPEGI() + "\n" + objGame.getPrice() + "\n" + objGame.getReleaseDate() + "\n");
        }
    }

    private String parseDateToString(Date date)
    {
        return releaseDateFormat.format(date);
    }

    public void xmlToArrayList(String fileLocation) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(fileLocation));

            document.getDocumentElement().normalize();

            NodeList gameInfoList = document.getElementsByTagName("game");

            Games.clear();

            for(int i = 0; i < gameInfoList.getLength(); i++)
            {
                Node game = gameInfoList.item(i);
                String name = null;
                String genre = null;
                int PEGI = 0;
                int price = 0;
                String releaseDate = null;

                if(game.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element gameElement = (Element) game;
                    name = gameElement.getAttribute("name");

                    NodeList gameDetails = game.getChildNodes();
                    for(int j = 0; j < gameDetails.getLength(); j++)
                    {
                        Node detail = gameDetails.item(j);
                        if(detail.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element detailElement = (Element) detail;
                            switch (detailElement.getTagName())
                            {
                                case "genre":
                                    genre = detailElement.getAttribute("value");
                                    break;
                                case "pegi":
                                    PEGI = Integer.parseInt(detailElement.getAttribute("value"));
                                    break;
                                case "price":
                                    price = Integer.parseInt(detailElement.getAttribute("value"));
                                    break;
                                case "releaseDate":
                                    releaseDate = detailElement.getAttribute("value");
                                    break;
                            }
                        }
                    }
                }

                if (name != null && genre != null && PEGI != 0 && price != 0 && releaseDate != null)
                {
                    Game newGame = new Game(name, genre, PEGI, price, releaseDate);
                    Games.add(newGame);
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException | ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void quickSortData(){
        if (selectedDataStructure == DataStructures.None){
            System.out.print("No Data Structure Selected");
        } else if (selectedDataStructure == DataStructures.LinkedList){
            QuickSort.quickSort(LinkedListGame, 0, (Games.size() - 1));
            System.out.println("The games have been sorted using Quicksort!");
        } /*else if (selectedDataStructure == DataStructures.HashMap){
            QuickSort.quickSort(HashMapGame, 0, (Games.size() - 1));
            System.out.println("The games have been sorted using Quicksort!");
        } else if (selectedDataStructure == DataStructures.BinaryTree){
            QuickSort.quickSort(BinaryTreeGame, 0, (Games.size() - 1));
            System.out.println("The games have been sorted using Quicksort!");
        }*/
    }

    public void bubbleSortData(){
        if (selectedDataStructure == DataStructures.None){
            System.out.print("No Data Structure Selected");
        } else if (selectedDataStructure == DataStructures.LinkedList){
            BubbleSort.bubbleSort(LinkedListGame);
            System.out.println("The games have been sorted using Bubblesort!");
        }
    }

    public void mergeSortData(){
        if (selectedDataStructure == DataStructures.None){
            System.out.print("No Data Structure Selected");
        } else if (selectedDataStructure == DataStructures.LinkedList){
            MergeSort.mergeSort(LinkedListGame, 0, (LinkedListGame.size() - 1));
            System.out.println("The games have been sorted using Mergesort!");
        }
    }

    public void heapSortData() {
        if (selectedDataStructure == DataStructures.None){
            System.out.print("No Data Structure Selected");
        } else if (selectedDataStructure == DataStructures.LinkedList){
            HeapSort.heapSort(LinkedListGame);
            System.out.println("The games have been sorted using Heapsort!");
        }
    }

    public ArrayList<Game> getGames() {
        return Games;
    }

    public SimpleDateFormat getReleaseDateFormat() {
        return releaseDateFormat;
    }

    public void useLinkedList(){
        LinkedListGame = new DataStructure.LinkedList<>();
        for(Game game: Games){
            LinkedListGame.add(game);
        }
        selectedDataStructure = DataStructures.LinkedList;
    }

    /*public void useHashMap(){
        HashMapGame = new DataStructure.LinkedList<>();
        for(Game game: Games){
            HashMapGame.add(game);
        }
        selectedDataStructure = DataStructures.HashMap;
    }*/

    /*public void useBinaryTree(){
        BinaryTreeGame = new DataStructure.BinaryTree<>();
        for(Game game: Games){
            BinaryTreeGame.add(game);
        }
        selectedDataStructure = DataStructures.BinaryTree;
    }*/

    public void refreshListGames(){
        if(selectedDataStructure == DataStructures.LinkedList){
            useLinkedList();
        }
        /*else if(selectedDataStructure == DataStructures.HashMap){
            useHashMap();
        }else if(selectedDataStructure == DataStructures.BinaryTree){
            useBinaryTree();
        }*/
    }

    public DataStructureOperations<Game> getLinkedListGame() {
        return LinkedListGame;
    }

    public DataStructures getSelectedDataStructure() {
        return selectedDataStructure;
    }
}
