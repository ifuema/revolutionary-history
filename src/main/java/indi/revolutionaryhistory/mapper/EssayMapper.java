package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.Essay;
import indi.revolutionaryhistory.mapper.sql.EssayMapperSqlProvider;
import org.apache.ibatis.annotations.*;

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

    /**
     * 根据id文本查询文章id
     * @param eId
     * @return
     */
    @Select("SELECT e_id FROM essay WHERE e_id = #{eId}")
    Integer selectEIdByEId(Integer eId);

    /**
     * 插入一条文章信息
     * @param essay
     * @return
     */
    @Insert("INSERT INTO essay (e_title, e_img, e_body, e_type, e_source, e_video, e_num, e_time) " +
            "VALUES (#{eTitle}, #{eImg}, #{eBody}, #{eType}, #{eSource}, #{eVideo}, #{eNum}, #{eTime})")
    @Options(useGeneratedKeys = true, keyProperty = "eId", keyColumn = "e_id")
    Integer insertEssay(Essay essay);

    /**
     * 根据id文本修改文章
     * @param essay
     * @return
     */
    @Update("UPDATE essay SET e_title = #{eTitle}, e_img = #{eImg}, " +
            "e_body = #{eBody}, e_type = #{eType}, e_source = #{eSource}, e_video = #{eVideo} WHERE e_id = #{eId}")
    Integer updateEssayByEId(Essay essay);

    /**
     * 根据id文本删除文章
     * @param eId
     * @return
     */
    @Delete("DELETE FROM essay WHERE e_id = #{eId}")
    Integer deleteEssayByEId(Integer eId);

    @Select("SELECT COUNT(*) FROM essay")
    Integer selectEssayCount();
}
