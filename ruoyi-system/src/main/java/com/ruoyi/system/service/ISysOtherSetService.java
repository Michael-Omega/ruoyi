package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysOtherSet;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-10-12
 */
public interface ISysOtherSetService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SysOtherSet selectSysOtherSetById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysOtherSet 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysOtherSet> selectSysOtherSetList(SysOtherSet sysOtherSet);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysOtherSet 【请填写功能名称】
     * @return 结果
     */
    public int insertSysOtherSet(SysOtherSet sysOtherSet);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysOtherSet 【请填写功能名称】
     * @return 结果
     */
    public int updateSysOtherSet(SysOtherSet sysOtherSet);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysOtherSetByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSysOtherSetById(Long id);
}
