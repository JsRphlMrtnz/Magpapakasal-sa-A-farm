import java.util.Random;

/**
 * This class contains the necessary attributes of the player.
 * It contains the player's name, money, and the player's inventory.
 * It also contains the necessary actions for each tool as well as harvesting.
 */
public class Player {
    private double xp;             // The player's experience points
    private double objectCoins;    // The player's money
    private FarmerType type;       // The player's farmer type
    private String feedbackString; // The feedback string that will be displayed on the GUI

    /**
     * This constructor assigns the name and initializes each attribute.
     * @param name The player's name
     */
    public Player(FarmerType type) {
        this.xp = 0;
        this.objectCoins = 100;
        this.type = type;
    }

 /**
  * This method helps change the certain farmer type of the player by checking if the player 
  * has reached a certain level and has enough objectCoins to afford it. 
  *
  * @param newType Is new type of farmer that the player wants to change to.
  * @return true if the player has met the requirements for the next type
  */
    public boolean updateFarmerType(FarmerType newType) {
        if (newType.getMinLevel() <= this.getLevel() && this.objectCoins >= newType.getRegFee() && newType.getMinLevel() - this.type.getMinLevel() == 5) {
            this.type = newType;
            this.objectCoins -= newType.getRegFee();
            feedbackString = "Successfully changed to " + type.getType();
            return true;
        }
        return false;
    }

/**
 * This method returns a boolean value to determine if a crop has been successfully plants onto a tile.
 * For a crop to be planted, the tile is plowed, doesn't already have a seed, and the player has
 * enough coins. 
 * 
 * @param seed The seed that that the player wants to plant onto the tile.
 * @param tile The tile that the player is trying to plant a crop on.
 * @return true if a crop has been successfully planted.
 */
    public boolean plant(Seed seed, Tile tile) {
        //  Checks if the tile has a seed, plowed, or if the player dosen't have enough coins.Then it will return false immediately.
        if (tile.getHasSeed() || tile.getPlowed() == false || this.objectCoins < seed.getCost()) {
            return false;
        }
        
        this.objectCoins -= seed.getCost();
        tile.setSeed(seed);
        feedbackString = "Successfully planted the " + seed.getName() + " seed";
        return true;
    }

/**
 * This method returns a boolean value whether a tile has been successfully plowed
 * For it to return a true value, the tile must not be plowed so it is not required to check if
 * there is a crop on the tile since the tile will be already plowed. Otherwise, it will return a false value.
 * If plowed correctly, the tile will be updated to plowed, objectCoins of the player 
 * is deducted by the cost of using the certain tool, and the player receives a certain amount of xp.
 * 
 * @param tool The tool that the player is using
 * @param tile The tile that the player is trying to plow
 * @return true if it was successfully plowed.
 */
    public boolean plow(Tools tool, Tile tile) {
        if (!tile.getPlowed() && !tile.getHasRock()) {
            tile.updatePlow();
            xp += tool.getXp();
            this.objectCoins -= tool.getCost();
            feedbackString = "Successfully plowed the tile";
            return true;
        }
        return false;
    }

/**
 * This method returns a booleran value whether a tile has been successfully watered.
 * The tile can only be successfully watered if the tile has a seed. Otherwise, it will return false.
 * If watered correctly, it will update the amount of times the tile was watered, objectCoins of the player 
 * is deducted by the cost of using the certain tool, the player receives a certain amount of xp.
 * 
 * @param tool The tool that the player is using to water the tile
 * @param tile The tile that the player is trying to water
 * @return true if the tile was successfully watered.
 */
    public boolean water(Tools tool, Tile tile) {
        if (tile.getHasSeed() && tile.getIsWithered() == false) {
            tile.updateWater();
            xp += tool.getXp();
            this.objectCoins -= tool.getCost();
            feedbackString = "Successfully watered the " + tile.getSeed().getName();
            return true;
        }
        return false;
    }

/**
 * This method returns a boolean value whether a tile has been successfully fertilized.
 * The tile can only be successfully fertilized if the player has enough objectCoins and the tile has no seed. 
 * If fertilized correctly, it will update the amount of times the tile was fertilized, objectCoins of the player 
 * is deducted by the cost of using the certain tool, the player receives a certain amount of xp, and the method returns 
 * a true value.
 * 
 * @param tool The tool that is being used to fertilize the tile.
 * @param tile The tile that the player is trying to fertilize.
 * @return true if the tile was successfully fertilized.
 */
    public boolean fertilize(Tools tool, Tile tile) {
        if (this.objectCoins >= tool.getCost() && tile.getHasSeed() && !tile.getIsWithered()) {
            tile.updateFert();
            xp += tool.getXp();
            this.objectCoins -= tool.getCost();
            feedbackString = "Successfully fertilized the " + tile.getSeed().getName();
            return true;
        }
        return false;
    }
    
