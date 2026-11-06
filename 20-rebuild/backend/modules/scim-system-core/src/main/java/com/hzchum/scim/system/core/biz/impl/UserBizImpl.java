package com.hzchum.scim.system.core.biz.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.TokenInfo;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.JwtTokenUtil;
import com.hzchum.scim.common.core.api.config.WeChatAppConfigProperties;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.utils.EasyExcelUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WorkShopTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfigUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.service.MesBuildingMachinePartTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesWxMsgService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAccount;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageWxMsgService;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.biz.UserBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.constant.CacheConstants;
import com.hzchum.scim.system.core.api.common.enums.CrudTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.MenuCategoryEnum;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.ArgumentCheckUtils;
import com.hzchum.scim.system.core.api.common.utils.RSAUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.SmsUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.MessagePushUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigUserLink;
import com.hzchum.scim.system.core.api.pojo._do.ProjectUserLink;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo._do.ShrUserChangeRecord;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo._do.UserRoleLink;
import com.hzchum.scim.system.core.api.pojo._doModel.system.SysHomeEnableConfig;
import com.hzchum.scim.system.core.api.pojo.dto.CompanyConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.DeptUserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.DeptUserTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.LogoConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.MenuUserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.SupplierUserInfoDTO;
import com.hzchum.scim.system.core.api.pojo.dto.UserInfoResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserJobResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSaveRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserUpdateDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.config.SysPasswordPolicyDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigUserLinkService;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import com.hzchum.scim.system.core.api.service.RoleService;
import com.hzchum.scim.system.core.api.service.ShrUserChangeRecordService;
import com.hzchum.scim.system.core.api.service.SysHomeEnableConfigService;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.UserMapper;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserBizImpl extends IBizImpl<UserService, UserMapper, User> implements UserBiz {
   private static final Logger log = LoggerFactory.getLogger(UserBizImpl.class);
   @Value("${menu}")
   private String menu;
   private final UserService userService;
   private final RoleService roleService;
   private final DepartmentService departmentService;
   private final JobService jobService;
   private final UserRoleLinkService userRoleLinkService;
   private final ProjectUserLinkService projectUserLinkService;
   private final ProjectSupplierAccountService supplierAccountService;
   private final ProjectManageRosterService rosterService;
   private final SupplierService supplierService;
   private final RedisUtils redisUtils;
   private final JwtTokenUtil jwtTokenUtil;
   @Resource
   private ProjectManageWxMsgService wxMsgService;
   @Resource
   private ShrUserChangeRecordService shrUserChangeRecordService;
   @Resource
   private MesWxMsgService mesWxMsgService;
   @Resource
   private MesRosterService mesRosterService;
   @Resource
   private SmsUtils smsUtils;
   private final MesBuildingTeamUserLinkService teamUserLinkService;
   private final MesBuildingMachinePartTeamUserLinkService machinePartTeamUserLinkService;
   private final MesBuildingInspectionTeamUserLinkService inspectionTeamUserLinkService;
   private final ConfigService configService;
   private final PasswordEncoder encoder;
   private final WeChatAppConfigProperties weChatAppConfigProperties;
   @Value("${module}")
   private String module;
   @Value("${mes-enum}")
   private String mesEnum;
   @Value("${menu-enum}")
   private String menuEnum;
   private final MesInspectConfigUserLinkService configUserLinkService;
   @Resource
   private BasicConfigService basicConfigService;
   @Resource
   private SysHomeEnableConfigService sysHomeEnableConfigService;
   @Resource
   private MessagePushUtil messagePushUtil;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Resource
   private MesBuildingAttendanceOverConfigService overConfigService;
   @Resource
   private MesBuildingAttendanceOverConfigUserLinkService overConfigUserLinkService;

   @Override
   public UserInfoResponseVO getInfo(SecurityUser user, Integer category) {
      Integer projectTypes = 0;
      int flag = 1;
      if (this.module.contains("enclosure")) {
         projectTypes = projectTypes | ProjectTypeEnum.ENCLOSURE.getType();
         flag = 0;
      }

      if (this.module.contains("mes")) {
         projectTypes = projectTypes | ProjectTypeEnum.MES.getType() | ProjectTypeEnum.BRIDGE.getType();
      }

      int productMenu = 0;
      if (StrUtil.isNotBlank(this.menu)) {
         if (this.menu.contains("artifact")) {
            productMenu += ProductTypeEnum.ARTIFACT.getType();
            productMenu += ProductTypeEnum.ASSEMBLE.getType();
            productMenu += ProductTypeEnum.MACHINE_PART.getType();
         }

         if (this.menu.contains("enclosure")) {
            productMenu += ProductTypeEnum.ENCLOSURE.getType();
         }

         if (this.menu.contains("auxiliary_material")) {
            productMenu += ProductTypeEnum.AUXILIARY_MATERIAL.getType();
         }
      }

      List<MenuUserResponseVO> list = new ArrayList<>();
      user.getMenus().sort(Comparator.comparing(Menu::getSort));
      user.getMenus()
         .forEach(
            menu -> {
               if (category.equals(menu.getCategory())) {
                  if ("初鸣云招采".equals(menu.getName())) {
                     list.add(
                        MenuUserResponseVO.builder()
                           .id(menu.getId())
                           .name(menu.getName())
                           .icon(menu.getIcon())
                           .iframe(menu.getIframe())
                           .redirect(menu.getRedirect())
                           .isTripartite(Boolean.TRUE)
                           .build()
                     );
                  } else {
                     list.add(
                        MenuUserResponseVO.builder()
                           .id(menu.getId())
                           .name(menu.getName())
                           .icon(menu.getIcon())
                           .iframe(menu.getIframe())
                           .redirect(menu.getRedirect())
                           .isTripartite(Boolean.FALSE)
                           .build()
                     );
                  }
               }
            }
         );
      List<String> permissionList = user.getPermissions()
         .stream()
         .filter(permission -> category.equals(MenuCategoryEnum.PC.getValue()) == permission.contains(":"))
         .collect(Collectors.toList());
      List<LogoConfigVO> logoConfig = this.configService.getLogoConfig();
      String path = "";
      if (CollectionUtils.isNotEmpty(logoConfig)) {
         path = StringUtils.isEmpty(logoConfig.get(0).getPath()) ? "" : logoConfig.get(0).getPath();
      }

      if (flag == 1) {
         for (MenuUserResponseVO menuUserResponseVO : list) {
            if (menuUserResponseVO.getId() == 11L) {
               list.remove(menuUserResponseVO);
               break;
            }
         }
      }

      String productLabelLogoPath = "";
      List<LogoConfigVO> productLabelLogoAll = this.configService.getProductLabelLogoAll();
      if (CollectionUtils.isNotEmpty(productLabelLogoAll)) {
         productLabelLogoPath = StringUtils.isBlank(productLabelLogoAll.get(0).getPath()) ? "" : productLabelLogoAll.get(0).getPath();
      }

      int boolSmartLine = this.module.contains("smartLine") ? 1 : 0;
      int boolBridge = this.module.contains("bridge") ? 1 : 0;
      CompanyConfigVO companyConfig = this.configService.getCompanyConfig();
      Preconditions.checkArgument(companyConfig != null, "获取公司配置信息失败!!!");
      List<Integer> mesProductEnumList = new ArrayList<>();
      List<Integer> mesInventoryProductEnum = new ArrayList<>();
      List<Integer> factoryProductEnum = new ArrayList<>();
      List<Integer> buildingAndBridgeModels = new ArrayList<>();
      if (this.mesEnum.contains("building")) {
         mesProductEnumList.add(MesProductEnum.BUILDING.getType());
         mesInventoryProductEnum.add(MesProductEnum.BUILDING.getType());
         factoryProductEnum.add(WorkShopTypeEnum.BUILDING.getType());
         buildingAndBridgeModels.add(WorkShopTypeEnum.BUILDING.getType());
      }

      if (this.mesEnum.contains("bridge")) {
         mesProductEnumList.add(MesProductEnum.BRIDGE.getType());
         mesInventoryProductEnum.add(MesProductEnum.BRIDGE.getType());
         factoryProductEnum.add(WorkShopTypeEnum.BRIDGE.getType());
      }

      if (this.mesEnum.contains("grid")) {
         mesInventoryProductEnum.add(MesProductEnum.GRID.getType());
      }

      if (this.mesEnum.contains("enclosure")) {
         factoryProductEnum.add(WorkShopTypeEnum.ENCLOSURE.getType());
      }

      List<Integer> menuSystemEnum = Arrays.stream(this.menuEnum.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
      MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
      SysHomeEnableConfig sysHomeEnableConfig = this.sysHomeEnableConfigService.getById(1L);
      return UserInfoResponseVO.builder()
         .id(user.getId())
         .homePageShowConfig(sysHomeEnableConfig.getIsEnable())
         .deptId(user.getDepartment() == null ? null : user.getDepartment().getId())
         .boolSmartLine(boolSmartLine)
         .boolBridge(boolBridge)
         .enclosureType(flag)
         .projectTypes(projectTypes)
         .name(user.getName())
         .sex(user.getSex())
         .email(user.getEmail())
         .phone(user.getPhone())
         .productMenu(productMenu)
         .isEnabled(user.getIsEnabled())
         .dept(user.getDepartment() != null ? user.getDepartment().getName() : null)
         .roles(
            org.apache.commons.collections4.CollectionUtils.isNotEmpty(user.getRoles())
               ? user.getRoles().stream().map(Role::getPermission).collect(Collectors.toList())
               : new ArrayList<>()
         )
         .roleNames(
            org.apache.commons.collections4.CollectionUtils.isNotEmpty(user.getRoles())
               ? user.getRoles().stream().map(Role::getName).collect(Collectors.toList())
               : new ArrayList<>()
         )
         .job(user.getJob() != null ? user.getJob().getName() : null)
         .menus(list)
         .companyName(user.getUserType().equals(UserTypeEnum.COMMON_USER.getType()) ? user.getCompanyName() : user.getName())
         .permissions(permissionList)
         .username(user.getUsername())
         .inventoryNotifyPerm(user.getInventoryNotifyPerm())
         .userType(user.getUserType())
         .ddUserId(user.getDdUserId())
         .ddDeptId(user.getDdDeptId())
         .oaUserId(user.getOaUserId())
         .companyLogo(path)
         .website(companyConfig.getWebsite())
         .telephone(companyConfig.getTelephone())
         .mesProductEnum(mesProductEnumList)
         .factoryProductEnum(factoryProductEnum)
         .mesInventoryProductEnum(mesInventoryProductEnum)
         .menuSystemEnum(menuSystemEnum)
         .productLabelLogoPath(productLabelLogoPath)
         .inventoryGainType(inventoryTypeConfig.getInventoryGainType())
         .buildingAndBridgeModels(buildingAndBridgeModels)
         .drawingMatchRange(this.configService.getNumericalControlDrawingMatchRange())
         .build();
   }

   @Override
   public SupplierUserInfoDTO getTempUserInfo(SecurityUser user) {
      ProjectSupplierAccount supplierAccount = this.supplierAccountService
         .getOne(Wrappers.lambdaQuery(ProjectSupplierAccount.class).eq(ProjectSupplierAccount::getUserId, user.getId()));
      return SupplierUserInfoDTO.builder()
         .id(user.getId())
         .username(user.getUsername())
         .phone(user.getPhone())
         .supplierId(supplierAccount.getSupplierId())
         .supplierName(supplierAccount.getSupplierName())
         .isEnabled(user.getIsEnabled())
         .build();
   }

   @Override
   public SupplierUserInfoDTO getTempUserInfoV2(SecurityUser user) {
      SupplierUserInfoDTO userInfoDTO = new SupplierUserInfoDTO();
      BeanUtil.copy(user, userInfoDTO);
      if (UserTypeEnum.TEMP_USER.getType().equals(user.getUserType())) {
         ProjectManageRoster roster = this.rosterService
            .getOne(
               Wrappers.lambdaQuery(ProjectManageRoster.class)
                  .eq(ProjectManageRoster::getUserId, user.getId())
                  .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
            );
         Preconditions.checkArgument(roster != null, "劳务信息获取失败！");
         Supplier supplier = this.supplierService.getById(roster.getSupplierId());
         userInfoDTO.setName(roster.getName());
         userInfoDTO.setSex(roster.getSex());
         userInfoDTO.setSupplierId(roster.getSupplierId());
         userInfoDTO.setSupplierName(supplier != null ? supplier.getName() : "");
      }

      if (UserTypeEnum.COMMON_USER.getType().equals(user.getUserType())) {
         MesRoster roster = this.mesRosterService
            .getOne(Wrappers.lambdaQuery(MesRoster.class).eq(MesRoster::getUserId, user.getId()).eq(MesRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType()));
         Preconditions.checkArgument(roster != null, "劳务信息获取失败！");
         userInfoDTO.setName(roster.getName());
         userInfoDTO.setSex(roster.getSex());
         userInfoDTO.setSupplierId(roster.getSupplierId());
         if (roster.getSupplierId() != null) {
            Supplier supplier = this.supplierService.getById(roster.getSupplierId());
            userInfoDTO.setSupplierName(supplier != null ? supplier.getName() : "");
         } else {
            CompanyConfigVO companyConfig = this.configService.getCompanyConfig();
            userInfoDTO.setSupplierName(companyConfig != null ? companyConfig.getCompanyName() : "");
         }
      }

      return userInfoDTO;
   }

   @Override
   public PageVO<UserResponseVO> pageUser(Long deptId, String blurry, Boolean isEnabled, Integer userType, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<UserResponseVO> userResponseVOS = this.userService.listByCondition(deptId, blurry, isEnabled, userType);
      userResponseVOS.forEach(u -> {
         List<Role> roles = this.roleService.listByUserId(u.getId());
         u.setRoles(roles);
      });
      return new PageVO<>(userResponseVOS);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean register(UserSaveRequestVO requestVO) {
      Preconditions.checkArgument(Pattern.matches("[A-Za-z0-9]{4,16}", requestVO.getUsername()), "员工编号不符合规范!");
      Preconditions.checkArgument(this.userService.getByUsername(requestVO.getUsername()) == null, "添加失败,该员工编号已存在!");
      Preconditions.checkArgument(this.userService.getByPhone(requestVO.getPhone()) == null, "该手机号已被注册!");
      if (requestVO.getEmail() != null) {
         Preconditions.checkArgument(this.userService.getByEmail(requestVO.getEmail()) == null, "该邮箱已被注册!");
      }

      Role role = this.roleService.getByName("超级管理员");
      boolean b = requestVO.getRoleIds().stream().noneMatch(id -> id.equals(role.getId()));
      Preconditions.checkArgument(b, "保存失败，禁止对普通用户添加超级管理员角色");
      User user = BeanUtil.copy(requestVO, User.class);
      SysPasswordPolicyDTO passwordPolicy = this.configService.getPasswordPolicy();
      String rawPassWord = this.decryptPassword(passwordPolicy.getPassword());
      user.setPassword(this.encoder.encode(rawPassWord));
      user.setDepartmentId(requestVO.getDeptId());
      user.setLastPasswordResetDate(LocalDateTime.now());
      user.setIsEnabled(Boolean.TRUE);
      user.setUserType(UserTypeEnum.LABOR_USER.getType());
      this.userService.save(user);
      requestVO.getRoleIds().forEach(roleId -> {
         UserRoleLink userRoleLink = UserRoleLink.builder().roleId(roleId).userId(user.getId()).build();
         this.userRoleLinkService.save(userRoleLink);
      });
      ShrUserChangeRecord shrUserChangeRecord = ShrUserChangeRecord.builder()
         .deptName(ObjectUtils.isEmpty(user.getDepartmentId()) ? null : this.departmentService.getById(user.getDepartmentId()).getName())
         .jobName(ObjectUtils.isEmpty(user.getJobId()) ? null : this.jobService.getById(user.getJobId()).getName())
         .name(user.getName())
         .phone(user.getPhone())
         .crudType(CrudTypeEnum.SAVE.getType())
         .userType(UserTypeEnum.LABOR_USER.getType())
         .build();
      this.shrUserChangeRecordService.save(shrUserChangeRecord);
      this.messagePushUtil
         .sendDingTalkMessage(
            this.detailsUtils.getShrChangeDetails(shrUserChangeRecord).toString(), NotificationModuleTypeEnum.SHR_UPDATE_PUSH.getNotificationType(), null
         );
      return true;
   }

   private String decryptPassword(String password) {
      try {
         return RSAUtils.decryptRSADefault(
            System.getenv("LJAPS_SYSTEM_RSA_PRIVATE_KEY"),
            password
         );
      } catch (Exception e) {
         throw new BusinessException("失败，密码解析错误");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean changeUserDisable(Long userId, Boolean enabled, Boolean needCheck) {
      if (needCheck == null) {
         needCheck = Boolean.TRUE;
      }

      Long currentUserId = null;
      if (needCheck) {
         currentUserId = UserUtil.getCurrentUserId();
      }

      User user = this.userService.getById(userId);
      Preconditions.checkArgument(user != null, "切换用户禁用状态失败，当前用户不存在");
      if (needCheck) {
         Preconditions.checkArgument(!user.getId().equals(currentUserId), "切换失败，禁止修改自己状态");
      }

      List<UserRoleLink> userRoleLinks = this.userRoleLinkService.list(Wrappers.lambdaQuery(UserRoleLink.class).eq(UserRoleLink::getUserId, userId));
      Role adminRole = this.roleService.getByName("超级管理员");
      boolean isAdmin = userRoleLinks.stream().anyMatch(userRoleLink -> adminRole.getId().equals(userRoleLink.getRoleId()));
      Preconditions.checkArgument(!isAdmin, "修改失败，禁止修改超级管理员信息");
      if (enabled.equals(false)) {
         Preconditions.checkArgument(!this.teamUserLinkService.checkUserExist(userId), "该用户配置在生产班组中,不可禁用");
         Preconditions.checkArgument(!this.inspectionTeamUserLinkService.checkUserExist(userId), "该用户配置在质检班组中,不可禁用");
         List<MesInspectConfigUserLink> inspectConfigUserLinks = this.configUserLinkService
            .list((Wrapper<MesInspectConfigUserLink>)new LambdaQueryWrapper<MesInspectConfigUserLink>().eq(MesInspectConfigUserLink::getInspectUserId, userId));
         Preconditions.checkArgument(CollectionUtils.isEmpty(inspectConfigUserLinks), "该用户配置在质检班组中,不可禁用");
      }

      user.setIsEnabled(enabled);
      this.userService.updateById(user);
      GeneratorUserDetailService.USER_MAP.remove(user.getId());
      ShrUserChangeRecord shrUserChangeRecord = ShrUserChangeRecord.builder()
         .deptName(ObjectUtils.isEmpty(user.getDepartmentId()) ? null : this.departmentService.getById(user.getDepartmentId()).getName())
         .jobName(ObjectUtils.isEmpty(user.getJobId()) ? null : this.jobService.getById(user.getJobId()).getName())
         .name(user.getName())
         .phone(user.getPhone())
         .userType(user.getUserType())
         .crudType(enabled.equals(Boolean.TRUE) ? CrudTypeEnum.TRUE.getType() : CrudTypeEnum.FALSE.getType())
         .build();
      this.shrUserChangeRecordService.save(shrUserChangeRecord);
      this.messagePushUtil
         .sendDingTalkMessage(
            this.detailsUtils.getShrChangeDetails(shrUserChangeRecord).toString(), NotificationModuleTypeEnum.SHR_UPDATE_PUSH.getNotificationType(), null
         );
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updateUser(UserUpdateDTOParam updateDTOParam) {
      User user = this.userService.getById(updateDTOParam.getId());
      Preconditions.checkArgument(user != null, "未找到对应的用户");
      if (updateDTOParam.getRoleIds() != null) {
         List<UserRoleLink> userRoleLinks = this.userRoleLinkService
            .list(Wrappers.lambdaQuery(UserRoleLink.class).eq(UserRoleLink::getUserId, updateDTOParam.getId()));
         Role adminRole = this.roleService.getByName("超级管理员");
         boolean isAdmin = userRoleLinks.stream().anyMatch(userRoleLink -> adminRole.getId().equals(userRoleLink.getRoleId()));
         Preconditions.checkArgument(!isAdmin, "修改失败，禁止修改超级管理员信息");
         this.userRoleLinkService.remove(Wrappers.lambdaQuery(UserRoleLink.class).eq(UserRoleLink::getUserId, updateDTOParam.getId()));
         updateDTOParam.getRoleIds().forEach(roleId -> {
            UserRoleLink link = UserRoleLink.builder().userId(updateDTOParam.getId()).roleId(roleId).build();
            this.userRoleLinkService.save(link);
         });
      }

      if (!user.getUsername().equals(updateDTOParam.getUsername())) {
         Preconditions.checkArgument(this.userService.getByUsername(updateDTOParam.getUsername()) == null, "更新失败，该用户名已被其他账号关联");
      }

      if (!user.getPhone().equals(updateDTOParam.getPhone())) {
         Preconditions.checkArgument(this.userService.getByPhone(updateDTOParam.getPhone()) == null, "更新失败，该手机号已被其他账号关联");
      }

      if (updateDTOParam.getEmail() != null && !updateDTOParam.getEmail().equals(user.getEmail())) {
         Preconditions.checkArgument(this.userService.getByEmail(updateDTOParam.getPhone()) == null, "更新失败，该邮箱已被其他账号关联");
      }

      if (updateDTOParam.getDeptId() != null) {
         Department department = this.departmentService.getById(updateDTOParam.getDeptId());
         Preconditions.checkArgument(department != null, "更新失败，部门不存在");
         if (user.getDepartmentId() != null && !updateDTOParam.getDeptId().equals(user.getDepartmentId())) {
            List<Long> overConfigIds = this.overConfigService
               .list(
                  Wrappers.lambdaQuery(MesBuildingAttendanceOverConfig.class)
                     .eq(MesBuildingAttendanceOverConfig::getDepartmentId, user.getDepartmentId())
                     .and(q -> {
                        q.apply("DATE_FORMAT(overtime_working_time, '%Y-%m-%d') >= {0}", LocalDate.now());
                        q.or();
                        q.apply("DATE_FORMAT(overtime_closing_time, '%Y-%m-%d') >= {0}", LocalDate.now());
                     })
               )
               .stream()
               .map(MesBuildingAttendanceOverConfig::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(overConfigIds)) {
               MesRoster roster = this.mesRosterService.getOne(Wrappers.lambdaQuery(MesRoster.class).eq(MesRoster::getUserId, user.getId()));
               if (roster != null) {
                  int count = this.overConfigUserLinkService
                     .count(
                        Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class)
                           .in(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, overConfigIds)
                           .eq(MesBuildingAttendanceOverConfigUserLink::getRosterId, roster.getId())
                     );
                  Preconditions.checkArgument(count == 0, "该用户在当前部门存在未完成的加班打卡任务，请先删除花名册信息再切换部门！");
               }
            }
         }
      }

      if (!user.getIsEnabled().equals(updateDTOParam.getEnabled())) {
         Preconditions.checkArgument(!UserUtil.getCurrentUserId().equals(updateDTOParam.getId()), "切换失败，禁止修改自己状态");
         List<Role> roles = this.roleService.listByUserId(updateDTOParam.getId());
         boolean b = roles.stream().noneMatch(role -> "超级管理员".equals(role.getName()));
         Preconditions.checkArgument(b, "切换用户禁用状态失败，超级管理员账号无法切换");
      }

      if (user.getUserType() == UserTypeEnum.COMMON_USER.getType()) {
         updateDTOParam.setJobId(user.getJobId());
      }

      String jobName = ObjectUtils.isEmpty(updateDTOParam.getJobId()) ? null : this.jobService.getById(updateDTOParam.getJobId()).getName();
      String deptName = ObjectUtils.isEmpty(updateDTOParam.getDeptId()) ? null : this.departmentService.getById(updateDTOParam.getDeptId()).getName();
      if (!java.util.Objects.equals(user.getDepartmentId(), updateDTOParam.getDeptId())) {
         this.shrUserChangeRecordService
            .save(
               ShrUserChangeRecord.builder()
                  .deptName(
                     ObjectUtils.isEmpty(user.getDepartmentId()) ? null : this.departmentService.getById(user.getDepartmentId()).getName() + "->" + deptName
                  )
                  .jobName(ObjectUtils.isEmpty(user.getJobId()) ? null : this.jobService.getById(user.getJobId()).getName() + "->" + jobName)
                  .name(user.getName())
                  .phone(user.getPhone())
                  .crudType(CrudTypeEnum.UPDATE.getType())
                  .userType(user.getUserType())
                  .build()
            );
      }

      if (java.util.Objects.equals(user.getDepartmentId(), updateDTOParam.getDeptId())
         && !java.util.Objects.equals(user.getJobId(), updateDTOParam.getJobId())) {
         this.shrUserChangeRecordService
            .save(
               ShrUserChangeRecord.builder()
                  .deptName(ObjectUtils.isEmpty(user.getDepartmentId()) ? null : this.departmentService.getById(user.getDepartmentId()).getName())
                  .jobName(ObjectUtils.isEmpty(user.getJobId()) ? null + "->" + jobName : this.jobService.getById(user.getJobId()).getName() + "->" + jobName)
                  .name(user.getName())
                  .phone(user.getPhone())
                  .crudType(CrudTypeEnum.UPDATE.getType())
                  .userType(user.getUserType())
                  .build()
            );
      }

      BeanUtil.copy(updateDTOParam, user);
      user.setIsEnabled(updateDTOParam.getEnabled());
      user.setDepartmentId(updateDTOParam.getDeptId());
      this.userService.updateById(user);
      UpdateWrapper<MesBuildingTeamUserLink> wrapper = new UpdateWrapper<>();
      wrapper.eq("user_id", user.getId());
      wrapper.set("user_name", user.getName());
      this.teamUserLinkService.update(wrapper);
      UpdateWrapper<MesBuildingMachinePartTeamUserLink> partWrapper = new UpdateWrapper<>();
      partWrapper.eq("user_id", user.getId());
      partWrapper.set("user_name", user.getName());
      this.machinePartTeamUserLinkService.update(partWrapper);
      GeneratorUserDetailService.USER_MAP.remove(user.getId());
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean deleteUser(List<Long> ids) {
      ids.forEach(
         id -> {
            User user = this.userService.getById(id);
            Preconditions.checkArgument(user != null, "删除失败，传入的用户信息不存在");
            Preconditions.checkArgument(!user.getUsername().equals("admin"), "不可删除超级管理员");
            if (user.getUserType().equals(UserTypeEnum.TEMP_USER.getType())) {
               Preconditions.checkArgument(user.getIsEnabled().equals(false), "用户为分包商账户,用户未被禁用,不可删除");
               ProjectSupplierAccount supplierAccount = this.supplierAccountService
                  .getOne(Wrappers.lambdaQuery(ProjectSupplierAccount.class).eq(ProjectSupplierAccount::getUserId, id));
               if (supplierAccount != null) {
                  Preconditions.checkArgument(supplierAccount.getBoolStatus().equals(false), "用户为分包商账户,分包商正在使用,不可删除");
                  this.supplierAccountService.removeById(supplierAccount.getId());
               }
            }

            int count = this.projectUserLinkService.count(Wrappers.lambdaQuery(ProjectUserLink.class).eq(ProjectUserLink::getUserId, id));
            Preconditions.checkArgument(count == 0, "删除失败，要删除的用户：" + user.getName() + "在项目中");
            Preconditions.checkArgument(!this.teamUserLinkService.checkUserExist(id), "该用户配置在生产班组中,不可禁用");
            Preconditions.checkArgument(!this.inspectionTeamUserLinkService.checkUserExist(id), "该用户配置在质检班组中,不可禁用");
            List<MesInspectConfigUserLink> inspectConfigUserLinks = this.configUserLinkService
               .list((Wrapper<MesInspectConfigUserLink>)new LambdaQueryWrapper<MesInspectConfigUserLink>().eq(MesInspectConfigUserLink::getInspectUserId, id));
            Preconditions.checkArgument(CollectionUtils.isEmpty(inspectConfigUserLinks), "该用户配置在质检班组中,不可删除");
            this.userService.removeById(id);
            this.userRoleLinkService.remove(Wrappers.lambdaQuery(UserRoleLink.class).eq(UserRoleLink::getUserId, id));
            GeneratorUserDetailService.USER_MAP.remove(id);
            this.shrUserChangeRecordService
               .save(
                  ShrUserChangeRecord.builder()
                     .deptName(ObjectUtils.isNotEmpty(user.getDepartmentId()) ? this.departmentService.getById(user.getDepartmentId()).getName() : null)
                     .jobName(ObjectUtils.isNotEmpty(user.getJobId()) ? this.jobService.getById(user.getJobId()).getName() : null)
                     .name(user.getName())
                     .phone(user.getPhone())
                     .userType(user.getUserType())
                     .crudType(CrudTypeEnum.DALETE.getType())
                     .build()
               );
         }
      );
      return true;
   }

   @Override
   public List<DeptUserTreeResponseVO> userTree(Boolean hasRoot) {
      List<DeptUserTreeResponseVO> list = new ArrayList<>();
      Department one = this.departmentService.getOne((Wrapper<Department>)new LambdaQueryWrapper<Department>().eq(Department::getPid, 0));
      Preconditions.checkArgument(one != null, "系统没有设置根部门或公司");
      DeptUserTreeResponseVO responseVO = this.userTree2(one.getId());
      list.add(responseVO);
      return list;
   }

   private DeptUserTreeResponseVO userTree2(Long deptId) {
      DeptUserTreeResponseVO vo = new DeptUserTreeResponseVO();
      Department dept = this.departmentService.getById(deptId);
      vo.setId(dept.getId());
      vo.setLabel(dept.getName());
      vo.setIsUser(Boolean.FALSE);
      List<Department> departments = this.departmentService.list((Wrapper<Department>)new LambdaQueryWrapper<Department>().eq(Department::getPid, deptId));
      List<User> userList = this.userService
         .list(
            (Wrapper<User>)((new LambdaQueryWrapper<User>().eq(User::getDepartmentId, deptId))
                  .eq(User::getIsEnabled, EnableEnum.ENABLE.getType()))
               .in(User::getUserType, UserTypeEnum.COMMON_USER.getType(), UserTypeEnum.LABOR_USER.getType())
         );
      List<DeptUserTreeResponseVO> collect = new ArrayList<>();
      if (!userList.isEmpty()) {
         for (User u : userList) {
            DeptUserTreeResponseVO vo1 = new DeptUserTreeResponseVO();
            vo1.setId(u.getId());
            vo1.setLabel(u.getName());
            vo1.setIsUser(Boolean.TRUE);
            vo1.setDdUserId(u.getDdUserId());
            vo1.setIsDeepen(u.getIsDeepen());
            vo1.setPhone(u.getPhone());
            collect.add(vo1);
         }
      }

      if (!departments.isEmpty()) {
         for (Department department : departments) {
            DeptUserTreeResponseVO responseVO = this.userTree2(department.getId());
            collect.add(responseVO);
         }
      }

      vo.setChildren(collect);
      return vo;
   }

   @Override
   public DeptUserResponseVO getUserDept(Long deptId, Long jobId) {
      Department department = this.departmentService.getById(deptId);
      Preconditions.checkArgument(department != null, "部门不存在");
      Job job = this.jobService.getById(jobId);
      Preconditions.checkArgument(job != null, "岗位不存在");
      DeptUserResponseVO deptUserResponseVO = new DeptUserResponseVO();
      deptUserResponseVO.setDeptId(department.getId());
      deptUserResponseVO.setDeptName(department.getName());
      deptUserResponseVO.setJobId(jobId);
      deptUserResponseVO.setJobName(job.getName());
      List<User> userList = this.userService
         .list(
            (Wrapper<User>)((((new LambdaQueryWrapper<User>()
                           .eq(User::getDepartmentId, deptId))
                        .eq(User::getIsEnabled, EnableEnum.ENABLE.getType()))
                     .isNull(User::getJobId))
                  .or())
               .eq(User::getJobId, jobId)
         );
      if (CollectionUtils.isEmpty(userList)) {
         return deptUserResponseVO;
      }

      List<UserJobResponseVO> userJobResponseVOS = new ArrayList<>();

      for (User user : userList) {
         UserJobResponseVO userJobResponseVO = new UserJobResponseVO();
         userJobResponseVO.setUserId(user.getId());
         userJobResponseVO.setUserName(user.getName());
         userJobResponseVO.setJobId(user.getJobId());
         userJobResponseVOS.add(userJobResponseVO);
      }

      deptUserResponseVO.setUserList(userJobResponseVOS);
      return deptUserResponseVO;
   }

   @Override
   public Boolean exportUserTemplate(HttpServletResponse response) {
      String resourcePath = "template/UserImportTemplate.xlsx";
      String exportFileName = "用户人员导入模板.xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      ExcelWriter writer = EasyExcel.write().withTemplate(inputStream).build();
      Workbook workbook = writer.writeContext().writeWorkbookHolder().getWorkbook();
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean importUser(Long branchCompanyId, MultipartFile file, HttpServletResponse response) {
      List<String> columnNameList = Arrays.asList("行号", "序号", "员工编号", "姓名", "手机号码", "性别", "邮箱", "部门", "岗位", "角色", "排序");
      List<Map<String, String>> mistakeList = new ArrayList<>(1024);
      List<Map<String, String>> userMapList = null;

      try {
         userMapList = EasyExcelUtils.parseExcel(file.getInputStream(), 2);
      } catch (IOException e) {
         e.printStackTrace();
         Map<String, String> map = new HashMap<>(16);
         map.put("errorMessage", e.getMessage());
         mistakeList.add(map);
         this.exportMistakeList(response, mistakeList);
      }

      if (CollectionUtils.isEmpty(userMapList)) {
         Map<String, String> map = new HashMap<>(16);
         map.put("errorMessage", "导入数据为空");
         mistakeList.add(map);
         this.exportMistakeList(response, mistakeList);
         throw new BusinessException("导入失败,具体信息请查看错误表格!");
      }

      this.checkColumnName(userMapList, columnNameList, mistakeList);
      if (CollectionUtils.isNotEmpty(mistakeList)) {
         this.exportMistakeList(response, mistakeList);
      }

      userMapList = this.excludeBlankOrderNo(userMapList);
      if (userMapList.isEmpty()) {
         Map<String, String> map = new HashMap<>(16);
         map.put("errorMessage", "数据未填写[序号]");
         mistakeList.add(map);
         this.exportMistakeList(response, mistakeList);
      }

      userMapList = this.getNewMapList(userMapList, columnNameList);
      this.checkDataBlank(userMapList, columnNameList, mistakeList);
      if (CollectionUtils.isNotEmpty(mistakeList)) {
         this.exportMistakeList(response, mistakeList);
      }

      this.checkDuplicateData(userMapList, mistakeList);
      if (CollectionUtils.isNotEmpty(mistakeList)) {
         this.exportMistakeList(response, mistakeList);
      }

      List<Department> departmentList = this.departmentService.list();
      List<Job> jobList = this.jobService.list();
      List<Role> roleList = this.roleService.list();
      this.finalExistCheck(userMapList, departmentList, jobList, roleList, mistakeList);
      if (CollectionUtils.isNotEmpty(mistakeList)) {
         this.exportMistakeList(response, mistakeList);
      }

      this.saveUserData(userMapList, departmentList, jobList, roleList);
      this.exportMistakeList(response, mistakeList);
      return true;
   }

   private void checkColumnName(List<Map<String, String>> userMapList, List<String> columnNameList, List<Map<String, String>> mistakeList) {
      Map<String, String> firstRowMap = userMapList.get(0);
      Set<String> keySet = firstRowMap.keySet().stream().filter(Objects::nonNull).collect(Collectors.toSet());
      List<String> errorMessageList = new ArrayList<>(16);
      columnNameList.forEach(columnName -> {
         List<String> keyList = keySet.stream().filter(key -> {
            String deleteWhitespaceKey = StringUtils.deleteWhitespace(key);
            return deleteWhitespaceKey.contains(columnName);
         }).collect(Collectors.toList());
         if (keyList.isEmpty()) {
            errorMessageList.add("表头[" + columnName + "]列不存在");
         } else if (keyList.size() > 1) {
            errorMessageList.add("表头[" + columnName + "]列出现重复");
         }
      });
      if (CollectionUtils.isNotEmpty(errorMessageList)) {
         Map<String, String> map = new HashMap<>(16);
         map.put("errorMessage", StringUtils.join(errorMessageList, ",") + "!");
         mistakeList.add(map);
      }
   }

   private List<Map<String, String>> excludeBlankOrderNo(List<Map<String, String>> userMapList) {
      Map<String, String> firstRowUserMap = userMapList.get(0);
      String orderNoKey = firstRowUserMap.keySet().stream().filter(key -> StringUtils.deleteWhitespace(key).contains("序号".trim())).findFirst().orElse(null);
      return userMapList.stream().filter(map -> StringUtils.isNotBlank(map.get(orderNoKey))).collect(Collectors.toList());
   }

   private List<Map<String, String>> getNewMapList(List<Map<String, String>> userMapList, List<String> columnNameList) {
      List<Map<String, String>> newUserMapList = new ArrayList<>(userMapList.size());
      userMapList.forEach(userMap -> {
         Map<String, String> newUserMap = new HashMap<>(16);
         userMap.forEach((k, v) -> {
            if (k != null) {
               for (String columnName : columnNameList) {
                  if (StringUtils.deleteWhitespace(k).contains(columnName)) {
                     newUserMap.put(columnName, v);
                     break;
                  }
               }
            }
         });
         newUserMapList.add(newUserMap);
      });
      return newUserMapList;
   }

   private void checkDataBlank(List<Map<String, String>> userMapList, List<String> columnNameList, List<Map<String, String>> mistakeList) {
      List<Map<String, String>> newMistakeList = new ArrayList<>(userMapList.size());
      AtomicBoolean flag = new AtomicBoolean(false);
      userMapList.forEach(userMap -> {
         List<String> errorList = new ArrayList<>(16);
         columnNameList.forEach(columnName -> {
            String value = (String)userMap.get(columnName);
            if (columnName.equals("序号")) {
               if (!NumberUtils.isDigits(value)) {
                  errorList.add("序号必须为数字");
               }
            } else if (columnName.equals("员工编号")) {
               if (StringUtils.isBlank(value)) {
                  errorList.add("员工编号不能为空值");
               } else if (value.length() > 16) {
                  errorList.add("员工编号字数过多");
               } else if (!Pattern.matches("[A-Za-z0-9]{4,16}", value)) {
                  errorList.add("员工编号不符合规范");
               }
            } else if (columnName.equals("性别")) {
               if (StringUtils.isBlank(value)) {
                  errorList.add("性别不能为空值");
               } else if (!value.equals("男") && !value.equals("女")) {
                  errorList.add("性别有误");
               }
            } else if (columnName.equals("手机号码")) {
               if (StringUtils.isBlank(value)) {
                  errorList.add("手机号码不能为空值");
               } else if (!Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", value)) {
                  errorList.add("手机号码格式有误");
               }
            } else if (columnName.equals("邮箱")) {
               if (StringUtils.isNotBlank(value) && !Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", value)) {
                  errorList.add("邮箱格式有误");
               }
            } else if (columnName.equals("排序")) {
               if (StringUtils.isNotBlank(value) && !NumberUtils.isDigits(value)) {
                  errorList.add("排序必须为数字");
               }
            } else if (columnName.equals("部门")) {
               if (StringUtils.isBlank(value)) {
                  errorList.add("部门不能为空");
               } else {
                  String[] split = StringUtils.split(value, "/");
                  if (Arrays.stream(split).anyMatch(s -> s.length() > 255)) {
                     errorList.add("部门字数过多");
                  }
               }
            } else if (StringUtils.isNotBlank(value) && value.length() > 255) {
               errorList.add(columnName + "字数过多");
            }
         });
         if (CollectionUtils.isNotEmpty(errorList)) {
            flag.set(true);
            userMap.put("errorMessage", StringUtils.join(errorList, ",") + "!");
         }

         newMistakeList.add((Map<String, String>)userMap);
      });
      if (flag.get()) {
         mistakeList.addAll(newMistakeList);
      }
   }

   private void checkDuplicateData(List<Map<String, String>> userMapList, List<Map<String, String>> mistakeList) {
      Map<String, List<Map<String, String>>> usernameCollectMap = userMapList.stream().collect(Collectors.groupingBy(map -> map.get("员工编号")));
      Map<String, List<Map<String, String>>> phoneCollectMap = userMapList.stream().collect(Collectors.groupingBy(map -> map.get("手机号码")));
      Map<String, List<Map<String, String>>> emailCollectMap = userMapList.stream()
         .filter(map -> StringUtils.isNotBlank(map.get("邮箱")))
         .collect(Collectors.groupingBy(map -> map.get("邮箱")));
      Map<String, List<String>> rowNoErrorListMap = new HashMap<>(userMapList.size());
      usernameCollectMap.forEach((unKey, mapList) -> {
         if (mapList.size() > 1) {
            mapList.forEach(map -> {
               String rowNoValue = map.get("行号");
               List<String> errorList = rowNoErrorListMap.getOrDefault(rowNoValue, new ArrayList<>(16));
               errorList.add("员工编号出现重复");
               rowNoErrorListMap.put(rowNoValue, errorList);
            });
         }
      });
      phoneCollectMap.forEach((phoneKey, mapList) -> {
         if (mapList.size() > 1) {
            mapList.forEach(map -> {
               String rowNoValue = map.get("行号");
               List<String> errorList = rowNoErrorListMap.getOrDefault(rowNoValue, new ArrayList<>(16));
               errorList.add("手机号码出现重复");
               rowNoErrorListMap.put(rowNoValue, errorList);
            });
         }
      });
      emailCollectMap.forEach((emailKey, mapList) -> {
         if (mapList.size() > 1) {
            mapList.forEach(map -> {
               String rowNoValue = map.get("行号");
               List<String> errorList = rowNoErrorListMap.getOrDefault(rowNoValue, new ArrayList<>(16));
               errorList.add("邮箱地址出现重复");
               rowNoErrorListMap.put(rowNoValue, errorList);
            });
         }
      });
      if (CollectionUtils.isNotEmpty(rowNoErrorListMap)) {
         userMapList.forEach(userMap -> {
            String rowNoValue = userMap.get("行号");
            List<String> errorList = rowNoErrorListMap.get(rowNoValue);
            if (CollectionUtils.isNotEmpty(errorList)) {
               userMap.put("errorMessage", StringUtils.join(errorList, ",") + "!");
            } else {
               userMap.put("errorMessage", "");
            }
         });
         mistakeList.addAll(userMapList);
      }
   }

   private void finalExistCheck(
      List<Map<String, String>> userMapList, List<Department> departmentList, List<Job> jobList, List<Role> roleList, List<Map<String, String>> mistakeList
   ) {
      Map<String, Map<Long, List<Department>>> deptNamePidMap = departmentList.stream()
         .collect(Collectors.groupingBy(Department::getName, Collectors.groupingBy(Department::getPid)));
      Map<Long, Map<String, List<Job>>> deptIdJobNameMap = jobList.stream()
         .collect(Collectors.groupingBy(Job::getDeptId, Collectors.groupingBy(Job::getName)));
      Map<String, Role> roleNameMap = roleList.stream().collect(Collectors.toMap(Role::getName, Function.identity()));
      List<User> userList = this.userService.list();
      Set<String> usernameSet = new HashSet<>(userList.size());
      Set<String> phoneSet = new HashSet<>(userList.size());
      Set<String> emailSet = new HashSet<>(userList.size());
      userList.forEach(user -> {
         usernameSet.add(user.getUsername());
         phoneSet.add(user.getPhone());
         if (StringUtils.isNotBlank(user.getEmail())) {
            emailSet.add(user.getEmail());
         }
      });
      Map<String, List<String>> rowNoErrorListMap = new HashMap<>(userList.size());
      userMapList.forEach(userMap -> {
         String rowNoValue = userMap.get("行号");
         String usernameValue = userMap.get("员工编号");
         String phoneValue = userMap.get("手机号码");
         String emailValue = userMap.get("邮箱");
         String deptValue = userMap.get("部门");
         String jobValue = userMap.get("岗位");
         String roleValue = userMap.get("角色");
         List<String> errorList = new ArrayList<>(16);
         if (usernameSet.stream().anyMatch(un -> un.equalsIgnoreCase(usernameValue))) {
            errorList.add("员工编号已存在");
         }

         if (phoneSet.contains(phoneValue)) {
            errorList.add("手机号码已存在");
         }

         if (emailSet.stream().anyMatch(e -> e.equalsIgnoreCase(emailValue))) {
            errorList.add("邮箱已存在");
         }

         this.checkDeptJob(deptValue, jobValue, deptNamePidMap, deptIdJobNameMap, errorList);
         if (StringUtils.isNotBlank(roleValue)) {
            List<String> roleNameList = Arrays.stream(StringUtils.split(roleValue, "/")).collect(Collectors.toList());
            roleNameList.forEach(roleName -> {
               if (!roleNameMap.containsKey(roleName)) {
                  errorList.add("角色[" + roleName + "]未配置");
               }
            });
         }

         if (CollectionUtils.isNotEmpty(errorList)) {
            rowNoErrorListMap.put(rowNoValue, errorList);
         }
      });
      if (CollectionUtils.isNotEmpty(rowNoErrorListMap)) {
         userMapList.forEach(userMap -> {
            String rowNoValue = userMap.get("行号");
            List<String> errorList = rowNoErrorListMap.get(rowNoValue);
            if (errorList != null) {
               userMap.put("errorMessage", StringUtils.join(errorList, ",") + "!");
            } else {
               userMap.put("errorMessage", "");
            }

            mistakeList.add((Map<String, String>)userMap);
         });
      }
   }

   private void checkDeptJob(
      String deptValue,
      String jobValue,
      Map<String, Map<Long, List<Department>>> deptNamePidMap,
      Map<Long, Map<String, List<Job>>> deptIdJobNameMap,
      List<String> errorList
   ) {
      List<String> deptNameList = Arrays.stream(StringUtils.split(deptValue, "/")).map(StringUtils::deleteWhitespace).collect(Collectors.toList());
      Long pid = 0L;
      Department department = null;
      int size = deptNameList.size();

      for (int i = 0; i < size; i++) {
         department = null;
         String deptName = deptNameList.get(i);
         Map<Long, List<Department>> pidDeptMap = deptNamePidMap.get(deptName);
         String errorInfo = size == 1 ? "" : "第" + (i + 1) + "级";
         if (pidDeptMap == null) {
            errorList.add(errorInfo + "部门名称[" + deptName + "]未配置");
            break;
         }

         if (pidDeptMap.get(pid) == null) {
            errorList.add(errorInfo + "部门[" + deptName + "]填写有误");
            break;
         }

         List<Department> matchingDepartments = pidDeptMap.get(pid);
         if (matchingDepartments.size() != 1) {
            errorList.add(errorInfo + "部门路径[" + deptName + "]存在重复，无法唯一确定归属");
            break;
         }

         department = matchingDepartments.get(0);
         pid = department.getId();
      }

      if (StringUtils.isNotBlank(jobValue) && department != null) {
         Map<String, List<Job>> stringJobMap = deptIdJobNameMap.getOrDefault(department.getId(), Collections.emptyMap());
         List<Job> matchingJobs = stringJobMap.get(jobValue);
         if (CollectionUtils.isEmpty(matchingJobs)) {
            errorList.add("[" + department.getName() + "]下未创建[" + jobValue + "]岗位");
         } else if (matchingJobs.size() != 1) {
            errorList.add("[" + department.getName() + "]下岗位[" + jobValue + "]存在重复，无法唯一确定归属");
         }
      }
   }

   private void saveUserData(List<Map<String, String>> userMapList, List<Department> departmentList, List<Job> jobList, List<Role> roleList) {
      Map<Long, Map<String, List<Department>>> pidNameDeptMap = departmentList.stream()
         .collect(Collectors.groupingBy(Department::getPid, Collectors.groupingBy(Department::getName)));
      Map<Long, Map<String, List<Job>>> deptIdJobNameMap = jobList.stream()
         .collect(Collectors.groupingBy(Job::getDeptId, Collectors.groupingBy(Job::getName)));
      Map<String, Role> roleMap = roleList.stream().collect(Collectors.toMap(Role::getName, Function.identity()));
      Map<String, User> newUserMap = new LinkedHashMap<>(userMapList.size());
      Map<String, Set<Long>> usernameRoleListMap = new HashMap<>(userMapList.size());
      userMapList.forEach(
         userMap -> {
            User user = User.builder()
               .isEnabled(true)
               .name(userMap.get("姓名"))
               .sex(userMap.get("性别").equals("男") ? 0 : 1)
               .username(userMap.get("员工编号"))
               .phone(userMap.get("手机号码"))
               .email(userMap.get("邮箱"))
               .password(this.encoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")))
               .build();
            Long deptId = null;
            String deptValue = userMap.get("部门");
            List<String> deptNameList = Arrays.stream(StringUtils.split(deptValue, "/")).collect(Collectors.toList());
            Long pid = 0L;

            for (String deptName : deptNameList) {
               Map<String, List<Department>> deptNameMap = pidNameDeptMap.get(pid);
               List<Department> matchingDepartments = deptNameMap == null ? null : deptNameMap.get(deptName);
               Preconditions.checkArgument(
                  matchingDepartments != null && matchingDepartments.size() == 1,
                  "部门路径[" + deptName + "]不存在或存在重复，无法唯一确定归属"
               );
               Department department = matchingDepartments.get(0);
               pid = department.getId();
               deptId = department.getId();
            }

            user.setDepartmentId(deptId);
            if (StringUtils.isNotBlank(userMap.get("岗位"))) {
               String jobValue = userMap.get("岗位");
               Map<String, List<Job>> jobNameMap = deptIdJobNameMap.get(deptId);
               List<Job> matchingJobs = jobNameMap == null ? null : jobNameMap.get(jobValue);
               Preconditions.checkArgument(
                  matchingJobs != null && matchingJobs.size() == 1,
                  "岗位[" + jobValue + "]不存在或存在重复，无法唯一确定归属"
               );
               user.setJobId(matchingJobs.get(0).getId());
            }

            if (StringUtils.isNotBlank(userMap.get("排序"))) {
               user.setSort(Integer.valueOf(userMap.get("排序")));
            }

            newUserMap.put(user.getUsername(), user);
            if (StringUtils.isNotBlank(userMap.get("角色"))) {
               String roleValue = userMap.get("角色");
               Set<Long> roleIds = Arrays.stream(roleValue.split("/")).map(roleMap::get).filter(Objects::nonNull).map(Role::getId).collect(Collectors.toSet());
               if (CollectionUtils.isNotEmpty(roleIds)) {
                  usernameRoleListMap.put(user.getUsername(), roleIds);
               }
            }
         }
      );
      this.userService.saveBatch(newUserMap.values());
      if (CollectionUtils.isNotEmpty(usernameRoleListMap)) {
         List<UserRoleLink> roleLinkList = new ArrayList<>(usernameRoleListMap.size() * 2);
         usernameRoleListMap.forEach(
            (un, roleIds) -> {
               User user = newUserMap.get(un);
               List<UserRoleLink> roleLinks = roleIds.stream()
                  .map(roleId -> UserRoleLink.builder().userId(user.getId()).roleId(roleId).build())
                  .collect(Collectors.toList());
               roleLinkList.addAll(roleLinks);
            }
         );
         this.userRoleLinkService.saveBatch(roleLinkList);
      }
   }

   private void exportMistakeList(HttpServletResponse response, List<Map<String, String>> mistakeList) {
      String resourcePath = "template/UserImportMistakeTemplate.xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         if (mistakeList.isEmpty()) {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功!", "UTF-8"));
         } else {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("导入失败!", "UTF-8"));
         }

         response.setHeader("Access-Control-Expose-Headers", "result");
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }

      ExcelWriter writer = EasyExcel.write().withTemplate(inputStream).build();
      WriteSheet sheet = EasyExcel.writerSheet(0).build();
      writer.fill(new FillWrapper("list", mistakeList), sheet);
      Workbook workbook = writer.writeContext().writeWorkbookHolder().getWorkbook();
      workbook.setForceFormulaRecalculation(true);
      String exportFileName = "人员导入出错-信息表.xlsx";
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      if (CollectionUtils.isNotEmpty(mistakeList)) {
         throw new BusinessException("导入失败!请查看错误信息表!");
      }
   }

   @Override
   public UserResponseVO getUserByPhone(String phone) {
      UserResponseVO u = this.userService.getUserByPhone(phone);
      if (cn.hutool.core.bean.BeanUtil.isNotEmpty(u)) {
         List<Role> roles = this.roleService.listByUserId(u.getId());
         u.setRoles(roles);
      }

      return u;
   }

   @Override
   public Object weChatLogin(String code) {
      String openid = this.getOpenid(code);
      Preconditions.checkArgument(StringUtils.isNotBlank(openid), "操作失败,请联系管理员！");
      User user = this.userService.getOne(Wrappers.lambdaQuery(User.class).eq(User::getOpenId, openid));
      if (user != null) {
         Preconditions.checkArgument(user.getIsEnabled(), "操作失败！账号被禁用");
         return this.generateTokenMap(user.getUsername());
      } else {
         String key = String.valueOf(UUID.randomUUID());
         this.redisUtils.set(key, openid, 300L);
         return key;
      }
   }

   @Override
   public Object weChatBindAndLogin(String key, String phone, String code) {
      String openid = (String)this.redisUtils.get(key);
      String redisCode = String.valueOf(this.redisUtils.hget("wechat_bind_openid_code_cache", phone));
      Preconditions.checkArgument(StringUtils.isNotBlank(openid), "操作失败,key已失效！");
      Preconditions.checkArgument(StringUtils.isNotBlank(redisCode), "操作失败！验证码已失效！");
      Preconditions.checkArgument(code.equals(redisCode), "操作失败,验证码错误！");
      List<Long> mesRosterIds = this.mesRosterService.list().stream().map(MesRoster::getUserId).collect(Collectors.toList());
      User user = this.userService
         .getOne(
            Wrappers.lambdaQuery(User.class)
               .notLike(User::getUsername, "FBS")
               .eq(User::getPhone, phone)
               .and(
                  qw -> {
                     LambdaQueryWrapper var10000 = qw.eq(User::getUserType, UserTypeEnum.TEMP_USER.getType())
                        .or(CollectionUtils.isNotEmpty(mesRosterIds))
                        .in(CollectionUtils.isNotEmpty(mesRosterIds), User::getId, mesRosterIds);
                  }
               )
         );
      Preconditions.checkArgument(user != null, "操作失败！该手机号用户未在花名册中注册！");
      Preconditions.checkArgument(StringUtils.isBlank(user.getOpenId()), "操作失败！手机号已绑定！");
      Preconditions.checkArgument(user.getIsEnabled(), "操作失败！账号已被禁用！");
      user.setOpenId(openid);
      this.userService.updateById(user);
      Map<String, Object> stringObjectMap = this.generateTokenMap(user.getUsername());
      this.redisUtils.hdel("wechat_bind_openid_code_cache", phone);
      this.redisUtils.del(key);
      if (UserTypeEnum.TEMP_USER.getType().equals(user.getUserType())) {
         this.wxMsgService.initToDayUserSendMsgTimers(user);
      }

      if (UserTypeEnum.COMMON_USER.getType().equals(user.getUserType())) {
         this.mesWxMsgService.initToDayUserSendMsgTimers(user);
      }

      return stringObjectMap;
   }

   @Override
   public void logoutAndRelieveBind() {
      Long userId = UserUtil.getCurrentUserId();
      User user = this.userService.getById(userId);
      if (user != null) {
         this.userService.update(Wrappers.lambdaUpdate(User.class).set(User::getOpenId, null).eq(User::getId, user.getId()));
      }

      GeneratorUserDetailService.USER_MAP.remove(UserUtil.getCurrentUserId());
   }

   @Override
   public void getQrCode() {
      Map<String, Object> tokenMap = new HashMap<>();
      tokenMap.put("secret", this.weChatAppConfigProperties.getSecret());
      tokenMap.put("appid", this.weChatAppConfigProperties.getAppid());
      tokenMap.put("grant_type", "client_credential");
      String tokenJson = HttpUtil.get(this.weChatAppConfigProperties.getEndpoint() + "/cgi-bin/token", tokenMap);
      JSONObject tokenJsonObject = JSON.parseObject(tokenJson);
      String accessToken = tokenJsonObject.getString("access_token");
      HttpRequest request = HttpRequest.post(this.weChatAppConfigProperties.getEndpoint() + "/wxa/getwxacodeunlimit?access_token=" + accessToken);
      HashMap<String, Object> bodyMap = new HashMap<>();
      bodyMap.put("scene", "1");
      String bodyJson = JSON.toJSONString(bodyMap);
      request.body(bodyJson);
      HttpResponse res = request.execute();
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      assert servletRequestAttributes != null;
      HttpServletResponse response = servletRequestAttributes.getResponse();
      if (res.isOk()) {
         assert response != null;
         response.setContentType("image/jpeg");

         try {
            ServletOutputStream outputStream = response.getOutputStream();
            IoUtil.copy(res.bodyStream(), outputStream);
            outputStream.flush();
            IoUtil.close(outputStream);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   @Override
   public boolean sendCode(String phone) {
      List<Long> mesRosterIds = this.mesRosterService.list().stream().map(MesRoster::getUserId).collect(Collectors.toList());
      User user = this.userService
         .getOne(
            Wrappers.lambdaQuery(User.class)
               .notLike(User::getUsername, "FBS")
               .eq(User::getPhone, phone)
               .and(
                  qw -> {
                     LambdaQueryWrapper var10000 = qw.eq(User::getUserType, UserTypeEnum.TEMP_USER.getType())
                        .or(CollectionUtils.isNotEmpty(mesRosterIds))
                        .in(CollectionUtils.isNotEmpty(mesRosterIds), User::getId, mesRosterIds);
                  }
               )
         );
      ArgumentCheckUtils.checkNonNull(user, "发送验证码失败，该劳务账号不存在");
      if (this.redisUtils.hHasKey("wechat_bind_openid_code_cache", phone)) {
         return true;
      }

      String verifyCode = RandomStringUtils.randomNumeric(6);
      JSONObject message = new JSONObject();
      message.put("code", verifyCode);
      boolean result = this.smsUtils.sendSms(phone, message.toJSONString(), "SMS_483780039");
      if (result) {
         this.redisUtils.hset("wechat_bind_openid_code_cache", phone, verifyCode, CacheConstants.RESET_PASSWORD_CACHE_VERIFY_CODE_TIME);
      }

      return result;
   }

   private Map<String, Object> generateTokenMap(String username) {
      TokenInfo tokenInfo = TokenInfo.builder().username(username).build();
      Map<String, Object> resultMap = new HashMap<>();
      String token = this.jwtTokenUtil.generateToken(tokenInfo);
      log.info("微信登录token:" + token);
      resultMap.put("token", token);
      return resultMap;
   }

   private String getOpenid(String code) {
      Map<String, Object> map = new HashMap<>();
      map.put("appid", this.weChatAppConfigProperties.getAppid());
      map.put("secret", this.weChatAppConfigProperties.getSecret());
      map.put("js_code", code);
      map.put("grant_type", "authorization_code");
      String json = HttpUtil.get(this.weChatAppConfigProperties.getEndpoint() + "/sns/jscode2session", map);
      JSONObject jsonObject = JSON.parseObject(json);
      return jsonObject.getString("openid");
   }

   public UserBizImpl(
      final UserService userService,
      final RoleService roleService,
      final DepartmentService departmentService,
      final JobService jobService,
      final UserRoleLinkService userRoleLinkService,
      final ProjectUserLinkService projectUserLinkService,
      final ProjectSupplierAccountService supplierAccountService,
      final ProjectManageRosterService rosterService,
      final SupplierService supplierService,
      final RedisUtils redisUtils,
      final JwtTokenUtil jwtTokenUtil,
      final MesBuildingTeamUserLinkService teamUserLinkService,
      final MesBuildingMachinePartTeamUserLinkService machinePartTeamUserLinkService,
      final MesBuildingInspectionTeamUserLinkService inspectionTeamUserLinkService,
      final ConfigService configService,
      final PasswordEncoder encoder,
      final WeChatAppConfigProperties weChatAppConfigProperties,
      final MesInspectConfigUserLinkService configUserLinkService
   ) {
      this.userService = userService;
      this.roleService = roleService;
      this.departmentService = departmentService;
      this.jobService = jobService;
      this.userRoleLinkService = userRoleLinkService;
      this.projectUserLinkService = projectUserLinkService;
      this.supplierAccountService = supplierAccountService;
      this.rosterService = rosterService;
      this.supplierService = supplierService;
      this.redisUtils = redisUtils;
      this.jwtTokenUtil = jwtTokenUtil;
      this.teamUserLinkService = teamUserLinkService;
      this.machinePartTeamUserLinkService = machinePartTeamUserLinkService;
      this.inspectionTeamUserLinkService = inspectionTeamUserLinkService;
      this.configService = configService;
      this.encoder = encoder;
      this.weChatAppConfigProperties = weChatAppConfigProperties;
      this.configUserLinkService = configUserLinkService;
   }
}
