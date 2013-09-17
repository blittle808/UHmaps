package com.example.uhmaps;


public class Class {
	
	private String building_name;
	
	
	private int room_number;
	
	public Class() {
		//TODO
		
		this.building_name = "";
		this.room_number = 0;
	}
	
	public Class(String build) {
		//TODO
		
		this.building_name = build;
		this.room_number = 0;
	}
	
	
	public Class(String build, int room) {
		//TODO
		
		this.building_name = build;
		this.room_number = room;
	}
	
	/**
	 * Accessor for the text of this joke.
	 * 
	 * @return	A String value containing the text of this joke.
	 */
	public String getBuilding() {
		//TODO
		return this.building_name;
	}

	
	public void setBuilding(String build) {
		//TODO
		this.building_name = build;
	}

	
	public int getRoom() {
		//TODO
		return this.room_number;
	}
	
	
	public void setRoom(int room) {
		//TODO
		this.room_number = room;
	}
	
	public String toString() {
		//TODO
		return this.getBuilding();
	}
	public boolean equals(Object obj) {
		//TODO
		boolean ret = false;
		if(obj!=null){
			if(obj.getClass() == Class.class)
				if(obj.toString().equals(this.building_name))
					ret = true;
		}else
			ret = false;
		
		return ret;
	}

}


