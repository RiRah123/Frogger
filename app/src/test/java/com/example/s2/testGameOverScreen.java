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
public class testGameOverScreen {

    @Mock
    MainActivity4 activity;

    @Mock
    Button restartButton;

    @Mock
    Button quitButton;

    @Before
    public void setUp() {
        Mockito.when(activity.findViewById(R.id.quit_button)).thenReturn(quitButton);
    }

    @Test
    public void testQuitGame() {
        // Verify that quitGame() returns true
        Mockito.when(activity.quitGame()).thenCallRealMethod();
        assertTrue(activity.quitGame());
    }

}
