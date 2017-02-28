package xiazdong.exifdemo.util;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by damonxia on 17/2/27.
 */
public class FileUtils {

    /**
     *
     * @param context
     * @param fileName
     * @return
     */
    public static byte[] openJpgFromAsset(Context context, String fileName) {
        byte[] buffer = new byte[512];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            InputStream is = context.getResources().getAssets().open(fileName);
            int count = 0;
            while((count = is.read(buffer)) != -1) {
                out.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return out.toByteArray();
        }
    }

    /**
     * 字节数组转十六进制
     */
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
