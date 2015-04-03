package com.triveous.recorder.alltests.recording;

import android.util.Log;
import android.widget.TextView;

import com.robotium.solo.Solo;
import com.triveous.recorder.alltests.Test;
import com.triveous.recorder.alltests.images.ImagesOperations;
import com.triveous.recorder.alltests.utility.FileManager;
import com.triveous.recorder.alltests.utility.SettingsManager;

import java.util.ArrayList;

/**
 * Created by Shivam on 9/11/2014.
 */
public class Recorder {

    public static final float IMAGES_NULL = 0;

    private static ArrayList<String> mRecordings = new ArrayList<String>();

    public static ArrayList<String> getmRecordings() {
        return mRecordings;
    }

    public static void setmRecordings(ArrayList<String> mRecordings) {
        Recorder.mRecordings = mRecordings;
    }

    /**
     * Default settings
     * 44100, Wave
     */
    public static void record() {
        record(Settings.getDefaultSettings(), Settings.DEFAULT_DURATION, Settings.DEFAULT_FREQUENCY, null, IMAGES_NULL);
    }

    public static void record(Settings settings) {
        record(settings, Settings.DEFAULT_DURATION, Settings.DEFAULT_FREQUENCY, null, IMAGES_NULL);
    }

    public static void record(Settings settings, int duration) {
        record(settings, duration, Settings.DEFAULT_FREQUENCY, null, IMAGES_NULL);
    }

    public static void record(String fileNames) {
        record(Settings.getDefaultSettings(), Settings.DEFAULT_DURATION, Settings.DEFAULT_FREQUENCY, fileNames, IMAGES_NULL);
    }

    public static void record(Settings settings, String fileNames) {
        record(settings, Settings.DEFAULT_DURATION, Settings.DEFAULT_FREQUENCY, fileNames, IMAGES_NULL);
    }

    public static void record(Settings settings, int duration, String fileNames) {
        record(settings, duration, Settings.DEFAULT_FREQUENCY, fileNames, IMAGES_NULL);
    }

    public static void record(Settings settings, int duration, int frequency, String fileNames) {
        record(settings, duration, frequency, fileNames, IMAGES_NULL);
    }













    public static void record(float imagesFlag) {
        record(Settings.getDefaultSettings(), Settings.DEFAULT_DURATION, Settings.DEFAULT_FREQUENCY, null, imagesFlag);
    }

    public static void record(Settings settings,float imagesFlag) {
        record(settings, Settings.DEFAULT_DURATION, Settings.DEFAULT_FREQUENCY, null, imagesFlag);
    }

    public static void record(Settings settings, int duration,float imagesFlag) {
        record(settings, duration, Settings.DEFAULT_FREQUENCY, null, imagesFlag);
    }

    public static void record(String fileNames,float imagesFlag) {
        record(Settings.getDefaultSettings(), Settings.DEFAULT_DURATION, Settings.DEFAULT_FREQUENCY, fileNames, imagesFlag);
    }

    public static void record(Settings settings, String fileNames,float imagesFlag) {
        record(settings, Settings.DEFAULT_DURATION, Settings.DEFAULT_FREQUENCY, fileNames, imagesFlag);
    }

    public static void record(Settings settings, int duration, String fileNames,float imagesFlag) {
        record(settings, duration, Settings.DEFAULT_FREQUENCY, fileNames, imagesFlag);
    }

















