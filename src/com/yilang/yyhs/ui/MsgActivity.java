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
import android.widget.SimpleAdapter;

public class MsgActivity extends Activity {
	private ListView message_list;
	private static final String[] PHONES_PROJECTION = new String[] {
			Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID };
	private static final int PHONES_DISAPLAY_NAME_INDEX = 0;
	private static final int PHONES_NUMBER_INDEX = 1;
	private static final int PHONES_PHOTO_ID_INDEX = 2;
	private static final int PHONES_CONTACT_ID_INDEX = 3;
	private ArrayList<String> mContactsName = new ArrayList<String>();
	private ArrayList<String> mContactsNumber = new ArrayList<String>();
	private ArrayList<Bitmap> mContactsPhoto = new ArrayList<Bitmap>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activiay_msg);
		InitMessage();
	}
	
	// 初始化主界面显示的信息
		private void InitMessage() {
			SimpleAdapter adapter = new SimpleAdapter(this, getdata(),
					R.layout.message_list, new String[] { "photo", "contact",
							"message" }, new int[] { R.id.photo, R.id.contact,
							R.id.message });
			message_list = (ListView) findViewById(R.id.message_list);
			message_list.setAdapter(adapter);
		}

		private List<Map<String, Object>> getdata() {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map;
			GetContacts();
			// just for test
			map = new HashMap<String, Object>();
			map.put("photo", R.drawable.main_footer_forum_nor);
			map.put("contact", "test");
			map.put("message", "test");
			list.add(map);
			for (int i = 0; i < mContactsName.size(); i++) {
				map = new HashMap<String, Object>();
				// System.out.println((String)mContactsName.get(i));
				map.put("photo", R.drawable.main_footer_forum_nor);
				map.put("contact", (String) mContactsName.get(i));
				// map.put("contact", "me");
				map.put("message", "hello");
				list.add(map);
			}
			return list;
		}

		// 获取联系人
		private void GetContacts() {
			ContentResolver resolver = this.getContentResolver();
			Cursor cursor = resolver.query(Phone.CONTENT_URI, PHONES_PROJECTION,
					null, null, null);

			if (cursor != null) {
				while (cursor.moveToNext()) {
					String phoneNumber = cursor.getString(PHONES_NUMBER_INDEX);
					if (TextUtils.isEmpty(phoneNumber))
						continue;
					String contactName = cursor
							.getString(PHONES_DISAPLAY_NAME_INDEX);
					Long contactId = cursor.getLong(PHONES_CONTACT_ID_INDEX);
					Long photoId = cursor.getLong(PHONES_PHOTO_ID_INDEX);
					Bitmap contactPhoto = null;
					if (photoId > 0) {
						Uri uri = ContentUris.withAppendedId(
								ContactsContract.Contacts.CONTENT_URI, contactId);
						InputStream input = ContactsContract.Contacts
								.openContactPhotoInputStream(resolver, uri);
						contactPhoto = BitmapFactory.decodeStream(input);
					} else {
						contactPhoto = BitmapFactory.decodeResource(getResources(),
								R.drawable.ic_launcher);
					}
					mContactsName.add(contactName);
				}
				cursor.close();
			}
		}
}