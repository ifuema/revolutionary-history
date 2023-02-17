package indi.revolutionaryhistory.service;

import indi.revolutionaryhistory.entity.People;

import java.util.List;

public interface PeopleService {
    /**
     * 根据过滤人物信息分页获取人物列表
     * @param pageSize
     * @param pageNum
     * @param people
     * @return
     */
    List<People> getPeopleListPageByPeople(Integer pageSize, Integer pageNum, People people);

    /**
     * 根据id文本获取人物信息
     * @param pId
     * @return
     */
    People getPeopleByPId(Integer pId);

    /**
     * 根据id文本判断是否已存在人物
     * @param pId
     * @return
     */
    boolean checkPeopleByPId(Integer pId);
}
