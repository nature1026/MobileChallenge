package com.kayshin.paytmlabs.view;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Kay on 2017-05-07.
 */

public class ViewUI {
    public static void showMessage(View parent, String message) {
        Snackbar.make(parent, message, Snackbar.LENGTH_SHORT).show();
    }
    public static void showMessage(View parent, String message, String action, View.OnClickListener onClickListener) {
        Snackbar snackbar = Snackbar.make(parent,
                message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(action, onClickListener);
        snackbar.show();
    }
}
