package com.ruoyi.web.controller.web;


import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ServletUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/web")
public class LoginController extends BaseController {

    @RequestMapping("/login")
    public String Login(HttpServletResponse response, HttpServletRequest request){
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        return "web/index";
    }

    @RequestMapping("/handleLogin")
    @ResponseBody
    public AjaxResult login(@RequestParam(value = "username",required = true) String username,@RequestParam(value = "password",required = true) String password){
        Map data = new HashMap();
        data.put("username",username);
        data.put("password",password);
        return AjaxResult.success(data);
    }
}
