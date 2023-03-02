package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.People;
import indi.revolutionaryhistory.mapper.sql.PeopleMapperSqlProvider;
import org.apache.ibatis.annotations.*;

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

    /**
     * 插入一条人物信息
     * @param people
     * @return
     */
    @Insert("INSERT INTO people (p_name, p_alias, p_citizenship, p_nationality, p_birth, p_death, p_university, p_occupation, p_work, p_achievement, p_original_name, p_character, p_experience, p_life, p_evaluate, p_influence, p_commemoration, p_img) " +
            "VALUES (#{pName}, #{pAlias}, #{pCitizenship}, #{pNationality}, #{pBirth}, #{pDeath}, #{pUniversity}, #{pOccupation}, #{pWork}, #{pAchievement}, #{pOriginalName}, #{pCharacter}, #{pExperience}, #{pLife}, #{pEvaluate}, #{pInfluence}, #{pCommemoration}, #{pImg})")
    @Options(useGeneratedKeys = true, keyProperty = "pId", keyColumn = "p_id")
    Integer insertPeople(People people);

    /**
     * 根据id文本修改人物
     * @param people
     * @return
     */
    @Update("UPDATE people SET p_name = #{pName}, p_alias = #{pAlias}, " +
            "p_citizenship = #{pCitizenship}, p_nationality = #{pNationality}, p_birth = #{pBirth}, p_death = #{pDeath}, p_university = #{pUniversity}, p_occupation = #{pOccupation}, p_work = #{pWork}, p_achievement = #{pAchievement}, p_original_name = #{pOriginalName}, p_character = #{pCharacter}, p_experience = #{pExperience}, p_life = #{pLife}, p_evaluate = #{pEvaluate}, p_influence = #{pInfluence}, p_commemoration = #{pCommemoration}, p_img = #{pImg} WHERE p_id = #{pId}")
    Integer updatePeopleByPId(People people);

    /**
     * 根据id文本删除人物
     * @param pId
     * @return
     */
    @Delete("DELETE FROM people WHERE p_id = #{pId}")
    Integer deletePeopleByPId(Integer pId);
}
