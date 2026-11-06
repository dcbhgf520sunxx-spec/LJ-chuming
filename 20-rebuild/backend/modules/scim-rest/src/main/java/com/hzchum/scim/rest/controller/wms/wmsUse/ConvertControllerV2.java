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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-转换单")
@RestController
@RequestMapping("/api/v2/wms/convert")
public class ConvertControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(ConvertControllerV2.class);
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
      return ResultBuilder.success(this.convertService.pageInfoV2(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("导出转换单审核列表")
   @GetMapping("/exportConversionOrderAuditList")
   public void exportConversionOrderAuditList(ConvertDTOParam param, HttpServletResponse response) {
      log.info("API 调用 : 导出转换单审核列表");
      this.convertService.exportListV2(param, response);
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

   @ApiOperation("待审核转换单数量")
   @GetMapping("/reviewedNum")
   public ResultVO reviewedNum(Boolean boolPartyA) {
      log.info("API 调用 ：待审核转换单数量");
      return ResultBuilder.success(this.convertService.reviewedNumV2(boolPartyA));
   }

   @ApiOperation("根据项目查询转换单总计")
   @GetMapping("/getProjectConvert")
   public ResultVO getProjectConvert(ConvertDTOParam param) {
      log.info("API 调用 ：根据项目查询转换单总计");
      return this.convertService.getProjectConvert(param);
   }

   @ApiOperation("审核条板转换单")
   @PutMapping("/review")
   public ResultVO review(
      @RequestParam(name = "approveRecordId", required = true) Long approveRecordId,
      @RequestParam(name = "decision", required = true) Integer decision,
      @RequestParam(name = "opinion", required = false) String opinion
   ) {
      log.info("API 调用 ：审核条板转换单");
      return ResultBuilder.success(this.convertService.review(approveRecordId, decision, opinion));
   }

   @ApiOperation("撤销条板转换单")
   @PostMapping("/revocation/{id}")
   public ResultVO revocation(@PathVariable("id") Long id) {
      log.info("API 调用 ：撤销条板转换单");
      return ResultBuilder.success(this.convertService.revocation(id));
   }
}