    /**
     * Common method
     * @param settings
     * @param duration
     * @param frequency
     */
    public static void record(Settings settings, int duration, int frequency, String fileNames, float imagesFlag) {
        try {
            Solo solo = Test.getSolo();
            if (settings != null) {

                //Compare with existing settings
                if (SettingsManager.getSettingsManager().getmFileFormat() != settings.getmFileFormat()) {
                    setFileFormatSetting(solo, settings.getmFileFormat());
                }
                if (SettingsManager.getSettingsManager().getmAudioRate() != settings.getmAudioRate()) {
                    setAudioRateSetting(solo, settings.getmAudioRate());
                }
                if ((SettingsManager.getSettingsManager().getmBitRate() != settings.getmBitRate())
                        && settings.getmFileFormat() != Settings.FILE_FORMAT_WAVE) {
                    setBitRateSetting(solo, settings.getmBitRate());
                }

                //We cannot pass only frrequency directly so duration should be -1
                if (duration != -1) {
                    for (int index = 0; index < frequency; index++) {
                        recording(solo, duration);
                        if (fileNames != null && imagesFlag == IMAGES_NULL) {
                            //If only renaming is needed
                            rename(solo, fileNames + FileManager.getUniqueName());
                        } else if (fileNames == null && imagesFlag != IMAGES_NULL) {
                            //If only adding images no renaming is needed
                            ImagesOperations.addImages();

                        } else if (fileNames != null && imagesFlag != IMAGES_NULL) {
                            //both renaming and adding images
                            rename(solo, fileNames + FileManager.getUniqueName());
                            ImagesOperations.addImages();
                        }
                    }
                } else {
                    //With default duration
                    for (int index = 0; index < frequency; index++) {
                        recording(solo, Settings.DEFAULT_DURATION);
                        if (fileNames != null && imagesFlag == IMAGES_NULL) {
                            rename(solo, fileNames + FileManager.getUniqueName());
                        } else if (fileNames == null && imagesFlag != IMAGES_NULL) {
                            ImagesOperations.addImages();
                        } else if (fileNames != null && imagesFlag != IMAGES_NULL) {
                            rename(solo, fileNames + FileManager.getUniqueName());
                            ImagesOperations.addImages();
                        }
                    }
                }
            } else {
                // Null means no need to set settings existing settings will be used.
                for (int index = 0; index < frequency; index++) {
                    recording(solo, Settings.DEFAULT_DURATION);
                    if (fileNames != null && imagesFlag == IMAGES_NULL) {
                        rename(solo, fileNames + FileManager.getUniqueName());
                    } else if (fileNames == null && imagesFlag != IMAGES_NULL) {
                        ImagesOperations.addImages();
                    } else if (fileNames != null && imagesFlag != IMAGES_NULL) {
                        rename(solo, fileNames + FileManager.getUniqueName());
                        ImagesOperations.addImages();
                    }
                }
            }
        } catch (Exception e) {
            //Write the error
            FileManager.writeLog("Error: " + e);
        }
    }

    //If only one int its considered as duration not frequency.
    public static void record(int duration) {
        record(Settings.getDefaultSettings(), duration, Settings.DEFAULT_FREQUENCY, null, IMAGES_NULL);
    }

    public static void record(Settings settings, int duration, int frequency) {
        record(settings, duration, frequency, null, IMAGES_NULL);
    }

    public static void record(Settings settings, int duration, int frequency, float images) {
        record(settings, duration, frequency, null, images);
    }

    //TO send only frequency pass duration as -1
    //We cannot pass only frrequency directly so duration should be -1
    public static void record(int duration, int frequency) {
        if (duration != -1) {
            record(getDefaultSettings(), duration, frequency, null, IMAGES_NULL);
        } else {
            record(getDefaultSettings(), duration, frequency, null, IMAGES_NULL);
        }
    }

    public static void record(int duration, int frequency, String newFilename) {
        record(getDefaultSettings(), duration, frequency, newFilename, IMAGES_NULL);
    }

    public static void record(ArrayList<Settings> settings, int frequency) {
        record(settings, Settings.DEFAULT_DURATION, frequency);
    }

    public static void record(ArrayList<Settings> settings, int duration, int frequency) {

        for (int i = 0; i < settings.size(); i++) {
            record(settings.get(i), duration, frequency, null, IMAGES_NULL);
        }
    }

    //Called when renaming is required
    public static void record(ArrayList<Settings> settings, int duration, int frequency, String fileName) {
        for (int i = 0; i < settings.size(); i++) {
            record(settings.get(i), duration, frequency, fileName, IMAGES_NULL);
        }
    }

    public static void record(ArrayList<Settings> settings, int[] duration) {

        for (int i = 0; i < duration.length; i++) {
            record(settings.get(i), duration[i], Settings.DEFAULT_FREQUENCY, null, IMAGES_NULL);
        }
    }

