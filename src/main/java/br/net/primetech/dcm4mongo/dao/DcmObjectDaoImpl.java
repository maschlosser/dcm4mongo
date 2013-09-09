package br.net.primetech.dcm4mongo.dao;

import br.net.primetech.dcm4mongo.model.DcmObject;

import java.util.Date;
import java.util.Iterator;
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

        System.out.println("********");

        Set entrySet = dcmObject.getElements().entrySet();
        Iterator it = entrySet.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
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
