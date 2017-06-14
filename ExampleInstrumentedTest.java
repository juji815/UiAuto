package com.UiAuto_ForSetting;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Process;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObject2Condition;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.uiautomator.Until.findObject;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    UiDevice mDevices = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    Context mContext = InstrumentationRegistry.getContext();
    String APP = "com.android.settings";
    String text = "蓝牙";

//    @Test
//    public void useAppContext() throws Exception {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.UiAuto_ForSetting", appContext.getPackageName());
//    }
//
//    @Test
//    public void search() throws Exception {
//        UiObject searchButton = mDevices.findObject(new UiSelector().description("搜索设置"));
//        searchButton.click();
//        UiObject searchText = mDevices.findObject(new UiSelector().resourceId("android:id/search_src_text"));
//        searchText.setText("WLAN");
//        UiObject searchResult = mDevices.findObject(new UiSelector().className("android.widget.TextView").text("WLAN"));
//        searchResult.click();
//        UiObject switchBar = mDevices.findObject(new UiSelector().resourceId("com.android.settings:id/switch_bar"));
//        String status = switchBar.getText();
//        System.out.println("Current WIFI status is "+ status);
//        if (status.equals("开启")){
//            switchBar.click();
//            Thread.sleep(1000);
//            System.out.println("Current WIFI status is "+ switchBar.getText());
//            assertEquals("关闭", switchBar.getText());
//            this.getNetworkStatus(0);
//        }
//        else if (status.equals("关闭")){
//            switchBar.click();
//            Thread.sleep(1000);
//            System.out.println("2Current WIFI status is "+ switchBar.getText());
//            assertEquals("开启", switchBar.getText());
//            this.getNetworkStatus(1);
//        }
//        else{
//            Thread.sleep(1000);
//            System.out.println("Do Nothing");
//        }
//    }

    @Test
    public void test() throws Exception{
        getNetworkStatus(0);
    }

    private void getNetworkStatus(int status) throws Exception {
        Context context =  InstrumentationRegistry.getContext();
        ConnectivityManager connection = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network networks = connection.getActiveNetwork();
        //ip route
        try {
            int type =connection.getNetworkInfo(networks).getType();
            switch (type) {
                case 0:
                    System.out.println("Current Network is Mobile");
                    break;
                case 1:
                    System.out.println("Current Network is WiFi");
                    break;
                case 2:
                    System.out.println("Current Network is Mobile_MMS");
                    break;
                case 3:
                    System.out.println("Current Network is Mobile_SUPL");
                    break;
                case 4:
                    System.out.println("Current Network is Mobile_DUN");
                    break;
                case 5:
                    System.out.println("Current Network is Mobile_HIPRI");
                    break;
                case 6:
                    System.out.println("Current Network is WIMAX");
                    break;
                case 7:
                    System.out.println("Current Network is BT");
                    break;
                case 8:
                    System.out.println("Current Network is DUMMY");
                    break;
                case 9:
                    System.out.println("Current Network is ETHERNET");
                    break;
                case 17:
                    System.out.println("Current Network is VPN");
                    break;
                default:
                    System.out.println("UnKnown Type of " + type);
            }
        }catch(NullPointerException e){
            System.out.println("No Active Network");
        }
        finally {
            System.out.println(connection.getNetworkInfo(ConnectivityManager.TYPE_MOBILE));
            System.out.println(connection.getNetworkInfo(ConnectivityManager.TYPE_WIFI));
        }
//        for (Network network : networks){
//            System.out.println("Network is " + network);
//            System.out.println(connection.getNetworkInfo(network).getState());
//        }
        if (status == 0){
            System.out.println("Current WIFI status is CLOSED");

        }
        else if (status == 1){
            System.out.println("Current WIFI status is OPEN");
        }
        else{
            System.out.println("Current WIFI status is UNKNOWN");
        }
    }

    private void runExec(String command) throws Exception{
        Runtime runtime = Runtime.getRuntime();
        Process proc = (Process123) runtime.exec(command);
    }

//    @Test
//    public void guestrue() throws Exception {
//        mDevices.wakeUp();
//        UiObject2 photo = mDevices.findObject(By.pkg("com.oneplus.gallery"));
//        photo.pinchOpen(0.1f, 100);
//        photo.pinchClose(0.5f, 300);
//        photo.wait(findObject(By.textContains("屏幕截图")), 20000);
//        //photo.pinchOpen(0.5f);
//    }
//    @Test
//    public void startSetting() throws UiObjectNotFoundException {
//        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(APP);
//        mContext.startActivity(myIntent);
//        mDevices.waitForWindowUpdate(APP, 1000);
//        Boolean tmp = new UiScrollable(new UiSelector().packageName("com.android.settings")).scrollIntoView(new UiSelector().resourceId("com.android.settings:id/dashboard_tile").childSelector(new UiSelector().text(text)));
//        System.out.println("tmp is " + tmp);
//        if (tmp) {
//            UiObject bt = mDevices.findObject(new UiSelector().text(text));
//            bt.click();
//        }
//    }
}
