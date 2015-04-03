package com.triveous.recorder.alltests.images;

import com.robotium.solo.Solo;
import com.triveous.recorder.alltests.Test;

/**
 * Created by Shivam on 11/28/2014.
 */

public class ImagesOperations {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    //The view position in the listview
    public static final int VIEW_POSITION = 56;

    public static void addImages() {
        Solo solo = Test.getSolo();
        swipe(solo, RIGHT);
        clickOn_Add_An_Image(solo);
        addImagesFromGallery(solo);
    }

    public static void swipe(Solo solo, int side) {
        if (side == LEFT) {
            solo.scrollViewToSide(solo.getView("pager"), Solo.LEFT);
            solo.sleep(5000);
        } else {
            solo.scrollViewToSide(solo.getView("pager"), Solo.RIGHT);
            solo.sleep(5000);
        }
    }

    /**
     * Find the recording and click on add an Image in the overflow menu.
     *
     * @param solo
     */

    public static void clickOn_Add_An_Image(Solo solo) {

        // Test.getActivityInstrumentationTestCase2().assertTrue("RecorderListFragment is not found!", solo.waitForActivity("RecorderListFragment"));
        solo.sleep(729);
        //Click on ImageView
       // solo.clickOnView(solo.getView(com.triveous.recorder.R.id.recordsOverflow));
        solo.sleep(1000);
        //It will click on listview firts item 5th overflow
        solo.clickInList(5, 0);
        //Wait for activity: 'com.triveous.recorder.ui.images.ImageWizardActivity'
        // Test.getActivityInstrumentationTestCase2().assertTrue("com.triveous.recorder.ui.images.ImageWizardActivity is not found!", solo.waitForActivity(com.triveous.recorder.ui.images.ImageWizardActivity.class));
        solo.sleep(2000);
    }

    /**
     * Clicks on add button in the ImageWizardActivity and add images from gallery
     * @param solo
     */
    public static void addImagesFromGallery(Solo solo){

    }

    /**
     * Delete the images from the ImageWizardActivity grid view.
     */
    public static void deleteImagesFromGridView() {

    }

    /**
     * Clicks on Next button at the bottom of ImageWizardActivity.
     * @param solo
     */
    public static void clickOnNext(Solo solo){

    }

    /**
     * Clicks on Cancel button at the bottom of ImageWizardActivity.
     * @param solo
     */
    public static void clickOnCancel(Solo solo){

    }

    /**
     * Clicks on Priveous button at the bottom of ImageWizardActivity.
     * @param solo
     */
    public static void clickOnPriveous(Solo solo){

    }

    /**
     * Clicks on Finish button at the bottom of ImageWizardActivity.
     * @param solo
     */
    public static void clickOnFinish(Solo solo){

    }

    /**
     * Clicks on Timing button at the bottom of ImageWizardActivity.
     * Auto, 2sec, 5sec
     * @param solo
     */
    public static void clickOnTime(Solo solo){

    }

    /**
     * Rearranges the pictures randomly in the grid view.
     * @param solo
     */
    public static void rearrangePicturesRandomly(Solo solo){

    }
}
