package com.triveous.recorder;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.TextView;
import com.robotium.solo.Solo;
import com.triveous.recorder.alltests.Test;
import com.triveous.recorder.alltests.recording.Recorder;
import com.triveous.recorder.alltests.recording.ServiceValidator;
import com.triveous.recorder.alltests.utility.FileManager;

@SuppressWarnings("rawtypes")
public class SkyroTestRunner extends ActivityInstrumentationTestCase2 {
    private Solo solo;
    private static SkyroTestRunner skyroTestRunner;
    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.triveous.recorder.RecorderActivity";
    private static Class<?> launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("unchecked")
    public SkyroTestRunner() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation());
        Test.setup(this);
        getActivity();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testOneMinute() throws Exception {
        solo.sleep(1000);
        assertTrue("RecorderActivity", solo.waitForActivity("RecorderActivity", 2000));
        //Record button
        solo.clickOnView(solo.getView("recorderpage_record"));
        solo.sleep(60 * 1000);
        solo.clickOnView(solo.getView("recorderpage_stop"));
        solo.sleep(3000);
        String filename = ((TextView) solo.getView("card_topText")).getText().toString();
        Log.d("fileName", filename);
        while (checkService()) {
            Recorder.sleep(solo);
        }
        assertTrue("File not created..", FileManager.fileExist(filename));
    }

    public boolean checkService() {
        return ServiceValidator.isAnySkyroServiceRunning(getActivity());
    }
}

