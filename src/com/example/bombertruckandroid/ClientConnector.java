package com.example.bombertruckandroid;

import android.content.Context;
import android.os.AsyncTask;

import com.example.bombertruckbackend.GameCycleController;
import com.example.bombertruckbackend.Map;
import com.example.bombertruckbackend.PlayerController;


	public class ClientConnector extends Thread{
		
		public static boolean upButtonPressed = false; 
		public static boolean downButtonPressed = false;
		public static boolean leftButtonPressed = false;
		public static boolean rightButtonPressed = false;
		public static boolean bombButtonPressed = false;
		
		private static boolean threadLoopRunning = false;
		
		private static GameCycleController connection = new GameCycleController(new Map(5,5, true));
		
		PlayerController playerController;
		
		public ClientConnector() {
			connection = new GameCycleController(new Map(5,5, true));
			playerController = getPlayerController();
		}
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			threadLoopRunning = true;
			while(threadLoopRunning) {
				update();
			}
		}
		
		
		public void end() {
			threadLoopRunning = false;
		
		}
		
		public static Map getMap() {
			return connection.sentMap();
		}
		
		public PlayerController getPlayerController() {
			return connection.testControlPlayerOne();
		}
		
		public void update() {
			//send command function to backend here
			//W = up; S= down; A = Left; D =Right; B = Setbomb
			// if button/location of pressed.
			if (upButtonPressed) {
				playerController.enqueueCommand("A");
			} 
			if (downButtonPressed) {
				playerController.enqueueCommand("D");
			}
			if (leftButtonPressed) {
				playerController.enqueueCommand("W");
			} 
			if (rightButtonPressed) {
				playerController.enqueueCommand("S");
			}
			if (bombButtonPressed) {
				playerController.enqueueCommand("B");
			}
			
			//this going to be replace with a server side cycling when the project goes to web
			connection.onCycle();
		}
		
		
	}


