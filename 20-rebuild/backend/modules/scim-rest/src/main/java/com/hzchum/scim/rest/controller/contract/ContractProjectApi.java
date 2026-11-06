package com.hzchum.scim.rest.controller.contract;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessBiz;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.AppendAttachmentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectLedgerSumDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListForUserDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectPrimeListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractProjectArchivistDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractProjectFilesDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractTechListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectBaseDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectBusinessDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectCustomerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectDetailsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectOrderStatisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ContractProjectFilesParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ContractProjectIsArchivistParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectListQueryParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProjectSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectUserUpdateCollectDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectUserUpdateParam;
import com.hzchum.scim.contract.core.api.pojo.vo.save.ProjectSaveVORequest;
import com.hzchum.scim.contract.core.api.pojo.vo.update.ProjectUserUpdateVORequest;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectRecordService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.plan.core.api.biz.PlanMonomerBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectTreeResponseVO;
import com.hzchum.scim.system.core.api.annotation.Log;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.BusinessTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ModuleEnum;
import com.hzchum.scim.system.core.api.common.enums.OperationTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "合同管理-项目")
@RestController
@RequestMapping("/api/project")
public class ContractProjectApi {
   private static final Logger log = LoggerFactory.getLogger(ContractProjectApi.class);
   @Resource
   private ContractProjectService projectService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private PlanMonomerBiz monomerBiz;
   @Resource
   private ContractCollectionInvoiceBiz collectionInvoiceBiz;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private BusinessBiz businessBiz;
   @Resource
   private ContractProjectContentService projectContentService;
   @Resource
   private ContractProjectRecordService projectRecordService;
   @Resource
   private ContractProjectBiz contractProjectBiz;

   @ApiOperation("档案管理附件信息修改")
   @PostMapping("/appendAttachment")
   @PreAuthorize("@permission.check('contract_record:get')")
   public ResultVO appendAttachment(@RequestBody AppendAttachmentDTO attachmentDTO) {
      log.info("API 调用 ：档案管理附件信息修改");
      return ResultBuilder.success(this.contractProjectBiz.appendAttachment(attachmentDTO));
   }

   @ApiOperation("档案管理附件批量下载")
   @PostMapping("/downloadAttachments")
   @PreAuthorize("@permission.check('contract_record:download')")
   public void bulkDownloadAttachment(@RequestBody List<Long> projectIds) {
      log.info("API 调用 ：附件批量下载");
      this.contractProjectBiz.bulkDownloadAttachment(projectIds);
   }

   @ApiOperation("档案管理附件批量下载-NEW")
   @PostMapping("/downloadAttachmentsNew")
   @PreAuthorize("@permission.check('contract_record:download')")
   public ResultVO bulkDownloadAttachmentNew(@RequestBody Map<Long, List<Long>> projectIdsMap) throws IOException {
      log.info("API 调用 ：档案管理附件批量下载-NEW");
      return ResultBuilder.success(this.contractProjectBiz.bulkDownloadAttachmentNew(projectIdsMap));
   }

   @ApiOperation("所有未归档合同数量")
   @GetMapping("/getUnArchived")
   @PreAuthorize("@permission.check('contract_record:get')")
   public ResultVO<Integer> getUnArchived() {
      return ResultBuilder.success(this.contractProjectBiz.getUnArchived());
   }

   @ApiOperation("获取项目详情")
   @GetMapping("/{projectId}/details")
   public ResultVO<ProjectDetailsDTO> getContractDetailsByProjectId(@PathVariable Long projectId) {
      log.info("API 调用 ：获取项目详情");
      return ResultBuilder.success(this.contractProjectBiz.getContractDetailsByProjectId(projectId));
   }

   @ApiOperation("获取项目基础信息")
   @GetMapping("/{projectId}/base")
   @PreAuthorize("@permission.check('contract_project:detail')")
   public ResultVO<ProjectBaseDTO> getContractBaseByProjectId(@PathVariable Long projectId) {
      log.info("API 调用 ：获取项目基础信息");
      return ResultBuilder.success(this.contractProjectBiz.getContractBaseByProjectId(projectId));
   }

