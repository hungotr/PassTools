package com.example.passtools;

public abstract class EncodeDecode
{
    protected String plaintext = null;
    protected String ciphertext = null;

    public String getPlaintext() { return plaintext; }

    public void setPlaintext(String plaintext) { this.plaintext = plaintext; }

    public String getCiphertext() { return ciphertext; }

    public void setCiphertext(String ciphertext) { this.ciphertext = ciphertext; }

    public abstract String encode();
    public abstract String decode();
}
