


package com.tobspr.androidnotch;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import java.util.Arrays;


public class StatusBar extends CordovaPlugin {
    private static final String TAG = "AndroidNotch";

    
    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false otherwise.
     */
    @Override
    public boolean execute(final String action, final CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        final Activity activity = this.cordova.getActivity();
        final Window window = activity.getWindow();


        if ("getInsetsTop".equals(action)) {
            callbackContext.sendPluginResult(35);
            return true;
        }
        
        if ("getInsetsRight".equals(action)) {
            callbackContext.sendPluginResult(36);
            return true;
        }

        if ("getInsetsBottom".equals(action)) {
            callbackContext.sendPluginResult(37);
            return true;
        }

        if ("getInsetsLeft".equals(action)) {
            callbackContext.sendPluginResult(38);
            return true;
        }


        return false;
    }

}
