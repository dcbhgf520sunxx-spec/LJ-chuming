package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractSettlementBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectSettlementSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-项目预结算")
@RestController
@RequestMapping("/api/contract/project/preSettlement")
public class ContractSettlementController {
   private static final Logger log = LoggerFactory.getLogger(ContractSettlementController.class);
   private final ContractSettlementBiz contractSettlementBiz;

   @ApiOperation("项目台账-收入台账-新增预结算")
   @PostMapping("/save")
   @PreAuthorize("@contractCollectionAccess.settlementWrite(#param.projectId,#param.level,true)")
   public ResultVO saveProjectPreSettlement(
      @RequestBody @Valid ProjectSettlementSaveParam param, @RequestHeader(value = "financeBranchId", required = false) Long branchCompanyId
   ) {
      log.info("Api调用:项目台账-收入台账-预结算申请");
      param.setBranchCompanyId(branchCompanyId);
      return ResultBuilder.success(this.contractSettlementBiz.savePreSettlement(param));
   }

   @ApiOperation("项目台账-收入台账-预结算列表")
   @GetMapping("/list")
   @PreAuthorize("@contractCollectionAccess.settlementRead(#projectId,#level)")
   public ResultVO<ListVO<ContractSettlementDTO>> listProjectPreSettlement(
      @RequestParam Long projectId, Integer level, @RequestHeader(value = "financeBranchId", required = false) Long branchCompanyId
   ) {
      log.info("Api调用:项目预结算列表");
      return ResultBuilder.success(new ListVO<>(this.contractSettlementBiz.listProjectSettlement(projectId, level, branchCompanyId)));
   }

   @ApiOperation("项目台账-收入台账-预结算列表-打印")
   @GetMapping("/list/print")
   @PreAuthorize("@contractCollectionAccess.settlementRead(#projectId,#level)")
   public ResultVO<PrintVO<List<ContractSettlementDTO>>> listProjectPreSettlementPrint(
      @RequestParam Long projectId, Integer level, @RequestHeader(value = "financeBranchId", required = false) Long branchCompanyId
   ) {
      log.info("Api调用:项目预结算列表");
      return ResultBuilder.success(this.contractSettlementBiz.printListProjectSettlement(projectId, level, branchCompanyId));
   }

   public ContractSettlementController(final ContractSettlementBiz contractSettlementBiz) {
      this.contractSettlementBiz = contractSettlementBiz;
   }
}
