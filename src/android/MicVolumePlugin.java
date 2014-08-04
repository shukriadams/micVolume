package com.shukriadams.micVolume;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;

// used by audio
import android.os.Bundle;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

public class MicVolumePlugin extends CordovaPlugin 
{
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    try 
    {
      if (action.equals("start")){
        start(callbackContext);
      } else if (action.equals("read")){
        read(callbackContext);
      } else if (action.equals("stop")){
        stop(callbackContext);
      } else {
        callbackContext.error("Unsupported action");
      }

      /*
      JSONObject returnObj = new JSONObject();
      returnObj.put("title", "you should still be seeing this");
          callbackContext.success(returnObj); // pass return object back here
          */
        return true;
    } 
    catch(Exception e) 
    {
        System.err.println("Exception: " + e.getMessage());
        callbackContext.error(e.getMessage());
        return false;
    }    
  }

    private short[] buffer = null;
    private AudioRecord audioRecord = null;
    private int bufferSize= 1024;
    private float volume = 0;
    private int buflen;
 
    private void start(CallbackContext callbackContext) {
    int freq =44100;
        int chan = AudioFormat.CHANNEL_IN_MONO;
        int enc  = AudioFormat.ENCODING_PCM_16BIT;
        int src  = MediaRecorder.AudioSource.MIC;
        buflen = AudioRecord.getMinBufferSize(freq, chan, enc);
        audioRecord = new AudioRecord(src,freq,chan,enc,buflen);
 
        audioRecord.startRecording();
        buffer = new short[bufferSize];

        callbackContext.success();
    }
 
    private void read(CallbackContext callbackContext) throws JSONException
    {

      JSONObject returnObj = new JSONObject();
    
        double amplitude = 0;
        int bufferReadResult = audioRecord.read(buffer, 0, buffer.length);
        double sumLevel = 0;
        for (int i = 0; i < bufferReadResult; i++) {
          sumLevel += buffer[i];
        }
        amplitude = Math.abs((sumLevel / bufferReadResult));

        returnObj.put("volume", Math.sqrt(amplitude));
       callbackContext.success(returnObj);
    }

    private void stop(CallbackContext callbackContext) {
      audioRecord.stop();
      audioRecord.release();
      audioRecord = null;

      callbackContext.success();
    } 
}



 

