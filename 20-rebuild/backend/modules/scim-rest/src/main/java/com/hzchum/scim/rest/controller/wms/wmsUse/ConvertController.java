package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ConvertDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SteelPlateOutboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ConvertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-转换单")
@RestController
@RequestMapping("/api/wms/convert")
public class ConvertController {
   private static final Logger log = LoggerFactory.getLogger(ConvertController.class);
   @Resource
   ConvertService convertService;

   @ApiOperation("根据条件分页查询转换单")
   @GetMapping("/convert")
   @PreAuthorize("@permission.check('wms_rawMat_convertList:get') || @permission.check('wms_rawMat_convertList_self:get') || @permission.check('wms_rawMat_convertList_partyA:get')")
   public ResultVO list(
      ConvertDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询转换单");
      return ResultBuilder.success(this.convertService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("导出转换单审核列表")
   @GetMapping("/exportConversionOrderAuditList")
   @PreAuthorize("@permission.check('wms_rawMat_convertList:get') || @permission.check('wms_rawMat_convertList_self:get') || @permission.check('wms_rawMat_convertList_partyA:get')")
   public void exportConversionOrderAuditList(ConvertDTOParam param, HttpServletResponse response) {
      log.info("API 调用 : 导出转换单审核列表");
      this.convertService.exportList(param, response);
   }

   @ApiOperation("根据id查询转换单详情")
   @GetMapping("/convertDetail/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_convertList:detail') || @permission.check('wms_report_convertList:get')")
   public ResultVO convertDetail(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据id查询转换单详情");
      return this.convertService.convertDetail(id);
   }

   @ApiOperation("卷板转换单保存")
   @PutMapping("/saveConvert")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:convert') || @permission.check('wms_matWarehouse_steel_self:convert') || @permission.check('wms_matWarehouse_steel_partyA:convert')")
   public ResultVO saveConvert(@Valid @RequestBody SteelPlateOutboundDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：卷板转换单保存");
      return ResultBuilder.success(this.convertService.saveConvert(param));
   }

   @ApiOperation("审核通过转换单")
   @GetMapping("/passed/{id}")
   public ResultVO passed(@PathVariable("id") Long id) {
      log.info("API 调用 ：审核通过转换单");
      return ResultBuilder.success(this.convertService.passed(id));
   }

   @ApiOperation("转换单审核拒绝")
   @GetMapping("/convertReturn/{id}")
   public ResultVO convertReturn(@PathVariable("id") Long id) {
      log.info("API 调用 ：转换单审核拒绝");
      return ResultBuilder.success(this.convertService.convertReturn(id));
   }

   @ApiOperation("待审核转换单数量")
   @GetMapping("/reviewedNum")
   public ResultVO reviewedNum() {
      log.info("API 调用 ：待审核转换单数量");
      return ResultBuilder.success(this.convertService.reviewedNum());
   }

   @ApiOperation("根据项目查询转换单总计")
   @GetMapping("/getProjectConvert")
   @PreAuthorize("@permission.check('wms_report_convertList:get')")
   public ResultVO getProjectConvert(ConvertDTOParam param) {
      log.info("API 调用 ：根据项目查询转换单总计");
      return this.convertService.getProjectConvert(param);
   }

   @ApiOperation("下载转换单详情")
   @GetMapping("/convertDetailExport")
   public void convertDetailExport(Long id, HttpServletResponse response) {
      log.info("API 调用 ： 下载转换单详情");
      this.convertService.convertDetailExport(id, response, 1);
   }

   @ApiOperation("报表-下载转换单详情")
   @GetMapping("/reportConvertDetailExport")
   public void reportConvertDetailExport(Long id, HttpServletResponse response) {
      log.info("API 调用 ： 报表-下载转换单详情");
      this.convertService.convertDetailExport(id, response, 2);
   }
}
