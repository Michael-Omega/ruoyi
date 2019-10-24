package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysOtherSetMapper;
import com.ruoyi.system.domain.SysOtherSet;
import com.ruoyi.system.service.ISysOtherSetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-10-12
 */
@Service
public class SysOtherSetServiceImpl implements ISysOtherSetService 
{
    @Autowired
    private SysOtherSetMapper sysOtherSetMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public SysOtherSet selectSysOtherSetById(Long id)
    {
        return sysOtherSetMapper.selectSysOtherSetById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysOtherSet 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysOtherSet> selectSysOtherSetList(SysOtherSet sysOtherSet)
    {
        return sysOtherSetMapper.selectSysOtherSetList(sysOtherSet);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysOtherSet 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysOtherSet(SysOtherSet sysOtherSet)
    {
        return sysOtherSetMapper.insertSysOtherSet(sysOtherSet);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysOtherSet 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysOtherSet(SysOtherSet sysOtherSet)
    {
        return sysOtherSetMapper.updateSysOtherSet(sysOtherSet);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysOtherSetByIds(String ids)
    {
        return sysOtherSetMapper.deleteSysOtherSetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSysOtherSetById(Long id)
    {
        return sysOtherSetMapper.deleteSysOtherSetById(id);
    }
}
