package com.h.test.customermoneyview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.text.Selection;
import android.text.Spannable;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by H on 16/2/18.
 */
public class UIUtils {

    public static void showInputKey(Handler handler, final EditText editText){
        //显示输入法
        final InputMethodManager inputManager =
                (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                inputManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        },500);
    }


    public static void showInputEvent(boolean flag, EditText commentView) {

        InputMethodManager inputManager =
                (InputMethodManager) commentView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (flag) {
            commentView.setFocusable(true);
            commentView.setFocusableInTouchMode(true);
            commentView.requestFocus();
            inputManager.showSoftInput(commentView, 0);
        } else {
            boolean isOpen = inputManager.isActive();
            if (isOpen) {
                inputManager.hideSoftInputFromWindow(commentView.getWindowToken(), 0);
            }
        }

    }

    /**
     * 获取状态栏高度
     */
    public static int getStatusHeight(Activity activity) {
        int statusHeight = 0;
        Rect localRect = new Rect();
        activity.getWindow().getDecorView()
                .getWindowVisibleDisplayFrame(localRect);
        statusHeight = localRect.top;
        if (0 == statusHeight) {
            Class<?> localClass;
            try {
                localClass = Class.forName("com.android.internal.R$dimen");
                Object localObject = localClass.newInstance();
                int i5 = Integer.parseInt(localClass
                        .getField("status_bar_height").get(localObject)
                        .toString());
                statusHeight = activity.getResources()
                        .getDimensionPixelSize(i5);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return statusHeight;
    }


    /**
     * 跳转到浏览器
     */
    public static void jumpBrowser(Context mContext, String path) {
        try {
            Uri uri = Uri.parse(path);
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 将EditText的光标定位到字符的最后面
    public static void setEditTextCursorLocation(EditText editText) {
        CharSequence text = editText.getText();
        if (text instanceof Spannable) {
            Spannable spanText = (Spannable) text;
            Selection.setSelection(spanText, text.length());
        }
    }

    /**
     * 格式化
     */
    private static DecimalFormat dfs = null;

    public static DecimalFormat format(String pattern) {
        if (dfs == null) {
            dfs = new DecimalFormat();
        }
        dfs.setRoundingMode(RoundingMode.FLOOR);
        dfs.applyPattern(pattern);
        return dfs;
    }

}
