package com.example.airpollut;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import android.util.Log;

public class DownloadData extends Thread{
	public String poll;

	String downloadHTML() throws Exception{
		//String line;
		Log.d(MainActivity.DEBUGTAG, "Loading data");
		String id = "1234";
		URL url = new URL("https://salty-plains-87444.herokuapp.com/SendDataToAndroid");
		
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		
	poll = br.readLine();
			Log.d(MainActivity.DEBUGTAG, poll);
			
	return poll;
	
		
		
	}
	
}
