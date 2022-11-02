/**
 * This class contains conditions of a certain tile in the farm. It helps determine the 
 * conditions of the certain crop (if the crop is watered, fertilized enough, harvested in the right time).
 */
public class Tile {
    private Seed seed;
    private boolean isPlowed;
    private int water;
    private int fertilizer;
    private int harvestTime;
    private boolean hasSeed;

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
    }

/**
 * This method accepts a seed and sets the seed variable onto the tile which then
 * sets the necessary variables to when a seed is planted onto a tile.
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
 * The method helps change the plow situation of a certain tile since there are
 * different ways in which a tile can be plowed and not plowed.
 * Overall the method checks if the field is plowed, then sets it to not plowed. Otherwise, it is set to plowed.
 */
    public void updatePlow() {
        if (this.isPlowed) {
            this.isPlowed = false;
        } else {
            this.isPlowed = true;
        }
    }

 /**
  * This method updates the water variable by adding one. This is going to be used
  * everytime the tile is watered by the player.
  */
    public void updateWater() {
        this.water++;
    }

/**
 * This method increases the fertilizer level by one. This is going to be used 
 * everytime the tile is fertilized by the player.
 */
    public void updateFert() {
        this.fertilizer++;
    }

/**
 * Decrements the harvestTime variable by 1 when a day passes by.
 */
    public void updateTime() {
        this.harvestTime--;
    }

/**
 * This method returns a boolean value that represents whether or not the field is plowed.
 * 
 * @return The boolean value of isPlowed.
 */
    public boolean getPlowed() {
        return this.isPlowed;
    }

  /**
   * This method returns a boolean value that indicates whether or not the tile has a seed.
   * 
   * @return The value of the variable hasSeed.
   */
    public boolean getHasSeed() {
        return this.hasSeed;
    }

/**
 * This method returns the harvest time of the crop when it is planted onto the tile.
 * 
 * @return The harvestTime variable is being returned.
 */
    public int getTime() {
        return this.harvestTime;
    }

/**
 * This method returns the seed that has been planted onto the tile.
 * 
 * @return The seed object.
 */
    public Seed getSeed() {
        return this.seed;
    }

/**
 * If the water or fertilizer is less than the minimum required, and the harvest time is 0 or less,
 * then the plant is withered. Otherwise, the plant is healthy.
 * 
 * @return A boolean value that represents whether or not the plant is withered.
 */
    public boolean isWithered() {
        if ((this.water < this.seed.getMinWater() || this.fertilizer < this.seed.getMinFertilizer()) && this.harvestTime == 0 || this.harvestTime < 0) {
            return true;
        }
        return false;
    }

/**
 * This method returns the amount of times that the tile has been watered.
 * 
 * @return The water variable is being returned.
 */
    public int getWater() {
        return this.water;
    }

/**
 * This method returns the amount of times that the tile has been fertilized.
 * 
 * @return The fertilizer variable.
 */
    public int getFert() {
        return this.fertilizer;
    }
}
