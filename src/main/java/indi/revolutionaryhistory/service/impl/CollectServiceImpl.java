package indi.revolutionaryhistory.service.impl;

import indi.revolutionaryhistory.entity.Collect;
import indi.revolutionaryhistory.mapper.CollectMapper;
import indi.revolutionaryhistory.service.CollectService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
    public boolean checkCollect(Collect collect) {
        Collect dataCollect = collectMapper.selectCollectByCollect(collect);
        if (dataCollect == null) {
            return false;
        } else {
            return true;
        }
    }
}
