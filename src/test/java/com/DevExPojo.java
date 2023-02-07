
package com;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;


@Generated("jsonschema2pojo")
public class DevExPojo {

    @SerializedName("id")
    @Expose
    private double id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("profileId")
    @Expose
    private double profileId;

    public DevExPojo() {
    }

    public DevExPojo(double id, String email, String name, String company, String status, double profileId) {
        super();
        this.id = id;
        this.email = email;
        this.name = name;
        this.company = company;
        this.status = status;
        this.profileId = profileId;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getProfileId() {
        return profileId;
    }

    public void setProfileId(double profileId) {
        this.profileId = profileId;
    }

}