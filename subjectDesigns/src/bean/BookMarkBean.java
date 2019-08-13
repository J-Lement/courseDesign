package bean;

public class BookMarkBean {
    private int bookId;
    private int userId;
    private String reading;
    private String rTime;

    public BookMarkBean() {
    }

    public BookMarkBean(int bookId, int userId, String reading, String rTime) {
        this.bookId = bookId;
        this.userId = userId;
        this.reading = reading;
        this.rTime = rTime;
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

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }
}
