package com.triveous.recorder.alltests.images;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.triveous.recorder.alltests.Test;
import com.triveous.recorder.alltests.recording.Recorder;
import com.triveous.recorder.alltests.recording.Settings;

/**
 * Created by Shivam on 11/28/2014.
 */
public class ImagesTest extends Test {
    private static ImagesTest sImagesTest;

    public static ImagesTest getDefault(Solo solo) {
        if (getSolo() == null) {
            setSolo(solo);
        }
        if (sImagesTest == null) {
            sImagesTest = new ImagesTest();
        }
        return sImagesTest;
    }

    public static ImagesTest getDefault(ActivityInstrumentationTestCase2 activityInstrumentationTestCase2) {
        setup(activityInstrumentationTestCase2);
        if (sImagesTest == null) {
            sImagesTest = new ImagesTest();
        }
        return sImagesTest;
    }

    public static ImagesTest getDefault() {
        if (sImagesTest == null) {
            sImagesTest = new ImagesTest();
        }
        return sImagesTest;
    }

    @Override
    public void allTests() {

    }

    @Override
    public void coreTests() {

        Recorder.record(Settings.getSetting_44100_Wave(), 1, 1, Settings.ADD_Images);
        Recorder.record( 1, 1);
        Recorder.record(Settings.getSetting_44100_Wave(), 1, 1, Settings.DEFAULT_FILE_NAME, Settings.ADD_Images);
    }
}
