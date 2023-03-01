package indi.revolutionaryhistory.service;

import indi.revolutionaryhistory.entity.Discuss;

import java.util.List;

public interface DiscussService {
    List<Discuss> getDiscussListByEId(Integer eId);

    boolean saveDiscuss(Discuss discuss);

    /**
     * 根据id文本判断是否已存在评论
     * @param dId
     * @return
     */
    boolean checkDiscussByDId(Integer dId);

    /**
     * 根据id删除评论
     * @param dId
     * @return
     */
    boolean removeDiscussByDId(Integer dId);
}
