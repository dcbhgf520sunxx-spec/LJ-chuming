package com.hzchum.scim.rest.controller.contract;

import org.springframework.security.access.prepost.PreAuthorize;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.DataPermissionCheck;
import com.hzchum.scim.common.core.api.enums.WasteHandleMethodEnum;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionBiz;
import com.hzchum.scim.contract.core.api.biz.ContractInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractScrapSaleLedgerBiz;
import com.hzchum.scim.contract.core.api.enums.CollectionTypeEnum;
import com.hzchum.scim.contract.core.api.enums.CreateInvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnProductDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCheckDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ContractCollectionUpdateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ContractInvoiceEditDTOParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.CollectionWasteQueryVoParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.InvoiceWasteQueryVoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-废品销售台账")
@Validated
@RestController
@RequestMapping("/api/contract/return/sale/ledger")
public class ContractReturnSaleLedgerController {
   private static final Logger log = LoggerFactory.getLogger(ContractReturnSaleLedgerController.class);
   private final ContractScrapSaleLedgerBiz contractScrapSaleLedgerBiz;
   private final ContractCollectionBiz contractCollectionBiz;
   private final ContractInvoiceBiz contractInvoiceBiz;

   @ApiOperation("销售总额")
   @GetMapping("/saleTotalAmount")
   @PreAuthorize("@permission.check('product_waste:get')")
   public ResultVO<BigDecimal> getTotalSaleAmount() {
      log.info("Api调用:获取制成品废品出售总额");
      return ResultBuilder.success(this.contractScrapSaleLedgerBiz.getSaleAmount(null, null));
   }

   @ApiOperation("台账列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('product_waste:get')")
   public ResultVO<PageVO<ContractWasteLedgerDTO>> pageListScrapSaleLedger(
      LocalDate startDate,
      LocalDate endDate,
      Long branchCompanyId,
      Long contractWasteId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:制成品废品出售台账列表");
      List<ContractWasteLedgerDTO> ledgerDTOList = this.contractScrapSaleLedgerBiz.listScrapSaleLedger(startDate, endDate, branchCompanyId, contractWasteId);
      return ResultBuilder.success(PageUtil.listPage(pageNumber, pageSize, ledgerDTOList));
   }

   @ApiOperation("台账列表-打印")
   @GetMapping("/list/print")
   @PreAuthorize("@permission.check('product_waste:print')")
   public ResultVO<PrintVO<List<ContractWasteLedgerDTO>>> printListScrapSaleLedger(
      LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long contractWasteId
   ) {
      log.info("Api调用:制成品废品出售台账列表-打印");
      return ResultBuilder.success(this.contractScrapSaleLedgerBiz.printListScrapSaleLedger(startDate, endDate, branchCompanyId, contractWasteId));
   }

   @ApiOperation("总成本")
   @GetMapping("/totalCost")
   @PreAuthorize("@permission.check('product_waste:get')")
   public ResultVO<BigDecimal> getTotalSaleAmount(Long branchCompanyId, Long contractWasteId) {
      log.info("Api调用:获取制成品废品总成本");
      return ResultBuilder.success(this.contractScrapSaleLedgerBiz.getWasteCost(branchCompanyId, contractWasteId));
   }

   @ApiOperation("产品列表")
   @GetMapping("/product/list")
   @PreAuthorize("@permission.check('product_waste:get')")
   public ResultVO<PageVO<ContractReturnProductDTO>> pageSaleProductList(
      @RequestParam Long branchCompanyId,
      @RequestParam Long contractWasteId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:制成品废品出售-产品列表");
      return ResultBuilder.success(
         this.contractScrapSaleLedgerBiz
            .pageListWasteProduct(branchCompanyId, contractWasteId, null, WasteHandleMethodEnum.WASTE_SALE.getType(), pageNumber, pageSize)
      );
   }

   @ApiOperation("产品列表-打印")
   @GetMapping("/product/list/print")
   @PreAuthorize("@permission.check('product_waste:print')")
   public ResultVO<PrintVO<List<ContractReturnProductDTO>>> printSaleProductList(@RequestParam Long branchCompanyId, @RequestParam Long contractWasteId) {
      log.info("Api调用:制成品废品出售-产品列表打印");
      return ResultBuilder.success(
         this.contractScrapSaleLedgerBiz.printListWasteProduct(branchCompanyId, contractWasteId, null, WasteHandleMethodEnum.WASTE_SALE.getType())
      );
   }

