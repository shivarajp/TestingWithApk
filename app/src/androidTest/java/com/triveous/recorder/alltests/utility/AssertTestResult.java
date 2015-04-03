package com.triveous.recorder.alltests.utility;

import android.os.Environment;

import com.triveous.recorder.alltests.Test;
import com.triveous.recorder.alltests.recording.Recorder;
import com.triveous.recorder.alltests.recording.Settings;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Shivam on 4/2/2015.
 */
public class AssertTestResult {

    public static File mParentDir = new File(Environment.getExternalStorageDirectory() + "/AudioRecorder/");

    public static boolean validateResult(Settings settings, int duration, int frequency, String fileNames, float imagesFlag){

        //get all the file names recorded in the current test
        ArrayList<String> recordingNames = Recorder.getmRecordings();

        if(recordingNames.size()>0){
            for(int i=0;i<recordingNames.size();i++) {

                Test.getActivityInstrumentationTestCase2().assertTrue("",calculateExpectedFileSize(FileManager.returnFile(mParentDir, recordingNames.get(i))));

                //check the expected file size if its its correct then continue else stop and write log
               /* if(calculateExpectedFileSize(FileManager.returnFile(mParentDir, recordingNames.get(i)))){
                    FileManager.writeLog("Size check:passed->"+recordingNames.get(i));
                    Log.d("Size check:","passed->"+recordingNames.get(i));
                    //continue;
                }else {
                    FileManager.writeLog("Size check:Failed file size not maching:->"+recordingNames.get(i));
                    Log.d("Size check:","Failed file size not maching*->"+recordingNames.get(i));
                    //return false;
                }*/
            }
        }
        return true;
    }

    private static boolean calculateExpectedFileSize(File fileToTest){
        //Based on the file format calculate the approximate file size
        return false;
    }

}
