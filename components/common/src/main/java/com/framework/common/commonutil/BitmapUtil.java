package com.framework.common.commonutil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Project:ChintPay
 * Author:dyping
 * Date:2017/6/27 14:53
 */

public class BitmapUtil {

    public static File compressBitmap(Context context, File srcFile) {

        String srcFileName = srcFile.getName();
        String srcFilePath = srcFile.getPath();
        File outPathDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File outFile = new File(outPathDir.getPath() + "/" + srcFileName);
        if (!outFile.exists()) {
            try {
                outFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Bitmap srcBitmap = BitmapFactory.decodeFile(srcFilePath);
        if (outputStream != null) {
            srcBitmap.compress(Bitmap.CompressFormat.JPEG, 30, outputStream);
        }

        return outFile;
    }


}
