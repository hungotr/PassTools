package com.example.passtools;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class Password extends EncodeDecode
{
    private Cipher cObj;

    public Password(String input) throws NoSuchPaddingException, NoSuchAlgorithmException
    {
        super(input);
        this.cObj = Cipher.getInstance("Blowfish");
    }

    public Password(String input, Mode what) throws NoSuchPaddingException, NoSuchAlgorithmException
    {
        super(input, what);
        this.cObj = Cipher.getInstance("Blowfish");
    }

    @Override
    public String encode()
    {
        return null;
    }

    @Override
    public String decode()
    {
        return null;
    }
}
