package com.hzchum.scim.mes.building.core.biz.impl.task;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.common.core.api.pojo.dto.IDAndQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.common.core.api.utils.ListPageUtil;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingCutConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingWorkshopBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingArtifactSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkMonthBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlatePartBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingMachinePartSchedulingArtifactTaskLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingMachinePartSeparateBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNestCutMachinePartSeparateBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNewTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingSinglePartArtifactPrintBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskFastBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTopTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.MachinePartSchedulingIssueStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingCutConfigDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingGroupSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.ProjectResponseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductIdAndProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestTeamConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingNestCutMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.MesBuildingTaskOrderDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingCutConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingNeedCompleteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestTeamConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.AddWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingArtifactTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingNumberLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingNumberTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductNumbersDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProgressProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskOrderTrackingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingArtifactSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderArtifactDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderAssembleDetaiDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderMachinePartDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderMatchingDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsTeamLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestTeamConfigService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSinglePartArtifactPrintService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.api.utils.PdfUtil;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNestTeamConfigMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderMapper;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import com.hzchum.scim.plan.core.api.enums.AuxiliaryUsePropertyEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactStandardPartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftProductTaskSaveDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MonomerTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectTreeResponseVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechArtifactStandardPartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechAssembleTypesettingPartLinkService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.CappWeldingCraftUsageModeEnum;
import com.hzchum.scim.system.core.api.enums.SysMatchRangeEnum;
import com.hzchum.scim.system.core.api.pojo.dto.config.CappWeldingCraftConfigDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingTaskOrderBizImpl
   extends IBizImpl<MesBuildingTaskOrderService, MesBuildingTaskOrderMapper, MesBuildingTaskOrder>
   implements MesBuildingTaskOrderBiz {
   @Resource
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Resource
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Autowired
   private MesBuildingArtifactSchedulingBiz artifactSchedulingBiz;
   @Autowired
   private MesBuildingProcessService mesBuildingProcessService;
   @Autowired
   private MesBuildingTeamService mesBuildingTeamService;
   @Autowired
   private MesBuildingMachinePartTeamDetailService machinePartTeamDetailService;
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesBuildingMachinePartSeparateBiz machinePartSeparateBiz;
   @Autowired
   private MesBuildingNestCutMachinePartSeparateBiz nestCutMachinePartSeparateBiz;
   @Autowired
   private MesBuildingMachinePartSchedulingBiz machinePartSchedulingBiz;
   @Autowired
   private MesBuildingMachinePartSchedulingLinkBiz machinePartSchedulingLinkBiz;
   @Autowired
   private MesBuildingMachinePartSchedulingLinkMonthBiz machinePartSchedulingLinkMonthBiz;
   @Resource
   private MesBuildingMachinePartSchedulingArtifactTaskLinkBiz machinePartSchedulingArtifactTaskLinkBiz;
   @Autowired
   private MesBuildingNestCutPlateBiz nestCutPlateBiz;
   @Autowired
   private MesBuildingNestCutPlatePartBiz nestCutPlatePartBiz;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechAssembleExtService assembleExtService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Autowired
   private MesBuildingGroupsBiz groupsBiz;
   @Autowired
   private MesBuildingGroupsService mesBuildingGroupsService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private UserService userService;
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private MesBuildingTaskFastBiz taskFastBiz;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingProductProductionSummaryService productionSummaryService;

   // Task quantity is the month's newly dispatched quantity (see the existing carry-forward formula).
   private void recordNewTaskQuantities(List<MesBuildingTask> tasks) {
      for (MesBuildingTask task : tasks) {
         this.productionSummaryService.updateRecord(ProductProductionSummaryDTOParam.builder()
            .projectId(task.getProjectId()).monomerId(task.getMonomerId()).productId(task.getProductId())
            .productType(task.getTaskTypeEnum()).taskQuantity(task.getTaskQuantity())
            .inProductionQuantity(task.getInProductionQuantity() == null ? 0 : task.getInProductionQuantity())
            .completeQuantity(task.getCompleteQuantity() == null ? 0 : task.getCompleteQuantity()).build());
      }
   }

   @Autowired
   private MesBuildingCutConfigBiz cutConfigBiz;
   @Autowired
   private MesBuildingProductionLineBiz productionLineBiz;
   @Autowired
   private MesBuildingTopTaskOrderBiz topTaskOrderBiz;
   @Autowired
   private TechDrawingService techDrawingService;
   @Autowired
   private MesBuildingWorkshopBiz workshopBiz;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private MesBuildingTaskProcessBiz taskProcessBiz;
   @Resource
   private MesBuildingProcessService processService;
   @Resource
   private TechAssembleTypesettingPartLinkService assembleTypesettingPartLinkService;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingBiz taskNeedMachinePartSchedulingBiz;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingService taskNeedMachinePartSchedulingService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private MesBuildingSinglePartArtifactPrintBiz singlePartArtifactPrintBiz;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private MesBuildingSinglePartArtifactPrintService singlePartArtifactPrintService;
   @Resource
   private MesBuildingProductionLineService lineService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private PlanMonomerService monomerService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private TechArtifactExtService artifactExtService;
   @Resource
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesBuildingArtifactSchedulingService artifactSchedulingService;
   @Autowired
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   @Resource
   private TechArtifactStandardPartLinkService artifactStandardPartLinkService;
   @Resource
   private TechStandardPartService standardPartService;
   @Autowired
   private MesBuildingNewTaskBiz newTaskBiz;
   @Resource
   private PlanAreaBatchService areaBatchService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingGroupsTeamLinkService mesBuildingGroupsTeamLinkService;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingMapper mesBuildingTaskNeedMachinePartSchedulingMapper;
   @Resource
   private TechCappCraftProductTaskBiz cappCraftProductTaskBiz;
   @Resource
   private ConfigService configService;
   @Resource
   private MesBuildingNestTeamConfigService mesBuildingNestTeamConfigService;
   @Resource
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   private MesBuildingNestTeamConfigMapper mesBuildingNestTeamConfigMapper;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveArtifactTaskOrder(MesBuildingTaskOrderDTOParam dtoParam, MesBuildingMachinePartSchedulingDTOParam dtoParamOld) {
      if (dtoParam.getMatchingDetailList() != null && dtoParam.getMatchingDetailList().size() > 0) {
         List<MesBuildingArtifactScheduling> schedulingList = this.artifactSchedulingBiz
            .listByIds(
               dtoParam.getArtifactSchedulingList().stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getSchedulingId).collect(Collectors.toList())
            );
         Optional<LocalDateTime> askCompleteTime = schedulingList.stream().map(MesBuildingArtifactScheduling::getAskCompleteTime).max(LocalDateTime::compareTo);
         List<MesBuildingTaskOrderMatchingDTOParam> addSchedulingList = dtoParam.getMatchingDetailList()
            .stream()
            .filter(e -> e.getSchedulingId() == null)
            .collect(Collectors.toList());
         List<MesBuildingTaskOrderMatchingDTOParam> updateSchedulingList = dtoParam.getMatchingDetailList()
            .stream()
            .filter(e -> e.getSchedulingId() != null)
            .collect(Collectors.toList());
         Map<Long, Integer> addIdAndQuantityMap = new HashMap<>();
         if (addSchedulingList.size() > 0) {
            addIdAndQuantityMap.putAll(
               this.saveArtifactSchedulingList(
                  addSchedulingList.stream()
                     .map(
                        e -> MesBuildingArtifactSchedulingDTOParam.builder()
                           .productId(e.getProductId())
                           .quantity(e.getQuantity())
                           .groupsId(e.getGroupsId())
                           .askCompleteTime(askCompleteTime.get())
                           .build()
                     )
                     .collect(Collectors.toList())
               )
            );
         }

         Map<Long, Integer> updateIdAndQuantityMap = new HashMap<>();
         if (updateSchedulingList.size() > 0) {
            List<Long> ids = this.artifactSchedulingBiz
               .list(
                  Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                     .eq(MesBuildingArtifactScheduling::getGroupsId, dtoParam.getArtifactSchedulingList().get(0).getGroupsId())
                     .in(
                        MesBuildingArtifactScheduling::getId,
                        updateSchedulingList.stream().map(MesBuildingTaskOrderMatchingDTOParam::getSchedulingId).collect(Collectors.toList())
                     )
               )
               .stream()
               .map(MesBuildingArtifactScheduling::getId)
               .collect(Collectors.toList());
            dtoParam.getArtifactSchedulingList()
               .addAll(
                  updateSchedulingList.stream()
                     .filter(e -> ids.contains(e.getSchedulingId()))
                     .map(
                        e -> MesBuildingTaskOrderArtifactDetailDTOParam.builder()
                           .schedulingId(e.getSchedulingId())
                           .quantity(e.getQuantity())
                           .groupsId(e.getGroupsId())
                           .build()
                     )
                     .collect(Collectors.toList())
               );
            if (updateSchedulingList.stream().anyMatch(e -> !ids.contains(e.getSchedulingId()))) {
               this.updateArtifactScheduling(
                     updateSchedulingList.stream()
                        .filter(e -> !ids.contains(e.getSchedulingId()))
                        .map(
                           e -> MesBuildingArtifactSchedulingDTOParam.builder()
                              .id(e.getSchedulingId())
                              .quantity(e.getQuantity())
                              .groupsId(e.getGroupsId())
                              .build()
                        )
                        .collect(Collectors.toList())
                  )
                  .forEach(updateIdAndQuantityMap::put);
            }
         }

         addIdAndQuantityMap.putAll(updateIdAndQuantityMap);
         dtoParam.getArtifactSchedulingList().forEach(e -> {
            if (updateIdAndQuantityMap.get(e.getSchedulingId()) != null) {
               e.setQuantity(e.getQuantity() + updateIdAndQuantityMap.get(e.getSchedulingId()));
               updateIdAndQuantityMap.remove(e.getSchedulingId());
            }
         });
         addIdAndQuantityMap.forEach(
            (a, b) -> dtoParam.getArtifactSchedulingList()
               .add(MesBuildingTaskOrderArtifactDetailDTOParam.builder().groupsId(schedulingList.get(0).getGroupsId()).schedulingId(a).quantity(b).build())
         );
      }

      return this.saveTaskOrderList(dtoParam, dtoParamOld);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveArtifactTaskOrder2(MesBuildingTaskOrderDTOParam dtoParam) {
      if (CollectionUtils.isNotEmpty(dtoParam.getArtifactSchedulingList())) {
         List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactSchedulingList = dtoParam.getArtifactSchedulingList();
         List<Long> schedulingIds = dtoParam.getArtifactSchedulingList()
            .stream()
            .map(MesBuildingTaskOrderArtifactDetailDTOParam::getSchedulingId)
            .collect(Collectors.toList());
         List<MesBuildingArtifactScheduling> schedulings = this.artifactSchedulingBiz.listByIds(schedulingIds);
         Map<Long, MesBuildingArtifactScheduling> schedulingMap = schedulings.stream()
            .collect(Collectors.toMap(MesBuildingArtifactScheduling::getId, Function.identity()));
         if (CollectionUtils.isNotEmpty(dtoParam.getAssembleDetailList())) {
            List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleDetailList = dtoParam.getAssembleDetailList()
               .stream()
               .filter(MesBuildingTaskOrderAssembleDetaiDTOParam::getBoolProcess)
               .filter(e -> e.getAskCompleteTime() != null)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(assembleDetailList)) {
               LocalDateTime assembleLocalDateTime = assembleDetailList.stream()
                  .map(MesBuildingTaskOrderAssembleDetaiDTOParam::getAskCompleteTime)
                  .sorted(LocalDateTime::compareTo)
                  .collect(Collectors.toList())
                  .get(assembleDetailList.size() - 1);
               LocalDateTime artifactLocalDateTime = schedulings.stream()
                  .map(MesBuildingArtifactScheduling::getAskCompleteTime)
                  .sorted(LocalDateTime::compareTo)
                  .collect(Collectors.toList())
                  .get(0);
               Preconditions.checkArgument(artifactLocalDateTime.compareTo(assembleLocalDateTime) >= 0, "部件的要求完成日期不可超过构件的要求完成日期");
            }
         }

         List<MesBuildingTaskOrderAssembleDetaiDTOParam> checkAssembleDetaiDTOParamList = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(dtoParam.getAssembleDetailList())) {
            checkAssembleDetaiDTOParamList.addAll(dtoParam.getAssembleDetailList());
         }

         if (CollectionUtils.isNotEmpty(dtoParam.getPrunedList())) {
            checkAssembleDetaiDTOParamList.addAll(dtoParam.getPrunedList());
         }

         if (CollectionUtils.isNotEmpty(checkAssembleDetaiDTOParamList)) {
         }
      }

      if (dtoParam.getMatchingDetailList() != null && dtoParam.getMatchingDetailList().size() > 0) {
         List<MesBuildingArtifactScheduling> schedulingList = this.artifactSchedulingBiz
            .listByIds(
               dtoParam.getArtifactSchedulingList().stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getSchedulingId).collect(Collectors.toList())
            );
         Optional<LocalDateTime> askCompleteTime = schedulingList.stream().map(MesBuildingArtifactScheduling::getAskCompleteTime).max(LocalDateTime::compareTo);
         List<MesBuildingTaskOrderMatchingDTOParam> addSchedulingList = dtoParam.getMatchingDetailList()
            .stream()
            .filter(e -> e.getSchedulingId() == null)
            .collect(Collectors.toList());
         List<MesBuildingTaskOrderMatchingDTOParam> updateSchedulingList = dtoParam.getMatchingDetailList()
            .stream()
            .filter(e -> e.getSchedulingId() != null)
            .collect(Collectors.toList());
         Map<Long, Integer> addIdAndQuantityMap = new HashMap<>();
         if (addSchedulingList.size() > 0) {
            addIdAndQuantityMap.putAll(
               this.saveArtifactSchedulingList2(
                  addSchedulingList.stream()
                     .map(
                        e -> MesBuildingArtifactSchedulingDTOParam.builder()
                           .productId(e.getProductId())
                           .quantity(e.getQuantity())
                           .productionLineId(e.getProdLineId())
                           .askCompleteTime(askCompleteTime.get())
                           .build()
                     )
                     .collect(Collectors.toList())
               )
            );
         }

         Map<Long, Integer> updateIdAndQuantityMap = new HashMap<>();
         if (updateSchedulingList.size() > 0) {
            List<Long> ids = this.artifactSchedulingBiz
               .list(
                  Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                     .eq(MesBuildingArtifactScheduling::getProductionLineId, dtoParam.getArtifactSchedulingList().get(0).getProdLineId())
                     .in(
                        MesBuildingArtifactScheduling::getId,
                        updateSchedulingList.stream().map(MesBuildingTaskOrderMatchingDTOParam::getSchedulingId).collect(Collectors.toList())
                     )
               )
               .stream()
               .map(MesBuildingArtifactScheduling::getId)
               .collect(Collectors.toList());
            dtoParam.getArtifactSchedulingList()
               .addAll(
                  updateSchedulingList.stream()
                     .filter(e -> ids.contains(e.getSchedulingId()))
                     .map(
                        e -> MesBuildingTaskOrderArtifactDetailDTOParam.builder()
                           .schedulingId(e.getSchedulingId())
                           .quantity(e.getQuantity())
                           .prodLineId(e.getProdLineId())
                           .build()
                     )
                     .collect(Collectors.toList())
               );
            if (updateSchedulingList.stream().anyMatch(e -> !ids.contains(e.getSchedulingId()))) {
               this.updateArtifactScheduling(
                     updateSchedulingList.stream()
                        .filter(e -> !ids.contains(e.getSchedulingId()))
                        .map(
                           e -> MesBuildingArtifactSchedulingDTOParam.builder()
                              .id(e.getSchedulingId())
                              .quantity(e.getQuantity())
                              .productionLineId(e.getProdLineId())
                              .build()
                        )
                        .collect(Collectors.toList())
                  )
                  .forEach(updateIdAndQuantityMap::put);
            }
         }

         addIdAndQuantityMap.putAll(updateIdAndQuantityMap);
         dtoParam.getArtifactSchedulingList().forEach(e -> {
            if (updateIdAndQuantityMap.get(e.getSchedulingId()) != null) {
               e.setQuantity(e.getQuantity() + updateIdAndQuantityMap.get(e.getSchedulingId()));
               updateIdAndQuantityMap.remove(e.getSchedulingId());
            }
         });
         addIdAndQuantityMap.forEach(
            (a, b) -> dtoParam.getArtifactSchedulingList()
               .add(
                  MesBuildingTaskOrderArtifactDetailDTOParam.builder()
                     .prodLineId(schedulingList.get(0).getProductionLineId())
                     .schedulingId(a)
                     .quantity(b)
                     .build()
               )
         );
      }

      return this.saveTaskOrderList2(dtoParam);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveTaskOrderList(MesBuildingTaskOrderDTOParam dtoParam, MesBuildingMachinePartSchedulingDTOParam dtoParamOld) {
      List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactTasks = dtoParam.getArtifactSchedulingList();
      if (artifactTasks != null) {
         Map<Long, Integer> taskQuantityMap = artifactTasks.stream()
            .collect(Collectors.toMap(MesBuildingTaskOrderArtifactDetailDTOParam::getSchedulingId, MesBuildingTaskOrderArtifactDetailDTOParam::getQuantity));
         List<Long> schedulingIds = artifactTasks.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getSchedulingId).collect(Collectors.toList());
         List<MesBuildingArtifactScheduling> schedulings = this.artifactSchedulingBiz.listByIds(schedulingIds);
         Preconditions.checkArgument(schedulings.size() == schedulingIds.size(), "操作失败!!请刷新页面后重试");
         schedulings.forEach(s -> s.setTaskQuantity(s.getTaskQuantity() + taskQuantityMap.get(s.getId())));
         Preconditions.checkArgument(schedulings.stream().noneMatch(s -> s.getTaskQuantity() > s.getQuantity()), "操作失败!!!构件任务下发数不可大于排产数!!!");
         this.artifactSchedulingService.updateBatchById(schedulings);
         Map<Long, MesBuildingArtifactScheduling> schedulingMap = schedulings.stream()
            .collect(Collectors.toMap(MesBuildingArtifactScheduling::getId, Function.identity()));

         for (MesBuildingTaskOrderArtifactDetailDTOParam artifactTask : artifactTasks) {
            artifactTask.setProductId(schedulingMap.get(artifactTask.getSchedulingId()).getProductId());
            artifactTask.setAskCompleteTime(schedulingMap.get(artifactTask.getSchedulingId()).getAskCompleteTime());
         }
      }

      List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleTasks = dtoParam.getAssembleDetailList();
      List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartTasks = dtoParam.getMachinePartDetailList();
      this.saveTaskOrderList(artifactTasks, assembleTasks, machinePartTasks, dtoParam.getProductionLineTypeEnum(), dtoParamOld);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveTaskOrderList2(MesBuildingTaskOrderDTOParam dtoParam) {
      List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactTasks = dtoParam.getArtifactSchedulingList();
      if (artifactTasks != null) {
         Map<Long, Integer> taskQuantityMap = artifactTasks.stream()
            .collect(Collectors.toMap(MesBuildingTaskOrderArtifactDetailDTOParam::getSchedulingId, MesBuildingTaskOrderArtifactDetailDTOParam::getQuantity));
         List<Long> schedulingIds = artifactTasks.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getSchedulingId).collect(Collectors.toList());
         List<MesBuildingArtifactScheduling> schedulings = this.artifactSchedulingBiz.listByIds(schedulingIds);
         Preconditions.checkArgument(schedulings.size() == schedulingIds.size(), "操作失败!!请刷新页面后重试");
         schedulings.forEach(s -> {
            s.setTaskQuantity(s.getTaskQuantity() + taskQuantityMap.get(s.getId()));
            s.setIssueStatus(Boolean.TRUE);
         });
         Preconditions.checkArgument(schedulings.stream().noneMatch(s -> s.getTaskQuantity() > s.getQuantity()), "操作失败!!!构件任务下发数不可大于排产数!!!");
         this.artifactSchedulingService.updateBatchById(schedulings);
         Map<Long, MesBuildingArtifactScheduling> schedulingMap = schedulings.stream()
            .collect(Collectors.toMap(MesBuildingArtifactScheduling::getId, Function.identity()));

         for (MesBuildingTaskOrderArtifactDetailDTOParam artifactTask : artifactTasks) {
            artifactTask.setProductId(schedulingMap.get(artifactTask.getSchedulingId()).getProductId());
            artifactTask.setAskCompleteTime(schedulingMap.get(artifactTask.getSchedulingId()).getAskCompleteTime());
            artifactTask.setAreaId(schedulingMap.get(artifactTask.getSchedulingId()).getAreaId());
            artifactTask.setAreaBatchId(schedulingMap.get(artifactTask.getSchedulingId()).getAreaBatchId());
         }
      }

      List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleTasks = dtoParam.getAssembleDetailList();
      if (CollectionUtils.isNotEmpty(dtoParam.getPrunedList())) {
         List<TechAssemble> noMainAssembles = this.assembleService
            .listByIds(dtoParam.getPrunedList().stream().map(MesBuildingTaskOrderAssembleDetaiDTOParam::getProductId).collect(Collectors.toList()));
         List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedMap = dtoParam.getPrunedList()
            .stream()
            .map(s -> s.setBoolProcess(Boolean.FALSE))
            .collect(Collectors.toList());
         assembleTasks.addAll(prunedMap);
      }

      if (CollectionUtils.isNotEmpty(assembleTasks)) {
         List<Long> assIds = assembleTasks.stream().map(MesBuildingTaskOrderAssembleDetaiDTOParam::getProductId).collect(Collectors.toList());
         Map<Long, Long> assAreaMap = this.assembleService
            .listByIds(assIds)
            .stream()
            .collect(Collectors.toMap(TechAssemble::getId, TechAssemble::getAreaBatchId));
         assembleTasks.forEach(e -> e.setAreaBatchId(assAreaMap.get(e.getProductId())));
      }

      List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartTasks = dtoParam.getMachinePartDetailList();
      this.saveTaskOrderList2(artifactTasks, assembleTasks, machinePartTasks, dtoParam.getPrunedList(), dtoParam.getInputOrderNumber());
      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingTaskOrderDTO> getTaskOrderList(MesBuildingTaskOrderDTOParam dtoParam) {
      return this.baseService
         .getTaskOrderList(BeanUtil.copy(dtoParam, MesBuildingTaskOrderDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingTaskOrderDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<MesBuildingTaskOrderDTO> getTaskOrderPage(MesBuildingTaskOrderDTOParam dtoParam, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getTaskOrderList(dtoParam));
   }

   @Override
   public PageVO<MesBuildingArtifactTaskOrderDTO> getArtifactsTaskPage(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      List<Long> areaBatchIds,
      String serialNumber,
      Integer taskType,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String orderNumber,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> assembleIds = new ArrayList<>();
      if (taskType == null || taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssemble> assembleList = this.assembleService
            .list(
               Wrappers.lambdaQuery(TechAssemble.class)
                  .in(projectIds != null, TechAssemble::getProjectId, projectIds)
                  .in(monomerIds != null, TechAssemble::getMonomerId, monomerIds)
                  .in(areaIds != null, TechAssemble::getAreaId, areaIds)
                  .in(CollectionUtils.isNotEmpty(areaBatchIds), TechAssemble::getAreaBatchId, areaBatchIds)
            );
         assembleIds = assembleList.stream().map(TechAssemble::getId).distinct().collect(Collectors.toList());
         if (CollectionUtils.isEmpty(assembleIds)) {
            return new PageVO<>();
         }
      }

      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingArtifactTaskOrderDTO> collect;
      if (taskType != null) {
         collect = this.baseService
            .getArtifactsTaskList(
               projectIds,
               monomerIds,
               areaIds,
               areaBatchIds,
               serialNumber,
               taskType,
               printType,
               workshopId,
               localDateTime,
               orderNumber,
               assembleIds,
               startDate,
               endDate
            )
            .stream()
            .map(e -> BeanUtil.copy(e, MesBuildingArtifactTaskOrderDTO.class))
            .collect(Collectors.toList());
      } else {
         collect = this.baseMapper
            .getAllArtifactsTaskList(
               projectIds, monomerIds, areaIds, areaBatchIds, serialNumber, printType, workshopId, localDateTime, orderNumber, assembleIds, startDate, endDate
            )
            .stream()
            .map(e -> BeanUtil.copy(e, MesBuildingArtifactTaskOrderDTO.class))
            .collect(Collectors.toList());
      }

      return new PageVO<>(page, collect);
   }

   @Override
   public List<MesBuildingArtifactTaskOrderDTO> getArtifactsTaskList(
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      Integer taskType,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String orderNumber,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      List<Long> assembleIds = new ArrayList<>();
      if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssemble> assembleList = this.assembleService
            .list(
               Wrappers.lambdaQuery(TechAssemble.class)
                  .in(projectIds != null, TechAssemble::getProjectId, projectIds)
                  .in(monomerIds != null, TechAssemble::getMonomerId, monomerIds)
                  .in(areaIds != null, TechAssemble::getAreaId, areaIds)
            );
         assembleIds = assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList());
      }

      return this.baseService
         .getArtifactsTaskList(
            projectIds, monomerIds, areaIds, null, null, taskType, printType, workshopId, localDateTime, orderNumber, assembleIds, startDate, endDate
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactTaskOrderDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<TaskOrderTrackingDTO> taskTrackMachinePartPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer taskType,
      Integer status,
      String orderNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> partIdList = new ArrayList<>();
      if (projectId != null) {
         partIdList = this.machinePartService
            .list(
               Wrappers.lambdaQuery(TechMachinePart.class)
                  .eq(TechMachinePart::getProjectId, projectId)
                  .eq(monomerId != null, TechMachinePart::getMonomerId, monomerId)
                  .eq(areaId != null, TechMachinePart::getAreaId, areaId)
                  .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
            )
            .stream()
            .map(TechMachinePart::getId)
            .collect(Collectors.toList());
         if (partIdList.size() == 0) {
            return new PageVO<>();
         }
      }

      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<TaskOrderTrackingDTO> dtoList = this.baseService
         .taskTrackMachinePart(dateTime, workshopId, productionLineId, partIdList, taskType, status, orderNumber)
         .stream()
         .map(e -> {
            e.setRate(new BigDecimal(e.getCompleteQuantity()).divide(new BigDecimal(e.getTotalQuantity()), 2, 4));
            return BeanUtil.copy(e, TaskOrderTrackingDTO.class);
         })
         .collect(Collectors.toList());
      dtoList.sort(Comparator.comparing(TaskOrderTrackingDTO::getRate));
      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<TaskOrderTrackingDTO> taskTrackMachinePart(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer taskType,
      Integer status,
      String orderNumber
   ) {
      List<Long> partIdList = new ArrayList<>();
      if (projectId != null) {
         partIdList = this.machinePartService
            .list(
               Wrappers.lambdaQuery(TechMachinePart.class)
                  .eq(TechMachinePart::getProjectId, projectId)
                  .eq(monomerId != null, TechMachinePart::getMonomerId, monomerId)
                  .eq(areaId != null, TechMachinePart::getAreaId, areaId)
                  .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
            )
            .stream()
            .map(TechMachinePart::getId)
            .collect(Collectors.toList());
         if (partIdList.size() == 0) {
            return new ArrayList<>();
         }
      }

      List<TaskOrderTrackingDTO> dtoList = this.baseService
         .taskTrackMachinePart(dateTime, workshopId, productionLineId, partIdList, taskType, status, orderNumber)
         .stream()
         .map(e -> {
            e.setRate(new BigDecimal(e.getCompleteQuantity()).divide(new BigDecimal(e.getTotalQuantity()), 2, 4));
            return BeanUtil.copy(e, TaskOrderTrackingDTO.class);
         })
         .collect(Collectors.toList());
      dtoList.sort(Comparator.comparing(TaskOrderTrackingDTO::getRate));
      return dtoList;
   }

   @Override
   public PageVO<TaskOrderTrackingDTO> taskTrackArtifactPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer taskType,
      Integer status,
      String orderNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      List<TaskOrderTrackingDTO> dtoList = this.taskTrackArtifact(
         dateTime, workshopId, productionLineId, projectIds, monomerId, areaId, areaBatchId, taskType, status, orderNumber
      );
      Map<String, List<TaskOrderTrackingDTO>> topOrderMap = dtoList.stream().collect(Collectors.groupingBy(TaskOrderTrackingDTO::getOrderNumber));
      List<TaskOrderTrackingDTO> returnDtos = new ArrayList<>();

      for (String key : topOrderMap.keySet()) {
         List<TaskOrderTrackingDTO> dtos = topOrderMap.get(key);
         TaskOrderTrackingDTO dto = dtos.get(0);
         TaskOrderTrackingDTO copy = BeanUtil.copy(dto, TaskOrderTrackingDTO.class);
         copy.setTotalQuantity(dtos.stream().mapToInt(TaskOrderTrackingDTO::getTotalQuantity).sum());
         copy.setTotalMete(dtos.stream().map(TaskOrderTrackingDTO::getTotalMete).reduce(BigDecimal.ZERO, BigDecimal::add));
         copy.setTotalNetWeight(dtos.stream().map(TaskOrderTrackingDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         copy.setTotalGrossWeight(dtos.stream().map(TaskOrderTrackingDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         copy.setCompleteQuantity(dtos.stream().mapToInt(TaskOrderTrackingDTO::getCompleteQuantity).sum());
         copy.setCompleteMete(dtos.stream().map(TaskOrderTrackingDTO::getCompleteMete).reduce(BigDecimal.ZERO, BigDecimal::add));
         copy.setCompleteGrossWeight(dtos.stream().map(TaskOrderTrackingDTO::getCompleteGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         copy.setCompleteNetWeight(dtos.stream().map(TaskOrderTrackingDTO::getCompleteNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         copy.setRate(new BigDecimal(copy.getCompleteQuantity()).divide(new BigDecimal(copy.getTotalQuantity()), 2, RoundingMode.HALF_UP));
         returnDtos.add(copy);
      }

      List<TaskOrderTrackingDTO> collected = returnDtos.stream()
         .sorted(Comparator.comparingLong(TaskOrderTrackingDTO::getTaskOrderId))
         .collect(Collectors.toList());
      PageVO pages = ListPageUtil.getPages(pageNumber, pageSize, collected);
      return pages;
   }

   @Override
   public List<TaskOrderTrackingDTO> taskTrackArtifact(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer taskType,
      Integer status,
      String orderNumber
   ) {
      List<TaskOrderTrackingDTO> dtoList = this.baseService
         .taskTrackArtifact(dateTime, workshopId, productionLineId, projectIds, monomerId, areaId, areaBatchId, taskType, status, orderNumber)
         .stream()
         .map(e -> {
            e.setRate(new BigDecimal(e.getCompleteQuantity()).divide(new BigDecimal(e.getTotalQuantity()), 2, 4));
            return BeanUtil.copy(e, TaskOrderTrackingDTO.class);
         })
         .collect(Collectors.toList());
      dtoList.sort(Comparator.comparing(TaskOrderTrackingDTO::getRate));
      return dtoList;
   }

   @Override
   public PageVO<MesBuildingMachineTaskOrderDTO> getMachinePartTaskPage(
      Integer boolNestCut,
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      String serialNumber,
      Integer processType,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String cutNumber,
      Long cutConfigId,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<MesBuildingProcess> process = this.processService.list(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getType, processType));
      if (CollectionUtils.isEmpty(process)) {
         return new PageVO<>();
      }

      List<Long> processIds = process.stream().map(MesBuildingProcess::getId).collect(Collectors.toList());
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.getMachinePartTaskList(
            boolNestCut, projectIds, monomerIds, areaIds, serialNumber, processType, processIds, printType, workshopId, localDateTime, cutNumber, cutConfigId
         )
      );
   }

   @Override
   public List<MesBuildingMachineTaskOrderDTO> getMachinePartTaskList(
      Integer boolNestCut,
      List<Long> projectIds,
      List<Long> monomerIds,
      List<Long> areaIds,
      String serialNumber,
      Integer processType,
      List<Long> processIds,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String cutNumber,
      Long cutConfigId
   ) {
      List<MesBuildingMachineTaskOrderDTO> mesBuildingNestCutPlate = this.nestCutPlateBiz
         .getAllnetCut(
            boolNestCut, projectIds, monomerIds, areaIds, serialNumber, processType, processIds, printType, workshopId, localDateTime, cutNumber, cutConfigId
         );
      List<Long> offlines = mesBuildingNestCutPlate.stream()
         .map(s -> s.setBoolOffLine(s.getOffLineType() == 1))
         .filter(MesBuildingMachineTaskOrderDTO::getBoolOffLine)
         .map(MesBuildingMachineTaskOrderDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(mesBuildingNestCutPlate)) {
         mesBuildingNestCutPlate.forEach(e -> {
            Integer cutType = e.getCutType();
            MesBuildingProcess mesBuildingProcess = this.mesBuildingProcessService.getById(cutType);
            e.setCutTypeName(mesBuildingProcess.getName());
         });
      }

      if (mesBuildingNestCutPlate.size() != 0 && !CollectionUtils.isEmpty(offlines)) {
         List<MesBuildingNestCutPlatePart> cutpar = this.nestCutPlatePartBiz
            .list(Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class).in(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, offlines));
         if (CollectionUtils.isEmpty(cutpar)) {
            return mesBuildingNestCutPlate;
         }

         Map<Long, List<MesBuildingNestCutPlatePart>> cutPartsMap = cutpar.stream()
            .collect(Collectors.groupingBy(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId));
         Map<Long, TechMachinePart> machineParts = this.machinePartService
            .listByIds(cutpar.stream().map(MesBuildingNestCutPlatePart::getPartId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity(), (s1, s2) -> s1));

         for (MesBuildingMachineTaskOrderDTO dto : mesBuildingNestCutPlate) {
            if (dto.getBoolOffLine()) {
               int sum = cutPartsMap.get(dto.getId()).stream().mapToInt(MesBuildingNestCutPlatePart::getQuantity).sum();
               BigDecimal taskNetWeight = BigDecimal.ZERO;
               BigDecimal taskGrossWeight = BigDecimal.ZERO;

               for (MesBuildingNestCutPlatePart par : cutPartsMap.get(dto.getId())) {
                  taskNetWeight = taskNetWeight.add(machineParts.get(par.getPartId()).getNetWeight().multiply(new BigDecimal(par.getQuantity())));
                  taskGrossWeight = taskGrossWeight.add(machineParts.get(par.getPartId()).getGrossWeight().multiply(new BigDecimal(par.getQuantity())));
               }

               dto.setTaskQuantity(sum);
               dto.setTaskNetWeight(taskNetWeight);
               dto.setTaskGrossWeight(taskGrossWeight);
            }
         }

         return mesBuildingNestCutPlate;
      } else {
         return mesBuildingNestCutPlate;
      }
   }

   @Override
   public void getMachinePartNesting(Long cutId) {
      MesBuildingNestCutPlate sch = this.nestCutPlateBiz.getById(cutId);
      Preconditions.checkArgument(sch != null, "切割工单不存在");
      String pdfUrl = sch.getPdfUrl();
      String filePath = this.configProperties.getFilePath() + "pdf" + File.separator;

      try {
         PdfUtil.downLoadFromUrl(pdfUrl, sch.getPdfName(), filePath);
      } catch (IOException e) {
         Preconditions.checkArgument(false, "文件下载失败");
      }

      File file = new File(filePath + sch.getPdfName());
      FileUtil.downloadFile(file, "scheduling.pdf");
      file.delete();
   }

   @Override
   public List<MesBuildingMachineTaskDTO> getMachinePartDrilling(Long cutId, Integer processType) {
      MesBuildingNestCutPlate cut = this.nestCutPlateBiz.getById(cutId);
      if (!cut.getBoolOffLine()) {
         List<MesBuildingMachineTaskDTO> machinePartDrilling = this.baseService.getMachinePartDrilling(cutId, processType);
         Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
         if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
            Map<Long, List<MesBuildingMachineTaskDTO>> listMap = machinePartDrilling.stream()
               .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getMonomerId));
            listMap.forEach((monomerId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(monomerId, serialNumberList);
               drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
            });
         }

         if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
            Map<String, List<MesBuildingMachineTaskDTO>> listMap = machinePartDrilling.stream()
               .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getAreaId));
            listMap.forEach((areaId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(Long.valueOf(areaId), serialNumberList);
               drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
            });
         }

         return machinePartDrilling;
      } else {
         List<MesBuildingMachineTaskDTO> machinePartDrilling = this.baseService.getMachinePartOffLine(cutId);
         Integer drawingMatchRange = this.configService.getNumericalControlDrawingMatchRange();
         if (SysMatchRangeEnum.MONOMER.getType().equals(drawingMatchRange)) {
            Map<Long, List<MesBuildingMachineTaskDTO>> listMap = machinePartDrilling.stream()
               .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getMonomerId));
            listMap.forEach((monomerId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPictures(monomerId, serialNumberList);
               drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
            });
         }

         if (SysMatchRangeEnum.AREA.getType().equals(drawingMatchRange)) {
            Map<String, List<MesBuildingMachineTaskDTO>> listMap = machinePartDrilling.stream()
               .collect(Collectors.groupingBy(MesBuildingMachineTaskDTO::getAreaId));
            listMap.forEach((areaId, drillingList) -> {
               Set<String> serialNumberList = drillingList.stream().map(MesBuildingMachineTaskDTO::getSerialNumber).collect(Collectors.toSet());
               Map<String, String> dxfPicturesMap = this.techDrawingService.getDxfPicturesByArea(Long.valueOf(areaId), serialNumberList);
               drillingList.forEach(e -> e.setPicturePath(dxfPicturesMap.get(e.getSerialNumber())));
            });
         }

         return machinePartDrilling;
      }
   }

   private String getSerialNumber(Long teamId, Long workshopId, String serialNumber) {
      List<MesBuildingNestTeamConfig> mesBuildingNestTeamConfigList = this.mesBuildingNestTeamConfigService
         .list((Wrapper<MesBuildingNestTeamConfig>)new LambdaQueryWrapper<MesBuildingNestTeamConfig>().eq(MesBuildingNestTeamConfig::getTeamId, teamId));
      MesBuildingWorkshop mesBuildingWorkshop = this.mesBuildingWorkshopService.getById(workshopId);
      MesBuildingNestTeamConfigDTO mesBuildingNestTeamConfigDTO = this.mesBuildingNestTeamConfigMapper.selectNeedNestTeamConfig(teamId).get(0);
      Preconditions.checkArgument(
         CollectionUtil.isNotEmpty(mesBuildingNestTeamConfigList),
         "未找到班组代号配置，请先到配置管理中配置套料切割配置:车间："
            + mesBuildingWorkshop.getName()
            + "，工序："
            + mesBuildingNestTeamConfigDTO.getProcessName()
            + "，班组："
            + mesBuildingNestTeamConfigDTO.getTeamName()
      );
      if (CollectionUtil.isNotEmpty(mesBuildingNestTeamConfigList)) {
         MesBuildingNestTeamConfig mesBuildingNestTeamConfig = mesBuildingNestTeamConfigList.get(0);
         if (mesBuildingNestTeamConfig.getBoolShowCodename()) {
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
               serialNumber = serialNumber + codeName;
            } else {
               serialNumber = codeName + serialNumber;
            }
         }
      }

      return serialNumber;
   }

   @Override
   public PageVO getMachinePartDrillingPage(Long cutId, Integer processType, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getMachinePartDrilling(cutId, processType));
   }

   @Override
   public Integer cunRows(Integer taskTypeEnum, Long topTaskOrderId) {
      return this.baseService.cunRows(taskTypeEnum, topTaskOrderId);
   }

   private void saveTaskOrderList(
      List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactTaskList,
      List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleTaskList,
      List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartTaskList,
      Integer productionLineType,
      MesBuildingMachinePartSchedulingDTOParam dtoParamOld
   ) {
      if (CollectionUtils.isNotEmpty(artifactTaskList)) {
         List<Long> artIds = artifactTaskList.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getProductId).collect(Collectors.toList());
         this.taskBiz.checkProductStatus(artIds, TaskTypeEnum.ARTIFACT.getType());
      }

      if (CollectionUtils.isNotEmpty(assembleTaskList)) {
         List<Long> assIds = assembleTaskList.stream().map(MesBuildingTaskOrderAssembleDetaiDTOParam::getProductId).collect(Collectors.toList());
         this.taskBiz.checkProductStatus(assIds, TaskTypeEnum.ASSEMBLE.getType());
      }

      if (CollectionUtils.isNotEmpty(artifactTaskList)) {
         List<Long> artifactIds = artifactTaskList.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getProductId).collect(Collectors.toList());
         List<TechArtifact> artifacts = this.artifactService.listByIds(artifactIds);
         Long projectId = artifacts.get(0).getProjectId();
         Long monomerId = artifacts.get(0).getMonomerId();
         Long areaId = artifacts.get(0).getAreaId();
         PlanArea area = this.areaService.getById(areaId);
         Long artiGroupId = artifactTaskList.get(0).getGroupsId();
         MesBuildingGroups groups = this.groupsBiz.getById(artiGroupId);
         Preconditions.checkArgument(groups != null, "操作失败,构件选择的生产组不存在!");
         Optional<LocalDateTime> artifactMaxTime = artifactTaskList.stream()
            .map(MesBuildingTaskOrderArtifactDetailDTOParam::getAskCompleteTime)
            .max(LocalDateTime::compareTo);
         Preconditions.checkArgument(artifactMaxTime.isPresent(), "操作失败!!请刷新页面后重试!!!");
         int allQuantity = artifactTaskList.stream().mapToInt(MesBuildingTaskOrderArtifactDetailDTOParam::getQuantity).sum();
         MesBuildingTopTaskOrder topTaskOrder = this.topTaskOrderBiz
            .getOne((Wrapper<MesBuildingTopTaskOrder>)new LambdaQueryWrapper<MesBuildingTopTaskOrder>().eq(MesBuildingTopTaskOrder::getAreaId, areaId));
         if (topTaskOrder == null) {
            topTaskOrder = MesBuildingTopTaskOrder.builder()
               .productionLineTypeEnum(productionLineType)
               .areaId(areaId)
               .projectId(projectId)
               .monomerId(monomerId)
               .askCompleteTime(artifactMaxTime.get())
               .orderNumber("顶级-" + groups.getName() + "-" + area.getName())
               .quantity(allQuantity)
               .build();
            this.topTaskOrderBiz.save(topTaskOrder);
         } else {
            topTaskOrder.setQuantity(topTaskOrder.getQuantity() + allQuantity);
            topTaskOrder.setAskCompleteTime(artifactMaxTime.get());
            this.topTaskOrderBiz.updateById(topTaskOrder);
         }

         MesBuildingTaskOrder artifactOrder = this.baseService
            .getOne(
               (Wrapper<MesBuildingTaskOrder>)((new LambdaQueryWrapper<MesBuildingTaskOrder>().eq(MesBuildingTaskOrder::getAreaId, areaId))
                     .eq(MesBuildingTaskOrder::getGroupsId, artiGroupId))
                  .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         if (artifactOrder == null) {
            artifactOrder = MesBuildingTaskOrder.builder()
               .groupsId(artiGroupId)
               .projectId(projectId)
               .monomerId(monomerId)
               .areaId(areaId)
               .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
               .quantity(allQuantity)
               .printQuantity(0)
               .status(Boolean.TRUE)
               .topTaskOrderId(topTaskOrder.getId())
               .productionLineTypeEnum(productionLineType)
               .orderNumber("构-" + groups.getName())
               .userId(UserUtil.getCurrentUserId())
               .askCompleteTime(artifactMaxTime.get())
               .build();
            this.baseService.save(artifactOrder);
         } else {
            artifactOrder.setQuantity(artifactOrder.getQuantity() + allQuantity);
            artifactOrder.setAskCompleteTime(artifactMaxTime.get());
            artifactOrder.setPrintQuantity(0);
            this.baseService.updateById(artifactOrder);
         }

         Map<Long, List<IDAndQuantityDTO>> numberLinkMap = this.saveArtifactTaskOrderLink(
            topTaskOrder, artifactOrder.getId(), artifactTaskList, productionLineType, artiGroupId
         );
         Map<Long, Integer> assTaskMap = assembleTaskList.stream()
            .collect(
               Collectors.toMap(MesBuildingTaskOrderAssembleDetaiDTOParam::getProductId, MesBuildingTaskOrderAssembleDetaiDTOParam::getQuantity, Integer::sum)
            );
         if (CollectionUtils.isNotEmpty(assembleTaskList)) {
            for (Long assId : numberLinkMap.keySet()) {
               List<IDAndQuantityDTO> needList = numberLinkMap.get(assId);
               int sum = needList.stream().mapToInt(IDAndQuantityDTO::getQuantity).sum();
               Preconditions.checkArgument(assTaskMap.get(assId) != null, "操作失败!!!请刷新页面后重试!!!");
               Preconditions.checkArgument(assTaskMap.get(assId).equals(sum), "操作失败!!!请刷新页面后重试!!!");
            }
         }

         if (CollectionUtils.isNotEmpty(assembleTaskList)) {
            List<MesBuildingTaskOrderAssembleDetaiDTOParam> needTasks = assembleTaskList.stream()
               .filter(MesBuildingTaskOrderAssembleDetaiDTOParam::getBoolProcess)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(needTasks)) {
               Map<Long, List<MesBuildingTaskOrderAssembleDetaiDTOParam>> assembleTaskOrderMap = needTasks.stream()
                  .collect(Collectors.groupingBy(MesBuildingTaskOrderAssembleDetaiDTOParam::getGroupsId, Collectors.toList()));

               for (Long assGroupId : assembleTaskOrderMap.keySet()) {
                  MesBuildingGroups assembleGroups = this.groupsBiz.getById(assGroupId);
                  List<MesBuildingTaskOrderAssembleDetaiDTOParam> assGroupTask = assembleTaskOrderMap.get(assGroupId);
                  int assSum = assGroupTask.stream().mapToInt(MesBuildingTaskOrderAssembleDetaiDTOParam::getQuantity).sum();
                  Optional<LocalDateTime> assMaxTime = assGroupTask.stream()
                     .map(MesBuildingTaskOrderAssembleDetaiDTOParam::getAskCompleteTime)
                     .max(LocalDateTime::compareTo);
                  Preconditions.checkArgument(assMaxTime.isPresent(), "操作失败!!请刷新页面后重试!!!");
                  MesBuildingTaskOrder assTaskOrder = this.baseService
                     .getOne(
                        (Wrapper<MesBuildingTaskOrder>)((new LambdaQueryWrapper<MesBuildingTaskOrder>()
                                 .eq(MesBuildingTaskOrder::getAreaId, areaId))
                              .eq(MesBuildingTaskOrder::getGroupsId, assGroupId))
                           .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType())
                     );
                  if (assTaskOrder == null) {
                     assTaskOrder = MesBuildingTaskOrder.builder()
                        .groupsId(assGroupId)
                        .projectId(projectId)
                        .monomerId(monomerId)
                        .areaId(areaId)
                        .taskTypeEnum(TaskTypeEnum.ASSEMBLE.getType())
                        .quantity(assSum)
                        .printQuantity(0)
                        .topTaskOrderId(topTaskOrder.getId())
                        .orderNumber("部-" + assembleGroups.getName())
                        .status(Boolean.TRUE)
                        .userId(UserUtil.getCurrentUserId())
                        .askCompleteTime(assMaxTime.get())
                        .build();
                     this.baseService.save(assTaskOrder);
                  } else {
                     assTaskOrder.setQuantity(assTaskOrder.getQuantity() + assSum);
                     assTaskOrder.setAskCompleteTime(assMaxTime.get());
                     assTaskOrder.setPrintQuantity(0);
                     this.baseService.updateById(assTaskOrder);
                  }

                  this.saveAssembleTaskOrderLink(topTaskOrder, assTaskOrder.getId(), assGroupTask, productionLineType, assGroupId, numberLinkMap);
               }
            }

            List<MesBuildingTaskOrderAssembleDetaiDTOParam> unProcessAssList = assembleTaskList.stream()
               .filter(s -> !s.getBoolProcess())
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(unProcessAssList)) {
               this.saveAssembleTaskOrderLink(null, null, unProcessAssList, null, null, numberLinkMap);
            }
         }
      }

      if (machinePartTaskList != null) {
         Map<Long, MesBuildingTaskOrderMachinePartDetailDTOParam> nestCutDrillMap = machinePartTaskList.stream()
            .collect(Collectors.toMap(MesBuildingTaskOrderMachinePartDetailDTOParam::getId, Function.identity()));
         Map<Long, MesBuildingTeam> groupsMap = new HashMap<>();
         List<Long> groupsIds = machinePartTaskList.stream().map(MesBuildingTaskOrderMachinePartDetailDTOParam::getGroupsId).collect(Collectors.toList());
         List<Long> drillGroupsIds = machinePartTaskList.stream()
            .map(MesBuildingTaskOrderMachinePartDetailDTOParam::getDrillGroupsId)
            .collect(Collectors.toList());
         if (drillGroupsIds.size() > 0) {
            groupsIds.addAll(drillGroupsIds);
         }

         this.mesBuildingTeamService.listByIds(groupsIds).forEach(e -> {
            MesBuildingTeam var10000 = groupsMap.put(e.getId(), e);
         });
         machinePartTaskList.forEach(
            e -> this.nestCutPlateBiz
               .updateById(
                  MesBuildingNestCutPlate.builder()
                     .allocateTime(e.getAskCompleteTime())
                     .id(e.getId())
                     .factoryId(groupsMap.get(e.getGroupsId()).getFactoryId())
                     .workshopId(groupsMap.get(e.getGroupsId()).getWorkshopId())
                     .productionLineId(groupsMap.get(e.getGroupsId()).getProductionLineId())
                     .askCompleteTime(e.getAskCompleteTime())
                     .groupsId(e.getGroupsId())
                     .boolIssueEnum(Boolean.TRUE)
                     .schedulingTime(LocalDateTime.now())
                     .build()
               )
         );
         List<MesBuildingNestCutPlate> nestCutPlateList = this.nestCutPlateBiz
            .listByIds(machinePartTaskList.stream().map(MesBuildingTaskOrderMachinePartDetailDTOParam::getId).collect(Collectors.toList()));
         nestCutPlateList.forEach(
            e -> {
               MesBuildingMachinePartScheduling machinePartScheduling = this.machinePartSchedulingBiz.getById(e.getMachinePartSchedulingId());
               machinePartScheduling.setTaskStatusEnum(2);
               this.machinePartSchedulingBiz.updateById(machinePartScheduling);
               if ((
                     machinePartScheduling.getIssueStatusEnum().equals(MachinePartSchedulingIssueStatusEnum.OUT_NESTING.getType())
                        || !machinePartScheduling.getBoolNestCutEnum()
                  )
                  && this.nestCutPlateBiz
                        .list(
                           Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
                              .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, e.getMachinePartSchedulingId())
                              .eq(MesBuildingNestCutPlate::getBoolIssueEnum, Boolean.FALSE)
                        )
                        .size()
                     == 0) {
                  machinePartScheduling.setTaskStatusEnum(4);
                  this.machinePartSchedulingBiz.updateById(machinePartScheduling);
               }

               MesBuildingTaskOrder oldTaskOrder = this.getOne(
                  Wrappers.lambdaQuery(MesBuildingTaskOrder.class).eq(MesBuildingTaskOrder::getSchedulingId, e.getMachinePartSchedulingId())
               );
               Long taskOrderId;
               if (oldTaskOrder == null) {
                  MesBuildingTaskOrder taskOrder = MesBuildingTaskOrder.builder()
                     .taskTypeEnum(ProductTypeEnum.MACHINE_PART.getType())
                     .quantity(machinePartScheduling.getQuantity())
                     .printQuantity(0)
                     .childGuid(dtoParamOld.getBcGuid())
                     .orderNumber(machinePartScheduling.getOrderNumber())
                     .status(Boolean.TRUE)
                     .boolNestCutEnum(e.getBoolNestCutEnum())
                     .cutConfigId(machinePartScheduling.getCutConfigId())
                     .jobId(dtoParamOld.getJobId())
                     .drillCutConfigId(machinePartScheduling.getDrillCutConfigId())
                     .schedulingId(e.getMachinePartSchedulingId())
                     .askCompleteTime(e.getAskCompleteTime())
                     .userId(UserUtil.getCurrentUserId())
                     .build();
                  this.save(taskOrder);
                  taskOrderId = taskOrder.getId();
                  this.saveMachinePartSeparate(taskOrderId);
               } else {
                  taskOrderId = oldTaskOrder.getId();
                  if (oldTaskOrder.getAskCompleteTime().isBefore(e.getAskCompleteTime())) {
                     oldTaskOrder.setAskCompleteTime(e.getAskCompleteTime());
                     this.updateById(oldTaskOrder);
                  }
               }

               e.setTaskOrderId(taskOrderId);
               e.setIssueUserId(UserUtil.getCurrentUserId());
               this.nestCutPlateBiz.updateById(e);
               this.saverMachinePartTaskOrderLinkList(
                  taskOrderId,
                  e,
                  nestCutDrillMap.get(e.getId()).getDrillGroupsId() == null ? null : groupsMap.get(nestCutDrillMap.get(e.getId()).getDrillGroupsId()),
                  nestCutDrillMap.get(e.getId()).getDrillAskCompleteTime(),
                  dtoParamOld
               );
            }
         );
      }
   }

   private void saveTaskOrderList2(
      List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactTaskList,
      List<MesBuildingTaskOrderAssembleDetaiDTOParam> assembleTaskList,
      List<MesBuildingTaskOrderMachinePartDetailDTOParam> machinePartTaskList,
      List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList,
      String inputOrderNumber
   ) {
      if (CollectionUtils.isNotEmpty(artifactTaskList)) {
         List<Long> artIds = artifactTaskList.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getProductId).collect(Collectors.toList());
         this.taskBiz.checkProductStatus(artIds, TaskTypeEnum.ARTIFACT.getType());
      }

      if (CollectionUtils.isNotEmpty(assembleTaskList)) {
         List<Long> assIds = assembleTaskList.stream().map(MesBuildingTaskOrderAssembleDetaiDTOParam::getProductId).collect(Collectors.toList());
         this.taskBiz.checkProductStatus(assIds, TaskTypeEnum.ASSEMBLE.getType());
      }

      if (CollectionUtils.isNotEmpty(artifactTaskList)) {
         List<Long> artifactIds = artifactTaskList.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getProductId).collect(Collectors.toList());
         List<TechArtifact> artifacts = this.artifactService.listByIds(artifactIds);
         Long projectId = artifacts.get(0).getProjectId();
         Map<Long, PlanAreaBatch> areaBatchMap = this.areaBatchService
            .listByIds(artifacts.stream().map(TechArtifact::getAreaBatchId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(PlanAreaBatch::getId, Function.identity()));
         ContractProject project = this.contractProjectService.getById(projectId);
         List<MesBuildingTaskOrder> orders = this.baseService
            .list(Wrappers.lambdaQuery(MesBuildingTaskOrder.class).eq(MesBuildingTaskOrder::getProjectId, projectId));
         AtomicReference<Long> artCount = new AtomicReference<>(
            orders.stream().filter(s -> s.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())).count()
         );
         AtomicReference<Long> assCount = new AtomicReference<>(
            orders.stream().filter(s -> s.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())).count()
         );
         Optional<LocalDateTime> artifactMaxTime = artifactTaskList.stream()
            .map(MesBuildingTaskOrderArtifactDetailDTOParam::getAskCompleteTime)
            .max(LocalDateTime::compareTo);
         Preconditions.checkArgument(artifactMaxTime.isPresent(), "操作失败!!请刷新页面后重试!!!");
         Map<String, List<MesBuildingTaskOrderArtifactDetailDTOParam>> artTaskMap = artifactTaskList.stream()
            .collect(Collectors.groupingBy(s -> s.getAreaBatchId() + "_" + s.getProdLineId()));
         Map<Long, List<MesBuildingTaskOrderAssembleDetaiDTOParam>> assTaskMap = assembleTaskList.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskOrderAssembleDetaiDTOParam::getAreaBatchId));
         artTaskMap.forEach(
            (areaLine, list) -> {
               Long areaBatchId = list.get(0).getAreaBatchId();
               Long lineId = list.get(0).getProdLineId();
               PlanAreaBatch areaBatch = areaBatchMap.get(areaBatchId);
               Long monomerId = areaBatch.getMonomerId();
               Long areaId = areaBatch.getAreaId();
               int allQuantity = list.stream().mapToInt(MesBuildingTaskOrderArtifactDetailDTOParam::getQuantity).sum();
               MesBuildingTopTaskOrder topOne = this.topTaskOrderBiz
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingTopTaskOrder.class)
                        .eq(MesBuildingTopTaskOrder::getAreaBatchId, areaBatchId)
                        .eq(MesBuildingTopTaskOrder::getProductionLineId, lineId)
                  );
               if (topOne == null) {
                  int topOrderNumber = this.topTaskOrderBiz.getNumber(LocalDateTime.now()) + 1;
                  topOne = MesBuildingTopTaskOrder.builder()
                     .projectId(projectId)
                     .monomerId(monomerId)
                     .areaId(areaId)
                     .areaBatchId(areaBatchId)
                     .productionLineId(lineId)
                     .askCompleteTime(artifactMaxTime.get())
                     .orderNumber("顶级-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-" + topOrderNumber)
                     .quantity(allQuantity)
                     .build();
                  this.topTaskOrderBiz.save(topOne);
               } else {
                  topOne.setQuantity(topOne.getQuantity() + allQuantity);
                  topOne.setAskCompleteTime(artifactMaxTime.get());
                  this.topTaskOrderBiz.updateById(topOne);
               }

               MesBuildingTaskOrder artOrder = this.baseService
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
                        .eq(MesBuildingTaskOrder::getAreaBatchId, areaBatchId)
                        .eq(MesBuildingTaskOrder::getProductionLineId, lineId)
                        .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                  );
               if (artOrder == null) {
                  artCount.getAndSet(artCount.get() + 1L);
                  String artFormatNumber = String.format("%02d", artCount.get());
                  artOrder = MesBuildingTaskOrder.builder()
                     .productionLineId(lineId)
                     .projectId(projectId)
                     .monomerId(monomerId)
                     .areaId(areaId)
                     .areaBatchId(areaBatchId)
                     .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
                     .quantity(allQuantity)
                     .printQuantity(0)
                     .status(Boolean.TRUE)
                     .topTaskOrderId(topOne.getId())
                     .orderNumber("构-" + areaBatch.getName() + "-" + artFormatNumber)
                     .userId(UserUtil.getCurrentUserId())
                     .askCompleteTime(artifactMaxTime.get())
                     .build();
                  this.baseService.save(artOrder);
               } else {
                  artOrder.setQuantity(artOrder.getQuantity() + allQuantity);
                  artOrder.setAskCompleteTime(artifactMaxTime.get());
                  artOrder.setPrintQuantity(0);
                  this.baseService.updateById(artOrder);
               }

               Map<Long, List<IDAndQuantityDTO>> numberLinkMap = this.saveArtifactTaskOrderLink2(
                  topOne, artOrder.getId(), (List<MesBuildingTaskOrderArtifactDetailDTOParam>)list, lineId
               );
               List<MesBuildingTaskOrderAssembleDetaiDTOParam> assTaskList = assTaskMap.get(areaBatchId);
               if (CollectionUtils.isNotEmpty(assTaskList)) {
                  Map<Long, Integer> assTaskQuantityMap = assTaskList.stream()
                     .collect(
                        Collectors.toMap(
                           MesBuildingTaskOrderAssembleDetaiDTOParam::getProductId, MesBuildingTaskOrderAssembleDetaiDTOParam::getQuantity, Integer::sum
                        )
                     );
                  if (CollectionUtils.isNotEmpty(assTaskList)) {
                     for (Long assId : numberLinkMap.keySet()) {
                        List<IDAndQuantityDTO> needList = numberLinkMap.get(assId);
                        int sum = needList.stream().mapToInt(IDAndQuantityDTO::getQuantity).sum();
                        Preconditions.checkArgument(assTaskQuantityMap.get(assId) != null, "操作失败!!!请刷新页面后重试!!!");
                        Preconditions.checkArgument(assTaskQuantityMap.get(assId).equals(sum), "操作失败!!!请刷新页面后重试!!!");
                     }
                  }

                  List<MesBuildingTaskOrderAssembleDetaiDTOParam> needTasks = assTaskList.stream()
                     .filter(MesBuildingTaskOrderAssembleDetaiDTOParam::getBoolProcess)
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(needTasks)) {
                     Map<Long, List<MesBuildingTaskOrderAssembleDetaiDTOParam>> assembleTaskOrderMap = needTasks.stream()
                        .collect(Collectors.groupingBy(MesBuildingTaskOrderAssembleDetaiDTOParam::getProdLineId, Collectors.toList()));

                     for (Long assLineId : assembleTaskOrderMap.keySet()) {
                        MesBuildingProductionLine assembleProductionLine = this.productionLineBiz.getById(assLineId);
                        List<MesBuildingTaskOrderAssembleDetaiDTOParam> assLineTask = assembleTaskOrderMap.get(assLineId);
                        int assSum = assLineTask.stream().mapToInt(MesBuildingTaskOrderAssembleDetaiDTOParam::getQuantity).sum();
                        Optional<LocalDateTime> assMaxTime = assLineTask.stream()
                           .map(MesBuildingTaskOrderAssembleDetaiDTOParam::getAskCompleteTime)
                           .max(LocalDateTime::compareTo);
                        Preconditions.checkArgument(assMaxTime.isPresent(), "操作失败!!请刷新页面后重试!!!");
                        MesBuildingTaskOrder assOrder = this.baseService
                           .getOne(
                              Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
                                 .eq(MesBuildingTaskOrder::getAreaBatchId, areaBatchId)
                                 .eq(MesBuildingTaskOrder::getProductionLineId, assLineId)
                                 .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType())
                           );
                        if (assOrder == null) {
                           assCount.getAndSet(assCount.get() + 1L);
                           String assFormatNumber = String.format("%02d", assCount.get());
                           assOrder = MesBuildingTaskOrder.builder()
                              .projectId(projectId)
                              .monomerId(monomerId)
                              .areaId(areaId)
                              .areaBatchId(areaBatchId)
                              .productionLineId(assLineId)
                              .taskTypeEnum(TaskTypeEnum.ASSEMBLE.getType())
                              .quantity(assSum)
                              .printQuantity(0)
                              .topTaskOrderId(topOne.getId())
                              .orderNumber("部-" + areaBatch.getName() + "-" + assFormatNumber)
                              .status(Boolean.TRUE)
                              .userId(UserUtil.getCurrentUserId())
                              .askCompleteTime(assMaxTime.get())
                              .build();
                           this.baseService.save(assOrder);
                        } else {
                           assOrder.setQuantity(assOrder.getQuantity() + allQuantity);
                           assOrder.setAskCompleteTime(
                              assOrder.getAskCompleteTime().compareTo(assMaxTime.get()) == 1 ? assOrder.getAskCompleteTime() : assMaxTime.get()
                           );
                           assOrder.setPrintQuantity(0);
                           this.baseService.updateById(assOrder);
                        }

                        this.saveAssembleTaskOrderLink2(topOne, assOrder.getId(), assLineTask, assLineId, numberLinkMap, null);
                     }
                  }

                  List<MesBuildingTaskOrderAssembleDetaiDTOParam> unProcessAssList = assTaskList.stream()
                     .filter(s -> !s.getBoolProcess())
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(unProcessAssList)) {
                     this.saveAssembleTaskOrderLink2(null, null, unProcessAssList, null, numberLinkMap, prunedList);
                  }
               }
            }
         );
      }

      if (machinePartTaskList != null) {
         Map<Long, MesBuildingTaskOrderMachinePartDetailDTOParam> nestCutDrillMap = machinePartTaskList.stream()
            .collect(Collectors.toMap(MesBuildingTaskOrderMachinePartDetailDTOParam::getId, Function.identity()));
         Map<Long, MesBuildingProductionLine> linesMap = new HashMap<>();
         List<Long> linesIds = machinePartTaskList.stream().map(MesBuildingTaskOrderMachinePartDetailDTOParam::getProdLineId).collect(Collectors.toList());
         List<Long> getDrillprodLineIds = machinePartTaskList.stream()
            .map(MesBuildingTaskOrderMachinePartDetailDTOParam::getDrillprodLineId)
            .collect(Collectors.toList());
         if (getDrillprodLineIds.size() > 0) {
            linesIds.addAll(getDrillprodLineIds);
         }

         this.productionLineBiz.listByIds(linesIds).forEach(e -> {
            MesBuildingProductionLine var10000 = linesMap.put(e.getId(), e);
         });
         machinePartTaskList.forEach(
            e -> this.nestCutPlateBiz
               .updateById(
                  MesBuildingNestCutPlate.builder()
                     .allocateTime(e.getAskCompleteTime())
                     .id(e.getId())
                     .factoryId(linesMap.get(e.getProdLineId()).getFactoryId())
                     .workshopId(linesMap.get(e.getProdLineId()).getWorkshopId())
                     .productionLineId(linesMap.get(e.getProdLineId()).getId())
                     .askCompleteTime(e.getAskCompleteTime())
                     .boolIssueEnum(Boolean.TRUE)
                     .schedulingTime(LocalDateTime.now())
                     .build()
               )
         );
         List<MesBuildingNestCutPlate> nestCutPlateList = this.nestCutPlateBiz
            .listByIds(machinePartTaskList.stream().map(MesBuildingTaskOrderMachinePartDetailDTOParam::getId).collect(Collectors.toList()));
         nestCutPlateList.forEach(
            e -> {
               MesBuildingMachinePartScheduling machinePartScheduling = this.machinePartSchedulingBiz.getById(e.getMachinePartSchedulingId());
               machinePartScheduling.setTaskStatusEnum(2);
               this.machinePartSchedulingBiz.updateById(machinePartScheduling);
               if ((
                     machinePartScheduling.getIssueStatusEnum().equals(MachinePartSchedulingIssueStatusEnum.OUT_NESTING.getType())
                        || !machinePartScheduling.getBoolNestCutEnum()
                  )
                  && this.nestCutPlateBiz
                        .list(
                           Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
                              .eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, e.getMachinePartSchedulingId())
                              .eq(MesBuildingNestCutPlate::getBoolIssueEnum, Boolean.FALSE)
                        )
                        .size()
                     == 0) {
                  machinePartScheduling.setTaskStatusEnum(4);
                  this.machinePartSchedulingBiz.updateById(machinePartScheduling);
               }

               MesBuildingTaskOrder oldTaskOrder = this.getOne(
                  Wrappers.lambdaQuery(MesBuildingTaskOrder.class).eq(MesBuildingTaskOrder::getSchedulingId, e.getMachinePartSchedulingId())
               );
               Long taskOrderId;
               if (oldTaskOrder == null) {
                  MesBuildingTaskOrder taskOrder = MesBuildingTaskOrder.builder()
                     .taskTypeEnum(ProductTypeEnum.MACHINE_PART.getType())
                     .quantity(machinePartScheduling.getQuantity())
                     .printQuantity(0)
                     .orderNumber(machinePartScheduling.getOrderNumber())
                     .status(Boolean.TRUE)
                     .boolNestCutEnum(e.getBoolNestCutEnum())
                     .cutConfigId(machinePartScheduling.getCutConfigId())
                     .schedulingId(e.getMachinePartSchedulingId())
                     .askCompleteTime(e.getAskCompleteTime())
                     .userId(UserUtil.getCurrentUserId())
                     .build();
                  this.save(taskOrder);
                  taskOrderId = taskOrder.getId();
                  this.saveMachinePartSeparate2(taskOrderId);
               } else {
                  taskOrderId = oldTaskOrder.getId();
                  if (oldTaskOrder.getAskCompleteTime().isBefore(e.getAskCompleteTime())) {
                     oldTaskOrder.setAskCompleteTime(e.getAskCompleteTime());
                     this.updateById(oldTaskOrder);
                  }
               }

               e.setTaskOrderId(taskOrderId);
               e.setIssueUserId(UserUtil.getCurrentUserId());
               this.nestCutPlateBiz.updateById(e);
               this.saverMachinePartTaskOrderLinkList2(
                  taskOrderId,
                  e,
                  nestCutDrillMap.get(e.getId()).getDrillprodLineId() == null ? null : linesMap.get(nestCutDrillMap.get(e.getId()).getDrillprodLineId()),
                  nestCutDrillMap.get(e.getId()).getDrillAskCompleteTime()
               );
            }
         );
      }
   }

   private Map<Long, List<IDAndQuantityDTO>> saveArtifactTaskOrderLink(
      MesBuildingTopTaskOrder topTaskOrder,
      Long taskOrderId,
      List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactTaskList,
      Integer productionLineType,
      Long groupId
   ) {
      MesBuildingGroups group = this.groupsBiz.getById(groupId);
      List<TechArtifact> artifacts = new ArrayList<>();
      Map<Long, TechArtifact> artifactMap = new HashMap<>();
      Map<Long, List<TechAssembleDetail>> assembleDetailMap = new HashMap<>();
      List<MesBuildingProductProcess> productProcessList = this.productProcessService
         .list(Wrappers.lambdaQuery(MesBuildingProductProcess.class).eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE));
      productProcessList = productProcessList.stream().filter(item -> Objects.equals(item.getProductionLineId(), group.getProductionLineId()) && item.getPartType() == null).collect(Collectors.toList());
      Map<String, MesBuildingProductProcess> productProcessMap = productProcessList.stream()
         .collect(Collectors.toMap(s -> s.getProductType() + "_" + s.getTypeId(), Function.identity()));
      if (artifactTaskList != null) {
         List<Long> artIds = artifactTaskList.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getProductId).collect(Collectors.toList());
         artifacts = this.artifactService.listByIds(artIds);
         artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         List<TechAssembleDetail> assembleDetails = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artIds));
         List<Long> assIds = assembleDetails.stream().map(TechAssembleDetail::getAssembleId).distinct().collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(assIds)) {
            List<Long> processIds = this.assembleService.listByIds(assIds).stream().map(TechAssemble::getId).collect(Collectors.toList());
            assembleDetailMap = assembleDetails.stream()
               .filter(s -> processIds.contains(s.getAssembleId()))
               .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
         }
      }

      Map<Long, List<IDAndQuantityDTO>> assArtifactlinkMap = new HashMap<>();
      if (artifactTaskList != null) {
         Map<Long, Integer> scheduMap = artifactTaskList.stream()
            .collect(
               Collectors.toMap(MesBuildingTaskOrderArtifactDetailDTOParam::getProductId, MesBuildingTaskOrderArtifactDetailDTOParam::getQuantity, Integer::sum)
            );
         Map<Long, Integer> taskMap = this.taskBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                  .in(MesBuildingTask::getProductId, scheduMap.keySet())
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingTask::getProductId, MesBuildingTask::getTaskQuantity, Integer::sum));

         for (Long id : scheduMap.keySet()) {
            Integer listQuantity = artifactMap.get(id).getQuantity();
            Integer taskQuantity = taskMap.get(id) == null ? 0 : taskMap.get(id);
            Integer schQuantity = scheduMap.get(id);
            if (listQuantity == null) {
               Preconditions.checkArgument(false, "任务下发失败,找不到该构件!!!");
            } else {
               Preconditions.checkArgument(listQuantity >= taskQuantity + schQuantity, "任务下发失败,构件下发数不可大于清单数,请刷新后重试!!!");
            }
         }

         List<Long> schedulingIds = artifactTaskList.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getSchedulingId).collect(Collectors.toList());
         List<MesBuildingTask> tasks = new ArrayList<>();

         for (MesBuildingTaskOrderArtifactDetailDTOParam needTask : artifactTaskList) {
            TechArtifact artifact = artifactMap.get(needTask.getProductId());
            boolean boolOneCode = artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType());
            String key = TaskTypeEnum.ARTIFACT.getType() + "_" + artifact.getStructureClassId();
            MesBuildingProductProcess productProcess = productProcessMap.get(key);
            if (!artifact.getBoolAllPartSendDirectly()
               && (!artifact.getBuildingType().equals(InventoryTypeEnum.GRID.getType()) || !artifact.getBoolSendDirectly())) {
               Preconditions.checkArgument(productProcess != null, "操作失败!!!构件工序未配置!!!");
            }

            MesBuildingTask task = MesBuildingTask.builder()
               .projectId(artifact.getProjectId())
               .monomerId(artifact.getMonomerId())
               .areaId(artifact.getAreaId())
               .groupsId(groupId)
               .factoryId(group.getFactoryId())
               .workshopId(group.getWorkshopId())
               .productionLineId(group.getProductionLineId())
               .productId(needTask.getProductId())
               .classificationId(artifact.getStructureClassId())
               .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
               .productProcessId(productProcess == null ? 0L : productProcess.getId())
               .schedulingId(needTask.getSchedulingId())
               .productionLineTypeEnum(productionLineType)
               .taskQuantity(needTask.getQuantity())
               .askCompleteTime(needTask.getAskCompleteTime())
               .userId(UserUtil.getCurrentUserId())
               .taskOrderId(taskOrderId)
               .topTaskOrderId(topTaskOrder.getId())
               .boolOneCode(boolOneCode)
               .build();
            if (artifact.getBuildingType().equals(InventoryTypeEnum.GRID.getType()) && artifact.getBoolSendDirectly()) {
               task.setBoolCompleteEnum(1L);
               task.setCompleteQuantity(task.getTaskQuantity());
               task.setCompleteQuantity(task.getTaskQuantity());
               task.setInProductionQuantity(task.getTaskQuantity());
               task.setInProductionQuantity(task.getTaskQuantity());
               task.setCompleteTime(LocalDateTime.now());
            }

            tasks.add(task);
         }

         this.taskService.saveBatch(tasks);
         this.recordNewTaskQuantities(tasks);
         Map<Long, Long> taskTaskPorcessMap = this.taskBiz.addAllTaskProces(tasks, artifactMap, null, TaskTypeEnum.ARTIFACT.getType());
         this.saveSchedulingPartsDataForTasks(tasks, artifactMap, null, TaskTypeEnum.ARTIFACT.getType());
         List<TechArtifactExt> needTaskExts = this.artifactExtService
            .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getSchedulingId, schedulingIds).eq(TechArtifactExt::getBoolTask, false));
         Map<Long, List<TechArtifactExt>> artExtMap = needTaskExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getSchedulingId));

         for (MesBuildingTask task : tasks) {
            List<TechArtifactExt> artifactExts = artExtMap.get(task.getSchedulingId());
            artifactExts.sort(Comparator.comparing(TechArtifactExt::getSortNumber));
            Preconditions.checkArgument(artifactExts.size() >= task.getTaskQuantity(), "操作失败!!!构件任务下发数大于当前可下发数,请刷新页面后重试!!!!");
            List<TechArtifactExt> needTaskExt = artifactExts.stream().limit(task.getTaskQuantity().intValue()).collect(Collectors.toList());

            for (TechArtifactExt techArtifactExt : needTaskExt) {
               techArtifactExt.setTaskId(task.getId());
               techArtifactExt.setBoolTask(Boolean.TRUE);
            }

            artExtMap.put(task.getSchedulingId(), needTaskExt);
         }

         List<TechArtifactExt> extList = artExtMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
         this.artifactExtService.updateBatchById(extList);
         this.saveAllsendArtifct(artifacts, tasks, artExtMap);
         List<MesBuildingTaskNumberLink> links = new ArrayList<>();

         for (MesBuildingTask task : tasks) {
            List<TechArtifactExt> needTaskExt = artExtMap.get(task.getSchedulingId());
            Preconditions.checkArgument(needTaskExt.size() == task.getTaskQuantity(), "操作失败!!!请联系管理员!!!");
            Boolean boolOneCode = task.getBoolOneCode();

            for (TechArtifactExt needTaskext : needTaskExt) {
               List<TechAssembleDetail> linkAssmble = assembleDetailMap.get(needTaskext.getArtifactId());
               if (CollectionUtils.isNotEmpty(linkAssmble)) {
                  for (TechAssembleDetail assembleDetail : linkAssmble) {
                     for (int i = 0; i < assembleDetail.getQuantity(); i++) {
                        MesBuildingTaskNumberLink link = MesBuildingTaskNumberLink.builder()
                           .artifactId(task.getProductId())
                           .assembleId(assembleDetail.getAssembleId())
                           .artifactNumber(needTaskext.getSortNumber())
                           .artifactTaskId(task.getId())
                           .artifactTaskProcessId(taskTaskPorcessMap.getOrDefault(task.getId(), 0L))
                           .boolArtifactComplete(Boolean.FALSE)
                           .boolOneCode(boolOneCode)
                           .build();
                        links.add(link);
                     }
                  }
               } else {
                  MesBuildingTaskNumberLink link = MesBuildingTaskNumberLink.builder()
                     .artifactId(task.getProductId())
                     .artifactNumber(needTaskext.getSortNumber())
                     .artifactTaskId(task.getId())
                     .artifactTaskProcessId(taskTaskPorcessMap.get(task.getId()))
                     .boolArtifactComplete(Boolean.FALSE)
                     .boolAssembleComplete(Boolean.TRUE)
                     .boolOneCode(boolOneCode)
                     .build();
                  TechArtifact artifact = artifactMap.get(task.getProductId());
                  if (artifact.getBuildingType().equals(InventoryTypeEnum.GRID.getType()) && artifact.getBoolSendDirectly()) {
                     link.setBoolArtifactReport(Boolean.TRUE);
                     link.setBoolArtifactComplete(Boolean.TRUE);
                     link.setBoolArtifactInproduce(Boolean.TRUE);
                     link.setBoolArtifactInspection(Boolean.TRUE);
                     link.setArtifactTaskProcessId(0L);
                  }

                  links.add(link);
               }
            }
         }

         this.mesBuildingTaskNumberLinkService.saveBatch(links);
         this.unProcessSendPart(links, TaskTypeEnum.ARTIFACT.getType(), null);

         for (MesBuildingTaskNumberLink link : links) {
            if (link.getAssembleId() != null) {
               List<IDAndQuantityDTO> linkList = assArtifactlinkMap.get(link.getAssembleId());
               if (CollectionUtils.isEmpty(linkList)) {
                  linkList = new ArrayList<>();
               }

               IDAndQuantityDTO build = IDAndQuantityDTO.builder().id(link.getId()).quantity(1).build();
               linkList.add(build);
               assArtifactlinkMap.put(link.getAssembleId(), linkList);
            }
         }
      }

      return assArtifactlinkMap;
   }

   private Map<Long, List<IDAndQuantityDTO>> saveArtifactTaskOrderLink2(
      MesBuildingTopTaskOrder topTaskOrder, Long taskOrderId, List<MesBuildingTaskOrderArtifactDetailDTOParam> artifactTaskList, Long prodLineId
   ) {
      MesBuildingProductionLine prodLine = this.productionLineBiz.getById(prodLineId);
      List<TechArtifact> artifacts = new ArrayList<>();
      Map<Long, TechArtifact> artifactMap = new HashMap<>();
      Map<Long, List<TechAssembleDetail>> assembleDetailMap = new HashMap<>();
      List<MesBuildingProductProcess> productProcessList = this.productProcessService
         .list(Wrappers.lambdaQuery(MesBuildingProductProcess.class).eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE));
      productProcessList = productProcessList.stream().filter(item -> item.getPartType() == null).collect(Collectors.toList());
      Map<String, MesBuildingProductProcess> productProcessMap = productProcessList.stream()
         .collect(Collectors.toMap(s -> s.getProductionLineId() + "_" + s.getProductType() + "_" + s.getTypeId(), Function.identity()));
      if (artifactTaskList != null) {
         List<Long> artIds = artifactTaskList.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getProductId).collect(Collectors.toList());
         artifacts = this.artifactService.listByIds(artIds);
         artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         List<TechAssembleDetail> assembleDetails = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artIds));
         List<Long> assIds = assembleDetails.stream().map(TechAssembleDetail::getAssembleId).distinct().collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(assIds)) {
            List<Long> assExistIds = this.assembleService.listByIds(assIds).stream().map(TechAssemble::getId).collect(Collectors.toList());
            assembleDetailMap = assembleDetails.stream()
               .filter(s -> assExistIds.contains(s.getAssembleId()))
               .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
         }
      }

      Map<Long, List<IDAndQuantityDTO>> assArtifactlinkMap = new HashMap<>();
      if (artifactTaskList != null) {
         Map<Long, Integer> scheduMap = artifactTaskList.stream()
            .collect(
               Collectors.toMap(MesBuildingTaskOrderArtifactDetailDTOParam::getProductId, MesBuildingTaskOrderArtifactDetailDTOParam::getQuantity, Integer::sum)
            );
         Map<Long, Integer> taskMap = this.taskBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                  .in(MesBuildingTask::getProductId, scheduMap.keySet())
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingTask::getProductId, MesBuildingTask::getTaskQuantity, Integer::sum));

         for (Long id : scheduMap.keySet()) {
            Integer listQuantity = artifactMap.get(id).getQuantity();
            Integer taskQuantity = taskMap.get(id) == null ? 0 : taskMap.get(id);
            Integer schQuantity = scheduMap.get(id);
            if (listQuantity == null) {
               Preconditions.checkArgument(false, "任务下发失败,找不到该构件!!!");
            } else {
               Preconditions.checkArgument(listQuantity >= taskQuantity + schQuantity, "任务下发失败,构件下发数不可大于清单数,请刷新后重试!!!");
            }
         }

         List<Long> schedulingIds = artifactTaskList.stream().map(MesBuildingTaskOrderArtifactDetailDTOParam::getSchedulingId).collect(Collectors.toList());
         List<MesBuildingTask> tasks = new ArrayList<>();

         for (MesBuildingTaskOrderArtifactDetailDTOParam needTask : artifactTaskList) {
            TechArtifact artifact = artifactMap.get(needTask.getProductId());
            boolean boolOneCode = artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType());
            String key = prodLine.getId() + "_" + TaskTypeEnum.ARTIFACT.getType() + "_" + artifact.getStructureClassId();
            MesBuildingProductProcess productProcess = productProcessMap.get(key);
            if (!artifact.getBoolAllPartSendDirectly()) {
               Preconditions.checkArgument(productProcess != null, "操作失败!!!构件工序未配置!!!");
            }

            MesBuildingTask task = MesBuildingTask.builder()
               .projectId(artifact.getProjectId())
               .monomerId(artifact.getMonomerId())
               .areaId(artifact.getAreaId())
               .areaBatchId(artifact.getAreaBatchId())
               .factoryId(prodLine.getFactoryId())
               .workshopId(prodLine.getWorkshopId())
               .productionLineId(prodLine.getId())
               .productId(needTask.getProductId())
               .classificationId(artifact.getStructureClassId())
               .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
               .productProcessId(productProcess == null ? 0L : productProcess.getId())
               .schedulingId(needTask.getSchedulingId())
               .taskQuantity(needTask.getQuantity())
               .askCompleteTime(needTask.getAskCompleteTime())
               .userId(UserUtil.getCurrentUserId())
               .taskOrderId(taskOrderId)
               .topTaskOrderId(topTaskOrder.getId())
               .boolOneCode(boolOneCode)
               .build();
            if (artifact.getBuildingType().equals(InventoryTypeEnum.GRID.getType()) && artifact.getBoolSendDirectly()) {
               task.setBoolCompleteEnum(1L);
               task.setCompleteQuantity(task.getTaskQuantity());
               task.setCompleteQuantity(task.getTaskQuantity());
               task.setInProductionQuantity(task.getTaskQuantity());
               task.setInProductionQuantity(task.getTaskQuantity());
               task.setCompleteTime(LocalDateTime.now());
            }

            tasks.add(task);
         }

         this.taskService.saveBatch(tasks);
         this.recordNewTaskQuantities(tasks);
         Map<Long, Long> taskTaskPorcessMap = this.taskBiz.addAllTaskProces(tasks, artifactMap, null, TaskTypeEnum.ARTIFACT.getType());
         this.saveSchedulingPartsDataForTasks2(tasks, artifactMap, null, TaskTypeEnum.ARTIFACT.getType(), Boolean.TRUE);
         List<TechArtifactExt> needTaskExts = this.artifactExtService
            .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getSchedulingId, schedulingIds).eq(TechArtifactExt::getBoolTask, false));
         Map<Long, List<TechArtifactExt>> artExtMap = needTaskExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getSchedulingId));

         for (MesBuildingTask task : tasks) {
            List<TechArtifactExt> artifactExts = artExtMap.get(task.getSchedulingId());
            artifactExts.sort(Comparator.comparing(TechArtifactExt::getSortNumber));
            Preconditions.checkArgument(artifactExts.size() >= task.getTaskQuantity(), "操作失败!!!构件任务下发数大于当前可下发数,请刷新页面后重试!!!!");
            List<TechArtifactExt> needTaskExt = artifactExts.stream().limit(task.getTaskQuantity().intValue()).collect(Collectors.toList());

            for (TechArtifactExt techArtifactExt : needTaskExt) {
               techArtifactExt.setTaskId(task.getId());
               techArtifactExt.setBoolTask(Boolean.TRUE);
            }

            artExtMap.put(task.getSchedulingId(), needTaskExt);
         }

         List<TechArtifactExt> extList = artExtMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
         this.artifactExtService.updateBatchById(extList);
         CappWeldingCraftConfigDTO cappWeldingCraft = this.configService.getCappWeldingCraft();
         if (cappWeldingCraft != null && cappWeldingCraft.getUsageMode().equals(CappWeldingCraftUsageModeEnum.INDEPENDENT_MANIFESTATION.getUsageMode())) {
            List<CappCraftProductTaskSaveDTO> cappCraftProductTaskSaveDTOS = tasks.stream().map(item -> {
               CappCraftProductTaskSaveDTO cappCraftProductTaskSaveDTO = BeanUtil.copy(item, CappCraftProductTaskSaveDTO.class);
               cappCraftProductTaskSaveDTO.setProductionLineId(item.getProductionLineId());
               cappCraftProductTaskSaveDTO.setMesBuildingTaskId(item.getId());
               return cappCraftProductTaskSaveDTO;
            }).collect(Collectors.toList());
            this.cappCraftProductTaskBiz
               .generateCappTaksRecord(
                  new ArrayList<>(), extList, cappCraftProductTaskSaveDTOS, com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType()
               );
         }

         this.saveAllsendArtifct(artifacts, tasks, artExtMap);
         List<MesBuildingTaskNumberLink> links = new ArrayList<>();

         for (MesBuildingTask task : tasks) {
            List<TechArtifactExt> needTaskExt = artExtMap.get(task.getSchedulingId());
            Preconditions.checkArgument(needTaskExt.size() == task.getTaskQuantity(), "操作失败!!!请联系管理员!!!");
            Boolean boolOneCode = task.getBoolOneCode();

            for (TechArtifactExt needTaskext : needTaskExt) {
               List<TechAssembleDetail> linkAssmble = assembleDetailMap.get(needTaskext.getArtifactId());
               if (CollectionUtils.isNotEmpty(linkAssmble)) {
                  for (TechAssembleDetail assembleDetail : linkAssmble) {
                     for (int i = 0; i < assembleDetail.getQuantity(); i++) {
                        MesBuildingTaskNumberLink link = MesBuildingTaskNumberLink.builder()
                           .artifactId(task.getProductId())
                           .assembleId(assembleDetail.getAssembleId())
                           .artifactNumber(needTaskext.getSortNumber())
                           .artifactTaskId(task.getId())
                           .artifactTaskProcessId(taskTaskPorcessMap.getOrDefault(task.getId(), 0L))
                           .boolArtifactComplete(Boolean.FALSE)
                           .boolOneCode(boolOneCode)
                           .build();
                        links.add(link);
                     }
                  }
               } else {
                  MesBuildingTaskNumberLink link = MesBuildingTaskNumberLink.builder()
                     .artifactId(task.getProductId())
                     .artifactNumber(needTaskext.getSortNumber())
                     .artifactTaskId(task.getId())
                     .artifactTaskProcessId(taskTaskPorcessMap.get(task.getId()))
                     .boolArtifactComplete(Boolean.FALSE)
                     .boolAssembleComplete(Boolean.TRUE)
                     .boolOneCode(boolOneCode)
                     .build();
                  TechArtifact artifact = artifactMap.get(task.getProductId());
                  if (artifact.getBuildingType().equals(InventoryTypeEnum.GRID.getType()) && artifact.getBoolSendDirectly()) {
                     link.setBoolArtifactReport(Boolean.TRUE);
                     link.setBoolArtifactComplete(Boolean.TRUE);
                     link.setBoolArtifactInproduce(Boolean.TRUE);
                     link.setBoolArtifactInspection(Boolean.TRUE);
                     link.setArtifactTaskProcessId(0L);
                  }

                  links.add(link);
               }
            }
         }

         this.mesBuildingTaskNumberLinkService.saveBatch(links);
         this.unProcessSendPart(links, TaskTypeEnum.ARTIFACT.getType(), null);

         for (MesBuildingTaskNumberLink link : links) {
            if (link.getAssembleId() != null) {
               List<IDAndQuantityDTO> linkList = assArtifactlinkMap.get(link.getAssembleId());
               if (CollectionUtils.isEmpty(linkList)) {
                  linkList = new ArrayList<>();
               }

               IDAndQuantityDTO build = IDAndQuantityDTO.builder().id(link.getId()).quantity(1).build();
               linkList.add(build);
               assArtifactlinkMap.put(link.getAssembleId(), linkList);
            }
         }
      }

      return assArtifactlinkMap;
   }

   private void saveAllsendArtifct(List<TechArtifact> artifacts, List<MesBuildingTask> tasks, Map<Long, List<TechArtifactExt>> artExtMap) {
      List<ProductIdAndProcessDO> boolenProcess = this.baseService
         .listBoolenProcessBase(tasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList()));
      Map<Long, Boolean> booleanMap = boolenProcess.stream()
         .collect(Collectors.toMap(ProductIdAndProcessDO::getProductId, ProductIdAndProcessDO::getBoolenProcess, (s1, s2) -> s1));
      List<MesBuildingSinglePartArtifactPrint> sings = new ArrayList<>();
      List<Long> allSendArtIds = artifacts.stream().filter(TechArtifact::getBoolAllPartSendDirectly).map(TechArtifact::getId).collect(Collectors.toList());

      for (MesBuildingTask task : tasks.stream().filter(s -> allSendArtIds.contains(s.getProductId())).collect(Collectors.toList())) {
         for (TechArtifactExt techArtifactExt : artExtMap.get(task.getSchedulingId())) {
            sings.add(
               MesBuildingSinglePartArtifactPrint.builder()
                  .productId(task.getProductId())
                  .taskId(task.getId())
                  .workshopId(task.getWorkshopId())
                  .number(techArtifactExt.getSortNumber())
                  .taskQuantity(1)
                  .quantity(booleanMap.getOrDefault(task.getProductId(), Boolean.FALSE) ? 0 : 1)
                  .operationId(UserUtil.getCurrentUserId())
                  .build()
            );
         }
      }

      this.singlePartArtifactPrintService.saveBatch(sings);
   }

   private Boolean saverMachinePartTaskOrderLinkList(
      Long taskOrderId,
      MesBuildingNestCutPlate nestCutPlate,
      MesBuildingTeam drillGroups,
      LocalDateTime drillAskCompleteTime,
      MesBuildingMachinePartSchedulingDTOParam dtoParamOld
   ) {
      Map<Long, MesBuildingNestCutPlatePart> nestCutPlatePartMap = new HashMap<>();
      List<MesBuildingNestCutPlatePart> nestCutPlatePartList = this.nestCutPlatePartBiz
         .list(Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class).eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutPlate.getId()));
      nestCutPlatePartList.forEach(e -> {
         MesBuildingNestCutPlatePart var10000 = nestCutPlatePartMap.put(e.getPartId(), e);
      });
      List<TechMachinePart> machinePartLinkList = this.machinePartService.listByIds(nestCutPlatePartMap.keySet());
      Long extracted = this.extracted(dtoParamOld);
      List<MesBuildingTask> mesBuildingTaskList = new ArrayList<>();
      machinePartLinkList.forEach(
         e -> {
            MesBuildingTask task = MesBuildingTask.builder()
               .projectId(e.getProjectId())
               .monomerId(e.getMonomerId())
               .areaId(e.getAreaId())
               .factoryId(nestCutPlate.getFactoryId())
               .workshopId(nestCutPlate.getWorkshopId())
               .productionLineId(nestCutPlate.getProductionLineId())
               .groupsId(nestCutPlate.getGroupsId())
               .productId(e.getId())
               .nestCutPlateId(nestCutPlatePartMap.get(e.getId()).getMesBuildingNestCutPlateId())
               .classificationId(e.getSteelId())
               .taskTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
               .productProcessId(extracted)
               .machinePartSchedulingId(nestCutPlate.getMachinePartSchedulingId())
               .taskQuantity(nestCutPlatePartMap.get(e.getId()).getQuantity())
               .askCompleteTime(nestCutPlate.getAskCompleteTime())
               .userId(UserUtil.getCurrentUserId())
               .taskOrderId(taskOrderId)
               .build();
            mesBuildingTaskList.add(task);
         }
      );
      this.taskFastBiz.saveBatch(mesBuildingTaskList);
      this.taskBiz.addPartTaskProcessFast(mesBuildingTaskList, drillGroups, drillAskCompleteTime, nestCutPlate, dtoParamOld);
      this.saveNestCutMachinePartSeparate(taskOrderId, nestCutPlate.getId());
      return Boolean.TRUE;
   }

   private Long extracted(MesBuildingMachinePartSchedulingDTOParam dtoParamOld) {
      Long cutConfigId = dtoParamOld.getCutConfigId();
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
      Integer deviceType = mesBuildingMachinePartTeamDetail.getDeviceType();
      Long productionLineId = mesBuildingMachinePartTeamDetail.getProductionLineId();
      MesBuildingProductionLine mesBuildingProductionLine = this.lineService.getById(productionLineId);
      Long workshopId = mesBuildingProductionLine.getWorkshopId();
      Long teamId = null;
      Integer drillDeviceType = null;
      MesBuildingMachinePartTeamDetail drillMesBuildingMachinePartTeamDetail = null;
      if (null != dtoParamOld.getDrillCutConfigId()) {
         drillMesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(dtoParamOld.getDrillCutConfigId());
         teamId = drillMesBuildingMachinePartTeamDetail.getGroupsId();
         drillDeviceType = drillMesBuildingMachinePartTeamDetail.getDeviceType();
      }

      AtomicReference<Long> drillProductProcessId = new AtomicReference<>();
      List<MesBuildingProductProcessLink> mesBuildingProductProcessLinkList = this.productProcessLinkService
         .list(
            (Wrapper<MesBuildingProductProcessLink>)(new LambdaQueryWrapper<MesBuildingProductProcessLink>().eq(MesBuildingProductProcessLink::getProcessId, deviceType))
               .eq(MesBuildingProductProcessLink::getTeamId, mesBuildingMachinePartTeamDetail.getGroupsId())
         );
      if (CollectionUtils.isNotEmpty(mesBuildingProductProcessLinkList)) {
         List<Long> productProcessIds = mesBuildingProductProcessLinkList.stream()
            .map(MesBuildingProductProcessLink::getProductProcessId)
            .collect(Collectors.toList());
         List<MesBuildingProductProcessLink> processLinks = this.productProcessLinkService
            .list((Wrapper<MesBuildingProductProcessLink>)new LambdaQueryWrapper<MesBuildingProductProcessLink>().in(MesBuildingProductProcessLink::getProductProcessId, productProcessIds));
         if (null != dtoParamOld.getDrillCutConfigId()) {
            Integer finalDrillDeviceType = drillDeviceType;
            Long finalTeamId = teamId;
            List<MesBuildingProductProcessLink> collect = processLinks.stream()
               .filter(e -> e.getProcessId().equals(finalDrillDeviceType))
               .filter(e -> e.getTeamId().equals(finalTeamId))
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(collect)) {
               drillProductProcessId.set(collect.get(0).getProductProcessId());
            }
         }

         if (drillProductProcessId.get() == null && null == dtoParamOld.getDrillCutConfigId()) {
            drillProductProcessId.set(mesBuildingProductProcessLinkList.get(0).getProductProcessId());
         }
      }

      if (drillProductProcessId.get() == null) {
         MesBuildingProductProcess newProductProcess = MesBuildingProductProcess.builder()
            .productType(1)
            .typeId(0L)
            .userId(UserUtil.getCurrentUserId())
            .productionLineId(productionLineId)
            .partType(mesBuildingMachinePartTeamDetail.getPartType())
            .workshopId(workshopId)
            .build();
         this.productProcessService.save(newProductProcess);
         MesBuildingProductProcessLink mesBuildingProductProcessLink = MesBuildingProductProcessLink.builder()
            .productProcessId(newProductProcess.getId())
            .processId((long)deviceType.intValue())
            .sequence(0)
            .nodeTime(0)
            .partProdMode(mesBuildingMachinePartTeamDetail.getPartProdMode())
            .boolFixedProcess(true)
            .teamId(mesBuildingMachinePartTeamDetail.getGroupsId())
            .build();
         this.productProcessLinkService.save(mesBuildingProductProcessLink);
         if (null != dtoParamOld.getDrillCutConfigId()) {
            MesBuildingProductProcessLink drillMesBuildingProductProcessLink = MesBuildingProductProcessLink.builder()
               .productProcessId(newProductProcess.getId())
               .processId((long)drillDeviceType.intValue())
               .sequence(1)
               .nodeTime(0)
               .partProdMode(drillMesBuildingMachinePartTeamDetail.getPartProdMode())
               .boolFixedProcess(true)
               .teamId(drillMesBuildingMachinePartTeamDetail.getGroupsId())
               .build();
            this.productProcessLinkService.save(drillMesBuildingProductProcessLink);
         }

         drillProductProcessId.set(newProductProcess.getId());
      }

      return drillProductProcessId.get();
   }

   private Boolean saverMachinePartTaskOrderLinkList2(
      Long taskOrderId, MesBuildingNestCutPlate nestCutPlate, MesBuildingProductionLine prodLines, LocalDateTime drillAskCompleteTime
   ) {
      Map<Long, MesBuildingNestCutPlatePart> nestCutPlatePartMap = new HashMap<>();
      List<MesBuildingNestCutPlatePart> nestCutPlatePartList = this.nestCutPlatePartBiz
         .list(Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class).eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutPlate.getId()));
      nestCutPlatePartList.forEach(e -> {
         MesBuildingNestCutPlatePart var10000 = nestCutPlatePartMap.put(e.getPartId(), e);
      });
      List<TechMachinePart> machinePartLinkList = this.machinePartService.listByIds(nestCutPlatePartMap.keySet());
      machinePartLinkList.forEach(
         e -> {
            MesBuildingTask task = MesBuildingTask.builder()
               .projectId(e.getProjectId())
               .monomerId(e.getMonomerId())
               .areaId(e.getAreaId())
               .factoryId(nestCutPlate.getFactoryId())
               .workshopId(nestCutPlate.getWorkshopId())
               .productionLineId(nestCutPlate.getProductionLineId())
               .productId(e.getId())
               .nestCutPlateId(nestCutPlatePartMap.get(e.getId()).getMesBuildingNestCutPlateId())
               .classificationId(e.getSteelId())
               .taskTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
               .productProcessId(
                  this.utilsBiz
                     .getProductProcessIdByClassificationIdAndType(e.getSteelId(), ProductTypeEnum.MACHINE_PART.getType(), nestCutPlate.getProductionLineId())
               )
               .machinePartSchedulingId(nestCutPlate.getMachinePartSchedulingId())
               .taskQuantity(nestCutPlatePartMap.get(e.getId()).getQuantity())
               .askCompleteTime(nestCutPlate.getAskCompleteTime())
               .userId(UserUtil.getCurrentUserId())
               .taskOrderId(taskOrderId)
               .build();
            this.taskBiz.save(task);
            this.newTaskBiz.addPartTaskProcess2(task, prodLines, drillAskCompleteTime);
         }
      );
      this.saveNestCutMachinePartSeparate2(taskOrderId, nestCutPlate.getId());
      return Boolean.TRUE;
   }

   @Override
   public void saveMachinePartSeparate(Long id) {
      MesBuildingTaskOrder taskOrder = this.getById(id);
      MesBuildingMachinePartScheduling machinePartScheduling = this.machinePartSchedulingBiz.getById(taskOrder.getSchedulingId());
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> artifactTaskLinkList = this.machinePartSchedulingArtifactTaskLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingArtifactTaskLink.class)
               .eq(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingId, machinePartScheduling.getId())
         );
      if (artifactTaskLinkList != null && artifactTaskLinkList.size() > 0) {
         Map<Long, MesBuildingTaskNeedMachinePartScheduling> needMachinePartSchedulingLinkMap = this.taskNeedMachinePartSchedulingBiz
            .listByIds(artifactTaskLinkList.stream().map(MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(MesBuildingTaskNeedMachinePartScheduling::getId, Function.identity()));
         artifactTaskLinkList.forEach(
            e -> this.machinePartSeparateBiz
               .save(
                  MesBuildingMachinePartSeparate.builder()
                     .productId(needMachinePartSchedulingLinkMap.get(e.getNeedLinkId()).getProductId())
                     .quantity(e.getQuantity())
                     .groupsId(needMachinePartSchedulingLinkMap.get(e.getNeedLinkId()).getGroupsId())
                     .taskOrderId(id)
                     .taskId(e.getTaskId())
                     .cunQuantity(0)
                     .userId(UserUtil.getCurrentUserId())
                     .schedulingId(taskOrder.getSchedulingId())
                     .build()
               )
         );
      }
   }

   @Override
   public void saveMachinePartSeparate2(Long id) {
      MesBuildingTaskOrder taskOrder = this.getById(id);
      MesBuildingMachinePartScheduling machinePartScheduling = this.machinePartSchedulingBiz.getById(taskOrder.getSchedulingId());
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> artifactTaskLinkList = this.machinePartSchedulingArtifactTaskLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingArtifactTaskLink.class)
               .eq(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingId, machinePartScheduling.getId())
         );
      if (artifactTaskLinkList != null && artifactTaskLinkList.size() > 0) {
         Map<Long, MesBuildingTaskNeedMachinePartScheduling> needMachinePartSchedulingLinkMap = this.taskNeedMachinePartSchedulingBiz
            .listByIds(artifactTaskLinkList.stream().map(MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(MesBuildingTaskNeedMachinePartScheduling::getId, Function.identity()));
         artifactTaskLinkList.forEach(
            e -> this.machinePartSeparateBiz
               .save(
                  MesBuildingMachinePartSeparate.builder()
                     .productId(needMachinePartSchedulingLinkMap.get(e.getNeedLinkId()).getProductId())
                     .quantity(e.getQuantity())
                     .productionLineId(needMachinePartSchedulingLinkMap.get(e.getNeedLinkId()).getProductionLineId())
                     .taskOrderId(id)
                     .taskId(e.getTaskId())
                     .cunQuantity(0)
                     .userId(UserUtil.getCurrentUserId())
                     .schedulingId(taskOrder.getSchedulingId())
                     .build()
               )
         );
      }
   }

   @Override
   public void saveNestCutMachinePartSeparate(Long taskOrderId, Long nestCutId) {
      MesBuildingNestCutPlate cut = this.nestCutPlateBiz.getById(nestCutId);
      List<MesBuildingNestCutPlatePart> nestCutPlatePartList = this.nestCutPlatePartBiz
         .list(Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class).eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutId));
      List<MesBuildingMachinePartSeparate> machinePartSeparateList = this.machinePartSeparateBiz
         .list(Wrappers.lambdaQuery(MesBuildingMachinePartSeparate.class).eq(MesBuildingMachinePartSeparate::getTaskOrderId, taskOrderId));
      if (machinePartSeparateList.size() > 0) {
         Map<Long, List<MesBuildingMachinePartSeparate>> machinePartSeparateListMap = machinePartSeparateList.stream()
            .filter(e -> !e.getQuantity().equals(e.getCunQuantity()))
            .collect(Collectors.groupingBy(MesBuildingMachinePartSeparate::getProductId));
         MesBuildingTaskOrder taskOrder = this.getById(taskOrderId);
         List<Long> partIdList = nestCutPlatePartList.stream().map(MesBuildingNestCutPlatePart::getPartId).collect(Collectors.toList());
         Map<Long, Boolean> boolDrillHoleFast = this.cutConfigBiz.getBoolDrillHoleFast(partIdList, taskOrder.getCutConfigId());
         nestCutPlatePartList.forEach(
            part -> {
               AtomicReference<Integer> quantity = new AtomicReference<>(part.getQuantity());
               if (machinePartSeparateListMap.get(part.getPartId()) != null) {
                  machinePartSeparateListMap.get(part.getPartId())
                     .forEach(
                        list -> {
                           if (quantity.get() > 0) {
                              Integer separateQuantity = 0;
                              if (quantity.get() <= list.getQuantity() - list.getCunQuantity()) {
                                 separateQuantity = quantity.get();
                                 this.machinePartSeparateBiz
                                    .updateById(
                                       MesBuildingMachinePartSeparate.builder().id(list.getId()).cunQuantity(list.getCunQuantity() + quantity.get()).build()
                                    );
                                 quantity.set(0);
                              } else {
                                 separateQuantity = list.getQuantity() - list.getCunQuantity();
                                 this.machinePartSeparateBiz
                                    .updateById(MesBuildingMachinePartSeparate.builder().id(list.getId()).cunQuantity(list.getQuantity()).build());
                                 quantity.set(quantity.get() - (list.getQuantity() - list.getCunQuantity()));
                              }

                              Boolean drillBoolean = Boolean.FALSE;
                              if (null != boolDrillHoleFast.get(part.getPartId())) {
                                 drillBoolean = boolDrillHoleFast.get(part.getPartId());
                              }

                              MesBuildingTask mesBuildingTask = this.taskService.getById(list.getTaskId());
                              MesBuildingNestCutMachinePartSeparate build = MesBuildingNestCutMachinePartSeparate.builder()
                                 .nestCutId(nestCutId)
                                 .schedulingId(list.getSchedulingId())
                                 .taskOrderId(list.getTaskOrderId())
                                 .quantity(separateQuantity)
                                 .productId(part.getPartId())
                                 .userId(UserUtil.getCurrentUserId())
                                 .groupsId(list.getGroupsId())
                                 .processType(
                                    this.cutConfigBiz.getBoolDrillHoleNew(part.getPartId(), taskOrder.getCutConfigId(), mesBuildingTask.getProductProcessId())
                                       ? ProcessTypeEnum.DRILL_HOLE.getType()
                                       : ProcessTypeEnum.MAKINGS.getType()
                                 )
                                 .workshopId(list.getWorkshopId())
                                 .build();
                              if (cut.getBoolOffLine()) {
                                 build.setProcessType(ProcessTypeEnum.MAKINGS.getType());
                              }

                              this.nestCutMachinePartSeparateBiz.save(build);
                           }
                        }
                     );
               }
            }
         );
      }
   }

   @Override
   public void saveNestCutMachinePartSeparate2(Long taskOrderId, Long nestCutId) {
      MesBuildingNestCutPlate cut = this.nestCutPlateBiz.getById(nestCutId);
      List<MesBuildingNestCutPlatePart> nestCutPlatePartList = this.nestCutPlatePartBiz
         .list(Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class).eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutId));
      List<MesBuildingMachinePartSeparate> machinePartSeparateList = this.machinePartSeparateBiz
         .list(Wrappers.lambdaQuery(MesBuildingMachinePartSeparate.class).eq(MesBuildingMachinePartSeparate::getTaskOrderId, taskOrderId));
      if (machinePartSeparateList.size() > 0) {
         Map<Long, List<MesBuildingMachinePartSeparate>> machinePartSeparateListMap = machinePartSeparateList.stream()
            .filter(e -> !e.getQuantity().equals(e.getCunQuantity()))
            .collect(Collectors.groupingBy(MesBuildingMachinePartSeparate::getProductId));
         MesBuildingTaskOrder taskOrder = this.getById(taskOrderId);
         nestCutPlatePartList.forEach(
            part -> {
               AtomicReference<Integer> quantity = new AtomicReference<>(part.getQuantity());
               if (machinePartSeparateListMap.get(part.getPartId()) != null) {
                  machinePartSeparateListMap.get(part.getPartId())
                     .forEach(
                        list -> {
                           if (quantity.get() > 0) {
                              Integer separateQuantity = 0;
                              if (quantity.get() <= list.getQuantity() - list.getCunQuantity()) {
                                 separateQuantity = quantity.get();
                                 this.machinePartSeparateBiz
                                    .updateById(
                                       MesBuildingMachinePartSeparate.builder().id(list.getId()).cunQuantity(list.getCunQuantity() + quantity.get()).build()
                                    );
                                 quantity.set(0);
                              } else {
                                 separateQuantity = list.getQuantity() - list.getCunQuantity();
                                 this.machinePartSeparateBiz
                                    .updateById(MesBuildingMachinePartSeparate.builder().id(list.getId()).cunQuantity(list.getQuantity()).build());
                                 quantity.set(quantity.get() - (list.getQuantity() - list.getCunQuantity()));
                              }

                              MesBuildingNestCutMachinePartSeparate build = MesBuildingNestCutMachinePartSeparate.builder()
                                 .nestCutId(nestCutId)
                                 .schedulingId(list.getSchedulingId())
                                 .taskOrderId(list.getTaskOrderId())
                                 .quantity(separateQuantity)
                                 .productId(part.getPartId())
                                 .userId(UserUtil.getCurrentUserId())
                                 .productionLineId(list.getProductionLineId())
                                 .processType(
                                    this.cutConfigBiz.getBoolDrillHole(part.getPartId(), taskOrder.getCutConfigId())
                                       ? ProcessTypeEnum.DRILL_HOLE.getType()
                                       : ProcessTypeEnum.MAKINGS.getType()
                                 )
                                 .workshopId(list.getWorkshopId())
                                 .build();
                              if (cut.getBoolOffLine()) {
                                 build.setProcessType(ProcessTypeEnum.MAKINGS.getType());
                              }

                              this.nestCutMachinePartSeparateBiz.save(build);
                           }
                        }
                     );
               }
            }
         );
      }
   }

   @Override
   public List<MesBuildingCutConfigDTO> getMachinePartCutConfig(List<Long> projectIds, List<Long> monomerIds, List<Long> areaIds, Integer processType) {
      List<MesBuildingProcess> process = this.processService.list(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getType, processType));
      if (CollectionUtils.isEmpty(process)) {
         return new ArrayList<>();
      }

      List<Long> processIds = process.stream().map(MesBuildingProcess::getId).collect(Collectors.toList());
      List<MesBuildingCutConfigDO> configDOList = this.getMachinePartTaskList(
            null, projectIds, monomerIds, areaIds, null, processType, processIds, null, null, null, null, null
         )
         .stream()
         .map(MesBuildingMachineTaskOrderDTO::getConfig)
         .distinct()
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(configDOList)) {
         configDOList.forEach(e -> {
            String cutTypeName = this.mesBuildingTaskNeedMachinePartSchedulingMapper.getDictionaryByNameAndSort("device_type", Integer.valueOf(e.getName()));
            e.setName(cutTypeName);
         });
      }

      return configDOList.stream().map(e -> BeanUtil.copy(e, MesBuildingCutConfigDTO.class)).collect(Collectors.toList());
   }

   public Map<Long, Integer> updateArtifactScheduling(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      Map<Long, MesBuildingArtifactScheduling> oldArtifactSchedulingMap = new HashMap<>();
      this.artifactSchedulingBiz.listByIds(dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getId).collect(Collectors.toList())).forEach(e -> {
         MesBuildingArtifactScheduling var10000 = oldArtifactSchedulingMap.put(e.getId(), e);
      });
      Preconditions.checkArgument(oldArtifactSchedulingMap.size() == dtoParamList.size(), "操作失败：参数id不正确");
      dtoParamList.forEach(dtoParam -> {
         MesBuildingArtifactScheduling oldScheduling = oldArtifactSchedulingMap.get(dtoParam.getId());
         dtoParam.setAskCompleteTime(oldScheduling.getAskCompleteTime());
         dtoParam.setProductId(oldScheduling.getProductId());
         if (dtoParam.getGroupsId() != null) {
            Preconditions.checkArgument(!dtoParam.getGroupsId().equals(oldScheduling.getGroupsId()), "操作失败，不能分配到原生产组");
         }

         oldScheduling.setQuantity(oldScheduling.getQuantity() - dtoParam.getQuantity());
         if (oldScheduling.getQuantity() == 0) {
            this.artifactSchedulingBiz.removeById(oldScheduling);
         } else {
            oldScheduling.setUserId(UserUtil.getCurrentUserId());
            this.artifactSchedulingBiz.updateById(oldScheduling);
         }
      });
      return this.saveArtifactSchedulingList(dtoParamList);
   }

   public synchronized Map<Long, Integer> saveArtifactSchedulingList(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      Map<Long, Integer> idAndQuantityMap = new HashMap<>();
      Map<Long, MesBuildingGroups> groupsMap = new HashMap<>();
      List<MesBuildingGroups> mesBuildingGroups = this.groupsBiz
         .listByIds(dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getGroupsId).collect(Collectors.toList()));
      mesBuildingGroups.forEach(e -> {
         MesBuildingGroups var10000 = groupsMap.put(e.getId(), e);
      });
      Map<Long, MesBuildingProductionLine> productionLineMap = new HashMap<>();
      this.productionLineBiz.listByIds(mesBuildingGroups.stream().map(MesBuildingGroups::getProductionLineId).collect(Collectors.toList())).forEach(e -> {
         MesBuildingProductionLine var10000 = productionLineMap.put(e.getId(), e);
      });
      dtoParamList.forEach(
         dtoParam -> {
            TechArtifact artifact = this.artifactService.getById(dtoParam.getProductId());
            Preconditions.checkArgument(artifact != null, "错误，产品id不正确");
            Integer schedulingQuantity = this.artifactSchedulingBiz
               .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).eq(MesBuildingArtifactScheduling::getProductId, artifact.getId()))
               .stream()
               .mapToInt(MesBuildingArtifactScheduling::getQuantity)
               .sum();
            Preconditions.checkArgument(dtoParam.getQuantity() + schedulingQuantity <= artifact.getQuantity(), "错误,排产总数量不能大于清单数量!!!");
            MesBuildingArtifactScheduling artifactScheduling = this.artifactSchedulingBiz
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                     .eq(MesBuildingArtifactScheduling::getAskCompleteTime, dtoParam.getAskCompleteTime())
                     .eq(MesBuildingArtifactScheduling::getProductId, dtoParam.getProductId())
                     .eq(MesBuildingArtifactScheduling::getProductionLineId, dtoParam.getProductionLineId())
                     .eq(dtoParam.getGroupsId() != null, MesBuildingArtifactScheduling::getGroupsId, dtoParam.getGroupsId())
               );
            if (artifactScheduling != null) {
               this.artifactSchedulingBiz
                  .updateById(
                     MesBuildingArtifactScheduling.builder()
                        .id(artifactScheduling.getId())
                        .quantity(artifact.getQuantity() + dtoParam.getQuantity())
                        .userId(UserUtil.getCurrentUserId())
                        .build()
                  );
               idAndQuantityMap.merge(artifactScheduling.getId(), dtoParam.getQuantity(), Integer::sum);
            } else {
               MesBuildingArtifactScheduling newScheduling = MesBuildingArtifactScheduling.builder()
                  .productId(artifact.getId())
                  .projectId(artifact.getProjectId())
                  .monomerId(artifact.getMonomerId())
                  .areaId(artifact.getAreaId())
                  .areaBatchId(artifact.getAreaBatchId())
                  .factoryId(groupsMap.get(dtoParam.getGroupsId()).getFactoryId())
                  .workshopId(groupsMap.get(dtoParam.getGroupsId()).getWorkshopId())
                  .productionLineId(groupsMap.get(dtoParam.getGroupsId()).getProductionLineId())
                  .productionLineTypeEnum(productionLineMap.get(groupsMap.get(dtoParam.getGroupsId()).getProductionLineId()).getProductionLineTypeEnum())
                  .groupsId(dtoParam.getGroupsId())
                  .askCompleteTime(dtoParam.getAskCompleteTime())
                  .status(Boolean.TRUE)
                  .issueStatus(Boolean.FALSE)
                  .quantity(dtoParam.getQuantity())
                  .userId(UserUtil.getCurrentUserId())
                  .build();
               this.artifactSchedulingBiz.save(newScheduling);
               idAndQuantityMap.merge(newScheduling.getId(), dtoParam.getQuantity(), Integer::sum);
            }
         }
      );
      return idAndQuantityMap;
   }

   public synchronized Map<Long, Integer> saveArtifactSchedulingList2(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      Map<Long, Integer> idAndQuantityMap = new HashMap<>();
      Map<Long, MesBuildingProductionLine> linesMap = new HashMap<>();
      List<MesBuildingProductionLine> mesBuildingLines = this.productionLineBiz
         .listByIds(dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getProductionLineId).collect(Collectors.toList()));
      mesBuildingLines.forEach(e -> {
         MesBuildingProductionLine var10000 = linesMap.put(e.getId(), e);
      });
      Map<Long, MesBuildingProductionLine> productionLineMap = new HashMap<>();
      this.productionLineBiz.listByIds(mesBuildingLines.stream().map(MesBuildingProductionLine::getId).collect(Collectors.toList())).forEach(e -> {
         MesBuildingProductionLine var10000 = productionLineMap.put(e.getId(), e);
      });
      dtoParamList.forEach(
         dtoParam -> {
            TechArtifact artifact = this.artifactService.getById(dtoParam.getProductId());
            Preconditions.checkArgument(artifact != null, "错误，产品id不正确");
            Integer schedulingQuantity = this.artifactSchedulingBiz
               .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).eq(MesBuildingArtifactScheduling::getProductId, artifact.getId()))
               .stream()
               .mapToInt(MesBuildingArtifactScheduling::getQuantity)
               .sum();
            Preconditions.checkArgument(dtoParam.getQuantity() + schedulingQuantity <= artifact.getQuantity(), "错误,排产总数量不能大于清单数量!!!");
            MesBuildingArtifactScheduling artifactScheduling = this.artifactSchedulingBiz
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                     .eq(MesBuildingArtifactScheduling::getAskCompleteTime, dtoParam.getAskCompleteTime())
                     .eq(MesBuildingArtifactScheduling::getProductId, dtoParam.getProductId())
                     .eq(MesBuildingArtifactScheduling::getProductionLineId, dtoParam.getProductionLineId())
               );
            if (artifactScheduling != null) {
               this.artifactSchedulingBiz
                  .updateById(
                     MesBuildingArtifactScheduling.builder()
                        .id(artifactScheduling.getId())
                        .quantity(artifact.getQuantity() + dtoParam.getQuantity())
                        .userId(UserUtil.getCurrentUserId())
                        .build()
                  );
               idAndQuantityMap.merge(artifactScheduling.getId(), dtoParam.getQuantity(), Integer::sum);
            } else {
               MesBuildingArtifactScheduling newScheduling = MesBuildingArtifactScheduling.builder()
                  .productId(artifact.getId())
                  .projectId(artifact.getProjectId())
                  .monomerId(artifact.getMonomerId())
                  .areaId(artifact.getAreaId())
                  .areaBatchId(artifact.getAreaBatchId())
                  .factoryId(linesMap.get(dtoParam.getProductionLineId()).getFactoryId())
                  .workshopId(linesMap.get(dtoParam.getProductionLineId()).getWorkshopId())
                  .productionLineId(linesMap.get(dtoParam.getProductionLineId()).getId())
                  .productionLineTypeEnum(productionLineMap.get(linesMap.get(dtoParam.getProductionLineId()).getId()).getProductionLineTypeEnum())
                  .askCompleteTime(dtoParam.getAskCompleteTime())
                  .status(Boolean.TRUE)
                  .issueStatus(Boolean.FALSE)
                  .quantity(dtoParam.getQuantity())
                  .userId(UserUtil.getCurrentUserId())
                  .build();
               this.artifactSchedulingBiz.save(newScheduling);
               idAndQuantityMap.merge(newScheduling.getId(), dtoParam.getQuantity(), Integer::sum);
            }
         }
      );
      return idAndQuantityMap;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getMachinePartDrillingPrint(Long cutId, Integer processType) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      MesBuildingNestCutPlate cut = this.nestCutPlateBiz.getById(cutId);
      Preconditions.checkArgument(cut != null, "工单不存在");
      Set<Long> ids = new HashSet<>();
      ids.add(cut.getGroupsId());
      List<MesBuildingGroupSumDO> GroupSumDOS = this.mesBuildingGroupsService.selectGroupsByids(ids);
      if (!CollectionUtils.isEmpty(GroupSumDOS)) {
         MesBuildingGroupSumDO groupSumDO = GroupSumDOS.get(0);
         IdAndNameDO lineDo = IdAndNameDO.builder().id(groupSumDO.getLineId()).name(groupSumDO.getLineName()).build();
         IdAndNameDO workshopDo = IdAndNameDO.builder().id(groupSumDO.getWorkshopId()).name(groupSumDO.getWorkshopName()).build();
         header.put("line", lineDo);
         header.put("workshop", workshopDo);
         header.put("workshopAndLine", groupSumDO.getLineName() + ">" + groupSumDO.getGroupName());
      } else {
         MesBuildingProductionLine line = this.lineService.getById(cut.getProductionLineId());
         MesBuildingWorkshop workshop = this.workshopService.getById(line.getWorkshopId());
         IdAndNameDO lineDo = IdAndNameDO.builder().id(line.getId()).name(line.getName()).build();
         IdAndNameDO workshopDo = IdAndNameDO.builder().id(workshop.getId()).name(workshop.getName()).build();
         header.put("line", lineDo);
         header.put("workshop", workshopDo);
         header.put("workshopAndLine", lineDo.getName());
      }

      header.put("serialNumber", cut.getCutNumber());
      header.put("process", ProcessTypeEnum.getNameByType(processType));
      header.put("scheduleUserName", this.userService.getNameById(cut.getIssueUserId()));
      List<MesBuildingMachineTaskDTO> list = this.getMachinePartDrilling(cutId, processType);
      if (CollUtil.isNotEmpty(list)) {
         MesBuildingMachineTaskDTO mesBuildingMachineTaskDTO = list.get(0);
         header.put("project", mesBuildingMachineTaskDTO.getProject());
      }

      MesBuildingMachinePartTeamDetail machinePartTeamDetail = this.machinePartTeamDetailService.getById(cut.getCutConfigId());
      Long teamId = machinePartTeamDetail.getGroupsId();
      ShowInfo team = this.mesBuildingTeamService.listInfoByIds(ListUtil.toList(teamId)).stream().findFirst().orElseGet(ShowInfo::new);
      header.put("teamName", team.getName());
      printVO.setHeader(header);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("id", cut.getTaskOrderId());
      jsonObject.put("ftype", 4);
      if (cut.getCutNumber().contains("(直)")) {
         jsonObject.put("type", 1);
      } else if (cut.getCutNumber().contains("(型)")) {
         jsonObject.put("type", 2);
      } else if (cut.getCutNumber().contains("(套)")) {
         jsonObject.put("type", 8);
      }

      printVO.setQrCode(jsonObject.toString());
      printVO.setTable(list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<MesBuildingAssistTaskOrderDTO> getTaskOrderAssistList(Long topTaskOrderId) {
      List<MesBuildingAssistTaskOrderDTO> dtoList = this.baseService
         .getTaskOrderAssistList(topTaskOrderId)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingAssistTaskOrderDTO.class))
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingAssistProcessDTO>> assistProcessMap = this.taskProcessBiz
         .getAssistProcessListByTaskOrderIdList(dtoList.stream().map(MesBuildingAssistTaskOrderDTO::getId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingAssistProcessDTO::getTaskOrderId));
      dtoList.forEach(
         e -> {
            List<MesBuildingAssistProcessDTO> mesBuildingAssistProcessDTOS = assistProcessMap.get(e.getId());
            if (CollectionUtils.isNotEmpty(mesBuildingAssistProcessDTOS)) {
               for (MesBuildingAssistProcessDTO processDTO : mesBuildingAssistProcessDTOS) {
                  List<IdAndNameDO> nextProcessDTOS = mesBuildingAssistProcessDTOS.stream()
                     .filter(process -> process.getSequence() > processDTO.getSequence())
                     .map(MesBuildingAssistProcessDTO::getProcess)
                     .collect(Collectors.toList());
                  processDTO.setNextProcessList(nextProcessDTOS);
               }
            }

            e.setProcessList(mesBuildingAssistProcessDTOS);
         }
      );
      return dtoList;
   }

   @Override
   public List<ProjectTreeResponseVO> getArtifactsTaskProjectList(LocalDateTime localDateTime, String name) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      List<ContractProject> projectList = this.contractProjectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getId, projectIds)
               .apply("DATE_FORMAT(create_time,'%Y')={0}", localDateTime.format(DateTimeFormatter.ofPattern("yyyy")))
               .like(name != null, ContractProject::getSerialNumber, name)
               .or()
               .like(name != null, ContractProject::getName, name)
               .or()
               .like(name != null, ContractProject::getShortName, name)
         );
      if (projectList.size() == 0) {
         return new ArrayList<>();
      }

      Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<Long> areaIdList = this.baseMapper.listAareaIds(projectIds);
      if (CollectionUtils.isEmpty(areaIdList)) {
         return new ArrayList<>();
      }

      List<PlanArea> areaList = this.areaService.listByIds(areaIdList);
      Map<Long, Map<Long, List<PlanArea>>> projectTreeMap = areaList.stream()
         .filter(e -> projectList.stream().map(ContractProject::getId).collect(Collectors.toList()).contains(e.getProjectId()))
         .collect(Collectors.groupingBy(PlanArea::getProjectId, Collectors.groupingBy(PlanArea::getMonomerId)));
      Map<Long, PlanMonomer> monomerMap = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).in(PlanMonomer::getProjectId, projectMap.keySet()))
         .stream()
         .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      List<ProjectTreeResponseVO> treeDto = new ArrayList<>();
      projectTreeMap.forEach((projectId, monomer) -> {
         ProjectTreeResponseVO project = new ProjectTreeResponseVO();
         project.setId(projectId);
         project.setName(projectMap.get(projectId).getName());
         project.setShortName(projectMap.get(projectId).getShortName());
         project.setSerialNumber(projectMap.get(projectId).getSerialNumber());
         List<MonomerTreeResponseVO> monomerChildren = new ArrayList<>();
         monomer.forEach((monomerId, area) -> {
            MonomerTreeResponseVO build1 = new MonomerTreeResponseVO();
            build1.setId(monomerId);
            build1.setName(monomerMap.get(monomerId).getName());
            List<AreaTreeResponseVO> areaChildren = new ArrayList<>();
            area.forEach(e -> {
               AreaTreeResponseVO build2 = new AreaTreeResponseVO();
               build2.setId(e.getId());
               build2.setName(e.getName());
               areaChildren.add(build2);
            });
            build1.setChildren(areaChildren);
            monomerChildren.add(build1);
         });
         project.setChildren(monomerChildren);
         treeDto.add(project);
      });
      treeDto.sort(Comparator.comparing(ProjectTreeResponseVO::getId).reversed());
      return treeDto;
   }

   @Override
   public List<ProjectTreeResponseVO> getArtifactsTaskProjectListV2(LocalDate monthDate, String name, Long workshopId) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      if (StringUtils.isNotBlank(name)) {
         List<ContractProject> projectList = this.contractProjectService
            .list(
               Wrappers.lambdaQuery(ContractProject.class)
                  .in(ContractProject::getId, projectIds)
                  .like(ContractProject::getSerialNumber, name)
                  .or()
                  .like(ContractProject::getName, name)
                  .or()
                  .like(ContractProject::getShortName, name)
            );
         projectIds = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      }

      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      List<ProjectResponseDTO> projectDTOList = this.baseMapper.getTaskProjectList(projectIds, workshopId, monthDate);
      if (CollectionUtils.isEmpty(projectDTOList)) {
         return new ArrayList<>();
      }

      Map<Long, ProjectResponseDTO> projectMap = projectDTOList.stream().collect(Collectors.toMap(ProjectResponseDTO::getId, Function.identity()));
      List<Long> areaIdList = this.baseMapper.listAareaIds(projectIds);
      if (CollectionUtils.isEmpty(areaIdList)) {
         return new ArrayList<>();
      }

      Map<Long, List<PlanAreaBatch>> areaBatchMap = this.areaBatchService
         .list((Wrapper<PlanAreaBatch>)new LambdaQueryWrapper<PlanAreaBatch>().in(PlanAreaBatch::getProjectId, projectMap.keySet()))
         .stream()
         .collect(Collectors.groupingBy(PlanAreaBatch::getAreaId));
      List<PlanArea> areaList = this.areaService.listByIds(areaIdList);
      Map<Long, Map<Long, List<PlanArea>>> projectTreeMap = areaList.stream()
         .filter(e -> projectDTOList.stream().map(ProjectResponseDTO::getId).collect(Collectors.toList()).contains(e.getProjectId()))
         .collect(Collectors.groupingBy(PlanArea::getProjectId, Collectors.groupingBy(PlanArea::getMonomerId)));
      Map<Long, PlanMonomer> monomerMap = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).in(PlanMonomer::getProjectId, projectMap.keySet()))
         .stream()
         .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      List<ProjectTreeResponseVO> treeDto = new ArrayList<>();
      projectTreeMap.forEach((projectId, monomer) -> {
         ProjectTreeResponseVO project = new ProjectTreeResponseVO();
         project.setId(projectId);
         project.setName(projectMap.get(projectId).getName());
         project.setShortName(projectMap.get(projectId).getShortName());
         project.setSerialNumber(projectMap.get(projectId).getSerialNumber());
         List<MonomerTreeResponseVO> monomerChildren = new ArrayList<>();
         monomer.forEach((monomerId, area) -> {
            MonomerTreeResponseVO build1 = new MonomerTreeResponseVO();
            build1.setId(monomerId);
            build1.setName(monomerMap.get(monomerId).getName());
            List<AreaTreeResponseVO> areaChildren = new ArrayList<>();
            area.forEach(e -> {
               AreaTreeResponseVO build2 = new AreaTreeResponseVO();
               build2.setId(e.getId());
               build2.setName(e.getName());
               List<PlanAreaBatch> areaBatchList = areaBatchMap.get(e.getId());
               if (CollectionUtils.isNotEmpty(areaBatchList)) {
                  List<NameInfo> areaBatchVOS = cn.hutool.core.bean.BeanUtil.copyToList(areaBatchList, NameInfo.class);
                  build2.setAreaBatchList(areaBatchVOS);
               }

               areaChildren.add(build2);
            });
            build1.setChildren(areaChildren);
            monomerChildren.add(build1);
         });
         project.setChildren(monomerChildren);
         treeDto.add(project);
      });
      treeDto.sort(Comparator.comparing(ProjectTreeResponseVO::getId).reversed());
      return treeDto;
   }

   @Override
   public List<ProjectTreeResponseVO> getMachinePartTaskprojectList(LocalDateTime localDateTime, String name, Integer processType) {
      List<Long> projectIds = this.contractProjectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      List<ContractProject> projectList = this.contractProjectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getId, projectIds)
               .apply("DATE_FORMAT(create_time,'%Y')={0}", localDateTime.format(DateTimeFormatter.ofPattern("yyyy")))
               .like(name != null, ContractProject::getSerialNumber, name)
               .or()
               .like(name != null, ContractProject::getName, name)
               .or()
               .like(name != null, ContractProject::getShortName, name)
         );
      if (projectList.size() == 0) {
         return new ArrayList<>();
      }

      Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      List<Long> processIds = this.processService
         .list(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getType, processType))
         .stream()
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      List<MesBuildingMachineTaskOrderDTO> machinePartTaskList = this.getMachinePartTaskList(
         null,
         projectList.stream().map(ContractProject::getId).collect(Collectors.toList()),
         null,
         null,
         null,
         processType,
         processIds,
         null,
         null,
         null,
         null,
         null
      );
      if (machinePartTaskList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> taskOrderIds = machinePartTaskList.stream().map(MesBuildingMachineTaskOrderDTO::getTaskOrderId).distinct().collect(Collectors.toList());
      List<Long> areaIdList = this.taskBiz
         .list(Wrappers.lambdaQuery(MesBuildingTask.class).in(MesBuildingTask::getTaskOrderId, taskOrderIds))
         .stream()
         .map(MesBuildingTask::getAreaId)
         .distinct()
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(areaIdList)) {
         return new ArrayList<>();
      }

      List<PlanArea> areaList = this.areaService.listByIds(areaIdList);
      Map<Long, Map<Long, List<PlanArea>>> projectTreeMap = areaList.stream()
         .filter(e -> projectList.stream().map(ContractProject::getId).collect(Collectors.toList()).contains(e.getProjectId()))
         .collect(Collectors.groupingBy(PlanArea::getProjectId, Collectors.groupingBy(PlanArea::getMonomerId)));
      Map<Long, PlanMonomer> monomerMap = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).in(PlanMonomer::getProjectId, projectMap.keySet()))
         .stream()
         .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      List<ProjectTreeResponseVO> treeDto = new ArrayList<>();
      projectTreeMap.forEach((projectId, monomer) -> {
         ProjectTreeResponseVO project = new ProjectTreeResponseVO();
         project.setId(projectId);
         project.setName(projectMap.get(projectId).getName());
         project.setShortName(projectMap.get(projectId).getShortName());
         project.setSerialNumber(projectMap.get(projectId).getSerialNumber());
         List<MonomerTreeResponseVO> monomerChildren = new ArrayList<>();
         monomer.forEach((monomerId, area) -> {
            MonomerTreeResponseVO build1 = new MonomerTreeResponseVO();
            build1.setId(monomerId);
            build1.setName(monomerMap.get(monomerId).getName());
            List<AreaTreeResponseVO> areaChildren = new ArrayList<>();
            area.forEach(e -> {
               AreaTreeResponseVO build2 = new AreaTreeResponseVO();
               build2.setId(e.getId());
               build2.setName(e.getName());
               areaChildren.add(build2);
            });
            build1.setChildren(areaChildren);
            monomerChildren.add(build1);
         });
         project.setChildren(monomerChildren);
         treeDto.add(project);
      });
      treeDto.sort(Comparator.comparing(ProjectTreeResponseVO::getId).reversed());
      return treeDto;
   }

   @Override
   public List<TaskOrderTrackingDTO> taskDull() {
      List<TaskOrderTrackingDTO> taskOrderTrackingDTOS = this.taskTrackArtifact(
         null, null, null, null, null, null, null, TaskTypeEnum.ARTIFACT.getType(), null, null
      );

      for (TaskOrderTrackingDTO trackingDTO : taskOrderTrackingDTOS) {
         trackingDTO.setProductType(TaskTypeEnum.ARTIFACT.getType());
         Integer unQuantity = 0;
         ProgressProcessDTO artifactProcess = this.taskProcessBiz.taskArtifactProcess(trackingDTO.getTaskOrderId(), null, null, null, null, null);
         if (artifactProcess.getArtifactList() != null) {
            for (List<TaskTrackingProcessDTO> dtoList : artifactProcess.getArtifactList()) {
               unQuantity = unQuantity + dtoList.stream().filter(e -> e.getStatus().equals(0)).mapToInt(TaskTrackingProcessDTO::getUnQuantity).sum();
            }
         }

         if (artifactProcess.getAssembleList() != null) {
            for (List<TaskTrackingProcessDTO> dtoList : artifactProcess.getAssembleList()) {
               unQuantity = unQuantity + dtoList.stream().filter(e -> e.getStatus().equals(0)).mapToInt(TaskTrackingProcessDTO::getUnQuantity).sum();
            }
         }

         trackingDTO.setUnQuantity(unQuantity);
      }

      taskOrderTrackingDTOS = taskOrderTrackingDTOS.stream().filter(e -> e.getUnQuantity() > 0).collect(Collectors.toList());
      List<TaskOrderTrackingDTO> taskOrderTrackingDTOList = this.taskTrackMachinePart(
         null, null, null, null, null, null, TaskTypeEnum.MACHINE_PART.getType(), null, null
      );

      for (TaskOrderTrackingDTO trackingDTO : taskOrderTrackingDTOList) {
         Integer unQuantity = 0;

         for (List<TaskTrackingProcessDTO> partProcess : this.taskProcessBiz
            .taskMachinePartProcess(trackingDTO.getTaskOrderId(), null, null, null, null, null, TaskTypeEnum.MACHINE_PART.getType())) {
            unQuantity = unQuantity + partProcess.stream().filter(e -> e.getStatus().equals(0)).mapToInt(TaskTrackingProcessDTO::getUnQuantity).sum();
         }

         trackingDTO.setUnQuantity(unQuantity);
      }

      taskOrderTrackingDTOList = taskOrderTrackingDTOList.stream().filter(e -> e.getUnQuantity() > 0).collect(Collectors.toList());
      taskOrderTrackingDTOS.addAll(taskOrderTrackingDTOList);
      return taskOrderTrackingDTOS;
   }

   @Override
   public PageVO<TaskOrderTrackingDTO> taskDullPage(Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.taskDull());
   }

   private void saveNeedScheduling(MesBuildingTask task) {
      if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, task.getProductId()))
            .forEach(
               e -> {
                  TechMachinePart machinePart = this.machinePartService.getById(e.getMachinePartId());
                  if (machinePart.getBoolProcess() && machinePart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = MesBuildingTaskNeedMachinePartScheduling.builder()
                        .projectId(task.getProjectId())
                        .monomerId(task.getMonomerId())
                        .areaId(task.getAreaId())
                        .taskId(task.getId())
                        .workshopId(task.getWorkshopId())
                        .groupsId(task.getGroupsId())
                        .taskOrderId(task.getTaskOrderId())
                        .productionLineId(task.getProductionLineId())
                        .askCompleteTime(task.getAskCompleteTime())
                        .productId(e.getMachinePartId())
                        .needQuantity(e.getQuantity() * task.getTaskQuantity())
                        .useId(UserUtil.getCurrentUserId())
                        .build();
                     this.taskNeedMachinePartSchedulingBiz.save(needMachinePartScheduling);
                  }
               }
            );
      } else {
         if (!task.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            throw new IllegalArgumentException("操作失败！类型不正确");
         }

         this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, task.getProductId()))
            .forEach(
               e -> {
                  TechMachinePart machinePart = this.machinePartService.getById(e.getMachinePartId());
                  if (machinePart.getBoolProcess() && machinePart.getRelationType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = MesBuildingTaskNeedMachinePartScheduling.builder()
                        .projectId(task.getProjectId())
                        .monomerId(task.getMonomerId())
                        .areaId(task.getAreaId())
                        .taskId(task.getId())
                        .taskOrderId(task.getTaskOrderId())
                        .workshopId(task.getWorkshopId())
                        .groupsId(task.getGroupsId())
                        .productionLineId(task.getProductionLineId())
                        .askCompleteTime(task.getAskCompleteTime())
                        .productId(e.getMachinePartId())
                        .needQuantity(e.getQuantity() * task.getTaskQuantity())
                        .useId(UserUtil.getCurrentUserId())
                        .build();
                     this.taskNeedMachinePartSchedulingBiz.save(needMachinePartScheduling);
                  }
               }
            );
      }
   }

   public void artifactWarehousing(MesBuildingTaskOrder order, List<MesBuildingArtifactScheduling> schedulingList) {
      Map<Long, Long> taskMap = this.taskBiz
         .list(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getTaskOrderId, order.getId()))
         .stream()
         .collect(Collectors.toMap(MesBuildingTask::getProductId, MesBuildingTask::getId));
      List<Long> artifactIds = schedulingList.stream().map(MesBuildingArtifactScheduling::getProductId).collect(Collectors.toList());
      Map<Long, Long> productMap = schedulingList.stream().collect(Collectors.toMap(s -> s.getProductId(), s -> s.getProductionLineId()));
      List<TechArtifact> techArtifacts = this.artifactService.listByIds(artifactIds);
      techArtifacts = techArtifacts.stream()
         .filter(TechArtifact::getBoolSinglePartEnum)
         .filter(s -> !this.utilsBiz.getBoolSinglePartArtifactPaint(s, productMap.get(s.getProjectId())))
         .collect(Collectors.toList());
      artifactIds = techArtifacts.stream().map(TechArtifact::getId).collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = techArtifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      if (!CollectionUtils.isEmpty(artifactIds)) {
         List<TechArtifact> assArtifacts = new ArrayList<>();
         List<TechArtifact> partArtifacts = new ArrayList<>();
         List<TechAssembleDetail> assArtifactLinks = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
         if (CollectionUtils.isNotEmpty(assArtifactLinks)) {
            List<Long> assIds = this.assembleService
               .listByIds(assArtifactLinks.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()))
               .stream()
               .filter(s -> !s.getBoolSchedulingEnum())
               .map(TechAssemble::getId)
               .collect(Collectors.toList());
            List<Long> assArtids = assArtifactLinks.stream()
               .filter(s -> assIds.contains(s.getAssembleId()))
               .map(TechAssembleDetail::getArtifactId)
               .collect(Collectors.toList());
            assArtifacts = techArtifacts.stream()
               .filter(TechArtifact::getBoolSinglePartEnum)
               .filter(s -> !s.getBoolAllPartSendDirectly())
               .filter(s -> assArtids.contains(s.getId()))
               .collect(Collectors.toList());
         }

         List<TechArtifactMachinePartLink> machinePartLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIds));
         if (CollectionUtils.isNotEmpty(machinePartLinks)) {
            List<Long> partIds = this.machinePartService
               .listByIds(machinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()))
               .stream()
               .filter(s -> !s.getBoolSchedulingEnum())
               .filter(s -> s.getRelationType() != 18)
               .map(TechMachinePart::getId)
               .collect(Collectors.toList());
            List<Long> partArtids = machinePartLinks.stream()
               .filter(s -> partIds.contains(s.getMachinePartId()))
               .map(TechArtifactMachinePartLink::getArtifactId)
               .collect(Collectors.toList());
            partArtifacts = techArtifacts.stream()
               .filter(TechArtifact::getBoolSinglePartEnum)
               .filter(s -> !s.getBoolAllPartSendDirectly())
               .filter(s -> partArtids.contains(s.getId()))
               .collect(Collectors.toList());
         }

         assArtifacts.addAll(partArtifacts);
         List<Long> warmIds = assArtifacts.stream().map(TechArtifact::getId).collect(Collectors.toList());
         List<Long> finalArtifactIds = artifactIds;
         List<MesBuildingArtifactScheduling> collect = schedulingList.stream()
            .filter(s -> finalArtifactIds.contains(s.getProductId()))
            .collect(Collectors.toList());
         Map<Long, TechArtifact> techMap = techArtifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity(), (s1, s2) -> s1));
         List<MesBuildingSinglePartArtifactPrint> sings = new ArrayList<>();

         for (MesBuildingArtifactScheduling scheduling : collect) {
            TechArtifact artifact = artifactMap.get(scheduling.getProductId());
            if (!this.utilsBiz.getBoolSinglePartArtifactPaint(artifact, scheduling.getProductionLineId())) {
               if (techMap.get(scheduling.getProductId()).getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
                  int count = this.singlePartArtifactPrintService
                     .count(
                        Wrappers.lambdaQuery(MesBuildingSinglePartArtifactPrint.class)
                           .eq(MesBuildingSinglePartArtifactPrint::getProductId, scheduling.getProductId())
                     );

                  for (Integer i = 1; i <= scheduling.getQuantity(); i = i + 1) {
                     sings.add(
                        MesBuildingSinglePartArtifactPrint.builder()
                           .taskQuantity(scheduling.getQuantity())
                           .productId(scheduling.getProductId())
                           .taskId(taskMap.get(scheduling.getProductId()))
                           .workshopId(scheduling.getWorkshopId())
                           .number(count + i)
                           .quantity(warmIds.contains(scheduling.getProductId()) ? 1 : 0)
                           .operationId(UserUtil.getCurrentUserId())
                           .build()
                     );
                  }
               } else {
                  sings.add(
                     MesBuildingSinglePartArtifactPrint.builder()
                        .productId(scheduling.getProductId())
                        .taskId(taskMap.get(scheduling.getProductId()))
                        .workshopId(scheduling.getWorkshopId())
                        .number(null)
                        .taskQuantity(scheduling.getQuantity())
                        .quantity(warmIds.contains(scheduling.getProductId()) ? scheduling.getQuantity() : 0)
                        .operationId(UserUtil.getCurrentUserId())
                        .build()
                  );
               }
            }
         }

         this.singlePartArtifactPrintService.saveBatch(sings);
      }
   }

   @Override
   public List<MesBuildingTask> getArtListByAssTask(Long taskId) {
      return this.baseMapper.getArtListByAssTask(taskId);
   }

   @Override
   public List<MesBuildingTask> getArtListByPartTask(Long taskId) {
      return this.baseMapper.getArtListByPartTask(taskId);
   }

   private void sendAssPartsWrehouse(List<MesBuildingTask> tasks) {
      List<TechArtifactMachinePartLink> machinePartLinks = this.artifactMachinePartLinkService
         .list(
            Wrappers.lambdaQuery(TechArtifactMachinePartLink.class)
               .in(TechArtifactMachinePartLink::getArtifactId, tasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList()))
         );
      Map<Long, List<TechArtifactMachinePartLink>> artParLinkMap = machinePartLinks.stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
      List<ArtifactSchedulingNeedCompleteDTO> needCompleteDTOS = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(machinePartLinks)) {
         List<TechMachinePart> machineParts = this.machinePartService
            .listByIds(machinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
         List<TechMachinePart> needWarsParts = machineParts.stream().filter(s -> !s.getBoolProcess()).collect(Collectors.toList());
         Map<Long, TechMachinePart> needProduceMap = needWarsParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

         for (MesBuildingTask task : tasks) {
            List<TechArtifactMachinePartLink> links = artParLinkMap.get(task.getProductId());
            if (CollectionUtils.isNotEmpty(links)) {
               for (TechArtifactMachinePartLink link : links) {
                  TechMachinePart techMachinePart = needProduceMap.get(link.getMachinePartId());
                  if (techMachinePart != null) {
                     int needProduce = task.getTaskQuantity() * link.getQuantity();
                     techMachinePart.setProducedQuantity(techMachinePart.getProducedQuantity() + needProduce);
                     if (techMachinePart.getRelationType().equals(2) && techMachinePart.getBoolSendDirectly()) {
                        ArtifactSchedulingNeedCompleteDTO build = ArtifactSchedulingNeedCompleteDTO.builder()
                           .projectId(techMachinePart.getProjectId())
                           .monomerId(techMachinePart.getMonomerId())
                           .areaId(techMachinePart.getAreaId())
                           .factoryId(task.getFactoryId())
                           .workshopId(task.getWorkshopId())
                           .lineId(task.getProductionLineId())
                           .artifactTaskId(task.getId())
                           .taskTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
                           .productId(techMachinePart.getId())
                           .quantity(needProduce)
                           .boolSendDirectly(techMachinePart.getBoolSendDirectly())
                           .build();
                        needCompleteDTOS.add(build);
                     }
                  }
               }
            }
         }

         List<TechMachinePart> techMachineParts = new ArrayList<>(needProduceMap.values());
         this.machinePartService.updateBatchById(techMachineParts);
      }

      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list(
            Wrappers.lambdaQuery(TechAssembleDetail.class)
               .in(TechAssembleDetail::getArtifactId, tasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList()))
         );
      Map<Long, List<TechAssembleDetail>> assembleDetailMap = assembleDetailList.stream().collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         List<TechAssemble> assembles = this.assembleService
            .listByIds(assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
         List<TechAssemble> needWarsAss = assembles.stream().filter(s -> !s.getBoolProcess()).collect(Collectors.toList());
         Map<Long, TechAssemble> needProduceMap = needWarsAss.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

         for (MesBuildingTask task : tasks) {
            List<TechAssembleDetail> links = assembleDetailMap.get(task.getProductId());
            if (CollectionUtils.isNotEmpty(links)) {
               for (TechAssembleDetail link : links) {
                  TechAssemble techAssemble = needProduceMap.get(link.getAssembleId());
                  if (techAssemble != null) {
                     int needProduce = task.getTaskQuantity() * link.getQuantity();
                     techAssemble.setProducedQuantity(techAssemble.getProducedQuantity() + needProduce);
                     if (techAssemble.getBoolSendDirectly()) {
                        ArtifactSchedulingNeedCompleteDTO build = ArtifactSchedulingNeedCompleteDTO.builder()
                           .projectId(techAssemble.getProjectId())
                           .monomerId(techAssemble.getMonomerId())
                           .areaId(techAssemble.getAreaId())
                           .factoryId(task.getFactoryId())
                           .workshopId(task.getWorkshopId())
                           .lineId(task.getProductionLineId())
                           .artifactTaskId(task.getId())
                           .taskTypeEnum(TaskTypeEnum.ASSEMBLE.getType())
                           .productId(techAssemble.getId())
                           .quantity(needProduce)
                           .boolSendDirectly(techAssemble.getBoolSendDirectly())
                           .build();
                        needCompleteDTOS.add(build);
                     }
                  }
               }
            }

            List<TechAssemble> assembleList = new ArrayList<>(needProduceMap.values());
            this.assembleService.updateBatchById(assembleList);
         }
      }

      List<ArtifactSchedulingNeedCompleteDTO> needWrehouse = needCompleteDTOS.stream()
         .filter(ArtifactSchedulingNeedCompleteDTO::getBoolSendDirectly)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(needWrehouse)) {
         List<MesBuildingComplete> needCompletes = new ArrayList<>();

         for (ArtifactSchedulingNeedCompleteDTO dto : needWrehouse) {
            MesBuildingComplete complete = MesBuildingComplete.builder()
               .projectId(dto.getProjectId())
               .monomerId(dto.getMonomerId())
               .areaId(dto.getAreaId())
               .factoryId(dto.getFactoryId())
               .workshopId(dto.getWorkshopId())
               .productionLineId(dto.getLineId())
               .productId(dto.getProductId())
               .quantity(dto.getQuantity())
               .taskTypeEnum(dto.getTaskTypeEnum())
               .boolAbnormalEnum(false)
               .userId(UserUtil.getCurrentUserId())
               .artifactTaskId(dto.getArtifactTaskId())
               .build();
            needCompletes.add(complete);
         }

         this.completeService.saveBatch(needCompletes, 100);
         Map<String, List<MesBuildingComplete>> shopCompleteMap = needCompletes.stream()
            .collect(Collectors.groupingBy(s -> s.getWorkshopId() + "_" + s.getTaskTypeEnum()));

         for (String shopAndType : shopCompleteMap.keySet()) {
            String[] split = shopAndType.split("_");
            Long shopId = Long.valueOf(split[0]);
            Integer taskType = Integer.valueOf(split[1]);
            List<MesBuildingComplete> workComplete = shopCompleteMap.get(shopAndType);
            Long factoryId = workComplete.get(0).getFactoryId();
            List<Long> productIds = workComplete.stream().map(MesBuildingComplete::getProductId).collect(Collectors.toList());
            List<MesBuildingWarehouseSummary> allSummary = this.warehouseSummaryService
               .list(
                  (Wrapper<MesBuildingWarehouseSummary>)((((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                                 .eq(MesBuildingWarehouseSummary::getFactoryId, factoryId))
                              .in(MesBuildingWarehouseSummary::getProductId, productIds))
                           .eq(MesBuildingWarehouseSummary::getProductType, taskType))
                        .eq(MesBuildingWarehouseSummary::getWorkshopId, shopId))
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
               );
            Map<Long, MesBuildingWarehouseSummary> summaryMap = allSummary.stream()
               .collect(Collectors.toMap(MesBuildingWarehouseSummary::getProductId, Function.identity()));
            List<MesBuildingWarehouseRecord> needwarehouserRecord = new ArrayList<>();

            for (MesBuildingComplete complete : workComplete) {
               MesBuildingWarehouseSummary summary = this.warehouseSummaryService
                  .getOne(
                     (Wrapper<MesBuildingWarehouseSummary>)((((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                                    .eq(MesBuildingWarehouseSummary::getFactoryId, factoryId))
                                 .eq(MesBuildingWarehouseSummary::getProductId, complete.getProductId()))
                              .eq(MesBuildingWarehouseSummary::getProductType, taskType))
                           .eq(MesBuildingWarehouseSummary::getWorkshopId, shopId))
                        .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                  );
               if (summary == null) {
                  summary = BeanUtil.copy(complete, MesBuildingWarehouseSummary.class);
                  summary.setProductType(taskType);
                  summary.setType(1);
                  this.warehouseSummaryService.save(summary);
               } else {
                  summary.setQuantity(summary.getQuantity().add(BigDecimal.valueOf(complete.getQuantity().intValue())));
                  this.warehouseSummaryService.updateById(summary);
               }

               MesBuildingWarehouseRecord record = BeanUtil.copy(summary, MesBuildingWarehouseRecord.class);
               record.setCompleteId(complete.getId());
               record.setQuantity(BigDecimal.valueOf(complete.getQuantity().intValue()));
               record.setUserId(UserUtil.getCurrentUserId());
               record.setUserName(UserUtil.getCurrentName());
               record.setNumber(complete.getNumber());
               record.setProductType(taskType);
               record.setType(WarehouseTypeEnum.INTO.getType());
               record.setStatus(1);
               needwarehouserRecord.add(record);
            }

            this.warehouseRecordService.saveBatch(needwarehouserRecord);
         }
      }
   }

   private Boolean saveSchedulingPartsDataForTasks(
      List<MesBuildingTask> tasks, Map<Long, TechArtifact> artifactMap, Map<Long, TechAssemble> assembleMap, Integer taskType
   ) {
      List<Long> productIds = tasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
      if (taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<TechArtifactMachinePartLink> prtLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, productIds));
         Map<Long, List<TechArtifactMachinePartLink>> artLinkMap = prtLinks.stream().collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         List<Long> parIds = prtLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(parIds)) {
            List<TechMachinePart> machineParts = this.machinePartService.listByIds(parIds);
            Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity(), (s1, s2) -> s1));
            MesBuildingTaskProcess mesBuildingTaskProcess = this.taskProcessService
               .list(
                  (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>()
                        .in(MesBuildingTaskProcess::getTaskId, tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList())))
                     .eq(MesBuildingTaskProcess::getSequence, 0)
               )
               .get(0);
            List<MesBuildingTaskNeedMachinePartScheduling> needMachinePartSchedulings = new ArrayList<>();

            for (MesBuildingTask task : tasks) {
               List<TechArtifactMachinePartLink> links = artLinkMap.get(task.getProductId());
               if (CollectionUtils.isNotEmpty(links)) {
                  for (TechArtifactMachinePartLink link : links) {
                     TechMachinePart machinePart = partMap.get(link.getMachinePartId());
                     if (machinePart.getBoolProcess() && machinePart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                        MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = MesBuildingTaskNeedMachinePartScheduling.builder()
                           .projectId(task.getProjectId())
                           .monomerId(task.getMonomerId())
                           .areaId(task.getAreaId())
                           .taskId(task.getId())
                           .workshopId(task.getWorkshopId())
                           .groupsId(task.getGroupsId())
                           .taskOrderId(task.getTaskOrderId())
                           .productionLineId(task.getProductionLineId())
                           .askCompleteTime(task.getAskCompleteTime())
                           .productId(link.getMachinePartId())
                           .needQuantity(link.getQuantity() * task.getTaskQuantity())
                           .steelPlateTypeEnum(machinePart.getSteelPlateTypeEnum())
                           .useId(UserUtil.getCurrentUserId())
                           .build();
                        needMachinePartScheduling.setTeamId(mesBuildingTaskProcess.getTeamId());
                        needMachinePartSchedulings.add(needMachinePartScheduling);
                     }
                  }
               }
            }

            this.taskNeedMachinePartSchedulingService.saveBatch(needMachinePartSchedulings);
         }
      } else if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssembleMachinePartLink> prtLinks = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, productIds));
         Map<Long, List<TechAssembleMachinePartLink>> asslinkMap = prtLinks.stream().collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
         List<Long> parIds = prtLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(parIds)) {
            List<TechMachinePart> machineParts = this.machinePartService.listByIds(parIds);
            Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity(), (s1, s2) -> s1));
            MesBuildingTaskProcess mesBuildingTaskProcess = this.taskProcessService
               .list(
                  (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>()
                        .in(MesBuildingTaskProcess::getTaskId, tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList())))
                     .eq(MesBuildingTaskProcess::getSequence, 0)
               )
               .get(0);
            List<MesBuildingTaskNeedMachinePartScheduling> needMachinePartSchedulings = new ArrayList<>();

            for (MesBuildingTask task : tasks) {
               List<TechAssembleMachinePartLink> links = asslinkMap.get(task.getProductId());
               if (!CollectionUtils.isEmpty(links)) {
                  for (TechAssembleMachinePartLink link : links) {
                     TechMachinePart machinePart = partMap.get(link.getMachinePartId());
                     if (machinePart.getBoolProcess() && machinePart.getRelationType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                        MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = MesBuildingTaskNeedMachinePartScheduling.builder()
                           .projectId(task.getProjectId())
                           .monomerId(task.getMonomerId())
                           .areaId(task.getAreaId())
                           .taskId(task.getId())
                           .workshopId(task.getWorkshopId())
                           .groupsId(task.getGroupsId())
                           .taskOrderId(task.getTaskOrderId())
                           .productionLineId(task.getProductionLineId())
                           .askCompleteTime(task.getAskCompleteTime())
                           .productId(link.getMachinePartId())
                           .needQuantity(link.getQuantity() * task.getTaskQuantity())
                           .useId(UserUtil.getCurrentUserId())
                           .steelPlateTypeEnum(machinePart.getSteelPlateTypeEnum())
                           .build();
                        needMachinePartScheduling.setTeamId(mesBuildingTaskProcess.getTeamId());
                        needMachinePartSchedulings.add(needMachinePartScheduling);
                     }
                  }
               }
            }

            this.taskNeedMachinePartSchedulingService.saveBatch(needMachinePartSchedulings);
         }
      } else {
         Preconditions.checkArgument(false, "操作失败产品类型不正确!!!!");
      }

      return Boolean.TRUE;
   }

   private Boolean saveSchedulingPartsDataForTasks2(
      List<MesBuildingTask> tasks, Map<Long, TechArtifact> artifactMap, Map<Long, TechAssemble> assembleMap, Integer taskType, Boolean boolTask
   ) {
      List<Long> productIds = tasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
      if (taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<TechArtifactMachinePartLink> prtLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, productIds));
         Map<Long, List<TechArtifactMachinePartLink>> artLinkMap = prtLinks.stream().collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         List<Long> parIds = prtLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(parIds)) {
            List<TechMachinePart> machineParts = this.machinePartService.listByIds(parIds);
            Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity(), (s1, s2) -> s1));
            MesBuildingTaskProcess mesBuildingTaskProcess = this.taskProcessService
               .list(
                  (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>()
                        .in(MesBuildingTaskProcess::getTaskId, tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList())))
                     .eq(MesBuildingTaskProcess::getSequence, 0)
               )
               .get(0);
            List<MesBuildingTaskNeedMachinePartScheduling> needMachinePartSchedulings = new ArrayList<>();

            for (MesBuildingTask task : tasks) {
               List<TechArtifactMachinePartLink> links = artLinkMap.get(task.getProductId());
               if (CollectionUtils.isNotEmpty(links)) {
                  for (TechArtifactMachinePartLink link : links) {
                     TechMachinePart machinePart = partMap.get(link.getMachinePartId());
                     if (machinePart.getBoolProcess() && machinePart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                        MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = MesBuildingTaskNeedMachinePartScheduling.builder()
                           .projectId(task.getProjectId())
                           .monomerId(task.getMonomerId())
                           .areaId(task.getAreaId())
                           .areaBatchId(task.getAreaBatchId())
                           .taskId(task.getId())
                           .workshopId(task.getWorkshopId())
                           .taskOrderId(task.getTaskOrderId())
                           .productionLineId(task.getProductionLineId())
                           .askCompleteTime(task.getAskCompleteTime())
                           .productId(link.getMachinePartId())
                           .needQuantity(link.getQuantity() * task.getTaskQuantity())
                           .useId(UserUtil.getCurrentUserId())
                           .steelPlateTypeEnum(machinePart.getSteelPlateTypeEnum())
                           .build();
                        needMachinePartScheduling.setTeamId(mesBuildingTaskProcess.getTeamId());
                        needMachinePartSchedulings.add(needMachinePartScheduling);
                     }
                  }
               }
            }

            this.taskNeedMachinePartSchedulingService.saveBatch(needMachinePartSchedulings);
         }
      } else if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType()) && boolTask) {
         List<TechAssembleMachinePartLink> prtLinks = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, productIds));
         Map<Long, List<TechAssembleMachinePartLink>> asslinkMap = prtLinks.stream().collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
         List<Long> parIds = prtLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(parIds)) {
            List<TechMachinePart> machineParts = this.machinePartService.listByIds(parIds);
            Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity(), (s1, s2) -> s1));
            MesBuildingTaskProcess mesBuildingTaskProcess = this.taskProcessService
               .list(
                  (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>()
                        .in(MesBuildingTaskProcess::getTaskId, tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList())))
                     .eq(MesBuildingTaskProcess::getSequence, 0)
               )
               .get(0);
            List<MesBuildingTaskNeedMachinePartScheduling> needMachinePartSchedulings = new ArrayList<>();

            for (MesBuildingTask task : tasks) {
               List<TechAssembleMachinePartLink> links = asslinkMap.get(task.getProductId());
               if (!CollectionUtils.isEmpty(links)) {
                  for (TechAssembleMachinePartLink link : links) {
                     TechMachinePart machinePart = partMap.get(link.getMachinePartId());
                     if (machinePart.getBoolProcess() && machinePart.getRelationType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                        MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = MesBuildingTaskNeedMachinePartScheduling.builder()
                           .projectId(task.getProjectId())
                           .monomerId(task.getMonomerId())
                           .areaId(task.getAreaId())
                           .taskId(task.getId())
                           .workshopId(task.getWorkshopId())
                           .taskOrderId(task.getTaskOrderId())
                           .productionLineId(task.getProductionLineId())
                           .askCompleteTime(task.getAskCompleteTime())
                           .productId(link.getMachinePartId())
                           .needQuantity(link.getQuantity() * task.getTaskQuantity())
                           .steelPlateTypeEnum(machinePart.getSteelPlateTypeEnum())
                           .useId(UserUtil.getCurrentUserId())
                           .build();
                        needMachinePartScheduling.setTeamId(mesBuildingTaskProcess.getTeamId());
                        needMachinePartSchedulings.add(needMachinePartScheduling);
                     }
                  }
               }
            }

            this.taskNeedMachinePartSchedulingService.saveBatch(needMachinePartSchedulings);
         }
      }

      return Boolean.TRUE;
   }

   private void saveAssembleTaskOrderLink(
      MesBuildingTopTaskOrder topTaskOrder,
      Long orderId,
      List<MesBuildingTaskOrderAssembleDetaiDTOParam> assGroupTask,
      Integer productionLineType,
      Long groupId,
      Map<Long, List<IDAndQuantityDTO>> numberLinkMap
   ) {
      if (CollectionUtils.isEmpty(assGroupTask)) {
         Preconditions.checkArgument(false, "操作失败,请联系管理员!!!!");
      }

      List<Long> assIds = assGroupTask.stream().map(MesBuildingTaskOrderAssembleDetaiDTOParam::getProductId).distinct().collect(Collectors.toList());
      List<TechAssemble> assembles = this.assembleService.listByIds(assIds);
      Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      List<MesBuildingProductProcess> productProcessList = this.productProcessService
         .list(Wrappers.lambdaQuery(MesBuildingProductProcess.class).eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE));
      Map<String, MesBuildingProductProcess> productProcessMap = productProcessList.stream()
         .collect(Collectors.toMap(s -> s.getProductType() + "_" + s.getTypeId(), Function.identity()));
      MesBuildingGroups group = null;
      if (groupId != null) {
         group = this.groupsBiz.getById(groupId);
      }

      List<MesBuildingTask> assTasks = new ArrayList<>();

      for (MesBuildingTaskOrderAssembleDetaiDTOParam assTask : assGroupTask) {
         TechAssemble assemble = assembleMap.get(assTask.getProductId());
         MesBuildingProductProcess assProductProcess = productProcessMap.get(TaskTypeEnum.ASSEMBLE.getType() + "_" + assemble.getAssembleConfigId());
         MesBuildingTask task = MesBuildingTask.builder()
            .projectId(assemble.getProjectId())
            .monomerId(assemble.getMonomerId())
            .areaId(assemble.getAreaId())
            .areaBatchId(assemble.getAreaBatchId())
            .factoryId(groupId == null ? null : group.getFactoryId())
            .workshopId(groupId == null ? null : group.getWorkshopId())
            .productionLineId(groupId == null ? null : group.getProductionLineId())
            .groupsId(groupId == null ? null : assTask.getGroupsId())
            .productId(assTask.getProductId())
            .taskTypeEnum(TaskTypeEnum.ASSEMBLE.getType())
            .classificationId(assemble.getAssembleConfigId())
            .productProcessId(groupId == null ? null : assProductProcess.getId())
            .taskQuantity(assTask.getQuantity())
            .productionLineTypeEnum(productionLineType)
            .askCompleteTime(assTask.getAskCompleteTime())
            .userId(UserUtil.getCurrentUserId())
            .topTaskOrderId(groupId == null ? null : topTaskOrder.getId())
            .taskOrderId(orderId)
            .boolOneCode(assTask.getBoolOneCode())
            .build();
         assTasks.add(task);
      }

      Map<Long, Long> assTaskTaskProcessMap = new HashMap<>();
      if (groupId != null) {
         this.taskService.saveBatch(assTasks);
         this.recordNewTaskQuantities(assTasks);
         assTaskTaskProcessMap = this.taskBiz.addAllTaskProces(assTasks, null, assembleMap, TaskTypeEnum.ASSEMBLE.getType());
      }

      this.saveSchedulingPartsDataForTasks(assTasks, null, assembleMap, TaskTypeEnum.ASSEMBLE.getType());
      List<IDAndQuantityDTO> allIdAndQuantityDTOS = numberLinkMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
      List<Long> linkIds = allIdAndQuantityDTOS.stream().map(IDAndQuantityDTO::getId).collect(Collectors.toList());
      List<MesBuildingTaskNumberLink> links = this.mesBuildingTaskNumberLinkService.listByIds(linkIds);
      Map<Long, MesBuildingTaskNumberLink> linkMap = links.stream().collect(Collectors.toMap(MesBuildingTaskNumberLink::getId, Function.identity()));
      List<TechAssembleExt> neeUpdateAssexts = new ArrayList<>();
      List<MesBuildingTaskNumberLink> updatelinkList = new ArrayList<>();
      List<Long> taskAssIds = assTasks.stream().map(MesBuildingTask::getProductId).distinct().collect(Collectors.toList());
      List<TechAssembleExt> allTaskAssembleExts = this.assembleExtService
         .list(Wrappers.lambdaQuery(TechAssembleExt.class).in(TechAssembleExt::getAssembleId, taskAssIds).eq(TechAssembleExt::getBoolTask, false));
      Map<Long, List<TechAssembleExt>> assExtMap = allTaskAssembleExts.stream().collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));

      for (MesBuildingTask assTask : assTasks) {
         List<TechAssembleExt> allAssembleExts = assExtMap.get(assTask.getProductId());
         Preconditions.checkArgument(allAssembleExts.size() >= assTask.getTaskQuantity(), "操作失败!!!请刷新页面后重试!!!!");
         allAssembleExts.sort(Comparator.comparing(TechAssembleExt::getSortNumber));
         List<TechAssembleExt> needTaskExt = allAssembleExts.stream().limit(assTask.getTaskQuantity().intValue()).collect(Collectors.toList());
         List<TechAssembleExt> canTaskExt = allAssembleExts.stream().skip(assTask.getTaskQuantity().intValue()).collect(Collectors.toList());
         assExtMap.put(assTask.getProductId(), canTaskExt);
         needTaskExt.forEach(s -> s.setBoolTask(Boolean.TRUE));
         Boolean boolOneCode = assTask.getBoolOneCode();
         List<IDAndQuantityDTO> assLinks = numberLinkMap.get(assTask.getProductId());
         List<MesBuildingTaskNumberLink> linkList = assLinks.stream().map(s -> linkMap.get(s.getId())).collect(Collectors.toList());
         linkList = linkList.stream().filter(s -> s.getBoolOneCode().equals(boolOneCode)).collect(Collectors.toList());
         Preconditions.checkArgument(linkList.size() == assTask.getTaskQuantity(), "操作失败!!!请刷新页面后重试!!!!");
         List<Integer> sortNumber = needTaskExt.stream().map(TechAssembleExt::getSortNumber).collect(Collectors.toList());

         for (MesBuildingTaskNumberLink link : linkList) {
            link.setAssembleId(assTask.getProductId());
            link.setAssembleTaskId(assTask.getId());
            link.setAssembleTaskProcessId(assTaskTaskProcessMap.get(assTask.getId()));
            link.setAssembleNumber(sortNumber.get(0));
            link.setBoolAssembleReport(groupId == null);
            link.setBoolAssembleInspection(groupId == null);
            link.setBoolAssembleComplete(groupId == null);
            sortNumber.remove(0);
            updatelinkList.add(link);
         }

         neeUpdateAssexts.addAll(needTaskExt);
      }

      this.assembleExtService.updateBatchById(neeUpdateAssexts);
      this.mesBuildingTaskNumberLinkService.updateBatchById(updatelinkList);
      this.unProcessSendPart(updatelinkList, TaskTypeEnum.ASSEMBLE.getType(), null);
   }

   private void saveAssembleTaskOrderLink2(
      MesBuildingTopTaskOrder topTaskOrder,
      Long orderId,
      List<MesBuildingTaskOrderAssembleDetaiDTOParam> assLineTask,
      Long prodLineId,
      Map<Long, List<IDAndQuantityDTO>> numberLinkMap,
      List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList
   ) {
      if (CollectionUtils.isEmpty(assLineTask)) {
         Preconditions.checkArgument(false, "操作失败,请联系管理员!!!!");
      }

      List<Long> assIds = assLineTask.stream().map(MesBuildingTaskOrderAssembleDetaiDTOParam::getProductId).distinct().collect(Collectors.toList());
      List<TechAssemble> assembles = this.assembleService.listByIds(assIds);
      Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      List<MesBuildingProductProcess> productProcessList = this.productProcessService
         .list(Wrappers.lambdaQuery(MesBuildingProductProcess.class).eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE));
      productProcessList = productProcessList.stream().filter(item -> item.getPartType() == null).collect(Collectors.toList());
      Map<String, MesBuildingProductProcess> productProcessMap = productProcessList.stream()
         .collect(Collectors.toMap(s -> s.getProductionLineId() + "_" + s.getProductType() + "_" + s.getTypeId(), Function.identity()));
      MesBuildingProductionLine prodLine = null;
      if (prodLineId != null) {
         prodLine = this.productionLineBiz.getById(prodLineId);
      }

      List<Long> prunedIds = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(prunedList)) {
         prunedIds = prunedList.stream().map(e -> e.getProductId()).collect(Collectors.toList());
      }

      List<MesBuildingTask> assTasks = new ArrayList<>();

      for (MesBuildingTaskOrderAssembleDetaiDTOParam assTask : assLineTask) {
         TechAssemble assemble = assembleMap.get(assTask.getProductId());
         MesBuildingProductProcess assProductProcess = productProcessMap.get(
            assTask.getProdLineId() + "_" + TaskTypeEnum.ASSEMBLE.getType() + "_" + assemble.getAssembleConfigId()
         );
         if (!assemble.getBoolAllPartSendDirectly() && assemble.getBoolProcess() && !prunedIds.contains(assemble.getId())) {
            Preconditions.checkArgument(assProductProcess != null, "操作失败!!!部件工序未配置!!!");
         }

         MesBuildingTask task = MesBuildingTask.builder()
            .projectId(assemble.getProjectId())
            .monomerId(assemble.getMonomerId())
            .areaId(assemble.getAreaId())
            .areaBatchId(assemble.getAreaBatchId())
            .factoryId(prodLine == null ? null : prodLine.getFactoryId())
            .workshopId(prodLine == null ? null : prodLine.getWorkshopId())
            .productionLineId(prodLine == null ? null : prodLine.getId())
            .productId(assTask.getProductId())
            .taskTypeEnum(TaskTypeEnum.ASSEMBLE.getType())
            .classificationId(assemble.getAssembleConfigId())
            .productProcessId(prodLine == null ? null : assProductProcess.getId())
            .taskQuantity(assTask.getQuantity())
            .askCompleteTime(assTask.getAskCompleteTime())
            .userId(UserUtil.getCurrentUserId())
            .topTaskOrderId(prodLine == null ? null : topTaskOrder.getId())
            .taskOrderId(orderId)
            .boolOneCode(assTask.getBoolOneCode())
            .build();
         assTasks.add(task);
      }

      Map<Long, Long> assTaskTaskProcessMap = new HashMap<>();
      if (prodLineId != null) {
         this.taskService.saveBatch(assTasks);
         this.recordNewTaskQuantities(assTasks);
         assTaskTaskProcessMap = this.taskBiz.addAllTaskProces(assTasks, null, assembleMap, TaskTypeEnum.ASSEMBLE.getType());
      }

      this.saveSchedulingPartsDataForTasks2(assTasks, null, assembleMap, TaskTypeEnum.ASSEMBLE.getType(), prodLineId != null);
      List<IDAndQuantityDTO> allIdAndQuantityDTOS = numberLinkMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
      List<Long> linkIds = allIdAndQuantityDTOS.stream().map(IDAndQuantityDTO::getId).collect(Collectors.toList());
      List<MesBuildingTaskNumberLink> links = this.mesBuildingTaskNumberLinkService.listByIds(linkIds);
      Map<Long, MesBuildingTaskNumberLink> linkMap = links.stream().collect(Collectors.toMap(MesBuildingTaskNumberLink::getId, Function.identity()));
      List<TechAssembleExt> neeUpdateAssexts = new ArrayList<>();
      List<MesBuildingTaskNumberLink> updatelinkList = new ArrayList<>();
      List<Long> taskAssIds = assTasks.stream().map(MesBuildingTask::getProductId).distinct().collect(Collectors.toList());
      List<TechAssembleExt> allTaskAssembleExts = this.assembleExtService
         .list(Wrappers.lambdaQuery(TechAssembleExt.class).in(TechAssembleExt::getAssembleId, taskAssIds).eq(TechAssembleExt::getBoolTask, false));
      Map<Long, List<TechAssembleExt>> assExtMap = allTaskAssembleExts.stream().collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));

      for (MesBuildingTask assTask : assTasks) {
         List<TechAssembleExt> allAssembleExts = assExtMap.get(assTask.getProductId());
         Preconditions.checkArgument(allAssembleExts.size() >= assTask.getTaskQuantity(), "操作失败!!!请刷新页面后重试!!!!");
         allAssembleExts.sort(Comparator.comparing(TechAssembleExt::getSortNumber));
         List<TechAssembleExt> needTaskExt = allAssembleExts.stream().limit(assTask.getTaskQuantity().intValue()).collect(Collectors.toList());
         List<TechAssembleExt> canTaskExt = allAssembleExts.stream().skip(assTask.getTaskQuantity().intValue()).collect(Collectors.toList());
         assExtMap.put(assTask.getProductId(), canTaskExt);
         needTaskExt.forEach(s -> s.setBoolTask(Boolean.TRUE));
         Boolean boolOneCode = assTask.getBoolOneCode();
         List<IDAndQuantityDTO> assLinks = numberLinkMap.get(assTask.getProductId());
         List<MesBuildingTaskNumberLink> linkList = assLinks.stream().map(s -> linkMap.get(s.getId())).collect(Collectors.toList());
         linkList = linkList.stream().filter(s -> s.getBoolOneCode().equals(boolOneCode)).collect(Collectors.toList());
         linkList = linkList.stream().filter(e -> e.getAssembleNumber() == null).limit(needTaskExt.size()).collect(Collectors.toList());
         Preconditions.checkArgument(linkList.size() == assTask.getTaskQuantity(), "操作失败!!!请刷新页面后重试!!!!");
         List<Integer> sortNumber = needTaskExt.stream().map(TechAssembleExt::getSortNumber).collect(Collectors.toList());

         for (MesBuildingTaskNumberLink link : linkList) {
            link.setAssembleId(assTask.getProductId());
            link.setAssembleTaskId(assTask.getId());
            link.setAssembleTaskProcessId(assTaskTaskProcessMap.get(assTask.getId()));
            link.setAssembleNumber(sortNumber.get(0));
            link.setBoolAssembleReport(prodLine == null);
            link.setBoolAssembleInspection(prodLine == null);
            link.setBoolAssembleComplete(prodLine == null);
            sortNumber.remove(0);
            updatelinkList.add(link);
         }

         neeUpdateAssexts.addAll(needTaskExt);
      }

      CappWeldingCraftConfigDTO cappWeldingCraft = this.configService.getCappWeldingCraft();
      if (cappWeldingCraft != null && cappWeldingCraft.getUsageMode().equals(CappWeldingCraftUsageModeEnum.INDEPENDENT_MANIFESTATION.getUsageMode())) {
         List<CappCraftProductTaskSaveDTO> cappCraftProductTaskSaveDTOS = assTasks.stream().map(item -> {
            CappCraftProductTaskSaveDTO cappCraftProductTaskSaveDTO = BeanUtil.copy(item, CappCraftProductTaskSaveDTO.class);
            cappCraftProductTaskSaveDTO.setProductionLineId(item.getProductionLineId());
            cappCraftProductTaskSaveDTO.setMesBuildingTaskId(item.getId());
            return cappCraftProductTaskSaveDTO;
         }).collect(Collectors.toList());
         this.cappCraftProductTaskBiz
            .generateCappTaksRecord(
               neeUpdateAssexts, new ArrayList<>(), cappCraftProductTaskSaveDTOS, com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ASSEMBLE.getType()
            );
      }

      this.assembleExtService.updateBatchById(neeUpdateAssexts);
      this.mesBuildingTaskNumberLinkService.updateBatchById(updatelinkList);
      this.unProcessSendPart(updatelinkList, TaskTypeEnum.ASSEMBLE.getType(), prunedList);
   }

   @Override
   public List<MesBuildingNumberTaskOrderDTO> listNumberOrders(Long projectId, Long monomerId, Long areaId, Integer taskType, String serialNumber) {
      TechArtifact artifact = this.artifactService
         .getOne(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getProjectId, projectId)
               .eq(TechArtifact::getMonomerId, monomerId)
               .eq(areaId != null, TechArtifact::getAreaId, areaId)
               .eq(TechArtifact::getSerialNumber, serialNumber)
         );
      Preconditions.checkArgument(artifact != null, "操作失败,构件不存在!!");
      List<MesBuildingTask> tasks = this.taskService
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .eq(MesBuildingTask::getProductId, artifact.getId())
               .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         );
      Integer quantity = 0;
      List<MesBuildingNumberTaskOrderDTO> dtos = new ArrayList<>();
      ContractProject project = this.contractProjectService.getById(projectId);
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      PlanArea area = this.areaService.getById(areaId);
      if (CollectionUtils.isNotEmpty(tasks)) {
         List<Long> orderIds = tasks.stream().map(MesBuildingTask::getTaskOrderId).distinct().collect(Collectors.toList());
         List<MesBuildingTaskOrder> taskOrders = this.baseService.listByIds(orderIds);
         Map<Long, Integer> taskQuantityMap = tasks.stream()
            .collect(Collectors.toMap(MesBuildingTask::getTaskOrderId, MesBuildingTask::getTaskQuantity, Integer::sum));

         for (MesBuildingTaskOrder taskOrder : taskOrders) {
            quantity = tasks.stream().mapToInt(MesBuildingTask::getTaskQuantity).sum();
            MesBuildingNumberTaskOrderDTO build = MesBuildingNumberTaskOrderDTO.builder()
               .id(taskOrder.getId())
               .project(NameInfo.builder().id(project.getId()).name(project.getName()).build())
               .monomer(NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build())
               .orderNumber(taskOrder.getOrderNumber())
               .askCompleteTime(taskOrder.getAskCompleteTime())
               .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
               .productId(artifact.getId())
               .quantity(taskQuantityMap.get(taskOrder.getId()))
               .serialNumber(artifact.getSerialNumber())
               .build();
            dtos.add(build);
         }
      }

      if (artifact.getQuantity() > quantity) {
         MesBuildingNumberTaskOrderDTO build = MesBuildingNumberTaskOrderDTO.builder()
            .id(-1L)
            .project(NameInfo.builder().id(project.getId()).name(project.getName()).build())
            .monomer(NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build())
            .orderNumber("未排产,待优化")
            .askCompleteTime(LocalDateTime.now())
            .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
            .productId(artifact.getId())
            .quantity(artifact.getQuantity() - quantity)
            .serialNumber(artifact.getSerialNumber())
            .build();
         dtos.add(build);
      }

      return dtos;
   }

   @Override
   public List<MesBuildingProductNumbersDTO> listProductNumbers(Long orderId, Long productId, Integer number) {
      MesBuildingTaskOrder order = this.baseService.getById(orderId);
      TechArtifact artifact = this.artifactService.getById(productId);
      MesBuildingTask task = this.taskBiz
         .getOne(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getTaskOrderId, orderId).eq(MesBuildingTask::getProductId, productId));
      Preconditions.checkArgument(task != null, "操作失败,任务不存在!!!");
      List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
               .eq(number != null, MesBuildingTaskNumberLink::getArtifactNumber, number)
               .eq(MesBuildingTaskNumberLink::getArtifactTaskId, task.getId())
               .orderByAsc(MesBuildingTaskNumberLink::getArtifactNumber)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberLinks), "码号不存在!!!");
      ContractProject project = this.contractProjectService.getById(artifact.getProjectId());
      PlanMonomer monomer = this.monomerService.getById(artifact.getMonomerId());
      PlanArea area = this.areaService.getById(artifact.getAreaId());
      List<Long> taskProcessIds = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactTaskProcessId).distinct().collect(Collectors.toList());
      Map<Long, Long> taskProcessMap = new HashMap<>();
      Map<Long, MesBuildingProcess> processMap = new HashMap<>();
      if (taskProcessIds.stream().anyMatch(sx -> sx > 0L)) {
         List<MesBuildingTaskProcess> processeList = this.taskProcessBiz.listByIds(taskProcessIds);
         taskProcessMap = processeList.stream().collect(Collectors.toMap(MesBuildingTaskProcess::getId, MesBuildingTaskProcess::getProcessId));
         List<Long> processIds = processeList.stream().map(MesBuildingTaskProcess::getProcessId).collect(Collectors.toList());
         processMap = this.processService.listByIds(processIds).stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      }

      List<Integer> artNumerList = new ArrayList<>();
      List<MesBuildingProductNumbersDTO> dtos = new ArrayList<>();

      for (MesBuildingTaskNumberLink numberLink : numberLinks) {
         if (!artNumerList.contains(numberLink.getArtifactNumber())) {
            MesBuildingProductNumbersDTO build = MesBuildingProductNumbersDTO.builder()
               .productId(artifact.getId())
               .project(NameInfo.builder().id(project.getId()).name(project.getName()).build())
               .monomer(NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build())
               .orderNumber(order.getOrderNumber())
               .askCompleteTime(order.getAskCompleteTime())
               .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
               .productId(artifact.getId())
               .serialNumber(artifact.getSerialNumber())
               .number(numberLink.getArtifactNumber())
               .build();
            String s = "";
            if (artifact.getBoolAllPartSendDirectly()) {
               s = "直发檩条";
            } else if (numberLink.getBoolArtifactComplete()) {
               s = "生产完成";
            } else {
               Long processId = taskProcessMap.get(numberLink.getArtifactTaskProcessId());
               MesBuildingProcess process = processMap.get(processId);
               if (numberLink.getBoolArtifactReport() && !numberLink.getBoolArtifactInspection()) {
                  s = process.getName() + "生产未质检";
               } else if (!numberLink.getBoolArtifactReport()) {
                  s = process.getName() + "未生产";
               } else {
                  Preconditions.checkArgument(false, "操作失败!!!!");
               }
            }

            build.setProcessName(s);
            dtos.add(build);
            artNumerList.add(numberLink.getArtifactNumber());
         }
      }

      List<MesBuildingProductNumbersDTO> sortedDtos = dtos.stream()
         .sorted(Comparator.comparing(MesBuildingProductNumbersDTO::getNumber))
         .collect(Collectors.toList());
      return dtos;
   }

   @Override
   public List<MesBuildingNumberLinkDTO> linknumbers(List<NumberInfoDTO> numbers) {
      Long productId = numbers.get(0).getProductId();
      TechArtifact artifact = this.artifactService.getById(productId);
      List<Integer> numberList = numbers.stream().map(NumberInfoDTO::getNumber).collect(Collectors.toList());
      List<MesBuildingTaskNumberLink> links = this.mesBuildingTaskNumberLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
               .eq(MesBuildingTaskNumberLink::getArtifactId, productId)
               .in(MesBuildingTaskNumberLink::getArtifactNumber, numberList)
         );
      List<Long> assIds = links.stream().map(MesBuildingTaskNumberLink::getAssembleId).filter(Objects::nonNull).collect(Collectors.toList());
      Map<Long, TechAssemble> assembleMap = new HashMap<>();
      Map<Long, Long> taskProcessMap = new HashMap<>();
      Map<Long, MesBuildingProcess> processMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(assIds)) {
         List<TechAssemble> assembles = this.assembleService.listByIds(assIds);
         assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         List<Long> asstaskProcessIds = links.stream().map(MesBuildingTaskNumberLink::getAssembleTaskProcessId).distinct().collect(Collectors.toList());
         List<MesBuildingTaskProcess> taskProcessList = this.taskProcessBiz.listByIds(asstaskProcessIds);
         if (CollectionUtils.isNotEmpty(taskProcessList)) {
            taskProcessMap = taskProcessList.stream().collect(Collectors.toMap(MesBuildingTaskProcess::getId, MesBuildingTaskProcess::getProcessId));
            List<Long> processIds = taskProcessList.stream().map(MesBuildingTaskProcess::getProcessId).distinct().collect(Collectors.toList());
            List<MesBuildingProcess> processList = this.processService.listByIds(processIds);
            processMap = processList.stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
         }
      }

      Map<Integer, List<MesBuildingTaskNumberLink>> artNumberMap = links.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
      List<MesBuildingNumberLinkDTO> dtos = new ArrayList<>();

      for (NumberInfoDTO numberInfoDTO : numbers) {
         Integer number = numberInfoDTO.getNumber();

         for (MesBuildingTaskNumberLink link : artNumberMap.get(number)) {
            if (link.getAssembleId() != null) {
               TechAssemble assemble = assembleMap.get(link.getAssembleId());
               Long processId = taskProcessMap.get(link.getAssembleTaskProcessId());
               MesBuildingNumberLinkDTO build = MesBuildingNumberLinkDTO.builder()
                  .artifactId(artifact.getId())
                  .artSerialNumber(artifact.getSerialNumber())
                  .artNumber(number)
                  .assembleId(assemble.getId())
                  .assSerialNumber(assemble.getSerialNumber())
                  .assNumber(link.getAssembleNumber())
                  .build();
               MesBuildingProcess process = processMap.get(processId);
               String s = "";
               if (link.getBoolAssembleComplete()) {
                  s = "生产完成";
               } else if (link.getBoolAssembleReport() && !link.getBoolAssembleInspection()) {
                  s = process.getName() + "生产未质检";
               } else if (!link.getBoolAssembleReport()) {
                  s = process.getName() + "未生产";
               } else {
                  Preconditions.checkArgument(false, "操作失败!!!!");
               }

               build.setProcessName(s);
               dtos.add(build);
            } else {
               MesBuildingNumberLinkDTO build = MesBuildingNumberLinkDTO.builder()
                  .artifactId(artifact.getId())
                  .artSerialNumber(artifact.getSerialNumber())
                  .artNumber(number)
                  .processName("未关联需要生产的部件!")
                  .build();
               dtos.add(build);
            }
         }
      }

      Comparator<MesBuildingNumberLinkDTO> comparator = Comparator.comparing(MesBuildingNumberLinkDTO::getArtNumber)
         .thenComparing(MesBuildingNumberLinkDTO::getAssembleId)
         .thenComparing(MesBuildingNumberLinkDTO::getAssNumber);
      Collections.sort(dtos, comparator);
      return dtos;
   }

   void unProcessSendPart(List<MesBuildingTaskNumberLink> numberLinks, Integer taskType, List<MesBuildingTaskOrderAssembleDetaiDTOParam> prunedList) {
      List<ArtifactSchedulingNeedCompleteDTO> needCompleteDTOS = new ArrayList<>();
      if (taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<Long> artIds = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactId).distinct().collect(Collectors.toList());
         List<Long> taskIds = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactTaskId).distinct().collect(Collectors.toList());
         List<MesBuildingTask> tasks = this.taskBiz.listByIds(taskIds);
         Map<Long, MesBuildingTask> taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
         List<MesBuildingTaskNumberLink> artifactTaskNumberLinks = numberLinks.stream()
            .filter(MesBuildingTaskNumberLink::getBoolArtifactComplete)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(artifactTaskNumberLinks)) {
            Map<Long, TechArtifact> artifactMap = this.artifactService
               .listByIds(artifactTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));

            for (MesBuildingTaskNumberLink numberLink : artifactTaskNumberLinks) {
               MesBuildingTask task = taskMap.get(numberLink.getArtifactTaskId());
               TechArtifact artifact = artifactMap.get(numberLink.getArtifactId());
               if (artifact.getBuildingType().equals(InventoryTypeEnum.GRID.getType()) && artifact.getBoolSendDirectly()) {
                  artifact.setProducedQuantity(artifact.getProducedQuantity() + 1);
                  ArtifactSchedulingNeedCompleteDTO build = ArtifactSchedulingNeedCompleteDTO.builder()
                     .projectId(artifact.getProjectId())
                     .monomerId(artifact.getMonomerId())
                     .areaId(artifact.getAreaId())
                     .areaBatchId(artifact.getAreaBatchId())
                     .factoryId(task.getFactoryId())
                     .completeType(taskType)
                     .number(numberLink.getArtifactNumber())
                     .numberLinkId(numberLink.getId())
                     .workshopId(task.getWorkshopId())
                     .lineId(task.getProductionLineId())
                     .artifactTaskId(task.getId())
                     .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
                     .productId(artifact.getId())
                     .quantity(1)
                     .boolSendDirectly(artifact.getBoolSendDirectly())
                     .build();
                  needCompleteDTOS.add(build);
               }
            }

            this.artifactService.updateBatchById(artifactMap.values());
         }

         List<String> housedNumberLinks = new ArrayList<>();
         List<TechArtifactMachinePartLink> machinePartLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artIds));
         Map<Long, List<TechArtifactMachinePartLink>> artParLinkMap = machinePartLinks.stream()
            .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         List<TechArtifactStandardPartLink> standardPartLinkList = this.artifactStandardPartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactStandardPartLink.class).in(TechArtifactStandardPartLink::getArtifactId, artIds));
         Map<Long, List<TechArtifactStandardPartLink>> artifactStandardPartLinkMap = standardPartLinkList.stream()
            .collect(Collectors.groupingBy(TechArtifactStandardPartLink::getArtifactId));
         if (CollectionUtils.isNotEmpty(machinePartLinks)) {
            List<TechMachinePart> machineParts = this.machinePartService
               .listByIds(machinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
            List<TechMachinePart> needWarsParts = machineParts.stream().filter(s -> !s.getBoolProcess()).collect(Collectors.toList());
            Map<Long, TechMachinePart> needProduceMap = needWarsParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

            for (MesBuildingTaskNumberLink numberLink : numberLinks) {
               if (!housedNumberLinks.contains(numberLink.getArtifactId() + "_" + numberLink.getArtifactNumber())) {
                  housedNumberLinks.add(numberLink.getArtifactId() + "_" + numberLink.getArtifactNumber());
                  MesBuildingTask task = taskMap.get(numberLink.getArtifactTaskId());
                  List<TechArtifactMachinePartLink> links = artParLinkMap.get(numberLink.getArtifactId());
                  if (CollectionUtils.isNotEmpty(links)) {
                     for (TechArtifactMachinePartLink link : links) {
                        TechMachinePart techMachinePart = needProduceMap.get(link.getMachinePartId());
                        if (techMachinePart != null) {
                           int needProduce = link.getQuantity();
                           techMachinePart.setProducedQuantity(techMachinePart.getProducedQuantity() + needProduce);
                           if (techMachinePart.getRelationType().equals(2) && techMachinePart.getBoolSendDirectly()) {
                              ArtifactSchedulingNeedCompleteDTO build = ArtifactSchedulingNeedCompleteDTO.builder()
                                 .projectId(techMachinePart.getProjectId())
                                 .monomerId(techMachinePart.getMonomerId())
                                 .areaId(techMachinePart.getAreaId())
                                 .areaBatchId(techMachinePart.getAreaBatchId())
                                 .factoryId(task.getFactoryId())
                                 .completeType(taskType)
                                 .number(numberLink.getArtifactNumber())
                                 .numberLinkId(numberLink.getId())
                                 .workshopId(task.getWorkshopId())
                                 .lineId(task.getProductionLineId())
                                 .artifactTaskId(task.getId())
                                 .taskTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
                                 .productId(techMachinePart.getId())
                                 .quantity(needProduce)
                                 .boolSendDirectly(techMachinePart.getBoolSendDirectly())
                                 .build();
                              needCompleteDTOS.add(build);
                           }
                        }
                     }
                  }
               }
            }

            List<TechMachinePart> techMachineParts = new ArrayList<>(needProduceMap.values());
            this.machinePartService.updateBatchById(techMachineParts);
         }

         if (CollectionUtils.isNotEmpty(standardPartLinkList)) {
            List<TechStandardPart> standardPartList = this.standardPartService
               .listByIds(standardPartLinkList.stream().map(TechArtifactStandardPartLink::getStandardPartId).collect(Collectors.toList()));
            List<TechStandardPart> needStandardPartList = standardPartList.stream()
               .filter(s -> s.getUseProperty().equals(AuxiliaryUsePropertyEnum.SITE_USE.getType()))
               .collect(Collectors.toList());
            Map<Long, TechStandardPart> needProduceMap = needStandardPartList.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));

            for (MesBuildingTaskNumberLink numberLink : numberLinks) {
               if (!housedNumberLinks.contains(numberLink.getArtifactId() + "_" + numberLink.getArtifactNumber())) {
                  housedNumberLinks.add(numberLink.getArtifactId() + "_" + numberLink.getArtifactNumber());
                  MesBuildingTask task = taskMap.get(numberLink.getArtifactTaskId());
                  List<TechArtifactStandardPartLink> links = artifactStandardPartLinkMap.get(numberLink.getArtifactId());
                  if (CollectionUtils.isNotEmpty(links)) {
                     for (TechArtifactStandardPartLink link : links) {
                        TechStandardPart standardPart = needProduceMap.get(link.getStandardPartId());
                        if (standardPart != null) {
                           int needProduce = link.getQuantity();
                           if (standardPart.getRelationType().equals(2)) {
                              ArtifactSchedulingNeedCompleteDTO build = ArtifactSchedulingNeedCompleteDTO.builder()
                                 .projectId(standardPart.getProjectId())
                                 .monomerId(standardPart.getMonomerId())
                                 .areaId(standardPart.getAreaId())
                                 .areaBatchId(standardPart.getAreaBatchId())
                                 .factoryId(task.getFactoryId())
                                 .completeType(taskType)
                                 .number(numberLink.getArtifactNumber())
                                 .numberLinkId(numberLink.getId())
                                 .workshopId(task.getWorkshopId())
                                 .lineId(task.getProductionLineId())
                                 .artifactTaskId(task.getId())
                                 .taskTypeEnum(TaskTypeEnum.AUXILIARY_MATERIAL.getType())
                                 .productId(standardPart.getId())
                                 .quantity(needProduce)
                                 .boolSendDirectly(Boolean.TRUE)
                                 .build();
                              needCompleteDTOS.add(build);
                           }
                        }
                     }
                  }
               }
            }
         }
      } else if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<Long> assIds = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleId).distinct().collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(assIds)) {
            List<TechAssemble> assembles = this.assembleService.listByIds(assIds);
            List<TechAssemble> needWarsAss = assembles.stream().filter(s -> !s.getBoolProcess()).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(prunedList)) {
               List<TechAssemble> noMainAssembles = this.assembleService
                  .listByIds(prunedList.stream().map(MesBuildingTaskOrderAssembleDetaiDTOParam::getProductId).collect(Collectors.toList()));
               needWarsAss.addAll(noMainAssembles);
            }

            Map<Long, TechAssemble> needProduceMap = needWarsAss.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
            List<Long> taskIds = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactTaskId).distinct().collect(Collectors.toList());
            List<MesBuildingTask> tasks = this.taskBiz.listByIds(taskIds);
            Map<Long, MesBuildingTask> taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));

            for (MesBuildingTaskNumberLink numberLink : numberLinks) {
               TechAssemble techAssemble = needProduceMap.get(numberLink.getAssembleId());
               MesBuildingTask task = taskMap.get(numberLink.getArtifactTaskId());
               if (techAssemble != null) {
                  techAssemble.setProducedQuantity(techAssemble.getProducedQuantity() + 1);
                  if (techAssemble.getBoolSendDirectly()) {
                     ArtifactSchedulingNeedCompleteDTO build = ArtifactSchedulingNeedCompleteDTO.builder()
                        .projectId(techAssemble.getProjectId())
                        .monomerId(techAssemble.getMonomerId())
                        .areaId(techAssemble.getAreaId())
                        .areaBatchId(techAssemble.getAreaBatchId())
                        .factoryId(task.getFactoryId())
                        .workshopId(task.getWorkshopId())
                        .lineId(task.getProductionLineId())
                        .artifactTaskId(task.getId())
                        .number(numberLink.getAssembleNumber())
                        .taskTypeEnum(TaskTypeEnum.ASSEMBLE.getType())
                        .productId(techAssemble.getId())
                        .quantity(1)
                        .completeType(TaskTypeEnum.ARTIFACT.getType())
                        .numberLinkId(numberLink.getId())
                        .boolSendDirectly(techAssemble.getBoolSendDirectly())
                        .build();
                     needCompleteDTOS.add(build);
                  }
               }
            }

            List<TechAssemble> assembleList = new ArrayList<>(needProduceMap.values());
            this.assembleService.updateBatchById(assembleList);
         }
      }

      List<ArtifactSchedulingNeedCompleteDTO> needWrehouse = needCompleteDTOS.stream()
         .filter(ArtifactSchedulingNeedCompleteDTO::getBoolSendDirectly)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(needWrehouse)) {
         List<MesBuildingComplete> needCompletes = new ArrayList<>();

         for (ArtifactSchedulingNeedCompleteDTO dto : needWrehouse) {
            MesBuildingComplete complete = MesBuildingComplete.builder()
               .projectId(dto.getProjectId())
               .monomerId(dto.getMonomerId())
               .areaId(dto.getAreaId())
               .areaBatchId(dto.getAreaBatchId())
               .factoryId(dto.getFactoryId())
               .number(dto.getNumber())
               .workshopId(dto.getWorkshopId())
               .productionLineId(dto.getLineId())
               .productId(dto.getProductId())
               .quantity(dto.getQuantity())
               .taskTypeEnum(dto.getTaskTypeEnum())
               .boolAbnormalEnum(false)
               .userId(UserUtil.getCurrentUserId())
               .artifactTaskId(dto.getArtifactTaskId())
               .parentType(dto.getCompleteType())
               .numberLinkId(dto.getNumberLinkId())
               .build();
            needCompletes.add(complete);
         }

         this.completeService.saveBatch(needCompletes);
         this.saveWareHouseBycomplete(needCompletes);
      }
   }

   private void saveWareHouseBycomplete(List<MesBuildingComplete> completes) {
      List<AddWarehouseDTO> addWarehouseDTOS = new ArrayList<>();

      for (MesBuildingComplete complete : completes) {
         AddWarehouseDTO build = AddWarehouseDTO.builder()
            .factoryId(complete.getFactoryId())
            .workshopId(complete.getWorkshopId())
            .productType(complete.getTaskTypeEnum())
            .productId(complete.getProductId())
            .type(WarehouseTypeEnum.INTO.getType())
            .build();
         addWarehouseDTOS.add(build);
      }

      List<MesBuildingWarehouseSummary> summaries = this.warehouseSummaryService.listWareHouseSummary(addWarehouseDTOS);
      List<MesBuildingWarehouseRecord> records = new ArrayList<>();

      for (MesBuildingComplete complete : completes) {
         MesBuildingWarehouseRecord record = BeanUtil.copy(complete, MesBuildingWarehouseRecord.class);
         record.setCompleteId(complete.getId());
         record.setQuantity(BigDecimal.valueOf(complete.getQuantity().intValue()));
         record.setUserId(UserUtil.getCurrentUserId());
         record.setUserName(UserUtil.getCurrentName());
         record.setNumber(complete.getNumber());
         record.setProductType(complete.getTaskTypeEnum());
         record.setStatus(WarehouseRecordStatusTypeEnum.INTO.getType());
         record.setType(WarehouseTypeEnum.INTO.getType());
         records.add(record);
      }

      this.warehouseRecordService.saveBatch(records);
      Map<String, List<MesBuildingComplete>> completeMap = completes.stream()
         .collect(
            Collectors.groupingBy(
               s -> s.getFactoryId()
                  + "_"
                  + s.getWorkshopId()
                  + "_"
                  + s.getTaskTypeEnum()
                  + "_"
                  + s.getProductId()
                  + "_"
                  + WarehouseRecordStatusTypeEnum.INTO.getType()
            )
         );
      Map<String, MesBuildingWarehouseSummary> summaryMap = summaries.stream()
         .collect(
            Collectors.toMap(
               s -> s.getFactoryId() + "_" + s.getWorkshopId() + "_" + s.getProductType() + "_" + s.getProductId() + "_" + s.getType(), Function.identity()
            )
         );
      Map<String, MesBuildingWarehouseSummary> saveSummaryMap = new HashMap<>();

      for (String key : completeMap.keySet()) {
         List<MesBuildingComplete> completeList = completeMap.get(key);
         int quantity = completeList.stream().mapToInt(MesBuildingComplete::getQuantity).sum();
         MesBuildingWarehouseSummary summary = summaryMap.get(key);
         Long factoryId = Long.valueOf(key.split("_")[0]);
         Long workShopId = Long.valueOf(key.split("_")[1]);
         Integer taskType = Integer.valueOf(key.split("_")[2]);
         Long productId = Long.valueOf(key.split("_")[3]);
         Integer wareHouseType = Integer.valueOf(key.split("_")[4]);
         if (summary == null) {
            MesBuildingWarehouseSummary saveSummary = saveSummaryMap.get(key);
            if (saveSummary == null) {
               saveSummary = BeanUtil.copy(completes.get(0), MesBuildingWarehouseSummary.class);
               saveSummary.setId(null);
               saveSummary.setFactoryId(factoryId);
               saveSummary.setWorkshopId(workShopId);
               saveSummary.setProductType(taskType);
               saveSummary.setType(wareHouseType);
               saveSummary.setProductId(productId);
               saveSummary.setQuantity(BigDecimal.valueOf(quantity));
               saveSummary.setProductType(completes.get(0).getTaskTypeEnum());
               saveSummary.setType(WarehouseTypeEnum.INTO.getType());
               saveSummaryMap.put(key, saveSummary);
            } else {
               saveSummary.setQuantity(saveSummary.getQuantity().add(BigDecimal.valueOf(quantity)));
               saveSummaryMap.put(key, saveSummary);
            }
         } else {
            summary.setQuantity(summary.getQuantity().add(BigDecimal.valueOf(quantity)));
         }
      }

      this.warehouseSummaryService.saveBatch(new ArrayList<>(saveSummaryMap.values()));
      this.warehouseSummaryService.updateBatchById(new ArrayList<>(summaryMap.values()));
   }
}
