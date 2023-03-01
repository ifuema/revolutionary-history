package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.Discuss;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiscussMapper {
    @Select("SELECT * FROM discuss WHERE e_id = #{eId}")
    List<Discuss> selectDiscussListByEId(Integer eId);

    @Insert("INSERT INTO discuss (u_id, e_id, d_body, d_time) VALUES (#{uId}, #{eId}, #{dBody}, #{dTime})")
    Integer insertDiscuss(Discuss discuss);

    /**
     * 根据id文本查询评论id
     * @param dId
     * @return
     */
    @Select("SELECT d_id FROM discuss WHERE d_id = #{dId}")
    Integer selectDIdByDId(Integer dId);

    /**
     * 根据id文本删除评论
     * @param dId
     * @return
     */
    @Delete("DELETE FROM discuss WHERE d_id = #{dId}")
    Integer deleteDiscussByDId(Integer dId);
}
