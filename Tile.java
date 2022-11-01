public class Tile {
    private Seed seed;
    private boolean isPlowed;
    private int water;
    private int fertilizer;
    private int harvestTime;
    private boolean hasSeed;

    public Tile() {
        reset();
    }

    public void reset() {
        this.seed = null;
        this.isPlowed = false;
        this.water = 0;
        this.fertilizer = 0;
        this.harvestTime = 0;
        this.hasSeed = false;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
        this.hasSeed = true;
        this.water = 0;
        this.fertilizer = 0;
        this.harvestTime = seed.getHarvestTime();
    }

    public void updatePlow() {
        if (this.isPlowed) {
            this.isPlowed = false;
        } else {
            this.isPlowed = true;
        }
    }

    public void updateWater() {
        this.water++;
    }

    public void updateFert() {
        this.fertilizer++;
    }

    public void updateTime() {
        this.harvestTime--;
    }

    public boolean getPlowed() {
        return this.isPlowed;
    }

    public boolean getHasSeed() {
        return this.hasSeed;
    }

    public int getTime() {
        return this.harvestTime;
    }

    public Seed getSeed() {
        return this.seed;
    }

    public boolean isWithered() {
        if (this.water < this.seed.getMinWater() || this.fertilizer < this.seed.getMinFertilizer() && this.harvestTime == 0) {
            return true;
        }
        return false;
    }

    public int getWater() {
        return this.water;
    }

    public int getFert() {
        return this.fertilizer;
    }
}
