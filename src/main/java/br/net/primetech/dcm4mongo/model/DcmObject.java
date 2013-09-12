package br.net.primetech.dcm4mongo.model;

import java.io.File;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: schlosser
 * Date: 09/09/13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class DcmObject {

    File file;
    Hashtable<Integer, String> elements;
    Hashtable<Integer, Date> dateElements;
    byte[] imageByteArray;

    public DcmObject() {
    }

    public DcmObject(Hashtable<Integer, String> elements) {
        this.elements = elements;
    }

    public DcmObject(Hashtable<Integer, String> elements, File file) {
        this.file = file;
        this.elements = elements;
    }

    public DcmObject(Hashtable<Integer, String> elements, Hashtable<Integer, Date> dateElements, File file) {
        this.elements = elements;
        this.dateElements = dateElements;
        this.file = file;
    }

    public DcmObject(Hashtable<Integer, String> elements, Hashtable<Integer, Date> dateElements, File file, byte[] imageByteArray) {
        this.file = file;
        this.elements = elements;
        this.dateElements = dateElements;
        this.imageByteArray = imageByteArray;
    }

    public byte[] getImageByteArray() {
        return imageByteArray;
    }

    public void setImageByteArray(byte[] imageByteArray) {
        this.imageByteArray = imageByteArray;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Hashtable<Integer, Date> getDateElements() {
        return dateElements;
    }

    public void setDateElements(Hashtable<Integer, Date> dateElements) {
        this.dateElements = dateElements;
    }

    public Hashtable<Integer, String> getElements() {
        return elements;
    }

    public void setElements(Hashtable<Integer, String> elements) {
        this.elements = elements;
    }
}
