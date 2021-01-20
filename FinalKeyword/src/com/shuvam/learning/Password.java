package com.shuvam.learning;

public class Password {
    private static final long KEY = 723129133;
    private final long encryptedPassword;

    public Password(long password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private long encryptDecrypt(long password) {
        return password ^ KEY;
    }

    public void storePassword() {
        System.out.println("Saving password as: " + this.encryptedPassword);
    }

    public boolean letMeIn(long password) {
        if(encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Nope, you cannot come in");
            return false;
        }
    }
}
