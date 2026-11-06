package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.aliyun.oss.OSS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.FunctionTypeEnum;
import com.hzchum.scim.common.core.api.enums.ModuleTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.biz.NestBiz;
import com.hzchum.scim.cut.core.api.service.NestCutPlateService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingCutConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingTeamBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkMonthBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlatePartBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingMachinePartSchedulingArtifactTaskLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.MachinePartSchedulingIssueStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.MachinePartSchedulingTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingCutConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLinkMonth;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingNestCutMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingCutConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingDrillQuantitySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingMachinePartSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingMachinePartSchedulingLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingMachinePartSchedulingProjectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingMachinePartSchedulingSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNeedMachinePartSchedulingLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingParNeedSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingTaskNeedMachinePartSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.OffLineSchedulingFileDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.PartDistributionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProjectMomentDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.PicturePathDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.get.PdfUtilDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingLinkDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingPartCheckDrillDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderMachinePartDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkMonthService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlateService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSchedulingArtifactTaskLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSeparateService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingNestCutMachinePartSeparateService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.api.utils.PdfUtil;
import com.hzchum.scim.mes.building.core.biz.impl.utils.ZIPUtils;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingMachinePartSchedulingMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.MonomerTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectTreeResponseVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.util.OssUtils;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingMachinePartSchedulingBizImpl
   extends IBizImpl<MesBuildingMachinePartSchedulingService, MesBuildingMachinePartSchedulingMapper, MesBuildingMachinePartScheduling>
   implements MesBuildingMachinePartSchedulingBiz {
   @Value("${endpoint}")
   private String endpoint;
   @Value("${accessKeyId}")
   private String accessKeyId;
   @Value("${accessKeySecret}")
   private String accessKeySecret;
   @Value("${bucketName}")
   private String bucketName;
   @Value("${chum.config.url}")
   private String ip;
   @Autowired
   ContractProjectService projectService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   MesBuildingMachinePartSchedulingLinkBiz linkBiz;
   @Autowired
   private OssUtils ossUtils;
   @Autowired
   TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Autowired
   TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Autowired
   TechMachinePartService machinePartService;
   @Autowired
   private TechArtifactService artifactService;
   @Resource
   private MesBuildingTaskBiz mesBuildingTaskBiz;
   @Resource
   private MesBuildingTaskOrderService taskOrderService;
   @Autowired
   private NestCutPlateService nestCutPlateService;
   @Autowired
   private MesBuildingCutConfigBiz cutConfigBiz;
   @Autowired
   private MesBuildingNestCutPlateBiz nestCutPlateBiz;
   @Autowired
   private MesBuildingNestCutPlatePartBiz nestCutPlatePartBiz;
   @Autowired
   private MesBuildingNestCutPlatePartService nestCutPlatePartService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private TechDrawingService techDrawingService;
   @Resource
   private MesBuildingGroupsBiz groupsBiz;
   @Resource
   private MesBuildingProductionLineService productionLineService;
   @Resource
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingBiz taskNeedMachinePartSchedulingBiz;
   @Resource
   private MesBuildingMachinePartSchedulingLinkMonthBiz linkMonthBiz;
   @Resource
   private MesBuildingMachinePartSchedulingArtifactTaskLinkBiz machinePartSchedulingArtifactTaskLinkBiz;
   @Resource
   private MesBuildingMachinePartSchedulingLinkBiz mesBuildingMachinePartSchedulingLinkBiz;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private ConfigService configService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private MesBuildingProcessService processService;
   @Resource
   private MesBuildingGroupsTeamLinkBiz groupsTeamLinkBiz;
   @Resource
   private MesBuildingTeamBiz teamBiz;
   @Resource
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Resource
   private TechDrawingService drawingService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private WarehouseBiz warehouseBiz;
   @Resource
   private MesBuildingProductionLineService lineService;
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Resource
   private MesBuildingMachinePartSchedulingLinkMonthService linkMonthService;
   @Resource
   private MesBuildingTeamService mesBuildingTeamService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Resource
   private MesBuildingNestCutMachinePartSeparateService nestCutMachinePartSeparateService;
   @Resource
   private MesBuildingMachinePartSeparateService mesBuildingMachinePartSeparateService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingMachinePartSchedulingService machinePartSchedulingService;
   @Resource
   private MesBuildingNestCutPlateService mesBuildingNestCutPlateService;
   @Resource
   private MesBuildingNestCutPlatePartService mesBuildingNestCutPlatePartService;
   @Resource
   private MesBuildingMachinePartSchedulingLinkService machinePartSchedulingLinkService;
   @Resource
   private MesBuildingMachinePartSchedulingArtifactTaskLinkService mesBuildingMachinePartSchedulingArtifactTaskLinkService;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingService needMachinePartSchedulingService;
   @Resource
   private MesBuildingBoChuNestingResultService mesBuildingBoChuNestingResultService;
   @Resource
   private NestBiz nestBiz;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;

   @Override
   public List<MesBuildingMachinePartSchedulingDTO> getMachinePartList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      String material,
      String thick,
      List<String> thickList,
      String serialNumber,
      BigDecimal minLength,
      BigDecimal maxLength,
      Integer taskTypeEnum,
      Boolean boolDxfEnum,
      Boolean boolPriceEnum,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   ) {
      Preconditions.checkArgument(monthList != null && monthList.size() > 0, "操作失败！请输入日期");
      StringBuilder month = new StringBuilder();

      for (LocalDateTime e : monthList) {
         if (month.toString().length() != 0) {
            month.append(",");
         }

         month.append("'" + e.format(DateTimeFormatter.ofPattern("yyyy-MM")) + "'");
      }

      Map<Long, List<MesBuildingTaskNeedMachinePartScheduling>> needMachinePartLinkMap = this.taskNeedMachinePartSchedulingBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartScheduling.class)
               .apply("need_quantity>scheduling_quantity")
               .apply("date_format(ask_complete_time, '%Y-%m') in (" + month + ")")
               .in(workshopIds != null && workshopIds.size() > 0, MesBuildingTaskNeedMachinePartScheduling::getWorkshopId, workshopIds)
               .in(productionLineIds != null && productionLineIds.size() > 0, MesBuildingTaskNeedMachinePartScheduling::getProductionLineId, productionLineIds)
               .in(groupsIds != null && groupsIds.size() > 0, MesBuildingTaskNeedMachinePartScheduling::getGroupsId, groupsIds)
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTaskNeedMachinePartScheduling::getProductId));
      if (needMachinePartLinkMap.size() == 0) {
         return new ArrayList<>();
      }

      List<TechMachinePart> machineParts = this.machinePartService
         .list(
            Wrappers.lambdaQuery(TechMachinePart.builder().build())
               .in(projectIds != null, TechMachinePart::getProjectId, projectIds)
               .in(monomerIds != null, TechMachinePart::getMonomerId, monomerIds)
               .in(areaIds != null, TechMachinePart::getAreaId, areaIds)
               .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
               .eq(material != null, TechMachinePart::getMaterial, material)
               .isNull("其他".equals(thick), TechMachinePart::getThick)
               .eq(thick != null && !"其他".equals(thick), TechMachinePart::getThick, thick)
               .in(thickList != null && thickList.size() > 0, TechMachinePart::getThick, thickList)
               .like(serialNumber != null, TechMachinePart::getSerialNumber, serialNumber)
               .le(maxLength != null, TechMachinePart::getLength, maxLength)
               .ge(minLength != null, TechMachinePart::getLength, minLength)
               .in(TechMachinePart::getId, needMachinePartLinkMap.keySet())
               .ne(TechMachinePart::getRelationType, 18)
               .and(
                  taskTypeEnum != null,
                  s -> {
                     LambdaQueryWrapper var10000 = s.eq(
                           taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType()), TechMachinePart::getRelationType, ProductTypeEnum.ARTIFACT.getType()
                        )
                        .or()
                        .eq(taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType()), TechMachinePart::getRelationType, ProductTypeEnum.ASSEMBLE.getType());
                  }
               )
               .orderByAsc(TechMachinePart::getThick)
         );
      Map<Long, String> pictureMap = new HashMap<>();
      Map<Long, ContractProject> projectMap = new HashMap<>();
      if (boolPriceEnum) {
         List<Long> machinePartIds = machineParts.stream().map(TechMachinePart::getId).collect(Collectors.toList());

         for (PicturePathDTO picturePathDTO : (List<PicturePathDTO>)this.techDrawingService.selectMachDrawing(machinePartIds)) {
            pictureMap.put(picturePathDTO.getProductId(), picturePathDTO.getPicturePath());
         }

         if (machineParts.size() > 0) {
            this.projectService.listByIds(machineParts.stream().map(TechMachinePart::getProjectId).distinct().collect(Collectors.toList())).forEach(e -> {
               ContractProject var10000 = projectMap.put(e.getId(), e);
            });
         }
      }

      List<MesBuildingMachinePartSchedulingDTO> dtoList = machineParts.stream()
         .map(
            e -> {
               MesBuildingMachinePartSchedulingDTO dto = BeanUtil.copy(e, MesBuildingMachinePartSchedulingDTO.class);
               dto.setQuantity(needMachinePartLinkMap.get(e.getId()).stream().mapToInt(need -> need.getNeedQuantity() - need.getSchedulingQuantity()).sum());
               dto.setNeedMachinePartLinkList(
                  needMachinePartLinkMap.get(e.getId())
                     .stream()
                     .map(
                        needLink -> MesBuildingNeedMachinePartSchedulingLinkDTO.builder()
                           .id(needLink.getId())
                           .taskId(needLink.getTaskId())
                           .workshopId(needLink.getWorkshopId())
                           .productionLineId(needLink.getProductionLineId())
                           .groupsId(needLink.getGroupsId())
                           .quantity(needLink.getNeedQuantity() - needLink.getSchedulingQuantity())
                           .month(needLink.getAskCompleteTime().format(DateTimeFormatter.ofPattern("yyyy-MM")))
                           .build()
                     )
                     .collect(Collectors.toList())
               );
               if (boolPriceEnum) {
                  dto.setPicturePath(pictureMap.get(dto.getId()) == null ? null : this.ip + "files/" + pictureMap.get(dto.getId()));
                  dto.setProject(
                     ProjectDetailDO.builder()
                        .id(e.getProjectId())
                        .name(projectMap.get(e.getProjectId()).getName())
                        .shortName(projectMap.get(e.getProjectId()).getShortName())
                        .serialNumber(projectMap.get(e.getProjectId()).getSerialNumber())
                        .build()
                  );
               }

               return dto;
            }
         )
         .filter(e -> e.getQuantity() != 0)
         .collect(Collectors.toList());
      if (boolDxfEnum == null) {
         return dtoList;
      } else {
         return boolDxfEnum
            ? dtoList.stream().filter(e -> e.getPicturePath() != null).collect(Collectors.toList())
            : dtoList.stream().filter(e -> e.getPicturePath() == null).collect(Collectors.toList());
      }
   }

   @Override
   public MesBuildingMachinePartSchedulingSummaryDTO getMachinePartListAndSummary(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      String material,
      String thick,
      List<String> thickList,
      String serialNumber,
      BigDecimal minLength,
      BigDecimal maxLength,
      Integer taskTypeEnum,
      Boolean boolDxfEnum,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   ) {
      List<MesBuildingMachinePartSchedulingDTO> dtoList = this.getMachinePartList(
         projectIds,
         monomerIds,
         areaIds,
         monthList,
         dateTime,
         material,
         thick,
         thickList,
         serialNumber,
         minLength,
         maxLength,
         taskTypeEnum,
         boolDxfEnum,
         true,
         workshopIds,
         productionLineIds,
         groupsIds
      );
      if (CollectionUtils.isEmpty(dtoList)) {
         return null;
      }

      List<LocalDateTime> dateTimeList = new ArrayList<>();

      for (MesBuildingMachinePartSchedulingDTO dto : dtoList) {
         List<Long> taskIds = dto.getNeedMachinePartLinkList()
            .stream()
            .map(MesBuildingNeedMachinePartSchedulingLinkDTO::getTaskId)
            .distinct()
            .collect(Collectors.toList());
         dateTimeList.addAll(
            this.mesBuildingTaskBiz.listByIds(taskIds).stream().map(MesBuildingTask::getAskCompleteTime).distinct().collect(Collectors.toList())
         );
      }

      LocalDateTime maxDate = Collections.max(dateTimeList);
      LocalDateTime minDate = Collections.min(dateTimeList);
      return MesBuildingMachinePartSchedulingSummaryDTO.builder()
         .collect(dtoList)
         .quantity(dtoList.stream().mapToInt(MesBuildingMachinePartSchedulingDTO::getQuantity).sum())
         .totalNetWeight(dtoList.stream().map(e -> e.getNetWeight().multiply(new BigDecimal(e.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add))
         .maxDate(maxDate)
         .minDate(minDate)
         .build();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Long saveMachinePartNestCut(MesBuildingMachinePartSchedulingDTOParam dtoParam) {
      Map<Long, List<MesBuildingMachinePartSchedulingLinkDTOParam>> group = dtoParam.getLinkList()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId));
      Map<Long, Integer> machinePartQuantityMap = new HashMap<>();
      group.forEach(
         (productId, list) -> machinePartQuantityMap.put(productId, list.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
      );
      List<Long> allPartIds = dtoParam.getLinkList()
         .stream()
         .map(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId)
         .distinct()
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(allPartIds)) {
         this.mesBuildingTaskBiz.checkProductStatus(allPartIds, TaskTypeEnum.MACHINE_PART.getType());
      }

      List<TechMachinePart> blockList = this.machinePartService
         .listByIds(machinePartQuantityMap.keySet())
         .stream()
         .filter(s -> s.getProjectId() == 0L)
         .collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(blockList)) {
         Preconditions.checkArgument(!dtoParam.getBoolOffLine(), "线下套料不可选择垫片");
         blockList.forEach(e -> {
            if (e.getQuantity() == null) {
               e.setQuantity(0);
            }

            if (e.getQuantity() == 0) {
               e.setQuantity(machinePartQuantityMap.get(e.getId()));
            } else {
               e.setQuantity(e.getQuantity() + machinePartQuantityMap.get(e.getId()));
            }

            this.machinePartService.updateById(e);
         });
      }

      Long schedulingId = 0L;
      if (dtoParam.getSaveType().equals(1) || dtoParam.getSaveType().equals(2)) {
         schedulingId = this.saveNewMachinePartNestCut(dtoParam);
      }

      if (dtoParam.getSaveType().equals(4)) {
         Preconditions.checkArgument(!dtoParam.getBoolOffLine(), "追加工单,不可选取线下套料类型");
         this.updateMachinePartNestCut(dtoParam);
         schedulingId = dtoParam.getSchedulingId();
      }

      return schedulingId;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveMachinePartNestCutTask(MesBuildingMachinePartSchedulingDTOParam dtoParam) {
      MesBuildingMachinePartScheduling scheduling = this.getById(dtoParam.getSchedulingId());
      Preconditions.checkArgument(scheduling != null, "操作失败:数据有误");
      scheduling.setIssueStatusEnum(MachinePartSchedulingIssueStatusEnum.HAS_BEEN_ISSUED.getType());
      this.updateById(scheduling);
      List<MesBuildingTaskOrderMachinePartDetailDTOParam> taskOrderParamList = new ArrayList<>();
      this.nestCutPlateBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
               .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, scheduling.getId())
               .eq(MesBuildingNestCutPlate::getBoolIssueEnum, Boolean.FALSE)
         )
         .forEach(
            e -> taskOrderParamList.add(
               MesBuildingTaskOrderMachinePartDetailDTOParam.builder()
                  .groupsId(dtoParam.getGroupsId())
                  .id(e.getId())
                  .askCompleteTime(scheduling.getAskCompleteTime())
                  .drillGroupsId(dtoParam.getDrillGroupsId())
                  .drillAskCompleteTime(dtoParam.getDrillAskCompleteTime())
                  .build()
            )
         );
      Preconditions.checkArgument(taskOrderParamList.size() > 0, "操作失败！数据有误");
      this.taskOrderBiz.saveArtifactTaskOrder(MesBuildingTaskOrderDTOParam.builder().machinePartDetailList(taskOrderParamList).build(), dtoParam);
      return Boolean.TRUE;
   }

   @Override
   public MesBuildingDrillQuantitySummaryDTO chenkDrill(List<MesBuildingPartCheckDrillDTOParam> partList, Long schedulingId, Long cutConfigId, String thick) {
      List<MesBuildingMachinePartTeamDetail> mesBuildingMachinePartTeamDetailList = this.mesBuildingMachinePartTeamDetailService
         .list(
            (Wrapper<MesBuildingMachinePartTeamDetail>)new LambdaQueryWrapper<MesBuildingMachinePartTeamDetail>()
               .eq(MesBuildingMachinePartTeamDetail::getProcessType, ProcessTypeEnum.DRILL_HOLE.getType())
         );
      if (mesBuildingMachinePartTeamDetailList.size() == 0) {
         return MesBuildingDrillQuantitySummaryDTO.builder().boolDrillEnum(Boolean.FALSE).build();
      } else if (partList != null && partList.size() > 0) {
         Map<Long, Integer> drillMap = this.cutConfigBiz
            .getBoolDrillHolePartIdMap(partList.stream().map(MesBuildingPartCheckDrillDTOParam::getId).collect(Collectors.toList()), cutConfigId, thick);
         return drillMap.size() > 0
            ? MesBuildingDrillQuantitySummaryDTO.builder()
               .boolDrillEnum(Boolean.TRUE)
               .quantity(partList.stream().filter(e -> drillMap.containsKey(e.getId())).mapToInt(MesBuildingPartCheckDrillDTOParam::getQuantity).sum())
               .drillQuantity(partList.stream().filter(e -> drillMap.containsKey(e.getId())).mapToInt(e -> e.getQuantity() * drillMap.get(e.getId())).sum())
               .build()
            : MesBuildingDrillQuantitySummaryDTO.builder().boolDrillEnum(Boolean.FALSE).build();
      } else if (schedulingId != null) {
         MesBuildingMachinePartScheduling scheduling = this.getById(schedulingId);
         Preconditions.checkArgument(scheduling != null, "操作失败：不存在的排产id");
         List<MesBuildingMachinePartSchedulingLink> linkList = this.linkBiz
            .list(Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class).eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, schedulingId));
         Map<Long, Integer> drillMap = this.cutConfigBiz
            .getBoolDrillHolePartIdMap(
               linkList.stream().map(MesBuildingMachinePartSchedulingLink::getProductId).collect(Collectors.toList()), cutConfigId, thick
            );
         return drillMap.size() > 0
            ? MesBuildingDrillQuantitySummaryDTO.builder()
               .boolDrillEnum(Boolean.TRUE)
               .quantity(
                  linkList.stream().filter(e -> drillMap.containsKey(e.getProductId())).mapToInt(MesBuildingMachinePartSchedulingLink::getQuantity).sum()
               )
               .drillQuantity(
                  linkList.stream().filter(e -> drillMap.containsKey(e.getProductId())).mapToInt(e -> e.getQuantity() * drillMap.get(e.getProductId())).sum()
               )
               .build()
            : MesBuildingDrillQuantitySummaryDTO.builder().boolDrillEnum(Boolean.FALSE).build();
      } else {
         return MesBuildingDrillQuantitySummaryDTO.builder().boolDrillEnum(Boolean.FALSE).build();
      }
   }

   @Override
   public MesBuildingDrillQuantitySummaryDTO chenkDrillV2(
      List<MesBuildingPartCheckDrillDTOParam> partList, Long schedulingId, Long cutConfigId, List<String> thickList
   ) {
      Preconditions.checkArgument(CollUtil.isNotEmpty(thickList), "厚度不能为空");
      Map<String, List<MesBuildingPartCheckDrillDTOParam>> partGroup = Optional.ofNullable(partList)
         .filter(CollUtil::isNotEmpty)
         .map(m -> m.stream().collect(Collectors.groupingBy(MesBuildingPartCheckDrillDTOParam::getThick)))
         .orElseGet(Collections::emptyMap);
      List<MesBuildingDrillQuantitySummaryDTO> dtoList = thickList.stream()
         .map(thick -> this.chenkDrill(partGroup.get(thick), schedulingId, cutConfigId, thick))
         .collect(Collectors.toList());
      Boolean boolDrillEnum = dtoList.stream().anyMatch(MesBuildingDrillQuantitySummaryDTO::getBoolDrillEnum);
      Boolean boolAllMatched = dtoList.stream().allMatch(MesBuildingDrillQuantitySummaryDTO::getBoolDrillEnum);
      Integer quantity = dtoList.stream().map(MesBuildingDrillQuantitySummaryDTO::getQuantity).filter(ObjectUtil::isNotNull).reduce(Integer::sum).orElse(null);
      Integer drillQuantity = dtoList.stream()
         .map(MesBuildingDrillQuantitySummaryDTO::getDrillQuantity)
         .filter(ObjectUtil::isNotNull)
         .reduce(Integer::sum)
         .orElse(null);
      return MesBuildingDrillQuantitySummaryDTO.builder()
         .boolDrillEnum(boolDrillEnum)
         .quantity(quantity)
         .drillQuantity(drillQuantity)
         .boolAllMatched(boolAllMatched)
         .build();
   }

   @Transactional(rollbackFor = Exception.class)
   public synchronized Long saveNewMachinePartNestCut(MesBuildingMachinePartSchedulingDTOParam dtoParam) {
      Map<Long, BigDecimal> netWeightMap = new HashMap<>();
      AtomicReference<BigDecimal> totalNetWeight = new AtomicReference<>(BigDecimal.ZERO);
      this.machinePartService
         .listByIds(dtoParam.getLinkList().stream().map(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId).collect(Collectors.toList()))
         .forEach(e -> {
            BigDecimal var10000 = netWeightMap.put(e.getId(), e.getNetWeight());
         });
      int cun = this.baseService.passDeleteCount(LocalDateTime.now()) + 1;
      MesBuildingMachinePartScheduling scheduling = MesBuildingMachinePartScheduling.builder()
         .issueStatusEnum(MachinePartSchedulingIssueStatusEnum.NOT_NESTING.getType())
         .material(dtoParam.getMaterial())
         .thick(dtoParam.getThick())
         .userId(UserUtil.getCurrentUserId())
         .orderNumber(
            "L-"
               + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
               + "-"
               + LocalDateTime.now().getHour()
               + "-"
               + LocalDateTime.now().getMinute()
               + "-"
               + cun
         )
         .taskStatusEnum(dtoParam.getBoolOffLine() ? 4 : 1)
         .boolOffLine(dtoParam.getBoolOffLine())
         .status(Boolean.TRUE)
         .quantity(dtoParam.getLinkList().stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
         .build();
      this.save(scheduling);
      Map<Long, List<MesBuildingMachinePartSchedulingLinkDTOParam>> longListMap = dtoParam.getLinkList()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId));
      longListMap.forEach(
         (productId, list) -> {
            MesBuildingMachinePartSchedulingLink link = MesBuildingMachinePartSchedulingLink.builder()
               .productId(productId)
               .quantity(list.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
               .schedulingId(scheduling.getId())
               .userId(UserUtil.getCurrentUserId())
               .prdRef(scheduling.getOrderNumber() + productId)
               .build();
            this.linkBiz.save(link);
            list.forEach(
               e -> {
                  if (e.getId() != null) {
                     MesBuildingTaskNeedMachinePartScheduling taskNeedMachinePartScheduling = this.taskNeedMachinePartSchedulingBiz.getById(e.getId());
                     Preconditions.checkArgument(
                        taskNeedMachinePartScheduling.getNeedQuantity() > taskNeedMachinePartScheduling.getSchedulingQuantity(), "任务下发失败,不可重复下发"
                     );
                     taskNeedMachinePartScheduling.setSchedulingQuantity(taskNeedMachinePartScheduling.getNeedQuantity());
                     this.taskNeedMachinePartSchedulingBiz.updateById(taskNeedMachinePartScheduling);
                     MesBuildingMachinePartSchedulingArtifactTaskLink artifactTaskLink = MesBuildingMachinePartSchedulingArtifactTaskLink.builder()
                        .schedulingId(scheduling.getId())
                        .needLinkId(e.getId())
                        .taskId(taskNeedMachinePartScheduling.getTaskId())
                        .quantity(e.getQuantity())
                        .schedulingLinkId(link.getId())
                        .build();
                     this.machinePartSchedulingArtifactTaskLinkBiz.save(artifactTaskLink);
                  }
               }
            );
            totalNetWeight.compareAndSet(
               totalNetWeight.get(), totalNetWeight.get().add(netWeightMap.get(productId).multiply(BigDecimal.valueOf(link.getQuantity().intValue())))
            );
         }
      );
      if (dtoParam.getSaveType() == 2) {
         scheduling.setIssueStatusEnum(
            dtoParam.getBoolOffLine()
               ? MachinePartSchedulingIssueStatusEnum.HAS_BEEN_ISSUED.getType()
               : MachinePartSchedulingIssueStatusEnum.IN_NESTING.getType()
         );
         scheduling.setCutConfigId(dtoParam.getCutConfigId());
         scheduling.setNestingTime(LocalDateTime.now());
         scheduling.setOrderNumber("T" + scheduling.getOrderNumber());
         scheduling.setBoolNestCutEnum(Boolean.TRUE);
         scheduling.setAskCompleteTime(dtoParam.getAskCompleteTime());
         scheduling.setTotalNetWeight(totalNetWeight.get());
         this.updateById(scheduling);
         if (!dtoParam.getBoolOffLine()) {
            List<Long> nestCutSchedulingIds = new ArrayList<>();
            nestCutSchedulingIds.add(scheduling.getId());
            ResultVO resultVO = this.nestCutPlateService.uploadJobPart(nestCutSchedulingIds);
            Preconditions.checkArgument("发送成功".equals(resultVO.getData().toString()), "操作失败:下发失败");
         } else {
            Boolean var9 = this.offLineMachineryComplete(scheduling, dtoParam);
         }
      } else {
         Preconditions.checkArgument(!dtoParam.getBoolOffLine(), "无需套料类型,不可进行线下套料");
         scheduling.setIssueStatusEnum(MachinePartSchedulingIssueStatusEnum.IN_NESTING.getType());
         scheduling.setCutConfigId(dtoParam.getCutConfigId());
         scheduling.setNestingTime(LocalDateTime.now());
         scheduling.setBoolNestCutEnum(Boolean.FALSE);
         scheduling.setAskCompleteTime(dtoParam.getAskCompleteTime());
         scheduling.setTotalNetWeight(totalNetWeight.get());
         this.updateById(scheduling);
         MesBuildingNestCutPlate cutPlate = MesBuildingNestCutPlate.builder()
            .machinePartSchedulingId(scheduling.getId())
            .boolNestCutEnum(Boolean.FALSE)
            .cutConfigId(dtoParam.getCutConfigId())
            .boolIssueEnum(Boolean.FALSE)
            .boolProductionEunm(Boolean.FALSE)
            .cutNumber(scheduling.getOrderNumber())
            .material(scheduling.getMaterial())
            .userId(UserUtil.getCurrentUserId())
            .build();
         this.nestCutPlateBiz.save(cutPlate);
         this.linkBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class).eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, scheduling.getId())
            )
            .forEach(
               e -> this.nestCutPlatePartBiz
                  .save(
                     MesBuildingNestCutPlatePart.builder()
                        .mesBuildingNestCutPlateId(cutPlate.getId())
                        .partId(e.getProductId())
                        .quantity(e.getQuantity())
                        .build()
                  )
            );
         List<MesBuildingTaskOrderMachinePartDetailDTOParam> taskOrderParamList = new ArrayList<>();
         taskOrderParamList.add(
            MesBuildingTaskOrderMachinePartDetailDTOParam.builder()
               .groupsId(dtoParam.getGroupsId())
               .id(cutPlate.getId())
               .askCompleteTime(dtoParam.getAskCompleteTime())
               .drillGroupsId(dtoParam.getDrillGroupsId())
               .drillAskCompleteTime(dtoParam.getDrillAskCompleteTime())
               .build()
         );
         this.taskOrderBiz.saveArtifactTaskOrder(MesBuildingTaskOrderDTOParam.builder().machinePartDetailList(taskOrderParamList).build(), dtoParam);
      }

      return scheduling.getId();
   }

   @Transactional(rollbackFor = Exception.class)
   public synchronized Boolean updateMachinePartNestCut(MesBuildingMachinePartSchedulingDTOParam dtoParam) {
      MesBuildingMachinePartScheduling scheduling = this.getById(dtoParam.getSchedulingId());
      Preconditions.checkArgument(scheduling.getIssueStatusEnum().equals(MachinePartSchedulingIssueStatusEnum.IN_NESTING.getType()), "操作失败:该工单不处于套料中");
      Map<Long, BigDecimal> netWeightMap = new HashMap<>();
      AtomicReference<BigDecimal> totalNetWeight = new AtomicReference<>(BigDecimal.ZERO);
      this.machinePartService
         .listByIds(dtoParam.getLinkList().stream().map(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId).collect(Collectors.toList()))
         .forEach(e -> {
            BigDecimal var10000 = netWeightMap.put(e.getId(), e.getNetWeight());
         });
      Map<Long, List<MesBuildingMachinePartSchedulingLinkDTOParam>> longListMap = dtoParam.getLinkList()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId));
      Map<Long, Integer> partQuantityMap = new HashMap<>();
      longListMap.forEach(
         (productId, list) -> {
            MesBuildingMachinePartSchedulingLink link = this.linkBiz
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class)
                     .eq(MesBuildingMachinePartSchedulingLink::getProductId, productId)
                     .eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, scheduling.getId())
               );
            if (link != null) {
               link.setQuantity(link.getQuantity() + list.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum());
               this.linkBiz.updateById(link);
               partQuantityMap.put(link.getId(), list.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum());
            } else {
               link = MesBuildingMachinePartSchedulingLink.builder()
                  .productId(productId)
                  .quantity(list.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
                  .schedulingId(scheduling.getId())
                  .userId(UserUtil.getCurrentUserId())
                  .prdRef(scheduling.getOrderNumber() + productId)
                  .build();
               this.linkBiz.save(link);
               partQuantityMap.put(link.getId(), list.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum());
            }

            list.forEach(
               e -> {
                  if (e.getId() != null) {
                     MesBuildingTaskNeedMachinePartScheduling needMachinePartSchedulingLink = this.taskNeedMachinePartSchedulingBiz.getById(e.getId());
                     Preconditions.checkArgument(needMachinePartSchedulingLink != null, "操作失败！数据有误");
                     Preconditions.checkArgument(
                        needMachinePartSchedulingLink.getNeedQuantity() - needMachinePartSchedulingLink.getSchedulingQuantity() >= e.getQuantity(), "操作失败！数据有误"
                     );
                     needMachinePartSchedulingLink.setSchedulingQuantity(needMachinePartSchedulingLink.getSchedulingQuantity() + e.getQuantity());
                     this.taskNeedMachinePartSchedulingBiz.updateById(needMachinePartSchedulingLink);
                  }
               }
            );
            totalNetWeight.compareAndSet(
               totalNetWeight.get(), totalNetWeight.get().add(netWeightMap.get(productId).multiply(BigDecimal.valueOf(link.getQuantity().intValue())))
            );
         }
      );
      scheduling.setQuantity(
         scheduling.getQuantity() + dtoParam.getLinkList().stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum()
      );
      scheduling.setCutConfigId(dtoParam.getCutConfigId());
      scheduling.setAskCompleteTime(dtoParam.getAskCompleteTime());
      scheduling.setTotalNetWeight(scheduling.getTotalNetWeight().add(totalNetWeight.get()));
      this.updateById(scheduling);
      List<Long> nestCutSchedulingIds = new ArrayList<>();
      nestCutSchedulingIds.add(scheduling.getId());
      if (partQuantityMap.size() > 0) {
         ResultVO resultVO = this.nestCutPlateService.addJobPart(partQuantityMap);
         Preconditions.checkArgument("发送成功".equals(resultVO.getData().toString()), "操作失败:下发失败");
      }

      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingMachinePartSchedulingDTO> getMachinePartSchedulingRecordList(Integer issueStatusEnum, LocalDateTime dateTime) {
      List<MesBuildingMachinePartSchedulingDTO> schedulingDTOS = this.baseService
         .getMachinePartSchedulingRecordList(issueStatusEnum, dateTime)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingMachinePartSchedulingDTO.class))
         .collect(Collectors.toList());

      for (MesBuildingMachinePartSchedulingDTO schedulingDTO : schedulingDTOS) {
         List<MesBuildingMachinePartSchedulingLinkDTO> details = this.mesBuildingMachinePartSchedulingLinkBiz
            .getMachinePartSchedulingRecordDetails(schedulingDTO.getId());
         schedulingDTO.setBoolDrawing(1);

         for (MesBuildingMachinePartSchedulingLinkDTO detail : details) {
            if (StringUtils.isEmpty(detail.getPicturePath())) {
               schedulingDTO.setBoolDrawing(0);
            }
         }
      }

      return schedulingDTOS;
   }

   @Override
   public PageVO<MesBuildingMachinePartSchedulingDTO> getMachinePartSchedulingRecordPage(
      Integer issueStatusEnum, LocalDateTime dateTime, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getMachinePartSchedulingRecordList(issueStatusEnum, dateTime));
   }

   @Override
   public List<MesBuildingMachinePartSchedulingProjectDTO> getProjectList(List<LocalDateTime> monthList, LocalDateTime dateTime) {
      List<MesBuildingMachinePartSchedulingDTO> machinePartList = this.getMachinePartList(
         null, null, null, monthList, dateTime, null, null, null, null, null, null, null, null, false, null, null, null
      );
      if (machinePartList.size() == 0) {
         return new ArrayList<>();
      }

      Map<Long, ContractProject> projectMap = new HashMap<>();
      this.projectService
         .listByIds(machinePartList.stream().map(MesBuildingMachinePartSchedulingDTO::getProjectId).collect(Collectors.toList()))
         .stream()
         .filter(e -> e.getSettlementStatus().equals(0))
         .filter(e -> e.getStatus().equals(1))
         .collect(Collectors.toList())
         .forEach(e -> {
            ContractProject var10000 = projectMap.put(e.getId(), e);
         });
      return projectMap.keySet()
         .stream()
         .map(
            e -> MesBuildingMachinePartSchedulingProjectDTO.builder()
               .project(
                  ProjectDetailDO.builder()
                     .id(e)
                     .name(projectMap.get(e).getName())
                     .serialNumber(projectMap.get(e).getSerialNumber())
                     .shortName(projectMap.get(e).getShortName())
                     .build()
               )
               .quantity(
                  machinePartList.stream().filter(item -> item.getProjectId().equals(e)).mapToInt(MesBuildingMachinePartSchedulingDTO::getQuantity).sum()
               )
               .totalNetWeight(
                  machinePartList.stream()
                     .filter(item -> item.getProjectId().equals(e))
                     .map(item -> item.getNetWeight().multiply(BigDecimal.valueOf(item.getQuantity().intValue())))
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .build()
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectDetailDO> getProjectTree(List<LocalDateTime> monthList, LocalDateTime dateTime, Integer level) {
      List<Long> linkProjectIds = this.projectService
         .listSimpleProject(null, null, null, level)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(linkProjectIds)) {
         return new ArrayList<>();
      }

      List<MesBuildingParNeedSchedulingDTO> machinePartList = this.baseMapper
         .listNeedSchedulingParts(null, null, null, monthList, null, null, null, null, null, null, null, null, null, null);
      if (machinePartList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> projectIds = machinePartList.stream().map(s -> s.getProject().getId()).distinct().collect(Collectors.toList());
      List<Long> monmerIds = machinePartList.stream().map(s -> s.getMonomer().getId()).distinct().collect(Collectors.toList());
      List<Long> areaIds = machinePartList.stream().map(s -> s.getArea().getId()).distinct().collect(Collectors.toList());
      Map<Long, ContractProject> projectMap = new HashMap<>();
      this.projectService
         .listByIds(projectIds)
         .stream()
         .filter(e -> e.getSettlementStatus().equals(0))
         .filter(e -> e.getStatus().equals(1))
         .filter(e -> linkProjectIds.contains(e.getId()))
         .collect(Collectors.toList())
         .forEach(e -> {
            ContractProject var10000 = projectMap.put(e.getId(), e);
         });
      List<PlanMonomer> monomerList = this.monomerService.listByIds(monmerIds);
      List<PlanArea> areaList = this.areaService.listByIds(areaIds);
      Map<Long, List<WorkshopDetailDO>> areaWorkshopMap = new HashMap<>();
      Map<Long, List<ProductionLineDetailDO>> areaProductionLineMap = new HashMap<>();
      Map<Long, List<GroupsCurrencyDO>> areaGroupsMap = new HashMap<>();
      Integer showType = this.configService.getSowNeed();
      if (!showType.equals(MachinePartSchedulingTypeEnum.NOT.getType())) {
         Map<Long, List<MesBuildingParNeedSchedulingDTO>> areaMachinePartSchedulingMap = machinePartList.stream()
            .collect(Collectors.groupingBy(s -> s.getArea().getId()));

         for (Long areaId : areaMachinePartSchedulingMap.keySet()) {
            List<MesBuildingParNeedSchedulingDTO> areaNeedSchedulings = areaMachinePartSchedulingMap.get(areaId);
            Set<Long> workshopIds = new HashSet<>();
            List<WorkshopDetailDO> workshopList = new ArrayList<>();
            Map<Long, String> shopMap = areaNeedSchedulings.stream()
               .collect(Collectors.toMap(s -> s.getWorkshop().getId(), s -> s.getWorkshop().getName(), (s1, s2) -> s1));
            shopMap.keySet().forEach(aLong -> {
               if (!workshopIds.contains(aLong)) {
                  workshopIds.add(aLong);
                  workshopList.add(WorkshopDetailDO.builder().id(aLong).name(shopMap.get(aLong)).build());
               }
            });
            areaWorkshopMap.put(areaId, workshopList);
            Set<Long> linIds = new HashSet<>();
            List<ProductionLineDetailDO> productionLineList = new ArrayList<>();
            Map<Long, String> lineMap = areaNeedSchedulings.stream()
               .collect(Collectors.toMap(s -> s.getProductionLine().getId(), s -> s.getProductionLine().getName(), (s1, s2) -> s1));
            lineMap.keySet().forEach(aLong -> {
               if (!linIds.contains(aLong)) {
                  linIds.add(aLong);
                  productionLineList.add(ProductionLineDetailDO.builder().id(aLong).name(lineMap.get(aLong)).build());
               }
            });
            areaProductionLineMap.put(areaId, productionLineList);
            Set<Long> groupIds = new HashSet<>();
            List<GroupsCurrencyDO> groupsList = new ArrayList<>();
            Map<Long, String> groupMap = areaNeedSchedulings.stream()
               .collect(Collectors.toMap(s -> s.getGroup().getId(), s -> s.getGroup().getName(), (s1, s2) -> s1));
            groupMap.keySet().forEach(aLong -> {
               if (!groupIds.contains(aLong)) {
                  groupIds.add(aLong);
                  groupsList.add(GroupsCurrencyDO.builder().id(aLong).name(groupMap.get(aLong)).build());
               }
            });
            areaGroupsMap.put(areaId, groupsList);
         }
      }

      return projectMap.keySet()
         .stream()
         .map(
            e -> ProjectDetailDO.builder()
               .id(e)
               .name(projectMap.get(e).getName())
               .serialNumber(projectMap.get(e).getSerialNumber())
               .shortName(projectMap.get(e).getShortName())
               .quantity(
                  machinePartList.stream().filter(item -> item.getProject().getId().equals(e)).mapToInt(MesBuildingParNeedSchedulingDTO::getQuantity).sum()
               )
               .netWeight(
                  machinePartList.stream()
                     .filter(item -> item.getProject().getId().equals(e))
                     .map(item -> item.getNetWeight().multiply(BigDecimal.valueOf(item.getQuantity().intValue())))
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .monomerList(
                  monomerList.stream()
                     .filter(monomer -> monomer.getProjectId().equals(e))
                     .map(
                        monomer -> MonomerDetailDO.builder()
                           .id(monomer.getId())
                           .name(monomer.getName())
                           .quantity(
                              machinePartList.stream()
                                 .filter(item -> item.getMonomer().getId().equals(monomer.getId()))
                                 .mapToInt(MesBuildingParNeedSchedulingDTO::getQuantity)
                                 .sum()
                           )
                           .netWeight(
                              machinePartList.stream()
                                 .filter(item -> item.getMonomer().getId().equals(monomer.getId()))
                                 .map(item -> item.getNetWeight().multiply(BigDecimal.valueOf(item.getQuantity().intValue())))
                                 .reduce(BigDecimal.ZERO, BigDecimal::add)
                           )
                           .areaList(
                              areaList.stream()
                                 .filter(area -> area.getMonomerId().equals(monomer.getId()))
                                 .map(
                                    area -> {
                                       AreaDetailDO areaDetailDO = AreaDetailDO.builder()
                                          .id(area.getId())
                                          .name(area.getName())
                                          .quantity(
                                             machinePartList.stream()
                                                .filter(item -> item.getArea().getId().equals(area.getId()))
                                                .mapToInt(MesBuildingParNeedSchedulingDTO::getQuantity)
                                                .sum()
                                          )
                                          .netWeight(
                                             machinePartList.stream()
                                                .filter(item -> item.getArea().getId().equals(area.getId()))
                                                .map(item -> item.getNetWeight().multiply(BigDecimal.valueOf(item.getQuantity().intValue())))
                                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                                          )
                                          .build();
                                       if (showType.equals(MachinePartSchedulingTypeEnum.WORKSHOP.getType())) {
                                          areaDetailDO.setWorkshopList(areaWorkshopMap.get(area.getId()));
                                       }

                                       if (showType.equals(MachinePartSchedulingTypeEnum.PRODUCTION_LINE.getType())) {
                                          areaDetailDO.setProductionLineList(areaProductionLineMap.get(area.getId()));
                                       }

                                       if (showType.equals(MachinePartSchedulingTypeEnum.GROUPS.getType())) {
                                          areaDetailDO.setGroupsList(areaGroupsMap.get(area.getId()));
                                       }

                                       return areaDetailDO;
                                    }
                                 )
                                 .collect(Collectors.toList())
                           )
                           .build()
                     )
                     .collect(Collectors.toList())
               )
               .build()
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MonomerDetailDO> getMonomerList(List<Long> projectIds, List<LocalDateTime> monthList, LocalDateTime dateTime) {
      List<MesBuildingMachinePartSchedulingDTO> machinePartList = this.getMachinePartList(
         projectIds, null, null, monthList, dateTime, null, null, null, null, null, null, null, null, false, null, null, null
      );
      return machinePartList.size() == 0
         ? new ArrayList<>()
         : this.monomerService
            .listByIds(machinePartList.stream().map(MesBuildingMachinePartSchedulingDTO::getMonomerId).distinct().collect(Collectors.toList()))
            .stream()
            .map(e -> MonomerDetailDO.builder().id(e.getId()).name(e.getName()).build())
            .collect(Collectors.toList());
   }

   @Override
   public List<AreaDetailDO> getAreaList(List<Long> projectIds, List<Long> monomerIds, List<LocalDateTime> monthList, LocalDateTime dateTime) {
      List<MesBuildingMachinePartSchedulingDTO> machinePartList = this.getMachinePartList(
         projectIds, monomerIds, null, monthList, dateTime, null, null, null, null, null, null, null, null, false, null, null, null
      );
      return machinePartList.size() == 0
         ? new ArrayList<>()
         : this.areaService
            .listByIds(machinePartList.stream().map(MesBuildingMachinePartSchedulingDTO::getAreaId).distinct().collect(Collectors.toList()))
            .stream()
            .map(e -> AreaDetailDO.builder().id(e.getId()).name(e.getName()).build())
            .collect(Collectors.toList());
   }

   @Override
   public List<String> getMaterialList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      Integer taskTypeEnum,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   ) {
      List<MesBuildingParNeedSchedulingDTO> dtos = this.baseMapper
         .listNeedSchedulingParts(projectIds, monomerIds, areaIds, monthList, null, null, null, taskTypeEnum, null, null, null, null, null, null);
      return dtos.stream().map(MesBuildingParNeedSchedulingDTO::getMaterial).distinct().collect(Collectors.toList());
   }

   @Override
   public List<Integer> getPartTypeList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   ) {
      List<MesBuildingParNeedSchedulingDTO> dtos = this.baseMapper
         .listNeedSchedulingParts(
            projectIds, monomerIds, areaIds, monthList, workshopIds, productionLineIds, groupsIds, null, null, null, null, null, null, null
         );
      return dtos.stream().map(MesBuildingParNeedSchedulingDTO::getRelationType).distinct().collect(Collectors.toList());
   }

   @Override
   public List<String> getThickList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<LocalDateTime> monthList,
      LocalDateTime dateTime,
      String material,
      Integer taskTypeEnum,
      List<Long> workshopIds,
      List<Long> productionLineIds,
      List<Long> groupsIds
   ) {
      List<MesBuildingParNeedSchedulingDTO> dtos = this.baseMapper
         .listNeedSchedulingParts(
            projectIds, monomerIds, areaIds, monthList, workshopIds, productionLineIds, groupsIds, null, material, null, null, null, null, null
         );
      if (dtos == null) {
         return new ArrayList<>();
      }

      List<Double> doubles = dtos.stream()
         .filter(e -> e.getThick() != null)
         .map(e -> Double.parseDouble(e.getThick()))
         .distinct()
         .sorted()
         .collect(Collectors.toList());
      List<String> thickList = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(doubles)) {
         for (Double d : doubles) {
            double b = d;
            int b1 = (int)b;
            if (b % b1 == 0.0) {
               thickList.add((int)b + "");
            } else {
               thickList.add(b + "");
            }
         }
      }

      if (dtos.stream().anyMatch(e -> e.getThick() == null)) {
         thickList.add("其他");
      }

      return thickList;
   }

   @Override
   public List<String> getDateList(LocalDateTime dateTime) {
      Set<String> dateSet = new HashSet<>();
      List<String> dateList = new ArrayList<>();
      this.mesBuildingTaskBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.builder().build())
               .eq(MesBuildingTask::getBoolCompleteEnum, Boolean.FALSE)
               .and(
                  e -> {
                     LambdaQueryWrapper var10000 = e.eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                        .or()
                        .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType());
                  }
               )
               .apply("DATE_FORMAT(create_time,'%Y-%m')={0}", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM")))
         )
         .forEach(e -> dateSet.add(e.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
      dateSet.forEach(
         e -> {
            if (this.getMachinePartList(
                     null,
                     null,
                     null,
                     null,
                     LocalDate.parse(e, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay(),
                     null,
                     null,
                     null,
                     null,
                     null,
                     null,
                     null,
                     null,
                     false,
                     null,
                     null,
                     null
                  )
                  .size()
               > 0) {
               dateList.add(e);
            }
         }
      );
      return dateList;
   }

   @Override
   public List<String> getMonthList(Long workshopId) {
      new ArrayList();
      List<String> months = this.baseMapper.listNeedSchedulingMonth(workshopId);
      months.sort(Comparator.naturalOrder());
      return months;
   }

   @Override
   public List<String> getMonthListTwo(List<Long> workshopIds, List<Integer> steelPlateTypeEnum, Boolean sendStatus) {
      if (workshopIds != null && workshopIds.size() != 0) {
         new ArrayList();
         List<String> months = this.baseMapper.listNeedSchedulingMonthTwo(workshopIds, steelPlateTypeEnum, sendStatus);
         months.sort(Comparator.naturalOrder());
         return months;
      } else {
         return new ArrayList<>();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeList(List<Long> ids) {
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeDetail(Long id) {
      MesBuildingMachinePartSchedulingLink link = this.linkBiz.getById(id);
      MesBuildingMachinePartScheduling scheduling = this.baseService.getById(link.getSchedulingId());
      this.linkBiz.removeById(id);
      scheduling.setTotalNetWeight(
         scheduling.getTotalNetWeight()
            .subtract(this.machinePartService.getById(link.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(link.getQuantity().intValue())))
      );
      scheduling.setQuantity(scheduling.getQuantity() - link.getQuantity());
      if (scheduling.getQuantity().equals(0)) {
         this.baseService.removeById(scheduling.getId());
      } else {
         this.baseService.updateById(scheduling);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveMachinePartNestingIssued(List<MesBuildingMachinePartNestingDTOParam> dtoParamList) {
      List<Long> schedulingIds = dtoParamList.stream().map(MesBuildingMachinePartNestingDTOParam::getSchedulingId).collect(Collectors.toList());
      List<MesBuildingMachinePartScheduling> machinePartSchedulingList = this.listByIds(schedulingIds);
      Preconditions.checkArgument(machinePartSchedulingList.size() == schedulingIds.size(), "操作失败,零件排产记录不存在");
      Map<Long, MesBuildingMachinePartScheduling> schedulingMap = machinePartSchedulingList.stream()
         .collect(Collectors.toMap(MesBuildingMachinePartScheduling::getId, e -> (MesBuildingMachinePartScheduling)e));
      Map<Long, MesBuildingMachinePartNestingDTOParam> schedulingDtoMap = dtoParamList.stream()
         .collect(Collectors.toMap(MesBuildingMachinePartNestingDTOParam::getSchedulingId, e -> (MesBuildingMachinePartNestingDTOParam)e));
      List<MesBuildingCutConfigDTO> cutConfigDTOS = this.cutConfigBiz.listCondition();
      Map<Long, MesBuildingCutConfigDTO> cutConfigMap = cutConfigDTOS.stream()
         .collect(Collectors.toMap(MesBuildingCutConfigDTO::getId, e -> (MesBuildingCutConfigDTO)e));
      List<Long> nestSchedulingIds = new ArrayList<>();
      dtoParamList.forEach(
         e -> {
            MesBuildingMachinePartScheduling machinePartScheduling = schedulingMap.get(e.getSchedulingId());
            Preconditions.checkArgument(
               machinePartScheduling.getIssueStatusEnum().equals(MachinePartSchedulingIssueStatusEnum.NOT_NESTING.getType()), "操作失败，排产记录已发生套料!!!"
            );
            String thick = machinePartScheduling.getThick();
            MesBuildingCutConfigDTO configDTOS = cutConfigMap.get(e.getCutConfigId());
            Preconditions.checkArgument(configDTOS != null, "切割配置不存在");
            int minThickness = Integer.parseInt(configDTOS.getMinThickness());
            int maxThickness = Integer.parseInt(configDTOS.getMaxThickness());
            int partThickness = Integer.parseInt(thick);
            Preconditions.checkArgument(
               partThickness >= minThickness && partThickness <= maxThickness, "操作失败,厚度" + thick + "不在" + minThickness + "-" + maxThickness + "的厚度范围中"
            );
            if (configDTOS.getBoolNestCutEnum()) {
               nestSchedulingIds.add(machinePartScheduling.getId());
            }
         }
      );
      if (nestSchedulingIds.size() > 0) {
         machinePartSchedulingList.stream().filter(e -> nestSchedulingIds.contains(e.getId())).collect(Collectors.toList()).forEach(scheduling -> {
            scheduling.setIssueStatusEnum(MachinePartSchedulingIssueStatusEnum.IN_NESTING.getType());
            scheduling.setCutConfigId(schedulingDtoMap.get(scheduling.getId()).getCutConfigId());
            scheduling.setNestingTime(LocalDateTime.now());
            scheduling.setOrderNumber("T" + scheduling.getOrderNumber());
            scheduling.setBoolNestCutEnum(Boolean.TRUE);
            this.baseMapper.updateById(scheduling);
         });
         ResultVO resultVO = this.nestCutPlateService.uploadJobPart(schedulingIds);
         Preconditions.checkArgument("发送成功".equals(resultVO.getData().toString()), "操作失败:下发失败");
      }

      machinePartSchedulingList.stream()
         .filter(e -> !nestSchedulingIds.contains(e.getId()))
         .collect(Collectors.toList())
         .forEach(
            scheduling -> {
               scheduling.setIssueStatusEnum(MachinePartSchedulingIssueStatusEnum.IN_NESTING.getType());
               scheduling.setCutConfigId(schedulingDtoMap.get(scheduling.getId()).getCutConfigId());
               scheduling.setNestingTime(LocalDateTime.now());
               scheduling.setBoolNestCutEnum(Boolean.FALSE);
               this.baseMapper.updateById(scheduling);
               MesBuildingNestCutPlate cutPlate = MesBuildingNestCutPlate.builder()
                  .machinePartSchedulingId(scheduling.getId())
                  .boolNestCutEnum(Boolean.FALSE)
                  .boolIssueEnum(Boolean.FALSE)
                  .boolProductionEunm(Boolean.FALSE)
                  .cutNumber(scheduling.getOrderNumber())
                  .material(scheduling.getMaterial())
                  .userId(UserUtil.getCurrentUserId())
                  .build();
               this.nestCutPlateBiz.save(cutPlate);
               this.linkBiz
                  .list(
                     Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class)
                        .eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, scheduling.getId())
                  )
                  .forEach(
                     e -> this.nestCutPlatePartBiz
                        .save(
                           MesBuildingNestCutPlatePart.builder()
                              .mesBuildingNestCutPlateId(cutPlate.getId())
                              .partId(e.getProductId())
                              .quantity(e.getQuantity())
                              .build()
                        )
                  );
            }
         );
      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingMachinePartSchedulingDTO> getMachinePartTaskIssuedList(
      LocalDateTime date, Boolean boolNestCutEnum, Integer issueStatusEnum, Long projectId
   ) {
      List<Long> schedulingIdList = new ArrayList<>();
      if (projectId != null) {
         List<Long> partIdList = this.machinePartService
            .list(Wrappers.lambdaQuery(TechMachinePart.class).eq(TechMachinePart::getProjectId, projectId).eq(TechMachinePart::getBoolProcess, Boolean.TRUE))
            .stream()
            .map(TechMachinePart::getId)
            .collect(Collectors.toList());
         if (partIdList.size() > 0) {
            schedulingIdList = this.linkBiz
               .list(Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class).in(MesBuildingMachinePartSchedulingLink::getProductId, partIdList))
               .stream()
               .map(MesBuildingMachinePartSchedulingLink::getSchedulingId)
               .collect(Collectors.toList());
         }
      }

      return this.list(
            Wrappers.lambdaQuery(MesBuildingMachinePartScheduling.class)
               .and(
                  e -> {
                     LambdaQueryWrapper var10000 = e.or(
                           s -> {
                              LambdaQueryWrapper var10000x = s.ne(
                                    MesBuildingMachinePartScheduling::getIssueStatusEnum, MachinePartSchedulingIssueStatusEnum.NOT_NESTING.getType()
                                 )
                                 .eq(MesBuildingMachinePartScheduling::getBoolNestCutEnum, Boolean.TRUE);
                           }
                        )
                        .or(s -> {
                           LambdaQueryWrapper var10000x = s.eq(MesBuildingMachinePartScheduling::getBoolNestCutEnum, Boolean.FALSE);
                        });
                  }
               )
               .eq(boolNestCutEnum != null, MesBuildingMachinePartScheduling::getBoolNestCutEnum, boolNestCutEnum)
               .eq(issueStatusEnum != null, MesBuildingMachinePartScheduling::getIssueStatusEnum, issueStatusEnum)
               .in(schedulingIdList.size() > 0, MesBuildingMachinePartScheduling::getId, schedulingIdList)
               .apply(date != null, "date_format(nesting_time, '%Y-%m') = date_format({0}, '%Y-%m')", date)
               .orderByAsc(MesBuildingMachinePartScheduling::getTaskStatusEnum)
               .orderByDesc(MesBuildingMachinePartScheduling::getIssueStatusEnum, BaseEntity::getCreateTime)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingMachinePartSchedulingDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<MesBuildingMachinePartSchedulingDTO> getMachinePartTaskIssuedPage(
      LocalDateTime date,
      Boolean boolNestCutEnum,
      Integer issueStatusEnum,
      String orderNumber,
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      String thick,
      String material,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> schedulingIdList = new ArrayList<>();
      if (projectIds != null || monomerIds != null || areaIds != null) {
         List<Long> partIdList = this.machinePartService
            .list(
               Wrappers.lambdaQuery(TechMachinePart.class)
                  .in(projectIds != null, TechMachinePart::getProjectId, projectIds)
                  .in(monomerIds != null, TechMachinePart::getMonomerId, monomerIds)
                  .in(areaIds != null, TechMachinePart::getAreaId, areaIds)
                  .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
            )
            .stream()
            .map(TechMachinePart::getId)
            .collect(Collectors.toList());
         if (partIdList.size() > 0) {
            schedulingIdList = this.linkBiz
               .list(Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class).in(MesBuildingMachinePartSchedulingLink::getProductId, partIdList))
               .stream()
               .map(MesBuildingMachinePartSchedulingLink::getSchedulingId)
               .collect(Collectors.toList());
         }

         if (CollectionUtil.isEmpty(schedulingIdList)) {
            return new PageVO<>();
         }
      }

      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.list(
               Wrappers.lambdaQuery(MesBuildingMachinePartScheduling.class)
                  .and(
                     e -> {
                        LambdaQueryWrapper var10000 = e.or(
                              s -> {
                                 LambdaQueryWrapper var10000x = s.ne(
                                       MesBuildingMachinePartScheduling::getIssueStatusEnum, MachinePartSchedulingIssueStatusEnum.NOT_NESTING.getType()
                                    )
                                    .eq(MesBuildingMachinePartScheduling::getBoolNestCutEnum, Boolean.TRUE);
                              }
                           )
                           .or(s -> {
                              LambdaQueryWrapper var10000x = s.eq(MesBuildingMachinePartScheduling::getBoolNestCutEnum, Boolean.FALSE);
                           });
                     }
                  )
                  .eq(boolNestCutEnum != null, MesBuildingMachinePartScheduling::getBoolNestCutEnum, boolNestCutEnum)
                  .eq(issueStatusEnum != null, MesBuildingMachinePartScheduling::getIssueStatusEnum, issueStatusEnum)
                  .like(StringUtils.isNoneBlank(orderNumber), MesBuildingMachinePartScheduling::getOrderNumber, orderNumber)
                  .eq(StringUtils.isNotBlank(thick), MesBuildingMachinePartScheduling::getThick, thick)
                  .like(StringUtils.isNotBlank(material), MesBuildingMachinePartScheduling::getMaterial, material)
                  .in(schedulingIdList.size() > 0, MesBuildingMachinePartScheduling::getId, schedulingIdList)
                  .apply(date != null, "date_format(nesting_time, '%Y-%m') = date_format({0}, '%Y-%m')", date)
                  .orderByAsc(MesBuildingMachinePartScheduling::getTaskStatusEnum)
                  .orderByDesc(MesBuildingMachinePartScheduling::getIssueStatusEnum, BaseEntity::getCreateTime)
            )
            .stream()
            .map(e -> BeanUtil.copy(e, MesBuildingMachinePartSchedulingDTO.class))
            .collect(Collectors.toList())
      );
   }

   @Override
   public List<ProjectTreeResponseVO> getNestCutProjectList(LocalDateTime startDate, LocalDateTime endDate, String name, Integer issueStatusEnum) {
      List<MesBuildingMachinePartScheduling> schedulingList = this.list(
         Wrappers.lambdaQuery(MesBuildingMachinePartScheduling.class)
            .eq(MesBuildingMachinePartScheduling::getBoolNestCutEnum, Boolean.TRUE)
            .orderByAsc(MesBuildingMachinePartScheduling::getTaskStatusEnum)
            .orderByDesc(MesBuildingMachinePartScheduling::getIssueStatusEnum, BaseEntity::getCreateTime)
      );
      if (schedulingList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new ArrayList<>();
      }

      List<Long> proId = this.projectService.listBytimeAndName(startDate, endDate, name).stream().map(ContractProject::getId).collect(Collectors.toList());
      List<MesBuildingMachinePartScheduling> un = new ArrayList<>();
      if (issueStatusEnum != null) {
         if (issueStatusEnum == 8) {
            un = schedulingList.stream().filter(s -> s.getIssueStatusEnum() != 8).collect(Collectors.toList());
         } else {
            schedulingList = schedulingList.stream().filter(s -> s.getIssueStatusEnum() != 8).collect(Collectors.toList());
         }
      }

      List<Long> unid = new ArrayList<>();
      if (CollectionUtil.isNotEmpty(un)) {
         unid = this.findProjects(un).stream().map(ProjectTreeResponseVO::getId).collect(Collectors.toList());
      }

      List<ProjectTreeResponseVO> project = this.findProjects(schedulingList);
      if (CollectionUtil.isNotEmpty(project)) {
         List<Long> finalUnid = unid;
         return project.stream()
            .filter(s -> projectIds.contains(s.getId()))
            .filter(s -> proId.contains(s.getId()))
            .filter(s -> !finalUnid.contains(s.getId()))
            .collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public List<MesBuildingNestCutPlateDTO> getMachinePartTaskIssuedDetails(Long id) {
      return this.nestCutPlateBiz.getMachinePartTaskIssuedDetails(id).stream().map(e -> {
         MesBuildingNestCutPlateDTO dto = BeanUtil.copy(e, MesBuildingNestCutPlateDTO.class);
         if (dto.getGroupsId() == 0L) {
            dto.setGroupsId(null);
         }

         return dto;
      }).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updataIssueStatusEnum(String orderNumber) {
      MesBuildingMachinePartScheduling mesBuildingMachinePartScheduling = this.baseMapper
         .selectOne(Wrappers.lambdaQuery(MesBuildingMachinePartScheduling.class).eq(MesBuildingMachinePartScheduling::getOrderNumber, orderNumber));
      Preconditions.checkArgument(mesBuildingMachinePartScheduling != null, "套料结果保存失败零件排产工单不存在");
      mesBuildingMachinePartScheduling.setIssueStatusEnum(MachinePartSchedulingIssueStatusEnum.OUT_NESTING.getType());
      List<MesBuildingNestCutPlate> list = this.nestCutPlateBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
               .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, mesBuildingMachinePartScheduling.getId())
         );
      List<PdfUtilDTO> pdfUtilDTOS = new ArrayList<>();
      if (StringUtils.isNotBlank(mesBuildingMachinePartScheduling.getFilePath())) {
         PdfUtilDTO dto = new PdfUtilDTO();
         dto.setFileName("scheduling.pdf");
         dto.setHttpUrl(mesBuildingMachinePartScheduling.getFilePath());
         pdfUtilDTOS.add(dto);
      }

      for (MesBuildingNestCutPlate cut : list) {
         PdfUtilDTO dto = new PdfUtilDTO();
         dto.setFileName(cut.getPdfName());
         dto.setHttpUrl(cut.getPdfUrl());
         pdfUtilDTOS.add(dto);
      }

      String targetPath = this.configProperties.getFilePath() + "scheduling" + File.separator + mesBuildingMachinePartScheduling.getId() + File.separator;
      String s = PdfUtil.mergePdf(pdfUtilDTOS, targetPath);
      String ossRelativePath = "schedulingPDF" + "/" + mesBuildingMachinePartScheduling.getId() + "-" + "scheduling.pdf";
      String localAbsoluteFilePath = s;
      OSS client = this.ossUtils.openClient();
      String Url = this.ossUtils.uploadFile(client, ossRelativePath, localAbsoluteFilePath);
      mesBuildingMachinePartScheduling.setFilePath(Url);
      mesBuildingMachinePartScheduling.setIssueStatusEnum(MachinePartSchedulingIssueStatusEnum.OUT_NESTING.getType());
      this.baseMapper.updateById(mesBuildingMachinePartScheduling);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveMachinePartUnNestingIssued(MesBuildingMachinePartNestingDTOParam param) {
      MesBuildingMachinePartScheduling scheduling = this.getById(param.getSchedulingId());
      Preconditions.checkArgument(scheduling != null, "操作失败：排产id不正确");
      MesBuildingGroups groups = this.groupsBiz.getById(param.getGroupsId());
      Preconditions.checkArgument(groups != null, "操作失败：id不正确");
      MesBuildingCutConfig cutConfig = this.cutConfigBiz.getById(param.getCutConfigId());
      Preconditions.checkArgument(cutConfig != null, "操作失败：id不正确");
      MesBuildingNestCutPlate cutPlate = MesBuildingNestCutPlate.builder()
         .askCompleteTime(param.getArtifactDateTime())
         .machinePartSchedulingId(scheduling.getId())
         .boolNestCutEnum(Boolean.FALSE)
         .boolIssueEnum(Boolean.TRUE)
         .boolProductionEunm(Boolean.FALSE)
         .factoryId(groups.getFactoryId())
         .workshopId(groups.getWorkshopId())
         .groupsId(groups.getId())
         .cutNumber(scheduling.getOrderNumber())
         .material(scheduling.getMaterial())
         .build();
      this.nestCutPlateBiz.save(cutPlate);
      this.linkBiz
         .list(Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class).eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, scheduling.getId()))
         .forEach(
            e -> this.nestCutPlatePartBiz
               .save(
                  MesBuildingNestCutPlatePart.builder().mesBuildingNestCutPlateId(cutPlate.getId()).partId(e.getProductId()).quantity(e.getQuantity()).build()
               )
         );
      List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartDetailList = new ArrayList<>();
      machinePartDetailList.add(
         MesBuildingTaskOrderMachinePartDetailDTOParam.builder()
            .id(cutPlate.getId())
            .askCompleteTime(cutPlate.getAskCompleteTime())
            .groupsId(groups.getId())
            .build()
      );
      return this.taskOrderBiz
         .saveTaskOrderList(
            MesBuildingTaskOrderDTOParam.builder()
               .machinePartDetailList(machinePartDetailList)
               .productType(TaskTypeEnum.MACHINE_PART.getType())
               .productionLineTypeEnum(ProductionLineTypeEnum.TRADITIONAL_LINE.getType())
               .build(),
            null
         );
   }

   @Override
   public PartDistributionDTO partDistribution(Long id) {
      MesBuildingMachinePartScheduling mesBuildingMachinePartScheduling = this.baseMapper.selectById(id);
      int size = this.nestCutPlateBiz
         .list(Wrappers.lambdaQuery(MesBuildingNestCutPlate.class).eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, id))
         .size();
      Preconditions.checkArgument(mesBuildingMachinePartScheduling != null, "该任务单不存在!");
      List<MesBuildingMachinePartSchedulingLinkDTO> details = this.mesBuildingMachinePartSchedulingLinkBiz.getMachinePartSchedulingRecordDetails(id);
      int quantity = details.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTO::getQuantity).sum();
      BigDecimal totalNetWeight = details.stream()
         .map(e -> e.getNetWeight().multiply(new BigDecimal(e.getQuantity())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalGrossWeight = details.stream()
         .map(e -> e.getGrossWeight().multiply(new BigDecimal(e.getQuantity())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      List<ProjectMomentDTO> projectMomentDTOS = new ArrayList<>();
      Map<Long, List<MesBuildingMachinePartSchedulingLinkDTO>> projectMap = details.stream()
         .filter(s -> s.getProject().getId() != 0L)
         .collect(Collectors.groupingBy(s -> s.getProject().getId()));

      for (Long aLong : projectMap.keySet()) {
         List<MesBuildingMachinePartSchedulingLinkDTO> dtos = projectMap.get(aLong);
         List<NameInfo> monomers = new ArrayList<>();
         Map<Long, String> monIdAndName = dtos.stream()
            .filter(s -> s.getMonomer().getId() != 0L)
            .map(MesBuildingMachinePartSchedulingLinkDTO::getMonomer)
            .collect(Collectors.toMap(MonomerDetailDO::getId, MonomerDetailDO::getName, (s1, s2) -> s1));

         for (Long monId : monIdAndName.keySet()) {
            monomers.add(NameInfo.builder().id(monId).name(monIdAndName.get(monId)).build());
         }

         projectMomentDTOS.add(
            ProjectMomentDTO.builder()
               .id(aLong)
               .shortName(dtos.get(0).getProject().getShortName())
               .serialNumber(dtos.get(0).getProject().getSerialNumber())
               .name(dtos.get(0).getProject().getName())
               .monomers(monomers)
               .build()
         );
      }

      return PartDistributionDTO.builder()
         .projectInfoList(projectMomentDTOS)
         .cutQuantity(size)
         .quantity(quantity)
         .createTime(mesBuildingMachinePartScheduling.getCreateTime())
         .orderNumber(mesBuildingMachinePartScheduling.getOrderNumber())
         .totalNetWeight(totalNetWeight)
         .totalGrossWeight(totalGrossWeight)
         .build();
   }

   @Override
   public void getSchedulingPDF(Long id) {
      MesBuildingMachinePartScheduling sch = this.baseMapper.selectById(id);
      Preconditions.checkArgument(sch != null, "任务工单不存在");
      String pdfUrl = sch.getFilePath();
      String filePath = this.configProperties.getFilePath() + "pdf" + File.separator;

      try {
         PdfUtil.downLoadFromUrl(pdfUrl, sch.getOrderNumber() + ".pdf", filePath);
      } catch (IOException e) {
         Preconditions.checkArgument(false, "文件下载失败");
      }

      File file = new File(filePath + sch.getOrderNumber() + ".pdf");
      FileUtil.downloadFile(file, sch.getOrderNumber() + ".pdf");
      file.delete();
   }

   @Override
   public void downloadSchedulingFile(Long id) {
      MesBuildingMachinePartScheduling sch = this.baseService.getById(id);
      Preconditions.checkArgument(sch != null, "任务工单不存在");
      Preconditions.checkArgument(sch.getIssueStatusEnum() >= 4, "该工单套料未完成!");
      List<MesBuildingNestCutPlate> cuts = this.nestCutPlateBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
               .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, id)
               .eq(MesBuildingNestCutPlate::getBoolNestCutEnum, 1)
         );
      Map<String, MesBuildingNestCutPlate> cutMap = cuts.stream().collect(Collectors.toMap(MesBuildingNestCutPlate::getCutNumber, Function.identity()));

      try {
         for (String cutNumber : cutMap.keySet()) {
            String filePath = this.configProperties.getFilePath() + "zipfile" + File.separator + sch.getOrderNumber() + File.separator;
            MesBuildingNestCutPlate cutPlate = cutMap.get(cutNumber);
            PdfUtil.downLoadFromUrl(cutPlate.getNcUrl(), cutPlate.getNcName(), filePath);
            PdfUtil.downLoadFromUrl(cutPlate.getPdfUrl(), cutNumber + ".pdf", filePath);
         }

         ZIPUtils.toZip(
            this.configProperties.getFilePath() + "zipfile" + File.separator + sch.getOrderNumber() + ".zip",
            this.configProperties.getFilePath() + "zipfile" + File.separator + sch.getOrderNumber(),
            true
         );
         File file = new File(this.configProperties.getFilePath() + "zipfile" + File.separator + sch.getOrderNumber() + ".zip");
         FileUtil.downloadFile(file, sch.getOrderNumber() + ".zip");
         String filePath = this.configProperties.getFilePath() + "zipfile" + File.separator;
         deleteFile(filePath);
      } catch (Exception e) {
         Preconditions.checkArgument(false, "文件下载失败,请联系管理员!");
      }
   }

   @Override
   public void downloadOffLineSchedulingFile(Long id) {
      MesBuildingMachinePartScheduling scheduling = this.baseService.getById(id);
      Preconditions.checkArgument(scheduling != null, "排产数据不存在,请联系管理员");
      Preconditions.checkArgument(scheduling.getBoolOffLine(), "该工单不是线下套料类型");
      List<OffLineSchedulingFileDTO> dtos = new ArrayList<>();
      new HashMap();
      String path = this.configProperties.getFilePath() + "offLineFiles" + File.separator + scheduling.getOrderNumber() + File.separator;
      String zipPath = this.configProperties.getFilePath() + "offLineFiles" + File.separator + scheduling.getOrderNumber() + ".zip";
      String dxfPath = this.configProperties.getFilePath()
         + "offLineFiles"
         + File.separator
         + scheduling.getOrderNumber()
         + File.separator
         + "零件图"
         + File.separator;
      File saveDir = new File(dxfPath);
      if (!saveDir.exists()) {
         boolean indexList = saveDir.mkdirs();
      }

      List<Integer> indexList = new ArrayList<>();
      List<MesBuildingMachinePartSchedulingLinkDTO> machineParts = this.mesBuildingMachinePartSchedulingLinkBiz.getMachinePartSchedulingRecordDetails(id);
      Map<String, String> pathMap = this.machinePartService
         .listByIds(machineParts.stream().map(MesBuildingMachinePartSchedulingLinkDTO::getProductId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getSerialNumber, TechMachinePart::getPath, (s1, s2) -> s1));
      Map<Long, Integer> productMap = machineParts.stream()
         .collect(Collectors.toMap(MesBuildingMachinePartSchedulingLinkDTO::getId, MesBuildingMachinePartSchedulingLinkDTO::getQuantity, (s1, s2) -> s1));
      Map<Long, String> serialNumberMap = machineParts.stream()
         .collect(Collectors.toMap(MesBuildingMachinePartSchedulingLinkDTO::getId, MesBuildingMachinePartSchedulingLinkDTO::getSerialNumber, (s1, s2) -> s1));

      for (Long productId : productMap.keySet()) {
         dtos.add(
            OffLineSchedulingFileDTO.builder()
               .serialNumber(serialNumberMap.get(productId))
               .thickness(scheduling.getThick())
               .material(scheduling.getMaterial())
               .equipmentNo("Lantek laser")
               .quantity(productMap.get(productId))
               .build()
         );
      }

      Integer row = 2;

      for (OffLineSchedulingFileDTO dto : dtos) {
         indexList.add(row);
         dto.setPath("G$1&A" + row + "&$H$1");
         row = row + 1;
      }

      try {
         String tempFileName = "offline";
         String resourcePath = "files/offline.xls";
         String exportFileName = "套料零件清单.xls";
         org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, "xls");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Map<String, Object> exportMap = BeanUtil.beanToMap(dtos.get(0));
         exportMap.put("dtos", dtos);
         Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
         PoiUtils.downLoadExcel(exportFileName, path + scheduling.getOrderNumber() + ".xls", workbook);

         for (String s : pathMap.keySet()) {
            PdfUtil.downLoadFromUrl(pathMap.get(s), s + ".DXF", dxfPath);
         }

         ZIPUtils.toZip(zipPath, path, true);
         File dwfile = new File(zipPath);
         FileUtil.downloadFile(dwfile, scheduling.getOrderNumber() + ".zip");
         deleteFile(this.configProperties.getFilePath() + "offLineFiles");
      } catch (Exception e) {
         Preconditions.checkArgument(false, "文件下载失败,请联系管理员!");
      } finally {
         System.gc();
      }
   }

   @Override
   public List<MesBuildingTaskNeedMachinePartSchedulingDTO> getNeedDetailByIds(List<Long> ids) {
      return this.taskNeedMachinePartSchedulingBiz.getNeedDetailByIds(ids);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean partTaskOrderRevoke(Long id) {
      MesBuildingTaskOrder taskOrder = this.taskOrderService.getById(id);
      Preconditions.checkArgument(taskOrder != null, "操作失败,零件工单不存在!");
      Preconditions.checkArgument(
         UserUtil.getCurrentUser().isAdmin() || UserUtil.getCurrentUserId().equals(taskOrder.getUserId()), "操作失败,只能撤回本人创建的零件工单!"
      );
      Preconditions.checkArgument(TaskTypeEnum.MACHINE_PART.getType().equals(taskOrder.getTaskTypeEnum()), "操作失败,只能操作零件工单!");
      Preconditions.checkArgument(taskOrder.getOrderNumber().contains("(直)") || taskOrder.getOrderNumber().contains("(型)"), "操作失败,只能操作直接排产的工单!");
      List<WmsApproveRecord> wmsApproveRecords = this.wmsApproveRecordService
         .list(
            (Wrapper<WmsApproveRecord>)(((new LambdaQueryWrapper<WmsApproveRecord>()
                        .eq(WmsApproveRecord::getDataId, taskOrder.getSchedulingId()))
                     .eq(WmsApproveRecord::getModuleType, ModuleTypeEnum.MES.getType()))
                  .eq(WmsApproveRecord::getFunctionType, FunctionTypeEnum.MES_MACHINE_PART.getType()))
               .eq(WmsApproveRecord::getApproveProcessType, ApproveProcessTypeEnumV2.MES_MACHINE_PART.getType())
         );
      if (CollectionUtils.isNotEmpty(wmsApproveRecords)) {
         Preconditions.checkArgument(
            wmsApproveRecords.stream().noneMatch(e -> e.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())), "操作失败,该零件工单已办理领料,不可撤回!"
         );
         wmsApproveRecords.forEach(record -> {
            record.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
            record.setStatus(ApproveRecordStatusEnum.END.getType());
         });
         this.wmsApproveRecordService.updateBatchById(wmsApproveRecords);
      }

      MesBuildingTask task = this.taskService.lambdaQuery().eq(MesBuildingTask::getTaskOrderId, id).last("limit 1").one();
      ContractProject project = this.projectService.getById(task.getProjectId());
      Preconditions.checkArgument(project != null, "操作失败,项目不存在!");
      this.partTaskRevoke(id, taskOrder.getSchedulingId());
      this.taskOrderService.removeById(taskOrder);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean partTaskOrderRevokeV2(Long taskOrderId) {
      MesBuildingTaskOrder taskOrder = this.taskOrderService.getById(taskOrderId);
      Preconditions.checkArgument(taskOrder != null, "操作失败,零件工单不存在!");
      Preconditions.checkArgument(TaskTypeEnum.MACHINE_PART.getType().equals(taskOrder.getTaskTypeEnum()), "操作失败,只能操作零件工单!");
      MesBuildingTask task = this.taskService.lambdaQuery().eq(MesBuildingTask::getTaskOrderId, taskOrderId).last("limit 1").one();
      ContractProject project = this.projectService.getById(task.getProjectId());
      Preconditions.checkArgument(project != null, "操作失败,项目不存在!");
      this.nestingPartTaskRevoke(taskOrderId, taskOrder.getSchedulingId());
      this.taskOrderService.removeById(taskOrder);
      this.nestBiz.deleteNestingByChildGuid(taskOrder.getChildGuid());
      return Boolean.TRUE;
   }

   private void partTaskRevoke(Long id, Long schedulingId) {
      MesBuildingMachinePartScheduling partScheduling = this.machinePartSchedulingService.getById(schedulingId);
      Preconditions.checkArgument(partScheduling != null, "排产记录不存在!");
      List<MesBuildingTask> taskList = this.taskService.list(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getTaskOrderId, id));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskList), "操作失败,零件任务不存在!");
      Preconditions.checkArgument(taskList.stream().allMatch(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())), "操作失败,零件任务不存在!");
      List<Long> productIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
      List<Long> taskIds = taskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList());
      List<MesBuildingProduceTeamReport> produceTeamReports = this.produceTeamReportService
         .list((Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>().in(MesBuildingProduceTeamReport::getTaskId, taskIds));
      Preconditions.checkArgument(CollectionUtils.isEmpty(produceTeamReports), "操作失败,该工单下的零件存在上报记录,无法操作撤回!");
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
         .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskOrderId, id));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskProcessList), "操作失败,零件工序任务不存在!");
      Preconditions.checkArgument(taskProcessList.stream().allMatch(e -> e.getCompleteQuantity() == 0), "操作失败,该工单下的零件存在上报记录,无法操作撤回!");
      taskProcessList.forEach(e -> this.taskProcessService.updateById(e));
      this.taskProcessService.removeByIds(taskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()));
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> artifactTaskLinks = this.mesBuildingMachinePartSchedulingArtifactTaskLinkService
         .list(
            (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
               .eq(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingId, schedulingId)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactTaskLinks), "操作失败,零件排产记录异常!");
      List<Long> needIds = artifactTaskLinks.stream().map(MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId).collect(Collectors.toList());
      List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulings = this.needMachinePartSchedulingService.listByIds(needIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskNeedMachinePartSchedulings), "操作失败,零件排产记录异常");
      taskNeedMachinePartSchedulings.forEach(e -> {
         e.setSchedulingQuantity(0);
         e.setSchedulingUserId(null);
         e.setSchedulingDate(null);
         e.setSendNestingStatus(false);
      });
      this.needMachinePartSchedulingService.updateBatchById(taskNeedMachinePartSchedulings);
      this.mesBuildingMachinePartSchedulingArtifactTaskLinkService
         .removeByIds(artifactTaskLinks.stream().map(MesBuildingMachinePartSchedulingArtifactTaskLink::getId).collect(Collectors.toList()));
      List<MesBuildingNestCutMachinePartSeparate> cutPartSeparates = this.nestCutMachinePartSeparateService
         .list((Wrapper<MesBuildingNestCutMachinePartSeparate>)new LambdaQueryWrapper<MesBuildingNestCutMachinePartSeparate>().eq(MesBuildingNestCutMachinePartSeparate::getTaskOrderId, id));
      if (CollectionUtils.isNotEmpty(cutPartSeparates)) {
         this.nestCutMachinePartSeparateService
            .removeByIds(cutPartSeparates.stream().map(MesBuildingNestCutMachinePartSeparate::getId).collect(Collectors.toList()));
      }

      List<MesBuildingMachinePartSeparate> partSeparates = this.mesBuildingMachinePartSeparateService
         .list((Wrapper<MesBuildingMachinePartSeparate>)new LambdaQueryWrapper<MesBuildingMachinePartSeparate>().eq(MesBuildingMachinePartSeparate::getTaskOrderId, id));
      if (CollectionUtils.isNotEmpty(partSeparates)) {
         this.mesBuildingMachinePartSeparateService.removeByIds(partSeparates.stream().map(MesBuildingMachinePartSeparate::getId).collect(Collectors.toList()));
      }

      List<MesBuildingNestCutPlate> cutPlateList = this.mesBuildingNestCutPlateService
         .list((Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>().eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, schedulingId));
      if (CollectionUtils.isNotEmpty(cutPlateList)) {
         List<Long> cutPlateIds = cutPlateList.stream().map(MesBuildingNestCutPlate::getId).collect(Collectors.toList());
         List<MesBuildingNestCutPlatePart> list = this.mesBuildingNestCutPlatePartService
            .list((Wrapper<MesBuildingNestCutPlatePart>)new LambdaQueryWrapper<MesBuildingNestCutPlatePart>().in(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, cutPlateIds));
         if (CollectionUtils.isNotEmpty(list)) {
            this.mesBuildingNestCutPlatePartService.removeByIds(list.stream().map(MesBuildingNestCutPlatePart::getId).collect(Collectors.toList()));
         }

         this.mesBuildingNestCutPlateService.removeByIds(cutPlateIds);
      }

      List<MesBuildingMachinePartSchedulingLink> schedulingLinks = this.machinePartSchedulingLinkService
         .list((Wrapper<MesBuildingMachinePartSchedulingLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingLink>().eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, schedulingId));
      this.machinePartSchedulingLinkService.removeByIds(schedulingLinks.stream().map(MesBuildingMachinePartSchedulingLink::getId).collect(Collectors.toList()));
      this.machinePartSchedulingService.removeById(schedulingId);
      this.taskService.removeByIds(taskList.stream().map(MesBuildingTask::getId).distinct().collect(Collectors.toList()));
   }

   private void nestingPartTaskRevoke(Long id, Long schedulingId) {
      MesBuildingMachinePartScheduling partScheduling = this.machinePartSchedulingService.getById(schedulingId);
      Preconditions.checkArgument(partScheduling != null, "排产记录不存在!");
      List<MesBuildingTask> taskList = this.taskService.list(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getTaskOrderId, id));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskList), "操作失败,零件任务不存在!");
      Preconditions.checkArgument(taskList.stream().allMatch(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())), "操作失败,零件任务不存在!");
      List<Long> productIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
      List<Long> taskIds = taskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList());
      List<MesBuildingProduceTeamReport> produceTeamReports = this.produceTeamReportService
         .list((Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>().in(MesBuildingProduceTeamReport::getTaskId, taskIds));
      Preconditions.checkArgument(CollectionUtils.isEmpty(produceTeamReports), "操作失败,该工单下的零件存在上报记录,无法操作撤回!");
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
         .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskOrderId, id));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskProcessList), "操作失败,零件工序任务不存在!");
      Preconditions.checkArgument(taskProcessList.stream().allMatch(e -> e.getCompleteQuantity() == 0), "操作失败,该工单下的零件存在上报记录,无法操作撤回!");
      taskProcessList.forEach(e -> this.taskProcessService.updateById(e));
      this.taskProcessService.removeByIds(taskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()));
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> artifactTaskLinks = this.mesBuildingMachinePartSchedulingArtifactTaskLinkService
         .list(
            (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
               .eq(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingId, schedulingId)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactTaskLinks), "操作失败,零件排产记录异常!");
      Map<Long, Integer> artifactTaskLinkMap = artifactTaskLinks.stream()
         .collect(
            Collectors.toMap(
               MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId, MesBuildingMachinePartSchedulingArtifactTaskLink::getQuantity, Integer::sum
            )
         );
      List<Long> needIds = artifactTaskLinks.stream().map(MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId).collect(Collectors.toList());
      List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulings = this.needMachinePartSchedulingService.listByIds(needIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskNeedMachinePartSchedulings), "操作失败,零件排产记录异常");
      taskNeedMachinePartSchedulings.forEach(e -> {
         Integer quantity = artifactTaskLinkMap.getOrDefault(e.getId(), 0);
         Preconditions.checkArgument(e.getSchedulingQuantity() >= quantity, "数据异常, 请联系管理员");
         e.setSchedulingQuantity(e.getSchedulingQuantity() - quantity);
      });
      this.needMachinePartSchedulingService.updateBatchById(taskNeedMachinePartSchedulings);
      this.mesBuildingMachinePartSchedulingArtifactTaskLinkService
         .removeByIds(artifactTaskLinks.stream().map(MesBuildingMachinePartSchedulingArtifactTaskLink::getId).collect(Collectors.toList()));
      List<MesBuildingNestCutMachinePartSeparate> cutPartSeparates = this.nestCutMachinePartSeparateService
         .list((Wrapper<MesBuildingNestCutMachinePartSeparate>)new LambdaQueryWrapper<MesBuildingNestCutMachinePartSeparate>().eq(MesBuildingNestCutMachinePartSeparate::getTaskOrderId, id));
      if (CollectionUtils.isNotEmpty(cutPartSeparates)) {
         this.nestCutMachinePartSeparateService
            .removeByIds(cutPartSeparates.stream().map(MesBuildingNestCutMachinePartSeparate::getId).collect(Collectors.toList()));
      }

      List<MesBuildingMachinePartSeparate> partSeparates = this.mesBuildingMachinePartSeparateService
         .list((Wrapper<MesBuildingMachinePartSeparate>)new LambdaQueryWrapper<MesBuildingMachinePartSeparate>().eq(MesBuildingMachinePartSeparate::getTaskOrderId, id));
      if (CollectionUtils.isNotEmpty(partSeparates)) {
         this.mesBuildingMachinePartSeparateService.removeByIds(partSeparates.stream().map(MesBuildingMachinePartSeparate::getId).collect(Collectors.toList()));
      }

      List<MesBuildingNestCutPlate> cutPlateList = this.mesBuildingNestCutPlateService
         .list((Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>().eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, schedulingId));
      if (CollectionUtils.isNotEmpty(cutPlateList)) {
         List<Long> cutPlateIds = cutPlateList.stream().map(MesBuildingNestCutPlate::getId).collect(Collectors.toList());
         List<MesBuildingNestCutPlatePart> list = this.mesBuildingNestCutPlatePartService
            .list((Wrapper<MesBuildingNestCutPlatePart>)new LambdaQueryWrapper<MesBuildingNestCutPlatePart>().in(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, cutPlateIds));
         if (CollectionUtils.isNotEmpty(list)) {
            this.mesBuildingNestCutPlatePartService.removeByIds(list.stream().map(MesBuildingNestCutPlatePart::getId).collect(Collectors.toList()));
         }

         this.mesBuildingNestCutPlateService.removeByIds(cutPlateIds);
      }

      List<MesBuildingMachinePartSchedulingLink> schedulingLinks = this.machinePartSchedulingLinkService
         .list((Wrapper<MesBuildingMachinePartSchedulingLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingLink>().eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, schedulingId));
      this.machinePartSchedulingLinkService.removeByIds(schedulingLinks.stream().map(MesBuildingMachinePartSchedulingLink::getId).collect(Collectors.toList()));
      this.machinePartSchedulingService.removeById(schedulingId);
      this.taskService.removeByIds(taskList.stream().map(MesBuildingTask::getId).distinct().collect(Collectors.toList()));
   }

   public static void deleteFile(String filePath) {
      File file = new File(filePath);
      if (file.isFile()) {
         file.delete();
      } else {
         String[] childFilePath = file.list();

         for (String path : childFilePath) {
            deleteFile(file.getAbsoluteFile() + "/" + path);
         }

         file.delete();
      }
   }

   public List<ProjectDetailDO> findProject(List<MesBuildingMachinePartScheduling> schedulingList) {
      if (schedulingList.size() == 0) {
         return new ArrayList<>();
      }

      List<MesBuildingMachinePartSchedulingLink> schedulingLinkList = this.linkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class)
               .in(
                  MesBuildingMachinePartSchedulingLink::getSchedulingId,
                  schedulingList.stream().map(MesBuildingMachinePartScheduling::getId).collect(Collectors.toList())
               )
         );
      if (schedulingLinkList.size() == 0) {
         return new ArrayList<>();
      }

      List<TechMachinePart> partList = this.machinePartService
         .listByIds(schedulingLinkList.stream().map(MesBuildingMachinePartSchedulingLink::getProductId).distinct().collect(Collectors.toList()));
      return partList.size() == 0
         ? new ArrayList<>()
         : this.projectService
            .listByIds(partList.stream().map(TechMachinePart::getProjectId).collect(Collectors.toList()))
            .stream()
            .map(e -> ProjectDetailDO.builder().id(e.getId()).name(e.getName()).serialNumber(e.getSerialNumber()).shortName(e.getShortName()).build())
            .collect(Collectors.toList());
   }

   public List<ProjectTreeResponseVO> findProjects(List<MesBuildingMachinePartScheduling> schedulingList) {
      List<MesBuildingMachinePartSchedulingLink> schedulingLinkList = this.linkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class)
               .in(
                  MesBuildingMachinePartSchedulingLink::getSchedulingId,
                  schedulingList.stream().map(MesBuildingMachinePartScheduling::getId).collect(Collectors.toList())
               )
         );
      if (schedulingLinkList.size() == 0) {
         return new ArrayList<>();
      }

      List<TechMachinePart> partList = this.machinePartService
         .listByIds(schedulingLinkList.stream().map(MesBuildingMachinePartSchedulingLink::getProductId).distinct().collect(Collectors.toList()));
      if (partList.size() == 0) {
         return new ArrayList<>();
      }

      List<PlanArea> areaList = this.areaService.listByIds(partList.stream().map(TechMachinePart::getAreaId).collect(Collectors.toList()));
      List<ProjectTreeResponseVO> dtoList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(areaList)) {
         Map<Long, List<PlanArea>> areaMap = areaList.stream().collect(Collectors.groupingBy(PlanArea::getMonomerId));
         Set<Long> monomerIds = areaList.stream().map(PlanArea::getMonomerId).collect(Collectors.toSet());
         List<PlanMonomer> monomerList = this.monomerService.listByIds(monomerIds);
         if (CollectionUtils.isNotEmpty(monomerList)) {
            Map<Long, List<PlanMonomer>> monomerMap = monomerList.stream().collect(Collectors.groupingBy(PlanMonomer::getProjectId));
            Set<Long> projectIdList = monomerList.stream().map(PlanMonomer::getProjectId).collect(Collectors.toSet());
            List<ContractProject> projectList = this.projectService
               .list(
                  Wrappers.lambdaQuery(ContractProject.class)
                     .in(projectIdList.size() > 0, ContractProject::getId, projectIdList)
                     .eq(ContractProject::getStatus, ProjectStatusEnum.PROCESSING.getType())
               );
            dtoList = projectList.stream().map(project -> {
               ProjectTreeResponseVO responseVO = BeanUtil.copy(project, ProjectTreeResponseVO.class);
               List<PlanMonomer> planMonomers = monomerMap.get(project.getId());
               List<MonomerTreeResponseVO> monomerVOList = new ArrayList<>();
               planMonomers.forEach(monomer -> {
                  MonomerTreeResponseVO monomerVO = BeanUtil.copy(monomer, MonomerTreeResponseVO.class);
                  List<PlanArea> planAreas = areaMap.get(monomer.getId());
                  List<AreaTreeResponseVO> areaVOList = new ArrayList<>();
                  planAreas.forEach(area -> {
                     AreaTreeResponseVO areaVO = BeanUtil.copy(area, AreaTreeResponseVO.class);
                     areaVOList.add(areaVO);
                  });
                  monomerVO.setChildren(areaVOList);
                  monomerVOList.add(monomerVO);
               });
               responseVO.setChildren(monomerVOList);
               return responseVO;
            }).collect(Collectors.toList());
         }
      }

      return dtoList;
   }

   private Boolean offLineMachineryComplete(MesBuildingMachinePartScheduling scheduling, MesBuildingMachinePartSchedulingDTOParam dtoParam) {
      Map<Long, List<MesBuildingMachinePartSchedulingLinkDTOParam>> productMap = dtoParam.getLinkList()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId));
      List<TechMachinePart> machineParts = this.machinePartService.listByIds(productMap.keySet());
      MesBuildingProductionLine line = this.lineService.getById(dtoParam.getProductionLineId());
      Preconditions.checkArgument(line != null, "产线不存在");
      Map<Long, TechMachinePart> machinePartMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity(), (s1, s2) -> s1));
      List<TechMachinePart> updateList = new ArrayList<>();

      for (Long aLong : productMap.keySet()) {
         TechMachinePart techMachinePart = machinePartMap.get(aLong);
         int sum = productMap.get(aLong).stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum();
         techMachinePart.setProducedQuantity(techMachinePart.getProducedQuantity() + sum);
         techMachinePart.setBoolAbnormalEnum(false);
         updateList.add(techMachinePart);
      }

      this.machinePartService.updateBatchById(updateList);
      Map<String, List<TechMachinePart>> monPartMap = machineParts.stream().collect(Collectors.groupingBy(TechMachinePart::getSerialNumber));
      List<String> problems = new ArrayList<>();
      StringBuilder s = new StringBuilder();

      for (String serialNumber : monPartMap.keySet()) {
         Set<Long> monids = monPartMap.get(serialNumber).stream().map(TechMachinePart::getMonomerId).collect(Collectors.toSet());
         if (monids.size() > 1) {
            problems.add(serialNumber);
            s.append(serialNumber).append(",");
         }
      }

      Preconditions.checkArgument(problems.size() < 1, "排产失败,线下套料不允许出现,跨单体且编号相同的零件!问题编号" + s);
      BigDecimal totalNetWeight = BigDecimal.ZERO;
      int totalQuantity = 0;

      for (TechMachinePart machinePart : machineParts) {
         int sum = productMap.get(machinePart.getId()).stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum();
         totalQuantity += sum;
         totalNetWeight.add(machinePart.getNetWeight().multiply(new BigDecimal(sum)));
      }

      List<MesBuildingMachinePartSchedulingLinkMonth> linkMonths = new ArrayList<>();
      MesBuildingTaskOrder taskOrder = MesBuildingTaskOrder.builder()
         .boolNestCutEnum(true)
         .userId(UserUtil.getCurrentUserId())
         .orderNumber(scheduling.getOrderNumber())
         .quantity(totalQuantity)
         .completeTime(LocalDateTime.now())
         .askCompleteTime(scheduling.getAskCompleteTime())
         .userId(UserUtil.getCurrentUserId())
         .cutConfigId(scheduling.getCutConfigId())
         .schedulingId(scheduling.getId())
         .taskTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
         .build();
      this.taskOrderService.save(taskOrder);
      MesBuildingNestCutPlate nestCutPlate = MesBuildingNestCutPlate.builder()
         .schedulingTime(scheduling.getCreateTime())
         .material(scheduling.getMaterial())
         .thick(new BigDecimal(scheduling.getThick()))
         .weight(totalNetWeight)
         .factoryId(line.getFactoryId())
         .workshopId(line.getWorkshopId())
         .productionLineId(line.getId())
         .userId(UserUtil.getCurrentUserId())
         .issueUserId(UserUtil.getCurrentUserId())
         .cutNumber(scheduling.getOrderNumber() + "-" + 1)
         .schedulingTime(LocalDateTime.now())
         .machinePartSchedulingId(scheduling.getId())
         .askCompleteTime(scheduling.getAskCompleteTime())
         .boolIssueEnum(true)
         .boolNestCutEnum(true)
         .boolOffLine(true)
         .boolBindingEnum(true)
         .boolProductionEunm(true)
         .taskOrderId(taskOrder.getId())
         .build();
      this.nestCutPlateBiz.save(nestCutPlate);
      List<MesBuildingComplete> completes = new ArrayList<>();
      List<MesBuildingNestCutPlatePart> nestCutPlatePartList = new ArrayList<>();
      Map<Long, List<MesBuildingMachinePartSchedulingLinkDTOParam>> scheMap = dtoParam.getLinkList()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId));

      for (Long productId : scheMap.keySet()) {
         TechMachinePart techMachinePart = machinePartMap.get(productId);
         MesBuildingProductProcess productProcess = this.productProcessService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProductProcess.class)
                  .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE)
                  .eq(MesBuildingProductProcess::getProductType, TaskTypeEnum.MACHINE_PART.getType())
            );
         List<MesBuildingMachinePartSchedulingLinkDTOParam> linkDTOParams = scheMap.get(productId);

         for (MesBuildingMachinePartSchedulingLinkDTOParam dto : linkDTOParams) {
            MesBuildingMachinePartSchedulingLinkMonth complete = MesBuildingMachinePartSchedulingLinkMonth.builder().build();
         }

         MesBuildingTask task = MesBuildingTask.builder()
            .factoryId(line.getFactoryId())
            .workshopId(line.getWorkshopId())
            .productionLineId(line.getId())
            .projectId(techMachinePart.getProjectId())
            .monomerId(techMachinePart.getMonomerId())
            .areaId(techMachinePart.getAreaId())
            .productId(techMachinePart.getId())
            .taskTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
            .completeQuantity(linkDTOParams.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
            .completeTime(dtoParam.getAskCompleteTime())
            .machinePartSchedulingId(scheduling.getId())
            .productProcessId(productProcess != null ? productProcess.getId() : null)
            .taskQuantity(linkDTOParams.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
            .inProductionQuantity(linkDTOParams.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
            .askCompleteTime(LocalDateTime.now())
            .inProductionTime(LocalDateTime.now())
            .userId(UserUtil.getCurrentUserId())
            .taskOrderId(taskOrder.getId())
            .boolCompleteEnum(1L)
            .nestCutPlateId(nestCutPlate.getId())
            .completeQuantity(linkDTOParams.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
            .askCompleteTime(dtoParam.getAskCompleteTime())
            .build();
         this.mesBuildingTaskBiz.save(task);
         MesBuildingNestCutPlatePart cutPlatePart = MesBuildingNestCutPlatePart.builder()
            .mesBuildingNestCutPlateId(nestCutPlate.getId())
            .partId(productId)
            .quantity(linkDTOParams.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
            .cutTaskId(nestCutPlate.getCutNumber())
            .taskOrderId(taskOrder.getId())
            .taskId(task.getId() + "")
            .build();
         nestCutPlatePartList.add(cutPlatePart);
         MesBuildingComplete complete = MesBuildingComplete.builder()
            .projectId(techMachinePart.getProjectId())
            .monomerId(techMachinePart.getMonomerId())
            .areaId(techMachinePart.getAreaId())
            .factoryId(line.getFactoryId())
            .workshopId(line.getWorkshopId())
            .productionLineId(line.getId())
            .productId(techMachinePart.getId())
            .quantity(linkDTOParams.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
            .taskTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
            .boolAbnormalEnum(false)
            .taskId(task.getId())
            .userId(UserUtil.getCurrentUserId())
            .build();
         completes.add(complete);
         if (techMachinePart.getBoolSinglePartEnum()) {
            TechArtifactMachinePartLink machinePartLink = this.artifactMachinePartLinkService
               .getOne(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getMachinePartId, techMachinePart.getId()));
            TechArtifact artifact = this.artifactService.getById(machinePartLink.getArtifactId());
            if (!this.utilsBiz.getBoolSinglePartArtifactPaint(artifact, line.getId())) {
               MesBuildingTaskProcess taskProcess = MesBuildingTaskProcess.builder()
                  .factoryId(line.getFactoryId())
                  .workshopId(line.getWorkshopId())
                  .productionLineId(line.getId())
                  .projectId(techMachinePart.getProjectId())
                  .monomerId(techMachinePart.getMonomerId())
                  .areaId(techMachinePart.getAreaId())
                  .taskTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
                  .productId(productId)
                  .taskId(task.getId())
                  .build();
               this.mesBuildingTaskBiz
                  .saveSinglePartArtifactPaint(
                     artifact,
                     taskProcess,
                     linkDTOParams.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum(),
                     null,
                     complete.getId()
                  );
            }
         }

         if (techMachinePart.getBoolAllPartSendDirectly()) {
            List<TechArtifactMachinePartLink> machinePartLinks = this.artifactMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getMachinePartId, techMachinePart.getId()));
            List<TechArtifact> artifacts = this.artifactService
               .listByIds(machinePartLinks.stream().map(TechArtifactMachinePartLink::getArtifactId).collect(Collectors.toList()));
            this.mesBuildingTaskBiz.saveAllSendPartArtifact(task.getId(), task.getCompleteQuantity());
         }

         if (techMachinePart.getBoolSendDirectly() && !techMachinePart.getBoolAllPartSendDirectly()) {
            this.warehouseBiz
               .setStockQuantity(
                  WarehouseSaveDTOParam.builder()
                     .projectId(techMachinePart.getProjectId())
                     .monomerId(techMachinePart.getMonomerId())
                     .completeId(complete.getId())
                     .areaId(techMachinePart.getAreaId())
                     .areaBatchId(techMachinePart.getAreaBatchId())
                     .completeId(complete.getId())
                     .factoryId(line.getFactoryId())
                     .workshopId(line.getWorkshopId())
                     .productId(techMachinePart.getId())
                     .productType(TaskTypeEnum.MACHINE_PART.getType())
                     .type(WarehouseTypeEnum.INTO.getType())
                     .quantity(BigDecimal.valueOf(linkDTOParams.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum()))
                     .build()
               );
         }
      }

      this.nestCutPlatePartService.saveBatch(nestCutPlatePartList);
      this.linkMonthService.saveBatch(linkMonths);
      this.taskOrderBiz.saveMachinePartSeparate(taskOrder.getId());
      this.taskOrderBiz.saveNestCutMachinePartSeparate(taskOrder.getId(), nestCutPlate.getId());
      this.completeService.saveBatch(completes);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Long saveMachinePartNestCutNew(MesBuildingMachinePartSchedulingDTOParam dtoParam) {
      Map<Long, List<MesBuildingMachinePartSchedulingLinkDTOParam>> group = dtoParam.getLinkList()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId));
      Map<Long, Integer> machinePartQuantityMap = new HashMap<>();
      group.forEach(
         (productId, list) -> machinePartQuantityMap.put(productId, list.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
      );
      List<Long> allPartIds = dtoParam.getLinkList()
         .stream()
         .map(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId)
         .distinct()
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(allPartIds)) {
         this.mesBuildingTaskBiz.checkProductStatus(allPartIds, TaskTypeEnum.MACHINE_PART.getType());
      }

      List<TechMachinePart> blockList = this.machinePartService
         .listByIds(machinePartQuantityMap.keySet())
         .stream()
         .filter(s -> s.getProjectId() == 0L)
         .collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(blockList)) {
         Preconditions.checkArgument(!dtoParam.getBoolOffLine(), "线下套料不可选择垫片");
         blockList.forEach(e -> {
            if (e.getQuantity() == null) {
               e.setQuantity(0);
            }

            if (e.getQuantity() == 0) {
               e.setQuantity(machinePartQuantityMap.get(e.getId()));
            } else {
               e.setQuantity(e.getQuantity() + machinePartQuantityMap.get(e.getId()));
            }

            this.machinePartService.updateById(e);
         });
      }

      Long schedulingId = 0L;
      return this.saveNewMachinePartNestCutNew(dtoParam);
   }

   @Transactional(rollbackFor = Exception.class)
   public synchronized Long saveNewMachinePartNestCutNew(MesBuildingMachinePartSchedulingDTOParam dtoParam) {
      Map<Long, BigDecimal> netWeightMap = new HashMap<>();
      AtomicReference<BigDecimal> totalNetWeight = new AtomicReference<>(BigDecimal.ZERO);
      this.machinePartService
         .listByIds(dtoParam.getLinkList().stream().map(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId).collect(Collectors.toList()))
         .forEach(e -> {
            BigDecimal var10000 = netWeightMap.put(e.getId(), e.getNetWeight());
         });
      List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList = dtoParam.getLinkList();
      List<Long> projectIds = linkList.stream().map(MesBuildingMachinePartSchedulingLinkDTOParam::getProjectId).distinct().collect(Collectors.toList());
      String projectName = null;
      if (projectIds.size() == 1) {
         projectName = this.projectService.getById(projectIds.get(0)).getName();
      }

      int cun = this.baseService.passDeleteCount(LocalDateTime.now()) + 1;
      MesBuildingMachinePartScheduling scheduling = MesBuildingMachinePartScheduling.builder()
         .issueStatusEnum(MachinePartSchedulingIssueStatusEnum.NOT_NESTING.getType())
         .material("")
         .thick("")
         .userId(UserUtil.getCurrentUserId())
         .taskStatusEnum(dtoParam.getBoolOffLine() ? 4 : 1)
         .status(Boolean.TRUE)
         .quantity(dtoParam.getLinkList().stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
         .build();
      if (dtoParam.getProductClassificationEnum().equals(ProductClassificationEnum.SECTION_PRODUCT.getType())) {
         scheduling.setOrderNumber("(型)-" + projectName + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-" + cun);
      }

      if (dtoParam.getProductClassificationEnum().equals(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())) {
         scheduling.setOrderNumber(
            projectIds.size() > 1
               ? "(直)-多项目-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-" + cun
               : "(直)-" + projectName + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-" + cun
         );
      }

      if (dtoParam.getBcGuid() != null) {
         scheduling.setBcGuid(dtoParam.getBcGuid());
         scheduling.setJobId(dtoParam.getJobId());
         scheduling.setIssueStatusEnum(MachinePartSchedulingIssueStatusEnum.OUT_NESTING.getType());
         scheduling.setOrderNumber("(套)" + dtoParam.getChildOrderNumber());
      }

      this.save(scheduling);
      Map<Long, List<MesBuildingMachinePartSchedulingLinkDTOParam>> longListMap = dtoParam.getLinkList()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingLinkDTOParam::getProductId));
      longListMap.forEach(
         (productId, list) -> {
            MesBuildingMachinePartSchedulingLink link = MesBuildingMachinePartSchedulingLink.builder()
               .productId(productId)
               .quantity(list.stream().mapToInt(MesBuildingMachinePartSchedulingLinkDTOParam::getQuantity).sum())
               .schedulingId(scheduling.getId())
               .userId(UserUtil.getCurrentUserId())
               .prdRef(scheduling.getOrderNumber() + productId)
               .build();
            this.linkBiz.save(link);
            list.forEach(
               e -> {
                  if (e.getId() != null) {
                     MesBuildingTaskNeedMachinePartScheduling taskNeedMachinePartScheduling = this.taskNeedMachinePartSchedulingBiz.getById(e.getId());
                     MesBuildingMachinePartSchedulingArtifactTaskLink artifactTaskLink = MesBuildingMachinePartSchedulingArtifactTaskLink.builder()
                        .schedulingId(scheduling.getId())
                        .needLinkId(e.getId())
                        .taskId(taskNeedMachinePartScheduling.getTaskId())
                        .quantity(e.getQuantity())
                        .schedulingLinkId(link.getId())
                        .build();
                     this.machinePartSchedulingArtifactTaskLinkBiz.save(artifactTaskLink);
                  }
               }
            );
            totalNetWeight.compareAndSet(
               totalNetWeight.get(), totalNetWeight.get().add(netWeightMap.get(productId).multiply(BigDecimal.valueOf(link.getQuantity().intValue())))
            );
         }
      );
      if (dtoParam.getSaveType() == 2) {
         scheduling.setIssueStatusEnum(
            dtoParam.getBoolOffLine()
               ? MachinePartSchedulingIssueStatusEnum.HAS_BEEN_ISSUED.getType()
               : MachinePartSchedulingIssueStatusEnum.IN_NESTING.getType()
         );
         scheduling.setCutConfigId(dtoParam.getCutConfigId());
         scheduling.setDrillCutConfigId(dtoParam.getDrillCutConfigId());
         scheduling.setNestingTime(LocalDateTime.now());
         scheduling.setOrderNumber(scheduling.getOrderNumber());
         scheduling.setBoolNestCutEnum(Boolean.TRUE);
         scheduling.setAskCompleteTime(dtoParam.getAskCompleteTime());
         scheduling.setTotalNetWeight(totalNetWeight.get());
         this.updateById(scheduling);
         if (!dtoParam.getBoolOffLine()) {
            List<Long> nestCutSchedulingIds = new ArrayList<>();
            nestCutSchedulingIds.add(scheduling.getId());
            ResultVO resultVO = this.nestCutPlateService.uploadJobPart(nestCutSchedulingIds);
            Preconditions.checkArgument("发送成功".equals(resultVO.getData().toString()), "操作失败:下发失败");
         } else {
            Boolean var17 = this.offLineMachineryComplete(scheduling, dtoParam);
         }
      } else {
         Preconditions.checkArgument(!dtoParam.getBoolOffLine(), "无需套料类型,不可进行线下套料");
         scheduling.setIssueStatusEnum(MachinePartSchedulingIssueStatusEnum.IN_NESTING.getType());
         scheduling.setCutConfigId(dtoParam.getCutConfigId());
         scheduling.setNestingTime(LocalDateTime.now());
         scheduling.setOrderNumber(scheduling.getOrderNumber());
         scheduling.setBoolNestCutEnum(Boolean.FALSE);
         scheduling.setAskCompleteTime(dtoParam.getAskCompleteTime());
         scheduling.setTotalNetWeight(totalNetWeight.get());
         this.updateById(scheduling);
         MesBuildingNestCutPlate cutPlate = MesBuildingNestCutPlate.builder()
            .machinePartSchedulingId(scheduling.getId())
            .cutConfigId(dtoParam.getCutConfigId())
            .drillCutConfigId(dtoParam.getDrillCutConfigId())
            .boolNestCutEnum(Boolean.FALSE)
            .boolIssueEnum(Boolean.FALSE)
            .boolProductionEunm(Boolean.FALSE)
            .cutNumber(scheduling.getOrderNumber())
            .material(scheduling.getMaterial())
            .userId(UserUtil.getCurrentUserId())
            .build();
         this.nestCutPlateBiz.save(cutPlate);
         this.linkBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class).eq(MesBuildingMachinePartSchedulingLink::getSchedulingId, scheduling.getId())
            )
            .forEach(
               e -> this.nestCutPlatePartBiz
                  .save(
                     MesBuildingNestCutPlatePart.builder()
                        .mesBuildingNestCutPlateId(cutPlate.getId())
                        .partId(e.getProductId())
                        .quantity(e.getQuantity())
                        .build()
                  )
            );
         List<MesBuildingTaskOrderMachinePartDetailDTOParam> taskOrderParamList = new ArrayList<>();
         Long drillProcessId = dtoParam.getDrillProcessId();
         Long drillProductionLineId = dtoParam.getDrillProductionLineId();
         if (drillProcessId != null && drillProductionLineId != null) {
            MesBuildingTeam mesBuildingTeam = this.mesBuildingTeamService
               .getOne(
                  (Wrapper<MesBuildingTeam>)(new LambdaQueryWrapper<MesBuildingTeam>().eq(MesBuildingTeam::getProcessId, drillProcessId))
                     .eq(MesBuildingTeam::getProductionLineId, drillProductionLineId)
               );
            dtoParam.setDrillTeamId(mesBuildingTeam.getId());
         }

         Preconditions.checkArgument(dtoParam.getCutConfigId() != null, "切割配置id不能为空");
         MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(dtoParam.getCutConfigId());
         MesBuildingMachinePartTeamDetail drillMesBuildingMachinePartTeamDetail = null;
         if (null != dtoParam.getDrillCutConfigId()) {
            drillMesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(dtoParam.getDrillCutConfigId());
         }

         MesBuildingTaskOrderMachinePartDetailDTOParam mesBuildingTaskOrderMachinePartDetailDTOParam = MesBuildingTaskOrderMachinePartDetailDTOParam.builder()
            .groupsId(dtoParam.getGroupsId())
            .cutConfigId(dtoParam.getCutConfigId())
            .prodLineId(mesBuildingMachinePartTeamDetail.getProductionLineId())
            .id(cutPlate.getId())
            .askCompleteTime(dtoParam.getAskCompleteTime())
            .drillGroupsId(dtoParam.getDrillGroupsId())
            .drillTeamId(dtoParam.getDrillTeamId())
            .drillProcessId(dtoParam.getDrillProcessId())
            .drillprodLineId(dtoParam.getDrillProductionLineId())
            .drillAskCompleteTime(dtoParam.getDrillAskCompleteTime())
            .productClassificationEnum(dtoParam.getProductClassificationEnum())
            .build();
         if (null != drillMesBuildingMachinePartTeamDetail) {
            mesBuildingTaskOrderMachinePartDetailDTOParam.setDrillprodLineId(drillMesBuildingMachinePartTeamDetail.getProductionLineId());
            mesBuildingTaskOrderMachinePartDetailDTOParam.setDrillProcessId((long)drillMesBuildingMachinePartTeamDetail.getDeviceType().intValue());
            mesBuildingTaskOrderMachinePartDetailDTOParam.setDrillGroupsId(drillMesBuildingMachinePartTeamDetail.getGroupsId());
            mesBuildingTaskOrderMachinePartDetailDTOParam.setDrillAskCompleteTime(dtoParam.getDrillAskCompleteTime());
            mesBuildingTaskOrderMachinePartDetailDTOParam.setDrillTeamId(drillMesBuildingMachinePartTeamDetail.getGroupsId());
         }

         taskOrderParamList.add(mesBuildingTaskOrderMachinePartDetailDTOParam);
         this.taskOrderBiz.saveArtifactTaskOrder(MesBuildingTaskOrderDTOParam.builder().machinePartDetailList(taskOrderParamList).build(), dtoParam);
      }

      return scheduling.getId();
   }
}
