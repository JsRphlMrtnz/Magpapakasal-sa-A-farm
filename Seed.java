/**
 * It's a class that stores the all information of a certain crop seed. 
 * These crop seeds could be planted in the farm. The certain crop 
 * seeds that are going to be created through this class are turnip, 
 * carrot, potato, rose, sunflower, mango, and apple.
 */
public  class Seed{
   private int cost; // cost of the seed crop
   private int harvestTime; // harvest time of the seed crop
   private int minWater; // minimum water needed to grow the crop
   private int maxWater; // bonus water limit
   private int minFertilizer; // minimum fertilizer needed to grow the crop
   private int maxFertilizer; // bonus fertilizer limit
   private int sellingPrice; // selling price of the crop
   private int minProduce; // minimum produce per harvest
   private int maxProduce; //maximum produce per harvest
   private double xp; // xp the crop gives when harvested
   private String name; // name of the crop
   private String type; // type of the crop

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
 * This function returns the cost of the certain crop seed.
 * 
 * @return The cost variable is being returned.
 */
   public int getCost() {
      return this.cost;
   }

/**
 * This function returns the time it takes to harvest the crop.
 * 
 * @return The harvestTime variable is being returned.
 */
   public int getHarvestTime() {
      return this.harvestTime;
   }

/**
 * This function returns the minimum amount of water that the crop needs to survive.
 * 
 * @return The minWater variable is being returned.
 */
   public int getMinWater() {
      return this.minWater;
   }

/**
 * This function returns bonus limit of water that the crop can receive.
 * 
 * @return The maxWater variable is being returned.
 */
   public int getMaxWater() {
      return this.maxWater;
   }

/**
 * This function returns the minimum amount of fertilizer needed for the crop to grow.
 * 
 * @return The minFertilizer variable is being returned.
 */
   public int getMinFertilizer() {
      return this.minFertilizer;
   }

/**
 * This function returns the bonus limit of fertilizer that the crop can receive.
 * 
 * @return The maxFertilizer variable is being returned.
 */
   public int getMaxFertilizer() {
      return this.maxFertilizer;
   }

/**
 * This function returns the selling price of the certain crop.
 * 
 * @return The sellingPrice variable is being returned.
 */
   public int getSellingPrice() {
      return this.sellingPrice;
   }

 /**
  * It returns the minimum amount of produce that can be produced by the certain crop.
  * 
  * @return The minProduce variable is being returned.
  */
   public int getMinProduce() {
      return this.minProduce;
   }

/**
 * This function returns the maximum amount of produce that can be produced by certain crop.
 * 
 * @return The maxProduce variable is being returned.
 */
   public int getMaxProduce() {
      return this.maxProduce;
   }

 /**
  * This function returns the xp gained from harvesting the certain crop.
  * 
  * @return The xp variable is being returned.
  */
   public double getXp() {
      return this.xp;
   }

/**
 * This function returns the name of the crop.
 * 
 * @return The name variable is being returned.
 */
   public String getName() {
      return this.name;
   }

/**
 * This function returns the type crop of the certain seed.
 * 
 * @return The type variable is being returned.
 */
   public String getType() {
      return this.type;
   }
}