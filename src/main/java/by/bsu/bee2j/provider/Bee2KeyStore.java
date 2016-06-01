package by.bsu.bee2j.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.*;
import java.security.cert.*;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by user on 18.05.2016.
 */
public class Bee2KeyStore  extends KeyStoreSpi{
    @Override
    public Key engineGetKey(String alias, char[] password) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        return null;
    }

    @Override
    public String engineGetCertificateAlias(Certificate cert) {
        return null;
    }

    public void engineStore(OutputStream stream, char[] password) throws IOException, NoSuchAlgorithmException, CertificateException {

    }

    @Override
    public boolean engineIsCertificateEntry(String alias) {
        return false;
    }

    @Override
    public void engineSetCertificateEntry(String alias, Certificate cert) throws KeyStoreException {

    }

    @Override
    public boolean engineIsKeyEntry(String alias) {
        return false;
    }

    @Override
    public void engineSetKeyEntry(String alias, byte[] key, Certificate[] chain) throws KeyStoreException {

    }

    @Override
    public Certificate[] engineGetCertificateChain(String alias) {
        return new Certificate[0];
    }

    @Override
    public int engineSize() {
        return 0;
    }

    @Override
    public Enumeration<String> engineAliases() {
        return null;
    }

    @Override
    public void engineLoad(InputStream stream, char[] password) throws IOException, NoSuchAlgorithmException, CertificateException {

    }

    @Override
    public void engineDeleteEntry(String alias) throws KeyStoreException {

    }

    @Override
    public Certificate engineGetCertificate(String alias) {
        return null;
    }

    public Date engineGetCreationDate(String alias) {
        return null;
    }

    public void engineSetKeyEntry(String alias, Key key, char[] password, Certificate[] chain) throws KeyStoreException {

    }

    @Override
    public boolean engineContainsAlias(String alias) {
        return false;
    }

}
