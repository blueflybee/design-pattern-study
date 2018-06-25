package com.blueflybee.designpatternstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.blueflybee.designpatternstudy.abstractfactory.AbstractFactoryActivity;
import com.blueflybee.designpatternstudy.adapter.AdapterActivity;
import com.blueflybee.designpatternstudy.bridge.BridgeActivity;
import com.blueflybee.designpatternstudy.builder.BuilderActivity;
import com.blueflybee.designpatternstudy.chainofresponsibility.ChainOfResponsibilityActivity;
import com.blueflybee.designpatternstudy.command.CommandActivity;
import com.blueflybee.designpatternstudy.composite.CompositeActivity;
import com.blueflybee.designpatternstudy.decorator.DecoratorActivity;
import com.blueflybee.designpatternstudy.facade.FacadeActivity;
import com.blueflybee.designpatternstudy.flyweight.FlyweightActivity;
import com.blueflybee.designpatternstudy.interpreter.InterpreterActivity;
import com.blueflybee.designpatternstudy.mediator.MediatorActivity;
import com.blueflybee.designpatternstudy.memento.MementoActivity;
import com.blueflybee.designpatternstudy.observer.ObserverActivity;
import com.blueflybee.designpatternstudy.proxy.ProxyActivity;
import com.blueflybee.designpatternstudy.state.StateActivity;
import com.blueflybee.designpatternstudy.strategy.StrategyActivity;
import com.blueflybee.designpatternstudy.templatemethod.TemplateMethodActivity;
import com.blueflybee.designpatternstudy.visitor.VisitorActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] titles = {
        "1、职责链模式（Chain of responsibility 对象行为）",
        "2、命令模式（Command 对象行为）",
        "3、解释器模式（Interpreter 对象行为）",
        "4、迭代器模式（Iterator 对象行为）",
        "5、中介者模式（Mediator 对象行为）",
        "6、备忘录模式（Memento 对象行为）",
        "7、观察者模式（Observer 对象行为）",
        "8、状态模式（State 对象行为）",
        "9、策略模式（Strategy 对象行为）",
        "10、模板方法（Template method 类行为）",
        "11、访问者模式（Visitor 对象行为）",
        "12、适配器模式（Adapter 类&对象结构）",
        "13、桥接模式（Bridge 对象结构）",
        "14、组合模式（Composite 对象结构）",
        "15、装饰模式（Decorator 对象结构）",
        "16、外观模式（Facade 对象结构）",
        "17、享元模式（Flyweight 对象结构）",
        "18、代理模式（Proxy 对象结构）",
        "19、抽象工厂模式（Abstract factory 对象创建）",
        "20、生成器模式（Builder 对象创建）",
    };
    ListView listView = findViewById(R.id.list);
    listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles));
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = null;
        switch (position) {
          case 0:
            intent = new Intent(MainActivity.this, ChainOfResponsibilityActivity.class);
            break;

          case 1:
            intent = new Intent(MainActivity.this, CommandActivity.class);
            break;

          case 2:
            intent = new Intent(MainActivity.this, InterpreterActivity.class);
            break;

          case 3:
            intent = new Intent(MainActivity.this, InterpreterActivity.class);
            break;

          case 4:
            intent = new Intent(MainActivity.this, MediatorActivity.class);
            break;

          case 5:
            intent = new Intent(MainActivity.this, MementoActivity.class);
            break;

          case 6:
            intent = new Intent(MainActivity.this, ObserverActivity.class);
            break;

          case 7:
            intent = new Intent(MainActivity.this, StateActivity.class);
            break;

          case 8:
            intent = new Intent(MainActivity.this, StrategyActivity.class);
            break;

          case 9:
            intent = new Intent(MainActivity.this, TemplateMethodActivity.class);
            break;

          case 10:
            intent = new Intent(MainActivity.this, VisitorActivity.class);
            break;

          case 11:
            intent = new Intent(MainActivity.this, AdapterActivity.class);
            break;

          case 12:
            intent = new Intent(MainActivity.this, BridgeActivity.class);
            break;

          case 13:
            intent = new Intent(MainActivity.this, CompositeActivity.class);
            break;

          case 14:
            intent = new Intent(MainActivity.this, DecoratorActivity.class);
            break;

          case 15:
            intent = new Intent(MainActivity.this, FacadeActivity.class);
            break;

          case 16:
            intent = new Intent(MainActivity.this, FlyweightActivity.class);
            break;

          case 17:
            intent = new Intent(MainActivity.this, ProxyActivity.class);
            break;

          case 18:
            intent = new Intent(MainActivity.this, AbstractFactoryActivity.class);
            break;
          case 19:
            intent = new Intent(MainActivity.this, BuilderActivity.class);
            break;


          default:
            break;
        }
        startActivity(intent);

      }
    });


  }
}
