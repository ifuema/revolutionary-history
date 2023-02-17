package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.People;
import indi.revolutionaryhistory.mapper.sql.PeopleMapperSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface PeopleMapper {
    /**
     * 根据过滤人物信息分页查询人物列表
     * @param pageSize
     * @param startIndex
     * @param people
     * @return
     */
    @SelectProvider(type = PeopleMapperSqlProvider.class, method = "selectPeopleListPageByPeopleSql")
    List<People> selectPeopleListPageByPeople(Integer pageSize, Integer startIndex, People people);

    /**
     * 根据id文本查询文章信息
     * @param pId
     * @return
     */
    @Select("SELECT * FROM people WHERE p_id = #{pId}")
    People selectPeopleByPId(Integer pId);

    /**
     * 根据id文本查询文章id
     * @param pId
     * @return
     */
    @Select("SELECT p_id FROM people WHERE p_id = #{pId}")
    Integer selectPIdByPId(Integer pId);
}
