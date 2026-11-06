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
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-入库申请V2")
@RestController
@RequestMapping("/api/v2/wms/inbound/application")
public class InboundRecordControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(InboundRecordControllerV2.class);
   @Resource
   InboundService inboundService;

   @ApiOperation("根据入库单ID查询入库详情V2")
   @GetMapping("/record/raw-materials/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_inbound_self_record:detail','wms_rawMat_inbound_review:detail')")
   public ResultVO listDetail(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据入库单ID查询入库详情V2");
      return ResultBuilder.success(this.inboundService.getListV2(id, false));
   }

   @ApiOperation("新增自购钢材入库单")
   @PostMapping("/selfBuyingSteel")
   @PreAuthorize("@permission.check('wms_steelInbound_self_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(lockKey = "#request.loginUserId", message = "该人员正在创建入库单，请稍后再试")
   public ResultVO addSelfBuyingSteel(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增自购钢材入库单");
      request.setBasicClass(BasicClassEnum.STEEL_PLATE.getType());
      return ResultBuilder.success(this.inboundService.saveSelfBuyingInboundV2(request));
   }

   @ApiOperation("新增甲供钢材入库单")
   @PostMapping("/partyASteel")
   @PreAuthorize("@permission.check('wms_steelInbound_partyA_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(lockKey = "#request.loginUserId", message = "该人员正在创建入库单，请稍后再试")
   public ResultVO addFirstPartySteel(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增甲供钢材入库单");
      request.setBasicClass(BasicClassEnum.STEEL_PLATE.getType());
      return ResultBuilder.success(this.inboundService.savePartyAInboundV2(request));
   }

   @ApiOperation("新增自购辅材入库单")
   @PostMapping("/selfBuying/auxiliary-material")
   @PreAuthorize("@permission.check('wms_auxMatInbound_self_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(lockKey = "#request.loginUserId", message = "该人员正在创建入库单，请稍后再试")
   public ResultVO addSelfBuyingAuxiliary(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增自购辅材入库单");
      request.setBasicClass(BasicClassEnum.GENERAL_MATERIAL.getType());
      return ResultBuilder.success(this.inboundService.saveSelfBuyingInboundV2(request));
   }

   @ApiOperation("新增甲供辅材入库单")
   @PostMapping("/partyA/auxiliary-material")
   @PreAuthorize("@permission.check('wms_auxMatInbound_partyA_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(lockKey = "#request.loginUserId", message = "该人员正在创建入库单，请稍后再试")
   public ResultVO addPartyAAuxiliary(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增甲供辅材入库单");
      request.setBasicClass(BasicClassEnum.GENERAL_MATERIAL.getType());
      return ResultBuilder.success(this.inboundService.savePartyAInboundV2(request));
   }

   @ApiOperation("新增自购办公用品入库单")
   @PostMapping("/selfBuying/other-material")
   @PreAuthorize("@permission.check('wms_otherInbound_self_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(lockKey = "#request.loginUserId", message = "该人员正在创建入库单，请稍后再试")
   public ResultVO addSelfBuyingOther(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增自购办公用品入库单");
      request.setBasicClass(BasicClassEnum.OTHER.getType());
      return ResultBuilder.success(this.inboundService.saveSelfBuyingInboundV2(request));
   }

   @ApiOperation("新增甲供办公用品入库单")
   @PostMapping("/partyA/other-material")
   @PreAuthorize("@permission.check('wms_otherInbound_partyA_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(lockKey = "#request.loginUserId", message = "该人员正在创建入库单，请稍后再试")
   public ResultVO addPartyAOther(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增甲供办公用品入库单");
      request.setBasicClass(BasicClassEnum.OTHER.getType());
      return ResultBuilder.success(this.inboundService.savePartyAInboundV2(request));
   }

   @ApiOperation("新增自购气体入库单")
   @PostMapping("/selfBuying/gas")
   @PreAuthorize("@permission.check('wms_gasInbound_self_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(lockKey = "#request.loginUserId", message = "该人员正在创建入库单，请稍后再试")
   public ResultVO addSelfBuyingGas(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增自购气体入库单");
      request.setBasicClass(BasicClassEnum.GAS.getType());
      return ResultBuilder.success(this.inboundService.saveSelfBuyingInboundV2(request));
   }

   @ApiOperation("新增甲供气体入库单")
   @PostMapping("/partyA/gas")
   @PreAuthorize("@permission.check('wms_gasInbound_partyA_application:submit','config_wms_auditing:rewrite')")
   @SignerCheck(lockKey = "#request.loginUserId", message = "该人员正在创建入库单，请稍后再试")
   public ResultVO addPartyAGas(@Valid @RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增甲供气体入库单");
      request.setBasicClass(BasicClassEnum.GAS.getType());
      return ResultBuilder.success(this.inboundService.savePartyAInboundV2(request));
   }

   @ApiOperation("驳回后或撤销或直接编辑入库单 -> 直接编辑先撤销在发起申请")
   @PutMapping("/record/raw-materials")
   public ResultVO update(@RequestBody InboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 驳回后或撤销或直接编辑入库单 -> 直接编辑先撤销在发起申请");
      return ResultBuilder.success(this.inboundService.returnUpdateInbound(request));
   }

   @ApiOperation("重写时查看入库详情")
   @GetMapping("/record/raw-materials/rewrite/{id}")
   public ResultVO getInboundDTOByRecordId(@PathVariable("id") Long id) {
      log.info("API 调用 ：重写时查看入库详情");
      return ResultBuilder.success(this.inboundService.getInboundDTOByRecordId(id));
   }
}
