package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /**
     * 根据账号文本查询用户隐私信息
     * @param uAccount
     * @return
     */
    @Select("SELECT * FROM user WHERE u_account = #{uAccount}")
    User selectUserPrivateByUAccount(Long uAccount);

    /**
     * 根据账号文本查询用户id
     * @param uAccount
     * @return
     */
    @Select("SELECT u_id FROM user WHERE u_account = #{uAccount}")
    Integer selectUIdByUAccount(Long uAccount);

    /**
     *插入一条用户信息
     * @param user
     * @return
     */
    @Insert("INSERT INTO user (u_name, u_account, u_password, u_address, u_email) " +
            "VALUES (#{uName}, #{uAccount}, #{uPassword}, #{uAddress}, #{uEmail})")
    @Options(useGeneratedKeys = true, keyProperty = "uId", keyColumn = "u_id")
    Integer insertUser(User user);
}
