package se.mah.k3;

public class Item {
	 private String moment;
	 private String teacher;
	public Item(String moment,String teacher) {
		this.moment = moment;
		this.teacher = teacher;
	}
	 public String getMoment() {
		return this.moment;
	}
	public void setMoment(String moment) {
		this.moment = moment;
	}
	public String getTeacher() {
		return this.teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
}
