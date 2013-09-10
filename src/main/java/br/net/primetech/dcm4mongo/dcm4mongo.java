package br.net.primetech.dcm4mongo;

import br.net.primetech.dcm4mongo.dao.DcmObjectDao;
import br.net.primetech.dcm4mongo.dao.DcmObjectDaoImpl;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class dcm4mongo {
    public static void main(String[] args)  {

        File dir = new File(args[0]);
        DcmReader reader=new DcmReader();
        DcmObjectDao objectDao = new DcmObjectDaoImpl();

        System.out.println("Searching " + dir.getAbsolutePath() + " for DCM files...");
        Collection<File> dcms = FileUtils.listFiles(dir, FileFilterUtils.suffixFileFilter(".dcm"), FileFilterUtils.trueFileFilter());
        System.out.println("Found " + dcms.size() + " files.");

        for (Iterator<File> iterator = dcms.iterator(); iterator.hasNext(); ) {

            File file = iterator.next();
            System.out.println("Uploading file " + file.getName());
            try {
                objectDao.saveDcm(reader.parse(file));
                System.out.print("\r" + file.getName());

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }


        }

    }
}
