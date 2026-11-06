package com.ljaps.rebuild.business;

import com.hzchum.scim.system.core.api.common.SecurityUser;
import java.util.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class BusinessPermissionProbe {
    private static void user(boolean admin,String... permissions){
        SecurityUser user=new SecurityUser(1L,"admin","Admin display name",null,null,null,"",null,null,
            Collections.emptyList(),null,null,Collections.emptyList(),Collections.emptyList(),true,"",
            Arrays.asList(permissions),admin,false,1,null,null,null);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,null,Collections.emptyList()));
    }
    private static void check(boolean value,String message){if(!value)throw new AssertionError(message);}
    public static void main(String[] args){
        BusinessPermission guard=new BusinessPermission();
        SecurityContextHolder.clearContext();check(!guard.check("factory:add"),"anonymous denied");
        user(false);check(!guard.check("factory:add"),"role display name is not administrator");
        user(false,"factory:get");check(guard.check("factory:get"),"exact permission allowed");
        check(!guard.check("factory:add"),"read permission cannot write");
        check(guard.check("factory:add","factory:get"),"existing multi-permission annotation means any match");
        user(true);check(guard.check("factory:add"),"explicit administrator allowed");
        SecurityContextHolder.clearContext();check(!guard.check("factory:get"),"cleared context denied");
        System.out.println("business_permission_checks=7");
    }
}
