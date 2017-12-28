package com.tiensin.ideaplan;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    private Toolbar toolbar;
    private ViewPager viewPager;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = this;
        //去掉默认的actionBar显示
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//targetSDK > 21 use
        requestWindowFeature(Window.FEATURE_NO_TITLE);//targetSDK<21 use
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbarID);
        //viewPager = (ViewPager)findViewById(R.id.viewPager);
        setToolbar();

    }

    /*添加绑定menu的方法二*/
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }*/

    public void setToolbar() {
//        setSupportActionBar(toolbar);//添加绑定menu的方法二
        ToolbarMenuListener toolbarMenuListener = new ToolbarMenuListener();
        toolbar.setNavigationIcon(R.drawable.users24);
        toolbar.inflateMenu(R.menu.toolbar_menu);//添加绑定menu的方法一
        toolbar.setOnMenuItemClickListener(toolbarMenuListener);
    }

    class ToolbarMenuListener implements Toolbar.OnMenuItemClickListener{
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Log.d(TAG,"toolbar_menu_message isCheck="+ item.getItemId() );
            if(item.getItemId() == R.id.toolbar_menu_message)
            {
                Log.d(TAG,"toolbar_menu_message isCheck="+ item.isChecked());
            }else if(item.getItemId() == R.id.toolbar_menu_test)
            {
                Log.d(TAG,"toolbar_menu_test is clicked");
            }
            return true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
