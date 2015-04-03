package com.triveous.recorder.alltests.recording;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import com.triveous.recorder.alltests.utility.FileManager;

/**
 * Created by Shivam on 10/19/2014.
 */
public class ServiceValidator {

    private final static String CONVERTER_SERVICE = "com.triveous.recorder.audio.ConverterService";
    private final static String CLOUD_SERVICE = "com.triveous.recorder.cloud.CloudService";
    private final static String AUDIO_SERVICE = "com.triveous.recorder.audio.core.AudioService";
    private final static String COMPRESSION_SERVICE = "com.triveous.recorder.audio.core.compression.CompressionService";

    /**
     * This method detects skyro running services.
     *
     * @return true or false
     */
    public static boolean isAnySkyroServiceRunning(Activity activity) {
        ActivityManager manager = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            //Check for skyro service
            if (service.service.getClassName().contains("com.triveous.recorder")) {
                if (CONVERTER_SERVICE.equals(service.service.getClassName()) ||
                        CLOUD_SERVICE.equals(service.service.getClassName()) ||
                        AUDIO_SERVICE.equals(service.service.getClassName()) ||
                        COMPRESSION_SERVICE.equals(service.service.getClassName())
                        ) {
                    Log.d("Running Service:->", "" + service.service.getClassName());
                    FileManager.writeLog(""+service.service.getClassName());
                    return true;
                } else {
                    Log.d("Running Service:->", "" + service.service.getClassName());
                    FileManager.writeLog(""+service.service.getClassName());
                }
            } else {
                continue;
            }
        }
        return false;
    }

}
