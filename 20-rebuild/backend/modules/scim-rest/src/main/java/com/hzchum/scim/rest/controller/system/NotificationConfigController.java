package com.hzchum.scim.rest.controller.system;

import cn.hutool.core.bean.BeanUtil;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.notification.SysPushNotificationConfigBiz;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationConfigDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "推送管理-推送配置")
@RestController
@RequestMapping("/api/notification/config")
public class NotificationConfigController {
   private static final Logger log = LoggerFactory.getLogger(NotificationConfigController.class);
   @Resource
   private SysPushNotificationConfigBiz sysPushNotificationConfigBiz;

   @ApiOperation("推送配置查询")
   @PostMapping("/getList")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "operationalModuleTypeEnum", value = "模块类型", paramType = "query"),
            @ApiImplicitParam(name = "isDisposition", value = "是否配置", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "是否开启", paramType = "query"),
            @ApiImplicitParam(name = "notificationModeTypeEnum", value = "通知方式", paramType = "query")
      }
   )
   @PreAuthorize("@permission.check('push_message_config:get')")
   public ResultVO getList(Integer operationalModuleTypeEnum, Boolean isDisposition, Boolean status, Integer notificationModeTypeEnum) {
      log.info("API调用:推送配置查询");
      return ResultBuilder.success(this.sysPushNotificationConfigBiz.getList(operationalModuleTypeEnum, isDisposition, status, notificationModeTypeEnum));
   }

   @ApiOperation("推送配置修改")
   @PostMapping("")
   @PreAuthorize("@permission.check('push_message_config:pushSave')")
   public ResultVO editNotification(
      @RequestBody List<NotificationConfigVO> vo,
      @RequestParam(name = "notificationType", required = false) Integer notificationType,
      @RequestParam(name = "operationalModuleType", required = false) Integer operationalModuleType
   ) {
      log.info("API调用：推送配置修改");
      return ResultBuilder.success(
         this.sysPushNotificationConfigBiz.editNotification(BeanUtil.copyToList(vo, NotificationConfigDTOParam.class), notificationType, operationalModuleType)
      );
   }

   @ApiOperation("根据推送业务清空配置")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('push_message_config:del')")
   public ResultVO deleteNotificationConfig(
      @RequestParam(name = "notificationType") Integer notificationType, @RequestParam(name = "operationalModuleType") Integer operationalModuleType
   ) {
      log.info("API调用:根据推送业务清空配置");
      return ResultBuilder.success(this.sysPushNotificationConfigBiz.editNotification(new ArrayList<>(), notificationType, operationalModuleType));
   }

   @ApiOperation("推送配置状态修改")
   @PostMapping("/edit/status/{id}")
   @PreAuthorize("@permission.check('push_message_config:pushSave')")
   public ResultVO editStatus(@PathVariable Long id) {
      log.info("API调用:推送配置状态修改");
      return ResultBuilder.success(this.sysPushNotificationConfigBiz.editStatus(id));
   }

   @ApiOperation("推送配置适用对象获取(个人 部门 岗位)")
   @GetMapping("/getSuitableObject")
   @PreAuthorize("@permission.check('push_message_config:get')")
   public ResultVO getSuitableObject(@RequestParam Integer suitableObjectTypeEnum) {
      log.info("API调用:推送配置适用对象获取");
      return ResultBuilder.success(this.sysPushNotificationConfigBiz.getSuitableObject(suitableObjectTypeEnum));
   }

   public NotificationConfigController(final SysPushNotificationConfigBiz sysPushNotificationConfigBiz) {
      this.sysPushNotificationConfigBiz = sysPushNotificationConfigBiz;
   }
}
