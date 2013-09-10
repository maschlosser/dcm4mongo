package br.net.primetech.dcm4mongo;

import br.net.primetech.dcm4mongo.model.DcmObject;
import org.dcm4che.data.*;
import org.dcm4che.io.DicomInputHandler;
import org.dcm4che.io.DicomInputStream;
import org.dcm4che.util.TagUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.TimeZone;

import static org.dcm4che.util.DateUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: schlosser
 * Date: 09/09/13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class DcmReader implements DicomInputHandler {


    DicomInputStream dis;
    Hashtable<Integer, String> elements;
    Hashtable<Integer, Date> dateElements;

    public DcmObject parse(File file) throws IOException {

        elements = new Hashtable<Integer, String>();
        dateElements = new Hashtable<Integer, Date>();


        dis = new DicomInputStream(file);
        dis.setDicomInputHandler(this);
//        dis.readDataset(-1, Tag.PixelData);
        dis.readDataset(-1, -1);
        return new DcmObject(elements,dateElements, file);


    }

    @Override
    public void readValue(DicomInputStream dis, Attributes attrs) throws IOException {


        Integer tag = getTag(dis);

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
            String contents = stringBuilder.toString();
            if ((vr == VR.DT || vr == VR.DA || vr == VR.TM) && bytes.length > 6) {
                dateElements.put(tag, getDate(contents,vr));
            }
            elements.put(tag, contents);
        }

//        Fonte do log
        if (tagID == Tag.FileMetaInformationGroupLength)
            dis.setFileMetaInformationGroupLength(bytes);
        else if (tagID == Tag.TransferSyntaxUID
                || tagID == Tag.SpecificCharacterSet
                || TagUtils.isPrivateCreator(tagID))
            attrs.setBytes(tagID, vr, bytes);
    }

    @Override
    public void readValue(DicomInputStream dis, Sequence seq) throws IOException {
        elements.put(getTag(dis), "dentro do SQ");
        String key = elements.get(getTag(dis));
        boolean undefLen = dis.length() == -1;
        dis.readValue(dis, seq);
        if (undefLen) {
            elements.remove(key);
            elements.put(getTag(dis), "undefLen");
        }

    }

    @Override
    public void readValue(DicomInputStream dis, Fragments frags) throws IOException {
        System.out.println("estive aqui");
    }

    @Override
    public void startDataset(DicomInputStream dis) throws IOException {

    }

    @Override
    public void endDataset(DicomInputStream dis) throws IOException {

    }

    private int getTag(DicomInputStream dis) {

        //        Converte a tag DICOM para uma string
        //String tag = TagUtils.toString(dis.tag());
        return dis.tag();

    }

    private Date getDate(String s, VR vr) {

        int type = vr.code();
        Date date = new Date();
        System.out.println(s+":"+vr.toString());

        switch (type) {
            case 0x4454:
                date = parseDT(TimeZone.getDefault(), s);
            break;
            case 0x4441:
                date = parseDA(TimeZone.getDefault(), s);
            break;
            case 0x544d:
                date = parseTM(TimeZone.getDefault(), s);
            break;


        }
        return date;
    }



    private String getValue(DicomInputStream dis) {
        return null;

    }
}
