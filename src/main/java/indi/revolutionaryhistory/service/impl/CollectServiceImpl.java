package indi.revolutionaryhistory.service.impl;

import indi.revolutionaryhistory.entity.Collect;
import indi.revolutionaryhistory.mapper.CollectMapper;
import indi.revolutionaryhistory.service.CollectService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;


    @Override
    public boolean saveCollect(Collect collect) {
        if (collectMapper.insertCollect(collect) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkCollectByCollect(Collect collect) {
        Collect dataCollect = collectMapper.selectCollectByCollect(collect);
        if (dataCollect == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeCollectByCollect(Collect collect) {
        if (collectMapper.deleteCollectByCollect(collect) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Collect> getCollectListByUID(Integer uId) {
        return collectMapper.selectCollectListByEssay(uId);
    }
}
