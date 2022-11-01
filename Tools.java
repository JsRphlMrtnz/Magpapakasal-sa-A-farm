public class Tools {
   int cost;
   double xp;
   String name;

   Tools(int cost, double xp, String name)
   {
      this.cost = cost;
      this.xp = xp;
      this.name = name;
   }

   public int getCost() {
      return this.cost;
   }

   public double getXp() {
      return this.xp;
   }

   public String getName() {
      return this.name;
   }
}

