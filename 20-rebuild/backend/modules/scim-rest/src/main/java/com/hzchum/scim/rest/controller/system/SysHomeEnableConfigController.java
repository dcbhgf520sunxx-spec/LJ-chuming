package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.rest.pojo.vo.system.SysHomeEnableConfigUpdateVO;
import com.hzchum.scim.system.core.api.pojo._doModel.system.SysHomeEnableConfig;
import com.hzchum.scim.system.core.api.service.SysHomeEnableConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-首页开启配置")
@RestController
@RequestMapping("/api/home/config")
public class SysHomeEnableConfigController {
   private static final Logger log = LoggerFactory.getLogger(SysHomeEnableConfigController.class);
   @Resource
   private SysHomeEnableConfigService sysHomeEnableConfigService;

   @ApiOperation("首页是否开启查看")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('config_home:get')")
   public ResultVO detail() {
      SysHomeEnableConfig sysHomeEnableConfig = this.sysHomeEnableConfigService.getById(1L);
      return ResultBuilder.success(sysHomeEnableConfig);
   }

   @ApiOperation("首页是否开启修改")
   @PostMapping("/update")
   @PreAuthorize("@permission.check('config_home:edit')")
   public ResultVO update(@RequestBody SysHomeEnableConfigUpdateVO vo) {
      SysHomeEnableConfig sysHomeEnableConfig = this.sysHomeEnableConfigService.getById(1L);
      sysHomeEnableConfig.setIsEnable(vo.getIsEnable());
      this.sysHomeEnableConfigService.updateById(sysHomeEnableConfig);
      return ResultBuilder.success(Boolean.TRUE);
   }
}
