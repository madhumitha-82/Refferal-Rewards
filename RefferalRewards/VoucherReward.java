public class VoucherReward extends Reward {
    public VoucherReward(String rewardId, String name, int pointsRequired, int inventory) {
        super(rewardId, name, pointsRequired, inventory);
    }

    @Override
    public void deliver() {
        System.out.println("Voucher " + name + " delivered via Email.");
    }
}
