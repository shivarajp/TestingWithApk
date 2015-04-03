package com.triveous.recorder.alltests.dropbox;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.triveous.recorder.alltests.Test;
import com.triveous.recorder.alltests.recording.Recorder;
import com.triveous.recorder.alltests.recording.Settings;
import com.triveous.recorder.alltests.utility.FileManager;

/**
 * Created by Shivam on 11/3/2014.
 */
public class DropboxTest extends Test {

    private static DropboxTest sDropboxTest;

    public static DropboxTest getDefault(Solo solo) {
        if (getSolo() == null) {
            setSolo(solo);
        }
        if (sDropboxTest == null) {
            sDropboxTest = new DropboxTest();
        }
        return sDropboxTest;
    }

    public static DropboxTest getDefault(ActivityInstrumentationTestCase2 activityInstrumentationTestCase2) {
        setup(activityInstrumentationTestCase2);
        if (sDropboxTest == null) {
            sDropboxTest = new DropboxTest();
        }
        return sDropboxTest;
    }

    public static DropboxTest getDefault() {
        if (sDropboxTest == null) {
            sDropboxTest = new DropboxTest();
        }
        return sDropboxTest;
    }

    @Override
    public void allTests() {
        FileManager.writeLog("Before Test");
        FileManager.writeFileNames();
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 5, 10);
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 30, 5);
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 60, 5);
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 240, 4);
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 600, 1);
       // Recorder.recordAndRename(Settings.getSetting_44100_Mp3_128kbps(), 600, 1, Settings.DEFAULT_FILE_NAME);

        FileManager.writeLog("After Test");
        FileManager.writeFileNames();
    }

    @Override
    public void coreTests() {
        Recorder.record(Settings.getSetting_44100_Mp3_128kbps(), 1, 1, Settings.DEFAULT_FILE_NAME,Recorder.IMAGES_NULL);

    }

    public static void customDropboxTest() {
        Recorder.record(Settings.getDefaultSettings(), Settings.DEFAULT_DURATION, Settings.DEFAULT_FREQUENCY);
    }

    public void customDropboxTest(Settings settings, int duration, int frequency) {
        Recorder.record(settings, duration, frequency);
    }

    public void customDropboxTest(Settings settings, int duration, int frequency, String fileName) {
        Recorder.record(settings, duration, frequency, fileName,Recorder.IMAGES_NULL);
    }

    public void customDropboxTest(int duration, int frequency, String fileName) {
        Recorder.record(duration, frequency, fileName);
    }

    public void customDropboxTest(Settings settings, int duration) {
        Recorder.record(settings, duration);
    }

    public void customDropboxTest(int duration, int frequency) {
        Recorder.record(duration, frequency);
    }

    public void customDropboxTest(int duration) {
        Recorder.record(duration);
    }

    public void customDropboxTest(Settings settings) {
        Recorder.record(settings);
    }
}