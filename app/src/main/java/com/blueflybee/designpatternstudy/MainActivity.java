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
import com.blueflybee.designpatternstudy.interpreter.InterpreterActivity;
import com.blueflybee.designpatternstudy.mediator.TestMediatorActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] titles = {
        "1、职责链模式（Chain of responsibility）",
        "2、命令模式（Command）",
        "3、解释器模式（Interpreter）",
        "4、迭代器模式（Iterator）",
        "5、中介者模式（Mediator）",
    };
    ListView listView = findViewById(R.id.list);
    listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent;
        switch (position) {
          case 0:
            intent = new Intent(MainActivity.this, ChainOfResponsibilityActivity.class);
            startActivity(intent);
            break;

          case 1:
            intent = new Intent(MainActivity.this, CommandActivity.class);
            startActivity(intent);
            break;

          case 2:
            intent = new Intent(MainActivity.this, InterpreterActivity.class);
            startActivity(intent);
            break;

          case 3:
            intent = new Intent(MainActivity.this, InterpreterActivity.class);
            startActivity(intent);
            break;

          case 4:
            intent = new Intent(MainActivity.this, TestMediatorActivity.class);
            startActivity(intent);
            break;

          default:
            break;
        }

      }
    });


  }
}
