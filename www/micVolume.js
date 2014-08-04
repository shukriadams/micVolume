var micVolume = {
    start: function(successCallback, errorCallback) {
 		cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'MicVolumePlugin', // mapped to our native Java class called "Calendar"
            'start', // with this action name
            []
        ); 
    },
    read: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'MicVolumePlugin', // mapped to our native Java class called "Calendar"
            'read', // with this action name
            []
        ); 
    },
    stop: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'MicVolumePlugin', // mapped to our native Java class called "Calendar"
            'stop', // with this action name
            []
        ); 
    }    

}
module.exports = micVolume;