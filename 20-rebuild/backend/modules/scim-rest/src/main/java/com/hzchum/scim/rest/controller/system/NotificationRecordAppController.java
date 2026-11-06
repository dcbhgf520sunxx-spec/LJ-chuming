package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationRecordBiz;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushNotificationDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushNotificationRecordAppListDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "App推送记录")
@RestController
@RequestMapping("/api/push/record/app")
public class NotificationRecordAppController {
   private static final Logger log = LoggerFactory.getLogger(NotificationRecordAppController.class);
   @Resource
   private SysPushNotificationRecordBiz sysPushNotificationRecordBiz;

   @ApiOperation("推送列表")
   @GetMapping("/getAppList")
   public ResultVO<List<SysPushNotificationRecordAppListDTO>> getList() {
      log.info("API调用:推送列表");
      return ResultBuilder.success(this.sysPushNotificationRecordBiz.getAppList());
   }

   @ApiOperation("推送信息详情")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "operationalModuleType", value = "模块类型", paramType = "query", required = true),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "isRead", value = "是否阅读(true,已读，false，未读)", paramType = "query"),
            @ApiImplicitParam(name = "content", value = "消息详情", paramType = "query")
      }
   )
   @GetMapping("/pushMessage/detail")
   public ResultVO<PageVO<SysPushNotificationDetailDTO>> getAppMessageDetail(
      Integer operationalModuleType,
      LocalDate startDate,
      LocalDate endDate,
      Boolean isRead,
      String content,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "6") Integer pageSize
   ) {
      log.info("API调用:消息推送详情");
      return ResultBuilder.success(
         this.sysPushNotificationRecordBiz.getAppMessageDetail(operationalModuleType, startDate, endDate, isRead, content, pageNumber, pageSize)
      );
   }

   @ApiOperation("推送信息阅读")
   @PostMapping("")
   public ResultVO readPushMessage(@RequestParam Long id) {
      log.info("API调用:推送消息阅读");
      return ResultBuilder.success(this.sysPushNotificationRecordBiz.readPushMessage(id));
   }

   @ApiOperation("一键阅读")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "operationalModuleType", value = "模块类型", paramType = "query", required = true),
            @ApiImplicitParam(name = "startDate", value = "开始时间", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", paramType = "query"),
            @ApiImplicitParam(name = "content", value = "消息详情", paramType = "query")
      }
   )
   @PutMapping("/read/batch")
   public ResultVO readBatchMessage(Integer operationalModuleType, LocalDate startDate, LocalDate endDate, String content) {
      log.info("API调用:推送一键阅读");
      return ResultBuilder.success(this.sysPushNotificationRecordBiz.readBatchMessage(operationalModuleType, startDate, endDate, content));
   }

   public NotificationRecordAppController(final SysPushNotificationRecordBiz sysPushNotificationRecordBiz) {
      this.sysPushNotificationRecordBiz = sysPushNotificationRecordBiz;
   }
}
