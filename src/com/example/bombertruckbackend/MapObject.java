package com.example.bombertruckbackend;


public class MapObject {
	
	// default object just empty space
	
	public boolean penetratable = true;
	public boolean playerPassable = true;
	public String objectName = "Road"; 
	protected Maplocation myLocObj = null; 
	
	private boolean cycledMux = false;
	private boolean readyToDetenate = false;
	
	public MapObject (Maplocation locObj) {
		myLocObj = locObj;
	}
	
	public void onDetenate() {
		setDetenate(true);
		cycledMux = true;
	}
	
	public void onCycle() {
		// empty space does nothing
		
		if (getDetenate() == true) {
			myLocObj.setMapObject(new Explode(myLocObj));
		}
		cycledMux = true;
	}
	
	public void onRefresh() {
		cycledMux = false;
	}
	
	protected void setCycleMuxTrue() {
		cycledMux = true;
	}
	
	public boolean isMoved() {
		return cycledMux;
	}
	
	public void setDetenate(boolean detenate) {
		this.readyToDetenate = detenate;
	}
	
	public boolean getDetenate() {
		return readyToDetenate;
	}
}
