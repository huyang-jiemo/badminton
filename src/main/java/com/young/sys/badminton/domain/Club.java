package com.young.sys.badminton.domain;

public class Club {

    private Integer id;

    private String clubName;

    private Integer userId;

    private String clubLogo;

    private String clubMemo;

    private String clubAddress;

    private String clubPhone;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }

    public String getClubMemo() {
        return clubMemo;
    }

    public void setClubMemo(String clubMemo) {
        this.clubMemo = clubMemo;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public String getClubPhone() {
        return clubPhone;
    }

    public void setClubPhone(String clubPhone) {
        this.clubPhone = clubPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}