package com.example.s2;

import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class testWinScreen {

    @Mock
    MainActivity5 activity;

    @Mock
    Button restartButton;

    @Mock
    Button quitButton;

    @Before
    public void setUp() {
        Mockito.when(activity.findViewById(R.id.restart_button)).thenReturn(restartButton);
        Mockito.when(activity.findViewById(R.id.quit_button)).thenReturn(quitButton);
    }

    @Test
//    test if the restart_button returns true
    public void testRestartGame() {
        // Verify that quitGame() returns true
        Mockito.when(activity.openActivity2()).thenCallRealMethod();
        assertTrue(activity.openActivity2());
    }
}
