package com.hzchum.scim.mes.building.core.biz.impl.qhseBiz;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.Img;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AnhuanExposureDTO;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseBiz;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseInspectionLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNewTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhsePowerTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.SaveProduceTeamReportSummaryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.MesBuildingQhseDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseAcceptDeviation;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseInspectionLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseRectify;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingSpotCheckQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceQhseTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.ArtifactQhseSpotCheckDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.LastSendPersonDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseAcceptDeviationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDataExcelDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseProblemDataExcelDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseRectifyDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDowloadDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsDetailDowloadDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.PaintThicknessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.PaintThicknessSaveDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.ArtifactNumberQualifiedQuantityDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.MesBuildingCheckQhseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.MesBuildingQhseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.MesBuildingQhseRectifyDTOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseAcceptDeviationService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseInspectionLinkService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseRectifyService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingSpotCheckQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceQhseTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReportPaintThicknessLink;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.task.MesBuildingProduceInspectionTeamReportPaintThicknessLinkService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesSafetyClassConfig;
import com.hzchum.scim.system.core.api.pojo._do.PaintThicknessDO;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.system.core.api.service.MesQualityClassConfigService;
import com.hzchum.scim.system.core.api.service.MesSafetyClassConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingQhseBizImpl implements MesBuildingQhseBiz {
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingQhseInspectionLinkBiz mesBuildingQhseInspectionLinkBiz;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingQhseService mesBuildingQhseService;
   @Autowired
   private MesBuildingQhseUserLinkService qhseUserLinkService;
   @Autowired
   private MesBuildingQhseRectifyService qhseRectifyService;
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private AttachmentService attachmentService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private SysDictionaryService dictionaryService;
   @Autowired
   private MesBuildingUtilsBiz mesBuildingUtilsBiz;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Autowired
   private UserService userService;
   @Autowired
   private MesBuildingProduceQhseTeamReportService qhseTeamReportService;
   @Autowired
   private MesBuildingQhseInspectionLinkBiz qhseInspectionLinkBiz;
   @Autowired
   private MesBuildingQhseInspectionLinkService qhseInspectionLinkService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Resource
   private TechDrawingService drawingService;
   @Autowired
   private TechArtifactExtService artifactExtService;
   @Autowired
   private TechAssembleExtService assembleExtService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService planMonomerService;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Resource
   private ConfigProperties configProperties;
   @Autowired
   private MesBuildingProduceTeamReportService mesBuildingProduceTeamReportService;
   @Autowired
   private MesInspectConfigService inspectConfigService;
   @Autowired
   private UserRoleLinkService userRoleLinkService;
   @Autowired
   private MesBuildingQhseAcceptDeviationService qhseAcceptDeviationService;
   @Autowired
   private MesBuildingNewTaskBiz newTaskBiz;
   @Autowired
   private DepartmentService departmentService;
   @Autowired
   private RedisUtils redisUtils;
   @Autowired
   private MesBuildingPackageNumberLinkService packageNumberLinkService;
   @Autowired
   private MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Autowired
   private MesQualityClassConfigService qualityClassService;
   @Autowired
   private MesSafetyClassConfigService safetyClassService;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Autowired
   private TechDrawingService techDrawingService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private MesBuildingSpotCheckQhseService spotCheckQhseService;
   @Autowired
   private ConfigService configService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportPaintThicknessLinkService paintThicknessLinkService;
   @Resource
   private MesQualityClassConfigService mesQualityClassConfigService;
   @Resource
   private MesSafetyClassConfigService mesSafetyClassConfigService;
   private static String PATH = "files" + File.separator;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean saveQhse(MesBuildingQhseDTOParam dtoParam) {
      dtoParam.setProblemDrawing(this.utilsBiz.longListToString(dtoParam.getDrawingIds()));
      MesBuildingQhse qhse = BeanUtil.copy(dtoParam, MesBuildingQhse.class);
      qhse.setCustomPenalty(dtoParam.getPenalty());
      String codeConfig = this.getCodeConfigByType(dtoParam.getType(), dtoParam.getLevelOneType());
      Preconditions.checkArgument(!codeConfig.isEmpty(), "问题类型代码不存在，请检查配置");
      Integer count = this.getNumber();
      LocalDateTime dateTime = LocalDateTime.now();
      String number1 = count == 0 ? "1" : count.toString();
      String qhseNumber = codeConfig + dateTime.getYear() + "-" + dateTime.getMonthValue() + "-" + dateTime.getDayOfMonth() + "-" + number1;
      qhse.setQhseNumber(qhseNumber);
      if (dtoParam.getType().equals(QhseTypeEnum.SPECIAL_QUALITY.getType()) && dtoParam.getTaskId() != null) {
         this.handleSpecialQualityProblem(dtoParam, qhse);
      }

      if (dtoParam.getType().equals(QhseTypeEnum.QUALITY.getType())) {
         this.handleQualityReportProblem(dtoParam, qhse);
      }

      if (qhse.getType() != 1 && qhse.getType() != 8) {
         if ((qhse.getType() == 2 || qhse.getType() == 4) && qhse.getLevelTwoType() != null) {
            MesSafetyClassConfig safetyConfig = this.mesSafetyClassConfigService.getById(qhse.getLevelTwoType());
            if (safetyConfig != null) {
               qhse.setBehaviorScore(BigDecimal.valueOf(safetyConfig.getBehaviorScore().intValue()));
               qhse.setPenalty(safetyConfig.getPenalty());
            } else {
               qhse.setBehaviorScore(BigDecimal.ZERO);
               qhse.setPenalty(BigDecimal.ZERO);
            }
         }
      } else if (qhse.getLevelTwoType() != null) {
         MesQualityClassConfig qualityConfig = this.mesQualityClassConfigService.getById(qhse.getLevelTwoType());
         if (qualityConfig != null) {
            qhse.setBehaviorScore(BigDecimal.valueOf(qualityConfig.getBehaviorScore().intValue()));
            qhse.setPenalty(qualityConfig.getPenalty());
         } else {
            qhse.setBehaviorScore(BigDecimal.ZERO);
            qhse.setPenalty(BigDecimal.ZERO);
         }
      }

      this.mesBuildingQhseService.saveOrUpdate(qhse);
      if (Boolean.TRUE.equals(dtoParam.getBoolConcessionAcceptance())) {
         this.qhseAcceptDeviationService
            .saveQhseAcceptDeviation(MesBuildingQhseAcceptDeviationDTO.builder().qhseId(qhse.getId()).submitRemark(dtoParam.getSubmitRemark()).build());
      }

      this.bindUserPermissions(qhse, dtoParam);
      return true;
   }

   private String getCodeConfigByType(Integer type, Long levelOneType) {
      if ((type & (QhseTypeEnum.QUALITY.getType() | QhseTypeEnum.SPECIAL_QUALITY.getType())) != 0) {
         MesQualityClassConfig classConfigs = this.qualityClassService
            .getOne(Wrappers.lambdaQuery(MesQualityClassConfig.class).eq(MesQualityClassConfig::getId, levelOneType));
         return classConfigs != null ? classConfigs.getSerialNumber() : "";
      } else if ((type & (QhseTypeEnum.SECURITY.getType() | QhseTypeEnum.ENVIRONMENT.getType())) != 0) {
         MesSafetyClassConfig classConfigs = this.safetyClassService
            .getOne(Wrappers.lambdaQuery(MesSafetyClassConfig.class).eq(MesSafetyClassConfig::getId, levelOneType));
         return classConfigs != null ? classConfigs.getSerialNumber() : "";
      } else {
         return "";
      }
   }

   private void handleSpecialQualityProblem(MesBuildingQhseDTOParam dtoParam, MesBuildingQhse qhse) {
      MesBuildingTask task = this.taskService.getById(dtoParam.getTaskId());
      this.checkComponentPackagingStatus(task, dtoParam.getNumberList());
      this.taskBiz.checkProductStatus(Collections.singletonList(task.getProductId()), task.getTaskTypeEnum());
      qhse.setProjectId(task.getProjectId());
      qhse.setMonomerId(task.getMonomerId());
      qhse.setAreaId(task.getAreaId());
      qhse.setProductId(task.getProductId());
      qhse.setTaskTypeEnum(task.getTaskTypeEnum());
      if (task.getBoolOneCode()) {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(dtoParam.getNumberList()), "操作失败!!请联系管理员");
         qhse.setNumber(dtoParam.getNumberList().get(0));
      }
   }

   private void checkComponentPackagingStatus(MesBuildingTask task, List<Integer> numberList) {
      if (TaskTypeEnum.ARTIFACT.getType().equals(task.getTaskTypeEnum())) {
         boolean hasPackage = this.isComponentPackaged(task.getProductId(), TaskTypeEnum.ARTIFACT.getType(), numberList);
         boolean hasCargo = this.isComponentInCargo(task.getProductId(), TaskTypeEnum.ARTIFACT.getType(), numberList);
         Preconditions.checkArgument(!hasPackage && !hasCargo, "构件已打包或装车！！");
      } else if (TaskTypeEnum.ASSEMBLE.getType().equals(task.getTaskTypeEnum())) {
         List<TechAssembleExt> assembleExts = this.assembleExtService
            .list(Wrappers.lambdaQuery(TechAssembleExt.class).eq(TechAssembleExt::getAssembleId, task.getProductId()));
         List<Integer> numbers = assembleExts.stream().filter(TechAssembleExt::getBoolTask).map(TechAssembleExt::getSortNumber).collect(Collectors.toList());
         boolean hasPackage = this.isComponentPackaged(task.getProductId(), TaskTypeEnum.ASSEMBLE.getType(), numbers);
         boolean hasCargo = this.isComponentInCargo(task.getProductId(), TaskTypeEnum.ASSEMBLE.getType(), numbers);
         Preconditions.checkArgument(!hasPackage && !hasCargo, "构件已打包或装车！！");
      }
   }

   private boolean isComponentPackaged(Long productId, Integer productType, List<Integer> numbers) {
      return CollectionUtils.isNotEmpty(
         this.packageNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingPackageNumberLink.class)
                  .eq(MesBuildingPackageNumberLink::getProductId, productId)
                  .eq(MesBuildingPackageNumberLink::getProductType, productType)
                  .in(MesBuildingPackageNumberLink::getNumber, numbers)
            )
      );
   }

   private boolean isComponentInCargo(Long productId, Integer productType, List<Integer> numbers) {
      return CollectionUtils.isNotEmpty(
         this.cargoListProductNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingCargoListProductNumberLink.class)
                  .eq(MesBuildingCargoListProductNumberLink::getProductId, productId)
                  .eq(MesBuildingCargoListProductNumberLink::getProductType, productType)
                  .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, false)
                  .in(MesBuildingCargoListProductNumberLink::getNumber, numbers)
            )
      );
   }

   private void handleQualityReportProblem(MesBuildingQhseDTOParam dtoParam, MesBuildingQhse qhse) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(dtoParam.getReportList()), "操作失败!!!");
      int problemQuantity = dtoParam.getReportList().stream().mapToInt(InspectionReportSavedDTO::getReportQuantity).sum();
      Long reportNumberId = dtoParam.getReportList().get(0).getReportNumberId();
      MesBuildingProduceTeamReport report = this.mesBuildingProduceTeamReportService
         .getOne(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).eq(MesBuildingProduceTeamReport::getReportNumber, reportNumberId).last("limit 1"));
      this.taskBiz.checkProductStatus(Collections.singletonList(report.getProductId()), report.getTaskTypeEnum());
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(report.getTaskProcessId());
      Preconditions.checkArgument(taskProcess != null, "操作失败：无对应任务");
      MesBuildingWorkshop workshop = this.workshopService.getById(report.getWorkshopId());
      Preconditions.checkArgument(workshop != null, "操作失败,上报车间不存在!");
      qhse.setProjectId(taskProcess.getProjectId());
      qhse.setMonomerId(taskProcess.getMonomerId());
      qhse.setAreaId(taskProcess.getAreaId());
      qhse.setFactoryId(workshop.getFactoryId());
      qhse.setWorkshopId(report.getWorkshopId());
      qhse.setProductionLineId(report.getProductionLineId());
      qhse.setTaskId(taskProcess.getTaskId());
      qhse.setTaskProcessId(taskProcess.getId());
      qhse.setProductId(taskProcess.getProductId());
      qhse.setProblemQuantity(problemQuantity);
      qhse.setTaskTypeEnum(taskProcess.getTaskTypeEnum());
      qhse.setProcessId(taskProcess.getProcessId());
      qhse.setTeamId(report.getTeamId());
      qhse.setNumber(report.getNumber());
      Preconditions.checkArgument(
         taskProcess.getCompleteQuantity() - taskProcess.getInspectionQuantity() - taskProcess.getProblemQuantity() >= problemQuantity, "操作失败!!"
      );
      taskProcess.setProblemQuantity(taskProcess.getProblemQuantity() + problemQuantity);
      this.taskProcessService.updateById(taskProcess);
      this.newTaskBiz
         .saveProduceTeamReportSummary2(
            taskProcess, problemQuantity, report.getProductionLineId(), report.getTeamId(), SaveProduceTeamReportSummaryTypeEnum.PROBLEM_REPORT.getType()
         );
      this.mesBuildingQhseService.save(qhse);
      this.saveQhseInspectionLinkBydtoParam(taskProcess, dtoParam, qhse.getId());
   }

   private void bindUserPermissions(MesBuildingQhse qhse, MesBuildingQhseDTOParam dtoParam) {
      this.qhseUserLinkService
         .save(MesBuildingQhseUserLink.builder().qhseId(qhse.getId()).powerType(QhsePowerTypeEnum.EXAMINE.getType()).userId(qhse.getUserId()).build());
      List<MesBuildingTeamUserLink> teamUsers = this.teamUserLinkService
         .list((Wrapper<MesBuildingTeamUserLink>)new LambdaQueryWrapper<MesBuildingTeamUserLink>().eq(MesBuildingTeamUserLink::getTeamId, qhse.getTeamId()));
      List<Long> updateUserIds = teamUsers.stream().map(MesBuildingTeamUserLink::getUserId).collect(Collectors.toList());
      if (!updateUserIds.contains(qhse.getDutyId())) {
         updateUserIds.add(qhse.getDutyId());
      }

      updateUserIds.remove(qhse.getUserId());
      updateUserIds.forEach(
         userId -> this.qhseUserLinkService
            .save(MesBuildingQhseUserLink.builder().qhseId(qhse.getId()).powerType(QhsePowerTypeEnum.UPDATE.getType()).userId(userId).build())
      );
      if (CollectionUtils.isNotEmpty(dtoParam.getUserLink())) {
         dtoParam.getUserLink()
            .forEach(
               userId -> {
                  if (!userId.equals(qhse.getUserId()) && !userId.equals(qhse.getDutyId()) && !updateUserIds.contains(userId)) {
                     this.qhseUserLinkService
                        .save(MesBuildingQhseUserLink.builder().userId(userId).qhseId(qhse.getId()).powerType(QhsePowerTypeEnum.SEE.getType()).build());
                  }
               }
            );
         this.redisUtils.set("qhse_userlink:" + UserUtil.getCurrentUserId(), dtoParam.getUserLink());
      }
   }

   public Integer getNumber() {
      LocalDate today = LocalDate.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String startDate = today.format(formatter);
      String endDate = today.plusDays(1L).format(formatter);
      return this.mesBuildingQhseService.count(Wrappers.lambdaQuery(MesBuildingQhse.class).between(BaseEntity::getCreateTime, startDate, endDate));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean saveQhseRectify(MesBuildingQhseRectifyDTOParam dtoParam) {
      MesBuildingQhseRectify qhseRectify = BeanUtil.copy(dtoParam, MesBuildingQhseRectify.class);
      qhseRectify.setRectifyDrawing(this.utilsBiz.longListToString(dtoParam.getDrawingIds().getIds()));
      qhseRectify.setUserId(UserUtil.getCurrentUserId());
      Preconditions.checkArgument(qhseRectify.getRectifyDrawing() != null, "整改图片不能为空");
      Preconditions.checkArgument(qhseRectify.getRemark() != null && !qhseRectify.getRemark().equals(""), "整改备注不能为空");
      MesBuildingQhse qhse = this.mesBuildingQhseService.getById(qhseRectify.getQhseId());
      Preconditions.checkArgument(!qhse.getStatus().equals(QhseStatusEnum.ADOPT.getType()), "操作失败,问题已处理无法新增整改!!");
      if (qhse.getType().equals(QhseTypeEnum.QUALITY.getType())) {
         this.checkProductStatusForQualityProblem(qhseRectify.getQhseId());
      }

      this.qhseRectifyService.save(qhseRectify);
      this.updateQhseStatusToRectified(qhse);
      return true;
   }

   private void checkProductStatusForQualityProblem(Long qhseId) {
      List<MesBuildingQhseInspectionLink> links = this.qhseInspectionLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingQhseInspectionLink.class).eq(MesBuildingQhseInspectionLink::getQhseId, qhseId));
      if (CollectionUtils.isNotEmpty(links)) {
         List<Long> inspectIds = links.stream().map(MesBuildingQhseInspectionLink::getInspectionReportId).collect(Collectors.toList());
         List<MesBuildingProduceInspectionTeamReport> reports = this.inspectionTeamReportService.listByIds(inspectIds);
         if (CollectionUtils.isNotEmpty(reports)) {
            List<Long> productIds = reports.stream().map(MesBuildingProduceInspectionTeamReport::getProductId).collect(Collectors.toList());
            Integer taskTypeEnum = reports.get(0).getTaskTypeEnum();
            this.taskBiz.checkProductStatus(productIds, taskTypeEnum);
         }
      }
   }

   private void updateQhseStatusToRectified(MesBuildingQhse qhse) {
      qhse.setStatus(QhseStatusEnum.RECTIFIED.getType());
      if (qhse.getFirstRectifyTime() == null) {
         qhse.setFirstRectifyTime(LocalDateTime.now());
      }

      this.mesBuildingQhseService.updateById(qhse);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean saveQhseRectifyAV2(MesBuildingQhseRectifyDTOParam dtoParam) {
      MesBuildingQhseRectify qhseRectify = BeanUtil.copy(dtoParam, MesBuildingQhseRectify.class);
      qhseRectify.setRectifyDrawing(this.utilsBiz.longListToString(dtoParam.getDrawingIds().getIds()));
      Preconditions.checkArgument(qhseRectify.getRectifyDrawing() != null, "整改图片不能为空");
      Preconditions.checkArgument(qhseRectify.getRemark() != null && !qhseRectify.getRemark().equals(""), "整改备注不能为空");
      qhseRectify.setUserId(UserUtil.getCurrentUserId());
      MesBuildingQhse qhse = this.mesBuildingQhseService.getById(qhseRectify.getQhseId());
      if (qhse.getType().equals(QhseTypeEnum.QUALITY.getType())) {
         List<MesBuildingQhseInspectionLink> links = this.qhseInspectionLinkBiz
            .list(Wrappers.lambdaQuery(MesBuildingQhseInspectionLink.class).eq(MesBuildingQhseInspectionLink::getQhseId, qhseRectify.getQhseId()));
         List<Long> inspectIds = links.stream().map(MesBuildingQhseInspectionLink::getInspectionReportId).collect(Collectors.toList());
         List<MesBuildingProduceInspectionTeamReport> reports = this.inspectionTeamReportService.listByIds(inspectIds);
         List<Long> productIds = reports.stream().map(MesBuildingProduceInspectionTeamReport::getProductId).collect(Collectors.toList());
         Integer taskTypeEnum = reports.get(0).getTaskTypeEnum();
         this.taskBiz.checkProductStatus(productIds, taskTypeEnum);
      }

      this.qhseRectifyService.save(qhseRectify);
      qhse.setStatus(QhseStatusEnum.RECTIFIED.getType());
      this.mesBuildingQhseService.updateById(qhse);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean updateQhseStatus(Long id, Integer status) {
      MesBuildingQhse mesBuildingQhse = this.mesBuildingQhseService.getById(id);
      if (mesBuildingQhse.getStatus() == QhseStatusEnum.CONCESSION_ACCEPTED.getType() && status == null) {
         Preconditions.checkArgument(false, "操作失败，问题处于让步接收审核中");
      }

      int updateStatus = status == null ? QhseStatusEnum.ADOPT.getType() : status;
      Preconditions.checkArgument(mesBuildingQhse != null, "操作失败，没有相关问题");
      Preconditions.checkArgument(
         !mesBuildingQhse.getStatus().equals(QhseStatusEnum.ADOPT.getType())
            || !mesBuildingQhse.getStatus().equals(QhseStatusEnum.CONCESSION_ACCEPTED_APPROVED.getType()),
         "操作失败，整改已通过"
      );
      this.mesBuildingQhseService.updateById(mesBuildingQhse.setStatus(updateStatus));
      MesBuildingQhse qhse = this.mesBuildingQhseService.getById(mesBuildingQhse.getId());
      if (qhse.getType().equals(QhseTypeEnum.QUALITY.getType())
         && (
            mesBuildingQhse.getStatus().equals(QhseStatusEnum.ADOPT.getType())
               || mesBuildingQhse.getStatus().equals(QhseStatusEnum.CONCESSION_ACCEPTED_APPROVED.getType())
         )) {
         MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(qhse.getTaskProcessId());
         this.taskBiz.checkProductStatus(Collections.singletonList(taskProcess.getProductId()), taskProcess.getTaskTypeEnum());
         this.taskBiz.qhseAdopt(taskProcess, qhse.getProblemQuantity(), qhse.getUserId(), qhse.getTeamId(), mesBuildingQhse.getId());
      }

      qhse.setStatus(mesBuildingQhse.getStatus());
      if (qhse.getFirstRectifyTime() == null) {
         qhse.setFirstRectifyTime(LocalDateTime.now());
      }

      this.mesBuildingQhseService.updateById(qhse);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateQhseRectify(MesBuildingQhseRectifyDTOParam copy) {
      MesBuildingQhseRectify mesBuildingQhseRectify = this.qhseRectifyService.getById(copy.getId());
      Preconditions.checkArgument(mesBuildingQhseRectify != null, "操作失败，id有误");
      MesBuildingQhse mesBuildingQhse = this.mesBuildingQhseService.getById(mesBuildingQhseRectify.getQhseId());
      if (mesBuildingQhse.getType().equals(QhseTypeEnum.QUALITY.getType())) {
         List<MesBuildingQhseInspectionLink> links = this.qhseInspectionLinkBiz
            .list(Wrappers.lambdaQuery(MesBuildingQhseInspectionLink.class).eq(MesBuildingQhseInspectionLink::getQhseId, mesBuildingQhseRectify.getQhseId()));
         List<Long> inspectIds = links.stream().map(MesBuildingQhseInspectionLink::getInspectionReportId).collect(Collectors.toList());
         List<MesBuildingProduceInspectionTeamReport> reports = this.inspectionTeamReportService.listByIds(inspectIds);
         List<Long> productIds = reports.stream().map(MesBuildingProduceInspectionTeamReport::getProductId).collect(Collectors.toList());
         Integer taskTypeEnum = reports.get(0).getTaskTypeEnum();
         this.taskBiz.checkProductStatus(productIds, taskTypeEnum);
      }

      mesBuildingQhse.setStatus(QhseStatusEnum.UN_ADOPT.getType());
      mesBuildingQhseRectify.setRefuseRemark(copy.getRefuseRemark());
      this.qhseRectifyService.updateById(mesBuildingQhseRectify);
      return true;
   }

   @Override
   public Boolean changeQhseRectify(MesBuildingQhseRectifyDTOParam copy) {
      MesBuildingQhseRectify mesBuildingQhseRectify = this.qhseRectifyService.getById(copy.getId());
      Preconditions.checkArgument(mesBuildingQhseRectify != null, "操作失败，id有误");
      mesBuildingQhseRectify.setRefuseRemark(copy.getRefuseRemark());
      MesBuildingQhse qhse = this.mesBuildingQhseService.getById(mesBuildingQhseRectify.getQhseId());
      if (qhse.getType().equals(QhseTypeEnum.QUALITY.getType())) {
         List<MesBuildingQhseInspectionLink> links = this.qhseInspectionLinkBiz
            .list(Wrappers.lambdaQuery(MesBuildingQhseInspectionLink.class).eq(MesBuildingQhseInspectionLink::getQhseId, mesBuildingQhseRectify.getQhseId()));
         List<Long> inspectIds = links.stream().map(MesBuildingQhseInspectionLink::getInspectionReportId).collect(Collectors.toList());
         List<MesBuildingProduceInspectionTeamReport> reports = this.inspectionTeamReportService.listByIds(inspectIds);
         List<Long> productIds = reports.stream().map(MesBuildingProduceInspectionTeamReport::getProductId).collect(Collectors.toList());
         Integer taskTypeEnum = reports.get(0).getTaskTypeEnum();
         this.taskBiz.checkProductStatus(productIds, taskTypeEnum);
      }

      this.qhseRectifyService.updateById(mesBuildingQhseRectify);
      return true;
   }

   @Override
   public List<MesBuildingQhseDTO> qhseList(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Long processId,
      Long levelOneType,
      Long levelTwoType
   ) {
      if (UserUtil.getCurrentUser().isAdmin()) {
         userId = null;
      }

      if (type != null && (type & 9) > 0) {
         type = type | QhseTypeEnum.SPOT_CHECK.getType();
      }

      List<MesBuildingQhseDO> doList = this.mesBuildingQhseService
         .selectListByCondition(
            qhseId,
            projectId,
            userName,
            dutyName,
            rectifyName,
            serialNumber,
            type,
            status,
            boolApp,
            userId,
            startDate,
            endDate,
            specifiedDate,
            qhseIds,
            null,
            processId,
            levelOneType,
            levelTwoType
         );
      if (CollectionUtils.isEmpty(doList)) {
         return new ArrayList<>();
      }

      List<MesBuildingQhseDTO> qhseDTOS = doList.stream().map(e -> BeanUtil.copy(e, MesBuildingQhseDTO.class)).collect(Collectors.toList());
      Map<Long, String> SerialNumberMap = new HashMap<>();
      int mask = QhseTypeEnum.SECURITY.getType() | QhseTypeEnum.SPECIAL_QUALITY.getType() | QhseTypeEnum.SPOT_CHECK.getType();
      if (CollectionUtils.isNotEmpty(doList) && type != null && (type & mask) != 0) {
         List<Long> artIds = doList.stream()
            .filter(e -> e.getProductId() != null)
            .filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()))
            .map(MesBuildingQhseDO::getProductId)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(artIds)) {
            SerialNumberMap = this.artifactService.listByIds(artIds).stream().collect(Collectors.toMap(TechArtifact::getId, TechArtifact::getSerialNumber));
         }
      }

      Map<Long, String> finalSerialNumberMap = SerialNumberMap;
      Map<Long, MesQualityClassConfig> configMap = this.qualityClassService.list().stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      Map<Long, MesSafetyClassConfig> safetyMap = this.safetyClassService.list().stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      LocalDateTime dateTime = LocalDateTime.now();
      List<TechDrawing> techDrawings = this.techDrawingService
         .list(Wrappers.lambdaQuery(TechDrawing.class).in(TechDrawing::getMonomerId, qhseDTOS.stream().map(e -> e.getMonomerId()).collect(Collectors.toList())));
      Map<String, List<TechDrawing>> techDrawingMap = techDrawings.stream()
         .collect(Collectors.groupingBy(e -> e.getProjectId() + "-" + e.getMonomerId() + "-" + e.getSerialNumber()));
      qhseDTOS.forEach(
         e -> {
            e.setAttachmentDTOS(this.attachmentService.listByIds(e.getProblemDrawing()));
            List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS = this.qhseRectifyService
               .list(
                  (Wrapper<MesBuildingQhseRectify>)(Wrappers.<MesBuildingQhseRectify>lambdaQuery().eq(MesBuildingQhseRectify::getQhseId, e.getId()))
                     .orderByDesc(BaseEntity::getCreateTime)
               )
               .stream()
               .map(copy -> BeanUtil.copy(copy, MesBuildingQhseRectifyDTO.class))
               .collect(Collectors.toList());
            qhseRectifyDTOS.forEach(temp -> {
               List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(temp.getRectifyDrawing());
               if (attachmentDTOS != null) {
                  temp.setAttachmentDTOS(attachmentDTOS);
               }

               User user = this.userService.getById(temp.getUserId());
               if (user != null) {
                  temp.setName(user.getName());
               }
            });
            String productSerialNumber = "";
            e.setQhseRectifyDTOS(qhseRectifyDTOS);
            if (e.getType().equals(QhseTypeEnum.QUALITY.getType())) {
               if (e.getTaskTypeEnum().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                  TechAssemble ass = this.assembleService.getById(e.getProductId());
                  productSerialNumber = ass.getSerialNumber();
                  e.setProductSerialNumber(ass.getSerialNumber());
                  e.setSpecification(ass.getSpecification());
               } else if (e.getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = this.artifactService.getById(e.getProductId());
                  productSerialNumber = artifact.getSerialNumber();
                  e.setProductName(artifact == null ? null : artifact.getName());
                  e.setProductSerialNumber(artifact == null ? null : artifact.getSerialNumber());
                  e.setSpecification(artifact == null ? null : artifact.getSpecification());
               } else if (e.getTaskTypeEnum().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  TechEnclosure enclosure = this.enclosureService.getById(e.getProductId());
                  e.setProductName(enclosure.getName());
                  e.setProductSerialNumber(enclosure.getSerialNumber());
               } else if (e.getTaskTypeEnum().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                  TechMachinePart part = this.machinePartService.getById(e.getProductId());
                  e.setProductSerialNumber(part.getSerialNumber());
                  e.setSpecification(part.getSpecification());
               }

               AttachmentDTO attachmentDTO = this.attachmentService.getById(e.getDrawingLabel());
               List<TechDrawing> techDrawingList = techDrawingMap.get(e.getProjectId() + "-" + e.getMonomerId() + "-" + e.getProductSerialNumber());
               e.setDrawingLabelPath(
                  attachmentDTO != null
                     ? attachmentDTO.getRelativePath()
                     : (
                        CollectionUtils.isEmpty(techDrawingList)
                           ? null
                           : this.configProperties.getUrl() + PATH + techDrawingList.get(0).getFilePath() + techDrawingList.get(0).getFileName()
                     )
               );
               e.setQualityTypeList(this.dictionaryService.listLabelsByCondition(DictionaryEnum.MES_QHSE_PRODUCT_PROBLEM_TYPE.getName(), e.getQualityType()));
            }

            if (e.getType().equals(QhseTypeEnum.SPECIAL_QUALITY.getType()) || e.getType().equals(QhseTypeEnum.SPOT_CHECK.getType())) {
               MesBuildingTask task = this.taskService.getById(e.getTaskId());
               if (task == null) {
                  return;
               }

               ContractProject project = this.projectService.getById(task.getProjectId());
               ProjectDetailDO projectDetailDO = ProjectDetailDO.builder()
                  .id(project.getId())
                  .name(project.getName())
                  .shortName(project.getShortName())
                  .serialNumber(project.getSerialNumber())
                  .type(project.getProjectType())
                  .build();
               e.setProjectId(task.getProjectId())
                  .setMonomerId(task.getMonomerId())
                  .setMonomerName(this.planMonomerService.getById(task.getMonomerId()).getName())
                  .setAreaId(task.getAreaId())
                  .setFactoryId(task.getFactoryId())
                  .setWorkshopId(task.getWorkshopId())
                  .setProductionLineId(task.getProductionLineId())
                  .setProductId(task.getProductId())
                  .setTaskTypeEnum(task.getTaskTypeEnum())
                  .setProject(projectDetailDO)
                  .setProjectName(this.projectService.getById(task.getProjectId()).getName())
                  .setFactoryName(this.factoryService.getById(task.getFactoryId()).getName())
                  .setWorkshopName(this.workshopService.getById(task.getWorkshopId()).getName())
                  .setProductionLineName(this.productionLineService.getById(task.getProductionLineId()).getName());
               if (task.getTaskTypeEnum().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                  e.setProductSerialNumber(this.assembleService.getById(task.getProductId()).getSerialNumber());
               } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  e.setProductName(this.artifactService.getById(task.getProductId()).getName());
                  e.setProductSerialNumber(this.artifactService.getById(task.getProductId()).getSerialNumber());
               } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  e.setProductName(this.enclosureService.getById(task.getProductId()).getName());
                  e.setProductSerialNumber(this.enclosureService.getById(task.getProductId()).getSerialNumber());
               } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                  e.setProductSerialNumber(this.machinePartService.getById(task.getProductId()).getSerialNumber());
               }

               e.setQualityTypeList(this.dictionaryService.listLabelsByCondition(DictionaryEnum.MES_QHSE_PRODUCT_PROBLEM_TYPE.getName(), e.getQualityType()));
            }

            String SerialNumber = finalSerialNumberMap.get(e.getProductId());
            if (StringUtils.isNotBlank(SerialNumber)) {
               e.setSerialNumber(SerialNumber);
            } else {
               e.setSerialNumber(" / ");
            }

            List<TechDrawing> drawingListMap = this.drawingService
               .list(
                  (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                              .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                           .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                        .in(TechDrawing::getSerialNumber, productSerialNumber))
                     .eq(TechDrawing::getMonomerId, e.getMonomerId())
               );
            if (CollectionUtils.isNotEmpty(drawingListMap)) {
               e.setNumbers(drawingListMap.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
            }

            if (e.getType().equals(QhseTypeEnum.SPECIAL_QUALITY.getType()) && e.getNumber() != null) {
               e.setNumbers(Arrays.asList(e.getNumber()));
            }

            if (e.getFirstRectifyTime() != null) {
               e.setLossTime(Duration.between(e.getFirstRectifyTime(), e.getCreateTime()).toMillis());
            } else {
               e.setLossTime(Duration.between(e.getCreateTime(), dateTime).toMillis());
            }

            if ((e.getType() & (QhseTypeEnum.QUALITY.getType() | QhseTypeEnum.SPECIAL_QUALITY.getType() | QhseTypeEnum.SPOT_CHECK.getType())) != 0) {
               e.setLevelOneName(configMap.get(e.getLevelOneType()) == null ? null : configMap.get(e.getLevelOneType()).getName());
               e.setLevelTwoName(configMap.get(e.getLevelTwoType()) == null ? null : configMap.get(e.getLevelTwoType()).getName());
               e.setBehaviorScore(configMap.get(e.getLevelTwoType()) == null ? null : configMap.get(e.getLevelTwoType()).getBehaviorScore());
               e.setPenalty(configMap.get(e.getLevelTwoType()) == null ? null : configMap.get(e.getLevelTwoType()).getPenalty());
            } else if ((e.getType() & (QhseTypeEnum.SECURITY.getType() | QhseTypeEnum.ENVIRONMENT.getType())) != 0) {
               e.setLevelOneName(safetyMap.get(e.getLevelOneType()) == null ? null : safetyMap.get(e.getLevelOneType()).getName());
               e.setLevelTwoName(safetyMap.get(e.getLevelTwoType()) == null ? null : safetyMap.get(e.getLevelTwoType()).getName());
               e.setBehaviorScore(safetyMap.get(e.getLevelTwoType()) == null ? null : safetyMap.get(e.getLevelTwoType()).getBehaviorScore());
               e.setPenalty(
                  e.getCustomPenalty() != null
                     ? e.getCustomPenalty()
                     : (safetyMap.get(e.getLevelTwoType()) == null ? null : safetyMap.get(e.getLevelTwoType()).getPenalty())
               );
            }
         }
      );
      return qhseDTOS.stream()
         .sorted(Comparator.comparing(MesBuildingQhseDTO::getStatus).thenComparing(BaseEntity::getCreateTime, Comparator.reverseOrder()))
         .collect(Collectors.toList());
   }

   @Override
   public MesBuildingQhseDetailDTO qhseDetail(Long qhseId) {
      if (qhseId == null) {
         return new MesBuildingQhseDetailDTO();
      }

      MesBuildingQhseDetailDTO qhseDTO = this.mesBuildingQhseService.findQhseDetailList(qhseId);
      if (qhseDTO == null) {
         return new MesBuildingQhseDetailDTO();
      }

      Map<Long, MesQualityClassConfig> configMap = this.qualityClassService.list().stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      Map<Long, MesSafetyClassConfig> safetyMap = this.safetyClassService.list().stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      qhseDTO.setAttachmentDTOS(this.attachmentService.listByIds(qhseDTO.getProblemDrawing()));
      List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS = this.qhseRectifyService
         .list(
            (Wrapper<MesBuildingQhseRectify>)(Wrappers.<MesBuildingQhseRectify>lambdaQuery().eq(MesBuildingQhseRectify::getQhseId, qhseDTO.getId()))
               .orderByDesc(BaseEntity::getCreateTime)
         )
         .stream()
         .map(copy -> BeanUtil.copy(copy, MesBuildingQhseRectifyDTO.class))
         .collect(Collectors.toList());
      qhseRectifyDTOS.forEach(temp -> {
         temp.setAttachmentDTOS(this.attachmentService.listByIds(temp.getRectifyDrawing()));
         temp.setName(this.userService.getById(temp.getUserId()).getName());
      });
      String productSerialNumber = "";
      qhseDTO.setQhseRectifyDTOS(qhseRectifyDTOS);
      if (qhseDTO.getType().equals(QhseTypeEnum.QUALITY.getType())) {
         if (qhseDTO.getTaskTypeEnum().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            TechAssemble ass = this.assembleService.getById(qhseDTO.getProductId());
            productSerialNumber = ass.getSerialNumber();
            qhseDTO.setProductSerialNumber(ass.getSerialNumber());
            qhseDTO.setSpecification(ass.getSpecification());
         } else if (qhseDTO.getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = this.artifactService.getById(qhseDTO.getProductId());
            productSerialNumber = artifact.getSerialNumber();
            qhseDTO.setProductName(artifact == null ? null : artifact.getName());
            qhseDTO.setProductSerialNumber(artifact == null ? null : artifact.getSerialNumber());
            qhseDTO.setSpecification(artifact == null ? null : artifact.getSpecification());
         } else if (qhseDTO.getTaskTypeEnum().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            TechEnclosure enclosure = this.enclosureService.getById(qhseDTO.getProductId());
            qhseDTO.setProductName(enclosure.getName());
            qhseDTO.setProductSerialNumber(enclosure.getSerialNumber());
         } else if (qhseDTO.getTaskTypeEnum().equals(ProductTypeEnum.MACHINE_PART.getType())) {
            TechMachinePart part = this.machinePartService.getById(qhseDTO.getProductId());
            qhseDTO.setProductSerialNumber(part.getSerialNumber());
            qhseDTO.setSpecification(part.getSpecification());
         }
      }

      if (qhseDTO.getType().equals(QhseTypeEnum.SPECIAL_QUALITY.getType())) {
         MesBuildingTask task = this.taskService.getById(qhseDTO.getTaskId());
         if (task != null) {
            qhseDTO.setProjectId(task.getProjectId()).setProductId(task.getProductId()).setTaskTypeEnum(task.getTaskTypeEnum());
            if (task.getTaskTypeEnum().equals(ProductTypeEnum.ASSEMBLE.getType())) {
               TechAssemble ass = this.assembleService.getById(qhseDTO.getProductId());
               productSerialNumber = ass.getSerialNumber();
               qhseDTO.setProductSerialNumber(ass.getSerialNumber());
               qhseDTO.setSpecification(ass.getSpecification());
            } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
               TechArtifact artifact = this.artifactService.getById(qhseDTO.getProductId());
               productSerialNumber = artifact.getSerialNumber();
               qhseDTO.setProductName(artifact == null ? null : artifact.getName());
               qhseDTO.setProductSerialNumber(artifact == null ? null : artifact.getSerialNumber());
               qhseDTO.setSpecification(artifact == null ? null : artifact.getSpecification());
            } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               TechEnclosure enclosure = this.enclosureService.getById(qhseDTO.getProductId());
               qhseDTO.setProductName(enclosure.getName());
               qhseDTO.setProductSerialNumber(enclosure.getSerialNumber());
            } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.MACHINE_PART.getType())) {
               TechMachinePart part = this.machinePartService.getById(qhseDTO.getProductId());
               qhseDTO.setProductSerialNumber(part.getSerialNumber());
               qhseDTO.setSpecification(part.getSpecification());
            }
         }
      }

      List<TechDrawing> drawingListMap = this.drawingService
         .list(
            (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                     .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                  .in(TechDrawing::getSerialNumber, productSerialNumber))
               .eq(TechDrawing::getMonomerId, qhseDTO.getMonomerId())
         );
      if (CollectionUtils.isNotEmpty(drawingListMap)) {
         qhseDTO.setNumbers(drawingListMap.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
      }

      AttachmentDTO attachmentDTO = this.attachmentService.getById(qhseDTO.getDrawingLabel());
      qhseDTO.setDrawingLabelPath(
         attachmentDTO != null
            ? attachmentDTO.getRelativePath()
            : (
               CollectionUtils.isEmpty(drawingListMap)
                  ? null
                  : this.configProperties.getUrl() + PATH + drawingListMap.get(0).getFilePath() + drawingListMap.get(0).getFileName()
            )
      );
      if ((qhseDTO.getType() & (QhseTypeEnum.QUALITY.getType() | QhseTypeEnum.SPECIAL_QUALITY.getType())) != 0) {
         qhseDTO.setLevelOneName(configMap.get(qhseDTO.getLevelOneType()) == null ? null : configMap.get(qhseDTO.getLevelOneType()).getName());
         qhseDTO.setLevelTwoName(configMap.get(qhseDTO.getLevelTwoType()) == null ? null : configMap.get(qhseDTO.getLevelTwoType()).getName());
         qhseDTO.setBehaviorScore(configMap.get(qhseDTO.getLevelTwoType()) == null ? null : configMap.get(qhseDTO.getLevelTwoType()).getBehaviorScore());
         qhseDTO.setPenalty(configMap.get(qhseDTO.getLevelTwoType()) == null ? null : configMap.get(qhseDTO.getLevelTwoType()).getPenalty());
      } else if ((qhseDTO.getType() & (QhseTypeEnum.SECURITY.getType() | QhseTypeEnum.ENVIRONMENT.getType())) != 0) {
         qhseDTO.setLevelOneName(safetyMap.get(qhseDTO.getLevelOneType()) == null ? null : safetyMap.get(qhseDTO.getLevelOneType()).getName());
         qhseDTO.setLevelTwoName(safetyMap.get(qhseDTO.getLevelTwoType()) == null ? null : safetyMap.get(qhseDTO.getLevelTwoType()).getName());
         qhseDTO.setBehaviorScore(safetyMap.get(qhseDTO.getLevelTwoType()) == null ? null : safetyMap.get(qhseDTO.getLevelTwoType()).getBehaviorScore());
         qhseDTO.setPenalty(
            qhseDTO.getCustomPenalty() != null
               ? qhseDTO.getCustomPenalty()
               : (safetyMap.get(qhseDTO.getLevelTwoType()) == null ? null : safetyMap.get(qhseDTO.getLevelTwoType()).getPenalty())
         );
      }

      return qhseDTO;
   }

   @Override
   public PageVO anhuanExposure(LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize) {
      if (startDate == null && endDate == null) {
         LocalDateTime now = LocalDateTime.now();
         startDate = now.minus(30L, ChronoUnit.DAYS);
         endDate = now;
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingQhseDO> doList = this.mesBuildingQhseService
         .selectListByCondition(
            null,
            null,
            null,
            null,
            null,
            null,
            QhseTypeEnum.SECURITY.getType() | QhseTypeEnum.ENVIRONMENT.getType(),
            null,
            null,
            null,
            startDate,
            endDate,
            null,
            null,
            null,
            null,
            null,
            null
         );
      PageVO pageVO = new PageVO<>(doList);
      if (CollectionUtils.isEmpty(doList)) {
         return new PageVO();
      }

      List<MesBuildingQhseDTO> qhseDTOS = doList.stream().map(e -> BeanUtil.copy(e, MesBuildingQhseDTO.class)).collect(Collectors.toList());
      HashMap<String, List<AttachmentDTO>> map = new HashMap<>();
      DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      qhseDTOS.forEach(e -> {
         List<AttachmentDTO> attachmentDTOS = map.get(format.format(e.getCreateTime()));
         if (CollectionUtils.isNotEmpty(attachmentDTOS)) {
            attachmentDTOS.addAll(this.attachmentService.listByIds(e.getProblemDrawing()));
         } else {
            map.put(format.format(e.getCreateTime()), this.attachmentService.listByIds(e.getProblemDrawing()));
         }
      });
      ArrayList<AnhuanExposureDTO> returnList = new ArrayList<>();
      map.forEach((k, v) -> {
         AnhuanExposureDTO dto = new AnhuanExposureDTO();
         dto.setDate(k);
         dto.setImages((List<AttachmentDTO>)v);
         returnList.add(dto);
      });
      pageVO.setContent(returnList);
      return pageVO;
   }

   @Override
   public PageVO<MesBuildingQhseDTO> qhsePage(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      String sort,
      Integer pageNumber,
      Integer pageSize,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Long processId,
      Long levelOneType,
      Long levelTwoType
   ) {
      return PageUtil.listPage(
         pageNumber,
         pageSize,
         this.qhseList(
            qhseId,
            projectId,
            userName,
            dutyName,
            rectifyName,
            serialNumber,
            type,
            status,
            boolApp,
            userId,
            startDate,
            endDate,
            specifiedDate,
            qhseIds,
            processId,
            levelOneType,
            levelTwoType
         )
      );
   }

   @Override
   public MesBuildingQhseDTO getQhseById(Long id, Integer status, Long userId) {
      MesBuildingQhseDTO dto = null;
      dto = BeanUtil.copy(this.mesBuildingQhseService.selectQhseById(id, userId), MesBuildingQhseDTO.class);
      Map<Long, MesBuildingQhseUserLink> userLinkMap = this.qhseUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingQhseUserLink.class).eq(MesBuildingQhseUserLink::getQhseId, id))
         .stream()
         .collect(Collectors.toMap(MesBuildingQhseUserLink::getUserId, Function.identity()));
      if (userLinkMap.get(userId) != null) {
         if (dto.getStatus().equals(QhseStatusEnum.UN_RECTIFIED.getType()) && dto.getBoolNeedReply() && userLinkMap.get(userId).getPowerType() == 4) {
            dto.setPowerType(1);
         } else {
            dto.setPowerType(userLinkMap.get(userId).getPowerType());
         }
      }

      if (dto == null) {
         return new MesBuildingQhseDTO();
      }

      MesBuildingQhse buildingQhse = this.mesBuildingQhseService.getById(id);
      if (QhseTypeEnum.SECURITY.getType() == buildingQhse.getType() && dto == null) {
         dto = BeanUtil.copy(this.mesBuildingQhseService.selectQhseById(id, null), MesBuildingQhseDTO.class);
         dto.setPowerType(1);
      }

      dto.setAttachmentDTOS(this.attachmentService.listByIds(dto.getProblemDrawing()));
      dto.setDrawingLabelDTO(this.attachmentService.getById(dto.getDrawingLabel()));
      List<MesBuildingQhseInspectionLink> list = this.mesBuildingQhseInspectionLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingQhseInspectionLink.class).eq(MesBuildingQhseInspectionLink::getQhseId, id));
      List<MesBuildingQhseRectifyDTO> rectifyDTOS = this.qhseRectifyService
         .list(
            (Wrapper<MesBuildingQhseRectify>)(Wrappers.<MesBuildingQhseRectify>lambdaQuery().eq(MesBuildingQhseRectify::getQhseId, dto.getId()))
               .orderByDesc(BaseEntity::getCreateTime)
         )
         .stream()
         .map(copy -> BeanUtil.copy(copy, MesBuildingQhseRectifyDTO.class))
         .collect(Collectors.toList());
      rectifyDTOS.forEach(temp -> {
         temp.setAttachmentDTOS(this.attachmentService.listByIds(temp.getRectifyDrawing()));
         User user = this.userService.getById(temp.getUserId());
         temp.setName(user == null ? null : user.getName());
      });
      dto.setQhseRectifyDTOS(rectifyDTOS);
      MesBuildingTask task = null;
      if (buildingQhse.getTaskId() != null) {
         task = this.taskService.getOne(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getId, buildingQhse.getTaskId()));
         if (task.getBoolOneCode()) {
            dto.setNumbers(list.stream().map(MesBuildingQhseInspectionLink::getNumber).filter(Objects::nonNull).collect(Collectors.toList()));
         } else {
            dto.setNumbers(new ArrayList<>());
         }

         if (dto.getType().equals(QhseTypeEnum.SPECIAL_QUALITY.getType()) && dto.getNumber() != null) {
            dto.setNumbers(Arrays.asList(dto.getNumber()));
         }
      }

      if (dto.getType().equals(QhseTypeEnum.QUALITY.getType())) {
         if (dto.getTaskTypeEnum().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            dto.setProductSerialNumber(this.assembleService.getById(dto.getProductId()).getSerialNumber());
         } else if (dto.getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
            dto.setProductName(this.artifactService.getById(dto.getProductId()).getName());
            dto.setProductSerialNumber(this.artifactService.getById(dto.getProductId()).getSerialNumber());
         } else if (dto.getTaskTypeEnum().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            dto.setProductName(this.enclosureService.getById(dto.getProductId()).getName());
            dto.setProductSerialNumber(this.enclosureService.getById(dto.getProductId()).getSerialNumber());
         } else if (dto.getTaskTypeEnum().equals(ProductTypeEnum.MACHINE_PART.getType())) {
            dto.setProductSerialNumber(this.machinePartService.getById(dto.getProductId()).getSerialNumber());
         }

         MesBuildingQhseAcceptDeviation deviations = this.qhseAcceptDeviationService
            .getOne(
               (Wrapper<MesBuildingQhseAcceptDeviation>)(Wrappers.<MesBuildingQhseAcceptDeviation>lambdaQuery()
                     .eq(MesBuildingQhseAcceptDeviation::getQhseId, buildingQhse.getId()))
                  .eq(MesBuildingQhseAcceptDeviation::getStatus, status)
            );
         if (deviations != null) {
            dto.setSubmitRemark(deviations.getSubmitRemark());
            dto.setApprovalRemark(deviations.getApprovalRemark());
         }
      }

      if (dto.getType().equals(QhseTypeEnum.SPECIAL_QUALITY.getType()) || dto.getType().equals(QhseTypeEnum.SPOT_CHECK.getType())) {
         if (task == null) {
            return dto;
         }

         ContractProject project = this.projectService.getById(task.getProjectId());
         ProjectDetailDO projectDetailDO = ProjectDetailDO.builder()
            .id(project.getId())
            .name(project.getName())
            .shortName(project.getShortName())
            .serialNumber(project.getSerialNumber())
            .type(project.getProjectType())
            .build();
         dto.setProjectId(task.getProjectId())
            .setMonomerId(task.getMonomerId())
            .setMonomerName(this.planMonomerService.getById(task.getMonomerId()).getName())
            .setAreaId(task.getAreaId())
            .setFactoryId(task.getFactoryId())
            .setWorkshopId(task.getWorkshopId())
            .setProductionLineId(task.getProductionLineId())
            .setProductId(task.getProductId())
            .setTaskTypeEnum(task.getTaskTypeEnum())
            .setProject(projectDetailDO)
            .setProjectName(this.projectService.getById(task.getProjectId()).getName())
            .setFactoryName(this.factoryService.getById(task.getFactoryId()).getName())
            .setWorkshopName(this.workshopService.getById(task.getWorkshopId()).getName())
            .setProductionLineName(this.productionLineService.getById(task.getProductionLineId()).getName());
         if (task.getTaskTypeEnum().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            dto.setProductSerialNumber(this.assembleService.getById(task.getProductId()).getSerialNumber());
         } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
            dto.setProductName(this.artifactService.getById(task.getProductId()).getName());
            dto.setProductSerialNumber(this.artifactService.getById(task.getProductId()).getSerialNumber());
         } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            dto.setProductName(this.enclosureService.getById(task.getProductId()).getName());
            dto.setProductSerialNumber(this.enclosureService.getById(task.getProductId()).getSerialNumber());
         } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.MACHINE_PART.getType())) {
            dto.setProductSerialNumber(this.machinePartService.getById(task.getProductId()).getSerialNumber());
         }
      }

      if (CollectionUtils.isEmpty(dto.getNumbers())) {
         dto.setNumbers(null);
      }

      Map<Long, MesQualityClassConfig> configMap = this.qualityClassService.list().stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      Map<Long, MesSafetyClassConfig> safetyMap = this.safetyClassService.list().stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
      if ((dto.getType() & (QhseTypeEnum.QUALITY.getType() | QhseTypeEnum.SPECIAL_QUALITY.getType() | QhseTypeEnum.SPOT_CHECK.getType())) != 0) {
         dto.setLevelOneName(configMap.get(dto.getLevelOneType()) == null ? null : configMap.get(dto.getLevelOneType()).getName());
         dto.setLevelTwoName(configMap.get(dto.getLevelTwoType()) == null ? null : configMap.get(dto.getLevelTwoType()).getName());
         dto.setBehaviorScore(configMap.get(dto.getLevelTwoType()) == null ? null : configMap.get(dto.getLevelTwoType()).getBehaviorScore());
         dto.setPenalty(configMap.get(dto.getLevelTwoType()) == null ? null : configMap.get(dto.getLevelTwoType()).getPenalty());
      } else if ((dto.getType() & (QhseTypeEnum.SECURITY.getType() | QhseTypeEnum.ENVIRONMENT.getType())) != 0) {
         dto.setLevelOneName(safetyMap.get(dto.getLevelOneType()) == null ? null : safetyMap.get(dto.getLevelOneType()).getName());
         dto.setLevelTwoName(safetyMap.get(dto.getLevelTwoType()) == null ? null : safetyMap.get(dto.getLevelTwoType()).getName());
         dto.setBehaviorScore(safetyMap.get(dto.getLevelTwoType()) == null ? null : safetyMap.get(dto.getLevelTwoType()).getBehaviorScore());
         dto.setPenalty(
            dto.getCustomPenalty() != null
               ? dto.getCustomPenalty()
               : (safetyMap.get(dto.getLevelTwoType()) == null ? null : safetyMap.get(dto.getLevelTwoType()).getPenalty())
         );
      }

      dto.setForfeit(dto.getPenalty());
      List<Long> inspectionReportIds = this.qhseInspectionLinkService
         .list(Wrappers.lambdaQuery(MesBuildingQhseInspectionLink.class).eq(MesBuildingQhseInspectionLink::getQhseId, id))
         .stream()
         .map(MesBuildingQhseInspectionLink::getInspectionReportId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(inspectionReportIds)) {
         List<MesBuildingProduceInspectionTeamReportPaintThicknessLink> paintThicknessLinkList = this.paintThicknessLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReportPaintThicknessLink.class)
                  .in(MesBuildingProduceInspectionTeamReportPaintThicknessLink::getInspectionId, inspectionReportIds)
            );
         if (CollectionUtils.isNotEmpty(paintThicknessLinkList)) {
            Map<Long, Integer> inspectionTeamReportMap = this.inspectionTeamReportService
               .listByIds(inspectionReportIds)
               .stream()
               .collect(Collectors.toMap(MesBuildingProduceInspectionTeamReport::getId, MesBuildingProduceInspectionTeamReport::getNumber));
            List<PaintThicknessDTO> collect = paintThicknessLinkList.stream().map(e -> {
               PaintThicknessDTO paintThicknessDTO = BeanUtil.copy(e, PaintThicknessDTO.class);
               paintThicknessDTO.setNumber(inspectionTeamReportMap.get(e.getInspectionId()));
               return paintThicknessDTO;
            }).collect(Collectors.toList());
            dto.setPaintThicknessList(collect);
         }
      }

      return dto;
   }

   @Override
   public MesBuildingQhseDTO getAcceptOnDeviationById(Long id, Integer status, Long userId) {
      MesBuildingQhseDTO dto = BeanUtil.copy(this.mesBuildingQhseService.selectQhseById(id, userId), MesBuildingQhseDTO.class);
      if (dto == null) {
         return new MesBuildingQhseDTO();
      }

      MesBuildingQhse buildingQhse = this.mesBuildingQhseService.getById(id);
      if (QhseTypeEnum.SECURITY.getType() == buildingQhse.getType() && dto == null) {
         dto = BeanUtil.copy(this.mesBuildingQhseService.selectQhseById(id, null), MesBuildingQhseDTO.class);
         dto.setPowerType(1);
      }

      dto.setAttachmentDTOS(this.attachmentService.listByIds(dto.getProblemDrawing()));
      List<MesBuildingQhseInspectionLink> list = this.mesBuildingQhseInspectionLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingQhseInspectionLink.class).eq(MesBuildingQhseInspectionLink::getQhseId, id));
      List<MesBuildingQhseRectifyDTO> rectifyDTOS = this.qhseRectifyService
         .list(
            (Wrapper<MesBuildingQhseRectify>)(Wrappers.<MesBuildingQhseRectify>lambdaQuery().eq(MesBuildingQhseRectify::getQhseId, dto.getId()))
               .orderByDesc(BaseEntity::getCreateTime)
         )
         .stream()
         .map(copy -> BeanUtil.copy(copy, MesBuildingQhseRectifyDTO.class))
         .collect(Collectors.toList());
      rectifyDTOS.forEach(temp -> {
         temp.setAttachmentDTOS(this.attachmentService.listByIds(temp.getRectifyDrawing()));
         temp.setName(this.userService.getById(temp.getUserId()).getName());
      });
      dto.setQhseRectifyDTOS(rectifyDTOS);
      MesBuildingTask task = null;
      if (buildingQhse.getTaskId() != null) {
         task = this.taskService.getOne(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getId, buildingQhse.getTaskId()));
         if (task.getBoolOneCode()) {
            dto.setNumbers(list.stream().map(MesBuildingQhseInspectionLink::getNumber).filter(Objects::nonNull).collect(Collectors.toList()));
         } else {
            dto.setNumbers(new ArrayList<>());
         }

         if (dto.getType().equals(QhseTypeEnum.SPECIAL_QUALITY.getType()) && dto.getNumber() != null) {
            dto.setNumbers(Arrays.asList(dto.getNumber()));
         }
      }

      if (dto.getType().equals(QhseTypeEnum.QUALITY.getType())) {
         if (dto.getTaskTypeEnum().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            dto.setProductSerialNumber(this.assembleService.getById(dto.getProductId()).getSerialNumber());
         } else if (dto.getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
            dto.setProductName(this.artifactService.getById(dto.getProductId()).getName());
            dto.setProductSerialNumber(this.artifactService.getById(dto.getProductId()).getSerialNumber());
         } else if (dto.getTaskTypeEnum().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            dto.setProductName(this.enclosureService.getById(dto.getProductId()).getName());
            dto.setProductSerialNumber(this.enclosureService.getById(dto.getProductId()).getSerialNumber());
         } else if (dto.getTaskTypeEnum().equals(ProductTypeEnum.MACHINE_PART.getType())) {
            dto.setProductSerialNumber(this.machinePartService.getById(dto.getProductId()).getSerialNumber());
         }

         dto.setQualityTypeList(this.dictionaryService.listLabelsByCondition(DictionaryEnum.MES_QHSE_PRODUCT_PROBLEM_TYPE.getName(), dto.getQualityType()));
         MesBuildingQhseAcceptDeviation deviations = this.qhseAcceptDeviationService
            .getOne(
               (Wrapper<MesBuildingQhseAcceptDeviation>)(Wrappers.<MesBuildingQhseAcceptDeviation>lambdaQuery()
                     .eq(MesBuildingQhseAcceptDeviation::getQhseId, buildingQhse.getId()))
                  .eq(MesBuildingQhseAcceptDeviation::getStatus, status)
            );
         if (deviations != null) {
            dto.setSubmitRemark(deviations.getSubmitRemark());
            dto.setApprovalRemark(deviations.getApprovalRemark());
         }
      }

      if (dto.getType().equals(QhseTypeEnum.SPECIAL_QUALITY.getType())) {
         if (task == null) {
            return dto;
         }

         ContractProject project = this.projectService.getById(task.getProjectId());
         ProjectDetailDO projectDetailDO = ProjectDetailDO.builder()
            .id(project.getId())
            .name(project.getName())
            .shortName(project.getShortName())
            .serialNumber(project.getSerialNumber())
            .type(project.getProjectType())
            .build();
         dto.setProjectId(task.getProjectId())
            .setMonomerId(task.getMonomerId())
            .setMonomerName(this.planMonomerService.getById(task.getMonomerId()).getName())
            .setAreaId(task.getAreaId())
            .setFactoryId(task.getFactoryId())
            .setWorkshopId(task.getWorkshopId())
            .setProductionLineId(task.getProductionLineId())
            .setProductId(task.getProductId())
            .setTaskTypeEnum(task.getTaskTypeEnum())
            .setProject(projectDetailDO)
            .setProjectName(this.projectService.getById(task.getProjectId()).getName())
            .setFactoryName(this.factoryService.getById(task.getFactoryId()).getName())
            .setWorkshopName(this.workshopService.getById(task.getWorkshopId()).getName())
            .setProductionLineName(this.productionLineService.getById(task.getProductionLineId()).getName());
         if (task.getTaskTypeEnum().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            dto.setProductSerialNumber(this.assembleService.getById(task.getProductId()).getSerialNumber());
         } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
            dto.setProductName(this.artifactService.getById(task.getProductId()).getName());
            dto.setProductSerialNumber(this.artifactService.getById(task.getProductId()).getSerialNumber());
         } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            dto.setProductName(this.enclosureService.getById(task.getProductId()).getName());
            dto.setProductSerialNumber(this.enclosureService.getById(task.getProductId()).getSerialNumber());
         } else if (task.getTaskTypeEnum().equals(ProductTypeEnum.MACHINE_PART.getType())) {
            dto.setProductSerialNumber(this.machinePartService.getById(task.getProductId()).getSerialNumber());
         }

         dto.setQualityTypeList(this.dictionaryService.listLabelsByCondition(DictionaryEnum.MES_QHSE_PRODUCT_PROBLEM_TYPE.getName(), dto.getQualityType()));
      }

      if (CollectionUtils.isEmpty(dto.getNumbers())) {
         dto.setNumbers(null);
      }

      return dto;
   }

   @Override
   public List<QhseSummaryDTO> qhseSummary(Long projectId) {
      Map<String, Integer> qualityTypeMap = new HashMap<>();
      this.mesBuildingQhseService
         .list(
            (Wrappers.<MesBuildingQhse>lambdaQuery().eq(MesBuildingQhse::getType, QhseTypeEnum.QUALITY.getType()))
               .eq(projectId != null, MesBuildingQhse::getProjectId, projectId)
         )
         .forEach(e -> {
            String[] qualityType = e.getQualityType().split(",");

            for (int i = 0; i < qualityType.length; i++) {
               if (qualityTypeMap.get(qualityType[i]) == null) {
                  qualityTypeMap.put(qualityType[i], 1);
               } else {
                  qualityTypeMap.replace(qualityType[i], qualityTypeMap.get(qualityType[i]) + 1);
               }
            }
         });
      List<QhseSummaryDTO> dtoList = new ArrayList<>();
      Map<String, String> qualityMap = this.dictionaryService.getValueLabelByName(DictionaryEnum.MES_QHSE_PRODUCT_PROBLEM_TYPE.getName());

      for (Entry<String, Integer> entry : qualityTypeMap.entrySet()) {
         dtoList.add(QhseSummaryDTO.builder().quantity(entry.getValue()).qualityValue(entry.getKey()).qualityType(qualityMap.get(entry.getKey())).build());
      }

      return dtoList;
   }

   @Override
   public Boolean qhseDetailDownload(Long id, HttpServletResponse response) {
      Map<String, Object> result = new HashMap<>();
      MesBuildingQhseDTO qhse = this.getQhseById(id, null, null);
      String typeName = QhseTypeEnum.getNameByType(qhse.getType());
      List<AttachmentDTO> qhseImageList = qhse.getAttachmentDTOS();
      List<Map<String, ImageEntity>> rowList = this.getImageRowList(qhseImageList, 3);
      MesBuildingQhseRectifyDTO qhseRectifyDTO = null;
      List<Map<String, ImageEntity>> qhseRectifyDTOList = new ArrayList<>();
      if (qhse.getQhseRectifyDTOS().size() > 0 && qhse.getQhseRectifyDTOS() != null) {
         qhseRectifyDTO = qhse.getQhseRectifyDTOS().get(0);
         List<AttachmentDTO> qhseRectifyImageList = qhseRectifyDTO.getAttachmentDTOS();
         qhseRectifyDTOList = this.getImageRowList(qhseRectifyImageList, 3);
      }

      result.put("date1", qhse.getCreateTime());
      result.put("project", qhse.getProject());
      result.put("review", qhse);
      result.put("typeName", typeName);
      result.put("qualityTypeList", qhse.getQualityTypeList() == null ? null : String.join(",", qhse.getQualityTypeList()));
      result.put("rectifyName", qhseRectifyDTO == null ? null : qhseRectifyDTO.getName());
      result.put("date2", qhseRectifyDTO == null ? null : qhseRectifyDTO.getCreateTime());
      result.put("rowList", rowList);
      result.put("qhseRectifyDTOList", qhseRectifyDTOList);
      String tempFileName = "QhseEventExposure";
      String resourcePath = "files/QhseEventExposure.xlsx";
      String exportFileName = "QHSE事件曝光.xlsx";
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, result);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }

   @Override
   public Boolean qhseDetailAllDownload(List<Long> id, HttpServletResponse response) {
      Map<String, Object> result = new HashMap<>();
      List<Map<String, Object>> roleList = new ArrayList<>();
      int number = 1;

      for (Long i : id) {
         MesBuildingQhseDTO qhse = this.getQhseById(i, null, null);
         String typeName;
         if (qhse.getType().equals(QhseTypeEnum.QUALITY.getType())) {
            typeName = QhseTypeEnum.QUALITY.getName();
         } else if (qhse.getType().equals(QhseTypeEnum.SECURITY.getType())) {
            typeName = QhseTypeEnum.SECURITY.getName();
         } else if (qhse.getType().equals(QhseTypeEnum.ENVIRONMENT.getType())) {
            typeName = QhseTypeEnum.ENVIRONMENT.getName();
         } else {
            typeName = QhseTypeEnum.SPECIAL_QUALITY.getName();
         }

         String status;
         if (qhse.getStatus().equals(QhseStatusEnum.UN_ADOPT.getType())) {
            status = QhseStatusEnum.UN_ADOPT.getName();
         } else if (qhse.getStatus().equals(QhseStatusEnum.RECTIFIED.getType())) {
            status = QhseStatusEnum.RECTIFIED.getName();
         } else if (qhse.getStatus().equals(QhseStatusEnum.ADOPT.getType())) {
            status = QhseStatusEnum.ADOPT.getName();
         } else {
            status = QhseStatusEnum.UN_RECTIFIED.getName();
         }

         List<AttachmentDTO> qhseImageList = qhse.getAttachmentDTOS();
         List<Map<String, ImageEntity>> rowList = this.getImageRowList(qhseImageList, 2);
         MesBuildingQhseRectifyDTO qhseRectifyDTO = null;
         List<Map<String, ImageEntity>> qhseRectifyDTOList = new ArrayList<>();
         if (qhse.getQhseRectifyDTOS() != null && qhse.getQhseRectifyDTOS().size() > 0) {
            qhseRectifyDTO = qhse.getQhseRectifyDTOS().get(0);
            List<AttachmentDTO> qhseRectifyImageList = qhseRectifyDTO.getAttachmentDTOS();
            qhseRectifyDTOList = this.getImageRowList(qhseRectifyImageList, 2);
         }

         HashMap<String, Object> results = new HashMap<>();
         results.put("number", number++);
         results.put("typeName", typeName);
         results.put("productSerialNumber", qhse.getProductSerialNumber());
         results.put("username", qhse.getUserName() + qhse.getCreateTime());
         results.put("project", qhse.getProject() == null ? null : qhse.getProject().getSerialNumber() + qhse.getProject().getName());
         results.put("remark", qhse.getRemark());
         results.put("dutyname", qhse.getDutyName() == null ? null : qhse.getDutyName() + qhse.getCreateTime());
         results.put("status", status);
         results.put("qualityTypeList", qhse.getQualityTypeList() == null ? null : String.join(",", qhse.getQualityTypeList()));
         results.put("rectifyName", qhseRectifyDTO == null ? null : (qhseRectifyDTO.getName() + qhseRectifyDTO == null ? null : qhseRectifyDTO.getCreateTime()));
         results.put("rowList", rowList);
         if (qhseRectifyDTOList.size() == 1) {
            results.put("qhseRectifyDTOList1", qhseRectifyDTOList.get(0));
            results.put("qhseRectifyDTOList2", null);
         } else if (qhseRectifyDTOList.size() == 2) {
            results.put("qhseRectifyDTOList1", qhseRectifyDTOList.get(0));
            results.put("qhseRectifyDTOList2", qhseRectifyDTOList.get(1));
         } else {
            results.put("qhseRectifyDTOList1", null);
            results.put("qhseRectifyDTOList2", null);
         }

         results.put("forfeit", qhse.getForfeit() == null ? null : qhse.getForfeit().toString());
         roleList.add(results);
      }

      result.put("result", roleList);
      String tempFileName = "QhseBatchEventExposure";
      String resourcePath = "files/QhseBatchEventExposure.xlsx";
      String exportFileName = "QHSE事件曝光.xlsx";
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, result);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }

   private List<Map<String, ImageEntity>> getImageRowList(List<AttachmentDTO> qhseImageList, int size) {
      if (qhseImageList.size() == 0) {
         return new ArrayList<>();
      }

      int row = qhseImageList.size() / size + (qhseImageList.size() % size > 0 ? 1 : 0);
      List<Map<String, ImageEntity>> rowList = new ArrayList<>();

      for (int i = 1; i <= row; i++) {
         Map<String, ImageEntity> imageEntityMap = new HashMap<>();

         for (int l = (i - 1) * size; l < i * size && l < qhseImageList.size(); l++) {
            ImageEntity image = new ImageEntity();
            image.setWidth(200);
            image.setHeight(200);
            image.setUrl(this.configProperties.getFilePath() + File.separator + qhseImageList.get(l).getRelativePath());
            image.setType(ImageEntity.URL);
            imageEntityMap.put("a" + l % size, image);
         }

         rowList.add(imageEntityMap);
      }

      return rowList;
   }

   private Boolean check(MesBuildingQhseDTOParam dtoParam) {
      Preconditions.checkArgument(dtoParam.getTeamId() != null, "责任班组id不能为空");
      Preconditions.checkArgument(dtoParam.getProblemQuantity() > 0, "问题数量不能小于0");
      return true;
   }

   private Long saveQhseInspectionLink(MesBuildingTaskProcess taskProcess, Long teamId, Integer problemQuantity, Long qhseId, Integer number) {
      MesBuildingInspectionTeam inspectionTeam = this.mesBuildingUtilsBiz
         .getInspectionTeamBygroupsIdAndProcessIdAndUserId(taskProcess.getGroupsId(), taskProcess.getProcessId(), UserUtil.getCurrentUserId());
      Preconditions.checkArgument(inspectionTeam != null, "上报失败,用户没有处于可以质检班组内");
      MesBuildingProduceInspectionTeamReport inspectionTeamReport = MesBuildingProduceInspectionTeamReport.builder()
         .teamId(teamId)
         .inspectionTeamId(inspectionTeam.getId())
         .productId(taskProcess.getProductId())
         .taskTypeEnum(taskProcess.getTaskTypeEnum())
         .processId(taskProcess.getProcessId())
         .taskProcessId(taskProcess.getId())
         .taskId(taskProcess.getTaskId())
         .groupId(taskProcess.getGroupsId())
         .inspectionQuantity(problemQuantity)
         .userId(UserUtil.getCurrentUserId())
         .boolAdoptEnum(false)
         .number(number)
         .schedulingId(taskProcess.getSchedulingId())
         .build();
      this.inspectionTeamReportService.save(inspectionTeamReport);
      MesBuildingProduceTeamReport teamReport = this.mesBuildingProduceTeamReportService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .eq(MesBuildingProduceTeamReport::getTaskProcessId, taskProcess.getId())
               .eq(MesBuildingProduceTeamReport::getNumber, number)
         );
      teamReport.setProblemQuantity(teamReport.getProblemQuantity() + problemQuantity);
      this.mesBuildingProduceTeamReportService.updateById(teamReport);
      MesBuildingProduceQhseTeamReport qhseTeamReport = MesBuildingProduceQhseTeamReport.builder()
         .teamId(inspectionTeamReport.getTeamId())
         .inspectionTeamId(inspectionTeamReport.getInspectionTeamId())
         .productId(inspectionTeamReport.getProductId())
         .productType(inspectionTeamReport.getTaskTypeEnum())
         .processId(inspectionTeamReport.getProcessId())
         .taskProcessId(inspectionTeamReport.getTaskProcessId())
         .taskId(inspectionTeamReport.getTaskId())
         .qhseQuantity(inspectionTeamReport.getInspectionQuantity())
         .userId(inspectionTeamReport.getUserId())
         .schedulingId(inspectionTeamReport.getSchedulingId())
         .inspectionTeamReportId(inspectionTeamReport.getId())
         .build();
      this.qhseTeamReportService.save(qhseTeamReport);
      MesBuildingQhseInspectionLink link = MesBuildingQhseInspectionLink.builder()
         .qhseId(qhseId)
         .inspectionReportId(inspectionTeamReport.getId())
         .qhseReportId(qhseTeamReport.getId())
         .number(inspectionTeamReport.getNumber())
         .build();
      this.qhseInspectionLinkBiz.save(link);
      return link.getId();
   }

   private void saveQhseInspectionLinkBydtoParam(MesBuildingTaskProcess taskProcess, MesBuildingQhseDTOParam params, Long qhseId) {
      MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
      if (!taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()) && !taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         Preconditions.checkArgument(false, "操作失败!!!!");
      } else {
         List<InspectionReportSavedDTO> reportList = params.getReportList();
         List<Long> numberIds = reportList.stream().map(InspectionReportSavedDTO::getReportNumberId).distinct().collect(Collectors.toList());
         List<MesBuildingProduceTeamReport> reports = this.mesBuildingProduceTeamReportService
            .list(
               Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
                  .in(MesBuildingProduceTeamReport::getReportNumber, numberIds)
                  .apply("problem_quantity+inspection_quantity=0")
            );
         Map<Long, List<MesBuildingProduceTeamReport>> reportMap = reports.stream()
            .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getReportNumber));
         MesBuildingProduceTeamReport produceTeamReport = reports.get(0);
         List<MesInspectConfig> inspectConfig = this.inspectConfigService
            .selectCurrentUserIsInspectUser(
               produceTeamReport.getWorkshopId(), taskProcess.getProcessId(), task.getClassificationId(), UserUtil.getCurrentUserId()
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(inspectConfig), "上报失败,当前用户不是质检用户");
         List<MesBuildingProduceTeamReport> allUpdate = new ArrayList<>();
         HashMap<Long, Long> reportTeamAndNumberIdLinkMap = new HashMap<>();
         Map<Long, InspectionReportSavedDTO> reportDTOMap = reportList.stream()
            .collect(Collectors.toMap(InspectionReportSavedDTO::getReportNumberId, Function.identity()));

         for (InspectionReportSavedDTO savedDTO : reportList) {
            List<MesBuildingProduceTeamReport> teamReports = reportMap.get(savedDTO.getReportNumberId());
            Preconditions.checkArgument(teamReports.size() >= savedDTO.getReportQuantity(), "操作失败!!!");
            List<MesBuildingProduceTeamReport> needUpdateReport = teamReports.stream()
               .limit(savedDTO.getReportQuantity().intValue())
               .collect(Collectors.toList());
            needUpdateReport.forEach(s -> s.setProblemQuantity(s.getProblemQuantity() + 1));
            Preconditions.checkArgument(
               needUpdateReport.stream().noneMatch(s -> s.getQuantity() > s.getInspectionQuantity() + s.getProblemQuantity()), "操作失败!!!"
            );
            allUpdate.addAll(needUpdateReport);
            needUpdateReport.forEach(e -> {
               Long var10000 = reportTeamAndNumberIdLinkMap.put(e.getId(), savedDTO.getReportNumberId());
            });
         }

         this.mesBuildingProduceTeamReportService.updateBatchById(allUpdate);
         List<MesBuildingProduceInspectionTeamReport> saveInspects = new ArrayList<>();
         Long reportNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
         LocalDateTime reportTimes = LocalDateTime.now();
         PaintThicknessDO paintThicknessConfig = this.configService.getPaintThicknessConfig();
         HashMap<String, List<PaintThicknessSaveDTO>> paintThicknessMap = new HashMap<>();

         for (MesBuildingProduceTeamReport teamReport : allUpdate) {
            MesBuildingProduceInspectionTeamReport inspectionTeamReport = MesBuildingProduceInspectionTeamReport.builder()
               .teamId(teamReport.getTeamId())
               .productionLineId(teamReport.getProductionLineId())
               .productId(taskProcess.getProductId())
               .taskTypeEnum(taskProcess.getTaskTypeEnum())
               .processId(taskProcess.getProcessId())
               .taskProcessId(taskProcess.getId())
               .taskId(taskProcess.getTaskId())
               .groupId(teamReport.getGroupsId())
               .inspectReportNumber(reportNumber)
               .reportTime(reportTimes)
               .inspectionQuantity(1)
               .userId(UserUtil.getCurrentUserId())
               .boolAdoptEnum(false)
               .number(teamReport.getNumber())
               .schedulingId(taskProcess.getSchedulingId())
               .build();
            this.paintThicknessLinkService
               .buildInspectionPaintThicknessMap(
                  paintThicknessMap,
                  paintThicknessConfig,
                  taskProcess,
                  reportDTOMap.get(reportTeamAndNumberIdLinkMap.get(teamReport.getId())),
                  inspectionTeamReport
               );
            saveInspects.add(inspectionTeamReport);
            if (task.getBoolOneCode()) {
               reportNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
               reportTimes = LocalDateTime.now();
            }
         }

         this.inspectionTeamReportService.saveBatch(saveInspects);
         List<MesBuildingProduceInspectionTeamReportPaintThicknessLink> paintThicknessLinks = this.paintThicknessLinkService
            .getPaintThicknessLinkSaveList(saveInspects, paintThicknessMap);
         this.paintThicknessLinkService.saveBatch(paintThicknessLinks);
         List<MesBuildingQhseInspectionLink> links = new ArrayList<>();

         for (MesBuildingProduceInspectionTeamReport inspectionTeamReport : saveInspects) {
            MesBuildingProduceQhseTeamReport qhseTeamReport = MesBuildingProduceQhseTeamReport.builder()
               .teamId(inspectionTeamReport.getTeamId())
               .inspectionTeamId(inspectionTeamReport.getInspectionTeamId())
               .productId(inspectionTeamReport.getProductId())
               .productType(inspectionTeamReport.getTaskTypeEnum())
               .processId(inspectionTeamReport.getProcessId())
               .taskProcessId(inspectionTeamReport.getTaskProcessId())
               .taskId(inspectionTeamReport.getTaskId())
               .qhseQuantity(inspectionTeamReport.getInspectionQuantity())
               .userId(inspectionTeamReport.getUserId())
               .schedulingId(inspectionTeamReport.getSchedulingId())
               .inspectionTeamReportId(inspectionTeamReport.getId())
               .build();
            this.qhseTeamReportService.save(qhseTeamReport);
            MesBuildingQhseInspectionLink link = MesBuildingQhseInspectionLink.builder()
               .qhseId(qhseId)
               .inspectionReportId(inspectionTeamReport.getId())
               .qhseReportId(qhseTeamReport.getId())
               .number(inspectionTeamReport.getNumber())
               .build();
            links.add(link);
         }

         this.qhseInspectionLinkService.saveBatch(links);
      }
   }

   @Override
   public List<LastSendPersonDTO> LastSendPerson() {
      Object o = this.redisUtils.get("qhse_userlink:" + UserUtil.getCurrentUserId());
      if (o == null) {
         return new ArrayList<>();
      }

      List<Long> dto = (List<Long>)o;
      List<User> users = this.userService.list(Wrappers.lambdaQuery(User.class).in(User::getId, dto).eq(User::getIsEnabled, Boolean.TRUE));
      if (CollectionUtils.isEmpty(users)) {
         return new ArrayList<>();
      }

      List<Long> deptId = users.stream().map(s -> s.getDepartmentId()).collect(Collectors.toList());
      Map<Long, String> departMap = this.departmentService.listByIds(deptId).stream().collect(Collectors.toMap(s -> s.getId(), s -> s.getName()));
      return users.stream()
         .map(s -> LastSendPersonDTO.builder().Id(s.getId()).name(s.getName()).deptId(s.getDepartmentId()).deptName(departMap.get(s.getDepartmentId())).build())
         .collect(Collectors.toList());
   }

   @Override
   public void exportQhseList(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      String sort,
      Integer pageNumber,
      Integer pageSize,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Long processId,
      Long levelOneType,
      Long levelTwoType,
      HttpServletResponse response
   ) {
      List<MesBuildingQhseDataExcelDTO> exportDTOS = new ArrayList<>();
      String title = "安环统计";
      String sheetName = "安环统计报表";
      String fileName = "安环统计报表.xlsx";
      AtomicReference<Long> orderNo = new AtomicReference<>(1L);
      PageVO<MesBuildingQhseDTO> mesBuildingQhseDTOPageVO = PageUtil.listPage(
         pageNumber,
         pageSize,
         this.qhseList(
            qhseId,
            projectId,
            userName,
            dutyName,
            rectifyName,
            serialNumber,
            type,
            status,
            boolApp,
            userId,
            startDate,
            endDate,
            specifiedDate,
            qhseIds,
            processId,
            levelOneType,
            levelTwoType
         )
      );
      if (CollectionUtils.isNotEmpty(mesBuildingQhseDTOPageVO.getContent())) {
         List<MesBuildingQhseDTO> qhseDTOList = mesBuildingQhseDTOPageVO.getContent();
         if (CollectionUtils.isNotEmpty(qhseDTOList)) {
            qhseDTOList.forEach(qhseDTO -> {
               MesBuildingQhseDataExcelDTO excelDTO = BeanUtil.copy(qhseDTO, MesBuildingQhseDataExcelDTO.class);
               excelDTO.setOrderNo(orderNo.getAndSet(orderNo.get() + 1L));
               excelDTO.setCreateTime(DateUtil.format(qhseDTO.getCreateTime(), "yyyy-MM-dd"));
               if (CollectionUtils.isNotEmpty(qhseDTO.getAttachmentDTOS())) {
                  byte[] imageByte = this.getImageByte(qhseDTO.getAttachmentDTOS());
                  excelDTO.setEntranceAttachment(imageByte);
               }

               if (CollectionUtils.isNotEmpty(qhseDTO.getQhseRectifyDTOS())) {
                  MesBuildingQhseRectifyDTO mesBuildingQhseRectifyDTO = qhseDTO.getQhseRectifyDTOS().get(0);
                  excelDTO.setAfterRemark(mesBuildingQhseRectifyDTO.getRemark());
                  if (CollectionUtils.isNotEmpty(mesBuildingQhseRectifyDTO.getAttachmentDTOS())) {
                     byte[] imageByte = this.getImageByte(mesBuildingQhseRectifyDTO.getAttachmentDTOS());
                     excelDTO.setAfterAttachment(imageByte);
                  }
               }

               exportDTOS.add(excelDTO);
            });
         }
      }

      PoiUtils.annotatedExportExcel(exportDTOS, title, sheetName, MesBuildingQhseDataExcelDTO.class, fileName, ExcelType.XSSF, response);
   }

   @Override
   public void exportQhseStats(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      String sort,
      Integer pageNumber,
      Integer pageSize,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Long processId,
      Long levelOneType,
      Long levelTwoType,
      HttpServletResponse response
   ) {
      List<MesBuildingQhseProblemDataExcelDTO> exportDTOS = new ArrayList<>();
      String title = "问题统计";
      String sheetName = "问题统计报表";
      String fileName = "问题统计报表.xlsx";
      AtomicReference<Long> orderNo = new AtomicReference<>(1L);
      PageVO<MesBuildingQhseDTO> mesBuildingQhseDTOPageVO = PageUtil.listPage(
         pageNumber,
         pageSize,
         this.qhseList(
            qhseId,
            projectId,
            userName,
            dutyName,
            rectifyName,
            serialNumber,
            type,
            status,
            boolApp,
            userId,
            startDate,
            endDate,
            specifiedDate,
            qhseIds,
            processId,
            levelOneType,
            levelTwoType
         )
      );
      if (CollectionUtils.isNotEmpty(mesBuildingQhseDTOPageVO.getContent())) {
         List<MesBuildingQhseDTO> qhseDTOList = mesBuildingQhseDTOPageVO.getContent();
         if (CollectionUtils.isNotEmpty(qhseDTOList)) {
            qhseDTOList.forEach(qhseDTO -> {
               MesBuildingQhseProblemDataExcelDTO excelDTO = BeanUtil.copy(qhseDTO, MesBuildingQhseProblemDataExcelDTO.class);
               excelDTO.setOrderNo(orderNo.getAndSet(orderNo.get() + 1L));
               excelDTO.setCreateTime(DateUtil.format(qhseDTO.getCreateTime(), "yyyy-MM-dd"));
               if (CollectionUtils.isNotEmpty(qhseDTO.getAttachmentDTOS())) {
                  byte[] imageByte = this.getImageByte(qhseDTO.getAttachmentDTOS());
                  excelDTO.setEntranceAttachment(imageByte);
               }

               if (CollectionUtils.isNotEmpty(qhseDTO.getQhseRectifyDTOS())) {
                  MesBuildingQhseRectifyDTO mesBuildingQhseRectifyDTO = qhseDTO.getQhseRectifyDTOS().get(0);
                  excelDTO.setAfterRemark(mesBuildingQhseRectifyDTO.getRemark());
                  if (CollectionUtils.isNotEmpty(mesBuildingQhseRectifyDTO.getAttachmentDTOS())) {
                     byte[] imageByte = this.getImageByte(mesBuildingQhseRectifyDTO.getAttachmentDTOS());
                     excelDTO.setAfterAttachment(imageByte);
                  }
               }

               exportDTOS.add(excelDTO);
            });
         }
      }

      PoiUtils.annotatedExportExcel(exportDTOS, title, sheetName, MesBuildingQhseProblemDataExcelDTO.class, fileName, ExcelType.XSSF, response);
   }

   private byte[] getImageByte(List<AttachmentDTO> attachmentDTOS) {
      AttachmentDTO attachmentDTO = attachmentDTOS.get(0);
      InputStream inputStream = null;
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

      try {
         URL url = new URL(attachmentDTO.getImageUrl());
         HttpURLConnection connection = (HttpURLConnection)url.openConnection();
         connection.setRequestMethod("GET");
         inputStream = new BufferedInputStream(connection.getInputStream());
         if (inputStream != null) {
            try {
               Img.from(inputStream).setQuality(0.3).write(outputStream);
            } catch (Exception e1) {
               byte[] buffer = new byte[1024];

               while (true) {
                  try {
                     int length;
                     if ((length = inputStream.read(buffer)) == -1) {
                        break;
                     }

                     outputStream.write(buffer, 0, length);
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (inputStream != null) {
            try {
               inputStream.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }

      return outputStream.toByteArray();
   }

   @Override
   public ArtifactQhseSpotCheckDTO getArtifactByTaskId(Long taskId, Integer number) {
      MesBuildingTask task = this.taskService.getById(taskId);
      Preconditions.checkArgument(task != null, "任务不能为空");
      Preconditions.checkArgument(task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()), "操作失败,该产品非构件!");
      Integer operableQuantity = 0;
      if (task.getBoolOneCode()) {
         Preconditions.checkArgument(number != null, "操作失败,一物一码产品需码号信息!");
         List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService
            .list(
               (Wrapper<MesBuildingWarehouseRecord>)(((((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                                 .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                              .eq(MesBuildingWarehouseRecord::getType, 1))
                           .eq(MesBuildingWarehouseRecord::getProductId, task.getProductId()))
                        .eq(MesBuildingWarehouseRecord::getNumber, number))
                     .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType()))
                  .ne(MesBuildingWarehouseRecord::getStatus, 1)
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(recordList), "操作失败,扫码构件已打包或发运!");
         operableQuantity = 1;
      } else {
         operableQuantity = task.getTaskQuantity();
         List<MesBuildingComplete> completes = this.completeService
            .list(
               (Wrapper<MesBuildingComplete>)(new LambdaQueryWrapper<MesBuildingComplete>().eq(MesBuildingComplete::getTaskId, task.getId()))
                  .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         if (CollectionUtils.isNotEmpty(completes)) {
            List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService
               .list(
                  (Wrapper<MesBuildingWarehouseRecord>)(((((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                                    .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                                 .in(MesBuildingWarehouseRecord::getCompleteId, completes.stream().map(MesBuildingComplete::getId).collect(Collectors.toList())))
                              .eq(MesBuildingWarehouseRecord::getType, 1))
                           .eq(MesBuildingWarehouseRecord::getProductId, task.getProductId()))
                        .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType()))
                     .ne(MesBuildingWarehouseRecord::getStatus, 1)
               );
            Preconditions.checkArgument(CollectionUtils.isEmpty(recordList) || recordList.size() < task.getTaskQuantity(), "操作失败,扫码构件任务已全部打包或发运!");
            operableQuantity = task.getTaskQuantity() - recordList.size();
         }
      }

      TechArtifact techArtifact = this.artifactService.getById(task.getProductId());
      Preconditions.checkArgument(techArtifact != null, "构件清单不存在!");
      ArtifactQhseSpotCheckDTO artifactQhseSpotCheckDTO = BeanUtil.copy(techArtifact, ArtifactQhseSpotCheckDTO.class);
      ProjectInfo info = this.projectService.getSimpleById(techArtifact.getProjectId());
      artifactQhseSpotCheckDTO.setProject(info);
      NameInfo monomerNameInfo = this.monomerService.getSimpleById(techArtifact.getMonomerId());
      artifactQhseSpotCheckDTO.setMonomer(monomerNameInfo);
      NameInfo areaNameInfo = this.areaService.getSimpleById(techArtifact.getAreaId());
      artifactQhseSpotCheckDTO.setArea(areaNameInfo);
      artifactQhseSpotCheckDTO.setOperableQuantity(operableQuantity);
      artifactQhseSpotCheckDTO.setNumber(number);
      artifactQhseSpotCheckDTO.setWorkShopName(this.workshopService.getById(task.getWorkshopId()).getName());
      artifactQhseSpotCheckDTO.setProductionLineName(this.productionLineService.getById(task.getProductionLineId()).getName());
      artifactQhseSpotCheckDTO.setBoolOneCode(task.getBoolOneCode());
      return artifactQhseSpotCheckDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveQhseSpotCheck(MesBuildingCheckQhseDTOParam dtoParam) {
      MesBuildingTask task = this.taskService.getById(dtoParam.getTaskId());
      Preconditions.checkArgument(task != null && task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()), "操作失败,构件任务不存在!");
      TechArtifact artifact = this.artifactService.getById(task.getProductId());
      Preconditions.checkArgument(artifact != null, "构件不存在!");
      int sumCheckQuantity = 0;
      int unQualifiedQuantity = 0;
      List<Integer> numberList = null;
      if (!task.getBoolOneCode() && !CollectionUtils.isNotEmpty(dtoParam.getNumberQualifiedList())) {
         Preconditions.checkArgument(CollectionUtils.isEmpty(dtoParam.getNumberQualifiedList()), "操作失败,该产品为一码多件,不可选码操作!");
         Preconditions.checkArgument(
            dtoParam.getQualifiedQuantity() != null
               && dtoParam.getQualifiedQuantity() >= 0
               && dtoParam.getUnQualifiedQuantity() != null
               && dtoParam.getUnQualifiedQuantity() >= 0
               && dtoParam.getQualifiedQuantity() + dtoParam.getUnQualifiedQuantity() > 0,
            "操作失败,抽检的合格数/不合格数异常!"
         );
         sumCheckQuantity = dtoParam.getQualifiedQuantity() + dtoParam.getUnQualifiedQuantity();
         unQualifiedQuantity = dtoParam.getUnQualifiedQuantity();
         Preconditions.checkArgument(unQualifiedQuantity <= task.getTaskQuantity(), "所选数量不可超过任务数");
         List<MesBuildingComplete> completes = this.completeService
            .list(
               (Wrapper<MesBuildingComplete>)(new LambdaQueryWrapper<MesBuildingComplete>().eq(MesBuildingComplete::getTaskId, task.getId()))
                  .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         if (CollectionUtils.isNotEmpty(completes)) {
            List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService
               .list(
                  (Wrapper<MesBuildingWarehouseRecord>)(((((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                                    .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                                 .in(MesBuildingWarehouseRecord::getCompleteId, completes.stream().map(MesBuildingComplete::getId).collect(Collectors.toList())))
                              .eq(MesBuildingWarehouseRecord::getType, 1))
                           .eq(MesBuildingWarehouseRecord::getProductId, task.getProductId()))
                        .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType()))
                     .ne(MesBuildingWarehouseRecord::getStatus, 1)
               );
            Preconditions.checkArgument(CollectionUtils.isEmpty(recordList) || recordList.size() < task.getTaskQuantity(), "操作失败,构件任务已全部打包或发运!");
            Preconditions.checkArgument(unQualifiedQuantity <= task.getTaskQuantity() - recordList.size(), "可操作数不足,存在打包/装车的构件!");
         }
      } else {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(dtoParam.getNumberQualifiedList()), "操作失败,一物一码列表不可为空!");
         numberList = dtoParam.getNumberQualifiedList()
            .stream()
            .map(ArtifactNumberQualifiedQuantityDTOParam::getNumber)
            .distinct()
            .collect(Collectors.toList());
         Preconditions.checkArgument(numberList.size() == dtoParam.getNumberQualifiedList().size(), "操作失败,码号不可重复");
         sumCheckQuantity = dtoParam.getNumberQualifiedList().size();
         unQualifiedQuantity = (int)dtoParam.getNumberQualifiedList().stream().filter(e -> !e.getBoolQualified()).count();
         List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService
            .list(
               (Wrapper<MesBuildingWarehouseRecord>)(((((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                                 .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                              .eq(MesBuildingWarehouseRecord::getType, 1))
                           .eq(MesBuildingWarehouseRecord::getProductId, task.getProductId()))
                        .ne(MesBuildingWarehouseRecord::getStatus, 1))
                     .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.NORMAL.getType()))
                  .in(MesBuildingWarehouseRecord::getNumber, numberList)
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(recordList), "操作失败,所选构件码号已装车或打包,请刷新重新!");
      }

      MesBuildingSpotCheckQhse spotCheckQhse = BeanUtil.copy(task, MesBuildingSpotCheckQhse.class);
      BeanUtil.copy(artifact, spotCheckQhse);
      spotCheckQhse.setTaskId(task.getId());
      spotCheckQhse.setSpotCheckQuantity(sumCheckQuantity);
      spotCheckQhse.setTaskTypeEnum(TaskTypeEnum.ARTIFACT.getType());
      spotCheckQhse.setQualifiedQuantity(sumCheckQuantity - unQualifiedQuantity);
      spotCheckQhse.setUnQualifiedQuantity(unQualifiedQuantity);
      spotCheckQhse.setSpotCheckDateTime(LocalDateTime.now());
      spotCheckQhse.setSpotCheckUserName(UserUtil.getCurrentName());
      spotCheckQhse.setSpotCheckRemark(dtoParam.getRemark());
      this.spotCheckQhseService.save(spotCheckQhse);
      if (unQualifiedQuantity == 0) {
         return Boolean.TRUE;
      }

      dtoParam.setProblemDrawing(this.utilsBiz.longListToString(dtoParam.getDrawingIds()));
      String codeConfig = null;
      MesBuildingQhse qhse = BeanUtil.copy(dtoParam, MesBuildingQhse.class);
      MesQualityClassConfig classConfigs = this.qualityClassService
         .getOne(Wrappers.lambdaQuery(MesQualityClassConfig.class).eq(MesQualityClassConfig::getId, dtoParam.getLevelOneType()));
      codeConfig = classConfigs.getSerialNumber();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(codeConfig), "问题类型代码不存在，请检查配置");
      Integer count = this.getNumber();
      LocalDateTime dateTime = LocalDateTime.now();
      String number1 = count == 0 ? "1" : count.toString();
      String qhseNumber = codeConfig + dateTime.getYear() + "-" + dateTime.getMonthValue() + "-" + dateTime.getDayOfMonth() + "-" + number1;
      qhse.setQhseNumber(qhseNumber);
      qhse.setProjectId(task.getProjectId());
      qhse.setMonomerId(task.getMonomerId());
      qhse.setAreaId(task.getAreaId());
      qhse.setProductId(task.getProductId());
      qhse.setTaskTypeEnum(task.getTaskTypeEnum());
      qhse.setType(QhseTypeEnum.SPOT_CHECK.getType());
      Preconditions.checkArgument(task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()), "操作失败,仅构件可抽检");
      this.mesBuildingQhseService.saveOrUpdate(qhse);
      if (dtoParam.getBoolConcessionAcceptance() != null && dtoParam.getBoolConcessionAcceptance()) {
         this.qhseAcceptDeviationService
            .saveQhseAcceptDeviation(MesBuildingQhseAcceptDeviationDTO.builder().qhseId(qhse.getId()).submitRemark(dtoParam.getSubmitRemark()).build());
      }

      this.qhseUserLinkService
         .save(MesBuildingQhseUserLink.builder().qhseId(qhse.getId()).powerType(QhsePowerTypeEnum.EXAMINE.getType()).userId(qhse.getUserId()).build());
      List<MesBuildingTeamUserLink> updateUsers = this.teamUserLinkService
         .list((Wrapper<MesBuildingTeamUserLink>)new LambdaQueryWrapper<MesBuildingTeamUserLink>().eq(MesBuildingTeamUserLink::getTeamId, qhse.getTeamId()));
      List<Long> updateUserIds = updateUsers.stream().map(MesBuildingTeamUserLink::getUserId).collect(Collectors.toList());
      if (!updateUserIds.contains(qhse.getDutyId())) {
         updateUserIds.add(qhse.getDutyId());
      }

      if (updateUserIds.contains(qhse.getUserId())) {
         updateUserIds.remove(qhse.getUserId());
      }

      updateUserIds.forEach(
         userId -> this.qhseUserLinkService
            .save(MesBuildingQhseUserLink.builder().qhseId(qhse.getId()).powerType(QhsePowerTypeEnum.UPDATE.getType()).userId(userId).build())
      );
      dtoParam.getUserLink().forEach(e -> {
         if (!e.equals(qhse.getUserId()) && !e.equals(qhse.getDutyId()) && !updateUserIds.contains(e)) {
            this.qhseUserLinkService.save(MesBuildingQhseUserLink.builder().userId(e).qhseId(qhse.getId()).powerType(QhsePowerTypeEnum.SEE.getType()).build());
         }
      });
      if (CollectionUtils.isNotEmpty(dtoParam.getUserLink())) {
         this.redisUtils.set("qhse_userlink:" + UserUtil.getCurrentUserId(), dtoParam.getUserLink());
      }

      return Boolean.TRUE;
   }

   @Override
   public PageVO findSpotCheckListPage(Long projectId, String projectName, String userName, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.findSpotCheckList(projectId, projectName, userName));
   }

   @Override
   public List<MesBuildingSpotStatisticsCountDTO> findSpotCheckList(Long projectId, String projectName, String userName) {
      List<MesBuildingSpotStatisticsCountDTO> spotCheckList = this.spotCheckQhseService.findSpotCheckList(projectId, projectName, userName);
      if (CollectionUtils.isEmpty(spotCheckList)) {
         return new ArrayList<>();
      }

      List<Long> projectIds = spotCheckList.stream().map(MesBuildingSpotStatisticsCountDTO::getId).collect(Collectors.toList());
      Map<Long, List<MesBuildingSpotStatisticsCountDTO>> monomerProjectSpotStatisticsCountDTOMap = this.spotCheckQhseService
         .findMonomerSpotCheckList(projectIds, userName)
         .stream()
         .collect(Collectors.groupingBy(MesBuildingSpotStatisticsCountDTO::getProjectId));
      List<MesBuildingTask> completes = this.taskService
         .list(
            (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
               .in(MesBuildingTask::getProjectId, spotCheckList.stream().map(MesBuildingSpotStatisticsCountDTO::getId).collect(Collectors.toList()))
         );
      Map<Long, List<MesBuildingTask>> completeProjectMap = completes.stream().collect(Collectors.groupingBy(MesBuildingTask::getProjectId));
      Map<Long, List<MesBuildingTask>> completemonomerMap = completes.stream().collect(Collectors.groupingBy(MesBuildingTask::getMonomerId));

      for (MesBuildingSpotStatisticsCountDTO countDTO : spotCheckList) {
         int sum = completeProjectMap.get(countDTO.getId()).stream().mapToInt(MesBuildingTask::getTaskQuantity).sum();
         countDTO.setTotalCompanyQuantity(sum);
         countDTO.setSamplingRate(
            BigDecimal.valueOf(countDTO.getQualifiedQuantity() + countDTO.getUnQualifiedQuantity())
               .multiply(BigDecimal.valueOf(100L))
               .divide(BigDecimal.valueOf(sum), 2, 4)
         );
         countDTO.setSamplingPassRate(
            BigDecimal.valueOf(countDTO.getQualifiedQuantity().intValue()).multiply(BigDecimal.valueOf(100L)).divide(BigDecimal.valueOf(sum), 2, 4)
         );
         countDTO.setUnSamplingPassRate(
            BigDecimal.valueOf(countDTO.getUnQualifiedQuantity().intValue()).multiply(BigDecimal.valueOf(100L)).divide(BigDecimal.valueOf(sum), 2, 4)
         );
         List<MesBuildingSpotStatisticsCountDTO> monomerCoutDTOS = monomerProjectSpotStatisticsCountDTOMap.get(countDTO.getId());
         if (CollectionUtils.isNotEmpty(monomerCoutDTOS)) {
            for (MesBuildingSpotStatisticsCountDTO monomerCoutDTO : monomerCoutDTOS) {
               int monomerSum = completemonomerMap.get(monomerCoutDTO.getId()).stream().mapToInt(MesBuildingTask::getTaskQuantity).sum();
               monomerCoutDTO.setTotalCompanyQuantity(monomerSum);
               monomerCoutDTO.setSamplingRate(
                  BigDecimal.valueOf(monomerCoutDTO.getQualifiedQuantity() + monomerCoutDTO.getUnQualifiedQuantity())
                     .multiply(BigDecimal.valueOf(100L))
                     .divide(BigDecimal.valueOf(monomerSum), 2, 4)
               );
               monomerCoutDTO.setSamplingPassRate(
                  BigDecimal.valueOf(monomerCoutDTO.getQualifiedQuantity().intValue())
                     .multiply(BigDecimal.valueOf(100L))
                     .divide(BigDecimal.valueOf(monomerSum), 2, 4)
               );
               monomerCoutDTO.setUnSamplingPassRate(
                  BigDecimal.valueOf(monomerCoutDTO.getUnQualifiedQuantity().intValue())
                     .multiply(BigDecimal.valueOf(100L))
                     .divide(BigDecimal.valueOf(monomerSum), 2, 4)
               );
            }
         }

         countDTO.setMonomerSpotStatisticsCountDTOS(monomerCoutDTOS);
      }

      return spotCheckList;
   }

   @Override
   public PageVO findSpotCheckDetailListPage(
      Long projectId,
      Long monomerId,
      String userName,
      String monomerName,
      String name,
      String serialNumber,
      String specification,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.findSpotCheckDetailList(projectId, monomerId, userName, monomerName, name, serialNumber, specification)
      );
   }

   @Override
   public List<MesBuildingSpotStatisticsCountDetailDTO> findSpotCheckDetailList(
      Long projectId, Long monomerId, String userName, String monomerName, String name, String serialNumber, String specification
   ) {
      return this.spotCheckQhseService.findSpotCheckDetailList(projectId, monomerId, userName, monomerName, name, serialNumber, specification);
   }

   @Override
   public void printFindSpotCheckList(Long projectId, String projectName, String userName, HttpServletResponse response) {
      List<Map<String, Object>> typeList = new ArrayList<>();
      Map<String, Object> exportMap = new HashMap<>();
      List<MesBuildingSpotStatisticsCountDTO> spotCheckList = this.findSpotCheckList(projectId, projectName, userName);
      AtomicInteger orderNumber = new AtomicInteger(1);
      AtomicInteger index = new AtomicInteger(1);
      List<Integer> indexList = new ArrayList<>();
      List<Integer> monomerIndexList = new ArrayList<>();
      List<MesBuildingSpotStatisticsCountDowloadDTO> typesettingExportDOS = new ArrayList<>();

      for (MesBuildingSpotStatisticsCountDTO countDTO : spotCheckList) {
         index.getAndIncrement();
         MesBuildingSpotStatisticsCountDowloadDTO build = MesBuildingSpotStatisticsCountDowloadDTO.builder()
            .orderNumber(String.valueOf(orderNumber.getAndIncrement()))
            .name(countDTO.getName())
            .spotCheckUserNames(countDTO.getSpotCheckUserNames())
            .qualifiedQuantity(countDTO.getQualifiedQuantity())
            .samplingPassRate(countDTO.getSamplingPassRate())
            .unQualifiedQuantity(countDTO.getUnQualifiedQuantity())
            .unSamplingPassRate(countDTO.getUnSamplingPassRate())
            .totalCompanyQuantity(countDTO.getTotalCompanyQuantity())
            .samplingRate(countDTO.getSamplingRate())
            .build();
         typesettingExportDOS.add(build);
         indexList.add(index.get());
         List<MesBuildingSpotStatisticsCountDTO> monomerSpotStatisticsCountDTOS = countDTO.getMonomerSpotStatisticsCountDTOS();
         if (CollectionUtils.isNotEmpty(monomerSpotStatisticsCountDTOS)) {
            for (MesBuildingSpotStatisticsCountDTO monomerSpotStatisticsCountDTO : monomerSpotStatisticsCountDTOS) {
               index.getAndIncrement();
               MesBuildingSpotStatisticsCountDowloadDTO monomerBuild = MesBuildingSpotStatisticsCountDowloadDTO.builder()
                  .orderNumber(String.valueOf(orderNumber.getAndIncrement()))
                  .name(monomerSpotStatisticsCountDTO.getName())
                  .spotCheckUserNames(monomerSpotStatisticsCountDTO.getSpotCheckUserNames())
                  .qualifiedQuantity(monomerSpotStatisticsCountDTO.getQualifiedQuantity())
                  .samplingPassRate(monomerSpotStatisticsCountDTO.getSamplingPassRate())
                  .unQualifiedQuantity(monomerSpotStatisticsCountDTO.getUnQualifiedQuantity())
                  .unSamplingPassRate(monomerSpotStatisticsCountDTO.getUnSamplingPassRate())
                  .totalCompanyQuantity(monomerSpotStatisticsCountDTO.getTotalCompanyQuantity())
                  .samplingRate(monomerSpotStatisticsCountDTO.getSamplingRate())
                  .build();
               typesettingExportDOS.add(monomerBuild);
               monomerIndexList.add(index.get());
            }
         }
      }

      for (MesBuildingSpotStatisticsCountDowloadDTO typesettingDO : typesettingExportDOS) {
         Map<String, Object> typesettingMap = BeanUtil.beanToMap(typesettingDO);
         typeList.add(typesettingMap);
      }

      exportMap.put("typeList", typeList);

      try {
         String tempFileName = "FindSpotCheckList";
         String resourcePath = "files/FindSpotCheckList.xlsx";
         String exportFileName = "抽检统计.xlsx";
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
         Sheet sheetAt = workbook.getSheetAt(0);

         for (Integer indexNum : indexList) {
            for (Cell cell : sheetAt.getRow(indexNum)) {
               Font font = workbook.createFont();
               font.setFontName("宋体");
               font.setFontHeightInPoints((short)12);
               font.setBold(true);
               CellStyle cellStyle = workbook.createCellStyle();
               cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
               cellStyle.setAlignment(HorizontalAlignment.CENTER);
               cellStyle.setBorderBottom(BorderStyle.THIN);
               cellStyle.setBorderTop(BorderStyle.THIN);
               cellStyle.setBorderLeft(BorderStyle.THIN);
               cellStyle.setBorderRight(BorderStyle.THIN);
               cellStyle.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
               cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
               cell.setCellStyle(cellStyle);
               cellStyle.setFont(font);
            }
         }

         if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(monomerIndexList)) {
            for (Integer indexNum : monomerIndexList) {
               for (Cell cell : sheetAt.getRow(indexNum)) {
                  Font font = workbook.createFont();
                  font.setFontName("宋体");
                  font.setFontHeightInPoints((short)12);
                  font.setBold(false);
                  CellStyle cellStyle = workbook.createCellStyle();
                  cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                  cellStyle.setAlignment(HorizontalAlignment.CENTER);
                  cellStyle.setBorderBottom(BorderStyle.THIN);
                  cellStyle.setBorderTop(BorderStyle.THIN);
                  cellStyle.setBorderLeft(BorderStyle.THIN);
                  cellStyle.setBorderRight(BorderStyle.THIN);
                  cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                  cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                  cell.setCellStyle(cellStyle);
                  cellStyle.setFont(font);
               }
            }
         }

         PoiUtils.downNoBuildCellLoadExcel(exportFileName, response, workbook);
      } catch (IOException e) {
         throw new BusinessException(ResultCodeEnum.ERROR, e.getMessage());
      }
   }

   @Override
   public void printFindSpotCheckDetailList(
      Long projectId, Long monomerId, String userName, String monomerName, String name, String serialNumber, String specification, HttpServletResponse response
   ) {
      List<MesBuildingSpotStatisticsCountDetailDTO> spotCheckDetailList = this.findSpotCheckDetailList(
         projectId, monomerId, userName, monomerName, name, serialNumber, specification
      );
      if (CollectionUtils.isNotEmpty(spotCheckDetailList)) {
         String title = "抽检详情";
         String sheetName = "抽检详情";
         String fileName = "抽检详情.xlsx";
         AtomicInteger orderNo = new AtomicInteger(1);
         List<MesBuildingSpotStatisticsDetailDowloadDTO> detailDowloadDTOS = spotCheckDetailList.stream().map(e -> {
            MesBuildingSpotStatisticsDetailDowloadDTO copy = BeanUtil.copy(e, MesBuildingSpotStatisticsDetailDowloadDTO.class);
            copy.setProjectName(e.getProject().getShortName());
            copy.setMonomerName(e.getMonomer().getName());
            copy.setOrderNumber(orderNo.getAndIncrement());
            return copy;
         }).collect(Collectors.toList());
         PoiUtils.exportExcel(detailDowloadDTOS, title, sheetName, MesBuildingSpotStatisticsDetailDowloadDTO.class, fileName, ExcelType.XSSF, response);
      }
   }

   @Override
   public Boolean qhseSafetyEnvironmentDownload(Long id, HttpServletResponse response) {
      Map<String, Object> result = new HashMap<>();
      MesBuildingQhseDTO qhse = this.getQhseById(id, null, null);
      String typeName = QhseTypeEnum.getNameByType(qhse.getType());
      List<AttachmentDTO> qhseImageList = qhse.getAttachmentDTOS();
      List<Map<String, ImageEntity>> rowList = this.getImageRowList(qhseImageList, 3);
      MesBuildingQhseRectifyDTO qhseRectifyDTO = null;
      List<Map<String, ImageEntity>> qhseRectifyDTOList = new ArrayList<>();
      String afterRemark = "";
      if (CollectionUtils.isNotEmpty(qhse.getQhseRectifyDTOS())) {
         qhseRectifyDTO = qhse.getQhseRectifyDTOS().get(0);
         List<AttachmentDTO> qhseRectifyImageList = qhseRectifyDTO.getAttachmentDTOS();
         qhseRectifyDTOList = this.getImageRowList(qhseRectifyImageList, 3);
         afterRemark = qhseRectifyDTO.getRemark();
      }

      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      result.put("qhseNumber", qhse.getQhseNumber());
      result.put("date", dateTimeFormatter.format(qhse.getCreateTime()));
      result.put("dutyName", qhse.getDutyName());
      result.put("userName", qhse.getUserName());
      result.put("levelOneName", qhse.getLevelOneName());
      result.put("levelTwoName", qhse.getLevelTwoName());
      result.put("behaviorScore", qhse.getBehaviorScore());
      result.put("penalty", qhse.getPenalty());
      result.put("typeName", typeName);
      result.put("statusName", QhseStatusEnum.getNameByType(qhse.getStatus()));
      result.put("remark", qhse.getRemark());
      result.put("afterRemark", afterRemark);
      result.put("rowList", rowList);
      result.put("qhseRectifyDTOList", qhseRectifyDTOList);
      String tempFileName = "QhseSafetyEnvironment";
      String resourcePath = "files/QhseSafetyEnvironment.xlsx";
      String exportFileName = "安环问题报告.xlsx";
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, result);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }

   @Override
   public Boolean qhseProblemStatisticsDownload(Long id, HttpServletResponse response) {
      Map<String, Object> result = new HashMap<>();
      MesBuildingQhseDTO qhse = this.getQhseById(id, null, null);
      String typeName = QhseTypeEnum.getNameByType(qhse.getType());
      List<AttachmentDTO> qhseImageList = qhse.getAttachmentDTOS();
      List<Map<String, ImageEntity>> rowList = this.getImageRowList(qhseImageList, 3);
      MesBuildingQhseRectifyDTO qhseRectifyDTO = null;
      List<Map<String, ImageEntity>> qhseRectifyDTOList = new ArrayList<>();
      String afterRemark = "";
      if (CollectionUtils.isNotEmpty(qhse.getQhseRectifyDTOS())) {
         qhseRectifyDTO = qhse.getQhseRectifyDTOS().get(0);
         List<AttachmentDTO> qhseRectifyImageList = qhseRectifyDTO.getAttachmentDTOS();
         qhseRectifyDTOList = this.getImageRowList(qhseRectifyImageList, 3);
         afterRemark = qhseRectifyDTO.getRemark();
      }

      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      ContractProject project = this.projectService.getById(qhse.getProjectId());
      result.put("projectName", project.getName() + "-" + project.getSerialNumber());
      result.put("qhseNumber", qhse.getQhseNumber());
      result.put("date", dateTimeFormatter.format(qhse.getCreateTime()));
      result.put("dutyName", qhse.getDutyName());
      result.put("userName", qhse.getUserName());
      result.put("levelOneName", qhse.getLevelOneName());
      result.put("levelTwoName", qhse.getLevelTwoName());
      result.put("behaviorScore", qhse.getBehaviorScore());
      result.put("penalty", qhse.getPenalty());
      result.put("typeName", typeName);
      result.put("statusName", QhseStatusEnum.getNameByType(qhse.getStatus()));
      result.put("remark", qhse.getRemark());
      result.put("afterRemark", afterRemark);
      result.put("rowList", rowList);
      result.put("qhseRectifyDTOList", qhseRectifyDTOList);
      result.put("processName", qhse.getProcessName());
      result.put("serialNumber", qhse.getSerialNumber());
      result.put("specification", qhse.getSpecification());
      result.put("workshopName", qhse.getWorkshopName());
      String tempFileName = "QhseProblemStatistics";
      String resourcePath = "files/QhseProblemStatistics.xlsx";
      String exportFileName = "质检问题报告.xlsx";
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;

      try {
         inputStream = resource.getInputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      File file = null;

      try {
         file = File.createTempFile(tempFileName, "xlsx");
      } catch (IOException e) {
         e.printStackTrace();
      }

      FileUtil.copyInputStreamToFile(inputStream, file);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, result);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }
}
