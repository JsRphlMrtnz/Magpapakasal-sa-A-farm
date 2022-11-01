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
}
