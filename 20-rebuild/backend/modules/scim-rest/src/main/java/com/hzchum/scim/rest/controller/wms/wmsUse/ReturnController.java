package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Return;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.MaterialReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialReturnableDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.UpdateReturnDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-退库")
@RestController
@RequestMapping("/api/wms/return")
public class ReturnController {
   private static final Logger log = LoggerFactory.getLogger(ReturnController.class);
   @Resource
   ReturnService returnService;

   @ApiOperation("查询可退库列表")
   @GetMapping("/returnable/{BasicClass}")
   public ResultVO list(
      QueryMaterialReturnableDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询可退库列表");
      return ResultBuilder.success(this.returnService.getReturnable(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询退库单列表")
   @GetMapping("/application/record/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_return_record:get')")
   public ResultVO returnList(
      QueryReturnDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询退库单列表");
      return ResultBuilder.success(this.returnService.getReturn(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据ID查询退库单信息")
   @GetMapping("/application/record/raw-materials/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_return_record:get')")
   public ResultVO getReturnById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID查询退库单信息");
      return ResultBuilder.success(this.returnService.getReturnDetailById(id));
   }

   @ApiOperation("根据ID查询退库单信息")
   @GetMapping("/application/review/raw-materials/{id}")
   @PreAuthorize("@permission.check('wms_rawMat_return_review:get','wms_rawMat_return_review:detail')")
   public ResultVO getReturn(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID查询退库单信息");
      return ResultBuilder.success(this.returnService.getReturnDetailById(id));
   }

   @ApiOperation("获取未审核退库单ID集")
   @GetMapping("/application/review/raw-materials/pending/ids")
   @PreAuthorize("@permission.check('wms_rawMat_return_review:get')")
   public ResultVO getIds(QueryReturnDTOParam param) {
      log.info("API 调用 ：获取未审核退库单ID集");
      return ResultBuilder.success(this.returnService.getIds(param));
   }

   @ApiOperation("用户确认退库")
   @PutMapping("/application/review/raw-materials/passed")
   @PreAuthorize("@permission.check('wms_rawMat_return_review:review')")
   public ResultVO passed(@Valid @RequestBody ReturnDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：用户确认退库");
      Return returnDO = this.returnService.getById(param.getId());
      if (returnDO == null || !ReviewStatusEnum.UN_REVIEWED.getType().equals(returnDO.getReviewStatus())) {
         throw new BusinessException("当前退库单请通过分配的审批流程办理");
      }
      return ResultBuilder.success(this.returnService.passed(param));
   }

   @ApiOperation("退库单审核退回")
   @PutMapping("/application/review/raw-materials/returned")
   @PreAuthorize("@permission.check('wms_rawMat_return_review:review')")
   public ResultVO returned(@Valid @RequestBody ReturnDTOParam param, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：退库单审核退回");
      Return returnDO = this.returnService.getById(param.getId());
      if (returnDO == null || !ReviewStatusEnum.UN_REVIEWED.getType().equals(returnDO.getReviewStatus())) {
         throw new BusinessException("当前退库单请通过分配的审批流程办理");
      }
      return ResultBuilder.success(this.returnService.returned(param));
   }

   @ApiOperation("新增钢材退库单")
   @PostMapping("/application/steel-plate")
   @PreAuthorize("@permission.check('wms_steelPlate_return_application:submit')")
   public ResultVO steelPlate(@RequestBody ValidList<MaterialReturnDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增钢材退库单");
      return ResultBuilder.success(this.returnService.saveReturn(params));
   }

   @ApiOperation("新增型材退库单")
   @PostMapping("/application/section-steel")
   @PreAuthorize("@permission.check('wms_sectionSteel_return_application:submit')")
   public ResultVO sectionSteel(@Valid @RequestBody ValidList<MaterialReturnDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 新增型材退库单");
      return ResultBuilder.success(this.returnService.saveReturn(params));
   }

   @ApiOperation("新增钢卷退库单")
   @PostMapping("/application/steel-coil")
   @PreAuthorize("@permission.check('wms_steelCoil_return_application:submit')")
   public ResultVO steelCoil(@Valid @RequestBody ValidList<MaterialReturnDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增钢卷退库单");
      return ResultBuilder.success(this.returnService.saveReturn(params));
   }

   @ApiOperation("新增辅材退库单")
   @PostMapping("/application/auxiliary-material")
   @PreAuthorize("@permission.check('wms_auxMat_return_application:submit')")
   public ResultVO auxiliaryMaterial(@Valid @RequestBody ValidList<MaterialReturnDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增辅材退库单");
      return ResultBuilder.success(this.returnService.saveReturn(params));
   }

   @ApiOperation("新增其它退库单")
   @PostMapping("/application/other-material")
   @PreAuthorize("@permission.check('wms_other_return_application:submit')")
   public ResultVO otherMaterial(@Valid @RequestBody ValidList<MaterialReturnDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增其它退库单");
      return ResultBuilder.success(this.returnService.saveReturn(params));
   }

   @ApiOperation("新增气体退库单")
   @PostMapping("/application/gas")
   @PreAuthorize("@permission.check('wms_gas_return_application:submit')")
   public ResultVO ges(@Valid @RequestBody ValidList<MaterialReturnDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增气体退库单");
      return ResultBuilder.success(this.returnService.saveReturn(params));
   }

   @ApiOperation("修改退库单")
   @PutMapping("/application/record/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_return_record:edit')")
   public ResultVO update(@Valid @RequestBody UpdateReturnDTOParam params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 : 修改退库单");
      return ResultBuilder.success(this.returnService.updateReturn(params));
   }

   @ApiOperation("删除退库单")
   @DeleteMapping("/application/record/raw-materials")
   @PreAuthorize("@permission.check('wms_rawMat_return_record:del')")
   public ResultVO del(@RequestBody List<Long> ids) {
      log.info("API 调用 : 删除退库单");
      return ResultBuilder.success(this.returnService.detailByIds(ids));
   }
}
