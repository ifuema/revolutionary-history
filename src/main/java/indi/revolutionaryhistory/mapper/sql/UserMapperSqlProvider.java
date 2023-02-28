package indi.revolutionaryhistory.mapper.sql;

import indi.revolutionaryhistory.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class UserMapperSqlProvider {
    public static String selectUserListPageByUserSql(final User user) {
        return new SQL() {{
            SELECT("u_id, u_name, u_account, u_address, u_email, u_img").FROM("user");
            if (user.getuAccount() != null) {
                WHERE("u_account = #{user.uAccount}");
            }
            if (user.getuAddress() != null && user.getuAddress() != "") {
                user.setuAddress("%" + user.getuAddress() + "%");
                WHERE("u_address LIKE #{user.uAddress}");
            }
            if (user.getuName() != null && user.getuName() != "") {
                user.setuName("%" + user.getuName() + "%");
                WHERE("u_name LIKE #{user.uName}");
            }
            if (user.getuEmail() != null && user.getuEmail() != "") {
                WHERE("u_email = #{user.uEmail}");
            }
            LIMIT("#{pageSize}").OFFSET("#{startIndex}");
        }}.toString();
    }
}
