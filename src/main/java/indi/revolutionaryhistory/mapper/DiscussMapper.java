package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.Discuss;
import indi.revolutionaryhistory.entity.Essay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiscussMapper {
    @Select("SELECT * FROM discuss WHERE e_id = #{eId}")
    List<Discuss> selectDiscussListByEId(Integer eId);
}
