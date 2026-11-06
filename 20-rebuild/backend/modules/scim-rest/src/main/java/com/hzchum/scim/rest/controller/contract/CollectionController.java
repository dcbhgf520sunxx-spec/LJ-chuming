package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionBiz;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionInvoiceBiz;
import com.hzchum.scim.contract.core.api.enums.CollectionTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionWarningDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectSimpleDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCheckDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionQueryDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ContractCollectionUpdateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.CollectionLedgerQueryVoParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.CollectionProjectQueryVoParam;
import com.hzchum.scim.contract.core.api.pojo.voParam.CollectionWasteQueryVoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

@Api(tags = "合同管理-收款")
@RestController
@RequestMapping("/api/contract/collection")
@Validated
public class CollectionController {
   private static final Logger log = LoggerFactory.getLogger(CollectionController.class);
   @Resource
   private ContractCollectionBiz contractCollectionBiz;
   @Resource
   private ContractCollectionInvoiceBiz collectionInvoiceBiz;

   @ApiOperation("项目台账-收款列表")
   @GetMapping("/project")
   @PreAuthorize("@permission.check('contract_ledger_collection:get')")
   public ResultVO<PageVO<ContractCollectionDTO>> listProjectCollection(
      CollectionProjectQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:项目台账-收款列表");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setType(CollectionTypeEnum.PROJECT_COLLECTION.getType());
      return ResultBuilder.success(this.contractCollectionBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("项目台账-收款列表-打印")
   @GetMapping("/project/print")
   @PreAuthorize("@permission.check('contract_ledger_collection:print')")
   public ResultVO printListProjectCollection(CollectionProjectQueryVoParam param) {
      log.info("Api调用:项目台账-收款列表打印");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setType(CollectionTypeEnum.PROJECT_COLLECTION.getType());
      return ResultBuilder.success(this.contractCollectionBiz.printList(dtoParam));
   }

   @ApiOperation("废料台账-收款列表")
   @GetMapping("/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_collection:get')")
   public ResultVO<PageVO<ContractCollectionDTO>> listWasteCollection(
      CollectionWasteQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:废料台账-收款列表");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setCollectionUnitId(param.getBranchCompanyId());
      dtoParam.setType(CollectionTypeEnum.WASTE_COLLECTION.getType());
      return ResultBuilder.success(this.contractCollectionBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("废料台账-收款列表-打印")
   @GetMapping("/waste/print")
   @PreAuthorize("@permission.check('contract_scrap_ledger_collection:print')")
   public ResultVO printListWasteCollection(CollectionWasteQueryVoParam param) {
      log.info("Api调用:废料台账-收款列表打印");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setCollectionUnitId(param.getBranchCompanyId());
      dtoParam.setType(CollectionTypeEnum.WASTE_COLLECTION.getType());
      return ResultBuilder.success(this.contractCollectionBiz.printList(dtoParam));
   }

   @ApiOperation("收款台账-收款列表")
   @GetMapping("/listPage")
   @PreAuthorize("@permission.check('collection_ledger_collection:get')")
   public ResultVO<PageVO<ContractCollectionDTO>> listCollectionLedger(
      CollectionLedgerQueryVoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:收款台账-查看收款列表");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
      return ResultBuilder.success(this.contractCollectionBiz.pageList(dtoParam, pageNumber, pageSize));
   }

   @ApiOperation("收款台账-收款列表-打印")
   @GetMapping("/listPage/print")
   @PreAuthorize("@permission.check('collection_ledger_collection:print')")
   public ResultVO listByCondition(CollectionLedgerQueryVoParam param) {
      log.info("Api调用:收款台账-收款列表打印");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
      return ResultBuilder.success(this.contractCollectionBiz.printList(dtoParam));
   }

   @ApiOperation("收款台账-收款金额合计")
   @GetMapping("/getCollectionSum")
   public ResultVO<BigDecimal> getSumCollection(CollectionLedgerQueryVoParam param) {
      log.info("Api调用: 根据条件查询收款之和");
      ContractCollectionQueryDtoParam dtoParam = BeanUtil.copy(param, ContractCollectionQueryDtoParam.class);
      dtoParam.setAuditStatus(AuditStatusEnum.SUCCEED.getType());
      return ResultBuilder.success(this.contractCollectionBiz.getSummaryCollection(dtoParam));
   }

   @ApiOperation("获取项目-收款开票-自动显示信息")
   @GetMapping("/getFinanceInfo")
   public ResultVO<ProjectSimpleDTO> getFinanceInfo(@RequestParam Long projectId) {
      log.info("Api调用 : 查询收款信息");
      return ResultBuilder.success(this.collectionInvoiceBiz.getProjectFinanceInfo(projectId));
   }

   @ApiOperation("批量新增收款")
   @PostMapping("/saveList")
   @PreAuthorize("@permission.check('contract_ledger_collection:add')")
   public ResultVO saveProjectCollection(@RequestBody @Valid List<ContractCollectionSaveDTOParam> params) {
      log.info("Api调用: 批量新增收款");
      return ResultBuilder.success(this.contractCollectionBiz.saveList(CollectionTypeEnum.PROJECT_COLLECTION.getType(), params));
   }

   @ApiOperation("新增-废料收款")
   @PostMapping("/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_collection:add')")
   public ResultVO saveWasteCollection(@RequestBody @Valid List<ContractCollectionSaveDTOParam> params) {
      log.info("Api调用: 批量新增收款");
      return ResultBuilder.success(this.contractCollectionBiz.saveList(CollectionTypeEnum.WASTE_COLLECTION.getType(), params));
   }

   @ApiOperation("审核-项目收款")
   @PutMapping("/audit/project")
   @PreAuthorize("@permission.check('contract_ledger_collection:audit')")
   public ResultVO auditCollection(@RequestBody @Valid ContractCheckDtoParam param) {
      log.info("Api调用: 审核项目收款");
      return ResultBuilder.success(this.contractCollectionBiz.auditCollection(param));
   }

   @ApiOperation("审核-废料收款")
   @PutMapping("/audit/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_collection:audit')")
   public ResultVO auditWasteCollection(@RequestBody @Valid ContractCheckDtoParam param) {
      log.info("Api调用: 审核废料收款");
      return ResultBuilder.success(this.contractCollectionBiz.auditCollection(param));
   }

   @ApiOperation("修改-项目收款")
   @PutMapping("/project")
   @PreAuthorize("@permission.check('contract_ledger_collection:edit')")
   public ResultVO editProjectCollection(@RequestBody @Valid ContractCollectionUpdateDTOParam param) {
      log.info("Api调用:修改项目收款");
      return ResultBuilder.success(this.contractCollectionBiz.updateCollection(param));
   }

   @ApiOperation("修改-废料收款")
   @PutMapping("/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_collection:edit')")
   public ResultVO updateWasteCollection(@RequestBody @Valid ContractCollectionUpdateDTOParam param) {
      log.info("Api调用:修改废料收款");
      return ResultBuilder.success(this.contractCollectionBiz.updateCollection(param));
   }

   @ApiOperation("删除-项目收款")
   @DeleteMapping("/deleteById/{id}/project")
   @PreAuthorize("@permission.check('contract_ledger_collection:del')")
   public ResultVO deleteProjectCollection(@PathVariable Long id) {
      log.info("Api调用: 删除-项目收款");
      return ResultBuilder.success(this.contractCollectionBiz.deleteCollection(id));
   }

   @ApiOperation("删除-废料收款")
   @DeleteMapping("/deleteById/{id}/waste")
   @PreAuthorize("@permission.check('contract_scrap_ledger_collection:del')")
   public ResultVO deleteWasteCollection(@PathVariable Long id) {
      log.info("Api调用: 删除-废料收款");
      return ResultBuilder.success(this.contractCollectionBiz.deleteCollection(id));
   }

   @ApiOperation("查看收款预警列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份 2021", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型 1有欠款 0无欠款", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("/listCollectionWarning")
   @PreAuthorize("@permission.check('collection_warn:get')")
   public ResultVO<PageVO<ContractCollectionWarningDTO>> listCollectionWarning(
      Integer year, Long projectId, Boolean type, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查看收款预警列表");
      return ResultBuilder.success(this.contractCollectionBiz.listCollectionWarning(year, projectId, type, pageNumber, pageSize));
   }

   @ApiOperation("打印收款预警列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "年份 2021", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型 1有欠款 0无欠款", paramType = "query")
      }
   )
   @GetMapping("/listCollectionWarning/print")
   @PreAuthorize("@permission.check('collection_warn:print')")
   public ResultVO printCollectionWarning(Integer year, Long projectId, Boolean type) {
      log.info("Api调用: 打印收款预警列表");
      return ResultBuilder.success(this.contractCollectionBiz.printCollectionWarnings(year, projectId, type));
   }
}
