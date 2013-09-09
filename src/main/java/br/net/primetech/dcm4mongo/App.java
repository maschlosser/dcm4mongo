package br.net.primetech.dcm4mongo;

import br.net.primetech.dcm4mongo.dao.DcmObjectDao;
import br.net.primetech.dcm4mongo.dao.DcmObjectDaoImpl;
import br.net.primetech.dcm4mongo.model.DcmObject;
import br.net.primetech.dcm4mongo.model.DcmReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {

        File dir = new File("/Users/schlosser/Downloads");
        DcmObject dcm;
        DcmReader reader=new DcmReader();
        DcmObjectDao objectDao = new DcmObjectDaoImpl();



        System.out.println("Searching " + dir.getAbsolutePath() + " for DCM files...");
        Collection<File> dcms = FileUtils.listFiles(dir, FileFilterUtils.suffixFileFilter(".dcm"), FileFilterUtils.trueFileFilter());
        System.out.println("Found " + dcms.size() + " files.");

        for (Iterator<File> iterator = dcms.iterator(); iterator.hasNext(); ) {
            File next = iterator.next();

            objectDao.saveDcm(reader.parse(next));

            System.out.print("\r" + next.getName());

        }

    }
}
