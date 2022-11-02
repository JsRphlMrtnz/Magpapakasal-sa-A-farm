/**
 * This class stores the all information of a seed. 
 * These seeds could be planted in a tile. The seeds 
 * that are going to be created are turnip, 
 * carrot, potato, rose, sunflower, mango, and apple.
 */
public  class Seed{
   private int cost;          // cost of the seed 
   private int harvestTime;   // harvest time of the seed 
   private int minWater;      // minimum water needed to grow the seed
   private int maxWater;      // bonus water limit
   private int minFertilizer; // minimum fertilizer needed to grow the seed
   private int maxFertilizer; // bonus fertilizer limit
   private int sellingPrice;  // selling price of the harvest
   private int minProduce;    // minimum produce per harvest
   private int maxProduce;    // maximum produce per harvest
   private double xp;         // xp the crop gives when harvested
   private String name;       // name of the seed
   private String type;       // type of the seed

   public Seed(int cost, int harvestTime, int minWater,  int maxWater, int minFertilizer, int maxFertilizer, int sellingPrice, int minProduce, int maxProduce, double xp, String name, String type) {
      this.cost = cost;
      this.harvestTime = harvestTime;
      this.minWater = minWater;
      this.maxWater = maxWater;
      this.minFertilizer = minFertilizer;
      this.maxFertilizer = maxFertilizer;
      this.sellingPrice = sellingPrice;
      this.minProduce = minProduce;
      this.maxProduce = maxProduce;
      this.xp = xp;
      this.name = name;
      this.type = type;
   }

/**
 * This function returns the cost of the seed.
 * 
 * @return The cost of the seed.
 */
   public int getCost() {
      return this.cost;
   }

/**
 * This function returns the time it takes to harvest the crop.
 * 
 * @return The time it takes to harvest.
 */
   public int getHarvestTime() {
      return this.harvestTime;
   }

/**
 * This function returns the minimum amount of water that the crop needs to survive.
 * 
 * @return The minimum amount of water needed.
 */
   public int getMinWater() {
      return this.minWater;
   }

/**
 * This function returns the bonus limit of water that the crop can receive.
 * 
 * @return The bonus limit of water.
 */
   public int getMaxWater() {
      return this.maxWater;
      
   }
/**
 * This function returns the minimum amount of fertilizer needed for the crop to grow.
 * 
 * @return The minimum amount of fertilizer needed.
 */
   public int getMinFertilizer() {
      return this.minFertilizer;
   }

/**
 * This function returns the bonus limit of fertilizer that the crop can receive.
 * 
 * @return The bonus limit of fertilizer.
 */
   public int getMaxFertilizer() {
      return this.maxFertilizer;
   }

/**
 * This function returns the selling price of the crop.
 * 
 * @return The sellingPrice variable is being returned.
 */
   public int getSellingPrice() {
      return this.sellingPrice;
   }

 /**
  * It returns the minimum amount of produce that can be produced by the crop.
  * 
  * @return The minimum amount of produce.
  */
   public int getMinProduce() {
      return this.minProduce;
   }

/**
 * This function returns the maximum amount of produce that can be produced by the crop.
 * 
 * @return The maxmimum amount of produce.
 */
   public int getMaxProduce() {
      return this.maxProduce;
   }

 /**
  * This function returns the xp gained from harvesting a single crop.
  * 
  * @return The xp of a single crop.
  */
   public double getXp() {
      return this.xp;
   }

/**
 * This function returns the name of the seed in String.
 * 
 * @return The name of the seed.
 */
   public String getName() {
      return this.name;
   }

/**
 * This function returns the type crop of the seed in String.
 * 
 * @return The type of the seed.
 */
   public String getType() {
      return this.type;
   }
}