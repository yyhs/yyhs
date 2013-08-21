package com.yilang.yyhs.ui;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yilang.yyhs.R;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Photo;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	private RadioGroup footer;
	private RadioButton footer_forum, footer_region, footer_user;
	private ListView message_list;
	Context mContext=null;
	private static final String[] PHONES_PROJECTION=new String[]{
		Phone.DISPLAY_NAME,Phone.NUMBER,Photo.PHOTO_ID,Phone.CONTACT_ID};
	private static final int PHONES_DISAPLAY_NAME_INDEX=0;
	private static final int PHONES_NUMBER_INDEX=1;
	private static final int PHONES_PHOTO_ID_INDEX=2;
	private static final int PHONES_CONTACT_ID_INDEX=3;
	private ArrayList<String> mContactsName=new ArrayList<String>();
	private ArrayList<String> mContactsNumber=new ArrayList<String>();
	private ArrayList<Bitmap> mContactsPhoto=new ArrayList<Bitmap>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext=this;
		setContentView(R.layout.activity_main);
		InitRaidButton();
		InitMessage();		
	}	
	
	//初始化主界面显示的信息
	private void InitMessage() {
		SimpleAdapter adapter=new SimpleAdapter(this,getdata(),R.layout.message_list,
				new String[]{"photo","contact","message"},
				new int[]{R.id.photo,R.id.contact,R.id.message});
		message_list=(ListView)findViewById(R.id.message_list);
		message_list.setAdapter(adapter);
	}
	private List<Map<String,Object>> getdata() {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Map<String,Object> map;
		GetContacts();
		
		for(int i=0;i<mContactsName.size();i++){ 
			map=new HashMap<String,Object>();
//			System.out.println((String)mContactsName.get(i));
			map.put("photo", R.drawable.main_footer_forum_nor);
			map.put("contact", (String)mContactsName.get(i));
			//map.put("contact", "me");
			map.put("message","hello");
			list.add(map);
		} 
		return list;
	}
	//获取联系人
	private void GetContacts() {
		ContentResolver resolver=mContext.getContentResolver();
		Cursor cursor=resolver.query(Phone.CONTENT_URI, PHONES_PROJECTION,null,null,null);
		
		if(cursor!=null){
			while(cursor.moveToNext()){
				String phoneNumber=cursor.getString(PHONES_NUMBER_INDEX);
				if(TextUtils.isEmpty(phoneNumber)) continue;
				String contactName=cursor.getString(PHONES_DISAPLAY_NAME_INDEX);
				Long contactId=cursor.getLong(PHONES_CONTACT_ID_INDEX);
				Long photoId=cursor.getLong(PHONES_PHOTO_ID_INDEX);
				Bitmap contactPhoto=null;
				if(photoId>0){
					Uri uri=ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,contactId);
					InputStream input=ContactsContract.Contacts.openContactPhotoInputStream(resolver,uri);
					contactPhoto=BitmapFactory.decodeStream(input);
				}else {
					contactPhoto=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
				}
				mContactsName.add(contactName);
			}
			cursor.close();
		}
	}
	
	private void InitRaidButton() {
		footer=(RadioGroup)findViewById(R.id.main_footer);
		footer_forum=(RadioButton)findViewById(R.id.main_footer_forum);
		footer_region=(RadioButton)findViewById(R.id.main_footer_region);
		footer_user=(RadioButton)findViewById(R.id.main_footer_user);
		footer.setOnCheckedChangeListener(new OnCheckedChangeListener());
	}
	//RaidButton的监听
	public class OnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
		 public void onCheckedChanged(RadioGroup group, int checkedId) {
			 int id=footer.getCheckedRadioButtonId();
			 
			 Toast.makeText(MainActivity.this,String.valueOf(id),Toast.LENGTH_SHORT).show();
		}
	}
}
