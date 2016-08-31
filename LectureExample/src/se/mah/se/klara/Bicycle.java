package se.mah.se.klara;

public class Bicycle {
	private int gear = 0;
	private int speed = 0;
	public Bicycle(int gear, int speed) {
		this.gear = gear;
		this.speed = speed;
	}
	public int getGear() {
		return gear;
	}
	public void setGear(int gear) {
		this.gear = gear;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
