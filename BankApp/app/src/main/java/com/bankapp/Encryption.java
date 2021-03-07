package com.bankapp;

import android.util.*;
import java.io.*;
import java.security.*;
import javax.crypto.*;

public class Encryption {

    //Hashed with SHA256
    static String usernameHash = "��y\u007F��4�#�o~,����2칮\u001F���hۻX�p�"; //username = "kenobi"
    static String passwordHash = "\u001D�n\u0003=a-��Kp\u0006\u001E��h��L-�\u000B\u0012�\u001E\u07B7�>y�"; //password = "hellothere"

    //Hashed with Base64
    static String apiURL = "aHR0cHM6Ly82MDA3ZjFhNDMwOWY4YjAwMTdlZTUwMjIubW9ja2FwaS5pby9hcGkvbTEvYWNjb3VudHM="; //apiURL = "https://6007f1a4309f8b0017ee5022.mockapi.io/api/m1/accounts"

    public static String getUrl() {
        return new String(Base64.decode(apiURL,0));
    }

    public static boolean checkCredentials (String username, String password) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String digUsername = new String(digest.digest(username.getBytes()));
            String digPassword = new String(digest.digest(password.getBytes()));
            if(passwordHash.equals(digPassword) && usernameHash.equals(digUsername))
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
