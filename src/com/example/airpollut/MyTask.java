package com.example.airpollut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class MyTask extends AsyncTask<Void, Integer, String> {
	Context context;
	public static String x = "none";
	ProgressDialog progressDialog;
	

	MyTask(Context context) {
		this.context = context;

	}

	@Override
	protected String doInBackground(Void... params) {
		int i = 0;
		synchronized (this) {
			Log.d(MainActivity.DEBUGTAG, "Loading data");
			
			URL url = null;
			
			String poll = null;
			InputStream is = null;
			try {
				Log.d(MainActivity.DEBUGTAG, "krok1");
				url = new URL("https://salty-plains-87444.herokuapp.com/SendDataToAndroid");
				Log.d(MainActivity.DEBUGTAG, "krok2");
				is = url.openStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				Log.d(MainActivity.DEBUGTAG, "krok3");
				poll = br.readLine();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			

			
		
			Log.d(MainActivity.DEBUGTAG, poll);
			x=poll;
			while (i < 10) {
				try {
					wait(700);
					i++;
					publishProgress(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return "Loading completed";
	}

	@Override
	protected void onPreExecute() {
		progressDialog = new ProgressDialog(context);
		progressDialog.setTitle("Pobieram ostatni odczyt");
		progressDialog.setMax(10);
		progressDialog.setProgress(0);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.show();

	}

	@Override
	protected void onPostExecute(String result) {
		
		progressDialog.hide();
		//textView = (TextView) findViewById(R.id.text);
		//textView.setText(myTask.x);
		
		 
		        TextView textView = (TextView) ((MainActivity)context).findViewById(R.id.text);
		        textView.setText("Aktualny poziom py³u zawieszonego PM10 wynosi: "+x+" ug/m3");
		
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		int progress = values[0];
		progressDialog.setProgress(progress);

		// textView.setText("Loading...");
	}

}
