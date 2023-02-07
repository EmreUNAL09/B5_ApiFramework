
package Example;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class AllProfilePojo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("website")
    @Expose
    private Object website;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("location")
    @Expose
    private Object location;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("skills")
    @Expose
    private List<String> skills;
    @SerializedName("bio")
    @Expose
    private Object bio;
    @SerializedName("githubusername")
    @Expose
    private Object githubusername;
    @SerializedName("social")
    @Expose
    private Social social;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("education")
    @Expose
    private List<Object> education;
    @SerializedName("experience")
    @Expose
    private List<Object> experience;
    @SerializedName("user")
    @Expose
    private User user;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AllProfilePojo() {
    }

    /**
     * 
     * @param date
     * @param website
     * @param education
     * @param year
     * @param social
     * @param bio
     * @param experience
     * @param userId
     * @param skills
     * @param githubusername
     * @param company
     * @param location
     * @param id
     * @param user
     * @param status
     */
    public AllProfilePojo(Integer id, String company, Object website, Integer year, Object location, String status, List<String> skills, Object bio, Object githubusername, Social social, String date, Integer userId, List<Object> education, List<Object> experience, User user) {
        super();
        this.id = id;
        this.company = company;
        this.website = website;
        this.year = year;
        this.location = location;
        this.status = status;
        this.skills = skills;
        this.bio = bio;
        this.githubusername = githubusername;
        this.social = social;
        this.date = date;
        this.userId = userId;
        this.education = education;
        this.experience = experience;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Object getWebsite() {
        return website;
    }

    public void setWebsite(Object website) {
        this.website = website;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    public Object getGithubusername() {
        return githubusername;
    }

    public void setGithubusername(Object githubusername) {
        this.githubusername = githubusername;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Object> getEducation() {
        return education;
    }

    public void setEducation(List<Object> education) {
        this.education = education;
    }

    public List<Object> getExperience() {
        return experience;
    }

    public void setExperience(List<Object> experience) {
        this.experience = experience;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
