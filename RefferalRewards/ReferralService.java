import java.util.*;

public class ReferralService {
    private Map<String, User> users = new HashMap<>();
    private List<Referral> referrals = new ArrayList<>();
    private List<Reward> rewards = new ArrayList<>();

    public User registerUser(String userId, String name, String email) {
        User u = new User(userId, name, email);
        users.put(userId, u);
        return u;
    }

    public void createReferral(User inviter, String inviteeEmail) {
        String refId = "REF" + (referrals.size() + 1);
        Referral r = new Referral(refId, inviter, inviteeEmail);
        referrals.add(r);
        System.out.println("Referral created by " + inviter.getName() + " for " + inviteeEmail);
    }

    public void trackSignup(String inviteeEmail) {
        for (Referral r : referrals) {
            if (r.getStatus().equals("PENDING") && r.inviteeEmail.equals(inviteeEmail)) {
                r.markSignedUp();
                System.out.println("Signup tracked! Points awarded to " + r.getInviter().getName());
                break;
            }
        }
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
    }

    public void redeem(User user, String rewardId) {
        for (Reward r : rewards) {
            if (r.getRewardId().equals(rewardId)) {
                processRedemption(user, r);
                return;
            }
        }
        System.out.println("Reward not found.");
    }

    public void redeem(User user, String rewardName, boolean withPromo) {
        for (Reward r : rewards) {
            if (r.getName().equalsIgnoreCase(rewardName)) {
                if (withPromo) {
                    System.out.println("Promo applied! 10% discount on points.");
                    r.pointsRequired *= 0.9;
                }
                processRedemption(user, r);
                return;
            }
        }
        System.out.println("Reward not found.");
    }

    private void processRedemption(User user, Reward r) {
        if (!r.isAvailable()) {
            System.out.println("Reward out of stock!");
            return;
        }
        if (user.getPoints() >= r.getPointsRequired()) {
            user.deductPoints(r.getPointsRequired());
            r.consumeInventory();
            r.deliver();
            System.out.println(user.getName() + " redeemed " + r.getName());
        } else {
            System.out.println("Not enough points to redeem " + r.getName());
        }
    }

    public void printLeaderboard() {
        System.out.println("\n===== Referral Leaderboard =====");
        users.values().stream()
                .sorted((u1, u2) -> Integer.compare(u2.getPoints(), u1.getPoints()))
                .forEach(u -> System.out.println(u.getName() + " - " + u.getPoints() + " points"));
    }
}
