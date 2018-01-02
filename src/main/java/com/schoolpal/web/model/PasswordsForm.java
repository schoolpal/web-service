package com.schoolpal.web.model;

import javax.validation.constraints.NotEmpty;

public class PasswordsForm {

    @NotEmpty
    private String oriPass;

    @NotEmpty
    private String newPass;

    public String getOriPass() {
        return oriPass;
    }

    public void setOriPass(String oriPass) {
        this.oriPass = oriPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
