package com.company;

public class User {
    private String password;
    private String salt;
    private String hash;

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPass) {
        password = newPass;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String newSalt) {
        salt = newSalt;
    }

    public String getHashedPassword() {
        return hash;
    }

    public void setHashedPassword(String newHash) {
        hash = newHash;
    }

    public User(String newPassword) {
        password = newPassword;
    }


}
