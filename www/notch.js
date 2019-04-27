

var exec = require("cordova/exec");

var AndroidNotch = {

    getInsetTop: function (success, error) {
        success(30);
    },

    getInsetRight: function (success, error) {
        success(31);
    },

    getInsetBottom: function (success, error) {
        success(32);
    },

    getInsetLeft: function (success, error) {
        success(33);
    }

};


module.exports = AndroidNotch;