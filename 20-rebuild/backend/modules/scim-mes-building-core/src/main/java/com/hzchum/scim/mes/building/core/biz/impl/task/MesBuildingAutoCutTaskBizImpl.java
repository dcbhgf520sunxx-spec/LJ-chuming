package com.hzchum.scim.mes.building.core.biz.impl.task;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AreaTreeDTO;
import com.hzchum.scim.common.core.api.pojo.dto.MonomerTreeDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingAutoCutTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CuttingReportMethodEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppTaskOrderProjectTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppTaskOrderSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestTeamConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestingApprove;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestingApproveDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutSchedulingDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutTaskSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPCutTaskProcessDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPSemiAutoCutTaskDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.SemiAutoCutPartDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuJobDirectoryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlateService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestTeamConfigService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestingApproveService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingProduceTeamReportMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingPlateJson;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingPlateJsonService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAutoCutTaskBizImpl implements MesBuildingAutoCutTaskBiz {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAutoCutTaskBizImpl.class);
   @Value("${chum.bochuNestingDiagramPath}")
   private String bochuNestingDiagramPath;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingMapper mesBuildingTaskNeedMachinePartSchedulingMapper;
   @Autowired
   private MesBuildingGroupsBiz groupsBiz;
   @Autowired
   private MesBuildingTaskOrderService mesBuildingTaskOrderService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Autowired
   private TechDrawingService techDrawingService;
   @Autowired
   private UserService userService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingProduceTeamReportMapper mesBuildingProduceTeamReportMapper;
   @Autowired
   private MesBuildingMachinePartSchedulingService mesBuildingMachinePartSchedulingService;
   @Autowired
   private MesBuildingNestCutPlatePartService mesBuildingNestCutPlatePartService;
   @Autowired
   private TechMachinePartService techMachinePartService;
   @Autowired
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Autowired
   private MesBuildingBoChuJobDirectoryService mesBuildingBoChuJobDirectoryService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingService mesBuildingTaskNeedMachinePartSchedulingService;
   @Autowired
   private MesBuildingBoChuNestingResultService mesBuildingBoChuNestingResultService;
   @Autowired
   private MesBuildingNestCutPlateService mesBuildingNestCutPlateService;
   @Autowired
   private MesBuildingProcessService mesBuildingProcessService;
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private MesBuildingNestingApproveService mesBuildingNestingApproveService;
   @Resource
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Value("${chum.config.url}")
   private String ip;
   @Value("${chum.config.filePath}")
   private String nestPath;
   @Autowired
   private MesBuildingNestTeamConfigService mesBuildingNestTeamConfigService;
   @Autowired
   private MesBuildingNestingPlateJsonService mesBuildingNestingPlateJsonService;
   @Autowired
   private MesBuildingProductionLineService mesBuildingProductionLineService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private BasicConfigService basicConfigService;
   @Resource
   private ConfigService configService;

   @Override
   public PageVO<APPAutoCutTaskSummaryDTO> taskOrderPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum,
      String sort,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .filter(projectId == null ? id -> true : id -> id.equals(projectId))
         .collect(Collectors.toList());
      if (projectIds.isEmpty()) {
         return new PageVO<>();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
         List<AppTaskOrderSummaryDO> appTaskOrderSummaryDOS = this.mesBuildingTaskProcessService
            .selectTaskOrderIdListNoGroup(teamIds, projectId, projectIds, monomerId, areaId, null, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum);
         List<MesBuildingProcess> mesBuildingProcessList = this.mesBuildingProcessService.list();
         Map<Long, String> mesBuildingProcessMap = mesBuildingProcessList.stream()
            .collect(Collectors.toMap(MesBuildingProcess::getId, MesBuildingProcess::getName));
         List<APPAutoCutTaskSummaryDTO> appTaskOrderSummaryDTOList = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(appTaskOrderSummaryDOS)) {
            appTaskOrderSummaryDOS.forEach(e -> e.setCutTypeName(mesBuildingProcessMap.get(e.getCutType())));
            appTaskOrderSummaryDOS = appTaskOrderSummaryDOS.stream()
               .filter(item -> item.getOrderNumber() != null && item.getOrderNumber().contains("(套)"))
               .collect(Collectors.toList());
            Map<Long, List<AppTaskOrderSummaryDO>> appTaskOrderSummaryDOSMap = appTaskOrderSummaryDOS.stream()
               .collect(Collectors.groupingBy(AppTaskOrderSummaryDO::getJobId));
            appTaskOrderSummaryDOSMap.forEach(
               (jobId, appTaskOrderSummaryDOList) -> {
                  List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
                     .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
                  if (!CollectionUtils.isEmpty(mesBuildingBoChuJobDirectoryList)) {
                     MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = mesBuildingBoChuJobDirectoryList.get(0);
                     APPAutoCutTaskSummaryDTO appAutoCutTaskSummaryDTO = new APPAutoCutTaskSummaryDTO();
                     appAutoCutTaskSummaryDTO.setProject(appTaskOrderSummaryDOList.get(0).getProject());
                     appAutoCutTaskSummaryDTO.setJobId(jobId);
                     appAutoCutTaskSummaryDTO.setJobName(mesBuildingBoChuJobDirectory.getJobName());
                     appAutoCutTaskSummaryDTO.setUserName(appTaskOrderSummaryDOList.get(0).getUserName());
                     appAutoCutTaskSummaryDTO.setSchedulingDate(mesBuildingBoChuJobDirectory.getCreateTime());
                     List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.mesBuildingTaskNeedMachinePartSchedulingService
                        .list(
                           (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                              .eq(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, jobId)
                        );
                     int completeSum = appTaskOrderSummaryDOList.stream().mapToInt(AppTaskOrderSummaryDO::getCompleteQuantity).sum();
                     int quantitySum = appTaskOrderSummaryDOList.stream().mapToInt(AppTaskOrderSummaryDO::getQuantity).sum();
                     appAutoCutTaskSummaryDTO.setPartQuantity(quantitySum - completeSum);
                     List<String> bcGuidList = appTaskOrderSummaryDOList.stream().map(AppTaskOrderSummaryDO::getBcGuid).collect(Collectors.toList());
                     appAutoCutTaskSummaryDTO.setBuGuids(bcGuidList);
                     List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDTOList = new ArrayList<>();

                     for (AppTaskOrderSummaryDO appTaskOrderSummaryDO : appTaskOrderSummaryDOList) {
                        APPAutoCutSchedulingDetail appAutoCutSchedulingDetail = new APPAutoCutSchedulingDetail();
                        appAutoCutSchedulingDetail.setSchedulingId(appTaskOrderSummaryDO.getSchedulingId());
                        appAutoCutSchedulingDetail.setOrderNumber(appTaskOrderSummaryDO.getOrderNumber());
                        appAutoCutSchedulingDTOList.add(appAutoCutSchedulingDetail);
                     }

                     appAutoCutTaskSummaryDTO.setAppAutoCutSchedulingDetailList(appAutoCutSchedulingDTOList);
                     List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.mesBuildingBoChuNestingResultService
                        .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getJobId, jobId));
                     appAutoCutTaskSummaryDTO.setQuantity(mesBuildingBoChuNestingResultList.size());
                     APPCutTaskProcessDetailDTO appCutTaskProcessDetailDTO = this.numericalControlDetail(appAutoCutTaskSummaryDTO.getJobId(), null, false);
                     MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
                     if (inventoryTypeConfig.getInventoryGainType().equals(2)) {
                        appTaskOrderSummaryDTOList.forEach(e -> e.setApproveState(1));
                     } else {
                        List<MesBuildingNestingApproveDTO> mesBuildingNestingApproveDTOS = this.mesBuildingNestingApproveService.getNestingApprove(jobId, null);
                        if (CollectionUtils.isNotEmpty(mesBuildingNestingApproveDTOS)) {
                           appAutoCutTaskSummaryDTO.setApproveState(1);
                        } else {
                           appAutoCutTaskSummaryDTO.setApproveState(0);
                        }
                     }

                     appTaskOrderSummaryDTOList.add(appAutoCutTaskSummaryDTO);
                  }
               }
            );
         }

         return listPage(pageNumber, pageSize, appTaskOrderSummaryDTOList);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public List<ProjectInfo> existTaskOrderProjectList(Integer taskTypeEnum, Integer machinePartProductionClass) {
      List<ProjectInfo> projectInfoList = new ArrayList<>();
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.isEmpty()) {
         return Collections.emptyList();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (CollUtil.isEmpty(teamList)) {
         return Collections.emptyList();
      }

      List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
      List<AppTaskOrderProjectTreeDO> appTaskOrderSummaryDOS = this.mesBuildingTaskProcessService
         .selectTaskOrderProjectTree(teamIds, null, projectIds, null, null, null, taskTypeEnum, null, null, null);
      switch (machinePartProductionClass) {
         case 1:
            appTaskOrderSummaryDOS = appTaskOrderSummaryDOS.stream()
               .filter(item -> item.getOrderNumber() != null && item.getOrderNumber().contains("(直)"))
               .collect(Collectors.toList());
            break;
         case 2:
            appTaskOrderSummaryDOS = appTaskOrderSummaryDOS.stream()
               .filter(item -> item.getOrderNumber() != null && item.getOrderNumber().contains("(套)"))
               .collect(Collectors.toList());
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            break;
         case 4:
            appTaskOrderSummaryDOS = appTaskOrderSummaryDOS.stream()
               .filter(item -> item.getOrderNumber() != null && item.getOrderNumber().contains("(型)"))
               .collect(Collectors.toList());
            break;
         case 8:
            List<AppTaskOrderProjectTreeDO> appDrillTaskOrderSummaryDOS = this.taskProcessService
               .drillTaskOrderProjectTreeList(null, projectIds, null, null, null, teamIds);
            if (CollectionUtils.isNotEmpty(appDrillTaskOrderSummaryDOS)) {
               appDrillTaskOrderSummaryDOS.stream()
                  .collect(Collectors.groupingBy(AppTaskOrderProjectTreeDO::getProjectId))
                  .forEach(
                     (projectId, taskOrderSummaryDOS) -> {
                        AppTaskOrderProjectTreeDO appTaskOrderProjectTreeDO = taskOrderSummaryDOS.get(0);
                        ProjectInfo projectInfo = ProjectInfo.builder()
                           .id(appTaskOrderProjectTreeDO.getProjectId())
                           .name(appTaskOrderProjectTreeDO.getProjectName())
                           .serialNumber(appTaskOrderProjectTreeDO.getProjectSerialNumber())
                           .shortName(appTaskOrderProjectTreeDO.getProjectShortName())
                           .build();
                        List<MonomerTreeDTO> monomerTreeDTOS = new ArrayList<>();
                        taskOrderSummaryDOS.stream()
                           .collect(Collectors.groupingBy(e -> e.getMonomerId()))
                           .forEach(
                              (monomerId, monomerList) -> {
                                 AppTaskOrderProjectTreeDO monomerDO = monomerList.get(0);
                                 MonomerTreeDTO monomer = MonomerTreeDTO.builder().id(monomerId).name(monomerDO.getMonomerName()).build();
                                 List<AreaTreeDTO> areaTreeDTOS = monomerList.stream()
                                    .map(e -> AreaTreeDTO.builder().id(e.getAreaId()).name(e.getAreaName()).build())
                                    .collect(Collectors.toList());
                                 monomer.setChildren(areaTreeDTOS);
                                 monomerTreeDTOS.add(monomer);
                              }
                           );
                        projectInfo.setChildren(monomerTreeDTOS);
                        projectInfoList.add(projectInfo);
                     }
                  );
            }

            return projectInfoList;
      }

      if (CollectionUtils.isNotEmpty(appTaskOrderSummaryDOS)) {
         appTaskOrderSummaryDOS.stream()
            .collect(Collectors.groupingBy(AppTaskOrderProjectTreeDO::getProjectId))
            .forEach(
               (projectId, taskOrderSummaryDOS) -> {
                  AppTaskOrderProjectTreeDO appTaskOrderProjectTreeDO = taskOrderSummaryDOS.get(0);
                  ProjectInfo projectInfo = ProjectInfo.builder()
                     .id(appTaskOrderProjectTreeDO.getProjectId())
                     .name(appTaskOrderProjectTreeDO.getProjectName())
                     .serialNumber(appTaskOrderProjectTreeDO.getProjectSerialNumber())
                     .shortName(appTaskOrderProjectTreeDO.getProjectShortName())
                     .build();
                  List<MonomerTreeDTO> monomerTreeDTOS = new ArrayList<>();
                  taskOrderSummaryDOS.stream()
                     .collect(Collectors.groupingBy(e -> e.getMonomerId()))
                     .forEach(
                        (monomerId, monomerList) -> {
                           AppTaskOrderProjectTreeDO monomerDO = monomerList.get(0);
                           MonomerTreeDTO monomer = MonomerTreeDTO.builder().id(monomerId).name(monomerDO.getMonomerName()).build();
                           List<AreaTreeDTO> areaTreeDTOS = monomerList.stream()
                              .map(e -> AreaTreeDTO.builder().id(e.getAreaId()).name(e.getAreaName()).build())
                              .collect(Collectors.toList());
                           monomer.setChildren(areaTreeDTOS);
                           monomerTreeDTOS.add(monomer);
                        }
                     );
                  projectInfo.setChildren(monomerTreeDTOS);
                  projectInfoList.add(projectInfo);
               }
            );
      }

      return projectInfoList;
   }

   @Override
   public APPCutTaskProcessDetailDTO numericalControlDetail(Long jobId, List<String> bcGuidList, Boolean boolCheck) {
      List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList = new ArrayList<>();
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = this.mesBuildingBoChuJobDirectoryService
         .getOne((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      List<MesBuildingNestingApproveDTO> mesBuildingNestingApproveDTOS = this.mesBuildingNestingApproveService.getNestingApprove(jobId, null);
      Map<Long, MesBuildingNestingApproveDTO> mesBuildingNestingApproveMap = mesBuildingNestingApproveDTOS.stream()
         .collect(Collectors.toMap(MesBuildingNestingApproveDTO::getSchedulingId, record -> (MesBuildingNestingApproveDTO)record));
      Long projectId = Long.valueOf(mesBuildingBoChuJobDirectory.getProjectId());
      ContractProject project = this.projectService.getById(projectId);
      List<WmsApproveRecord> wmsApproveRecordOKList = this.wmsApproveRecordService
         .list(
            (Wrapper<WmsApproveRecord>)(new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getDataSerialNumber, jobId))
               .eq(WmsApproveRecord::getApproveProcessType, ApproveProcessTypeEnumV2.MES_MACHINE_PART.getType())
         );
      Long approveId = null;
      if (CollectionUtils.isNotEmpty(wmsApproveRecordOKList)) {
         approveId = wmsApproveRecordOKList.get(0).getId();
      }

      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectoryParent = this.mesBuildingBoChuJobDirectoryService
         .getOne(
            (Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, mesBuildingBoChuJobDirectory.getJobId())
         );
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .filter(projectId == null ? id -> true : id -> id.equals(projectId))
         .collect(Collectors.toList());
      if (projectIds.isEmpty()) {
         return new APPCutTaskProcessDetailDTO();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
         List<AppTaskOrderSummaryDO> appTaskOrderSummaryDOS = this.mesBuildingTaskProcessService
            .selectTaskOrderIdListNoGroupJobId(teamIds, null, projectIds, null, null, null, 1, null, null, 0, jobId);
         List<MesBuildingProcess> mesBuildingProcessList = this.mesBuildingProcessService.list();
         Map<Long, String> mesBuildingProcessMap = mesBuildingProcessList.stream()
            .collect(Collectors.toMap(MesBuildingProcess::getId, MesBuildingProcess::getName));
         if (CollectionUtils.isNotEmpty(appTaskOrderSummaryDOS)) {
            appTaskOrderSummaryDOS.forEach(e -> e.setCutTypeName(mesBuildingProcessMap.get(e.getCutType())));
            appTaskOrderSummaryDOS = appTaskOrderSummaryDOS.stream()
               .filter(item -> item.getOrderNumber() != null && item.getOrderNumber().contains("(套)"))
               .collect(Collectors.toList());
            Map<Long, List<AppTaskOrderSummaryDO>> appTaskOrderSummaryDOSMap = appTaskOrderSummaryDOS.stream()
               .collect(Collectors.groupingBy(AppTaskOrderSummaryDO::getJobId));
            appTaskOrderSummaryDOSMap.forEach(
               (jobIdOne, appTaskOrderSummaryDOList) -> {
                  List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
                     .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
                  if (!CollectionUtils.isEmpty(mesBuildingBoChuJobDirectoryList)) {
                     for (AppTaskOrderSummaryDO appTaskOrderSummaryDO : appTaskOrderSummaryDOList) {
                        if (!boolCheck) {
                           if (mesBuildingNestingApproveMap.get(appTaskOrderSummaryDO.getSchedulingId()) == null) {
                              APPAutoCutSchedulingDetail appAutoCutSchedulingDetail = new APPAutoCutSchedulingDetail();
                              appAutoCutSchedulingDetail.setSchedulingId(appTaskOrderSummaryDO.getSchedulingId());
                              appAutoCutSchedulingDetail.setOrderNumber(jobIdOne.toString());
                              appAutoCutSchedulingDetailList.add(appAutoCutSchedulingDetail);
                           }
                        } else if (boolCheck
                           && mesBuildingNestingApproveMap.get(appTaskOrderSummaryDO.getSchedulingId()) != null
                           && mesBuildingNestingApproveMap.get(appTaskOrderSummaryDO.getSchedulingId()).getReviewStatus() == 16) {
                           APPAutoCutSchedulingDetail appAutoCutSchedulingDetail = new APPAutoCutSchedulingDetail();
                           appAutoCutSchedulingDetail.setSchedulingId(appTaskOrderSummaryDO.getSchedulingId());
                           appAutoCutSchedulingDetail.setOrderNumber(jobIdOne.toString());
                           appAutoCutSchedulingDetailList.add(appAutoCutSchedulingDetail);
                        }
                     }
                  }
               }
            );
         }

         List<Long> appSchedulingIdList = appAutoCutSchedulingDetailList.stream().map(APPAutoCutSchedulingDetail::getSchedulingId).collect(Collectors.toList());
         appTaskOrderSummaryDOS = appTaskOrderSummaryDOS.stream()
            .filter(task -> appSchedulingIdList.contains(task.getSchedulingId()))
            .collect(Collectors.toList());
         APPCutTaskProcessDetailDTO appSemiAutoCutTaskProcessDetailDTO = new APPCutTaskProcessDetailDTO();
         appSemiAutoCutTaskProcessDetailDTO.setAppAutoCutSchedulingDetailList(appAutoCutSchedulingDetailList);
         appSemiAutoCutTaskProcessDetailDTO.setOrderNumber(mesBuildingBoChuJobDirectoryParent.getJobName());
         appSemiAutoCutTaskProcessDetailDTO.setJobId(mesBuildingBoChuJobDirectory.getJobId());
         appSemiAutoCutTaskProcessDetailDTO.setProject(
            ProjectInfo.builder().id(project.getId()).name(project.getName()).serialNumber(project.getSerialNumber()).shortName(project.getShortName()).build()
         );
         List<String> bcGuidListAll = appTaskOrderSummaryDOS.stream().map(AppTaskOrderSummaryDO::getBcGuid).collect(Collectors.toList());
         List<String> guidResultList = appTaskOrderSummaryDOS.stream().map(AppTaskOrderSummaryDO::getBcGuid).map(bcGuid -> {
            int lastIndex = bcGuid.lastIndexOf(45);
            return lastIndex != -1 ? bcGuid.substring(0, lastIndex) : bcGuid;
         }).collect(Collectors.toList());
         List<MaterialInventoryDTO> materialInventoryDTOList = this.materialInventoryService.getNumericalControlDetail(guidResultList);
         List<MaterialInventoryDTO> materialInventoryDTOMergeList = mergeAndSumMete(materialInventoryDTOList);
         List<APPAutoCutPlateDTO> appAutoCutPlateDTOList = new ArrayList<>();
         BigDecimal totalNetWeight = new BigDecimal(0);

         for (MaterialInventoryDTO materialInventoryDTO : materialInventoryDTOMergeList) {
            APPAutoCutPlateDTO appAutoCutPlateDTO = new APPAutoCutPlateDTO();
            appAutoCutPlateDTO.setQuantity(materialInventoryDTO.getQuantity());
            appAutoCutPlateDTO.setClassifyName(materialInventoryDTO.getClassifyName());
            appAutoCutPlateDTO.setSpecification(materialInventoryDTO.getSpecification());
            appAutoCutPlateDTO.setMete(materialInventoryDTO.getMete());
            appAutoCutPlateDTO.setWorkshopName(materialInventoryDTO.getWorkshop().getName());
            appAutoCutPlateDTO.setWarehouseName(materialInventoryDTO.getWarehouse().getName());
            appAutoCutPlateDTO.setLength(materialInventoryDTO.getLength());
            appAutoCutPlateDTO.setWidth(materialInventoryDTO.getWidth());
            appAutoCutPlateDTO.setThickness(materialInventoryDTO.getThickness());
            appAutoCutPlateDTO.setSurplusSn(materialInventoryDTO.getSurplusSn());
            appAutoCutPlateDTO.setMaterialIsWhole(materialInventoryDTO.getMaterialIsWhole());
            totalNetWeight = totalNetWeight.add(materialInventoryDTO.getMete());
            appAutoCutPlateDTOList.add(appAutoCutPlateDTO);
         }

         if (null != approveId) {
            WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(approveId);
            appSemiAutoCutTaskProcessDetailDTO.setWmsApproveRecordFlowDTO(wmsApproveRecordFlowDTO);
            appSemiAutoCutTaskProcessDetailDTO.setApproveStatus(1);
         }

         appSemiAutoCutTaskProcessDetailDTO.setTotalNetWeight(totalNetWeight);
         appSemiAutoCutTaskProcessDetailDTO.setTotalQuantity(
            appAutoCutPlateDTOList.stream().map(APPAutoCutPlateDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add).intValue()
         );
         appSemiAutoCutTaskProcessDetailDTO.setAppautoCutPlateDTOList(appAutoCutPlateDTOList);
         return appSemiAutoCutTaskProcessDetailDTO;
      } else {
         return new APPCutTaskProcessDetailDTO();
      }
   }

   @Override
   public APPCutTaskProcessDetailDTO numericalControlDetailSubmit(Long jobId) {
      List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList = new ArrayList<>();
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = this.mesBuildingBoChuJobDirectoryService
         .getOne((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
      Long projectId = Long.valueOf(mesBuildingBoChuJobDirectory.getProjectId());
      ContractProject project = this.projectService.getById(projectId);
      List<MesBuildingNestingApproveDTO> mesBuildingNestingApproveDTOS = this.mesBuildingNestingApproveService.getNestingApprove(jobId, 2);
      Map<Long, MesBuildingNestingApproveDTO> mesBuildingNestingApproveMap = mesBuildingNestingApproveDTOS.stream()
         .collect(Collectors.toMap(MesBuildingNestingApproveDTO::getSchedulingId, record -> (MesBuildingNestingApproveDTO)record));
      Long approveId = null;
      if (CollectionUtils.isNotEmpty(mesBuildingNestingApproveDTOS)) {
         List<WmsApproveRecord> wmsApproveRecordList = this.wmsApproveRecordService
            .list(
               (Wrapper<WmsApproveRecord>)new LambdaQueryWrapper<WmsApproveRecord>()
                  .eq(WmsApproveRecord::getDataId, mesBuildingNestingApproveDTOS.get(0).getWmsApproveRecordId())
            );
         approveId = wmsApproveRecordList.get(0).getId();
      }

      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectoryParent = this.mesBuildingBoChuJobDirectoryService
         .getOne(
            (Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, mesBuildingBoChuJobDirectory.getJobId())
         );
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .filter(projectId == null ? id -> true : id -> id.equals(projectId))
         .collect(Collectors.toList());
      if (projectIds.isEmpty()) {
         return new APPCutTaskProcessDetailDTO();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
         List<AppTaskOrderSummaryDO> appTaskOrderSummaryDOS = this.mesBuildingTaskProcessService
            .selectTaskOrderIdListNoGroupJobId(teamIds, null, projectIds, null, null, null, 1, null, null, 0, jobId);
         List<MesBuildingProcess> mesBuildingProcessList = this.mesBuildingProcessService.list();
         Map<Long, String> mesBuildingProcessMap = mesBuildingProcessList.stream()
            .collect(Collectors.toMap(MesBuildingProcess::getId, MesBuildingProcess::getName));
         if (CollectionUtils.isNotEmpty(appTaskOrderSummaryDOS)) {
            appTaskOrderSummaryDOS.forEach(e -> e.setCutTypeName(mesBuildingProcessMap.get(e.getCutType())));
            appTaskOrderSummaryDOS = appTaskOrderSummaryDOS.stream()
               .filter(item -> item.getOrderNumber() != null && item.getOrderNumber().contains("(套)"))
               .collect(Collectors.toList());
            Map<Long, List<AppTaskOrderSummaryDO>> appTaskOrderSummaryDOSMap = appTaskOrderSummaryDOS.stream()
               .collect(Collectors.groupingBy(AppTaskOrderSummaryDO::getJobId));
            appTaskOrderSummaryDOSMap.forEach(
               (jobIdOne, appTaskOrderSummaryDOList) -> {
                  List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
                     .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
                  if (!CollectionUtils.isEmpty(mesBuildingBoChuJobDirectoryList)) {
                     for (AppTaskOrderSummaryDO appTaskOrderSummaryDO : appTaskOrderSummaryDOList) {
                        if (mesBuildingNestingApproveMap.get(appTaskOrderSummaryDO.getSchedulingId()) != null) {
                           APPAutoCutSchedulingDetail appAutoCutSchedulingDetail = new APPAutoCutSchedulingDetail();
                           appAutoCutSchedulingDetail.setSchedulingId(appTaskOrderSummaryDO.getSchedulingId());
                           appAutoCutSchedulingDetail.setOrderNumber(jobIdOne.toString());
                           appAutoCutSchedulingDetailList.add(appAutoCutSchedulingDetail);
                        }
                     }
                  }
               }
            );
         }

         List<Long> appSchedulingIdList = appAutoCutSchedulingDetailList.stream().map(APPAutoCutSchedulingDetail::getSchedulingId).collect(Collectors.toList());
         appTaskOrderSummaryDOS = appTaskOrderSummaryDOS.stream()
            .filter(task -> appSchedulingIdList.contains(task.getSchedulingId()))
            .collect(Collectors.toList());
         APPCutTaskProcessDetailDTO appSemiAutoCutTaskProcessDetailDTO = new APPCutTaskProcessDetailDTO();
         appSemiAutoCutTaskProcessDetailDTO.setAppAutoCutSchedulingDetailList(appAutoCutSchedulingDetailList);
         appSemiAutoCutTaskProcessDetailDTO.setOrderNumber(mesBuildingBoChuJobDirectoryParent.getJobName());
         appSemiAutoCutTaskProcessDetailDTO.setJobId(mesBuildingBoChuJobDirectory.getJobId());
         appSemiAutoCutTaskProcessDetailDTO.setProject(
            ProjectInfo.builder().id(project.getId()).name(project.getName()).serialNumber(project.getSerialNumber()).shortName(project.getShortName()).build()
         );
         List<String> guidResultList = appTaskOrderSummaryDOS.stream().map(AppTaskOrderSummaryDO::getBcGuid).map(bcGuid -> {
            int lastIndex = bcGuid.lastIndexOf(45);
            return lastIndex != -1 ? bcGuid.substring(0, lastIndex) : bcGuid;
         }).collect(Collectors.toList());
         List<MaterialInventoryDTO> materialInventoryDTOList = this.materialInventoryService.getNumericalControlDetail(guidResultList);
         List<MaterialInventoryDTO> materialInventoryDTOMergeList = mergeAndSumMete(materialInventoryDTOList);
         List<APPAutoCutPlateDTO> appAutoCutPlateDTOList = new ArrayList<>();
         BigDecimal totalNetWeight = new BigDecimal(0);

         for (MaterialInventoryDTO materialInventoryDTO : materialInventoryDTOMergeList) {
            APPAutoCutPlateDTO appAutoCutPlateDTO = new APPAutoCutPlateDTO();
            appAutoCutPlateDTO.setQuantity(materialInventoryDTO.getQuantity());
            appAutoCutPlateDTO.setClassifyName(materialInventoryDTO.getClassifyName());
            appAutoCutPlateDTO.setSpecification(materialInventoryDTO.getSpecification());
            appAutoCutPlateDTO.setMete(materialInventoryDTO.getMete());
            appAutoCutPlateDTO.setWorkshopName(materialInventoryDTO.getWorkshop().getName());
            appAutoCutPlateDTO.setWarehouseName(materialInventoryDTO.getWarehouse().getName());
            appAutoCutPlateDTO.setLength(materialInventoryDTO.getLength());
            appAutoCutPlateDTO.setWidth(materialInventoryDTO.getWidth());
            appAutoCutPlateDTO.setThickness(materialInventoryDTO.getThickness());
            appAutoCutPlateDTO.setSurplusSn(materialInventoryDTO.getSurplusSn());
            appAutoCutPlateDTO.setMaterialIsWhole(materialInventoryDTO.getMaterialIsWhole());
            totalNetWeight = totalNetWeight.add(materialInventoryDTO.getMete());
            appAutoCutPlateDTOList.add(appAutoCutPlateDTO);
         }

         if (null != approveId) {
            WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(approveId);
            appSemiAutoCutTaskProcessDetailDTO.setWmsApproveRecordFlowDTO(wmsApproveRecordFlowDTO);
            appSemiAutoCutTaskProcessDetailDTO.setApproveStatus(8);
         }

         appSemiAutoCutTaskProcessDetailDTO.setTotalNetWeight(totalNetWeight);
         appSemiAutoCutTaskProcessDetailDTO.setTotalQuantity(
            appAutoCutPlateDTOList.stream().map(APPAutoCutPlateDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add).intValue()
         );
         appSemiAutoCutTaskProcessDetailDTO.setAppautoCutPlateDTOList(appAutoCutPlateDTOList);
         return appSemiAutoCutTaskProcessDetailDTO;
      } else {
         return new APPCutTaskProcessDetailDTO();
      }
   }

   @Override
   public APPCutTaskProcessDetailDTO getApproveRecordDetail(Long wmsApproveRecordId) {
      List<MesBuildingNestingApprove> mesBuildingNestingApproveList = this.mesBuildingNestingApproveService
         .list((Wrapper<MesBuildingNestingApprove>)new LambdaQueryWrapper<MesBuildingNestingApprove>().eq(MesBuildingNestingApprove::getWmsApproveRecordId, wmsApproveRecordId));
      APPCutTaskProcessDetailDTO appSemiAutoCutTaskProcessDetailDTO = new APPCutTaskProcessDetailDTO();
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectory = this.mesBuildingBoChuJobDirectoryService
         .getOne(
            (Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>()
               .eq(MesBuildingBoChuJobDirectory::getJobId, mesBuildingNestingApproveList.get(0).getJobId())
         );
      String projectId = mesBuildingBoChuJobDirectory.getProjectId();
      String workshopId = mesBuildingBoChuJobDirectory.getWorkshopId();
      MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(workshopId);
      Preconditions.checkArgument(mesBuildingWorkshop != null, "车间不存在");
      ContractProject contractProject = this.contractProjectService.getById(projectId);
      MesBuildingBoChuJobDirectory mesBuildingBoChuJobDirectoryParent = this.mesBuildingBoChuJobDirectoryService
         .getOne(
            (Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, mesBuildingBoChuJobDirectory.getJobId())
         );
      appSemiAutoCutTaskProcessDetailDTO.setWorkshopId(mesBuildingWorkshop.getId());
      appSemiAutoCutTaskProcessDetailDTO.setWorkshopName(mesBuildingWorkshop.getName());
      appSemiAutoCutTaskProcessDetailDTO.setProjectName(contractProject.getSerialNumber());
      appSemiAutoCutTaskProcessDetailDTO.setProjectId(contractProject.getId());
      appSemiAutoCutTaskProcessDetailDTO.setProject(
         ProjectInfo.builder()
            .id(contractProject.getId())
            .name(contractProject.getName())
            .serialNumber(contractProject.getSerialNumber())
            .shortName(contractProject.getShortName())
            .build()
      );
      appSemiAutoCutTaskProcessDetailDTO.setOrderNumber(mesBuildingBoChuJobDirectoryParent.getJobName());
      appSemiAutoCutTaskProcessDetailDTO.setJobId(mesBuildingBoChuJobDirectory.getJobId());
      List<WmsApproveRecord> wmsApproveRecordOKList = this.wmsApproveRecordService
         .list(
            (Wrapper<WmsApproveRecord>)(new LambdaQueryWrapper<WmsApproveRecord>().eq(WmsApproveRecord::getDataId, wmsApproveRecordId))
               .eq(WmsApproveRecord::getApproveProcessType, ApproveProcessTypeEnumV2.MES_MACHINE_PART.getType())
         );
      if (CollectionUtils.isNotEmpty(wmsApproveRecordOKList)) {
         Long id = wmsApproveRecordOKList.get(0).getId();
         Integer reviewStatus = wmsApproveRecordOKList.get(0).getReviewStatus();
         String serialNumber = wmsApproveRecordOKList.get(0).getSerialNumber();
         appSemiAutoCutTaskProcessDetailDTO.setApproveStatus(reviewStatus);
         WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(id);
         appSemiAutoCutTaskProcessDetailDTO.setWmsApproveRecordFlowDTO(wmsApproveRecordFlowDTO);
         appSemiAutoCutTaskProcessDetailDTO.setSerialNumber(serialNumber);
      } else {
         appSemiAutoCutTaskProcessDetailDTO.setApproveStatus(0);
      }

      List<Long> schedulingIds = mesBuildingNestingApproveList.stream().map(MesBuildingNestingApprove::getSchedulingId).collect(Collectors.toList());
      List<MesBuildingTaskOrder> mesBuildingTaskOrderList = this.mesBuildingTaskOrderService
         .list((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().in(MesBuildingTaskOrder::getSchedulingId, schedulingIds));
      List<String> guidResultList = mesBuildingTaskOrderList.stream().map(MesBuildingTaskOrder::getChildGuid).map(bcGuid -> {
         int lastIndex = bcGuid.lastIndexOf(45);
         return lastIndex != -1 ? bcGuid.substring(0, lastIndex) : bcGuid;
      }).collect(Collectors.toList());
      List<MaterialInventoryDTO> materialInventoryDTOList = this.materialInventoryService.getNumericalControlDetail(guidResultList);
      List<MaterialInventoryDTO> materialInventoryDTOMergeList = mergeAndSumMete(materialInventoryDTOList);
      List<APPAutoCutPlateDTO> appAutoCutPlateDTOList = new ArrayList<>();
      BigDecimal totalNetWeight = new BigDecimal(0);

      for (MaterialInventoryDTO materialInventoryDTO : materialInventoryDTOMergeList) {
         APPAutoCutPlateDTO appAutoCutPlateDTO = new APPAutoCutPlateDTO();
         appAutoCutPlateDTO.setQuantity(materialInventoryDTO.getQuantity());
         appAutoCutPlateDTO.setClassifyName(materialInventoryDTO.getClassifyName());
         appAutoCutPlateDTO.setSpecification(materialInventoryDTO.getSpecification());
         appAutoCutPlateDTO.setMete(materialInventoryDTO.getMete());
         appAutoCutPlateDTO.setWorkshopName(materialInventoryDTO.getWorkshop().getName());
         appAutoCutPlateDTO.setWarehouseName(materialInventoryDTO.getWarehouse().getName());
         appAutoCutPlateDTO.setLength(materialInventoryDTO.getLength());
         appAutoCutPlateDTO.setWidth(materialInventoryDTO.getWidth());
         appAutoCutPlateDTO.setThickness(materialInventoryDTO.getThickness());
         appAutoCutPlateDTO.setSurplusSn(materialInventoryDTO.getSurplusSn());
         appAutoCutPlateDTO.setMaterialIsWhole(materialInventoryDTO.getMaterialIsWhole());
         totalNetWeight = totalNetWeight.add(materialInventoryDTO.getMete());
         appAutoCutPlateDTOList.add(appAutoCutPlateDTO);
      }

      appSemiAutoCutTaskProcessDetailDTO.setTotalNetWeight(totalNetWeight);
      appSemiAutoCutTaskProcessDetailDTO.setTotalQuantity(materialInventoryDTOList.size());
      appSemiAutoCutTaskProcessDetailDTO.setAppautoCutPlateDTOList(appAutoCutPlateDTOList);
      return appSemiAutoCutTaskProcessDetailDTO;
   }

   public static List<MaterialInventoryDTO> mergeAndSumMete(List<MaterialInventoryDTO> materialInventoryDTOList) {
      Map<String, MaterialInventoryDTO> mergedMap = new HashMap<>();
      List<MaterialInventoryDTO> result = new ArrayList<>();

      for (MaterialInventoryDTO dto : materialInventoryDTOList) {
         if (dto.getMaterialIsWhole() == 1 && null != dto.getLength() && null != dto.getThickness() && null != dto.getWidth()) {
            log.info("dto:{}", dto);
            String key = dto.getLength().toString()
               + "_"
               + dto.getThickness().toString()
               + "_"
               + dto.getWidth().toString()
               + "_"
               + dto.getClassifyName()
               + "_"
               + dto.getSpecification();
            if (mergedMap.containsKey(key)) {
               MaterialInventoryDTO existingDTO = mergedMap.get(key);
               existingDTO.setMete(existingDTO.getMete().add(dto.getMete()));
               existingDTO.setQuantity(existingDTO.getQuantity() == null ? BigDecimal.ONE : existingDTO.getQuantity().add(BigDecimal.ONE));
            } else {
               dto.setQuantity(BigDecimal.ONE);
               mergedMap.put(key, dto);
            }
         } else if (dto.getMaterialIsWhole() == 1 && null == dto.getLength() && null == dto.getThickness() && null == dto.getWidth()) {
            log.info("dto:{}", dto);
            String key = dto.getClassifyName() + "_" + dto.getSpecification();
            if (mergedMap.containsKey(key)) {
               MaterialInventoryDTO existingDTO = mergedMap.get(key);
               existingDTO.setMete(existingDTO.getMete().add(dto.getMete()));
               existingDTO.setQuantity(existingDTO.getQuantity() == null ? BigDecimal.ONE : existingDTO.getQuantity().add(BigDecimal.ONE));
            } else {
               dto.setQuantity(BigDecimal.ONE);
               mergedMap.put(key, dto);
            }
         } else if (dto.getMaterialIsWhole() == 2) {
            dto.setQuantity(BigDecimal.ONE);
            result.add(dto);
         }
      }

      result.addAll(mergedMap.values());
      return result;
   }

   @Override
   public APPSemiAutoCutTaskDetailDTO taskOrderDetailTwo(Long taskOrderId) {
      APPSemiAutoCutTaskDetailDTO appSemiAutoCutTaskDetailDTO = new APPSemiAutoCutTaskDetailDTO();
      MesBuildingTaskOrder mesBuildingTaskOrder = this.mesBuildingTaskOrderService.getById(taskOrderId);
      Integer jobId = mesBuildingTaskOrder.getJobId();
      Preconditions.checkArgument(mesBuildingTaskOrder != null, "找不到工单信息");
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList = this.mesBuildingTaskProcessService
         .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskOrderId, taskOrderId));
      Long cutId = null;
      Long projectId = null;
      User user = this.userService.getById(mesBuildingTaskOrder.getUserId());
      if (CollectionUtils.isEmpty(mesBuildingTaskProcessList)) {
         return appSemiAutoCutTaskDetailDTO;
      }

      cutId = mesBuildingTaskProcessList.get(0).getNestCutPlateId();
      projectId = mesBuildingTaskProcessList.get(0).getProjectId();
      ContractProject contractProject = this.contractProjectService.getById(projectId);
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService
         .getById(mesBuildingTaskOrder.getCutConfigId());
      MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(mesBuildingMachinePartTeamDetail.getDeviceType());
      appSemiAutoCutTaskDetailDTO.setCutName(mesBuildingProcess.getName());
      appSemiAutoCutTaskDetailDTO.setOrderNumber(mesBuildingTaskOrder.getOrderNumber());
      appSemiAutoCutTaskDetailDTO.setCompleteTime(mesBuildingTaskOrder.getCompleteTime());
      appSemiAutoCutTaskDetailDTO.setAskCompleteTime(mesBuildingTaskOrder.getAskCompleteTime());
      appSemiAutoCutTaskDetailDTO.setQuantity(mesBuildingTaskOrder.getQuantity());
      appSemiAutoCutTaskDetailDTO.setProjectName(contractProject.getShortName());
      appSemiAutoCutTaskDetailDTO.setProjectNumber(contractProject.getSerialNumber());
      appSemiAutoCutTaskDetailDTO.setUserName(user.getName());
      appSemiAutoCutTaskDetailDTO.setDrillReportMethod(mesBuildingMachinePartTeamDetail.getDrillReportMethod());
      appSemiAutoCutTaskDetailDTO.setCuttingReportMethod(mesBuildingMachinePartTeamDetail.getCuttingReportMethod());
      if (appSemiAutoCutTaskDetailDTO.getCuttingReportMethod().equals(CuttingReportMethodEnum.APP.getCode())) {
         appSemiAutoCutTaskDetailDTO.setBoolCanAppReport(true);
      } else {
         appSemiAutoCutTaskDetailDTO.setBoolCanAppReport(false);
      }

      MesBuildingNestCutPlate mesBuildingNestCutPlate = this.mesBuildingNestCutPlateService
         .list(
            (Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>()
               .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, mesBuildingTaskOrder.getSchedulingId())
         )
         .get(0);
      appSemiAutoCutTaskDetailDTO.setNestCutPlateId(mesBuildingNestCutPlate.getId());
      List<MesBuildingMachineTaskDTO> mesBuildingMachineTaskDTOList = this.mesBuildingTaskOrderService.getMachinePartOffLineAuto(cutId, null, null);
      Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
      if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
         Map<Long, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
            .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getMonomerId));
         listMap.forEach((monomerId, drillingList) -> {
            Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
            Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(monomerId, serialNumberList);
            drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
         });
      }

      if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
         Map<String, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
            .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getAreaId));
         listMap.forEach((areaId, drillingList) -> {
            Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
            Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(Long.valueOf(areaId), serialNumberList);
            drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
         });
      }

      List<SemiAutoCutPartDTO> semiAutoCutPartDTOList = new ArrayList<>();
      Long teamId = mesBuildingMachinePartTeamDetail.getGroupsId();
      Long productionLineId = mesBuildingMachinePartTeamDetail.getProductionLineId();
      MesBuildingProductionLine mesBuildingProductionLine = this.mesBuildingProductionLineService.getById(productionLineId);
      Long workshopId = mesBuildingProductionLine.getWorkshopId();
      MesBuildingNestTeamConfig mesBuildingNestTeamConfig;
      if (null != jobId) {
         List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.mesBuildingTaskNeedMachinePartSchedulingService
            .list(
               (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                     .eq(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, jobId))
                  .isNotNull(MesBuildingTaskNeedMachinePartScheduling::getNestTeamConfigId)
            );
         if (CollectionUtils.isNotEmpty(mesBuildingTaskNeedMachinePartSchedulingList)) {
            Long nestTeamConfigId = mesBuildingTaskNeedMachinePartSchedulingList.get(0).getNestTeamConfigId();
            mesBuildingNestTeamConfig = this.mesBuildingNestTeamConfigService.getById(nestTeamConfigId);
         } else {
            mesBuildingNestTeamConfig = null;
         }
      } else {
         mesBuildingNestTeamConfig = null;
      }

      mesBuildingMachineTaskDTOList.forEach(
         e -> {
            SemiAutoCutPartDTO semiAutoCutPartDTO = SemiAutoCutPartDTO.builder()
               .partNumber(e.getSerialNumber())
               .id(e.getId())
               .partId(e.getPartId())
               .specification(e.getSpecification())
               .quantity(e.getQuantity())
               .completeQuantity(e.getCompleteQuantity())
               .thumbnail(e.getPicturePath())
               .thick(e.getThick())
               .material(e.getMaterial())
               .boolCompleteEnum(e.getBoolCompleteEnum())
               .labelStatus(e.getLabelStatus())
               .build();
            if (null != mesBuildingNestTeamConfig && mesBuildingNestTeamConfig.getBoolShowCodename()) {
               String codeName = mesBuildingNestTeamConfig.getCodeName();
               if (mesBuildingNestTeamConfig.getDisplayRule()) {
                  if (mesBuildingNestTeamConfig.getCodeRule()) {
                     codeName = "-" + codeName;
                  } else {
                     codeName = codeName + "-";
                  }
               } else {
                  codeName = "(" + codeName + ")";
               }

               if (mesBuildingNestTeamConfig.getCodeRule()) {
                  semiAutoCutPartDTO.setPartNumber(semiAutoCutPartDTO.getPartNumber() + codeName);
               } else {
                  semiAutoCutPartDTO.setPartNumber(codeName + semiAutoCutPartDTO.getPartNumber());
               }
            }

            semiAutoCutPartDTOList.add(semiAutoCutPartDTO);
         }
      );
      appSemiAutoCutTaskDetailDTO.setSemiAutoCutPartDTOList(semiAutoCutPartDTOList);
      return appSemiAutoCutTaskDetailDTO;
   }

   @Override
   public List<APPSemiAutoCutTaskDetailDTO> taskOrderDetail(Long jobId) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList == null) {
         return new ArrayList<>();
      }

      List<MesBuildingMachinePartScheduling> mesBuildingMachinePartSchedulingList = this.mesBuildingMachinePartSchedulingService
         .list((Wrapper<MesBuildingMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingMachinePartScheduling>().eq(MesBuildingMachinePartScheduling::getJobId, jobId));
      List<APPSemiAutoCutTaskDetailDTO> appSemiAutoCutTaskDetailDTOList = new ArrayList<>();
      List<Long> cutConfigIdList = mesBuildingMachinePartSchedulingList.stream()
         .map(MesBuildingMachinePartScheduling::getCutConfigId)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, MesBuildingMachinePartTeamDetail> machinePartTeamDetailMap = Optional.ofNullable(cutConfigIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.mesBuildingMachinePartTeamDetailService::listByIds)
         .orElse(Collections.emptyList())
         .stream()
         .collect(Collectors.toMap(MesBuildingMachinePartTeamDetail::getId, Function.identity()));
      List<Long> machinePartSchedulingIdList = mesBuildingMachinePartSchedulingList.stream()
         .map(MesBuildingMachinePartScheduling::getId)
         .collect(Collectors.toList());
      List<MesBuildingTaskOrder> taskOrderList = Optional.ofNullable(machinePartSchedulingIdList)
         .filter(CollUtil::isNotEmpty)
         .map(v -> this.mesBuildingTaskOrderService.list((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().in(MesBuildingTaskOrder::getSchedulingId, v)))
         .orElse(Collections.emptyList());
      Map<Long, List<MesBuildingTaskOrder>> taskOrderBySchedulingIdGroup = taskOrderList.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskOrder::getSchedulingId));
      List<Long> taskOrderIdList = taskOrderList.stream().map(MesBuildingTaskOrder::getId).collect(Collectors.toList());
      Map<Long, List<MesBuildingTaskProcess>> taskProcessByTaskOrderIdGroup = Optional.ofNullable(taskOrderIdList)
         .filter(CollUtil::isNotEmpty)
         .map(
            v -> this.mesBuildingTaskProcessService
               .list(
                  (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getSequence, 0))
                     .in(MesBuildingTaskProcess::getTaskOrderId, v)
               )
         )
         .orElse(Collections.emptyList())
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskOrderId));
      List<Long> taskOrderCutConfigIdList = taskOrderList.stream().map(MesBuildingTaskOrder::getCutConfigId).collect(Collectors.toList());
      Map<Long, MesBuildingMachinePartTeamDetail> taskOrderMachinePartTeamDetailMap = Optional.ofNullable(taskOrderCutConfigIdList)
         .filter(CollUtil::isNotEmpty)
         .map(this.mesBuildingMachinePartTeamDetailService::listByIds)
         .orElse(Collections.emptyList())
         .stream()
         .collect(Collectors.toMap(MesBuildingMachinePartTeamDetail::getId, Function.identity()));
      List<Long> taskOrderSchedulingIdList = taskOrderList.stream().map(MesBuildingTaskOrder::getSchedulingId).collect(Collectors.toList());
      Map<Long, List<MesBuildingNestCutPlate>> nestCutPlateByMachinePartSchedulingIdGroup = Optional.ofNullable(taskOrderSchedulingIdList)
         .filter(CollUtil::isNotEmpty)
         .map(
            v -> this.mesBuildingNestCutPlateService
               .list((Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>().in(MesBuildingNestCutPlate::getMachinePartSchedulingId, v))
         )
         .orElse(Collections.emptyList())
         .stream()
         .collect(Collectors.groupingBy(MesBuildingNestCutPlate::getMachinePartSchedulingId));
      List<String> bcGuidList = mesBuildingMachinePartSchedulingList.stream().map(MesBuildingMachinePartScheduling::getBcGuid).collect(Collectors.toList());
      List<MesBuildingBoChuNestingResult> boChuNestingResultList = Optional.ofNullable(bcGuidList)
         .filter(CollUtil::isNotEmpty)
         .map(
            v -> this.mesBuildingBoChuNestingResultService
               .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().in(MesBuildingBoChuNestingResult::getChildGuid, v))
         )
         .orElse(Collections.emptyList());
      Map<String, List<MesBuildingBoChuNestingResult>> boChuNestingResultByChildGuidGroup = boChuNestingResultList.stream()
         .collect(Collectors.groupingBy(MesBuildingBoChuNestingResult::getChildGuid));
      List<String> guidList = boChuNestingResultList.stream().map(MesBuildingBoChuNestingResult::getGuid).collect(Collectors.toList());
      Map<String, List<MesBuildingNestingPlateJson>> nestingPlateJsonByGuidGroup = Optional.ofNullable(guidList)
         .filter(CollUtil::isNotEmpty)
         .map(
            v -> this.mesBuildingNestingPlateJsonService
               .list(
                  (Wrapper<MesBuildingNestingPlateJson>)(new LambdaQueryWrapper<MesBuildingNestingPlateJson>().eq(MesBuildingNestingPlateJson::getJobId, jobId))
                     .in(MesBuildingNestingPlateJson::getGuid, v)
               )
         )
         .orElse(Collections.emptyList())
         .stream()
         .collect(Collectors.groupingBy(MesBuildingNestingPlateJson::getGuid));
      Map<Long, ContractProject> projectMap = this.projectService.list().stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      Map<Long, MesBuildingProcess> processMap = this.mesBuildingProcessService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      mesBuildingMachinePartSchedulingList.forEach(
         mesBuildingMachinePartScheduling -> {
            Long cutConfigId = mesBuildingMachinePartScheduling.getCutConfigId();
            MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetailTeam = machinePartTeamDetailMap.get(cutConfigId);
            if (teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toSet()).contains(mesBuildingMachinePartTeamDetailTeam.getGroupsId())) {
               APPSemiAutoCutTaskDetailDTO appSemiAutoCutTaskDetailDTO = new APPSemiAutoCutTaskDetailDTO();
               MesBuildingTaskOrder mesBuildingTaskOrder = taskOrderBySchedulingIdGroup.get(mesBuildingMachinePartScheduling.getId()).get(0);
               String bcChildGuid = mesBuildingMachinePartScheduling.getBcGuid();
               appSemiAutoCutTaskDetailDTO.setGuid(bcChildGuid.substring(0, bcChildGuid.lastIndexOf("-")));
               appSemiAutoCutTaskDetailDTO.setCutCount(1);
               MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult = boChuNestingResultByChildGuidGroup.get(bcChildGuid).get(0);
               String bcguid = mesBuildingBoChuNestingResult.getGuid();
               List<MesBuildingNestingPlateJson> mesBuildingNestingPlateJsonList = nestingPlateJsonByGuidGroup.get(bcguid);
               if (CollectionUtils.isNotEmpty(mesBuildingNestingPlateJsonList)) {
                  byte[] plateDrawing = mesBuildingNestingPlateJsonList.get(0).getPlateDrawing();
                  String nestFileNamePath = "nesting" + File.separator + jobId + File.separator;
                  String nestFileName = bcChildGuid + ".png";
                  String allPath = this.nestPath + nestFileNamePath + nestFileName;
                  File outputFile = new File(allPath);

                  try {
                     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(plateDrawing);
                     BufferedImage image = ImageIO.read(byteArrayInputStream);
                     File outputDir = new File(this.nestPath + nestFileNamePath);
                     if (!outputDir.exists()) {
                        if (!outputDir.mkdirs()) {
                           log.info("目标目录创建失败: " + outputDir.getAbsolutePath());
                           return;
                        }

                        log.info("目标目录创建成功: " + outputDir.getAbsolutePath());
                     }

                     if (image != null) {
                        ImageIO.write(image, "PNG", outputFile);
                     } else {
                        log.info("套料图片为空");
                     }
                  } catch (Exception e) {
                     e.printStackTrace();
                     log.info("保存图片时发生错误。");
                  }

                  if (!outputFile.exists()) {
                     String imagePath = StrUtil.indexedFormat(this.bochuNestingDiagramPath, bcguid);
                     appSemiAutoCutTaskDetailDTO.setThumbnailUrl(imagePath);
                  } else {
                     appSemiAutoCutTaskDetailDTO.setThumbnailUrl(this.ip + "files/nesting/" + jobId + "/" + nestFileName);
                  }
               } else {
                  String imagePath = StrUtil.indexedFormat(this.bochuNestingDiagramPath, bcguid);
                  appSemiAutoCutTaskDetailDTO.setThumbnailUrl(imagePath);
               }

               Preconditions.checkArgument(mesBuildingTaskOrder != null, "找不到工单信息");
               List<MesBuildingTaskProcess> mesBuildingTaskProcessList = taskProcessByTaskOrderIdGroup.get(mesBuildingTaskOrder.getId());
               MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = taskOrderMachinePartTeamDetailMap.get(mesBuildingTaskOrder.getCutConfigId());
               Long cutId = null;
               Long projectId = null;
               User user = this.userService.getById(mesBuildingTaskOrder.getUserId());
               if (!CollectionUtils.isEmpty(mesBuildingTaskProcessList)) {
                  MesBuildingTaskProcess mesBuildingTaskProcess = mesBuildingTaskProcessList.get(0);
                  cutId = mesBuildingTaskProcessList.get(0).getNestCutPlateId();
                  projectId = mesBuildingTaskProcessList.get(0).getProjectId();
                  appSemiAutoCutTaskDetailDTO.setId(mesBuildingTaskProcess.getTaskOrderId());
                  appSemiAutoCutTaskDetailDTO.setCompleteTime(mesBuildingTaskProcess.getCompleteTime());
                  ContractProject contractProject = projectMap.get(projectId);
                  MesBuildingProcess mesBuildingProcess = processMap.get((long)mesBuildingMachinePartTeamDetail.getDeviceType().intValue());
                  appSemiAutoCutTaskDetailDTO.setCutName(mesBuildingProcess.getName());
                  appSemiAutoCutTaskDetailDTO.setOrderNumber(
                     mesBuildingTaskOrder.getOrderNumber().substring(0, mesBuildingTaskOrder.getOrderNumber().lastIndexOf("-"))
                  );
                  appSemiAutoCutTaskDetailDTO.setAskCompleteTime(mesBuildingTaskOrder.getAskCompleteTime());
                  appSemiAutoCutTaskDetailDTO.setQuantity(mesBuildingTaskOrder.getQuantity());
                  appSemiAutoCutTaskDetailDTO.setProjectName(contractProject.getShortName());
                  appSemiAutoCutTaskDetailDTO.setProjectNumber(contractProject.getSerialNumber());
                  appSemiAutoCutTaskDetailDTO.setUserName(user.getName());
                  appSemiAutoCutTaskDetailDTO.setDrillReportMethod(mesBuildingMachinePartTeamDetail.getDrillReportMethod());
                  appSemiAutoCutTaskDetailDTO.setCuttingReportMethod(mesBuildingMachinePartTeamDetail.getCuttingReportMethod());
                  if (appSemiAutoCutTaskDetailDTO.getCuttingReportMethod().equals(CuttingReportMethodEnum.APP.getCode())) {
                     appSemiAutoCutTaskDetailDTO.setBoolCanAppReport(true);
                  } else {
                     appSemiAutoCutTaskDetailDTO.setBoolCanAppReport(false);
                  }

                  MesBuildingNestCutPlate mesBuildingNestCutPlate = nestCutPlateByMachinePartSchedulingIdGroup.get(mesBuildingTaskOrder.getSchedulingId())
                     .get(0);
                  appSemiAutoCutTaskDetailDTO.setNestCutPlateId(mesBuildingNestCutPlate.getId());
                  appSemiAutoCutTaskDetailDTO.setMachinePartSchedulingId(mesBuildingNestCutPlate.getMachinePartSchedulingId());
                  appSemiAutoCutTaskDetailDTO.setThickness(mesBuildingBoChuNestingResult.getThickness().toString());
                  appSemiAutoCutTaskDetailDTO.setMaterial(mesBuildingBoChuNestingResult.getMaterial());
                  appSemiAutoCutTaskDetailDTO.setPlateHeight(mesBuildingBoChuNestingResult.getPlateHeight().toString());
                  appSemiAutoCutTaskDetailDTO.setPlateWidth(mesBuildingBoChuNestingResult.getPlateWidth().toString());
                  appSemiAutoCutTaskDetailDTO.setFileNameNest(mesBuildingBoChuNestingResult.getFileNameNest());
                  List<MesBuildingMachineTaskDTO> mesBuildingMachineTaskDTOList = this.mesBuildingTaskOrderService.getMachinePartOffLineAuto(cutId, null, null);
                  Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
                  if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
                     Map<Long, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
                        .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getMonomerId));
                     listMap.forEach((monomerId, drillingList) -> {
                        Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
                        Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(monomerId, serialNumberList);
                        drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
                     });
                  }

                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     Map<String, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
                        .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getAreaId));
                     listMap.forEach((areaId, drillingList) -> {
                        Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
                        Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(Long.valueOf(areaId), serialNumberList);
                        drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
                     });
                  }

                  List<SemiAutoCutPartDTO> semiAutoCutPartDTOList = new ArrayList<>();
                  mesBuildingMachineTaskDTOList.forEach(
                     e -> {
                        if (!e.getBoolCompleteEnum()) {
                           semiAutoCutPartDTOList.add(
                              SemiAutoCutPartDTO.builder()
                                 .partNumber(e.getSerialNumber())
                                 .id(e.getId())
                                 .partId(e.getPartId())
                                 .specification(e.getSpecification())
                                 .completeQuantity(e.getCompleteQuantity())
                                 .quantity(e.getQuantity())
                                 .thumbnail(e.getPicturePath())
                                 .thick(e.getThick())
                                 .material(e.getMaterial())
                                 .boolCompleteEnum(e.getBoolCompleteEnum())
                                 .labelStatus(e.getLabelStatus())
                                 .build()
                           );
                        }
                     }
                  );
                  if (CollectionUtils.isNotEmpty(semiAutoCutPartDTOList)) {
                     appSemiAutoCutTaskDetailDTO.setSemiAutoCutPartDTOList(semiAutoCutPartDTOList);
                     appSemiAutoCutTaskDetailDTOList.add(appSemiAutoCutTaskDetailDTO);
                  }
               }
            }
         }
      );
      List<APPSemiAutoCutTaskDetailDTO> appSemiAutoCutTaskDetailDTOLastList = mergeCutCounts(appSemiAutoCutTaskDetailDTOList);
      MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
      if (inventoryTypeConfig.getInventoryGainType().equals(2)) {
         appSemiAutoCutTaskDetailDTOLastList.forEach(i -> i.setBoolPickingApproved(Boolean.TRUE));
      } else {
         List<MesBuildingNestingApproveDTO> nestingApproveList = this.mesBuildingNestingApproveService.getNestingApprove(jobId, null);
         List<Long> reviewedSchedulingIdList = nestingApproveList.stream()
            .filter(i -> Objects.equals(i.getReviewStatus(), ReviewStatusEnum.REVIEWED.getType()))
            .map(MesBuildingNestingApproveDTO::getSchedulingId)
            .distinct()
            .collect(Collectors.toList());
         appSemiAutoCutTaskDetailDTOLastList.forEach(i -> i.setBoolPickingApproved(reviewedSchedulingIdList.contains(i.getMachinePartSchedulingId())));
      }

      return appSemiAutoCutTaskDetailDTOLastList;
   }

   @Override
   public PageVO<APPSemiAutoCutTaskDetailDTO> taskOrderDetailHistory(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList == null) {
         return new PageVO<>();
      }

      List<APPSemiAutoCutTaskDetailDTO> appSemiAutoCutTaskDetailDTOList = new ArrayList<>();
      List<MesBuildingNestCutPlateDTO> mesBuildingNestCutPlateDTOList = this.mesBuildingProduceTeamReportMapper
         .teamReportNestCutPlateList(startDate, endDate, taskTypeEnum, processType, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toSet()));
      if (CollUtil.isEmpty(mesBuildingNestCutPlateDTOList)) {
         return new PageVO<>();
      }

      Map<Long, List<MesBuildingNestCutPlateDTO>> taskOrderIdMap = mesBuildingNestCutPlateDTOList.stream()
         .collect(Collectors.groupingBy(MesBuildingNestCutPlateDTO::getTaskOrderId));
      Map<Long, MesBuildingTaskOrder> mesBuildingTaskOrderMap = this.mesBuildingTaskOrderService
         .listByIds(taskOrderIdMap.keySet())
         .stream()
         .collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
      List<MesBuildingTaskProcess> allMesBuildingTaskProcessList = this.mesBuildingTaskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskOrderId, taskOrderIdMap.keySet()))
               .eq(MesBuildingTaskProcess::getSequence, 0)
         );
      List<Long> productIdList = allMesBuildingTaskProcessList.stream().map(MesBuildingTaskProcess::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechMachinePart> machinePartMap = this.techMachinePartService
         .listByIds(productIdList)
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      Map<Long, List<MesBuildingTaskProcess>> mesBuildingTaskProcessGroup = allMesBuildingTaskProcessList.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskOrderId));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<Long> cutConfigIdList = mesBuildingTaskOrderMap.values().stream().map(MesBuildingTaskOrder::getCutConfigId).distinct().collect(Collectors.toList());
      Map<Long, MesBuildingMachinePartTeamDetail> machinePartTeamDetailMap = this.mesBuildingMachinePartTeamDetailService
         .listByIds(cutConfigIdList)
         .stream()
         .collect(Collectors.toMap(MesBuildingMachinePartTeamDetail::getId, Function.identity()));
      Map<Long, MesBuildingProcess> processMap = this.mesBuildingProcessService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.contractProjectService
         .list()
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      taskOrderIdMap.forEach(
         (taskOrderId, mesBuildingNestCutPlateDTOList1) -> {
            APPSemiAutoCutTaskDetailDTO appSemiAutoCutTaskDetailDTO = new APPSemiAutoCutTaskDetailDTO();
            MesBuildingTaskOrder mesBuildingTaskOrder = mesBuildingTaskOrderMap.getOrDefault(taskOrderId, new MesBuildingTaskOrder());
            if (mesBuildingTaskOrder.getOrderNumber().contains("(套)")) {
               List<MesBuildingTaskProcess> mesBuildingTaskProcessList = mesBuildingTaskProcessGroup.getOrDefault(taskOrderId, new ArrayList<>());
               Long cutId = null;
               Long projectId = null;
               Integer completeQuantity = 0;
               BigDecimal completeWeight = BigDecimal.ZERO;
               User user = userMap.get(mesBuildingTaskOrder.getUserId());
               if (CollectionUtils.isNotEmpty(mesBuildingTaskProcessList)) {
                  MesBuildingTaskProcess mesBuildingTaskProcess = mesBuildingTaskProcessList.get(0);
                  cutId = mesBuildingTaskProcessList.get(0).getNestCutPlateId();
                  projectId = mesBuildingTaskProcessList.get(0).getProjectId();
                  completeQuantity = mesBuildingTaskProcessList.stream().mapToInt(MesBuildingTaskProcess::getCompleteQuantity).sum();

                  for (int i = 0; i < mesBuildingTaskProcessList.size(); i++) {
                     MesBuildingTaskProcess e = mesBuildingTaskProcessList.get(i);
                     TechMachinePart techMachinePart = machinePartMap.get(e.getProductId());
                     completeWeight = completeWeight.add(techMachinePart.getNetWeight().multiply(new BigDecimal(e.getCompleteQuantity())));
                  }

                  appSemiAutoCutTaskDetailDTO.setId(mesBuildingTaskProcess.getTaskOrderId());
               }

               MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = machinePartTeamDetailMap.get(mesBuildingTaskOrder.getCutConfigId());
               MesBuildingProcess mesBuildingProcess = processMap.get((long)mesBuildingMachinePartTeamDetail.getDeviceType().intValue());
               appSemiAutoCutTaskDetailDTO.setCutName(mesBuildingProcess.getName());
               appSemiAutoCutTaskDetailDTO.setSchedulingDate(mesBuildingTaskOrder.getCreateTime());
               if (null == serialNumber || mesBuildingTaskOrder.getOrderNumber().contains(serialNumber)) {
                  appSemiAutoCutTaskDetailDTO.setOrderNumber(mesBuildingTaskOrder.getOrderNumber());
                  appSemiAutoCutTaskDetailDTO.setCompleteTime(mesBuildingTaskOrder.getCompleteTime());
                  appSemiAutoCutTaskDetailDTO.setAskCompleteTime(mesBuildingTaskOrder.getAskCompleteTime());
                  appSemiAutoCutTaskDetailDTO.setUserName(user.getName());
                  ContractProject contractProject = projectMap.get(projectId);
                  appSemiAutoCutTaskDetailDTO.setProjectName(contractProject.getShortName());
                  appSemiAutoCutTaskDetailDTO.setProjectNumber(contractProject.getSerialNumber());
                  appSemiAutoCutTaskDetailDTO.setQuantity(mesBuildingTaskOrder.getQuantity());
                  appSemiAutoCutTaskDetailDTO.setCompleteQuantity(completeQuantity);
                  appSemiAutoCutTaskDetailDTO.setCompleteWeight(completeWeight);
                  List<SemiAutoCutPartDTO> semiAutoCutPartDTOList = new ArrayList<>();
                  List<MesBuildingMachineTaskDTO> mesBuildingMachineTaskDTOList = this.mesBuildingTaskOrderService.getMachinePartOffLineAuto(cutId, null, null);
                  Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
                  if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
                     Map<Long, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
                        .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getMonomerId));
                     listMap.forEach((monomerId, drillingList) -> {
                        Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
                        Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(monomerId, serialNumberList);
                        drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
                     });
                  }

                  if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
                     Map<String, List<MesBuildingMachineTaskDTO>> listMap = mesBuildingMachineTaskDTOList.stream()
                        .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getAreaId));
                     listMap.forEach((areaId, drillingList) -> {
                        Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
                        Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(Long.valueOf(areaId), serialNumberList);
                        drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
                     });
                  }

                  mesBuildingMachineTaskDTOList.forEach(
                     e -> {
                        if (e.getBoolCompleteEnum()) {
                           semiAutoCutPartDTOList.add(
                              SemiAutoCutPartDTO.builder()
                                 .partNumber(e.getSerialNumber())
                                 .id(e.getId())
                                 .partId(e.getPartId())
                                 .specification(e.getSpecification())
                                 .quantity(e.getQuantity())
                                 .completeQuantity(e.getCompleteQuantity())
                                 .thumbnail(e.getPicturePath())
                                 .thick(e.getThick())
                                 .material(e.getMaterial())
                                 .boolCompleteEnum(e.getBoolCompleteEnum())
                                 .labelStatus(e.getLabelStatus())
                                 .build()
                           );
                        }
                     }
                  );
                  appSemiAutoCutTaskDetailDTO.setSemiAutoCutPartDTOList(semiAutoCutPartDTOList);
                  appSemiAutoCutTaskDetailDTOList.add(appSemiAutoCutTaskDetailDTO);
               }
            }
         }
      );
      return listPage(pageNumber, pageSize, appSemiAutoCutTaskDetailDTOList);
   }

   @Override
   public String updatePartLabelStatus(Long id) {
      MesBuildingNestCutPlatePart mesBuildingNestCutPlatePart = this.mesBuildingNestCutPlatePartService.getById(id);
      if (null != mesBuildingNestCutPlatePart && mesBuildingNestCutPlatePart.getLabelStatus() == 0) {
         mesBuildingNestCutPlatePart.setLabelStatus(1);
         this.mesBuildingNestCutPlatePartService.updateById(mesBuildingNestCutPlatePart);
         return "修改打标状态成功";
      } else {
         return "已打标，无需修改打标状态";
      }
   }

   public static <T> PageVO<T> listPage(Integer pageNum, Integer pageSize, List<T> collect) {
      Page<T> pages = new Page<>(pageNum, pageSize);
      int total = collect.size();
      pages.setTotal(total);
      int startIndex = (pageNum - 1) * pageSize;
      int endIndex = Math.min(startIndex + pageSize, total);
      pages.addAll(collect.subList(startIndex, endIndex));
      return new PageVO<>(pages);
   }

   public static List<APPSemiAutoCutTaskDetailDTO> mergeCutCounts(List<APPSemiAutoCutTaskDetailDTO> taskDetails) {
      Map<String, Integer> cutCountMap = new HashMap<>();

      for (APPSemiAutoCutTaskDetailDTO taskDetail : taskDetails) {
         String guid = taskDetail.getGuid();
         int currentCutCount = taskDetail.getCutCount();
         cutCountMap.put(guid, cutCountMap.getOrDefault(guid, 0) + currentCutCount);
      }

      for (APPSemiAutoCutTaskDetailDTO taskDetail : taskDetails) {
         String guid = taskDetail.getGuid();
         taskDetail.setCutCount(cutCountMap.get(guid));
      }

      return taskDetails.stream()
         .collect(Collectors.toMap(APPSemiAutoCutTaskDetailDTO::getGuid, task -> (APPSemiAutoCutTaskDetailDTO)task, (existing, replacement) -> existing))
         .values()
         .stream()
         .collect(Collectors.toList());
   }
}
