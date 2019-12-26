package javab;

public class Room {
	private int roomNum;
	private String bedType;
	private double rate;
	private String occupantName;
	private char smoking;
	private boolean occupied;
	
	public Room() {
		this.occupantName = "No";
		this.occupied = false;
	}
	
	public Room(int roomNum, String bedType, double rate, char smoking) {
		this.roomNum = roomNum;
		this.bedType = bedType;
		this.rate = rate;
		this.smoking = smoking;
	}
	
	public String getBedType() {
		return this.bedType;
	}
	
	public double getRoomRate() {
		return this.rate;
	}
	
	public char getSomking() {
		return this.smoking;
	}
	
	public int getRoomNum() {
		return this.roomNum;
	}

	public String getOccupant() {
		return this.occupantName;
	}
	
	public void setOccupied(boolean occu) {
		this.occupied = occu;
	}
	
	public void setOccupant(String occu) {
		this.occupantName = occu;
	}
	
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	public void setBedType(String btype) {
		this.bedType = btype;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public void setSomking(char smoking) {
		this.smoking = smoking;
	}

	public boolean isOccupied() {
		return this.occupied;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("\nThe room number is " + this.roomNum + "\nThe bed type is " + this.bedType + "\nThe rate is " + this.rate +
				"\nSmoking(" + this.smoking + ")\n");
		if(this.occupied) {
			sb.append("This room is booked, occupant name is " + this.occupantName);
		}
		return sb.toString();
	}
}
