package com.hzchum.scim.rest.controller.system;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.project.core.api.biz.ProjectSupplierAccountBiz;
import com.hzchum.scim.project.core.api.pojo.dto.sub.SubProjectDTO;
import com.hzchum.scim.system.core.api.biz.UserBiz;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.MenuCategoryEnum;
import com.hzchum.scim.system.core.api.common.utils.RSAUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetEmailPasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetPasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserResetPhonePasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSaveRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSetEnabledRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleUpdateRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.UserUpdateDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.UserUpdatePasswordRequestVO;
import com.hzchum.scim.system.core.api.pojo.param.SysNotificationsBindByUserParam;
import com.hzchum.scim.system.core.api.pojo.request.LoginRequestVO;
import com.hzchum.scim.system.core.api.service.MenuService;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "系统管理-用户")
@RestController
@RequestMapping("/api/user")
public class UserApi {
   private static final Logger log = LoggerFactory.getLogger(UserApi.class);
   private final UserService userService;
   private final UserBiz userBiz;
   private final ProjectUserLinkService projectUserLinkService;
   private final MenuService menuService;
   private final ContractProjectBiz contractProjectBiz;
   private final ProjectSupplierAccountBiz supplierAccountBiz;

   @ApiOperation(value = "用户 - 列表(全部|简单|排序)", notes = "查询所有用户（按部门排序）")
   @GetMapping("/all/simple")
   public Result getSimpleUser() {
      log.info("API 调用 ： 查询所有用户（按部门排序）");
      return ResultGenerator.genSuccessResult(this.userService.getSimpleUser());
   }

   @ApiOperation(value = "部门用户树", notes = "部门用户树")
   @GetMapping("/tree")
   public Result userTree(@RequestParam(defaultValue = "true") Boolean hasRoot) {
      log.info("API 调用 ： 部门用户树");
      return ResultGenerator.genSuccessResult(this.userBiz.userTree(hasRoot));
   }

   @ApiOperation(value = "项目用户 - 列表(全部 | 简单)", notes = "根据项目id查询当前项目用户所有用户")
   @ApiImplicitParam(name = "id", value = "项目id", paramType = "query")
   @GetMapping("/project/{id}/all/simple")
   public Result listUser(@PathVariable Long id) {
      log.info("API 调用 ： 根据项目id查询当前项目用户所有用户");
      return ResultGenerator.genSuccessResult(this.projectUserLinkService.listUser(id));
   }

   @ApiOperation(value = "用户登录（可用手机，用户名，邮箱）", notes = "用户登录（可用手机，用户名，邮箱）")
   @PostMapping("/login")
   public Result login(@Valid @RequestBody LoginRequestVO requestVO) {
      log.info("API 调用 ： 用户登录（可用手机，用户名，邮箱）");
      return ResultGenerator.genSuccessResult(this.userService.login(requestVO.getUsername(), requestVO.getPassword()));
   }

   @ApiOperation(value = "用户登录（用户名）", notes = "用户登录（用户名）")
   @PostMapping("/login/sub")
   public Result subLogin(@Valid @RequestBody LoginRequestVO requestVO) {
      log.info("API 调用 ： 分包商用户登录（户名）");
      return ResultGenerator.genSuccessResult(this.userService.subLogin(requestVO.getUsername(), requestVO.getPassword()));
   }

   @ApiOperation(value = "用户注册", notes = "添加或注册一个新的用户")
   @PostMapping("")
   @PreAuthorize("@permission.check('user:add')")
   public Result register(@Valid @RequestBody UserSaveRequestVO requestVO) {
      log.info("API 调用 ：保存一个新的用户");
      return ResultGenerator.genSuccessResult(this.userBiz.register(requestVO));
   }

   @ApiOperation(value = "pc端用户信息", notes = "已登录用户获取个人信息")
   @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header")
   @GetMapping("/info")
   public Result getUser() {
      log.info("API 调用 ： 登录用户获取个人信息");
      SecurityUser user = UserUtil.getCurrentUser();
      return ResultGenerator.genSuccessResult(this.userBiz.getInfo(user, MenuCategoryEnum.PC.getValue()));
   }

   @ApiOperation(value = "app用户信息", notes = "app已登录用户获取个人信息")
   @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header")
   @GetMapping("/app/info")
   public Result getUserInfo() {
      log.info("API 调用 ： app登录用户获取个人信息");
      SecurityUser user = UserUtil.getCurrentUser();
      return ResultGenerator.genSuccessResult(this.userBiz.getInfo(user, MenuCategoryEnum.APP.getValue()));
   }

