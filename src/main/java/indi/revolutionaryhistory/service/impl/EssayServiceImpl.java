package indi.revolutionaryhistory.service.impl;

import indi.revolutionaryhistory.entity.Essay;
import indi.revolutionaryhistory.mapper.EssayMapper;
import indi.revolutionaryhistory.service.EssayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class EssayServiceImpl implements EssayService {
    @Resource
    private EssayMapper essayMapper;

    /**
     * 根据过滤文章信息分页获取文章列表
     * @param pageSize
     * @param pageNum
     * @param essay
     * @return
     */
    @Override
    public List<Essay> getEssayListPageByEssay(Integer pageSize, Integer pageNum, Essay essay) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return essayMapper.selectEssayListPageByEssay(pageSize, startIndex, essay);
    }

    /**
     * 根据id文本获取文章信息
     * @param eId
     * @return
     */
    @Override
    public Essay getEssayByEId(Integer eId) {
        return essayMapper.selectEssayByEId(eId);
    }

    @Override
    public boolean modifyENumAddByEId(Integer eId) {
        if (essayMapper.updateENumAddByEId(eId) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据id文本判断是否已存在文章
     * @param eId
     * @return
     */
    @Override
    public boolean checkEssayByEId(Integer eId) {
        Integer dataEId = essayMapper.selectEIdByEId(eId);
        if (dataEId == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 新增文章
     * @param essay
     * @return
     */
    @Override
    public boolean saveEssay(Essay essay) {
        essay.seteTime(Instant.now());
        essay.seteNum(0);
        if (essayMapper.insertEssay(essay) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据id修改文章
     * @param essay
     * @return
     */
    @Override
    public boolean modifyEssayByEId(Essay essay) {
        if (essayMapper.updateEssayByEId(essay) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据id文本删除文章
     * @param eId
     * @return
     */
    @Override
    public boolean removeEssayByEId(Integer eId) {
        if (essayMapper.deleteEssayByEId(eId) >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
