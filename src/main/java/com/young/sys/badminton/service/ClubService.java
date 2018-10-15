package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ClubMapper;
import com.young.sys.badminton.domain.Club;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/9  俱乐部service服务类
 */
@Service
public class ClubService {

    @Resource
    private ClubMapper clubMapper;

    public List<Club> selectAll(){
        return clubMapper.selectAll();
    }

    public Club selectById(Integer id){
        return clubMapper.selectById(id);
    }

    public void insert(Club club){
        clubMapper.insert(club);
    }

    public void update(Club club){
        clubMapper.update(club);
    }

    public void deleteById(Integer id){
        clubMapper.deleteById(id);
    }
}
