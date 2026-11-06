package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.biz.ContractInvoiceBiz;
import com.hzchum.scim.contract.core.api.enums.CollectionTypeEnum;
import com.hzchum.scim.contract.core.api.enums.CreateInvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCheckDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ContractInvoiceEditDTOParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.InvoiceLedgerQueryVoParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.InvoiceProjectQueryVoParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.InvoiceWasteQueryVoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
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

@Api(tags = "合同管理-开票")
@Validated
@RestController
@RequestMapping("/api/contract/invoice")
public class InvoiceController {
   private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);
   @Resource
   private ContractInvoiceBiz invoiceBiz;

   @ApiOperation("项目台账-开票列表")
   @GetMapping("/project")
   @PreAuthorize("@permission.check('contract_ledger_invoice:get')")
   public ResultVO<PageVO<ContractInvoiceDTO>> listProjectInvoice(
      InvoiceProjectQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目台账-开票列表");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setType(CreateInvoiceTypeEnum.PROJECT_COLLECTION.getType());
      return ResultBuilder.success(this.invoiceBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("项目台账-开票列表-打印")
   @GetMapping("/project/print")
   @PreAuthorize("@permission.check('contract_ledger_invoice:print')")
   public ResultVO printListProjectInvoice(InvoiceProjectQueryVoParam param) {
      log.info("Api调用:项目台账-开票列表打印");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setType(CreateInvoiceTypeEnum.PROJECT_COLLECTION.getType());
      return ResultBuilder.success(this.invoiceBiz.printList(dtoParam));
   }

   @ApiOperation("废料台账-开票列表")
   @GetMapping("/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_invoice:get')")
   public ResultVO<PageVO<ContractInvoiceDTO>> listWasteInvoice(
      InvoiceWasteQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:废料台账-开票列表");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setInvoiceUnitId(param.getBranchCompanyId());
      dtoParam.setType(CollectionTypeEnum.WASTE_COLLECTION.getType());
      return ResultBuilder.success(this.invoiceBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("废料台账-废料开票列表-打印")
   @GetMapping("/waste/print")
   @PreAuthorize("@permission.check('contract_scrap_ledger_invoice:print')")
   public ResultVO printListWasteInvoice(InvoiceWasteQueryVoParam param) {
      log.info("Api调用:废料台账-开票列表打印");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setInvoiceUnitId(param.getBranchCompanyId());
      dtoParam.setType(CollectionTypeEnum.WASTE_COLLECTION.getType());
      return ResultBuilder.success(this.invoiceBiz.printList(dtoParam));
   }

   @ApiOperation("收款台账-开票列表")
   @GetMapping("/listPage")
   @PreAuthorize("@permission.check('collection_ledger_invoice:get')")
   public ResultVO<PageVO<ContractInvoiceDTO>> listPageLedger(
      InvoiceLedgerQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:收款台账-开票列表");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
      return ResultBuilder.success(this.invoiceBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("收款台账-开票列表-打印")
   @GetMapping("/listPage/print")
   @PreAuthorize("@permission.check('collection_ledger_invoice:print')")
   public ResultVO printListPageLedger(InvoiceLedgerQueryVoParam param) {
      log.info("Api调用:收款台账-开票列表打印");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
      return ResultBuilder.success(this.invoiceBiz.printList(dtoParam));
   }

   @ApiOperation("收款台账-开票金额之和")
   @GetMapping("/getInvoiceSum")
   public ResultVO<BigDecimal> getInvoiceSum(InvoiceLedgerQueryVoParam param) {
      log.info("Api调用: 查询发票金额之和");
      ContractInvoiceQueryDtoParam dtoParam = BeanUtil.copy(param, ContractInvoiceQueryDtoParam.class);
      dtoParam.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
      return ResultBuilder.success(this.invoiceBiz.getSummaryInvoice(dtoParam));
   }

   @Validated
   @ApiOperation("批量新增开票")
   @PostMapping("/saveList")
   @PreAuthorize("@permission.check('contract_ledger_invoice:add')")
   public ResultVO saveProjectInvoice(@RequestBody @Valid List<ContractInvoiceSaveDTOParam> saveDTOParams) {
      log.info("Api调用:新增项目开票");
      return ResultBuilder.success(this.invoiceBiz.saveList(CreateInvoiceTypeEnum.PROJECT_COLLECTION.getType(), saveDTOParams));
   }

   @ApiOperation("新增-废料开票")
   @PostMapping("/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_invoice:add')")
   public ResultVO saveWasteInvoice(@RequestBody @Valid List<ContractInvoiceSaveDTOParam> saveDTOParams) {
      log.info("Api调用:新增废料开票");
      return ResultBuilder.success(this.invoiceBiz.saveList(CreateInvoiceTypeEnum.WASTE_COLLECTION.getType(), saveDTOParams));
   }

   @ApiOperation("审核-项目开票")
   @PutMapping("/audit/project")
   @PreAuthorize("@permission.check('contract_ledger_invoice:audit')")
   public ResultVO auditProjectInvoice(@RequestBody @Valid ContractCheckDtoParam param) {
      log.info("Api调用: 审核项目开票");
      return ResultBuilder.success(this.invoiceBiz.auditInvoice(param));
   }

   @ApiOperation("审核-废料开票")
   @PutMapping("/audit/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_invoice:audit')")
   public ResultVO auditWasteInvoice(@RequestBody @Valid ContractCheckDtoParam param) {
      log.info("Api调用: 审核废料开票");
      return ResultBuilder.success(this.invoiceBiz.auditInvoice(param));
   }

   @ApiOperation("修改-项目开票")
   @PutMapping("/project")
   @PreAuthorize("@permission.check('contract_ledger_invoice:edit')")
   public ResultVO updateProject(@RequestBody @Valid ContractInvoiceEditDTOParam editDTOParam) {
      log.info("Api调用:修改项目开票");
      return ResultBuilder.success(this.invoiceBiz.updateInvoice(editDTOParam));
   }

   @ApiOperation("修改-废料开票")
   @PutMapping("/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_invoice:edit')")
   public ResultVO updateWaste(@RequestBody @Valid ContractInvoiceEditDTOParam editDTOParam) {
      log.info("Api调用:修改废料开票");
      return ResultBuilder.success(this.invoiceBiz.updateInvoice(editDTOParam));
   }

   @ApiOperation("删除-项目开票")
   @ApiImplicitParam(name = "id", value = "开票记录ID", paramType = "path", required = true)
   @DeleteMapping("/deleteById/{id}/project")
   @PreAuthorize("@permission.check('contract_ledger_invoice:del')")
   public ResultVO deleteProject(@PathVariable Long id) {
      log.info("Api调用: 删除-未审核开票填报");
      return ResultBuilder.success(this.invoiceBiz.delete(id));
   }

   @ApiOperation("删除-废料开票")
   @ApiImplicitParam(name = "id", value = "开票记录ID", paramType = "path", required = true)
   @DeleteMapping("/deleteById/{id}/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_invoice:del')")
   public ResultVO deleteWaste(@PathVariable Long id) {
      log.info("Api调用: 删除-未审核开票填报");
      return ResultBuilder.success(this.invoiceBiz.delete(id));
   }
}
