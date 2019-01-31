package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooUser;
import com.young.sys.meetoo.model.MeetooUserStatisticModel;

/**
 *
 * @author huyang8
 * @date 2019-01-23 16:52
 */
public interface MeetooUserMapper {

    MeetooUser selectById(Integer id);

    MeetooUser selectByOpenId(String openid);

    Integer insert(MeetooUser record);

    void update(MeetooUser record);

    MeetooUserStatisticModel selectUserStatistic(Integer userId);
}