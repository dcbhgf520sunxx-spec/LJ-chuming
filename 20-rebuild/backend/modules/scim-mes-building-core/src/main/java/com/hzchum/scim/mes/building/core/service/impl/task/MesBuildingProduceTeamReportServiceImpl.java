package com.hzchum.scim.mes.building.core.service.impl.task;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
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
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.DateQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectProductionMeteDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskReportTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingNextProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProduceInspectionTeamReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProduceTeamReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportRecordNumbersV2DO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportSourceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.YearMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingArtifactTaskProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.DistributionProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ReckonPriceDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ReckonPriceTeamDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceQhseTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.MesDailyProductionTaskDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.OutStaffDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.PriceDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.get.PriceDetailsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InspectRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamProduceInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.WorkshopProduceInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDailyProductionQuerySumDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesTeamReportProductStaticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.DateAndCount;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductLineDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamCapacityAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamEachMonthRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.produceTeamRecourseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ArtifactReportSourceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.DateMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.LastProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.NewArtifactReportSourceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessKanBanAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceAbonrmalReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceInspectionTeamReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProductProduceCargoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProductTeamSummaryDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProductTeamSummaryDetailEnhanceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProjectMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ReportRecordV2DTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.TeamReportRealTimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.UserProductionDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.UserProductionSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.productTeamSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingQualityInspectionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingReportNumberStatusDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessArtifactNumberDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTeamReportDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchInspectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceProcessDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wages.PriceDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingNextProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceQhseTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingProduceTeamReportMapper;
import com.hzchum.scim.plan.core.api.biz.TechArtifactBiz;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class MesBuildingProduceTeamReportServiceImpl
   extends ServiceImpl<MesBuildingProduceTeamReportMapper, MesBuildingProduceTeamReport>
   implements MesBuildingProduceTeamReportService {
   @Resource
   private TechArtifactBiz techArtifactBiz;
   @Resource
   private TechAssembleService assembleService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingGroupsBiz groupsBiz;
   @Autowired
   private MesBuildingProcessBiz processBiz;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private TechArtifactService techArtifactService;
   @Autowired
   private MesBuildingTaskProcessBiz taskProcessBiz;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingProduceQhseTeamReportService qhseTeamReportService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService planMonomerService;
   @Autowired
   private PlanAreaService planAreaService;
   @Autowired
   private UserService userService;
   @Autowired
   private MesBuildingTaskOrderService orderService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Autowired
   private MesBuildingTaskNumberLinkService numberLinkService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private PlanAreaBatchService areaBatchService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Autowired
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   @Autowired
   private MesBuildingNextProcessLinkService nextProcessLinkService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Resource
   private BranchCompanyService branchCompanyService;

   @Override
   public List<ProduceTeamReportDTO> listByCondition(
      String date,
      Long taskId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber
   ) {
      return this.baseMapper
         .listByCondition(
            date, taskId, productId, taskTypeEnum, teamId, reportType, projectId, monomerId, areaId, workshopId, productLineId, factoryId, serialNumber
         )
         .stream()
         .map(e -> BeanUtil.copy(e, ProduceTeamReportDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProduceTeamReportDTO> pageByCondition(
      String date,
      Long taskId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.listByCondition(
            date, taskId, productId, taskTypeEnum, teamId, reportType, projectId, monomerId, areaId, workshopId, productLineId, factoryId, serialNumber
         )
      );
   }

   @Override
   public Integer unInspectionCun(Integer taskTypeEnum) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      return teamList != null && teamList.size() != 0
         ? this.baseMapper
            .unInspectionListByCondition(
               taskTypeEnum, null, null, null, null, null, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()), null
            )
            .size()
         : 0;
   }

   @Override
   public Integer unInspectionCun2(Integer taskTypeEnum) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      return teamList != null && teamList.size() != 0
         ? this.baseMapper
            .unInspectionListByCondition2(
               taskTypeEnum, null, null, null, null, null, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()), null
            )
            .size()
         : 0;
   }

   @Override
   public List<ProduceTeamReportDTO> unInspectionListByCondition(
      Integer taskTypeEnum, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productLineId, String serialNumber
   ) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      return teamList.size() == 0
         ? new ArrayList<>()
         : this.baseMapper
            .unInspectionListByCondition(
               taskTypeEnum,
               projectId,
               monomerId,
               areaId,
               workshopId,
               productLineId,
               teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()),
               serialNumber
            )
            .stream()
            .map(e -> BeanUtil.copy(e, ProduceTeamReportDTO.class))
            .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProduceTeamReportDTO> unInspectionPageByCondition(
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      return teamList.size() == 0
         ? new PageVO<>()
         : new PageVO<>(
            PageHelper.startPage(pageNumber, pageSize),
            this.baseMapper
               .unInspectionListByCondition(
                  taskTypeEnum,
                  projectId,
                  monomerId,
                  areaId,
                  workshopId,
                  productLineId,
                  teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()),
                  serialNumber
               )
               .stream()
               .map(e -> BeanUtil.copy(e, ProduceTeamReportDTO.class))
               .collect(Collectors.toList())
         );
   }

   @Override
   public List<ProduceInspectionTeamReportDTO> inspectionListByCondition(
      String date,
      Long taskId,
      Long productId,
      Long teamId,
      Integer taskTypeEnum,
      Boolean boolAdoptEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber
   ) {
      return this.baseMapper
         .inspectionListByCondition(
            date, taskId, productId, teamId, taskTypeEnum, boolAdoptEnum, projectId, monomerId, areaId, workshopId, productLineId, factoryId, serialNumber
         )
         .stream()
         .map(e -> BeanUtil.copy(e, ProduceInspectionTeamReportDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProduceInspectionTeamReportDTO> inspectionPageByCondition(
      String date,
      Long taskId,
      Long productId,
      Long teamId,
      Integer taskTypeEnum,
      Boolean boolAdoptEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.inspectionListByCondition(
            date, taskId, productId, teamId, taskTypeEnum, boolAdoptEnum, projectId, monomerId, areaId, workshopId, productLineId, factoryId, serialNumber
         )
      );
   }

   @Override
   public List<ProduceAbonrmalReportDTO> reportList(Long productId, Integer productType, Long taskId, List<Long> processIdList) {
      return this.baseMapper
         .reportList(productId, productType, taskId, processIdList)
         .stream()
         .map(e -> BeanUtil.copy(e, ProduceAbonrmalReportDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public DistributionDO getComplete(PriceDTOParam copy) {
      return this.baseMapper.getComplete(copy);
   }

   @Override
   public List<OutStaffDO> outStaffWageList(OutStaffDOParam doParam) {
      return this.baseMapper.outStaffWageList(doParam);
   }

   @Override
   public List<ReckonPriceTeamDO> getTeamMate(PriceDOParam doParam) {
      return this.baseMapper.getTeamMate(doParam);
   }

   @Override
   public List<ReckonPriceDetailDO> getTeamMateDetails(PriceDetailsDOParam doParam) {
      return this.baseMapper.getTeamMateDetails(doParam);
   }

   @Override
   public BigDecimal getProcessPriceSummary(PriceDOParam copy) {
      return this.baseMapper.getProcessPriceSummary(copy);
   }

   @Override
   public List<DistributionProcessDO> getProcessPrice(PriceDOParam copy) {
      return this.baseMapper.getProcessPrice(copy);
   }

   @Override
   public List<ReportSourceDO> reportSourceList(Long id, Integer prodcutType) {
      return this.baseMapper.reportSourceList(id, prodcutType);
   }

   @Override
   public List<MesBuildingArtifactTaskProcessDO> artifactTaskList(Long previousTaskProcessId, Long taskProcessId, Long number) {
      return this.baseMapper.artifactTaskList(previousTaskProcessId, taskProcessId, number);
   }

   @Override
   public List<MesBuildingArtifactTaskProcessDO> artifactTaskLogList(Long previousTaskProcessId, Long taskProcessId, Long number) {
      return this.baseMapper.artifactTaskLogList(previousTaskProcessId, taskProcessId, number);
   }

   @Override
   public List<MesBuildingArtifactTaskProcessDO> artifactTaskLogLists(List<Long> previousTaskProcessIds, Long taskProcessId, Long number) {
      return this.baseMapper.artifactTaskLogLists(previousTaskProcessIds, taskProcessId, number);
   }

   @Override
   public List<MesBuildingArtifactTaskProcessDO> artifactInspectionTaskList(Long taskProcessId, Long number, Long teamId) {
      return this.baseMapper.artifactInspectionTaskList(taskProcessId, number, teamId);
   }

   @Override
   public PageVO<ProduceTeamReportDTO> pageByConditionByDate(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean boolAll,
      Boolean isCurrentUser,
      Boolean boolMarked,
      Integer pageNumber,
      Integer pageSize
   ) {
      boolAll = boolAll != null && boolAll;
      List<Long> teamIds = new ArrayList<>();
      if (boolAll) {
         teamIds.add(teamId);
      } else if (teamId == null) {
         SecurityUser currentUser = UserUtil.getCurrentUser();
         teamIds = this.teamUserLinkService
            .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).eq(MesBuildingTeamUserLink::getUserId, currentUser.getId()))
            .stream()
            .map(MesBuildingTeamUserLink::getTeamId)
            .collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamIds), "当前用户不存在班组");
      } else {
         teamIds.add(teamId);
      }

      Long userId = null;
      if (isCurrentUser) {
         userId = UserUtil.getCurrentUserId();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProduceTeamReportDO> dos = this.baseMapper
         .listByConditionBydate(
            startDate,
            endDate,
            taskId,
            processId,
            productId,
            taskTypeEnum,
            teamIds,
            reportType,
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            workshopId,
            productLineId,
            factoryId,
            serialNumber,
            userId,
            boolMarked
         );
      PageVO pageVO = new PageVO<>(dos);
      List<ProduceTeamReportDTO> produceTeamReportDTOS = dos.stream().map(e -> BeanUtil.copy(e, ProduceTeamReportDTO.class)).collect(Collectors.toList());
      pageVO.setContent(produceTeamReportDTOS);
      if (CollectionUtils.isEmpty(dos)) {
         return pageVO;
      }

      List<Long> reportNumber = produceTeamReportDTOS.stream().map(ProduceTeamReportDO::getId).distinct().collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(reportNumber)) {
         List<MesBuildingProduceTeamReport> reportList = this.list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .apply("task_type_enum & {0} >0", taskTypeEnum)
               .in(MesBuildingProduceTeamReport::getReportNumber, reportNumber)
         );
         Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap = reportList.stream()
            .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getReportNumber));
         List<Long> taskIds = reportList.stream().map(MesBuildingProduceTeamReport::getTaskId).distinct().collect(Collectors.toList());
         List<MesBuildingProduceInspectionTeamReport> inspectionTeamReports = this.inspectionTeamReportService
            .list((Wrapper<MesBuildingProduceInspectionTeamReport>)new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>().in(MesBuildingProduceInspectionTeamReport::getTaskId, taskIds));
         Map<Long, List<MesBuildingProduceInspectionTeamReport>> inspectionTeamReportMap = new HashMap<>();
         Map<Long, User> userMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(inspectionTeamReports)) {
            inspectionTeamReportMap = inspectionTeamReports.stream().collect(Collectors.groupingBy(MesBuildingProduceInspectionTeamReport::getTaskProcessId));
            userMap = this.userService
               .listByIds(inspectionTeamReports.stream().map(MesBuildingProduceInspectionTeamReport::getUserId).distinct().collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(User::getId, Function.identity()));
         }

         List<NumberInfoDTO> productNumberMap = reportList.stream()
            .map(e -> NumberInfoDTO.builder().productId(e.getProductId()).number(e.getNumber()).build())
            .collect(Collectors.toList());
         Map<Long, List<MesBuildingTaskNumberLink>> taskNumberMap = Collections.emptyMap();
         if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
            List<MesBuildingTaskNumberLink> artLinks = this.mesBuildingTaskNumberLinkService.listLinksBydata(productNumberMap, TaskTypeEnum.ARTIFACT.getType());
            taskNumberMap = artLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactId));
         } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum) || taskTypeEnum.equals(48)) {
            List<MesBuildingTaskNumberLink> artLinks = this.mesBuildingTaskNumberLinkService.listLinksBydata(productNumberMap, TaskTypeEnum.ASSEMBLE.getType());
            taskNumberMap = artLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
         }

         List<MesBuildingNextProcessLink> nextProcessList = this.nextProcessLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingNextProcessLink.class)
                  .in(MesBuildingNextProcessLink::getTaskProcessId, reportList.stream().map(e -> e.getTaskProcessId()).distinct().collect(Collectors.toList()))
            );
         nextProcessList.forEach(e -> e.setNextProcessId(e.getNextProcessId() == null ? 0L : e.getNextProcessId()));
         Map<Long, List<Long>> nextProcessMap = nextProcessList.stream()
            .collect(Collectors.groupingBy(e -> e.getTaskProcessId(), Collectors.mapping(s -> s.getNextProcessId(), Collectors.toList())));
         LambdaQueryWrapper<MesBuildingTaskProcess> wrapper = new LambdaQueryWrapper<>();
         reportList.stream()
            .forEach(
               e -> {
                  if (wrapper.isEmptyOfNormal()) {
                     wrapper.eq(MesBuildingTaskProcess::getTaskId, e.getTaskId());
                     wrapper.in(MesBuildingTaskProcess::getProcessId, nextProcessMap.get(e.getTaskProcessId()));
                  } else {
                     wrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskProcess::getTaskId, e.getTaskId())
                              .in(MesBuildingTaskProcess::getProcessId, nextProcessMap.get(e.getTaskProcessId()));
                        }
                     );
                  }
               }
            );
         Map<String, MesBuildingTaskProcess> nextTaskProcessMap = this.taskProcessService
            .list(wrapper)
            .stream()
            .collect(Collectors.toMap(e -> e.getTaskId() + "_" + e.getProcessId(), Function.identity()));

         for (ProduceTeamReportDTO dto : produceTeamReportDTOS) {
            dto.setReportUser(dto.getUser().getName());
            List<MesBuildingProduceTeamReport> reports = produceTeamReportMap.get(dto.getId());
            List<Integer> numberList = reports.stream().map(e -> e.getNumber()).collect(Collectors.toList());
            List<MesBuildingTaskNumberLink> numberLinks = taskNumberMap.get(dto.getProductId());
            if (reports.get(0).getIsReversible() != null) {
               List<Long> nextTaskProcess = nextProcessMap.get(reports.get(0).getTaskProcessId());
               ArrayList<Long> taskProcesseIds = new ArrayList<>();
               nextTaskProcess.forEach(e -> {
                  MesBuildingTaskProcess process = nextTaskProcessMap.get(reports.get(0).getTaskId() + "_" + e);
                  if (process != null) {
                     taskProcesseIds.add(process.getId());
                  } else {
                     taskProcesseIds.addAll(nextProcessMap.get(dto.getTaskProcessId()));
                  }
               });
               boolean boolReversible = false;
               if (nextTaskProcess != null) {
                  if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
                     numberLinks = numberLinks.stream().filter(e -> numberList.contains(e.getArtifactNumber())).collect(Collectors.toList());
                     if (taskProcesseIds.size() == 1 && taskProcesseIds.get(0) == 0L) {
                        boolReversible = reports.get(0).getIsReversible()
                           && numberLinks.stream().allMatch(e -> taskProcesseIds.get(0).equals(e.getArtifactTaskProcessId()));
                     } else {
                        boolReversible = reports.get(0).getIsReversible()
                           && numberLinks.stream()
                              .allMatch(
                                 e -> taskProcesseIds.contains(e.getArtifactTaskProcessId()) && !e.getBoolArtifactReport() && !e.getBoolArtifactInspection()
                              );
                     }

                     dto.setIsReversible(boolReversible);
                  } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum) || taskTypeEnum.equals(48)) {
                     numberLinks = numberLinks.stream().filter(e -> numberList.contains(e.getAssembleNumber())).collect(Collectors.toList());
                     if (taskProcesseIds.size() == 1 && taskProcesseIds.get(0) == 0L) {
                        boolReversible = reports.get(0).getIsReversible()
                           && numberLinks.stream().allMatch(e -> taskProcesseIds.get(0).equals(e.getAssembleTaskProcessId()))
                           && numberLinks.stream().allMatch(e -> e.getArtifactNextProcessId() == null);
                     } else {
                        boolReversible = reports.get(0).getIsReversible()
                           && numberLinks.stream()
                              .allMatch(
                                 e -> taskProcesseIds.contains(e.getAssembleTaskProcessId()) && !e.getBoolAssembleReport() && !e.getBoolAssembleInspection()
                              );
                     }

                     dto.setIsReversible(boolReversible);
                  }
               } else {
                  dto.setIsReversible(reports.get(0).getIsReversible());
               }
            } else {
               Optional<Integer> inspectQuantity = reports.stream().map(e -> e.getInspectionQuantity()).reduce(Integer::sum);
               Optional<Integer> taskQuantity = reports.stream().map(e -> e.getQuantity()).reduce(Integer::sum);
               dto.setIsReversible(inspectQuantity.get() < taskQuantity.get());
            }

            if (dto.getBoolOneCode()) {
               dto.setNumber(reports.get(0).getNumber());
            }

            MesBuildingProduceTeamReport produceTeamReport = reports.get(0);
            List<MesBuildingProduceInspectionTeamReport> inspectionTeamReport = inspectionTeamReportMap.get(produceTeamReport.getTaskProcessId());
            if (CollectionUtils.isNotEmpty(inspectionTeamReport)) {
               if (dto.getBoolOneCode()) {
                  dto.setNumber(produceTeamReport.getNumber());
                  List<MesBuildingProduceInspectionTeamReport> produceInspectionTeamReports = inspectionTeamReport.stream()
                     .filter(e -> e.getNumber().equals(produceTeamReport.getNumber()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(produceInspectionTeamReports)) {
                     User user = userMap.get(produceInspectionTeamReports.get(0).getUserId());
                     if (user != null) {
                        dto.setInspectionUserNme(user.getName());
                     }
                  }
               } else {
                  List<Integer> numbers = reports.stream().map(MesBuildingProduceTeamReport::getNumber).distinct().collect(Collectors.toList());
                  Map<Long, User> finalUserMap = userMap;
                  List<MesBuildingProduceInspectionTeamReport> produceInspectionTeamReports = inspectionTeamReport.stream()
                     .filter(e -> numbers.contains(e.getNumber()))
                     .filter(e -> finalUserMap.get(e.getUserId()) != null)
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(produceInspectionTeamReports)) {
                     dto.setInspectionUserNme(
                        produceInspectionTeamReports.stream().map(e -> finalUserMap.get(e.getUserId()).getName()).distinct().collect(Collectors.joining(","))
                     );
                  }
               }
            }

            dto.setBoolMarked(produceTeamReport.getBoolMarked());
            dto.setMarkingTime(produceTeamReport.getMarkingTime());
            dto.setMarkedQuantity(reports.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum());
         }
      }

      pageVO.setContent(produceTeamReportDTOS);
      return pageVO;
   }

   @Override
   public List<ProjectDetailDO> projectConditionList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean boolAll
   ) {
      List<Long> teamlist = null;
      if (teamId != null) {
         teamlist = Arrays.asList(teamId);
      }

      return this.baseMapper
         .listByConditionBydate(
            startDate,
            endDate,
            taskId,
            processId,
            productId,
            taskTypeEnum,
            teamlist,
            reportType,
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            workshopId,
            productLineId,
            factoryId,
            serialNumber,
            null,
            null
         )
         .stream()
         .map(ProduceTeamReportDO::getProject)
         .distinct()
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProduceInspectionTeamReportDTO> inspectionPageByConditionByDate(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Long teamId,
      Integer taskTypeEnum,
      Boolean boolAdoptEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean isCurrentUser,
      Integer pageNumber,
      Integer pageSize
   ) {
      Long userId = null;
      if (isCurrentUser) {
         userId = UserUtil.getCurrentUserId();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProduceInspectionTeamReportDO> dos = this.baseMapper
         .inspectionListByConditionByDate(
            startDate,
            endDate,
            taskId,
            processId,
            productId,
            teamId,
            taskTypeEnum,
            boolAdoptEnum,
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            workshopId,
            productLineId,
            factoryId,
            serialNumber,
            userId
         );
      PageVO<ProduceInspectionTeamReportDTO> pageVO = (PageVO)new PageVO<ProduceInspectionTeamReportDO>(dos);
      if (CollectionUtils.isEmpty(dos)) {
         return pageVO;
      }

      List<ProduceInspectionTeamReportDTO> produceInspectionTeamReportDTOS = dos.stream()
         .map(e -> BeanUtil.copy(e, ProduceInspectionTeamReportDTO.class))
         .collect(Collectors.toList());
      pageVO.setContent(produceInspectionTeamReportDTOS);
      List<Long> inspectNumbers = produceInspectionTeamReportDTOS.stream()
         .map(ProduceInspectionTeamReportDO::getInspectReportNumber)
         .distinct()
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(inspectNumbers)) {
         List<MesBuildingProduceInspectionTeamReport> reportList = this.inspectionTeamReportService
            .list(
               Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReport.class)
                  .in(MesBuildingProduceInspectionTeamReport::getInspectReportNumber, inspectNumbers)
            );
         Map<Long, List<MesBuildingProduceInspectionTeamReport>> inspectionReportMap = reportList.stream()
            .collect(Collectors.groupingBy(MesBuildingProduceInspectionTeamReport::getInspectReportNumber));
         List<Long> taskIds = reportList.stream().map(MesBuildingProduceInspectionTeamReport::getTaskId).distinct().collect(Collectors.toList());
         List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
            .list((Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>().in(MesBuildingProduceTeamReport::getTaskId, taskIds));
         Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap = produceTeamReportList.stream()
            .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskProcessId));
         Map<Long, User> userMap = this.userService
            .listByIds(produceTeamReportList.stream().map(MesBuildingProduceTeamReport::getUserId).distinct().collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(User::getId, Function.identity()));

         for (ProduceInspectionTeamReportDTO dto : produceInspectionTeamReportDTOS) {
            dto.setInspectionUserNme(dto.getUser().getName());
            List<MesBuildingProduceInspectionTeamReport> reports = inspectionReportMap.get(dto.getInspectReportNumber());
            MesBuildingProduceInspectionTeamReport inspectionTeamReport = reports.get(0);
            List<MesBuildingProduceTeamReport> teamReportList = produceTeamReportMap.get(inspectionTeamReport.getTaskProcessId());
            if (CollectionUtils.isNotEmpty(teamReportList)) {
               if (dto.getBoolOneCode()) {
                  dto.setNumber(inspectionTeamReport.getNumber());
                  List<MesBuildingProduceTeamReport> produceTeamReports = teamReportList.stream()
                     .filter(e -> e.getNumber().equals(inspectionTeamReport.getNumber()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(produceTeamReports)) {
                     User user = userMap.get(produceTeamReports.get(0).getUserId());
                     dto.setReportUser("超管");
                     if (user != null) {
                        dto.setReportUser(user.getName());
                     }
                  }
               } else {
                  List<Integer> inspectionNumbers = reports.stream()
                     .map(MesBuildingProduceInspectionTeamReport::getNumber)
                     .distinct()
                     .collect(Collectors.toList());
                  List<MesBuildingProduceTeamReport> produceTeamReports = teamReportList.stream()
                     .filter(e -> inspectionNumbers.contains(e.getNumber()))
                     .filter(e -> userMap.get(e.getUserId()) != null)
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(produceTeamReports)) {
                     dto.setReportUser(produceTeamReports.stream().map(e -> userMap.get(e.getUserId()).getName()).distinct().collect(Collectors.joining(",")));
                  } else {
                     dto.setReportUser("超管");
                  }
               }
            }
         }
      }

      pageVO.setContent(produceInspectionTeamReportDTOS);
      return pageVO;
   }

   @Override
   public Map teamReportListSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean isCurrentUser,
      Integer pageNumber,
      Integer pageSize
   ) {
      Long userId = null;
      if (isCurrentUser) {
         userId = UserUtil.getCurrentUserId();
      }

      KevMeteDO kevMeteDO = this.baseMapper.teamReportListSummary(startDate, endDate, taskTypeEnum, userId);
      HashMap<String, BigDecimal> map = new HashMap<>();
      map.put("quantity", kevMeteDO == null ? BigDecimal.ZERO : new BigDecimal(kevMeteDO.getGroupKey()));
      map.put("weight", kevMeteDO == null ? BigDecimal.ZERO : kevMeteDO.getMete());
      return map;
   }

   @Override
   public Map inspectionTeamReportListSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Long teamId,
      Integer taskTypeEnum,
      Boolean boolAdoptEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean isCurrentUser,
      Integer pageNumber,
      Integer pageSize
   ) {
      Long userId = null;
      if (isCurrentUser) {
         userId = UserUtil.getCurrentUserId();
      }

      KevMeteDO kevMeteDO = this.baseMapper.inspectionTeamReportListSummary(startDate, endDate, taskTypeEnum, userId);
      HashMap<String, BigDecimal> map = new HashMap<>();
      map.put("quantity", kevMeteDO == null ? BigDecimal.ZERO : new BigDecimal(kevMeteDO.getGroupKey()));
      map.put("weight", kevMeteDO == null ? BigDecimal.ZERO : kevMeteDO.getMete());
      return map;
   }

   @Override
   public PageVO pageTeamReportNestCutPlateList(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, Integer pageNumber, Integer pageSize
   ) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList == null) {
         return new PageVO();
      }

      Map<Long, MesBuildingGroups> groupsMap = this.groupsBiz
         .getGroupsList(null)
         .stream()
         .collect(Collectors.toMap(MesBuildingGroups::getId, Function.identity()));
      return groupsMap.size() == 0
         ? new PageVO()
         : new PageVO<>(
            PageHelper.startPage(pageNumber, pageSize), this.teamReportNestCutPlateList(startDate, endDate, taskTypeEnum, processType, groupsMap.keySet())
         );
   }

   @Override
   public List<MesBuildingNestCutPlateDTO> teamReportNestCutPlateList(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, Set<Long> groupsId
   ) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList == null) {
         return new ArrayList() {};
      }

      Map<Long, MesBuildingGroups> groupsMap = this.groupsBiz
         .getGroupsList(null)
         .stream()
         .collect(Collectors.toMap(MesBuildingGroups::getId, Function.identity()));
      return groupsMap.size() == 0
         ? new ArrayList<>()
         : this.baseMapper.teamReportNestCutPlateList(startDate, endDate, taskTypeEnum, processType, groupsMap.keySet());
   }

   @Override
   public PageVO<ProduceTeamReportDTO> pageTeamReportMachinePartList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskTypeEnum,
      Integer processType,
      String serialNumber,
      Long projectId,
      Long cutId,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.teamReportMachinePartList(startDate, endDate, taskTypeEnum, processType, serialNumber, projectId, cutId)
      );
   }

   @Override
   public List<ProduceTeamReportDTO> teamReportMachinePartList(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, String serialNumber, Long projectId, Long cutId
   ) {
      return this.baseMapper.teamReportMachinePartList(startDate, endDate, taskTypeEnum, processType, serialNumber, projectId, cutId);
   }

   @Override
   public Map teamReportMachinePartListSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskTypeEnum,
      Integer processType,
      String serialNumber,
      Long projectId,
      Long cutId,
      Integer pageNumber,
      Integer pageSize
   ) {
      KevMeteDO kevMeteDO = this.baseMapper.teamReportMachinePartListSummary(startDate, endDate, taskTypeEnum, processType, cutId);
      HashMap<String, BigDecimal> map = new HashMap<>();
      map.put("quantity", kevMeteDO == null ? BigDecimal.ZERO : new BigDecimal(kevMeteDO.getGroupKey()));
      map.put("weight", kevMeteDO == null ? BigDecimal.ZERO : kevMeteDO.getMete());
      return map;
   }

   @Override
   public List<ArtifactReportSourceDTO> artifactSourceReportProductList(Long productId, Integer number, Long taskId) {
      return this.baseMapper.artifactSourceReportProductList(productId, number, taskId);
   }

   @Override
   public List<NewArtifactReportSourceDTO> newArtifactSourceReportProductList(Long productId, Integer taskTypeEnum, Integer number) {
      return this.baseMapper.newArtifactSourceReportProductList(productId, taskTypeEnum, number);
   }

   @Override
   public List<NewArtifactReportSourceDTO> ArtifactSourceInspectReportProductList(Long productId, Integer taskTypeEnum, Integer number) {
      return this.baseMapper.ArtifactSourceInspectReportProductList(productId, taskTypeEnum, number);
   }

   @Override
   public List<YearMeteDO> getMeteByYear(LocalDateTime dateTime, Integer processTypeEnum, Long projectId) {
      return this.baseMapper.getMeteByYear(dateTime, processTypeEnum, projectId);
   }

   @Override
   public List<DateMeteDTO> getMeteByYearV2(LocalDateTime dateTime, Integer processTypeEnum, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getMeteByYearV2(dateTime, processTypeEnum, branchCompanyId, workshopId);
   }

   @Override
   public List<productTeamSummaryDTO> productTeamSummaryReport(
      Long workshopId, Long projectId, Long processId, Integer taskTypeEnum, LocalDateTime startDate, LocalDateTime endDate
   ) {
      return this.baseMapper.productTeamSummaryReport(workshopId, projectId, processId, taskTypeEnum, startDate, endDate);
   }

   @Override
   public List<productTeamSummaryDTO> productTeamSummaryReportV2(
      Long workshopId,
      Long projectId,
      Long processId,
      List<Long> teamIds,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskReportTypeEnum
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      return CollectionUtils.isEmpty(projectIds)
         ? new ArrayList<>()
         : this.baseMapper
            .productTeamSummaryReportV2(workshopId, projectId, projectIds, processId, teamIds, taskTypeEnum, startDate, endDate, taskReportTypeEnum);
   }

   @Override
   public void productTeamSummaryReportDownload(
      Long workshopId,
      Long projectId,
      Long processId,
      List<Long> teamIds,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskReportTypeEnum,
      HttpServletResponse response
   ) throws IOException {
      List<productTeamSummaryDTO> dtos = this.productTeamSummaryReportV2(
         workshopId, projectId, processId, teamIds, taskTypeEnum, startDate, endDate, taskReportTypeEnum
      );
      List<ProductTeamSummaryDetailDTO> summaryDetailDTOS = this.baseMapper
         .productTeamSummaryReportDetailListPrint(
            workshopId, projectId, null, null, null, null, teamIds, processId, null, taskTypeEnum, startDate, endDate, taskReportTypeEnum
         );
      this.exportToExcel(dtos, summaryDetailDTOS, response);
   }

   public void exportToExcel(List<productTeamSummaryDTO> dataList, List<ProductTeamSummaryDetailDTO> summaryDetailDTOS, HttpServletResponse response) throws IOException {
      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet("summary");
      Row headerRow = sheet.createRow(0);
      String[] staticHeaders = new String[]{"工序", "班组", "上报数", "净重(吨)", "毛重(吨)", "质检数", "净重(吨)", "毛重(吨)"};

      for (int i = 0; i < staticHeaders.length; i++) {
         Cell cell = headerRow.createCell(i);
         cell.setCellValue(staticHeaders[i]);
      }

      int rowNum = 1;
      BigDecimal divideSum = BigDecimal.valueOf(1000L);

      for (productTeamSummaryDTO data : dataList) {
         Row row = sheet.createRow(rowNum++);
         row.createCell(0).setCellValue(data.getProcess().getName());
         row.createCell(1).setCellValue(data.getWorkshop().getName() + ">" + data.getTeam().getName());
         row.createCell(2).setCellValue(data.getReportQuantity().toString());
         row.createCell(3).setCellValue(data.getReportNetWeight().divide(divideSum).toPlainString());
         row.createCell(4).setCellValue(data.getReportGrossWeight().divide(divideSum).toPlainString());
         row.createCell(5).setCellValue(data.getInspectionQuantity().toString());
         row.createCell(6).setCellValue(data.getNetWeight().divide(divideSum).toPlainString());
         row.createCell(7).setCellValue(data.getGrossWeight().divide(divideSum).toPlainString());
      }

      for (int i = 0; i < staticHeaders.length; i++) {
         sheet.autoSizeColumn(i);
      }

      Sheet sheetTwo = workbook.createSheet("班组统计详情");
      Row headerRowTwo = sheetTwo.createRow(0);
      String[] staticHeaderTwos = new String[]{
         "序号", "项目名称", "单体", "区域", "编号", "规格", "长度", "上报数量", "质检数量", "工序", "班组长", "单净重(kg)", "单毛重(kg)", "总净重(kg)", "总毛重(kg)", "上报人", "上报日期"
      };

      for (int i = 0; i < staticHeaderTwos.length; i++) {
         Cell cell = headerRowTwo.createCell(i);
         cell.setCellValue(staticHeaderTwos[i]);
      }

      int rowNumTwo = 1;

      for (ProductTeamSummaryDetailDTO data : summaryDetailDTOS) {
         Row row = sheetTwo.createRow(rowNumTwo);
         row.createCell(0).setCellValue(rowNumTwo++);
         row.createCell(1).setCellValue(data.getProject().getSerialNumber() + "  " + data.getProject().getShortName());
         row.createCell(2).setCellValue(data.getMonomer().getName());
         row.createCell(3).setCellValue(data.getArea().getName());
         row.createCell(4).setCellValue(data.getSerialNumber());
         row.createCell(5).setCellValue(data.getSpecification());
         row.createCell(6).setCellValue(data.getLength().toString());
         row.createCell(7).setCellValue(data.getReportQuantity().intValue());
         row.createCell(8).setCellValue(data.getQuantity().intValue());
         row.createCell(9).setCellValue(data.getProcess().getName());
         row.createCell(10).setCellValue(data.getTeamUser().getName());
         row.createCell(11).setCellValue(data.getNetWeight().toString());
         row.createCell(12).setCellValue(data.getGrossWeight().toString());
         row.createCell(13).setCellValue(data.getTotalNetWeight().toString());
         row.createCell(14).setCellValue(data.getTotalGrossWeight().toString());
         row.createCell(15).setCellValue(data.getReportUserName());
         row.createCell(16).setCellValue(data.getReportingDate());
      }

      for (int i = 0; i < staticHeaderTwos.length; i++) {
         sheetTwo.autoSizeColumn(i);
      }

      response.setCharacterEncoding("UTF-8");
      response.setHeader("content-Type", "application/vnd.ms-excel");
      response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("班组总计汇总报表.xlsx", "UTF-8"));
      response.setHeader("Access-Control-Expose-Headers", "*");
      response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
      workbook.write(response.getOutputStream());
      workbook.close();
   }

   @Override
   public PageVO<ProductTeamSummaryDetailDTO> productTeamSummaryReportDetailPage(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.productTeamSummaryReportDetailList(
            workshopId, projectId, monomerId, areaId, areaBatchId, groupsId, teamId, processId, serialNumber, taskTypeEnum, startDate, endDate
         )
      );
   }

   @Override
   public ProductTeamSummaryDetailEnhanceDTO productTeamSummaryReportDetailPageV2(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskReportTypeEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      if (taskTypeEnum == null) {
         return null;
      }

      List<ProductTeamSummaryDetailDTO> detailList = this.baseMapper
         .productTeamSummaryReportDetailListV2(
            workshopId,
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            groupsId,
            teamId,
            processId,
            serialNumber,
            taskTypeEnum,
            startDate,
            endDate,
            taskReportTypeEnum
         );
      List<ProjectSimpleInfoDTO> projectSimpleInfoDTOS = this.projectService.listSimpleProject(null, null, null, null).getContent();
      List<Long> projectIds = projectSimpleInfoDTOS.stream().map(ProjectSimpleInfoDTO::getId).collect(Collectors.toList());
      detailList = detailList.stream().filter(e -> projectIds.contains(e.getProject().getId())).collect(Collectors.toList());
      int quantity = detailList.stream().mapToInt(ProductTeamSummaryDetailDTO::getQuantity).sum();
      BigDecimal totalNetWeight = detailList.stream().map(ProductTeamSummaryDetailDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalGrossWeight = detailList.stream().map(ProductTeamSummaryDetailDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
      return ProductTeamSummaryDetailEnhanceDTO.builder()
         .quantity(quantity)
         .totalNetWeight(totalNetWeight)
         .totalGrossWeight(totalGrossWeight)
         .detailPages(PageUtil.listPage(pageNumber, pageSize, detailList))
         .build();
   }

   @Override
   public List<ProductTeamSummaryDetailDTO> productTeamSummaryReportDetailList(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      return this.baseMapper
         .productTeamSummaryReportDetailList(
            workshopId, projectId, monomerId, areaId, areaBatchId, groupsId, teamId, processId, serialNumber, taskTypeEnum, startDate, endDate
         );
   }

   @Override
   public List<MesBuildingProcessDTO> getWorkshopByProcessList(Long workshopId) {
      return this.processBiz.getWorkshopByProcessList(workshopId);
   }

   @Override
   public List<MesBuildingProcessDTO> getWorkshopByProcessListV2(Long workshopId) {
      List<Long> teamIds = this.teamService
         .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getWorkshopId, workshopId).select(MesBuildingTeam::getId))
         .stream()
         .map(MesBuildingTeam::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(teamIds)) {
         return new ArrayList<>();
      }

      List<Long> processIds = this.productProcessLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductProcessLink.class)
               .in(workshopId != null && CollectionUtils.isNotEmpty(teamIds), MesBuildingProductProcessLink::getTeamId, teamIds)
               .select(MesBuildingProductProcessLink::getProcessId)
         )
         .stream()
         .map(MesBuildingProductProcessLink::getProcessId)
         .distinct()
         .collect(Collectors.toList());
      return CollectionUtils.isEmpty(processIds)
         ? new ArrayList<>()
         : this.processService.listByIds(processIds).stream().map(process -> BeanUtil.copy(process, MesBuildingProcessDTO.class)).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> productTeamSummaryReportDetailPrint(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskReportTypeEnum
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      String date = startDate != null && endDate != null ? DateTimeUtil.getLocalDateStr(startDate) + "-" + DateTimeUtil.getLocalDateStr(endDate) : "全部";
      String userName = teamId != null
         ? this.teamUserLinkService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
                  .eq(MesBuildingTeamUserLink::getTeamId, teamId)
                  .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, 1)
            )
            .getUserName()
         : "全部";
      header.put("date", date);
      if (taskReportTypeEnum != null) {
         header.put("date", date + "(" + TaskReportTypeEnum.getNameByType(taskReportTypeEnum) + ")");
      }

      header.put("process", this.processService.getById(processId).getName());
      header.put("userName", userName);
      printVO.setHeader(header);
      printVO.setTable(
         this.baseMapper
            .productTeamSummaryReportDetailListV2(
               workshopId,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               groupsId,
               teamId,
               processId,
               serialNumber,
               taskTypeEnum,
               startDate,
               endDate,
               taskReportTypeEnum
            )
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public AppTeamReportDetailsDTO teamReportDetailList(Long id) {
      List<MesBuildingProduceTeamReport> teamReports = this.list(
         Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).eq(MesBuildingProduceTeamReport::getReportNumber, id)
      );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamReports), "操作失败：传入id不正确");
      MesBuildingProduceTeamReport teamReport = teamReports.get(0);
      Long taskId = teamReport.getTaskId();
      MesBuildingTask task = this.taskService.getById(taskId);
      AppTeamReportDetailsDTO dto = AppTeamReportDetailsDTO.builder()
         .taskTypeEnum(teamReport.getTaskTypeEnum())
         .quantity(teamReport.getQuantity())
         .productId(teamReport.getProductId())
         .taskId(taskId)
         .build();
      Long taskProcessId = teamReport.getTaskProcessId();
      MesBuildingTaskProcess taskProcess = this.taskProcessBiz.getById(taskProcessId);
      ContractProject project = this.projectService.getById(taskProcess.getProjectId());
      ProjectDetailDO projectDetailDO = new ProjectDetailDO();
      BeanUtils.copyProperties(project, projectDetailDO);
      dto.setProject(projectDetailDO);
      PlanMonomer monomer = this.planMonomerService.getById(taskProcess.getMonomerId());
      MonomerDetailDO monomerDetailDO = new MonomerDetailDO();
      BeanUtils.copyProperties(monomer, monomerDetailDO);
      dto.setMonomer(monomerDetailDO);
      PlanArea area = this.planAreaService.getById(taskProcess.getAreaId());
      AreaDetailDO areaDetailDO = new AreaDetailDO();
      BeanUtils.copyProperties(area, areaDetailDO);
      dto.setArea(areaDetailDO);
      PlanAreaBatch areaBatch = this.areaBatchService.getById(taskProcess.getAreaBatchId());
      NameInfo nameInfo = new NameInfo();
      BeanUtils.copyProperties(areaBatch, nameInfo);
      dto.setAreaBatch(nameInfo);
      MesBuildingTeamUserLink leader = this.teamUserLinkService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .eq(MesBuildingTeamUserLink::getTeamId, teamReport.getTeamId())
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true)
         );
      User user = this.userService.getById(leader.getUserId());
      List<MesBuildingProduceInspectionTeamReport> inspectionTeamReports = this.inspectionTeamReportService
         .list(
            (Wrapper<MesBuildingProduceInspectionTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                  .eq(MesBuildingProduceInspectionTeamReport::getTaskProcessId, teamReport.getTaskProcessId()))
               .eq(MesBuildingProduceInspectionTeamReport::getNumber, teamReport.getNumber())
         );
      dto.setTeam(IdAndNameDO.builder().id(teamReport.getTeamId()).name(user.getName()).build());
      dto.setReportUser(user.getName());
      if (CollectionUtils.isNotEmpty(inspectionTeamReports)) {
         MesBuildingProduceInspectionTeamReport inspectionTeamReport = inspectionTeamReports.get(0);
         User inspectionUser = this.userService.getById(inspectionTeamReport.getUserId());
         if (inspectionUser != null) {
            dto.setInspectionUserNme(inspectionUser.getName());
         }
      }

      Long oderderId = taskProcess.getTaskOrderId();
      dto.setOrderNumber(this.orderService.getById(oderderId).getOrderNumber());
      MesBuildingProcess process = this.processService.getById(teamReport.getProcessId());
      dto.setProcess(IdAndNameDO.builder().id(process.getId()).name(process.getName()).build());
      dto.setReportType(process.getReportType());
      if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact product = this.techArtifactService.getById(teamReport.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
         dto.setCodingType(product.getCodingType());
         if (product.getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
            AppTaskProcessArtifactNumberDTO build = AppTaskProcessArtifactNumberDTO.builder()
               .number(teamReport.getNumber())
               .serialNumber(product.getSerialNumber())
               .build();
            List<AppTaskProcessArtifactNumberDTO> arrayList = new ArrayList<>();
            arrayList.add(build);
            dto.setArtifactNumberList(arrayList);
         }
      } else if (teamReport.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         TechAssemble product = this.assembleService.getById(teamReport.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
         dto.setCodingType(task.getBoolOneCode() ? 1 : 2);
         if (dto.getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
            AppTaskProcessArtifactNumberDTO build = AppTaskProcessArtifactNumberDTO.builder()
               .number(teamReport.getNumber())
               .serialNumber(product.getSerialNumber())
               .build();
            List<AppTaskProcessArtifactNumberDTO> arrayList = new ArrayList<>();
            arrayList.add(build);
            dto.setArtifactNumberList(arrayList);
         }
      }

      ProductLineDetailDTO lineDetailDTO = this.productionLineService.getTreeByLineId(teamReport.getProductionLineId());
      IdAndNameDO line = IdAndNameDO.builder().id(lineDetailDTO.getProductionLineId()).name(lineDetailDTO.getProductionLineName()).build();
      IdAndNameDO workShop = IdAndNameDO.builder().id(lineDetailDTO.getWorkshopId()).name(lineDetailDTO.getWorkshopName()).build();
      IdAndNameDO factory = IdAndNameDO.builder().id(lineDetailDTO.getFactoryId()).name(lineDetailDTO.getFactoryName()).build();
      dto.setProductionLine(line);
      dto.setGroups(line);
      dto.setWorkshop(workShop);
      dto.setFactory(factory);
      return dto;
   }

   @Override
   public MesBuildingProduceTeamReportDTO getTeamReportPrint(Long id) {
      return this.baseMapper.getTeamReportPrint(id);
   }

   @Override
   public List<produceTeamRecourseDTO> listproduceTeamByProcessIdAndProductIdAndType(Long processId, Long productId, Integer type, List<Long> groupId) {
      return this.baseMapper.listproduceTeamByProcessIdAndProductIdAndType(processId, productId, type, groupId);
   }

   @Override
   public ProcessKanBanAndQuantityDTO processProduceKanban(Long teamId, Long processId, Long groupsId) {
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .eq(MesBuildingTaskProcess::getProcessId, processId)
               .eq(MesBuildingTaskProcess::getGroupsId, groupsId)
         );
      Integer taskQuantity = taskProcessList.stream().mapToInt(MesBuildingTaskProcess::getTaskQuantity).sum();
      Integer inspectQuantity = taskProcessList.stream().mapToInt(MesBuildingTaskProcess::getInspectionQuantity).sum();
      Integer quantityDay = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .eq(MesBuildingProduceTeamReport::getTeamId, teamId)
               .eq(MesBuildingProduceTeamReport::getProcessId, processId)
               .eq(MesBuildingProduceTeamReport::getGroupsId, groupsId)
               .apply("date(create_time) =date(NOW())")
         )
         .stream()
         .mapToInt(MesBuildingProduceTeamReport::getInspectionQuantity)
         .sum();
      Integer quantityMonth = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .eq(MesBuildingProduceTeamReport::getTeamId, teamId)
               .eq(MesBuildingProduceTeamReport::getProcessId, processId)
               .eq(MesBuildingProduceTeamReport::getGroupsId, groupsId)
               .apply("DATE_FORMAT(create_time,'%Y/%m') = DATE_FORMAT(NOW(),'%Y/%m')")
         )
         .stream()
         .mapToInt(MesBuildingProduceTeamReport::getInspectionQuantity)
         .sum();
      Integer qhseQuantity = this.qhseTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceQhseTeamReport.class)
               .eq(MesBuildingProduceQhseTeamReport::getTeamId, teamId)
               .eq(MesBuildingProduceQhseTeamReport::getProcessId, processId)
         )
         .stream()
         .mapToInt(MesBuildingProduceQhseTeamReport::getQhseQuantity)
         .sum();
      return ProcessKanBanAndQuantityDTO.builder()
         .incompleteQuantity(taskQuantity - inspectQuantity)
         .dayQuantity(quantityDay)
         .monthQuantity(quantityMonth)
         .qhseQuantity(qhseQuantity)
         .build();
   }

   @Override
   public List<produceTeamRecourseDTO> listproduceInfo(List<Long> processId, Long productId, Integer type, List<Long> assitLinesIds) {
      return this.baseMapper.listproduceInfo(processId, productId, type, assitLinesIds);
   }

   @Override
   public List<produceTeamRecourseDTO> listProduceInfoByTypeAndNumber(
      List<Long> processId, Long productId, Integer type, List<Long> assitLinesIds, List<Integer> assembleNumberList
   ) {
      return this.baseMapper.listProduceInfoByTypeAndNumber(processId, productId, type, assitLinesIds, assembleNumberList);
   }

   @Override
   public Integer findAnnualTotal(Integer year, Long processId, Long userId) {
      return this.baseMapper.findAnnualTotal(year, processId, userId);
   }

   @Override
   public Integer findLastMonthTotal(Long processId, Long userId) {
      return this.baseMapper.findLastMonthTotal(processId, userId);
   }

   @Override
   public Integer findCurrentMonthTotal(Long processId, Long userId) {
      return this.baseMapper.findCurrentMonthTotal(processId, userId);
   }

   @Override
   public Integer findCurrentProjects(Long processId, Long userId) {
      return this.baseMapper.findCurrentProjects(processId, userId);
   }

   @Override
   public Integer findCurrentIncomplete(Long processId, Long userId) {
      return this.baseMapper.findCurrentIncomplete(processId, userId);
   }

   @Override
   public Integer findCurrentIncompleteOnAssist(Long processId, Long userId) {
      return this.baseMapper.findCurrentIncompleteOnAssist(processId, userId);
   }

   @Override
   public Integer findYesterdayTotal(Long processId, Long userId) {
      return this.baseMapper.findYesterdayTotal(processId, userId);
   }

   @Override
   public Integer findTodayTotal(Long processId, Long userId) {
      return this.baseMapper.findTodayTotal(processId, userId);
   }

   @Override
   public List<DateAndCount> getMonthlyOutputByYear(Integer year, Long processId, Long userId) {
      return this.baseMapper.getMonthlyOutputByYear(year, processId, userId);
   }

   @Override
   public PageVO<ReportRecordV2DTO> pageByConditionByDateV2(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long taskProcessId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long groupId,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean boolAll,
      Integer pageNumber,
      Integer pageSize
   ) {
      boolAll = boolAll != null && boolAll;
      List<Long> teamIds = new ArrayList<>();
      if (boolAll) {
         teamIds.add(teamId);
      } else if (teamId == null) {
         SecurityUser currentUser = UserUtil.getCurrentUser();
         teamIds = this.teamUserLinkService
            .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).eq(MesBuildingTeamUserLink::getUserId, currentUser.getId()))
            .stream()
            .map(MesBuildingTeamUserLink::getTeamId)
            .collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamIds), "当前用户不存在班组");
      } else {
         teamIds.add(teamId);
      }

      MesBuildingTaskProcess taskProcess = this.taskProcessBiz.getById(taskProcessId);
      taskTypeEnum = taskProcess.getTaskTypeEnum();
      List<ReportRecordV2DTO> dtos = this.baseMapper
         .listReportDataByDate(
            startDate,
            endDate,
            taskId,
            taskProcessId,
            processId,
            productId,
            taskProcess.getTaskTypeEnum(),
            groupId,
            teamIds,
            reportType,
            projectId,
            monomerId,
            areaId,
            workshopId,
            productLineId,
            factoryId,
            serialNumber,
            boolAll
         );
      PageVO<ReportRecordV2DTO> pageVO = new PageVO<>(dtos);
      if (CollectionUtils.isEmpty(dtos)) {
         return new PageVO<>();
      }

      List<ReportRecordNumbersV2DO> recNumers = dtos.stream()
         .map(
            dtox -> ReportRecordNumbersV2DO.builder()
               .taskProcessId(dtox.getTaskProcessId())
               .groupId(dtox.getGroups().getId())
               .teamId(dtox.getTeam().getId())
               .reportTime(dtox.getReportTime())
               .reportNumberId(dtox.getReportNumberId())
               .userId(dtox.getUser().getId())
               .build()
         )
         .collect(Collectors.toList());
      List<MesBuildingProduceTeamReport> reports = this.baseMapper
         .selectList(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).eq(MesBuildingProduceTeamReport::getTaskProcessId, taskProcessId));
      if ((taskTypeEnum & (TaskTypeEnum.ARTIFACT.getType() | TaskTypeEnum.ASSEMBLE.getType())) > 0) {
         Map<String, List<MesBuildingProduceTeamReport>> numberMap = reports.stream()
            .collect(
               Collectors.groupingBy(s -> s.getTaskProcessId() + "_" + s.getGroupsId() + "_" + s.getTeamId() + "_" + s.getUserId() + "_" + s.getReportNumber())
            );

         for (ReportRecordV2DTO dto : dtos) {
            dto.setCanInspectQuantity(dto.getReprotQuantity() - dto.getInspectionQuantity());
            if (dto.getBooleOneCode()) {
               String key = dto.getTaskProcessId()
                  + "_"
                  + dto.getGroups().getId()
                  + "_"
                  + dto.getTeam().getId()
                  + "_"
                  + dto.getUser().getId()
                  + "_"
                  + dto.getReportNumberId();
               List<MesBuildingProduceTeamReport> numbers = numberMap.get(key);
               dto.setNumber(numbers.get(0).getNumber());
            }
         }
      }

      return pageVO;
   }

   @Override
   public PageVO<ReportRecordV2DTO> pageByConditionByDateV3(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long taskProcessId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long groupId,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean boolAll,
      Boolean boolBatch,
      Integer pageNumber,
      Integer pageSize
   ) {
      boolAll = boolAll != null && boolAll;
      List<Long> teamIds = new ArrayList<>();
      if (boolAll) {
         teamIds.add(teamId);
      } else if (teamId != null || boolBatch != null && boolBatch) {
         if (boolBatch == null || !boolBatch) {
            teamIds.add(teamId);
         }
      } else {
         SecurityUser currentUser = UserUtil.getCurrentUser();
         teamIds = this.teamUserLinkService
            .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).eq(MesBuildingTeamUserLink::getUserId, currentUser.getId()))
            .stream()
            .map(MesBuildingTeamUserLink::getTeamId)
            .collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamIds), "当前用户不存在班组");
      }

      MesBuildingTaskProcess taskProcess = this.taskProcessBiz.getById(taskProcessId);
      taskTypeEnum = taskProcess.getTaskTypeEnum();
      List<ReportRecordV2DTO> dtos = this.baseMapper
         .listReportDataByDate2(
            startDate,
            endDate,
            taskId,
            taskProcessId,
            processId,
            productId,
            taskTypeEnum,
            teamIds,
            reportType,
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            workshopId,
            productLineId,
            factoryId,
            serialNumber,
            boolAll
         );
      PageVO<ReportRecordV2DTO> pageVO = new PageVO<>(dtos);
      if (CollectionUtils.isEmpty(dtos)) {
         return new PageVO<>();
      }

      List<MesBuildingProduceTeamReport> reports = this.baseMapper
         .selectList(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).eq(MesBuildingProduceTeamReport::getTaskProcessId, taskProcessId));
      if (CollectionUtils.isNotEmpty(reports)) {
         Map<String, List<MesBuildingTaskNumberLink>> numberLinkMaps = Collections.emptyMap();
         if (taskTypeEnum == TaskTypeEnum.ARTIFACT.getType()) {
            LambdaQueryWrapper<MesBuildingTaskNumberLink> queryWrapper = Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class);
            reports.stream()
               .filter(s -> s.getTaskTypeEnum() == TaskTypeEnum.ARTIFACT.getType())
               .forEach(
                  report -> queryWrapper.or(
                     wrapper -> {
                        LambdaQueryWrapper var10000 = wrapper.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, report.getTaskProcessId())
                           .eq(MesBuildingTaskNumberLink::getArtifactNumber, report.getNumber());
                     }
                  )
               );
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.numberLinkService.list(queryWrapper);
            numberLinkMaps = mesBuildingTaskNumberLinks.stream()
               .collect(Collectors.groupingBy(e -> e.getArtifactTaskProcessId() + "_" + e.getArtifactNumber()));
            Map<String, List<MesBuildingProduceTeamReport>> numberMap = reports.stream()
               .collect(
                  Collectors.groupingBy(
                     s -> s.getTaskProcessId() + "_" + s.getProductionLineId() + "_" + s.getTeamId() + "_" + s.getUserId() + "_" + s.getReportNumber()
                  )
               );
            Map<Long, MesBuildingProcess> processMap = this.processService
               .listByIds(mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNextProcessId).distinct().collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(s -> s.getId(), Function.identity()));

            for (ReportRecordV2DTO dto : dtos) {
               dto.setCanInspectQuantity(dto.getReprotQuantity() - dto.getInspectionQuantity());
               if (dto.getBooleOneCode()) {
                  String key = dto.getTaskProcessId()
                     + "_"
                     + dto.getProductionLine().getId()
                     + "_"
                     + dto.getTeam().getId()
                     + "_"
                     + dto.getUser().getId()
                     + "_"
                     + dto.getReportNumberId();
                  List<MesBuildingProduceTeamReport> numbers = numberMap.get(key);
                  dto.setNumber(numbers.get(0).getNumber());
                  String key2 = dto.getTaskProcessId() + "_" + dto.getNumber();
                  Long nextProcessId = numberLinkMaps.get(key2).get(0).getArtifactNextProcessId();
                  MesBuildingProcess process = processMap.get(nextProcessId);
                  IdAndNameDO build = null;
                  if (process != null) {
                     build = IdAndNameDO.builder().id(nextProcessId).name(process.getName()).build();
                  }

                  dto.setNextProcess(build);
               } else {
                  MesBuildingProcess process = processMap.get(
                     this.nextProcessLinkService
                        .getOne(Wrappers.lambdaQuery(MesBuildingNextProcessLink.class).eq(MesBuildingNextProcessLink::getTaskProcessId, dto.getTaskProcessId()))
                        .getNextProcessId()
                  );
                  if (process != null) {
                     dto.setNextProcess(IdAndNameDO.builder().id(process.getId()).name(process.getName()).build());
                  }
               }
            }
         }

         if (taskTypeEnum == TaskTypeEnum.ASSEMBLE.getType()) {
            LambdaQueryWrapper<MesBuildingTaskNumberLink> queryWrapper = Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class);
            reports.stream()
               .filter(s -> s.getTaskTypeEnum() == TaskTypeEnum.ASSEMBLE.getType())
               .forEach(
                  report -> queryWrapper.or(
                     wrapper -> {
                        LambdaQueryWrapper var10000 = wrapper.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, report.getTaskProcessId())
                           .eq(MesBuildingTaskNumberLink::getAssembleNumber, report.getNumber());
                     }
                  )
               );
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.numberLinkService.list(queryWrapper);
            numberLinkMaps = mesBuildingTaskNumberLinks.stream()
               .collect(Collectors.groupingBy(e -> e.getAssembleTaskProcessId() + "_" + e.getAssembleNumber()));
            Map<String, List<MesBuildingProduceTeamReport>> numberMap = reports.stream()
               .collect(
                  Collectors.groupingBy(
                     s -> s.getTaskProcessId() + "_" + s.getProductionLineId() + "_" + s.getTeamId() + "_" + s.getUserId() + "_" + s.getReportNumber()
                  )
               );
            Map<Long, MesBuildingProcess> processMap = this.processService
               .listByIds(mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNextProcessId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(s -> s.getId(), Function.identity()));

            for (ReportRecordV2DTO dto : dtos) {
               dto.setCanInspectQuantity(dto.getReprotQuantity() - dto.getInspectionQuantity());
               if (dto.getBooleOneCode()) {
                  String key = dto.getTaskProcessId()
                     + "_"
                     + dto.getProductionLine().getId()
                     + "_"
                     + dto.getTeam().getId()
                     + "_"
                     + dto.getUser().getId()
                     + "_"
                     + dto.getReportNumberId();
                  List<MesBuildingProduceTeamReport> numbers = numberMap.get(key);
                  dto.setNumber(numbers.get(0).getNumber());
                  String key2 = dto.getTaskProcessId() + "_" + dto.getNumber();
                  Long nextProcessId = numberLinkMaps.get(key2).get(0).getAssembleNextProcessId();
                  MesBuildingProcess process = processMap.get(nextProcessId);
                  IdAndNameDO build = null;
                  if (process != null) {
                     build = IdAndNameDO.builder().id(nextProcessId).name(process.getName()).build();
                  }

                  dto.setNextProcess(build);
               } else {
                  MesBuildingProcess process = processMap.get(
                     this.nextProcessLinkService
                        .getOne(Wrappers.lambdaQuery(MesBuildingNextProcessLink.class).eq(MesBuildingNextProcessLink::getTaskProcessId, dto.getTaskProcessId()))
                        .getNextProcessId()
                  );
                  if (process != null) {
                     dto.setNextProcess(IdAndNameDO.builder().id(process.getId()).name(process.getName()).build());
                  }
               }
            }
         }
      }

      return pageVO;
   }

   @Override
   public List<MesBuildingProduceTeamReport> listReports(List<NumberInfoDTO> numberInfos, Integer taskType) {
      return this.baseMapper.listReports(numberInfos, taskType);
   }

   @Override
   public List<MesBuildingReportNumberStatusDTO> listStatusBydata(
      List<ProductProduceCargoDTO> dtos, Integer taskType, Long areaId, Long monomerId, Long projectId
   ) {
      return this.baseMapper.listStatusBydata(dtos, taskType, areaId, monomerId, projectId);
   }

   @Override
   public List<TeamReportRealTimeInfoDTO> productTeamReportRealTimeInfo(Long workshopId) {
      LocalDateTime now = LocalDateTime.now();
      LocalDateTime monthStart = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
      LocalDateTime monthEnd = now.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59).withNano(999);
      List<TeamReportRealTimeInfoDTO> avgCapabilityList = this.baseMapper.productTeamReportAvgInfo(workshopId);
      List<TeamReportRealTimeInfoDTO> ongoingTaskList = this.baseMapper.productTeamReportRealTimeInfo(workshopId);
      List<TeamReportRealTimeInfoDTO> scheduledOutputList = this.baseMapper.getCurrentMonthScheduledOutput(workshopId, monthStart, monthEnd);
      Map<String, TeamReportRealTimeInfoDTO> ongoingTaskMap = ongoingTaskList.stream()
         .collect(Collectors.toMap(taskx -> taskx.getShopName() + taskx.getLineName(), Function.identity()));
      Map<String, TeamReportRealTimeInfoDTO> scheduledOutputMap = scheduledOutputList.stream()
         .collect(Collectors.toMap(taskx -> taskx.getShopName() + taskx.getLineName(), Function.identity()));
      if (CollectionUtils.isEmpty(avgCapabilityList) && CollectionUtils.isEmpty(ongoingTaskList)) {
         return new ArrayList<>();
      }

      Map<Long, BigDecimal> lineAvgMonthMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(avgCapabilityList)) {
         LocalDateTime currentTime = LocalDateTime.now();
         List<Long> uniqueLineIds = avgCapabilityList.stream().map(TeamReportRealTimeInfoDTO::getLineId).distinct().collect(Collectors.toList());
         lineAvgMonthMap = this.productionLineService.listByIds(uniqueLineIds).stream().collect(Collectors.toMap(MesBuildingProductionLine::getId, line -> {
            LocalDateTime createTime = line.getCreateTime();
            if (createTime.getYear() < currentTime.getYear()) {
               return BigDecimal.valueOf(currentTime.getMonthValue());
            }

            int daysBetween = (int)ChronoUnit.DAYS.between(createTime.toLocalDate(), currentTime.toLocalDate());
            return BigDecimal.valueOf(daysBetween / 30.0).setScale(4, RoundingMode.HALF_UP);
         }));
      }

      for (TeamReportRealTimeInfoDTO avgDto : avgCapabilityList) {
         String key = avgDto.getShopName() + avgDto.getLineName();
         TeamReportRealTimeInfoDTO ongoingTask = ongoingTaskMap.get(key);
         TeamReportRealTimeInfoDTO scheduledOutput = scheduledOutputMap.get(key);
         BigDecimal avgMonth = lineAvgMonthMap.getOrDefault(avgDto.getLineId(), BigDecimal.ZERO);
         if (avgMonth.compareTo(BigDecimal.ZERO) > 0) {
            avgDto.setAvgNetWeight(avgDto.getAvgNetWeight().divide(avgMonth, 4, RoundingMode.HALF_UP));
         }

         if (scheduledOutput != null) {
            avgDto.setCurrentMonthScheduling(scheduledOutput.getCurrentMonthScheduling().round(new MathContext(4)));
            scheduledOutputMap.remove(key);
         } else {
            avgDto.setCurrentMonthScheduling(BigDecimal.ZERO);
         }

         if (ongoingTask != null) {
            avgDto.setUnTotalNetWeight(ongoingTask.getUnTotalNetWeight().round(new MathContext(4)));
            ongoingTaskMap.remove(key);
         } else {
            avgDto.setUnTotalNetWeight(BigDecimal.ZERO);
         }
      }

      if (CollectionUtils.isNotEmpty(ongoingTaskMap)) {
         for (TeamReportRealTimeInfoDTO task : ongoingTaskMap.values()) {
            String key = task.getShopName() + task.getLineName();
            TeamReportRealTimeInfoDTO scheduledOutput = scheduledOutputMap.get(key);
            if (scheduledOutput != null) {
               task.setCurrentMonthScheduling(scheduledOutput.getCurrentMonthScheduling().round(new MathContext(4)));
            } else {
               task.setCurrentMonthScheduling(BigDecimal.ZERO);
            }

            task.setAvgNetWeight(BigDecimal.ZERO);
            avgCapabilityList.add(task);
         }
      }

      return avgCapabilityList;
   }

   @Override
   public List<LastProcessInfoDTO> lastProcessInfo(Map<Long, List<Integer>> taskNumberMap) {
      return this.baseMapper.lastProcessInfo(taskNumberMap);
   }

   @Override
   public List<LastProcessInfoDTO> lastProcessBatchInfo(Map<Long, List<Integer>> taskNumberMap) {
      return this.baseMapper.lastProcessBatchInfo(taskNumberMap);
   }

   @Override
   public List<TeamProduceProcessInfoDTO> findEachTeamProduceInfo(Long workshopId, Long projectId, LocalDateTime startDate, LocalDateTime endDate) {
      return this.baseMapper.findEachTeamProduceInfo(workshopId, projectId, startDate, endDate);
   }

   @Override
   public List<TeamProduceProcessDetailDTO> findEachTeamProduceDetail(
      Long workshopId, Long projectId, Long monomerId, Long areaId, Long teamId, Long processId, LocalDateTime startDate, LocalDateTime endDate
   ) {
      MesBuildingProcess process = this.processService.getById(processId);
      return this.baseMapper
         .findEachTeamProduceDetailV2(workshopId, projectId, monomerId, areaId, teamId, processId, process.getProductType(), startDate, endDate);
   }

   @Override
   public List<TeamCapacityAnalysisDTO> findTeamCapacityAnalysis(Long workShopId, LocalDateTime date) {
      LocalDateTime now = LocalDateTime.now();
      if (date == null) {
         date = now;
      }

      List<MesBuildingTeam> teamList = this.teamService
         .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(workShopId != null, MesBuildingTeam::getWorkshopId, workShopId));
      if (CollectionUtil.isEmpty(teamList)) {
         return new ArrayList<>();
      }

      List<Long> teamIds = teamList.stream().map(e -> e.getId()).collect(Collectors.toList());
      Map<Long, Long> userLinkMap = this.teamUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).in(MesBuildingTeamUserLink::getTeamId, teamIds))
         .stream()
         .collect(Collectors.groupingBy(e -> e.getTeamId(), Collectors.counting()));
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<TeamCapacityAnalysisDTO> monthRateDTOS = this.taskService.findTeamCapacityAnalysis(teamIds, date, projectIds);

      for (TeamCapacityAnalysisDTO rateDTO : monthRateDTOS) {
         Map<String, TeamEachMonthRateDTO> teamMonthDTO = rateDTO.getEachMonthDTO()
            .stream()
            .collect(Collectors.toMap(s -> s.getTeamId() + "_" + s.getDate(), Function.identity()));

         for (String month : DateTimeUtil.getMonths(12)) {
            TeamEachMonthRateDTO monthRateDTO = teamMonthDTO.get(rateDTO.getTeam().getId() + "_" + month);
            if (monthRateDTO == null) {
               monthRateDTO = new TeamEachMonthRateDTO();
               monthRateDTO.setDate(month);
               monthRateDTO.setTotalCompleteWeight(BigDecimal.ZERO);
               rateDTO.getEachMonthDTO().add(monthRateDTO);
            }
         }

         rateDTO.setTeamNumber(Math.toIntExact(userLinkMap.get(rateDTO.getTeam().getId())));
         BigDecimal reduce = rateDTO.getEachMonthDTO().stream().map(e -> e.getTotalCompleteWeight()).reduce(BigDecimal.ZERO, BigDecimal::add);
         int monthValue = getMonthValue(date, now.getYear());
         BigDecimal avgWeight = reduce.divide(new BigDecimal(monthValue), 0, RoundingMode.HALF_UP);
         rateDTO.setTotalWeight(reduce);
         rateDTO.setAvgWeight(avgWeight);
      }

      return monthRateDTOS;
   }

   @Override
   public PageVO<TeamCapacityAnalysisDTO> findTeamCapacityAnalysisV2(Long workShopId, LocalDateTime date, Integer pageNumber, Integer pageSize) {
      LocalDateTime now = LocalDateTime.now();
      if (date == null) {
         date = now;
      }

      List<MesBuildingTeam> teamList = this.teamService
         .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(workShopId != null, MesBuildingTeam::getWorkshopId, workShopId));
      if (CollectionUtil.isEmpty(teamList)) {
         return new PageVO<>();
      }

      List<Long> teamIds = teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList());
      Map<Long, Long> userLinkMap = this.teamUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).in(MesBuildingTeamUserLink::getTeamId, teamIds))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTeamUserLink::getTeamId, Collectors.counting()));
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      List<TeamCapacityAnalysisDTO> monthRateDTOS = this.taskService.findTeamCapacityAnalysis(teamIds, date, projectIds);

      for (TeamCapacityAnalysisDTO rateDTO : monthRateDTOS) {
         Map<String, TeamEachMonthRateDTO> teamMonthDTO = rateDTO.getEachMonthDTO()
            .stream()
            .collect(Collectors.toMap(s -> rateDTO.getTeam().getId() + "_" + s.getDate(), Function.identity()));

         for (int i = 1; i <= 12; i++) {
            TeamEachMonthRateDTO monthRateDTO = teamMonthDTO.get(rateDTO.getTeam().getId() + "_" + date.getYear() + "-" + String.format("%02d", i));
            if (monthRateDTO == null) {
               monthRateDTO = new TeamEachMonthRateDTO();
               monthRateDTO.setDate(date.getYear() + "-" + String.format("%02d", i));
               monthRateDTO.setTotalCompleteWeight(BigDecimal.ZERO);
               rateDTO.getEachMonthDTO().add(monthRateDTO);
            }
         }

         rateDTO.setTeamNumber(Math.toIntExact(userLinkMap.get(rateDTO.getTeam().getId())));
         BigDecimal reduce = rateDTO.getEachMonthDTO().stream().map(TeamEachMonthRateDTO::getTotalCompleteWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
         int monthValue = getMonthValue(date, now.getYear());
         BigDecimal avgWeight = reduce.divide(new BigDecimal(monthValue), 0, RoundingMode.HALF_UP);
         rateDTO.setTotalWeight(reduce);
         rateDTO.setAvgWeight(avgWeight);
      }

      return PageUtil.listPage(pageNumber, pageSize, monthRateDTOS);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> findEachTeamProduceDetailPrint(
      Long workshopId, Long projectId, Long monomerId, Long areaId, Long teamId, Long processId, LocalDateTime startDate, LocalDateTime endDate
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      String date = startDate != null && endDate != null ? DateTimeUtil.getLocalDateStr(startDate) + "-" + DateTimeUtil.getLocalDateStr(endDate) : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      MesBuildingProcess process = this.processService.getById(processId);
      printVO.setTable(
         this.baseMapper
            .findEachTeamProduceDetailV2(workshopId, projectId, monomerId, areaId, teamId, processId, process.getProductType(), startDate, endDate)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public void findTeamCapacityAnalysisDownload(Long workShopId, LocalDateTime date) {
      try {
         HashMap<String, Object> result = new HashMap<>();
         List<TeamCapacityAnalysisDTO> resultList = this.findTeamCapacityAnalysisV2List(workShopId, date);
         if (!CollectionUtils.isEmpty(resultList)) {
            ArrayList<HashMap<String, Object>> resultRowList = new ArrayList<>();
            AtomicReference<Long> orderNo = new AtomicReference<>(0L);
            resultList.forEach(
               e -> {
                  orderNo.set(orderNo.get() + 1L);
                  HashMap<String, Object> rowsMap = new HashMap<>();
                  rowsMap.put("id", orderNo.get());
                  rowsMap.put("workShopName", e.getWorkshop().getName());
                  rowsMap.put("processName", e.getProcess().getName());
                  rowsMap.put("teamName", e.getTeam().getName());
                  rowsMap.put("teamNumber", e.getTeamNumber());
                  rowsMap.put("totalWeight", e.getTotalWeight().divide(BigDecimal.valueOf(1000L), 5, 4).stripTrailingZeros());
                  rowsMap.put("avgWeight", e.getAvgWeight().divide(BigDecimal.valueOf(1000L), 5, 4).stripTrailingZeros());
                  e.getEachMonthDTO()
                     .forEach(mete -> rowsMap.put(mete.getDate(), mete.getTotalCompleteWeight().divide(BigDecimal.valueOf(1000L), 5, 4).stripTrailingZeros()));
                  resultRowList.add(rowsMap);
               }
            );
            result.put("resultList", resultRowList);
            result.put(
               "titles",
               resultList.get(0)
                  .getEachMonthDTO()
                  .stream()
                  .sorted(Comparator.comparing(TeamEachMonthRateDTO::getDate))
                  .map(e -> createTitleEL(e.getDate()))
                  .collect(Collectors.toList())
            );
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            HttpServletResponse response = servletRequestAttributes.getResponse();
            String tempFileName = "TeamCapacityAnalysis";
            String resourcePath = "files/MesBuildingTeamCapacity2.xlsx";
            String exportFileName = "班组产量分析信息.xlsx";
            org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
            InputStream inputStream = resource.getInputStream();
            File file = File.createTempFile(tempFileName, "xlsx");
            FileUtil.copyInputStreamToFile(inputStream, file);
            TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
            params.setColForEach(true);
            Workbook workbook = ExcelExportUtil.exportExcel(params, result);
            PoiUtils.downLoadExcel(exportFileName, response, workbook);
         }
      } catch (Throwable $ex) {
         throw MesBuildingProduceTeamReportServiceImpl.<RuntimeException>rethrow($ex);
      }
   }

   private List<TeamCapacityAnalysisDTO> findTeamCapacityAnalysisV2List(Long workShopId, LocalDateTime date) {
      LocalDateTime now = LocalDateTime.now();
      if (date == null) {
         date = now;
      }

      List<MesBuildingTeam> teamList = this.teamService
         .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(workShopId != null, MesBuildingTeam::getWorkshopId, workShopId));
      if (CollectionUtil.isEmpty(teamList)) {
         return new ArrayList<>();
      }

      List<Long> teamIds = teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList());
      Map<Long, Long> userLinkMap = this.teamUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingTeamUserLink.class).in(MesBuildingTeamUserLink::getTeamId, teamIds))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTeamUserLink::getTeamId, Collectors.counting()));
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<TeamCapacityAnalysisDTO> monthRateDTOS = this.taskService.findTeamCapacityAnalysis(teamIds, date, projectIds);

      for (TeamCapacityAnalysisDTO rateDTO : monthRateDTOS) {
         Map<String, TeamEachMonthRateDTO> teamMonthDTO = rateDTO.getEachMonthDTO()
            .stream()
            .collect(Collectors.toMap(s -> rateDTO.getTeam().getId() + "_" + s.getDate(), Function.identity()));

         for (int i = 1; i <= 12; i++) {
            TeamEachMonthRateDTO monthRateDTO = teamMonthDTO.get(rateDTO.getTeam().getId() + "_" + date.getYear() + "-" + String.format("%02d", i));
            if (monthRateDTO == null) {
               monthRateDTO = new TeamEachMonthRateDTO();
               monthRateDTO.setDate(date.getYear() + "-" + String.format("%02d", i));
               monthRateDTO.setTotalCompleteWeight(BigDecimal.ZERO);
               rateDTO.getEachMonthDTO().add(monthRateDTO);
            }
         }

         rateDTO.setTeamNumber(Math.toIntExact(userLinkMap.get(rateDTO.getTeam().getId())));
         BigDecimal reduce = rateDTO.getEachMonthDTO().stream().map(TeamEachMonthRateDTO::getTotalCompleteWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
         int monthValue = getMonthValue(date, now.getYear());
         BigDecimal avgWeight = reduce.divide(new BigDecimal(monthValue), 0, RoundingMode.HALF_UP);
         rateDTO.setTotalWeight(reduce);
         rateDTO.setAvgWeight(avgWeight);
      }

      return monthRateDTOS;
   }

   private static Map<String, Object> createTitleEL(String dateStr) {
      Map<String, Object> title = new HashMap<>();
      title.put("dateStr", dateStr);
      title.put("mete", "t." + dateStr);
      return title;
   }

   public static int getMonthValue(LocalDateTime date, int currentYear) {
      return date.getYear() < currentYear ? 12 : date.getMonthValue();
   }

   @Override
   public List<DateQuantityDTO> findAchievementGroupWorkshop(LocalDate date) {
      return this.baseMapper.findAchievementGroupWorkshop(date);
   }

   @Override
   public List<MesBuildingQualityInspectionDTO> getQualityInspectionDetails(List<Long> teamReportIds) {
      return this.baseMapper.getQualityInspectionTimingDetails(teamReportIds);
   }

   @Override
   public List<MesBuildingQualityInspectionDTO> getQualityInspectionDefiniteNumberDetails() {
      return this.baseMapper.getQualityInspectionDefiniteNumberDetails();
   }

   @Override
   public List<TeamProduceInfoDTO> findTeamProjectProduceInfo(int year, Long workShopId, Long productionId) {
      return this.baseMapper.findTeamProjectProduceInfo(year, workShopId, productionId);
   }

   @Override
   public List<WorkshopProduceInfoDTO> findWorkshopProjectProduceInfo(Integer year, Long workShopId, Long productionId) {
      return this.baseMapper.findWorkshopProjectProduceInfoV2(year, workShopId, productionId);
   }

   @Override
   public List<InspectRealtimeInfoDTO> findInspectRealtimeInfo(Long workShopId, Long productionId) {
      return this.baseMapper.findInspectRealtimeInfo(workShopId, productionId);
   }

   @Override
   public List<MesDailyProductionQuerySumDTO> getMesDailyProductionTaskSum(MesDailyProductionTaskDOParam param) {
      return this.baseMapper.getMesDailyProductionTaskSum(param);
   }

   @Override
   public List<MesDailyProductionQuerySumDTO> getProductionDetail(
      Long projectId, Long workShopId, Long teamId, Long monomerId, LocalDateTime dateTime, Long processId, Integer meteUnitEnum, List<Long> productionLineIds
   ) {
      return this.baseMapper.getProductionDetail(projectId, workShopId, teamId, monomerId, dateTime, processId, meteUnitEnum, productionLineIds);
   }

   @Override
   public List<ArtifactReportSourceDTO> assembleSourceReportProductList(Long productId, Integer number, Long taskId) {
      return this.baseMapper.assembleSourceReportProductList(productId, number, taskId);
   }

   @Override
   public List<ReportRecordV2DTO> listBatchReportDataByDate2List(List<BatchInspectDTO> dtos, Integer taskTypeEnum) {
      return this.baseMapper.listBatchReportDataByDate2List(dtos, taskTypeEnum);
   }

   @Override
   public List<MesTeamReportProductStaticsDTO> getTeamReportProductList(
      Integer productType,
      Long workShopId,
      Long productionLineId,
      Long teamId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      List<LocalDateTime> dateTimeList
   ) {
      return this.baseMapper
         .getTeamReportProductList(
            productType, workShopId, productionLineId, teamId, projectId, monomerId, areaId, areaBatchId, processId, serialNumber, dateTimeList
         );
   }

   @Override
   public List<DateMeteDTO> getProductionSummary(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getProductionSummary(projectIds, year, LocalDate.now().getYear(), branchCompanyId, workshopId);
   }

   @Override
   public List<DateMeteDTO> getProductionMonthly(LocalDate year, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getProductionMonthly(year, branchCompanyId, workshopId);
   }

   @Override
   public List<DateMeteDTO> getProductionMonthlyV2(List<Long> projectIds, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getProductionMonthlyV2(projectIds, startDate, endDate, branchCompanyId, workshopId);
   }

   @Override
   public List<DateMeteDTO> getNumbersMonthly(List<Long> projectIds, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getNumbersMonthly(projectIds, startDate, endDate, branchCompanyId, workshopId);
   }

   @Override
   public List<DateMeteDTO> getNumbersYear(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getNumbersYear(projectIds, year, LocalDate.now().getYear(), branchCompanyId, workshopId);
   }

   @Override
   public List<DateMeteDTO> getProductionDay(List<Long> projectIds, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getProductionDay(projectIds, yearDate, mouthDate, branchCompanyId, workshopId);
   }

   @Override
   public List<ProjectMeteDTO> getProjectMete(List<Long> projectIds, LocalDate dateTime, Long branchCompanyId, Long workshopId, Boolean isMonthly) {
      return this.baseMapper.getProjectMete(projectIds, dateTime, branchCompanyId, workshopId, isMonthly);
   }

   @Override
   public List<DateMeteDTO> getSchedulingMonthly(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getSchedulingMonthly(projectIds, year, branchCompanyId, workshopId);
   }

   @Override
   public List<DateMeteDTO> getYearSchedulingProductionInfo(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getYearSchedulingProductionInfo(projectIds, year, branchCompanyId, workshopId);
   }

   @Override
   public List<ProjectMeteDTO> getProjectSchedulingProductionInfo(List<Long> projectIds, LocalDate yearMonth, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getProjectSchedulingProductionInfo(projectIds, yearMonth, branchCompanyId, workshopId);
   }

   @Override
   public List<TeamProduceOperateAnalyseDTO> getTeamProduceOperateAnalyse(
      List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId, Long processId
   ) {
      return this.baseMapper.getTeamProduceOperateAnalyse(projectIds, year, branchCompanyId, workshopId, processId);
   }

   @Override
   public List<TeamProduceOperateAnalyseDetailsDTO> getTeamProduceDetailsOperateAnalyse(
      List<Long> projectIds,
      LocalDate yearDate,
      LocalDate startDate,
      LocalDate endDate,
      Long branchCompanyId,
      Long workshopId,
      Long teamId,
      Integer taskTypeEnum,
      Long processId
   ) {
      return this.baseMapper
         .getTeamProduceDetailsOperateAnalyse(projectIds, yearDate, startDate, endDate, branchCompanyId, workshopId, teamId, taskTypeEnum, processId);
   }

   @Override
   public List<DateMeteDTO> getProductionGroupMonth(Long projectId, LocalDate year, Long branchCompanyId, Integer taskType) {
      return this.baseMapper.getProductionGroupMonth(projectId, year, branchCompanyId, taskType);
   }

   @Override
   public void getProductionGroupMonthDownload(Long projectId, Long branchCompanyId, Integer taskType, HttpServletResponse response) {
      ProjectProductionMeteDTO productionMeteDTO = this.projectService.getProjectProductionMete(projectId, branchCompanyId);
      BigDecimal deepMete = BigDecimal.ZERO;
      if (ProductTypeEnum.ARTIFACT.getType().equals(taskType)) {
         deepMete = productionMeteDTO.getArtifactDeepMete();
      }

      if (ProductTypeEnum.ASSEMBLE.getType().equals(taskType)) {
         deepMete = productionMeteDTO.getAssembleDeepMete();
      }

      if (ProductTypeEnum.MACHINE_PART.getType().equals(taskType)) {
         deepMete = productionMeteDTO.getPartMete();
      }

      List<DateMeteDTO> groupMonthList = this.getProductionGroupMonth(projectId, null, branchCompanyId, taskType);
      if (!CollectionUtils.isEmpty(groupMonthList)) {
         String title = "";
         if (branchCompanyId != null) {
            BranchCompany branchCompany = this.branchCompanyService.getById(branchCompanyId);
            if (branchCompany != null) {
               title = title + "分支机构：" + branchCompany.getName() + "\n";
            }
         }

         if (projectId != null) {
            ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
            if (projectInfo != null) {
               title = title + "项目：" + projectInfo.getName() + "\n";
            }
         }

         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "日期"));
         headList.add(Arrays.asList(title, "累计生产（吨）"));
         headList.add(Arrays.asList(title, "完成率"));
         List<List<Object>> dataList = new ArrayList<>();
         BigDecimal finalDeepMete = deepMete;
         groupMonthList.forEach(ex -> {
            BigDecimal mete = ex.getMete();
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            data.add(ex.getDateTime());
            data.add(mete.divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP));
            if (finalDeepMete.compareTo(BigDecimal.ZERO) != 0) {
               data.add(mete.multiply(BigDecimal.valueOf(100L)).divide(finalDeepMete, 2, RoundingMode.HALF_UP));
            } else {
               data.add(BigDecimal.ZERO);
            }

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
   public List<DateMeteDTO> getProductionYear(List<LocalDate> dateList, Long branchCompanyId, Long workshopId) {
      return this.baseMapper.getProductionYear(dateList, branchCompanyId, workshopId);
   }

   @Override
   public List<UserProductionSummaryDTO> UserProductionSummary(Long projectId, Integer taskTypeEnum, LocalDateTime startDate, LocalDateTime endDate) {
      return this.baseMapper.UserProductionSummary(projectId, taskTypeEnum, startDate, endDate);
   }

   @Override
   public PageVO<UserProductionDetailDTO> UserProductionDetailList(
      Long projectId,
      Long monomerId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long userId,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<UserProductionDetailDTO> dtos = this.baseMapper
         .UserProductionDetailList(projectId, monomerId, serialNumber, taskTypeEnum, startDate, endDate, userId);
      return new PageVO<>(dtos);
   }

   @Override
   public void UserProductionSummaryDownload(Long projectId, Integer taskTypeEnum, LocalDateTime startDate, LocalDateTime endDate, HttpServletResponse response) {
      List<UserProductionSummaryDTO> dtos = this.baseMapper.UserProductionSummary(projectId, taskTypeEnum, startDate, endDate);
      List<Map<String, Object>> productionList = new ArrayList<>();
      Map<String, Object> exportMap = new HashMap<>();
      AtomicInteger index = new AtomicInteger(0);
      dtos.forEach(ex -> {
         Map<String, Object> map = BeanUtil.beanToMap(ex);
         map.put("number", index.incrementAndGet());
         productionList.add(map);
         exportMap.put("productionList", productionList);
      });

      try {
         String tempFileName = "UserProductionSummary";
         String resourcePath = "files/UserProductionSummary.xlsx";
         String exportFileName = "个人产量统计.xlsx";
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
         PoiUtils.downNoBuildCellLoadExcel(exportFileName, response, workbook);
      } catch (IOException e) {
         throw new BusinessException(ResultCodeEnum.ERROR, e.getMessage());
      }
   }

   @Override
   public void UserProductionDetailDownload(
      Long projectId,
      Long monomerId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long userId,
      HttpServletResponse response
   ) {
      List<UserProductionDetailDTO> dtos = this.baseMapper
         .UserProductionDetailList(projectId, monomerId, serialNumber, taskTypeEnum, startDate, endDate, userId);
      List<Map<String, Object>> productionList = new ArrayList<>();
      Map<String, Object> exportMap = new HashMap<>();
      AtomicInteger index = new AtomicInteger(0);
      dtos.forEach(ex -> {
         Map<String, Object> map = BeanUtil.beanToMap(ex);
         map.put("number", index.incrementAndGet());
         productionList.add(map);
         exportMap.put("productionList", productionList);
      });

      try {
         String tempFileName = "UserProductionDetailList";
         String resourcePath = "files/UserProductionDetailList.xlsx";
         String exportFileName = "个人产量详情.xlsx";
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
         PoiUtils.downNoBuildCellLoadExcel(exportFileName, response, workbook);
      } catch (IOException e) {
         throw new BusinessException(ResultCodeEnum.ERROR, e.getMessage());
      }
   }

   @Transactional
   @Override
   public Boolean teamReportMarked(NameInfo dto) {
      List<MesBuildingProduceTeamReport> produceTeamReportList = this.baseMapper
         .selectList((Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>().eq(MesBuildingProduceTeamReport::getReportNumber, dto.getId()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(produceTeamReportList), "操作失败,产品上报记录不存在!");
      List<MesBuildingProduceTeamReport> reports = produceTeamReportList.stream()
         .sorted(Comparator.comparing(MesBuildingProduceTeamReport::getBoolMarked))
         .collect(Collectors.toList());
      MesBuildingProduceTeamReport produceTeamReport = reports.get(0);
      if (!produceTeamReport.getBoolMarked()) {
         produceTeamReport.setBoolMarked(Boolean.TRUE);
         produceTeamReport.setMarkingTime(LocalDateTime.now());
         produceTeamReport.setMarkedQuantity(1);
         this.baseMapper.updateById(produceTeamReport);
      }

      return Boolean.TRUE;
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
