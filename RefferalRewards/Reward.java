public abstract class Reward {
    protected String rewardId;
    protected String name;
    protected int pointsRequired;
    protected int inventory;

    public Reward(String rewardId, String name, int pointsRequired, int inventory) {
        this.rewardId = rewardId;
        this.name = name;
        this.pointsRequired = pointsRequired;
        this.inventory = inventory;
    }

    public String getRewardId() { return rewardId; }
    public String getName() { return name; }
    public int getPointsRequired() { return pointsRequired; }

    public boolean isAvailable() {
        return inventory > 0;
    }

    public void consumeInventory() {
        if (inventory > 0) inventory--;
    }

    public abstract void deliver();
}
