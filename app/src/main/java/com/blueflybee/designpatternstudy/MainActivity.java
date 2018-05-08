package com.blueflybee.designpatternstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.blueflybee.designpatternstudy.chainofresponsibility.ChainOfResponsibilityActivity;
import com.blueflybee.designpatternstudy.command.CommandActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] titles = {
        "1、职责链模式（Chain of responsibility）",
        "2、命令模式（Command）",
//        "仿支付宝首页自定义菜单",
    };
    ListView listView = findViewById(R.id.list);
    listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
          case 0:
            Intent intent0 = new Intent(MainActivity.this, ChainOfResponsibilityActivity.class);
            startActivity(intent0);
            break;

          case 1:
            Intent intent1 = new Intent(MainActivity.this, CommandActivity.class);
            startActivity(intent1);
            break;
//
//          case 2:
//            Intent intent2 = new Intent(MainActivity.this, AlipayActivity.class);
//            startActivity(intent2);
//            break;

          default:
            break;
        }

      }
    });


  }
}
