package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean flashlightavailable=false;
    private boolean flashon=false;
    ImageView powerbutton;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerbutton=findViewById(R.id.button);
        text=findViewById(R.id.switch_txt);

        flashlightavailable=getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        Log.d("CHAMAN", "onCreate: "+flashlightavailable);
        Log.d("CHAMAN", "onCreate:emu "+isEmulator());
       if(flashlightavailable&&!isEmulator()){
           try {
               CameraManager CM=(CameraManager) getSystemService(Context.CAMERA_SERVICE);
               String CId= CM.getCameraIdList()[0];
               CM.setTorchMode(CId,true);
//            turnonnflash();
            text.setText("OFF");
            flashon=true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
       }else{
           Toast.makeText(MainActivity.this, "Flashlight not available", Toast.LENGTH_SHORT).show();
       }
        powerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flashlightavailable){
                    //if flash is Available
                    if(flashon){
                        //Check if flash is on
                        flashon=false;
                        text.setText("ONN");
                        try {
                            //Turning off flash
                            turnoffflash();
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Flashlight not available", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                       flashon= true;
                       text.setText("OFF");
                        try {
                            //Turning ONN flash
                            turnonnflash();
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    // If flash is not available
                    Toast.makeText(MainActivity.this, "Flashlight not available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void turnoffflash() throws CameraAccessException {
        CameraManager CM=(CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String CId= CM.getCameraIdList()[0];
        CM.setTorchMode(CId,false);
        Toast.makeText(MainActivity.this, "Flashlight OFF", Toast.LENGTH_SHORT).show();

    }

    private void turnonnflash() throws CameraAccessException {
        CameraManager CM=(CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String CId= CM.getCameraIdList()[0];
        CM.setTorchMode(CId,true);
        Toast.makeText(MainActivity.this, "Flashlight ONN", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        // on pause the flash is turning off
        super.onPause();
        if(!flashon){
            Toast.makeText(this, "Flash is already turned off", Toast.LENGTH_SHORT).show();
        }else {
            flashon = true;
            try {
                turnoffflash();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onResume() {
        //on resume the flash is turning onn
        super.onResume();
        if(!flashon){
            Toast.makeText(this, "Please turn onn flash", Toast.LENGTH_SHORT).show();
        }else {
            flashon = true;
            try {
                turnonnflash();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity Destroyed", Toast.LENGTH_SHORT).show();
    }

    private boolean isEmulator(){
    if (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")
            || Build.FINGERPRINT.startsWith("generic")
            || Build.FINGERPRINT.startsWith("unknown")
            || Build.HARDWARE.contains("goldfish")
            || Build.HARDWARE.contains("ranchu")
            || Build.MODEL.contains("google_sdk")
            || Build.MODEL.contains("Emulator")
            || Build.MODEL.contains("Android SDK built for x86")
            || Build.MANUFACTURER.contains("Genymotion")
            || Build.PRODUCT.contains("sdk_google")
            || Build.PRODUCT.contains("google_sdk")
            || Build.PRODUCT.contains("sdk")
            || Build.PRODUCT.contains("sdk_x86")
            || Build.PRODUCT.contains("sdk_gphone64_arm64")
            || Build.PRODUCT.contains("vbox86p")
            || Build.PRODUCT.contains("emulator")
            || Build.PRODUCT.contains("simulator")){
        return true;
    }
    return false;
}
}