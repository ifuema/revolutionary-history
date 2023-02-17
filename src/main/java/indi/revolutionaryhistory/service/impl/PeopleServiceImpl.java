package indi.revolutionaryhistory.service.impl;

import indi.revolutionaryhistory.entity.People;
import indi.revolutionaryhistory.mapper.PeopleMapper;
import indi.revolutionaryhistory.service.PeopleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Resource
    private PeopleMapper peopleMapper;

    /**
     * 根据过滤人物信息分页获取人物列表
     * @param pageSize
     * @param pageNum
     * @param people
     * @return
     */
    @Override
    public List<People> getPeopleListPageByPeople(Integer pageSize, Integer pageNum, People people) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return peopleMapper.selectPeopleListPageByPeople(pageSize, startIndex, people);
    }

    /**
     * 根据id文本获取人物信息
     * @param pId
     * @return
     */
    @Override
    public People getPeopleByPId(Integer pId) {
        return peopleMapper.selectPeopleByPId(pId);
    }

    /**
     * 根据id文本判断是否已存在人物
     * @param pId
     * @return
     */
    @Override
    public boolean checkPeopleByPId(Integer pId) {
        Integer dataPId = peopleMapper.selectPIdByPId(pId);
        if (dataPId == null) {
            return false;
        } else {
            return true;
        }
    }
}
