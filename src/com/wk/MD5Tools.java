package com.wk;

import java.security.MessageDigest;

/**
 * MD5鎶�鏈姞瀵嗚В瀵�aaaaaaaaaaaaaaaaaaaaaaaa13215
 */
public class MD5Tools {
    /***
     * MD5鍔犵爜 鐢熸垚32浣峬d5鐮�
     */
    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 鍔犲瘑瑙ｅ瘑绠楁硶 鎵ц涓�娆″姞瀵嗭紝涓ゆ瑙ｅ瘑
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    // 娴嬭瘯涓诲嚱鏁�
    public static void main(String args[]) {
        String s = new String("1233");
        System.out.println("鍘熷锛�" + s);
        System.out.println("MD5鍚庯細" + string2MD5(s));
        System.out.println("鍔犲瘑鐨勶細" + convertMD5(s));
        System.out.println("瑙ｅ瘑鐨勶細" + convertMD5("b3f2e98436564818e85fd1d846f74fe9"));

    }
}
