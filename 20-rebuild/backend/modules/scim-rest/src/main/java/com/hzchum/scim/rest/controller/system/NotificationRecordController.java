package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationRecordBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "推送管理-推送记录-pc暂时没用")
@RestController
@RequestMapping("/api/push/record")
public class NotificationRecordController {
   private static final Logger log = LoggerFactory.getLogger(NotificationRecordController.class);
   @Resource
   private SysPushNotificationRecordBiz sysPushNotificationRecordBiz;

   @ApiOperation("推送信息阅读")
   @PostMapping("")
   public ResultVO readPushMessage(@RequestParam Long id) {
      log.info("API调用:推送消息阅读");
      return ResultBuilder.success(this.sysPushNotificationRecordBiz.readPushMessage(id));
   }

   public NotificationRecordController(final SysPushNotificationRecordBiz sysPushNotificationRecordBiz) {
      this.sysPushNotificationRecordBiz = sysPushNotificationRecordBiz;
   }
}
