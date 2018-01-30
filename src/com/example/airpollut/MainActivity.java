package com.example.airpollut;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

//import com.example.kjhjkh.R;

//import com.example.kjhjkh.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {
	public TextView textView;
	String line = null;
	//TextView textView;
	
	public static final String DEBUGTAG = "blad";
	public static final String TEXTFILE = "plik.txt";
	public static final String FILESAVED = "FileSaved";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//textView = (TextView)findViewById(android.R.id.textView);

		

		
		
		//addLoadButtonListener();
		addLoadedButtonListener();
	}
	
	private void addLoadButtonListener() {
		Button loadBtn = (Button)findViewById(R.id.loaded);
		
		loadBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				new AsyncTask<Void,Void,String>(){

					protected String doInBackground(Void... params) {
						String level = null;
						try {
							Log.d(DEBUGTAG, "Click");
							level = DownloadHTML();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Log.d(DEBUGTAG, "mpppppppp");
						}
						Log.d(DEBUGTAG, "mpppppppp" + level);
						return level;
					}
					
				}.execute();
				
				
			}
		});
		
	}
	
	private void addLoadedButtonListener() {
		Button loadedBtn = (Button)findViewById(R.id.loaded);
		
		loadedBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				MyTask myTask = new MyTask(MainActivity.this);
				myTask.execute();
				
				
			}
		});
		
	}
	
	private String DownloadHTML() throws Exception{
		Log.d(DEBUGTAG, "Loading data");
		String id = "1234";
		URL url = new URL("https://salty-plains-87444.herokuapp.com/SendDataToAndroid");
		
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		
	line = br.readLine();
			Log.d(DEBUGTAG, line);
			
	return line;
	}
	
	public void display(String x){
		
		
		textView = (TextView) findViewById(R.id.text);
		textView.setText(x);
	}
		
		
	
}
