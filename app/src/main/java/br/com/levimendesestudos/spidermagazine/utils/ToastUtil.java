package br.com.levimendesestudos.spidermagazine.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 809778 on 22/12/2016.
 */

public class ToastUtil {

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void showToast(Context context, int idMsg) {
        Toast.makeText(context, idMsg, Toast.LENGTH_LONG).show();
    }
}
