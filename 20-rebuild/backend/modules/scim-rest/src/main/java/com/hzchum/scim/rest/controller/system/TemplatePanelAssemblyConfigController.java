package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.TemplatePanelAssemblyConfigBiz;
import com.hzchum.scim.system.core.api.pojo.vo.TemplatePanelAssemblyConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES配置-板拼部件模板配置")
@RestController
@RequestMapping("/api/template/assembly/config")
public class TemplatePanelAssemblyConfigController {
   private static final Logger log = LoggerFactory.getLogger(TemplatePanelAssemblyConfigController.class);
   @Resource
   private TemplatePanelAssemblyConfigBiz panelAssemblyConfigBiz;

   @ApiOperation("获取板拼部件模板配置列表")
   @GetMapping("list")
   @PreAuthorize("@permission.check('assembly-template-config:get')")
   public ResultVO listAssemblyTemplateConfigs() {
      log.info("API 调用 ：获取板拼部件模板配置列表");
      return ResultBuilder.success(this.panelAssemblyConfigBiz.listAssemblyTemplateConfigs());
   }

   @ApiOperation("修改板拼部件模板配置列表")
   @PutMapping("update")
   @PreAuthorize("@permission.check('assembly-template-config:edit')")
   public ResultVO updateAssemblyTemplateConfigs(@RequestBody List<TemplatePanelAssemblyConfigVO> panelAssemblyConfigVOS) {
      log.info("API 调用 ：修改板拼部件模板配置列表");
      return ResultBuilder.success(this.panelAssemblyConfigBiz.updateAssemblyTemplateConfigs(panelAssemblyConfigVOS));
   }

   public TemplatePanelAssemblyConfigController(final TemplatePanelAssemblyConfigBiz panelAssemblyConfigBiz) {
      this.panelAssemblyConfigBiz = panelAssemblyConfigBiz;
   }
}
