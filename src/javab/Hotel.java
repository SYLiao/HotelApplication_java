package javab;

import java.util.*;

public class Hotel {
	private static final int NOT_FOUND = -1;
	
	private ArrayList<Room> theRooms = new ArrayList<Room>();
	private String name;
	private String location;
	private int occupiedCnt;
	private int numOfRooms;
	
	public Hotel() {
		this.occupiedCnt = 0;
		this.numOfRooms = 0;
	}
	
	public Hotel(String name, String location) {
		this.name = name;
		this.location = location;
		this.occupiedCnt = 0;
		this.numOfRooms = 0;
	}
	
	public void setTheRooms(ArrayList<Room> theRooms) {
		this.theRooms = theRooms;
	}
	
	public List<Room> getTheRooms() {
		return this.theRooms;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public int getRoomCnt() {
		return this.numOfRooms;
	}
	
	public int getOccupied() {
		return this.occupiedCnt;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean isFull() {
		return this.occupiedCnt == this.numOfRooms;
	}
	
	public boolean isEmpty() {
		return this.occupiedCnt == 0;
	}
	
	public void addRoom(int room, String bed, char smoking, double rate) {
		if(this.theRooms.size() != 0) {
			System.out.println("This room is existed");
			return;
		}
		Room newRoom = new Room(room, bed, rate, smoking);
		this.theRooms.add(newRoom);
		this.numOfRooms++;
	}
	
	public void addRoom(Room room, int id) {
		this.theRooms.add(room);
		this.numOfRooms++;
	}
	
	public void addReservation(String name, char smoking, String bed) {
		for(Room room : this.theRooms) {
			if(room != null && !room.isOccupied()) {
				if(room.getSomking() == smoking && room.getBedType() == bed) {
					room.setOccupant(name);
					room.setOccupied(true);
					System.out.println("You are registered");
					this.occupiedCnt++;
					return;
				}
			}
		}
		System.out.println("No available room");
	}
	
	public void cancelReservation(String name) {
		int id = findReservation(name);
		if(id == -1) {
			System.out.println("Not found");
		}
		else {
			this.theRooms.get(id).setOccupant(null);
			this.theRooms.get(id).setOccupied(false);
		}
	}
	
	public int findReservation(String name) {
		for(Room room : this.theRooms) {
			if(room != null && room.getOccupant() == name) {
				return room.getRoomNum();
			}
		}
		return NOT_FOUND;
	}
	
	public void printReservationList() {
		for(Room room : this.theRooms) {
			if(room != null && room.isOccupied()) {
				System.out.println(room.toString());
			}
		}
	}
	
	public int getDailySales() {
		int sum = 0;
		for(Room room : this.theRooms) {
			if(room != null && room.isOccupied()) {
				sum += room.getRoomRate();
			}
		}
		return sum;
	}
	
	public double occupancyPercentage() {
		return (double)this.numOfRooms / (double)this.occupiedCnt;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The Hotel name is " + this.name + "\nThe rooms number is " + this.numOfRooms + "\nThe available rooms number is " + this.occupiedCnt);
		for(Room room : this.theRooms) {
			if(room != null) {
				sb.append(room.toString());
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
