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

    public Application(){
        xmlToArrayList("src/Games.xml");
        for (Game objGame : Games)
        {
            System.out.println(objGame.getName() + "\n" + objGame.getGenre() + "\n" + objGame.getPEGI() + "\n" + objGame.getPrice() + "\n" + objGame.getReleaseDate() + "\n");
        }

        //frontend start
        GUI gui = new GUI(Games);
    }

    private String parseDateToString(Date date)
    {
        return releaseDateFormat.format(date);
    }

    private void xmlToArrayList(String fileLocation)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = (Document) builder.parse(new File(fileLocation));

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

    private void quickSortData(GUI gui){
        QuickSort.quickSort(Games, 0, (Games.size() - 1));
        System.out.println("The games have been sorted using Quicksort!");
        gui.refreshData(Games);
    }
}