    public static void record(ArrayList<Settings> settings, int[] duration, int[] frequency) {
        for (int i = 0; i < duration.length; i++) {
            record(settings.get(i), duration[i], frequency[i], null, IMAGES_NULL);
        }
    }

    public static void record(ArrayList<Settings> settings, int duration, int[] frequency) {
        for (int i = 0; i < frequency.length; i++) {
            record(settings.get(i), duration, frequency[i], null, IMAGES_NULL);
        }
    }

    public static void record(ArrayList<Settings> settings, int[] duration, int[] frequency, String fileName) {
        for (int i = 0; i < duration.length; i++) {
            record(settings.get(i), duration[i], frequency[i], fileName, IMAGES_NULL);
        }
    }











    //If only one int its considered as duration not frequency.
    public static void record(int duration, float imagesFlag) {
        record(Settings.getDefaultSettings(), duration, Settings.DEFAULT_FREQUENCY, null, imagesFlag);
    }

    //TO send only frequency pass duration as -1
    public static void record(int duration, int frequency, float imagesFlag) {
        if (duration != -1) {
            record(getDefaultSettings(), duration, frequency, null, imagesFlag);
        } else {
            record(getDefaultSettings(), duration, frequency, null, imagesFlag);
        }
    }

    public static void record(int duration, int frequency, String newFilename, float imagesFlag) {
        record(getDefaultSettings(), duration, frequency, newFilename, imagesFlag);
    }

    public static void record(ArrayList<Settings> settings, int frequency, float imagesFlag) {
        record(settings, Settings.DEFAULT_DURATION, frequency, imagesFlag);
    }

    public static void record(ArrayList<Settings> settings, int duration, int frequency, float imagesFlag) {

        for (int i = 0; i < settings.size(); i++) {
            record(settings.get(i), duration, frequency, null,imagesFlag);
        }
    }

    //Called when renaming is required
    public static void record(ArrayList<Settings> settings, int duration, int frequency, String fileName, float imagesFlag) {
        for (int i = 0; i < settings.size(); i++) {
            record(settings.get(i), duration, frequency, fileName, imagesFlag);
        }
    }

    public static void record(ArrayList<Settings> settings, int[] duration, float imagesFlag) {

        for (int i = 0; i < duration.length; i++) {
            record(settings.get(i), duration[i], Settings.DEFAULT_FREQUENCY, null, imagesFlag);
        }
    }

    public static void record(ArrayList<Settings> settings, int[] duration, int[] frequency, float imagesFlag) {
        for (int i = 0; i < duration.length; i++) {
            record(settings.get(i), duration[i], frequency[i], null, imagesFlag);
        }
    }

    public static void record(ArrayList<Settings> settings, int duration, int[] frequency, float imagesFlag) {
        for (int i = 0; i < frequency.length; i++) {
            record(settings.get(i), duration, frequency[i], null, imagesFlag);
        }
    }

    public static void record(ArrayList<Settings> settings, int[] duration, int[] frequency, String fileName, float imagesFlag) {
        for (int i = 0; i < duration.length; i++) {
            record(settings.get(i), duration[i], frequency[i], fileName, imagesFlag);
        }
    }














    public static Settings getDefaultSettings() {
        return new Settings(Settings.AUDIO_RATE_44100, Settings.FILE_FORMAT_WAVE);
    }

    private static void wait(Solo solo) {
        solo.sleep(Settings.DEFAULT_SLEEP);
    }

