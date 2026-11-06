package com.hzchum.scim.rest.controller.scm;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.rest.pojo.vo.scm.supplier.BatchSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.scm.supplier.SupplierVORequest;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.BatchSaveSupplierDTOParam;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "scm-供应商管理")
@RestController
@RequestMapping("/api/scm/supplier")
public class SupplierController {
   private static final Logger log = LoggerFactory.getLogger(SupplierController.class);
   @Resource
   private SupplierService supplierService;

   @ApiOperation("分页获取供应商列表")
   @GetMapping
   @PreAuthorize("@permission.check('scm_supplier:get')")
   public ResultVO list(
      @RequestParam(name = "boolHide", required = false) Boolean boolHide,
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：分页获取供应商列表");
      return ResultBuilder.success(this.supplierService.pageInfo(pageNumber, pageSize, sort, boolHide, name));
   }

   @ApiOperation("根据ID获取供应商详情")
   @GetMapping("/{id}")
   public ResultVO list(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID获取供应商详情");
      return ResultBuilder.success(this.supplierService.listById(id));
   }

   @ApiOperation("获取简单供应商列表")
   @GetMapping("/all/brief")
   public ResultVO list() {
      log.info("API 调用 ：获取简单供应商列表");
      return ResultBuilder.success(this.supplierService.getAllBrief());
   }

   @ApiOperation("根据供应商类型获取列表")
   @GetMapping("/all/{basicClass}")
   public ResultVO list(@PathVariable("basicClass") Integer basicClass) {
      log.info("API 调用 ：根据供应商类型获取列表");
      return ResultBuilder.success(this.supplierService.getByType(basicClass));
   }

   @ApiOperation("APP-根据供应商类型获取列表")
   @GetMapping("/app/all/{basicClass}")
   @PreAuthorize("@permission.check('logisticsManager','bridgeLogisticsManager')")
   public ResultVO appList(@PathVariable("basicClass") Integer basicClass) {
      log.info("API 调用 ：APP-根据供应商类型获取列表");
      return ResultBuilder.success(this.supplierService.getByType(basicClass));
   }

   @ApiOperation("新增供应商")
   @PostMapping
   @PreAuthorize("@permission.check('scm_supplier:add')")
   public ResultVO save(@Validated @RequestBody SupplierVORequest supplierVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：新增供应商");
      return ResultBuilder.success(this.supplierService.saveSupplier(supplierVORequest));
   }

   @ApiOperation("批量新增供应商")
   @PostMapping("/batch")
   @PreAuthorize("@permission.check('scm_supplier:add')")
   public ResultVO batchSave(@Validated @RequestBody ValidList<BatchSaveVORequest> batchSaveVORequests, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：批量新增供应商");
      List<BatchSaveSupplierDTOParam> dtoParams = batchSaveVORequests.stream()
         .map(batchSaveVORequest -> BeanUtil.copy(batchSaveVORequest, BatchSaveSupplierDTOParam.class))
         .collect(Collectors.toList());
      return ResultBuilder.success(this.supplierService.batchSaveSupplier(dtoParams));
   }

   @ApiOperation("修改供应商信息")
   @PutMapping
   @PreAuthorize("@permission.check('scm_supplier:edit')")
   public ResultVO update(@Valid @RequestBody SupplierVORequest supplierVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改供应商信息");
      return ResultBuilder.success(this.supplierService.updateSupplier(supplierVORequest));
   }

   @ApiOperation("修改供应商隐藏状态")
   @PutMapping("/enabled")
   @PreAuthorize("@permission.check('scm_supplier:editStatus')")
   public ResultVO update(@RequestParam(name = "id") Long id, @RequestParam(name = "boolHide") Boolean boolHide) {
      log.info("API 调用 ：修改供应商隐藏状态");
      return ResultBuilder.success(this.supplierService.updateSupplier(id, boolHide));
   }

   @ApiOperation("删除供应商")
   @DeleteMapping
   @PreAuthorize("@permission.check('scm_supplier:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除供应商");
      return ResultBuilder.success(this.supplierService.delete(ids));
   }

   @ApiOperation("获取状态未结算且有效期有效 有年度合同的供应商")
   @GetMapping("/allBoolAnnual")
   public ResultVO annualList(Integer boolAnnual) {
      log.info("API 调用 ：获取状态未结算且有效期有效 有年度合同的供应商");
      return ResultBuilder.success(this.supplierService.getBoolAnnual(boolAnnual));
   }

   @ApiOperation("下载 供应商清单 导入模版")
   @GetMapping("/template/export")
   public void exportSupplierTemplate(HttpServletResponse response) {
      log.info("API 调用 ： 下载 供应商清单 导入模版");
      this.supplierService.exportSupplierTemplate(response);
   }

   @ApiOperation("导入 供应商清单")
   @PostMapping("/supplier/import")
   @PreAuthorize("@permission.check('scm_supplier:import')")
   @SignerCheck(boolMethodAndClassName = true, message = "正在推送中，请稍后刷新重试", timeout = 60L)
   public void importSupplier(@RequestPart MultipartFile file, HttpServletResponse response) {
      log.info("Api调用: 导入 供应商清单");
      this.supplierService.importSupplier(file, response);
   }

   @ApiOperation("供应商信息下载")
   @GetMapping("/supplierExcel")
   @PreAuthorize("@permission.check('scm_supplier:get')")
   public void PurchaseExcel(
      @RequestParam(name = "boolHide", required = false) Boolean boolHide,
      @RequestParam(name = "name", required = false) String name,
      HttpServletResponse response
   ) {
      log.info("API 调用 ：供应商信息下载");
      this.supplierService.supplierExcel(boolHide, name, response);
   }
}
