package com.example.bombertruckandroid;

import com.example.bombertruckbackend.GameCycleController;
import com.example.bombertruckbackend.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View{

	GameCycleController gameController = null;
	
	Bitmap bomb = null;
	Bitmap explode = null;
	Bitmap player = null;
	Bitmap playerandbomb = null;
	Bitmap road = null;
	
	Paint paint = null;
	
	private void initGameView() {
		this.gameController = new GameCycleController(new Map(5,5,true));
		this.bomb = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
		this.player = BitmapFactory.decodeResource(getResources(), R.drawable.player);
		this.playerandbomb = BitmapFactory.decodeResource(getResources(), R.drawable.playerandbomb);
		this.road = BitmapFactory.decodeResource(getResources(), R.drawable.road);
		this.explode = BitmapFactory.decodeResource(getResources(), R.drawable.explode);
		this.paint = new Paint();
	}
	
	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		initGameView();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initGameView();
	}

	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initGameView();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		gameController.onCycle();
		Map gameMap = gameController.sentMap();
		
		int canvasHeight = canvas.getHeight();
		int canvasWidth = canvas.getWidth();
		
		int mapSizeX = gameMap.getMapSizeX();
		int mapSizeY = gameMap.getMapSizeY();
		
		int minLength = Math.min(canvasHeight, canvasWidth);
				
		int gameboxSize = minLength/mapSizeX;
		
		
		for (int x = 0; x < mapSizeX;x++) {
			for (int y = 0; y < mapSizeY; y++) {
				int boxXPosStart = x * gameboxSize;
				int boxXPosEnd = boxXPosStart + gameboxSize;
				int boxYPosStart = y * gameboxSize;
				int boxYPosEnd = boxYPosStart + gameboxSize;
				
				Rect gamebox = new Rect();
				gamebox.set(boxXPosStart, boxYPosStart, boxXPosEnd, boxYPosEnd);
				
				if (gameMap.getLocation(x, y).getMapObject().objectName.equals("Road")) {
					Rect bitMapRect = new Rect();
					bitMapRect.set(0,0,road.getWidth(),road.getHeight());
					canvas.drawBitmap(road, bitMapRect, gamebox, paint);
				} else if (gameMap.getLocation(x, y).getMapObject().objectName.equals("Player")){
					Rect bitMapRect = new Rect();
					bitMapRect.set(0,0,player.getWidth(),player.getHeight());
					canvas.drawBitmap(player, bitMapRect, gamebox, paint);
				} else if (gameMap.getLocation(x, y).getMapObject().objectName.equals("Bomb")){
					Rect bitMapRect = new Rect();
					bitMapRect.set(0,0,bomb.getWidth(),bomb.getHeight());
					canvas.drawBitmap(bomb, bitMapRect, gamebox, paint);
				} else if (gameMap.getLocation(x, y).getMapObject().objectName.equals("Explode")){
					Rect bitMapRect = new Rect();
					bitMapRect.set(0,0,explode.getWidth(),explode.getHeight());
					canvas.drawBitmap(explode, bitMapRect, gamebox, paint);
				} else if (gameMap.getLocation(x, y).getMapObject().objectName.equals("PlayerAndBomb")){
					Rect bitMapRect = new Rect();
					bitMapRect.set(0,0,playerandbomb.getWidth(),playerandbomb.getHeight());
					canvas.drawBitmap(playerandbomb, bitMapRect, gamebox, paint);
				}
				
				
			}
		}
		
		
	}
	
	
}
