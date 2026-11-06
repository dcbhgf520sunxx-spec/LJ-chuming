package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractChangeBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractAmountRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractChangeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectChangeInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ChangeAuditDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ContractChangeSaveDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-项目变更")
@RestController
@RequestMapping("/api/project")
public class ContractChangeController {
   private static final Logger log = LoggerFactory.getLogger(ContractChangeController.class);
   private final ContractChangeBiz contractChangeBiz;

   @ApiOperation("项目变更")
   @PostMapping("/updateProject")
   @PreAuthorize("@permission.check('contract_project:edit','contract_project:changeAmount')")
   public ResultVO updateProject(@RequestBody @Valid ContractChangeSaveDTOParam contractChangeDTOParam) {
      log.info("Api调用: 项目变更");
      return ResultBuilder.success(this.contractChangeBiz.changeProject(contractChangeDTOParam));
   }

   @ApiOperation("项目变更列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "year", value = "年份 2020", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "变更类型  1信息修改2合同金额变更4项目结算 8签证", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "发起人", paramType = "query"),
            @ApiImplicitParam(name = "auditorName", value = "审核人", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态 1审核中 2审核通过 4已驳回", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "10")
      }
   )
   @GetMapping("/listChange")
   @PreAuthorize("@permission.check('contract_change:get')")
   public ResultVO<PageVO<ContractChangeDTO>> listChanges(
      Long projectId,
      Integer year,
      Integer type,
      String name,
      String userName,
      String auditorName,
      Integer auditStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("Api调用: 查看项目变更列表");
      return ResultBuilder.success(
         this.contractChangeBiz.listContractChanges(projectId, year, type, name, userName, auditorName, auditStatus, pageNumber, pageSize)
      );
   }

   @ApiOperation("查看变更详情")
   @ApiImplicitParam(name = "changeId", value = "变更表id", paramType = "query", required = true)
   @GetMapping("/getTempInfo")
   @PreAuthorize("@permission.check('contract_change:detail','contract_change:audit')")
   public ResultVO<ContractProjectChangeInfoDTO> getProjectTempInfo(@RequestParam Long changeId) {
      log.info("Api调用: 根据变更表id查询合同信息变更类型详情");
      return ResultBuilder.success(this.contractChangeBiz.getByChangeId(changeId));
   }

   @ApiOperation("审核项目变更")
   @PutMapping("/changeAudit")
   @PreAuthorize("@permission.check('contract_change:audit')")
   public ResultVO changeAudit(@RequestBody @Valid ChangeAuditDTOParam auditDTOParam) {
      log.info("Api调用 : 审核项目变更");
      return ResultBuilder.success(this.contractChangeBiz.auditProjectChange(auditDTOParam));
   }

   @ApiOperation("合同额变更记录")
   @GetMapping("/listContractAmountRecord")
   @PreAuthorize("@permission.check('contract_ledger:amountLog')")
   public ResultVO<ListVO<ContractAmountRecordDTO>> listContractAmountRecords(Long projectId) {
      log.info("API调用 ：根据项目id,查询项目金额记录");
      return ResultBuilder.success(this.contractChangeBiz.listContractAmountRecord(projectId));
   }

   public ContractChangeController(final ContractChangeBiz contractChangeBiz) {
      this.contractChangeBiz = contractChangeBiz;
   }
}
