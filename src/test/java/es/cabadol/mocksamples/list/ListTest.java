package es.cabadol.mocksamples.list;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Test for {@link java.util.List}
 *
 * @author cbadenes@gmail.com (Carlos Badenes)
 *
 */
public class ListTest {


    public void before(){

    }

    @Test
    public void verifyInteractions(){
        // mock creation
        List mockedList = mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();

        Assert.assertEquals(0,mockedList.size());

    }


    @Test
    public void stubMethodCalls(){
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");

        // the following prints "first"
        System.out.println(mockedList.get(0));

        // the following prints "null" because get(999) was not subbed
        System.out.println(mockedList.get(999));
    }

    @Test
    @Ignore
    public void methodIgnored(){

    }

}
