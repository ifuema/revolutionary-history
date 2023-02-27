package indi.revolutionaryhistory.mapper;

import indi.revolutionaryhistory.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    /**
     * 根据账号文本查询管理员隐私信息
     * @param aAccount
     * @return
     */
    @Select("SELECT * FROM admin WHERE a_account = #{aAccount}")
    Admin selectAdminPrivateByUAccount(Integer aAccount);

    /**
     * 根据账号密码查询管理员id
     * @param admin
     * @return
     */
    @Select("SELECT a_id FROM admin WHERE a_account = #{aAccount} AND a_password = #{aPassword}")
    Integer selectAIdByAAccountAndAPassword(Admin admin);

    /**
     * 根据id文本查询管理员信息
     * @param aId
     * @return
     */
    @Select("SELECT a_id, a_account FROM admin WHERE a_id = #{aId}")
    Admin selectAdminByAId(Integer aId);
}
