import DataStructure.DataStructureOperations;
import DataStructure.Node.Node;

public class LinearSearch {
    private DataStructureOperations<Game> Games;
    private String searchTerm;

    public LinearSearch(DataStructureOperations<Game> Games, String searchTerm){
        this.Games = Games;
        this.searchTerm = searchTerm;
    }

    public int linearSearch(){
        int n = Games.size();

        //move through array sequentially
        for(int i = 0; i < n; i++){
            if(Games.get(i).getValue().getName() == searchTerm){
                return i;
            }
        }
        return -1;
    }
}
