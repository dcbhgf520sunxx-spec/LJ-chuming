package com.hzchum.scim.rest.controller.bim;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.bim.core.api.pojo.dto.BimModelConfigurationDTO;
import com.hzchum.scim.bim.core.api.service.BimModelConfigurationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@Api(tags = "bim-导入模式配置")
@RestController
@RequestMapping("/api/model/configure")
public class BimModelConfigurationApi {
   private static final Logger log = LoggerFactory.getLogger(BimModelConfigurationApi.class);
   @Resource
   private BimModelConfigurationService bimModelConfigurationService;

   @ApiOperation("查看单体的模型配置")
   @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query")
   @GetMapping("")
   public ResultVO getModelConfigure(@RequestParam Long monomerId) {
      log.info("API 调用 ： 查看单体的模型配置");
      return ResultBuilder.success(this.bimModelConfigurationService.getModelConfigure(monomerId));
   }

   @ApiOperation("修改单体的模型配置")
   @PutMapping("")
   @PreAuthorize("@permission.check('plan_model_file:import')")
   public ResultVO setModelConfigure(@Valid @RequestBody BimModelConfigurationDTO configurationDTO) {
      log.info("API 调用 ： 修改单体的模型配置");
      return ResultBuilder.success(this.bimModelConfigurationService.setModelConfigure(configurationDTO));
   }
}
