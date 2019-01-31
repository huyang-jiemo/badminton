package com.young.sys.meetoo.service;

import com.young.sys.meetoo.dao.MeetooMomentPicMapper;
import com.young.sys.meetoo.domain.MeetooMomentPic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author huyang8
 * @date 2019-01-24 14:43
 */
@Service
public class MeetooMomentPicService {

    @Resource
    private MeetooMomentPicMapper meetooMomentPicMapper;

    public Integer insert(MeetooMomentPic record){
        return meetooMomentPicMapper.insert(record);
    }
}
