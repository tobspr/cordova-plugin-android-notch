# cordova-plugin-android-notch

This plugin allows to query android notch insets.

For iOs, the insets are available as constant() and env() variables. However this doesn't work on android 9, which is where this plugin can help.

## Usage

```js

window.AndroidNotch.hasCutout(success => function(cutout) => {
    alert("Cutout: " + cutout);
}));

window.AndroidNotch.getInsetTop(success => function(insetSize) => {
    alert("Top Inset: " + insetSize);
}));

// There is also getInsetRight, getInsetBottom, getInsetLeft
```


If you want to use those variables in css, here's a possibility:

```js

// Call this on resize or orientationchange, but *after* the deviceready event
function detectInsets() {
    if (window.AndroidNotch) {
        const style = document.documentElement.style;

        // Apply insets as css variables

        window.AndroidNotch.getInsetTop(px => {
            style.setProperty("--notch-inset-top", px + "px");
        }, (err) => console.error("Failed to get insets top:", err));
        
        window.AndroidNotch.getInsetRight(px => {
            style.setProperty("--notch-inset-right", px + "px");
        }, (err) => console.error("Failed to get insets right:", err));
        
        window.AndroidNotch.getInsetBottom(px => {
            style.setProperty("--notch-inset-bottom", px + "px");
        }, (err) => console.error("Failed to get insets bottom:", err));
        
        window.AndroidNotch.getInsetLeft(px => {
            style.setProperty("--notch-inset-left", px + "px");
        }, (err) => console.error("Failed to get insets left:", err));
    }
}
```


Then in your css:

```css

:root {
    --notch-inset-top: 0px;
    --notch-inset-right: 0px;
    --notch-inset-bottom: 0px;
    --notch-inset-left: 0px;
}

/* Use it with var(--notch-inset-top) now, for example: */
body {
    padding-top: var(--notch-inset-top);
}

```

## Compatibility

This plugin works on all android versions, but we can only detect notches starting from Android 9. They have been available on Android 8 as vendor specific additions, but I haven't figured how to detect those yet. Feel free to make a PR!
