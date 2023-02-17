package indi.revolutionaryhistory.mapper.sql;

import indi.revolutionaryhistory.entity.People;
import org.apache.ibatis.jdbc.SQL;

public class PeopleMapperSqlProvider {
    public static String selectPeopleListPageByPeopleSql(final People people) {
        return new SQL() {{
            SELECT("*").FROM("people");
            if (people.getpName() != null && people.getpName() != "") {
                people.setpName("%" + people.getpName() + "%");
                WHERE("p_name LIKE #{people.pName}");
            }
            if (people.getpAlias() != null && people.getpAlias() != "") {
                people.setpAlias("%" + people.getpAlias() + "%");
                WHERE("p_alias LIKE #{people.pAlias}");
            }
            if (people.getpCitizenship() != null && people.getpCitizenship() != "") {
                people.setpCitizenship("%" + people.getpCitizenship() + "%");
                WHERE("p_citizenship LIKE #{people.pCitizenship}");
            }
            if (people.getpUniversity() != null && people.getpUniversity() != "") {
                people.setpUniversity("%" + people.getpUniversity() + "%");
                WHERE("p_university LIKE #{people.pUniversity}");
            }
            if (people.getpOccupation() != null && people.getpOccupation() != "") {
                people.setpOccupation("%" + people.getpOccupation() + "%");
                WHERE("p_occupation LIKE #{people.pOccupation}");
            }
            if (people.getpWork() != null && people.getpWork() != "") {
                people.setpWork("%" + people.getpWork() + "%");
                WHERE("p_work LIKE #{people.pWork}");
            }
            if (people.getpOriginalName() != null && people.getpOriginalName() != "") {
                people.setpOriginalName("%" + people.getpOriginalName() + "%");
                WHERE("p_original_name LIKE #{people.pOriginalName}");
            }
            if (people.getpCharacter() != null && people.getpCharacter() != "") {
                people.setpCharacter("%" + people.getpCharacter() + "%");
                WHERE("p_character LIKE #{people.pCharacter}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
