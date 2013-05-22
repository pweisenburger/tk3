package tk3.labyrinth.gui;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Set;

import tk3.labyrinth.core.gameelements.Door;
import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.gamefield.Room;

public final class RoomUtil {
	public static final class DoorEntry {
		boolean bottom, right, top, left;
	}
	
	public static Map<Room, Point> calculateRoomPosition(Field field, Map<Door, DoorEntry> doorEntry) {
		Map<Room, Point> roomPosition = new HashMap<>();
		int sepOffset = -990;
		for (Room room : field.getRooms()) {
			if (!roomPosition.containsKey(room))
				roomPosition.put(room, new Point(sepOffset += 1000, 0));
			
			Queue<Room> rooms = new LinkedList<>();
			rooms.add(room);
			
			while (!rooms.isEmpty()) {
				Room room0 = rooms.poll();
				Point point0 = roomPosition.get(room0);
				
				for (int y = 0; y < room0.getHeight(); y++)
					for (int x = 0; x < room0.getWidth(); x++)
						if (room0.getGameElement(x, y) instanceof Door) {
							Door door0 = (Door) room0.getGameElement(x, y);
							Door door1 = door0.getDoor();
							
							if (door1 != null && !roomPosition.containsKey(door1.getPosition().getRoom())) {
								Room room1 = door1.getPosition().getRoom();
								if (roomPosition.containsKey(room1))
									continue;
								
								DoorEntry entry0 = doorEntry.get(door0);
								DoorEntry entry1 = doorEntry.get(door1);
								
								Point point1 = new Point(point0.x - door1.getPosition().getX() + door0.getPosition().getX(),
										                 point0.y - door1.getPosition().getY() + door0.getPosition().getY());
								
								if (!entry0.bottom && !entry1.top
										&& !isRoomIntersection(room1, new Point(point1.x, point1.y + 1), roomPosition))
									roomPosition.put(room1, new Point(point1.x, point1.y + 1));
								else if (!entry0.top && !entry1.bottom
										&& !isRoomIntersection(room1, new Point(point1.x, point1.y - 1), roomPosition))
									roomPosition.put(room1, new Point(point1.x, point1.y - 1));
								else if (!entry0.right && !entry1.left
										&& !isRoomIntersection(room1, new Point(point1.x + 1, point1.y), roomPosition))
									roomPosition.put(room1, new Point(point1.x + 1, point1.y));
								else if (!entry0.left && !entry1.right
										&& !isRoomIntersection(room1, new Point(point1.x - 1, point1.y), roomPosition))
									roomPosition.put(room1, new Point(point1.x - 1, point1.y));
								
								else if (!entry0.bottom && !entry1.top && entry1.bottom && entry0.top) {
									Point point = new Point(point1.x, point1.y + 2);
									while (isRoomIntersection(room1, point, roomPosition))
										point.y++;
									point.y++;
									roomPosition.put(room1, point);
								}
								else if (!entry0.top && !entry1.bottom && entry1.top && entry0.bottom) {
									Point point = new Point(point1.x, point1.y - 2);
									while (isRoomIntersection(room1, point, roomPosition))
										point.y--;
									point.y--;
									roomPosition.put(room1, point);
								}
								else if (!entry0.right && !entry1.left && entry1.right && entry0.left) {
									Point point = new Point(point1.x + 2, point1.y);
									while (isRoomIntersection(room1, point, roomPosition))
										point.x++;
									point.x++;
									roomPosition.put(room1, point);
								}
								else if (!entry0.left && !entry1.right && entry1.left && entry0.right) {
									Point point = new Point(point1.x - 2, point1.y);
									while (isRoomIntersection(room1, point, roomPosition))
										point.x--;
									point.x--;
									roomPosition.put(room1, point);
								}
								
								else if (!entry0.bottom && !entry1.top) {
									Point point = new Point(point1.x, point1.y + 2);
									while (isRoomIntersection(room1, point, roomPosition))
										point.y++;
									point.y++;
									roomPosition.put(room1, point);
								}
								else if (!entry0.top && !entry1.bottom) {
									Point point = new Point(point1.x, point1.y - 2);
									while (isRoomIntersection(room1, point, roomPosition))
										point.y--;
									point.y--;
									roomPosition.put(room1, point);
								}
								else if (!entry0.right && !entry1.left) {
									Point point = new Point(point1.x + 2, point1.y);
									while (isRoomIntersection(room1, point, roomPosition))
										point.x++;
									point.x++;
									roomPosition.put(room1, point);
								}
								else {
									Point point = new Point(point1.x - 2, point1.y);
									while (isRoomIntersection(room1, point, roomPosition))
										point.x--;
									point.x--;
									roomPosition.put(room1, point);
								}
								
								rooms.add(room1);
							}
						}
			}
		}
		return roomPosition;
	}
	
	public static boolean isRoomIntersection(Room room, Point offset, Map<Room, Point> roomPosition) {
		for (Entry<Room, Point> entry : roomPosition.entrySet())
			if (areRoomsIntersecting(room, offset, entry.getKey(), entry.getValue()))
				return true;
		return false;
	}
	
	public static boolean areRoomsIntersecting(Room room0, Point offset0,
            Room room1, Point offset1) {
		Set<Point> points = new HashSet<>();
		for (int y = 0; y < room0.getHeight(); y++)
		for (int x = 0; x < room0.getWidth(); x++)
		if (room0.getGameElement(x, y) != null &&
		!room0.getGameElement(x, y).isTraversable())
		points.add(new Point(offset0.x  + x, offset0.y + y));
		
		for (int y = 0; y < room1.getHeight(); y++)
		for (int x = 0; x < room1.getWidth(); x++)
		if (room1.getGameElement(x, y) != null &&
		!room1.getGameElement(x, y).isTraversable() &&
		points.contains(new Point(offset1.x + x, offset1.y + y)))
		return true;
		
		return false;
	}
	
	public static Map<Door, DoorEntry> calculateDoorEntries(Field field) {
		Map<Door, DoorEntry> doorEntry = new HashMap<>();
		for (Room room : field.getRooms())
			for (int y = 0; y < room.getHeight(); y++)
				for (int x = 0; x < room.getWidth(); x++)
					if (room.getGameElement(x, y) instanceof Door) {
						Door door = (Door) room.getGameElement(x, y);
						doorEntry.put(door, calculateDoorEntries(door));
					}
		return doorEntry;
	}
	
	private static DoorEntry calculateDoorEntries(Door door) {
		Room room = door.getPosition().getRoom();
		int x = door.getPosition().getX();
		int y = door.getPosition().getY();
		
		DoorEntry doorEntry = new DoorEntry();
		doorEntry.bottom = y + 1 < room.getHeight() &&
				(room.getGameElement(x, y + 1) == null ||
				 room.getGameElement(x, y + 1).isTraversable());
		doorEntry.right = x + 1 < room.getWidth() &&
				(room.getGameElement(x + 1, y) == null ||
				 room.getGameElement(x + 1, y).isTraversable());
		doorEntry.top = y - 1 >= 0 &&
				(room.getGameElement(x, y - 1) == null ||
				 room.getGameElement(x, y - 1).isTraversable());
		doorEntry.left = x - 1 >= 0 &&
				(room.getGameElement(x - 1, y) == null ||
				 room.getGameElement(x - 1, y).isTraversable());
		return doorEntry;
	}
}
