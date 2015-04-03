package com.triveous.recorder.alltests.recording;

import com.triveous.recorder.alltests.utility.FileManager;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Shivam on 10/15/2014.
 */
public class Settings {

    private int mAudioRate;
    private int mBitRate;
    private int mFileFormat;

    public int getmAudioRate() {
        return mAudioRate;
    }

    public int getmBitRate() {
        return mBitRate;
    }

    public int getmFileFormat() {
        return mFileFormat;
    }

    public void setmAudioRate(int mAudioRate) {
        this.mAudioRate = mAudioRate;
    }

    public void setmBitRate(int mBitRate) {
        this.mBitRate = mBitRate;
    }

    public void setmFileFormat(int mFileFormat) {
        this.mFileFormat = mFileFormat;
    }

    private static File mLogFile = null;

    //Duration of recording in min's
    public static final int DEFAULT_DURATION = 1;
    public static final int DEFAULT_FREQUENCY = 1;
    public static final int DEFAULT_SLEEP = 60 * 1000;
    public static int FILE_FORMAT_WAVE = 0;
    public static int FILE_FORMAT_MP3 = 1;
    public static int FILE_FORMAT_M4A = 2;


    public static int NO_RENAME = 0;
    public static int RENAME = 1;

    public static float TEST_TYPE_RECORDING = 0;
    public static float TEST_TYPE_DROPBOX = 1;

    public static final String DEFAULT_FILE_NAME = "Rec-";

    //Audio Rate
    public static final int AUDIO_RATE_44100 = 44100;
    public static final int AUDIO_RATE_22050 = 22050;
    public static final int AUDIO_RATE_11025 = 11025;
    public static final int AUDIO_RATE_8000 = 8000;

    //Bit Rate
    public static final int BIT_RATE_320 = 320;
    public static final int BIT_RATE_256 = 256;
    public static final int BIT_RATE_192 = 192;
    public static final int BIT_RATE_160 = 160;
    public static final int BIT_RATE_128 = 128;
    public static final int BIT_RATE_64 = 64;
    public static final int BIT_RATE_32 = 32;
    public static final int BIT_RATE_8 = 8;

    public static final float ADD_Images = 1.f;


    private static ArrayList<Integer> allBitRates;

    public static File getmLogFile() {
        return mLogFile;
    }

    /**
     * Every time you call this method it will create new file and save it for later operations.
     */
    public static void setmLogFile() {
        Settings.mLogFile = null;
        Settings.mLogFile = FileManager.createLogFile();
    }

    public Settings() {
        mAudioRate = AUDIO_RATE_44100;
        mFileFormat = FILE_FORMAT_WAVE;
    }

    public Settings(int audioRate) {
        mAudioRate = audioRate;
        mFileFormat = FILE_FORMAT_WAVE;
    }

    //Suppose user choosen Mp3 and forgot to set bitrate
    public Settings(int audioRate, int fileFormat) {
        mAudioRate = audioRate;
        mFileFormat = fileFormat;
    }

    public Settings(int audioRate, int bitRate, int fileFormat) {
        mAudioRate = audioRate;
        mFileFormat = fileFormat;
        mBitRate = bitRate;
    }

    public static Settings getDefaultSettings() {
        return new Settings(Settings.AUDIO_RATE_44100, Settings.FILE_FORMAT_WAVE);
    }

    //44100,wave
    public static Settings getSetting_44100_Wave() {

        return new Settings(Settings.AUDIO_RATE_44100, Settings.FILE_FORMAT_WAVE);
    }

    //22050,wave
    public static Settings getSetting_22050_Wave() {

        return new Settings(Settings.AUDIO_RATE_22050, Settings.FILE_FORMAT_WAVE);
    }

    //11025,wave
    public static Settings getSetting_11025_Wave() {

        return new Settings(Settings.AUDIO_RATE_11025, Settings.FILE_FORMAT_WAVE);
    }

    //44100,Mp3,128kbps
    public static Settings getSetting_44100_Mp3_128kbps() {
        return new Settings(Settings.AUDIO_RATE_44100, Settings.FILE_FORMAT_MP3, Settings.BIT_RATE_128);
    }

    //22050,Mp3,128kbps
    public static Settings getSetting_22050_Mp3_128kbps() {
        return new Settings(Settings.AUDIO_RATE_22050, Settings.FILE_FORMAT_MP3, Settings.BIT_RATE_128);
    }

    //11025,Mp3,128kbps
    public static Settings getSetting_11025_Mp3_128kbps() {
        return new Settings(Settings.AUDIO_RATE_11025, Settings.FILE_FORMAT_MP3, Settings.BIT_RATE_128);
    }

    //44100,Mp3,128kbps
    public static Settings getSetting_44100_Mp3_320kbps() {
        return new Settings(Settings.AUDIO_RATE_44100, Settings.FILE_FORMAT_MP3, Settings.BIT_RATE_320);
    }

    //22050,Mp3,128kbps
    public static Settings getSetting_22050_Mp3_320kbps() {
        return new Settings(Settings.AUDIO_RATE_22050, Settings.FILE_FORMAT_MP3, Settings.BIT_RATE_320);
    }

    //11025,Mp3,128kbps
    public static Settings getSetting_11025_Mp3_320kbps() {
        return new Settings(Settings.AUDIO_RATE_11025, Settings.FILE_FORMAT_MP3, Settings.BIT_RATE_320);
    }


    public static ArrayList<Settings> getAllWaveSettings() {
        ArrayList<Settings> settings = new ArrayList<Settings>();
        settings.add(Settings.getSetting_44100_Wave());
        settings.add(Settings.getSetting_22050_Wave());
        settings.add(Settings.getSetting_11025_Wave());
        return settings;

    }

    public static ArrayList<Settings> getAllMp3Settings() {
        ArrayList<Settings> settings = new ArrayList<Settings>();
        settings.add(Settings.getSetting_44100_Mp3_128kbps());
        settings.add(Settings.getSetting_22050_Mp3_128kbps());
        settings.add(Settings.getSetting_11025_Mp3_128kbps());
        settings.add(Settings.getSetting_44100_Mp3_320kbps());
        settings.add(Settings.getSetting_22050_Mp3_320kbps());
        settings.add(Settings.getSetting_11025_Mp3_320kbps());
        return settings;
    }

    public static int[] getAllDurations() {
        int[] durations = null;
        durations[0] = 5;
        durations[0] = 30;
        durations[0] = 60;
        durations[0] = 240;
        durations[0] = 600;
        return durations;
    }

    public static int[] getAllFrequencies() {
        int[] durations = null;
        durations[0] = 10;
        durations[0] = 5;
        durations[0] = 5;
        durations[0] = 4;
        durations[0] = 1;
        return durations;
    }
}