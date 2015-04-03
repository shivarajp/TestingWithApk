package com.triveous.recorder.alltests.utility;

/**
 * Created by Shivam on 11/20/2014.
 */
public class SettingsManager {

    private static SettingsManager sSettingsManager;
    private int mAudioRate;
    private int mBitRate;
    private int mFileFormat;

    public static SettingsManager getSettingsManager() {
        if (sSettingsManager == null) {
            sSettingsManager = new SettingsManager();
        }
        return sSettingsManager;
    }

    public SettingsManager() {
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


    public int getmBitRate() {
        return mBitRate;
    }

    public int getmFileFormat() {
        return mFileFormat;
    }

    public int getmAudioRate() {
        return mAudioRate;
    }
}
