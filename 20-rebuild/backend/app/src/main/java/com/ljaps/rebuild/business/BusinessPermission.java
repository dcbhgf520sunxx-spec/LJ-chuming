package com.ljaps.rebuild.business;

import com.hzchum.scim.system.core.api.common.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/** Existing @PreAuthorize permission names are checked against the current database role/menu grants. */
@Service("permission")
public class BusinessPermission {
    @Autowired private JdbcTemplate jdbc;

    /** Pages without a permission string retain their existing numeric role/menu grant. */
    public Boolean menu(long menuId){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(auth==null || !(auth.getPrincipal() instanceof SecurityUser))return false;
        SecurityUser user=(SecurityUser)auth.getPrincipal();
        if(user.isAdmin())return true;
        if(user.getId()==null || jdbc==null)return false;
        Integer count=jdbc.queryForObject(
            "SELECT COUNT(*) FROM sys_user_role_link ur " +
            "INNER JOIN sys_role r ON r.id=ur.role_id " +
            "INNER JOIN sys_role_menu_link rm ON rm.role_id=r.id " +
            "INNER JOIN sys_menu m ON m.id=rm.menu_id " +
            "WHERE ur.user_id=? AND m.id=? AND ur.bool_delete_enum=0 " +
            "AND r.bool_delete_enum=0 AND rm.bool_delete_enum=0 " +
            "AND m.bool_delete_enum=0 AND m.category=0 AND m.type=1",
            Integer.class,user.getId(),menuId);
        return count!=null && count>0;
    }
    public Boolean check(String... permissions){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(auth==null || !(auth.getPrincipal() instanceof SecurityUser))return false;
        SecurityUser user=(SecurityUser)auth.getPrincipal();
        if(user.isAdmin())return true;
        if(user.getPermissions()==null)return false;
        for(String permission:permissions)if(user.getPermissions().contains(permission))return true;
        return false;
    }
}
