package indi.revolutionaryhistory.service.impl;

import indi.revolutionaryhistory.entity.Admin;
import indi.revolutionaryhistory.mapper.AdminMapper;
import indi.revolutionaryhistory.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    /**
     * 根据账号文本获取管理员隐私信息
     * @param aAccount
     * @return
     */
    @Override
    public Admin getAdminPrivateByAAccount(Integer aAccount) {
        return adminMapper.selectAdminPrivateByUAccount(aAccount);
    }

    /**
     * 根据账号密码判断是否已存在管理员
     * @param admin
     * @return
     */
    @Override
    public Integer getAIdByAAccountAndAPassword(Admin admin) {
        return adminMapper.selectAIdByAAccountAndAPassword(admin);
    }

    /**
     * 根据id文本获取管理员信息
     * @param aId
     * @return
     */
    @Override
    public Admin getAdminByAId(Integer aId) {
        return adminMapper.selectAdminByAId(aId);
    }
}
