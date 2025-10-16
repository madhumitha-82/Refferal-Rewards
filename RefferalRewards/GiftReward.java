public class GiftReward extends Reward {
    public GiftReward(String rewardId, String name, int pointsRequired, int inventory) {
        super(rewardId, name, pointsRequired, inventory);
    }

    @Override
    public void deliver() {
        System.out.println("Gift " + name + " shipped to user address.");
    }
}
