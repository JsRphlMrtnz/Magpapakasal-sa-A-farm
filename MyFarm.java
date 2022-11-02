import java.util.Scanner;

public class MyFarm {
    private int day;                     // amount of days that have passed by in the game
    private Player player;
    private Tile tile;                   // one tile (for MC01)
    private Tools[] tool = new Tools[5]; // Plow, Watering Can, Fertilizer, Shovel, Pickaxe
    private Seed seed;                   // turnip (for MC01)
    

    public MyFarm(String name) {
        this.player = new Player(name);
        this.tile = new Tile(); 
        this.day = 1;
        this.tool[0] = new Tools(0, 0.5, "Plow");         // instantiates the plow tool
        this.tool[1] = new Tools(0, 0.5, "Watering Can"); // instantiates the watering can tool
        this.tool[2] = new Tools(10, 4, "Fertilizer");    // instantiates the fertilizer tool
        this.tool[3] = new Tools(50, 15, "Pickaxe");      // instantiates the pickaxe tool
        this.tool[4] = new Tools(7, 2, "Shovel");         // instantiates the shovel tool
        this.seed = new Seed(5, 2, 1, 2, 0, 1, 6, 1, 2, 5, "Turnip", "Root Crop"); // instantiates the turnip seed
    }

    /**
     * This method is to combine all the game mechanics for the player to be able to
     * play the game. 
     * 
     * @param sc Scanner used to scan the user input.
     */
    public void operation(Scanner sc) {
        char tileChar = ' ';

        int option = 0;
        do {
            System.out.println("Hello " + this.player.getName() + "!");
            System.out.println("Day :" + this.day);
            System.out.println("ObjectCoins: " + this.player.getCoins());
            System.out.println("Level: " + this.player.getLevel());

            if (!this.tile.getHasSeed())
            tileChar = ' ';
            else {
                switch (this.tile.getSeed().getName()) {
                case "Turnip":
                    tileChar = 'T';
                    break;
                }
                if (this.tile.isWithered())
                    tileChar = 'W';
            }
            System.out.println("=============");
            System.out.println("|" + tileChar + "|");
            System.out.println("=============");
            if (this.tile.getHasSeed())
                System.out.println("Time left to harvest: " + this.tile.getTime());

            System.out.println("1. Actions\t2. End Day");
            System.out.print("What would you like to do: ");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("1. Plow\t2. Plant\t3. Water\t4. Fertilize\t5. Dig\t 6. Harvest\t7. Back");
                    int action;
                    do {
                        System.out.print("What would you like to do: ");
                        action = sc.nextInt();
                    } while (action < 1 || action > 7);
    
                    switch (action) {
                        case 1: {
                            if (this.player.plow(this.tool[0], this.tile)) {
                                System.out.println("You plowed the tile!");
                            } else {
                                System.out.println("You cannot plow the tile!");
                            }
                            break;
                        }
                        case 2: {
                            if (this.player.plant(this.seed, this.tile)) {
                                System.out.println("You planted the seed!");
                            } else {
                                System.out.println("You cannot plant on this tile!");
                            }
                            break;
                        }
                        case 3: {
                            if (this.player.water(this.tool[1], this.tile)) {
                                System.out.println("You watered the tile!");
                            } else {
                                System.out.println("You cannot water this tile!");
                            }
                            break;
                        }
                        case 4: {
                            if (this.player.fertilize(this.tool[2], this.tile)) {
                                System.out.println("You fertilized the tile!");
                            } else {
                                System.out.println("Fertilizing failed!");
                            }
                            break;
                        }
                        case 5: {
                            if (this.player.dig(this.tool[4], this.tile)) {
                                System.out.println("You dug the tile out!");
                            } else {
                                System.out.println("Digging failed!");
                            }
                            break;
                        }
                        case 6: {
                            if (this.player.harvest(this.tile)) {
                                System.out.println("You harvested the tile!");
                            } else {
                                System.out.println("Harvesting failed!");
                            }
                            break;
                        }
                    }
                    option = 0;
                    break;
                }
            }
            
        } while (option != 2);

        this.endDay();
    }

/**
 * This method increments the day and updates the harvest time of the tile
 */
    public void endDay() {
        this.day++;
        this.tile.updateTime();
        System.out.println("\n\n");
    }

/**
 * This method determines if it is gameover for the player. The game is over if there are no
 * active growing crops and the player cannot buy a Turnip seed.
 * 
 * @return This returns a boolean value to determine if it is gameover.
 */
    public boolean gameOver() {
        return (!this.tile.getHasSeed() && this.player.getCoins() < 5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter farmer name: ");
        String name = sc.nextLine();
        MyFarm farm = new MyFarm(name);

        // the game will go on as long it is not gameOver for the player.
        while (!farm.gameOver()) {
            farm.operation(sc);
        }
        sc.close();
    }
}
