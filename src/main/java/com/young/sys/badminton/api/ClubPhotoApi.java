package com.young.sys.badminton.api;

import com.young.sys.badminton.domain.ClubPhoto;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.ClubPhotoService;
import com.young.sys.badminton.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huyang8
 * TODO: 2018/12/24  俱乐部相册api
 */
@Controller
@RequestMapping("/api/clubPhoto")
public class ClubPhotoApi extends BaseApi{

    @Resource
    private ClubPhotoService clubPhotoService;

    @RequestMapping("/selectByClubId.do")
    @ResponseBody
    public AjaxResult selectByClubId(Integer clubId) {
        return successData(clubPhotoService.selectByClubId(clubId));
    }

    @RequestMapping("/selectModelByClubId.do")
    @ResponseBody
    public AjaxResult selectModelByClubId(Integer clubId) {
        return successData(clubPhotoService.selectModelByClubId(clubId));
    }

    @RequestMapping("/savePhoto.do")
    @ResponseBody
    public AjaxResult savePhoto(ClubPhoto clubPhoto) {
        clubPhotoService.insert(clubPhoto);
        return success();
    }

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/uploadPhoto.do")
    @ResponseBody
    public AjaxResult uploadPhoto(Integer clubId, HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) {
        ClubPhoto clubPhoto = new ClubPhoto();
        clubPhoto.setClubId(clubId);
        clubPhoto.setPhotoUrl(FileUploadUtil.uploadFile(file, request, "clubPhoto_"+clubId));
        clubPhoto.setPhotoDate(SIMPLE_DATE_FORMAT.format(new Date()));
        clubPhotoService.insert(clubPhoto);
        return success();
    }

    @RequestMapping("/deletePhoto.do")
    @ResponseBody
    public AjaxResult deletePhoto(Integer id) {
        clubPhotoService.deleteById(id);
        return success();
    }
}
