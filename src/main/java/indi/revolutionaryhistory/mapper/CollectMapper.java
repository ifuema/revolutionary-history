package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.Collect;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CollectMapper {
    @Insert("INSERT INTO collect (u_id, e_id) VALUES (#{uId}, #{eId})")
    Integer insertCollect(Collect collect);

    @Select("SELECT u_id, e_id FROM collect WHERE u_id = #{uId} AND e_id = #{eId}")
    Collect selectCollectByCollect(Collect collect);
}
