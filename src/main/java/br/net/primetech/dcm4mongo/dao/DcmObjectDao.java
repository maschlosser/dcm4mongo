package br.net.primetech.dcm4mongo.dao;

import br.net.primetech.dcm4mongo.model.DcmObject;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: schlosser
 * Date: 09/09/13
 * Time: 15:37
 * To change this template use File | Settings | File Templates.
 */
public interface DcmObjectDao {

    public  void saveDcm(DcmObject dcmObject);

    public DcmObject getDcmByID(String id);

    public DcmObject getDcmByDate(Date date);

    public DcmObject getDcmByModality(String modality);

    public DcmObject getDcmByPatient(String patient);

    public DcmObject getDamByPhysician(String physician);


}
