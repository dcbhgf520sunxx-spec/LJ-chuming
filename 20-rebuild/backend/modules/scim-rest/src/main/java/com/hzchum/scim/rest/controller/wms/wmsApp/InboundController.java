package com.hzchum.scim.rest.controller.wms.wmsApp;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.APPInboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.APPInboundPassDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundQualityTestingDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-App入库质检")
@RestController
@RequestMapping("/api/app/wms/inbound")
public class InboundController {
   private static final Logger log = LoggerFactory.getLogger(InboundController.class);
   @Resource
   InboundService inboundService;

   @ApiOperation("质检审核")
   @PutMapping("/quality-testing")
   @PreAuthorize("@permission.check('materialStorageInspection')")
   public ResultVO qualityTesting(@RequestBody InboundQualityTestingDTOParam param) {
      log.info("API 调用 : 质检审核");
      return ResultBuilder.success(this.inboundService.qualityTesting(param));
   }

   @ApiOperation("质检列表查询")
   @GetMapping("/quality-testing")
   public ResultVO list(
      QueryInboundDTOParam queryInboundDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：质检列表查询");
      queryInboundDTOParam.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      return ResultBuilder.success(this.inboundService.pageInfo(queryInboundDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("质检根据入库单id获取入库单详情")
   @GetMapping("/quality-testing/{id}")
   public ResultVO qualityTesting(@PathVariable("id") Long id) {
      log.info("API 调用 ：质检根据入库单id获取入库单详情");
      return ResultBuilder.success(this.inboundService.getQualityTestingDetail(id));
   }

   @ApiOperation("根据条件分页查询入库记录")
   @GetMapping("/application/review/raw-materials")
   public ResultVO getList(
      QueryInboundDTOParam queryInboundDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询入库记录");
      return ResultBuilder.success(this.inboundService.pageInfo(queryInboundDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("app拍照入库")
   @PostMapping("/saveAPPInbound")
   public ResultVO saveAPPInbound(@Valid @RequestBody APPInboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : app拍照入库");
      return ResultBuilder.success(this.inboundService.saveAPPInbound(request));
   }

   @ApiOperation("app拍照计算面积")
   @PostMapping("/getArea")
   public ResultVO getArea(@Valid @RequestBody APPInboundDTOParam request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : app拍照计算面积");
      return ResultBuilder.success(this.inboundService.getArea(request));
   }

   @ApiOperation("根据条件分页查询入库记录")
   @GetMapping("/record/InboundList")
   public ResultVO InboundList(
      QueryInboundDTOParam queryInboundDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询入库记录");
      return ResultBuilder.success(this.inboundService.selectAPPInboundDetailDTO(queryInboundDTOParam, pageNumber, pageSize, sort));
   }

   @ApiOperation("审核通过")
   @PutMapping("/raw-materials/passed")
   public ResultVO passed(@RequestBody APPInboundPassDTOParam request) {
      log.info("API 调用 : 审核通过");
      InboundDTOParam copy = BeanUtil.copy(request, InboundDTOParam.class);
      return ResultBuilder.success(this.inboundService.passed(copy));
   }

   @ApiOperation("审核退回")
   @PutMapping("/raw-materials/returned")
   public ResultVO returned(@RequestBody APPInboundPassDTOParam request) {
      log.info("API 调用 : 审核退回");
      return ResultBuilder.success(this.inboundService.returned(request));
   }

   @ApiOperation("根据条件分页查询余料记录")
   @GetMapping("/getSurplusList")
   public ResultVO getSurplusList(
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      Boolean marking,
      String specification,
      BigDecimal thickness,
      Boolean boolPartyA,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询余料记录");
      return ResultBuilder.success(this.inboundService.getSurplusList(pageNumber, pageSize, marking, specification, thickness, boolPartyA, sort));
   }

   @ApiOperation("更新打标")
   @GetMapping("/updateMarking/{id}")
   public ResultVO updateMarking(@PathVariable Long id) {
      log.info("API 调用 : 更新打标");
      return ResultBuilder.success(this.inboundService.updateMarking(id));
   }

   @ApiOperation("获取余料规格和厚度")
   @GetMapping("/getConditions")
   public ResultVO getConditions() {
      log.info("API 调用 : 获取余料规格和厚度");
      return ResultBuilder.success(this.inboundService.getConditions());
   }

   @ApiOperation("根据作业id获取板材")
   @GetMapping("/getMaterialInventory/{jobId}")
   public ResultVO getMaterialInventory(@PathVariable Long jobId) {
      log.info("API 调用 : 根据作业id获取板材");
      return ResultBuilder.success(this.inboundService.getMaterialInventory(jobId));
   }
}
