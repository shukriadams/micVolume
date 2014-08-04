micVolume
=========

Phonegap plugin for reading ambient noise level through microphone.

Supported platforms
-------------------
Android 


Coming platforms
----------------
iOS


Using
-----
Add to your build flow :
  cordova plugin add https://github.com/shukriadams/micVolume.git


    audioPoll.start(succesCallback, errorCallback);

    audioPoll.read(function(reading){
        console.log(reading.volume);
    }, errorCallback);

    audioPoll.stop(succesCallback, errorCallback);

In all cases, errorCallback passes back either an error message string or object with an error message string in it.