    /**
     * Default settings 44100,wave
     */
    public static void setDefaultSetting(Solo solo) {

        SettingsManager.getSettingsManager().setmAudioRate(Settings.AUDIO_RATE_44100);
        SettingsManager.getSettingsManager().setmFileFormat(Settings.FILE_FORMAT_WAVE);

        solo.waitForActivity("RecorderActivity", 2000);
        solo.sleep(2000);
        //Settings
        solo.clickOnActionBarItem(0x1);
        //solo.sendKey(Solo.MENU);
        //solo.clickOnText("Settings");
        //solo.clickOnMenuItem("Settings");
        //Wait for activity: 'com.triveous.recorder.ui.preferences.RecorderPreferenceActivity'   (Activity)
        Test.getActivityInstrumentationTestCase2().assertTrue("RecorderPreferenceActivity is not found!", solo.waitForActivity("RecorderPreferenceActivity"));
        //Sleep for 1784 milliseconds
        solo.sleep(1784);

        //File Format
        //Click on LinearLayout File format wav (uncompressed) LinearLayout
        solo.clickInList(8, 0);
        //Wait for dialog
        solo.waitForDialogToOpen(5000);
        //Sleep for 1396 milliseconds
        solo.sleep(1000);
        //Click on Wave
        solo.clickOnView(solo.getView(android.R.id.text1, 0));
        //Sleep for 3464 milliseconds
        solo.sleep(2000);

        //Audio Rate
        //Click on LinearLayout Audio rate LinearLayout
        solo.clickOnText(java.util.regex.Pattern.quote("Audio rate"));
        //Wait for dialog
        solo.waitForDialogToOpen(5000);
        //Sleep for 1352 milliseconds
        solo.sleep(1352);
        //Click on 44100 Hz
        solo.clickOnView(solo.getView(android.R.id.text1, 0));
        //Sleep for 3379 milliseconds
        solo.sleep(2000);

        //Press menu back key
        solo.goBack();
        solo.sleep(2000);
    }

    public static void recording(Solo solo, int duration) {
        //Record button
        solo.clickOnView(solo.getView("recorderpage_record"));
        solo.sleep(duration * 60 * 1000);
        solo.clickOnView(solo.getView("recorderpage_stop"));
        //Get the recording file name from welcome card
        getmRecordings().add(((TextView) solo.getView("card_topText")).getText().toString());
        solo.sleep(3000);
    }

    public static void rename(Solo solo, String filename) {
        //Rename
        if (solo.waitForActivity("RecorderActivity", 2000)) {
            //Click on Rename (Rename Button on Welcome Card button)
            solo.clickOnView(solo.getView("card_details_utility_stop_rename"));
            //Wait for dialog
            solo.waitForDialogToOpen(5000);
            //Sleep for 1663 milliseconds
            solo.sleep(1663);
            //Enter the text:  (Rename or New file name dialog clear existing text an enter new text)
            solo.clearEditText((android.widget.EditText) solo.getView("renamedialogEditText"));
            //New File name
            solo.enterText((android.widget.EditText) solo.getView("renamedialogEditText"), filename);
            //Sleep for 884 milliseconds
            solo.sleep(884);
            //Click on OK (click ok to confirm new name)
            solo.clickOnView(solo.getView(android.R.id.button1));
            //Sleep for 1549 milliseconds
            solo.sleep(3000);
        } else {
            //Write into log file
        }
    }

    public static void sleep(Solo solo) {
        Log.d("waitinng", "waiting");
        solo.sleep(Settings.DEFAULT_SLEEP);
    }

    public static void setFileFormatSetting(Solo solo, int fileFormat) {

        SettingsManager.getSettingsManager().setmFileFormat(fileFormat);
        solo.waitForActivity("RecorderActivity", 2000);
        solo.sleep(2000);
        //Settings
        solo.clickOnActionBarItem(0x1);
        //solo.sendKey(Solo.MENU);
        //solo.clickOnText("Settings");
        //solo.clickOnMenuItem("Settings");
        //Wait for activity: 'com.triveous.recorder.ui.preferences.RecorderPreferenceActivity'   (Activity)
        Test.getActivityInstrumentationTestCase2().assertTrue("RecorderPreferenceActivity is not found!", solo.waitForActivity("RecorderPreferenceActivity"));
        //Sleep for 1784 milliseconds
        solo.sleep(1784);
        //File Format
        //Click on LinearLayout File format wav (uncompressed) LinearLayout
        solo.clickInList(8, 0);
        //Wait for dialog
        solo.waitForDialogToOpen(5000);
        //Sleep for 1396 milliseconds
        solo.sleep(1000);
        if (fileFormat == Settings.FILE_FORMAT_WAVE) {
            //Click on Wave
            solo.clickOnView(solo.getView(android.R.id.text1, 0));
            //Sleep for 3464 milliseconds
            solo.sleep(2000);
        } else if (fileFormat == Settings.FILE_FORMAT_MP3) {
            //Click on mp3
            solo.clickOnView(solo.getView(android.R.id.text1, 1));
            solo.sleep(2000);
        } else {
            //Click on m4a
            solo.clickOnView(solo.getView(android.R.id.text1, 2));
            solo.sleep(2000);
        }
        pressBack(solo);
    }

