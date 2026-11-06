package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.system.core.api.biz.UserBiz;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.request.WeChatBindingRequestVO;
import com.hzchum.scim.system.core.api.pojo.request.WeChatLoginRequestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "微信小程序-用户")
@RestController
@RequestMapping("/api/we_chat")
public class WeChatApi {
   private static final Logger log = LoggerFactory.getLogger(WeChatApi.class);
   @Resource
   private final UserBiz userBiz;

   @ApiOperation(value = "小程序用户登录", notes = "")
   @PostMapping("/login")
   @SignerCheck(lockKey = "#requestVO.code", message = "登录中,请勿重复提交!!!")
   public Result login(@Validated @RequestBody WeChatLoginRequestVO requestVO) {
      log.info("API 调用 ： 用户登录（可用手机，用户名，邮箱）");
      return ResultGenerator.genSuccessResult(this.userBiz.weChatLogin(requestVO.getCode()));
   }

   @ApiOperation(value = "绑定小程序用户并登录", notes = "")
   @PostMapping("/binding")
   @SignerCheck(lockKey = "#requestVO.key", message = "登录中,请勿重复提交!!!")
   public Result binding(@Validated @RequestBody WeChatBindingRequestVO requestVO) {
      log.info("API 调用 ： 用户登录（可用手机，用户名，邮箱）");
      return ResultGenerator.genSuccessResult(this.userBiz.weChatBindAndLogin(requestVO.getKey(), requestVO.getPhone(), requestVO.getCode()));
   }

   @ApiOperation("退出登录并解绑")
   @DeleteMapping("/logout")
   public Result logOut(HttpServletRequest request) {
      log.info("API 调用 ： 退出登录并解绑(未使用)");
      this.userBiz.logoutAndRelieveBind();

      try {
         request.logout();
      } catch (ServletException e) {
         log.info("退出登录失败：", e);
      }

      return ResultGenerator.genSuccessResult();
   }

   @ApiOperation(value = "发送登录验证码", notes = "")
   @GetMapping("/sendCode")
   public Result appSendVerifyCode(@RequestParam String phone) {
      log.info("API 调用 ：发送登录验证码");
      return ResultGenerator.genSuccessResult(this.userBiz.sendCode(phone));
   }

   @ApiOperation("获取小程序二维码")
   @GetMapping("/getQRCode")
   public void getQRCode() {
      log.info("API调用:获取小程序二维码");
      this.userBiz.getQrCode();
   }

   public WeChatApi(final UserBiz userBiz) {
      this.userBiz = userBiz;
   }
}
