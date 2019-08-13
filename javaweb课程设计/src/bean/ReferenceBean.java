package bean;

public class ReferenceBean {
    private int subId;
    private int bookId;
    private int numOfCol;
    private int numOfBro;
    private float avgScore;
    private float Recommend;
    private int upTime;

    public int getUpTime() {
		return upTime;
	}

	public void setUpTime(int upTime) {
		this.upTime = upTime;
	}

	public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getNumOfCol() {
        return numOfCol;
    }

    public void setNumOfCol(int numOfCol) {
        this.numOfCol = numOfCol;
    }

    public int getNumOfBro() {
        return numOfBro;
    }

    public void setNumOfBro(int numOfBro) {
        this.numOfBro = numOfBro;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public float getRecommend() {
        return Recommend;
    }

    public void setRecommend(float d) {
        Recommend = d;
    }
}
