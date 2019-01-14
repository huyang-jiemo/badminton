package com.young.sys.badminton.model;

import com.young.sys.badminton.domain.ClubPhoto;

import java.util.List;

public class ClubPhotoModel {

    private String photoDate;

    private List<ClubPhoto> clubPhotoList;

    public String getPhotoDate() {
        return photoDate;
    }

    public void setPhotoDate(String photoDate) {
        this.photoDate = photoDate;
    }

    public List<ClubPhoto> getClubPhotoList() {
        return clubPhotoList;
    }

    public void setClubPhotoList(List<ClubPhoto> clubPhotoList) {
        this.clubPhotoList = clubPhotoList;
    }
}
