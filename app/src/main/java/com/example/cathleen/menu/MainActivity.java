package com.example.cathleen.menu;
/**
 * 选项菜单
 * 在menu_main中添加选项
 * 在onOptionsItemSelected中添加单击事件
 *
 * 上下文菜单
 * 在onCreate中注册菜单
 * 创建onCreateContextMenu
 *
 * 弹出菜单
 * 在指定组件上添加onClick方法，在MainActivity中添加方法
 *
 * ???如何显示指定菜单
 * 分Menu文件写
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    TextView longMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        longMe = (TextView) findViewById(R.id.longMe);
        registerForContextMenu(longMe);

    }

    //选项菜单
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
        switch (id) {
            case R.id.option1:
                Toast.makeText(MainActivity.this, "option1 is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.option2:
                Toast.makeText(MainActivity.this, "option2 is clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.long1:
                Toast.makeText(MainActivity.this, "context 上下文1 is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.long2:
                Toast.makeText(MainActivity.this, "context 上下文2 is clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    //弹出菜单
    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.pop_menu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.pop1:
                Toast.makeText(MainActivity.this, "popMenu1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pop2:
                Toast.makeText(MainActivity.this, "popMenu2", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
