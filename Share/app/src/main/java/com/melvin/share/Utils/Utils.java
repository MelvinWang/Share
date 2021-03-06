package com.melvin.share.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Environment;
import android.support.v4.view.MotionEventCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.aigestudio.wheelpicker.widget.curved.WheelDatePicker;

import java.util.Date;

/**
 * Created Time: 2016/7/17.
 * <p>
 * Author:Melvin
 * <p>
 * 功能： Toast,Share等实用工具
 */
public class Utils {
    private static final String endpoint = "http://oss-cn-beijing.aliyuncs.com/importantfile/";
    public static Toast mToast;
    public static SharedPreferences mPref;

    public static void showToast(Context mContext, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 获取oss固定字符串的长度
     */
    public static int getOssUrlLength() {
        return endpoint.length();
    }

    /**
     * 获取share
     */
    public static SharedPreferences getShare(Context mContext) {
        mPref = mContext.getSharedPreferences("config", mContext.MODE_PRIVATE);
        return mPref;
    }

    /**
     * 获取refreshToken
     */
    public static String getRefreshToken(Context mContext) {
        mPref = getShare(mContext);
        String refreshToken = mPref.getString("refreshToken", null);
        return refreshToken;
    }

    /**
     * 获取token
     */
    public static String getToken(Context mContext) {
        mPref = getShare(mContext);
        String token = mPref.getString("token", null);
        return token;
    }

    /**
     * 获取token
     */
    public static String getBranchId(Context mContext) {
        mPref = getShare(mContext);
        String branchId = mPref.getString("branchId", null);
        return branchId;
    }


    /**
     * 获取token
     */
    public static String getUserPhone(Context mContext) {
        mPref = getShare(mContext);
        String userphone = mPref.getString("username", null);
        return userphone;
    }


    /**
     * dip转换px
     */
    public static int dip2px(int dip, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */

    public static int px2dip(int px, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * dip 转换成 px
     *
     * @param dip
     * @param context
     * @return
     */
    public static float dip2Dimension(float dip, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, displayMetrics);
    }

    /**
     * @param dip
     * @param context
     * @param complexUnit {@link TypedValue#COMPLEX_UNIT_DIP} {@link TypedValue#COMPLEX_UNIT_SP}}
     * @return
     */
    public static float toDimension(float dip, Context context, int complexUnit) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(complexUnit, dip, displayMetrics);
    }

    /**
     * 判断外部存储是否正常
     *
     * @param
     * @return
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取状态栏高度
     *
     * @param v
     * @return
     */
    public static int getStatusBarHeight(View v) {
        if (v == null) {
            return 0;
        }
        Rect frame = new Rect();
        v.getWindowVisibleDisplayFrame(frame);
        return frame.top;
    }

    public static String getActionName(MotionEvent event) {
        String action = "unknow";
        switch (MotionEventCompat.getActionMasked(event)) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_SCROLL:
                action = "ACTION_SCROLL";
                break;
            case MotionEvent.ACTION_OUTSIDE:
                action = "ACTION_SCROLL";
                break;
            default:
                break;
        }
        return action;
    }
    public static WheelDatePicker createWheelDate(Context context, int padding, int textSize, int itemSpace) {
        WheelDatePicker wheelDatePicker = new WheelDatePicker(context);
        wheelDatePicker.setPadding(padding, 0, padding, 0);
        wheelDatePicker.setBackgroundColor(0xffffff);
        wheelDatePicker.setTextColor(0xFF7787C5);
        wheelDatePicker.setCurrentTextColor(0xFF7774B7);
        wheelDatePicker.setLabelColor(0xFF7774B7);
        wheelDatePicker.setTextSize(textSize);
        wheelDatePicker.setItemSpace(itemSpace);
        String dateLong = DateUtil.getDateLong(new Date());
        String[] split = dateLong.split("-");
        wheelDatePicker.setCurrentDate(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        return wheelDatePicker;
    }



}
