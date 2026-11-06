package com.hzchum.scim.rest.controller.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysSupplierPaymentAttributeBiz;
import com.hzchum.scim.system.core.api.pojo.dto.SysSupplierPaymentAttributeDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysSupplierPaymentAttributeParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Api(tags = "系统管理-付款属性配置")
@Validated
@RestController
@RequestMapping("/api/system/payment/attribute")
public class SysPaymentAttributeController {
   private static final Logger log = LoggerFactory.getLogger(SysPaymentAttributeController.class);
   private final SysSupplierPaymentAttributeBiz supplierPaymentAttributeBiz;

   @ApiOperation("列表-(公共接口)")
   @GetMapping("/listAll")
   public ResultVO<ListVO<SysSupplierPaymentAttributeDTO>> listAll(String name) {
      log.info("Api调用:付款属性列表(公共接口)");
      return ResultBuilder.success(new ListVO<>(this.supplierPaymentAttributeBiz.listByCondition(name, true)));
   }

   @ApiOperation("列表-分页")
   @GetMapping("/pageList")
   @PreAuthorize("@permission.check('subcontract_payment_attribute:get')")
   public ResultVO<PageVO<SysSupplierPaymentAttributeDTO>> pageList(
      String name, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:付款属性列表分页");
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<SysSupplierPaymentAttributeDTO> list = this.supplierPaymentAttributeBiz.listByCondition(name, null);
      return ResultBuilder.success(new PageVO<>(page, list));
   }

   @ApiOperation("新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('subcontract_payment_attribute:add')")
   public ResultVO<Boolean> save(@RequestBody @Valid SysSupplierPaymentAttributeParam param) {
      log.info("Api调用:付款属性新增");
      return ResultBuilder.success(this.supplierPaymentAttributeBiz.savePaymentAttribute(Collections.singletonList(param)));
   }

   @ApiOperation("新增-批量")
   @PostMapping("/save/batch")
   @PreAuthorize("@permission.check('subcontract_payment_attribute:add')")
   public ResultVO<Boolean> saveBatch(@RequestBody @Valid List<SysSupplierPaymentAttributeParam> paramList) {
      log.info("Api调用:付款属性新增");
      return ResultBuilder.success(this.supplierPaymentAttributeBiz.savePaymentAttribute(paramList));
   }

   @ApiOperation("修改")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('subcontract_payment_attribute:edit')")
   public ResultVO<Boolean> update(@RequestBody @Valid SysSupplierPaymentAttributeParam param) {
      log.info("Api调用:付款属性修改");
      return ResultBuilder.success(this.supplierPaymentAttributeBiz.updatePaymentAttribute(param));
   }

   @ApiOperation("删除")
   @DeleteMapping("/remove")
   @PreAuthorize("@permission.check('subcontract_payment_attribute:del')")
   public ResultVO<Boolean> remove(@RequestBody List<Long> ids) {
      log.info("Api调用:付款属性删除");
      return ResultBuilder.success(this.supplierPaymentAttributeBiz.delPaymentAttribute(ids));
   }

   public SysPaymentAttributeController(final SysSupplierPaymentAttributeBiz supplierPaymentAttributeBiz) {
      this.supplierPaymentAttributeBiz = supplierPaymentAttributeBiz;
   }
}
