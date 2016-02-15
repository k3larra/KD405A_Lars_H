package se.mah.k3.lars.model;

import java.util.ArrayList;
import java.util.Iterator;

import se.mah.k3.lars.Constants;

public class CatFarm {
	private ArrayList<Cat> allCats;
	private String name;
	
	

	public CatFarm(String name){
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
			allCats.get(0).hideCat();
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
	
	public ArrayList<Cat> getAllCats(){
		return allCats;
	}
	
}
