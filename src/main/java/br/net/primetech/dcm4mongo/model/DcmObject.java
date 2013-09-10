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

    Date studyDate;
    Date seriesDate;
    Date acquisitionDate;
    Date contentDate;
    File file;
    Hashtable<Integer, String> elements;
    Hashtable<Integer,Date> dateElements;

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

    public File getFile() {
        return file;
    }

    public Hashtable<Integer, Date> getDateElements() {
        return dateElements;
    }

    public void setDateElements(Hashtable<Integer, Date> dateElements) {
        this.dateElements = dateElements;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Date getStudyDate() {
        return studyDate;
    }

    public void setStudyDate(Date studyDate) {
        this.studyDate = studyDate;
    }

    public Date getSeriesDate() {
        return seriesDate;
    }

    public void setSeriesDate(Date seriesDate) {
        this.seriesDate = seriesDate;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Date getContentDate() {
        return contentDate;
    }

    public void setContentDate(Date contentDate) {
        this.contentDate = contentDate;
    }

    public Hashtable<Integer, String> getElements() {
        return elements;
    }

    public void setElements(Hashtable<Integer, String> elements) {
        this.elements = elements;
    }
}
