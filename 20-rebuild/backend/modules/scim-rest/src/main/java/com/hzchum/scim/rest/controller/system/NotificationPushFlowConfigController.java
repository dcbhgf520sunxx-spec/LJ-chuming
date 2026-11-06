package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushFlowConfigDetailSaveDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "推送管理-项目流程")
@RestController
@RequestMapping("/api/push/flow/config")
public class NotificationPushFlowConfigController {
   private static final Logger log = LoggerFactory.getLogger(NotificationPushFlowConfigController.class);
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;

   @ApiOperation("流程列表")
   @GetMapping("")
   public ResultVO getPushFlowSimpleList(Boolean status, Integer notificationTypeEnum, String name) {
      log.info("API调用:获取项目简单流程");
      return ResultBuilder.success(this.sysPushFlowConfigBiz.getPushFlowSimpleList(status, notificationTypeEnum, name));
   }

   @ApiOperation("流程树结构详情")
   @GetMapping("/detail")
   public ResultVO getPushFlowDetail(Long id) {
      log.info("API调用:流程树结构详情");
      return ResultBuilder.success(this.sysPushFlowConfigBiz.getPushFlowDetail(id));
   }

   @ApiOperation("修改推送流")
   @PostMapping("/editFlow")
   public ResultVO editFlow(@RequestBody SysPushFlowConfigDetailSaveDTOParam sysPushFlowConfigDetailSaveDTOParam) {
      log.info("API调用:修改推送流");
      return ResultBuilder.success(this.sysPushFlowConfigBiz.editFlow(sysPushFlowConfigDetailSaveDTOParam));
   }

   @ApiOperation("删除推送流")
   @DeleteMapping("")
   public ResultVO deleteFlow(@RequestParam Long id) {
      log.info("API调用：删除推送流");
      return ResultBuilder.success(this.sysPushFlowConfigBiz.deleteFlow(id));
   }

   @ApiOperation("流程状态修改")
   @PostMapping("/editStatus")
   public ResultVO editStatus(Long id) {
      log.info("API调用:流程状态修改");
      return ResultBuilder.success(this.sysPushFlowConfigBiz.editStatus(id));
   }

   public NotificationPushFlowConfigController(final SysPushFlowConfigBiz sysPushFlowConfigBiz) {
      this.sysPushFlowConfigBiz = sysPushFlowConfigBiz;
   }
}
