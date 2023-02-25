package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.Discuss;
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
}
