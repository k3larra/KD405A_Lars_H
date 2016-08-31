package se.mah.se.klara;

public class MountainBike extends Bicycle {
	private int shockAbsorberSetting = 0;
	
	public MountainBike(int gear, int speed, int shockAbsorberSetting) {
		super(gear, speed);
		this.shockAbsorberSetting = shockAbsorberSetting;
	}

	public int getShockAbsorberSetting() {
		return shockAbsorberSetting;
	}

	public void setShockAbsorberSetting(int shockAbsorberSetting) {
		this.shockAbsorberSetting = shockAbsorberSetting;
	}
	
}
