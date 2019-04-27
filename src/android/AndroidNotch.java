


package com.tobspr.androidnotch;

import org.apache.cordova.CordovaPlugin;


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
        return false;
    }

}
