package bean;

public class ScoreBean {
    private int bookId;
    private int userId;
    private int ifScore = 0;
    private float score;

    public int getIfScore() {
        return ifScore;
    }

    public void setIfScore(int ifScore) {
        this.ifScore = ifScore;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }


}
