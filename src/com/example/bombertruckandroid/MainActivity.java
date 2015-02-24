package com.example.bombertruckandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	
	ClientConnector cc;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button buttonUp = (Button)findViewById(R.id.buttonUp);
        buttonUp.setOnTouchListener(new View.OnTouchListener() {
        	
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					ClientConnector.upButtonPressed = true;
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					ClientConnector.upButtonPressed = false;
					return true;
				}
				
				
				return false;
			}
        });
        
        Button buttonDown = (Button)findViewById(R.id.buttonDown);
        buttonDown.setOnTouchListener(new View.OnTouchListener() {
        	
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					ClientConnector.downButtonPressed = true;
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					ClientConnector.downButtonPressed = false;
					return true;
				}
				
				
				return false;
			}
        });
        
        Button buttonLeft = (Button)findViewById(R.id.buttonLeft);
        buttonLeft.setOnTouchListener(new View.OnTouchListener() {
        	
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					ClientConnector.leftButtonPressed = true;
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					ClientConnector.leftButtonPressed = false;
					return true;
				}
				
				
				return false;
			}
        });
        
        Button buttonRight = (Button)findViewById(R.id.buttonRight);
        buttonRight.setOnTouchListener(new View.OnTouchListener() {
        	
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					ClientConnector.rightButtonPressed = true;
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					ClientConnector.rightButtonPressed = false;
					return true;
				}
				
				
				return false;
			}
        });
        
        Button buttonBomb = (Button)findViewById(R.id.buttonBomb);
        buttonBomb.setOnTouchListener(new View.OnTouchListener() {
        	
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					ClientConnector.bombButtonPressed = true;
					return true;
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					ClientConnector.bombButtonPressed = false;
					return true;
				}
				
				
				return false;
			}
        });
        
        
    }


 


	
	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
		
		cc = new ClientConnector();
		cc.start();
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		cc.end();
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
