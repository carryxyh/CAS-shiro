package com.github.zhangkaitao.shiro.chapter15.realm;

import com.github.zhangkaitao.shiro.chapter15.service.UserService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-13
 * <p>Version: 1.0
 */
public class MyCasRealm extends CasRealm {

//    private UserService userService;
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> set = new HashSet<String>();
        set.add(username);
        authorizationInfo.setRoles(set);
        authorizationInfo.setStringPermissions(set);

        return authorizationInfo;
    }
}
