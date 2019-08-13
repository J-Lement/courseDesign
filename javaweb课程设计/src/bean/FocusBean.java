package bean;

public class FocusBean {
    private int userId;
    private int subId;
    private int ifFoc;

    public FocusBean() {
    }

    public FocusBean(int userId, int subId, int ifFoc) {
        this.userId = userId;
        this.subId = subId;
        this.ifFoc = ifFoc;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getIfFoc() {
        return ifFoc;
    }

    public void setIfFoc(int ifFoc) {
        this.ifFoc = ifFoc;
    }
}
