package com.yilang.yyhs.ui;

import com.yilang.yyhs.R;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;  
import android.os.Bundle;  
import android.widget.CompoundButton;  
import android.widget.RadioButton;  
import android.widget.CompoundButton.OnCheckedChangeListener;  
import android.widget.RadioGroup;
import android.widget.TabHost;  
import android.widget.Toast;


public class MainActivity extends TabActivity  implements OnCheckedChangeListener {
	private RadioGroup footer;
	private RadioButton footer_forum, footer_region, footer_user;
//	private ListView message_list;

	private TabHost mTabHost;
	private Intent msgIntent;
	private Intent setupIntent;

	Context mContext = null;
	// final LayoutInflater inflater=null;
	// final LinearLayout init_lin=(LinearLayout)findViewById(R.id.lin_main);
	/*private static final String[] PHONES_PROJECTION = new String[] {
			Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID };
	private static final int PHONES_DISAPLAY_NAME_INDEX = 0;
	private static final int PHONES_NUMBER_INDEX = 1;
	private static final int PHONES_PHOTO_ID_INDEX = 2;
	private static final int PHONES_CONTACT_ID_INDEX = 3;
	private ArrayList<String> mContactsName = new ArrayList<String>();
	private ArrayList<String> mContactsNumber = new ArrayList<String>();
	private ArrayList<Bitmap> mContactsPhoto = new ArrayList<Bitmap>();
*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// final LayoutInflater inflater=LayoutInflater.from(this) ;
		// final LinearLayout
		// init_lin=(LinearLayout)findViewById(R.id.lin_main);
		mContext = this;
		
		setContentView(R.layout.activity_main);
		
		this.msgIntent = new Intent(this, MsgActivity.class);
		this.setupIntent = new Intent(this, SetupActivity.class);
		//InitIntent();
		System.out.println("2");
		footer = (RadioGroup) findViewById(R.id.main_footer);
		footer_forum = (RadioButton) findViewById(R.id.main_footer_forum);
		footer_region = (RadioButton) findViewById(R.id.main_footer_region);
		footer_user = (RadioButton) findViewById(R.id.main_footer_user);
		footer_forum.setOnCheckedChangeListener(this);
		footer_region.setOnCheckedChangeListener(this);
		footer_user.setOnCheckedChangeListener(this);
		//footer.setOnCheckedChangeListener(new OnCheckedChangeListener());
		//InitRaidButton();
		System.out.println("3");
		setupIntent();
		System.out.println("4");
		//InitMessage();
		System.out.println("5");
	}

	private void InitIntent() {
		this.msgIntent = new Intent(this, MsgActivity.class);
		this.setupIntent = new Intent(this, SetupActivity.class);
	}

	

	private void InitRaidButton() {
		footer = (RadioGroup) findViewById(R.id.main_footer);
		footer_forum = (RadioButton) findViewById(R.id.main_footer_forum);
		footer_region = (RadioButton) findViewById(R.id.main_footer_region);
		footer_user = (RadioButton) findViewById(R.id.main_footer_user);
		//footer.setOnCheckedChangeListener(new OnCheckedChangeListener());
	}
	
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
            case R.id.main_footer_forum:
                this.mTabHost.setCurrentTabByTag("msg_tab");
                break;
            case R.id.main_footer_region:
            	Toast.makeText(MainActivity.this, String.valueOf(R.id.main_footer_region),Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_footer_user:
                this.mTabHost.setCurrentTabByTag("setup_tab");
                break;
            }
        }
    }
	// RaidButtonµÄ¼àÌý
//	public class OnCheckedChangeListener implements
//			RadioGroup.OnCheckedChangeListener {
//		public void onCheckedChanged(RadioGroup group, int checkedId) {
//			// LayoutInflater inflater=LayoutInflater.from(mContext);
//			// LinearLayout
//			// init_lin=(LinearLayout)findViewById(R.id.lin_chnage);
//			int id = footer.getCheckedRadioButtonId();
//			switch (id) {
//			case R.id.main_footer_forum:
//				mTabHost.setCurrentTabByTag("msg_tab");
//				// LinearLayout list_lin=(LinearLayout) inflater.inflate(
//				// R.layout.main_list, null).findViewById(R.id.main_list);
//				// ListView lv=(ListView)list_lin.getChildAt(0);
//				// init_lin.removeAllViews();
//				// init_lin.addView(list_lin);
//				break;
//			case R.id.main_footer_region:
//				break;
//			case R.id.main_footer_user:
//				mTabHost.setCurrentTabByTag("setup_tab");
//				// LinearLayout setup_lin=(LinearLayout) inflater.inflate(
//				// R.layout.setup_list, null).findViewById(R.id.setup_list);
//				// TextView tv=(TextView)setup_lin.getChildAt(0);
//				// init_lin.removeAllViews();
//				// init_lin.addView(setup_lin);
//
//				break;
//			}
//
//			Toast.makeText(MainActivity.this, String.valueOf(id),
//					Toast.LENGTH_SHORT).show();
//		}
//	}

	private void setupIntent() {
		
		this.mTabHost = getTabHost();
		//this.mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		//this.mTabHost.setup();
       // TabHost localTabHost = this.mTabHost;
        //localTabHost.setup();
		System.out.println("1+++");
		mTabHost.addTab(buildTabSpec("msg_tab", R.string.main_message,
				R.drawable.main_footer_forum_over, this.msgIntent));
		System.out.println("===");
		mTabHost.addTab(buildTabSpec("setup_tab", R.string.main_setup,
				R.drawable.main_footer_user_nor, this.setupIntent));
		System.out.println("1..1");
	}

	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		System.out.println(tag+"aa"+resLabel+"bb"+resIcon);
		return this.mTabHost.newTabSpec(tag).setIndicator(getString(resLabel),
						getResources().getDrawable(resIcon)).setContent(content);
	}
}