   @ApiOperation("app分包商用户信息")
   @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header", required = true)
   @GetMapping("/app/sub")
   public Result getTempUserInfo() {
      log.info("API 调用 ： app登录用户获取个人信息");
      SecurityUser user = UserUtil.getCurrentUser();
      return ResultGenerator.genSuccessResult(this.userBiz.getTempUserInfo(user));
   }

   @ApiOperation("app分包商用户信息V2")
   @GetMapping("/app/subV2")
   public Result getTempUserInfoV2() {
      log.info("API 调用 ： app登录用户获取个人信息");
      SecurityUser user = UserUtil.getCurrentUser();
      return ResultGenerator.genSuccessResult(this.userBiz.getTempUserInfoV2(user));
   }

   @ApiOperation("个人中心-修改用户")
   @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header")
   @PutMapping("/info")
   public Result updateUserSimpleInfo(@Valid @RequestBody UserSimpleUpdateRequestVO requestVO) {
      log.info("API 调用 ： 登录用户获取个人信息");
      return ResultGenerator.genSuccessResult(this.userService.updateUserSimpleInfo(requestVO));
   }

   @ApiOperation("设置为深化用户")
   @PutMapping("/deepen")
   @PreAuthorize("@permission.check('deep_pen_config_edit')")
   public Result updateUserSimpleInfo(@RequestBody List<Long> newUserIds) {
      log.info("API 调用 ： 设置为深化用户");
      return ResultGenerator.genSuccessResult(this.userService.updateUserDeepen(newUserIds));
   }

   @ApiOperation(value = "凭证刷新", notes = "用户刷新登录凭证")
   @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header")
   @GetMapping("/refresh")
   public Result refreshToken(HttpServletRequest httpServletRequest, @RequestHeader("Authorization") String token) {
      log.info("API 调用 ： 用户Token的刷新");
      return ResultGenerator.genSuccessResult(this.userService.refreshToken(token));
   }

   @ApiOperation(value = "切换用户禁用状态", notes = "切换用户禁用状态")
   @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header")
   @PutMapping("/enabled")
   @PreAuthorize("@permission.check('user:edit')")
   public Result changeUserDisable(@RequestBody @Valid UserSetEnabledRequestVO requestVO) {
      log.info("API 调用 ： 切换用户禁用状态");
      return ResultGenerator.genSuccessResult(this.userBiz.changeUserDisable(requestVO.getId(), requestVO.getEnabled(), null));
   }

   @ApiOperation(value = "列表-用户", notes = "根据条件分页获取职员列表(除了这个接口，其他所有获取用户接口都是获取未禁用的)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "blurry", value = "姓名，手机号，邮箱模糊搜索", paramType = "query"),
            @ApiImplicitParam(name = "deptId", value = "部门id", paramType = "query"),
            @ApiImplicitParam(name = "enabled", value = "是否是激活状态,true:已激活，false：未激活", paramType = "query"),
            @ApiImplicitParam(name = "userType", value = "人员类型,userTypeEnum", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10")
      }
   )
   @GetMapping("")
   @PreAuthorize("@permission.check('user:get')")
   public Result pageUser(
      @RequestParam(required = false) String blurry,
      @RequestParam(required = false) Long deptId,
      @RequestParam(required = false) Boolean enabled,
      @RequestParam(required = false) Integer userType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ： 根据项目id，用户名，状态分页获取公司职员列表");
      return ResultGenerator.genSuccessResult(this.userBiz.pageUser(deptId, blurry, enabled, userType, pageNumber, pageSize));
   }

   @ApiOperation(value = "用户更新", notes = "更新用户的信息")
   @PutMapping("")
   @PreAuthorize("@permission.check('user:edit')")
   public Result updateUser(@Valid @RequestBody UserUpdateDTOParam requestVO) {
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未传入用户信息token");
      log.info("API 调用 ： 更新用户的信息");
      return ResultGenerator.genSuccessResult(this.userBiz.updateUser(requestVO));
   }

   @ApiOperation(value = "根据手机号重置用户的账户密码", notes = "根据手机号重置用户的账户密码")
   @PutMapping("/reset")
   public Result resetPassword(@Valid @RequestBody UserResetPhonePasswordRequestVO requestVO) {
      log.info("API 调用 ： 根据手机号重置用户的账户密码");
      return ResultGenerator.genSuccessResult(this.userService.resetPassword(requestVO));
   }

