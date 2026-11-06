package com.hzchum.scim.system.core.security;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.CompanyConfigVO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.MenuService;
import com.hzchum.scim.system.core.api.service.RoleService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.RoleMenuLinkMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class GeneratorUserDetailService implements UserDetailsService {
   private static final Logger log = LoggerFactory.getLogger(GeneratorUserDetailService.class);
   @Resource
   @Lazy
   private UserService userService;
   @Resource
   private RoleMenuLinkMapper roleMenuLinkMapper;
   @Resource
   private MenuService menuService;
   @Resource
   private ConfigService configService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private JobService jobService;
   @Resource
   private RoleService roleService;
   @Autowired
   private ServletContext servletContext;
   @Value("${menu.recruitment.enable}")
   private boolean enableRecruitment;
   public static Map<Long, SecurityUser> USER_MAP = new ConcurrentHashMap<>();

   @Override
   public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      Object contextAttribute = this.servletContext.getAttribute("boolAllowLogin");
      if (contextAttribute == null) {
         throw new BusinessException("服务正在初始化...");
      }

      User user = null;
      if (Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", userName)) {
         user = this.userService.getByPhone(userName);
      } else if (Pattern.matches("[A-Za-z0-9]{4,16}", userName)) {
         user = this.userService.getByUsername(userName);
      } else if (Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", userName)) {
         user = this.userService.getByEmail(userName);
      }

      if (user == null) {
         user = this.userService.getUserByUserName(userName, UserTypeEnum.TEMP_USER.getType());
      }

      if (Objects.isNull(user)) {
         throw new UsernameNotFoundException("当前账号不存在：" + userName);
      }

      if (USER_MAP.containsKey(user.getId())) {
         SecurityUser securityUser = USER_MAP.get(user.getId());
         if (securityUser != null) {
            return securityUser;
         }
      }

      List<Role> roles = this.roleService.listByUserId(user.getId());
      Department dept = user.getDepartmentId() == null ? null : this.departmentService.getById(user.getDepartmentId());
      Job job = user.getJobId() == null ? null : this.jobService.getById(user.getJobId());
      boolean isAdmin = false;
      List<Menu> menus = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(roles)) {
         isAdmin = roles.stream().anyMatch(role -> "admin".equals(role.getPermission()));
         if (isAdmin) {
            menus = this.menuService.list();
         } else {
            List<Long> menuListId = this.roleMenuLinkMapper.listByUserId(user.getId());

            for (Menu menu : this.menuService.list((Wrapper<Menu>)new LambdaQueryWrapper<Menu>().eq(Menu::getBoolMainSystem, true))) {
               menuListId.add(menu.getId());
            }

            Set<Long> menuListSetId = new HashSet<>(menuListId);
            if (CollectionUtils.isNotEmpty(menuListSetId)) {
               menus = this.menuService.listByIds(menuListId);
            }
         }
      }

      List<String> permissions = menus.stream()
         .filter(menu -> StringUtils.isNotBlank(menu.getPermission()))
         .map(Menu::getPermission)
         .collect(Collectors.toList());
      Collection<? extends GrantedAuthority> authorities = null;
      if (CollectionUtils.isNotEmpty(roles)) {
         authorities = roles.stream().map(Role::getName).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
      } else {
         authorities = new ArrayList<>();
      }

      CompanyConfigVO configVO = this.configService.getCompanyConfig();
      List<Menu> modelMenu = menus.stream().filter(menu -> !menu.getHidden()).collect(Collectors.toList());
      List<Long> menuIds = modelMenu.stream().map(Menu::getId).collect(Collectors.toList());
      Menu mainSystemMenu = this.menuService.lambdaQuery().eq(Menu::getBoolMainSystem, true).one();
      if (Objects.nonNull(mainSystemMenu) && menuIds.contains(mainSystemMenu.getId())) {
         modelMenu = this.menuService
            .lambdaQuery()
            .eq(Menu::getPid, mainSystemMenu.getId())
            .ne(Menu::getId, mainSystemMenu.getId())
            .eq(Menu::getHidden, false)
            .in(Menu::getId, menuIds)
            .list();
         modelMenu.addAll(
            menus.stream()
               .filter(menu -> menu.getPid() == 0L && !menu.getHidden() && !menu.getId().equals(mainSystemMenu.getId()))
               .collect(Collectors.toList())
         );
      }

      SecurityUser securityUser = new SecurityUser(
         user.getId(),
         user.getUsername(),
         user.getName(),
         user.getSex(),
         user.getPhone(),
         user.getEmail(),
         user.getPassword(),
         user.getCreateTime(),
         user.getLastPasswordResetDate(),
         roles,
         dept,
         job,
         authorities,
         modelMenu,
         user.getIsEnabled(),
         configVO == null ? null : configVO.getCompanyName(),
         permissions,
         isAdmin,
         user.getInventoryNotifyPerm(),
         user.getUserType(),
         user.getDdUserId(),
         user.getDdDeptId(),
         user.getOaUserId()
      );
      USER_MAP.put(user.getId(), securityUser);
      return securityUser;
   }
}
