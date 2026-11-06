package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-库存预警通知")
@RestController
@RequestMapping("/api/wms/material/inventory/reminder")
public class WarningReminderController {
   private static final Logger log = LoggerFactory.getLogger(WarningReminderController.class);
   @Resource
   WarningService warningService;

   @ApiOperation("获取预警列表")
   @GetMapping
   public ResultVO list() {
      log.info("API 调用 ：获取预警列表");
      return ResultBuilder.success(this.warningService.getReminder());
   }
}
