package com.triveous.recorder.alltests.dropbox;

import com.robotium.solo.Solo;

/**
 * Created by Shivam on 11/4/2014.
 */
public class DropboxFileNameValidator {

    public static boolean isFileNamePresent(Solo solo){

        solo.sleep(5000);
        solo.scrollViewToSide(solo.getView("pager"), Solo.RIGHT);
        solo.sleep(3181);
        android.widget.ListView listView0 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
        for(;;) {
            solo.scrollListToLine(listView0, 6);
            if (solo.searchText("Recording")) {
                solo.sleep(5000);
            }
        }
    }
}
