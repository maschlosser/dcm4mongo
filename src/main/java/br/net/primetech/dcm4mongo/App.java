package br.net.primetech.dcm4mongo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {

        File dir = new File("/Users/schlosser/Downloads");


        System.out.println("Searching " + dir.getAbsolutePath() + " for DCM files...");
        Collection<File> dcms = FileUtils.listFiles(dir, FileFilterUtils.suffixFileFilter(".dcm"), FileFilterUtils.trueFileFilter());
        System.out.println("Found " + dcms.size() + " files.");

        for (Iterator<File> iterator = dcms.iterator(); iterator.hasNext(); ) {
            File next = iterator.next();
            Thread.sleep(3);
            System.out.print("\r" + next.getName());

        }

    }
}
