package br.net.primetech.dcm4mongo.model;

import org.dcm4che.data.*;
import org.dcm4che.io.DicomInputHandler;
import org.dcm4che.io.DicomInputStream;
import org.dcm4che.util.TagUtils;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: schlosser
 * Date: 09/09/13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class DcmReader implements DicomInputHandler {


    DicomInputStream dis;
    Hashtable<String, String> elements;


    public DcmObject parse(File file) throws IOException {

        elements = new Hashtable<String, String>();


        dis = new DicomInputStream(file);
        dis.setDicomInputHandler(this);
        dis.readDataset(-1, Tag.PixelData);
        return new DcmObject(elements);



    }

    @Override
    public void readValue(DicomInputStream dis, Attributes attrs) throws IOException {

        String tag = getTag(dis);

//        Processa sequencias
        VR vr = dis.vr();
        int valueLength = dis.length();
        boolean undefinedValueLength = valueLength == -1;

        if (vr == VR.SQ || undefinedValueLength) {
            elements.put(tag, "SQ");
            dis.readValue(dis, attrs);
            if (undefinedValueLength) {
                elements.put(getTag(dis), getValue(dis));
            }
//            Retorna e vai para o ReadValue com o parametro de sequence
            return;
        }

        int tagID = dis.tag();
        StringBuilder stringBuilder = new StringBuilder(500);
        byte[] bytes = dis.readValue();

        if (vr.prompt(bytes, dis.bigEndian(), attrs.getSpecificCharacterSet(), 500, stringBuilder)) {
            elements.put(tag, stringBuilder.toString());
        }




    }

    @Override
    public void readValue(DicomInputStream dis, Sequence seq) throws IOException {
        elements.put(getTag(dis),"dentro do SQ");
        String key = elements.get(getTag(dis));
        boolean undefLen = dis.length() == -1;
        dis.readValue(dis, seq);
        if (undefLen) {
            elements.remove(key);
            elements.put(getTag(dis),"undefLen");
        }

    }

    @Override
    public void readValue(DicomInputStream dis, Fragments frags) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void startDataset(DicomInputStream dis) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void endDataset(DicomInputStream dis) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private String getTag(DicomInputStream dis) {

        //        Converte a tag DICOM para uma string
        String tag = TagUtils.toString(dis.tag());
        return tag;

    }

    private String getValue(DicomInputStream dis) {
        return null;

    }
}
