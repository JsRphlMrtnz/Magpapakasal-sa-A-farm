import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

import javax.swing.JButton;


/**
 * 
 * Magpapakasal-sa-A-farm is farming simulation game that runs on Java.
 * 
 * @author Don Laude A. Aspecto
 * @author Jose Raphael E. Martinez
 * @version 1.0
 */
public class MyFarm {
    private int day;                     // amount of days that have passed by in the game
    private Player player;               // the player of the game
    private Tile[] tiles = new Tile[50]; // 50 tiles
    private Tools[] tool = new Tools[5]; // Plow, Watering Can, Fertilizer, Shovel, Pickaxe
    private Seed[] seeds = new Seed[8];  // Turnip, Carrot, Potato, Rose, Tulips, Sunflower, Mango, Apple

    /**
     * This constructor initializes all the attributes of the MyFarm class.
     * @param name is the name of the farmer to be used on the Player class constructor.
     */
    public MyFarm(String name) {
        this.player = new Player(name);
        this.day = 1;

        for (int i = 0; i < tiles.length; i++) { // initializes all the tiles
            tiles[i] = new Tile();
        }
        this.tool[0] = new Tools(0, 0.5, "Plow");         // initializes the plow tool
        this.tool[1] = new Tools(0, 0.5, "Watering Can"); // initializes the watering can tool
        this.tool[2] = new Tools(10, 4, "Fertilizer");    // initializes the fertilizer tool
        this.tool[3] = new Tools(7, 2, "Shovel");         // initializes the shovel tool
        this.tool[4] = new Tools(50, 15, "Pickaxe");      // initializes the pickaxe tool
        
        this.seeds[0] = new Seed(5, 2, 1, 2, 0, 1, 6, 1, 2, 5, "Turnip", "Root Crop"); // instantiates the turnip seed
        this.seeds[1] = new Seed(10, 3, 1, 2, 0, 1, 9, 1, 2, 7.5, "Carrot", "Root Crop"); // instantiates the carrot seed
        this.seeds[2] = new Seed(20, 5, 3, 4, 1, 2, 3, 1, 10, 12.5, "Potato", "Root Crop"); // instantiates the potato seed
        this.seeds[3] = new Seed(5, 2, 2, 3, 0, 1, 5, 1, 1, 2.5, "Rose", "Flower"); // instantiates the rose seed
        this.seeds[4] = new Seed(10, 2, 2, 3, 0, 1, 9, 1, 1, 5, "Tulips", "Flower"); // instantiates the tulips seed
        this.seeds[5] = new Seed(20, 3, 2, 3, 1, 2, 19, 1, 1, 7.5, "Sunflower", "Flower"); // instantiates the sunflower seed
        this.seeds[6] = new Seed(100, 10, 7, 7, 4, 4, 8, 5, 15, 25, "Mango", "Fruit tree"); // instantiates the mango seed
        this.seeds[7] = new Seed(200, 10, 7, 7, 5, 5, 5, 10, 15, 25, "Apple", "Fruit tree"); // instantiates the apple seed
    }

    // region unimplemented methods
// /**
//  * This method increments the day and updates the harvest time of the tile
//  */
//     public void endDay() {
//         this.day++;
//         this.tile.updateTime();
//         if (this.tile.getHasSeed())
//             this.tile.updateWithered();
//         System.out.println("\n\n");
//     }

// /**
//  * This method determines if it is gameover for the player. The game is over if there are no
//  * active growing crops and the player cannot buy a Turnip seed or if all tiles are withered.
//  * 
//  * @return This returns a boolean value to determine if it is gameover.
//  */
//     public boolean gameOver() {
//         if(this.tile.getHasSeed())
//             return (this.tile.getIsWithered());
//         else 
//             return (this.player.getCoins() < 5);
//     }
// endregion

    // region getters and setters
    public int getDay() {
        return this.day;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public Tools[] getTool() {
        return tool;
    }

    public Seed[] getSeeds() {
        return seeds;
    }
    public static void main(String[] args) {
        MyFarm farm = new MyFarm("Farmer");
    }
}
