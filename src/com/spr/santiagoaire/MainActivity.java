package com.spr.santiagoaire;


 

 
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import  android.support.v7.widget.Toolbar;
 

public class MainActivity extends  Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		 
		 
				toolbar.setTitle("Santiago Aire");
				toolbar.setLogo(R.drawable.ic_launcher);
				
	 
				toolbar.inflateMenu(R.menu.main);

				toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem menuItem) {

						String link = "https://play.google.com/store/apps/details?id=com.spr.santiagoaire";
							
						
						switch (menuItem.getItemId()) {
						case R.id.sobre:
							// Toast.makeText(ToolbarActivity.this,"Share",Toast.LENGTH_SHORT).show();

							String url = "http://southernpacificreview.com/2014/05/23/santiago-air-quality-pm-2-5/";
							Intent i = new Intent(Intent.ACTION_VIEW);
							i.setData(Uri.parse(url));
							startActivity(i);
						case R.id.action_share:	
							Intent sharingIntent = new Intent(
									android.content.Intent.ACTION_SEND);
							sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
									"Calidad del Aire Santiago");
							sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,
									link);
							sharingIntent.setType("text/plain");
							startActivity(Intent.createChooser(sharingIntent,
									"compartir via"));

						 
						}

						return false;
					}
				});
 
		
		WebView myWebView = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = myWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		myWebView.loadUrl("http://southernpacificreview.com/js/airquality.html");
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
		if (id == R.id.sobre) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