   @ApiOperation("收款列表")
   @GetMapping("/collection/list")
   @PreAuthorize("@permission.check('product_waste:get')")
   @DataPermissionCheck(permissionType = 2)
   public ResultVO<PageVO<ContractCollectionDTO>> listScrapCollection(
      CollectionWasteQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:制成品废品台账-收款列表");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setCollectionUnitId(param.getBranchCompanyId());
      dtoParam.setType(CollectionTypeEnum.SCRAP_COLLECTION.getType());
      return ResultBuilder.success(this.contractCollectionBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("收款列表-打印")
   @GetMapping("/collection/list/print")
   @PreAuthorize("@permission.check('product_waste:print')")
   @DataPermissionCheck(permissionType = 2)
   public ResultVO<PrintVO<List<Map<String, Object>>>> printListScrapCollection(CollectionWasteQueryVoParam param) {
      log.info("Api调用:制成品废品台账-收款列表打印");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setCollectionUnitId(param.getBranchCompanyId());
      dtoParam.setType(CollectionTypeEnum.SCRAP_COLLECTION.getType());
      return ResultBuilder.success(this.contractCollectionBiz.printList(dtoParam));
   }

   @ApiOperation("新增收款")
   @PostMapping("/collection/save")
   @PreAuthorize("@permission.check('product_waste:add')")
   public ResultVO saveScrapCollection(@RequestBody @Valid List<ContractCollectionSaveDTOParam> params) {
      log.info("Api调用:新增制成品出售收款");
      return ResultBuilder.success(this.contractCollectionBiz.saveList(CollectionTypeEnum.SCRAP_COLLECTION.getType(), params));
   }

   @ApiOperation("修改收款")
   @PutMapping("/collection/update")
   @PreAuthorize("@permission.check('product_waste:edit') && @contractCollectionAccess.productWasteRecord(#param.id,false)")
   public ResultVO updateScrapCollection(@RequestBody @Valid ContractCollectionUpdateDTOParam param) {
      log.info("Api调用:修改制成品出售收款");
      return ResultBuilder.success(this.contractCollectionBiz.updateCollection(param));
   }

   @ApiOperation("审核收款")
   @PutMapping("/collection/audit")
   @PreAuthorize("@permission.check('product_waste:review') && @contractCollectionAccess.productWasteRecord(#param.id,false)")
   public ResultVO auditScrapCollection(@RequestBody @Valid ContractCheckDtoParam param) {
      log.info("Api调用:审核制成品出售收款");
      return ResultBuilder.success(this.contractCollectionBiz.auditCollection(param));
   }

   @ApiOperation("删除收款")
   @DeleteMapping("/collection/delete/{id}")
   @PreAuthorize("@permission.check('product_waste:del') && @contractCollectionAccess.productWasteRecord(#id,false)")
   public ResultVO deleteScrapCollection(@PathVariable Long id) {
      log.info("Api调用:删除制成品出售收款");
      return ResultBuilder.success(this.contractCollectionBiz.deleteCollection(id));
   }

   @ApiOperation("开票列表")
   @GetMapping("/invoice/list")
   @PreAuthorize("@permission.check('product_waste:get')")
   public ResultVO<PageVO<ContractInvoiceDTO>> listScrapInvoice(
      InvoiceWasteQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:制成品出售台账-开票列表");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setInvoiceUnitId(param.getBranchCompanyId());
      dtoParam.setType(CollectionTypeEnum.SCRAP_COLLECTION.getType());
      return ResultBuilder.success(this.contractInvoiceBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("开票列表-打印")
   @GetMapping("/invoice/list/print")
   @PreAuthorize("@permission.check('product_waste:print')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> printListScrapInvoice(InvoiceWasteQueryVoParam param) {
      log.info("Api调用:制成品出售台账-开票列表打印");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setInvoiceUnitId(param.getBranchCompanyId());
      dtoParam.setType(CollectionTypeEnum.SCRAP_COLLECTION.getType());
      return ResultBuilder.success(this.contractInvoiceBiz.printList(dtoParam));
   }

   @ApiOperation("新增开票")
   @PostMapping("/invoice/save")
   @PreAuthorize("@permission.check('product_waste:add')")
   public ResultVO<Boolean> saveScrapInvoice(@RequestBody @Valid List<ContractInvoiceSaveDTOParam> params) {
      log.info("Api调用:新增制成品出售台账开票");
      return ResultBuilder.success(this.contractInvoiceBiz.saveList(CreateInvoiceTypeEnum.SCRAP_COLLECTION.getType(), params));
   }

   @ApiOperation("修改开票")
   @PutMapping("/invoice/update")
   @PreAuthorize("@permission.check('product_waste:edit') && @contractCollectionAccess.productWasteRecord(#editDTOParam.id,true)")
   public ResultVO<Boolean> updateScrapInvoice(@RequestBody @Valid ContractInvoiceEditDTOParam editDTOParam) {
      log.info("Api调用:修改制成品出售台账开票");
      return ResultBuilder.success(this.contractInvoiceBiz.updateInvoice(editDTOParam));
   }

   @ApiOperation("审核开票")
   @PutMapping("/invoice/audit")
   @PreAuthorize("@permission.check('product_waste:review') && @contractCollectionAccess.productWasteRecord(#param.id,true)")
   public ResultVO<Boolean> auditScrapInvoice(@RequestBody @Valid ContractCheckDtoParam param) {
      log.info("Api调用:审核制成品出售台账开票");
      return ResultBuilder.success(this.contractInvoiceBiz.auditInvoice(param));
   }

   @ApiOperation("删除开票")
   @DeleteMapping("/invoice/delete/{id}")
   @PreAuthorize("@permission.check('product_waste:del') && @contractCollectionAccess.productWasteRecord(#id,true)")
   public ResultVO<Boolean> deleteScrapInvoice(@PathVariable Long id) {
      log.info("Api调用: 删除-未审核开票填报");
      return ResultBuilder.success(this.contractInvoiceBiz.delete(id));
   }

   public ContractReturnSaleLedgerController(
      final ContractScrapSaleLedgerBiz contractScrapSaleLedgerBiz,
      final ContractCollectionBiz contractCollectionBiz,
      final ContractInvoiceBiz contractInvoiceBiz
   ) {
      this.contractScrapSaleLedgerBiz = contractScrapSaleLedgerBiz;
      this.contractCollectionBiz = contractCollectionBiz;
      this.contractInvoiceBiz = contractInvoiceBiz;
   }
}
