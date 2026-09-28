package com.formuscmp.formus.utils;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.KeyStore;

import static com.formuscmp.formus.utils.KeyUtils.loadKeyStoreFromFile;

public class ReadPasswordFromKeyStore {

    public static void main(String[] args) throws Exception {

        checkArgs(args);

        String pathToKeyStore = args[0];
        String keystorePassword = args[1];
        String passwordPassword = args[2];
        String passwordAlias = args[3];

        KeyStore keyStore = loadKeyStoreFromFile(pathToKeyStore, keystorePassword);

        System.out.println("read password " + readPasswordFromKeyStore(keyStore, passwordPassword, passwordAlias));
    }

    private static void checkArgs(String[] args) {
        if(args.length != 4) {
            throw new IllegalArgumentException("Usage: ReadPasswordFromKeyStore <full path to keystore> <keystore password> <password password> <key alias>");
        }
    }

    private static String readPasswordFromKeyStore(KeyStore keyStore, String passwordPassword, String passwordAlias) throws Exception {

        KeyStore.PasswordProtection keyStorePP = new KeyStore.PasswordProtection(passwordPassword.toCharArray());

        KeyStore.SecretKeyEntry ske =
                (KeyStore.SecretKeyEntry)keyStore.getEntry(passwordAlias, keyStorePP);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBE");
        PBEKeySpec keySpec = (PBEKeySpec)factory.getKeySpec(
                ske.getSecretKey(),
                PBEKeySpec.class);

        return new String(keySpec.getPassword());
    }
}
