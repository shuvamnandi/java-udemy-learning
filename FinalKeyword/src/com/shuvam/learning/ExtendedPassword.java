package com.shuvam.learning;

public class ExtendedPassword extends Password{
    private long decryptedPassword;

    public ExtendedPassword(long password) {
        super(password);
        this.decryptedPassword = password;
    }

    // Doing this compromises the security of this password storage
//    @Override
//    public void storePassword() {
//        System.out.println("Saving password as: " + this.decryptedPassword);
//    }
}
