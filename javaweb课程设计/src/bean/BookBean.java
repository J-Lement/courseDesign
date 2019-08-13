package bean;

public class BookBean {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookInfo;
	private String bookAttach;
	private String bookSub;
	private String reading;
	private String rTime;
	private int upTime;
	public int getUpTime() {
		return upTime;
	}
	public void setUpTime(int upTime) {
		this.upTime = upTime;
	}
	public String getBookSub() {
		return bookSub;
	}
	public void setBookSub(String bookSub) {
		this.bookSub = bookSub;
	}
	public String getBookAttach() {
		return bookAttach;
	}
	public void setBookAttach(String bookAttach) {
		this.bookAttach = bookAttach;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
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
