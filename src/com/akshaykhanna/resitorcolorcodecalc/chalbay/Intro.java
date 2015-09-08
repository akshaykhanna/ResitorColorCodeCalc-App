package com.akshaykhanna.resitorcolorcodecalc.chalbay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.searchboxsdk.android.StartAppSearch;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.splash.SplashConfig;

public class Intro extends Activity 
{

	
	
	
	private StartAppAd startAppAd = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		StartAppAd.init(this, "108700521", "208306621");
		StartAppSearch.init(this, "108700521", "208306621");
		
		StartAppAd.showSplash(this, savedInstanceState, 
				new SplashConfig()
				.setTheme(SplashConfig.Theme.ASHEN_SKY )  // using the "BLAZE" theme
				.setLogo(R.drawable.ic_launcher)  // resource ID
				);
				
		setContentView(R.layout.intro);
		
		
		
		
		
		
		
		
		Thread timer= new Thread()
		{

			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				
				try
				{
					sleep(2700);
					
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
					
				}
				finally
				{
					Intent sta2= new Intent("com.akshaykhanna.resitorcolorcodecalc.chalbay.MAINACTIVITY");
					startActivity(sta2);
					
				}
			
				
				
			}
		
		};
		timer.start();
		
		
		
		
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
		
		
	}
	

}