   @ApiOperation("生成子合同流水编号")
   @GetMapping("/{projectId}/serialnumber")
   public ResultVO<String> getSerialNumberr(@PathVariable Integer projectId) {
      log.info("API 调用 : 生成子合同流水编号 ");
      return ResultBuilder.success(this.contractProjectBiz.getSerialNumber(projectId));
   }

   @ApiOperation("合同档案归档详情")
   @GetMapping("/isArchivist")
   @PreAuthorize("@permission.check('contract_record:get')")
   public ResultVO<PageVO<ContractProjectArchivistDTO>> isArchivist(
      ContractProjectIsArchivistParam contractProjectIsArchivistParam,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：合同档案归档详情");
      return ResultBuilder.success(this.contractProjectBiz.isArchivist(contractProjectIsArchivistParam, pageNumber, pageSize));
   }

   @ApiOperation("合同档案列表")
   @GetMapping("/listContracts")
   @PreAuthorize("@permission.check('contract_record:get')")
   public ResultVO<PageVO<ContractProjectFilesDTO>> pageByCondition(
      ContractProjectFilesParam contractProjectFilesParam,
      Long projectId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取合同档案列表");
      PageVO<ContractProjectFilesDTO> pageVO = this.contractProjectBiz.listProjectFiles(contractProjectFilesParam, projectId, pageNumber, pageSize);
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation("查询项目内容列表")
   @ApiImplicitParam(name = "businessType", value = "业务类型 1加工承揽 2项目承包", required = true)
   @GetMapping("/getAllType")
   public ResultVO getAllTypeList(@RequestParam("businessType") Integer businessType, @RequestParam(defaultValue = "1") Integer flag) {
      log.info("API 调用 ：根据业务类型,获取项目内容列表");
      return ResultBuilder.success(this.projectContentService.listProjectContentCategory(businessType, flag));
   }

   @ApiOperation("合同档案详情 文件类型列表")
   @GetMapping("/listAttachmentType")
   @PreAuthorize("@permission.check('contract_record:get')")
   public ResultVO listAttachmentType() {
      log.info("API 调用 ：合同档案详情 文件类型列表");
      return ResultBuilder.success(this.projectService.selectAttachmentTypeList());
   }

   @ApiOperation("项目列表")
   @GetMapping("/listAllProject")
   @PreAuthorize("@permission.check('contract_project:get','contract_project_complete:get')")
   public ResultVO<PageVO<ContractProjectListDTO>> listPageByCondition(
      ProjectListQueryParam queryParam, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取 项目列表");
      return ResultBuilder.success(this.contractProjectBiz.pageListProject(queryParam, pageNumber, pageSize));
   }

   @ApiOperation("主合同项目列表")
   @GetMapping("/prime/contract/list")
   public ResultVO<List<ContractProjectPrimeListDTO>> primeContractList() {
      log.info("API 调用 ：主合同项目列表");
      return ResultBuilder.success(this.contractProjectBiz.primeContractList());
   }

   @ApiOperation("项目列表（供项目人员配置使用）")
   @GetMapping("/listAllProjectBrief")
   public ResultVO<List<ContractProjectListForUserDTO>> pageListProjectByIdOrName(ProjectListQueryParam queryParam) {
      log.info("API 调用 ：获取 项目列表");
      return ResultBuilder.success(this.contractProjectBiz.pageListProjectByIdOrNameAll(queryParam));
   }

   @ApiOperation("打印项目列表")
   @GetMapping("/listAllProject/print")
   @PreAuthorize("@permission.check('contract_project:print')")
   public ResultVO listPageByCondition(ProjectListQueryParam queryParam) {
      log.info("API 调用 ：打印项目列表");
      return ResultBuilder.success(this.contractProjectBiz.printContractByConditions(queryParam));
   }

   @ApiOperation("项目数据总览")
   @ApiImplicitParam(name = "year", value = "年份 例:2022", paramType = "query")
   @GetMapping("/projectStatistics")
   @PreAuthorize("@permission.check('contract_project:get')")
   public ResultVO<ProjectOrderStatisticsDTO> getProjectStatistics(
      Integer year, @RequestParam(required = false) Integer productType, @RequestParam(required = false) Integer lumpSumSystemType
   ) {
      log.info("Api调用: 项目数据总览");
      return ResultBuilder.success(this.projectService.getStatistics(year, productType, lumpSumSystemType));
   }

   @ApiOperation("结构工程量汇总(吨)")
   @GetMapping("/getStructureWorkQuantitySum")
   public ResultVO<BigDecimal> getSumStructureWorkQuantity(ProjectListQueryParam queryParam) {
      log.info("API 调用 ：打印项目列表");
      return ResultBuilder.success(this.contractProjectBiz.getSumStructureWorkQuantity(queryParam));
   }

   @ApiOperation("项目数量统计(无权限)")
   @ApiImplicitParam(name = "year", value = "年份 例:2022", paramType = "query")
   @GetMapping("/v2/projectStatistics")
   public ResultVO<ProjectOrderStatisticsDTO> getProjectStatisticsV2(
      Integer year, @RequestParam(required = false) Integer productType, @RequestParam(required = false) Integer lumpSumSystemType
   ) {
      log.info("Api调用: 项目订单统计(无权限");
      return ResultBuilder.success(this.projectService.getStatistics(year, productType, lumpSumSystemType));
   }

   @ApiOperation("下载项目信息")
   @GetMapping("/{projectId}/export")
   @PreAuthorize("@permission.check('contract_project:download')")
   public ResultVO exportProject(@PathVariable Long projectId, HttpServletResponse response) {
      log.info("API 调用 ：下载项目信息资料");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "导出失败，无法解析用户信息！");
      return ResultBuilder.success(this.contractProjectBiz.exportProject(projectId, response));
   }

