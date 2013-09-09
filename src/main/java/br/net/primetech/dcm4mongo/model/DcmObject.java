package br.net.primetech.dcm4mongo.model;

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

    Hashtable<String, String> elements = new Hashtable<String, String>();

    public DcmObject(Hashtable<String, String> elements) {
        this.elements=elements;
    }

    public DcmObject() {
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

    public Hashtable<String, String> getElements() {
        return elements;
    }

    public void setElements(Hashtable<String, String> elements) {
        this.elements = elements;
    }
}
