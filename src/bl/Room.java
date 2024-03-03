package bl;
/**
 * This class represents a room in the hotel
 *
 */

public class Room {
	static Integer numbers = 1;
	int numRoom;
	int floor;
	LevelEnum level;
	boolean isActive;
	static double startPrice;
	
	Room(int floor, LevelEnum level) {
		setFloor(floor);
		synchronized (numbers) {
			setNumRoom(numbers++);
		}
		setLevel(level);
		
	}

	public int getNumRoom() {
		return numRoom;
	}

	private void setNumRoom(int numRoom) {
		this.numRoom = numRoom;
	}

	public int getFloor() {
		return floor;
	}

	void setFloor(int floor) {
		// add condition to check floor is valid
		this.floor = floor;
	}

	public LevelEnum getLevel() {
		return level;
	}

	void setLevel(LevelEnum level) {
		this.level = level;
	}

	public boolean isActive() {
		return isActive;
	}

	void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
