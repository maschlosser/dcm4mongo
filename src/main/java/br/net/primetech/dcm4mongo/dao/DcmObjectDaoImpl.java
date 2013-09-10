package br.net.primetech.dcm4mongo.dao;

import br.net.primetech.dcm4mongo.model.DcmObject;
import org.dcm4che.data.ElementDictionary;
import org.dcm4che.util.TagUtils;

import java.util.Date;
import java.util.Hashtable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: schlosser
 * Date: 09/09/13
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class DcmObjectDaoImpl implements DcmObjectDao {


    @Override
    public void saveDcm(DcmObject dcmObject) {

        Hashtable dataElements = dcmObject.getDateElements();
        Hashtable hsElements = dcmObject.getElements();
        Set <Integer> dateKeys = dataElements.keySet();
        Set <Integer> keys = hsElements.keySet();

        for (Integer key : dateKeys) {
            System.out.println(ElementDictionary.keywordOf(key,null)+":"+dataElements.get(key).toString());
        }

        for (Integer key : keys)
            System.out.println(ElementDictionary.keywordOf(key, null) + " " + TagUtils.toString(key) +
                    " " + hsElements.get(key));
        System.out.println("---------");

    }

    @Override
    public DcmObject getDcmByID(String id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DcmObject getDcmByDate(Date date) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DcmObject getDcmByModality(String modality) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DcmObject getDcmByPatient(String patient) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DcmObject getDamByPhysician(String physician) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
