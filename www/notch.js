

var exec = require("cordova/exec");

var AndroidNotch = {


    hasCutout: function(success, error) {
        exec(success, error, "AndroidNotch", "hasCutout");
    },
    
    setLaoyut: function(success, error) {
        exec(success, error, "AndroidNotch", "setLayout");
    },

    getInsetTop: function (success, error) {
        exec(success, error, "AndroidNotch", "getInsetsTop");
    },
    
    getInsetRight: function (success, error) {
        exec(success, error, "AndroidNotch", "getInsetsRight");
    },
    
    getInsetBottom: function (success, error) {
        exec(success, error, "AndroidNotch", "getInsetsBottom");
    },
    
    getInsetLeft: function (success, error) {
        exec(success, error, "AndroidNotch", "getInsetsLeft");
    }

};


module.exports = AndroidNotch;