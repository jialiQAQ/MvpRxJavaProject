package com.example.jiali.myapplication.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String md532(String str) {
        if (str != null) {
            return makemd5(str).toString();
        }
        return null;
    }

    public static String md516(String str) {
        if (str != null) {
            return makemd5(str).toString().substring(8, 24);
        }
        return null;
    }

    private static StringBuffer makemd5(String str) {
        StringBuffer buf = new StringBuffer("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] b = md.digest();

            for (int offset = 0; offset < b.length; offset++) {
                int i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return buf;
    }

    public static String encryptToMD5(String info) {
        byte[] digesta = null;
        try {
            MessageDigest alga = MessageDigest.getInstance("MD5");

            alga.update(info.getBytes());

            digesta = alga.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String rs = byte2hex(digesta);
        return rs;
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
}
