package com.crazzy.junit.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Slf4j
public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size() {

        when(mock.size()).thenReturn(5);

        assertEquals(5, mock.size());
    }

    @Test
    public void sizeMulti() {

        when(mock.size()).thenReturn(5).thenReturn(10);

        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void withParam() {

        when(mock.get(0)).thenReturn("rahul");

        assertEquals("rahul", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void withAnyParam() {

        when(mock.get(anyInt())).thenReturn("rahul");

        assertEquals("rahul", mock.get(0));
        assertEquals("rahul", mock.get(1));
    }

    @Test
    public void verificationTest() {

        String val1 = mock.get(0);
        String val2 = mock.get(1);

        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {

        mock.add("something");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("something", captor.getValue());
    }

    @Test
    public void multiArgumentCapturing() {
        mock.add("something1");
        mock.add("something2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("something1", allValues.get(0));
        assertEquals("something2", allValues.get(1));
    }

    @Test
    public void spyingInstedMocking() {
        ArrayList list = spy(ArrayList.class);

        list.add("something1");
        log.info(String.valueOf(list.get(0)));
        log.info(String.valueOf(list.size()));

        list.add("something2");
        list.add("something3");
        log.info(String.valueOf(list.size()));

        when(list.size()).thenReturn(5);
        log.info(String.valueOf(list.size()));

        list.add("something4");
        log.info(String.valueOf(list.size()));

        verify(list).add("something4");


    }

}
