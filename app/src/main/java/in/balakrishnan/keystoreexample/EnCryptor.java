package in.balakrishnan.keystoreexample;

import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class EnCryptor {

    private static final String TAG = "EnCryptor";

    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    SecretKey secretKey;
    private byte[] encryption;
    private byte[] iv;

    public EnCryptor(SecretKey context) {
        secretKey = context;
    }

    public byte[] encryptText(final String textToEncrypt)
            throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {

        final Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        iv = cipher.getIV();

        return (encryption = cipher.doFinal(textToEncrypt.getBytes(StandardCharsets.UTF_8)));
    }

    public byte[] getEncryption() {
        return encryption;
    }

    public byte[] getIv() {
        return iv;
    }

}