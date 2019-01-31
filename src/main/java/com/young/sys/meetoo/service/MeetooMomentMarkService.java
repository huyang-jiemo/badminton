package com.young.sys.meetoo.service;

import com.young.sys.meetoo.dao.MeetooMomentMarkMapper;
import com.young.sys.meetoo.domain.MeetooMomentMark;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huyang8
 * @date 2019-01-26 17:52
 */
@Service
public class MeetooMomentMarkService {

    @Resource
    private MeetooMomentMarkMapper meetooMomentMarkMapper;

    public MeetooMomentMark selectMarkByMomentIdAndUserId(Integer momentId, Integer userId) {
        return meetooMomentMarkMapper.selectMarkByMomentIdAndUserId(momentId, userId);
    }

    public void insert(MeetooMomentMark meetooMomentMark) {
        meetooMomentMarkMapper.insert(meetooMomentMark);
    }
}
