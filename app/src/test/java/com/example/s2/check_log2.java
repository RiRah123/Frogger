package com.example.s2;

import android.content.res.Resources;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class check_log2{
    private static class TestResources extends Resources {
        TestResources() {
            super(null, null, null);
        }

        @Override
        public int getIdentifier(String name, String defType, String defPackage) {
            return 0;
        }
    }

    @Test
    public void testResourcesExist() {
        Resources resources = new TestResources();
        int id = resources.getIdentifier("log_tile2", "drawable", "com.example.s2");
        assertEquals(0, id);
    }
}
