cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "js/plugins/notification.js",
        "id": "org.apache.cordova.dialogs.notification",
        "merges": [
            "navigator.notification"
        ]
    },
    {
        "file": "js/plugins/android/notification.js",
        "id": "org.apache.cordova.dialogs.notification_android",
        "merges": [
            "navigator.notification"
        ]
    },
    {
        "file": "js/plugins/device.js",
        "id": "org.apache.cordova.device.device",
        "clobbers": [
            "device"
        ]
    },
    {
        "file": "js/plugins/InAppBrowser.js",
        "id": "org.apache.cordova.inappbrowser.InAppBrowser",
        "clobbers": [
            "window.open"
        ]
    },
    {
        "file": "js/plugins/network.js",
        "id": "org.apache.cordova.network-information.network",
        "clobbers": [
            "navigator.connection",
            "navigator.network.connection"
        ]
    },
    {
        "file": "js/plugins/Connection.js",
        "id": "org.apache.cordova.network-information.Connection",
        "clobbers": [
            "Connection"
        ]
    },
    {
        "file": "js/plugins/splashscreen.js",
        "id": "org.apache.cordova.splashscreen.SplashScreen",
        "clobbers": [
            "navigator.splashscreen"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "org.apache.cordova.splashscreen": "0.2.4",
    "org.apache.cordova.inappbrowser": "0.2.4",
    "org.apache.cordova.dialogs": "0.2.3",
    "org.apache.cordova.vibration": "0.3.4",
    "org.apache.cordova.device": "0.2.7",
    "org.apache.cordova.network-information": "0.2.7"
}
// BOTTOM OF METADATA
});