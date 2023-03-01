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

    /**
     * 根据id文本判断是否已存在评论
     * @param dId
     * @return
     */
    @Override
    public boolean checkDiscussByDId(Integer dId) {
        Integer dataDId = discussMapper.selectDIdByDId(dId);
        if (dataDId == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据id删除评论
     * @param dId
     * @return
     */
    @Override
    public boolean removeDiscussByDId(Integer dId) {
        if (discussMapper.deleteDiscussByDId(dId) >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
