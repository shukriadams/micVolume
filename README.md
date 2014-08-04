micVolume
=========

Phonegap plugin for reading ambient noise level through microphone.

Supported platforms
===================
Android 


Coming platforms
===================
iOS


Using
=====

	audioPoll.start(succesCallback, errorCallback);

    audioPoll.read(function(reading){
        console.log(reading.volume);
    }, errorCallback);

    audioPoll.stop(succesCallback, errorCallback);

In all cases, errorCallback passes back an object that contains an error message.
