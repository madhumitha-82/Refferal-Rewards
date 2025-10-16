public class Referral {
    private String refId;
    private User inviter;
    String inviteeEmail;
    private String status;
    private int bonus;

    public Referral(String refId, User inviter, String inviteeEmail) {
        this.refId = refId;
        this.inviter = inviter;
        this.inviteeEmail = inviteeEmail;
        this.status = "PENDING";
        this.bonus = 50;
    }

    public void markSignedUp() {
        this.status = "SIGNEDUP";
        inviter.addPoints(bonus);
    }

    public String getStatus() {
        return status;
    }

    public User getInviter() {
        return inviter;
    }
}
