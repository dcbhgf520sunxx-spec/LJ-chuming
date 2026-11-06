package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushWebhookConfigDTO;
import com.hzchum.scim.system.core.api.service.notification.SysPushWebhookConfigService;
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

@Api(tags = "推送管理-WebhookURL配置")
@RestController
@RequestMapping("/api/notification/webhook/config")
public class NotificationWebhookConfigController {
   private static final Logger log = LoggerFactory.getLogger(NotificationWebhookConfigController.class);
   @Resource
   private SysPushWebhookConfigService webhookConfigService;

   @ApiOperation("推送配置webhook查询")
   @GetMapping("/getWebhookList")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "url", value = "路径", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态，1开启，0禁用", paramType = "query"),
            @ApiImplicitParam(name = "notificationType", value = "通知业务", paramType = "query")
      }
   )
   @PreAuthorize("@permission.check('web_hook_url_config:get')")
   public ResultVO getWebhookList(String url, String name, Integer status, Integer notificationType) {
      log.info("API调用:推送配置webhook查询");
      return ResultBuilder.success(this.webhookConfigService.getWebhookList(url, name, status, notificationType));
   }

   @ApiOperation("添加webhook配置")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('web_hook_url_config:add')")
   public ResultVO save(@RequestBody List<SysPushWebhookConfigDTO> sysPushWebhookConfigDTO) {
      log.info("API调用:添加webhook配置");
      return ResultBuilder.success(this.webhookConfigService.save(sysPushWebhookConfigDTO));
   }

   @ApiOperation("修改webhook配置")
   @PostMapping("/update")
   @PreAuthorize("@permission.check('web_hook_url_config:edit')")
   public ResultVO upadte(@RequestBody SysPushWebhookConfigDTO sysPushWebhookConfigDTO) {
      log.info("API调用:修改webhook配置");
      return ResultBuilder.success(this.webhookConfigService.update(sysPushWebhookConfigDTO));
   }

   @ApiOperation("删除webhook配置")
   @PostMapping("/delete")
   @PreAuthorize("@permission.check('web_hook_url_config:del')")
   public ResultVO delete(@RequestBody @NotEmpty(message = "idList不能为空") List<Long> ids) {
      log.info("API调用:修改webhook配置");
      return ResultBuilder.success(this.webhookConfigService.delete(ids));
   }

   @ApiOperation(value = "启用/禁用", notes = "启用/禁用 EnableEnum")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "id", value = "id", paramType = "query"), @ApiImplicitParam(name = "status", value = "状态，1开启，0禁用", paramType = "query")}
   )
   @PutMapping("/status")
   @PreAuthorize("@permission.check('web_hook_url_config:editStatus')")
   public Result setEnabled(@RequestParam Long id, @RequestParam Integer status) {
      log.info("API 调用 ： 启用/禁用");
      return ResultGenerator.genSuccessResult(this.webhookConfigService.setEnabled(id, status));
   }

   public NotificationWebhookConfigController(final SysPushWebhookConfigService webhookConfigService) {
      this.webhookConfigService = webhookConfigService;
   }
}
