

var run = require("cordova/exec");

var AndroidNotch = {


    hasCutout: function(success, error) {
        run(success, error, "AndroidNotch", "hasCutout");
    },

    setLaoyut: function(success, error) {
        run(success, error, "AndroidNotch", "setLayout");
    },

    getInsetTop: function (success, error) {
        run(success, error, "AndroidNotch", "getInsetsTop");
    },
    
    getInsetRight: function (success, error) {
        run(success, error, "AndroidNotch", "getInsetsRight");
    },
    
    getInsetBottom: function (success, error) {
        run(success, error, "AndroidNotch", "getInsetsBottom");
    },
    
    getInsetLeft: function (success, error) {
        run(success, error, "AndroidNotch", "getInsetsLeft");
    }

};


module.exports = AndroidNotch;