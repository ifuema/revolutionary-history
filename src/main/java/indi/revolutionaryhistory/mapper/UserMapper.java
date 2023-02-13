package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.User;
import org.apache.ibatis.annotations.*;

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

    /**
     * 根据账号密码查询用户id
     * @param user
     * @return
     */
    @Select("SELECT u_id FROM user WHERE u_account = #{uAccount} AND u_password = #{uPassword}")
    Integer selectUIdByUAccountAndUPassword(User user);

    /**
     * 根据id文本查询用户信息
     * @param uId
     * @return
     */
    @Select("SELECT u_id, u_name, u_account, u_address, u_email FROM user WHERE u_id = #{uId}")
    User selectUserByUId(Integer uId);

    /**
     * 根据id文本修改用户
     * @param user
     * @return
     */
    @Update("UPDATE user SET u_name = #{uName}, u_account = #{uAccount}, u_password = #{uPassword}, " +
            "u_address = #{uAddress}, u_email = #{uEmail} WHERE u_id = #{uId}")
    Integer updateUserByUId(User user);
}
