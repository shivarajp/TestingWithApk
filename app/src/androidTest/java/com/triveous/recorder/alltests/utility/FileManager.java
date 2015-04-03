package com.triveous.recorder.alltests.utility;

import android.os.Environment;
import android.util.Log;

import com.triveous.recorder.alltests.recording.Recorder;
import com.triveous.recorder.alltests.recording.Settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Shivam on 11/5/2014.
 */
public class FileManager {

    private static final String SEPARATOR =
            "--------------------------------------------------" +
                    System.getProperty("line.separator") +
                    "Time:- " + getCurrentTime() +
                    System.getProperty("line.separator") +
                    "--------------------------------------------------" +
                    System.getProperty("line.separator");

    private static final String HTML_START ="<html>" +
                                             "<head>Report</head>" +
                                             "<body><div>";
    private static final String HTML_END ="</div></body></html>";


    public static void writeLog(String data) {
        try {
            FileOutputStream fOut = new FileOutputStream(Settings.getmLogFile(), true);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            // myOutWriter.append(SEPARATOR);
            myOutWriter.append(data);
            myOutWriter.flush();
            fOut.flush();
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            Log.d("Error writing Log", "" + e.getMessage());
        }
    }

    /**
     * List all the file names,size and writes to file.
     */
    public static void writeFileNames() {
        try {
            FileOutputStream fOut = new FileOutputStream(Settings.getmLogFile(), true);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.append(SEPARATOR);
            myOutWriter.append(FileManager.getAllFileNames(FileManager.getParentDir()));
            myOutWriter.close();
            fOut.close();
        } catch (Exception e) {
            Log.d("Error writing Log", "" + e.getMessage());
        }
    }

    public static File createLogFile() {
        int count = 0;
        String path = Environment.getExternalStorageDirectory() + "/Logg";
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            //Do nothing
        } else {
            dir.mkdir();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        Date date = new Date();
        String name = "LogFile-" + dateFormat.format(date).toString();
        path += "/" + name;
        try {
            File f1 = new File(path + ".mp3");
            File f2 = new File(path + ".wav");

            while (f1.exists() || f2.exists()) {
                f1 = null;
                f2 = null;
                count++;
                name = name + "-" + count;
                path += name;
                f1 = new File(path + ".mp3");
                f2 = new File(path + ".wav");
            }
            return new File(path + ".txt");
        } catch (Exception e) {
            Log.d("File creation error", "" + e);
        }
        return new File(path + ".txt");
    }

    public static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        Date date = new Date();
        return dateFormat.format(date).toString();
    }

    public static String getAllFileNames(File parentDir) {
        String allFileNames = "";
        File[] files = parentDir.listFiles();
        for (File file : files) {
            if (!file.isDirectory()) {
                allFileNames += "Name->" + file.getName() +
                        System.getProperty("line.separator") + "Size->" +
                        file.getTotalSpace() + System.getProperty("line.separator");
            }
        }
        return allFileNames;
    }

    public static File getParentDir() {
        return new File(Environment.getExternalStorageDirectory() + "/AudioRecorder");
    }

    public static String getUniqueName() {
        Date date = null;
        DateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        date = new Date();
        return dateFormat.format(date).toString();
    }

    public static void assertFileNames() {
        String fileNames = FileManager.getAllFileNames(FileManager.getParentDir());
        for (int i = 0; i < Recorder.getmRecordings().size(); i++) {
            if (fileNames.contains(Recorder.getmRecordings().get(i))) {
                continue;
            } else {
                writeLog(System.getProperty("line.separator") + Recorder.getmRecordings().get(i) +
                        " File Not Found in directory" + System.getProperty("line.separator"));
            }
        }
    }

    public static ArrayList<String> getTests() {
        File file = getDefaultFile();
        ArrayList<String> tests = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                tests.add(line);
            }
            br.close();
        } catch (Exception e) {

        }
        return tests;
    }

    private static File getDefaultFile() {
        return new File(Environment.getExternalStorageDirectory() + "/AudioRecorder/tests.txt");
    }

    public static boolean fileExist(String fileName){
        try {
            String path = getParentDir().toString()+"/"+fileName;
            File f1 = new File(path + ".mp3");
            File f2 = new File(path + ".wav");

            while (f1.exists() || f2.exists()) {
                Log.d("", "" + f1.getName() + f2.getName());
                return true;
            }
        } catch (Exception e) {
            Log.d("File creation error", "" + e);
        }
        return false;
    }

    public static File returnFile(File parentDir, String fileName) {
        File[] files = parentDir.listFiles();
        for (File file : files) {
            if (file.getName().contains(fileName) && !file.isDirectory()) {
                return file;
            }else {
                Log.d("", "different file");
            }
        }
        return null;
    }

    public static File createHtmlReport(File txtFile){
        //File htmlReport = createLogFile().na;

        return txtFile;
    }

}
