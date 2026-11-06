package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractWasteBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractWasteSaleDetailLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteLedgerQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractWasteQueryDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = "合同管理-废料合同")
@Validated
@RestController
@RequestMapping("/api/contract/contractWaste")
public class ContractWasteController {
   private static final Logger log = LoggerFactory.getLogger(ContractWasteController.class);
   private final ContractWasteBiz contractWasteBiz;

   @ApiOperation("列表(公共接口-无权限)")
   @GetMapping("/listAll")
   public ResultVO<ListVO<ContractWasteDTO>> listAll(ContractWasteQueryDtoParam param) {
      log.info("Api调用:废料合同列表(公共接口)");
      return ResultBuilder.success(new ListVO<>(this.contractWasteBiz.listAll(param)));
   }

   @ApiOperation("列表-分页")
   @GetMapping
   @PreAuthorize("@permission.check('contract_scrap_ledger_config:get')")
   public ResultVO<PageVO<ContractWasteDTO>> pageList(
      ContractWasteQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:废料合同列表");
      return ResultBuilder.success(this.contractWasteBiz.pageList(param, pageNumber, pageSize));
   }

   @ApiOperation("新增")
   @PostMapping
   @PreAuthorize("@permission.check('contract_scrap_ledger_config:add')")
   public ResultVO saveList(@RequestBody @Valid List<ContractWasteDtoParam> paramList) {
      log.info("Api调用:废料合同新增");
      return ResultBuilder.success(this.contractWasteBiz.saveList(paramList));
   }

   @ApiOperation("修改")
   @PutMapping
   @PreAuthorize("@permission.check('contract_scrap_ledger_config:edit')")
   public ResultVO updateList(@RequestBody @Valid List<ContractWasteDtoParam> paramList) {
      log.info("Api调用:废料合同修改");
      return ResultBuilder.success(this.contractWasteBiz.updateList(paramList));
   }

   @ApiOperation("删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('contract_scrap_ledger_config:del')")
   public ResultVO removeList(@RequestBody List<Long> ids) {
      log.info("Api调用:废料合同删除");
      return ResultBuilder.success(this.contractWasteBiz.deleteList(ids));
   }

   @ApiOperation("查询废料销售总额")
   @GetMapping("/saleTotalAmount")
   public ResultVO getSumSaleTotalAmount(ContractWasteLedgerQueryDtoParam param) {
      log.info("Api调用:查询废料销售总额");
      return ResultBuilder.success(this.contractWasteBiz.getSumTotalAmount(param));
   }

   @ApiOperation("废料台账-根据(购买方和出售单位)汇总")
   @GetMapping("/summary/ledger")
   @PreAuthorize("@permission.check('contract_scrap_ledger:get')")
   public ResultVO<PageVO<ContractWasteLedgerDTO>> pageListWasteLedger(
      ContractWasteLedgerQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:废料合同台账列表");
      return ResultBuilder.success(this.contractWasteBiz.pageListWasteLedger(param, pageNumber, pageSize));
   }

   @ApiOperation("废料台账-打印")
   @GetMapping("/summary/ledger/print")
   @PreAuthorize("@permission.check('contract_scrap_ledger:print')")
   public ResultVO<PrintVO<List<ContractWasteLedgerDTO>>> printListWasteLedger(ContractWasteLedgerQueryDtoParam param) {
      log.info("Api调用:废料台账列表打印");
      return ResultBuilder.success(this.contractWasteBiz.printWasteLedger(param));
   }

   @ApiOperation("废料台账-按日期查询")
   @GetMapping("/saleDetail")
   @PreAuthorize("@permission.check('contract_scrap_ledger:get')")
   public ResultVO<PageVO<ContractWasteSaleDetailLedgerDTO>> pageListWasteSaleDetail(
      ContractWasteLedgerQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:废料台账-按日期查询列表");
      return ResultBuilder.success(this.contractWasteBiz.pageListWasteSaleDetailLedger(param, pageNumber, pageSize));
   }

   @ApiOperation("废料台账-按日期查询-打印")
   @GetMapping("/saleDetail/print")
   @PreAuthorize("@permission.check('contract_scrap_ledger:print')")
   public ResultVO<PrintVO<List<ContractWasteSaleDetailLedgerDTO>>> printListWasteSaleDetail(ContractWasteLedgerQueryDtoParam param) {
      log.info("Api调用:废料台账-按日期查询列表打印");
      return ResultBuilder.success(this.contractWasteBiz.printListWasteSaleDetailLedger(param));
   }

   @ApiOperation("废料出售金额列表")
   @GetMapping("/saleAmount")
   @PreAuthorize("@permission.check('contract_scrap_ledger:detail')")
   public ResultVO<PageVO<ContractWasteSaleDetailLedgerDTO>> pageListWasteSaleAmount(
      ContractWasteLedgerQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:废料出售金额列表");
      return ResultBuilder.success(this.contractWasteBiz.pageListWasteSaleDetailLedger(param, pageNumber, pageSize));
   }

   @ApiOperation("废料出售金额列表-打印")
   @GetMapping("/saleAmount/print")
   @PreAuthorize("@permission.check('contract_scrap_ledger:detailPrint')")
   public ResultVO<PrintVO<List<ContractWasteSaleDetailLedgerDTO>>> printListWasteSaleAmount(ContractWasteLedgerQueryDtoParam param) {
      log.info("Api调用:废料出售金额列表-打印");
      return ResultBuilder.success(this.contractWasteBiz.printListWasteSaleDetailLedger(param));
   }

   @ApiOperation("废料出售-已收款开票额")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "contractWasteId", value = "废料出售合同id", required = true),
            @ApiImplicitParam(name = "branchCompanyId", value = "分支机构(出售单位)id", required = true)
      }
   )
   @GetMapping("/collection_Invoice/amount")
   public ResultVO<ContractInvoiceCollectionDTO> getWasteCollectionInvoiceInfo(@RequestParam Long contractWasteId, @RequestParam Long branchCompanyId) {
      log.info("Api调用:查询废料出售-已收款开票金额");
      return ResultBuilder.success(this.contractWasteBiz.getWasteCollectionInvoiceInfo(contractWasteId, branchCompanyId));
   }

   public ContractWasteController(final ContractWasteBiz contractWasteBiz) {
      this.contractWasteBiz = contractWasteBiz;
   }
}
