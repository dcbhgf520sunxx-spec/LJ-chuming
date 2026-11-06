package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushApproveConfigDTO;
import com.hzchum.scim.system.core.api.service.notification.SysPushApproveConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "推送管理-审批推送配置")
@RestController
@RequestMapping("/api/notification/approve/config")
public class NotificationApproveConfigController {
   private static final Logger log = LoggerFactory.getLogger(NotificationApproveConfigController.class);
   @Resource
   private SysPushApproveConfigService approveConfigService;

   @ApiOperation("审批推送配置查询")
   @GetMapping("/getPushApproveList")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "appKey", value = "appKey（企微：corpId）", paramType = "query"),
            @ApiImplicitParam(name = "appType", value = "应用类型", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态，1开启，0禁用", paramType = "query")
      }
   )
   @PreAuthorize("@permission.check('approval_push_config:get')")
   public ResultVO getWebhookList(String appKey, Integer status, Integer appType) {
      log.info("API调用:审批推送配置查询");
      return ResultBuilder.success(this.approveConfigService.getPushApproveList(appKey, status, appType));
   }

   @ApiOperation("添加审批推送配置")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('approval_push_config:add')")
   public ResultVO save(@RequestBody SysPushApproveConfigDTO sysPushApproveConfigDTO) {
      log.info("API调用:添加webhook配置");
      return ResultBuilder.success(this.approveConfigService.save(sysPushApproveConfigDTO));
   }

   @ApiOperation("修改审批推送配置")
   @PostMapping("/update")
   @PreAuthorize("@permission.check('approval_push_config:edit')")
   public ResultVO upadte(@RequestBody SysPushApproveConfigDTO sysPushApproveConfigDTO) {
      log.info("API调用:修改审批推送配置");
      return ResultBuilder.success(this.approveConfigService.update(sysPushApproveConfigDTO));
   }

   @ApiOperation("删除审批推送配置")
   @PostMapping("/delete")
   @PreAuthorize("@permission.check('approval_push_config:del')")
   public ResultVO delete(@RequestBody @NotEmpty(message = "idList不能为空") List<Long> ids) {
      log.info("API调用:删除审批推送配置");
      return ResultBuilder.success(this.approveConfigService.delete(ids));
   }

   @ApiOperation(value = "启用/禁用", notes = "启用/禁用")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "id", value = "id", paramType = "query"), @ApiImplicitParam(name = "status", value = "状态，1开启，0禁用", paramType = "query")}
   )
   @PutMapping("/status")
   @PreAuthorize("@permission.check('approval_push_config:editStatus')")
   public Result setEnabled(@RequestParam Long id, @RequestParam Integer status) {
      log.info("API 调用 ： 启用/禁用");
      return ResultGenerator.genSuccessResult(this.approveConfigService.setEnabled(id, status));
   }

   public NotificationApproveConfigController(final SysPushApproveConfigService approveConfigService) {
      this.approveConfigService = approveConfigService;
   }
}
