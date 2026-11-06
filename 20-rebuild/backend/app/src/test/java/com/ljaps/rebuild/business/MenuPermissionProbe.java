package com.ljaps.rebuild.business;

import com.hzchum.scim.system.core.api.common.SecurityUser;
import java.util.*;
import java.lang.reflect.Field;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class MenuPermissionProbe {
    private static class Grants extends JdbcTemplate {
        Integer value=0; int calls=0;
        @Override @SuppressWarnings("unchecked")
        public <T> T queryForObject(String sql,Class<T> type,Object... args){
            if(!sql.contains("ur.bool_delete_enum=0") || !sql.contains("r.bool_delete_enum=0") ||
               !sql.contains("rm.bool_delete_enum=0") || !sql.contains("m.bool_delete_enum=0") ||
               !sql.contains("m.category=0 AND m.type=1") || args.length!=2 ||
               !Long.valueOf(42).equals(args[0]) || !Long.valueOf(32425).equals(args[1]))
                throw new AssertionError("Only the actual live user's exact existing page grant may authorize");
            calls++;return (T)value;
        }
    }
    private static void user(boolean admin){
        SecurityUser user=new SecurityUser(42L,"admin","Admin display name",null,null,null,"",null,null,
            Collections.emptyList(),null,null,Collections.emptyList(),Collections.emptyList(),true,"",
            Collections.singletonList("unrelated:get"),admin,false,1,null,null,null);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,null,Collections.emptyList()));
    }
    private static void check(boolean v,String why){if(!v)throw new AssertionError(why);}
    public static void main(String[] args)throws Exception{
        BusinessPermission guard=new BusinessPermission();Grants grants=new Grants();
        Field field=BusinessPermission.class.getDeclaredField("jdbc");field.setAccessible(true);field.set(guard,grants);
        SecurityContextHolder.clearContext();check(!guard.menu(32425L),"anonymous denied");
        check(grants.calls==0,"anonymous never queries grants");
        user(false);check(!guard.menu(32425L),"unrelated string permission grants no page access");
        grants.value=1;check(guard.menu(32425L),"existing exact numeric page grant allowed");
        grants.value=0;check(!guard.menu(32425L),"revoked page grant denied immediately");
        grants.value=null;check(!guard.menu(32425L),"missing grant denied");
        user(true);check(guard.menu(32425L),"explicit existing administrator allowed");
        SecurityContextHolder.clearContext();check(!guard.menu(32425L),"cleared context denied");
        System.out.println("menu_permission_checks=8");
    }
}
