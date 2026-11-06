package com.hzchum.scim.mes.building.core.biz.impl.task;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingCutConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsInspectionTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseBiz;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseInspectionLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingArtifactSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlatePartBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingAssistBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingMachinePartSchedulingArtifactTaskLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNestTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNewTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProduceTeamReportBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProjectProductionSummaryBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingSinglePartArtifactPrintBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingUnProductionBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderChangeBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTopTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.SaveProduceTeamReportSummaryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.TeamReportTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingCalcMaxNumManager;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingFabricatedPartConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingInProduction;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingTechArtifactAuxiliaryPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.IdAndRecelveQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.AddWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingNextProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseAcceptDeviationService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuJobDirectoryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingFabricatedPartConfigService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingChangeLogService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingInProductionService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSchedulingArtifactTaskLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportSummaryService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSinglePartArtifactPrintService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTopTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesProductionWageService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingTechArtifactAuxiliaryPriceService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingMapper;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.plan.core.api.biz.SysSteelAnalysisBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactAuxiliaryLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryPart;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactAuxiliaryLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactChangeService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryPartService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.project.core.api.service.ProjectInstallReportService;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.project.core.api.service.ProjectSubVisaService;
import com.hzchum.scim.system.core.api.common.enums.AuxiliaryTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliaryClassification;
import com.hzchum.scim.system.core.api.service.MesInspectClassificationConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigTeamLinkService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigUserLinkService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserService;
import com.hzchum.scim.system.core.api.service.SysAuxiliaryClassificationService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingNestTaskBizImpl implements MesBuildingNestTaskBiz {
   @Value("${chum.config.url}")
   private String ip;
   @Autowired
   private TechMachinePartService techMachinePartService;
   @Autowired
   private MesBuildingBoChuNestingResultService mesBuildingBoChuNestingResultService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingProduceTeamReportBiz teamReportBiz;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingAssistService mesBuildingAssistService;
   @Autowired
   private MesBuildingInspectionTeamService inspectionTeamService;
   @Autowired
   private MesBuildingArtifactSchedulingBiz artifactSchedulingBiz;
   @Autowired
   private MesBuildingArtifactSchedulingService artifactSchedulingService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingBiz taskNeedMachinePartSchedulingBiz;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private MesBuildingMachinePartTeamDetailService mesBuildingMachinePartTeamDetailService;
   @Autowired
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService produceInspectionTeamReportService;
   @Autowired
   private MesBuildingProduceTeamReportSummaryService produceTeamReportSummaryService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingInProductionService inProductionService;
   @Autowired
   private WarehouseBiz warehouseBiz;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingQhseBiz qhseBiz;
   @Autowired
   private MesBuildingMachinePartSchedulingArtifactTaskLinkService mesBuildingMachinePartSchedulingArtifactTaskLinkService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingService mesBuildingTaskNeedMachinePartSchedulingService;
   @Autowired
   private MesBuildingProductProductionSummaryService productionSummaryService;
   @Autowired
   private MesBuildingCargoListService cargoListService;
   @Autowired
   private MesBuildingAssistBiz assistBiz;
   @Autowired
   private MesBuildingProductionLineBiz productionLineBiz;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private EnclosurePlanService enclosurePlanService;
   @Autowired
   private PlanMonomerService monomerService;
   @Resource
   private MesBuildingQhseInspectionLinkBiz qhseInspectionLinkBiz;
   @Autowired
   private MesBuildingProduceTeamReportPriceService teamReportPriceService;
   @Resource
   private ProjectQhseProblemService qhseProblemService;
   @Resource
   private ProjectInstallReportService installReportService;
   @Resource
   private ProjectSubVisaService projectSubVisaService;
   @Autowired
   private MesBuildingGroupsBiz groupsBiz;
   @Autowired
   private MesBuildingGroupsTeamLinkBiz groupsTeamLinkBiz;
   @Autowired
   private MesBuildingGroupsInspectionTeamLinkBiz groupsInspectionTeamLinkBiz;
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesBuildingTopTaskOrderBiz topTaskOrderBiz;
   @Autowired
   private MesBuildingTopTaskOrderService topTaskOrderService;
   @Autowired
   private MesBuildingCutConfigBiz cutConfigBiz;
   @Autowired
   private MesBuildingMachinePartSchedulingService machinePartSchedulingService;
   @Autowired
   private MesBuildingMachinePartSchedulingLinkBiz partSchedulingLinkBiz;
   @Autowired
   private MesBuildingMachinePartSchedulingBiz partSchedulingBiz;
   @Autowired
   private MesBuildingNestCutPlatePartBiz nestCutPlatePartBiz;
   @Autowired
   private MesBuildingNestCutPlatePartService nestCutPlatePartService;
   @Autowired
   private MesBuildingNestCutPlateBiz nestCutPlateBiz;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingTaskOrderService taskOrderService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private SysSteelAnalysisBiz sysSteelAnalysisBiz;
   @Resource
   private MesBuildingProjectProductionSummaryBiz projectProductionSummaryBiz;
   @Resource
   private UserService userService;
   @Resource
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private SysDictionaryService dictionaryService;
   @Autowired
   private MesBuildingQhseService qhseService;
   @Autowired
   private TechArtifactAuxiliaryLinkService artifactAuxiliaryLinkService;
   @Autowired
   private MesBuildingTechArtifactAuxiliaryPriceService mesBuildingTechArtifactAuxiliaryPriceService;
   @Autowired
   private TechAuxiliaryPartService techAuxiliaryPartService;
   @Autowired
   private SysAuxiliaryClassificationService auxiliaryClassificationService;
   @Autowired
   private MesBuildingFabricatedPartConfigService buildingFabricatedPartConfigService;
   @Autowired
   private MesBuildingSinglePartArtifactPrintBiz singlePartArtifactPrintBiz;
   @Autowired
   private MesBuildingInspectionTeamUserLinkService inspectionTeamUserLinkService;
   @Autowired
   private MesBuildingSinglePartArtifactPrintService singlePartArtifactPrintService;
   @Autowired
   private MesEnclosureTaskBiz mesEnclosureTaskBiz;
   @Autowired
   private MesBuildingAssistBiz mesBuildingAssistBiz;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingUnProductionBiz unProductionBiz;
   @Resource
   private MesBuildingMachinePartSchedulingArtifactTaskLinkBiz partSchedulingArtifactTaskLinkBiz;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingChangeLogService mesBuildingChangeLogService;
   @Autowired
   private MesBuildingTaskProcessBiz mesBuildingTaskProcessBiz;
   @Autowired
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Autowired
   private TechArtifactChangeService techArtifactChangeService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingService needMachinePartSchedulingService;
   @Autowired
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   @Autowired
   private TechAssembleExtService assembleExtService;
   @Autowired
   private TechArtifactExtService artifactExtService;
   @Autowired
   private MesBuildingPackageNumberLinkService packageNumberLinkService;
   @Autowired
   private MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService;
   @Autowired
   private MesBuildingQhseService mesBuildingQhseService;
   @Autowired
   private MesBuildingTaskOrderChangeBiz orderChangeBiz;
   @Autowired
   private MesBuildingAssistNumberDetailService numberDetailService;
   @Autowired
   private MesBuildingCalcMaxNumManager mesBuildingCalcMaxNumManager;
   @Autowired
   private RedisUtils redisUtils;
   @Autowired
   private MesProductionWageService productionWageService;
   @Autowired
   private MesBuildingNewTaskBiz newTaskBiz;
   @Autowired
   private MesInspectConfigService inspectConfigService;
   @Autowired
   private MesBuildingNextProcessLinkService nextProcessLinkService;
   @Autowired
   private MesInspectConfigTeamLinkService configTeamLinkService;
   @Autowired
   private MesInspectClassificationConfigLinkService classificationConfigLinkService;
   @Autowired
   private MesInspectConfigUserLinkService inspectConfigUserLinkService;
   @Autowired
   private UserRoleLinkService userRoleLinkService;
   @Autowired
   private MesBuildingQhseAcceptDeviationService qhseAcceptDeviationService;
   @Autowired
   private MesBuildingAssistNumberDetailService assistNumberDetailService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Autowired
   private MesBuildingAssistService assistService;
   @Resource
   private ProjectInspectionUserService projectInspectionUserService;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingMapper mesBuildingTaskNeedMachinePartSchedulingMapper;
   @Autowired
   private MesBuildingBoChuJobDirectoryService mesBuildingBoChuJobDirectoryService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveNestCutPlateReport(
      Long nestCutPlateId, List<Long> partIds, String ncCode, Boolean reportType, List<IdAndRecelveQuantityDTO> parts
   ) {
      MesBuildingNestCutPlate nestCutPlate = this.nestCutPlateBiz
         .getOne(
            Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
               .eq(MesBuildingNestCutPlate::getId, nestCutPlateId)
               .eq(ncCode != null, MesBuildingNestCutPlate::getNcCode, ncCode)
         );
      Preconditions.checkArgument(nestCutPlate != null, "操作失败：任务切割指令不存在");
      if (!nestCutPlate.getBoolNestCutEnum()) {
         Preconditions.checkArgument(!nestCutPlate.getBoolProductionEunm(), "操作失败：该切割指令已上报");
         Map<Long, Integer> partMap = parts.stream()
            .collect(Collectors.toMap(IdAndRecelveQuantityDTO::getProductId, IdAndRecelveQuantityDTO::getReceivedQuantity));
         List<MesBuildingTaskProcess> list = this.taskProcessService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .eq(MesBuildingTaskProcess::getNestCutPlateId, nestCutPlateId)
                  .in(partMap.keySet().size() != 0, MesBuildingTaskProcess::getProductId, partMap.keySet())
                  .in(
                     MesBuildingTaskProcess::getProcessId,
                     this.processService
                        .list(
                           Wrappers.lambdaQuery(MesBuildingProcess.class)
                              .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
                              .ne(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                        )
                        .stream()
                        .map(MesBuildingProcess::getId)
                        .collect(Collectors.toList())
                  )
                  .eq(MesBuildingTaskProcess::getSequence, 0)
            );
         ArrayList<MesBuildingNestCutPlatePart> cutPlateParts = new ArrayList<>();

         for (MesBuildingTaskProcess taskProcess : list) {
            MesBuildingNestCutPlatePart nestCutPlatePart = this.nestCutPlatePartBiz
               .getOne(
                  Wrappers.lambdaUpdate(MesBuildingNestCutPlatePart.class)
                     .eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, taskProcess.getNestCutPlateId())
                     .eq(MesBuildingNestCutPlatePart::getPartId, taskProcess.getProductId())
               );
            nestCutPlatePart.setCompleteQuantity(nestCutPlatePart.getCompleteQuantity() + partMap.get(taskProcess.getProductId()));
            nestCutPlatePart.setBoolCompleteEnum(nestCutPlatePart.getQuantity().equals(nestCutPlatePart.getCompleteQuantity()));
            cutPlateParts.add(nestCutPlatePart);
            this.saveProduceTeamReport(
               MesBuildingProduceTeamReportDTOParam.builder()
                  .id(taskProcess.getId())
                  .reportQuantity(partMap.get(taskProcess.getProductId()))
                  .reportType(Boolean.FALSE)
                  .build()
            );
         }

         this.nestCutPlatePartService.updateBatchById(cutPlateParts);
         if (this.nestCutPlatePartBiz
               .count(
                  Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class)
                     .eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutPlate)
                     .eq(MesBuildingNestCutPlatePart::getBoolCompleteEnum, Boolean.FALSE)
               )
            == 0) {
            nestCutPlate.setBoolProductionEunm(Boolean.TRUE);
            if (CollectionUtils.isNotEmpty(partMap.keySet())) {
               List<AppTaskProcessDTO> machinePartListByCutId = this.getMachinePartListByCutId(nestCutPlateId, null, null, null, null);
               int sum = machinePartListByCutId.stream().mapToInt(AppTaskProcessDTO::getQuantity).sum();
               nestCutPlate.setBoolProductionEunm(sum == 0);
            }

            this.nestCutPlateBiz.updateById(nestCutPlate);
            if (nestCutPlate.getBoolNestCutEnum()) {
               Preconditions.checkArgument(ncCode != null, "操作失败：扫描条形码有误");
               List<Long> checkNestCutPlateIdList = this.nestCutPlateBiz
                  .list(Wrappers.lambdaQuery(MesBuildingNestCutPlate.class).eq(MesBuildingNestCutPlate::getNcCode, ncCode))
                  .stream()
                  .map(MesBuildingNestCutPlate::getId)
                  .collect(Collectors.toList());
               Preconditions.checkArgument(checkNestCutPlateIdList.contains(nestCutPlate.getId()), "操作失败：扫码有误");
               Preconditions.checkArgument(nestCutPlate.getBoolNestCutEnum(), "操作失败：未绑定钢板");
            }
         }
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveDrillNestCutPlateReport(Long nestCutPlateId, List<IdAndRecelveQuantityDTO> parts, Boolean reportType) {
      MesBuildingNestCutPlate nestCutPlate = this.nestCutPlateBiz.getById(nestCutPlateId);
      if (this.nestCutPlatePartBiz
            .count(
               Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class)
                  .eq(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutPlate.getId())
                  .eq(MesBuildingNestCutPlatePart::getBoolCompleteEnum, Boolean.FALSE)
            )
         == 0) {
         nestCutPlate.setBoolProductionEunm(Boolean.TRUE);
         this.nestCutPlateBiz.updateById(nestCutPlate);
      }

      Map<Long, Integer> partMap = parts.stream()
         .collect(Collectors.toMap(IdAndRecelveQuantityDTO::getProductId, IdAndRecelveQuantityDTO::getReceivedQuantity));
      this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .eq(MesBuildingTaskProcess::getNestCutPlateId, nestCutPlateId)
               .in(MesBuildingTaskProcess::getProductId, parts.stream().map(IdAndRecelveQuantityDTO::getProductId).collect(Collectors.toList()))
               .in(
                  MesBuildingTaskProcess::getProcessId,
                  this.processService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingProcess.class)
                           .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
                           .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                     )
                     .stream()
                     .map(MesBuildingProcess::getId)
                     .collect(Collectors.toList())
               )
         )
         .forEach(
            e -> this.saveProduceTeamReport(
               MesBuildingProduceTeamReportDTOParam.builder().id(e.getId()).reportQuantity(partMap.get(e.getProductId())).reportType(Boolean.FALSE).build()
            )
         );
      return Boolean.TRUE;
   }

   public List<AppTaskProcessDTO> getMachinePartListByCutId(Long cutId, Long projectId, Long monomerId, Long areaId, String serialNumber) {
      List<AppTaskProcessDTO> dtos = this.taskProcessService
         .listCutTaskByTaskOrderId(cutId, projectId, monomerId, areaId, serialNumber)
         .stream()
         .sorted(Comparator.comparing(AppTaskProcessDTO::getQuantity).reversed())
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(dtos)) {
         dtos = dtos.stream().map(s -> s.setPicturePath(this.ip + "files/" + s.getPicturePath())).collect(Collectors.toList());
      }

      return dtos;
   }

   @Transactional(rollbackFor = Exception.class)
   public List<Integer> saveProduceTeamReport(MesBuildingProduceTeamReportDTOParam dtoParam) {
      if (dtoParam.getReportType() == null) {
         dtoParam.setReportType(false);
      }

      if (dtoParam.getBoolAssistEnum() == null) {
         dtoParam.setBoolAssistEnum(Boolean.FALSE);
      }

      if (CollectionUtils.isEmpty(dtoParam.getNumberList())) {
         List<Integer> numberList = this.mesBuildingCalcMaxNumManager
            .getNumberList(dtoParam.getId(), dtoParam.getBoolAssistEnum(), dtoParam.getAssistGroupId(), dtoParam.getReportQuantity());
         if (CollectionUtils.isNotEmpty(numberList)) {
            dtoParam.setNumberList(numberList);
         }
      }

      Preconditions.checkArgument(dtoParam.getReportQuantity().intValue() > 0L, "上报数不能小于零");
      MesBuildingTaskProcess mesBuildingTaskProcess = this.taskProcessService.getById(dtoParam.getId());
      this.checkProductStatus(Collections.singletonList(mesBuildingTaskProcess.getProductId()), mesBuildingTaskProcess.getTaskTypeEnum());
      MesBuildingAssist assist = null;
      Long teamId;
      if (dtoParam.getBoolAssistEnum()) {
         assist = this.assistBiz
            .getOne(
               Wrappers.lambdaQuery(MesBuildingAssist.class)
                  .eq(MesBuildingAssist::getTaskProcessId, dtoParam.getId())
                  .eq(MesBuildingAssist::getGroupsId, dtoParam.getAssistGroupId())
                  .eq(MesBuildingAssist::getBoolFinishEnum, false)
            );
         Preconditions.checkArgument(assist != null, "上报失败请刷新后重试!!!");
         Long processId = assist.getProcessId();
         assist.setProduceQuantity(assist.getProduceQuantity() + dtoParam.getReportQuantity());
         Preconditions.checkArgument(assist.getQuantity() >= assist.getProduceQuantity(), "操作失败,请刷新后重试!!!");
         assist.setBoolFinishEnum(assist.getQuantity().equals(assist.getProduceQuantity()));
         this.mesBuildingAssistBiz.updateById(assist);
         Preconditions.checkArgument(assist.getQuantity() >= dtoParam.getReportQuantity(), "操作失败：请刷新后重试!!");
         teamId = mesBuildingTaskProcess.getTeamId();
      } else {
         List<MesBuildingAssist> assistList = this.assistBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingAssist.class)
                  .eq(MesBuildingAssist::getTaskProcessId, dtoParam.getId())
                  .eq(MesBuildingAssist::getBoolFinishEnum, false)
            );
         Integer assquantity = this.getAssistQuantity(assistList, mesBuildingTaskProcess.getTaskTypeEnum());
         Preconditions.checkArgument(
            dtoParam.getReportQuantity() <= mesBuildingTaskProcess.getNeedQuantity() - mesBuildingTaskProcess.getCompleteQuantity() - assquantity,
            "操作失败：请刷新后重试!!"
         );
         if (mesBuildingTaskProcess.getTeamId() != null) {
            teamId = mesBuildingTaskProcess.getTeamId();
         } else {
            List<Long> drillProcessIdList = this.processService
               .list(
                  Wrappers.lambdaQuery(MesBuildingProcess.class)
                     .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                     .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               )
               .stream()
               .map(MesBuildingProcess::getId)
               .collect(Collectors.toList());
            if (drillProcessIdList.contains(mesBuildingTaskProcess.getProcessId())) {
               teamId = 0L;
            } else {
               teamId = 0L;
            }
         }
      }

      dtoParam.setTeamId(teamId);
      if (mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(mesBuildingTaskProcess.getProductId());
         Preconditions.checkArgument(artifact.getBoolStatusEnum(), "操作失败：该构件已暂停生产!");
      }

      Preconditions.checkArgument(
         mesBuildingTaskProcess.getNeedQuantity() >= mesBuildingTaskProcess.getCompleteQuantity() + dtoParam.getReportQuantity(), "上报失败，超出可生产数量"
      );
      return this.checkProductAndProduceTeamReport(
         mesBuildingTaskProcess,
         dtoParam.getReportQuantity(),
         dtoParam.getAssistGroupId(),
         dtoParam.getTeamId(),
         dtoParam.getReportType(),
         dtoParam.getNumberList(),
         assist
      );
   }

   public Boolean checkProductStatus(List<Long> productIds, Integer taskTypeEnum) {
      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<String> artNumbers = this.artifactService
            .listByIds(productIds)
            .stream()
            .filter(s -> !s.getBoolStatusEnum())
            .map(TechArtifact::getSerialNumber)
            .collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isEmpty(artNumbers), "构件:" + String.join(",", artNumbers) + "处于冻结中!!无法操作!!!");
         List<TechAssembleDetail> assembleDetails = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, productIds));
         if (CollectionUtils.isNotEmpty(assembleDetails)) {
            List<Long> assIds = assembleDetails.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList());
            List<TechAssembleDetail> allDetails = this.assembleDetailService
               .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getAssembleId, assIds));
            List<String> assNumbers = this.artifactService
               .listByIds(allDetails.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()))
               .stream()
               .filter(s -> !s.getBoolStatusEnum())
               .map(TechArtifact::getSerialNumber)
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isEmpty(assNumbers), "本部件关联的构件:" + String.join(",", assNumbers) + "处于冻结中!!无法操作!!!");
         }

         List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, productIds));
         if (CollectionUtils.isNotEmpty(partLinks)) {
            List<Long> partIds = partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
            List<TechArtifactMachinePartLink> allPartLinks = this.artifactMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getMachinePartId, partIds));
            List<String> partNumbers = this.artifactService
               .listByIds(allPartLinks.stream().map(TechArtifactMachinePartLink::getArtifactId).collect(Collectors.toList()))
               .stream()
               .filter(s -> !s.getBoolStatusEnum())
               .map(TechArtifact::getSerialNumber)
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isEmpty(partNumbers), "本零件关联的构件:" + String.join(",", partNumbers) + "处于冻结中!!无法操作!!!");
         }
      } else if (taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssembleDetail> assembleDetails = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getAssembleId, productIds));
         List<String> numbers = this.artifactService
            .listByIds(assembleDetails.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()))
            .stream()
            .filter(s -> !s.getBoolStatusEnum())
            .map(TechArtifact::getSerialNumber)
            .collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isEmpty(numbers), "本部件关联的构件:" + String.join(",", numbers) + "处于冻结中!!无法操作!!!");
      } else if (taskTypeEnum.equals(TaskTypeEnum.MACHINE_PART.getType())) {
         List<TechMachinePart> techMachineParts = this.techMachinePartService.listByIds(productIds);
         List<TechMachinePart> techMachinePartYFB = techMachineParts.stream()
            .filter(part -> part.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(techMachinePartYFB)) {
            List<Long> productYFBIds = techMachinePartYFB.stream().map(TechMachinePart::getId).collect(Collectors.toList());
            List<TechAssembleMachinePartLink> assemblePartLinks = this.assembleMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getMachinePartId, productYFBIds));
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(assemblePartLinks), "翼腹板部件不存在");
            List<Long> assembleIds = assemblePartLinks.stream().map(TechAssembleMachinePartLink::getAssembleId).collect(Collectors.toList());
            List<TechAssembleDetail> assembleDetails = this.assembleDetailService
               .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getAssembleId, assembleIds));
            List<String> numbers = this.artifactService
               .listByIds(assembleDetails.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()))
               .stream()
               .filter(s -> !s.getBoolStatusEnum())
               .map(TechArtifact::getSerialNumber)
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isEmpty(numbers), "本部件关联的构件:" + String.join(",", numbers) + "处于冻结中!!无法操作!!!");
         }

         List<TechMachinePart> techMachinePartOther = techMachineParts.stream()
            .filter(part -> !part.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(techMachinePartOther)) {
            List<Long> productOtherIds = techMachinePartOther.stream().map(TechMachinePart::getId).collect(Collectors.toList());
            List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getMachinePartId, productOtherIds));
            List<String> numbers = this.artifactService
               .listByIds(partLinks.stream().map(TechArtifactMachinePartLink::getArtifactId).collect(Collectors.toList()))
               .stream()
               .filter(s -> !s.getBoolStatusEnum())
               .map(TechArtifact::getSerialNumber)
               .collect(Collectors.toList());
            Preconditions.checkArgument(CollectionUtils.isEmpty(numbers), "本零件关联的构件:" + String.join(",", numbers) + "处于冻结中!!无法操作!!!");
         }
      } else {
         Preconditions.checkArgument(false, "产品类型不正确!!!!!");
      }

      return true;
   }

   List<Integer> checkProductAndProduceTeamReport(
      MesBuildingTaskProcess taskProcess,
      Integer reportQuantity,
      Long assistGroupId,
      Long teamId,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingAssist assist
   ) {
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         if (taskProcess.getSequence() == 0 && this.projectService.getProjectMode(taskProcess.getProjectId()).equals(ProjectModeEnum.STANDARD_MODE.getType())) {
            TechAssemble assemble = this.assembleService.getById(taskProcess.getProductId());
            Preconditions.checkArgument(assemble != null, "操作失败，找不到对应组立");
            List<TechAssembleMachinePartLink> assembleMachinePartLinks = this.assembleMachinePartLinkService
               .list((Wrapper<TechAssembleMachinePartLink>)Wrappers.<TechAssembleMachinePartLink>lambdaQuery().eq(TechAssembleMachinePartLink::getAssembleId, assemble.getId()));
            if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
               List<Long> partIds = assembleMachinePartLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList());
               List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
               Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
               assembleMachinePartLinks.forEach(
                  e -> {
                     TechMachinePart machinePart = partMap.get(e.getMachinePartId());
                     Preconditions.checkArgument(machinePart != null, "操作失败，找不到对应零件");
                     machinePart.setProducedQuantity(machinePart.getProducedQuantity() + e.getQuantity() * reportQuantity);
                     if (!machinePart.getBoolSendDirectly()) {
                        Preconditions.checkArgument(
                           machinePart.getProducedQuantity() - machinePart.getUsedQuantity() >= reportQuantity * e.getQuantity(),
                           "操作失败，零件" + machinePart.getSerialNumber() + "数量不足"
                        );
                     }

                     machinePart.setUsedQuantity(machinePart.getUsedQuantity() + reportQuantity * e.getQuantity());
                  }
               );
               this.machinePartService.updateBatchById(new ArrayList<>(partMap.values()));
            }

            this.updateQuantity(taskProcess.getTaskId(), reportQuantity);
         }

         numberList = this.productProduceTeamReport(taskProcess, reportQuantity, assistGroupId, teamId, reportType, numberList, assist);
      }

      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(taskProcess.getProductId());
         Preconditions.checkArgument(artifact != null, "操作失败，找不到对应构件");
         if (taskProcess.getSequence() == 0) {
            if (this.projectService.getProjectMode(taskProcess.getProjectId()).equals(ProjectModeEnum.STANDARD_MODE.getType())) {
               List<TechAssembleDetail> assembleDetails = this.assembleDetailService
                  .list((Wrapper<TechAssembleDetail>)Wrappers.<TechAssembleDetail>lambdaQuery().eq(TechAssembleDetail::getArtifactId, artifact.getId()));
               if (!assembleDetails.isEmpty()) {
                  List<Long> assIds = assembleDetails.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList());
                  List<TechAssemble> assembleList = this.assembleService.listByIds(assIds);
                  Map<Long, TechAssemble> assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
                  assembleDetails.forEach(
                     e -> {
                        TechAssemble assemble = assembleMap.get(e.getAssembleId());
                        Preconditions.checkArgument(assemble != null, "操作失败，找不到对应组立");
                        if (!assemble.getBoolSendDirectly()) {
                           Preconditions.checkArgument(
                              assemble.getProducedQuantity() - assemble.getUsedQuantity() >= reportQuantity * e.getQuantity(), "操作失败，对应组立数量不足"
                           );
                        }

                        assemble.setUsedQuantity(assemble.getUsedQuantity() + reportQuantity * e.getQuantity());
                     }
                  );
                  this.assembleService.updateBatchById(new ArrayList<>(assembleMap.values()));
               }

               if (this.projectService.getProjectMode(taskProcess.getProjectId()).equals(ProjectModeEnum.STANDARD_MODE.getType())) {
                  List<TechArtifactMachinePartLink> artifactMachinePartLinkList = this.artifactMachinePartLinkService
                     .list((Wrapper<TechArtifactMachinePartLink>)Wrappers.<TechArtifactMachinePartLink>lambdaQuery().eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()));
                  if (CollectionUtils.isNotEmpty(artifactMachinePartLinkList)) {
                     List<Long> partIds = artifactMachinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
                     List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
                     Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
                     artifactMachinePartLinkList.forEach(
                        e -> {
                           TechMachinePart machinePart = partMap.get(e.getMachinePartId());
                           Preconditions.checkArgument(machinePart != null, "操作失败，找不到对应零件");
                           if (!machinePart.getRelationType().equals(18) && machinePart.getRelationType().equals(TaskTypeEnum.ARTIFACT.getType())) {
                              if (!machinePart.getBoolSendDirectly()) {
                                 Preconditions.checkArgument(
                                    machinePart.getProducedQuantity() - machinePart.getUsedQuantity() >= reportQuantity * e.getQuantity(),
                                    "操作失败，零件" + machinePart.getSerialNumber() + "数量不足"
                                 );
                              }

                              machinePart.setUsedQuantity(machinePart.getUsedQuantity() + reportQuantity * e.getQuantity());
                           }
                        }
                     );
                     this.machinePartService.updateBatchById(new ArrayList<>(partMap.values()));
                  }
               }
            }

            this.updateQuantity(taskProcess.getTaskId(), reportQuantity);
         }

         numberList = this.productProduceTeamReport(taskProcess, reportQuantity, assistGroupId, teamId, reportType, numberList, assist);
      }

      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         if (taskProcess.getSequence() == 0) {
            this.updateQuantity(taskProcess.getTaskId(), reportQuantity);
         }

         this.productProduceTeamReport(taskProcess, reportQuantity, assistGroupId, teamId, reportType, numberList, assist);
      }

      return numberList;
   }

   private void updateQuantity(Long taskId, Integer reportQuantity) {
      MesBuildingTask task = this.taskService.getById(taskId);
      if (task.getInProductionTime() == null) {
         task.setInProductionTime(LocalDateTime.now());
         ContractProject project = this.projectService.getById(task.getProjectId());
         if (project != null && project.getMesStartDate() == null) {
            project.setMesStartDate(LocalDateTime.now());
            this.projectService.updateById(project);
         }
      }

      task.setInProductionQuantity(task.getInProductionQuantity() + reportQuantity);
      Preconditions.checkArgument(this.taskService.updateById(task), "上报中,请刷新页面");
      this.productionSummaryService
         .updateRecord(
            ProductProductionSummaryDTOParam.builder()
               .projectId(task.getProjectId())
               .monomerId(task.getMonomerId())
               .productId(task.getProductId())
               .productType(task.getTaskTypeEnum())
               .inProductionQuantity(reportQuantity)
               .build()
         );
   }

   private List<Integer> productProduceTeamReport(
      MesBuildingTaskProcess mesBuildingTaskProcess,
      Integer reportQuantity,
      Long assistGroupId,
      Long teamId,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingAssist assist
   ) {
      Boolean boolHaveInspect = this.utilsBiz
         .checkInspectionTeam(assist != null ? assist.getGroupsId() : mesBuildingTaskProcess.getGroupsId(), mesBuildingTaskProcess.getProcessId());
      return this.updateTaskProcess(mesBuildingTaskProcess, reportQuantity, boolHaveInspect, assistGroupId, teamId, reportType, numberList, assist);
   }

   private Integer getAssistQuantity(List<MesBuildingAssist> assistBizs, Integer productType) {
      int size = 0;
      if (CollectionUtil.isNotEmpty(assistBizs)) {
         List<MesBuildingAssistNumberDetail> assistNumberDetails = this.assistNumberDetailService
            .list(
               (Wrapper<MesBuildingAssistNumberDetail>)(new LambdaQueryWrapper<MesBuildingAssistNumberDetail>()
                     .in(MesBuildingAssistNumberDetail::getAssistId, assistBizs.stream().map(MesBuildingAssist::getId).collect(Collectors.toList())))
                  .eq(MesBuildingAssistNumberDetail::getBoolFinishEnum, Boolean.FALSE)
            );
         if (CollectionUtil.isNotEmpty(assistNumberDetails)) {
            Map<Long, List<Integer>> assistNumberDetailMap = assistNumberDetails.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingAssistNumberDetail::getTaskProcessId, Collectors.mapping(MesBuildingAssistNumberDetail::getNumber, Collectors.toList())
                  )
               );
            LambdaQueryWrapper<MesBuildingTaskNumberLink> taskNumberQueryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();
            if (productType.equals(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            if (productType.equals(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ASSEMBLE.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            List<MesBuildingTaskNumberLink> taskNumberLinks = this.taskNumberLinkService.list(taskNumberQueryWrapper);
            if (CollectionUtil.isNotEmpty(taskNumberLinks)) {
               if (productType.equals(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType())) {
                  size = taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList()).size();
               }

               if (productType.equals(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ASSEMBLE.getType())) {
                  size = taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList()).size();
               }
            }
         }
      }

      return size;
   }

   List<Integer> updateTaskProcess(
      MesBuildingTaskProcess mesBuildingTaskProcess,
      Integer reportQuantity,
      boolean isInspection,
      Long assistGroupId,
      Long teamId,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingAssist assist
   ) {
      boolean booleOneCode = CollectionUtils.isNotEmpty(numberList);
      MesBuildingTeam team = this.teamService.getById(teamId);
      Preconditions.checkArgument(team != null, "上报失败,用户没有处于可以生产班组内");
      new HashMap();
      new ArrayList();
      List<Integer> finalNumberList = numberList;
      List<MesBuildingAssistNumberDetail> assistDetails;
      Map assistDetaiMap;
      List assistNumbers;
      if (assist != null) {
         assistDetails = this.numberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .eq(MesBuildingAssistNumberDetail::getAssistId, assist.getId())
                  .eq(MesBuildingAssistNumberDetail::getTaskProcessId, mesBuildingTaskProcess.getId())
                  .orderByAsc(MesBuildingAssistNumberDetail::getNumber)
            );
         if (CollectionUtils.isNotEmpty(numberList)) {
            assistDetails = assistDetails.stream().filter(s -> finalNumberList.contains(s.getNumber())).collect(Collectors.toList());
            Preconditions.checkArgument(assistDetails.stream().noneMatch(MesBuildingAssistNumberDetail::getBoolFinishEnum), "操作失败!");
         }

         Preconditions.checkArgument(assistDetails.size() >= reportQuantity, "操作失败!");
         assistDetaiMap = assistDetails.stream().collect(Collectors.toMap(MesBuildingAssistNumberDetail::getNumber, Function.identity()));
         assistNumbers = assistDetails.stream().filter(s -> !s.getBoolFinishEnum()).map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());
      } else {
         assistDetails = this.numberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .eq(MesBuildingAssistNumberDetail::getTaskProcessId, mesBuildingTaskProcess.getId())
                  .orderByAsc(MesBuildingAssistNumberDetail::getNumber)
            );
         assistDetaiMap = assistDetails.stream().collect(Collectors.toMap(MesBuildingAssistNumberDetail::getNumber, Function.identity()));
         assistNumbers = assistDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(numberList)) {
            Preconditions.checkArgument(assistNumbers.stream().noneMatch(finalNumberList::contains), "操作失败,本次上报的码号不得与协同的码号重复!");
         }
      }

      List<MesBuildingAssistNumberDetail> finishedAssistDetails = new ArrayList<>();
      if (mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, mesBuildingTaskProcess.getId())
                  .in(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getArtifactNumber, numberList)
                  .eq(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, true)
                  .eq(CollectionUtils.isEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, false)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
                  .orderByAsc(MesBuildingTaskNumberLink::getArtifactNumber)
            );
         Map<Integer, List<MesBuildingTaskNumberLink>> numberLinkMap = numberLinks.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
         Preconditions.checkArgument(numberLinkMap.keySet().size() >= reportQuantity, "操作失败,请刷新页面后重试!!!!");
         List<MesBuildingTaskNumberLink> allValues = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(numberList)) {
            Preconditions.checkArgument(numberLinks.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete), "操作失败!");
            allValues.addAll(numberLinks);
            if (assist != null) {
               finishedAssistDetails.addAll(assistDetails);
            }
         } else {
            Integer needLimit = reportQuantity;

            for (Integer number : numberLinkMap.keySet()) {
               if (assist == null && !assistNumbers.contains(number) || assist != null && assistNumbers.contains(number)) {
                  List<MesBuildingTaskNumberLink> links = numberLinkMap.get(number);
                  if (needLimit > 0 && links.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                     needLimit = needLimit - 1;
                     allValues.addAll(links);
                     if (assist != null) {
                        MesBuildingAssistNumberDetail detail = (MesBuildingAssistNumberDetail)assistDetaiMap.get(number);
                        finishedAssistDetails.add(detail);
                     }
                  }
               }
            }

            Preconditions.checkArgument(needLimit == 0, "操作失败!");
         }

         for (MesBuildingTaskNumberLink numberLink : allValues) {
            numberLink.setBoolArtifactInproduce(Boolean.TRUE);
            if (!isInspection) {
               Long nextProcessId = mesBuildingTaskProcess.getNextProcessId();
               MesBuildingTaskProcess nextTaskProcess = this.taskProcessService
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                        .eq(MesBuildingTaskProcess::getTaskId, mesBuildingTaskProcess.getTaskId())
                        .eq(MesBuildingTaskProcess::getProcessId, mesBuildingTaskProcess.getNextProcessId())
                  );
               Long nextTaskProcessId = nextTaskProcess == null ? null : nextTaskProcess.getId();
               if (nextProcessId == null) {
                  numberLink.setArtifactTaskProcessId(0L);
                  numberLink.setBoolArtifactReport(Boolean.TRUE);
                  numberLink.setBoolArtifactInspection(Boolean.TRUE);
                  numberLink.setBoolArtifactComplete(Boolean.TRUE);
               } else {
                  numberLink.setArtifactTaskProcessId(nextTaskProcessId);
                  numberLink.setBoolArtifactReport(Boolean.FALSE);
                  numberLink.setBoolArtifactInspection(Boolean.FALSE);
               }
            } else {
               numberLink.setBoolArtifactReport(true);
               numberLink.setBoolArtifactInspection(Boolean.FALSE);
            }
         }

         this.mesBuildingTaskNumberLinkService.updateBatchById(allValues);
         numberList = allValues.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList());
      } else if (mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, mesBuildingTaskProcess.getId())
                  .in(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getAssembleNumber, numberList)
                  .eq(CollectionUtils.isNotEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, true)
                  .eq(CollectionUtils.isEmpty(numberList), MesBuildingTaskNumberLink::getBoolOneCode, false)
                  .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, false)
                  .orderByAsc(MesBuildingTaskNumberLink::getAssembleNumber)
            );
         if (assist != null) {
            List<Integer> finalAssistNumbers = assistNumbers;
            numberLinks = numberLinks.stream().filter(s -> finalAssistNumbers.contains(s.getAssembleNumber())).collect(Collectors.toList());
            Preconditions.checkArgument(numberLinks.size() >= reportQuantity);
         }

         numberLinks = numberLinks.stream().limit(reportQuantity.intValue()).collect(Collectors.toList());
         Preconditions.checkArgument(numberLinks.size() >= reportQuantity, "操作失败,请刷新页面后重试!!!!");
         if (assist != null) {
            for (MesBuildingTaskNumberLink numberLink : numberLinks) {
               MesBuildingAssistNumberDetail detail = (MesBuildingAssistNumberDetail)assistDetaiMap.get(numberLink.getAssembleNumber());
               finishedAssistDetails.add(detail);
            }
         }

         for (MesBuildingTaskNumberLink numberLink : numberLinks) {
            numberLink.setBoolAssembleInproduce(Boolean.TRUE);
            if (!isInspection) {
               Long nextProcessId = mesBuildingTaskProcess.getNextProcessId();
               MesBuildingTaskProcess nextTaskProcess = this.taskProcessService
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                        .eq(MesBuildingTaskProcess::getTaskId, mesBuildingTaskProcess.getTaskId())
                        .eq(MesBuildingTaskProcess::getProcessId, mesBuildingTaskProcess.getNextProcessId())
                  );
               Long nextTaskProcessId = nextTaskProcess == null ? null : nextTaskProcess.getId();
               if (nextProcessId == null) {
                  numberLink.setAssembleTaskProcessId(0L);
                  numberLink.setBoolAssembleReport(Boolean.TRUE);
                  numberLink.setBoolAssembleInspection(Boolean.TRUE);
                  numberLink.setBoolAssembleComplete(Boolean.TRUE);
               } else {
                  numberLink.setAssembleTaskProcessId(nextTaskProcessId);
                  numberLink.setBoolAssembleReport(Boolean.FALSE);
                  numberLink.setBoolAssembleInspection(Boolean.FALSE);
               }
            } else {
               numberLink.setBoolAssembleReport(true);
               numberLink.setBoolAssembleInspection(Boolean.FALSE);
            }
         }

         this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
         numberList = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
      }

      if (CollectionUtils.isNotEmpty(finishedAssistDetails)) {
         finishedAssistDetails.forEach(s -> s.setBoolFinishEnum(Boolean.TRUE));
         this.numberDetailService.updateBatchById(finishedAssistDetails);
      }

      if (!mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())
         && !mesBuildingTaskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         this.saveTeamReport(mesBuildingTaskProcess, reportQuantity, isInspection, reportType, null, team, assist, booleOneCode);
      } else {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberList), "操作失败,产品需要一物一码");
         this.saveTeamReport(mesBuildingTaskProcess, reportQuantity, isInspection, reportType, numberList, team, assist, booleOneCode);
      }

      if (isInspection) {
         mesBuildingTaskProcess.setCompleteQuantity(mesBuildingTaskProcess.getCompleteQuantity() + reportQuantity);
         this.taskProcessService.updateById(mesBuildingTaskProcess);
         this.saveProduceTeamReportSummary(
            mesBuildingTaskProcess, reportQuantity, assistGroupId, team.getId(), SaveProduceTeamReportSummaryTypeEnum.PRODUCE_REPORT.getType()
         );
      } else {
         this.saveProduceTeamReportSummary(
            mesBuildingTaskProcess, reportQuantity, assistGroupId, team.getId(), SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType()
         );
         mesBuildingTaskProcess.setCompleteQuantity(mesBuildingTaskProcess.getCompleteQuantity() + reportQuantity);
         mesBuildingTaskProcess.setInspectionQuantity(mesBuildingTaskProcess.getCompleteQuantity());
         if (mesBuildingTaskProcess.getCompleteQuantity().equals(mesBuildingTaskProcess.getNeedQuantity())) {
            mesBuildingTaskProcess.setCompleteTime(LocalDateTime.now());
         }

         this.taskProcessService.updateById(mesBuildingTaskProcess);
         this.updateNextTaskProcess(mesBuildingTaskProcess, reportQuantity, team.getId(), numberList);
      }

      return numberList;
   }

   public Boolean updateNextTaskProcess(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long teamId, List<Integer> numberList) {
      List<MesBuildingTaskNumberLink> numberLinks = null;
      Map<Integer, List<MesBuildingTaskNumberLink>> numberLinksMap = new HashMap<>();
      Integer typeEnum = taskProcess.getTaskTypeEnum();
      if (typeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskId, taskProcess.getTaskId())
                  .in(MesBuildingTaskNumberLink::getArtifactNumber, numberList)
            );
         numberLinksMap = numberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
      } else if (typeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getAssembleTaskId, taskProcess.getTaskId())
                  .in(MesBuildingTaskNumberLink::getAssembleNumber, numberList)
            );
         numberLinksMap = numberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleNumber));
      }

      this.buildProductProcess(taskProcess, teamId, numberList, numberLinksMap, typeEnum, reportQuantity);
      List<MesBuildingTask> taskList = this.taskService
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .eq(MesBuildingTask::getTaskOrderId, taskProcess.getTaskOrderId())
               .isNull(MesBuildingTask::getCompleteTime)
         );
      if (taskList.size() == 0) {
         MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(taskProcess.getTaskOrderId());
         taskOrder.setCompleteTime(LocalDateTime.now());
         this.taskOrderBiz.updateById(taskOrder);
         if (typeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
            List<MesBuildingTaskOrder> taskOrderList = this.taskOrderBiz
               .list(
                  Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
                     .eq(MesBuildingTaskOrder::getTopTaskOrderId, taskOrder.getTopTaskOrderId())
                     .isNull(MesBuildingTaskOrder::getCompleteTime)
               );
            if (taskOrderList.size() == 0) {
               this.topTaskOrderBiz.updateById(MesBuildingTopTaskOrder.builder().id(taskOrder.getTopTaskOrderId()).completeTime(LocalDateTime.now()).build());
            }
         }

         if (typeEnum.equals(TaskTypeEnum.MACHINE_PART.getType()) && null != taskOrder.getChildGuid()) {
            List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.mesBuildingBoChuNestingResultService
               .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaQueryWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getChildGuid, taskOrder.getChildGuid()));
            if (CollectionUtil.isNotEmpty(mesBuildingBoChuNestingResultList)) {
               mesBuildingBoChuNestingResultList.forEach(item -> {
                  item.setCutStatus(CutStatusEnum.CUT_COMPLETED.getCode());
                  BigDecimal taskRate = new BigDecimal("100").setScale(8, RoundingMode.HALF_UP);
                  item.setTaskRate(taskRate);
                  this.mesBuildingBoChuNestingResultService.updateById(item);
               });
            }
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   public Boolean saveProduceTeamReportSummary(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long assistGroupId, Long teamId, Integer type) {
      MesBuildingProduceTeamReportSummary produceTeamReportSummary = this.produceTeamReportSummaryService
         .getOne(
            (Wrapper<MesBuildingProduceTeamReportSummary>)(((Wrappers.<MesBuildingProduceTeamReportSummary>lambdaQuery()
                        .eq(MesBuildingProduceTeamReportSummary::getTaskProcessId, taskProcess.getId()))
                     .eq(assistGroupId == null, MesBuildingProduceTeamReportSummary::getGroupsId, taskProcess.getGroupsId()))
                  .eq(assistGroupId != null, MesBuildingProduceTeamReportSummary::getGroupsId, assistGroupId))
               .eq(MesBuildingProduceTeamReportSummary::getTeamId, teamId)
         );
      if (produceTeamReportSummary != null) {
         if (type.equals(SaveProduceTeamReportSummaryTypeEnum.PRODUCE_REPORT.getType())) {
            produceTeamReportSummary.setQuantity(produceTeamReportSummary.getQuantity() + reportQuantity);
         }

         if (type.equals(SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType())) {
            produceTeamReportSummary.setQuantity(produceTeamReportSummary.getQuantity() + reportQuantity);
            produceTeamReportSummary.setInspectionQuantity(produceTeamReportSummary.getInspectionQuantity() + reportQuantity);
         } else if (type.equals(SaveProduceTeamReportSummaryTypeEnum.INSPECTION_REPORT.getType())) {
            produceTeamReportSummary.setInspectionQuantity(produceTeamReportSummary.getInspectionQuantity() + reportQuantity);
         } else if (type.equals(SaveProduceTeamReportSummaryTypeEnum.PROBLEM_REPORT.getType())) {
            produceTeamReportSummary.setProblemQuantity(produceTeamReportSummary.getProblemQuantity() + reportQuantity);
         } else if (type.equals(SaveProduceTeamReportSummaryTypeEnum.ADOPT_PROBLEM_REPORT.getType())) {
            produceTeamReportSummary.setProblemQuantity(produceTeamReportSummary.getProblemQuantity() - reportQuantity);
            produceTeamReportSummary.setInspectionQuantity(produceTeamReportSummary.getInspectionQuantity() + reportQuantity);
         }

         this.produceTeamReportSummaryService.updateById(produceTeamReportSummary);
      } else {
         MesBuildingProduceTeamReportSummary summary = MesBuildingProduceTeamReportSummary.builder()
            .productId(taskProcess.getProductId())
            .taskTypeEnum(taskProcess.getTaskTypeEnum())
            .processId(taskProcess.getProcessId())
            .taskId(taskProcess.getTaskId())
            .groupsId(assistGroupId == null ? taskProcess.getGroupsId() : assistGroupId)
            .teamId(teamId)
            .taskProcessId(taskProcess.getId())
            .quantity(reportQuantity)
            .userId(0L)
            .schedulingId(taskProcess.getSchedulingId())
            .build();
         if (type.equals(SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType())) {
            summary.setInspectionQuantity(reportQuantity);
         }

         this.produceTeamReportSummaryService.save(summary);
      }

      return true;
   }

   private void buildProductProcess(
      MesBuildingTaskProcess taskProcess,
      Long teamId,
      List<Integer> numberList,
      Map<Integer, List<MesBuildingTaskNumberLink>> numberLinksMap,
      Integer typeEnum,
      Integer reportQuantity
   ) {
      if (typeEnum.equals(TaskTypeEnum.ASSEMBLE.getType()) || typeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         numberLinksMap.forEach(
            (number, numberLinkList) -> {
               MesBuildingTaskNumberLink numberLink = numberLinkList.get(0);
               if ((
                     !taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())
                        || numberLink.getArtifactNextProcessId() == null
                        || numberLink.getArtifactNextProcessId() == 0L
                  )
                  && (
                     !taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())
                        || numberLink.getAssembleNextProcessId() == null
                        || numberLink.getAssembleNextProcessId() == 0L
                  )) {
                  if (typeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = this.artifactService.getById(taskProcess.getProductId());
                     artifact.setProducedQuantity(artifact.getProducedQuantity() + 1);
                     Preconditions.checkArgument(artifact.getQuantity() >= artifact.getProducedQuantity(), "操作失败!!!");
                     this.artifactService.updateById(artifact);
                  } else if (typeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
                     TechAssemble assemble = this.assembleService.getById(taskProcess.getProductId());
                     if (assemble.getBoolSchedulingEnum()) {
                        Preconditions.checkArgument(assemble.getProducedQuantity() + 1 <= assemble.getQuantity(), "生产数量不能大于清单数量");
                        assemble.setProducedQuantity(assemble.getProducedQuantity() + 1);
                        Preconditions.checkArgument(assemble.getQuantity() >= assemble.getProducedQuantity(), "操作失败!!!");
                        this.assembleService.updateById(assemble);
                     }
                  }

                  MesBuildingTask taskx = this.taskService.getById(taskProcess.getTaskId());
                  taskx.setCompleteQuantity(taskx.getCompleteQuantity() + 1);
                  Preconditions.checkArgument(taskx.getTaskQuantity() >= taskx.getCompleteQuantity(), "操作失败!!!!");
                  if (taskx.getTaskQuantity().equals(taskx.getCompleteQuantity())) {
                     taskx.setCompleteTime(LocalDateTime.now());
                  }

                  this.taskService.updateById(taskx);
                  if (!typeEnum.equals(TaskTypeEnum.ARTIFACT.getType()) && !typeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
                     this.saveCompoleteReport(taskProcess, 1, teamId, null);
                  } else {
                     Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberList), "一物一码的构件序号不能为空");
                     List<Integer> list = null;
                     if (typeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
                        list = Arrays.asList(numberLink.getArtifactNumber());
                     } else if (typeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
                        list = Arrays.asList(numberLink.getAssembleNumber());
                     }

                     this.saveCompoleteReport(taskProcess, 1, teamId, list);
                  }

                  this.productionSummaryService
                     .updateRecord(
                        ProductProductionSummaryDTOParam.builder()
                           .projectId(taskx.getProjectId())
                           .monomerId(taskx.getMonomerId())
                           .productId(taskx.getProductId())
                           .productType(taskx.getTaskTypeEnum())
                           .completeQuantity(1)
                           .build()
                     );
                  if (typeEnum.equals(TaskTypeEnum.ARTIFACT.getType()) && !this.taskProcessService.getProjectCompleteStatus(taskx.getProjectId())) {
                     ContractProject project = this.projectService.getById(taskx.getProjectId());
                     this.projectService.updateById(project.setMesEndDate(LocalDateTime.now()));
                  }
               } else {
                  MesBuildingTaskProcess nextTaskProcess = null;
                  if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
                     nextTaskProcess = this.taskProcessService
                        .getOne(
                           Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                              .eq(MesBuildingTaskProcess::getTaskId, numberLink.getArtifactTaskId())
                              .eq(MesBuildingTaskProcess::getProcessId, numberLink.getArtifactNextProcessId())
                        );
                  } else {
                     nextTaskProcess = this.taskProcessService
                        .getOne(
                           Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                              .eq(MesBuildingTaskProcess::getTaskId, numberLink.getAssembleTaskId())
                              .eq(MesBuildingTaskProcess::getProcessId, numberLink.getAssembleNextProcessId())
                        );
                  }

                  assert nextTaskProcess != null;
                  nextTaskProcess.setNeedQuantity(nextTaskProcess.getNeedQuantity() + 1);
                  this.taskProcessService.updateById(nextTaskProcess);
               }
            }
         );
      }

      if (typeEnum.equals(TaskTypeEnum.MACHINE_PART.getType())) {
         if (taskProcess.getNextProcessId() != null) {
            MesBuildingTaskProcess nextTaskProcess = this.taskProcessService
               .getOne(
                  (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId()))
                     .eq(MesBuildingTaskProcess::getProcessId, taskProcess.getNextProcessId())
               );
            assert nextTaskProcess != null;
            nextTaskProcess.setNeedQuantity(nextTaskProcess.getNeedQuantity() + reportQuantity);
            this.taskProcessService.updateById(nextTaskProcess);
         } else {
            TechMachinePart machinePart = this.machinePartService.getById(taskProcess.getProductId());
            if (machinePart.getBoolProcess()) {
               Preconditions.checkArgument(machinePart.getProducedQuantity() + reportQuantity <= machinePart.getQuantity(), "生产数量不能大于清单数量");
               machinePart.setProducedQuantity(machinePart.getProducedQuantity() + reportQuantity);
               this.machinePartService.updateById(machinePart);
            }

            MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
            task.setCompleteQuantity(task.getCompleteQuantity() + reportQuantity);
            Preconditions.checkArgument(task.getTaskQuantity() >= task.getCompleteQuantity(), "操作失败!!!!");
            if (task.getTaskQuantity().equals(task.getCompleteQuantity())) {
               task.setCompleteTime(LocalDateTime.now());
            }

            this.taskService.updateById(task);
            this.saveCompoleteReport(taskProcess, reportQuantity, teamId, null);
            this.productionSummaryService
               .updateRecord(
                  ProductProductionSummaryDTOParam.builder()
                     .projectId(task.getProjectId())
                     .monomerId(task.getMonomerId())
                     .productId(task.getProductId())
                     .productType(task.getTaskTypeEnum())
                     .completeQuantity(reportQuantity)
                     .build()
               );
         }
      }
   }

   public List<Integer> saveTeamReport(
      MesBuildingTaskProcess taskProcess,
      Integer reportQuantity,
      boolean isInspection,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingTeam team,
      MesBuildingAssist assist,
      Boolean booleOneCode
   ) {
      List<MesBuildingProduceTeamReport> reports = new ArrayList<>();
      LocalDateTime reportTime = LocalDateTime.now();
      Long reportNumber = this.redisUtils.incr("teamreport_reportnumber:", 1L);
      if (CollectionUtils.isNotEmpty(numberList)) {
         for (Integer number : numberList) {
            MesBuildingProduceTeamReport teamReport = MesBuildingProduceTeamReport.builder()
               .productId(taskProcess.getProductId())
               .taskTypeEnum(taskProcess.getTaskTypeEnum())
               .processId(taskProcess.getProcessId())
               .productionLineId(assist == null ? taskProcess.getProductionLineId() : assist.getProductionLineId())
               .taskId(taskProcess.getTaskId())
               .teamId(team.getId())
               .taskProcessId(taskProcess.getId())
               .quantity(1)
               .reportTime(reportTime)
               .userId(0L)
               .boolHandleEnum(false)
               .inspectionQuantity(isInspection ? 0 : 1)
               .number(number)
               .groupsId(assist == null ? taskProcess.getGroupsId() : assist.getGroupsId())
               .reportType(reportType ? TeamReportTypeEnum.ABNORMAL.getType() : TeamReportTypeEnum.NORMAL.getType())
               .schedulingId(taskProcess.getSchedulingId())
               .assistId(assist == null ? null : assist.getId())
               .reportNumber(reportNumber)
               .sequence(taskProcess.getSequence())
               .build();
            if (booleOneCode) {
               reportNumber = this.redisUtils.incr("teamreport_reportnumber:", 1L);
            }

            reports.add(teamReport);
         }
      } else {
         MesBuildingProduceTeamReport teamReport = MesBuildingProduceTeamReport.builder()
            .productId(taskProcess.getProductId())
            .taskTypeEnum(taskProcess.getTaskTypeEnum())
            .processId(taskProcess.getProcessId())
            .productionLineId(assist == null ? taskProcess.getProductionLineId() : assist.getProductionLineId())
            .taskId(taskProcess.getTaskId())
            .teamId(team.getId())
            .taskProcessId(taskProcess.getId())
            .quantity(reportQuantity)
            .userId(0L)
            .boolHandleEnum(false)
            .reportTime(reportTime)
            .inspectionQuantity(isInspection ? 0 : reportQuantity)
            .groupsId(assist == null ? taskProcess.getGroupsId() : assist.getGroupsId())
            .reportType(reportType ? TeamReportTypeEnum.ABNORMAL.getType() : TeamReportTypeEnum.NORMAL.getType())
            .schedulingId(taskProcess.getSchedulingId())
            .assistId(assist == null ? null : assist.getId())
            .reportNumber(reportNumber)
            .sequence(taskProcess.getSequence())
            .build();
         reports.add(teamReport);
      }

      this.produceTeamReportService.saveBatch(reports);
      Map<Long, Integer> reportMap = reports.stream()
         .collect(Collectors.toMap(MesBuildingProduceTeamReport::getId, MesBuildingProduceTeamReport::getInspectionQuantity));
      this.teamReportBiz.savePiceByData(reportMap);
      if (taskProcess.getSequence().equals(0)) {
         List<MesBuildingInProduction> inProductions = new ArrayList<>();

         for (MesBuildingProduceTeamReport teamReport : reports) {
            MesBuildingInProduction inProduction = MesBuildingInProduction.builder()
               .projectId(taskProcess.getProjectId())
               .monomerId(taskProcess.getMonomerId())
               .areaId(taskProcess.getAreaId())
               .factoryId(taskProcess.getFactoryId())
               .workshopId(taskProcess.getWorkshopId())
               .productionLineId(taskProcess.getProductionLineId())
               .taskId(taskProcess.getTaskId())
               .productId(taskProcess.getProductId())
               .productType(taskProcess.getTaskTypeEnum())
               .teamReportId(teamReport.getId())
               .teamId(teamReport.getTeamId())
               .userId(0L)
               .quantity(reportQuantity)
               .number(teamReport.getNumber())
               .build();
            inProductions.add(inProduction);
         }

         this.inProductionService.saveBatch(inProductions);
      }

      return null;
   }

   private void saveCompoleteReport(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long teamId, List<Integer> numberList) {
      List<MesBuildingComplete> completes = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(numberList)) {
         for (Integer number : numberList) {
            MesBuildingComplete complete = BeanUtil.copy(taskProcess, MesBuildingComplete.class);
            complete.setUserId(0L);
            complete.setCreateTime(LocalDateTime.now());
            complete.setUpdateTime(null);
            complete.setBoolAbnormalEnum(false);
            complete.setQuantity(1);
            complete.setNumber(number);
            complete.setGroupsId(taskProcess.getGroupsId());
            complete.setTeamId(teamId);
            complete.setFactoryId(taskProcess.getFactoryId());
            completes.add(complete);
         }
      } else {
         MesBuildingComplete complete = BeanUtil.copy(taskProcess, MesBuildingComplete.class);
         complete.setUserId(0L);
         complete.setCreateTime(LocalDateTime.now());
         complete.setUpdateTime(null);
         complete.setBoolAbnormalEnum(false);
         complete.setQuantity(reportQuantity);
         complete.setGroupsId(taskProcess.getGroupsId());
         complete.setTeamId(teamId);
         complete.setFactoryId(taskProcess.getFactoryId());
         completes.add(complete);
      }

      this.completeService.saveBatch(completes);
      List<MesBuildingComplete> needWrehouseCompletes = new ArrayList<>();
      List<MesBuildingComplete> neewUpdateAllSendList = new ArrayList<>();
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         this.saveArtifactAuxiliaryPriceByCompetes(taskProcess, completes);
         needWrehouseCompletes.addAll(completes);
      }

      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         List<Long> partIds = completes.stream().map(MesBuildingComplete::getProductId).distinct().collect(Collectors.toList());
         List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
         Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

         for (MesBuildingComplete complete : completes) {
            TechMachinePart machinePart = partMap.get(complete.getProductId());
            if (machinePart.getBoolAllPartSendDirectly()) {
            }

            if (machinePart.getBoolSendDirectly()) {
               needWrehouseCompletes.add(complete);
            }
         }
      }

      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<Long> assIds = completes.stream().map(MesBuildingComplete::getProductId).distinct().collect(Collectors.toList());
         List<TechAssemble> assembles = this.assembleService.listByIds(assIds);
         Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

         for (MesBuildingComplete complete : completes) {
            TechAssemble assemble = assembleMap.get(complete.getProductId());
            if (assemble.getBoolAllPartSendDirectly()) {
               MesBuildingComplete copy = BeanUtil.copy(complete, MesBuildingComplete.class);
               neewUpdateAllSendList.add(copy);
            }

            if (assemble.getBoolSendDirectly()) {
               needWrehouseCompletes.add(complete);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(neewUpdateAllSendList)) {
         this.updateAllSendWarehouseData(neewUpdateAllSendList, taskProcess.getTaskTypeEnum());
      }

      if (CollectionUtils.isNotEmpty(needWrehouseCompletes)) {
         this.addWrehouseByCompletes(needWrehouseCompletes);
      }
   }

   private void updateAllSendWarehouseData(List<MesBuildingComplete> neewUpdateAllSendList, Integer taskType) {
      List<NumberInfoDTO> needUpdataSendnumbers = new ArrayList<>();
      if (taskType.equals(TaskTypeEnum.MACHINE_PART.getType())) {
         Preconditions.checkArgument(false, "零件暂无生产业务");
      }

      if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<Integer> allNumbers = neewUpdateAllSendList.stream().map(s -> s.getNumber()).collect(Collectors.toList());
         Long assId = neewUpdateAllSendList.get(0).getProductId();
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getAssembleId, assId)
                  .in(MesBuildingTaskNumberLink::getAssembleNumber, allNumbers)
            );
         List<NumberInfoDTO> numberInfoDTOS = new ArrayList<>();

         for (MesBuildingTaskNumberLink numberLink : numberLinks) {
            NumberInfoDTO build = NumberInfoDTO.builder().productId(numberLink.getArtifactId()).number(numberLink.getArtifactNumber()).build();
            numberInfoDTOS.add(build);
         }

         List<MesBuildingTaskNumberLink> allLinks = this.mesBuildingTaskNumberLinkService.listLinksBydata(numberInfoDTOS, TaskTypeEnum.ARTIFACT.getType());
         Map<String, List<MesBuildingTaskNumberLink>> allLinkMap = allLinks.stream()
            .collect(Collectors.groupingBy(s -> s.getArtifactId() + "_" + s.getArtifactNumber()));

         for (String key : allLinkMap.keySet()) {
            Long artId = Long.valueOf(key.split("_")[0]);
            Integer artNumber = Integer.valueOf(key.split("_")[1]);
            List<MesBuildingTaskNumberLink> links = allLinkMap.get(key);
            if (links.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
               NumberInfoDTO build = NumberInfoDTO.builder().productId(artId).number(artNumber).build();
               needUpdataSendnumbers.add(build);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(needUpdataSendnumbers)) {
         List<MesBuildingSinglePartArtifactPrint> sings = this.singlePartArtifactPrintService.listBydata(needUpdataSendnumbers);
         sings.forEach(s -> s.setQuantity(1));
         this.singlePartArtifactPrintService.updateBatchById(sings);
      }
   }

   void addWrehouseByCompletes(List<MesBuildingComplete> completes) {
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
         record.setUserId(0L);
         record.setUserName(UserUtil.getCurrentName());
         record.setNumber(complete.getNumber());
         record.setProductType(complete.getTaskTypeEnum());
         record.setStatus(WarehouseRecordStatusTypeEnum.INTO.getType());
         record.setType(WarehouseTypeEnum.INTO.getType());
         records.add(record);
      }

      this.warehouseRecordService.saveBatch(records);
      Map<String, Integer> completeMap = completes.stream()
         .collect(
            Collectors.toMap(
               s -> s.getFactoryId()
                  + "_"
                  + s.getWorkshopId()
                  + "_"
                  + s.getTaskTypeEnum()
                  + "_"
                  + s.getProductId()
                  + "_"
                  + WarehouseRecordStatusTypeEnum.INTO.getType(),
               MesBuildingComplete::getQuantity,
               Integer::sum
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
         Integer quantity = completeMap.get(key);
         MesBuildingWarehouseSummary summary = summaryMap.get(key);
         if (summary == null) {
            MesBuildingWarehouseSummary updateSummary = saveSummaryMap.get(key);
            if (updateSummary == null) {
               MesBuildingWarehouseSummary saveSummary = BeanUtil.copy(completes.get(0), MesBuildingWarehouseSummary.class);
               saveSummary.setId(null);
               saveSummary.setQuantity(BigDecimal.valueOf(quantity.intValue()));
               saveSummary.setProductType(completes.get(0).getTaskTypeEnum());
               saveSummary.setType(WarehouseTypeEnum.INTO.getType());
               saveSummaryMap.put(key, saveSummary);
            } else {
               updateSummary.setQuantity(updateSummary.getQuantity().add(BigDecimal.valueOf(quantity.intValue())));
               saveSummaryMap.put(key, updateSummary);
            }
         } else {
            summary.setQuantity(summary.getQuantity().add(BigDecimal.valueOf(quantity.intValue())));
         }
      }

      this.warehouseSummaryService.saveBatch(new ArrayList<>(saveSummaryMap.values()));
      this.warehouseSummaryService.updateBatchById(new ArrayList<>(summaryMap.values()));
   }

   private void saveArtifactAuxiliaryPriceByCompetes(MesBuildingTaskProcess taskProcess, List<MesBuildingComplete> completes) {
      List<TechArtifactAuxiliaryLink> techArtifactAuxiliaryLinks = this.artifactAuxiliaryLinkService
         .list(Wrappers.lambdaQuery(TechArtifactAuxiliaryLink.class).eq(TechArtifactAuxiliaryLink::getArtifactId, taskProcess.getProductId()));
      if (!CollectionUtils.isEmpty(techArtifactAuxiliaryLinks)) {
         List<Long> allAuxiliaryPartIds = techArtifactAuxiliaryLinks.stream()
            .map(TechArtifactAuxiliaryLink::getAuxiliaryPartId)
            .distinct()
            .collect(Collectors.toList());
         List<TechAuxiliaryPart> techAuxiliaryParts = this.techAuxiliaryPartService.listByIds(allAuxiliaryPartIds);
         Map<Long, TechAuxiliaryPart> techAuxiliaryPartMap = techAuxiliaryParts.stream()
            .collect(Collectors.toMap(TechAuxiliaryPart::getId, Function.identity()));
         List<Long> auxiliaryClassIds = techAuxiliaryParts.stream().map(TechAuxiliaryPart::getAuxiliaryClassId).distinct().collect(Collectors.toList());
         List<SysAuxiliaryClassification> auxiliaryClassifications = this.auxiliaryClassificationService.listByIds(auxiliaryClassIds);
         Map<Long, SysAuxiliaryClassification> auxiliaryificationMap = auxiliaryClassifications.stream()
            .collect(Collectors.toMap(SysAuxiliaryClassification::getId, Function.identity(), (s1, s2) -> s1));
         List<MesBuildingFabricatedPartConfig> allfabricatedPartConfig = this.buildingFabricatedPartConfigService
            .list(Wrappers.lambdaQuery(MesBuildingFabricatedPartConfig.class).in(MesBuildingFabricatedPartConfig::getAuxiliaryId, auxiliaryClassIds));
         Map<Long, MesBuildingFabricatedPartConfig> FabricatedPartConfigMap = allfabricatedPartConfig.stream()
            .collect(Collectors.toMap(MesBuildingFabricatedPartConfig::getAuxiliaryId, Function.identity()));
         List<MesBuildingTechArtifactAuxiliaryPrice> prices = new ArrayList<>();

         for (MesBuildingComplete complete : completes) {
            for (TechArtifactAuxiliaryLink techArtifactAuxiliaryLink : techArtifactAuxiliaryLinks) {
               TechAuxiliaryPart techAuxiliaryPart = techAuxiliaryPartMap.get(techArtifactAuxiliaryLink.getAuxiliaryPartId());
               if (techAuxiliaryPart != null) {
                  SysAuxiliaryClassification classification = auxiliaryificationMap.get(techAuxiliaryPart.getAuxiliaryClassId());
                  if (!classification.getType().equals(AuxiliaryTypeEnum.OTHER.getType())) {
                     MesBuildingFabricatedPartConfig fabricatedPartConfig = FabricatedPartConfigMap.get(classification.getId());
                     MesBuildingTechArtifactAuxiliaryPrice build = MesBuildingTechArtifactAuxiliaryPrice.builder()
                        .projectId(taskProcess.getProjectId())
                        .monomerId(taskProcess.getMonomerId())
                        .areaId(taskProcess.getAreaId())
                        .artifactId(taskProcess.getProductId())
                        .auxiliaryPartId(techArtifactAuxiliaryLink.getAuxiliaryPartId())
                        .completeId(complete.getId())
                        .completeTime(complete.getCreateTime())
                        .quantity(techArtifactAuxiliaryLink.getQuantity() * complete.getQuantity())
                        .price(fabricatedPartConfig == null ? BigDecimal.ZERO : fabricatedPartConfig.getUnitPrice())
                        .wages(
                           fabricatedPartConfig == null
                              ? BigDecimal.ZERO
                              : fabricatedPartConfig.getUnitPrice().multiply(new BigDecimal(techArtifactAuxiliaryLink.getQuantity() * complete.getQuantity()))
                        )
                        .build();
                     prices.add(build);
                  }
               }
            }
         }

         this.mesBuildingTechArtifactAuxiliaryPriceService.saveBatch(prices);
      }
   }
}
