package com.young.sys.badminton.domain;

public class ClubPhoto {

    private Integer id;

    private Integer clubId;

    private String photoUrl;

    private String photoDate;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoDate() {
        return photoDate;
    }

    public void setPhotoDate(String photoDate) {
        this.photoDate = photoDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
