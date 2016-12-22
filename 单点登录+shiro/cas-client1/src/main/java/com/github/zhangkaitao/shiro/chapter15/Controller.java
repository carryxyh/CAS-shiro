package com.github.zhangkaitao.shiro.chapter15;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiuyuhang on 16/8/16.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/cas")
    public String test() {
        return "casFailure";
    }

    @RequestMapping("/fail")
    public String fail(HttpServletRequest request, Model model) {
        Assertion assertion = (Assertion) request.getSession().getAttribute(
                AbstractCasFilter.CONST_CAS_ASSERTION);
        AttributePrincipal principal = assertion.getPrincipal();
        model.addAttribute("name", principal.getName());
        return "casFailure";
    }

}
