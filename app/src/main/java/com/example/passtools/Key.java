package com.example.passtools;

import java.util.Base64;

public class Key extends EncodeDecode
{
    private Base64.Encoder b64En;
    private Base64.Decoder b64De;

    public Key(String input)
    {
        setPlaintext(input);
        this.b64En = Base64.getEncoder();
        this.b64De = Base64.getDecoder();
    }



    @Override
    public String encode()
    {
        String buf = new String(this.b64En.encode(this.plaintext.getBytes()));
        if(getCiphertext().isEmpty()) this.ciphertext = buf;

        return this.ciphertext;
    }

    @Override
    public String decode()
    {
        String buf = new String(this.b64De.decode(this.ciphertext.getBytes()));
        if(getPlaintext().isEmpty()) this.plaintext = buf;

        return this.plaintext;
    }
}
