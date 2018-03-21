package com.example.jiali.myapplication.util;

import java.util.UUID;

public class UUIDGenerator {
    private static UUIDGenerator uniqueInstance = new UUIDGenerator();

    private String[] chars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static UUIDGenerator getInstance() {
        return uniqueInstance;
    }

    public String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.toUpperCase();
    }

    public String getReplaceUUID() {
        String temp = getUUID().replace("-", "");
        temp = MD5.md516(temp);
        return temp.toUpperCase();
    }

    public String[] getUUIDByNum(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    public String[] getReplaceUUIDByNum(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID().replace("-", "");
        }
        return ss;
    }

    public String getReplaceUUIDTo32() {
        String temp = getUUID().replace("-", "");
        temp = MD5.md532(temp);
        return temp.toUpperCase();
    }

    public String getReplaceShortUUID() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = getUUID().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(this.chars[(x % 62)]);
        }
        return shortBuffer.toString();
    }
}