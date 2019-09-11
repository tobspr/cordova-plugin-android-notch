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


## SCSS Snippet

Assuming you set the `--notch-inset-top` variables as described above, you can use this SCSS snippet to make the notch work on android and iOs:

```scss
// ----------------------------------------
/* Defines a property which is affected by the safe area */
@mixin SafeAreaTop($propToModify, $add: 0px, $important: false) {
    $importantStr: "";
    @if ($important) {
        $importantStr: "!important";
    }
    #{$propToModify}: #{$add} #{$importantStr};
    #{$propToModify}: calc(#{$add} + var(--notch-inset-top)) #{$importantStr};
    #{$propToModify}: calc(#{$add} + constant(safe-area-inset-top) + var(--notch-inset-top)) #{$importantStr};
    #{$propToModify}: calc(#{$add} + env(safe-area-inset-top, 0px) + var(--notch-inset-top)) #{$importantStr};
}

// ----------------------------------------
/* Defines a property which is affected by the safe area */
@mixin SafeAreaRight($propToModify, $add: 0px, $important: false) {
    $importantStr: "";
    @if ($important) {
        $importantStr: " !important";
    }
    #{$propToModify}: #{$add} #{$importantStr};
    #{$propToModify}: calc(#{$add} + var(--notch-inset-right)) #{$importantStr};
    #{$propToModify}: calc(#{$add} + constant(safe-area-inset-right) + var(--notch-inset-right)) #{$importantStr};
    #{$propToModify}: calc(#{$add} + env(safe-area-inset-right, 0px) + var(--notch-inset-right)) #{$importantStr};
}

// ----------------------------------------
/* Defines a property which is affected by the safe area */
@mixin SafeAreaBottom($propToModify, $add: 0px, $important: false) {
    $importantStr: "";
    @if ($important) {
        $importantStr: " !important";
    }
    #{$propToModify}: #{$add} #{$importantStr};
    #{$propToModify}: calc(#{$add} + var(--notch-inset-bottom)) #{$importantStr};
    #{$propToModify}: calc(#{$add} + constant(safe-area-inset-bottom) + var(--notch-inset-bottom)) #{$importantStr};
    #{$propToModify}: calc(#{$add} + env(safe-area-inset-bottom, 0px) + var(--notch-inset-bottom)) #{$importantStr};
}

// ----------------------------------------
/* Defines a property which is affected by the safe area */
@mixin SafeAreaLeft($propToModify, $add: 0px, $important: false) {
    $importantStr: "";
    @if ($important) {
        $importantStr: " !important";
    }
    #{$propToModify}: #{$add} #{$importantStr};
    #{$propToModify}: calc(#{$add} + var(--notch-inset-left)) #{$importantStr};
    #{$propToModify}: calc(#{$add} + constant(safe-area-inset-left) + var(--notch-inset-left)) #{$importantStr};
    #{$propToModify}: calc(#{$add} + env(safe-area-inset-left, 0px) + var(--notch-inset-left)) #{$importantStr};
}
```

Usage Example:

```scss

body {
  @include SafeAreaTop(padding-top, 20px);
}

```
