import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Game {
    private String name;
    private String genre;
    private int PEGI;
    private int price;
    private Date releaseDate;
    private SimpleDateFormat releaseDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Game(String name, String genre, int PEGI, int price, String releaseDate) throws ParseException {
        this.name = name;
        this.genre = genre;
        this.PEGI = PEGI;
        this.price = price;
        this.releaseDate = releaseDateFormat.parse(releaseDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPEGI() {
        return PEGI;
    }

    public void setPEGI(int PEGI) {
        this.PEGI = PEGI;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
