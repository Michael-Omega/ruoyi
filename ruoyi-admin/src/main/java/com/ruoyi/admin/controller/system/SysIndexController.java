package com.ruoyi.admin.controller.system;

import java.util.List;

import com.ruoyi.system.domain.SysOtherSet;
import com.ruoyi.system.service.ISysOtherSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysMenuService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/admin")
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    @Resource
    private ISysOtherSetService sysOtherSetService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        SysOtherSet sysOtherSet = sysOtherSetService.selectSysOtherSetById(1L);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        mmap.put("otherSet",sysOtherSet);
        return "admin/index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return "admin/main_v1";
    }
}