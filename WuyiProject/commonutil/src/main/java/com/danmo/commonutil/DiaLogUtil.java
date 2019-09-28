package com.danmo.commonutil;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;


/**
 * @version V1.0 <dialog封装>
 * @FileName: com.example.liujiancheng.tnsapsubmitoffice.utils.DiaLogUtil.java
 * @author: Liu jiancheng
 * @date: 2017-06-22 08:44
 */
public class DiaLogUtil {
    /**
     *
     * @param context dialog上下文
     * @param message dialog int message
     * @param clickListener dialog clickListener
     * @return   单个显示信息dialog
     */
    public static Dialog showNormalDialog(
            Context context,
            int message,
            OnClickListener clickListener,
            OnClickListener listener
    ){
        Dialog dialog = null;
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_menu_help)
                .setTitle("提示")
                .setMessage(message)
                .setPositiveButton("确定",clickListener)
                .setNegativeButton("取消",listener)
                .setCancelable(false)
                .show();
        return dialog;
    }
    /**
     *
     * @param context dialog上下文
     * @param message dialog int message
     * @param clickListener dialog clickListener
     * @return   单个显示信息dialog
     */
    public static Dialog showNormalStringDialog(
            Context context,
            String message,
            OnClickListener clickListener,
            OnClickListener listener
    ){
        Dialog dialog = null;
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_menu_help)
                .setTitle("请检查如下信息:")
                .setMessage(message)
                .setPositiveButton("确定",clickListener)
                .setNegativeButton("取消",listener)
                .setCancelable(false)
                .show();
        return dialog;
    }

    /**
     * 单选框dialog
     * @param context dialog上下文
     * @param title dialog itemId
     * @param clickListener dialog clickListener
     * @param listener dialog clickListener
     * @return
     */
    public static Dialog ShowArrayDialog(
            int message,
            Context context,
            String[] title,
            OnClickListener clickListener,
            OnClickListener listener
    ){
        Dialog dialog = null;
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_menu_help)
                .setTitle(message)
                .setSingleChoiceItems(title,0,clickListener)
                .setNegativeButton("取消",listener)
                .show();
        return dialog;
    }
public static AlertDialog ShowArrayDialogAny(int message,
                                             Context context,
                                             String[] title,
                                             DialogInterface.OnMultiChoiceClickListener clickListener,
                                             OnClickListener positivelistener,
                                             OnClickListener negativelistener
                                                ){

    return new AlertDialog.Builder(context)
            .setIcon(android.R.drawable.ic_menu_help)
            .setTitle(message)
            .setMultiChoiceItems(title, new boolean[title.length],clickListener)
            .setPositiveButton("确定",positivelistener)
            .setNegativeButton("取消",negativelistener)
            .show();

}

    public static Dialog showEditDialog(
            Context context,
            String title,
            OnClickListener clickListener,
            View editText,
            OnClickListener listener
    ){

        Dialog dialog = null;
        dialog= new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_menu_help)
                .setTitle(title)
                .setView(editText)
                .setCancelable(false)
                .setPositiveButton("确定",clickListener)
                .setNegativeButton("取消",listener).show();
        return dialog;
    }

    public static Dialog showEditDialogNum(
            Context context,
            OnClickListener clickListener,
            OnClickListener listener
    ){
        Dialog dialog = null;
        EditText materialEditText = new EditText(context);
        materialEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_menu_help)
                .setTitle("请输入")
                .setView(materialEditText)
                .setPositiveButton("确定",clickListener)
                .setNegativeButton("取消",listener)
                .show();
        return dialog;
    }

    public static Dialog showNewEditDialog(
            Context context,
            String title,
            OnClickListener clickListener,
            View editText,
            OnClickListener listener
    ){

        Dialog dialog = null;
        dialog= new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_menu_help)
                .setTitle(title)
                .setView(editText)
                .setCancelable(false)
                .setPositiveButton("取消",listener)
                .setNegativeButton("确定",clickListener).show();

        return dialog;
    }
}
