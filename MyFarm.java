import java.io.File;
import java.util.Scanner;

/**
 * 
 * Magpapakasal-sa-A-farm is farming simulation game that runs on Java.
 * 
 * @author Don Laude A. Aspecto
 * @author Jose Raphael E. Martinez
 * @version 2.0
 */
public class MyFarm {
    private int day;                     // amount of days that have passed by in the game
    private Player player;               // the player of the game
    private Tile[] tiles = new Tile[50]; // 50 tiles
    private Tools[] tool = new Tools[5]; // Plow, Watering Can, Fertilizer, Shovel, Pickaxe
    private Seed[] seeds = new Seed[8];  // Turnip, Carrot, Potato, Rose, Tulips, Sunflower, Mango, Apple
    private FarmerType[] farmerTypes = new FarmerType[4]; // Regular Farmer, Registered Farmer, Distinguished Farmer, Legendary Farmer

    /**
     * This constructor initializes all the attributes of the MyFarm class.
     * @param name is the name of the farmer to be used on the Player class constructor.
     */
    public MyFarm() {

        for (int i = 0; i < tiles.length; i++) { // initializes all the tiles
            tiles[i] = new Tile();
        }


        try { // initializes the rocks
            Scanner sc = new Scanner(new File("rock.txt"));
            while (sc.hasNext()) {
                int rock = sc.nextInt();
                tiles[rock].setRock(true);
            }
            sc.close();
        } catch (Exception e) {
        }

        this.tool[0] = new Tools(0, 0.5, "Plow");         // initializes the plow tool
        this.tool[1] = new Tools(0, 0.5, "Watering Can"); // initializes the watering can tool
        this.tool[2] = new Tools(10, 4, "Fertilizer");    // initializes the fertilizer tool
        this.tool[3] = new Tools(50, 15, "Pickaxe");      // initializes the pickaxe tool
        this.tool[4] = new Tools(7, 2, "Shovel");         // initializes the shovel tool
        
        this.seeds[0] = new Seed(5, 2, 1, 2, 0, 1, 6, 1, 2, 5, "Turnip", "Root Crop"); // instantiates the turnip seed
        this.seeds[1] = new Seed(10, 3, 1, 2, 0, 1, 9, 1, 2, 7.5, "Carrot", "Root Crop"); // instantiates the carrot seed
        this.seeds[2] = new Seed(20, 5, 3, 4, 1, 2, 3, 1, 10, 12.5, "Potato", "Root Crop"); // instantiates the potato seed
        this.seeds[3] = new Seed(5, 2, 2, 3, 0, 1, 5, 1, 1, 2.5, "Rose", "Flower"); // instantiates the rose seed
        this.seeds[4] = new Seed(10, 2, 2, 3, 0, 1, 9, 1, 1, 5, "Tulips", "Flower"); // instantiates the tulips seed
        this.seeds[5] = new Seed(20, 3, 2, 3, 1, 2, 19, 1, 1, 7.5, "Sunflower", "Flower"); // instantiates the sunflower seed
        this.seeds[6] = new Seed(100, 10, 7, 7, 4, 4, 8, 5, 15, 25, "Mango", "Fruit tree"); // instantiates the mango seed
        this.seeds[7] = new Seed(200, 10, 7, 7, 5, 5, 5, 10, 15, 25, "Apple", "Fruit tree"); // instantiates the apple seed

        this.farmerTypes[0] = new FarmerType(0, 0, 0, 0, 0, 0, "Farmer"); // instantiates the farmer type
        this.farmerTypes[1] = new FarmerType(1, 1, 0, 0, 200, 5, "Registered Farmer"); // instantiates the registered farmer type
        this.farmerTypes[2] = new FarmerType(2, 2, 1, 0, 300, 10, "Distinguished Farmer"); // instantiates the distinguished farmer type
        this.farmerTypes[3] = new FarmerType(4, 3, 2, 1, 400, 15, "Legendary Farmer"); // instantiates the legendary farmer type

        this.player = new Player(farmerTypes[0]);
        this.day = 1;
    }

/**
 * This method increments the day and updates the harvest time of the tile
 */
    public void endDay() {
        this.day++;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].getHasSeed()) {
                tiles[i].updateTime();
                tiles[i].updateWithered();
            }
        }
    }

/**
 * This method determines if it is gameover for the player. The game is over if there are no
 * active growing crops and the player cannot buy a Turnip seed or if all tiles are withered.
 * 
 * @return This returns a boolean value to determine if it is gameover.
 */
    public boolean gameOver() {
        int witherCount = 0;
        boolean allTilesWithered = true;
        boolean noActiveCrops = true;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].getHasSeed() && !tiles[i].getIsWithered()) {
                noActiveCrops = false;
            }
            if (tiles[i].getIsWithered())
                    witherCount++;
        }
        if (witherCount == tiles.length)
            allTilesWithered = true;
        else
            allTilesWithered = false;
        return allTilesWithered || (noActiveCrops && this.player.getCoins() < 5);
    }

    public boolean availableSurroundings(int tile) {
        
        try {
            int min = tile - 6;
            int max = tile - 3;
            int prev = 0;
            for (int i = min; i < max; i++) {
                if (i != min)
                    prev = (i - 1) % 5;
                if (tiles[i].getHasSeed() || tiles[i].getHasRock() || prev > i % 5)
                    return false;
            }
            if (tiles[tile - 1].getHasSeed() ||  tiles[tile - 1].getHasRock() || tiles[tile + 1].getHasSeed() ||  tiles[tile + 1].getHasRock())
                return false;
            min = tile + 4;
            max = tile + 7;
            prev = 0;
            for (int i = min; i < max; i++) {
                if (i != min)
                    prev = (i - 1) % 5;
                if (tiles[i].getHasSeed() || tiles[i].getHasRock() || prev > i % 5)
                    return false;
            }
        }
        catch (Exception e) {
            return false;
        }
        
        return true;
    }

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

    public FarmerType[] getFarmerTypes() {
        return farmerTypes;
    }
}
