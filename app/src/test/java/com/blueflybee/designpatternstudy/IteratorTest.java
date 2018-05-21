package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.iterator.AbstractList;
import com.blueflybee.designpatternstudy.iterator.Employee;
import com.blueflybee.designpatternstudy.iterator.FilterIterator;
import com.blueflybee.designpatternstudy.iterator.InnerIterator;
import com.blueflybee.designpatternstudy.iterator.IterFilter;
import com.blueflybee.designpatternstudy.iterator.Iterator;
import com.blueflybee.designpatternstudy.iterator.List;
import com.blueflybee.designpatternstudy.iterator.ListIterator;
import com.blueflybee.designpatternstudy.iterator.ListTraver;
import com.blueflybee.designpatternstudy.iterator.PrintNEmpIterator;
import com.blueflybee.designpatternstudy.iterator.SkipList;
import com.blueflybee.designpatternstudy.iterator.SkipListIterator;
import com.blueflybee.designpatternstudy.iterator.SkipListTraver;
import com.blueflybee.designpatternstudy.iterator.Traversable;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


/**
 * <pre>
 *     author : shaojun
 *     e-mail : wusj@qtec.cn
 *     time   : 2018/05/04
 *     desc   : Test command design pattern
 *     version: 1.0
 * </pre>
 */
public class IteratorTest {

  @Mock
  private AbstractList<Employee> mList;
  @Mock
  private Employee mEmployee;


  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void list_count_Correct() {

    int count = mList.count();

    verify(mList).count();
    assertEquals(0, count);
  }

  @Test
  public void list_add_Correct() {
    AbstractList<Employee> list = new List<>();
    int count = list.count();

    assertEquals(0, count);

    list.add(mEmployee);

    assertEquals(1, list.count());

  }

  @Test
  public void list_remove_Correct() {
    AbstractList<Employee> list = new List<>();
    int count = list.count();
    assertEquals(0, count);

    list.add(mEmployee);
    assertEquals(1, list.count());

    Employee employee = list.remove(0);
    assertNotNull(employee);
    assertEquals(0, list.count());
  }

  @Test
  public void iterator_moveFirst_Correct() {
    AbstractList<Employee> list = new List<>();
    Iterator<Employee> iterator = list.iterator();
    iterator.first();
    int index = iterator.index();
    assertEquals(0, index);

  }

  @Test
  public void iterator_moveNext_Correct() {
    AbstractList<Employee> list = new List<>();
    list.add(new Employee());
    Iterator<Employee> iterator = list.iterator();
    iterator.first();
    int index = iterator.index();
    assertEquals(0, index);

    iterator.next();
    index = iterator.index();
    assertEquals(1, index);

  }

  @Test
  public void iterator_hasNext_Correct() {
    AbstractList<Employee> list = new List<>();
    list.add(new Employee());
    list.add(new Employee());
    Iterator<Employee> iterator = list.iterator();
    iterator.first();

    assertTrue(iterator.hasNext());

    iterator.next();

    assertTrue(iterator.hasNext());

    iterator.next();

    assertFalse(iterator.hasNext());

  }

  @Test
  public void iterator_currentItem_Correct() {
    AbstractList<Employee> list = new List<>();
    Employee e1 = new Employee("0", "e1");
    list.add(e1);
    list.add(new Employee("1", "e2"));
    list.add(new Employee("2", "e3"));
    list.add(new Employee("3", "e4"));
    list.add(new Employee("4", "e5"));
    Iterator<Employee> iterator = list.iterator();

    for (iterator.first();iterator.hasNext(); iterator.next()) {
      Employee employee = iterator.currentItem();
      assertNotNull(employee);
      System.out.println("currentItem = " + employee);
    }

  }

  @Test
  public void skipList_add_Correct() {
    AbstractList<Employee> list = new SkipList<>();
    int count = list.count();

    assertEquals(0, count);

    list.add(mEmployee);

    assertEquals(1, list.count());
  }

