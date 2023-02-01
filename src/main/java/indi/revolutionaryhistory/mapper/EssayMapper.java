package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.Essay;
import indi.revolutionaryhistory.mapper.sql.EssayMapperSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EssayMapper {
    /**
     * 根据过滤文章信息分页查询文章列表
     * @param pageSize
     * @param startIndex
     * @param essay
     * @return
     */
    @SelectProvider(type = EssayMapperSqlProvider.class, method = "selectEssayListPageByEssaySql")
    List<Essay> selectEssayListPageByEssay(Integer pageSize, Integer startIndex, Essay essay);

    /**
     * 根据id文本查询文章信息
     * @param eId
     * @return
     */
    @Select("SELECT * FROM essay WHERE e_id = #{eId}")
    Essay selectEssayByEId(Integer eId);

    @Update("UPDATE essay SET e_num = e_num + 1 WHERE e_id = #{eId}")
    Integer updateENumAddByEId(Integer eId);
}
