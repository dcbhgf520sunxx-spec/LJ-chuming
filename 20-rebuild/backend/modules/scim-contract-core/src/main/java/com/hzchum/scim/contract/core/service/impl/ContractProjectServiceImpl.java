package com.hzchum.scim.contract.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectsTreeDTO;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ContractAttachmentTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ContractTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ReportMethodEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractInvoiceCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectListForUserDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractBusinessDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractBusinessDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.business.ContractLedgerSimpleDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractProjectFinanceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAbleCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAbleCollectionStatisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAnalysisDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectAnalysisSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectExecuteStateDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectFeedingStateDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectOrderStatisticsDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectProductionMeteDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectInstallDivideMethodDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectInstallReportMethodDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ContractProjectFilesParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectLedgerQueryDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.project.ProjectListQueryParam;
import com.hzchum.scim.contract.core.api.pojo.vo.largeScreen.ProjectDataVO;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractVisaService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.mapper.ContractProjectMapper;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageCostSummaryValueDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.DateMeteDTO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.SysSteelAnalysisBiz;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomerDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailDto;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosurePlanDetailQureyDto;
import com.hzchum.scim.plan.core.api.pojo.dto.TechnologyDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupByProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.steel.SteelAnalysisDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerDetailService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectConfigVO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractProjectServiceImpl extends ServiceImpl<ContractProjectMapper, ContractProject> implements ContractProjectService {
   private static final Logger log = LoggerFactory.getLogger(ContractProjectServiceImpl.class);
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ContractAuditLedgerService auditLedgerService;
   @Autowired
   private ContractVisaService visaService;
   @Autowired
   private PlanMonomerDetailService planMonomerDetailService;
   @Autowired
   private TechArtifactService techArtifactService;
   @Autowired
   private MesBuildingCompleteService mesBuildingCompleteService;
   @Autowired
   private MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService;
   @Autowired
   private PlanMonomerService planMonomerService;
   @Autowired
   private PlanAreaService planAreaService;
   @Autowired
   private MesBuildingCargoListService mesBuildingCargoListService;
   @Autowired
   private SysSteelAnalysisBiz sysSteelAnalysisBiz;
   @Resource
   private ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private ReportService reportService;
   @Autowired
   private ConfigService configService;
   private ContractProjectContentService projectContentService;

   @Override
   public List<ContractProject> listProjectFiles(Long projectId, Long userId, ContractProjectFilesParam contractProjectFilesParam) {
      return this.baseMapper.listProjectFiles(userId, projectId, contractProjectFilesParam);
   }

   @Override
   public List<Map<String, Object>> selectAttachmentTypeList() {
      List<Map<String, Object>> attachmentTypeList = new ArrayList<>();
      ContractAttachmentTypeEnum[] values = ContractAttachmentTypeEnum.values();

      for (ContractAttachmentTypeEnum typeEnum : values) {
         Map<String, Object> map = new HashMap<>();
         map.put("type", typeEnum.getTypeNum());
         map.put("name", typeEnum.getDesc());
         attachmentTypeList.add(map);
      }

      return attachmentTypeList;
   }

   @Override
   public List<ContractProjectListDTO> listProjectsByConditions(ProjectListQueryParam queryParam) {
      return this.baseMapper.selectProjectsByConditions(queryParam);
   }

   @Override
   public List<ContractProjectListForUserDTO> listProjectsByIdOrName(ProjectListQueryParam queryParam) {
      return this.baseMapper.selectProjectsByIdOrName(queryParam);
   }

   @Override
   public Map<String, Integer> getOutFinishCount() {
      Integer count = this.baseMapper
         .selectCount(
            (Wrapper<ContractProject>)(Wrappers.<ContractProject>lambdaQuery().eq(ContractProject::getOutFinishStatus, 1))
               .eq(ContractProject::getStatus, ProjectStatusEnum.PROCESSING.getType())
         );
      Map<String, Integer> countMap = new HashMap<>();
      countMap.put("outFinishCount", count);
      return countMap;
   }

   @Override
   public BigDecimal getContractAmountSum(Integer projectType, Integer year, Integer status) {
      return this.baseMapper.selectContractAmountSum(projectType, year, status);
   }

   @Override
   public List<Map<String, Object>> selectAllProject() {
      List<ContractProject> contractProjects = this.baseMapper.selectList(null);
      List<Map<String, Object>> mapList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(contractProjects)) {
         contractProjects.forEach(p -> {
            Map<String, Object> map = new HashMap<>();
            map.put("projectId", p.getId());
            map.put("projectName", p.getShortName());
            mapList.add(map);
         });
      }

      return mapList;
   }

   @Override
   public ListVO<ProjectSimpleInfoDTO> listSimpleProject(Integer projectType, Integer businessType, Integer lumpSumSystemType, Integer level) {
      SecurityUser user = UserUtil.getCurrentUser();
      List<ProjectSimpleInfoDTO> simpleInfoDTOList;
      if (user.isAdmin()) {
         simpleInfoDTOList = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(ContractProject.class)
                  .apply(projectType != null, "project_type & {0}", projectType)
                  .eq(businessType != null, ContractProject::getBusinessType, businessType)
                  .apply(projectType != null, "project_type & {0}", projectType)
                  .apply(level != null, "level & {0}", level)
                  .apply(lumpSumSystemType != null, "lump_sum_system_type & {0}", lumpSumSystemType)
                  .orderByDesc(ContractProject::getId)
            )
            .stream()
            .map(s -> BeanUtil.copy(s, ProjectSimpleInfoDTO.class))
            .collect(Collectors.toList());
      } else {
         List<Long> projectIds = this.baseMapper.selectProjectIdsByUserId(user.getId(), level);
         if (projectIds.isEmpty()) {
            simpleInfoDTOList = Collections.emptyList();
         } else {
            simpleInfoDTOList = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(ContractProject.class)
                     .apply(projectType != null, "project_type & {0}", projectType)
                     .eq(businessType != null, ContractProject::getBusinessType, businessType)
                     .in(ContractProject::getId, projectIds)
                     .apply(level != null, "level & {0}", level)
                     .apply(projectType != null, "project_type & {0}", projectType)
                     .apply(lumpSumSystemType != null, "lump_sum_system_type & {0}", lumpSumSystemType)
                     .orderByDesc(ContractProject::getId)
               )
               .stream()
               .map(s -> BeanUtil.copy(s, ProjectSimpleInfoDTO.class))
               .collect(Collectors.toList());
         }
      }

      return new ListVO<>(simpleInfoDTOList);
   }

   @Override
   public List<Long> listProjectIdByUser(Long userId, Integer level) {
      return this.baseMapper.selectProjectIdsByUserId(userId, level);
   }

   @Override
   public ContractProject checkProjectStatus(Long projectId) {
      ContractProject project = this.baseMapper.selectById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      Preconditions.checkArgument(SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "项目已结算!");
      int count = this.auditLedgerService
         .count(
            Wrappers.lambdaQuery(ContractAuditLedger.class)
               .eq(ContractAuditLedger::getPaymentEnum, AuditPaymentEnum.PROJECT_SETTLEMENT.getType())
               .eq(ContractAuditLedger::getProjectId, projectId)
               .eq(ContractAuditLedger::getAuditStatusEnum, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "项目正在结算中!");
      Preconditions.checkArgument(ProjectStatusEnum.PROCESSING.getType().equals(project.getStatus()), "项目已暂停或者已完工!");
      return project;
   }

   @Override
   public ContractProject packageAndCargoListcheckProjectStatus(Long projectId) {
      ContractProject project = this.baseMapper.selectById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在！");
      Preconditions.checkArgument(!ProjectStatusEnum.PAUSE.getType().equals(project.getStatus()), "项目已暂停!");
      return project;
   }

   @Override
   public ProjectInfo getSimpleById(Long id) {
      return this.baseMapper.getProjectInfoById(id);
   }

   @Cacheable(cacheNames = "project", key = "#id", unless = "#result == null")
   @Override
   public ProjectInfo getByIdFromCache(Long id) {
      return this.baseMapper.getProjectInfoById(id);
   }

   @CachePut(cacheNames = "project", key = "#project.id")
   @Override
   public ProjectInfo updateWithCache(ContractProject project) {
      this.baseMapper.updateById(project);
      return BeanUtil.copy(project, ProjectInfo.class);
   }

   @CachePut(cacheNames = "project", key = "#project.id")
   @Override
   public ProjectInfo saveWithCache(ContractProject project) {
      this.baseMapper.insert(project);
      return BeanUtil.copy(project, ProjectInfo.class);
   }

   @CacheEvict(cacheNames = "project", key = "#id")
   @Override
   public int deleteWithCache(Long id) {
      return this.baseMapper.deleteById(id);
   }

   @Override
   public List<ProjectInfo> listByIds(String projectIds) {
      if (StringUtils.isBlank(projectIds)) {
         return new ArrayList<>();
      }

      List<Long> idList = Arrays.stream(StringUtils.split(projectIds, ",")).map(Long::parseLong).collect(Collectors.toList());
      return this.listSimpleByIdList(idList);
   }

   @Override
   public List<ProjectInfo> listSimpleByIdList(Collection<Long> idList) {
      return CollectionUtils.isEmpty(idList)
         ? new ArrayList<>()
         : this.baseMapper.selectBatchIds(idList).stream().map(s -> BeanUtil.copy(s, ProjectInfo.class)).collect(Collectors.toList());
   }

   @Override
   public List<ContractProject> listTree(Long userId, Integer status, Integer settlementStatus, Integer projectType, Integer lumpSumSystemType, Integer level) {
      return this.baseMapper.selectListProject(userId, status, settlementStatus, projectType, lumpSumSystemType, level);
   }

   @Override
   public List<ContractProject> listByCondition(ProjectDTOParam param) {
      param.setUserId(UserUtil.getCurrentUserId());
      return this.baseMapper.listByCondition(param);
   }

   @Override
   public List<ContractProjectLedgerDTO> listProjectLedger(ProjectLedgerQueryDTOParam queryDTOParam) {
      return this.baseMapper.selectProjectLedgerList(queryDTOParam);
   }

   @Override
   public List<ProjectSimpleInfoDTO> listMyProject(
      Integer status, Integer settlementStatus, Integer year, String noName, Integer projectType, Integer lumpSumSystemType, Integer level
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      List<ProjectSimpleInfoDTO> projectDTOList;
      if (user.isAdmin()) {
         projectDTOList = this.baseMapper.selectMyProjectList(null, status, settlementStatus, year, noName, projectType, lumpSumSystemType, level);
      } else {
         projectDTOList = this.baseMapper.selectMyProjectList(user.getId(), status, settlementStatus, year, noName, projectType, lumpSumSystemType, level);
      }

      return projectDTOList;
   }

   @Override
   public Integer getProjectMode(Long projectId) {
      Preconditions.checkArgument(projectId != null, "项目id为空!");
      ContractProject project = this.baseMapper.selectById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      return project.getMode();
   }

   @Override
   public ListVO<ContractBusinessDTO> customerTransactionSummary(String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate) {
      List<Long> projectIds = this.listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      return projectIds.size() == 0
         ? new ListVO<>()
         : new ListVO<>(this.baseMapper.customerTransactionSummary(name, businessType, startDate, endDate, projectIds));
   }

   @Override
   public PageVO<ContractBusinessDTO> customerTransactionSummaryPage(
      String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize, List<String> sortList
   ) {
      List<Long> projectIds = this.listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollUtil.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      Page page = PageHelper.startPage(pageNumber, pageSize, com.hzchum.pangu.common.util.StringUtils.analyzeSortConditions(sortList));
      List<ContractBusinessDTO> dtoList = this.baseMapper.customerTransactionSummary(name, businessType, startDate, endDate, projectIds);
      return new PageVO<>(page, dtoList);
   }

   private List<Long> customerTransactionProjectIds() {
      return this.listSimpleProject(null, null, null, null).getContent().stream()
         .map(ProjectSimpleInfoDTO::getId).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printCustomerTransactionSummary(String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (businessType != null) {
         header.put("businessType", ProjectBusinessTypeEnum.getNameByType(businessType));
      }

      String date = startDate != null && endDate != null ? DateTimeUtil.getLocalDateStr(startDate) + "-" + DateTimeUtil.getLocalDateStr(endDate) : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      List<Long> projectIds = this.customerTransactionProjectIds();
      printVO.setTable(projectIds.isEmpty() ? new ArrayList<>() : this.baseMapper
         .customerTransactionSummary(name, businessType, startDate, endDate, projectIds).stream()
         .map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public ListVO<ContractBusinessDetailDTO> customerTransactionDetail(String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate) {
      List<Long> projectIds = this.customerTransactionProjectIds();
      return new ListVO<>(projectIds.isEmpty() ? new ArrayList<>() :
         this.baseMapper.customerTransactionDetail(name, businessType, startDate, endDate, projectIds));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printCustomerTransactionDetail(String name, Integer businessType, LocalDateTime startDate, LocalDateTime endDate) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("name", name);
      String date = startDate != null && endDate != null ? DateTimeUtil.getLocalDateStr(startDate) + "-" + DateTimeUtil.getLocalDateStr(endDate) : "全部";
      header.put("date", date);
      List<Long> projectIds = this.customerTransactionProjectIds();
      List<ContractBusinessDetailDTO> result = projectIds.isEmpty() ? new ArrayList<>() :
         this.baseMapper.customerTransactionDetail(name, businessType, startDate, endDate, projectIds);
      List<Map<String, Object>> table = result.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      BigDecimal contractAmount = result.stream().map(ContractBusinessDetailDTO::getContractAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal settlementAmount = result.stream()
         .map(e -> e.getSettlementAmount() == null ? BigDecimal.ZERO : e.getSettlementAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("totalContractAmount", contractAmount);
      header.put("totalSettlementAmount", settlementAmount);
      header.put("businessType", businessType);
      header.put("quantity", result.size());
      printVO.setHeader(header);
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public List<ContractLedgerSimpleDTO> listSalesLedger(
      Long userId, Integer year, Integer projectStatus, String name, Integer orderSourceType, Integer productType
   ) {
      return this.baseMapper.selectListSalesLedger(userId, year, projectStatus, name, orderSourceType, productType);
   }

   @Override
   public List<ContractProjectOrderDTO> listProjectOrderCount(LocalDateTime dateTime) {
      return this.baseMapper.listProjectOrderCount(dateTime);
   }

   @Override
   public ProjectAbleCollectionStatisticsDTO getAbleCollectionStatistics(Integer type) {
      Preconditions.checkArgument(type != null, "参数不能为空");
      return this.baseMapper.selectAbleCollectionStatistics(type);
   }

   @Override
   public List<ProjectAbleCollectionDTO> listAbleCollection(Integer type) {
      return this.baseMapper.selectAbleCollection(type);
   }

   @Override
   public ProjectOrderStatisticsDTO getStatistics(Integer year, Integer productType, Integer lumpSumSystemType) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      ProjectDTOParam param = new ProjectDTOParam();
      if (year != null) {
         param.setYear(String.valueOf(year));
      }

      param.setProjectType(productType);
      param.setLumpSumSystemType(lumpSumSystemType);
      List<ContractProject> projectList = this.baseMapper.listByCondition(param);
      if (!currentUser.isAdmin()) {
         param.setUserId(currentUser.getId());
         projectList = this.baseMapper.listByCondition(param);
      }

      projectList = projectList.stream()
         .filter(p -> p.getContractType() != null && !p.getContractType().equals(ContractTypeEnum.REPLENISHMENT_CONTRACT.getType()))
         .collect(Collectors.toList());
      return ProjectOrderStatisticsDTO.builder()
         .sumQuantity(projectList.size())
         .selfSupportQuantity(projectList.stream().filter(p -> p.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())).count())
         .jointVentureQuantity(projectList.stream().filter(p -> p.getProjectAttribute().equals(ProjectAttributeEnum.JOINT_VENTURE.getType())).count())
         .lumpSumSystemQuantity(projectList.stream().filter(p -> p.getProjectAttribute().equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())).count())
         .processingQuantity(projectList.stream().filter(p -> p.getStatus().equals(ProjectStatusEnum.PROCESSING.getType())).count())
         .completedQuantity(projectList.stream().filter(p -> p.getStatus().equals(ProjectStatusEnum.COMPLETED.getType())).count())
         .settlementQuantity(projectList.stream().filter(p -> p.getSettlementStatus().equals(1)).count())
         .contractAmount(projectList.stream().map(ContractProject::getContractAmount).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
   }

   @Override
   public List<ContractProject> costAnalysis(Integer settlementStatus, Integer status) {
      return this.baseMapper.costAnalysis(settlementStatus, status);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateInstallReportMethod(ProjectInstallReportMethodDTOParam param) {
      ContractProject project = this.checkProjectStatus(param.getProjectId());
      if (!param.getReportMethod().equals(project.getInstallReportMethod())) {
         if (ReportMethodEnum.PC.getType().equals(param.getReportMethod())) {
            Long count = this.baseMapper.UnAuditReport(project.getId());
            Preconditions.checkArgument(count == 0L, "操作失败!,请审核所有app安装上报的产品后切换!");
         }

         project.setInstallReportMethod(param.getReportMethod());
         this.baseMapper.updateById(project);
         this.redisUtils.del("simpleProjectList");
         return true;
      } else {
         return true;
      }
   }

   @Override
   public List<ProjectSimpleInfoDTO> projectSummaryYear(LocalDateTime date, Integer status, String name, List<Long> projectIds, Integer projectType) {
      return this.baseMapper.projectSummaryYear(date, status, name, projectIds, projectType);
   }

   @Override
   public List<ContractProjectFinanceDTO> listProjectFinancialStatement(
      Integer year, Long projectId, Integer businessType, Integer projectType, Integer orderSourceType, Integer status, Integer settlementStatus
   ) {
      return this.baseMapper.selectProjectFinancialStatement(year, projectId, businessType, projectType, orderSourceType, status, settlementStatus);
   }

   @Override
   public Map<String, Long> projectListMySummary(int year, Integer projectType, Integer lumpSumSystemType, Integer level) {
      projectType = projectType == null ? ProjectTypeEnum.MES.getType() | ProjectTypeEnum.BRIDGE.getType() : projectType;
      Map<String, Long> map = new HashMap<>();
      List<ProjectSimpleInfoDTO> content = this.baseMapper.selectMyProjectList(null, null, null, year, null, projectType, lumpSumSystemType, level);
      map.put("total", content.stream().count());
      map.put("processing", content.stream().filter(e -> e.getStatus().equals(1)).count());
      map.put("completed", content.stream().filter(e -> e.getSettlementStatus().equals(0)).filter(e -> e.getStatus().equals(4)).count());
      map.put("settled", content.stream().filter(e -> e.getSettlementStatus().equals(1)).count());
      return map;
   }

   @Override
   public List<ProjectDetailDO> getMachinePartTaskprojectList(Set<Long> cutIds, LocalDateTime localDateTime, String serialNumber, List<Long> projectIds) {
      return this.baseMapper.getMachinePartTaskprojectList(cutIds, localDateTime, serialNumber, projectIds);
   }

   @Override
   public List<ContractProject> listBytimeAndName(LocalDateTime startDate, LocalDateTime endDate, String name) {
      return this.baseMapper.listBytimeAndName(startDate, endDate, name);
   }

   @Override
   public List<ContractProject> taskOrderProjectList(List<Long> taskOrderIds, Integer type) {
      return this.baseMapper.taskOrderProjectList(taskOrderIds, type);
   }

   @Override
   public Map<String, Object> projectSummaryInfo() {
      List<ContractProject> yearProjectList = this.list(
         (Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", new Date())
      );
      BigDecimal yearProjectMete = BigDecimal.ZERO;

      for (ContractProject project : yearProjectList) {
         yearProjectMete = this.planMonomerDetailService
            .list((Wrapper<PlanMonomerDetail>)new LambdaQueryWrapper<PlanMonomerDetail>().eq(PlanMonomerDetail::getProjectId, project.getId()))
            .stream()
            .map(PlanMonomerDetail::getMete)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
      }

      List<ContractProject> list = this.list();
      List<ContractProject> processingList = list.stream()
         .filter(e -> e.getStatus().equals(ProjectStatusEnum.PROCESSING.getType()))
         .collect(Collectors.toList());
      List<ContractProject> pauseList = list.stream().filter(e -> e.getStatus().equals(ProjectStatusEnum.PAUSE.getType())).collect(Collectors.toList());
      List<ContractProject> completedList = list.stream().filter(e -> e.getStatus().equals(ProjectStatusEnum.COMPLETED.getType())).collect(Collectors.toList());
      Map<String, Object> map = new HashMap<>();
      map.put("yearProjectCount", yearProjectList.size());
      map.put("yearProjectMete", yearProjectMete);
      map.put("totalProjectCount", list.size());
      map.put("processingCount", processingList.size());
      map.put("pauseCount", pauseList.size());
      map.put("completedCount", completedList.size());
      return map;
   }

   @Override
   public List<ProjectDataVO> projectList() {
      List<ContractProject> yearProjectList = this.list(
         (Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().apply("date_format(create_time, '%Y') = date_format({0}, '%Y')", new Date())
      );
      List<ProjectDataVO> listVO = new ArrayList<>();

      for (ContractProject project : yearProjectList) {
         BigDecimal inventoryTon = this.techArtifactService.sumTnventoryTon(project.getId());
         BigDecimal produceTon = this.mesBuildingCompleteService.sumProduceTon(project.getId());
         BigDecimal produceRate = BigDecimal.ZERO;
         if (produceTon.compareTo(BigDecimal.ZERO) != 0 && inventoryTon.compareTo(BigDecimal.ZERO) != 0) {
            produceRate = NumberUtil.round(NumberUtil.div(produceTon, inventoryTon), 2);
         }

         BigDecimal outTon = this.mesBuildingWarehouseSummaryService.sumOutTon(project.getId());
         BigDecimal outRate = BigDecimal.ZERO;
         if (outTon.compareTo(BigDecimal.ZERO) != 0 && inventoryTon.compareTo(BigDecimal.ZERO) != 0) {
            outRate = NumberUtil.round(NumberUtil.div(outTon, inventoryTon), 2);
         }

         ProjectDataVO vo = new ProjectDataVO();
         vo.setId(project.getId());
         vo.setProjectName(project.getName());
         vo.setInventoryTon(inventoryTon);
         vo.setProduceTon(produceTon);
         vo.setProduceRate(produceRate);
         vo.setOutTon(outTon);
         vo.setOutRate(outRate);
         listVO.add(vo);
      }

      return listVO;
   }

   @Override
   public Map<String, Object> projectInfo(Long projectId) {
      ContractProject project = this.getById(projectId);
      ZonedDateTime zdt1 = project.getStartDate().atStartOfDay(ZoneId.systemDefault());
      ZonedDateTime zdt2 = project.getEndDate().atStartOfDay(ZoneId.systemDefault());
      Date startDate = Date.from(zdt1.toInstant());
      Date endDate = Date.from(zdt2.toInstant());
      long completeday = 0L;
      if (project.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())) {
         ZonedDateTime zdt3 = project.getCompleteDate().atStartOfDay(ZoneId.systemDefault());
         Date completeDate = Date.from(zdt3.toInstant());
         boolean bool = project.getCompleteDate().isAfter(LocalDate.now());
         if (bool) {
            completeday = DateUtil.between(completeDate, new Date(), DateUnit.DAY);
         } else {
            completeday = DateUtil.between(startDate, completeDate, DateUnit.DAY);
         }
      }

      Long planDay = DateUtil.between(startDate, endDate, DateUnit.DAY);
      int monomerCount = this.planMonomerService.count((Wrapper<PlanMonomer>)new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, projectId));
      int areaCount = this.planAreaService.count((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getProjectId, projectId));
      int carCount = this.mesBuildingCargoListService
         .count(
            (Wrapper<MesBuildingCargoList>)(new LambdaQueryWrapper<MesBuildingCargoList>().eq(MesBuildingCargoList::getProjectId, projectId))
               .eq(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType())
         );
      List<SteelAnalysisDTO> analysis = this.sysSteelAnalysisBiz.analysis(projectId, null, null, null).getContent();
      BigDecimal useMete = analysis.stream().map(SteelAnalysisDTO::getUseMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      HashMap<String, Object> map = new HashMap<>();
      map.put("planDay", planDay);
      map.put("completeday", completeday);
      map.put("monomerCount", monomerCount);
      map.put("areaCount", areaCount);
      map.put("carCount", carCount);
      map.put("useMete", useMete);
      return map;
   }

   @Override
   public List<EnclosurePlanDetailDto> queryEnclosurePlan(EnclosurePlanDetailQureyDto dto, List<Long> projectIds) {
      return this.baseMapper.queryEnclosurePlan(dto, projectIds);
   }

   @Override
   public List<ProjectInfo> listInfoByIdList(Collection<Long> idList) {
      return CollectionUtils.isEmpty(idList) ? new ArrayList<>(16) : this.baseMapper.selectInfoByIdList(idList);
   }

   @Override
   public ContractInvoiceCollectionDTO getProjectCollectionVoiceInfo(Long projectId) {
      ContractProject project = this.baseMapper.selectById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      return ContractInvoiceCollectionDTO.builder().collectionAmount(project.getCollectionAmount()).invoiceAmount(project.getInvoiceAmount()).build();
   }

   @Override
   public List<String> selectSql(String areaName) {
      return this.baseMapper.selectSql(areaName);
   }

   @Override
   public void updateSql(String areaName) {
      this.baseMapper.updateSql(areaName);
   }

   @Override
   public List<ProjectInfo> getSimpleByIds(List<Long> projectIds) {
      return CollectionUtils.isEmpty(projectIds) ? new ArrayList<>() : this.baseMapper.getProjectInfoByIds(projectIds);
   }

   @Override
   public List<ContractProject> listWastage(Integer year, Integer status, List<Long> projectIds) {
      return this.baseMapper.listWastage(year, status, projectIds);
   }

   @Override
   public List<ProjectLedgerDTO> projectLedgerList(ProjectLedgerDtoParam param) {
      return this.baseMapper.projectLedgerList(param);
   }

   @Override
   public List<TechnologyDTO> pageByYearAndName(Integer year, String name, Integer projectType, Integer lumpSumSystemType, Long userId) {
      return this.baseMapper.pageByYearAndName(year, name, projectType, lumpSumSystemType, userId);
   }

   @Override
   public List<ProjectSimpleInfoDTO> selectContractProjects(
      Integer status, String noOrName, LocalDate firstDayOfYear, LocalDate lastDayOfYear, Integer projectType, Integer lumpSumSystemType, Long userId
   ) {
      return this.baseMapper.selectContractProjects(status, noOrName, firstDayOfYear, lastDayOfYear, projectType, lumpSumSystemType, userId);
   }

   @Override
   public List<ContractProject> selectContractProjectList(List<Long> combinedIds, Long aLong) {
      return this.baseMapper.selectContractProjectList(combinedIds, aLong);
   }

   @Override
   public List<ProjectsTreeDTO> findProjectTreeByProjectId(List<Long> projectIds, Long workShopId, LocalDateTime dateTime) {
      return this.baseMapper.findProjectTreeByProjectid(projectIds, workShopId, dateTime);
   }

   @Override
   public void checkContractSignBodyId(Long projectId, List<Long> projectIdList, String projectIds, Long contractSignBodyId) {
      if (ObjectUtil.isEmpty(projectId) && CollectionUtils.isEmpty(projectIdList) && ObjectUtil.isEmpty(projectIds)) {
         Preconditions.checkArgument(false, "请至少传一个项目ID信息");
      }

      if (ObjectUtil.isNotEmpty(projectId)) {
         List<ProjectBranchCompanyLink> projectBranchCompanyLinks = this.projectBranchCompanyLinkService
            .list((Wrapper<ProjectBranchCompanyLink>)new LambdaQueryWrapper<ProjectBranchCompanyLink>().eq(ProjectBranchCompanyLink::getProjectId, projectId));
         List<ProjectBranchCompanyLink> collect = projectBranchCompanyLinks.stream()
            .filter(p -> p.getBranchCompanyId().equals(contractSignBodyId))
            .collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(collect), "所选择项目的签订主体与所传签订主体不符，请刷新页面重试！！！");
      }

      if (CollectionUtils.isNotEmpty(projectIdList)) {
         List<ProjectBranchCompanyLink> projectBranchCompanyLinks = this.projectBranchCompanyLinkService
            .list((Wrapper<ProjectBranchCompanyLink>)new LambdaQueryWrapper<ProjectBranchCompanyLink>().in(ProjectBranchCompanyLink::getProjectId, projectIdList));

         for (Long l : projectIdList) {
            List<ProjectBranchCompanyLink> collect = projectBranchCompanyLinks.stream().filter(p -> p.getProjectId().equals(l)).collect(Collectors.toList());
            List<ProjectBranchCompanyLink> collect1 = collect.stream()
               .filter(c -> c.getBranchCompanyId().equals(contractSignBodyId))
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(collect1), "所选择项目的签订主体与所传签订主体不符，请刷新页面重试！！！");
         }
      }

      if (ObjectUtil.isNotEmpty(projectIds)) {
         List<Long> idList = Arrays.stream(projectIds.split(",")).map(Long::valueOf).collect(Collectors.toList());
         List<ProjectBranchCompanyLink> projectBranchCompanyLinks = this.projectBranchCompanyLinkService
            .list((Wrapper<ProjectBranchCompanyLink>)new LambdaQueryWrapper<ProjectBranchCompanyLink>().in(ProjectBranchCompanyLink::getProjectId, idList));

         for (Long l : idList) {
            List<ProjectBranchCompanyLink> collect = projectBranchCompanyLinks.stream().filter(p -> p.getProjectId().equals(l)).collect(Collectors.toList());
            List<ProjectBranchCompanyLink> collect1 = collect.stream()
               .filter(c -> c.getBranchCompanyId().equals(contractSignBodyId))
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(collect1), "所选择项目的签订主体与所传签订主体不符，请刷新页面重试！！！");
         }
      }
   }

   @Override
   public Boolean updateInstallDivideMethod(ProjectInstallDivideMethodDTOParam param) {
      ContractProject project = this.checkProjectStatus(param.getProjectId());
      Preconditions.checkArgument(project.getInstallDivideMethod() == null, "操作失败！安装产品划分方式，确认后不能修改！");
      if (!param.getDivideMethod().equals(project.getInstallDivideMethod())) {
         project.setInstallDivideMethod(param.getDivideMethod());
         this.baseMapper.updateById(project);
         this.redisUtils.del("simpleProjectList");
         return true;
      } else {
         return true;
      }
   }

   @Override
   public List<ContractProject> wastageLossProjectList(Integer year, Integer status, List<Long> projectIds) {
      return this.baseMapper.wastageLossProjectList(year, status, projectIds);
   }

   @Override
   public ProjectAnalysisSummaryDTO getProjectSummaryDTO(LocalDate yearDate, Long branchCompanyId) {
      List<ContractProject> projectList = this.baseMapper.getProjectList(yearDate, Boolean.TRUE, null, branchCompanyId);
      BigDecimal contractAmount = projectList.stream().map(ContractProject::getContractAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      Map<Long, BigDecimal> deepMeteMap = this.artifactService
         .sumMeteGroupByProject(null)
         .stream()
         .collect(Collectors.toMap(ProductMeteGroupByProjectDTO::getProjectId, ProductMeteGroupByProjectDTO::getMete));
      BigDecimal deepMete = projectList.stream().map(e -> deepMeteMap.getOrDefault(e.getId(), BigDecimal.ZERO)).reduce(BigDecimal.ZERO, BigDecimal::add);
      return ProjectAnalysisSummaryDTO.builder().contractQuantity(projectList.size()).contractAmount(contractAmount).deepMete(deepMete).build();
   }

   @Override
   public List<ProjectAnalysisSummaryDTO> getGroupProjectDTO(LocalDate yearDate, Long branchCompanyId) {
      List<ContractProject> projectList = this.baseMapper.getProjectList(yearDate, Boolean.TRUE, null, branchCompanyId);
      Map<Long, BigDecimal> deepMeteMap = this.artifactService
         .sumMeteGroupByProject(null)
         .stream()
         .collect(Collectors.toMap(ProductMeteGroupByProjectDTO::getProjectId, ProductMeteGroupByProjectDTO::getMete));
      Map<Integer, List<ContractProject>> groupedByBusinessType = projectList.stream().collect(Collectors.groupingBy(ContractProject::getBusinessType));
      List<ProjectAnalysisSummaryDTO> result = new ArrayList<>();
      groupedByBusinessType.forEach(
         (businessType, projects) -> {
            BigDecimal deepMete = projects.stream().map(e -> deepMeteMap.getOrDefault(e.getId(), BigDecimal.ZERO)).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal contractAmount = projects.stream().map(ContractProject::getContractAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            result.add(
               ProjectAnalysisSummaryDTO.builder()
                  .businessType(businessType)
                  .contractQuantity(projects.size())
                  .contractAmount(contractAmount)
                  .deepMete(deepMete)
                  .build()
            );
         }
      );
      return result;
   }

   @Override
   public List<ProjectAnalysisSummaryDTO> getGroupMonthProjectDTO(LocalDate yearDate, Long branchCompanyId) {
      List<ContractProject> projectList = this.baseMapper.getProjectList(yearDate, Boolean.TRUE, null, branchCompanyId);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      Map<String, List<ContractProject>> doMap = new HashMap<>();
      Map<String, List<TechArtifact>> artifactMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(projectList)) {
         doMap = projectList.stream().collect(Collectors.groupingBy(project -> project.getCreateTime().format(formatter)));
         List<Long> projectIds = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
         List<TechArtifact> allArtifactList = this.artifactService
            .list(
               (new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getProjectId, projectIds))
                  .select(
                     BaseEntity::getCreateTime,
                     TechArtifact::getId,
                     TechArtifact::getProjectId,
                     TechArtifact::getQuantity,
                     TechArtifact::getNetWeight,
                     TechArtifact::getGrossWeight,
                     TechArtifact::getProducedQuantity
                  )
            );
         artifactMap = allArtifactList.stream().collect(Collectors.groupingBy(e -> e.getCreateTime().format(formatter)));
      }

      List<ProjectAnalysisSummaryDTO> result = new ArrayList<>();

      for (LocalDate dateTime : this.getYearMonthDateList(yearDate)) {
         String key = dateTime.format(formatter);
         ProjectAnalysisSummaryDTO build = ProjectAnalysisSummaryDTO.builder()
            .dateTime(key)
            .contractAmount(BigDecimal.ZERO)
            .contractQuantity(0)
            .deepMete(BigDecimal.ZERO)
            .build();
         if (doMap.containsKey(key)) {
            List<ContractProject> detailDOList = doMap.get(key);
            BigDecimal contractAmount = detailDOList.stream().map(ContractProject::getContractAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            build.setContractQuantity(detailDOList.size());
            build.setContractAmount(contractAmount);
         }

         if (artifactMap.containsKey(key)) {
            List<TechArtifact> detailDOList = artifactMap.get(key);
            BigDecimal totalArtifactNetWeight = detailDOList.stream()
               .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            build.setDeepMete(totalArtifactNetWeight);
         }

         result.add(build);
      }

      return result;
   }

   @Override
   public List<ProjectAnalysisDetailDTO> getGroupProjectDetailDTO(LocalDate yearDate, Integer businessType, Boolean year, Long branchCompanyId) {
      List<ContractProject> projectList = this.baseMapper.getProjectList(yearDate, year, businessType, branchCompanyId);
      return this.convertToProjectAnalysisDetailDTO(projectList);
   }

   @Override
   public void getGroupProjectDetailDTODownload(LocalDate yearDate, Boolean year, Integer businessType, Long branchCompanyId, HttpServletResponse response) {
      List<ProjectAnalysisDetailDTO> detailDTO = this.getGroupProjectDetailDTO(yearDate, businessType, year, branchCompanyId);
      if (!CollectionUtils.isEmpty(detailDTO)) {
         String title = "";
         DateTimeFormatter formatter;
         if (year) {
            formatter = DateTimeFormatter.ofPattern("yyyy");
         } else {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM");
         }

         title = title + "日期：" + yearDate.format(formatter) + "\n";
         if (branchCompanyId != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
            if (branchCompany != null) {
               title = title + "分支机构：" + branchCompany.getName() + "\n";
            }
         }

         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "立项日期"));
         headList.add(Arrays.asList(title, "项目"));
         headList.add(Arrays.asList(title, "订单类型"));
         headList.add(Arrays.asList(title, "发包单位"));
         headList.add(Arrays.asList(title, "签证主体"));
         headList.add(Arrays.asList(title, "合同额（万元）"));
         headList.add(Arrays.asList(title, "清单量（吨）"));
         List<List<Object>> dataList = new ArrayList<>();
         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         ProjectConfigVO configVO = this.configService.getProjectConfig();
         detailDTO.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            LocalDateTime createTime = ex.getCreateTime();
            data.add(createTime != null ? createTime.format(formatter2) : "-");
            String projectName;
            if (configVO.getShowProjectFullName()) {
               projectName = ex.getName();
            } else {
               projectName = ex.getShortName();
            }

            String serialNumber;
            if (configVO.getShowSerialNumber()) {
               serialNumber = ex.getSerialNumber();
            } else {
               serialNumber = "";
            }

            if (configVO.getArrangement().equals(1)) {
               data.add(serialNumber + " " + projectName);
            } else {
               data.add(projectName + " " + serialNumber);
            }

            data.add(ProjectBusinessTypeEnum.JOB.getType().equals(ex.getBusinessType()) ? "项目承包" : "加工承揽");
            data.add(ex.getCustomerUnit());
            data.add(ex.getBranchCompanyName());
            data.add(ex.getContractAmount().divide(BigDecimal.valueOf(10000L), 0, RoundingMode.HALF_UP));
            data.add(ex.getDeepMete().divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP));
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "合同统计详情表.xlsx");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            EasyExcel.write(response.getOutputStream())
               .head(headList)
               .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
               .registerWriteHandler(
                  new CellWriteHandler() {
                     @Override
                     public void beforeCellCreate(
                        WriteSheetHolder writeSheetHolder,
                        WriteTableHolder writeTableHolder,
                        Row row,
                        Head head,
                        Integer columnIndex,
                        Integer relativeRowIndex,
                        Boolean isHead
                     ) {
                        if (isHead && relativeRowIndex == 0) {
                           row.setHeight((short)550);
                        }
                     }
                  }
               )
               .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setWriteFont(new WriteFont() {
                        {
                           this.setFontName("宋体");
                           this.setFontHeightInPoints((short)10);
                           this.setBold(true);
                        }
                     });
                     this.setWrapped(true);
                     this.setShrinkToFit(true);
                  }
               }, new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setBorderBottom(BorderStyle.THIN);
                     this.setBorderLeft(BorderStyle.THIN);
                     this.setBorderRight(BorderStyle.THIN);
                     this.setBorderTop(BorderStyle.THIN);
                  }
               }))
               .sheet("合同统计详情表")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public List<ProjectAnalysisDetailDTO> getGroupProjectDeepMeteDetail(LocalDate yearDate, Long branchCompanyId) {
      List<ContractProject> projectList = this.baseMapper.getProjectList(yearDate, Boolean.TRUE, null, branchCompanyId);
      Map<String, List<TechArtifact>> artifactMap = new HashMap<>();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      if (CollectionUtils.isNotEmpty(projectList)) {
         List<Long> projectIds = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
         List<TechArtifact> allArtifactList = this.artifactService
            .list(
               (new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getProjectId, projectIds))
                  .select(
                     BaseEntity::getCreateTime,
                     TechArtifact::getId,
                     TechArtifact::getProjectId,
                     TechArtifact::getQuantity,
                     TechArtifact::getNetWeight,
                     TechArtifact::getGrossWeight,
                     TechArtifact::getProducedQuantity
                  )
            );
         artifactMap = allArtifactList.stream().collect(Collectors.groupingBy(e -> e.getCreateTime().format(formatter)));
      }

      String key = yearDate.format(formatter);
      if (!artifactMap.containsKey(key)) {
         return new ArrayList<>();
      }

      List<TechArtifact> techArtifactList = artifactMap.get(key);
      Map<Long, List<TechArtifact>> artifactProjectMap = techArtifactList.stream().collect(Collectors.groupingBy(TechArtifact::getProjectId));
      List<Long> projectIds = techArtifactList.stream().map(TechArtifact::getProjectId).distinct().collect(Collectors.toList());
      List<ContractProject> projectDOList = this.listByIds(projectIds);
      return projectDOList.stream()
         .map(
            project -> {
               ProjectAnalysisDetailDTO dto = BeanUtil.copy(project, ProjectAnalysisDetailDTO.class);
               ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
               dto.setProject(projectInfo);
               BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
               dto.setBranchCompanyName(branchCompany.getName());
               BigDecimal deepMete = artifactProjectMap.get(project.getId())
                  .stream()
                  .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               dto.setDeepMete(deepMete);
               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public void getGroupProjectDeepMeteDetailDownload(LocalDate yearDate, Long branchCompanyId, HttpServletResponse response) {
      List<ProjectAnalysisDetailDTO> detailDTO = this.getGroupProjectDeepMeteDetail(yearDate, branchCompanyId);
      if (!CollectionUtils.isEmpty(detailDTO)) {
         String title = "";
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
         title = title + "日期：" + yearDate.format(formatter) + "\n";
         if (branchCompanyId != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
            if (branchCompany != null) {
               title = title + "分支机构：" + branchCompany.getName() + "\n";
            }
         }

         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "立项日期"));
         headList.add(Arrays.asList(title, "项目"));
         headList.add(Arrays.asList(title, "订单类型"));
         headList.add(Arrays.asList(title, "发包单位"));
         headList.add(Arrays.asList(title, "签证主体"));
         headList.add(Arrays.asList(title, "合同额（万元）"));
         headList.add(Arrays.asList(title, "清单量（吨）"));
         List<List<Object>> dataList = new ArrayList<>();
         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         ProjectConfigVO configVO = this.configService.getProjectConfig();
         detailDTO.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            LocalDateTime createTime = ex.getCreateTime();
            data.add(createTime != null ? createTime.format(formatter2) : "-");
            String projectName;
            if (configVO.getShowProjectFullName()) {
               projectName = ex.getName();
            } else {
               projectName = ex.getShortName();
            }

            String serialNumber;
            if (configVO.getShowSerialNumber()) {
               serialNumber = ex.getSerialNumber();
            } else {
               serialNumber = "";
            }

            if (configVO.getArrangement().equals(1)) {
               data.add(serialNumber + " " + projectName);
            } else {
               data.add(projectName + " " + serialNumber);
            }

            data.add(ProjectBusinessTypeEnum.JOB.getType().equals(ex.getBusinessType()) ? "项目承包" : "加工承揽");
            data.add(ex.getCustomerUnit());
            data.add(ex.getBranchCompanyName());
            data.add(ex.getContractAmount().divide(BigDecimal.valueOf(10000L), 0, RoundingMode.HALF_UP));
            data.add(ex.getDeepMete().divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP));
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "合同统计详情表.xlsx");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            EasyExcel.write(response.getOutputStream())
               .head(headList)
               .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
               .registerWriteHandler(
                  new CellWriteHandler() {
                     @Override
                     public void beforeCellCreate(
                        WriteSheetHolder writeSheetHolder,
                        WriteTableHolder writeTableHolder,
                        Row row,
                        Head head,
                        Integer columnIndex,
                        Integer relativeRowIndex,
                        Boolean isHead
                     ) {
                        if (isHead && relativeRowIndex == 0) {
                           row.setHeight((short)550);
                        }
                     }
                  }
               )
               .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setWriteFont(new WriteFont() {
                        {
                           this.setFontName("宋体");
                           this.setFontHeightInPoints((short)10);
                           this.setBold(true);
                        }
                     });
                     this.setWrapped(true);
                     this.setShrinkToFit(true);
                  }
               }, new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setBorderBottom(BorderStyle.THIN);
                     this.setBorderLeft(BorderStyle.THIN);
                     this.setBorderRight(BorderStyle.THIN);
                     this.setBorderTop(BorderStyle.THIN);
                  }
               }))
               .sheet("合同统计详情表")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public PageVO<ContractProjectListDTO> listAnalysisProjects(ProjectListQueryParam queryParam, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ContractProjectListDTO> projectResponseDTOS = this.listProjectsByConditions(queryParam);
      projectResponseDTOS.forEach(
         p -> {
            p.setAlreadyDays(
               LocalDate.now().isAfter(p.getStartDate())
                  ? com.hzchum.scim.common.core.api.utils.DateTimeUtil.getBetweenDays(p.getStartDate(), LocalDate.now())
                  : 1
            );
            p.setAllDays(com.hzchum.scim.common.core.api.utils.DateTimeUtil.getBetweenDays(p.getStartDate(), p.getEndDate()));
            LambdaQueryWrapper<ContractTech> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ContractTech::getProjectId, p.getId());
         }
      );
      return new PageVO<>(page, projectResponseDTOS);
   }

   @Override
   public ProjectProductionMeteDTO getProjectProductionMete(Long projectId, Long branchCompanyId) {
      ProjectProductionMeteDTO productionSumDTO = ProjectProductionMeteDTO.builder()
         .artifactDeepMete(BigDecimal.ZERO)
         .artifactMete(BigDecimal.ZERO)
         .assembleMete(BigDecimal.ZERO)
         .partMete(BigDecimal.ZERO)
         .build();
      List<MesBuildingTask> allTaskList = this.taskService
         .list(
            (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>()
                  .in(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType(), TaskTypeEnum.ASSEMBLE.getType(), TaskTypeEnum.MACHINE_PART.getType()))
               .eq(MesBuildingTask::getProjectId, projectId)
         );
      List<TechArtifact> artifacts = this.artifactService
         .list(
            (new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getProjectId, projectId))
               .select(TechArtifact::getId, TechArtifact::getQuantity, TechArtifact::getNetWeight, TechArtifact::getTotalNetWeight)
         );
      List<TechAssemble> assembles = this.assembleService
         .list(
            (new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getProjectId, projectId))
               .select(TechAssemble::getId, TechAssemble::getQuantity, TechAssemble::getNetWeight, TechAssemble::getTotalNetWeight)
         );
      List<TechMachinePart> parts = this.machinePartService
         .list(
            (new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getProjectId, projectId))
               .select(TechMachinePart::getId, TechMachinePart::getQuantity, TechMachinePart::getNetWeight, TechMachinePart::getTotalNetWeight)
         );
      if (CollectionUtils.isNotEmpty(artifacts)) {
         BigDecimal deepMete = artifacts.stream()
            .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         productionSumDTO.setArtifactDeepMete(deepMete);
      }

      if (CollectionUtils.isNotEmpty(artifacts)) {
         BigDecimal deepMete = assembles.stream()
            .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         productionSumDTO.setAssembleDeepMete(deepMete);
      }

      if (CollectionUtils.isNotEmpty(artifacts)) {
         BigDecimal deepMete = parts.stream()
            .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         productionSumDTO.setPartDeepMete(deepMete);
      }

      if (CollectionUtils.isEmpty(allTaskList)) {
         return productionSumDTO;
      }

      Map<Integer, List<MesBuildingTask>> allTaskMap = allTaskList.stream().collect(Collectors.groupingBy(MesBuildingTask::getTaskTypeEnum));
      Map<Long, TechArtifact> artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      allTaskMap.forEach(
         (taskTypeEnum, tasks) -> {
            if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
               BigDecimal completeMete = tasks.stream()
                  .map(e -> artifactMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getCompleteQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               productionSumDTO.setArtifactMete(completeMete);
            }

            if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
               BigDecimal completeMete = tasks.stream()
                  .map(e -> assembleMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getCompleteQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               productionSumDTO.setAssembleMete(completeMete);
            }

            if (TaskTypeEnum.MACHINE_PART.getType().equals(taskTypeEnum)) {
               BigDecimal completeMete = tasks.stream()
                  .map(e -> partMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getCompleteQuantity().intValue())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               productionSumDTO.setPartMete(completeMete);
            }
         }
      );
      return productionSumDTO;
   }

   @Override
   public List<ProjectFeedingStateDTO> getProjectFeedingState(Long projectId, Long branchCompanyId, Boolean isRecently) {
      List<DateMeteDTO> productionMeteList = this.teamReportService.getProductionGroupMonth(projectId, null, null, 2);
      List<WastageCostSummaryValueDTO> returnMeteList = this.reportService.getGroupByMonthReturn(projectId);
      List<WastageCostSummaryValueDTO> outboundMeteList = this.reportService.getGroupByMonthOutbound(projectId);
      Map<String, BigDecimal> produceMeteMap = productionMeteList.stream().collect(Collectors.toMap(DateMeteDTO::getDateTime, DateMeteDTO::getMete));
      Map<String, BigDecimal> returnMeteMap = returnMeteList.stream()
         .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, WastageCostSummaryValueDTO::getProductMonthOutput));
      Map<String, BigDecimal> outboundMeteMap = outboundMeteList.stream()
         .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, WastageCostSummaryValueDTO::getProductMonthOutput));
      List<String> dateTimeList = new ArrayList<>();
      dateTimeList.addAll(produceMeteMap.keySet());
      dateTimeList.addAll(returnMeteMap.keySet());
      dateTimeList.addAll(outboundMeteMap.keySet());
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      List<LocalDate> yearMonthList = this.getFeedingMonth(dateTimeList, isRecently);
      List<ProjectFeedingStateDTO> result = new ArrayList<>();

      for (LocalDate dateTime : yearMonthList) {
         String key = dateTime.format(formatter);
         ProjectFeedingStateDTO build = ProjectFeedingStateDTO.builder()
            .dateTime(key)
            .produceMete(produceMeteMap.getOrDefault(key, BigDecimal.ZERO))
            .feedingMete(outboundMeteMap.getOrDefault(key, BigDecimal.ZERO).subtract(returnMeteMap.getOrDefault(key, BigDecimal.ZERO)).stripTrailingZeros())
            .build();
         result.add(build);
      }

      return result;
   }

   @Override
   public void getProjectFeedingStateDownload(Long projectId, Long branchCompanyId, HttpServletResponse response) {
      List<ProjectFeedingStateDTO> dtoList = this.getProjectFeedingState(projectId, branchCompanyId, Boolean.FALSE);
      if (!CollectionUtils.isEmpty(dtoList)) {
         String title = "";
         if (branchCompanyId != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
            if (branchCompany != null) {
               title = title + "分支机构：" + branchCompany.getName() + "\n";
            }
         }

         if (projectId != null) {
            ProjectInfo projectInfo = this.getSimpleById(projectId);
            if (projectInfo != null) {
               title = title + "项目：" + projectInfo.getName() + "\n";
            }
         }

         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "日期"));
         headList.add(Arrays.asList(title, "投料量"));
         headList.add(Arrays.asList(title, "产量"));
         headList.add(Arrays.asList(title, "差异"));
         List<List<Object>> dataList = new ArrayList<>();
         dtoList.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            data.add(ex.getDateTime());
            data.add(ex.getFeedingMete().divide(BigDecimal.valueOf(1000L), 3, 4));
            data.add(ex.getProduceMete().divide(BigDecimal.valueOf(1000L), 3, 4));
            data.add(ex.getFeedingMete().subtract(ex.getProduceMete()).divide(BigDecimal.valueOf(1000L), 3, 4));
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "项目投料详情.xlsx");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            EasyExcel.write(response.getOutputStream())
               .head(headList)
               .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
               .registerWriteHandler(
                  new CellWriteHandler() {
                     @Override
                     public void beforeCellCreate(
                        WriteSheetHolder writeSheetHolder,
                        WriteTableHolder writeTableHolder,
                        Row row,
                        Head head,
                        Integer columnIndex,
                        Integer relativeRowIndex,
                        Boolean isHead
                     ) {
                        if (isHead && relativeRowIndex == 0) {
                           row.setHeight((short)550);
                        }
                     }
                  }
               )
               .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setWriteFont(new WriteFont() {
                        {
                           this.setFontName("宋体");
                           this.setFontHeightInPoints((short)10);
                           this.setBold(true);
                        }
                     });
                     this.setWrapped(true);
                     this.setShrinkToFit(true);
                  }
               }, new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setBorderBottom(BorderStyle.THIN);
                     this.setBorderLeft(BorderStyle.THIN);
                     this.setBorderRight(BorderStyle.THIN);
                     this.setBorderTop(BorderStyle.THIN);
                  }
               }))
               .sheet("项目投料详情表")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   private List<LocalDate> getFeedingMonth(List<String> dateTimeList, Boolean isRecently) {
      List<LocalDate> yearMonthList = new ArrayList<>();
      if (!isRecently) {
         if (CollectionUtils.isEmpty(dateTimeList)) {
            return new ArrayList<>();
         }

         String minDate = dateTimeList.stream().min(Comparator.naturalOrder()).orElse(null);
         String maxDate = dateTimeList.stream().max(Comparator.naturalOrder()).orElse(null);
         String[] minDateArr = minDate.split("-");
         String[] maxDateArr = maxDate.split("-");
         LocalDate startDate = LocalDate.of(Integer.parseInt(minDateArr[0]), Integer.parseInt(minDateArr[1]), 1);
         LocalDate endDate = LocalDate.of(Integer.parseInt(maxDateArr[0]), Integer.parseInt(maxDateArr[1]), 1);
         long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
         Stream.<LocalDate>iterate(startDate, date -> date.plusMonths(1L)).limit(monthsBetween + 1L).forEach(yearMonthList::add);
      } else {
         if (CollectionUtils.isEmpty(dateTimeList)) {
            dateTimeList.add(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM")));
         }

         String maxDate = dateTimeList.stream().max(Comparator.naturalOrder()).orElse(null);
         String[] maxDateArr = maxDate.split("-");
         LocalDate endDate = LocalDate.of(Integer.parseInt(maxDateArr[0]), Integer.parseInt(maxDateArr[1]), 1);
         yearMonthList = Stream.<LocalDate>iterate(endDate, date -> date.minusMonths(1L)).limit(12L).sorted().collect(Collectors.toList());
      }

      return yearMonthList;
   }

   @Override
   public List<ProjectExecuteStateDTO> getProjectExecuteStateDTO(Long projectId, Long branchCompanyId) {
      List<ProjectExecuteStateDTO> deepMeteList = this.baseMapper.getDeepMeteGroupMonth(projectId);
      List<ProjectExecuteStateDTO> produceMeteList = this.baseMapper.getProduceMeteGroupMonth(projectId);
      List<ProjectExecuteStateDTO> shippingMeteList = this.baseMapper.getShippingMeteGroupMonth(projectId);
      List<ProjectExecuteStateDTO> installMeteList = this.baseMapper.getInstallMeteGroupMonth(projectId);
      Map<String, BigDecimal> deepMeteMap = deepMeteList.stream()
         .collect(Collectors.toMap(ProjectExecuteStateDTO::getDateTime, ProjectExecuteStateDTO::getDeepMete));
      Map<String, BigDecimal> produceMeteMap = produceMeteList.stream()
         .collect(Collectors.toMap(ProjectExecuteStateDTO::getDateTime, ProjectExecuteStateDTO::getProduceMete));
      Map<String, BigDecimal> shippingMeteMap = shippingMeteList.stream()
         .collect(Collectors.toMap(ProjectExecuteStateDTO::getDateTime, ProjectExecuteStateDTO::getShippingMete));
      Map<String, BigDecimal> installMeteMap = installMeteList.stream()
         .collect(Collectors.toMap(ProjectExecuteStateDTO::getDateTime, ProjectExecuteStateDTO::getInstallMete));
      List<String> dateTimeList = new ArrayList<>();
      dateTimeList.addAll(deepMeteMap.keySet());
      dateTimeList.addAll(produceMeteMap.keySet());
      dateTimeList.addAll(shippingMeteMap.keySet());
      dateTimeList.addAll(installMeteMap.keySet());
      if (CollectionUtils.isEmpty(dateTimeList)) {
         return new ArrayList<>();
      }

      String minDate = dateTimeList.stream().min(Comparator.naturalOrder()).orElse(null);
      String maxDate = dateTimeList.stream().max(Comparator.naturalOrder()).orElse(null);
      String[] minDateArr = minDate.split("-");
      String[] maxDateArr = maxDate.split("-");
      LocalDate startDate = LocalDate.of(Integer.parseInt(minDateArr[0]), Integer.parseInt(minDateArr[1]), 1);
      LocalDate endDate = LocalDate.of(Integer.parseInt(maxDateArr[0]), Integer.parseInt(maxDateArr[1]), 1);
      List<LocalDate> yearMonthList = new ArrayList<>();
      long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
      Stream.<LocalDate>iterate(startDate, date -> date.plusMonths(1L)).limit(monthsBetween + 1L).forEach(yearMonthList::add);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      List<ProjectExecuteStateDTO> result = new ArrayList<>();

      for (LocalDate dateTime : yearMonthList) {
         String key = dateTime.format(formatter);
         ProjectExecuteStateDTO build = ProjectExecuteStateDTO.builder()
            .dateTime(key)
            .deepMete(deepMeteMap.getOrDefault(key, BigDecimal.ZERO).stripTrailingZeros())
            .produceMete(produceMeteMap.getOrDefault(key, BigDecimal.ZERO).stripTrailingZeros())
            .shippingMete(shippingMeteMap.getOrDefault(key, BigDecimal.ZERO).stripTrailingZeros())
            .installMete(installMeteMap.getOrDefault(key, BigDecimal.ZERO).stripTrailingZeros())
            .build();
         result.add(build);
      }

      return result;
   }

   @Override
   public void getProjectExecuteStateDTODownload(Long projectId, Long branchCompanyId, HttpServletResponse response) {
      List<ProjectExecuteStateDTO> dtoList = this.getProjectExecuteStateDTO(projectId, branchCompanyId);
      if (!CollectionUtils.isEmpty(dtoList)) {
         String title = "";
         if (branchCompanyId != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
            if (branchCompany != null) {
               title = title + "分支机构：" + branchCompany.getName() + "\n";
            }
         }

         if (projectId != null) {
            ProjectInfo projectInfo = this.getSimpleById(projectId);
            if (projectInfo != null) {
               title = title + "项目：" + projectInfo.getName() + "\n";
            }
         }

         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "月份"));
         headList.add(Arrays.asList(title, "图纸深化"));
         headList.add(Arrays.asList(title, "生产加工"));
         headList.add(Arrays.asList(title, "物流发运"));
         headList.add(Arrays.asList(title, "项目安装"));
         List<List<Object>> dataList = new ArrayList<>();
         dtoList.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            data.add(ex.getDateTime());
            data.add(ex.getDeepMete().divide(BigDecimal.valueOf(1000L), 0, 4));
            data.add(ex.getProduceMete().divide(BigDecimal.valueOf(1000L), 0, 4));
            data.add(ex.getShippingMete().divide(BigDecimal.valueOf(1000L), 0, 4));
            data.add(ex.getInstallMete().divide(BigDecimal.valueOf(1000L), 0, 4));
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "生产状态详情表.xlsx");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            EasyExcel.write(response.getOutputStream())
               .head(headList)
               .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
               .registerWriteHandler(
                  new CellWriteHandler() {
                     @Override
                     public void beforeCellCreate(
                        WriteSheetHolder writeSheetHolder,
                        WriteTableHolder writeTableHolder,
                        Row row,
                        Head head,
                        Integer columnIndex,
                        Integer relativeRowIndex,
                        Boolean isHead
                     ) {
                        if (isHead && relativeRowIndex == 0) {
                           row.setHeight((short)550);
                        }
                     }
                  }
               )
               .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setWriteFont(new WriteFont() {
                        {
                           this.setFontName("宋体");
                           this.setFontHeightInPoints((short)10);
                           this.setBold(true);
                        }
                     });
                     this.setWrapped(true);
                     this.setShrinkToFit(true);
                  }
               }, new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setBorderBottom(BorderStyle.THIN);
                     this.setBorderLeft(BorderStyle.THIN);
                     this.setBorderRight(BorderStyle.THIN);
                     this.setBorderTop(BorderStyle.THIN);
                  }
               }))
               .sheet("生产状态详情表")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public BigDecimal getInstallMete(Long projectId, Long branchCompanyId) {
      return this.baseMapper.getInstallMete(projectId);
   }

   @Override
   public Boolean checkRelatednessById(Long idOne, Long idTwo) {
      Preconditions.checkArgument(idOne != null && idTwo != null, "projectId不能为空");
      ContractProject projectOne = this.baseMapper.selectById(idOne);
      ContractProject projectTwo = this.baseMapper.selectById(idTwo);
      Preconditions.checkArgument(projectTwo != null && projectOne != null, "项目不存在");
      List<Long> projectIds = new ArrayList<>();
      if (ObjectUtil.isNotEmpty(projectOne.getPId())) {
         List<ContractProject> projects = this.baseMapper
            .selectList((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getPId, projectOne.getPId()));
         projectIds.addAll(projects.stream().map(ContractProject::getId).collect(Collectors.toList()));
         projectIds.add(projectOne.getPId());
      } else {
         List<ContractProject> projects = this.baseMapper
            .selectList((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getPId, projectOne.getId()));
         if (CollectionUtils.isNotEmpty(projects)) {
            projectIds.addAll(projects.stream().map(ContractProject::getId).collect(Collectors.toList()));
         }

         projectIds.add(projectOne.getId());
      }

      return projectIds.contains(idTwo) && projectIds.contains(idOne);
   }

   private List<ProjectAnalysisDetailDTO> convertToProjectAnalysisDetailDTO(List<ContractProject> projectList) {
      if (CollectionUtils.isEmpty(projectList)) {
         return new ArrayList<>();
      }

      Map<Long, BigDecimal> deepMeteMap = this.artifactService
         .sumMeteGroupByProject(null)
         .stream()
         .collect(Collectors.toMap(ProductMeteGroupByProjectDTO::getProjectId, ProductMeteGroupByProjectDTO::getMete));
      return projectList.stream().map(project -> {
         ProjectAnalysisDetailDTO dto = BeanUtil.copy(project, ProjectAnalysisDetailDTO.class);
         ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
         dto.setProject(projectInfo);
         dto.setDeepMete(deepMeteMap.getOrDefault(project.getId(), BigDecimal.ZERO));
         BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
         dto.setBranchCompanyName(branchCompany.getName());
         return dto;
      }).collect(Collectors.toList());
   }

   private List<LocalDate> getYearMonthDateList(LocalDate year) {
      LocalDate startDate = LocalDate.of(year.getYear(), 1, 1);
      LocalDate endDate = LocalDate.of(year.getYear(), 12, 1);
      List<LocalDate> yearMonthList = new ArrayList<>();
      long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
      Stream.<LocalDate>iterate(startDate, date -> date.plusMonths(1L)).limit(monthsBetween + 1L).forEach(yearMonthList::add);
      return yearMonthList;
   }
}
