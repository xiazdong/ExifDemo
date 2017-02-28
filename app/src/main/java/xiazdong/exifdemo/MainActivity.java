package xiazdong.exifdemo;

import android.net.Uri;
import android.media.ExifInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import xiazdong.exifdemo.util.FileUtils;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //byte[] data = FileUtils.openJpgFromAsset(this, "f8t.jpg");
        //Log.i(TAG, FileUtils.bytesToHexString(data));
        try {
            ExifInterface exif = new ExifInterface("/sdcard/test-exiforientation/f8t.jpg");
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            Log.i(TAG, orientation+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获得
     * @param name
     * @return
     */
    private String getJpegHexData(String name) {
        return FileUtils.bytesToHexString(FileUtils.openJpgFromAsset(this, name));
    }
}
