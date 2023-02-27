package indi.revolutionaryhistory.service;

import indi.revolutionaryhistory.entity.Admin;

public interface AdminService {
    /**
     * 根据账号文本获取管理员隐私信息
     * @param aAccount
     * @return
     */
    Admin getAdminPrivateByAAccount(Integer aAccount);

    /**
     * 根据账号密码判断是否已存在管理员
     * @param admin
     * @return
     */
    Integer getAIdByAAccountAndAPassword(Admin admin);

    /**
     * 根据id文本获取管理员信息
     * @param aId
     * @return
     */
    Admin getAdminByAId(Integer aId);
}
