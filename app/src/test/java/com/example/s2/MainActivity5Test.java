package com.example.s2;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class MainActivity5Test {

    @Test
//    check if the restart_button works.
    public void testRestartGame() {
        MainActivity5 activity = mock(MainActivity5.class);
        doCallRealMethod().when(activity).openActivity2();
        assertTrue(activity.openActivity2());
    }
}

