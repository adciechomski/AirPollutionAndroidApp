package com.example.airpollut;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment1 extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
		View view = inflater.inflate(R.layout.fragmentmain,container, false);
	
		ImageView imageView = (ImageView)view.findViewById(R.id.image);
		TextView titleView = (TextView)view.findViewById(R.id.title);
		
		Drawable icon = getResources().getDrawable(R.drawable.kwiatek);
		imageView.setImageDrawable(icon);
		titleView.setText("Cos tam");
		
		
		
				
		return view;
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
