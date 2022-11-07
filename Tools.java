/**
 * This class is used to create a tool object which has a cost, xp, and name.
 * The tool object is used to help the player in the game to either plow, 
 * water crops, fertilize crops, break rocks, or dig. The certain tool objects that are going to be 
 * created through this class are the plow, watering can, fertilizer, shovel, and pickaxe. Through
 * using these tools the player gains xp but loses object coins.
 */
public class Tools {
   private int cost;    // The cost of using the tool
   private double xp;   // The amount of xp the player receives when using the tool
   private String name; // The name of the tool

   /**
    * This constructor assigns the cost, xp, and name of the tool.
    * @param cost The cost of using the tool
    * @param xp The amount of xp the player receives when using the tool
    * @param name The name of the tool
    */
   public Tools(int cost, double xp, String name) {
      this.cost = cost;
      this.xp = xp;
      this.name = name;
   }

/**
 * This method returns the cost of using the certain tool.
 * 
 * @return The cost of the tool.
 */
   public int getCost() {
      return this.cost;
   }

/**
 * This method returns xp gained from using the certain tool.
 * 
 * @return The amount of xp the user gains when using the tool.
 */
   public double getXp() {
      return this.xp;
   }

/**
 * This method returns the name of the tool.
 * 
 * @return The name of the tool.
 */
   public String getName() {
      return this.name;
   }
}

