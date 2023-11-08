package com.example.passtools;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Password extends EncodeDecode
{
    private Cipher cObj;
    private Key bfKey = null;
    private SecretKeySpec keyspec;

    public Password(String input) throws NoSuchPaddingException, NoSuchAlgorithmException
    {
        super(input);
        this.cObj = Cipher.getInstance("Blowfish");

        if(this.bfKey.getPlaintext().isEmpty() || this.bfKey == null)
            this.bfKey = new Key("BLOWFISHENCRYPT");

        this.keyspec = new SecretKeySpec(this.bfKey.plainbytes, "Blowfish");
    }

    public Password(String input, Mode what) throws NoSuchPaddingException, NoSuchAlgorithmException
    {
        super(input, what);
        this.cObj = Cipher.getInstance("Blowfish");

        if(this.bfKey.getPlaintext().isEmpty() || this.bfKey == null)
            this.bfKey = new Key("BLOWFISHENCRYPT");

        this.keyspec = new SecretKeySpec(this.bfKey.plainbytes, "Blowfish");
    }

    public Password(String input, String key) throws NoSuchPaddingException, NoSuchAlgorithmException
    {
        super(input);
        this.bfKey = new Key(key);
        this.cObj = Cipher.getInstance("Blowfish");
        this.keyspec = new SecretKeySpec(this.bfKey.plainbytes, "Blowfish");
    }

    public Password(String input, String key, Mode what) throws NoSuchPaddingException, NoSuchAlgorithmException
    {
        super(input, what);
        this.bfKey = new Key(key);
        this.cObj = Cipher.getInstance("Blowfish");
        this.keyspec = new SecretKeySpec(this.bfKey.plainbytes, "Blowfish");
    }

    @Override
    public String encode() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        if(this.plainbytes == null) this.plainbytes = this.plaintext.getBytes(StandardCharsets.UTF_8);

        this.cObj.init(Cipher.ENCRYPT_MODE, keyspec);
        String buf = new String(this.cObj.doFinal(this.plainbytes));
        if(getCiphertext().isEmpty()) this.ciphertext = buf;

        return buf;
    }

    @Override
    public String decode() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
    {
        if(this.plainbytes == null) this.plainbytes = this.plaintext.getBytes(StandardCharsets.UTF_8);

        this.cObj.init(Cipher.DECRYPT_MODE, keyspec);
        String buf = new String(this.cObj.doFinal(this.plainbytes));
        if(getCiphertext().isEmpty()) this.ciphertext = buf;

        return buf;
    }
}
