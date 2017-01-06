package com.schoolpal.db.model;

public class TContractParent {
    private String id;

    private String contractId;

    private String parentOriId;

    private String firstName;

    private String lastName;

    private String cellphone;

    private String weichat;

    private String email;

    private String address;

    private String relationship;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getParentOriId() {
        return parentOriId;
    }

    public void setParentOriId(String parentOriId) {
        this.parentOriId = parentOriId == null ? null : parentOriId.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getWeichat() {
        return weichat;
    }

    public void setWeichat(String weichat) {
        this.weichat = weichat == null ? null : weichat.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship == null ? null : relationship.trim();
    }
}