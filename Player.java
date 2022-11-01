import java.util.Random;

public class Player {
    private double xp;
    private double objectCoins;
    private FarmerType type;
    private String name;

    public Player(String name) {
        this.name = name;
        this.xp = 0;
        this.objectCoins = 100;
        type = new FarmerType(0, 0, 0, 0, 0, 0, "Farmer");
    }

    public boolean updateFarmerType(FarmerType newType) {
        if (newType.getMinLevel() <= this.getLevel()) {
            this.type = newType;
            return true;
        }
        return false;
    }

    public void updateCoins(int objectCoins) {
        this.objectCoins += objectCoins;
    }

    public void updateXp(double xp) {
        this.xp += xp;
    }

    public boolean plant(Seed seed, Tile tile) {
        if (tile.getHasSeed() || !tile.getPlowed() || this.objectCoins < seed.getCost()) {
            return false;
        }
        
        this.objectCoins -= seed.getCost();
        tile.setSeed(seed);
        return true;
    }

    public boolean plow(Tools tool, Tile tile) {
        if (tool.getName() == "Plow" && !tile.getPlowed()) {
            tile.updatePlow();
            xp += tool.getXp();
            this.objectCoins -= tool.getCost();
            return true;
        }
        return false;
    }

    public boolean water(Tools tool, Tile tile) {
        if (tool.getName() == "Watering Can" && tile.getHasSeed()) {
            tile.updateWater();
            xp += tool.getXp();
            this.objectCoins -= tool.getCost();
            return true;
        }
        return false;
    }

    public boolean fertilize(Tools tool, Tile tile) {
        if (this.objectCoins - tool.getCost() <= 0 || !tile.getHasSeed())
            return false;

        tile.updateFert();
        xp += tool.getXp();
        this.objectCoins -= tool.getCost();
        return true;
    }
    
    public boolean dig (Tools tool, Tile tile) {
        if (this.objectCoins - tool.getCost() <= 0)
            return false;
        if (tool.getName() == "Shovel" && tile.getPlowed()) {
            tile.updatePlow();
            if (tile.getHasSeed())
                tile.reset();
            }
        xp += tool.getXp();
        this.objectCoins -= tool.getCost();
        return true;
    }

    public boolean harvest(Tile tile) {
        if (tile.getTime() == 0 && tile.getHasSeed()) {
            int productsProduced = new Random().nextInt(tile.getSeed().getMaxProduce() - tile.getSeed().getMinProduce() + 1) + tile.getSeed().getMinProduce();
            int harvestTotal = productsProduced * (tile.getSeed().getSellingPrice() + this.type.getBonusEarning());
            
            int waterCount = tile.getWater() + this.type.getBonusWaterLimit();
            if (waterCount > tile.getSeed().getMaxWater())
                waterCount = tile.getSeed().getMaxWater();
            double waterBonus = harvestTotal * 0.2 * (waterCount - 1);
            
            int fertCount = tile.getFert() + this.type.getBonusFertilizerLimit();
            if (fertCount > tile.getSeed().getMaxFertilizer())
                fertCount = tile.getSeed().getMaxFertilizer();
            double fertBonus = harvestTotal * 0.5 * (fertCount - 1);
            
            double total = harvestTotal + waterBonus + fertBonus;
            this.objectCoins += total;

            double xpGain = tile.getSeed().getXp() * productsProduced;
            this.xp += xpGain;

            System.out.println("Harvested " + productsProduced + " " + tile.getSeed().getName() + " for " + total + " ObjectCoins.");
            System.out.println("Gained " + xpGain + " xp.");
            tile.reset();
            return true;
        }
        return false;
    }

    public int getLevel() {
        return (int) Math.floor(this.xp / 100);
    }

    public double getCoins() {
        return this.objectCoins;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type.getType();
    }
}