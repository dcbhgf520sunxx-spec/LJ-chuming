package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.dto.SysDrawingRecognitionRulesDTO;
import com.hzchum.scim.system.core.api.service.SysDrawingRecognitionRulesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目配置-图纸识别规则")
@RestController
@RequestMapping("/api/drawing/rules")
public class DrawingRecognitionRulesApi {
   private static final Logger log = LoggerFactory.getLogger(DrawingRecognitionRulesApi.class);
   private final SysDrawingRecognitionRulesService sysDrawingRecognitionRulesService;

   @ApiOperation(value = "保存图纸识别规则", notes = "保存图纸识别规则")
   @PostMapping("")
   @PreAuthorize("@permission.check('drawing_sn_config:edit')")
   public Result saveDrawingRules(@Validated(Add.class) @RequestBody SysDrawingRecognitionRulesDTO rulesDTO) {
      log.info("API 调用 ：保存图纸识别规则");
      return ResultGenerator.genSuccessResult(this.sysDrawingRecognitionRulesService.saveDrawingRules(rulesDTO));
   }

   @ApiOperation(value = "查询图纸识别规则", notes = "查询图纸识别规则")
   @GetMapping("")
   @PreAuthorize("@permission.check('drawing_sn_config:get')")
   public Result getDrawingRules() {
      log.info("API 调用 ：查询图纸识别规则");
      return ResultGenerator.genSuccessResult(this.sysDrawingRecognitionRulesService.getDrawingRules());
   }

   public DrawingRecognitionRulesApi(final SysDrawingRecognitionRulesService sysDrawingRecognitionRulesService) {
      this.sysDrawingRecognitionRulesService = sysDrawingRecognitionRulesService;
   }
}
