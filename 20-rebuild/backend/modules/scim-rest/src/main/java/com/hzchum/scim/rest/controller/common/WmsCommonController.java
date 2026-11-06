package com.hzchum.scim.rest.controller.common;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "WMS公共接口")
@RestController
@RequestMapping("/api/wms/common")
public class WmsCommonController {
   private static final Logger log = LoggerFactory.getLogger(WmsCommonController.class);
   @Value("${approve.subjoinMsgBoolShow}")
   private Boolean subjoinMsgBoolShow;

   @ApiOperation("获取审批附加信息是否显示")
   @GetMapping("/getSubjoinMsgBoolShow")
   public ResultVO getSubjoinMsgBoolShow() {
      log.info("API 调用 ：获取审批附加信息是否显示");
      return ResultBuilder.success(this.subjoinMsgBoolShow);
   }
}