    public static void pressBack(Solo solo) {
        //Press menu back key
        solo.goBack();
        solo.sleep(2000);
    }

    /**
     * call this method only when you are already in settings page
     * <p/>
     * This method will set the specified Audio rate setting.
     *
     * @param solo
     * @param audioRate
     */
    public static void setAudioRateSetting(Solo solo, int audioRate) {

        SettingsManager.getSettingsManager().setmAudioRate(audioRate);

        switch (audioRate) {
            case 44100:
                setAudioRate(solo, 0);
                break;
            case 22050:
                setAudioRate(solo, 1);
                break;
            case 11000:
                setAudioRate(solo, 2);
                break;
            case 8000:
                setAudioRate(solo, 3);
                break;
            default:
                break;
        }
    }

    public static void setAudioRate(Solo solo, int index) {
        solo.waitForActivity("RecorderActivity", 2000);
        solo.sleep(2000);
        //Settings
        solo.clickOnActionBarItem(0x1);
        //solo.sendKey(Solo.MENU);
        //solo.clickOnText("Settings");
        //solo.clickOnMenuItem("Settings");
        //Wait for activity: 'com.triveous.recorder.ui.preferences.RecorderPreferenceActivity'   (Activity)
        Test.getActivityInstrumentationTestCase2().assertTrue("RecorderPreferenceActivity is not found!", solo.waitForActivity("RecorderPreferenceActivity"));
        //Sleep for 1784 milliseconds
        solo.sleep(1784);

        //Audio Rate
        //Click on LinearLayout Audio rate LinearLayout
        solo.clickOnText(java.util.regex.Pattern.quote("Audio rate"));
        //Wait for dialog
        solo.waitForDialogToOpen(5000);
        //Sleep for 1352 milliseconds
        solo.sleep(1352);
        //Click on Audio rate Hz
        solo.clickOnView(solo.getView(android.R.id.text1, index));

        //solo.clickOnText(index+"");
        //Sleep for 3379 milliseconds
        solo.sleep(2000);

        //Press menu back key
        solo.goBack();
        solo.sleep(2000);
    }


    public static void setBitRateSetting(Solo solo, int index) {

        SettingsManager.getSettingsManager().setmBitRate(index);
        solo.waitForActivity("RecorderActivity", 2000);
        solo.sleep(2000);
        //Settings
        solo.clickOnActionBarItem(0x1);
        //solo.clickOnMenuItem("Settings");
        //Wait for activity: 'com.triveous.recorder.ui.preferences.RecorderPreferenceActivity'   (Activity)
        Test.getActivityInstrumentationTestCase2().assertTrue("RecorderPreferenceActivity is not found!", solo.waitForActivity("RecorderPreferenceActivity"));
        //Sleep for 1784 milliseconds
        solo.sleep(1784);
        //Scroll to LinearLayout MP3 bitrate 128 kbits/s LinearLayout
        android.widget.ListView listView0 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        solo.scrollListToLine(listView0, 3);
        //Click on LinearLayout MP3 bitrate 128 kbits/s LinearLayout
        solo.clickOnText(java.util.regex.Pattern.quote("MP3 bitrate"));
        //Wait for dialog
        solo.waitForDialogToOpen(5000);
        //Sleep for 1456 milliseconds
        solo.sleep(1456);
        //solo.clickOnView(solo.getView(android.R.id.text1, index));
        //Click on given bitrate kbits/s
        solo.clickOnText(index + "");
        //Sleep for 1903 milliseconds
        solo.sleep(1903);

        //Press menu back key
        solo.goBack();
        solo.sleep(2000);
    }
}
