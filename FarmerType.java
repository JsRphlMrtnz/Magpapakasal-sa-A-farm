
/**
 * This FarmerType class is used to determine and store the data of the different types of farmers
 * which are farmer (default), registered farmer, distinguished farmer, and
 * legendary farmer. These different types of farmers have different values for
 * their bonuses, minimum level, and registration fees. 
 */
public class FarmerType {
   private int bonusEarning;
   private int costReduction;
   private int bonusWaterLimit;
   private int bonusFertilizerLimit;
   private int regFee; // registration limit
   private int minLevel; // minimum level to register
   private String type; // type of farmer (farmer, registered farmer, distinguished farmer, legendary farmer)

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
 * This function returns the Bonus Earnings per Produce of the certain farmer type.
 * 
 * @return The bonusEarning variable is being returned.
 */
   public int getBonusEarning() {
      return this.bonusEarning;
   }


/**
 * This function returns the Seed Cost Reduction of the certain farmer type.
 * 
 * @return The costReduction variable is being returned.
 */
   public int getCostReduction() {
      return this.costReduction;
   }

/**
 * This function returns the Water Bonus Limit Increase of the certain farmer type.
 * 
 * @return The bonusWaterLimit variable is being returned.
 */
   public int getBonusWaterLimit() {
      return this.bonusWaterLimit;
   }

 /**
  * This function returns the Fertilizer Bonus Limit Increase of the certain farmer type.
  * 
  * @return The bonusFertilizerLimit variable is being returned.
  */
   public int getBonusFertilizerLimit() {
      return this.bonusFertilizerLimit;
   }


/**
 * This function returns the cost it takes to register as a certain farmer type.
 * 
 * @return The regFee variable is being returned.
 */
   public int getRegFee() {
      return this.regFee;
   }

/**
 * This function returns the minimum level it takes to register as a certain farmer type.
 * 
 * @return The minLevel variable is being returned.
 */
   public int getMinLevel() {
      return this.minLevel;
   }

/**
 * This function returns the label of the certain type of farmer type.
 * 
 * @return The type variable is being returned.
 */
   public String getType() {
      return this.type;
   }

   


}
