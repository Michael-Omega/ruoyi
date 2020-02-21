package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysOtherSet;
import com.ruoyi.system.service.ISysOtherSetService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【其他设置】Controller
 * 
 * @author ruoyi
 * @date 2019-10-12
 */
@Controller
@RequestMapping("/admin/system/set")
public class SysOtherSetController extends BaseController
{
    private String prefix = "admin/system/set";

    @Autowired
    private ISysOtherSetService sysOtherSetService;

    @RequiresPermissions("system:set:view")
    @GetMapping()
    public String set()
    {
        return prefix + "/set";
    }

    /**
     * 查询【其他设置】列表
     */
    @RequiresPermissions("system:set:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysOtherSet sysOtherSet)
    {
        startPage();
        List<SysOtherSet> list = sysOtherSetService.selectSysOtherSetList(sysOtherSet);
        return getDataTable(list);
    }

    /**
     * 导出【其他设置】列表
     */
    @RequiresPermissions("system:set:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysOtherSet sysOtherSet)
    {
        List<SysOtherSet> list = sysOtherSetService.selectSysOtherSetList(sysOtherSet);
        ExcelUtil<SysOtherSet> util = new ExcelUtil<SysOtherSet>(SysOtherSet.class);
        return util.exportExcel(list, "set");
    }


    /**
     * 修改【其他设置】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysOtherSet sysOtherSet = sysOtherSetService.selectSysOtherSetById(id);
        mmap.put("sysOtherSet", sysOtherSet);
        return prefix + "/edit";
    }

    /**
     * 修改保存【其他设置】
     */
    @RequiresPermissions("system:set:edit")
    @Log(title = "【其他设置】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysOtherSet sysOtherSet)
    {
        return toAjax(sysOtherSetService.updateSysOtherSet(sysOtherSet));
    }

}
