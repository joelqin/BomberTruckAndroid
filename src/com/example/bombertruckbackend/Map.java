package com.example.bombertruckbackend;

public class Map {
	private Maplocation[][] map = null;
	private int mapSizeX = 0;
	private int mapSizeY = 0;
	
	
	public Map(int x, int y) {
		mapSizeX = x;
		mapSizeY = y;
		initMap();
	}
	
	public Map(int x, int y, boolean tester) {
		mapSizeX = x; 
		mapSizeY = y;
		initMap();
		if (tester == true) {
			map[0][0].setMapObject(new Player(map[0][0]));
			map[mapSizeX - 1][mapSizeY - 1].setMapObject(new Player(map[mapSizeX - 1][mapSizeY - 1]));
		}
	}
	
	private void initMap() {
		map = new Maplocation[mapSizeX][mapSizeY];
		for(int x = 0; x < mapSizeX; x++) {
			for (int y = 0; y < mapSizeY; y++) {
				map[x][y] = new Maplocation(x,y,this);
			}
		}
	}
	public Maplocation[][] getMap() {
		return map;
	}
	
	public int getMapSizeX() {
		return mapSizeX;
	}
	
	public int getMapSizeY() {
		return mapSizeY;
	}
	
	public boolean setMap(int x, int y) {
		if (map == null) {
			map = new Maplocation[x][y];
			initMap();
			return true;
		} else {
			return false;
		}
	}
	
	public Maplocation getLocation(int x, int y) {
		if (map == null) {
			return null;
		} 
		else if (((mapSizeX - 1) < x) || (x < 0) || ((mapSizeY - 1) < y) || (y < 0)) {
			return null;
		}
		else {
			return map[x][y];
		}
	}
	
}
