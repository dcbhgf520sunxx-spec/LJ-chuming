package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SpecificationDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-规格配置")
@RestController
@RequestMapping("/api/config/classification/specification")
public class SpecificationController {
   private static final Logger log = LoggerFactory.getLogger(SpecificationController.class);
   @Resource
   SpecificationService specificationService;

   @ApiOperation("获取科目规格配置列表")
   @GetMapping("/{classificationId}")
   @PreAuthorize("@permission.check('config_specConfig:get')")
   public ResultVO list(@PathVariable Long classificationId) {
      log.info("API 调用 ：获取科目规格配置列表");
      return ResultBuilder.success(this.specificationService.getByClassificationId(classificationId));
   }

   @ApiOperation("新增科目规格配置")
   @PostMapping
   @PreAuthorize("@permission.check('config_specConfig:add')")
   public ResultVO save(@Validated @RequestBody SpecificationDTOParam specificationVOParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增科目规格配置");
      return ResultBuilder.success(this.specificationService.batchSave(specificationVOParam));
   }

   @ApiOperation("删除科目规格")
   @DeleteMapping
   @PreAuthorize("@permission.check('config_specConfig:del')")
   public ResultVO deleteBySubjectId(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除科目规格");
      return ResultBuilder.success(this.specificationService.deleteByIds(ids));
   }

   @ApiOperation("修改科目规格配置")
   @PutMapping
   @PreAuthorize("@permission.check('config_specConfig:edit')")
   public ResultVO update(@Valid @RequestBody SpecificationDTOParam specificationVOParam, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改科目规格配置");
      return ResultBuilder.success(this.specificationService.updateSpecification(specificationVOParam));
   }

   public SpecificationController(final SpecificationService specificationService) {
      this.specificationService = specificationService;
   }
}
