package com.triveous.recorder.alltests;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by Shivam on 9/11/2014.
 */
public abstract class Test {
    private static volatile Solo solo = null;
    private static volatile ActivityInstrumentationTestCase2 activityInstrumentationTestCase2 = null;

    abstract public void allTests();

    abstract public void coreTests();


    public static Solo getSolo() {
        return solo;
    }

    public static void setSolo(Solo solo) {
        Test.solo = solo;
    }

    public static ActivityInstrumentationTestCase2 getActivityInstrumentationTestCase2() {
        return activityInstrumentationTestCase2;
    }

    public static void setActivityInstrumentationTestCase2(ActivityInstrumentationTestCase2 activityInstrumentationTestCase2) {
        Test.activityInstrumentationTestCase2 = activityInstrumentationTestCase2;
    }

    public static void setup(ActivityInstrumentationTestCase2 _activityInstrumentationTestCase2) {
        if (solo == null) {
            Solo _solo = solo = new Solo(_activityInstrumentationTestCase2.getInstrumentation());
            setSolo(_solo);
        }
        if (activityInstrumentationTestCase2 != null) {
            setActivityInstrumentationTestCase2(_activityInstrumentationTestCase2);
        }
    }
}

