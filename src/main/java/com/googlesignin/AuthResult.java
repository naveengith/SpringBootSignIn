package com.googlesignin;

/**
 * Created by naveen on 1/31/17.
 */
public class AuthResult {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AuthResult{" +
                "code='" + code + '\'' +
                '}';
    }
}
