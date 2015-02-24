package com.example.bombertruckbackend;

public class Bomb extends MapObject {

	private int bombPower = 0;
	private int bombTimer = 0;
	private boolean exploded = false; // trigged to true when bomb exploded.
	
	public Bomb(Maplocation locObj) {
		super(locObj);
		this.playerPassable = false;
		this.penetratable = false;
		this.exploded = false;
		this.objectName = "Bomb";
	}
	
	public boolean setBombPower(int power) {
		if (bombPower == 0) {
			bombPower = power;
			return true;
		} else {
			return false;
		}
	
	}
	
	public boolean setBombTimer(int time) {
		if (bombTimer == 0) {
			bombTimer = time;
			return true;
		} else {
			return false;
		}
	
	}
	
	public void onExplode() {
		bombTimer = 0;
		setDetenate(true);
		exploded = true;
		Maplocation nextLoc = myLocObj.upLocation();
		for (int upCount = 0; upCount < bombPower; upCount++) {
			if (nextLoc != null) {
				MapObject mapObj = nextLoc.getMapObject();
				mapObj.onDetenate();
				nextLoc = nextLoc.upLocation();
			}
			
		}
		
		nextLoc = myLocObj.downLocation();
		for (int downCount = 0; downCount < bombPower; downCount++) {
			if (nextLoc != null) {
				MapObject mapObj = nextLoc.getMapObject();
				mapObj.onDetenate();
				nextLoc = nextLoc.downLocation();
			}
		}
		
		nextLoc = myLocObj.leftLocation();
		for (int leftCount = 0; leftCount < bombPower; leftCount++) {
			if (nextLoc != null) {
				MapObject mapObj = nextLoc.getMapObject();
			
				mapObj.onDetenate();
			
				nextLoc = nextLoc.leftLocation();
			}
			
		}
		
		nextLoc = myLocObj.rightLocation();
		for (int rightCount = 0; rightCount < bombPower; rightCount++) {
			if (nextLoc != null) {
				MapObject mapObj = nextLoc.getMapObject();
				mapObj.onDetenate();
				nextLoc = nextLoc.rightLocation();
			}
		}
		
	}
	
	
	public void onDetenate() {
		if (exploded == false) {
			onExplode();
		}
		
		// onExplode will set self to detentate
		setCycleMuxTrue();
	}
	
	public void onCycle() {
		bombTimer--;
		if (getDetenate() == true) {
			myLocObj.setMapObject(new Explode(myLocObj));
			exploded = true;
		}
		
		if (bombTimer < 0) {
			if (exploded == false) {
				onExplode();
			}
		}
		setCycleMuxTrue();
	}
}
