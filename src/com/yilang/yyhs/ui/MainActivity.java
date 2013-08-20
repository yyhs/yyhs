package com.yilang.yyhs.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yilang.yyhs.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	private RadioGroup footer;
	private RadioButton footer_forum, footer_region, footer_user;
	private ListView message_list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		InitRaidButton();
		SimpleAdapter adapter=new SimpleAdapter(this,getdata(),R.layout.message_list,
				new String[]{"photo","contact","message"},
				new int[]{R.id.photo,R.id.contact,R.id.message});
		message_list=(ListView)findViewById(R.id.message_list);
		message_list.setAdapter(adapter);
		
	}	
	private List<Map<String,Object>> getdata() {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("photo", R.drawable.main_footer_forum_nor);
		map.put("contact", "me");
		map.put("message","hello");
		list.add(map);
		return list;
	}
	
	private void InitRaidButton() {
		footer=(RadioGroup)findViewById(R.id.main_footer);
		footer_forum=(RadioButton)findViewById(R.id.main_footer_forum);
		footer_region=(RadioButton)findViewById(R.id.main_footer_region);
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