    /**
     * This method returns a boolean value whether a tile has been successfully mined.
     * The tile can only be successfully mined if the player has enough objectCoins and the tile has a rock.
     * If mined correctly, it will update the tile to not have a rock, 
     * subtract the objectCoins of the player by the cost of using the certain tool,
     * the player receives a certain amount of xp, and the method returns a true value.
     * @param tool the tool that the player is using
     * @param tile The tile that the player is trying to mine
     * @return true if the tile was successfully mined.
     */
    public boolean mine(Tools tool, Tile tile) {
        if (this.objectCoins >= tool.getCost() && tile.getHasRock()) {
            tile.setRock(false);
            xp += tool.getXp();
            this.objectCoins -= tool.getCost();
            feedbackString = "Successfully mined the rock";
            return true;
        }
        return false;
    }
/**
 * This method returns a boolean value whether a tile has been successfully dug
 * by having enough obejectCoins. If the tile was dug up, objectCoins of the player 
 * is deducted by the cost of using the tool, the player receives a certain amount of xp,
 * the tile values are set to null, and the method returns a true value. Otherwise it will return a false value.
 * 
 * @param tool the tool that the player is using
 * @param tile a Tile object
 * @return true if the tile was successfully dug.
 */
    public boolean dig (Tools tool, Tile tile) {
        if (this.objectCoins < tool.getCost() || tile.getHasRock())
            return false;
        if (tile.getPlowed()) {
            tile.updatePlow();
            if (tile.getHasSeed())
                tile.reset();
            xp += tool.getXp();
            feedbackString = "Successfully dug up the tile.";
        }
        this.objectCoins -= tool.getCost();
        return true;
    }

    /**
     * This method returns a boolean value whether a tile has been successfully harvested.
     * If the tile was successfully harvested, the method will do computations to determine the amount of coins
     * and xp that the player will receive. The tile will then reset and the method will return a true value.
     * Otherwise, it will return a false value.
     * @param tile The tile that is being harvested.
     * @return A boolean value whether a tile has been successfully harvested.
     */
    public boolean harvest(Tile tile) {
        if (tile.getTime() == 0 && tile.getHasSeed() && !tile.getIsWithered()) {
            int productsProduced = new Random().nextInt(tile.getSeed().getMaxProduce() - tile.getSeed().getMinProduce() + 1) + tile.getSeed().getMinProduce();
            int harvestTotal = productsProduced * (tile.getSeed().getSellingPrice() + this.type.getBonusEarning());
            
            int waterCount = tile.getWater() + this.type.getBonusWaterLimit();
            if (waterCount > tile.getSeed().getMaxWater())
                waterCount = tile.getSeed().getMaxWater();
            double waterBonus = harvestTotal * 0.2 * (waterCount - 1);
            
            int fertCount = tile.getFert() + this.type.getBonusFertilizerLimit();
            if (fertCount > tile.getSeed().getMaxFertilizer())
                fertCount = tile.getSeed().getMaxFertilizer();
            double fertBonus = harvestTotal * 0.5 * (fertCount - 1);
            
            double total = harvestTotal + waterBonus + fertBonus;
            if (tile.getSeed().getType() == "Flower")
                total *= 1.1;
            this.objectCoins += total;

            double xpGain = tile.getSeed().getXp() * productsProduced;
            this.xp += xpGain;

            feedbackString = "Harvested " + productsProduced + " " + tile.getSeed().getName() + " for " + total + " ObjectCoins.";
            feedbackString += " Gained " + xpGain + " xp.";
            return true;
        }
        return false;
    }

/**
 *  This method computes and returns the certain level that the player has reached.
 * 
 * @return The level of the player.
 */
    public int getLevel() {
        return (int) Math.floor(this.xp / 100);
    }

/**
 * This method returns the amount of objectCoins that the player has.
 * 
 * @return The objectCoins variable
 */
    public double getCoins() {
        return this.objectCoins;
    }

  /**
   * This method returns the type of farmer the player is in.(farmer, registered, distinguished, legendary)
   * 
   * @return The type of farmer the player is.
   */
    public String getType() {
        return this.type.getType();
    }

   /**
    * This method returns the amount of xp that the player has.
    *
    * @return current xp of player
    */
    public double getXp() {
        return this.xp;
    }

   /**
    * This method returns the feedback string that is being used to display the feedback to the player.
    * 
    * @return The feedback string.
    */
    public String getFeedbackString() {
        return this.feedbackString;
    }
}