package com.hzchum.scim.system.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingtalk.api.response.OapiV2DepartmentListsubResponse.DeptBaseResponse;
import com.dingtalk.api.response.OapiV2UserGetResponse.UserGetResponse;
import com.dingtalk.api.response.OapiV2UserListResponse.ListUserResponse;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.config.JwtProperties;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.TokenInfo;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.JwtTokenUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.constant.CacheConstants;
import com.hzchum.scim.system.core.api.common.enums.DDUserIdCheckResultEnum;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.ArgumentCheckUtils;
import com.hzchum.scim.system.core.api.common.utils.DingDingUtils;
import com.hzchum.scim.system.core.api.common.utils.MailUtils;
import com.hzchum.scim.system.core.api.common.utils.RSAUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.SmsUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo._do.SysLog;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DDUserCheckInfo;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentUserTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.DeptUserTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetEmailPasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetPasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetPhonePasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleUpdateRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserUpdatePasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.DingDing.DDUserParam;
import com.hzchum.scim.system.core.api.pojo.dto.DingDing.UserChangeInfo;
import com.hzchum.scim.system.core.api.pojo.dto.config.SysPasswordPolicyDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysNotificationsBindByUserParam;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.RoleService;
import com.hzchum.scim.system.core.api.service.SysLogService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.api.utils.PasswordPolicyUtil;
import com.hzchum.scim.system.core.mapper.UserMapper;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
   private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
   private final AuthenticationManager authenticationManager;
   @Resource
   private MailUtils mailUtils;
   @Resource
   private UserDetailsService userDetailService;
   @Resource
   private JwtTokenUtil jwtTokenUtil;
   @Resource
   private PasswordEncoder encoder;
   @Resource
   private JwtProperties jwtProperties;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private SmsUtils smsUtils;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private SysLogService sysLogService;
   @Resource
   private ConfigService configService;
   @Resource
   private RoleService roleService;

   public UserServiceImpl(AuthenticationManager authenticationManager) {
      this.authenticationManager = authenticationManager;
   }

   @Override
   public Map<String, Object> login(String username, String password) {
      User user = null;
      if (Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", username)) {
         user = this.baseMapper.getByPhone(username);
      } else if (Pattern.matches("[A-Za-z0-9]{4,16}", username)) {
         user = this.baseMapper.getByUsername(username);
      } else if (Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", username)) {
         user = this.baseMapper.getByEmail(username);
      }

      Preconditions.checkArgument(user != null, "用户不存在");
      return this.getTokenMap(username, password);
   }

   private Map<String, Object> getTokenMap(String username, String password) {
      password = this.decryptPassword(password);
      UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);

      try {
         Authentication authentication = this.authenticationManager.authenticate(upToken);
         TokenInfo tokenInfo = TokenInfo.builder().username(authentication.getName()).build();
         Map<String, Object> resultMap = new HashMap<>();
         String token = this.jwtTokenUtil.generateToken(tokenInfo);
         log.info("token: " + token);
         resultMap.put("token", token);
         SysPasswordPolicyDTO passwordPolicy = this.configService.getPasswordPolicy();
         SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
         Boolean conformPasswordPolicy = PasswordPolicyUtil.getConformPolicy(password, passwordPolicy, securityUser.isAdmin());
         resultMap.put("conformPasswordPolicy", conformPasswordPolicy);
         return resultMap;
      } catch (DisabledException e) {
         throw new BusinessException("该账号已被禁用，请联系管理员");
      } catch (BadCredentialsException e) {
         throw new BusinessException("账号密码错误");
      } catch (AuthenticationException e) {
         throw new BusinessException(e.getMessage());
      } catch (Exception e) {
         throw new BusinessException("登录发生错误，请联系管理员");
      }
   }

   @Override
   public Map<String, Object> subLogin(String username, String password) {
      User user = this.getUserByUserName(username, UserTypeEnum.TEMP_USER.getType());
      Preconditions.checkArgument(user != null, "分包商账户不存在");
      return this.getTokenMap(username, password);
   }

   @Override
   public String refreshToken(String token) {
      String subToken = token.substring(this.jwtProperties.getSalt().length());

      try {
         String username = this.jwtTokenUtil.getUsername(subToken);
         SecurityUser user = (SecurityUser)this.userDetailService.loadUserByUsername(username);
         return null;
      } catch (Exception e) {
         log.error("token刷新失败", e);
         throw new BusinessException("认证失败，无法刷新token");
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean resetPassword(UserResetPhonePasswordRequestVO requestVO) {
      User user = this.baseMapper.getByPhone(requestVO.getPhone());
      ArgumentCheckUtils.checkNonNull(user, "手机号尚未注册，请先注册");
      String verifyCode = (String)this.redisUtils.hget("reset_password_verify_code_cache", requestVO.getPhone());
      Preconditions.checkArgument(StringUtils.isNotBlank(verifyCode), "验证码已过期！");
      Preconditions.checkArgument(Objects.equals(verifyCode, requestVO.getVerifyCode()), "验证码错误！");
      String password = this.decryptPassword(requestVO.getPassword());
      user.setPassword(this.encoder.encode(password));
      user.setLastPasswordResetDate(LocalDateTime.now());
      this.baseMapper.updateById(user);
      GeneratorUserDetailService.USER_MAP.remove(user.getId());
      return true;
   }

   @Override
   public boolean resetToDefaultPassword(UserResetPasswordRequestVO requestVO) {
      User user = this.baseMapper.selectById(requestVO.getUserId());
      ArgumentCheckUtils.checkNonNull(user, "用户不存在");
      SysPasswordPolicyDTO passwordPolicy = this.configService.getPasswordPolicy();
      String rawPassWord = this.decryptPassword(passwordPolicy.getPassword());
      user.setPassword(this.encoder.encode(rawPassWord));
      user.setLastPasswordResetDate(LocalDateTime.now());
      this.baseMapper.updateById(user);
      GeneratorUserDetailService.USER_MAP.remove(user.getId());
      return false;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean resetPassword(UserResetEmailPasswordRequestVO requestVO) {
      User user = this.baseMapper.getByEmail(requestVO.getEmail());
      ArgumentCheckUtils.checkNonNull(user, "手机号尚未注册，请先注册");
      String verifyCode = (String)this.redisUtils.hget("reset_password_verify_code_cache", requestVO.getEmail());
      Preconditions.checkArgument(StringUtils.isNotBlank(verifyCode), "验证码已过期！");
      Preconditions.checkArgument(Objects.equals(verifyCode, requestVO.getVerifyCode()), "验证码错误！");
      String password = this.decryptPassword(requestVO.getPassword());
      user.setPassword(this.encoder.encode(password));
      user.setLastPasswordResetDate(LocalDateTime.now());
      this.baseMapper.updateById(user);
      GeneratorUserDetailService.USER_MAP.remove(user.getId());
      return true;
   }

   @Override
   public boolean sendPhoneVerifyCode(String phone) {
      User user = this.baseMapper.getByPhone(phone);
      ArgumentCheckUtils.checkNonNull(user, "发送验证码失败，该手机账号不存在");
      String verifyCode = RandomStringUtils.randomNumeric(6);
      JSONObject message = new JSONObject();
      message.put("code", verifyCode);
      boolean result = this.smsUtils.sendSms(phone, message.toJSONString(), "SMS_170116425");
      if (result) {
         this.redisUtils.hset("reset_password_verify_code_cache", phone, verifyCode, CacheConstants.RESET_PASSWORD_CACHE_VERIFY_CODE_TIME);
      }

      return result;
   }

   @Override
   public boolean sendEmailVerifyCode(String email) {
      User user = this.baseMapper.getByEmail(email);
      Preconditions.checkArgument(user != null, "发送验证码失败，该邮箱不存在");
      String verifyCode = RandomStringUtils.randomNumeric(6);
      String subject = "MES密码短信重置验证码";
      String text = "您的验证码为：" + verifyCode + "。该验证码在10分钟内有效";

      try {
         this.mailUtils.commonMail(email, subject, text);
         this.redisUtils.hset("reset_password_verify_code_cache", email, verifyCode, CacheConstants.RESET_PASSWORD_CACHE_VERIFY_CODE_TIME);
      } catch (Exception e) {
         Preconditions.checkArgument(false, "邮箱验证码发送失败");
      }

      return true;
   }

   @Override
   public ListVO<UserSimpleResponseVO> getSimpleUser() {
      return new ListVO<>(this.baseMapper.getSimpleUser());
   }

   @Override
   public Boolean updatePwd(Long userId, UserUpdatePasswordRequestVO requestVO) {
      User user = this.baseMapper.selectById(userId);
      Preconditions.checkArgument(user != null, "更新失败，用户不存在");
      String oldPassword = this.decryptPassword(requestVO.getOldPwd());
      Preconditions.checkArgument(this.encoder.matches(oldPassword, user.getPassword()), "更新失败，密码错误");
      String newPassword = this.decryptPassword(requestVO.getNewPwd());
      SysPasswordPolicyDTO passwordPolicy = this.configService.getPasswordPolicy();
      PasswordPolicyUtil.checkPolicy(newPassword, passwordPolicy, UserUtil.getCurrentUser().isAdmin());
      user.setPassword(this.encoder.encode(newPassword));
      user.setLastPasswordResetDate(LocalDateTime.now());
      this.baseMapper.updateById(user);
      GeneratorUserDetailService.USER_MAP.remove(user.getId());
      return true;
   }

   @Override
   public DDUserCheckInfo checkDDUserId(String ddUserId) {
      List<User> userList = this.baseMapper
         .selectList((Wrapper<User>)(new LambdaQueryWrapper<User>().eq(User::getDdUserId, ddUserId)).eq(User::getIsEnabled, Boolean.TRUE));
      DDUserCheckInfo response = new DDUserCheckInfo();
      response.setResult(userList.size() <= 1 ? userList.size() : DDUserIdCheckResultEnum.MORE.getValue());
      if (DDUserIdCheckResultEnum.MORE.getValue().equals(response.getResult())) {
         List<String> userName = userList.stream().map(User::getPhone).collect(Collectors.toList());
         response.setOtherInfo(com.hzchum.pangu.common.util.StringUtils.list2String(userName, ","));
      } else {
         response.setOtherInfo("");
      }

      return response;
   }

   @Override
   public Boolean updateUserSimpleInfo(UserSimpleUpdateRequestVO requestVO) {
      SecurityUser securityUser = UserUtil.getCurrentUser();
      User user = this.baseMapper.selectById(securityUser.getId());
      Preconditions.checkArgument(user != null, "修改失败，用户不存在");
      Preconditions.checkArgument(!securityUser.isAdmin() || user.getName().equals(requestVO.getName()), "修改失败，不能修改超级管理员名称");
      if (!user.getPhone().equals(requestVO.getPhone())) {
         Preconditions.checkArgument(this.baseMapper.getByPhone(requestVO.getPhone()) == null, "更新失败，该手机号已被其他账号关联");
      }

      BeanUtil.copy(requestVO, user);
      this.baseMapper.updateById(user);
      GeneratorUserDetailService.USER_MAP.remove(user.getId());
      return true;
   }

   @Override
   public Boolean updateUserDeepen(List<Long> newUserIds) {
      List<User> oldUsers = this.baseMapper.selectList(Wrappers.lambdaQuery(User.class).eq(User::getIsDeepen, Boolean.TRUE));
      oldUsers = oldUsers.stream().filter(e -> !newUserIds.contains(e.getId())).map(e -> e.setIsDeepen(Boolean.FALSE)).collect(Collectors.toList());
      this.updateBatchById(oldUsers);
      if (CollectionUtils.isNotEmpty(newUserIds)) {
         this.baseMapper
            .update(null, (Wrapper<User>)(new LambdaUpdateWrapper<User>().in(User::getId, newUserIds)).set(User::getIsDeepen, Boolean.TRUE));
      }

      return true;
   }

   @Override
   public List<User> listByDeptId(Long deptId) {
      return this.baseMapper.listByDeptId(deptId);
   }

   @Override
   public List<Long> getByInventoryNotifyPerm() {
      return this.baseMapper.getByInventoryNotifyPerm();
   }

   @Override
   public User getByPhone(String phone) {
      return this.baseMapper.getByPhone(phone);
   }

   @Override
   public User getByUsername(String userName) {
      return this.baseMapper.getByUsername(userName);
   }

   @Override
   public User getByEmail(String email) {
      return this.baseMapper.getByEmail(email);
   }

   @Override
   public String getNameById(Long userId) {
      if (userId == null) {
         return null;
      }

      User user = this.baseMapper.selectById(userId);
      return user != null ? user.getName() : null;
   }

   @Override
   public List<NameInfo> listSimpleName(String ids) {
      if (StringUtils.isBlank(ids)) {
         return new ArrayList<>();
      }

      List<Long> idList = Arrays.stream(StringUtils.split(ids, ",")).map(Long::parseLong).collect(Collectors.toList());
      return this.baseMapper
         .selectList(Wrappers.lambdaQuery(User.class).in(User::getId, idList))
         .stream()
         .map(u -> BeanUtil.copy(u, NameInfo.class))
         .collect(Collectors.toList());
   }

   @Override
   public void setInventoryNotifyPerm(List<Long> ids, boolean b) {
      this.baseMapper.updateNotifyType(ids, b);
   }

   private DeptUserTreeResponseVO tranDept(DepartmentUserTreeResponseVO dept) {
      DeptUserTreeResponseVO responseVO = new DeptUserTreeResponseVO();
      responseVO.setId(dept.getId());
      responseVO.setLabel(dept.getName());
      responseVO.setIsUser(Boolean.FALSE);
      List<DeptUserTreeResponseVO> responseVOS = new ArrayList<>();
      dept.getDeptList().forEach(department -> {
         DeptUserTreeResponseVO deptResponse = this.tranDept(department);
         responseVOS.add(deptResponse);
      });
      responseVOS.addAll(this.tranUser(dept.getUserList()));
      if (!responseVOS.isEmpty()) {
         responseVO.setChildren(responseVOS);
      }

      return responseVO;
   }

   private List<DeptUserTreeResponseVO> tranUser(List<User> userList) {
      return userList.stream().map(user -> {
         DeptUserTreeResponseVO responseVO = new DeptUserTreeResponseVO();
         responseVO.setId(user.getId());
         responseVO.setLabel(user.getName());
         responseVO.setIsUser(Boolean.TRUE);
         return responseVO;
      }).collect(Collectors.toList());
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

   @Override
   public User getUserByUserName(String username, Integer userType) {
      return this.baseMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getUsername, username).eq(User::getUserType, userType));
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void initDDUser() {
      List<DeptBaseResponse> deptList = DingDingUtils.listDept(1L, null);
      deptList.forEach(dept -> {
         List<ListUserResponse> ddUserList = DingDingUtils.listUser(dept.getDeptId());
         ddUserList.forEach(e -> this.initUserInfo(BeanUtil.copy(e, DDUserParam.class)));
      });
      this.baseMapper.selectList(null).forEach(user -> {
         if (user.getDdUserId() == null) {
            String ddUserId = DingDingUtils.getUserByPhone(user.getPhone());
            if (StringUtils.isNotBlank(ddUserId)) {
               UserGetResponse ddUser = DingDingUtils.getUserByUserId(ddUserId);
               if (ddUser != null) {
                  user.setDdUserId(ddUser.getUserid());
                  user.setDdDeptId(ddUser.getDeptIdList().get(0));
                  this.baseMapper.updateById(user);
               }
            }
         }
      });
   }

   @Override
   public String checkUserIds(List<Long> ccUserIds, String message) {
      if (CollectionUtils.isEmpty(ccUserIds)) {
         return null;
      }

      List<User> ccUsers = this.baseMapper.selectBatchIds(ccUserIds);
      Preconditions.checkArgument(ccUsers.size() == ccUserIds.size(), message);
      return ccUserIds.stream().map(String::valueOf).collect(Collectors.joining(","));
   }

   @Override
   public String getUserNameWithDeptName(Long userId) {
      if (userId == null) {
         return "";
      }

      User user = this.baseMapper.selectById(userId);
      Preconditions.checkArgument(user != null, "用户不存在");
      DepartmentDTO departmentDTO = null;
      if (user.getDepartmentId() != null) {
         departmentDTO = this.departmentService.getDepartment(user.getDepartmentId());
         Preconditions.checkArgument(departmentDTO != null, "部门不存在");
      }

      StringBuffer sb = new StringBuffer();
      return this.getDeptName(sb, departmentDTO).append(user.getName()).toString();
   }

   private StringBuffer getDeptName(StringBuffer sb, DepartmentDTO department) {
      if (department != null && department.getPid() != 0L) {
         this.getDeptName(sb, this.departmentService.getDepartment(department.getPid()));
         return sb.append(department.getName()).append("/");
      } else {
         return sb;
      }
   }

   private void initUserInfo(DDUserParam ddUser) {
      if (ddUser.getMobile() != null) {
         User user = this.baseMapper.getByPhone(ddUser.getMobile());
         if (user != null) {
            user.setDdUserId(ddUser.getUserid());
            user.setDdDeptId(ddUser.getDeptIdList().get(0));
            user.setIsEnabled(true);
            this.baseMapper.updateById(user);
         } else {
            user = new User();
            user.setUsername("dd" + RandomStringUtils.randomNumeric(6));
            user.setName(ddUser.getName());
            user.setPhone(ddUser.getMobile());
            if (StringUtils.isNotBlank(ddUser.getEmail())) {
               user.setEmail(ddUser.getEmail());
            }

            user.setIsEnabled(true);
            user.setDepartmentId(1L);
            user.setPassword(this.encoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")));
            user.setSex(0);
            user.setDdUserId(ddUser.getUserid());
            user.setDdDeptId(ddUser.getDeptIdList().get(0));
            this.baseMapper.insert(user);
         }
      }
   }

   @Override
   public List<String> listDdUserIdByIds(List<Long> userIds) {
      List<User> users = this.baseMapper.selectBatchIds(userIds);
      return users.stream().map(User::getDdUserId).filter(e -> e != null).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void ddChangeUser(String plainText) {
      UserChangeInfo info = JSON.parseObject(plainText, UserChangeInfo.class);
      String ddUserId = info.getUserId().get(0);
      if ("user_add_org".equals(info.getEventType())) {
         UserGetResponse ddUser = DingDingUtils.getUserByUserId(ddUserId);
         this.initUserInfo(BeanUtil.copy(ddUser, DDUserParam.class));
      } else if ("user_modify_org".equals(info.getEventType())) {
         UserGetResponse ddUser = DingDingUtils.getUserByUserId(ddUserId);
         this.initUserInfo(BeanUtil.copy(ddUser, DDUserParam.class));
      } else if ("user_leave_org".equals(info.getEventType())) {
         User user = this.baseMapper.selectOne((Wrapper<User>)Wrappers.<User>lambdaQuery().eq(User::getDdUserId, ddUserId));
         Preconditions.checkArgument(user != null, "用户不存在");
         user.setIsEnabled(false);
         this.baseMapper.updateById(user);
      }
   }

   @Override
   public List<UserResponseVO> listByCondition(Long deptId, String blurry, Boolean isEnabled, Integer userType) {
      return this.baseMapper.selectByCondition(deptId, blurry, isEnabled, userType);
   }

   @Override
   public List<UserSimpleResponseVO> getSimpleUserByIds(List<Long> ids) {
      return this.baseMapper.getSimpleUserByIds(ids);
   }

   @Override
   public List<UserSimpleResponseVO> getUserAllListVO() {
      return this.baseMapper.getUserAllListVO();
   }

   @Override
   public UserResponseVO getUserByPhone(String phone) {
      return this.baseMapper.getUserByPhone(phone);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean notificationsBindByUser(SysNotificationsBindByUserParam sysNotificationsBindByUserParam) {
      Preconditions.checkArgument(StringUtils.isNotBlank(sysNotificationsBindByUserParam.getRegistrationId()), "参数有误,请联系管理人员!!!!");
      Preconditions.checkArgument(StringUtils.isNotBlank(sysNotificationsBindByUserParam.getPlatform()), "参数有误,请联系管理人员!!!!");
      Long currentUserId = UserUtil.getCurrentUserId();
      User user = this.getById(currentUserId);
      Preconditions.checkArgument(user != null, "用户不存在!!!!");
      String platform = sysNotificationsBindByUserParam.getPlatform();
      if (StringUtils.isNotBlank(platform)) {
         user.setPlatform(platform);
      }

      String registrationId = sysNotificationsBindByUserParam.getRegistrationId();
      if (StringUtils.isNotBlank(registrationId)) {
         user.setRegistrationId(registrationId);
      }

      this.updateById(user);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean notificationsUnBindByUser() {
      Long currentUserId = UserUtil.getCurrentUserId();
      User user = this.getById(currentUserId);
      Preconditions.checkArgument(user != null, "用户不存在!!!!");
      user.setPlatform("");
      user.setRegistrationId("");
      this.updateById(user);
      return Boolean.TRUE;
   }

   @Override
   public void onlineTimeExport(HttpServletResponse response) throws IOException {
      LocalDate date = LocalDate.now();
      String exportFileName = date.getYear() + "年" + date.getMonth().getValue() + "月" + date.getDayOfMonth() + "日-人员在线时长.xlsx";
      List<User> list = this.list();
      Map<Long, List<SysLog>> listMap = this.sysLogService
         .list(Wrappers.lambdaQuery(SysLog.class).isNotNull(SysLog::getUserId).apply("date_format(create_time,'%Y-%m') = date_format(now(),'%Y-%m')"))
         .stream()
         .collect(Collectors.groupingBy(SysLog::getUserId));
      HashMap<User, HashMap<Integer, BigDecimal>> map = new HashMap<>();
      Map<Long, List<SysLog>> finalListMap = listMap;
      list.forEach(itme -> {
         List<SysLog> sysLogs = finalListMap.get(itme.getId());
         HashMap<Integer, BigDecimal> timeMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(sysLogs)) {
            Map<Integer, List<SysLog>> map1 = sysLogs.stream().collect(Collectors.groupingBy(itme1 -> itme1.getCreateTime().getDayOfMonth()));
            sysLogs.stream().collect(Collectors.groupingBy(itme1 -> itme1.getCreateTime().getDayOfMonth())).forEach((key, value) -> {
               LocalDateTime startTime = value.stream().map(BaseEntity::getCreateTime).min(Comparator.naturalOrder()).get();
               LocalDateTime endTime = value.stream().map(BaseEntity::getCreateTime).max(Comparator.naturalOrder()).get();
               long hours = ChronoUnit.HOURS.between(startTime, endTime);
               long minutes = ChronoUnit.MINUTES.between(startTime, endTime) % 60L;
               BigDecimal totalHours = BigDecimal.valueOf(hours + minutes / 60.0).setScale(2, RoundingMode.HALF_UP);
               timeMap.put(key, totalHours);
            });
         }

         map.put(itme, timeMap);
      });
      Map<Long, String> deptMap = this.departmentService.list().stream().collect(Collectors.toMap(Department::getId, Department::getName));
      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet(date.getYear() + "年" + date.getMonth().getValue() + "月在线时长");
      Font font = workbook.createFont();
      font.setFontHeightInPoints((short)24);
      font.setBold(true);
      CellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setFont(font);
      sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, date.getDayOfMonth() + 1));
      Row titleRow = sheet.createRow(0);
      titleRow.createCell(0).setCellValue(date.getYear() + "年" + date.getMonth().getValue() + "月人员在线时长统计表(单位H)");
      Row headerRow = sheet.createRow(1);
      headerRow.createCell(0).setCellValue("部门");
      headerRow.createCell(1).setCellValue("用户名");

      for (int i = 1; i <= date.getDayOfMonth(); i++) {
         headerRow.createCell(i + 1).setCellValue(i + "号");
      }

      headerRow.createCell(date.getDayOfMonth() + 2).setCellValue("合计");
      int rowNum = 2;

      for (Entry<User, HashMap<Integer, BigDecimal>> entry : map.entrySet()) {
         Row row = sheet.createRow(rowNum++);
         User user = entry.getKey();
         if (user.getDepartmentId() != null) {
            row.createCell(0).setCellValue(deptMap.get(user.getDepartmentId()));
         }

         row.createCell(1).setCellValue(user.getName());

         for (int i = 1; i <= date.getDayOfMonth(); i++) {
            BigDecimal bigDecimal = entry.getValue().get(i);
            row.createCell(i + 1).setCellValue(bigDecimal == null ? 0.0 : bigDecimal.doubleValue());
         }

         BigDecimal sum = entry.getValue().values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
         row.createCell(date.getDayOfMonth() + 2).setCellValue(sum.doubleValue());
      }

      try {
         response.setContentType("application/vnd.ms-excel;charset=UTF-8");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(exportFileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setCharacterEncoding("utf-8");
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }

      OutputStream out = response.getOutputStream();
      workbook.write(out);
      out.close();
      workbook.close();
   }

   @Override
   public Boolean sendVerificationCode(UserResetPhonePasswordRequestVO requestVO) {
      Preconditions.checkArgument(
         Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", requestVO.getPhone()), "手机格式错误"
      );
      User user = this.baseMapper.getByPhone(requestVO.getPhone());
      Preconditions.checkArgument(user != null, "不存在该账号");
      Object o = this.redisUtils.get("forget_the_password" + requestVO.getPhone());
      Preconditions.checkArgument(o == null, "请勿重复发送验证码");
      JSONObject message = new JSONObject();
      String verifyCode = RandomStringUtils.randomNumeric(6);
      message.put("code", verifyCode);
      this.redisUtils.set("forget_the_password" + requestVO.getPhone(), verifyCode, 60L);
      this.smsUtils.sendSms(requestVO.getPhone(), message.toJSONString(), "SMS_170116425");
      return Boolean.TRUE;
   }

   @Override
   public Boolean checkVerificationCode(UserResetPhonePasswordRequestVO requestVO) {
      String code = (String)this.redisUtils.get("forget_the_password" + requestVO.getPhone());
      Preconditions.checkArgument(code != null, "验证失败，验证码不存在或已失效");
      Preconditions.checkArgument(code.equals(requestVO.getVerifyCode()), "验证失败，验证码错误");
      User user = this.baseMapper.getByPhone(requestVO.getPhone());
      Preconditions.checkArgument(user != null, "不存在该账号");
      String password = this.decryptPassword(requestVO.getPassword());
      List<Role> roles = this.roleService.listByUserId(user.getId());
      Boolean isAdmin = roles.stream().anyMatch(role -> "admin".equals(role.getPermission()));
      SysPasswordPolicyDTO passwordPolicy = this.configService.getPasswordPolicy();
      PasswordPolicyUtil.checkPolicy(password, passwordPolicy, isAdmin);
      user.setPassword(this.encoder.encode(password));
      user.setLastPasswordResetDate(LocalDateTime.now());
      this.baseMapper.updateById(user);
      GeneratorUserDetailService.USER_MAP.remove(user.getId());
      this.redisUtils.del("forget_the_password" + requestVO.getPhone());
      return true;
   }

   @Transactional
   @Override
   public Boolean updateUserType(Long userId) {
      User user = this.getById(userId);
      Preconditions.checkArgument(user != null, "用户不存在");
      Preconditions.checkArgument(user.getUserType().equals(UserTypeEnum.COMMON_USER.getType()), "该用户不是编制内用户");
      Preconditions.checkArgument(user.getIsEnabled().equals(Boolean.FALSE), "该用户启用状态不可修改编制类型");
      user.setUserType(UserTypeEnum.LABOR_USER.getType());
      return this.updateById(user);
   }
}
