
package Example;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("google")
    @Expose
    private Object google;
    @SerializedName("github")
    @Expose
    private Object github;
    @SerializedName("facebook")
    @Expose
    private Object facebook;
    @SerializedName("profileId")
    @Expose
    private Integer profileId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public User() {
    }

    /**
     * 
     * @param date
     * @param password
     * @param github
     * @param profileId
     * @param facebook
     * @param name
     * @param google
     * @param id
     * @param avatar
     * @param email
     */
    public User(Integer id, String name, String email, String password, String avatar, String date, Object google, Object github, Object facebook, Integer profileId) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.date = date;
        this.google = google;
        this.github = github;
        this.facebook = facebook;
        this.profileId = profileId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getGoogle() {
        return google;
    }

    public void setGoogle(Object google) {
        this.google = google;
    }

    public Object getGithub() {
        return github;
    }

    public void setGithub(Object github) {
        this.github = github;
    }

    public Object getFacebook() {
        return facebook;
    }

    public void setFacebook(Object facebook) {
        this.facebook = facebook;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

}
