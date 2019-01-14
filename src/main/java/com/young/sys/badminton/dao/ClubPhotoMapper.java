package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.ClubPhoto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClubPhotoMapper {

    List<ClubPhoto> selectByClubId(Integer clubId);

    void insert(ClubPhoto clubPhoto);

    void deleteById(Integer id);

    List<String> selectDisDateByClubId(Integer clubId);

    List<ClubPhoto> selectByClubIdAndDate(@Param("clubId")Integer clubId, @Param("photoDate")String photoDate);
}
