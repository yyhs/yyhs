package com.yilang.yyhs.ui;

import com.yilang.yyhs.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	private RadioGroup footer;
	private RadioButton footer_forum, footer_region, footer_user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		InitRaidButton();
		
	}	
	
	private void InitRaidButton() {
		footer=(RadioGroup)findViewById(R.id.main_footer);
		footer_forum=(RadioButton)findViewById(R.id.main_footer_forum);
		footer_region=(RadioButton)findViewById(R.id.main_footer_user);
		footer_user=(RadioButton)findViewById(R.id.main_footer_user);
		footer.setOnCheckedChangeListener(new OnCheckedChangeListener());
	}
	//RaidButtonµÄ¼àÌý
	public class OnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
		 public void onCheckedChanged(RadioGroup group, int checkedId) {
			 int id=footer.getCheckedRadioButtonId();
			 
			 Toast.makeText(MainActivity.this,String.valueOf(id),Toast.LENGTH_SHORT).show();
		}
	}
}
