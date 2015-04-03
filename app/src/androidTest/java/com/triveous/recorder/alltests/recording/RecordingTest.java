package com.triveous.recorder.alltests.recording;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.robotium.solo.Solo;
import com.triveous.recorder.alltests.Test;
import com.triveous.recorder.alltests.utility.AssertTestResult;
import com.triveous.recorder.alltests.utility.FileManager;

/**
 * Created by Shivam on 9/11/2014.
 */
public class RecordingTest extends Test {
    private static RecordingTest sRecordingTest;

    public static RecordingTest getDefault(Solo solo) {
        if (getSolo() == null) {
            setSolo(solo);
        }
        if (sRecordingTest == null) {
            sRecordingTest = new RecordingTest();
        }
        return sRecordingTest;
    }

    public static RecordingTest getDefault(ActivityInstrumentationTestCase2 activityInstrumentationTestCase2) {
        setup(activityInstrumentationTestCase2);
        if (sRecordingTest == null) {
            sRecordingTest = new RecordingTest();
        }
        return sRecordingTest;
    }

    public static RecordingTest getDefault() {
        if (sRecordingTest == null) {
            sRecordingTest = new RecordingTest();
        }
        return sRecordingTest;
    }

    @Override
    public void allTests() {
        Recorder.record(Settings.getSetting_44100_Wave(), 1, 1);
       /* Recorder.record(Settings.getSetting_44100_Wave(), 30, 5);
        Recorder.record(Settings.getSetting_44100_Wave(), 60, 5);
        Recorder.record(Settings.getSetting_44100_Wave(), 240, 4);
        Recorder.record(Settings.getSetting_44100_Wave(), 600, 1);

        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 5, 10);
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 30, 5);
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 60, 5);
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 240, 4);
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 600, 1);

        Recorder.record(Settings.getSetting_22050_Wave(), 5, 10);
        Recorder.record(Settings.getSetting_22050_Wave(), 30, 5);
        Recorder.record(Settings.getSetting_22050_Wave(), 60, 5);
        Recorder.record(Settings.getSetting_22050_Wave(), 240, 4);
        Recorder.record(Settings.getSetting_22050_Wave(), 600, 1);

        Recorder.record(Settings.getSetting_22050_Mp3_128kbps(), 5, 10);
        Recorder.record(Settings.getSetting_22050_Mp3_128kbps(), 30, 5);
        Recorder.record(Settings.getSetting_22050_Mp3_128kbps(), 60, 5);
        Recorder.record(Settings.getSetting_22050_Mp3_128kbps(), 240, 4);
        Recorder.record(Settings.getSetting_22050_Mp3_128kbps(), 600, 1);*/

        //or

        //Covers all Settings,durations and frequencies
        //  Recorder.record(Settings.getAllWaveSettings(), Settings.getAllDurations(),Settings.getAllFrequencies());
        //  Recorder.record(Settings.getAllMp3Settings(), Settings.getAllDurations(),Settings.getAllFrequencies());
    }

    public void customTests(Settings settings, int duration, int frequency) {
        Recorder.record(settings, duration, frequency);
    }

    public void customTests(Settings settings, int duration, int frequency, String fileName) {
        Recorder.record(settings, duration, frequency, fileName, Recorder.IMAGES_NULL);
        if(AssertTestResult.validateResult(settings, duration, frequency, fileName, Recorder.IMAGES_NULL)){
            FileManager.writeLog("CustomTests Settings settings, int duration, int frequency, String fileName");
            Log.d("CustomTests", "Settings settings, int duration, int frequency, String fileName");

        }else {

        }
    }

    public void customTests(int duration, int frequency, String fileName) {
        Recorder.record(duration, frequency, fileName);
    }

    public void customTests(Settings settings, int duration) {
        Recorder.record(settings, duration);
    }

    public void customTests(int duration, int frequency) {
        Recorder.record(duration, frequency);
    }

    public void customTests(int duration) {
        Recorder.record(duration);
    }

    public void customTests(Settings settings) {
        Recorder.record(settings);
    }

    public void coreTests() {
        Recorder.record(Settings.getSetting_44100_Wave());
        Recorder.record(Settings.getSetting_22050_Wave());
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps());
        Recorder.record(Settings.getSetting_22050_Mp3_128kbps());
    }
}
