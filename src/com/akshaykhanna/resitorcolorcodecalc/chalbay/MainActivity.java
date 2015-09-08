package com.akshaykhanna.resitorcolorcodecalc.chalbay;



import com.akshaykhanna.resitorcolorcodecalc.chalbay.R;
import com.searchboxsdk.android.StartAppSearch;
import com.startapp.android.publish.StartAppAd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemSelectedListener
{

	private StartAppAd startAppAd = new StartAppAd(this);
	Spinner sp1, sp2, sp3,sp4;//Drop down list
	int b=0,a=0,p,pt=0;
	long c=1;
	double r=0;
	String color[]={"Black","Brown","Red","Orange","Yellow","Green" ,"Blue","Voilet","Grey","White"};
	String color3[]={"Black","Brown","Red","Orange","Yellow","Green" ,"Blue","Voilet","Grey"};
	String tolerance[]={"None","Gold","Silver"};
	String t[]={"20%","5%","10%"};
	String unit,value,store;
	
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StartAppSearch.showSearchBox(this);
		
		intialise();
		
		//Declaration of spinner or drop down list
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,color);
		sp1.setAdapter(adapter);
		sp1.setOnItemSelectedListener(this);
		sp2.setAdapter(adapter);
		sp2.setOnItemSelectedListener(this);
		ArrayAdapter<String> adapter3=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,color);
		sp3.setAdapter(adapter3);
		sp3.setOnItemSelectedListener(this);
		ArrayAdapter<String> adapter2=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,tolerance);
		sp4.setAdapter(adapter2);
		sp4.setOnItemSelectedListener(this);
		
		
	}

	private void intialise() 
	{
		// TODO Auto-generated method stub
		sp1=(Spinner)findViewById(R.id.spinner1);
		sp2=(Spinner)findViewById(R.id.spinner2);
		sp3=(Spinner)findViewById(R.id.spinner3);
		sp4=(Spinner)findViewById(R.id.spinner4);
		
		tv=(TextView)findViewById(R.id.tvValue);
		
	}

	

	@Override
	public void onItemSelected(AdapterView<?> arg0, View view, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId())
		{
		case R.id.spinner1:
			p=sp1.getSelectedItemPosition();
			a=10*p;
			String d=Integer.toString(p);
			
			break;
		case R.id.spinner2:
		p=sp2.getSelectedItemPosition();
		b=p;
		
		break;
		case R.id.spinner3:
		p=sp3.getSelectedItemPosition();
		c=(long) Math.pow(10, p);
		
		break;
		case R.id.spinner4:
			
			pt=sp4.getSelectedItemPosition();
			break;
		}
		
		//Calculating final resistor value and choosing respective unit
		r=(a+b)*c;
		if(r<1000)
			unit="ohm";
		else if(r>=1000&&r<1000000)
			{
			unit="Kohm";
			r=r/1000;
			}
		else if(r>=1000000&&r<Math.pow(10, 9))
			{
			unit="Mohm";
			r=r/1000000;
			}
		else
		{
			unit="Gohm";
			r=r/Math.pow(10, 9);
		}
		value=r+unit+", "+t[pt];
			tv.setText(value);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu)

	{
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater capactiveButtonMenu=getMenuInflater();
	    capactiveButtonMenu.inflate(R.menu.avant_grade_menu, menu);
	    return true;
	    
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.credits:
			Intent about=new Intent("com.akshaykhanna.resitorcolorcodecalc.chalbay.ABOUTUS");
			startActivity(about);
			break;
		
		case R.id.Exit:
			finish();
			break;
		}
		return false;
		
	}
	@Override
	public void onResume(){
	super.onResume();
	startAppAd.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		startAppAd.onPause();
		finish();
	}
	
	
	
}
