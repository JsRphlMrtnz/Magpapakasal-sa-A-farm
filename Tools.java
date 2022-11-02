/**
 * This class is used to create a tool object which has a cost, xp, and name.
 * The tool object is used to help the player in the game to either plow, 
 * water crops, fertilize crops, break rocks, or dig. The certain tool objects that are going to be 
 * created through this class are the plow, watering can, fertilizer, shovel, and pickaxe. Through
 * using these tools the player gains xp but loses object coins.
 */
public class Tools {
   private int cost;
   private double xp;
   private String name;

   public Tools(int cost, double xp, String name) {
      this.cost = cost;
      this.xp = xp;
      this.name = name;
   }

/**
 * This method returns the cost of using the certain tool.
 * 
 * @return The cost variable is being returned.
 */
   public int getCost() {
      return this.cost;
   }

/**
 * This method returns xp gained from using the certain tool.
 * 
 * @return The xp variable is being returned.
 */
   public double getXp() {
      return this.xp;
   }

/**
 * This method returns the name of the certain tool which can be
 * plow, watering can, fertilizer, pickaxe, shovel.
 * 
 * @return The name variable is being returne.
 */
   public String getName() {
      return this.name;
   }
}

