package domain;


import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User extends Entity implements IHaveId {

    private int id;
    private String login;
    private String password;
    private String email;
    private int role;

    public static final int RoleDefault = 0;
    public static final int RolePremium = 1;
    public static final int RoleAdmin = 2;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = encryptPassword(password);
    }

    public void setEncryptedPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public static String encryptPassword(String password) {
        MessageDigest cript;
        try {
            cript = MessageDigest.getInstance("SHA-1");
            cript.reset();
            cript.update(password.getBytes("utf8"));
            return new String(Hex.encodeHex(cript.digest()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}

