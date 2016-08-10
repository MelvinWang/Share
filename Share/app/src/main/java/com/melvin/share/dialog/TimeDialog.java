package com.melvin.share.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.aigestudio.wheelpicker.core.AbstractWheelPicker;
import com.aigestudio.wheelpicker.core.IWheelPicker;
import com.melvin.share.R;


/**
 * Author: Melvin
 * <p/>
 * Data： 2016/8/10
 * <p/>
 * 描述： 时间控件
 */
public class TimeDialog extends Dialog implements View.OnClickListener {
    private View root;
    private ViewGroup container;
    private TextView btnObtain;
    private IWheelPicker picker;
    private String timeResult;

    public TimeDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCanceledOnTouchOutside(true);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                container.removeAllViews();
            }
        });
        root = getLayoutInflater().inflate(R.layout.time_dialog, null);
        container = (ViewGroup) root.findViewById(R.id.main_dialog_container);
        btnObtain = (TextView) root.findViewById(R.id.btn_obtain);
        btnObtain.setOnClickListener(this);
    }

    @Override
    public void setContentView(View view) {
        if (view instanceof IWheelPicker) {
            picker = (IWheelPicker) view;
            picker.setOnWheelChangeListener(new AbstractWheelPicker.SimpleWheelChangeListener() {
                @Override
                public void onWheelScrollStateChanged(int state) {
                    if (state != AbstractWheelPicker.SCROLL_STATE_IDLE) {
                        btnObtain.setEnabled(false);
                    } else {
                        btnObtain.setEnabled(true);
                    }
                }

                @Override
                public void onWheelSelected(int index, String data) {
                    timeResult=data;
                }
            });
        }
        container.addView(view);
        super.setContentView(root);
    }

    @Override
    public void onClick(View v) {
//       WheelDatePicker wheelDatePicker = Utils.createWheelDate(getContext(), padding, textSize, itemSpace);
        switch (v.getId()) {
            case R.id.btn_obtain:
                mOnConfirmListener.onConFirmClick(timeResult);
                TimeDialog.this.dismiss();
                break;
        }
    }

    public interface OnConfirmListener {
        void onConFirmClick(String timeResult);
    }

    public OnConfirmListener mOnConfirmListener;

    public void setOnConfirmListener(OnConfirmListener onConfirmListener) {
        this.mOnConfirmListener = onConfirmListener;
    }

    ;

}