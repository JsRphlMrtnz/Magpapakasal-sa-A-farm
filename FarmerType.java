/**
 * This class is used to store the data of the different types of farmers
 * which are farmer (default), registered farmer, distinguished farmer, and
 * legendary farmer. These different types of farmers have different values for
 * their bonuses, minimum level, and registration fees. 
 */
public class FarmerType {
   private int bonusEarning;         // The bonus earning of the farmer per harvest
   private int costReduction;        // The cost reduction of the farmer per seed
   private int bonusWaterLimit;      // The bonus water limit of the farmer per seed
   private int bonusFertilizerLimit; // The bonus fertilizer limit of the farmer per seed
   private int regFee;               // registration fee of the type of farmer
   private int minLevel;             // minimum level to register
   private String type;              // type of farmer (farmer, registered farmer, distinguished farmer, legendary farmer)

   public FarmerType(int bonusEarning, int costReduction, int bonusWaterLimit, int bonusFertilizerLimit, int regFee, int minLevel, String type) {
      this.bonusEarning = bonusEarning;
      this.costReduction = costReduction;
      this.bonusWaterLimit = bonusWaterLimit;
      this.bonusFertilizerLimit = bonusFertilizerLimit;
      this.regFee = regFee;
      this.minLevel = minLevel;
      this.type = type;
   }
   

/**
 * This function returns the Bonus Earnings per Produce of the farmer type.
 * 
 * @return The bonus earnings per produce.
 */
   public int getBonusEarning() {
      return this.bonusEarning;
   }


/**
 * This function returns the seed cost reduction of the farmer type.
 * 
 * @return The amount reduced per seed.
 */
   public int getCostReduction() {
      return this.costReduction;
   }

/**
 * This function returns the Water Bonus Limit Increase of the farmer type.
 * 
 * @return The water bonus limit increase.
 */
   public int getBonusWaterLimit() {
      return this.bonusWaterLimit;
   }

 /**
  * This function returns the Fertilizer Bonus Limit Increase of the farmer type.
  * 
  * @return The fertilizer bonus limit increase.
  */
   public int getBonusFertilizerLimit() {
      return this.bonusFertilizerLimit;
   }


/**
 * This function returns the cost it takes to register as this farmer type.
 * 
 * @return The cost of registration.
 */
   public int getRegFee() {
      return this.regFee;
   }

/**
 * This function returns the minimum level it takes to register as this farmer type.
 * 
 * @return The minimum level.
 */
   public int getMinLevel() {
      return this.minLevel;
   }

/**
 * This function returns the name of the farmer type in String.
 * 
 * @return The name of the farmer type
 */
   public String getType() {
      return this.type;
   }

   


}
