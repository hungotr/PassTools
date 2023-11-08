package com.example.passtools;

import androidx.annotation.NonNull;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

enum Mode { DECODE, ENCODE }

public abstract class EncodeDecode
{
    protected String plaintext;
    protected String ciphertext;
    protected byte[] plainbytes;
    protected byte[] cipherbytes;

    protected EncodeDecode(String input)
    {
        this.plaintext = input;
        this.plainbytes = input.getBytes(StandardCharsets.UTF_8);
    }

    protected EncodeDecode(String input, Mode what)
    {
        if(what == Mode.DECODE)
        {
            this.ciphertext = input;
            this.cipherbytes = input.getBytes(StandardCharsets.UTF_8);
        }
        else if(what == Mode.ENCODE || what == null)
        {
            this.plaintext = input;
            this.plainbytes = input.getBytes(StandardCharsets.UTF_8);
        }
    }

    public String getPlaintext() { return plaintext; }

    public void setPlaintext(@NonNull String plaintext)
    {
        this.plaintext = plaintext;
        this.plainbytes = plaintext.getBytes(StandardCharsets.UTF_8);
    }

    public String getCiphertext() { return ciphertext; }

    public void setCiphertext(@NonNull String ciphertext)
    {
        this.ciphertext = ciphertext;
        this.cipherbytes = ciphertext.getBytes(StandardCharsets.UTF_8);
    }

    public abstract String encode() throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException;
    public abstract String decode() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

    @NonNull
    public String toString()
    {
        return "[" + this.plaintext + ", " + this.ciphertext + "]";
    }
}
