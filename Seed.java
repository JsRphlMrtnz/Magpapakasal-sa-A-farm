import java.util.Properties;

public  class Seed{
   int cost, harvestTime, minWater, maxWater, minFertilizer, maxFertilizer, sellingPrice, minProduce, maxProduce;
   double xp;
   String name, type;

   Seed(int cost, int harvestTime, int minWater,  int maxWater, int minFertilizer, int maxFertilizer, int sellingPrice, int minProduce, int maxProduce, double xp, string name, string type)
   {
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

   public int getCost() 
   {
      return this.cost;
   }

   public int getHarvestTime() 
   {
      return this.harvestTime;
   }

   public int getMinWater() 
   {
      return this.minWater;
   }

   public int getMaxWater() 
   {
      return this.maxWater;
   }

   public int getMinFertilizer() 
   {
      return this.minFertilizer;
   }

   public int getMaxFertilizer() 
   {
      return this.maxFertilizer;
   }

   public int getSellingPrice() 
   {
      return this.sellingPrice;
   }

   public int getMinProduce() 
   {
      return this.minProduce;
   }

   public int getMaxProduce() 
   {
      return this.maxProduce;
   }

   public double getXp() 
   {
      return this.xp;
   }

   public String getName() 
   {
      return this.name;
   }

   public String getType() 
   {
      return this.type;
   }
}