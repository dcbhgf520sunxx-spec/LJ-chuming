package com.hzchum.scim.rest.controller.common;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.biz.CommonTokenBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "公共-token校验")
@RestController
@RequestMapping("/api/common/token")
public class CommonTokenController {
   private static final Logger log = LoggerFactory.getLogger(CommonTokenController.class);
   @Resource
   private CommonTokenBiz commonTokenBiz;

   @ApiOperation("获取token")
   @GetMapping
   public ResultVO getToken(@RequestParam String appKey, @RequestParam String appSecret) {
      log.info("API 调用 ：获取token");
      return ResultBuilder.success(this.commonTokenBiz.getToken(appKey, appSecret));
   }

   @ApiOperation("刷新token")
   @GetMapping("/refresh")
   public ResultVO refreshToken(@RequestParam String refreshToken) {
      log.info("API 调用 ：用友-刷新token");
      return ResultBuilder.success(this.commonTokenBiz.refreshToken(refreshToken));
   }
}
