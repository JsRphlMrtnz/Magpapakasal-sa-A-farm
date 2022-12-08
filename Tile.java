/**
 * This class contains conditions of a certain tile in the farm. It helps determine the 
 * conditions of the certain crop (if the crop is watered, fertilized enough, harvested in the right time).
 */
public class Tile {
    private Seed seed;          // The seed that is planted on the tile
    private boolean isPlowed;   // If the tile is plowed
    private int water;          // The amount of times the tile was watered
    private int fertilizer;     // The amount of times the tile was fertilized
    private int harvestTime;    // The amount of days until the crop is ready to harvest
    private boolean hasSeed;    // If the tile has a seed planted on it
    private boolean isWithered; // If the crop is withered
    private boolean hasRock;    // If the tile has a rock on it

    /**
     * This constructor initializes all the attributes to empty values.
     */
    public Tile() {
        reset();
    }

/**
 * This method resets the seed, isPlowed, water, fertilizer, harvestTime, and hasSeed variables to
 * their default values
 */
    public void reset() {
        this.seed = null;
        this.isPlowed = false;
        this.water = 0;
        this.fertilizer = 0;
        this.harvestTime = 0;
        this.hasSeed = false;
        this.isWithered = false;
        this.hasRock = false;
    }

/**
 * This method sets the seed that is being planted on the tile.
 * 
 * @param seed The seed that is planted in the plot.
 */
    public void setSeed(Seed seed) {
        this.seed = seed;
        this.hasSeed = true;
        this.water = 0;
        this.fertilizer = 0;
        this.harvestTime = seed.getHarvestTime();
    }

/**
 * The method acts as a toggle for the isPlowed attribute.
 * If the tile is plowed, it will be set to false and vice-versa.
 */
    public void updatePlow() {
        if (this.isPlowed) {
            this.isPlowed = false;
        } else {
            this.isPlowed = true;
        }
    }

 /**
  * This method increments the amount of times the tile was watered.
  */
    public void updateWater() {
        this.water++;
    }

/**
 * This method increments the amount of times the tile was fertilized.
 */
    public void updateFert() {
        this.fertilizer++;
    }

/**
 * This method decrements the amount of days until the crop is ready to harvest.
 */
    public void updateTime() {
        this.harvestTime--;
    }

/**
 * This method updates if the plant currently on the tile is withered.
 * A plant is withered if it has not been watered and fertilized enough on the day of harvest
 * or if the day of harvest has passed.
 * 
 */
    public void updateWithered() {
        this.isWithered = ((this.water < this.seed.getMinWater() || this.fertilizer < this.seed.getMinFertilizer()) && this.harvestTime == 0 || this.harvestTime < 0);
    }

/**
 * This method gets the value of isWithered and returns it
 * 
 * @return The current withered status of the plant.
 */
    public boolean getIsWithered() {
        return this.isWithered;
}

/**
 * This method gets the value of isPlowed and returns it.
 * 
 * @return The value of isPlowed.
 */
    public boolean getPlowed() {
        return this.isPlowed;
    }

  /**
   * This method gets the value of hasSeed and returns it.
   * 
   * @return The value of the hasSeed.
   */
    public boolean getHasSeed() {
        return this.hasSeed;
    }

/**
 * This method gets the amount of days left until the plant is ready to harvest.
 * 
 * @return Days left until harvest.
 */
    public int getTime() {
        return this.harvestTime;
    }

/**
 * This method returns the seed that has been planted onto the tile.
 * 
 * @return The current planted seed.
 */
    public Seed getSeed() {
        return this.seed;
    }

/**
 * This method returns the amount of times that the tile has been watered.
 * 
 * @return The amount of times that the tile has been watered.
 */
    public int getWater() {
        return this.water;
    }

/**
 * This method returns the amount of times that the tile has been fertilized.
 * 
 * @return The amount of times that the tile has been fertilized.
 */
    public int getFert() {
        return this.fertilizer;
    }

/**
 * This method returns the value of hasRock.
 * 
 * @return The value of hasRock.
 */
    public boolean getHasRock() {
        return this.hasRock;
    }

/**
 * This method sets the value of hasRock to true.
 * 
 * @param hasRock The value of hasRock.
 */
    public void setRock() {
        this.hasRock = true;
    }
}
