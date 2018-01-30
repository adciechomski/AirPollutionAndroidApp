package com.example.airpollut;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Guzik extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.guzik,container, false);
		
		Button button = (Button) view.findViewById(R.id.loaded);
		
		
			//Button loadedBtn = (Button)findViewById(R.id.loaded);
			
			button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					
					//MyTask myTask = new MyTask(MainActivity.this);
					//myTask.execute();
					
					
				}
			});
			
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
