import java.util.Random;

public class User {
    private String userId;
    private String name;
    private String email;
    private String referralCode;
    private int points;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.referralCode = generateReferralCode();
        this.points = 0;
    }

    private String generateReferralCode() {
        return name.substring(0, 2).toUpperCase() + new Random().nextInt(9999);
    }

    public String getReferralCode() { return referralCode; }
    public String getName() { return name; }
    public String getUserId() { return userId; }
    public int getPoints() { return points; }

    public void addPoints(int pts) {
        this.points += pts;
    }

    public void deductPoints(int pts) {
        if (this.points >= pts) this.points -= pts;
    }

    @Override
    public String toString() {
        return "User{" + "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", referralCode='" + referralCode + '\'' +
                ", points=" + points + '}';
    }
}
