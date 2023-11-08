package com.example.passtools;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Key extends EncodeDecode
{
    private Base64.Encoder b64En;
    private Base64.Decoder b64De;

    public Key(String input)
    {
        super(input);

        this.b64En = Base64.getEncoder();
        this.b64De = Base64.getDecoder();
    }

    public Key(String input, Mode what)
    {
        super(input, what);

        this.b64En = Base64.getEncoder();
        this.b64De = Base64.getDecoder();
    }

    @Override
    public String encode()
    {
        if(this.plainbytes == null) this.plainbytes = this.plaintext.getBytes(StandardCharsets.UTF_8);

        String buf = new String(this.b64En.encode(this.plainbytes));
        if(getCiphertext().isEmpty()) this.ciphertext = buf;

        return this.ciphertext;
    }

    @Override
    public String decode()
    {
        if(this.cipherbytes == null) this.cipherbytes = this.ciphertext.getBytes(StandardCharsets.UTF_8);

        String buf = new String(this.b64De.decode(this.cipherbytes));
        if(getPlaintext().isEmpty()) this.plaintext = buf;

        return this.plaintext;
    }
}
