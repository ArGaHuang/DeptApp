package com.example.news1260.deptapp;

import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private Button button;
    private static final int REQUEST_CODE_CAMERA = 2;
    private DBHelper dbhelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper = new DBHelper(this); //執行Helper類,會建立demo資料庫，和有三個欄位NAME、TEL、EMAIL 的 friends 資料表 .
        dbhelper.close();

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(listenner);


    }


    private void goToCamera() {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Button.OnClickListener listenner = new Button.OnClickListener() { //activity切換
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Add_dept.class);
            startActivity(intent);
            finish();

        }
    };
}
