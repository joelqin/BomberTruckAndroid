package com.example.bombertruckbackend;


public class Explode extends MapObject{

	private int explodeTimer = 2;
	
	public Explode(Maplocation locObj) {
		super(locObj);
		this.playerPassable = true;
		this.penetratable = true;
		this.objectName = "Explode";
	}

	public void onCycle() {
		// empty space does nothing
		explodeTimer--;
		if (explodeTimer <= 0) {
			myLocObj.setMapObject(new MapObject(myLocObj));
			myLocObj.getMapObject().setCycleMuxTrue();
		}
		if (getDetenate() == true) {
			myLocObj.setMapObject(new Explode(myLocObj));
			myLocObj.getMapObject().setCycleMuxTrue();
		}
		setCycleMuxTrue();	
	}
	
}
