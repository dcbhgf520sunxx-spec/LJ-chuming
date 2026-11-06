package com.hzchum.scim.rest.controller.system;

import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.request.MesAuxiliaryDTOParam;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "配套件-配套件Controller")
@RequestMapping("/api/system/auxiliary")
@RestController
public class MesAuxiliaryController {
   private static final Logger log = LoggerFactory.getLogger(MesAuxiliaryController.class);
   @Autowired
   private MesAuxiliaryService mesAuxiliaryService;

   @ApiOperation("获取配套件物料科目对照信息")
   @GetMapping("/mes/selectList")
   @PreAuthorize("@permission.check('accessories_subject_comparison:get')")
   public Result getList(
      @RequestParam(required = false) Integer basicClass,
      @RequestParam(required = false) String auxiliaryName,
      @RequestParam(required = false) String className
   ) {
      log.info("API 调用 ：获取配套件物料科目对照信息");
      return ResultGenerator.genSuccessResult(this.mesAuxiliaryService.selectList(basicClass, auxiliaryName, className));
   }

   @ApiOperation("根据ID查看关联信息")
   @GetMapping("/mes/selectById")
   public Result selectById(@RequestParam("id") Long id) {
      log.info("API 调用 ：获取配套件物料科目对照信息");
      return ResultGenerator.genSuccessResult(this.mesAuxiliaryService.selectById(id));
   }

   @ApiOperation("新增配套件物料科目对照信息")
   @PostMapping("/mes/save")
   @PreAuthorize("@permission.check('accessories_subject_comparison:add')")
   public Result save(@RequestBody @Validated List<MesAuxiliaryDTOParam> dtoParams) {
      log.info("API 调用 ：新增配套件物料科目对照信息");
      return ResultGenerator.genSuccessResult(this.mesAuxiliaryService.save(dtoParams));
   }

   @ApiOperation("修改配套件物料科目对照信息")
   @PutMapping("/mes/update")
   @PreAuthorize("@permission.check('accessories_subject_comparison:edit')")
   public Result update(@RequestBody @Validated MesAuxiliaryDTOParam dtoParam) {
      log.info("API 调用 ：新增配套件物料科目对照信息");
      return ResultGenerator.genSuccessResult(this.mesAuxiliaryService.update(dtoParam));
   }

   @ApiOperation("删除配套件物料科目对照信息")
   @DeleteMapping("/mes/del")
   @PreAuthorize("@permission.check('accessories_subject_comparison:del')")
   public Result deleted(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除配套件物料科目对照信息");
      return ResultGenerator.genSuccessResult(this.mesAuxiliaryService.deleted(ids));
   }

   @ApiOperation("获取科目信息(末级)")
   @GetMapping("/mes/getClassification")
   public Result getClassification(@RequestParam Integer basicClass, @RequestParam String accountingUnit) {
      log.info("API 调用 ：获取科目信息(末级)");
      return ResultGenerator.genSuccessResult(this.mesAuxiliaryService.getClassification(basicClass, accountingUnit));
   }
}