   @ApiOperation(value = "app根据手机号重置用户的账户密码", notes = "app根据手机号重置用户的账户密码")
   @PutMapping("/app/reset")
   public Result appResetPassword(@Valid @RequestBody UserResetPhonePasswordRequestVO requestVO) {
      log.info("API 调用 ： 根据手机号重置用户的账户密码");
      return ResultGenerator.genSuccessResult(this.userService.resetPassword(requestVO));
   }

   @ApiOperation(value = "根据邮箱重置用户的账户密码", notes = "根据邮箱重置用户的账户密码")
   @PutMapping("/resetEmail")
   public Result resetPassword(@Valid @RequestBody UserResetEmailPasswordRequestVO requestVO) {
      log.info("API 调用 ： 根据邮箱重置用户的账户密码");
      return ResultGenerator.genSuccessResult(this.userService.resetPassword(requestVO));
   }

   @ApiOperation(value = "app根据邮箱重置用户的账户密码", notes = "app根据邮箱重置用户的账户密码")
   @PutMapping("/app/resetEmail")
   public Result appResetPassword(@Valid @RequestBody UserResetEmailPasswordRequestVO requestVO) {
      log.info("API 调用 ： 根据邮箱重置用户的账户密码");
      return ResultGenerator.genSuccessResult(this.userService.resetPassword(requestVO));
   }

   @ApiOperation(value = "获取-重置密码短信验证码", notes = "获取-重置密码短信验证码")
   @ApiImplicitParam(name = "phone", value = "手机号", paramType = "query")
   @GetMapping("/verifyCode")
   public Result sendVerifyCode(@RequestParam String phone) {
      log.info("API 调用 ：发送重置密码短信验证码");
      return ResultGenerator.genSuccessResult(this.userService.sendPhoneVerifyCode(phone));
   }

   @ApiOperation(value = "app获取-重置密码短信验证码", notes = "app获取-重置密码短信验证码")
   @ApiImplicitParam(name = "phone", value = "手机号", paramType = "query")
   @GetMapping("/app/verifyCode")
   public Result appSendVerifyCode(@RequestParam String phone) {
      log.info("API 调用 ：发送重置密码短信验证码");
      return ResultGenerator.genSuccessResult(this.userService.sendPhoneVerifyCode(phone));
   }

   @ApiOperation(value = "获取-重置密码邮件验证码", notes = "获取-重置密码邮件验证码")
   @ApiImplicitParam(name = "email", value = "邮件", paramType = "query")
   @GetMapping("/resetEmail")
   public Result sendEmailVerifyCode(@RequestParam String email) {
      log.info("API 调用 ：发送重置密码邮件验证码");
      return ResultGenerator.genSuccessResult(this.userService.sendEmailVerifyCode(email));
   }

   @ApiOperation(value = "app获取-重置密码邮件验证码", notes = "app获取-重置密码邮件验证码")
   @ApiImplicitParam(name = "email", value = "邮件", paramType = "query")
   @GetMapping("/app/resetEmail")
   public Result appSendEmailVerifyCode(@RequestParam String email) {
      log.info("API 调用 ：发送重置密码邮件验证码");
      return ResultGenerator.genSuccessResult(this.userService.sendEmailVerifyCode(email));
   }

   @ApiOperation(value = "用户删除", notes = "批量删除用户信息")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('user:del')")
   public Result deleteUser(@RequestBody List<Long> ids) {
      log.info("API 调用 ： 更新用户的信息");
      return ResultGenerator.genSuccessResult(this.userBiz.deleteUser(ids));
   }

