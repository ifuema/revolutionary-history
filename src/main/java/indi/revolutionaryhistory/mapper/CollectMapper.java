package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectMapper {
    @Insert("INSERT INTO collect (u_id, e_id) VALUES (#{uId}, #{eId})")
    Integer insertCollect(Collect collect);

    @Select("SELECT u_id, e_id FROM collect WHERE u_id = #{uId} AND e_id = #{eId}")
    Collect selectCollectByCollect(Collect collect);

    @Delete("DELETE FROM collect WHERE u_id = #{uId} AND e_id = #{eId}")
    Integer deleteCollectByCollect(Collect collect);

    @Select("SELECT * FROM collect WHERE u_id = #{uId}")
    List<Collect> selectCollectListByEssay(Integer uId);
}
