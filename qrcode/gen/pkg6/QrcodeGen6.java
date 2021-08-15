/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcode.gen.pkg6;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author arturo
 */
public class QrcodeGen6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws WriterException, IOException {

        String message = args[0];
        String filename = args[1];
        String size = args[2];

        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = 
          barcodeWriter.encode(message, BarcodeFormat.QR_CODE, Integer.parseInt(size), Integer.parseInt(size));

        ByteArrayOutputStream qrcImgByteStram = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix,"JPG",qrcImgByteStram);
        byte[] imgData = qrcImgByteStram.toByteArray();

        File file = new File(filename);
        OutputStream os = new FileOutputStream(file);
        os.write(imgData);
        os.close();
               
        
    }
    
}
