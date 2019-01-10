package com.northernbrain.getpermission;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import java.util.HashSet;

/**
 * @author NorthernBrain
 * @version v1.0
 * @see GetDrug All dangerous permission applications after Android 6.0.
 * After Android 6.0, some permissions need to be dynamically applied to use.
 */
public class GetDrug {
    /**
     * @NEED_SDK_VERSION Sdk version
     */
    private static final int NEED_SDK_VERSION = 22;

    /**
     * @PermissionList Permissions you choose
     */
    private static HashSet<String> PermissionList = new HashSet<>();

    /**
     * @PERMISSIONS_GROUP All permissions
     */
    @SuppressLint("InlinedApi")
    private static final String[] PERMISSIONS_GROUP = {
            Manifest.permission.READ_CALENDAR,
            Manifest.permission.WRITE_CALENDAR,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.GET_ACCOUNTS,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CALL_LOG,
            Manifest.permission.WRITE_CALL_LOG,
            Manifest.permission.ADD_VOICEMAIL,
            Manifest.permission.USE_SIP,
            Manifest.permission.PROCESS_OUTGOING_CALLS,
            Manifest.permission.BODY_SENSORS,
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS,
            Manifest.permission.READ_SMS,
            Manifest.permission.RECEIVE_WAP_PUSH,
            Manifest.permission.RECEIVE_MMS,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private static String[] PERMISSIONS_LIST = new String[PERMISSIONS_GROUP.length];

    /**
     * Call this method you can directly get all the dangerous permissions after Android 6.0
     *
     * @param activity Your Activity.
     */
    public void getAllPermission(Activity activity) {
        if (android.os.Build.VERSION.SDK_INT > NEED_SDK_VERSION) {
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, PERMISSIONS_GROUP, 600);
            }
        }
    }

    public static final class Applicator {
        private Activity activity;

        public Applicator(Activity activity) {
            this.activity = activity;
        }

        /**
         * Dynamically get calendar permissions
         *
         * @return this
         */
        public Applicator getCalendar() {
            PermissionList.add(PERMISSIONS_GROUP[0]);
            PermissionList.add(PERMISSIONS_GROUP[1]);
            return this;
        }

        /**
         * Dynamically get camera permissions
         *
         * @return
         */
        public Applicator getCamera() {
            PermissionList.add(PERMISSIONS_GROUP[2]);
            return this;
        }

        /**
         * Dynamically get contact permissions
         *
         * @return
         */
        public Applicator getContact() {
            PermissionList.add(PERMISSIONS_GROUP[3]);
            PermissionList.add(PERMISSIONS_GROUP[4]);
            PermissionList.add(PERMISSIONS_GROUP[5]);
            return this;
        }

        /**
         * Dynamically get location permissions
         *
         * @return
         */
        public Applicator getLocation() {
            PermissionList.add(PERMISSIONS_GROUP[6]);
            PermissionList.add(PERMISSIONS_GROUP[7]);
            return this;
        }

        /**
         * Dynamically get microphone permissions
         *
         * @return
         */
        public Applicator getMicrophone() {
            PermissionList.add(PERMISSIONS_GROUP[8]);
            return this;
        }

        /**
         * Dynamically get phone permissions
         *
         * @return
         */
        public Applicator getPhone() {
            PermissionList.add(PERMISSIONS_GROUP[9]);
            PermissionList.add(PERMISSIONS_GROUP[10]);
            PermissionList.add(PERMISSIONS_GROUP[11]);
            PermissionList.add(PERMISSIONS_GROUP[12]);
            PermissionList.add(PERMISSIONS_GROUP[13]);
            PermissionList.add(PERMISSIONS_GROUP[14]);
            PermissionList.add(PERMISSIONS_GROUP[15]);
            return this;
        }

        /**
         * Dynamically get sensor permissions
         *
         * @return
         */
        public Applicator getSensor() {
            PermissionList.add(PERMISSIONS_GROUP[16]);
            return this;
        }

        /**
         * Dynamically get sms permissions
         *
         * @return
         */
        public Applicator getSms() {
            PermissionList.add(PERMISSIONS_GROUP[17]);
            PermissionList.add(PERMISSIONS_GROUP[18]);
            PermissionList.add(PERMISSIONS_GROUP[19]);
            PermissionList.add(PERMISSIONS_GROUP[20]);
            PermissionList.add(PERMISSIONS_GROUP[21]);
            return this;
        }

        /**
         * Dynamically get storage permissions
         *
         * @return
         */
        public Applicator getStorage() {
            PermissionList.add(PERMISSIONS_GROUP[22]);
            PermissionList.add(PERMISSIONS_GROUP[23]);
            return this;
        }

        public GetDrug heal() {
            if (PermissionList.size() > 0) {
                String[] PERMISSION_READY = (String[]) PermissionList.toArray(new String[0]);
                if (PERMISSION_READY.length != 0) {
                    if (android.os.Build.VERSION.SDK_INT > NEED_SDK_VERSION) {
                        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(activity, PERMISSION_READY, 600);
                        }
                    }
                }
            } else {
                /**
                 * Correct example:
                 * GetDrug getDrug = new GetDrug.Applicator(new Activity())
                 *             .getCalendar()
                 *             .getContact()
                 *             ...
                 *             .heal();
                 * Get the permissions you want.Cannot call the heal() method directly,Otherwise it will go wrong
                 * @RuntimeException 不能够直接调用heal() 这个方法
                 */
                throw new RuntimeException("I need a formula to heal.（不能够直接调用heal() 这个方法）");
            }

            return null;
        }
    }
}