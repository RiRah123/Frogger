package com.example.s2;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;



import org.junit.Test;

public class MainActivity4Test {

    @Test
    public void testOpenActivity2() {
        MainActivity4 activity = mock(MainActivity4.class);
        doCallRealMethod().when(activity).openActivity2();

        assertTrue(activity.openActivity2());
    }

}