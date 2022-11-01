import java.util.Scanner;

public class MyFarm {
    private int day;
    private Player player;
    private Tile tile;
    private Tools[] tool = new Tools[5];
    private Seed seed;
    

    public MyFarm(String name) {
        this.player = new Player(name);
        this.tile = new Tile();
        this.day = 1;
        this.tool[0] = new Tools(0, 0.5, "Plow");
        this.tool[1] = new Tools(0, 0.5, "Watering Can");
        this.tool[2] = new Tools(10, 4, "Fertilizer");
        this.tool[3] = new Tools(50, 15, "Pickaxe");
        this.tool[4] = new Tools(7, 2, "Shovel");
        this.seed = new Seed(5, 2, 1, 2, 0, 1, 6, 1, 2, 5, "Turnip", "Root Crop");
    }

    public void startDay(Scanner sc) {
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

    public void endDay() {
        this.day++;
        this.tile.updateTime();
        System.out.println("\n\n");
    }

    public boolean gameOver() {
        return (!this.tile.getHasSeed() && this.player.getCoins() < 5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter farmer name: ");
        String name = sc.nextLine();
        MyFarm farm = new MyFarm(name);

        while (!farm.gameOver()) {
            farm.startDay(sc);
        }
        sc.close();
    }
}
