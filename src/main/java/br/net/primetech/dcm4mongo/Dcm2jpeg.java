package br.net.primetech.dcm4mongo;

import org.dcm4che.imageio.plugins.dcm.DicomImageReadParam;

import javax.imageio.*;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: schlosser
 * Date: 12/09/13
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
public class Dcm2jpeg {

    private final ImageReader imageReader = ImageIO.getImageReadersByFormatName("DICOM").next();
    private int frame = 1;
    private ImageWriter imageWriter;
    private ImageWriteParam imageWriteParam;

    public byte[] convert(File src) throws IOException {
        ImageInputStream iis = ImageIO.createImageInputStream(src);
        BufferedImage bImage = readImage(iis);

        iis.close();

        return writeImage(bImage);


    }

    private BufferedImage readImage(ImageInputStream iis) throws IOException {
        imageReader.setInput(iis);
        return imageReader.read(frame - 1, readParam());
    }

    private byte[] writeImage(BufferedImage bImage) throws IOException {

        byte[] imageByte;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        initImageWriter();
        MemoryCacheImageOutputStream outputStream = new MemoryCacheImageOutputStream(bout);
        imageWriter.setOutput(outputStream);

        imageWriter.write(null, new IIOImage(bImage, null, null), imageWriteParam);
        outputStream.flush();
        bout.flush();
        imageByte = bout.toByteArray();

        bout.close();

        return imageByte;


    }

    private ImageReadParam readParam() {
        DicomImageReadParam param = (DicomImageReadParam) imageReader.getDefaultReadParam();
        //set parms aqui
        return param;
    }

    private void initImageWriter() {
        Iterator iterator = ImageIO.getImageWritersByFormatName("jpeg");
        imageWriter = (ImageWriter) iterator.next();

        imageWriteParam = imageWriter.getDefaultWriteParam();
        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(1);
    }
}
