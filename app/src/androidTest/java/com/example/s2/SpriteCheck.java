// Test Case was written by Rian Rahman (but pushed by John Gunerli due to merge conflicts)
package com.example.s2;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SpriteCheck {
    private Context context;
    @Test
    public void testSpriteSelection() {
        RadioButton button1 = new RadioButton(context);
        RadioButton button2 = new RadioButton(context);
        RadioButton button3 = new RadioButton(context);

        RadioGroup group = new RadioGroup(context);
        group.addView(button1);
        group.addView(button2);
        group.addView(button3);
        group.clearCheck();

        // Check for default selection (no buttons selected)
        assertEquals(getChecked(group), 2);

        group.clearCheck();
        group.check(1);
        assertEquals(getChecked(group), 1);

        group.clearCheck();
        group.check(2);
        assertEquals(getChecked(group), 2);

        group.clearCheck();
        group.check(3);
        assertEquals(getChecked(group), 3);
    }

    public static int getChecked(RadioGroup group) {
        if (group.getCheckedRadioButtonId() == -1) {
            return 2;
        } else {
            return group.getCheckedRadioButtonId();
        }
    }



    @Before
    public void setUp() {
        context = ApplicationProvider.getApplicationContext();
    }

}
