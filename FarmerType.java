public class FarmerType {
   private int bonusProduce;
   private int costReduction;
   private int bonusWaterLimit;
   private int bonusFertilizerLimit;
   private int regFee;
   private int minLevel;
   private String type;

   public FarmerType(int bonusProduce, int costReduction, int bonusWaterLimit, int bonusFertilizerLimit, int regFee, int minLevel, String type) {
      this.bonusProduce = bonusProduce;
      this.costReduction = costReduction;
      this.bonusWaterLimit = bonusWaterLimit;
      this.bonusFertilizerLimit = bonusFertilizerLimit;
      this.regFee = regFee;
      this.minLevel = minLevel;
      this.type = type;
   }
   

   public int getBonusProduce() {
      return this.bonusProduce;
   }

   public int getCostReduction() {
      return this.costReduction;
   }

   public int getBonusWaterLimit() {
      return this.bonusWaterLimit;
   }

   public int getBonusFertilizerLimit() {
      return this.bonusFertilizerLimit;
   }

   public int getRegFee() {
      return this.regFee;
   }

   public int getMinLevel() {
      return this.minLevel;
   }

   public String getType() {
      return this.type;
   }

   


}
