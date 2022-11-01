public  class Seed{
   private int cost;
   private int harvestTime;
   private int minWater;
   private int maxWater;
   private int minFertilizer;
   private int maxFertilizer;
   private int sellingPrice;
   private int minProduce;
   private int maxProduce;
   private double xp;
   private String name;
   private String type;

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

   public int getCost() {
      return this.cost;
   }

   public int getHarvestTime() {
      return this.harvestTime;
   }

   public int getMinWater() {
      return this.minWater;
   }

   public int getMaxWater() {
      return this.maxWater;
   }

   public int getMinFertilizer() {
      return this.minFertilizer;
   }

   public int getMaxFertilizer() {
      return this.maxFertilizer;
   }

   public int getSellingPrice() {
      return this.sellingPrice;
   }

   public int getMinProduce() {
      return this.minProduce;
   }

   public int getMaxProduce() {
      return this.maxProduce;
   }

   public double getXp() {
      return this.xp;
   }

   public String getName() {
      return this.name;
   }

   public String getType() {
      return this.type;
   }
}