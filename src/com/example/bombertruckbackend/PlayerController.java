package com.example.bombertruckbackend;


public class PlayerController {
	//this queue only allow single command to be saved
	
	private String command = null;
	private Player player = null;
	
	public PlayerController(Player player) {
		this.player = player;
	}
	
	public void enqueueCommand(String command) {
		this.command = command;
	}
	
	public String dequeueCommand() {
		String result = command;
		command = null;
		return result;
	}
	
	public boolean executeCommand() {
		if (player == null) {
			return false;
		}
		if (command == null) {
			return false;
		}
		if (command.equals("W")) {
			player.moveUp();
		} else if (command.equals("S")){
			player.moveDown();
		} else if (command.equals("A")){
			player.moveLeft();
		} else if (command.equals("D")){
			player.moveRight();
		} else if (command.equals("B")){
			player.placeBomb();
		}
		command = null;
		return true;
	}

	
}