   @ApiOperation("修改用户密码")
   @PostMapping("/updatePwd")
   public Result updatePwd(@Valid @RequestBody UserUpdatePasswordRequestVO requestVO) {
      log.info("API 调用 ：修改用户密码");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "未传入用户信息token");
      return ResultGenerator.genSuccessResult(this.userService.updatePwd(user.getId(), requestVO));
   }

   @ApiOperation("退出登录")
   @DeleteMapping("/logout")
   public Result logOut(HttpServletRequest request) {
      log.info("API 调用 ： 退出登录");

      try {
         request.logout();
      } catch (ServletException e) {
         log.info("退出登录失败：", e);
      }

      return ResultGenerator.genSuccessResult();
   }

   @ApiOperation(value = "项目-列表(页面顶部显示)", notes = "查询用户相关的简单项目信息(包含年份-用于选择项目)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header"),
            @ApiImplicitParam(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库  ", paramType = "query"),
            @ApiImplicitParam(name = "businessType", value = "业务类型 1加工承揽 2项目承包 ", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "项目状态 1进行中 2暂停 4完工  ", paramType = "query"),
            @ApiImplicitParam(name = "settlementStatus", value = "结算状态 1已结算 0未结算 ", paramType = "query"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = "包干制项目管理类型", paramType = "query")
      }
   )
   @GetMapping("/project/simple")
   public Result<ListVO<ProjectSimpleInfoDTO>> listSimpleProject(
      Integer projectType,
      Integer businessType,
      Integer status,
      Integer settlementStatus,
      @RequestParam(required = false) Integer lumpSumSystemType,
      Integer level
   ) {
      log.info("API 调用 ：查询用户相关的简单项目信息");
      return ResultGenerator.genSuccessResult(
         new ListVO<>(this.contractProjectBiz.listSimpleProjectInfo(projectType, businessType, status, settlementStatus, lumpSumSystemType, level))
      );
   }

   @ApiOperation("获取未添加结算单的项目")
   @GetMapping("/project/visa/simple")
   public Result listUnSettlementProject(Integer projectType, Integer businessType) {
      log.info("API 调用 ：获取未添加结算单的项目");
      return ResultGenerator.genSuccessResult(this.contractProjectBiz.listProjectSettleInfo(projectType, businessType, null, null));
   }

   @ApiOperation(value = "获取用户动态菜单", notes = "获取用户动态菜单")
   @ApiImplicitParams(@ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header"))
   @GetMapping("/menu")
   public Result getMenuBuildTree(HttpServletRequest request) {
      log.info("API 调用 ： 获取用户动态菜单");
      SecurityUser user = (SecurityUser)request.getAttribute("user");
      Preconditions.checkArgument(user != null, "未传入用户信息token");
      return ResultGenerator.genSuccessResult(this.menuService.getMenuBuildTree(user));
   }

   @ApiOperation(value = "获取部门岗位的用户信息", notes = "获取部门岗位的用户信息")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "deptId", value = "部门id ", paramType = "query"), @ApiImplicitParam(name = "jobId", value = "岗位id ", paramType = "query")}
   )
   @GetMapping("/dept")
   public Result userTree(@RequestParam Long deptId, @RequestParam Long jobId) {
      log.info("API 调用 ： 获取部门岗位的用户信息");
      return ResultGenerator.genSuccessResult(this.userBiz.getUserDept(deptId, jobId));
   }

   @ApiOperation("劳务分包商可见-项目树")
   @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header")
   @GetMapping("/app/sub/project-tree")
   public ResultVO<ListVO<SubProjectDTO>> listSubSupplierProject() {
      log.info("Api调用: 查询-劳务分包商可见-项目列表");
      return ResultBuilder.success(new ListVO<>(this.supplierAccountBiz.listProject()));
   }

   @ApiOperation("下载-用户人员导入模板")
   @GetMapping("/template/export")
   public ResultVO<Boolean> exportUserImportTemplate(HttpServletResponse response) {
      log.info("Api调用:下载-用户人员导入模板");
      return ResultBuilder.success(this.userBiz.exportUserTemplate(response));
   }

   @ApiOperation("导入-用户人员表格")
   @PostMapping("/import")
   public ResultVO<Boolean> importUser(Long branchCompanyId, @RequestPart MultipartFile file, HttpServletResponse response) {
      log.info("Api调用: 查询-劳务分包商可见-项目列表");
      return ResultBuilder.success(this.userBiz.importUser(branchCompanyId, file, response));
   }

   @ApiOperation("劳务分包商可见-项目树V2")
   @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header")
   @GetMapping("/app/sub/project-treeV2")
   public ResultVO<ListVO<SubProjectDTO>> listSubSupplierProjectV2() {
      log.info("Api调用: 查询-劳务分包商可见-项目列表V2");
      return ResultBuilder.success(new ListVO<>(this.supplierAccountBiz.listProjectV2()));
   }

   @ApiOperation("手机号获取用户信息")
   @GetMapping("/get-user-by-phone")
   public ResultVO getUserByPhone(@RequestParam String phone) {
      log.info("API 调用 ： 手机号获取用户信息");
      return ResultBuilder.success(this.userBiz.getUserByPhone(phone));
   }

   @ApiOperation(value = "重置密码", notes = "重置密码")
   @PutMapping("/resetToDefaultPassword")
   @PreAuthorize("@permission.check('user:resetToDefaultPassword')")
   public Result resetToDefaultPassword(@RequestBody UserResetPasswordRequestVO requestVO) {
      log.info("API 调用 ： 根据手机号重置用户的账户密码");
      return ResultGenerator.genSuccessResult(this.userService.resetToDefaultPassword(requestVO));
   }

   @ApiOperation("APP用户设备码绑定")
   @PostMapping("/notifications/bind")
   public ResultVO notificationsBindByUser(@RequestBody SysNotificationsBindByUserParam sysNotificationsBindByUserParam) {
      log.info("API 调用 ： APP用户设备码绑定");
      return ResultBuilder.success(this.userService.notificationsBindByUser(sysNotificationsBindByUserParam));
   }

   @ApiOperation("APP用户设备码解绑")
   @PostMapping("/notifications/unbind")
   public ResultVO notificationsUnBindByUser() {
      log.info("API 调用 ： APP用户设备码解绑");
      return ResultBuilder.success(this.userService.notificationsUnBindByUser());
   }

   @ApiOperation("人员在线时长导出(中南定制)")
   @GetMapping("/online/time/export")
   public void onlineTimeExport(HttpServletResponse response) throws IOException {
      log.info("API 调用 ： 人员在线时长导出(中南定制)");
      this.userService.onlineTimeExport(response);
   }

   @ApiOperation("中南知识产权(中南定制)")
   @GetMapping("/intellectual/property")
   public ResultVO getIntellectualProperty() throws IOException {
      String publicKey = "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7Y7HmFw5Khu6XPAZgZLr\nhaa7GQqCjsDcsN872YE+F+tyEIVJQZIh+3qzIpn3Qe3ipQsX/994BemWsrAsb586\nl2bpJC1JyR4Mtwpw5B2BnG/Gb0+CfN4Sjk+08SD8iXrvVKRiOxv1yEvr7Yqgp2Uc\ngoJYYhVKH9SU0r3CSl8ub1uVWUwgU84HTcB26i1XIlJUA8+l1E1fa7nIVuZOeJnC\nIrfth6jAyY8yMtBuTd182WGJ91ArwupuVT1lJks/hKSVYNT07JuwiRV8zmOyPjq6\nMKw3DMqIPoYVBdgmF5TR/kAz3S+6x24jZUmbUdlM0y6tDIFbJWimt1/xJqEsR3wu\nLwIDAQAB\n-----END PUBLIC KEY-----";
      String phone = "";
      String name = "";

      try {
         phone = RSAUtils.encryptWithPublicKey(UserUtil.getCurrentUser().getPhone(), publicKey);
         name = RSAUtils.encryptWithPublicKey(UserUtil.getCurrentUser().getName(), publicKey);
      } catch (Exception e) {
         throw new RuntimeException("RSAUtils手机号码加密失败");
      }

      String url = "http://znzhlj.znjs.com:8097/ZNLJ?secret=" + phone + "&name=" + name;
      return ResultBuilder.success(url);
   }

   @ApiOperation("忘记密码获取验证码")
   @PostMapping("/send/verificationCode")
   public ResultVO sendVerificationCode(@RequestBody UserResetPhonePasswordRequestVO requestVO) {
      log.info("API 调用 ： 忘记密码获取验证码");
      return ResultBuilder.success(this.userService.sendVerificationCode(requestVO));
   }

   @ApiOperation("忘记密码复核短信验证码验证并重置密码")
   @PostMapping("/check/verificationCode")
   public ResultVO checkVerificationCode(@RequestBody UserResetPhonePasswordRequestVO requestVO) {
      log.info("API 调用 ：忘记密码复核短信验证码验证并重置密码");
      return ResultBuilder.success(this.userService.checkVerificationCode(requestVO));
   }

   @ApiOperation("禁用的编制内用户修改为编制外类型")
   @PostMapping("/update/user/type")
   public ResultVO updateUserType(Long userId) {
      log.info("API 调用 ：禁用的编制内用户修改为编制外类型");
      return ResultBuilder.success(this.userService.updateUserType(userId));
   }

   public UserApi(
      final UserService userService,
      final UserBiz userBiz,
      final ProjectUserLinkService projectUserLinkService,
      final MenuService menuService,
      final ContractProjectBiz contractProjectBiz,
      final ProjectSupplierAccountBiz supplierAccountBiz
   ) {
      this.userService = userService;
      this.userBiz = userBiz;
      this.projectUserLinkService = projectUserLinkService;
      this.menuService = menuService;
      this.contractProjectBiz = contractProjectBiz;
      this.supplierAccountBiz = supplierAccountBiz;
   }
}
