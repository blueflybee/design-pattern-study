package com.blueflybee.designpatternstudy;

import com.blueflybee.designpatternstudy.iterator.AbstractList;
import com.blueflybee.designpatternstudy.iterator.Employee;
import com.blueflybee.designpatternstudy.iterator.Iterator;
import com.blueflybee.designpatternstudy.iterator.List;

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

}
