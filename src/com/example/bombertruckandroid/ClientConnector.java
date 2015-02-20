package com.example.bombertruckandroid;

import com.example.bombertruckbackend.GameCycleController;
import com.example.bombertruckbackend.Map;
import com.example.bombertruckbackend.PlayerController;


	public class ClientConnector {
		
		GameCycleController connection;
		PlayerController playerController;
		
		public ClientConnector() {
			connection = new GameCycleController(new Map(5,5, true));
			playerController = getPlayerController();
		}
		
		public Map getMap() {
			return connection.sentMap();
		}
		
		public PlayerController getPlayerController() {
			return connection.testControlPlayerOne();
		}
		
		public void update() {
			//send command function to backend here
			//W = up; S= down; A = Left; D =Right; B = Setbomb
			// if button/location of pressed.
			if (true) {
				playerController.enqueueCommand("A");
			}
			if (true) {
				playerController.enqueueCommand("D");
			}
			if (true) {
				playerController.enqueueCommand("W");
			}
			if (true) {
				playerController.enqueueCommand("S");
			}
			if (true) {
				playerController.enqueueCommand("B");
			}
			
			//this going to be replace with a server side cycling when the project goes to web
			connection.onCycle();
		}
	}


