package com.hzchum.scim.rest.controller.scm;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.scm.core.api.biz.SubcontractOrderBiz;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderSaveDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderUpdateDTOParam;
import com.hzchum.scim.scm.core.api.service.SubcontractMonomerLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-分包订单")
@RestController
@RequestMapping("/api/scm/subcontract-order")
public class SubcontractOrderController {
   private static final Logger log = LoggerFactory.getLogger(SubcontractOrderController.class);
   @Resource
   private SubcontractOrderBiz subcontractOrderBiz;
   @Resource
   private SubcontractMonomerLinkService subcontractMonomerLinkService;

   @ApiOperation("分包订单列表")
   @GetMapping
   @PreAuthorize("@permission.check('subcontract_order:get')")
   public ResultVO<PageVO<SubcontractOrderDTO>> listOrders(
      SubcontractOrderQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 分包订单列表");
      return ResultBuilder.success(this.subcontractOrderBiz.pageListOrders(param, pageNumber, pageSize));
   }

   @ApiOperation("新增分包订单")
   @PostMapping
   @PreAuthorize("@permission.check('subcontract_order:add')")
   public ResultVO save(@RequestBody @Valid SubcontractOrderSaveDTOParam param) {
      log.info("Api调用: 新增分包订单");
      return ResultBuilder.success(this.subcontractOrderBiz.save(param));
   }

   @ApiOperation("修改分包订单")
   @PutMapping
   @PreAuthorize("@permission.check('subcontract_order:edit')")
   public ResultVO update(@RequestBody @Valid SubcontractOrderUpdateDTOParam param) {
      log.info("Api调用: 修改分包订单");
      return ResultBuilder.success(this.subcontractOrderBiz.update(param));
   }

   @ApiOperation("删除分包订单")
   @DeleteMapping
   @PreAuthorize("@permission.check('subcontract_order:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("Api调用: 删除分包订单");
      return ResultBuilder.success(this.subcontractOrderBiz.delete(ids));
   }

   @ApiOperation("分包订单统计")
   @GetMapping("/getSum")
   public ResultVO<SubcontractOrderSummaryDTO> getOrderSum() {
      log.info("Api调用: 分包订单统计");
      return ResultBuilder.success(this.subcontractOrderBiz.getSumSubcontractOrder());
   }

   @ApiOperation("查询单体的分包商列表")
   @GetMapping("/list-supplier")
   public ResultVO<ListVO<SupplierInfo>> listSupplier(@RequestParam Long monomerId) {
      log.info("Api调用: 根据单体ID,查询分包商列表");
      return ResultBuilder.success(new ListVO<>(this.subcontractMonomerLinkService.listByMonomerId(monomerId)));
   }
}
