package se.mah.k3.lars;

import java.util.ArrayList;
import java.util.Iterator;

public class CatGarden {
	private ArrayList<Cat> allCats;
	private String name;
	
	

	public CatGarden(String name){
		this.allCats = new ArrayList<Cat>();
		this.name = name;
	}
	
	public void addCat(Cat c){
		if ( allCats.size()<Constants.maxNumberOfCats){
			this.allCats.add(c);
		}
	}
	
	public void killCat(){
		if(allCats.size()>0){
			allCats.remove(0);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCats(){
		String s = this.name+"\n";
		for (Cat cat : allCats) {
			s = s + "Name: "+ cat.getName()+" Age: "+ cat.getAge()+"\n";
		}
		return s;
	}
	
}
