package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.system.core.api.pojo.dto.NumberConfigDTOParam;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "编号生成配置")
@RestController
@RequestMapping("/api/config/project-config/number")
public class NumberConfigController {
   private static final Logger log = LoggerFactory.getLogger(NumberConfigController.class);
   @Resource
   NumberConfigService numberConfigService;

   @ApiOperation("获取文件编号配置")
   @GetMapping
   @PreAuthorize("@permission.check('config_numberConfig:get')")
   public ResultVO list() {
      log.info("API 调用 ：获取文件编号配置");
      return ResultBuilder.success(this.numberConfigService.listConfig());
   }

   @ApiOperation("修改文件编号配置")
   @PostMapping
   @PreAuthorize("@permission.check('config_numberConfig:edit')")
   public ResultVO add(@Valid @RequestBody ValidList<NumberConfigDTOParam> request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改文件编号配置");
      return ResultBuilder.success(this.numberConfigService.updateConfig(request));
   }
}
