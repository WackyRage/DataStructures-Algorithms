package Algorithms;

import DataStructure.DataStructureOperations;
import Game.Game;

import java.util.Objects;

public class LinearSearch {
    private DataStructureOperations<Game> Games;
    private String searchTerm;

    public LinearSearch(DataStructureOperations<Game> Games, String searchTerm){
        this.Games = Games;
        this.searchTerm = searchTerm;
    }

    public int linearSearch(){
        int n = Games.size();
        System.out.println(Games.size());
        //move through array sequentially
        for(int i = 0; i < n; i++){
            if(Objects.equals(Games.get(i).getName(), searchTerm)){
                System.out.println("we found it!");
                return i;
            }
            System.out.println(Games.get(i).getName());
            System.out.println(searchTerm);
        }
        return -1;
    }
}
