package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-期初入库申请")
@RestController
@RequestMapping("/api/wms/begin/inbound/application")
public class BeginInboundRecordController {
   private static final Logger log = LoggerFactory.getLogger(BeginInboundRecordController.class);
   @Autowired
   private InboundService inboundService;

   @ApiOperation("新增自购钢材入库单")
   @PostMapping("/selfBuyingSteel")
   @PreAuthorize("@permission.check('wms_steelInbound_self_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(boolMethodAndClassName = true, timeout = 300L, message = "期初入库正在保存！,请稍后刷新页面重试")
   public ResultVO addSelfBuyingSteel(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增自购钢材入库单");
      request.setBasicClass(BasicClassEnum.STEEL_PLATE.getType());
      return ResultBuilder.success(this.inboundService.saveBeginSelfBuyingInbound(request));
   }

   @ApiOperation("新增自购辅材入库单")
   @PostMapping("/selfBuying/auxiliary-material")
   @PreAuthorize("@permission.check('wms_auxMatInbound_self_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(boolMethodAndClassName = true, timeout = 300L, message = "期初入库正在保存！,请稍后刷新页面重试")
   public ResultVO addSelfBuyingAuxiliary(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增自购辅材入库单");
      request.setBasicClass(BasicClassEnum.GENERAL_MATERIAL.getType());
      return ResultBuilder.success(this.inboundService.saveBeginSelfBuyingInbound(request));
   }

   @ApiOperation("新增自购办公用品入库单")
   @PostMapping("/selfBuying/other-material")
   @PreAuthorize("@permission.check('wms_otherInbound_self_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(boolMethodAndClassName = true, timeout = 300L, message = "期初入库正在保存！,请稍后刷新页面重试")
   public ResultVO addSelfBuyingOther(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增自购办公用品入库单");
      request.setBasicClass(BasicClassEnum.OTHER.getType());
      return ResultBuilder.success(this.inboundService.saveBeginSelfBuyingInbound(request));
   }

   @ApiOperation("新增自购气体入库单")
   @PostMapping("/selfBuying/gas")
   @PreAuthorize("@permission.check('wms_gasInbound_self_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(boolMethodAndClassName = true, timeout = 300L, message = "期初入库正在保存！,请稍后刷新页面重试")
   public ResultVO addSelfBuyingGas(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增自购气体入库单");
      request.setBasicClass(BasicClassEnum.GAS.getType());
      return ResultBuilder.success(this.inboundService.saveBeginSelfBuyingInbound(request));
   }

   @ApiOperation("新增甲供钢材入库单")
   @PostMapping("/partyASteel")
   @PreAuthorize("@permission.check('wms_steelInbound_partyA_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(boolMethodAndClassName = true, timeout = 300L, message = "期初入库正在保存！,请稍后刷新页面重试")
   public ResultVO addFirstPartySteel(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增甲供钢材入库单");
      request.setBasicClass(BasicClassEnum.STEEL_PLATE.getType());
      return ResultBuilder.success(this.inboundService.saveBeginPartyAInbound(request));
   }

   @ApiOperation("新增甲供辅材入库单")
   @PostMapping("/partyA/auxiliary-material")
   @PreAuthorize("@permission.check('wms_auxMatInbound_partyA_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(boolMethodAndClassName = true, timeout = 300L, message = "期初入库正在保存！,请稍后刷新页面重试")
   public ResultVO addPartyAAuxiliary(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增甲供辅材入库单");
      request.setBasicClass(BasicClassEnum.GENERAL_MATERIAL.getType());
      return ResultBuilder.success(this.inboundService.saveBeginPartyAInbound(request));
   }

   @ApiOperation("新增甲供办公用品入库单")
   @PostMapping("/partyA/other-material")
   @PreAuthorize("@permission.check('wms_otherInbound_partyA_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(boolMethodAndClassName = true, timeout = 300L, message = "期初入库正在保存！,请稍后刷新页面重试")
   public ResultVO addPartyAOther(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增甲供办公用品入库单");
      request.setBasicClass(BasicClassEnum.OTHER.getType());
      return ResultBuilder.success(this.inboundService.saveBeginPartyAInbound(request));
   }

   @ApiOperation("新增甲供气体入库单")
   @PostMapping("/partyA/gas")
   @PreAuthorize("@permission.check('wms_gasInbound_partyA_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(boolMethodAndClassName = true, timeout = 300L, message = "期初入库正在保存！,请稍后刷新页面重试")
   public ResultVO addPartyAGas(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增甲供气体入库单");
      request.setBasicClass(BasicClassEnum.GAS.getType());
      return ResultBuilder.success(this.inboundService.saveBeginPartyAInbound(request));
   }
}
