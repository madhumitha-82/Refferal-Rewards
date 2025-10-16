public class ReferralAppMain {
    public static void main(String[] args) {
        ReferralService service = new ReferralService();

        User u1 = service.registerUser("U1", "madhu", "madhu124@mail.com");
        User u2 = service.registerUser("U2", "nandhu", "nandhu34@mail.com");

        service.createReferral(u1, "newuser@mail.com");
        service.trackSignup("newuser@mail.com");

        Reward rw1 = new VoucherReward("R1", "Amazon Voucher", 100, 5);
        Reward rw2 = new GiftReward("R2", "Coffee Mug", 150, 2);

        service.addReward(rw1);
        service.addReward(rw2);

        service.redeem(u1, "R1");
        service.redeem(u1, "Coffee Mug", true);

        service.printLeaderboard();
    }
}