  @Test
  public void skipIterator_moveNext_Correct() {
    AbstractList<Employee> list = new SkipList<>();
    list.add(new Employee());
    Iterator<Employee> iterator = list.iterator();
    assertTrue(iterator instanceof SkipListIterator);
    iterator.first();
    int index = iterator.index();
    assertEquals(0, index);

    iterator.next();
    index = iterator.index();
    assertEquals(1, index);

  }

  @Test
  public void createTraverListIterator_Correct() {
    AbstractList<Employee> list = new List<>();
    list.setTraver(new ListTraver());
    Iterator<Employee> iterator = list.getIterator(list);
    assertTrue(iterator instanceof ListIterator);
  }

  @Test
  public void createTraverSkipListIterator_Correct() {
    AbstractList<Employee> list = new SkipList<>();
    list.setTraver(new SkipListTraver());
    Iterator<Employee> iterator = list.getIterator(list);
    assertTrue(iterator instanceof SkipListIterator);
  }

  @Test
  public void skipIterator_currentItem_Correct() {
    AbstractList<Employee> list = new SkipList<>();
    list.setTraver(new SkipListTraver());
    Employee e1 = new Employee("0", "e0");
    list.add(e1);
    list.add(new Employee("1", "e1"));
    list.add(new Employee("2", "e2"));
    list.add(new Employee("3", "e3"));
    list.add(new Employee("4", "e4"));
    list.add(new Employee("5", "e5"));
    list.add(new Employee("6", "e6"));
    list.add(new Employee("7", "e7"));
    list.add(new Employee("8", "e8"));
    list.add(new Employee("9", "e9"));
    Iterator<Employee> iterator = list.getIterator(list);
    assertTrue(iterator instanceof SkipListIterator);

    for (iterator.first();iterator.hasNext(); iterator.next()) {
      Employee employee = iterator.currentItem();
      assertNotNull(employee);
      System.out.println("currentItem = " + employee);
    }

  }

  @Test
  public void innerIterator_printNEmployee() {
    AbstractList<Employee> list = new List<>();
    list.add(new Employee("0", "e0"));
    list.add(new Employee("1", "e1"));
    list.add(new Employee("2", "e2"));
    list.add(new Employee("3", "e3"));
    list.add(new Employee("4", "e4"));
    list.add(new Employee("5", "e5"));
    list.add(new Employee("6", "e6"));
    list.add(new Employee("7", "e7"));
    list.add(new Employee("8", "e8"));
    list.add(new Employee("9", "e9"));

    list.add(new Employee("10", "e10"));
    list.add(new Employee("11", "e11"));
    list.add(new Employee("12", "e12"));
    list.add(new Employee("13", "e13"));
    list.add(new Employee("14", "e14"));
    list.add(new Employee("15", "e15"));
    InnerIterator<Employee> innerIterator = new PrintNEmpIterator(list, 1);
    boolean result = innerIterator.traverse();
    System.out.println("result = " + result);
  }

  @Test
  public void innerIterator_printFilterEmployee() {
    AbstractList<Employee> list = new List<>();
    list.add(new Employee("0", "e0"));
    list.add(new Employee("1", "e1"));
    list.add(new Employee("2", "e2"));
    list.add(new Employee("3", "e3"));
    list.add(new Employee("4", "e4"));
    list.add(new Employee("5", "e5"));
    list.add(new Employee("6", "e6"));
    list.add(new Employee("7", "e7"));
    list.add(new Employee("8", "e8"));
    list.add(new Employee("9", "e9"));

    list.add(new Employee("10", "e10"));
    list.add(new Employee("11", "e11"));
    list.add(new Employee("12", "e12"));
    list.add(new Employee("13", "e13"));
    list.add(new Employee("14", "e14"));
    list.add(new Employee("15", "e15"));
    InnerIterator<Employee> innerIterator = new FilterIterator(list, new IterFilter<Employee>() {

      @Override
      public boolean correct(Employee employee) {
        return "12".compareToIgnoreCase(employee.getId()) > 0;
      }
    });
    boolean result = innerIterator.traverse();
    System.out.println("result = " + result);
  }
}
