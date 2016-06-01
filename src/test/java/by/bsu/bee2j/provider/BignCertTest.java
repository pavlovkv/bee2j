package by.bsu.bee2j.provider;

import by.bsu.bee2j.Bee2Library;
import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;


/**
 * Created by user on 19.05.2016.
 */
public class BignCertTest extends TestCase {
    public static void testBignCert() throws CertificateException, FileNotFoundException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException {
        FileInputStream fis = new FileInputStream("E:\\Work\\Certificate.der");
        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        Certificate crt =cf.generateCertificate(fis);
        PublicKey pub = crt.getPublicKey();
        Signature signature = Signature.getInstance("Bign");
        signature.initVerify(pub);
        //signature.update(data);
      //  SignBES
        System.out.println(pub);
    }
}