   @ApiOperation("查询可进行完工的项目数量")
   @GetMapping("/getOutFinishCount")
   public ResultVO getOutFinishCount() {
      log.info("API 调用 ：下载项目信息资料");
      return ResultBuilder.success(this.projectService.getOutFinishCount());
   }

   @ApiOperation("根据条件,查询项目累计合同额")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectType", value = "项目类型 1建钢 2桥梁 4围护", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "项目状态 1进行中 2暂停 4完工 8已结算", paramType = "query"),
            @ApiImplicitParam(name = "year", value = "创建年份 例2021", paramType = "query")
      }
   )
   @GetMapping("/getContractAmountSum")
   @PreAuthorize("@permission.check('contract_project:get')")
   public ResultVO getContractAmountSum(Integer projectType, Integer year, Integer status) {
      log.info("API 调用:根据条件,查询项目累计合同额");
      return ResultBuilder.success(this.projectService.getContractAmountSum(projectType, year, status));
   }

   @ApiOperation("列表操作记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "操作类型 1新增 2删除 3修改 4暂停 5继续", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "起始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query"),
            @ApiImplicitParam(name = "operator", value = "操作人姓名", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("/record")
   @PreAuthorize("@permission.check('contract_change:get')")
   public ResultVO<PageVO<ProjectRecordDTO>> listPageRecords(
      Long projectId,
      Integer type,
      LocalDate startDate,
      LocalDate endDate,
      String operator,
      @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：项目列表 列表操作记录");
      PageVO<ProjectRecordDTO> pageVO = this.projectRecordService.listProjectRecord(projectId, type, startDate, endDate, operator, pageNumber, pageSize);
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation("查询全部项目简要信息 id和name")
   @GetMapping("/selectAllProjectInfo")
   public ResultVO selectAllProjectSimpleInfo() {
      log.info("API 调用 ：查询全部项目简要信息 id和name");
      return ResultBuilder.success(this.projectService.selectAllProject());
   }

   @ApiOperation("项目立项")
   @PostMapping("")
   @PreAuthorize("@permission.check('contract_project:add')")
   public ResultVO save(@Valid @RequestBody ProjectSaveVORequest saveVORequest) {
      log.info("API 调用 ：保存项目信息");
      SecurityUser user = UserUtil.getCurrentUser();
      Preconditions.checkArgument(user != null, "新建失败，无法解析用户信息！");
      return ResultBuilder.success(this.contractProjectBiz.saveContract(saveVORequest));
   }

   @ApiOperation("查询围护的字典数据")
   @GetMapping("/listByType/{type}")
   public ResultVO listByType(@PathVariable("type") Integer type) {
      log.info("API 调用 ：查询围护的字典数据");
      return ResultBuilder.success(this.contractProjectBiz.listByType(type));
   }

   @ApiOperation("下载-合同基础附件")
   @GetMapping("/base/attachment/{id}")
   @PreAuthorize("@permission.check('contract_project:download')")
   public void downloadProjectBaseAttachment(@PathVariable Long id, Integer fileType, HttpServletResponse response) {
      log.info("API 调用 ：根据附件id下载文件");
      this.attachmentService.downloadFile(id, fileType);
   }

   @ApiOperation("查询项目商务信息")
   @GetMapping("/{projectId}/business")
   @PreAuthorize("@permission.check('contract_project:detail')")
   public ResultVO<ProjectBusinessDTO> getContractBusinessByProjectId(@PathVariable Long projectId) {
      log.info("API 调用 ：获取项目商务信息");
      return ResultBuilder.success(this.contractProjectBiz.getContractBusinessByProjectId(projectId));
   }

   @ApiOperation("查询项目商务信息")
   @GetMapping("v2/{projectId}/business")
   @PreAuthorize("@permission.check('contract_project:detail')")
   public ResultVO<ProjectBusinessDTO> getContractBusinessByProjectIdV2(@PathVariable Long projectId) {
      log.info("API 调用 ：获取项目商务信息");
      return ResultBuilder.success(this.contractProjectBiz.getContractBusinessByProjectIdV2(projectId));
   }

   @ApiOperation("查询项目技术交底")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "path", required = true),
            @ApiImplicitParam(name = "type", value = "技术交底类型 1结构 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板", paramType = "path")
      }
   )
   @GetMapping("/techDisclosure/{projectId}")
   @PreAuthorize("@permission.check('contract_project:detail','plan_artifact_tree_list:get','plan_enclosure_list:get')")
   public ResultVO<ContractTechListDTO> listTechnicalDisclosure(@PathVariable Long projectId, @RequestParam(required = false) Integer type) {
      log.info("API 调用 ：获取项目 技术交底列表");
      return ResultBuilder.success(this.contractTechService.listTech(projectId, type));
   }

   @ApiOperation("查询项目客户信息")
   @GetMapping("/{projectId}/customer")
   @PreAuthorize("@permission.check('contract_project:detail')")
   public ResultVO<ProjectCustomerDTO> getContractCustomerByProjectId(@PathVariable Long projectId) {
      log.info("API 调用 ：获取项目客户信息");
      return ResultBuilder.success(this.contractProjectBiz.getContractCustomerByProjectId(projectId));
   }

   @ApiOperation("编辑-更新项目用户")
   @PutMapping("/{projectId}/users")
   @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "path", required = true)
   @PreAuthorize("@permission.check('contract_project:editMember')")
   public ResultVO saveLinks(@PathVariable Long projectId, @RequestBody ProjectUserUpdateVORequest requestVO) {
      log.info("API 调用 ： 编辑-更新项目用户");
      return ResultBuilder.success(this.contractProjectBiz.saveLinks(projectId, requestVO.getIds()));
   }

   @ApiOperation("编辑-更新多项目中的所有用户")
   @ApiImplicitParam(
      name = "projectUserUpdateCollectDTOParam",
      value = "项目id列表",
      dataType = "com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectUserUpdateCollectDTOParam",
      paramType = "body",
      required = true
   )
   @PostMapping("/projectIdsUsers")
   @PreAuthorize("@permission.check('contract_project:editMember', #projectUserUpdateCollectDTOParam.isCover == true ? 'project_add_staff:coverSubmit' : 'project_add_staff:addSubmit')")
   public ResultVO saveProjectsLinks(@RequestBody ProjectUserUpdateCollectDTOParam projectUserUpdateCollectDTOParam) {
      log.info("API 调用 ： 编辑-更新多项目中的所有用户");
      return ResultBuilder.success(this.contractProjectBiz.saveProjectsLinks(projectUserUpdateCollectDTOParam));
   }

   @ApiOperation(value = "获取项目台账", notes = "获取项目台账")
   @GetMapping("/pageProjectLedger")
   @PreAuthorize("@permission.check('contract_ledger:get')")
   public ResultVO<PageVO<ContractProjectLedgerDTO>> pageProjectLedger(
      ProjectLedgerQueryDTOParam queryDTOParam, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：获取项目台账");
      return ResultBuilder.success(this.collectionInvoiceBiz.listProjectLedger(queryDTOParam, pageNumber, pageSize));
   }

   @ApiOperation(value = "打印项目台账列表", notes = "打印项目台账列表")
   @GetMapping("/pageProjectLedger/print")
   @PreAuthorize("@permission.check('contract_ledger:print')")
   public ResultVO printProjectLedgerList(ProjectLedgerQueryDTOParam queryDTOParam) {
      log.info("API 调用 ：打印项目台账列表");
      return ResultBuilder.success(this.collectionInvoiceBiz.printProjectLedgerList(queryDTOParam));
   }

   @ApiOperation("查询-项目已收款开票金额(公共接口)")
   @GetMapping("/collection_invoice/amount")
   public ResultVO<ContractInvoiceCollectionDTO> getProjectCollectionInvoiceAmount(@RequestParam Long projectId) {
      log.info("Api调用:查询项目的已收款和开票金额");
      return ResultBuilder.success(this.collectionInvoiceBiz.getProjectInvoiceCollection(projectId));
   }

   @ApiOperation("查询各项数据合计金额")
   @GetMapping("/getLedgerSum")
   public ResultVO<ContractProjectLedgerSumDTO> getLedgerSum(ProjectLedgerQueryDTOParam param) {
      log.info("API 调用 ：获取各项数据合计金额");
      return ResultBuilder.success(this.collectionInvoiceBiz.getProjectSum(param));
   }

   @ApiOperation("发生额记录")
   @GetMapping("/happened/record")
   @PreAuthorize("@permission.check('contract_ledger:amountLog')")
   public ResultVO listRecord(
      @RequestParam Long projectId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用 ：发生额详情记录");
      return ResultBuilder.success(this.businessBiz.listShipByProjectId(projectId, pageNumber, pageSize));
   }

   @ApiOperation(value = "获取项目树列表", notes = "项目-单体-区域")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "status", value = "项目状态:1：进行中，2：已被暂停  4已完工", paramType = "query"),
            @ApiImplicitParam(name = "settlementStatus", value = "结算状态:1:已结算，0未结算", paramType = "query"),
            @ApiImplicitParam(name = "projectType", value = "项目类型: 1建筑钢结构 2桥梁钢结构 4立体停车库 8围护", paramType = "query"),
            @ApiImplicitParam(name = "ifUserRelated", value = " true :用户关联的项目，false：所有项目", paramType = "query", defaultValue = "false"),
            @ApiImplicitParam(name = "lumpSumSystemType", value = " 包干制项目管理类型", paramType = "query", defaultValue = "0"),
            @ApiImplicitParam(name = "ifUserRelated", value = " true :用户关联的项目，false：所有项目", paramType = "query", defaultValue = "false"),
            @ApiImplicitParam(name = "level", value = " '单位层级 1:一级单位 2:二级单位", paramType = "query", defaultValue = "false")
      }
   )
   @GetMapping("/tree")
   public ResultVO<ListVO<ProjectTreeResponseVO>> listProjectTreeResponseVO(
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) Integer settlementStatus,
      @RequestParam(required = false) Integer projectType,
      @RequestParam(defaultValue = "false") Boolean ifUserRelated,
      @RequestParam(required = false) Integer lumpSumSystemType,
      @RequestParam(required = false) Integer level,
      @RequestParam(required = false) Integer productType,
      @RequestParam(defaultValue = "false") Boolean hasTask,
      @RequestParam(defaultValue = "false") Boolean hasInspectTask
   ) {
      log.info("API 调用 ：获取项目树");
      return ResultBuilder.success(
         this.monomerBiz
            .listProjectTreeResponseVO(status, settlementStatus, projectType, ifUserRelated, lumpSumSystemType, level, productType, hasTask, hasInspectTask)
      );
   }

   @ApiOperation("修改项目")
   @PutMapping("")
   public ResultVO updateProject(@RequestBody ProjectSaveDTOParam projectSaveDTOParam) {
      log.info("API 调用 ：编辑-修改项目");
      return ResultBuilder.success(this.contractProjectBiz.updateProject(projectSaveDTOParam));
   }

   @ApiOperation("修改项目状态")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = " 项目id", paramType = "path", required = true),
            @ApiImplicitParam(name = "status", value = " 1进行中，2暂停，4已完工", paramType = "path", required = true),
            @ApiImplicitParam(name = "isCheckOutFinishStatus", value = " ture 检查出库状态 false 不检查", paramType = "query", defaultValue = "false", required = true)
      }
   )
   @PutMapping("/{projectId}/status/{status}")
   @PreAuthorize("@permission.check('contract_project:editStatus')")
   public ResultVO setProjectStatus(
      @PathVariable Long projectId, @PathVariable Integer status, @RequestParam(defaultValue = "false") Boolean isCheckOutFinishStatus
   ) {
      log.info("API 调用 ：编辑-修改项目状态");
      return ResultBuilder.success(this.contractProjectBiz.updateProjectStatus(projectId, status, isCheckOutFinishStatus));
   }

   @ApiOperation("批量删除项目")
   @DeleteMapping("")
   @Log(module = ModuleEnum.PROJECT, name = BusinessTypeEnum.PROJECT_DELETE, type = OperationTypeEnum.DELETE, table = "b_project", dataType = ArrayList.class)
   @PreAuthorize("@permission.check('contract_project:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：批量删除项目");
      return ResultBuilder.success(this.contractProjectBiz.delete(ids));
   }

   @ApiOperation("我的项目列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "Authorization", value = "用户token", paramType = "header", required = true),
            @ApiImplicitParam(name = "status", value = "项目状态 1进行中 2暂停 4已完工", paramType = "query"),
            @ApiImplicitParam(name = "settlementStatus", value = "项目结算状态 0未结算 1已结算 ", paramType = "query"),
            @ApiImplicitParam(name = "year", value = "项目年份 例如 2021", paramType = "query"),
            @ApiImplicitParam(name = "noName", value = "编号或简称", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "条数", paramType = "query", defaultValue = "20"),
            @ApiImplicitParam(name = "level", value = " '单位层级 1:一级单位 2:二级单位", paramType = "query", defaultValue = "false")
      }
   )
   @GetMapping("/listMy")
   @PreAuthorize("@permission.check('plan_projects:get','my_project:get','buildingChart','bridgeChart')")
   public ResultVO<PageVO<ProjectSimpleInfoDTO>> listSimpleProject(
      @RequestParam(value = "status", required = false) Integer status,
      @RequestParam(value = "noOrName", required = false) String noOrName,
      @RequestParam(value = "year", required = false) Integer year,
      @RequestParam(value = "projectType", required = false) Integer projectType,
      @RequestParam(required = false) Integer lumpSumSystemType,
      @RequestParam(required = false) Integer level,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：查询用户相关的项目列表");
      return ResultBuilder.success(this.contractProjectBiz.getMyProjects(status, noOrName, projectType, year, lumpSumSystemType, level, pageNumber, pageSize));
   }

   @ApiOperation("我的项目列表汇总")
   @GetMapping("/listMy/summary")
   @PreAuthorize("@permission.check('buildingChart','bridgeChart')")
   public ResultVO projectListMySummary(
      int year, Integer projectType, @RequestParam(required = false) Integer lumpSumSystemType, @RequestParam(required = false) Integer level
   ) {
      log.info("API 调用 ：我的项目列表");
      return ResultBuilder.success(this.projectService.projectListMySummary(year, projectType, lumpSumSystemType, level));
   }

   @ApiOperation("打印我的项目列表")
   @GetMapping("/listMy/print")
   @PreAuthorize("@permission.check('plan_projects:print','my_project:print')")
   public ResultVO printSimpleProject(
      Integer year,
      Integer status,
      Integer settlementStatus,
      String noName,
      Integer projectType,
      @RequestParam(required = false) Integer lumpSumSystemType,
      @RequestParam(required = false) Integer level
   ) {
      log.info("API 调用 ：打印我的项目列表");
      return ResultBuilder.success(this.contractProjectBiz.printMyProjects(year, status, settlementStatus, noName, projectType, lumpSumSystemType, level));
   }

   @ApiOperation("我的项目信息")
   @ApiImplicitParam(name = "year", value = "项目年份 例如 2021", paramType = "query")
   @GetMapping("/getMyProjectInfo")
   public ResultVO<ContractProjectInfoDTO> listSimpleProject(
      Integer year,
      @RequestParam(required = false) Integer projectType,
      @RequestParam(required = false) Integer lumpSumSystemType,
      @RequestParam(required = false) Integer level
   ) {
      log.info("API 调用 ：查询我的项目相关信息");
      return ResultBuilder.success(this.contractProjectBiz.getMyProjectInfo(year, projectType, lumpSumSystemType, level));
   }

   @ApiOperation("项目工价预估项目列表查询")
   @GetMapping("/project-wage-estimate-project-list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "项目年份", required = true, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "项目状态(1：进行中，4：已完工)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "serialNumberOrShortName", value = "合同编号或项目简称", paramType = "query")
      }
   )
   public ResultVO projectWageEstimateProjectList(
      @RequestParam Integer year, @RequestParam Integer status, @RequestParam(required = false) String serialNumberOrShortName
   ) {
      log.info("API 调用 ：项目工价预估项目列表查询");
      return ResultBuilder.success(this.contractProjectBiz.projectWageEstimateProjectList(year, status, serialNumberOrShortName));
   }

   @ApiOperation("项目工价预估项目数量统计查询")
   @GetMapping("/project-wage-estimate-project-quantity-statistics")
   @ApiImplicitParams(@ApiImplicitParam(name = "year", value = "项目年份", required = true, paramType = "query"))
   public ResultVO projectWageEstimateProjectQuantityStatistics(@RequestParam Integer year) {
      log.info("API 调用 ：项目工价预估项目数量统计查询");
      return ResultBuilder.success(this.contractProjectBiz.projectWageEstimateProjectQuantityStatistics(year));
   }

   @ApiOperation(value = "根据人员查询项目列表", notes = "根据人员查询项目列表:必传userId，可传status。查询用户对应的完成和未完成的项目")
   @GetMapping("/listAllProject/user")
   @PreAuthorize("@permission.check('contract_project:get', 'person_bound_project:get')")
   public ResultVO<Map<String, List<ContractProjectListForUserDTO>>> listProjectByUser(ProjectListQueryParam projectListQueryParam) {
      log.info("API 调用 ：根据人员查询项目列表");
      return ResultBuilder.success(this.contractProjectBiz.listProjectByUser(projectListQueryParam));
   }

   @ApiOperation(value = "根据人员添加和删除项目", notes = "将指定人员 添加关联项目和删除关联项目")
   @PostMapping("/listAllProject/userUpdateProject")
   @PreAuthorize("@permission.check('person_bound_project:submit', 'contract_project:editMember')")
   public ResultVO userUpdateProject(@RequestBody ProjectUserUpdateParam projectUserUpdateParam) {
      log.info("API 调用 ：根据人员添加和删除项目");
      return ResultBuilder.success(this.contractProjectBiz.userUpdateProject(projectUserUpdateParam));
   }

   @ApiOperation("根据筛选计算主子合同金额汇总")
   @GetMapping("/get/contract/amount/sum")
   public ResultVO getContractAmountSum(ProjectListQueryParam queryParam) {
      return ResultBuilder.success(this.contractProjectBiz.getContractAmountSum(queryParam));
   }

   @ApiOperation("中南定制(合同导入模板下载)")
   @GetMapping("/down/load/import/project/template")
   public void downLoadImportProjectTemplate(HttpServletResponse response) {
      log.info("API调用:中南定制(合同导入模板下载)");
      this.contractProjectBiz.downLoadImportProjectTemplate(response);
   }

   @ApiOperation("中南定制(合同批量导入)")
   @PostMapping("/import/project")
   public void importProject(@RequestParam MultipartFile file, HttpServletResponse response) {
      log.info("API调用:中南定制(合同批量导入)");
      this.contractProjectBiz.importProject(file, response);
   }
}
