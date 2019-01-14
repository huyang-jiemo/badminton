package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ClubPhotoMapper;
import com.young.sys.badminton.domain.ClubPhoto;
import com.young.sys.badminton.model.ClubPhotoModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/01/9  俱乐部照片service服务类
 */
@Service
public class ClubPhotoService {

    @Resource
    private ClubPhotoMapper clubPhotoMapper;

    public List<ClubPhoto> selectByClubId(Integer clubId){
        return clubPhotoMapper.selectByClubId(clubId);
    }

    public void insert(ClubPhoto clubPhoto){
        clubPhotoMapper.insert(clubPhoto);
    }

    public void deleteById(Integer id){
        clubPhotoMapper.deleteById(id);
    }

    public List<String> selectDisDateByClubId(Integer clubId){
        return clubPhotoMapper.selectDisDateByClubId(clubId);
    }

    public List<ClubPhoto> selectByClubIdAndDate(Integer clubId, String photoDate){
        return clubPhotoMapper.selectByClubIdAndDate(clubId,photoDate);
    }

    public List<ClubPhotoModel> selectModelByClubId(Integer clubId) {
        List<ClubPhotoModel> clubPhotoModelList = new ArrayList<>();
        List<String> disDates = clubPhotoMapper.selectDisDateByClubId(clubId);
        if(disDates!=null&&disDates.size()>0){
            for(String date:disDates){
                ClubPhotoModel clubPhotoModel = new ClubPhotoModel();
                clubPhotoModel.setPhotoDate(date);
                clubPhotoModel.setClubPhotoList(clubPhotoMapper.selectByClubIdAndDate(clubId,date));
                clubPhotoModelList.add(clubPhotoModel);
            }
        }
        return clubPhotoModelList;
    }
}
