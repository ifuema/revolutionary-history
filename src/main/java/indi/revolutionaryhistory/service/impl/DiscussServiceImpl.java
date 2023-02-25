package indi.revolutionaryhistory.service.impl;

import indi.revolutionaryhistory.entity.Discuss;
import indi.revolutionaryhistory.mapper.DiscussMapper;
import indi.revolutionaryhistory.service.DiscussService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {
    @Resource
    private DiscussMapper discussMapper;

    @Override
    public List<Discuss> getDiscussListByEId(Integer eId) {
        return discussMapper.selectDiscussListByEId(eId);
    }

    @Override
    public boolean saveDiscuss(Discuss discuss) {
        discuss.setdTime(Instant.now());
        if (discussMapper.insertDiscuss(discuss) >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
