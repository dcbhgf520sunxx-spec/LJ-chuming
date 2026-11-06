package com.hzchum.scim.mes.building.core.biz.impl.task;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveRecordDTOParam;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
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
import com.hzchum.scim.mes.building.core.api.enums.AcceptDeviationStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.SaveProduceTeamReportSummaryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.TeamReportTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.onecode.OneCodeTaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.ChangeLogTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.IssuedToNestingSoftwareStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingCalcMaxNumManager;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingNextProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProjectSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.MesBuildingQhseDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingArtifactTaskProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingTaskProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskTrackingProductionLineDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.APPTaskProcessInspectionDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppTaskOrderSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.complete.ProductionLoadDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingGroupsTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingProductionLineTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingTeamTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsInspectionTeamLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsTeamLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseAcceptDeviation;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseInspectionLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingFabricatedPartConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingChangeLog;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingInProduction;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartSchedulingUnProduction;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingTechArtifactAuxiliaryPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.IdAndRecelveQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.GroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamProductionLineListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductLineDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ScanCodeArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ScanCodeEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.MesBuildingLeaderInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.AnalysisQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.PersonalDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ReportDataDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.TeamAndNumberDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanBySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.YearQuantityAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.AddWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingArtifactTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProcessAndLastProcesLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProductLineListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingLineMonthDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TrackSteelDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TrackSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPQuantityAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPTaskProcessInspectionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskMissingDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessArtifactNumberDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.ProductClassificationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.UserLinkGroupProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.UserLinkLineProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.get.ProductSourceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkQuery;
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
import com.hzchum.scim.mes.building.core.api.service.temp_work.MesTempWorkService;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesProductionWageService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingTechArtifactAuxiliaryPriceService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.api.utils.SerialNumberComparatorUtils;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskMapper;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingMapper;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.plan.core.api.biz.SysSteelAnalysisBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import com.hzchum.scim.plan.core.api.enums.HandleStatusEnum;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechCappProductTaskWorkTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactAuxiliaryLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactChange;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryPart;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductAppListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MonomerTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectTreeResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.SendPurlinDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.ArtifactAssociationCount;
import com.hzchum.scim.plan.core.api.pojo.dto.steel.SteelAnalysisDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductAppVO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
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
import com.hzchum.scim.plan.core.api.util.TechUtils;
import com.hzchum.scim.project.core.api.biz.ProjectInstallBiz;
import com.hzchum.scim.project.core.api.enums.ProjectManageMenuTaskEnum;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectManageModeTaskDTO;
import com.hzchum.scim.project.core.api.service.ProjectInstallReportService;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.project.core.api.service.ProjectSubVisaService;
import com.hzchum.scim.system.core.api.common.enums.AuxiliaryTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModeTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationTimeTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.enums.AvoidTimeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectClassificationConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigUserLink;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUser;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliaryClassification;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushNotificationConfig;
import com.hzchum.scim.system.core.api.service.MesInspectClassificationConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigTeamLinkService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigUserLinkService;
import com.hzchum.scim.system.core.api.service.ProjectInspectionUserService;
import com.hzchum.scim.system.core.api.service.SysAuxiliaryClassificationService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.api.service.notification.SysPushNotificationConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingTaskBizImpl extends IBizImpl<MesBuildingTaskService, MesBuildingTaskMapper, MesBuildingTask> implements MesBuildingTaskBiz {
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
   private RedisTemplate redisTemplate;
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
   private MesTempWorkService tempWorkService;
   @Autowired
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Autowired
   private MesBuildingAssistService assistService;
   @Resource
   private ProjectInspectionUserService projectInspectionUserService;
   @Autowired
   private PlanAreaBatchService areaBatchService;
   @Autowired
   private SysPushNotificationConfigService pushNotificationConfigService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingMapper mesBuildingTaskNeedMachinePartSchedulingMapper;
   @Autowired
   private MesBuildingBoChuJobDirectoryService mesBuildingBoChuJobDirectoryService;
   @Resource
   private ProjectInstallBiz projectInstallBiz;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private TechCappCraftProductTaskBiz techCappCraftProductTaskBiz;

   @Transactional(rollbackFor = Exception.class)
   @Override
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
         List<MesBuildingTeamUserLink> teamUserLinks = this.teamUserLinkService
            .list((Wrapper<MesBuildingTeamUserLink>)Wrappers.<MesBuildingTeamUserLink>lambdaQuery().eq(MesBuildingTeamUserLink::getUserId, UserUtil.getCurrentUserId()));
         Preconditions.checkArgument(!teamUserLinks.isEmpty(), "操作失败：你不在可以生产上报的班组内");
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
            List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
            Preconditions.checkArgument(
               CollectionUtils.isNotEmpty(teamList) && teamList.stream().anyMatch(e -> e.getId().equals(mesBuildingTaskProcess.getTeamId())),
               "操作识别,你不在可生产上报班组内!"
            );
            teamId = mesBuildingTaskProcess.getTeamId();
         } else {
            List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
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
               teamId = teamList.stream().filter(e -> drillProcessIdList.contains(e.getProcessId())).findFirst().get().getId();
            } else {
               List<Long> teamIdList = this.groupsTeamLinkBiz
                  .list(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).eq(MesBuildingGroupsTeamLink::getGroupsId, mesBuildingTaskProcess.getGroupsId()))
                  .stream()
                  .map(MesBuildingGroupsTeamLink::getTeamId)
                  .collect(Collectors.toList());
               Preconditions.checkArgument(teamIdList.size() > 0, "操作失败：你不在可以生产上报的班组内");
               teamId = this.teamService
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingTeam.class)
                        .in(MesBuildingTeam::getId, teamIdList)
                        .eq(MesBuildingTeam::getProcessId, mesBuildingTaskProcess.getProcessId())
                  )
                  .getId();
            }

            if (drillProcessIdList.contains(mesBuildingTaskProcess.getProcessId())) {
               MesBuildingGroups groups = this.groupsBiz
                  .getById(
                     this.groupsTeamLinkBiz
                        .getOne(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).eq(MesBuildingGroupsTeamLink::getTeamId, teamId))
                        .getGroupsId()
                  );
               mesBuildingTaskProcess.setFactoryId(groups.getFactoryId());
               mesBuildingTaskProcess.setWorkshopId(groups.getWorkshopId());
               mesBuildingTaskProcess.setProductionLineId(groups.getProductionLineId());
               mesBuildingTaskProcess.setGroupsId(groups.getId());
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

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean qhseAdopt(MesBuildingTaskProcess taskProcess, Integer quantity, Long userId, Long teamId, Long qhseId) {
      Preconditions.checkArgument((taskProcess.getTaskTypeEnum() & (TaskTypeEnum.ASSEMBLE.getType() | TaskTypeEnum.ARTIFACT.getType())) > 0, "操作失败!!!");
      taskProcess.setInspectionQuantity(taskProcess.getInspectionQuantity() + quantity);
      taskProcess.setProblemQuantity(taskProcess.getProblemQuantity() - quantity);
      this.taskProcessService.updateById(taskProcess);
      List<Integer> numberList = new ArrayList<>();
      List<MesBuildingQhseInspectionLink> qhseInspectLinks = this.qhseInspectionLinkBiz
         .list((Wrapper<MesBuildingQhseInspectionLink>)Wrappers.<MesBuildingQhseInspectionLink>lambdaQuery().eq(MesBuildingQhseInspectionLink::getQhseId, qhseId));
      List<Long> inspectIds = qhseInspectLinks.stream().map(MesBuildingQhseInspectionLink::getInspectionReportId).collect(Collectors.toList());
      List<MesBuildingProduceInspectionTeamReport> inspectionTeamReports = this.produceInspectionTeamReportService.listByIds(inspectIds);
      Map<Long, MesBuildingProduceInspectionTeamReport> inspectionReportMap = inspectionTeamReports.stream()
         .collect(Collectors.toMap(MesBuildingProduceInspectionTeamReport::getId, Function.identity()));
      qhseInspectLinks.forEach(e -> {
         MesBuildingProduceInspectionTeamReport inspectionTeamReport = inspectionReportMap.get(e.getInspectionReportId());
         inspectionTeamReport.setBoolAdoptEnum(true);
         inspectionTeamReport.setInspectReportTime(LocalDateTime.now());
         if (inspectionTeamReport.getNumber() != null) {
            numberList.add(inspectionTeamReport.getNumber());
         }
      });
      List<MesBuildingProduceInspectionTeamReport> inspections = new ArrayList<>(inspectionReportMap.values());
      this.produceInspectionTeamReportService.updateBatchById(inspections);
      Long prodLineId = inspections.get(0).getProductionLineId();
      this.newTaskBiz
         .saveProduceTeamReportSummary2(taskProcess, quantity, prodLineId, teamId, SaveProduceTeamReportSummaryTypeEnum.ADOPT_PROBLEM_REPORT.getType());
      HashMap<Long, Integer> savePriceMap = new HashMap<>();
      List<MesBuildingProduceTeamReport> allReports = this.produceTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .in(MesBuildingProduceTeamReport::getNumber, numberList)
               .eq(MesBuildingProduceTeamReport::getTaskProcessId, taskProcess.getId())
         );
      Preconditions.checkArgument(allReports.stream().allMatch(s -> s.getProblemQuantity() > 0), "操作失败,请刷新页面后重试!!!!");
      Preconditions.checkArgument(allReports.size() == numberList.size(), "操作失败,请刷新页面后重试!!!!");

      for (MesBuildingProduceTeamReport report : allReports) {
         report.setInspectionQuantity(1);
         report.setProblemQuantity(0);
         savePriceMap.merge(report.getId(), 1, Integer::sum);
      }

      this.produceTeamReportService.updateBatchById(allReports);
      this.teamReportBiz.savePiceByData(savePriceMap);
      Long nextProcessId = 0L;
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcess.getId())
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, true)
                  .in(MesBuildingTaskNumberLink::getArtifactNumber, numberList)
            );
         List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList());
         Preconditions.checkArgument(numbers.size() == numberList.size(), "操作失败!!!请刷新页面后重试!!!!");

         for (MesBuildingTaskNumberLink numberLink : numberLinks) {
            MesBuildingTaskProcess nextProcess = this.taskProcessService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                     .eq(MesBuildingTaskProcess::getTaskId, numberLink.getArtifactTaskId())
                     .eq(MesBuildingTaskProcess::getProcessId, numberLink.getArtifactNextProcessId())
               );
            nextProcessId = nextProcess == null ? 0L : nextProcess.getId();
            numberLink.setArtifactTaskProcessId(nextProcessId);
            numberLink.setBoolArtifactReport(Boolean.FALSE);
            numberLink.setBoolArtifactInspection(Boolean.FALSE);
            numberLink.setBoolArtifactComplete(nextProcessId == 0L);
         }

         this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
      } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcess.getId())
                  .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, true)
                  .in(MesBuildingTaskNumberLink::getAssembleNumber, numberList)
            );
         List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
         Preconditions.checkArgument(numbers.size() == numberList.size(), "操作失败!!!请刷新页面后重试!!!!");

         for (MesBuildingTaskNumberLink numberLink : numberLinks) {
            MesBuildingTaskProcess nextProcess = this.taskProcessService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                     .eq(MesBuildingTaskProcess::getTaskId, numberLink.getAssembleTaskId())
                     .eq(MesBuildingTaskProcess::getProcessId, numberLink.getAssembleNextProcessId())
               );
            nextProcessId = nextProcess == null ? 0L : nextProcess.getId();
            numberLink.setAssembleTaskProcessId(nextProcessId);
            numberLink.setBoolAssembleReport(Boolean.FALSE);
            numberLink.setBoolAssembleInspection(Boolean.FALSE);
            numberLink.setBoolAssembleComplete(nextProcessId == 0L);
         }

         this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
      } else {
         Preconditions.checkArgument(false, "产品类型不正确!!!");
      }

      this.updateNextTaskProcess(taskProcess, quantity, teamId, numberList);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addTaskProcess(MesBuildingTask task) {
      List<MesBuildingProcess> processList = this.utilsBiz.getProcessIdByProductProcessId(task.getProductProcessId());
      Map<Long, LocalDateTime> taskProcessTimeMap = this.utilsBiz.getTaskProcessTime(task.getProductProcessId(), task.getAskCompleteTime());
      if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(task.getProductId());
         if (artifact.getBoolSinglePartEnum()) {
            processList = processList.stream().filter(e -> e.getType().equals(ProcessTypeEnum.PAINT.getType())).collect(Collectors.toList());
         }

         if (!artifact.getBoolCoatingEnum()) {
            processList = processList.stream().filter(e -> !e.getType().equals(ProcessTypeEnum.PAINT.getType())).collect(Collectors.toList());
         }
      }

      if (!task.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         for (int i = 0; i < processList.size(); i++) {
            MesBuildingTaskProcess taskProcess = BeanUtil.copy(task, MesBuildingTaskProcess.class);
            taskProcess.setTaskId(task.getId());
            taskProcess.setProductProcessId(task.getProductProcessId());
            if (i == 0) {
               taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
            }

            taskProcess.setId(null);
            taskProcess.setCompleteQuantity(null);
            taskProcess.setProcessId(processList.get(i).getId());
            taskProcess.setAskCompleteTime(taskProcessTimeMap.get(taskProcess.getProcessId()));
            taskProcess.setSequence(i);
            if (i != processList.size() - 1) {
               taskProcess.setNextProcessId(processList.get(i + 1).getId());
            }

            this.taskProcessService.save(taskProcess);
         }
      } else {
         MesBuildingProcess makingsProcess = this.processService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.MAKINGS.getType())
            );
         MesBuildingProcess drillProcess = this.processService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
            );
         MesBuildingTaskProcess taskProcess = BeanUtil.copy(task, MesBuildingTaskProcess.class);
         taskProcess.setTaskId(task.getId());
         taskProcess.setProductProcessId(task.getProductProcessId());
         taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
         taskProcess.setId(null);
         taskProcess.setCompleteQuantity(null);
         taskProcess.setProcessId(makingsProcess.getId());
         taskProcess.setAskCompleteTime(taskProcessTimeMap.get(taskProcess.getProcessId()));
         taskProcess.setSequence(0);
         this.taskProcessService.save(taskProcess);
         MesBuildingMachinePartScheduling partScheduling = this.machinePartSchedulingService.getById(task.getMachinePartSchedulingId());
         Preconditions.checkArgument(partScheduling != null, "操作失败，零件排产记录不存在");
         if (this.cutConfigBiz.getBoolDrillHole(task.getProductId(), partScheduling.getCutConfigId())) {
            taskProcess.setNextProcessId(drillProcess.getId());
            this.taskProcessService.updateById(taskProcess);
            MesBuildingTaskProcess drillTaskProcess = BeanUtil.copy(task, MesBuildingTaskProcess.class);
            drillTaskProcess.setTaskId(task.getId());
            drillTaskProcess.setProductProcessId(task.getProductProcessId());
            drillTaskProcess.setNeedQuantity(0);
            drillTaskProcess.setId(null);
            drillTaskProcess.setCompleteQuantity(null);
            drillTaskProcess.setFactoryId(null);
            drillTaskProcess.setWorkshopId(null);
            drillTaskProcess.setProductionLineId(null);
            drillTaskProcess.setGroupsId(null);
            drillTaskProcess.setProcessId(drillProcess.getId());
            drillTaskProcess.setAskCompleteTime(taskProcessTimeMap.get(taskProcess.getProcessId()));
            drillTaskProcess.setSequence(taskProcess.getSequence() + 1);
            this.taskProcessService.save(drillTaskProcess);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addPartTaskProcess(
      MesBuildingTask task,
      MesBuildingTeam drillGroups,
      LocalDateTime drillAskCompleteTime,
      MesBuildingNestCutPlate nestCutPlate,
      MesBuildingMachinePartSchedulingDTOParam dtoParamOld
   ) {
      List<MesBuildingProcess> processList = this.utilsBiz.getProcessIdByProductProcessId(task.getProductProcessId());
      Map<Long, LocalDateTime> taskProcessTimeMap = this.utilsBiz.getTaskProcessTime(task.getProductProcessId(), task.getAskCompleteTime());
      Long cutConfigId = nestCutPlate.getCutConfigId();
      Long drillCutConfigId = dtoParamOld.getDrillCutConfigId();
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
      MesBuildingMachinePartTeamDetail drillMesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(drillCutConfigId);
      MesBuildingProcess makingsProcess = this.processService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               .eq(MesBuildingProcess::getType, ProcessTypeEnum.MAKINGS.getType())
               .eq(MesBuildingProcess::getId, mesBuildingMachinePartTeamDetail.getDeviceType())
         );
      MesBuildingProcess drillProcess = new MesBuildingProcess();
      if (drillMesBuildingMachinePartTeamDetail != null) {
         drillProcess = this.processService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                  .eq(MesBuildingProcess::getId, drillMesBuildingMachinePartTeamDetail.getDeviceType())
            );
      }

      MesBuildingTaskProcess taskProcess = BeanUtil.copy(task, MesBuildingTaskProcess.class);
      taskProcess.setTaskId(task.getId());
      taskProcess.setProductProcessId(task.getProductProcessId());
      taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
      taskProcess.setId(null);
      taskProcess.setCompleteQuantity(null);
      taskProcess.setProcessId(makingsProcess.getId());
      taskProcess.setAskCompleteTime(taskProcessTimeMap.get(taskProcess.getProcessId()));
      taskProcess.setSequence(0);
      taskProcess.setTeamId(mesBuildingMachinePartTeamDetail.getGroupsId());
      taskProcess.setGroupsId(mesBuildingMachinePartTeamDetail.getGroupsId());
      this.taskProcessService.save(taskProcess);
      MesBuildingMachinePartScheduling partScheduling = this.machinePartSchedulingService.getById(task.getMachinePartSchedulingId());
      Preconditions.checkArgument(partScheduling != null, "操作失败，零件排产记录不存在");
      if (processList.stream().anyMatch(e -> e.getType().equals(ProcessTypeEnum.DRILL_HOLE.getType()))
         && this.cutConfigBiz.getBoolDrillHole(task.getProductId(), partScheduling.getCutConfigId(), partScheduling.getThick())) {
         taskProcess.setNextProcessId(drillProcess.getId());
         this.taskProcessService.updateById(taskProcess);
         MesBuildingTaskProcess drillTaskProcess = BeanUtil.copy(task, MesBuildingTaskProcess.class);
         drillTaskProcess.setTaskId(task.getId());
         drillTaskProcess.setProductProcessId(task.getProductProcessId());
         taskProcess.setTeamId(mesBuildingMachinePartTeamDetail.getGroupsId());
         drillTaskProcess.setNeedQuantity(0);
         drillTaskProcess.setId(null);
         drillTaskProcess.setCompleteQuantity(0);
         drillTaskProcess.setFactoryId(drillGroups.getFactoryId());
         drillTaskProcess.setWorkshopId(drillGroups.getWorkshopId());
         drillTaskProcess.setProductionLineId(drillGroups.getProductionLineId());
         drillTaskProcess.setTeamId(drillMesBuildingMachinePartTeamDetail.getGroupsId());
         drillTaskProcess.setGroupsId(drillMesBuildingMachinePartTeamDetail.getGroupsId());
         drillTaskProcess.setProcessId(drillProcess.getId());
         drillTaskProcess.setAskCompleteTime(drillAskCompleteTime == null ? taskProcessTimeMap.get(taskProcess.getProcessId()) : drillAskCompleteTime);
         drillTaskProcess.setSequence(taskProcess.getSequence() + 1);
         this.taskProcessService.save(drillTaskProcess);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addPartTaskProcessFast(
      List<MesBuildingTask> mesBuildingTaskList,
      MesBuildingTeam drillGroups,
      LocalDateTime drillAskCompleteTime,
      MesBuildingNestCutPlate nestCutPlate,
      MesBuildingMachinePartSchedulingDTOParam dtoParamOld
   ) {
      Long cutConfigId = nestCutPlate.getCutConfigId();
      Long drillCutConfigId = dtoParamOld.getDrillCutConfigId();
      MesBuildingMachinePartTeamDetail mesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(cutConfigId);
      MesBuildingMachinePartTeamDetail drillMesBuildingMachinePartTeamDetail = this.mesBuildingMachinePartTeamDetailService.getById(drillCutConfigId);
      List<MesBuildingTaskProcess> mesBuildingTaskProcessList = new ArrayList<>();
      List<MesBuildingTaskProcess> mesBuildingTaskUpdateProcessList = new ArrayList<>();
      List<MesBuildingTaskProcess> mesBuildingDrillTaskProcessList = new ArrayList<>();
      MesBuildingProcess makingsProcess = this.processService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               .eq(MesBuildingProcess::getType, ProcessTypeEnum.MAKINGS.getType())
               .eq(MesBuildingProcess::getId, mesBuildingMachinePartTeamDetail.getDeviceType())
         );
      MesBuildingProcess drillProcess = new MesBuildingProcess();
      if (drillMesBuildingMachinePartTeamDetail != null) {
         drillProcess = this.processService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                  .eq(MesBuildingProcess::getId, drillMesBuildingMachinePartTeamDetail.getDeviceType())
            );
      }

      for (MesBuildingTask mesBuildingTask : mesBuildingTaskList) {
         Long productProcessId = mesBuildingTask.getProductProcessId();
         LocalDateTime askCompleteTime = mesBuildingTask.getAskCompleteTime();
         Map<Long, LocalDateTime> taskProcessTimeMap = this.utilsBiz.getTaskProcessTime(productProcessId, askCompleteTime);
         MesBuildingTaskProcess taskProcess = BeanUtil.copy(mesBuildingTask, MesBuildingTaskProcess.class);
         taskProcess.setTaskId(mesBuildingTask.getId());
         taskProcess.setProductProcessId(productProcessId);
         taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
         taskProcess.setId(null);
         taskProcess.setTeamId(mesBuildingMachinePartTeamDetail.getGroupsId());
         taskProcess.setCompleteQuantity(null);
         taskProcess.setProcessId(makingsProcess.getId());
         taskProcess.setAskCompleteTime(taskProcessTimeMap.get(taskProcess.getProcessId()));
         taskProcess.setSequence(0);
         mesBuildingTaskProcessList.add(taskProcess);
         MesBuildingMachinePartScheduling partScheduling = this.machinePartSchedulingService.getById(mesBuildingTask.getMachinePartSchedulingId());
         Preconditions.checkArgument(partScheduling != null, "操作失败，零件排产记录不存在");
      }

      this.taskProcessService.saveBatch(mesBuildingTaskProcessList);
      MesBuildingMachinePartScheduling partScheduling = this.machinePartSchedulingService.getById(mesBuildingTaskList.get(0).getMachinePartSchedulingId());
      List<Long> productIdList = mesBuildingTaskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
      Map<Long, Boolean> boolDrillHoleFast = this.cutConfigBiz.getBoolDrillHoleFast(productIdList, partScheduling.getCutConfigId());

      for (MesBuildingTaskProcess taskProcess : mesBuildingTaskProcessList) {
         Long productProcessId = taskProcess.getProductProcessId();
         Map<Long, LocalDateTime> taskProcessTimeMap = this.utilsBiz.getTaskProcessTime(taskProcess.getProductProcessId(), taskProcess.getAskCompleteTime());
         List<MesBuildingProcess> processList = this.utilsBiz.getProcessIdByProductProcessId(productProcessId);
         Boolean drillBoolean = Boolean.FALSE;
         if (null != boolDrillHoleFast.get(taskProcess.getProductId())) {
            drillBoolean = boolDrillHoleFast.get(taskProcess.getProductId());
         }

         if (processList.stream().anyMatch(e -> e.getType().equals(ProcessTypeEnum.DRILL_HOLE.getType())) && drillBoolean) {
            taskProcess.setNextProcessId(drillProcess.getId());
            mesBuildingTaskUpdateProcessList.add(taskProcess);
            MesBuildingTaskProcess drillTaskProcess = BeanUtil.copy(taskProcess, MesBuildingTaskProcess.class);
            drillTaskProcess.setTaskId(taskProcess.getTaskId());
            drillTaskProcess.setNextProcessId(null);
            drillTaskProcess.setProductProcessId(taskProcess.getProductProcessId());
            drillTaskProcess.setNeedQuantity(0);
            drillTaskProcess.setId(null);
            drillTaskProcess.setCompleteQuantity(null);
            drillTaskProcess.setFactoryId(drillGroups.getFactoryId());
            drillTaskProcess.setWorkshopId(drillGroups.getWorkshopId());
            drillTaskProcess.setProductionLineId(drillGroups.getProductionLineId());
            drillTaskProcess.setTeamId(drillMesBuildingMachinePartTeamDetail.getGroupsId());
            drillTaskProcess.setProcessId(drillProcess.getId());
            drillTaskProcess.setAskCompleteTime(drillAskCompleteTime == null ? taskProcessTimeMap.get(taskProcess.getProcessId()) : drillAskCompleteTime);
            drillTaskProcess.setSequence(taskProcess.getSequence() + 1);
            mesBuildingDrillTaskProcessList.add(drillTaskProcess);
         }
      }

      this.taskProcessService.updateBatchById(mesBuildingTaskUpdateProcessList);
      this.taskProcessService.saveBatch(mesBuildingDrillTaskProcessList);
      return true;
   }

   @Override
   public List<AppTaskOrderSummaryDTO> taskOrderList(Long projectId, Integer taskTypeEnum, String serialNumber, Integer boolLastProcessEnum) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> groupsIdList = this.groupsTeamLinkBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class)
                  .in(MesBuildingGroupsTeamLink::getTeamId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()))
            )
            .stream()
            .map(MesBuildingGroupsTeamLink::getGroupsId)
            .collect(Collectors.toList());
         if (groupsIdList.size() == 0) {
            return new ArrayList<>();
         }

         List<MesBuildingGroups> groups = this.groupsBiz
            .getGroupsList(null)
            .stream()
            .filter(e -> groupsIdList.contains(e.getId()))
            .collect(Collectors.toList());
         if (groups.size() == 0) {
            return new ArrayList<>();
         }

         if (projectIds.size() == 0) {
            return new ArrayList<>();
         }

         List<MesBuildingGroupsTreeDO> groupsTreeList = this.groupsBiz.getGroupsTreeList(null);
         return groupsTreeList.size() == 0
            ? new ArrayList<>()
            : this.taskProcessService
               .selectTaskOrderIdList(groupsTreeList, projectId, projectIds, null, null, null, taskTypeEnum, serialNumber, null, boolLastProcessEnum)
               .stream()
               .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
               .collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public List<AppTaskOrderSummaryDTO> taskOrderList2(Long projectId, Integer taskTypeEnum, String serialNumber, Integer boolLastProcessEnum) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
         return this.taskProcessService
            .selectTaskOrderIdList2(teamIds, projectId, projectIds, null, null, null, null, taskTypeEnum, serialNumber, null, boolLastProcessEnum)
            .stream()
            .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
            .collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   public static List<MesBuildingProductionLineTreeDO> teamTransitionLineTree(List<MesBuildingTeam> teamList) {
      Map<Long, List<MesBuildingTeamTreeDO>> listMap = teamList.stream()
         .collect(Collectors.groupingBy(MesBuildingTeam::getProductionLineId, Collectors.mapping(s -> {
            new MesBuildingTeamTreeDO();
            return MesBuildingTeamTreeDO.builder().id(s.getId()).processId(s.getProcessId()).build();
         }, Collectors.toList())));
      return listMap.entrySet().stream().map(s -> {
         new MesBuildingProductionLineTreeDO();
         return MesBuildingProductionLineTreeDO.builder().id(s.getKey()).teamList(s.getValue()).build();
      }).collect(Collectors.toList());
   }

   @Override
   public PageVO<AppTaskOrderSummaryDTO> taskOrderPage(
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

      List<MesBuildingGroupsTreeDO> groupsTreeList = this.groupsBiz.getGroupsTreeList(null);
      if (groupsTreeList.size() == 0) {
         return new PageVO<>();
      }

      List<AppTaskOrderSummaryDO> appTaskOrderSummaryDOS = this.taskProcessService
         .selectTaskOrderIdList(groupsTreeList, projectId, projectIds, monomerId, areaId, null, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum);
      if (CollectionUtils.isNotEmpty(appTaskOrderSummaryDOS)) {
         appTaskOrderSummaryDOS.forEach(e -> {
            String cutTypeName = this.mesBuildingTaskNeedMachinePartSchedulingMapper.getDictionaryByNameAndSort("device_type", e.getCutType());
            e.setCutTypeName(cutTypeName);
         });
      }

      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.taskProcessService
            .selectTaskOrderIdList(groupsTreeList, projectId, projectIds, monomerId, areaId, null, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum)
            .stream()
            .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
            .collect(Collectors.toList())
      );
   }

   @Override
   public PageVO<AppTaskOrderSummaryDTO> taskOrderPage2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
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
      } else {
         List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
         if (teamList != null && teamList.size() != 0) {
            List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
            PageHelper.startPage(pageNumber, pageSize);
            List<AppTaskOrderSummaryDTO> dtos = this.taskProcessService
               .selectTaskOrderIdList2(
                  teamIds, projectId, projectIds, monomerId, areaId, areaBatchId, null, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum
               )
               .stream()
               .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
               .collect(Collectors.toList());
            return new PageVO<>(dtos);
         } else {
            return new PageVO<>();
         }
      }
   }

   @Override
   public List<AppTaskOrderSummaryDTO> drillTaskOrderList() {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> processIdList = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
         )
         .stream()
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      if (processIdList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> teamIdList = teamList.stream().filter(e -> processIdList.contains(e.getProcessId())).map(MesBuildingTeam::getId).collect(Collectors.toList());
      if (teamIdList.size() == 0) {
         return new ArrayList<>();
      }

      List<AppTaskOrderSummaryDTO> appTaskOrderSummaryDTOList = this.taskProcessService
         .drillTaskOrderList(null, projectIds, null, null, null, teamIdList)
         .stream()
         .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
         .collect(Collectors.toList());
      return appTaskOrderSummaryDTOList.stream().filter(e -> e.getQuantity() > 0).collect(Collectors.toList());
   }

   @Override
   public List<AppTaskOrderSummaryDTO> drillTaskOrderList2() {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> processIdList = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
         )
         .stream()
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      if (processIdList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> teamIdList = teamList.stream().filter(e -> processIdList.contains(e.getProcessId())).map(MesBuildingTeam::getId).collect(Collectors.toList());
      if (teamIdList.size() == 0) {
         return new ArrayList<>();
      }

      List<MesBuildingTeam> teamLinkList = this.teamService.list(Wrappers.lambdaQuery(MesBuildingTeam.class).in(MesBuildingTeam::getId, teamIdList));
      return teamLinkList.size() == 0
         ? new ArrayList<>()
         : this.taskProcessService
            .drillTaskOrderList2(null, projectIds, null, null, null, teamLinkList.stream().map(MesBuildingTeam::getId).distinct().collect(Collectors.toList()))
            .stream()
            .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
            .collect(Collectors.toList());
   }

   @Override
   public PageVO<AppTaskOrderSummaryDTO> drillTaskOrderPage(
      Long projectId, Long monomerId, Long areaId, String orderNumber, String sort, Integer pageNumber, Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> processIdList = this.processService
            .list(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
            )
            .stream()
            .map(MesBuildingProcess::getId)
            .collect(Collectors.toList());
         if (processIdList.size() == 0) {
            return new PageVO<>();
         }

         List<Long> teamIdList = teamList.stream()
            .filter(e -> processIdList.contains(e.getProcessId()))
            .map(MesBuildingTeam::getId)
            .collect(Collectors.toList());
         if (teamIdList.size() == 0) {
            return new PageVO<>();
         }

         List<MesBuildingGroupsTeamLink> teamLinkList = this.groupsTeamLinkBiz
            .list(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).in(MesBuildingGroupsTeamLink::getTeamId, teamIdList));
         return teamLinkList.size() == 0
            ? new PageVO<>()
            : new PageVO<>(
               PageHelper.startPage(pageNumber, pageSize),
               this.taskProcessService
                  .drillTaskOrderList(
                     projectId,
                     projectIds,
                     monomerId,
                     areaId,
                     orderNumber,
                     teamLinkList.stream().map(MesBuildingGroupsTeamLink::getGroupsId).distinct().collect(Collectors.toList())
                  )
                  .stream()
                  .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
                  .collect(Collectors.toList())
            );
      } else {
         return new PageVO<>();
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveNestCutPlateReport(Long nestCutPlateId, List<Long> partIds, String ncCode, Boolean reportType, List<IdAndRecelveQuantityDTO> parts) {
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
         List<Long> nestCutPlateIds = list.stream().map(MesBuildingTaskProcess::getNestCutPlateId).distinct().collect(Collectors.toList());
         List<Long> productIds = list.stream().map(MesBuildingTaskProcess::getProductId).distinct().collect(Collectors.toList());
         List<MesBuildingNestCutPlatePart> nestCutPlateParts = this.nestCutPlatePartBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class)
                  .in(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutPlateIds)
                  .in(MesBuildingNestCutPlatePart::getPartId, productIds)
            );
         Map<String, MesBuildingNestCutPlatePart> nestCutPlatePartMap = nestCutPlateParts.stream()
            .collect(Collectors.toMap(part -> part.getMesBuildingNestCutPlateId() + "-" + part.getPartId(), part -> (MesBuildingNestCutPlatePart)part));

         for (MesBuildingTaskProcess taskProcess : list) {
            String key = taskProcess.getNestCutPlateId() + "-" + taskProcess.getProductId();
            MesBuildingNestCutPlatePart nestCutPlatePart = nestCutPlatePartMap.get(key);
            if (nestCutPlatePart != null) {
               nestCutPlatePart.setCompleteQuantity(nestCutPlatePart.getCompleteQuantity() + partMap.get(taskProcess.getProductId()));
               nestCutPlatePart.setBoolCompleteEnum(nestCutPlatePart.getQuantity().equals(nestCutPlatePart.getCompleteQuantity()));
               cutPlateParts.add(nestCutPlatePart);
               this.saveProduceTeamReport(
                  MesBuildingProduceTeamReportDTOParam.builder()
                     .id(taskProcess.getId())
                     .reportQuantity(partMap.get(taskProcess.getProductId()))
                     .reportType(Boolean.FALSE)
                     .boolAssistEnum(Boolean.FALSE)
                     .build()
               );
            }
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

   @Override
   public List<MesBuildingNestCutPlateDTO> taskOrderNestPartList(Long taskOrderId) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList == null) {
         return new ArrayList<>();
      }

      Map<Long, MesBuildingGroups> groupsMap = this.groupsBiz
         .getGroupsList(null)
         .stream()
         .collect(Collectors.toMap(MesBuildingGroups::getId, Function.identity()));
      if (groupsMap.size() == 0) {
         return new ArrayList<>();
      }

      List<MesBuildingNestCutPlateDTO> nestCutPlateList = this.nestCutPlateBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
               .eq(MesBuildingNestCutPlate::getTaskOrderId, taskOrderId)
               .eq(MesBuildingNestCutPlate::getBoolProductionEunm, Boolean.FALSE)
               .in(MesBuildingNestCutPlate::getGroupsId, groupsMap.keySet())
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingNestCutPlateDTO.class))
         .collect(Collectors.toList());
      if (nestCutPlateList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> woskshorpIds = new ArrayList<>();
      List<Long> productionLineIds = new ArrayList<>();
      nestCutPlateList.forEach(e -> {
         woskshorpIds.add(e.getWorkshopId());
         productionLineIds.add(e.getProductionLineId());
      });
      Map<Long, MesBuildingWorkshop> workshopMap = this.workshopService
         .listByIds(woskshorpIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      Map<Long, MesBuildingProductionLine> productionLineMap = this.productionLineBiz
         .listByIds(productionLineIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      nestCutPlateList.forEach(
         e -> {
            e.setGroups(GroupsCurrencyDO.builder().id(e.getGroupsId()).name(groupsMap.get(e.getGroupsId()).getName()).build());
            e.setWorkshop(WorkshopDetailDO.builder().id(e.getWorkshopId()).name(workshopMap.get(e.getWorkshopId()).getName()).build());
            e.setProductionLine(
               ProductionLineDetailDO.builder().id(e.getProductionLineId()).name(productionLineMap.get(e.getProductionLineId()).getName()).build()
            );
         }
      );
      return nestCutPlateList;
   }

   @Override
   public List<MesBuildingNestCutPlateDTO> getDrillTaskOrderNestPartList(Long taskOrderId) {
      List<Long> nestCutPlateIdList = this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .in(
                  MesBuildingTaskProcess::getProcessId,
                  this.processService
                     .list(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType()))
                     .stream()
                     .map(MesBuildingProcess::getId)
                     .collect(Collectors.toList())
               )
               .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType())
               .apply("need_quantity > complete_quantity")
               .eq(MesBuildingTaskProcess::getTaskOrderId, taskOrderId)
         )
         .stream()
         .map(MesBuildingTaskProcess::getNestCutPlateId)
         .distinct()
         .collect(Collectors.toList());
      if (nestCutPlateIdList.size() == 0) {
         return new ArrayList<>();
      }

      List<MesBuildingNestCutPlateDTO> nestCutPlateList = this.nestCutPlateBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingNestCutPlate.class)
               .eq(MesBuildingNestCutPlate::getTaskOrderId, taskOrderId)
               .in(MesBuildingNestCutPlate::getId, nestCutPlateIdList)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingNestCutPlateDTO.class))
         .collect(Collectors.toList());
      return nestCutPlateList.size() == 0 ? new ArrayList<>() : nestCutPlateList;
   }

   @Override
   public PageVO<AppTaskProcessDTO> pageProductTaskByTaskOrderId2(
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long classId,
      Long processId,
      String specification,
      String serialNumber,
      Long taskOrderId,
      Integer boolLastProcessEnum,
      Boolean boolMissingParts,
      Integer reportType,
      Integer pageNumber,
      Integer pageSize
   ) {
      new ArrayList();
      MesBuildingTaskOrder taskOrder = null;
      taskOrderId = taskOrderId == 0L ? null : taskOrderId;
      List<Long> teamIds = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId()).stream().map(MesBuildingTeam::getId).collect(Collectors.toList());
      if (taskOrderId != null) {
         taskOrder = this.taskOrderBiz.getById(taskOrderId);
         Preconditions.checkArgument(taskOrder != null, "操作失败：id有误!");
         List<Long> teamIdLinkList = this.teamService
            .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getProductionLineId, taskOrder.getProductionLineId()))
            .stream()
            .map(MesBuildingTeam::getId)
            .collect(Collectors.toList());
         teamIds = teamIds.stream().filter(teamIdLinkList::contains).collect(Collectors.toList());
      }

      if (teamIds.isEmpty() && !UserUtil.getCurrentUser().isAdmin()) {
         return new PageVO<>();
      }

      Page<Object> startPage = PageHelper.startPage(pageNumber, pageSize);
      List<AppTaskProcessDTO> dtoList = this.taskProcessService
         .listProductTaskByTaskOrderId2(
            teamIds,
            taskOrderId == null ? null : taskOrder.getProductionLineId(),
            taskTypeEnum,
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            processId,
            specification,
            serialNumber,
            taskOrderId,
            null,
            boolLastProcessEnum,
            classId
         )
         .stream()
         .map(e -> BeanUtil.copy(e, AppTaskProcessDTO.class).setBoolMissingEnum(Boolean.FALSE))
         .collect(Collectors.toList());
      if (dtoList.isEmpty()) {
         return new PageVO<>();
      }

      this.checkBoolMissing2(dtoList, null, taskTypeEnum, Boolean.FALSE);
      if (boolMissingParts != null && !boolMissingParts) {
         dtoList = dtoList.stream().filter(e -> !e.getBoolMissingEnum()).collect(Collectors.toList());
      }

      if (reportType.equals(3) || reportType.equals(2)) {
         dtoList = dtoList.stream().filter(e -> e.getReportType() == reportType).collect(Collectors.toList());
      }

      if (CollectionUtils.isNotEmpty(dtoList)) {
         dtoList.sort(SerialNumberComparatorUtils.create(AppTaskProcessDTO::getSerialNumber));
      }

      dtoList = dtoList.stream()
         .sorted(Comparator.comparing(AppTaskProcessDTO::getBoolMissingEnum, Comparator.nullsFirst(Boolean::compareTo)))
         .collect(Collectors.toList());
      return new PageVO<>(startPage, dtoList);
   }

   @Override
   public PageVO<AppTaskProcessDTO> pageProductTaskByTaskOrderId(
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      Long classId,
      String serialNumber,
      Long taskOrderId,
      Integer boolLastProcessEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(taskOrderId);
      Preconditions.checkArgument(taskOrder != null, "操作失败：id有误!");
      List<Long> teamIdLinkList = this.groupsTeamLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).eq(MesBuildingGroupsTeamLink::getGroupsId, taskOrder.getGroupsId()))
         .stream()
         .map(MesBuildingGroupsTeamLink::getTeamId)
         .collect(Collectors.toList());
      List<Long> processIds = this.utilsBiz
         .selectTeamIdByUserId(UserUtil.getCurrentUserId())
         .stream()
         .filter(e -> teamIdLinkList.contains(e.getId()))
         .map(MesBuildingTeam::getProcessId)
         .collect(Collectors.toList());
      if (processIds.isEmpty()) {
         return new PageVO<>();
      }

      Page<Object> startPage = PageHelper.startPage(pageNumber, pageSize);
      List<AppTaskProcessDTO> dtoList = this.taskProcessService
         .listProductTaskByTaskOrderId(
            processIds, taskOrder.getGroupsId(), taskTypeEnum, monomerId, areaId, serialNumber, taskOrderId, null, boolLastProcessEnum, classId
         )
         .stream()
         .map(e -> BeanUtil.copy(e, AppTaskProcessDTO.class).setBoolMissingEnum(Boolean.FALSE))
         .collect(Collectors.toList());
      if (dtoList.isEmpty()) {
         return new PageVO<>();
      }

      this.checkBoolMissing(dtoList, null, taskTypeEnum, Boolean.FALSE);
      return new PageVO<>(startPage, dtoList);
   }

   @Override
   public PageVO<AppTaskProcessDTO> pageProductAssistTask(
      Integer taskTypeEnum,
      Long taskId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (CollectionUtils.isEmpty(teamList)) {
         return new PageVO<>();
      }

      List<Long> processIds = teamList.stream().map(MesBuildingTeam::getProcessId).collect(Collectors.toList());
      List<Long> processList = this.processService
         .listByIds(processIds)
         .stream()
         .filter(s -> (s.getProductType() & taskTypeEnum) > 0)
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      teamList = teamList.stream().filter(s -> processList.contains(s.getProcessId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(teamList)) {
         return new PageVO<>();
      }

      Map<Long, MesBuildingTeam> teamMap = teamList.stream().collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity(), (s1, s2) -> s1));
      List<MesBuildingGroupsTeamLink> teamLinkList = this.groupsTeamLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class)
               .in(MesBuildingGroupsTeamLink::getTeamId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()))
         );
      if (CollectionUtils.isEmpty(teamLinkList)) {
         return new PageVO<>();
      }

      Map<Long, List<MesBuildingGroupsTeamLink>> groupMap = teamLinkList.stream().collect(Collectors.groupingBy(MesBuildingGroupsTeamLink::getGroupsId));
      List<UserLinkGroupProcessDTO> groupProcessLinks = new ArrayList<>();

      for (Long groupId : groupMap.keySet()) {
         List<MesBuildingGroupsTeamLink> mesBuildingGroupsTeamLinks = groupMap.get(groupId);
         List<Long> groupProcessIds = mesBuildingGroupsTeamLinks.stream().map(s -> teamMap.get(s.getTeamId()).getProcessId()).collect(Collectors.toList());
         groupProcessLinks.add(UserLinkGroupProcessDTO.builder().groupId(groupId).processIds(groupProcessIds).build());
      }

      List<MesBuildingAssist> assistList = this.assistBiz.listUserLinkAssIst(taskId, groupProcessLinks, taskTypeEnum);
      if (CollectionUtils.isEmpty(assistList)) {
         return new PageVO<>();
      }

      List<Long> assIstIds = assistList.stream().map(MesBuildingAssist::getId).collect(Collectors.toList());
      PageHelper.startPage(pageNumber, pageSize);
      List<AppTaskProcessDTO> dtoList = this.processService
         .listAssistDetail(assIstIds, taskTypeEnum, taskId, projectId, monomerId, areaId, areaBatchId, serialNumber);
      if (dtoList.isEmpty()) {
         return new PageVO<>();
      }

      this.checkBoolMissing(dtoList, null, taskTypeEnum, Boolean.TRUE);
      return new PageVO<>(dtoList);
   }

   @Override
   public PageVO<AppTaskProcessDTO> pageProductAssistTask2(
      Integer taskTypeEnum,
      Long taskId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      Integer boolLastProcessEnum,
      Boolean boolMissingParts,
      Integer reportType,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamList), "操作失败,当前用户未配置班组!");
      if (CollectionUtils.isEmpty(teamList)) {
         return new PageVO<>();
      }

      List<Long> processIds = teamList.stream().map(MesBuildingTeam::getProcessId).collect(Collectors.toList());
      List<Long> processList = this.processService
         .listByIds(processIds)
         .stream()
         .filter(s -> (s.getProductType() & taskTypeEnum) > 0)
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      teamList = teamList.stream().filter(s -> processList.contains(s.getProcessId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(teamList)) {
         return new PageVO<>();
      }

      List<MesBuildingTeam> teamLinkList = this.teamService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeam.class).in(MesBuildingTeam::getId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()))
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamList), "操作失败,当前用户未配置班组!");
      if (CollectionUtils.isEmpty(teamLinkList)) {
         return new PageVO<>();
      }

      List<UserLinkLineProcessDTO> lineProcessLinks = new ArrayList<>();

      for (MesBuildingTeam mesBuildingTeam : teamLinkList) {
         lineProcessLinks.add(
            UserLinkLineProcessDTO.builder()
               .lineId(mesBuildingTeam.getProductionLineId())
               .processIds(Collections.singletonList(mesBuildingTeam.getProcessId()))
               .teamId(mesBuildingTeam.getId())
               .build()
         );
      }

      if (taskId != null) {
         MesBuildingTask task = this.taskService.getById(taskId);
         Preconditions.checkArgument(task != null, "操作失败,任务不存在!");
         Preconditions.checkArgument(task.getTaskQuantity() > task.getCompleteQuantity(), "操作失败,任务已完成上报!");
         List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
            .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskId, task.getId()));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskProcesses), "操作失败,任务不存在!");
         Preconditions.checkArgument(taskProcesses.stream().anyMatch(e -> e.getNeedQuantity() > e.getCompleteQuantity()), "操作失败,任务已完成上报!");
         List<MesBuildingAssist> assistList = this.assistBiz
            .list(
               (Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>()
                  .in(MesBuildingAssist::getTaskProcessId, taskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()))
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(assistList), "操作失败,未查询到协同任务,请检查是否办理工序协同!");
         Preconditions.checkArgument(assistList.stream().anyMatch(e -> !e.getBoolFinishEnum()), "操作失败,协同任务已完成上报!");
         List<Long> assistTeamIds = assistList.stream().map(MesBuildingAssist::getTeamId).collect(Collectors.toList());
         Preconditions.checkArgument(teamLinkList.stream().anyMatch(e -> assistTeamIds.contains(e.getId())), "操作失败,当前登陆人所在班组与协同任务班组不一致!");
      }

      List<MesBuildingAssist> assistList = this.assistBiz.listUserLinkAssIst2(taskId, lineProcessLinks, taskTypeEnum);
      if (CollectionUtils.isEmpty(assistList)) {
         return new PageVO<>();
      }

      List<Long> assIstIds = assistList.stream().map(MesBuildingAssist::getId).collect(Collectors.toList());
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.getAppTaskProcessDTOVO(
            taskTypeEnum, taskId, projectId, monomerId, areaId, areaBatchId, processId, serialNumber, boolMissingParts, reportType, assIstIds
         )
      );
   }

   private List<AppTaskProcessDTO> getAppTaskProcessDTOVO(
      Integer taskTypeEnum,
      Long taskId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      Boolean boolMissingParts,
      Integer reportType,
      List<Long> assIstIds
   ) {
      List<AppTaskProcessDTO> dtoList = this.processService
         .listAssistDetail2(assIstIds, taskTypeEnum, taskId, projectId, monomerId, areaId, areaBatchId, processId, serialNumber);
      if (dtoList.isEmpty()) {
         return new ArrayList<>();
      }

      this.checkBoolMissing2(dtoList, null, taskTypeEnum, Boolean.TRUE);
      if (boolMissingParts != null && !boolMissingParts) {
         dtoList = dtoList.stream().filter(e -> !e.getBoolMissingEnum()).collect(Collectors.toList());
      }

      if (reportType.equals(3) || reportType.equals(2)) {
         dtoList = dtoList.stream().filter(e -> e.getReportType() == reportType).collect(Collectors.toList());
      }

      return dtoList.stream()
         .sorted(Comparator.comparing(AppTaskProcessDTO::getBoolMissingEnum, Comparator.nullsFirst(Boolean::compareTo)))
         .collect(Collectors.toList());
   }

   @Override
   public Integer assistTaskCount(Integer taskTypeEnum) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (CollectionUtils.isEmpty(teamList)) {
         return 0;
      }

      List<Long> processIds = teamList.stream().map(MesBuildingTeam::getProcessId).collect(Collectors.toList());
      List<Long> processList = this.processService
         .listByIds(processIds)
         .stream()
         .filter(s -> (s.getProductType() & taskTypeEnum) > 0)
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      teamList = teamList.stream().filter(s -> processList.contains(s.getProcessId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(teamList)) {
         return 0;
      }

      Map<Long, MesBuildingTeam> teamMap = teamList.stream().collect(Collectors.toMap(MesBuildingTeam::getId, Function.identity(), (s1, s2) -> s1));
      List<MesBuildingGroupsTeamLink> teamLinkList = this.groupsTeamLinkBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class)
               .in(MesBuildingGroupsTeamLink::getTeamId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()))
         );
      if (CollectionUtils.isEmpty(teamLinkList)) {
         return 0;
      }

      Map<Long, List<MesBuildingGroupsTeamLink>> groupMap = teamLinkList.stream().collect(Collectors.groupingBy(MesBuildingGroupsTeamLink::getGroupsId));
      List<UserLinkGroupProcessDTO> groupProcessLinks = new ArrayList<>();

      for (Long groupId : groupMap.keySet()) {
         List<MesBuildingGroupsTeamLink> mesBuildingGroupsTeamLinks = groupMap.get(groupId);
         List<Long> groupProcessIds = mesBuildingGroupsTeamLinks.stream().map(s -> teamMap.get(s.getTeamId()).getProcessId()).collect(Collectors.toList());
         groupProcessLinks.add(UserLinkGroupProcessDTO.builder().groupId(groupId).processIds(groupProcessIds).build());
      }

      List<MesBuildingAssist> assistList = this.assistBiz.listUserLinkAssIst(null, groupProcessLinks, taskTypeEnum);
      if (CollectionUtils.isEmpty(assistList)) {
         return 0;
      }

      List<Long> assIstIds = assistList.stream().map(MesBuildingAssist::getId).collect(Collectors.toList());
      List<AppTaskProcessDTO> dtoList = this.processService.listAssistDetail(assIstIds, taskTypeEnum, null, null, null, null, null, null);
      return dtoList.size();
   }

   @Override
   public Integer assistTaskCount2(Integer taskTypeEnum) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (CollectionUtils.isEmpty(teamList)) {
         return 0;
      }

      List<Long> processIds = teamList.stream().map(MesBuildingTeam::getProcessId).collect(Collectors.toList());
      List<Long> processList = this.processService
         .listByIds(processIds)
         .stream()
         .filter(s -> (s.getProductType() & taskTypeEnum) > 0)
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      teamList = teamList.stream().filter(s -> processList.contains(s.getProcessId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(teamList)) {
         return 0;
      }

      List<UserLinkLineProcessDTO> lineProcessLinks = new ArrayList<>();

      for (MesBuildingTeam mesBuildingTeam : teamList) {
         lineProcessLinks.add(
            UserLinkLineProcessDTO.builder()
               .lineId(mesBuildingTeam.getProductionLineId())
               .processIds(Collections.singletonList(mesBuildingTeam.getProcessId()))
               .teamId(mesBuildingTeam.getId())
               .build()
         );
      }

      List<MesBuildingAssist> assistList = this.assistBiz.listUserLinkAssIst2(null, lineProcessLinks, taskTypeEnum);
      if (CollectionUtils.isEmpty(assistList)) {
         return 0;
      }

      List<Long> assIstIds = assistList.stream().map(MesBuildingAssist::getId).collect(Collectors.toList());
      List<AppTaskProcessDTO> dtoList = this.processService.listAssistDetail2(assIstIds, taskTypeEnum, null, null, null, null, null, null, null);
      return dtoList.size();
   }

   @Override
   public List<AppTaskProcessDTO> listTaskProcessByTaskId(Long taskId, Integer boolLastProcessEnum) {
      MesBuildingTask task = this.taskService.getById(taskId);
      Preconditions.checkArgument(task != null, "操作失败:扫码任务不存在!");
      List<MesBuildingTeam> teamAllList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamAllList), "当前用户未配置班组!");
      if (CollectionUtils.isEmpty(teamAllList)) {
         return new ArrayList<>();
      }

      List<MesBuildingTeam> teamList = teamAllList.stream()
         .filter(team -> team.getProductionLineId().equals(task.getProductionLineId()))
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamList), "当前用户配置的班组产线与任务所在的产线不一致!");
      if (CollectionUtils.isEmpty(teamList)) {
         return new ArrayList<>();
      }

      Preconditions.checkArgument(task.getTaskQuantity() > task.getCompleteQuantity(), "操作失败,该任务报工!");
      List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskId, taskId))
               .in(MesBuildingTaskProcess::getTeamId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()))
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskProcesses), "操作失败,当前用户的班组与任务所在的班组不一致!");
      Preconditions.checkArgument(taskProcesses.stream().anyMatch(e -> e.getNeedQuantity() > e.getCompleteQuantity()), "操作失败,当前用户所在班组无可上报数量,请检查工序或是否质检!");
      List<AppTaskProcessDTO> dtoList = this.taskProcessService
         .listProductTaskByTaskOrderId2(
            teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()),
            task.getProductionLineId(),
            task.getTaskTypeEnum(),
            null,
            task.getMonomerId(),
            task.getAreaId(),
            null,
            null,
            null,
            null,
            task.getTaskOrderId(),
            taskId,
            boolLastProcessEnum,
            null
         )
         .stream()
         .map(e -> BeanUtil.copy(e, AppTaskProcessDTO.class))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(dtoList)) {
         return new ArrayList<>();
      }

      if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         Set<Long> artifactIdSet = dtoList.stream().filter(e -> !e.getSequence().equals(0)).map(AppTaskProcessDTO::getProductId).collect(Collectors.toSet());
         if (CollectionUtils.isEmpty(artifactIdSet)) {
            return dtoList;
         }

         Map<Long, Map<Long, TechArtifactMachinePartLink>> machinePartLinkMap = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIdSet))
            .stream()
            .collect(
               Collectors.groupingBy(
                  TechArtifactMachinePartLink::getArtifactId, Collectors.toMap(TechArtifactMachinePartLink::getMachinePartId, Function.identity())
               )
            );
         Map<Long, Map<Long, TechAssembleDetail>> assembleLinkMap = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIdSet))
            .stream()
            .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId, Collectors.toMap(TechAssembleDetail::getAssembleId, Function.identity())));
         List<Long> machineParIdList = new ArrayList<>();
         machinePartLinkMap.forEach((artifactId, map) -> map.forEach((k, v) -> machineParIdList.add(k)));
         List<Long> assembleParIdList = new ArrayList<>();
         assembleLinkMap.forEach((artifactId, map) -> map.forEach((k, v) -> assembleParIdList.add(k)));
         Map<Long, Integer> machinePartQuantityMap = new HashMap<>();
         if (machineParIdList.size() > 0) {
            this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .in(TechMachinePart::getId, machineParIdList)
                     .eq(TechMachinePart::getRelationType, TaskTypeEnum.ARTIFACT.getType())
               )
               .forEach(e -> {
                  Integer var10000 = machinePartQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         Map<Long, Integer> assembleQuantityMap = new HashMap<>();
         if (assembleParIdList.size() > 0) {
            this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).in(TechAssemble::getId, assembleParIdList).eq(TechAssemble::getBoolProcess, Boolean.TRUE))
               .forEach(e -> {
                  Integer var10000 = assembleQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         dtoList.forEach(e -> {
            if (e.getSequence().equals(0)) {
               AtomicReference<Boolean> boolMissingEnum = new AtomicReference<>(Boolean.FALSE);
               if (machinePartLinkMap.get(e.getProductId()) != null) {
                  machinePartLinkMap.get(e.getProductId()).forEach((partId, part) -> {
                     if (machinePartQuantityMap.get(partId) != null && machinePartQuantityMap.get(partId) < part.getQuantity()) {
                        boolMissingEnum.set(Boolean.TRUE);
                     }
                  });
               }

               if (assembleLinkMap.get(e.getProductId()) != null) {
                  assembleLinkMap.get(e.getProductId()).forEach((assembleId, assemble) -> {
                     if (assembleQuantityMap.get(assembleId) != null && assembleQuantityMap.get(assembleId) < assemble.getQuantity()) {
                        boolMissingEnum.set(Boolean.TRUE);
                     }
                  });
               }

               e.setBoolMissingEnum(boolMissingEnum.get());
            }
         });
      }

      return dtoList;
   }

   @Override
   public List<AppTaskProcessDTO> listProductTaskByTaskId(Long taskId, Integer boolLastProcessEnum) {
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList == null) {
         return new ArrayList<>();
      }

      MesBuildingTask task = this.taskService.getById(taskId);
      Preconditions.checkArgument(task != null, "操作失败：任务id不正确");
      List<AppTaskProcessDTO> dtoList = this.taskProcessService
         .listProductTaskByTaskOrderId(
            teamList.stream().map(MesBuildingTeam::getProcessId).collect(Collectors.toList()),
            task.getGroupsId(),
            task.getTaskTypeEnum(),
            task.getMonomerId(),
            task.getAreaId(),
            null,
            task.getTaskOrderId(),
            task.getId(),
            boolLastProcessEnum,
            null
         )
         .stream()
         .map(e -> BeanUtil.copy(e, AppTaskProcessDTO.class))
         .collect(Collectors.toList());
      if (dtoList.size() == 0) {
         return new ArrayList<>();
      }

      if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         Set<Long> artifactIdSet = dtoList.stream().filter(e -> !e.getSequence().equals(0)).map(AppTaskProcessDTO::getProductId).collect(Collectors.toSet());
         if (artifactIdSet.size() == 0) {
            return dtoList;
         }

         Map<Long, Map<Long, TechArtifactMachinePartLink>> machinePartLinkMap = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIdSet))
            .stream()
            .collect(
               Collectors.groupingBy(
                  TechArtifactMachinePartLink::getArtifactId, Collectors.toMap(TechArtifactMachinePartLink::getMachinePartId, Function.identity())
               )
            );
         Map<Long, Map<Long, TechAssembleDetail>> assembleLinkMap = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIdSet))
            .stream()
            .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId, Collectors.toMap(TechAssembleDetail::getAssembleId, Function.identity())));
         List<Long> machineParIdList = new ArrayList<>();
         machinePartLinkMap.forEach((artifactId, map) -> map.forEach((k, v) -> machineParIdList.add(k)));
         List<Long> assembleParIdList = new ArrayList<>();
         assembleLinkMap.forEach((artifactId, map) -> map.forEach((k, v) -> assembleParIdList.add(k)));
         Map<Long, Integer> machinePartQuantityMap = new HashMap<>();
         if (assembleParIdList.size() > 0) {
            this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .in(TechMachinePart::getId, machineParIdList)
                     .eq(TechMachinePart::getRelationType, TaskTypeEnum.ARTIFACT.getType())
               )
               .forEach(e -> {
                  Integer var10000 = machinePartQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         Map<Long, Integer> assembleQuantityMap = new HashMap<>();
         if (assembleQuantityMap.size() > 0) {
            this.assembleService
               .list(Wrappers.lambdaQuery(TechAssemble.class).in(TechAssemble::getId, assembleParIdList).eq(TechAssemble::getBoolProcess, Boolean.TRUE))
               .forEach(e -> {
                  Integer var10000 = assembleQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         dtoList.forEach(e -> {
            if (e.getSequence().equals(0)) {
               AtomicReference<Boolean> boolMissingEnum = new AtomicReference<>(Boolean.FALSE);
               if (machinePartLinkMap.get(e.getProductId()) != null) {
                  machinePartLinkMap.get(e.getProductId()).forEach((partId, part) -> {
                     if (machinePartQuantityMap.get(partId) != null && machinePartQuantityMap.get(partId) < part.getQuantity()) {
                        boolMissingEnum.set(Boolean.TRUE);
                     }
                  });
               }

               if (assembleLinkMap.get(e.getProductId()) != null) {
                  assembleLinkMap.get(e.getProductId()).forEach((assembleId, assemble) -> {
                     if (assembleQuantityMap.get(assembleId) != null && assembleQuantityMap.get(assembleId) < assemble.getQuantity()) {
                        boolMissingEnum.set(Boolean.TRUE);
                     }
                  });
               }

               e.setBoolMissingEnum(boolMissingEnum.get());
            }
         });
      }

      return dtoList;
   }

   @Override
   public List<AppTaskProcessDTO> listDrillTaskByNestCutPlateId(Long nestCutPlateId) {
      return this.taskProcessService.listDrillTaskByTaskOrderId(nestCutPlateId).stream().map(e -> {
         AppTaskProcessDTO dto = BeanUtil.copy(e, AppTaskProcessDTO.class);
         dto.setPicturePath(this.ip + "files/" + dto.getPicturePath());
         return dto;
      }).collect(Collectors.toList());
   }

   @Override
   public PageVO<AppTaskProcessDTO> pageDrillTaskByNestCutPlateId(Long nestCutPlateId, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.listDrillTaskByNestCutPlateId(nestCutPlateId));
   }

   @Override
   public AppTaskProcessDetailsDTO taskProcessDetails(Long id, Boolean boolAssist, Long assistGroupId) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(id);
      Preconditions.checkArgument(taskProcess != null, "操作失败：传入id不正确");
      AppTaskProcessDetailsDTO dto = AppTaskProcessDetailsDTO.builder()
         .id(taskProcess.getId())
         .askCompleteTime(taskProcess.getAskCompleteTime())
         .taskTypeEnum(taskProcess.getTaskTypeEnum())
         .quantity(taskProcess.getNeedQuantity() - taskProcess.getCompleteQuantity())
         .productId(taskProcess.getProductId())
         .taskId(taskProcess.getTaskId())
         .build();
      if (boolAssist) {
         MesBuildingAssist assistBizOne = this.mesBuildingAssistBiz
            .getOne(
               Wrappers.lambdaQuery(MesBuildingAssist.class)
                  .eq(MesBuildingAssist::getTaskProcessId, id)
                  .eq(MesBuildingAssist::getGroupsId, assistGroupId)
                  .eq(MesBuildingAssist::getBoolFinishEnum, false)
            );
         Integer assistQuantity = this.getAssistQuantity(Objects.isNull(assistBizOne) ? null : Arrays.asList(assistBizOne), taskProcess.getTaskTypeEnum());
         dto.setQuantity(assistQuantity);
         MesBuildingGroups groups = this.groupsBiz.getById(assistGroupId);
         dto.setAssistGroup(IdAndNameDO.builder().id(assistGroupId).name(groups == null ? null : groups.getName()).build());
         MesBuildingTeamUserLink teamUserLink = this.teamUserLinkService.getTeamLeaderNameByGroupId(taskProcess.getProcessId(), assistGroupId);
         dto.setTeam(IdAndNameDO.builder().id(teamUserLink.getId()).name(teamUserLink.getUserName()).build());
      } else {
         List<MesBuildingAssist> assistBizs = this.mesBuildingAssistBiz
            .list(Wrappers.lambdaQuery(MesBuildingAssist.class).eq(MesBuildingAssist::getTaskProcessId, id));
         if (CollectionUtils.isNotEmpty(assistBizs)) {
            Integer assistQuantity = this.getAssistQuantity(assistBizs, taskProcess.getTaskTypeEnum());
            dto.setQuantity(dto.getQuantity() - assistQuantity);
         }

         MesBuildingTeamUserLink teamUserLink = this.teamUserLinkService.getTeamLeaderNameByGroupId(taskProcess.getProcessId(), taskProcess.getGroupsId());
         dto.setTeam(IdAndNameDO.builder().id(teamUserLink.getId()).name(teamUserLink.getUserName()).build());
      }

      ContractProject project = this.projectService.getById(taskProcess.getProjectId());
      dto.setProject(
         ProjectDetailDO.builder()
            .id(project.getId())
            .name(project.getName())
            .serialNumber(project.getSerialNumber())
            .shortName(project.getShortName())
            .build()
      );
      if (taskProcess.getMonomerId() != null && taskProcess.getAreaId() != null) {
         PlanMonomer monomer = this.monomerService.getById(taskProcess.getMonomerId());
         PlanArea area = this.areaService.getById(taskProcess.getAreaId());
         dto.setMonomer(MonomerDetailDO.builder().id(monomer.getId()).name(monomer.getName()).build());
         dto.setArea(AreaDetailDO.builder().id(area.getId()).name(area.getName()).build());
      }

      MesBuildingProcess process = this.processService.getById(taskProcess.getProcessId());
      dto.setProcess(IdAndNameDO.builder().id(process.getId()).name(process.getName()).build());
      dto.setReportType(process.getReportType());
      List<MesBuildingNextProcessLink> processLinks = this.nextProcessLinkService
         .list(Wrappers.lambdaQuery(MesBuildingNextProcessLink.class).eq(MesBuildingNextProcessLink::getTaskProcessId, taskProcess.getId()));
      if (CollectionUtils.isNotEmpty(processLinks)) {
         List<Long> nextProcessIds = processLinks.stream().map(MesBuildingNextProcessLink::getNextProcessId).collect(Collectors.toList());
         List<IdAndNameDO> proList = new ArrayList<>();

         for (MesBuildingProcess pro : this.processService.listByIds(nextProcessIds)) {
            proList.add(IdAndNameDO.builder().id(pro.getId()).name(pro.getName()).build());
         }

         dto.setNextProcesses(proList);
      }

      List<MesBuildingAssistNumberDetail> assistNumberDetails = this.numberDetailService
         .list(Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class).eq(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcess.getId()));
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart product = this.machinePartService.getById(taskProcess.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
      } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact product = this.artifactService.getById(taskProcess.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
         if (product.getCodingType().equals(CodingTypeEnum.BATCH.getType())) {
            dto.setCodingType(product.getCodingType());
            dto.setBoolFirstProcess(taskProcess.getSequence().equals(0) ? Boolean.TRUE : Boolean.FALSE);
         } else {
            dto.setCodingType(CodingTypeEnum.SINGLE.getType());
            dto.setBoolFirstProcess(Boolean.FALSE);
         }

         List<AppTaskProcessArtifactNumberDTO> numberDTOS = new ArrayList<>();
         List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, id)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
            );
         Map<Integer, List<MesBuildingTaskNumberLink>> numberLinkMap = canReportNumbers.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
         if (boolAssist) {
            for (MesBuildingAssistNumberDetail assistNumber : assistNumberDetails.stream()
               .filter(s -> s.getGroupsId().equals(assistGroupId))
               .collect(Collectors.toList())) {
               List<MesBuildingTaskNumberLink> linkList = numberLinkMap.get(assistNumber.getNumber());
               if (CollectionUtils.isNotEmpty(linkList)
                  && !assistNumber.getBoolFinishEnum()
                  && linkList.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                  numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(assistNumber.getNumber()).serialNumber(product.getSerialNumber()).build());
               }
            }
         } else {
            List<Integer> assistNumbers = assistNumberDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());

            for (Integer number : numberLinkMap.keySet()) {
               if (!assistNumbers.contains(number)) {
                  List<MesBuildingTaskNumberLink> linkList = numberLinkMap.get(number);
                  if (linkList.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                     numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(number).serialNumber(product.getSerialNumber()).build());
                  }
               }
            }
         }

         dto.setArtifactNumberList(numberDTOS);
      } else {
         if (!taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            throw new IllegalArgumentException("操作失败，产品类型不正确");
         }

         TechAssemble product = this.assembleService.getById(taskProcess.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
         List<TechAssembleDetail> assembleDetails = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getAssembleId, product.getId()));
         List<Long> artifactIds = assembleDetails.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList());
         List<TechArtifact> artifacts = this.artifactService.listByIds(artifactIds);
         MesBuildingTask task = this.baseService.getById(taskProcess.getTaskId());
         if (task.getBoolOneCode()) {
            dto.setCodingType(1);
            dto.setBoolFirstProcess(Boolean.FALSE);
            List<AppTaskProcessArtifactNumberDTO> numberDTOS = new ArrayList<>();
            if (boolAssist) {
               for (MesBuildingAssistNumberDetail assNumber : assistNumberDetails.stream()
                  .filter(s -> s.getGroupsId().equals(assistGroupId))
                  .collect(Collectors.toList())) {
                  if (!assNumber.getBoolFinishEnum()) {
                     numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(assNumber.getNumber()).serialNumber(product.getSerialNumber()).build());
                  }
               }
            } else {
               List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                        .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, id)
                        .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, false)
                  );
               List<Integer> assistNumbers = assistNumberDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());

               for (MesBuildingTaskNumberLink canReportNumber : canReportNumbers) {
                  if (!assistNumbers.contains(canReportNumber.getAssembleNumber())) {
                     numberDTOS.add(
                        AppTaskProcessArtifactNumberDTO.builder().number(canReportNumber.getAssembleNumber()).serialNumber(product.getSerialNumber()).build()
                     );
                  }
               }
            }

            dto.setArtifactNumberList(numberDTOS);
         } else {
            dto.setBoolFirstProcess(Boolean.TRUE);
         }
      }

      if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()) && taskProcess.getSequence().equals(0)) {
         AtomicInteger producibleQuantity = new AtomicInteger();
         producibleQuantity.set(dto.getQuantity());
         List<AppTaskProcessArtifactNumberDTO> artifactNumberList = dto.getArtifactNumberList();
         producibleQuantity.set(artifactNumberList.size());
         List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, dto.getProductId()));
         List<Long> partIds = partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
         dto.setProducibleQuantity(producibleQuantity.get());
         if (CollectionUtils.isNotEmpty(partIds)) {
            List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
            Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            partLinks.forEach(
               e -> {
                  TechMachinePart part = partMap.get(e.getMachinePartId());
                  if (part.getBoolProcess()
                     && !part.getBoolSendDirectly()
                     && part.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType())
                     && producibleQuantity.get() > (part.getProducedQuantity() - part.getUsedQuantity()) / e.getQuantity()) {
                     producibleQuantity.set((part.getProducedQuantity() - part.getUsedQuantity()) / e.getQuantity());
                  }
               }
            );
            dto.setProducibleQuantity(producibleQuantity.get() > dto.getQuantity() ? dto.getQuantity() : producibleQuantity.get());
            if (artifactNumberList.size() > dto.getProducibleQuantity()) {
               artifactNumberList = artifactNumberList.stream().limit(dto.getProducibleQuantity().intValue()).collect(Collectors.toList());
               dto.setArtifactNumberList(artifactNumberList);
            }
         }
      } else if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()) && taskProcess.getSequence().equals(0)) {
         AtomicInteger producibleQuantity = new AtomicInteger();
         producibleQuantity.set(dto.getQuantity());
         List<TechAssembleMachinePartLink> partLinks = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, dto.getProductId()));
         List<Long> partIds = partLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList());
         dto.setProducibleQuantity(producibleQuantity.get());
         if (CollectionUtils.isNotEmpty(partIds)) {
            List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
            Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            partLinks.forEach(e -> {
               TechMachinePart part = partMap.get(e.getMachinePartId());
               if (part.getBoolProcess() && producibleQuantity.get() > (part.getProducedQuantity() - part.getUsedQuantity()) / e.getQuantity()) {
                  producibleQuantity.set((part.getProducedQuantity() - part.getUsedQuantity()) / e.getQuantity());
               }
            });
            dto.setProducibleQuantity(producibleQuantity.get() > dto.getQuantity() ? dto.getQuantity() : producibleQuantity.get());
         }
      } else {
         dto.setProducibleQuantity(dto.getQuantity());
      }

      GroupDetailDTO groupDetailDTO = this.groupsBiz.getTreeByGroupId(taskProcess.getGroupsId());
      IdAndNameDO group = IdAndNameDO.builder().id(groupDetailDTO.getGroupId()).name(groupDetailDTO.getGroupName()).build();
      IdAndNameDO line = IdAndNameDO.builder().id(groupDetailDTO.getProductionLineId()).name(groupDetailDTO.getProductionLineName()).build();
      IdAndNameDO workShop = IdAndNameDO.builder().id(groupDetailDTO.getWorkshopId()).name(groupDetailDTO.getWorkshopName()).build();
      IdAndNameDO factory = IdAndNameDO.builder().id(groupDetailDTO.getFactoryId()).name(groupDetailDTO.getFactoryName()).build();
      List<AppTaskProcessArtifactNumberDTO> artifactNumberList = dto.getArtifactNumberList();
      if (CollectionUtils.isNotEmpty(artifactNumberList)) {
         artifactNumberList.sort(Comparator.comparingInt(AppTaskProcessArtifactNumberDTO::getNumber));
         dto.setArtifactNumberList(artifactNumberList);
      }

      dto.setProductionLine(line);
      dto.setGroups(group);
      dto.setWorkshop(workShop);
      dto.setFactory(factory);
      return dto;
   }

   @Override
   public AppTaskProcessDetailsDTO taskProcessDetails2(
      Long id, Boolean boolAssist, Long assistLineId, Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap
   ) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(id);
      Preconditions.checkArgument(taskProcess != null, "操作失败：传入id不正确");
      AppTaskProcessDetailsDTO dto = AppTaskProcessDetailsDTO.builder()
         .id(taskProcess.getId())
         .askCompleteTime(taskProcess.getAskCompleteTime())
         .taskTypeEnum(taskProcess.getTaskTypeEnum())
         .quantity(taskProcess.getNeedQuantity() - taskProcess.getCompleteQuantity())
         .productId(taskProcess.getProductId())
         .taskId(taskProcess.getTaskId())
         .build();
      if (boolAssist) {
         MesBuildingAssist assistBizOne = this.mesBuildingAssistBiz
            .getOne(
               Wrappers.lambdaQuery(MesBuildingAssist.class)
                  .eq(MesBuildingAssist::getTaskProcessId, id)
                  .eq(MesBuildingAssist::getProductionLineId, assistLineId)
            );
         Integer assistQuantity = this.getAssistQuantity(Objects.isNull(assistBizOne) ? null : Arrays.asList(assistBizOne), taskProcess.getTaskTypeEnum());
         dto.setQuantity(assistQuantity);
         MesBuildingProductionLine productionLine = this.productionLineBiz.getById(assistLineId);
         dto.setAssistProductionLine(IdAndNameDO.builder().id(assistLineId).name(productionLine == null ? null : productionLine.getName()).build());
         MesBuildingTeamUserLink teamUserLink = this.teamUserLinkService.getTeamLeaderNameByTeamId(assistBizOne.getTeamId());
         dto.setTeam(IdAndNameDO.builder().id(teamUserLink.getId()).name(teamUserLink.getUserName()).build());
      } else {
         List<MesBuildingAssist> assistBizs = this.mesBuildingAssistBiz
            .list(Wrappers.lambdaQuery(MesBuildingAssist.class).eq(MesBuildingAssist::getTaskProcessId, id));
         if (CollectionUtils.isNotEmpty(assistBizs)) {
            Integer assistQuantity = this.getAssistQuantity(assistBizs, taskProcess.getTaskTypeEnum());
            dto.setQuantity(dto.getQuantity() - assistQuantity);
         }

         MesBuildingTeamUserLink teamUserLink = this.teamUserLinkService.getTeamLeaderNameByTeamId(taskProcess.getTeamId());
         dto.setTeam(IdAndNameDO.builder().id(teamUserLink.getId()).name(teamUserLink.getUserName()).build());
      }

      ContractProject project = this.projectService.getById(taskProcess.getProjectId());
      dto.setProject(
         ProjectDetailDO.builder()
            .id(project.getId())
            .name(project.getName())
            .serialNumber(project.getSerialNumber())
            .shortName(project.getShortName())
            .build()
      );
      if (taskProcess.getMonomerId() != null && taskProcess.getAreaId() != null) {
         PlanMonomer monomer = this.monomerService.getById(taskProcess.getMonomerId());
         PlanArea area = this.areaService.getById(taskProcess.getAreaId());
         PlanAreaBatch areaBatch = this.areaBatchService.getById(taskProcess.getAreaBatchId());
         dto.setMonomer(MonomerDetailDO.builder().id(monomer.getId()).name(monomer.getName()).build());
         dto.setArea(AreaDetailDO.builder().id(area.getId()).name(area.getName()).build());
         dto.setAreaBatch(NameInfo.builder().id(areaBatch.getId()).name(areaBatch.getName()).build());
      }

      MesBuildingProcess process = this.processService.getById(taskProcess.getProcessId());
      dto.setProcess(IdAndNameDO.builder().id(process.getId()).name(process.getName()).build());
      dto.setReportType(process.getReportType());
      List<MesBuildingNextProcessLink> processLinks = this.nextProcessLinkService
         .list(Wrappers.lambdaQuery(MesBuildingNextProcessLink.class).eq(MesBuildingNextProcessLink::getTaskProcessId, taskProcess.getId()));
      if (CollectionUtils.isNotEmpty(processLinks)) {
         List<Long> nextProcessIds = processLinks.stream().map(MesBuildingNextProcessLink::getNextProcessId).collect(Collectors.toList());
         List<IdAndNameDO> proList = new ArrayList<>();

         for (MesBuildingProcess pro : this.processService.listByIds(nextProcessIds)) {
            proList.add(IdAndNameDO.builder().id(pro.getId()).name(pro.getName()).build());
         }

         dto.setNextProcesses(proList);
      }

      List<MesBuildingAssistNumberDetail> assistNumberDetails = this.numberDetailService
         .list(Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class).eq(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcess.getId()));
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart product = this.machinePartService.getById(taskProcess.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
      } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact product = this.artifactService.getById(taskProcess.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
         if (product.getCodingType().equals(CodingTypeEnum.BATCH.getType())) {
            dto.setCodingType(product.getCodingType());
            dto.setBoolFirstProcess(taskProcess.getSequence().equals(0) ? Boolean.TRUE : Boolean.FALSE);
         } else {
            dto.setCodingType(CodingTypeEnum.SINGLE.getType());
            dto.setBoolFirstProcess(Boolean.FALSE);
         }

         List<AppTaskProcessArtifactNumberDTO> numberDTOS = new ArrayList<>();
         List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, id)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
            );
         Map<Integer, List<MesBuildingTaskNumberLink>> numberLinkMap = canReportNumbers.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
         List<Long> assembleIds = canReportNumbers.stream()
            .map(MesBuildingTaskNumberLink::getAssembleId)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         if (assembleTaskNumberLinkMap == null) {
            assembleTaskNumberLinkMap = CollectionUtils.isEmpty(assembleIds)
               ? new HashMap<>()
               : this.mesBuildingTaskNumberLinkService
                  .list(
                     (Wrapper<MesBuildingTaskNumberLink>)(((((new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                                       .in(MesBuildingTaskNumberLink::getAssembleId, assembleIds))
                                    .eq(MesBuildingTaskNumberLink::getBoolAssembleComplete, Boolean.TRUE))
                                 .eq(MesBuildingTaskNumberLink::getBoolArtifactInspection, Boolean.FALSE))
                              .eq(MesBuildingTaskNumberLink::getBoolArtifactInproduce, Boolean.FALSE))
                           .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, Boolean.FALSE))
                        .eq(MesBuildingTaskNumberLink::getBoolArtifactComplete, Boolean.FALSE)
                  )
                  .stream()
                  .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
         }

         Map<Long, List<MesBuildingTaskNumberLink>> finalAssembleTaskNumberLinkMap = assembleTaskNumberLinkMap;
         if (boolAssist) {
            for (MesBuildingAssistNumberDetail assistNumber : assistNumberDetails.stream()
               .filter(s -> s.getProductionLineId().equals(assistLineId))
               .collect(Collectors.toList())) {
               List<MesBuildingTaskNumberLink> linkList = numberLinkMap.get(assistNumber.getNumber());
               if (CollectionUtils.isNotEmpty(linkList) && !assistNumber.getBoolFinishEnum()) {
                  if (taskProcess.getSequence() == 0 && !linkList.stream().allMatch(e -> e.getAssembleId() == null)) {
                     boolean allGroupsSatisfied = linkList.stream()
                        .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
                        .entrySet()
                        .stream()
                        .allMatch(entry -> {
                           List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = finalAssembleTaskNumberLinkMap.get(entry.getKey());
                           return CollectionUtils.isNotEmpty(assembleTaskNumberLinks) && assembleTaskNumberLinks.size() >= entry.getValue().size();
                        });
                     if (allGroupsSatisfied) {
                        numberDTOS.add(
                           AppTaskProcessArtifactNumberDTO.builder().number(assistNumber.getNumber()).serialNumber(product.getSerialNumber()).build()
                        );
                        linkList.stream()
                           .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
                           .forEach((assembleId, taskNumberLinkList) -> {
                              List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = finalAssembleTaskNumberLinkMap.get(assembleId);
                              assembleTaskNumberLinks.subList(0, taskNumberLinkList.size()).clear();
                           });
                     }
                  } else {
                     numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(assistNumber.getNumber()).serialNumber(product.getSerialNumber()).build());
                  }
               }
            }
         } else {
            List<Integer> assistNumbers = assistNumberDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());

            for (Integer number : numberLinkMap.keySet()) {
               if (!assistNumbers.contains(number)) {
                  List<MesBuildingTaskNumberLink> linkList = numberLinkMap.get(number);
                  if (taskProcess.getSequence() == 0 && !linkList.stream().allMatch(e -> e.getAssembleId() == null)) {
                     boolean allGroupsSatisfied = linkList.stream()
                        .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
                        .entrySet()
                        .stream()
                        .allMatch(entry -> {
                           List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = finalAssembleTaskNumberLinkMap.get(entry.getKey());
                           return CollectionUtils.isNotEmpty(assembleTaskNumberLinks) && assembleTaskNumberLinks.size() >= entry.getValue().size();
                        });
                     if (allGroupsSatisfied) {
                        numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(number).serialNumber(product.getSerialNumber()).build());
                        linkList.stream()
                           .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
                           .forEach((assembleId, taskNumberLinkList) -> {
                              List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = finalAssembleTaskNumberLinkMap.get(assembleId);
                              assembleTaskNumberLinks.subList(0, taskNumberLinkList.size()).clear();
                           });
                     }
                  } else {
                     numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(number).serialNumber(product.getSerialNumber()).build());
                  }
               }
            }
         }

         dto.setArtifactNumberList(numberDTOS);
      } else {
         if (!taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            throw new IllegalArgumentException("操作失败，产品类型不正确");
         }

         TechAssemble product = this.assembleService.getById(taskProcess.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
         List<TechAssembleDetail> assembleDetails = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getAssembleId, product.getId()));
         List<Long> artifactIds = assembleDetails.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList());
         MesBuildingTask task = this.baseService.getById(taskProcess.getTaskId());
         if (task.getBoolOneCode()) {
            dto.setCodingType(1);
            dto.setBoolFirstProcess(Boolean.FALSE);
            List<AppTaskProcessArtifactNumberDTO> numberDTOS = new ArrayList<>();
            if (boolAssist) {
               for (MesBuildingAssistNumberDetail assNumber : assistNumberDetails.stream()
                  .filter(s -> s.getProductionLineId().equals(assistLineId))
                  .collect(Collectors.toList())) {
                  if (!assNumber.getBoolFinishEnum()) {
                     numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(assNumber.getNumber()).serialNumber(product.getSerialNumber()).build());
                  }
               }
            } else {
               List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                        .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, id)
                        .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, false)
                  );
               List<Integer> assistNumbers = assistNumberDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());

               for (MesBuildingTaskNumberLink canReportNumber : canReportNumbers) {
                  if (!assistNumbers.contains(canReportNumber.getAssembleNumber())) {
                     numberDTOS.add(
                        AppTaskProcessArtifactNumberDTO.builder().number(canReportNumber.getAssembleNumber()).serialNumber(product.getSerialNumber()).build()
                     );
                  }
               }
            }

            dto.setArtifactNumberList(numberDTOS);
         } else {
            dto.setCodingType(2);
            dto.setBoolFirstProcess(Boolean.TRUE);
         }
      }

      if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()) && taskProcess.getSequence().equals(0)) {
         AtomicInteger producibleQuantity = new AtomicInteger();
         producibleQuantity.set(dto.getQuantity());
         List<AppTaskProcessArtifactNumberDTO> artifactNumberList = dto.getArtifactNumberList();
         producibleQuantity.set(artifactNumberList.size());
         List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, dto.getProductId()));
         List<Long> partIds = partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
         dto.setProducibleQuantity(producibleQuantity.get());
         if (CollectionUtils.isNotEmpty(partIds)) {
            List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
            Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            partLinks.forEach(
               e -> {
                  TechMachinePart part = partMap.get(e.getMachinePartId());
                  if (part.getBoolProcess()
                     && !part.getBoolSendDirectly()
                     && part.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType())
                     && producibleQuantity.get() > (part.getProducedQuantity() - part.getUsedQuantity()) / e.getQuantity()) {
                     producibleQuantity.set((part.getProducedQuantity() - part.getUsedQuantity()) / e.getQuantity());
                  }
               }
            );
            dto.setProducibleQuantity(producibleQuantity.get() > dto.getQuantity() ? dto.getQuantity() : producibleQuantity.get());
            if (artifactNumberList.size() > dto.getProducibleQuantity()) {
               artifactNumberList = artifactNumberList.stream().limit(dto.getProducibleQuantity().intValue()).collect(Collectors.toList());
               dto.setArtifactNumberList(artifactNumberList);
            }
         }
      } else if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()) && taskProcess.getSequence().equals(0)) {
         AtomicInteger producibleQuantity = new AtomicInteger();
         producibleQuantity.set(dto.getQuantity());
         List<TechAssembleMachinePartLink> partLinks = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, dto.getProductId()));
         List<Long> partIds = partLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList());
         dto.setProducibleQuantity(producibleQuantity.get());
         if (CollectionUtils.isNotEmpty(partIds)) {
            List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
            Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            partLinks.forEach(e -> {
               TechMachinePart part = partMap.get(e.getMachinePartId());
               if (part.getBoolProcess() && producibleQuantity.get() > (part.getProducedQuantity() - part.getUsedQuantity()) / e.getQuantity()) {
                  producibleQuantity.set((part.getProducedQuantity() - part.getUsedQuantity()) / e.getQuantity());
               }
            });
            dto.setProducibleQuantity(producibleQuantity.get() > dto.getQuantity() ? dto.getQuantity() : producibleQuantity.get());
         }
      } else {
         dto.setProducibleQuantity(dto.getQuantity());
      }

      ProductLineDetailDTO lineDetailDTO = this.productionLineService.getTreeByLineId(taskProcess.getProductionLineId());
      IdAndNameDO line = IdAndNameDO.builder().id(lineDetailDTO.getProductionLineId()).name(lineDetailDTO.getProductionLineName()).build();
      IdAndNameDO workShop = IdAndNameDO.builder().id(lineDetailDTO.getWorkshopId()).name(lineDetailDTO.getWorkshopName()).build();
      IdAndNameDO factory = IdAndNameDO.builder().id(lineDetailDTO.getFactoryId()).name(lineDetailDTO.getFactoryName()).build();
      List<AppTaskProcessArtifactNumberDTO> artifactNumberList = dto.getArtifactNumberList();
      if (CollectionUtils.isNotEmpty(artifactNumberList)) {
         artifactNumberList.sort(Comparator.comparingInt(AppTaskProcessArtifactNumberDTO::getNumber));
         dto.setArtifactNumberList(artifactNumberList);
      }

      dto.setProductionLine(line);
      dto.setWorkshop(workShop);
      dto.setFactory(factory);
      return dto;
   }

   @Override
   public List<String> productNumberDetails(Long taskProcessId, Integer assembleNumber) {
      if (assembleNumber != null) {
         MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(taskProcessId);
         Preconditions.checkArgument(taskProcess != null, "操作失败：传入id不正确");
         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            MesBuildingTaskNumberLink taskNumberLink = this.mesBuildingTaskNumberLinkService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                     .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcessId)
                     .eq(MesBuildingTaskNumberLink::getAssembleNumber, assembleNumber)
               );
            if (ObjectUtil.isNotNull(taskNumberLink)) {
               TechArtifact artifact = this.artifactService.getById(taskNumberLink.getArtifactId());
               String resultStr = artifact.getSerialNumber() + "(" + taskNumberLink.getArtifactNumber() + ")";
               return CollUtil.newArrayList(resultStr);
            }
         }
      }

      return new ArrayList<>();
   }

   @Override
   public List<AppTaskMissingDetailsDTO> taskProcessMissingDetails(Long id, Boolean boolAssist, Long assistGroupId) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(id);
      Preconditions.checkArgument(taskProcess != null, "操作失败：id不能为空");
      if (boolAssist == null) {
         boolAssist = Boolean.FALSE;
      }

      new ArrayList();
      List<MesBuildingAssistNumberDetail> assistDetails;
      if (boolAssist) {
         Preconditions.checkArgument(assistGroupId != null, "操作失败!");
         assistDetails = this.numberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .eq(MesBuildingAssistNumberDetail::getTaskProcessId, id)
                  .eq(MesBuildingAssistNumberDetail::getGroupsId, assistGroupId)
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(assistDetails), "操作失败,请刷新页面!");
      } else {
         Preconditions.checkArgument(assistGroupId == null, "操作失败!");
         assistDetails = this.numberDetailService
            .list(Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class).eq(MesBuildingAssistNumberDetail::getTaskProcessId, id));
      }

      List<Integer> assistNumbers = assistDetails.stream()
         .filter(s -> !s.getBoolFinishEnum())
         .map(MesBuildingAssistNumberDetail::getNumber)
         .collect(Collectors.toList());
      List<AppTaskMissingDetailsDTO> dtoList = new ArrayList<>();
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTaskNumberLink> assLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, id)
                  .in(boolAssist && CollectionUtils.isNotEmpty(assistNumbers), MesBuildingTaskNumberLink::getArtifactNumber, assistNumbers)
                  .notIn(!boolAssist && CollectionUtils.isNotEmpty(assistNumbers), MesBuildingTaskNumberLink::getArtifactNumber, assistNumbers)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
            );
         Map<Long, Integer> linkQuantityMap = assLinks.stream()
            .filter(e -> !e.getBoolAssembleComplete())
            .collect(Collectors.toMap(MesBuildingTaskNumberLink::getAssembleId, s -> 1, Integer::sum));
         List<Integer> artNnumberLinks = assLinks.stream().map(s -> s.getArtifactNumber()).distinct().collect(Collectors.toList());
         if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(linkQuantityMap) && CollectionUtils.isNotEmpty(linkQuantityMap.keySet())) {
            Map<Long, TechAssemble> assMap = this.assembleService
               .listByIds(linkQuantityMap.keySet())
               .stream()
               .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

            for (Long assId : linkQuantityMap.keySet()) {
               TechAssemble assemble = assMap.get(assId);
               dtoList.add(
                  AppTaskMissingDetailsDTO.builder()
                     .productId(assId)
                     .specification(assemble.getSpecification())
                     .productTypeEnum(TaskTypeEnum.ASSEMBLE.getType())
                     .missingQuantity(linkQuantityMap.get(assId))
                     .serialNumber(assemble.getSerialNumber())
                     .build()
               );
            }
         }

         List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, taskProcess.getProductId()));
         List<Long> partIds = partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
         List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
         Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         partLinks.forEach(
            e -> {
               TechMachinePart part = partMap.get(e.getMachinePartId());
               if (part.getBoolProcess()
                  && part.getRelationType().equals(TaskTypeEnum.ARTIFACT.getType())
                  && !part.getBoolSendDirectly()
                  && part.getProducedQuantity() - part.getUsedQuantity() < e.getQuantity()) {
                  dtoList.add(
                     AppTaskMissingDetailsDTO.builder()
                        .productId(part.getId())
                        .productTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
                        .missingQuantity(e.getQuantity() * artNnumberLinks.size() - (part.getProducedQuantity() - part.getUsedQuantity()))
                        .serialNumber(part.getSerialNumber())
                        .specification(part.getSpecification())
                        .build()
                  );
               }
            }
         );
      } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssembleMachinePartLink> partLinks = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, taskProcess.getProductId()));
         List<Long> partIds = partLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList());
         List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
         Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         partLinks.forEach(
            e -> {
               TechMachinePart part = partMap.get(e.getMachinePartId());
               if (part.getBoolProcess()
                  && part.getRelationType().equals(TaskTypeEnum.ASSEMBLE.getType())
                  && !part.getBoolSendDirectly()
                  && part.getProducedQuantity() - part.getUsedQuantity() < e.getQuantity()) {
                  dtoList.add(
                     AppTaskMissingDetailsDTO.builder()
                        .productId(part.getId())
                        .productTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
                        .missingQuantity(e.getQuantity() - (part.getProducedQuantity() - part.getUsedQuantity()))
                        .serialNumber(part.getSerialNumber())
                        .specification(part.getSpecification())
                        .build()
                  );
               }
            }
         );
      }

      return dtoList;
   }

   @Override
   public List<AppTaskMissingDetailsDTO> taskProcessMissingDetails2(Long id, Boolean boolAssist, Long assistLineId) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(id);
      Preconditions.checkArgument(taskProcess != null, "操作失败：id不能为空");
      if (boolAssist == null) {
         boolAssist = Boolean.FALSE;
      }

      new ArrayList();
      List<MesBuildingAssistNumberDetail> assistDetails;
      if (boolAssist) {
         Preconditions.checkArgument(assistLineId != null, "操作失败,生产线id不可为空!");
         assistDetails = this.numberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .eq(MesBuildingAssistNumberDetail::getTaskProcessId, id)
                  .eq(MesBuildingAssistNumberDetail::getProductionLineId, assistLineId)
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(assistDetails), "操作失败,请刷新页面!");
      } else {
         Preconditions.checkArgument(assistLineId == null, "操作失败!");
         assistDetails = this.numberDetailService
            .list(Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class).eq(MesBuildingAssistNumberDetail::getTaskProcessId, id));
      }

      List<Integer> assistNumbers = assistDetails.stream()
         .filter(s -> !s.getBoolFinishEnum())
         .map(MesBuildingAssistNumberDetail::getNumber)
         .collect(Collectors.toList());
      List<AppTaskMissingDetailsDTO> dtoList = new ArrayList<>();
      // Components are consumed by sequence zero; later processes use that work in progress.
      if (taskProcess.getSequence() != null && taskProcess.getSequence() > 0) {
         return dtoList;
      }
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTaskNumberLink> assLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, id)
                  .in(boolAssist && CollectionUtils.isNotEmpty(assistNumbers), MesBuildingTaskNumberLink::getArtifactNumber, assistNumbers)
                  .notIn(!boolAssist && CollectionUtils.isNotEmpty(assistNumbers), MesBuildingTaskNumberLink::getArtifactNumber, assistNumbers)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
            );
         Map<Long, Integer> linkQuantityMap = assLinks.stream()
            .filter(e -> !e.getBoolAssembleComplete())
            .collect(Collectors.toMap(MesBuildingTaskNumberLink::getAssembleId, s -> 1, Integer::sum));
         List<Integer> artNnumberLinks = assLinks.stream().map(s -> s.getArtifactNumber()).distinct().collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(assLinks)) {
            List<Long> assembleIds = assLinks.stream()
               .filter(e -> !e.getBoolAssembleComplete())
               .map(e -> e.getAssembleTaskProcessId())
               .distinct()
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(assembleIds)) {
               List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                        .in(
                           MesBuildingTaskProcess::getId,
                           assLinks.stream()
                              .filter(e -> !e.getBoolAssembleComplete())
                              .map(e -> e.getAssembleTaskProcessId())
                              .distinct()
                              .collect(Collectors.toList())
                        )
                  );
               Map<Long, MesBuildingLeaderInfoDTO> leaderMap = this.teamService
                  .findAllTeamLeader(taskProcesses.stream().map(e -> e.getTeamId()).collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(s -> s.getId(), Function.identity()));
               Map<Long, TechAssemble> assMap = this.assembleService
                  .listByIds(linkQuantityMap.keySet())
                  .stream()
                  .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

               for (MesBuildingTaskProcess item : taskProcesses) {
                  TechAssemble assemble = assMap.get(item.getProductId());
                  MesBuildingLeaderInfoDTO LeaderInfo = leaderMap.get(item.getTeamId());
                  dtoList.add(
                     AppTaskMissingDetailsDTO.builder()
                        .productId(assemble.getId())
                        .specification(assemble.getSpecification())
                        .productTypeEnum(TaskTypeEnum.ASSEMBLE.getType())
                        .missingQuantity(linkQuantityMap.get(assemble.getId()))
                        .serialNumber(assemble.getSerialNumber())
                        .teamId(LeaderInfo.getId())
                        .teamName(LeaderInfo.getLeaderName())
                        .build()
                  );
               }
            }
         }

         List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, taskProcess.getProductId()));
         if (CollectionUtils.isNotEmpty(partLinks)) {
            List<Long> partIds = partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
            List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
            Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            partLinks.forEach(
               e -> {
                  TechMachinePart part = partMap.get(e.getMachinePartId());
                  if (part.getBoolProcess()
                     && part.getRelationType().equals(TaskTypeEnum.ARTIFACT.getType())
                     && !part.getBoolSendDirectly()
                     && part.getProducedQuantity() - part.getUsedQuantity() < e.getQuantity()) {
                     dtoList.add(
                        AppTaskMissingDetailsDTO.builder()
                           .productId(part.getId())
                           .productTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
                           .missingQuantity(e.getQuantity() * artNnumberLinks.size() - (part.getProducedQuantity() - part.getUsedQuantity()))
                           .serialNumber(part.getSerialNumber())
                           .teamName("-")
                           .specification(part.getSpecification())
                           .build()
                     );
                  }
               }
            );
         }
      } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssembleMachinePartLink> partLinks = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, taskProcess.getProductId()));
         if (CollectionUtils.isNotEmpty(partLinks)) {
            List<Long> partIds = partLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList());
            List<TechMachinePart> parts = this.machinePartService.listByIds(partIds);
            Map<Long, TechMachinePart> partMap = parts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            partLinks.forEach(
               e -> {
                  TechMachinePart part = partMap.get(e.getMachinePartId());
                  if (part.getBoolProcess()
                     && part.getRelationType().equals(TaskTypeEnum.ASSEMBLE.getType())
                     && !part.getBoolSendDirectly()
                     && part.getProducedQuantity() - part.getUsedQuantity() < e.getQuantity()) {
                     dtoList.add(
                        AppTaskMissingDetailsDTO.builder()
                           .productId(part.getId())
                           .productTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
                           .missingQuantity(e.getQuantity() - (part.getProducedQuantity() - part.getUsedQuantity()))
                           .serialNumber(part.getSerialNumber())
                           .specification(part.getSpecification())
                           .teamName("-")
                           .build()
                     );
                  }
               }
            );
         }
      }

      return dtoList;
   }

   @Override
   public TaskProductLineListDTO taskTrackProductionLine(LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long workShopId, Long projectId) {
      List<TaskProductDTO> artifactDTOList = this.taskService
         .getTaskByProductionLine(startTime, endTime, TaskTypeEnum.ARTIFACT.getType(), workShopId, projectId);
      List<TaskProductDTO> assembleDTOList = this.taskService
         .getAssembleProductionLine(startTime, endTime, TaskTypeEnum.ASSEMBLE.getType(), workShopId, projectId);
      List<TaskProductDTO> machineDTOList = this.taskService
         .getTaskByProductionLine(startTime, endTime, TaskTypeEnum.MACHINE_PART.getType(), workShopId, projectId);
      if (taskType != null) {
         if (taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
            return TaskProductLineListDTO.builder().artifactList(artifactDTOList).build();
         }

         if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
            return TaskProductLineListDTO.builder().assembleList(assembleDTOList).build();
         }

         if (taskType.equals(TaskTypeEnum.MACHINE_PART.getType())) {
            return TaskProductLineListDTO.builder().machineList(machineDTOList).build();
         }
      }

      return TaskProductLineListDTO.builder().artifactList(artifactDTOList).assembleList(assembleDTOList).machineList(machineDTOList).build();
   }

   @Override
   public List<TaskProcessProductDTO> taskTrackProductionLineDetail(
      LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      List<TaskProcessProductDTO> dtoList = this.taskService
         .taskTrackProductionLineDetail(startTime, endTime, taskType, productionLineId, projectIds, monomerId, areaId, serialNumber);
      String dateTime = LocalDate.now().toString();
      dtoList.forEach(e -> {
         int i = dateTime.compareTo(e.getCompleteDate().toLocalDate().toString());
         if (i > 0 && !e.getCompleteQuantity().equals(e.getQuantity())) {
            e.setStatus(0);
         } else {
            e.setStatus(1);
         }
      });
      dtoList.sort(Comparator.comparing(TaskProcessProductDTO::getStatus));
      return dtoList;
   }

   @Override
   public PageVO<TaskProcessProductDTO> taskTrackProductionLineDetailPage(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Integer taskType,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
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

      PageHelper.startPage(pageNumber, pageSize);
      List<TaskProcessProductDTO> dtoList = this.taskService
         .taskTrackProductionLineDetail(startTime, endTime, taskType, productionLineId, projectIds, monomerId, areaId, serialNumber);
      String dateTime = LocalDate.now().toString();
      dtoList.forEach(e -> {
         int i = dateTime.compareTo(e.getCompleteDate().toLocalDate().toString());
         if (i > 0 && !e.getCompleteQuantity().equals(e.getQuantity())) {
            e.setStatus(0);
         } else {
            e.setStatus(1);
         }
      });
      dtoList.sort(Comparator.comparing(TaskProcessProductDTO::getStatus));
      return new PageVO<>(dtoList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> taskTrackProductionLineDetailPrint(
      LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      String date = startTime != null && endTime != null ? DateTimeUtil.getLocalDateStr(startTime) + "-" + DateTimeUtil.getLocalDateStr(endTime) : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      printVO.setTable(
         this.taskTrackProductionLineDetail(startTime, endTime, taskType, productionLineId, projectId, monomerId, areaId, serialNumber)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<MesBuildingProductionLineDTO> getProductionLine(Integer productType, Long workShopId) {
      List<MesBuildingProductionLineDTO> list = null;
      if (productType.equals(TaskTypeEnum.MACHINE_PART.getType())) {
         return this.productionLineService
            .list(
               Wrappers.lambdaQuery(MesBuildingProductionLine.class)
                  .eq(MesBuildingProductionLine::getWorkshopId, workShopId)
                  .eq(MesBuildingProductionLine::getProductType, productType)
                  .eq(MesBuildingProductionLine::getBoolEnabledEnum, true)
            )
            .stream()
            .map(e -> BeanUtil.copy(e, MesBuildingProductionLineDTO.class))
            .collect(Collectors.toList());
      } else if (productType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         list = this.productionLineService
            .list(
               Wrappers.lambdaQuery(MesBuildingProductionLine.class)
                  .eq(MesBuildingProductionLine::getWorkshopId, workShopId)
                  .eq(MesBuildingProductionLine::getProductType, 2)
                  .eq(MesBuildingProductionLine::getBoolEnabledEnum, true)
            )
            .stream()
            .map(e -> BeanUtil.copy(e, MesBuildingProductionLineDTO.class))
            .collect(Collectors.toList());
         list.addAll(
            this.productionLineService
               .list(
                  Wrappers.lambdaQuery(MesBuildingProductionLine.class)
                     .eq(MesBuildingProductionLine::getWorkshopId, workShopId)
                     .eq(MesBuildingProductionLine::getProductType, 16)
                     .eq(MesBuildingProductionLine::getBoolEnabledEnum, true)
               )
               .stream()
               .map(e -> BeanUtil.copy(e, MesBuildingProductionLineDTO.class))
               .collect(Collectors.toList())
         );
         return list;
      } else {
         return list;
      }
   }

   @Override
   public List<TaskTrackingLineMonthDTO> taskTrackingMonth(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      List<TaskTrackingLineMonthDTO> dtoList = this.taskService
         .taskTrackingMonth(dateTime, workShopId, productionLineId)
         .stream()
         .map(e -> BeanUtil.copy(e, TaskTrackingLineMonthDTO.class))
         .collect(Collectors.toList());
      dtoList.forEach(e -> e.setRate(new BigDecimal(e.getCompleteQuantity()).divide(new BigDecimal(e.getQuantity()), 2, 4)));
      return dtoList;
   }

   @Override
   public List<TaskTrackingProductionLineDTO> taskTrackingMonthDetail(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      List<TaskTrackingProductionLineDO> doList = this.taskService.taskTrackingMonthDetail(dateTime, workShopId, productionLineId);
      List<TaskTrackingProductionLineDTO> dtoList = new ArrayList<>();
      Map<ProjectDetailDO, List<TaskTrackingProductionLineDO>> detailDOListMap = doList.stream()
         .collect(Collectors.groupingBy(TaskTrackingProductionLineDO::getProject));
      detailDOListMap.forEach(
         (project, list) -> {
            List<Long> monomerIds = list.stream().map(e -> e.getMonomer().getId()).collect(Collectors.toList());
            List<Long> areaIds = list.stream().map(e -> e.getArea().getId()).collect(Collectors.toList());
            List<MonomerDetailDO> monomerList = this.monomerService
               .listByIds(monomerIds)
               .stream()
               .map(e -> BeanUtil.copy(e, MonomerDetailDO.class))
               .collect(Collectors.toList());
            List<AreaDetailDO> areaList = this.areaService
               .listByIds(areaIds)
               .stream()
               .map(e -> BeanUtil.copy(e, AreaDetailDO.class))
               .collect(Collectors.toList());
            TaskTrackingProductionLineDTO build = TaskTrackingProductionLineDTO.builder()
               .project(project)
               .quantity(list.stream().mapToInt(TaskTrackingProductionLineDO::getQuantity).sum())
               .netWeight(list.stream().map(TaskTrackingProductionLineDO::getNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
               .grossWeight(list.stream().map(TaskTrackingProductionLineDO::getGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
               .completeQuantity(list.stream().mapToInt(TaskTrackingProductionLineDO::getCompleteQuantity).sum())
               .completeNetWeight(list.stream().map(TaskTrackingProductionLineDO::getCompleteNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
               .completeGrossWeight(list.stream().map(TaskTrackingProductionLineDO::getCompleteGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
               .monomerDO(monomerList)
               .areaDO(areaList)
               .build();
            dtoList.add(build);
         }
      );
      List<TaskTrackingProductionLineDTO> collect = dtoList.stream()
         .map(e -> e.setRate(new BigDecimal(e.getCompleteQuantity()).divide(new BigDecimal(e.getQuantity()), 2, 4)))
         .collect(Collectors.toList());
      collect.sort(Comparator.comparing(TaskTrackingProductionLineDTO::getRate));
      return collect;
   }

   @Override
   public PageVO<TaskTrackingProductionLineDTO> taskTrackingMonthPage(
      LocalDateTime dateTime, Long workShopId, Long productionLineId, Integer pageNumber, Integer pageSize
   ) {
      List<TaskTrackingProductionLineDTO> dtoList = this.taskTrackingMonthDetail(dateTime, workShopId, productionLineId);
      return new PageVO<>(PageUtils.getPageVO(dtoList, pageNumber, pageSize));
   }

   @Override
   public List<TaskTrackingProductDTO> taskTrackingMonthProject(
      LocalDateTime dateTime, Long workShopId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      return this.taskService.taskTrackingMonthProject(dateTime, workShopId, productionLineId, projectId, monomerId, areaId, serialNumber);
   }

   @Override
   public PageVO<TaskTrackingProductDTO> taskTrackingMonthProjectPage(
      LocalDateTime dateTime,
      Long workShopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.taskTrackingMonthProject(dateTime, workShopId, productionLineId, projectId, monomerId, areaId, serialNumber)
      );
   }

   @Override
   public PrintVO<List<Map<String, Object>>> taskTrackingMonthProjectPrint(
      LocalDateTime dateTime, Long workShopId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (dateTime != null) {
         header.put("date", dateTime.getYear());
      }

      printVO.setHeader(header);
      printVO.setTable(
         this.taskTrackingMonthProject(dateTime, workShopId, productionLineId, projectId, monomerId, areaId, serialNumber)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public APPQuantityAndMeteDTO taskTrackingMonthProjectSummary(LocalDateTime dateTime, Long projectId, Long monomerId, Long areaId, String serialNumber) {
      List<TaskTrackingProductDTO> taskTrackingProductDTOS = this.taskTrackingMonthProject(dateTime, null, null, projectId, monomerId, areaId, serialNumber);
      return APPQuantityAndMeteDTO.builder()
         .quantity(taskTrackingProductDTOS.stream().mapToInt(TaskTrackingProductDTO::getQuantity).sum())
         .mete(taskTrackingProductDTOS.stream().map(TaskTrackingProductDTO::getTaskNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeMete(taskTrackingProductDTOS.stream().map(TaskTrackingProductDTO::getCompleteNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeQuantity(taskTrackingProductDTOS.stream().mapToInt(TaskTrackingProductDTO::getCompleteQuantity).sum())
         .build();
   }

   @Override
   public List<TaskProductDTO> taskProductionLineList(LocalDateTime startTime, LocalDateTime endTime, Integer productType, Integer type, Long processId) {
      return productType.equals(TaskTypeEnum.ASSEMBLE.getType())
         ? this.baseService.getTaskAssembleProductionLine(startTime, endTime, type, processId)
         : this.baseService.taskProductionLineList(startTime, endTime, productType, type, processId);
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

   @Override
   public Boolean updateNextTaskProcess(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long teamId, List<Integer> numberList) {
      int ARTIFACT_TYPE = TaskTypeEnum.ARTIFACT.getType();
      int ASSEMBLE_TYPE = TaskTypeEnum.ASSEMBLE.getType();
      int MACHINE_PART_TYPE = TaskTypeEnum.MACHINE_PART.getType();
      Integer typeEnum = taskProcess.getTaskTypeEnum();
      Map<Integer, List<MesBuildingTaskNumberLink>> numberLinksMap = new HashMap<>();
      if (typeEnum == ARTIFACT_TYPE) {
         for (MesBuildingTaskNumberLink link : this.mesBuildingTaskNumberLinkService
            .list(
               (Wrapper<MesBuildingTaskNumberLink>)(Wrappers.<MesBuildingTaskNumberLink>lambdaQuery()
                     .eq(MesBuildingTaskNumberLink::getArtifactTaskId, taskProcess.getTaskId()))
                  .in(MesBuildingTaskNumberLink::getArtifactNumber, numberList)
            )) {
            numberLinksMap.computeIfAbsent(link.getArtifactNumber(), k -> new ArrayList<>()).add(link);
         }
      } else if (typeEnum == ASSEMBLE_TYPE) {
         for (MesBuildingTaskNumberLink link : this.mesBuildingTaskNumberLinkService
            .list(
               (Wrapper<MesBuildingTaskNumberLink>)(Wrappers.<MesBuildingTaskNumberLink>lambdaQuery()
                     .eq(MesBuildingTaskNumberLink::getAssembleTaskId, taskProcess.getTaskId()))
                  .in(MesBuildingTaskNumberLink::getAssembleNumber, numberList)
            )) {
            numberLinksMap.computeIfAbsent(link.getAssembleNumber(), k -> new ArrayList<>()).add(link);
         }
      }

      this.buildProductProcess(taskProcess, teamId, numberList, numberLinksMap, typeEnum, reportQuantity);
      if (TaskTypeEnum.ARTIFACT.getType().equals(typeEnum)) {
         this.projectProductionSummaryBiz.updateProjectMeteSummary(taskProcess.getTaskId(), taskProcess.getId(), reportQuantity, null);
      }
      Integer unfinishedTaskCount = this.taskService
         .count(
            (Wrapper<MesBuildingTask>)(Wrappers.<MesBuildingTask>lambdaQuery().eq(MesBuildingTask::getTaskOrderId, taskProcess.getTaskOrderId()))
               .isNull(MesBuildingTask::getCompleteTime)
         );
      List<MesBuildingTask> taskList = this.taskService
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .eq(MesBuildingTask::getTaskOrderId, taskProcess.getTaskOrderId())
               .isNull(MesBuildingTask::getCompleteTime)
         );
      if (unfinishedTaskCount == 0) {
         LocalDateTime now = LocalDateTime.now();
         MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(taskProcess.getTaskOrderId());
         taskOrder.setCompleteTime(now);
         this.taskOrderBiz.updateById(taskOrder);
         if (typeEnum == ARTIFACT_TYPE) {
            Integer unfinishedTopTaskCount = this.taskOrderBiz
               .count(
                  (Wrapper<MesBuildingTaskOrder>)(Wrappers.<MesBuildingTaskOrder>lambdaQuery()
                        .eq(MesBuildingTaskOrder::getTopTaskOrderId, taskOrder.getTopTaskOrderId()))
                     .isNull(MesBuildingTaskOrder::getCompleteTime)
               );
            if (unfinishedTopTaskCount == 0) {
               this.topTaskOrderBiz.updateById(MesBuildingTopTaskOrder.builder().id(taskOrder.getTopTaskOrderId()).completeTime(now).build());
            }
         } else if (typeEnum == MACHINE_PART_TYPE) {
            String childGuid = taskOrder.getChildGuid();
            if (childGuid != null) {
               List<MesBuildingBoChuNestingResult> nestingResults = this.mesBuildingBoChuNestingResultService
                  .list((Wrapper<MesBuildingBoChuNestingResult>)Wrappers.<MesBuildingBoChuNestingResult>lambdaQuery().eq(MesBuildingBoChuNestingResult::getChildGuid, childGuid));
               if (!nestingResults.isEmpty()) {
                  Integer CUT_COMPLETED = CutStatusEnum.CUT_COMPLETED.getCode();
                  BigDecimal TASK_RATE = new BigDecimal("100").setScale(8, RoundingMode.HALF_UP);

                  for (MesBuildingBoChuNestingResult result : nestingResults) {
                     result.setCutStatus(CUT_COMPLETED);
                     result.setTaskRate(TASK_RATE);
                  }

                  this.mesBuildingBoChuNestingResultService.updateBatchById(nestingResults);
               }
            }
         }
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
      int ARTIFACT_TYPE = TaskTypeEnum.ARTIFACT.getType();
      int ASSEMBLE_TYPE = TaskTypeEnum.ASSEMBLE.getType();
      int MACHINE_PART_TYPE = TaskTypeEnum.MACHINE_PART.getType();
      LocalDateTime now = LocalDateTime.now();
      if (typeEnum == ARTIFACT_TYPE || typeEnum == ASSEMBLE_TYPE) {
         this.processArtifactOrAssembleType(taskProcess, teamId, numberList, numberLinksMap, typeEnum, reportQuantity, ARTIFACT_TYPE, ASSEMBLE_TYPE, now);
      } else if (typeEnum == MACHINE_PART_TYPE) {
         this.processMachinePartType(taskProcess, teamId, reportQuantity, now);
      }
   }

   private void processArtifactOrAssembleType(
      MesBuildingTaskProcess taskProcess,
      Long teamId,
      List<Integer> numberList,
      Map<Integer, List<MesBuildingTaskNumberLink>> numberLinksMap,
      Integer typeEnum,
      Integer reportQuantity,
      int ARTIFACT_TYPE,
      int ASSEMBLE_TYPE,
      LocalDateTime now
   ) {
      MesBuildingTaskNumberLink numberLink = this.getFirstNumberLink(numberLinksMap);
      if (numberLink != null) {
         Long nextProcessId = null;
         Long taskId = null;
         boolean hasNextProcess;
         if (typeEnum == ARTIFACT_TYPE) {
            hasNextProcess = numberLink.getArtifactNextProcessId() != null && numberLink.getArtifactNextProcessId() != 0L;
            nextProcessId = numberLink.getArtifactNextProcessId();
            taskId = numberLink.getArtifactTaskId();
         } else {
            hasNextProcess = numberLink.getAssembleNextProcessId() != null && numberLink.getAssembleNextProcessId() != 0L;
            nextProcessId = numberLink.getAssembleNextProcessId();
            taskId = numberLink.getAssembleTaskId();
         }

         if (hasNextProcess) {
            this.processNextProcess(taskId, nextProcessId, reportQuantity);
         } else {
            this.completeCurrentProcess(taskProcess, typeEnum, reportQuantity, ARTIFACT_TYPE, ASSEMBLE_TYPE, teamId, numberList, now);
         }
      }
   }

   private MesBuildingTaskNumberLink getFirstNumberLink(Map<Integer, List<MesBuildingTaskNumberLink>> numberLinksMap) {
      for (List<MesBuildingTaskNumberLink> links : numberLinksMap.values()) {
         if (!links.isEmpty()) {
            return links.get(0);
         }
      }

      return null;
   }

   private void processNextProcess(Long taskId, Long nextProcessId, Integer reportQuantity) {
      MesBuildingTaskProcess nextTaskProcess = this.taskProcessService
         .getOne(
            (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskId, taskId))
               .eq(MesBuildingTaskProcess::getProcessId, nextProcessId)
         );
      if (nextTaskProcess != null) {
         nextTaskProcess.setNeedQuantity(nextTaskProcess.getNeedQuantity() + reportQuantity);
         this.taskProcessService.updateById(nextTaskProcess);
      }
   }

   @Override
   public void completeCurrentProcess(
      MesBuildingTaskProcess taskProcess,
      Integer typeEnum,
      Integer reportQuantity,
      int ARTIFACT_TYPE,
      int ASSEMBLE_TYPE,
      Long teamId,
      List<Integer> numberList,
      LocalDateTime now
   ) {
      this.updateProductCompleteQuantity(taskProcess, typeEnum, reportQuantity, ARTIFACT_TYPE, ASSEMBLE_TYPE);
      this.updateTaskCompleteStatus(taskProcess, reportQuantity, now);
      this.saveCompleteReport(taskProcess, reportQuantity, teamId, numberList, typeEnum, ARTIFACT_TYPE, ASSEMBLE_TYPE);
      this.updateProductionSummary(taskProcess, reportQuantity);
      if (typeEnum == ARTIFACT_TYPE) {
         this.checkProjectCompleteStatus(taskProcess, now);
      }
   }

   private void updateProductCompleteQuantity(
      MesBuildingTaskProcess taskProcess, Integer typeEnum, Integer reportQuantity, int ARTIFACT_TYPE, int ASSEMBLE_TYPE
   ) {
      if (typeEnum == ARTIFACT_TYPE) {
         TechArtifact artifact = this.artifactService.getById(taskProcess.getProductId());
         if (artifact != null) {
            int newProducedQuantity = artifact.getProducedQuantity() + reportQuantity;
            Preconditions.checkArgument(artifact.getQuantity() >= newProducedQuantity, "操作失败!!!");
            artifact.setProducedQuantity(newProducedQuantity);
            this.artifactService.updateById(artifact);
         }
      } else if (typeEnum == ASSEMBLE_TYPE) {
         TechAssemble assemble = this.assembleService.getById(taskProcess.getProductId());
         if (assemble != null && assemble.getBoolSchedulingEnum()) {
            int newProducedQuantity = assemble.getProducedQuantity() + reportQuantity;
            Preconditions.checkArgument(assemble.getQuantity() >= newProducedQuantity, "生产数量不能大于清单数量");
            assemble.setProducedQuantity(newProducedQuantity);
            this.assembleService.updateById(assemble);
         }
      }
   }

   private void updateTaskCompleteStatus(MesBuildingTaskProcess taskProcess, Integer reportQuantity, LocalDateTime now) {
      MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
      if (task != null) {
         int newCompleteQuantity = task.getCompleteQuantity() + reportQuantity;
         Preconditions.checkArgument(task.getTaskQuantity() >= newCompleteQuantity, "操作失败!!!!");
         task.setCompleteQuantity(newCompleteQuantity);
         if (task.getTaskQuantity() == newCompleteQuantity) {
            task.setCompleteTime(now);
         }

         this.taskService.updateById(task);
      }
   }

   private void saveCompleteReport(
      MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long teamId, List<Integer> numberList, Integer typeEnum, int ARTIFACT_TYPE, int ASSEMBLE_TYPE
   ) {
      if (typeEnum != ARTIFACT_TYPE && typeEnum != ASSEMBLE_TYPE) {
         this.saveCompoleteReport(taskProcess, reportQuantity, teamId, null);
      } else {
         Preconditions.checkArgument(!CollectionUtils.isEmpty(numberList), "一物一码的构件序号不能为空");
         this.saveCompoleteReport(taskProcess, reportQuantity, teamId, numberList);
      }
   }

   private void updateProductionSummary(MesBuildingTaskProcess taskProcess, Integer reportQuantity) {
      MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
      if (task != null) {
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

   private void checkProjectCompleteStatus(MesBuildingTaskProcess taskProcess, LocalDateTime now) {
      MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
      if (task != null && !this.taskProcessService.getProjectCompleteStatus(task.getProjectId())) {
         ContractProject project = this.projectService.getById(task.getProjectId());
         if (project != null) {
            project.setMesEndDate(now);
            this.projectService.updateById(project);
         }
      }
   }

   private void processMachinePartType(MesBuildingTaskProcess taskProcess, Long teamId, Integer reportQuantity, LocalDateTime now) {
      if (taskProcess.getNextProcessId() != null) {
         this.processNextProcess(taskProcess.getTaskId(), taskProcess.getNextProcessId(), reportQuantity);
      } else {
         TechMachinePart machinePart = this.machinePartService.getById(taskProcess.getProductId());
         if (machinePart != null && machinePart.getBoolProcess()) {
            int newProducedQuantity = machinePart.getProducedQuantity() + reportQuantity;
            Preconditions.checkArgument(machinePart.getQuantity() >= newProducedQuantity, "生产数量不能大于清单数量");
            machinePart.setProducedQuantity(newProducedQuantity);
            this.machinePartService.updateById(machinePart);
         }

         this.updateTaskCompleteStatus(taskProcess, reportQuantity, now);
         this.saveCompoleteReport(taskProcess, reportQuantity, teamId, null);
         this.updateProductionSummary(taskProcess, reportQuantity);
      }
   }

   @Override
   public Boolean updateNextTaskInspectionProcess(MesBuildingTaskProcess taskProcess, Integer reportQuantity, List<TeamAndNumberDTO> numberList) {
      List<MesBuildingTaskNumberLink> numberLinks = null;
      Map<Integer, List<MesBuildingTaskNumberLink>> numberLinksMap = new HashMap<>();
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskId, taskProcess.getTaskId())
                  .in(MesBuildingTaskNumberLink::getArtifactNumber, numberList.stream().map(TeamAndNumberDTO::getNumber).collect(Collectors.toList()))
            );
         numberLinksMap = numberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
      } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getAssembleTaskId, taskProcess.getTaskId())
                  .in(MesBuildingTaskNumberLink::getAssembleNumber, numberList.stream().map(TeamAndNumberDTO::getNumber).collect(Collectors.toList()))
            );
         numberLinksMap = numberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleNumber));
      }

      Map<Integer, List<TeamAndNumberDTO>> numberMap = numberList.stream().collect(Collectors.groupingBy(TeamAndNumberDTO::getNumber));
      this.buildInspectionProductProcess(taskProcess, numberLinksMap, numberMap);
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskProcess.getTaskTypeEnum())) {
         this.projectProductionSummaryBiz.updateProjectMeteSummary(taskProcess.getTaskId(), taskProcess.getId(), reportQuantity, null);
      }
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
         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
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
      }

      return true;
   }

   private void buildInspectionProductProcess(
      MesBuildingTaskProcess taskProcess, Map<Integer, List<MesBuildingTaskNumberLink>> numberLinksMap, Map<Integer, List<TeamAndNumberDTO>> numberMap
   ) {
      numberLinksMap.forEach(
         (number, numberLinkList) -> {
            MesBuildingTaskNumberLink numberLink = numberLinkList.get(0);
            if ((!taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()) || numberLink.getArtifactTaskProcessId() == 0L)
               && (!taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()) || numberLink.getAssembleTaskProcessId() == 0L)) {
               if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
                  TechArtifact artifact = this.artifactService.getById(taskProcess.getProductId());
                  artifact.setProducedQuantity(artifact.getProducedQuantity() + 1);
                  Preconditions.checkArgument(artifact.getQuantity() >= artifact.getProducedQuantity(), "操作失败!!!");
                  this.artifactService.updateById(artifact);
               } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                  TechAssemble assemble = this.assembleService.getById(taskProcess.getProductId());
                  if (assemble.getBoolSchedulingEnum()) {
                     Preconditions.checkArgument(assemble.getProducedQuantity() + 1 <= assemble.getQuantity(), "生产数量不能大于清单数量");
                     assemble.setProducedQuantity(assemble.getProducedQuantity() + 1);
                     Preconditions.checkArgument(assemble.getQuantity() >= assemble.getProducedQuantity(), "操作失败!!!");
                     this.assembleService.updateById(assemble);
                  }
               } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
                  TechMachinePart machinePart = this.machinePartService.getById(taskProcess.getProductId());
                  if (machinePart.getBoolProcess()) {
                     Preconditions.checkArgument(machinePart.getProducedQuantity() + 1 <= machinePart.getQuantity(), "生产数量不能大于清单数量");
                     machinePart.setProducedQuantity(machinePart.getProducedQuantity() + 1);
                     this.machinePartService.updateById(machinePart);
                  }
               }

               MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
               task.setCompleteQuantity(task.getCompleteQuantity() + 1);
               Preconditions.checkArgument(task.getTaskQuantity() >= task.getCompleteQuantity(), "操作失败!!!!");
               if (task.getTaskQuantity().equals(task.getCompleteQuantity())) {
                  task.setCompleteTime(LocalDateTime.now());
               }

               this.taskService.updateById(task);
               if (!taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())
                  && !taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                  Preconditions.checkArgument(false, "零件暂无任务!");
                  this.saveCompoleteInspectionReport(taskProcess, 1, null, null);
               } else {
                  Integer numberKey = taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())
                     ? numberLink.getAssembleNumber()
                     : numberLink.getArtifactNumber();
                  List<TeamAndNumberDTO> teamAndNumberDTOS = numberMap.get(numberKey);
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamAndNumberDTOS), "一物一码的构件序号不能为空");
                  this.saveCompoleteInspectionReport(taskProcess, 1, null, teamAndNumberDTOS);
               }

               this.productionSummaryService
                  .updateRecord(
                     ProductProductionSummaryDTOParam.builder()
                        .projectId(task.getProjectId())
                        .monomerId(task.getMonomerId())
                        .productId(task.getProductId())
                        .productType(task.getTaskTypeEnum())
                        .completeQuantity(1)
                        .build()
                  );
               if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())
                  && !this.taskProcessService.getProjectCompleteStatus(task.getProjectId())) {
                  ContractProject project = this.projectService.getById(task.getProjectId());
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

   Boolean produceInspectionTeamReport(MesBuildingTaskProcess mesBuildingTaskProcess, Integer reportQuantity, Long teamId, List<Integer> numberList) {
      mesBuildingTaskProcess.setInspectionQuantity(mesBuildingTaskProcess.getInspectionQuantity() + reportQuantity);
      Preconditions.checkArgument(this.taskProcessService.updateById(mesBuildingTaskProcess), "质检中,请刷新页面");
      this.updateNextTaskProcess(mesBuildingTaskProcess, reportQuantity, teamId, numberList);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteInspection(MesBuildingInspectionTeam inspectionTeam) {
      List<MesBuildingInspectionTeam> inspectionTeamList = this.inspectionTeamService
         .list(
            (Wrapper<MesBuildingInspectionTeam>)(Wrappers.<MesBuildingInspectionTeam>lambdaQuery().ne(MesBuildingInspectionTeam::getId, inspectionTeam.getId()))
               .eq(MesBuildingInspectionTeam::getProcessId, inspectionTeam.getProcessId())
         );
      if (inspectionTeamList.size() == 0) {
         List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService.listTaskProcessInspection(null, inspectionTeam.getProcessId());
         taskProcessList.forEach(
            e -> {
               Integer reportQuantity = e.getCompleteQuantity() - e.getInspectionQuantity() - e.getProblemQuantity();
               if (e.getCompleteQuantity().equals(e.getNeedQuantity())) {
                  e.setAskCompleteTime(LocalDateTime.now());
               }

               List<MesBuildingProduceTeamReport> teamReportList = this.produceTeamReportService
                  .list(
                     (Wrapper<MesBuildingProduceTeamReport>)((Wrappers.<MesBuildingProduceTeamReport>lambdaQuery()
                              .eq(MesBuildingProduceTeamReport::getTaskProcessId, e.getId()))
                           .eq(MesBuildingProduceTeamReport::getProcessId, inspectionTeam.getProcessId()))
                        .orderByAsc(MesBuildingProduceTeamReport::getId)
                  )
                  .stream()
                  .filter(team -> team.getQuantity() > team.getInspectionQuantity())
                  .collect(Collectors.toList());
               teamReportList.forEach(
                  teamReport -> {
                     this.saveProduceTeamReportSummary(
                        this.taskProcessService.getById(teamReport.getTaskProcessId()),
                        teamReport.getQuantity() - teamReport.getInspectionQuantity(),
                        teamReport.getGroupsId(),
                        teamReport.getTeamId(),
                        SaveProduceTeamReportSummaryTypeEnum.INSPECTION_REPORT.getType()
                     );
                     this.taskProcessService
                        .updateById(e.setInspectionQuantity(e.getInspectionQuantity() + (teamReport.getQuantity() - teamReport.getInspectionQuantity())));
                     this.updateNextTaskProcess(
                        e,
                        teamReport.getQuantity() - teamReport.getInspectionQuantity(),
                        teamReport.getTeamId(),
                        teamReportList.stream()
                           .filter(temp -> temp.getNumber() != null)
                           .map(MesBuildingProduceTeamReport::getNumber)
                           .collect(Collectors.toList())
                     );
                     teamReport.setInspectionQuantity(teamReport.getQuantity());
                     this.produceTeamReportService.updateById(teamReport);
                  }
               );
            }
         );
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteInspection(Long groupsId, Long processId) {
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .eq(MesBuildingTaskProcess::getGroupsId, groupsId)
               .eq(MesBuildingTaskProcess::getProcessId, processId)
               .apply("complete_quantity >(inspection_quantity + problem_quantity )")
         );
      if (CollectionUtils.isEmpty(taskProcessList)) {
         return true;
      }

      List<Long> productIds = taskProcessList.stream().map(MesBuildingTaskProcess::getProductId).distinct().collect(Collectors.toList());
      Integer taskTypeEnum = taskProcessList.get(0).getTaskTypeEnum();
      this.taskBiz.checkProductStatus(productIds, taskTypeEnum);
      List<Long> taskProcessIds = taskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList());
      List<MesBuildingProduceTeamReport> allTeamReportList = this.produceTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .in(MesBuildingProduceTeamReport::getTaskProcessId, taskProcessIds)
               .eq(MesBuildingProduceTeamReport::getProcessId, processId)
               .orderByAsc(MesBuildingProduceTeamReport::getId)
         )
         .stream()
         .filter(team -> team.getQuantity() > team.getInspectionQuantity())
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingProduceTeamReport>> teamReportMap = allTeamReportList.stream()
         .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskProcessId));
      Map<Long, Integer> priceMap = new HashMap<>();

      for (MesBuildingTaskProcess taskProcess : taskProcessList) {
         if (taskProcess.getCompleteQuantity().equals(taskProcess.getNeedQuantity())) {
            taskProcess.setAskCompleteTime(LocalDateTime.now());
         }

         List<MesBuildingProduceTeamReport> teamReportList = teamReportMap.get(taskProcess.getId());
         if (CollectionUtils.isNotEmpty(teamReportList)) {
            for (MesBuildingProduceTeamReport teamReport : teamReportList) {
               this.saveProduceTeamReportSummary(
                  this.taskProcessService.getById(teamReport.getTaskProcessId()),
                  teamReport.getQuantity() - teamReport.getInspectionQuantity(),
                  teamReport.getGroupsId(),
                  teamReport.getTeamId(),
                  SaveProduceTeamReportSummaryTypeEnum.INSPECTION_REPORT.getType()
               );
               this.taskProcessService
                  .updateById(
                     taskProcess.setInspectionQuantity(taskProcess.getInspectionQuantity() + (teamReport.getQuantity() - teamReport.getProblemQuantity()))
                  );
               this.updateNextTaskProcess(
                  taskProcess,
                  teamReport.getQuantity() - teamReport.getInspectionQuantity(),
                  teamReport.getTeamId(),
                  Collections.singletonList(teamReport.getNumber())
               );
               teamReport.setInspectionQuantity(teamReport.getQuantity());
               this.produceTeamReportService.updateById(teamReport);
               priceMap.put(teamReport.getId(), teamReport.getQuantity() - teamReport.getProblemQuantity());
            }

            List<Integer> inspectNumbers = teamReportList.stream().map(s -> s.getNumber()).collect(Collectors.toList());
            Long nextProcessId = 0L;
            if (taskProcess.getNextProcessId() != null) {
               MesBuildingTaskProcess nextProcess = this.taskProcessService
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                        .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId())
                        .eq(MesBuildingTaskProcess::getProcessId, taskProcess.getNextProcessId())
                  );
               nextProcessId = nextProcess.getId();
            }

            if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
               List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                        .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcess.getId())
                        .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, true)
                        .in(MesBuildingTaskNumberLink::getArtifactNumber, inspectNumbers)
                  );
               List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList());
               Preconditions.checkArgument(numbers.size() == inspectNumbers.size(), "操作失败!!!请刷新页面后重试!!!!");

               for (MesBuildingTaskNumberLink numberLink : numberLinks) {
                  numberLink.setArtifactTaskProcessId(nextProcessId);
                  numberLink.setBoolArtifactReport(Boolean.FALSE);
                  numberLink.setBoolArtifactInspection(Boolean.FALSE);
                  numberLink.setBoolArtifactComplete(nextProcessId == 0L);
               }

               this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
            } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
               List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                        .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcess.getId())
                        .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, true)
                        .in(MesBuildingTaskNumberLink::getAssembleNumber, inspectNumbers)
                  );
               List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
               Preconditions.checkArgument(numbers.size() == inspectNumbers.size(), "操作失败!!!请刷新页面后重试!!!!");

               for (MesBuildingTaskNumberLink numberLink : numberLinks) {
                  numberLink.setAssembleTaskProcessId(nextProcessId);
                  numberLink.setBoolAssembleReport(Boolean.FALSE);
                  numberLink.setBoolAssembleInspection(Boolean.FALSE);
                  numberLink.setBoolAssembleComplete(nextProcessId == 0L);
               }

               this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
            }
         }
      }

      this.teamReportBiz.savePiceByData(priceMap);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
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
            .userId(UserUtil.getCurrentUserId())
            .schedulingId(taskProcess.getSchedulingId())
            .build();
         if (type.equals(SaveProduceTeamReportSummaryTypeEnum.UN_INSPECTION_REPORT.getType())) {
            summary.setInspectionQuantity(reportQuantity);
         }

         this.produceTeamReportSummaryService.save(summary);
      }

      return true;
   }

   @Override
   public List<MesBuildingTaskProcessDTO> listProductTask(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      String material,
      Long taskOrderId,
      Boolean boolCompleteEnum
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         if (projectId != null) {
            projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
         }

         if (projectIds.size() == 0) {
            return new ArrayList<>();
         }

         List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
         return this.taskProcessService
            .selectListByTeamListAndProjectIdList(
               teamIds, projectIds, monomerId, areaId, taskTypeEnum, serialNumber, material, null, null, boolCompleteEnum, processId, null
            )
            .stream()
            .map(
               e -> {
                  MesBuildingTaskProcessDTO dto = BeanUtil.copy(e, MesBuildingTaskProcessDTO.class).setTaskType(1);
                  if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())
                     && dto.getCodingType().equals(CodingTypeEnum.SINGLE.getType())
                     && !dto.getSequence().equals(0)) {
                     if (boolCompleteEnum) {
                        dto.setArtifactNumberList(
                           this.produceTeamReportService
                              .artifactTaskLogList(
                                 this.taskProcessService
                                    .getOne(
                                       (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery()
                                             .eq(MesBuildingTaskProcess::getTaskId, dto.getTaskId()))
                                          .eq(MesBuildingTaskProcess::getSequence, dto.getSequence())
                                    )
                                    .getId(),
                                 dto.getId(),
                                 null
                              )
                              .stream()
                              .map(number -> BeanUtil.copy(number, AppTaskProcessArtifactNumberDTO.class))
                              .collect(Collectors.toList())
                        );
                     } else {
                        dto.setArtifactNumberList(
                           this.produceTeamReportService
                              .artifactTaskList(
                                 this.taskProcessService
                                    .getOne(
                                       (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery()
                                             .eq(MesBuildingTaskProcess::getTaskId, dto.getTaskId()))
                                          .eq(MesBuildingTaskProcess::getSequence, dto.getSequence() - 1)
                                    )
                                    .getId(),
                                 dto.getId(),
                                 null
                              )
                              .stream()
                              .map(number -> BeanUtil.copy(number, AppTaskProcessArtifactNumberDTO.class))
                              .collect(Collectors.toList())
                        );
                     }
                  }

                  return dto;
               }
            )
            .collect(Collectors.toList());
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public PageVO<MesBuildingTaskProcessDTO> productTaskPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      String material,
      Long taskOrderId,
      String productionLineName,
      String productName,
      Boolean boolCompleteEnum,
      String sort,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && !teamList.isEmpty()) {
         if (projectId != null) {
            projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
         }

         if (projectIds.isEmpty()) {
            return new PageVO<>();
         }

         List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
         PageHelper.startPage(pageNumber, pageSize);
         List<MesBuildingTaskProcessDO> mesBuildingTaskProcessDOS = this.taskProcessService
            .selectListByTeamListAndProjectIdList(
               teamIds, projectIds, monomerId, areaId, taskTypeEnum, serialNumber, material, productionLineName, productName, boolCompleteEnum, processId, null
            );
         PageVO pageVO = new PageVO<>(mesBuildingTaskProcessDOS);
         if (CollectionUtils.isEmpty(mesBuildingTaskProcessDOS)) {
            return pageVO;
         }

         List<Long> productIds = mesBuildingTaskProcessDOS.stream().map(MesBuildingTaskProcessDO::getProductId).distinct().collect(Collectors.toList());
         List<ArtifactAssociationCount> assList = this.assembleDetailService.getArtifactPartConvertCounts(productIds);
         List<ArtifactAssociationCount> partList = this.artifactMachinePartLinkService.getArtifactPartConvertCounts(productIds);
         assList.addAll(partList);
         Map<Long, List<ArtifactAssociationCount>> assciationMap = assList.stream().collect(Collectors.groupingBy(ArtifactAssociationCount::getArtifactId));
         List<Long> taskIdList = mesBuildingTaskProcessDOS.stream().map(MesBuildingTaskProcessDO::getTaskId).collect(Collectors.toList());
         Map<Long, List<Integer>> map = new HashMap<>();
         if (boolCompleteEnum) {
            List<Long> AllProcessIds = mesBuildingTaskProcessDOS.stream().map(MesBuildingTaskProcessDO::getId).collect(Collectors.toList());
            List<MesBuildingArtifactTaskProcessDO> processDOS = this.produceTeamReportService.artifactTaskLogLists(AllProcessIds, null, null);
            Map<Long, List<MesBuildingArtifactTaskProcessDO>> processMap = processDOS.stream()
               .collect(Collectors.groupingBy(MesBuildingArtifactTaskProcessDO::getId));

            for (Long id : processMap.keySet()) {
               List<Integer> numbers = processMap.get(id).stream().map(s -> s.getNumber()).collect(Collectors.toList());
               map.put(id, numbers);
            }
         } else {
            List<Long> AllProcessIds = mesBuildingTaskProcessDOS.stream()
               .filter(s -> !s.getSequence().equals(0))
               .map(MesBuildingTaskProcessDO::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(AllProcessIds)) {
               Map<Long, List<MesBuildingProduceTeamReport>> reports = this.produceTeamReportService
                  .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).in(MesBuildingProduceTeamReport::getTaskProcessId, AllProcessIds))
                  .stream()
                  .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskProcessId));
               List<ProcessAndLastProcesLinkDTO> links = this.taskProcessService.listLastProcess(AllProcessIds);
               Map<Long, Long> linkMap = links.stream()
                  .collect(Collectors.toMap(ProcessAndLastProcesLinkDTO::getLastProcessId, ProcessAndLastProcesLinkDTO::getProcessId));
               List<Long> lastIds = links.stream().map(ProcessAndLastProcesLinkDTO::getLastProcessId).collect(Collectors.toList());
               Map<Long, List<MesBuildingProduceTeamReport>> lastReports = this.produceTeamReportService
                  .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).in(MesBuildingProduceTeamReport::getTaskProcessId, lastIds))
                  .stream()
                  .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskProcessId));

               for (Long id : lastReports.keySet()) {
                  List<Integer> numbers = reports.get(linkMap.get(id)) == null
                     ? new ArrayList<>()
                     : reports.get(linkMap.get(id)).stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
                  List<Integer> lastNumbers = lastReports.get(id).stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
                  lastNumbers.removeAll(numbers);
                  map.put(linkMap.get(id), lastNumbers);
               }
            }
         }

         List<MesBuildingTaskProcessDTO> dtos = mesBuildingTaskProcessDOS.stream()
            .map(
               e -> {
                  MesBuildingTaskProcessDTO dto = BeanUtil.copy(e, MesBuildingTaskProcessDTO.class).setTaskType(1);
                  if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()) && dto.getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
                     if (boolCompleteEnum) {
                        dto.setArtifactNumberList(
                           map.get(dto.getId())
                              .stream()
                              .map(number -> AppTaskProcessArtifactNumberDTO.builder().number(number).serialNumber(dto.getSerialNumber()).build())
                              .collect(Collectors.toList())
                        );
                     } else if (!dto.getSequence().equals(0)) {
                        dto.setArtifactNumberList(
                           map.get(dto.getId())
                              .stream()
                              .map(number -> AppTaskProcessArtifactNumberDTO.builder().number(number).serialNumber(dto.getSerialNumber()).build())
                              .collect(Collectors.toList())
                        );
                     }
                  }

                  if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()) && dto.getSequence().equals(0)) {
                     List<ArtifactAssociationCount> artifactAssociationCounts = assciationMap.get(dto.getProductId());
                     Integer min = dto.getNeedQuantity() - dto.getCompleteQuantity();
                     if (CollectionUtils.isNotEmpty(artifactAssociationCounts)) {
                        for (ArtifactAssociationCount artifactAssociationCount : artifactAssociationCounts) {
                           if (min > artifactAssociationCount.getUnusedQuantity() / artifactAssociationCount.getQuantity()) {
                              min = artifactAssociationCount.getUnusedQuantity() / artifactAssociationCount.getQuantity();
                           }
                        }
                     }

                     dto.setProducibleQuantity(min);
                  } else {
                     dto.setProducibleQuantity(dto.getNeedQuantity() - dto.getCompleteQuantity());
                  }

                  return dto;
               }
            )
            .collect(Collectors.toList());
         pageVO.setContent(dtos);
         return pageVO;
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PageVO<APPTaskProcessInspectionDTO> productTaskInspectionPage2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId,
      String sort,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      List<MesBuildingGroupsTreeDO> groupsTreeList = this.groupsBiz.getGroupsListInspection(null);
      if (groupsTreeList.size() == 0) {
         return new PageVO<>();
      }

      if (pageNumber != null && pageSize != null) {
         PageHelper.startPage(pageNumber, pageSize);
      }

      List<APPTaskProcessInspectionDO> taskProcessList = this.taskProcessService
         .selectInspectionListByTeamList(groupsTreeList, projectIds, monomerId, areaId, processId, taskTypeEnum, serialNumber, productName, taskId);
      PageVO PageVO = new PageVO<>(taskProcessList);
      if (CollectionUtils.isEmpty(taskProcessList)) {
         return PageVO;
      }

      List<Long> taskIds = taskProcessList.stream().map(APPTaskProcessInspectionDO::getTaskId).collect(Collectors.toList());
      Map<Long, Boolean> taskOneCodeMap = this.taskService
         .listByIds(taskIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingTask::getId, MesBuildingTask::getBoolOneCode));
      List<APPTaskProcessInspectionDTO> collect = taskProcessList.stream()
         .map(
            e -> {
               APPTaskProcessInspectionDTO dto = BeanUtil.copy(e, APPTaskProcessInspectionDTO.class)
                  .setTaskType(e.getProductionLine().getId().equals(e.getTeamProductionLineId()) ? 2 : 1);
               if (e.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()) || e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                  dto.setBoolOneCode(taskOneCodeMap.get(dto.getTaskId()));
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
      PageVO.setContent(collect);
      return PageVO;
   }

   @Override
   public PageVO<APPTaskProcessInspectionDTO> productTaskInspectionPage3(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId,
      Integer reportType,
      String sort,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      List<MesInspectConfigUserLink> inspectConfigs = this.inspectConfigUserLinkService
         .list(Wrappers.lambdaQuery(MesInspectConfigUserLink.class).eq(MesInspectConfigUserLink::getInspectUserId, UserUtil.getCurrentUserId()));
      if (CollectionUtils.isEmpty(inspectConfigs)) {
         return new PageVO<>();
      }

      List<Long> inspectConfigIds = inspectConfigs.parallelStream().map(MesInspectConfigUserLink::getInspectConfigId).collect(Collectors.toList());
      List<MesBuildingProductionLineTreeDO> treeDOS = this.productionLineBiz.getInspectTeamLink(inspectConfigIds);
      Map<Long, List<Long>> classMap = this.classificationConfigLinkService
         .list(Wrappers.lambdaQuery(MesInspectClassificationConfigLink.class).in(MesInspectClassificationConfigLink::getInspectConfigId, inspectConfigIds))
         .stream()
         .collect(Collectors.groupingBy(s -> s.getInspectConfigId(), Collectors.mapping(s -> s.getClassificationId(), Collectors.toList())));
      treeDOS.forEach(tree -> tree.setClassIds(classMap.get(tree.getId())));
      if (pageNumber != null && pageSize != null) {
         PageHelper.startPage(pageNumber, pageSize);
      }

      List<APPTaskProcessInspectionDO> taskProcessList = this.taskProcessService
         .selectInspectionListByTeamList2(treeDOS, projectIds, monomerId, areaId, areaBatchId, processId, taskTypeEnum, serialNumber, productName, taskId);
      PageVO PageVO = new PageVO<>(taskProcessList);
      if (CollectionUtils.isEmpty(taskProcessList)) {
         return new PageVO<>();
      }

      if (reportType != null && reportType.equals(3) || reportType.equals(2)) {
         taskProcessList = taskProcessList.stream().filter(e -> e.getInspectType() == reportType).collect(Collectors.toList());
      }

      if (CollectionUtils.isEmpty(taskProcessList)) {
         return new PageVO<>();
      }

      List<Long> taskIds = taskProcessList.stream().map(APPTaskProcessInspectionDO::getTaskId).collect(Collectors.toList());
      Map<Long, Boolean> taskOneCodeMap = this.taskService
         .listByIds(taskIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingTask::getId, MesBuildingTask::getBoolOneCode));
      List<APPTaskProcessInspectionDTO> collect = taskProcessList.stream()
         .map(
            e -> {
               APPTaskProcessInspectionDTO dto = BeanUtil.copy(e, APPTaskProcessInspectionDTO.class)
                  .setTaskType(e.getProductionLine().getId().equals(e.getTeamProductionLineId()) ? 2 : 1);
               if (e.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()) || e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                  dto.setBoolOneCode(taskOneCodeMap.get(dto.getTaskId()));
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
      PageVO.setContent(collect);
      return PageVO;
   }

   @Override
   public List<APPTaskProcessInspectionDTO> productTaskInspectionList2(
      Long projectId, Long monomerId, Long areaId, Long processId, Integer taskTypeEnum, String serialNumber, String productName, Long taskId, String sort
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesBuildingInspectionTeam> teamList = this.utilsBiz.selectInspectionTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> groupsIdList = this.groupsInspectionTeamLinkBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingGroupsInspectionTeamLink.class)
                  .in(
                     MesBuildingGroupsInspectionTeamLink::getInspectionTeamId,
                     teamList.stream().map(MesBuildingInspectionTeam::getId).collect(Collectors.toList())
                  )
            )
            .stream()
            .map(MesBuildingGroupsInspectionTeamLink::getGroupsId)
            .collect(Collectors.toList());
         if (groupsIdList != null && groupsIdList.size() != 0) {
            List<MesBuildingGroupsTreeDO> groups = this.groupsBiz
               .getGroupsListInspection(null)
               .stream()
               .filter(e -> groupsIdList.contains(e.getId()))
               .collect(Collectors.toList());
            if (groups != null && groups.size() != 0) {
               if (projectId != null) {
                  projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
               }

               if (projectIds.size() == 0) {
                  return new ArrayList<>();
               }

               List<MesBuildingGroupsTreeDO> groupsTreeList = this.groupsBiz.getGroupsListInspection(null);
               return groupsTreeList.size() == 0
                  ? new ArrayList<>()
                  : this.taskProcessService
                     .selectInspectionListByTeamList(groupsTreeList, projectIds, monomerId, areaId, processId, taskTypeEnum, serialNumber, productName, taskId)
                     .stream()
                     .map(
                        e -> {
                           APPTaskProcessInspectionDTO dto = BeanUtil.copy(e, APPTaskProcessInspectionDTO.class)
                              .setTaskType(e.getProductionLine().getId().equals(e.getTeamProductionLineId()) ? 2 : 1);
                           if (e.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
                              dto.setBoolOneCode(CodingTypeEnum.SINGLE.getType().equals(e.getCodingType()));
                           }

                           return dto;
                        }
                     )
                     .collect(Collectors.toList());
            } else {
               return new ArrayList<>();
            }
         } else {
            return new ArrayList<>();
         }
      } else {
         return new ArrayList<>();
      }
   }

   @Override
   public List<APPTaskProcessInspectionDTO> productTaskInspectionList3(
      List<Long> inspectConfigIds,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId,
      String sort
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectId != null) {
         projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
      }

      if (projectIds.size() == 0) {
         return new ArrayList<>();
      }

      List<MesBuildingProductionLineTreeDO> treeDOS = null;
      if (CollectionUtils.isNotEmpty(inspectConfigIds)) {
         treeDOS = this.productionLineBiz.getInspectTeamLink(inspectConfigIds);
         Map<Long, List<Long>> classMap = this.classificationConfigLinkService
            .list(Wrappers.lambdaQuery(MesInspectClassificationConfigLink.class).in(MesInspectClassificationConfigLink::getInspectConfigId, inspectConfigIds))
            .stream()
            .collect(Collectors.groupingBy(s -> s.getInspectConfigId(), Collectors.mapping(s -> s.getClassificationId(), Collectors.toList())));
         treeDOS.forEach(s -> s.setClassIds(classMap.get(s.getId())));
      }

      return treeDOS.size() == 0
         ? new ArrayList<>()
         : this.taskProcessService
            .selectInspectionListByTeamList2(treeDOS, projectIds, monomerId, areaId, null, processId, taskTypeEnum, serialNumber, productName, taskId)
            .stream()
            .map(
               e -> {
                  APPTaskProcessInspectionDTO dto = BeanUtil.copy(e, APPTaskProcessInspectionDTO.class)
                     .setTaskType(e.getProductionLine().getId().equals(e.getTeamProductionLineId()) ? 2 : 1);
                  if (e.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
                     dto.setBoolOneCode(this.utilsBiz.getBoolOneCode(dto.getProductId()));
                  }

                  return dto;
               }
            )
            .collect(Collectors.toList());
   }

   @Override
   public PageVO<APPTaskProcessInspectionDTO> productTaskInspectionPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId,
      String sort,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
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
         if (projectIds.size() == 0) {
            return new PageVO<>();
         }
      }

      List<MesBuildingInspectionTeam> inspectionTeamList = this.utilsBiz.selectInspectionTeamIdByUserId(UserUtil.getCurrentUserId());
      if (inspectionTeamList == null) {
         return new PageVO<>();
      }

      List<MesBuildingGroupsTreeDO> groupsList = this.groupsBiz.getGroupsListInspection(null);
      if (groupsList == null) {
         return new PageVO<>();
      }

      if (pageNumber != null && pageSize != null) {
         PageHelper.startPage(pageNumber, pageSize);
      }

      return new PageVO<>(
         this.taskProcessService
            .selectInspectionListByTeamListAndProjectIdList(
               inspectionTeamList.stream().map(MesBuildingInspectionTeam::getProcessId).collect(Collectors.toList()),
               groupsList.stream().map(MesBuildingGroupsTreeDO::getId).collect(Collectors.toList()),
               projectIds,
               monomerId,
               areaId,
               processId,
               taskTypeEnum,
               serialNumber,
               productName,
               taskId
            )
            .stream()
            .map(
               e -> {
                  APPTaskProcessInspectionDTO dto = BeanUtil.copy(e, APPTaskProcessInspectionDTO.class)
                     .setTaskType(e.getProductionLine().getId().equals(e.getTeamProductionLineId()) ? 2 : 1);
                  if (e.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
                     dto.setBoolOneCode(this.utilsBiz.getBoolOneCode(dto.getProductId()));
                  }

                  return dto;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public Map<String, Integer> listProductTaskCount2(Long userId) {
      Map<String, Integer> taskMap = new HashMap<>();
      List<MesBuildingQhseDO> doList = this.mesBuildingQhseService
         .selectListByCondition(null, null, null, null, null, null, null, null, true, userId, null, null, null, null, 4, null, null, null)
         .stream()
         .filter(e -> e.getStatus() != 4 && e.getStatus() != 32)
         .collect(Collectors.toList());
      int qhse = QhseTypeEnum.QUALITY.getType() | QhseTypeEnum.SPECIAL_QUALITY.getType() | QhseTypeEnum.SPOT_CHECK.getType();
      int safeEnvironment = QhseTypeEnum.SECURITY.getType() | QhseTypeEnum.ENVIRONMENT.getType();
      taskMap.put("mesQhse", (int)doList.stream().filter(s -> (s.getType() & qhse) != 0).count());
      taskMap.put("safeEnvironmentQhse", (int)doList.stream().filter(s -> (s.getType() & safeEnvironment) != 0).count());
      taskMap.put("siteQhse", 0);
      taskMap.put("siteInstallAudit", 0);
      taskMap.put("siteVisaAudit", 0);
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      Integer assemble = 0;
      Integer artifact = 0;
      Integer assistAssemble = 0;
      Integer assistArtifact = 0;
      Integer unInspectionCun = 0;
      Integer enclosureManufacture = 0;
      Integer machinePart = 0;
      Integer machinePartDrill = 0;
      Integer assembleInspection = 0;
      Integer artifactInspection = 0;
      Integer enclosureInspection = 0;
      Integer machinePartInspection = 0;
      Integer acceptOnDeviation = 0;
      Integer manualCutting = 0;
      Integer cncCutting = 0;
      Integer drillHoleTask = 0;
      Integer structuralSteelCutting = 0;
      Integer rawMaterialApplicationApprove = 0;
      Integer weldTask = 0;
      List<CappCraftCardProductAppVO> cappCraftCardProductAppVOS = this.techCappCraftProductTaskBiz
         .productList(
            CappCraftCardProductAppListDTO.builder()
               .pageNumber(1)
               .pageSize(Integer.MAX_VALUE)
               .techCappProductTaskWorkType(TechCappProductTaskWorkTypeEnum.UNSTART.getType())
               .build()
         )
         .getContent();
      if (CollectionUtils.isNotEmpty(cappCraftCardProductAppVOS)) {
         weldTask = cappCraftCardProductAppVOS.stream().map(CappCraftCardProductAppVO::getProductQuantity).reduce(0, Integer::sum);
      }

      if (CollectionUtils.isNotEmpty(projectIds)) {
         List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(userId);
         assistArtifact = this.assistTaskCount2(TaskTypeEnum.ARTIFACT.getType());
         assistAssemble = this.assistTaskCount2(TaskTypeEnum.ASSEMBLE.getType());
         unInspectionCun = this.produceTeamReportService.unInspectionCun2(TaskTypeEnum.ASSEMBLE.getType())
            + this.produceTeamReportService.unInspectionCun(TaskTypeEnum.ASSEMBLE.getType());
         WmsApproveRecordDTOParam wmsApproveRecordDTOParam = new WmsApproveRecordDTOParam();
         wmsApproveRecordDTOParam.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
         wmsApproveRecordDTOParam.setApproveProcessType(ApproveProcessTypeEnumV2.MES_MACHINE_PART.getType());
         wmsApproveRecordDTOParam.setWaitMeCheck(Boolean.TRUE);
         PageVO<WmsApproveRecordDTO> pageVO = this.wmsApproveRecordService.getList(wmsApproveRecordDTOParam, 1, Integer.MAX_VALUE, null, 0);
         rawMaterialApplicationApprove = pageVO.getContent().size();
         if (CollectionUtils.isNotEmpty(teamList)) {
            assemble = this.taskOrderList2(null, 48, null, null).size();
            artifact = this.taskOrderList2(null, TaskTypeEnum.ARTIFACT.getType(), null, null).size();
            machinePart = this.taskOrderList2(null, TaskTypeEnum.MACHINE_PART.getType(), null, null).size();
            machinePartDrill = this.drillTaskOrderList2().size();
            List<AppTaskOrderSummaryDTO> appTaskOrderSummaryDTOList = this.taskOrderList2(null, TaskTypeEnum.MACHINE_PART.getType(), null, null);

            for (AppTaskOrderSummaryDTO e : appTaskOrderSummaryDTOList) {
               if (e.getOrderNumber().contains("(套)")) {
                  int jobId = e.getJobId().intValue();
                  List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
                     .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
                  if (CollectionUtils.isNotEmpty(mesBuildingBoChuJobDirectoryList)) {
                     cncCutting = cncCutting + 1;
                  }
               }
            }

            manualCutting = appTaskOrderSummaryDTOList.stream().filter(e -> e.getOrderNumber().contains("(直)")).collect(Collectors.toList()).size();
            structuralSteelCutting = appTaskOrderSummaryDTOList.stream().filter(e -> e.getOrderNumber().contains("(型)")).collect(Collectors.toList()).size();
            drillHoleTask = this.drillTaskOrderList().size();
         }

         List<MesInspectConfigUserLink> inspectConfigs = this.inspectConfigUserLinkService
            .list(Wrappers.lambdaQuery(MesInspectConfigUserLink.class).eq(MesInspectConfigUserLink::getInspectUserId, UserUtil.getCurrentUserId()));
         if (CollectionUtils.isNotEmpty(inspectConfigs)) {
            List<Long> inspectConfigIds = inspectConfigs.stream().map(MesInspectConfigUserLink::getInspectConfigId).collect(Collectors.toList());
            assembleInspection = this.productTaskInspectionList3(
                  inspectConfigIds, null, null, null, null, TaskTypeEnum.ASSEMBLE.getType(), null, null, null, null
               )
               .size();
            artifactInspection = this.productTaskInspectionList3(
                  inspectConfigIds, null, null, null, null, TaskTypeEnum.ARTIFACT.getType(), null, null, null, null
               )
               .size();
         }

         Map<Integer, Integer> projectQuantityMap = this.projectInstallBiz
            .getUserTaskQuantity()
            .stream()
            .collect(Collectors.toMap(ProjectManageModeTaskDTO::getModeTask, ProjectManageModeTaskDTO::getQuantity));
         taskMap.put("siteQhse", projectQuantityMap.getOrDefault(ProjectManageMenuTaskEnum.SAFETY.getType(), 0));
         taskMap.put("siteInstallAudit", projectQuantityMap.getOrDefault(ProjectManageMenuTaskEnum.INSTALL_AUDIT.getType(), 0));
         taskMap.put("siteVisaAudit", projectQuantityMap.getOrDefault(ProjectManageMenuTaskEnum.VISA_AUDIT.getType(), 0));
         Boolean hasPermission = this.userRoleLinkService.whetherUserHasPermission(UserUtil.getCurrentUserId(), "concessionAuditing");
         if (hasPermission || UserUtil.getCurrentUser().isAdmin()) {
            acceptOnDeviation = this.qhseAcceptDeviationService
               .count(
                  Wrappers.lambdaQuery(MesBuildingQhseAcceptDeviation.class)
                     .eq(MesBuildingQhseAcceptDeviation::getStatus, AcceptDeviationStatusEnum.UNAUDITED.getType())
               );
         }
      }

      enclosureManufacture = this.mesEnclosureTaskBiz.taskOrder(null, null, null, null, null).size();
      int safetyEnvInspectionTask = 0;
      ProjectInspectionUser projectInspectionUser = this.projectInspectionUserService
         .getOne(Wrappers.lambdaQuery(ProjectInspectionUser.class).eq(ProjectInspectionUser::getStatus, true).eq(ProjectInspectionUser::getUserId, userId));
      if (projectInspectionUser != null) {
         LocalTime localTime = LocalDateTime.now().toLocalTime();
         if (projectInspectionUser.getAvoidTime() != null) {
            Integer avoidTime = projectInspectionUser.getAvoidTime();
            int value = LocalDateTime.now().getDayOfWeek().getValue();
            if (avoidTime.equals(AvoidTimeEnum.AVOID_SATURDAY.getType())
               && value != 6
               && projectInspectionUser.getStartTime().toLocalTime().isBefore(localTime)
               && projectInspectionUser.getEndTime().toLocalTime().isAfter(localTime)) {
               safetyEnvInspectionTask = 1;
            }

            if (avoidTime.equals(AvoidTimeEnum.AVOID_SUNDAY.getType())
               && value != 7
               && projectInspectionUser.getStartTime().toLocalTime().isBefore(localTime)
               && projectInspectionUser.getEndTime().toLocalTime().isAfter(localTime)) {
               safetyEnvInspectionTask = 1;
            }

            if (avoidTime.equals(AvoidTimeEnum.AVOID_SATURDAY.getType() + AvoidTimeEnum.AVOID_SUNDAY.getType())
               && value != 7
               && value != 6
               && projectInspectionUser.getStartTime().toLocalTime().isBefore(localTime)
               && projectInspectionUser.getEndTime().toLocalTime().isAfter(localTime)) {
               safetyEnvInspectionTask = 1;
            }
         } else if (projectInspectionUser.getStartTime().toLocalTime().isBefore(localTime)
            && projectInspectionUser.getEndTime().toLocalTime().isAfter(localTime)) {
            safetyEnvInspectionTask = 1;
         }
      }

      List<Integer> approvalStatusList = Arrays.asList(ReviewStatusEnum.UN_REVIEWED.getType(), ReviewStatusEnum.AUDITING.getType());
      List<MesTempWorkDTO> myTempWorkApprovalList = this.tempWorkService
         .listInfo(
            MesTempWorkQuery.builder()
               .approverId(UserUtil.getCurrentUserId())
               .approvalStatusList(approvalStatusList)
               .approveRecordDetailStatus(ApproveRecordStatusEnum.UNDERWAY.getType())
               .build()
         );
      Integer myTempWorkApprovalCount = myTempWorkApprovalList.size();
      taskMap.put("myTempWorkApprovalCount", myTempWorkApprovalCount);
      taskMap.put("safetyEnvInspectionTask", safetyEnvInspectionTask);
      taskMap.put("assemble", assemble);
      taskMap.put("assistArtifact", assistArtifact);
      taskMap.put("assistAssemble", assistAssemble);
      taskMap.put("machinePartDrill", machinePartDrill);
      taskMap.put("artifact", artifact);
      taskMap.put("machinePart", machinePart);
      taskMap.put("assembleInspection", assembleInspection);
      taskMap.put("artifactInspection", artifactInspection);
      taskMap.put("enclosureInspection", enclosureInspection);
      taskMap.put("machinePartInspection", machinePartInspection);
      taskMap.put("unInspection", unInspectionCun);
      taskMap.put("enclosureManufacture", enclosureManufacture);
      taskMap.put("acceptOnDeviation", acceptOnDeviation);
      taskMap.put("drillHoleTask", drillHoleTask);
      taskMap.put("manualCutting", manualCutting);
      taskMap.put("cncCutting", cncCutting);
      taskMap.put("structuralSteelCutting", structuralSteelCutting);
      taskMap.put("rawMaterialApplicationApprove", rawMaterialApplicationApprove);
      List<MesBuildingCargoList> mesBuildingCargoLists = this.cargoListService.countByStatus(CargoListStatusEnum.LOADING.getType());
      List<MesBuildingCargoList> mesBuildingCargoLists1 = this.cargoListService.countByStatus(CargoListStatusEnum.WEIGH.getType());
      taskMap.put(
         "loading",
         projectIds.isEmpty() ? 0 : mesBuildingCargoLists.stream().filter(s -> projectIds.contains(s.getProjectId())).collect(Collectors.toList()).size()
      );
      taskMap.put(
         "weigh",
         projectIds.isEmpty() ? 0 : mesBuildingCargoLists1.stream().filter(s -> projectIds.contains(s.getProjectId())).collect(Collectors.toList()).size()
      );
      taskMap.put("weldTask", weldTask);
      return taskMap;
   }

   @Override
   public Map<String, List<Long>> listHasTaskProductionLineId(Long projectId, Long monomerId, Long areaId, Long areaBatchId, Integer productType) {
      Map<String, List<Long>> map = new HashMap<>();
      List<MesBuildingTaskDTO> tasks = this.taskService.listTasks(projectId, monomerId, areaId, areaBatchId, productType);
      List<Long> sendLines = new ArrayList<>();
      if ((productType & (TaskTypeEnum.ASSEMBLE.getType() | TaskTypeEnum.MACHINE_PART.getType())) > 0) {
         tasks = tasks.stream().filter(MesBuildingTaskDTO::getBoolSendDirectly).collect(Collectors.toList());
         List<MesBuildingComplete> completes = this.completeService
            .list(
               Wrappers.lambdaQuery(MesBuildingComplete.class)
                  .eq(projectId != null, MesBuildingComplete::getProjectId, projectId)
                  .eq(monomerId != null, MesBuildingComplete::getMonomerId, monomerId)
                  .eq(areaId != null, MesBuildingComplete::getAreaId, areaId)
                  .eq(areaBatchId != null, MesBuildingComplete::getAreaBatchId, areaBatchId)
                  .isNull(MesBuildingComplete::getTaskId)
                  .apply(productType != null, "task_type_enum & {0}", productType)
            );
         sendLines = completes.stream().map(s -> s.getProductionLineId()).distinct().collect(Collectors.toList());
      }

      List<Long> ids = tasks.stream().map(MesBuildingTaskDTO::getProductionLineId).distinct().collect(Collectors.toList());
      ids.addAll(sendLines);
      ids = ids.stream().distinct().collect(Collectors.toList());
      map.put("ids", ids);
      return map;
   }

   @Override
   public ListVO<ProductProjectSumDO> listGroupByProjectId(String year, String month, Long productionLineId, Long processId) {
      Preconditions.checkArgument(StringUtils.isNotBlank(year) | StringUtils.isNotBlank(month), "日期不能为空");
      MesBuildingProcess process = this.processService.getById(processId);
      Preconditions.checkArgument(process != null, "工序不存在");
      return new ListVO<>(this.taskProcessService.listGroupByProjectId(year, month, productionLineId, processId, process.getProductType()));
   }

   @Override
   public ListVO<TaskMeteDO> listGroupByMonth(String year, String month, Long projectId, Long productionLineId, Long processId) {
      Preconditions.checkArgument(StringUtils.isNotBlank(year) | StringUtils.isNotBlank(month), "日期不能为空");
      MesBuildingProcess process = this.processService.getById(processId);
      Preconditions.checkArgument(process != null, "工序不存在");
      return new ListVO<>(this.taskProcessService.listGroupByMonth(year, month, projectId, productionLineId, processId, process.getProductType()));
   }

   @Override
   public ScanCodeArtifactDTO getArtifactTask(Long productId) {
      TechArtifact artifact = this.artifactService.getById(productId);
      if (artifact == null) {
         return new ScanCodeArtifactDTO();
      }

      ScanCodeArtifactDTO result = BeanUtil.copy(artifact, ScanCodeArtifactDTO.class);
      result.setProject(this.projectService.getSimpleById(artifact.getProjectId()));
      result.setMonomer(this.monomerService.getSimpleById(artifact.getMonomerId()));
      result.setArea(this.areaService.getSimpleById(artifact.getAreaId()));
      return result;
   }

   @Override
   public ScanCodeEnclosureDTO getEnclosureTask(Long productId) {
      TechEnclosure enclosure = this.enclosureService.getById(productId);
      if (enclosure == null) {
         return new ScanCodeEnclosureDTO();
      }

      ScanCodeEnclosureDTO result = BeanUtil.copy(enclosure, ScanCodeEnclosureDTO.class);
      result.setProject(this.projectService.getSimpleById(enclosure.getProjectId()));
      result.setArea(BeanUtil.copy(this.enclosurePlanService.getById(enclosure.getEnclosurePlanId()), NameInfo.class));
      return result;
   }

   @Override
   public ScanCodeEnclosureDTO getEnclosureTaskV2(Long productId) {
      TechEnclosure enclosure = this.enclosureService.getById(productId);
      if (enclosure == null) {
         return new ScanCodeEnclosureDTO();
      }

      ScanCodeEnclosureDTO result = BeanUtil.copy(enclosure, ScanCodeEnclosureDTO.class);
      result.setProject(this.projectService.getSimpleById(enclosure.getProjectId()));
      result.setMonomer(this.monomerService.getSimpleById(enclosure.getMonomerId()));
      result.setArea(BeanUtil.copy(this.areaService.getById(enclosure.getAreaId()), NameInfo.class));
      return result;
   }

   @Override
   public Integer checkReportQuantity(Long id) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(id);
      Preconditions.checkArgument(taskProcess != null, "传入id不正确");
      if (taskProcess.getSequence().equals(0)) {
         Long productId = taskProcess.getProductId();
         Integer productType = taskProcess.getTaskTypeEnum();
         Integer quantity = taskProcess.getNeedQuantity() - taskProcess.getCompleteQuantity();
         Integer reportQuantity = quantity;
         if (productType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
            TechAssemble assemble = this.assembleService.getById(productId);
            Preconditions.checkArgument(assemble != null, "产品id不正确");
            Integer projectMode = this.projectService.getProjectMode(assemble.getProjectId());
            List<Integer> allReportQuantitylist = new ArrayList<>();
            if (projectMode.equals(ProjectModeEnum.STANDARD_MODE.getType())) {
               List<TechAssembleMachinePartLink> assembleMachinePartLinks = this.assembleMachinePartLinkService
                  .list((Wrapper<TechAssembleMachinePartLink>)Wrappers.<TechAssembleMachinePartLink>lambdaQuery().eq(TechAssembleMachinePartLink::getAssembleId, assemble.getId()));
               Preconditions.checkArgument(assembleMachinePartLinks != null, "操作失败，找不到对应零件");
               assembleMachinePartLinks.forEach(e -> {
                  TechMachinePart machinePart = this.machinePartService.getById(e.getMachinePartId());
                  Preconditions.checkArgument(machinePart != null, "操作失败，找不到对应零件");
                  allReportQuantitylist.add((machinePart.getProducedQuantity() - machinePart.getUsedQuantity()) / e.getQuantity());
               });
               reportQuantity = allReportQuantitylist.size() == 0 ? 0 : Collections.min(allReportQuantitylist);
            }
         } else {
            if (!productType.equals(TaskTypeEnum.ARTIFACT.getType())) {
               throw new IllegalArgumentException("产品类型不正确");
            }

            TechArtifact artifact = this.artifactService.getById(productId);
            Preconditions.checkArgument(artifact != null, "操作失败，找不到对应构件");
            Integer projectMode = this.projectService.getProjectMode(artifact.getProjectId());
            if (projectMode.equals(ProjectModeEnum.STANDARD_MODE.getType())) {
               List<TechAssembleDetail> assembleDetails = this.assembleDetailService
                  .list((Wrapper<TechAssembleDetail>)Wrappers.<TechAssembleDetail>lambdaQuery().eq(TechAssembleDetail::getArtifactId, artifact.getId()));
               if (assembleDetails.size() != 0) {
                  List<Integer> cun = new ArrayList<>();
                  assembleDetails.forEach(e -> {
                     TechAssemble assemble = this.assembleService.getById(e.getAssembleId());
                     cun.add((assemble.getProducedQuantity() - assemble.getUsedQuantity()) / e.getQuantity());
                  });
                  reportQuantity = cun.stream().min(Comparator.comparing(Integer::intValue)).get();
               }

               if (projectMode.equals(ProjectModeEnum.STANDARD_MODE.getType())) {
                  List<Integer> allReportQuantityList = new ArrayList<>();
                  List<TechArtifactMachinePartLink> artifactMachinePartLinkList = this.artifactMachinePartLinkService
                     .list((Wrapper<TechArtifactMachinePartLink>)Wrappers.<TechArtifactMachinePartLink>lambdaQuery().eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()));
                  Preconditions.checkArgument(artifactMachinePartLinkList != null, "操作失败，找不到对应零件");
                  artifactMachinePartLinkList.forEach(e -> {
                     TechMachinePart machinePart = this.machinePartService.getById(e.getMachinePartId());
                     if (machinePart.getRelationType().equals(TaskTypeEnum.ARTIFACT.getType())) {
                        allReportQuantityList.add((machinePart.getProducedQuantity() - machinePart.getUsedQuantity()) / e.getQuantity());
                     }
                  });
                  if (allReportQuantityList.size() == 0) {
                     allReportQuantityList.add(0);
                  }

                  reportQuantity = reportQuantity < Collections.min(allReportQuantityList) ? reportQuantity : Collections.min(allReportQuantityList);
               }
            }
         }

         return reportQuantity < quantity ? reportQuantity : quantity;
      } else {
         return taskProcess.getNeedQuantity() - taskProcess.getCompleteQuantity();
      }
   }

   @Override
   public ProductSourceDTO productSource(Long id, Integer productType) {
      return ProductSourceDTO.builder()
         .reportSourceList(this.teamReportBiz.reportSourceList(id, productType))
         .inspectionReportSourceList(this.teamReportBiz.inspectionReportSourceList(id, productType))
         .build();
   }

   @Override
   public List<ProductionLoadDO> productionLoad(LocalDateTime dateTime, Long factoryId) {
      return this.completeService.productionLoad(dateTime, factoryId);
   }

   @Override
   public List<MesBuildingArtifactTaskProcessDTO> artifactTaskList(Long taskProcessId, Long number) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(taskProcessId);
      Preconditions.checkArgument(taskProcess.getSequence() != 0, "操作失败，第一道工序不需要一物一码");
      return this.produceTeamReportService
         .artifactTaskList(
            this.taskProcessService
               .getOne(
                  (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId()))
                     .eq(MesBuildingTaskProcess::getSequence, taskProcess.getSequence() - 1)
               )
               .getId(),
            taskProcessId,
            number
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactTaskProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean artifactTaskRevoke(List<Long> artifactTaskIds) {
      List<MesBuildingTask> artifactTasks = this.taskService.listByIds(artifactTaskIds);
      Map<Long, List<MesBuildingTask>> taskMap = artifactTasks.stream().collect(Collectors.groupingBy(MesBuildingTask::getTaskOrderId));
      Map<Long, Integer> taskOrderQuantityMap = artifactTasks.stream()
         .collect(Collectors.toMap(MesBuildingTask::getTaskOrderId, MesBuildingTask::getTaskQuantity, Integer::sum));
      List<Long> artifactIds = artifactTasks.stream().map(MesBuildingTask::getProductId).distinct().collect(Collectors.toList());
      List<Long> artTaskIds = artifactTasks.stream().map(MesBuildingTask::getTaskOrderId).distinct().collect(Collectors.toList());
      Map<Long, MesBuildingTaskOrder> artTaskOrderMap = this.taskOrderService
         .listByIds(artTaskIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));

      for (Long taskOrderId : taskMap.keySet()) {
         List<MesBuildingTask> tasks = taskMap.get(taskOrderId);
         MesBuildingTaskOrder taskOrder = artTaskOrderMap.get(taskOrderId);
         List<MesBuildingProductionTaskDTO> dtos = new ArrayList<>();

         for (MesBuildingTask task : tasks) {
            MesBuildingProductionTaskDTO build = MesBuildingProductionTaskDTO.builder()
               .taskId(task.getId())
               .boolCanRevoke(true)
               .quantity(task.getTaskQuantity())
               .productId(task.getProductId())
               .build();
            dtos.add(build);
         }

         this.mesBuildingTaskProcessBiz.computeBoolCanRevokeOnecode(dtos, taskOrder, true);
         if (dtos.stream().anyMatch(s -> !s.getBoolCanRevoke())) {
            Preconditions.checkArgument(false, "撤回失败!!!请刷新页面!!!");
         }
      }

      this.checkProductStatus(artifactIds, TaskTypeEnum.ARTIFACT.getType());
      List<Long> artSchedulingIds = artifactTasks.stream().map(MesBuildingTask::getSchedulingId).collect(Collectors.toList());
      List<MesBuildingArtifactScheduling> artifactSchedulings = this.artifactSchedulingBiz.listByIds(artSchedulingIds);
      Map<Long, Integer> scheduMap = artifactTasks.stream()
         .collect(Collectors.toMap(MesBuildingTask::getSchedulingId, MesBuildingTask::getTaskQuantity, Integer::sum));

      for (MesBuildingArtifactScheduling scheduling : artifactSchedulings) {
         Integer integer = scheduMap.get(scheduling.getId());
         Preconditions.checkArgument(integer != null, "撤回失败!请联系管理员!!!!");
         scheduling.setTaskQuantity(scheduling.getTaskQuantity() - integer);
         Preconditions.checkArgument(scheduling.getTaskQuantity() >= 0, "撤回失败!请联系管理员!!!!");
         Preconditions.checkArgument(scheduling.getTaskQuantity() <= scheduling.getQuantity(), "撤回失败!请联系管理员!!!!");
         scheduling.setIssueStatus(scheduling.getQuantity().equals(scheduling.getTaskQuantity()));
      }

      this.artifactSchedulingService.updateBatchById(artifactSchedulings);
      List<MesBuildingTaskProcess> artiTaskProcesList = this.taskProcessService
         .list(Wrappers.lambdaQuery(MesBuildingTaskProcess.class).in(MesBuildingTaskProcess::getTaskId, artifactTaskIds));
      if (CollectionUtils.isNotEmpty(artiTaskProcesList)) {
         Preconditions.checkArgument(artiTaskProcesList.stream().allMatch(s -> s.getCompleteQuantity() == 0), "操作失败构件已报工!!请刷新页面后重试!!!");
         List<MesBuildingAssist> artAssList = this.mesBuildingAssistService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssist.class)
                  .in(MesBuildingAssist::getTaskProcessId, artiTaskProcesList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()))
            );
         Preconditions.checkArgument(artAssList.isEmpty(), "撤回失败!!存在协同的任务!!!");
         this.taskProcessService.removeByIds(artiTaskProcesList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()));
      }

      this.baseService.removeByIds(artifactTaskIds);
      this.taskNeedMachinePartSchedulingBiz
         .remove(Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartScheduling.class).in(MesBuildingTaskNeedMachinePartScheduling::getTaskId, artifactTaskIds));
      List<MesBuildingTaskNumberLink> allNumberLinks = this.mesBuildingTaskNumberLinkService
         .list(Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class).in(MesBuildingTaskNumberLink::getArtifactTaskId, artifactTaskIds));
      Preconditions.checkArgument(allNumberLinks.stream().noneMatch(MesBuildingTaskNumberLink::getBoolArtifactInproduce), "操作失败!!!");
      List<Long> assTaskProcessIds = allNumberLinks.stream()
         .map(MesBuildingTaskNumberLink::getAssembleTaskProcessId)
         .filter(Objects::nonNull)
         .collect(Collectors.toList());
      Map<Long, List<Integer>> artifactNumberMap = allNumberLinks.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingTaskNumberLink::getArtifactId, Collectors.mapping(MesBuildingTaskNumberLink::getArtifactNumber, Collectors.toList())
            )
         );
      List<TechArtifactExt> artifactExts = this.artifactExtService
         .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getArtifactId, artifactNumberMap.keySet()));
      Map<Long, List<TechArtifactExt>> artifactExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifactExt> updateArtnumbers = new ArrayList<>();

      for (Long artifactId : artifactNumberMap.keySet()) {
         List<Integer> numbers = artifactNumberMap.get(artifactId);
         List<TechArtifactExt> needUpdate = artifactExtMap.get(artifactId)
            .stream()
            .filter(s -> numbers.contains(s.getSortNumber()))
            .collect(Collectors.toList());
         Preconditions.checkArgument(needUpdate.size() == numbers.stream().distinct().count(), "操作失败!!!!");
         needUpdate.forEach(s -> s.setTaskId(0L).setBoolTask(Boolean.FALSE));
         updateArtnumbers.addAll(needUpdate);
      }

      this.artifactExtService.updateBatchById(updateArtnumbers);
      this.mesBuildingTaskNumberLinkService.removeByIds(allNumberLinks.stream().map(MesBuildingTaskNumberLink::getId).collect(Collectors.toList()));
      this.techCappCraftProductTaskBiz.deleteCappTaksRecord(new ArrayList<>(), updateArtnumbers, ProductTypeEnum.ARTIFACT.getType());
      Map<Long, List<Integer>> assNumberMap = allNumberLinks.stream()
         .filter(s -> s.getAssembleId() != null)
         .collect(
            Collectors.groupingBy(
               MesBuildingTaskNumberLink::getAssembleId, Collectors.mapping(MesBuildingTaskNumberLink::getAssembleNumber, Collectors.toList())
            )
         );
      if (!assNumberMap.isEmpty()) {
         List<TechAssembleExt> assembleExts = this.assembleExtService
            .list(Wrappers.lambdaQuery(TechAssembleExt.class).in(TechAssembleExt::getAssembleId, assNumberMap.keySet()));
         Map<Long, List<TechAssembleExt>> assExtMap = assembleExts.stream().collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));
         List<TechAssembleExt> updateAssnumbers = new ArrayList<>();

         for (Long artifactId : assNumberMap.keySet()) {
            List<Integer> numbers = assNumberMap.get(artifactId);
            List<TechAssembleExt> needUpdate = assExtMap.get(artifactId).stream().filter(s -> numbers.contains(s.getSortNumber())).collect(Collectors.toList());
            Preconditions.checkArgument(needUpdate.size() == numbers.size(), "操作失败!!!!");
            needUpdate.forEach(s -> s.setTaskId(0L).setBoolTask(Boolean.FALSE));
            updateAssnumbers.addAll(needUpdate);
         }

         this.assembleExtService.updateBatchById(updateAssnumbers);
         this.techCappCraftProductTaskBiz.deleteCappTaksRecord(updateAssnumbers, new ArrayList<>(), ProductTypeEnum.ASSEMBLE.getType());
      }

      if (CollectionUtils.isNotEmpty(assTaskProcessIds)) {
         Preconditions.checkArgument(allNumberLinks.stream().noneMatch(MesBuildingTaskNumberLink::getBoolAssembleInproduce), "操作失败!!!");
         Map<Long, Integer> assLinkMap = allNumberLinks.stream().collect(Collectors.toMap(MesBuildingTaskNumberLink::getAssembleTaskId, s -> 1, Integer::sum));
         List<MesBuildingAssist> assmbleAssList = this.mesBuildingAssistService
            .list(Wrappers.lambdaQuery(MesBuildingAssist.class).in(MesBuildingAssist::getTaskProcessId, assTaskProcessIds));
         Preconditions.checkArgument(assmbleAssList.isEmpty(), "撤回失败!!存在协同的任务!!!");
         List<MesBuildingTask> assTasks = this.taskService.listByIds(assLinkMap.keySet());
         Map<Long, MesBuildingTask> assTaskMap = assTasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
         List<MesBuildingTaskProcess> assTaskProcess = this.taskProcessService
            .list(Wrappers.lambdaQuery(MesBuildingTaskProcess.class).in(MesBuildingTaskProcess::getTaskId, assLinkMap.keySet()));
         Map<Long, List<MesBuildingTaskProcess>> assTaskProcessMap = assTaskProcess.stream().collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
         if (CollectionUtils.isNotEmpty(assTasks)) {
            List<Long> assembleTaskIds = assTasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList());
            List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.mesBuildingTaskNeedMachinePartSchedulingService
               .list(
                  (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                     .in(MesBuildingTaskNeedMachinePartScheduling::getTaskId, assembleTaskIds)
               );
            if (CollectionUtils.isNotEmpty(mesBuildingTaskNeedMachinePartSchedulingList)) {
               Preconditions.checkArgument(mesBuildingTaskNeedMachinePartSchedulingList.stream().allMatch(e -> e.getSchedulingQuantity() == 0), "操作失败,部件零件已排产!");
               Preconditions.checkArgument(
                  mesBuildingTaskNeedMachinePartSchedulingList.stream()
                     .allMatch(
                        e -> e.getIssuedToNestingSoftwareStatus().equals(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType())
                           || e.getIssuedToNestingSoftwareStatus().equals(IssuedToNestingSoftwareStatusEnum.ISSUANCE_FAILED.getType())
                     ),
                  "操作失败,部件零件已套料排产!"
               );
            }
         }

         for (Long assTaskId : assLinkMap.keySet()) {
            if (assTaskId != null) {
               Integer needReduce = assLinkMap.get(assTaskId);
               MesBuildingTask assTask = assTaskMap.get(assTaskId);
               assTask.setTaskQuantity(assTask.getTaskQuantity() - needReduce);
               Preconditions.checkArgument(assTask.getTaskQuantity() >= assTask.getCompleteQuantity(), "操作失败!!!!");
               List<MesBuildingTaskProcess> assTaskProcessList = assTaskProcessMap.get(assTaskId);
               if (CollectionUtils.isNotEmpty(assTaskProcessList)) {
                  for (MesBuildingTaskProcess taskProcess : assTaskProcessList) {
                     taskProcess.setTaskQuantity(taskProcess.getTaskQuantity() - needReduce);
                     if (taskProcess.getSequence().equals(0)) {
                        taskProcess.setNeedQuantity(taskProcess.getNeedQuantity() - needReduce);
                     }

                     Preconditions.checkArgument(taskProcess.getTaskQuantity() >= taskProcess.getCompleteQuantity(), "操作失败!!!!");
                  }
               }

               taskOrderQuantityMap.merge(assTask.getTaskOrderId(), needReduce, Integer::sum);
            }
         }

         List<MesBuildingTaskProcess> assTaskProcessList = assTaskProcessMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
         this.taskProcessService.updateBatchById(assTaskProcessList);
         List<Long> deleteAssTaskProcess = assTaskProcessList.stream()
            .filter(s -> s.getTaskQuantity().equals(0))
            .map(MesBuildingTaskProcess::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(deleteAssTaskProcess)) {
            this.taskProcessService.removeByIds(deleteAssTaskProcess);
         }

         List<MesBuildingTask> assTaskList = new ArrayList<>(assTaskMap.values());
         this.taskService.updateBatchById(assTaskList);
         List<Long> neeDeleteAssTaskIds = assTaskList.stream()
            .filter(s -> s.getTaskQuantity().equals(0))
            .map(MesBuildingTask::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(neeDeleteAssTaskIds)) {
            this.taskService.removeByIds(neeDeleteAssTaskIds);
         }

         this.taskNeedMachinePartSchedulingBiz
            .remove(
               Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartScheduling.class)
                  .in(MesBuildingTaskNeedMachinePartScheduling::getTaskId, assTaskMap.keySet())
            );
      }

      List<MesBuildingTaskOrder> taskOrders = this.taskOrderService.listByIds(taskOrderQuantityMap.keySet());
      Map<Long, MesBuildingTaskOrder> taskOrderMap = taskOrders.stream().collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
      List<Long> topOrderIds = taskOrders.stream().map(MesBuildingTaskOrder::getTopTaskOrderId).distinct().collect(Collectors.toList());
      List<MesBuildingTopTaskOrder> topTaskOrders = this.topTaskOrderService.listByIds(topOrderIds);
      Map<Long, MesBuildingTopTaskOrder> topOrderMap = topTaskOrders.stream().collect(Collectors.toMap(MesBuildingTopTaskOrder::getId, Function.identity()));
      Preconditions.checkArgument(taskOrders.size() == taskOrderQuantityMap.keySet().size(), "操作失败!!!");

      for (MesBuildingTaskOrder taskOrder : taskOrders) {
         Integer reduceQuantity = taskOrderQuantityMap.get(taskOrder.getId());
         taskOrder.setQuantity(taskOrder.getQuantity() - reduceQuantity);
         Preconditions.checkArgument(taskOrder.getQuantity() >= 0, "操作失败!!!");
         if (taskOrder.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            MesBuildingTopTaskOrder topTaskOrder = topOrderMap.get(taskOrder.getTopTaskOrderId());
            if (taskOrder.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
               topTaskOrder.setQuantity(topTaskOrder.getQuantity() - reduceQuantity);
            }

            Preconditions.checkArgument(topTaskOrder.getQuantity() >= 0, "操作失败!!!");
         }
      }

      List<MesBuildingTask> taskList = this.taskService
         .list(Wrappers.lambdaQuery(MesBuildingTask.class).in(MesBuildingTask::getTaskOrderId, taskOrderQuantityMap.keySet()));
      Map<Long, List<MesBuildingTask>> taskOrderGroupMap = taskList.stream().collect(Collectors.groupingBy(MesBuildingTask::getTaskOrderId));

      for (MesBuildingTaskOrder taskOrder : taskOrders) {
         List<MesBuildingTask> tasks = taskOrderGroupMap.get(taskOrder.getId());
         if (CollectionUtils.isNotEmpty(tasks)) {
            taskOrder.setCompleteTime(tasks.stream().anyMatch(s -> s.getTaskQuantity() > s.getCompleteQuantity()) ? null : LocalDateTime.now());
         } else {
            taskOrder.setCompleteTime(LocalDateTime.now());
         }
      }

      this.taskOrderService.updateBatchById(taskOrders);
      List<Long> deleteOrderIds = taskOrders.stream().filter(s -> s.getQuantity().equals(0)).map(MesBuildingTaskOrder::getId).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(deleteOrderIds)) {
         this.taskOrderService.removeByIds(deleteOrderIds);
         this.orderChangeBiz.deleteOrderChanges(deleteOrderIds);
      }

      Map<Long, List<MesBuildingTask>> topTaskOrderMap = taskList.stream().collect(Collectors.groupingBy(MesBuildingTask::getTopTaskOrderId));
      List<MesBuildingTopTaskOrder> topTaskOrderList = new ArrayList<>(topOrderMap.values());

      for (MesBuildingTopTaskOrder topTaskOrder : topTaskOrderList) {
         List<MesBuildingTask> tasks = topTaskOrderMap.get(topTaskOrder.getId());
         if (CollectionUtils.isNotEmpty(tasks)) {
            topTaskOrder.setCompleteTime(tasks.stream().anyMatch(s -> s.getTaskQuantity() > s.getCompleteQuantity()) ? null : LocalDateTime.now());
         } else {
            topTaskOrder.setCompleteTime(LocalDateTime.now());
         }
      }

      this.topTaskOrderService.updateBatchById(topTaskOrderList);
      List<Long> deleteTopOrderIds = topTaskOrderList.stream()
         .filter(s -> s.getQuantity().equals(0))
         .map(MesBuildingTopTaskOrder::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(deleteTopOrderIds)) {
         this.topTaskOrderService.removeByIds(deleteTopOrderIds);
      }

      List<TechAssembleDetail> allLinks = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
      Map<Long, List<TechAssembleDetail>> assembleDetailListByArtifactIdMap = new HashMap<>();
      List<TechAssemble> allTechAssembles = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(allLinks)) {
         assembleDetailListByArtifactIdMap = allLinks.stream().collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
         allTechAssembles = this.assembleService.listByIds(allLinks.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
      }

      Map<Long, TechAssemble> allAssMap = allTechAssembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      List<TechArtifactMachinePartLink> allPartLinks = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIds));
      Map<Long, List<TechArtifactMachinePartLink>> partLinkMap = allPartLinks.stream()
         .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
      Map<Long, TechMachinePart> partMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(allPartLinks)) {
         List<TechMachinePart> allParts = this.machinePartService
            .listByIds(allPartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
         partMap = allParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      }

      List<Long> taskIds = artifactTasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList());
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> list = this.mesBuildingMachinePartSchedulingArtifactTaskLinkService
         .list(
            (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
               .in(MesBuildingMachinePartSchedulingArtifactTaskLink::getTaskId, taskIds)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(list), "撤回失败!!该构件下的零件任务已排产!!!");
      List<MesBuildingTaskNeedMachinePartScheduling> mesBuildingTaskNeedMachinePartSchedulingList = this.mesBuildingTaskNeedMachinePartSchedulingService
         .list(
            (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)(new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                  .in(MesBuildingTaskNeedMachinePartScheduling::getTaskId, taskIds))
               .isNotNull(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingTaskNeedMachinePartSchedulingList), "撤回失败!!该构件下的零件任务已排产!!!");

      for (MesBuildingTask task : artifactTasks) {
         List<TechAssembleDetail> assembleDetailList = assembleDetailListByArtifactIdMap.get(task.getProductId());
         if (CollectionUtils.isNotEmpty(assembleDetailList)) {
            for (TechAssembleDetail detail : assembleDetailList) {
               TechAssemble techAssemble = allAssMap.get(detail.getAssembleId());
               if (techAssemble != null && !techAssemble.getBoolProcess()) {
                  techAssemble.setProducedQuantity(techAssemble.getProducedQuantity() - task.getTaskQuantity() * detail.getQuantity());
                  Preconditions.checkArgument(techAssemble.getProducedQuantity() >= 0, "撤回失败!!联系管理员!!!");
                  allAssMap.put(detail.getAssembleId(), techAssemble);
               }
            }
         }

         List<TechArtifactMachinePartLink> machinePartLinks = partLinkMap.get(task.getProductId());
         if (CollectionUtils.isNotEmpty(machinePartLinks)) {
            for (TechArtifactMachinePartLink link : machinePartLinks) {
               TechMachinePart techMachinePart = partMap.get(link.getMachinePartId());
               if (techMachinePart != null && !techMachinePart.getBoolProcess()) {
                  techMachinePart.setProducedQuantity(techMachinePart.getProducedQuantity() - task.getTaskQuantity() * link.getQuantity());
                  Preconditions.checkArgument(techMachinePart.getProducedQuantity() >= 0, "撤回失败!!联系管理员!!!");
                  partMap.put(link.getMachinePartId(), techMachinePart);
               } else {
                  partMap.put(link.getMachinePartId(), techMachinePart);
               }
            }
         }
      }

      List<TechAssemble> assList = new ArrayList<>(allAssMap.values());
      if (CollectionUtils.isNotEmpty(assList)) {
         this.assembleService.updateBatchById(assList);
      }

      List<TechMachinePart> parList = new ArrayList<>(partMap.values());
      if (CollectionUtils.isNotEmpty(parList)) {
         this.machinePartService.updateBatchById(parList);
      }

      List<MesBuildingComplete> completets = this.completeService
         .list(Wrappers.lambdaQuery(MesBuildingComplete.class).in(MesBuildingComplete::getArtifactTaskId, artifactTaskIds));
      if (CollectionUtils.isNotEmpty(completets)) {
         this.completeService.removeByIds(completets.stream().map(MesBuildingComplete::getId).collect(Collectors.toList()));
         this.warehouseRecordService
            .remove(
               Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                  .in(MesBuildingWarehouseRecord::getCompleteId, completets.stream().map(MesBuildingComplete::getId).collect(Collectors.toList()))
            );
         Map<String, List<MesBuildingComplete>> completeMap = completets.stream()
            .collect(Collectors.groupingBy(s -> s.getWorkshopId() + "_" + s.getTaskTypeEnum()));

         for (String key : completeMap.keySet()) {
            List<MesBuildingComplete> completes = completeMap.get(key);
            String[] split = key.split("_");
            Long shopId = Long.valueOf(split[0]);
            Integer taskType = Integer.valueOf(split[1]);
            List<Long> productIds = completes.stream().map(MesBuildingComplete::getProductId).collect(Collectors.toList());
            Map<Long, Integer> completeQuantityMap = completes.stream()
               .collect(Collectors.toMap(MesBuildingComplete::getProductId, MesBuildingComplete::getQuantity, Integer::sum));
            List<MesBuildingWarehouseSummary> allSummarys = this.warehouseSummaryService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .eq(MesBuildingWarehouseSummary::getWorkshopId, shopId)
                     .eq(MesBuildingWarehouseSummary::getProductType, taskType)
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .in(MesBuildingWarehouseSummary::getProductId, productIds)
               );

            for (MesBuildingWarehouseSummary summary : allSummarys) {
               summary.setQuantity(summary.getQuantity().subtract(BigDecimal.valueOf(completeQuantityMap.get(summary.getProductId()).intValue())));
               Preconditions.checkArgument(
                  summary.getQuantity().intValue() >= summary.getCargoQuantity().intValue() + summary.getPackageQuantity().intValue(),
                  "撤回失败,直发件已发运,剩余库存数不支持本张工单全部测回,请逐条操作"
               );
            }

            List<MesBuildingWarehouseSummary> needRemove = allSummarys.stream().filter(s -> s.getQuantity().equals(0)).collect(Collectors.toList());
            List<MesBuildingWarehouseSummary> needUpdate = allSummarys.stream().filter(s -> !s.getQuantity().equals(0)).collect(Collectors.toList());
            this.warehouseSummaryService.removeByIds(needRemove.stream().map(MesBuildingWarehouseSummary::getId).collect(Collectors.toList()));
            this.warehouseSummaryService.updateBatchById(needUpdate);
         }
      } else {
         for (MesBuildingTask task : artifactTasks) {
            Long shpId = task.getWorkshopId();
            Map<Long, Integer> reduceMap = new HashMap<>();
            reduceMap.put(task.getProductId(), task.getTaskQuantity());
            this.deleteOldData(shpId, reduceMap);
         }
      }

      List<Long> artIds = artifactTasks.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
      List<Long> allSendArtIds = this.artifactService
         .listByIds(artIds)
         .stream()
         .filter(TechArtifact::getBoolAllPartSendDirectly)
         .map(TechArtifact::getId)
         .collect(Collectors.toList());

      for (MesBuildingTask allSendTask : artifactTasks.stream().filter(s -> allSendArtIds.contains(s.getProductId())).collect(Collectors.toList())) {
         this.reducePurlin(allSendTask, allSendTask.getTaskQuantity());
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean artifactTaskOrderRevoke(Long id) {
      List<MesBuildingTask> taskList = this.baseService.list(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getTaskOrderId, id));
      this.artifactTaskRevoke(taskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList()));
      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingArtifactTaskProcessDTO> artifactInspectionTaskList(Long taskProcessId, Long number, Long teamId) {
      return this.produceTeamReportService
         .artifactInspectionTaskList(taskProcessId, number, teamId)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactTaskProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Override
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
      LocalDateTime reportTime = LocalDateTime.now();
      Long productionLineId = assist == null ? taskProcess.getProductionLineId() : assist.getProductionLineId();
      Long groupsId = assist == null ? taskProcess.getGroupsId() : assist.getGroupsId();
      Integer reportTypeValue = reportType ? TeamReportTypeEnum.ABNORMAL.getType() : TeamReportTypeEnum.NORMAL.getType();
      Long currentUserId = UserUtil.getCurrentUserId();
      List<MesBuildingProduceTeamReport> reports = this.buildTeamReports(
         taskProcess,
         reportQuantity,
         isInspection,
         reportTime,
         productionLineId,
         groupsId,
         reportTypeValue,
         currentUserId,
         numberList,
         team,
         assist,
         booleOneCode
      );
      if (CollectionUtils.isNotEmpty(reports)) {
         this.produceTeamReportService.saveBatch(reports);
      }

      this.handleQualityInspectionNotification(isInspection, reports);
      this.saveInProductionRecords(taskProcess, reportQuantity, numberList, reports, currentUserId);
      return null;
   }

   private List<MesBuildingProduceTeamReport> buildTeamReports(
      MesBuildingTaskProcess taskProcess,
      Integer reportQuantity,
      boolean isInspection,
      LocalDateTime reportTime,
      Long productionLineId,
      Long groupsId,
      Integer reportTypeValue,
      Long currentUserId,
      List<Integer> numberList,
      MesBuildingTeam team,
      MesBuildingAssist assist,
      Boolean booleOneCode
   ) {
      List<MesBuildingProduceTeamReport> reports = new ArrayList<>();
      boolean hasNumberList = CollectionUtils.isNotEmpty(numberList);
      Long reportNumber = this.redisUtils.incr("teamreport_reportnumber:", 1L);
      if (hasNumberList) {
         for (Integer number : numberList) {
            MesBuildingProduceTeamReport teamReport = MesBuildingProduceTeamReport.builder()
               .productId(taskProcess.getProductId())
               .taskTypeEnum(taskProcess.getTaskTypeEnum())
               .processId(taskProcess.getProcessId())
               .productionLineId(productionLineId)
               .taskId(taskProcess.getTaskId())
               .teamId(team.getId())
               .taskProcessId(taskProcess.getId())
               .quantity(1)
               .reportTime(reportTime)
               .userId(currentUserId)
               .boolHandleEnum(false)
               .inspectionQuantity(isInspection ? 0 : 1)
               .isReversible(!isInspection)
               .number(number)
               .groupsId(groupsId)
               .reportType(reportTypeValue)
               .schedulingId(taskProcess.getSchedulingId())
               .assistId(assist == null ? null : assist.getId())
               .reportNumber(reportNumber)
               .sequence(taskProcess.getSequence())
               .projectId(taskProcess.getProjectId())
               .monomerId(taskProcess.getMonomerId())
               .areaId(taskProcess.getAreaId())
               .workshopId(team.getWorkshopId())
               .build();
            reports.add(teamReport);
            if (booleOneCode) {
               reportNumber = this.redisUtils.incr("teamreport_reportnumber:", 1L);
            }
         }
      } else {
         MesBuildingProduceTeamReport teamReport = MesBuildingProduceTeamReport.builder()
            .productId(taskProcess.getProductId())
            .taskTypeEnum(taskProcess.getTaskTypeEnum())
            .processId(taskProcess.getProcessId())
            .productionLineId(productionLineId)
            .taskId(taskProcess.getTaskId())
            .teamId(team.getId())
            .taskProcessId(taskProcess.getId())
            .quantity(reportQuantity)
            .userId(currentUserId)
            .boolHandleEnum(false)
            .reportTime(reportTime)
            .inspectionQuantity(isInspection ? 0 : reportQuantity)
            .isReversible(!isInspection)
            .groupsId(groupsId)
            .reportType(reportTypeValue)
            .schedulingId(taskProcess.getSchedulingId())
            .assistId(assist == null ? null : assist.getId())
            .reportNumber(reportNumber)
            .sequence(taskProcess.getSequence())
            .projectId(taskProcess.getProjectId())
            .monomerId(taskProcess.getMonomerId())
            .areaId(taskProcess.getAreaId())
            .workshopId(team.getWorkshopId())
            .build();
         reports.add(teamReport);
      }

      return reports;
   }

   private void handleQualityInspectionNotification(boolean isInspection, List<MesBuildingProduceTeamReport> reports) {
      if (isInspection && !CollectionUtils.isEmpty(reports)) {
         SysPushNotificationConfig notificationConfig = this.pushNotificationConfigService
            .getOne(
               Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                  .eq(SysPushNotificationConfig::getNotificationTypeEnum, NotificationModuleTypeEnum.QUALITY_INSPECTION.getNotificationType())
                  .eq(SysPushNotificationConfig::getNotificationModeTypeEnum, NotificationModeTypeEnum.TIMING.getType())
                  .eq(SysPushNotificationConfig::getStatus, true)
            );
         if (!ObjectUtil.isEmpty(notificationConfig)) {
            String idStr = reports.stream().map(MesBuildingProduceTeamReport::getId).map(Object::toString).collect(Collectors.joining(","));
            long delaySeconds = this.calculateNotificationDelay(notificationConfig);
            long executionTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(delaySeconds);
            this.redisTemplate.opsForZSet().add("message_notification_quality_inspection", idStr + "+" + UserUtil.getCurrentName(), executionTime);
         }
      }
   }

   private long calculateNotificationDelay(SysPushNotificationConfig notificationConfig) {
      long SECONDS_PER_MINUTE = 60L;
      long SECONDS_PER_HOUR = 3600L;
      long SECONDS_PER_DAY = 86400L;
      int duration = notificationConfig.getDuration();
      int timeType = notificationConfig.getTimeTypeEnum();
      switch (timeType) {
         case 1:
            return duration * 60L;
         case 2:
            return duration * 3600L;
         case 3:
            return duration * 86400L;
         default:
            return 0L;
      }
   }

   private void saveInProductionRecords(
      MesBuildingTaskProcess taskProcess, Integer reportQuantity, List<Integer> numberList, List<MesBuildingProduceTeamReport> reports, Long currentUserId
   ) {
      if (taskProcess.getSequence().equals(0) && !CollectionUtils.isEmpty(reports)) {
         boolean hasNumberList = CollectionUtils.isNotEmpty(numberList);
         List<MesBuildingInProduction> inProductions = new ArrayList<>(reports.size());

         for (MesBuildingProduceTeamReport teamReport : reports) {
            MesBuildingInProduction inProduction = MesBuildingInProduction.builder()
               .projectId(taskProcess.getProjectId())
               .monomerId(taskProcess.getMonomerId())
               .areaId(taskProcess.getAreaId())
               .areaBatchId(taskProcess.getAreaBatchId())
               .factoryId(taskProcess.getFactoryId())
               .workshopId(taskProcess.getWorkshopId())
               .productionLineId(taskProcess.getProductionLineId())
               .taskId(taskProcess.getTaskId())
               .productId(taskProcess.getProductId())
               .productType(taskProcess.getTaskTypeEnum())
               .teamReportId(teamReport.getId())
               .teamId(teamReport.getTeamId())
               .userId(currentUserId)
               .quantity(hasNumberList ? 1 : reportQuantity)
               .number(teamReport.getNumber())
               .build();
            inProductions.add(inProduction);
         }

         if (CollectionUtils.isNotEmpty(inProductions)) {
            this.inProductionService.saveBatch(inProductions);
         }
      }
   }

   @Override
   public List<Integer> saveTeamReportV2(
      MesBuildingTaskProcess taskProcess,
      Integer reportQuantity,
      boolean isInspection,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingTeam team,
      MesBuildingAssist assist,
      Boolean booleOneCode,
      Long reportPersonId,
      BigDecimal perforateQuantity
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
               .userId(reportPersonId)
               .boolHandleEnum(false)
               .inspectionQuantity(isInspection ? 0 : 1)
               .isReversible(!isInspection)
               .number(number)
               .groupsId(assist == null ? taskProcess.getGroupsId() : assist.getGroupsId())
               .reportType(reportType ? TeamReportTypeEnum.ABNORMAL.getType() : TeamReportTypeEnum.NORMAL.getType())
               .schedulingId(taskProcess.getSchedulingId())
               .assistId(assist == null ? null : assist.getId())
               .reportNumber(reportNumber)
               .sequence(taskProcess.getSequence())
               .projectId(taskProcess.getProjectId())
               .monomerId(taskProcess.getMonomerId())
               .areaId(taskProcess.getAreaId())
               .workshopId(team.getWorkshopId())
               .productionLineId(team.getProductionLineId())
               .perforateQuantity(perforateQuantity)
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
            .userId(reportPersonId)
            .boolHandleEnum(false)
            .reportTime(reportTime)
            .inspectionQuantity(isInspection ? 0 : reportQuantity)
            .isReversible(!isInspection)
            .groupsId(assist == null ? taskProcess.getGroupsId() : assist.getGroupsId())
            .reportType(reportType ? TeamReportTypeEnum.ABNORMAL.getType() : TeamReportTypeEnum.NORMAL.getType())
            .schedulingId(taskProcess.getSchedulingId())
            .assistId(assist == null ? null : assist.getId())
            .reportNumber(reportNumber)
            .sequence(taskProcess.getSequence())
            .projectId(taskProcess.getProjectId())
            .monomerId(taskProcess.getMonomerId())
            .areaId(taskProcess.getAreaId())
            .workshopId(team.getWorkshopId())
            .productionLineId(team.getProductionLineId())
            .perforateQuantity(perforateQuantity)
            .build();
         reports.add(teamReport);
      }

      this.produceTeamReportService.saveBatch(reports);
      if (isInspection) {
         SysPushNotificationConfig notificationConfig = this.pushNotificationConfigService
            .getOne(
               Wrappers.lambdaQuery(SysPushNotificationConfig.class)
                  .eq(SysPushNotificationConfig::getNotificationTypeEnum, NotificationModuleTypeEnum.QUALITY_INSPECTION.getNotificationType())
                  .eq(SysPushNotificationConfig::getNotificationModeTypeEnum, NotificationModeTypeEnum.TIMING.getType())
                  .eq(SysPushNotificationConfig::getStatus, true)
            );
         if (ObjectUtil.isNotEmpty(notificationConfig)) {
            List<Long> ids = reports.stream().map(e -> e.getId()).collect(Collectors.toList());
            String idStr = ids.stream().map(Object::toString).collect(Collectors.joining(","));
            long currentTimeInMillis = System.currentTimeMillis();
            long time = 0L;
            if (notificationConfig.getTimeTypeEnum() == NotificationTimeTypeEnum.MINUTE.getType()) {
               time = notificationConfig.getDuration() * 60;
            }

            if (notificationConfig.getTimeTypeEnum() == NotificationTimeTypeEnum.HOUR.getType()) {
               time = notificationConfig.getDuration() * 60 * 60;
            }

            if (notificationConfig.getTimeTypeEnum() == NotificationTimeTypeEnum.DAY.getType()) {
               time = notificationConfig.getDuration() * 24 * 60 * 60;
            }

            long executionTime = currentTimeInMillis + TimeUnit.SECONDS.toMillis(time);
            this.redisTemplate.opsForZSet().add("message_notification_quality_inspection", idStr + "+" + UserUtil.getCurrentName(), executionTime);
         }
      }

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
               .userId(reportPersonId)
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
            complete.setUserId(UserUtil.getCurrentUserId());
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
         complete.setUserId(UserUtil.getCurrentUserId());
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

   private void saveCompoleteInspectionReport(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long teamId, List<TeamAndNumberDTO> numberList) {
      List<MesBuildingComplete> completes = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(numberList)) {
         for (TeamAndNumberDTO numberDTO : numberList) {
            MesBuildingComplete complete = BeanUtil.copy(taskProcess, MesBuildingComplete.class);
            complete.setUserId(UserUtil.getCurrentUserId());
            complete.setCreateTime(LocalDateTime.now());
            complete.setUpdateTime(null);
            complete.setBoolAbnormalEnum(false);
            complete.setQuantity(1);
            complete.setNumber(numberDTO.getNumber());
            complete.setGroupsId(taskProcess.getGroupsId());
            complete.setTeamId(numberDTO.getTeamId());
            complete.setFactoryId(taskProcess.getFactoryId());
            completes.add(complete);
         }
      } else {
         MesBuildingComplete complete = BeanUtil.copy(taskProcess, MesBuildingComplete.class);
         complete.setUserId(UserUtil.getCurrentUserId());
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

   @Override
   public Boolean saveSinglePartArtifactPaint(TechArtifact artifact, MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long teamId, Long completeId) {
      List<MesBuildingSinglePartArtifactPrint> allPrints = this.singlePartArtifactPrintBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingSinglePartArtifactPrint.class)
               .eq(MesBuildingSinglePartArtifactPrint::getProductId, artifact.getId())
               .eq(MesBuildingSinglePartArtifactPrint::getBoolAllReport, false)
         );
      Map<Long, List<MesBuildingSinglePartArtifactPrint>> taskSingMap = allPrints.stream()
         .collect(Collectors.groupingBy(MesBuildingSinglePartArtifactPrint::getTaskId));
      int unUseQuantity = 0;
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart machines = this.machinePartService.getById(taskProcess.getProductId());
         unUseQuantity = machines.getProducedQuantity() - machines.getUsedQuantity();
      } else {
         TechAssemble assemble = this.assembleService.getById(taskProcess.getProductId());
         unUseQuantity = assemble.getProducedQuantity() - assemble.getUsedQuantity();
      }

      for (Long taskId : taskSingMap.keySet()) {
         int canUseQuantity = unUseQuantity;
         List<MesBuildingSinglePartArtifactPrint> prints = taskSingMap.get(taskId);

         for (MesBuildingSinglePartArtifactPrint print : prints) {
            print.setQuantity(0);
            if (canUseQuantity > 0) {
               int needQuantity = print.getTaskQuantity() - print.getReportQuantity();
               if (canUseQuantity >= needQuantity) {
                  print.setQuantity(needQuantity);
                  canUseQuantity -= needQuantity;
               } else {
                  print.setQuantity(canUseQuantity);
                  canUseQuantity = 0;
               }
            }
         }

         this.singlePartArtifactPrintService.updateBatchById(prints);
      }

      return Boolean.TRUE;
   }

   @Override
   public QuantityAndWeightDetailDO taskMeteByProject(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Long workshopId) {
      return this.baseService.taskMeteByProject(projectId, startDate, endDate, workshopId);
   }

   @Override
   public List<QuantityAndWeightDetailDO> listTaskMeteByProject(List<Long> projectIds, LocalDateTime startDate, LocalDateTime endDate, Long workshopId) {
      return this.baseService.listTaskMeteByProject(projectIds, startDate, endDate, workshopId);
   }

   @Override
   public QuantityAndWeightDetailDO unCompletTaskMeteByProject(
      Long projectId, LocalDateTime startDate, LocalDateTime endDate, List<Long> singleArtifactIds, Long workshopId
   ) {
      return this.baseMapper.unCompletTaskMeteByProject(projectId, startDate, endDate, singleArtifactIds, workshopId);
   }

   @Override
   public List<MesBuildingProductionTaskDTO> projectProgressingTaskList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   ) {
      return this.baseService.projectProgressingTaskList(projectId, monomerId, areaId, serialNumber, startDate, endDate, workshopId);
   }

   @Override
   public ListVO<ProjectTreeResponseVO> taskOrderProjectList() {
      List<Long> linkProjectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (linkProjectIds.size() == 0) {
         return new ListVO<>();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (CollectionUtils.isEmpty(teamList)) {
         return new ListVO<>();
      }

      List<Long> teamIds = teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList());
      List<Long> groupsIdList = this.groupsTeamLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).in(MesBuildingGroupsTeamLink::getTeamId, teamIds))
         .stream()
         .map(MesBuildingGroupsTeamLink::getGroupsId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(groupsIdList)) {
         return new ListVO<>();
      }

      List<MesBuildingGroups> groups = this.groupsBiz.getGroupsList(null).stream().filter(e -> groupsIdList.contains(e.getId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(groups)) {
         return new ListVO<>();
      }

      List<MesBuildingGroupsTreeDO> groupsTreeList = this.groupsBiz.getGroupsTreeList(null);
      if (groupsTreeList.size() == 0) {
         return new ListVO<>();
      }

      List<AppTaskOrderSummaryDO> appTaskOrderSummaryDOS = this.taskProcessService
         .selectTaskOrderIdList(groupsTreeList, null, linkProjectIds, null, null, null, TaskTypeEnum.MACHINE_PART.getType(), null, null, null);
      List<Long> taskOrderIds = appTaskOrderSummaryDOS.stream().map(AppTaskOrderSummaryDO::getId).collect(Collectors.toList());
      List<ProjectDetailDO> projectList = this.projectService
         .taskOrderProjectList(taskOrderIds, ProcessTypeEnum.MAKINGS.getType())
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectDetailDO.class))
         .distinct()
         .collect(Collectors.toList());
      List<Long> projectIds = projectList.stream().map(ProjectDetailDO::getId).collect(Collectors.toList());
      List<PlanMonomer> monomers = this.monomerService.list(Wrappers.lambdaQuery(PlanMonomer.class).in(PlanMonomer::getProjectId, projectIds));
      Map<Long, List<PlanMonomer>> monMap = monomers.stream().collect(Collectors.groupingBy(PlanMonomer::getProjectId));
      List<PlanArea> areas = this.areaService.list(Wrappers.lambdaQuery(PlanArea.class).in(PlanArea::getProjectId, projectIds));
      Map<Long, List<PlanArea>> areaMap = areas.stream().collect(Collectors.groupingBy(PlanArea::getMonomerId));
      List<ProjectTreeResponseVO> responseList = projectList.stream().map(project -> {
         ProjectTreeResponseVO responseVO = BeanUtil.copy(project, ProjectTreeResponseVO.class);
         List<PlanMonomer> monomerList = monMap.get(project.getId());
         List<MonomerTreeResponseVO> monomerVOList = new ArrayList<>();
         monomerList.forEach(monomer -> {
            MonomerTreeResponseVO monomerVO = BeanUtil.copy(monomer, MonomerTreeResponseVO.class);
            List<PlanArea> areaList = areaMap.get(monomer.getId());
            List<AreaTreeResponseVO> areaVOList = new ArrayList<>();
            areaList.forEach(area -> {
               AreaTreeResponseVO areaVO = BeanUtil.copy(area, AreaTreeResponseVO.class);
               areaVOList.add(areaVO);
            });
            monomerVO.setChildren(areaVOList);
            monomerVOList.add(monomerVO);
         });
         responseVO.setChildren(monomerVOList);
         return responseVO;
      }).collect(Collectors.toList());
      return new ListVO<>(responseList);
   }

   @Override
   public ListVO<ProjectTreeResponseVO> drillTaskOrderProjectList() {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ListVO<>();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && teamList.size() != 0) {
         List<Long> processIdList = this.processService
            .list(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
            )
            .stream()
            .map(MesBuildingProcess::getId)
            .collect(Collectors.toList());
         if (processIdList.size() == 0) {
            return new ListVO<>();
         }

         List<Long> teamIdList = teamList.stream()
            .filter(e -> processIdList.contains(e.getProcessId()))
            .map(MesBuildingTeam::getId)
            .collect(Collectors.toList());
         if (teamIdList.size() == 0) {
            return new ListVO<>();
         }

         List<MesBuildingGroupsTeamLink> teamLinkList = this.groupsTeamLinkBiz
            .list(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).in(MesBuildingGroupsTeamLink::getTeamId, teamIdList));
         if (teamLinkList.size() == 0) {
            return new ListVO<>();
         }

         List<AppTaskOrderSummaryDTO> collect = this.taskProcessService
            .drillTaskOrderList(
               null, projectIds, null, null, null, teamLinkList.stream().map(MesBuildingGroupsTeamLink::getGroupsId).distinct().collect(Collectors.toList())
            )
            .stream()
            .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
            .collect(Collectors.toList());
         List<Long> taskOrderIds = collect.stream().map(AppTaskOrderSummaryDTO::getId).collect(Collectors.toList());
         List<ProjectDetailDO> projectList = this.projectService
            .taskOrderProjectList(taskOrderIds, ProcessTypeEnum.DRILL_HOLE.getType())
            .stream()
            .map(e -> BeanUtil.copy(e, ProjectDetailDO.class))
            .distinct()
            .collect(Collectors.toList());
         List<ProjectTreeResponseVO> responseList = projectList.stream()
            .map(
               project -> {
                  ProjectTreeResponseVO responseVO = BeanUtil.copy(project, ProjectTreeResponseVO.class);
                  List<PlanMonomer> monomerList = this.monomerService
                     .list((Wrapper<PlanMonomer>)new LambdaQueryWrapper<PlanMonomer>().eq(PlanMonomer::getProjectId, project.getId()));
                  List<MonomerTreeResponseVO> monomerVOList = new ArrayList<>();
                  monomerList.forEach(monomer -> {
                     MonomerTreeResponseVO monomerVO = BeanUtil.copy(monomer, MonomerTreeResponseVO.class);
                     List<PlanArea> areaList = this.areaService.list(Wrappers.lambdaQuery(PlanArea.builder().monomerId(monomer.getId()).build()));
                     List<AreaTreeResponseVO> areaVOList = new ArrayList<>();
                     areaList.forEach(area -> {
                        AreaTreeResponseVO areaVO = BeanUtil.copy(area, AreaTreeResponseVO.class);
                        areaVOList.add(areaVO);
                     });
                     monomerVO.setChildren(areaVOList);
                     monomerVOList.add(monomerVO);
                  });
                  responseVO.setChildren(monomerVOList);
                  return responseVO;
               }
            )
            .collect(Collectors.toList());
         return new ListVO<>(responseList);
      } else {
         return new ListVO<>();
      }
   }

   @Override
   public ProductMonitorKanbanBySummaryDTO getArtifactTaskMete(Long workshopId) {
      return this.baseService.getArtifactTaskMete(workshopId);
   }

   @Override
   public List<ArtifactSchedulingDO> artifactSchedulingProjectList(LocalDateTime dateTime, Long workshopId, List<Long> projectIds) {
      return this.baseService.artifactSchedulingProjectList(dateTime, workshopId, projectIds);
   }

   @Override
   public List<YearQuantityAndMeteDTO> artifactSchedulingMeteList(LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId) {
      return this.baseService.artifactSchedulingMeteList(dateTime, workshopId, projectId, monomerId);
   }

   @Override
   public List<ArtifactSchedulingDetailDTO> artifactSchedulingDetail(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      return this.baseService.artifactSchedulingDetail(dateTime, workshopId, projectId, monomerId, areaId, serialNumber);
   }

   @Override
   public YearQuantityAndMeteDTO artifactSchedulingMeteByMonth(String startDate, String endDate, Long workshopId, Long projectId, Long monomerId) {
      return this.baseService.artifactSchedulingMeteByMonth(startDate, endDate, workshopId, projectId, monomerId);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean artifactChange(Long changeId, Long artifactId, Integer newQuantity) {
      List<MesBuildingTask> taskList = this.baseService
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .eq(MesBuildingTask::getProductId, artifactId)
               .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         );
      List<MesBuildingArtifactScheduling> schedulingList = this.artifactSchedulingBiz
         .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).eq(MesBuildingArtifactScheduling::getProductId, artifactId));
      Integer schedulingQuantity = schedulingList.stream().mapToInt(MesBuildingArtifactScheduling::getQuantity).sum();
      Integer taskQuantity = taskList.stream().mapToInt(MesBuildingTask::getTaskQuantity).sum();
      if (newQuantity < schedulingQuantity) {
         if (taskQuantity > newQuantity) {
            this.temporaryReduceTask(changeId, artifactId, TaskTypeEnum.ARTIFACT.getType(), taskQuantity - newQuantity);
         } else {
            AtomicReference<Integer> reduceSchedulingQuantity = new AtomicReference<>(schedulingQuantity - newQuantity);
            schedulingList.stream().filter(scheduling -> scheduling.getQuantity() > scheduling.getTaskQuantity()).forEach(scheduling -> {
               if (reduceSchedulingQuantity.get() > 0) {
                  if (scheduling.getQuantity() - scheduling.getTaskQuantity() >= reduceSchedulingQuantity.get()) {
                     scheduling.setQuantity(scheduling.getQuantity() - reduceSchedulingQuantity.get());
                     reduceSchedulingQuantity.set(0);
                     if (scheduling.getQuantity().equals(scheduling.getTaskQuantity())) {
                        scheduling.setIssueStatus(Boolean.TRUE);
                     }
                  } else {
                     scheduling.setQuantity(scheduling.getTaskQuantity());
                     reduceSchedulingQuantity.set(reduceSchedulingQuantity.get() - (scheduling.getQuantity() - scheduling.getTaskQuantity()));
                  }

                  this.artifactSchedulingBiz.updateById(scheduling);
               }
            });
         }
      }

      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingProductionTaskDTO> projectProgressingList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, List<Long> singleArtifactIds, Long workshopId
   ) {
      return this.baseMapper.projectProgressingList(projectId, monomerId, areaId, serialNumber, singleArtifactIds, workshopId);
   }

   private Boolean temporaryReduceTask(Long changeId, Long artifactId, Integer taskTypeEnum, Integer quantity) {
      AtomicReference<Integer> reduceQuantity = new AtomicReference<>(quantity);
      List<MesBuildingTask> taskList = this.baseService
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .eq(MesBuildingTask::getProductId, artifactId)
               .eq(MesBuildingTask::getTaskTypeEnum, taskTypeEnum)
               .orderByAsc(MesBuildingTask::getCompleteQuantity)
         );
      Map<Long, Integer> artShopChangeMap = this.artShopCanChange(artifactId);
      taskList.stream().filter(filter -> filter.getTaskQuantity() - filter.getInProductionQuantity() > 0).collect(Collectors.toList()).forEach(task -> {
         Integer canChange = artShopChangeMap.get(task.getWorkshopId());
         canChange = canChange == null ? task.getTaskQuantity() - task.getInProductionQuantity() : canChange;
         if (canChange > 0 && reduceQuantity.get() > 0) {
            if (reduceQuantity.get() >= task.getTaskQuantity() - task.getInProductionQuantity()) {
               int reduce = task.getTaskQuantity() - task.getInProductionQuantity();
               reduce = reduce <= canChange ? reduce : canChange;
               this.temporaryReduceAssembleTaskQuantity(changeId, task.getId(), reduce);
               this.temporaryReducePartQuantity(changeId, task.getId(), reduce);
               this.temporaryReduceTaskQuantity(changeId, task.getId(), reduce);
               this.reducePurlin(task, reduce);
               reduceQuantity.set(reduceQuantity.get() - reduce);
               this.reduceArtifactSchedulingTaskQuantity(changeId, task.getSchedulingId(), reduce);
               task.setTaskQuantity(task.getInProductionQuantity());
               canChange = canChange - reduce;
               if (artShopChangeMap.get(task.getWorkshopId()) != null) {
                  artShopChangeMap.put(task.getWorkshopId(), canChange);
               }
            } else {
               Integer reduce = reduceQuantity.get();
               reduce = reduce <= canChange ? reduce : canChange;
               task.setTaskQuantity(task.getTaskQuantity() - reduce);
               this.temporaryReduceAssembleTaskQuantity(changeId, task.getId(), reduce);
               this.temporaryReducePartQuantity(changeId, task.getId(), reduce);
               this.temporaryReduceTaskQuantity(changeId, task.getId(), reduce);
               this.reducePurlin(task, reduce);
               this.reduceArtifactSchedulingTaskQuantity(changeId, task.getSchedulingId(), reduce);
               reduceQuantity.set(reduceQuantity.get() - reduce);
               canChange = canChange - reduce;
               if (artShopChangeMap.get(task.getWorkshopId()) != null) {
                  artShopChangeMap.put(task.getWorkshopId(), canChange);
               }
            }
         }
      });
      taskList.stream().filter(filter -> filter.getTaskQuantity() > 0).collect(Collectors.toList()).forEach(oldTask -> {
         Integer canChange = artShopChangeMap.get(oldTask.getWorkshopId());
         canChange = canChange == null ? oldTask.getTaskQuantity() : canChange;
         if (canChange > 0 && reduceQuantity.get() > 0) {
            if (reduceQuantity.get() >= oldTask.getTaskQuantity()) {
               Integer reduce = oldTask.getTaskQuantity();
               reduce = reduce > canChange ? canChange : reduce;
               this.temporaryReduceAssembleTaskQuantity(changeId, oldTask.getId(), reduce);
               this.temporaryReducePartQuantity(changeId, oldTask.getId(), reduce);
               this.temporaryReduceTaskQuantity(changeId, oldTask.getId(), reduce);
               this.reducePurlin(oldTask, reduce);
               reduceQuantity.set(reduceQuantity.get() - reduce);
               this.reduceArtifactSchedulingTaskQuantity(changeId, oldTask.getSchedulingId(), reduce);
               oldTask.setTaskQuantity(oldTask.getInProductionQuantity());
               canChange = canChange - reduce;
               if (artShopChangeMap.get(oldTask.getWorkshopId()) != null) {
                  artShopChangeMap.put(oldTask.getWorkshopId(), canChange);
               }
            } else {
               Integer reduce = reduceQuantity.get();
               reduce = reduce > canChange ? canChange : reduce;
               oldTask.setTaskQuantity(oldTask.getTaskQuantity() - reduce);
               this.temporaryReduceAssembleTaskQuantity(changeId, oldTask.getId(), reduce);
               this.temporaryReducePartQuantity(changeId, oldTask.getId(), reduce);
               this.reducePurlin(oldTask, reduce);
               this.temporaryReduceTaskQuantity(changeId, oldTask.getId(), reduce);
               this.reduceArtifactSchedulingTaskQuantity(changeId, oldTask.getSchedulingId(), reduce);
               reduceQuantity.set(reduceQuantity.get() - reduce);
               canChange = canChange - reduce;
               if (artShopChangeMap.get(oldTask.getWorkshopId()) != null) {
                  artShopChangeMap.put(oldTask.getWorkshopId(), canChange);
               }
            }
         }
      });
      if (reduceQuantity.get() > 0) {
         Preconditions.checkArgument(false, "本构件下的直发件,已发运剩余库存数,不支持本次变更减少数量!!!");
      }

      return Boolean.TRUE;
   }

   @NotNull
   @Override
   public Map<Long, Integer> artShopCanChange(Long artifactId) {
      Map<Long, Integer> artShopChangeMap = new HashMap<>();
      List<TechArtifactMachinePartLink> allPartLinks = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, artifactId));
      if (CollectionUtils.isNotEmpty(allPartLinks)) {
         Map<Long, TechArtifactMachinePartLink> parLinkMap = allPartLinks.stream()
            .collect(Collectors.toMap(TechArtifactMachinePartLink::getMachinePartId, Function.identity()));
         List<TechMachinePart> allParts = this.machinePartService
            .list(
               Wrappers.lambdaQuery(TechMachinePart.class)
                  .in(TechMachinePart::getId, allPartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()))
            );
         List<TechMachinePart> senParts = allParts.stream()
            .filter(sx -> sx.getRelationType().equals(2))
            .filter(TechMachinePart::getBoolSendDirectly)
            .collect(Collectors.toList());
         List<TechMachinePart> needProcessParts = senParts.stream().filter(TechMachinePart::getBoolProcess).collect(Collectors.toList());
         Map<String, Integer> partCanChangeMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(needProcessParts)) {
            List<Long> sendIds = needProcessParts.stream().map(TechMachinePart::getId).collect(Collectors.toList());
            List<MesBuildingTaskNeedMachinePartScheduling> allNeed = this.needMachinePartSchedulingService
               .list(Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartScheduling.class).in(MesBuildingTaskNeedMachinePartScheduling::getProductId, sendIds));
            Map<String, Integer> partShopQuantityMap = allNeed.stream()
               .collect(
                  Collectors.toMap(sx -> sx.getWorkshopId() + "_" + sx.getProductId(), MesBuildingTaskNeedMachinePartScheduling::getNeedQuantity, Integer::sum)
               );
            List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.MACHINE_PART.getType())
                     .in(MesBuildingWarehouseSummary::getProductId, sendIds)
               );
            Map<String, Integer> carQuantityMap = summaryList.stream()
               .collect(
                  Collectors.toMap(
                     sx -> sx.getWorkshopId() + "_" + sx.getProductId(), sx -> sx.getPackageQuantity().intValue() + sx.getCargoQuantity().intValue()
                  )
               );

            for (String s : partShopQuantityMap.keySet()) {
               Integer taskQuantity = partShopQuantityMap.get(s);
               Integer cargoQuantity = carQuantityMap.get(s);
               if (cargoQuantity != null) {
                  Preconditions.checkArgument(taskQuantity - cargoQuantity >= 0, "变更失败!!请联系管理员!!!");
                  partShopQuantityMap.put(s, taskQuantity - cargoQuantity);
               }

               partShopQuantityMap.forEach(partCanChangeMap::put);
            }
         }

         List<TechMachinePart> unProcessParts = senParts.stream().filter(sx -> !sx.getBoolProcess()).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(unProcessParts)) {
            List<Long> unProcessSendIds = unProcessParts.stream().map(TechMachinePart::getId).collect(Collectors.toList());
            List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.MACHINE_PART.getType())
                     .in(MesBuildingWarehouseSummary::getProductId, unProcessSendIds)
               );
            Map<String, Integer> unSummaryMap = summaryList.stream()
               .collect(
                  Collectors.toMap(
                     sx -> sx.getWorkshopId() + "_" + sx.getProductId(),
                     sx -> sx.getQuantity().intValue() - sx.getCargoQuantity().intValue() - sx.getPackageQuantity().intValue()
                  )
               );

            for (String s : unSummaryMap.keySet()) {
               partCanChangeMap.put(s, unSummaryMap.get(s));
            }
         }

         for (String s : partCanChangeMap.keySet()) {
            String[] split = s.split("_");
            Long shopId = Long.valueOf(split[0]);
            Long productId = Long.valueOf(split[1]);
            Integer canChangeQuantity = partCanChangeMap.get(s);
            TechArtifactMachinePartLink link = parLinkMap.get(productId);
            if (artShopChangeMap.get(shopId) == null) {
               artShopChangeMap.put(shopId, canChangeQuantity / link.getQuantity());
            } else {
               Integer last = artShopChangeMap.get(shopId);
               artShopChangeMap.put(shopId, last < canChangeQuantity / link.getQuantity() ? last : canChangeQuantity / link.getQuantity());
            }
         }
      }

      List<TechAssembleDetail> allAssembleDetais = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getArtifactId, artifactId));
      if (CollectionUtils.isNotEmpty(allAssembleDetais)) {
         Map<Long, TechAssembleDetail> assDetailMap = allAssembleDetais.stream()
            .collect(Collectors.toMap(TechAssembleDetail::getAssembleId, Function.identity()));
         List<TechAssemble> allAss = this.assembleService
            .list(
               Wrappers.lambdaQuery(TechAssemble.class)
                  .in(TechAssemble::getId, allAssembleDetais.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()))
            );
         List<TechAssemble> senAssList = allAss.stream().filter(TechAssemble::getBoolSendDirectly).collect(Collectors.toList());
         List<TechAssemble> needProcessAsss = senAssList.stream().filter(TechAssemble::getBoolProcess).collect(Collectors.toList());
         Map<String, Integer> partCanChangeMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(needProcessAsss)) {
            List<Long> sendIds = needProcessAsss.stream().map(TechAssemble::getId).collect(Collectors.toList());
            List<MesBuildingTask> allTasks = this.taskService.list(Wrappers.lambdaQuery(MesBuildingTask.class).in(MesBuildingTask::getProductId, sendIds));
            Map<String, Integer> partShopQuantityMap = allTasks.stream()
               .collect(Collectors.toMap(sx -> sx.getWorkshopId() + "_" + sx.getProductId(), MesBuildingTask::getTaskQuantity, Integer::sum));
            List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.ASSEMBLE.getType())
                     .in(MesBuildingWarehouseSummary::getProductId, sendIds)
               );
            Map<String, Integer> carQuantityMap = summaryList.stream()
               .collect(
                  Collectors.toMap(
                     sx -> sx.getWorkshopId() + "_" + sx.getProductId(), sx -> sx.getPackageQuantity().intValue() + sx.getCargoQuantity().intValue()
                  )
               );

            for (String s : partShopQuantityMap.keySet()) {
               Integer taskQuantity = partShopQuantityMap.get(s);
               Integer cargoQuantity = carQuantityMap.get(s);
               if (cargoQuantity != null) {
                  Preconditions.checkArgument(taskQuantity - cargoQuantity >= 0, "变更失败!!请联系管理员!!!");
                  partShopQuantityMap.put(s, taskQuantity - cargoQuantity);
               }

               partShopQuantityMap.forEach(partCanChangeMap::put);
            }
         }

         List<TechAssemble> unProcessAsss = senAssList.stream().filter(sx -> !sx.getBoolProcess()).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(unProcessAsss)) {
            List<Long> unProcessSendIds = unProcessAsss.stream().map(TechAssemble::getId).collect(Collectors.toList());
            List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.ASSEMBLE.getType())
                     .in(MesBuildingWarehouseSummary::getProductId, unProcessSendIds)
               );
            Map<String, Integer> unSummaryMap = summaryList.stream()
               .collect(
                  Collectors.toMap(
                     sx -> sx.getWorkshopId() + "_" + sx.getProductId(),
                     sx -> sx.getQuantity().intValue() - sx.getCargoQuantity().intValue() - sx.getPackageQuantity().intValue()
                  )
               );

            for (String s : unSummaryMap.keySet()) {
               partCanChangeMap.put(s, unSummaryMap.get(s));
            }
         }

         for (String s : partCanChangeMap.keySet()) {
            String[] split = s.split("_");
            Long shopId = Long.valueOf(split[0]);
            Long productId = Long.valueOf(split[1]);
            Integer canChangeQuantity = partCanChangeMap.get(s);
            TechAssembleDetail detail = assDetailMap.get(productId);
            if (artShopChangeMap.get(shopId) == null) {
               artShopChangeMap.put(shopId, canChangeQuantity / detail.getQuantity());
            } else {
               Integer last = artShopChangeMap.get(shopId);
               artShopChangeMap.put(shopId, last < canChangeQuantity / detail.getQuantity() ? last : canChangeQuantity / detail.getQuantity());
            }
         }
      }

      return artShopChangeMap;
   }

   private Boolean reduceArtifactSchedulingTaskQuantity(Long changeId, Long id, Integer quantity) {
      MesBuildingArtifactScheduling scheduling = this.artifactSchedulingBiz.getById(id);
      scheduling.setTaskQuantity(scheduling.getTaskQuantity() - quantity);
      scheduling.setQuantity(scheduling.getTaskQuantity());
      if (scheduling.getQuantity() != 0) {
         scheduling.setIssueStatus(Boolean.FALSE);
         this.artifactSchedulingBiz.updateById(scheduling);
      } else {
         this.artifactSchedulingBiz.removeById(id);
      }

      return Boolean.TRUE;
   }

   private Boolean temporaryReduceAssembleTaskQuantity(Long changeId, Long taskId, Integer quantity) {
      MesBuildingTask artifactTask = this.taskService.getById(taskId);
      MesBuildingTaskOrder artifactTaskOrder = this.taskOrderService.getById(artifactTask.getTaskOrderId());
      List<MesBuildingTaskOrder> assembleTaskOrderList = this.taskOrderService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
               .eq(MesBuildingTaskOrder::getTopTaskOrderId, artifactTaskOrder.getTopTaskOrderId())
               .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType())
         );
      if (assembleTaskOrderList.size() > 0) {
         List<MesBuildingTask> assembleTask = this.taskService
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .in(MesBuildingTask::getTaskOrderId, assembleTaskOrderList.stream().map(MesBuildingTaskOrder::getId).collect(Collectors.toList()))
            );
         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getArtifactId, artifactTask.getProductId()));
         if (assembleDetailList.size() > 0) {
            assembleDetailList.forEach(
               assembleDetail -> {
                  List<MesBuildingTask> taskList = this.taskService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingTask.class)
                           .in(MesBuildingTask::getTaskOrderId, assembleTaskOrderList.stream().map(MesBuildingTaskOrder::getId).collect(Collectors.toList()))
                           .eq(MesBuildingTask::getProductId, assembleDetail.getAssembleId())
                           .orderByAsc(MesBuildingTask::getProductId)
                           .orderByAsc(MesBuildingTask::getCompleteQuantity)
                     );
                  AtomicReference<Integer> reduceQuantity = new AtomicReference<>(quantity * assembleDetail.getQuantity());
                  taskList.forEach(task -> {
                     if (reduceQuantity.get() > 0) {
                        if (task.getTaskQuantity() >= reduceQuantity.get()) {
                           this.temporaryReduceTaskQuantity(changeId, task.getId(), reduceQuantity.get());
                           reduceQuantity.set(0);
                        } else {
                           this.temporaryReduceTaskQuantity(changeId, task.getId(), task.getTaskQuantity());
                           reduceQuantity.set(reduceQuantity.get() - task.getTaskQuantity());
                        }
                     }
                  });
               }
            );
         }
      }

      return Boolean.TRUE;
   }

   private Boolean temporaryReducePartQuantity(Long changeId, Long taskId, Integer quantity) {
      MesBuildingTask task = this.taskService.getById(taskId);
      if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<TechArtifactMachinePartLink> machinePartLinkList = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, task.getProductId()));
         machinePartLinkList.forEach(
            machinePartLink -> {
               Integer reduceQuantity = quantity * machinePartLink.getQuantity();
               MesBuildingTaskNeedMachinePartSchedulingUnProduction unProduction = this.unProductionBiz
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartSchedulingUnProduction.class)
                        .eq(MesBuildingTaskNeedMachinePartSchedulingUnProduction::getProductId, machinePartLink.getMachinePartId())
                        .eq(MesBuildingTaskNeedMachinePartSchedulingUnProduction::getTaskId, task.getId())
                  );
               if (unProduction != null) {
                  if (unProduction.getQuantity() >= reduceQuantity) {
                     unProduction.setQuantity(unProduction.getQuantity() - reduceQuantity);
                     reduceQuantity = 0;
                  } else {
                     unProduction.setQuantity(0);
                     reduceQuantity = reduceQuantity - unProduction.getQuantity();
                  }

                  this.unProductionBiz.updateById(unProduction);
                  if (unProduction.getQuantity() == 0) {
                     this.unProductionBiz.removeById(unProduction.getQuantity());
                  }
               }

               if (reduceQuantity > 0) {
                  MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = this.taskNeedMachinePartSchedulingBiz
                     .getOne(
                        Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartScheduling.class)
                           .eq(MesBuildingTaskNeedMachinePartScheduling::getProductId, machinePartLink.getMachinePartId())
                           .eq(MesBuildingTaskNeedMachinePartScheduling::getTaskId, task.getId())
                     );
                  if (needMachinePartScheduling != null) {
                     needMachinePartScheduling.setNeedQuantity(needMachinePartScheduling.getNeedQuantity() - reduceQuantity);
                     this.reducePartTaskQuantity(
                        changeId,
                        needMachinePartScheduling.getId(),
                        needMachinePartScheduling.getProductId(),
                        needMachinePartScheduling.getTaskId(),
                        reduceQuantity
                     );
                     if (needMachinePartScheduling.getNeedQuantity() == 0) {
                        this.taskNeedMachinePartSchedulingBiz.removeById(needMachinePartScheduling.getId());
                     } else if (needMachinePartScheduling.getNeedQuantity() > 0) {
                        if (needMachinePartScheduling.getSchedulingQuantity() > needMachinePartScheduling.getNeedQuantity()) {
                           needMachinePartScheduling.setSchedulingQuantity(needMachinePartScheduling.getNeedQuantity());
                        }

                        this.taskNeedMachinePartSchedulingBiz.updateById(needMachinePartScheduling);
                     } else {
                        Preconditions.checkArgument(false, "操作失败!!!请联系管理员!!!!");
                     }
                  }
               }
            }
         );
      }

      if (task.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssembleMachinePartLink> machinePartLinkList = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, task.getProductId()));
         machinePartLinkList.forEach(
            machinePartLink -> {
               if (task.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                  Integer reduceQuantity = quantity * machinePartLink.getQuantity();
                  MesBuildingTaskNeedMachinePartSchedulingUnProduction unProduction = this.unProductionBiz
                     .getOne(
                        Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartSchedulingUnProduction.class)
                           .eq(MesBuildingTaskNeedMachinePartSchedulingUnProduction::getProductId, machinePartLink.getMachinePartId())
                           .eq(MesBuildingTaskNeedMachinePartSchedulingUnProduction::getTaskId, task.getId())
                     );
                  if (unProduction != null) {
                     if (unProduction.getQuantity() >= reduceQuantity) {
                        unProduction.setQuantity(unProduction.getQuantity() - reduceQuantity);
                        reduceQuantity = 0;
                     } else {
                        unProduction.setQuantity(0);
                        reduceQuantity = reduceQuantity - unProduction.getQuantity();
                     }

                     this.unProductionBiz.updateById(unProduction);
                     if (unProduction.getQuantity() == 0) {
                        this.unProductionBiz.removeById(unProduction.getQuantity());
                     }
                  }

                  if (reduceQuantity > 0) {
                     MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = this.taskNeedMachinePartSchedulingBiz
                        .getOne(
                           Wrappers.lambdaQuery(MesBuildingTaskNeedMachinePartScheduling.class)
                              .eq(MesBuildingTaskNeedMachinePartScheduling::getProductId, machinePartLink.getMachinePartId())
                              .eq(MesBuildingTaskNeedMachinePartScheduling::getTaskId, task.getId())
                        );
                     if (needMachinePartScheduling != null) {
                        needMachinePartScheduling.setNeedQuantity(needMachinePartScheduling.getNeedQuantity() - reduceQuantity);
                        this.reducePartTaskQuantity(
                           changeId,
                           needMachinePartScheduling.getId(),
                           needMachinePartScheduling.getProductId(),
                           needMachinePartScheduling.getTaskId(),
                           reduceQuantity
                        );
                        if (needMachinePartScheduling.getNeedQuantity() == 0) {
                           this.taskNeedMachinePartSchedulingBiz.removeById(needMachinePartScheduling.getId());
                        } else {
                           if (needMachinePartScheduling.getSchedulingQuantity() > needMachinePartScheduling.getNeedQuantity()) {
                              needMachinePartScheduling.setSchedulingQuantity(needMachinePartScheduling.getNeedQuantity());
                           }

                           this.taskNeedMachinePartSchedulingBiz.updateById(needMachinePartScheduling);
                        }
                     }
                  }
               }
            }
         );
      }

      return Boolean.TRUE;
   }

   private Boolean reducePartTaskQuantity(Long changeId, Long needId, Long partId, Long needTaskId, Integer reduceQuantity) {
      MesBuildingMachinePartSchedulingArtifactTaskLink partSchedulingArtifactTaskLink = this.partSchedulingArtifactTaskLinkBiz
         .getOne(
            Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingArtifactTaskLink.class)
               .eq(MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId, needId)
         );
      if (partSchedulingArtifactTaskLink != null) {
         partSchedulingArtifactTaskLink.setQuantity(partSchedulingArtifactTaskLink.getQuantity() - reduceQuantity);
         if (partSchedulingArtifactTaskLink.getQuantity() == 0) {
            this.partSchedulingArtifactTaskLinkBiz.removeById(partSchedulingArtifactTaskLink.getId());
         } else {
            this.partSchedulingArtifactTaskLinkBiz.updateById(partSchedulingArtifactTaskLink);
         }

         MesBuildingMachinePartSchedulingLink partSchedulingLink = this.partSchedulingLinkBiz
            .getOne(
               Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLink.class)
                  .eq(MesBuildingMachinePartSchedulingLink::getId, partSchedulingArtifactTaskLink.getSchedulingLinkId())
            );
         if (partSchedulingLink != null) {
            partSchedulingLink.setQuantity(partSchedulingLink.getQuantity() - reduceQuantity);
            if (partSchedulingLink.getQuantity() == 0) {
               this.partSchedulingLinkBiz.removeById(partSchedulingLink.getId());
            } else if (partSchedulingLink.getQuantity() > 0) {
               this.partSchedulingLinkBiz.updateById(partSchedulingLink);
            } else {
               Preconditions.checkArgument(false, "操作失败!!!请联系管理员!!!!!");
            }

            MesBuildingMachinePartScheduling machinePartScheduling = this.partSchedulingBiz.getById(partSchedulingArtifactTaskLink.getSchedulingId());
            machinePartScheduling.setQuantity(machinePartScheduling.getQuantity() - reduceQuantity);
            if (machinePartScheduling.getQuantity() == 0) {
               this.partSchedulingBiz.removeById(machinePartScheduling.getId());
            } else {
               this.partSchedulingBiz.updateById(machinePartScheduling);
            }

            Map<Long, MesBuildingNestCutPlate> nestCutPlateMap = this.nestCutPlateBiz
               .list(Wrappers.lambdaQuery(MesBuildingNestCutPlate.class).eq(MesBuildingNestCutPlate::getMachinePartSchedulingId, machinePartScheduling.getId()))
               .stream()
               .collect(Collectors.toMap(MesBuildingNestCutPlate::getId, Function.identity()));

            for (MesBuildingNestCutPlatePart nestCutPlatePart : this.nestCutPlatePartBiz
               .list(
                  Wrappers.lambdaQuery(MesBuildingNestCutPlatePart.class)
                     .eq(MesBuildingNestCutPlatePart::getPartId, partId)
                     .in(MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId, nestCutPlateMap.keySet())
               )) {
               if (reduceQuantity > 0) {
                  Integer trueQuantity = nestCutPlatePart.getQuantity() >= reduceQuantity ? reduceQuantity : nestCutPlatePart.getQuantity();
                  nestCutPlatePart.setQuantity(nestCutPlatePart.getQuantity() - trueQuantity);
                  if (nestCutPlatePart.getQuantity().equals(0)) {
                     this.nestCutPlatePartBiz.removeById(nestCutPlatePart.getId());
                  } else {
                     this.nestCutPlatePartBiz.updateById(nestCutPlatePart);
                  }

                  List<MesBuildingTask> taskList = this.baseService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingTask.class)
                           .eq(MesBuildingTask::getNestCutPlateId, nestCutPlatePart.getMesBuildingNestCutPlateId())
                           .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType())
                           .eq(MesBuildingTask::getProductId, partId)
                     );
                  reduceQuantity = reduceQuantity - trueQuantity;
                  taskList.forEach(task -> this.temporaryReduceTaskQuantity(changeId, task.getId(), trueQuantity));
               }
            }
         }
      }

      return Boolean.TRUE;
   }

   private Boolean temporaryReduceTaskQuantity(Long changeId, Long taskId, Integer reduceQuantity) {
      if (reduceQuantity <= 0) {
         return Boolean.TRUE;
      }

      MesBuildingTask task = this.baseService.getById(taskId);
      task.setTaskQuantity(task.getTaskQuantity() - reduceQuantity);
      if (task.getCompleteQuantity().equals(task.getTaskQuantity())) {
         task.setCompleteTime(LocalDateTime.now());
      }

      List<TechAssembleDetail> assembleDetailList = new ArrayList<>();
      List<TechArtifactMachinePartLink> artifactMachinePartLinkList = new ArrayList<>();
      if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingComplete> completes = this.completeService
            .list(Wrappers.lambdaQuery(MesBuildingComplete.class).eq(MesBuildingComplete::getArtifactTaskId, taskId));
         if (CollectionUtils.isNotEmpty(completes)) {
            assembleDetailList = this.assembleDetailService
               .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getArtifactId, task.getProductId()));
            if (CollectionUtils.isNotEmpty(assembleDetailList)) {
               Map<Long, Integer> assNeedReduce = new HashMap<>();
               assembleDetailList.forEach(e -> {
                  TechAssemble assemble = this.assembleService.getById(e.getAssembleId());
                  if (assemble.getBoolSendDirectly() && !assemble.getBoolProcess()) {
                     assNeedReduce.put(assemble.getId(), e.getQuantity() * reduceQuantity);
                  }
               });
               this.reduceUnProcessSend(changeId, taskId, assNeedReduce, TaskTypeEnum.ASSEMBLE.getType());
            }

            artifactMachinePartLinkList = this.artifactMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, task.getProductId()));
            if (CollectionUtils.isNotEmpty(artifactMachinePartLinkList)) {
               Map<Long, Integer> parNeedReduce = new HashMap<>();
               artifactMachinePartLinkList.forEach(e -> {
                  TechMachinePart machinePart = this.machinePartService.getById(e.getMachinePartId());
                  if (machinePart.getBoolSendDirectly() && !machinePart.getBoolProcess() && machinePart.getRelationType().equals(2)) {
                     parNeedReduce.put(machinePart.getId(), e.getQuantity() * reduceQuantity);
                  }
               });
               this.reduceUnProcessSend(changeId, taskId, parNeedReduce, TaskTypeEnum.MACHINE_PART.getType());
            }
         } else {
            Map<Long, Integer> reduceMap = new HashMap<>();
            reduceMap.put(task.getProductId(), reduceQuantity);
            this.deleteOldData(task.getWorkshopId(), reduceMap);
         }
      }

      if (task.getInProductionQuantity() > task.getTaskQuantity()) {
         if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            Integer taskQuantity = this.taskProcessService
               .list(
                  Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                     .eq(MesBuildingTaskProcess::getProductId, task.getProductId())
                     .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
               )
               .stream()
               .mapToInt(MesBuildingTaskProcess::getInspectionQuantity)
               .sum();
            assembleDetailList.forEach(e -> {
               TechAssemble assemble = this.assembleService.getById(e.getAssembleId());
               assemble.setUsedQuantity(assemble.getUsedQuantity() - e.getQuantity() * (task.getInProductionQuantity() - task.getTaskQuantity()));
               if (assemble.getUsedQuantity() < 0) {
                  assemble.setUsedQuantity(0);
               }

               this.assembleService.updateById(assemble);
            });
            artifactMachinePartLinkList.forEach(
               e -> {
                  TechMachinePart machinePart = this.machinePartService.getById(e.getMachinePartId());
                  if (machinePart.getRelationType().equals(TaskTypeEnum.ARTIFACT.getType())) {
                     machinePart.setUsedQuantity(machinePart.getUsedQuantity() - e.getQuantity() * (task.getInProductionQuantity() - task.getTaskQuantity()));
                     this.machinePartService.updateById(machinePart);
                  }

                  if (machinePart.getRelationType().equals(18)) {
                     machinePart.setProducedQuantity(
                        machinePart.getProducedQuantity() - e.getQuantity() * (task.getInProductionQuantity() - task.getTaskQuantity())
                     );
                     machinePart.setUsedQuantity(machinePart.getUsedQuantity() - e.getQuantity() * (task.getInProductionQuantity() - task.getTaskQuantity()));
                     this.machinePartService.updateById(machinePart);
                  }
               }
            );
         }

         task.setInProductionQuantity(task.getTaskQuantity());
      }

      if (task.getCompleteQuantity() > task.getTaskQuantity()) {
         task.setCompleteQuantity(task.getTaskQuantity());
      }

      if (task.getTaskQuantity() == 0) {
         this.baseService.removeById(task.getId());
      } else {
         this.baseService.updateById(task);
      }

      MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(task.getTaskOrderId());
      taskOrder.setQuantity(taskOrder.getQuantity() - reduceQuantity);
      if (taskOrder.getQuantity() == 0) {
         this.taskOrderBiz.removeById(taskOrder.getId());
      } else {
         this.taskOrderBiz.updateById(taskOrder);
      }

      if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         MesBuildingTopTaskOrder topTaskOrder = this.topTaskOrderBiz.getById(taskOrder.getTopTaskOrderId());
         topTaskOrder.setQuantity(topTaskOrder.getQuantity() - reduceQuantity);
         if (topTaskOrder.getQuantity() == 0) {
            this.topTaskOrderBiz.removeById(topTaskOrder.getId());
         } else {
            this.topTaskOrderBiz.updateById(topTaskOrder);
         }
      }

      List<MesBuildingTaskProcess> processList = this.taskProcessService
         .list(Wrappers.lambdaQuery(MesBuildingTaskProcess.class).eq(MesBuildingTaskProcess::getTaskId, task.getId()));
      processList.forEach(e -> {
         this.reduceAssist(e, reduceQuantity);
         e.setTaskQuantity(e.getTaskQuantity() - reduceQuantity);
         if (e.getNeedQuantity() > e.getTaskQuantity()) {
            e.setNeedQuantity(e.getTaskQuantity());
         }

         if (e.getCompleteQuantity().equals(e.getTaskQuantity())) {
            e.setCompleteTime(LocalDateTime.now());
         }

         if (e.getCompleteQuantity() > task.getInProductionQuantity()) {
            Integer reduce = e.getCompleteQuantity() - task.getInProductionQuantity();
            if (reduce >= e.getProblemQuantity()) {
               this.temporaryReduceQhseTeamReport(changeId, e, null, e.getProblemQuantity());
               reduce = reduce - e.getProblemQuantity();
               e.setCompleteQuantity(e.getCompleteQuantity() - e.getProblemQuantity());
            } else {
               this.temporaryReduceQhseTeamReport(changeId, e, null, reduce);
               e.setCompleteQuantity(e.getCompleteQuantity() - reduce);
               reduce = 0;
            }

            if (reduce > 0) {
               this.temporaryReduceTeamReport(changeId, e, reduce);
               e.setCompleteQuantity(e.getCompleteQuantity() - reduce);
            }

            if (e.getInspectionQuantity() > e.getCompleteQuantity()) {
               e.setInspectionQuantity(e.getCompleteQuantity());
            }
         }

         if (e.getTaskQuantity() == 0) {
            this.taskProcessService.removeById(e.getId());
         } else {
            this.taskProcessService.updateById(e);
         }
      });
      return Boolean.TRUE;
   }

   private void reduceUnProcessSend(Long changeId, Long taskId, Map<Long, Integer> needReduceMap, Integer taskType) {
      List<MesBuildingComplete> completes = this.completeService
         .list(
            Wrappers.lambdaQuery(MesBuildingComplete.class)
               .eq(MesBuildingComplete::getArtifactTaskId, taskId)
               .in(MesBuildingComplete::getTaskTypeEnum, taskType)
         );

      for (MesBuildingComplete complete : completes) {
         complete.setQuantity(complete.getQuantity() - needReduceMap.get(complete.getProductId()));
         Preconditions.checkArgument(complete.getQuantity() >= 0, "操作失败!!!请联系管理员!!!!");
      }

      List<MesBuildingComplete> needDelete = completes.stream().filter(s -> s.getQuantity().equals(0)).collect(Collectors.toList());
      List<MesBuildingComplete> needReduce = completes.stream().filter(s -> !s.getQuantity().equals(0)).collect(Collectors.toList());
      this.completeService.removeByIds(needDelete.stream().map(MesBuildingComplete::getId).collect(Collectors.toList()));
      this.completeService.updateBatchById(needReduce);

      for (MesBuildingComplete complete : completes) {
         Long completeId = complete.getId();
         Integer reduceQuantity = needReduceMap.get(complete.getProductId());
         MesBuildingWarehouseRecord warehouseRecord = this.warehouseRecordService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                  .eq(MesBuildingWarehouseRecord::getCompleteId, completeId)
                  .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
            );
         List<MesBuildingChangeLog> logs = new ArrayList<>();
         if (warehouseRecord != null) {
            MesBuildingChangeLog recordLog = MesBuildingChangeLog.builder()
               .productId(warehouseRecord.getProductId())
               .changeId(changeId)
               .tableId(warehouseRecord.getId())
               .oldQuantity(warehouseRecord.getQuantity().intValue())
               .changeQuantity(reduceQuantity)
               .quantity(warehouseRecord.getQuantity().intValue() - reduceQuantity)
               .userId(UserUtil.getCurrentUserId())
               .taskTypeEnum(warehouseRecord.getProductType())
               .type(ChangeLogTypeEnum.WAREHOUSE_RECORD.getType())
               .build();
            warehouseRecord.setQuantity(warehouseRecord.getQuantity().subtract(BigDecimal.valueOf(reduceQuantity.intValue())));
            if (warehouseRecord.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
               this.warehouseRecordService.removeById(warehouseRecord.getId());
            } else {
               this.warehouseRecordService.updateById(warehouseRecord);
            }

            logs.add(recordLog);
            MesBuildingWarehouseSummary warehouseSummary = this.warehouseSummaryService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .eq(MesBuildingWarehouseSummary::getProductId, warehouseRecord.getProductId())
                     .eq(MesBuildingWarehouseSummary::getWorkshopId, warehouseRecord.getWorkshopId())
                     .eq(MesBuildingWarehouseSummary::getProductType, warehouseRecord.getProductType())
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
               );
            MesBuildingChangeLog summarylog = this.mesBuildingChangeLogService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingChangeLog.class)
                     .eq(MesBuildingChangeLog::getChangeId, changeId)
                     .eq(MesBuildingChangeLog::getTaskTypeEnum, warehouseRecord.getProductType())
                     .eq(MesBuildingChangeLog::getType, ChangeLogTypeEnum.WAREHOUSE_SUMMARY.getType())
                     .eq(MesBuildingChangeLog::getTableId, warehouseSummary.getId())
               );
            if (summarylog == null) {
               summarylog = MesBuildingChangeLog.builder()
                  .productId(warehouseRecord.getProductId())
                  .changeId(changeId)
                  .tableId(warehouseSummary.getId())
                  .oldQuantity(warehouseSummary.getQuantity().intValue())
                  .changeQuantity(reduceQuantity)
                  .quantity(warehouseSummary.getQuantity().intValue() - reduceQuantity)
                  .userId(UserUtil.getCurrentUserId())
                  .taskTypeEnum(warehouseRecord.getProductType())
                  .type(ChangeLogTypeEnum.WAREHOUSE_SUMMARY.getType())
                  .build();
            } else {
               summarylog.setChangeQuantity(summarylog.getChangeQuantity() + reduceQuantity);
               summarylog.setQuantity(summarylog.getQuantity() - reduceQuantity);
            }

            warehouseSummary.setQuantity(warehouseSummary.getQuantity().subtract(BigDecimal.valueOf(reduceQuantity.intValue())));
            Preconditions.checkArgument(warehouseSummary.getQuantity().intValue() >= 0, "操作失败!!!库存数检验出错!!请联系管理员!!!!");
            if (warehouseSummary.getQuantity().intValue() == 0) {
               this.warehouseSummaryService.removeById(warehouseSummary.getId());
            } else {
               this.warehouseSummaryService.updateById(warehouseSummary);
            }

            logs.add(summarylog);
         }

         this.mesBuildingChangeLogService.saveOrUpdateBatch(logs);
      }
   }

   private Boolean temporaryReduceQhseTeamReport(Long changeId, MesBuildingTaskProcess taskProcess, Long teamId, Integer reduceQuantity) {
      List<MesBuildingQhse> qhseList = this.qhseService
         .list(
            Wrappers.lambdaQuery(MesBuildingQhse.class)
               .eq(MesBuildingQhse::getTaskProcessId, taskProcess.getId())
               .eq(teamId != null, MesBuildingQhse::getTeamId, teamId)
               .orderByAsc(BaseEntity::getCreateTime)
         );
      AtomicReference<Integer> reduce = new AtomicReference<>(reduceQuantity);
      qhseList.forEach(qhse -> {
         if (reduce.get() > 0) {
            if (reduce.get() >= qhse.getProblemQuantity()) {
               this.qhseService.removeById(qhse.getId());
               this.temporaryReduceTeamReportSummary(taskProcess, qhse.getTeamId(), null, null, qhse.getProblemQuantity());
               if (teamId == null) {
                  this.temporaryReduceTeamReport(changeId, taskProcess, qhse.getProblemQuantity());
               }

               reduce.set(reduce.get() - qhse.getProblemQuantity());
            } else {
               qhse.setProblemQuantity(qhse.getProblemQuantity() - reduce.get());
               this.temporaryReduceTeamReportSummary(taskProcess, qhse.getTeamId(), null, null, reduce.get());
               if (teamId == null) {
                  this.temporaryReduceTeamReport(changeId, taskProcess, reduce.get());
               }

               this.qhseService.updateById(qhse);
               reduce.set(0);
            }
         }
      });
      return Boolean.TRUE;
   }

   private Boolean temporaryReduceTeamReport(Long changeId, MesBuildingTaskProcess taskProcess, Integer reduceQuantity) {
      List<MesBuildingProduceTeamReport> teamReportList = this.produceTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .eq(MesBuildingProduceTeamReport::getTaskProcessId, taskProcess.getId())
               .orderByAsc(BaseEntity::getCreateTime)
         );
      List<MesBuildingProduceTeamReport> teamReports = teamReportList.stream().filter(s -> s.getAssistId() == null).collect(Collectors.toList());
      AtomicReference<Integer> reduce = new AtomicReference<>(reduceQuantity);
      teamReports.forEach(
         teamReport -> {
            if (reduce.get() > 0) {
               if (reduce.get() >= teamReport.getQuantity()) {
                  this.produceTeamReportService.removeById(teamReport.getId());
                  this.temporaryReduceInspectionTeamReport(taskProcess, teamReport.getTeamId(), teamReport.getInspectionQuantity());
                  this.inProductionService
                     .remove(Wrappers.lambdaQuery(MesBuildingInProduction.class).eq(MesBuildingInProduction::getTeamReportId, teamReport.getTeamId()));
                  this.temporaryReduceCompleteTeamReport(changeId, taskProcess, teamReport.getTeamId(), teamReport.getQuantity());
                  reduce.set(reduce.get() - teamReport.getQuantity());
               } else {
                  teamReport.setQuantity(teamReport.getQuantity() - reduce.get());
                  this.temporaryReduceInspectionTeamReport(taskProcess, teamReport.getTeamId(), teamReport.getInspectionQuantity());
                  this.inProductionService
                     .update(
                        Wrappers.lambdaUpdate(MesBuildingInProduction.class)
                           .set(MesBuildingInProduction::getQuantity, teamReport.getQuantity())
                           .eq(MesBuildingInProduction::getTeamReportId, teamReport.getTeamId())
                     );
                  this.temporaryReduceCompleteTeamReport(changeId, taskProcess, teamReport.getTeamId(), reduce.get());
                  if (teamReport.getInspectionQuantity() > teamReport.getQuantity()) {
                     teamReport.setInspectionQuantity(teamReport.getQuantity());
                  }

                  this.produceTeamReportService.updateById(teamReport);
                  reduce.set(0);
               }
            }
         }
      );
      List<MesBuildingProduceTeamReport> assReports = teamReportList.stream().filter(s -> s.getAssistId() != null).collect(Collectors.toList());
      assReports = assReports.stream()
         .sorted(Comparator.comparing(MesBuildingProduceTeamReport::getAssistId).thenComparing(Comparator.comparing(BaseEntity::getCreateTime)).reversed())
         .collect(Collectors.toList());
      assReports.forEach(
         teamReport -> {
            if (reduce.get() > 0) {
               if (reduce.get() >= teamReport.getQuantity()) {
                  this.produceTeamReportService.removeById(teamReport.getId());
                  this.temporaryReduceInspectionTeamReport(taskProcess, teamReport.getTeamId(), teamReport.getInspectionQuantity());
                  this.inProductionService
                     .remove(Wrappers.lambdaQuery(MesBuildingInProduction.class).eq(MesBuildingInProduction::getTeamReportId, teamReport.getTeamId()));
                  this.temporaryReduceCompleteTeamReport(changeId, taskProcess, teamReport.getTeamId(), teamReport.getQuantity());
                  reduce.set(reduce.get() - teamReport.getQuantity());
               } else {
                  teamReport.setQuantity(teamReport.getQuantity() - reduce.get());
                  this.temporaryReduceInspectionTeamReport(taskProcess, teamReport.getTeamId(), teamReport.getInspectionQuantity());
                  this.inProductionService
                     .update(
                        Wrappers.lambdaUpdate(MesBuildingInProduction.class)
                           .set(MesBuildingInProduction::getQuantity, teamReport.getQuantity())
                           .eq(MesBuildingInProduction::getTeamReportId, teamReport.getTeamId())
                     );
                  this.temporaryReduceCompleteTeamReport(changeId, taskProcess, teamReport.getTeamId(), reduce.get());
                  if (teamReport.getInspectionQuantity() > teamReport.getQuantity()) {
                     teamReport.setInspectionQuantity(teamReport.getQuantity());
                  }

                  this.produceTeamReportService.updateById(teamReport);
                  reduce.set(0);
               }
            }
         }
      );
      return Boolean.TRUE;
   }

   private Boolean temporaryReduceCompleteTeamReport(Long changeId, MesBuildingTaskProcess taskProcess, Long teamId, Integer reduceQuantity) {
      List<MesBuildingComplete> completeList = this.completeService
         .list(
            Wrappers.lambdaQuery(MesBuildingComplete.class)
               .eq(MesBuildingComplete::getTaskId, taskProcess.getTaskId())
               .eq(MesBuildingComplete::getTeamId, teamId)
               .orderByAsc(BaseEntity::getCreateTime)
         );
      AtomicReference<Integer> reduce = new AtomicReference<>(reduceQuantity);
      completeList.forEach(complete -> {
         if (reduce.get() > 0) {
            if (reduce.get() >= complete.getQuantity()) {
               this.completeService.removeById(complete.getId());
               reduce.set(reduce.get() - complete.getQuantity());
               this.reduceWarehouseRecord(changeId, complete.getId(), complete.getQuantity());
            } else {
               complete.setQuantity(complete.getQuantity() - reduce.get());
               this.completeService.updateById(complete);
               this.reduceWarehouseRecord(changeId, complete.getId(), reduce.get());
               reduce.set(0);
            }
         }

         if (complete.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            TechAssemble assemble = this.assembleService.getById(complete.getProductId());
            assemble.setProducedQuantity(assemble.getProducedQuantity() - reduceQuantity);
            this.assembleService.updateById(assemble);
         }

         if (complete.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
            TechMachinePart machinePart = this.machinePartService.getById(complete.getProductId());
            machinePart.setProducedQuantity(machinePart.getProducedQuantity() - reduceQuantity);
            this.machinePartService.updateById(machinePart);
         }

         if (complete.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = this.artifactService.getById(complete.getProductId());
            artifact.setProducedQuantity(artifact.getProducedQuantity() - reduceQuantity);
            this.artifactService.updateById(artifact);
         }
      });
      return Boolean.TRUE;
   }

   private Boolean reduceWarehouseRecord(Long changeId, Long completeId, Integer reduceQuantity) {
      MesBuildingWarehouseRecord warehouseRecord = this.warehouseRecordService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
               .eq(MesBuildingWarehouseRecord::getCompleteId, completeId)
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
         );
      List<MesBuildingChangeLog> logs = new ArrayList<>();
      if (warehouseRecord != null) {
         MesBuildingChangeLog recordLog = MesBuildingChangeLog.builder()
            .productId(warehouseRecord.getProductId())
            .changeId(changeId)
            .tableId(warehouseRecord.getId())
            .oldQuantity(warehouseRecord.getQuantity().intValue())
            .changeQuantity(reduceQuantity)
            .quantity(warehouseRecord.getQuantity().intValue() - reduceQuantity)
            .userId(UserUtil.getCurrentUserId())
            .taskTypeEnum(warehouseRecord.getProductType())
            .type(ChangeLogTypeEnum.WAREHOUSE_RECORD.getType())
            .build();
         warehouseRecord.setQuantity(warehouseRecord.getQuantity().subtract(BigDecimal.valueOf(reduceQuantity.intValue())));
         if (warehouseRecord.getQuantity().intValue() == 0) {
            this.warehouseRecordService.removeById(warehouseRecord.getId());
         } else {
            this.warehouseRecordService.updateById(warehouseRecord);
         }

         logs.add(recordLog);
         MesBuildingWarehouseSummary warehouseSummary = this.warehouseSummaryService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                  .eq(MesBuildingWarehouseSummary::getProductId, warehouseRecord.getProductId())
                  .eq(MesBuildingWarehouseSummary::getProductType, warehouseRecord.getProductType())
                  .eq(MesBuildingWarehouseSummary::getWorkshopId, warehouseRecord.getWorkshopId())
                  .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
            );
         MesBuildingChangeLog summarylog = this.mesBuildingChangeLogService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingChangeLog.class)
                  .eq(MesBuildingChangeLog::getChangeId, changeId)
                  .eq(MesBuildingChangeLog::getTaskTypeEnum, warehouseRecord.getProductType())
                  .eq(MesBuildingChangeLog::getType, ChangeLogTypeEnum.WAREHOUSE_SUMMARY.getType())
                  .eq(MesBuildingChangeLog::getTableId, warehouseSummary.getId())
            );
         if (summarylog == null) {
            summarylog = MesBuildingChangeLog.builder()
               .productId(warehouseRecord.getProductId())
               .changeId(changeId)
               .tableId(warehouseSummary.getId())
               .oldQuantity(warehouseSummary.getQuantity().intValue())
               .changeQuantity(reduceQuantity)
               .quantity(warehouseSummary.getQuantity().intValue() - reduceQuantity)
               .userId(UserUtil.getCurrentUserId())
               .taskTypeEnum(warehouseRecord.getProductType())
               .type(ChangeLogTypeEnum.WAREHOUSE_SUMMARY.getType())
               .build();
         } else {
            summarylog.setChangeQuantity(summarylog.getChangeQuantity() + reduceQuantity);
            summarylog.setQuantity(summarylog.getQuantity() - reduceQuantity);
         }

         warehouseSummary.setQuantity(warehouseSummary.getQuantity().subtract(BigDecimal.valueOf(reduceQuantity.intValue())));
         if (warehouseSummary.getQuantity().intValue() == 0) {
            this.warehouseSummaryService.removeById(warehouseSummary.getId());
         } else {
            this.warehouseSummaryService.updateById(warehouseSummary);
         }

         logs.add(summarylog);
      }

      this.mesBuildingChangeLogService.saveOrUpdateBatch(logs);
      return Boolean.TRUE;
   }

   private Boolean temporaryReduceInspectionTeamReport(MesBuildingTaskProcess taskProcess, Long teamId, Integer reduceQuantity) {
      List<MesBuildingProduceInspectionTeamReport> inspectionTeamReportList = this.produceInspectionTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReport.class)
               .eq(MesBuildingProduceInspectionTeamReport::getTaskProcessId, taskProcess.getId())
               .eq(MesBuildingProduceInspectionTeamReport::getTeamId, teamId)
               .orderByAsc(BaseEntity::getCreateTime)
         );
      AtomicReference<Integer> reduce = new AtomicReference<>(reduceQuantity);
      inspectionTeamReportList.forEach(inspectionTeamReport -> {
         if (reduce.get() > 0) {
            if (reduce.get() >= inspectionTeamReport.getInspectionQuantity()) {
               this.produceInspectionTeamReportService.removeById(inspectionTeamReport.getId());
               reduce.set(reduce.get() - inspectionTeamReport.getInspectionQuantity());
               this.reduceAssembleTeamReportSummary(taskProcess, inspectionTeamReport.getTeamId(), null, inspectionTeamReport.getInspectionQuantity(), null);
            } else {
               inspectionTeamReport.setInspectionQuantity(inspectionTeamReport.getInspectionQuantity() - reduce.get());
               this.reduceAssembleTeamReportSummary(taskProcess, inspectionTeamReport.getTeamId(), null, reduce.get(), null);
               this.produceInspectionTeamReportService.updateById(inspectionTeamReport);
               reduce.set(0);
            }
         }
      });
      return Boolean.TRUE;
   }

   private Boolean reduceAssembleTeamReportSummary(
      MesBuildingTaskProcess taskProcess, Long teamId, Integer reduceQuantity, Integer reduceInspectionQuantity, Integer reduceProblemQuantity
   ) {
      MesBuildingProduceTeamReportSummary teamReportSummary = this.produceTeamReportSummaryService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReportSummary.class)
               .eq(MesBuildingProduceTeamReportSummary::getTaskProcessId, taskProcess.getId())
               .eq(MesBuildingProduceTeamReportSummary::getTeamId, teamId)
         );
      if (reduceQuantity != null) {
         teamReportSummary.setQuantity(teamReportSummary.getQuantity() - reduceQuantity);
      }

      if (reduceInspectionQuantity != null) {
         teamReportSummary.setInspectionQuantity(teamReportSummary.getInspectionQuantity() - reduceInspectionQuantity);
      }

      if (reduceProblemQuantity != null) {
         teamReportSummary.setProblemQuantity(teamReportSummary.getProblemQuantity() - reduceProblemQuantity);
      }

      this.produceTeamReportSummaryService.updateById(teamReportSummary);
      return Boolean.TRUE;
   }

   private Boolean temporaryReduceTeamReportSummary(
      MesBuildingTaskProcess taskProcess, Long teamId, Integer reduceQuantity, Integer reduceInspectionQuantity, Integer reduceProblemQuantity
   ) {
      MesBuildingProduceTeamReportSummary teamReportSummary = this.produceTeamReportSummaryService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReportSummary.class)
               .eq(MesBuildingProduceTeamReportSummary::getTaskProcessId, taskProcess.getId())
               .eq(MesBuildingProduceTeamReportSummary::getTeamId, teamId)
         );
      if (reduceQuantity != null) {
         teamReportSummary.setQuantity(teamReportSummary.getQuantity() - reduceQuantity);
      }

      if (reduceInspectionQuantity != null) {
         teamReportSummary.setInspectionQuantity(teamReportSummary.getInspectionQuantity() - reduceInspectionQuantity);
      }

      if (reduceProblemQuantity != null) {
         teamReportSummary.setProblemQuantity(teamReportSummary.getProblemQuantity() - reduceProblemQuantity);
      }

      this.produceTeamReportSummaryService.updateById(teamReportSummary);
      return Boolean.TRUE;
   }

   @Override
   public List<ProductClassificationDTO> productTypeByTaskOrderId(Integer taskTypeEnum, Long taskOrderId, Integer boolLastProcessEnum) {
      MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(taskOrderId);
      Preconditions.checkArgument(taskOrder != null, "操作失败：id有误!");
      List<Long> teamIdLinkList = this.groupsTeamLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).eq(MesBuildingGroupsTeamLink::getGroupsId, taskOrder.getGroupsId()))
         .stream()
         .map(MesBuildingGroupsTeamLink::getTeamId)
         .collect(Collectors.toList());
      if (teamIdLinkList.size() == 0) {
         return new ArrayList<>();
      }

      List<MesBuildingTeam> teamList = this.utilsBiz
         .selectTeamIdByUserId(UserUtil.getCurrentUserId())
         .stream()
         .filter(e -> teamIdLinkList.contains(e.getId()))
         .collect(Collectors.toList());
      return teamList.size() == 0
         ? new ArrayList<>()
         : this.taskProcessService
            .productTypeByTaskOrderId(
               teamList.stream().map(MesBuildingTeam::getProcessId).collect(Collectors.toList()),
               taskOrder.getGroupsId(),
               taskTypeEnum,
               taskOrderId,
               boolLastProcessEnum
            );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revokeTaskPocess(Long id) {
      List<MesBuildingProduceTeamReport> teamReports = this.produceTeamReportService
         .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).eq(MesBuildingProduceTeamReport::getReportNumber, id));
      List<Long> reportIds = teamReports.stream().map(MesBuildingProduceTeamReport::getId).collect(Collectors.toList());
      Preconditions.checkArgument(teamReports.stream().allMatch(s -> s.getProblemQuantity().equals(0)), "操作失败!测回的任务存在问题!!");
      int reduceQuantity = teamReports.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(teamReports), "操作失败");
      Preconditions.checkArgument(teamReports.stream().noneMatch(s -> s.getInspectionQuantity() > 0), "操作失败,请刷新页面后重试!!!");
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(teamReports.get(0).getTaskProcessId());
      taskProcess.setCompleteQuantity(taskProcess.getCompleteQuantity() - reduceQuantity);
      this.taskProcessService.updateById(taskProcess);
      this.checkProductStatus(Arrays.asList(taskProcess.getProductId()), taskProcess.getTaskTypeEnum());
      ContractProject project = this.projectService.getById(taskProcess.getProjectId());
      this.produceTeamReportService.removeByIds(reportIds);
      this.teamReportPriceService
         .remove(Wrappers.lambdaQuery(MesBuildingProduceTeamReportPrice.class).eq(MesBuildingProduceTeamReportPrice::getTeamReoprtId, id));
      if (taskProcess.getSequence().equals(0)) {
         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            List<TechArtifactMachinePartLink> machinePartLinks = this.artifactMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, taskProcess.getProductId()));
            if (CollectionUtils.isNotEmpty(machinePartLinks)) {
               List<TechMachinePart> techMachineParts = this.machinePartService
                  .listByIds(machinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
               Map<Long, TechMachinePart> partMap = techMachineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

               for (TechArtifactMachinePartLink machinePartLink : machinePartLinks) {
                  TechMachinePart techMachinePart = partMap.get(machinePartLink.getMachinePartId());
                  techMachinePart.setUsedQuantity(techMachinePart.getUsedQuantity() - reduceQuantity * machinePartLink.getQuantity());
               }

               this.machinePartService.updateBatchById(new ArrayList<>(partMap.values()));
            }

            List<TechAssembleDetail> assembleDetails = this.assembleDetailService
               .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getArtifactId, taskProcess.getProductId()));
            if (CollectionUtils.isNotEmpty(assembleDetails)) {
               List<TechAssemble> techAssembles = this.assembleService
                  .listByIds(assembleDetails.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
               Map<Long, TechAssemble> assMap = techAssembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

               for (TechAssembleDetail assembleDetail : assembleDetails) {
                  TechAssemble techAssemble = assMap.get(assembleDetail.getAssembleId());
                  techAssemble.setUsedQuantity(techAssemble.getUsedQuantity() - reduceQuantity * assembleDetail.getQuantity());
               }

               this.assembleService.updateBatchById(new ArrayList<>(assMap.values()));
            }
         }

         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            List<TechAssembleMachinePartLink> machinePartLinks = this.assembleMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, taskProcess.getProductId()));
            if (CollectionUtils.isNotEmpty(machinePartLinks)) {
               List<TechMachinePart> techMachineParts = this.machinePartService
                  .listByIds(machinePartLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList()));
               Map<Long, TechMachinePart> partMap = techMachineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

               for (TechAssembleMachinePartLink machinePartLink : machinePartLinks) {
                  TechMachinePart techMachinePart = partMap.get(machinePartLink.getMachinePartId());
                  techMachinePart.setUsedQuantity(techMachinePart.getUsedQuantity() - reduceQuantity * machinePartLink.getQuantity());
               }

               this.machinePartService.updateBatchById(new ArrayList<>(partMap.values()));
            }
         }
      }

      List<MesBuildingInProduction> inProductionList = this.inProductionService
         .list((Wrapper<MesBuildingInProduction>)Wrappers.<MesBuildingInProduction>lambdaQuery().in(MesBuildingInProduction::getTeamReportId, reportIds));
      this.inProductionService.removeByIds(inProductionList.stream().map(MesBuildingInProduction::getId).collect(Collectors.toList()));
      MesBuildingTask task = this.taskService.getById(taskProcess.getTaskId());
      task.setInProductionQuantity(task.getInProductionQuantity() - reduceQuantity);
      Preconditions.checkArgument(task.getInProductionQuantity() >= 0, "操作失败,请联系管理员");
      this.taskService.updateById(task);
      MesBuildingProduceTeamReportSummary summary = this.produceTeamReportSummaryService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReportSummary.class)
               .eq(MesBuildingProduceTeamReportSummary::getTaskProcessId, teamReports.get(0).getTaskProcessId())
               .eq(MesBuildingProduceTeamReportSummary::getProductionLineId, teamReports.get(0).getProductionLineId())
               .eq(MesBuildingProduceTeamReportSummary::getTeamId, teamReports.get(0).getTeamId())
         );
      summary.setQuantity(summary.getQuantity() - reduceQuantity);
      if (summary.getQuantity().equals(0)) {
         this.produceTeamReportSummaryService.removeById(summary.getId());
      } else {
         this.produceTeamReportSummaryService.updateById(summary);
      }

      List<Integer> reportNumbers = teamReports.stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
      List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
               .eq(taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()), MesBuildingTaskNumberLink::getArtifactId, taskProcess.getProductId())
               .eq(
                  taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()),
                  MesBuildingTaskNumberLink::getArtifactTaskProcessId,
                  taskProcess.getId()
               )
               .in(taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()), MesBuildingTaskNumberLink::getArtifactNumber, reportNumbers)
               .eq(taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()), MesBuildingTaskNumberLink::getAssembleId, taskProcess.getProductId())
               .eq(
                  taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()),
                  MesBuildingTaskNumberLink::getAssembleTaskProcessId,
                  taskProcess.getId()
               )
               .in(taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()), MesBuildingTaskNumberLink::getAssembleNumber, reportNumbers)
         );
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         Preconditions.checkArgument(
            numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().count() == reportNumbers.size(), "操作失败!!!"
         );
         Preconditions.checkArgument(numberLinks.stream().noneMatch(MesBuildingTaskNumberLink::getBoolArtifactInspection), "操作失败产品已质检!!!");
         numberLinks.forEach(s -> s.setBoolArtifactReport(Boolean.FALSE));
         if (taskProcess.getSequence().equals(0)) {
            numberLinks.forEach(s -> s.setBoolArtifactInproduce(Boolean.FALSE));
         }
      } else {
         Preconditions.checkArgument(
            numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().count() == reportNumbers.size(), "操作失败!!!"
         );
         Preconditions.checkArgument(numberLinks.stream().noneMatch(MesBuildingTaskNumberLink::getBoolAssembleInspection), "操作失败产品已质检!!!");
         numberLinks.forEach(s -> s.setBoolAssembleReport(Boolean.FALSE));
         if (taskProcess.getSequence().equals(0)) {
            numberLinks.forEach(s -> s.setBoolAssembleInproduce(Boolean.FALSE));
         }
      }

      this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
      List<MesBuildingProduceTeamReport> assistReports = teamReports.stream()
         .filter(e -> e.getAssistId() != null && 0L != e.getAssistId())
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(assistReports)) {
         List<Long> assistIds = assistReports.stream().map(MesBuildingProduceTeamReport::getAssistId).distinct().collect(Collectors.toList());
         List<MesBuildingAssist> mesBuildingAssists = this.assistService.listByIds(assistIds);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingAssists) && mesBuildingAssists.size() == assistIds.size(), "操作失败,协同记录不存在!");
         Preconditions.checkArgument(mesBuildingAssists.stream().allMatch(e -> e.getProduceQuantity() > 0), "操作失败,协同记录异常!");
         Map<Long, MesBuildingAssist> assistMap = mesBuildingAssists.stream().collect(Collectors.toMap(MesBuildingAssist::getId, Function.identity()));
         List<Integer> assistReportNumbers = assistReports.stream().map(MesBuildingProduceTeamReport::getNumber).distinct().collect(Collectors.toList());
         List<MesBuildingAssistNumberDetail> details = this.assistNumberDetailService
            .list(
               Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class)
                  .eq(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcess.getId())
                  .in(MesBuildingAssistNumberDetail::getNumber, assistReportNumbers)
                  .eq(MesBuildingAssistNumberDetail::getBoolFinishEnum, Boolean.TRUE)
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(details) && details.size() == assistReportNumbers.size(), "操作失败,协同记录不存在!");
         Map<Long, List<MesBuildingAssistNumberDetail>> assistNumberDetailMap = details.stream()
            .collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getAssistId));
         assistNumberDetailMap.forEach((assistId, numberDetails) -> {
            MesBuildingAssist assist = assistMap.get(assistId);
            Preconditions.checkArgument(assist != null, "操作失败,协同记录不存在!");
            Preconditions.checkArgument(assist.getProduceQuantity() >= numberDetails.size(), "操作失败,协同记录不存在!");
            numberDetails.forEach(e -> e.setBoolFinishEnum(Boolean.FALSE));
            assist.setBoolFinishEnum(Boolean.FALSE);
            assist.setProduceQuantity(assist.getProduceQuantity() - numberDetails.size());
         });
         this.assistService.updateBatchById(mesBuildingAssists);
         this.assistNumberDetailService.updateBatchById(details);
      }

      return Boolean.TRUE;
   }

   @Override
   public TrackSummaryDTO trackSummary(Long projectId) {
      List<SteelAnalysisDTO> analysis = this.sysSteelAnalysisBiz.analysis(projectId, null, null, null).getContent();
      List<SteelAnalysisDTO> stees = analysis.stream()
         .filter(s -> Integer.valueOf(s.getBasicId().intValue()).equals(BasicClassEnum.STEEL_PLATE.getType()))
         .collect(Collectors.toList());
      BigDecimal steeList = stees.stream().map(SteelAnalysisDTO::getListMete).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
      BigDecimal steePicking = stees.stream().map(SteelAnalysisDTO::getUseMete).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
      List<SteelAnalysisDTO> sections = analysis.stream()
         .filter(s -> Integer.valueOf(s.getBasicId().intValue()).equals(BasicClassEnum.SECTION_STEEL.getType()))
         .collect(Collectors.toList());
      BigDecimal sectionList = sections.stream().map(SteelAnalysisDTO::getListMete).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
      BigDecimal sectionPicking = sections.stream()
         .map(SteelAnalysisDTO::getUseMete)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .setScale(2, RoundingMode.HALF_UP);
      return TrackSummaryDTO.builder()
         .summaryList(steeList.add(sectionList))
         .summaryPicking(steePicking.add(sectionPicking))
         .steelList(steeList)
         .steelPicking(steePicking)
         .sectionList(sectionList)
         .sectionPicking(sectionPicking)
         .build();
   }

   @Override
   public List<TrackSteelDTO> trackSteel(Long projectId) {
      List<TrackSteelDTO> list = new ArrayList<>();
      List<SteelAnalysisDTO> analysis = this.sysSteelAnalysisBiz.analysis(projectId, null, null, null).getContent();
      List<SteelAnalysisDTO> stees = analysis.stream()
         .filter(sx -> Integer.valueOf(sx.getBasicId().intValue()).equals(BasicClassEnum.STEEL_PLATE.getType()))
         .collect(Collectors.toList());
      Map<String, List<SteelAnalysisDTO>> collect = stees.stream().collect(Collectors.groupingBy(sx -> sx.getMaterial() + "_" + sx.getThickness()));

      for (String s : collect.keySet()) {
         String[] split = s.split("_");
         String material = split[0];
         String thickness = split[1];
         List<SteelAnalysisDTO> dtos = collect.get(s);
         BigDecimal listMete = dtos.stream().map(SteelAnalysisDTO::getListMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal sectionPicking = dtos.stream().map(SteelAnalysisDTO::getUseMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal stockMete = dtos.stream().map(SteelAnalysisDTO::getStockMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         TrackSteelDTO build = TrackSteelDTO.builder()
            .listMete(listMete)
            .material(material)
            .thickness(thickness)
            .useMete(sectionPicking)
            .stockMete(stockMete)
            .build();
         list.add(build);
      }

      return list.stream().sorted(Comparator.comparing(sx -> Double.valueOf(sx.getThickness()))).collect(Collectors.toList());
   }

   @Override
   public List<TrackSteelDTO> trackSection(Long projectId) {
      List<TrackSteelDTO> list = new ArrayList<>();
      List<SteelAnalysisDTO> analysis = this.sysSteelAnalysisBiz.analysis(projectId, null, null, null).getContent();
      List<SteelAnalysisDTO> sections = analysis.stream()
         .filter(sx -> Integer.valueOf(sx.getBasicId().intValue()).equals(BasicClassEnum.SECTION_STEEL.getType()))
         .collect(Collectors.toList());
      Map<String, List<SteelAnalysisDTO>> collect = sections.stream().collect(Collectors.groupingBy(SteelAnalysisDTO::getName));

      for (String s : collect.keySet()) {
         List<SteelAnalysisDTO> dtos = collect.get(s);
         BigDecimal listMete = dtos.stream().map(SteelAnalysisDTO::getListMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal sectionPicking = dtos.stream().map(SteelAnalysisDTO::getUseMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal stockMete = dtos.stream().map(SteelAnalysisDTO::getStockMete).reduce(BigDecimal.ZERO, BigDecimal::add);
         TrackSteelDTO build = TrackSteelDTO.builder()
            .listMete(listMete)
            .material(null)
            .thickness(null)
            .name(s)
            .useMete(sectionPicking)
            .stockMete(stockMete)
            .build();
         list.add(build);
      }

      return list;
   }

   @Override
   public List<PersonalDTO> personal(LocalDateTime time, Long workShopId) {
      List<Long> inspectionTeamIds = this.inspectionTeamService.list().stream().map(MesBuildingInspectionTeam::getId).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(inspectionTeamIds)) {
         return new ArrayList<>();
      }

      List<MesBuildingInspectionTeamUserLink> list = this.inspectionTeamUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingInspectionTeamUserLink.class).in(MesBuildingInspectionTeamUserLink::getInspectionTeamId, inspectionTeamIds));
      List<User> users = list.stream().map(e -> User.builder().id(e.getUserId()).name(e.getUserName()).build()).distinct().collect(Collectors.toList());
      List<Long> collect = users.stream().map(User::getId).collect(Collectors.toList());
      Map<Long, String> idAndName = users.stream().collect(Collectors.toMap(User::getId, User::getName, (s1, s2) -> s2));
      List<ReportDataDTO> personal = this.produceInspectionTeamReportService.personal(time, workShopId, collect);
      Map<Long, List<ReportDataDTO>> userAndData = personal.stream().collect(Collectors.groupingBy(ReportDataDTO::getUserId));
      List<PersonalDTO> personalDTOS = new ArrayList<>();

      for (Long id : collect) {
         int sum = 0;
         BigDecimal weight = BigDecimal.ZERO;
         int adoptSum = 0;
         BigDecimal adoptWeight = BigDecimal.ZERO;
         int unAdoptSum = 0;
         BigDecimal unAdoptWeight = BigDecimal.ZERO;
         List<ReportDataDTO> reportDataDTOS = userAndData.get(id);
         if (CollectionUtils.isNotEmpty(reportDataDTOS)) {
            sum = reportDataDTOS.stream().mapToInt(ReportDataDTO::getQuantity).sum();
            weight = reportDataDTOS.stream()
               .map(s -> s.getWeight().multiply(new BigDecimal(s.getQuantity())))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .setScale(2, 5);
            List<ReportDataDTO> adopt = reportDataDTOS.stream().filter(s -> s.getBoolenQhse().equals(0)).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(adopt)) {
               adoptSum = adopt.stream().mapToInt(ReportDataDTO::getQuantity).sum();
               adoptWeight = adopt.stream()
                  .map(s -> s.getWeight().multiply(new BigDecimal(s.getQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .setScale(2, 5);
            }

            List<ReportDataDTO> unAdopt = reportDataDTOS.stream().filter(s -> s.getBoolenQhse().equals(1)).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(unAdopt)) {
               unAdoptSum = unAdopt.stream().mapToInt(ReportDataDTO::getQuantity).sum();
               unAdoptWeight = unAdopt.stream()
                  .map(s -> s.getWeight().multiply(new BigDecimal(s.getQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
                  .setScale(2, 5);
            }
         }

         PersonalDTO build = PersonalDTO.builder()
            .userId(id)
            .userName(idAndName.get(id))
            .totalQuantity(sum)
            .totalWeight(weight)
            .inspectionQuantity(adoptSum)
            .inspectionWeight(adoptWeight)
            .problemQuantity(unAdoptSum)
            .problemWeight(unAdoptWeight)
            .build();
         personalDTOS.add(build);
      }

      return personalDTOS;
   }

   @Override
   public Map personalSummary(LocalDateTime time, Long workShopId) {
      List<Long> collect = this.userService.list().stream().map(User::getId).collect(Collectors.toList());
      List<ReportDataDTO> personal = this.produceInspectionTeamReportService.personal(time, workShopId, collect);
      int sumQuantity = personal.stream().mapToInt(ReportDataDTO::getQuantity).sum();
      BigDecimal sumWeight = personal.stream()
         .map(s -> s.getWeight().multiply(new BigDecimal(s.getQuantity())))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .setScale(2, 5);
      List<ReportDataDTO> adopt = personal.stream().filter(s -> s.getBoolenQhse().equals(0)).collect(Collectors.toList());
      int adoptQuantity = adopt.stream().mapToInt(ReportDataDTO::getQuantity).sum();
      BigDecimal adoptWeight = adopt.stream()
         .map(s -> s.getWeight().multiply(new BigDecimal(s.getQuantity())))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .setScale(2, 5);
      List<ReportDataDTO> unAdopt = personal.stream().filter(s -> s.getBoolenQhse().equals(1)).collect(Collectors.toList());
      int unAdoptQuantity = unAdopt.stream().mapToInt(ReportDataDTO::getQuantity).sum();
      BigDecimal unAdoptWeight = unAdopt.stream()
         .map(s -> s.getWeight().multiply(new BigDecimal(s.getQuantity())))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .setScale(2, 5);
      Map<String, Object> map = new HashMap<>();
      map.put("sumQuantity", sumQuantity);
      map.put("sumWeight", sumWeight);
      map.put("adoptQuantity", adoptQuantity);
      map.put("adoptWeight", adoptWeight);
      map.put("unAdoptQuantity", unAdoptQuantity);
      map.put("unAdoptWeight", unAdoptWeight);
      return map;
   }

   @Override
   public List<AnalysisQhseDTO> analysisQhse(LocalDateTime time, Long workShopId) {
      List<AnalysisQhseDTO> dtoList = new ArrayList<>();
      Map<String, String> dictionary = this.dictionaryService.getValueLabelByName(DictionaryEnum.MES_QHSE_PRODUCT_PROBLEM_TYPE.getName());
      List<MesBuildingQhse> qhseList = this.qhseService
         .getListByTimesAndType(time, workShopId, QhseTypeEnum.QUALITY.getType() + QhseTypeEnum.SPECIAL_QUALITY.getType());

      for (String key : dictionary.keySet()) {
         dtoList.add(AnalysisQhseDTO.builder().type(dictionary.get(key)).quantity(this.decide(key, qhseList)).build());
      }

      return dtoList;
   }

   private Integer decide(String a, List<MesBuildingQhse> qhseList) {
      Integer quantity = 0;
      StringBuilder stringBuilder = new StringBuilder();
      qhseList.forEach(e -> stringBuilder.append(",").append(e.getQualityType()));
      if (a != null && qhseList.size() != 0) {
         String[] typeArray = stringBuilder.toString().split(",");

         for (String s : typeArray) {
            if (a.equals(s)) {
               quantity = quantity + 1;
            }
         }

         return quantity;
      } else {
         return quantity;
      }
   }

   @Override
   public List<QhseDetailsDTO> analysisData(LocalDateTime time, Long workShopId) {
      return this.qhseService.qhseSummaryList(time, QhseTypeEnum.QUALITY.getType() + QhseTypeEnum.SPECIAL_QUALITY.getType(), workShopId);
   }

   @Override
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

   @Override
   public List<ProductMonitorKanbanDTO> getProductMonitorKanban(Long workshopId, Integer status, String name, List<Long> projectIds) {
      return this.baseService.getProductMonitorKanban(workshopId, status, name, projectIds);
   }

   @Override
   public List<MesBuildingProductionTaskDTO> getProductMonitorKanbanDetail(Long workshopId, Long projectId, Long monomerId, Long areaId) {
      return this.baseService.getProductMonitorKanbanDetail(workshopId, projectId, monomerId, areaId);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void saveAllSendPartArtifact(Long taskId, Integer quantity) {
      MesBuildingTask comTask = this.baseService.getById(taskId);
      new ArrayList();
      List<MesBuildingTask> taskList;
      if (comTask.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
         taskList = this.taskOrderBiz.getArtListByPartTask(taskId);
      } else {
         taskList = this.taskOrderBiz.getArtListByAssTask(taskId);
      }

      if (CollectionUtils.isNotEmpty(taskList)) {
         List<Long> taskIds = taskList.stream().map(MesBuildingTask::getId).distinct().collect(Collectors.toList());
         Map<Long, Integer> map = this.minKitting(taskList);
         List<MesBuildingSinglePartArtifactPrint> prints = this.singlePartArtifactPrintService
            .list(
               Wrappers.lambdaQuery(MesBuildingSinglePartArtifactPrint.class)
                  .in(MesBuildingSinglePartArtifactPrint::getTaskId, taskIds)
                  .eq(MesBuildingSinglePartArtifactPrint::getBoolAllReport, false)
            );
         Map<Long, List<MesBuildingSinglePartArtifactPrint>> singTaskMap = prints.stream()
            .collect(Collectors.groupingBy(MesBuildingSinglePartArtifactPrint::getTaskId));

         for (Long singTaskIds : singTaskMap.keySet()) {
            List<MesBuildingSinglePartArtifactPrint> taskPrints = singTaskMap.get(singTaskIds);
            taskPrints = taskPrints.stream()
               .map(s -> s.setQuantity(0))
               .sorted(Comparator.nullsLast(Comparator.comparing(MesBuildingSinglePartArtifactPrint::getNumber)))
               .collect(Collectors.toList());
            Integer canQuantity = map.get(singTaskIds);

            for (MesBuildingSinglePartArtifactPrint print : taskPrints) {
               if (canQuantity > 0) {
                  if (print.getNumber() == null) {
                     Integer needQuantity = print.getTaskQuantity() - print.getReportQuantity();
                     print.setQuantity(canQuantity >= needQuantity ? needQuantity : canQuantity);
                     canQuantity = canQuantity >= needQuantity ? canQuantity - needQuantity : 0;
                  } else {
                     print.setQuantity(1);
                     canQuantity = canQuantity - 1;
                  }
               }
            }

            this.singlePartArtifactPrintService.updateBatchById(taskPrints);
         }
      }
   }

   @Override
   public Map<Long, Integer> minKitting(List<MesBuildingTask> taskList) {
      List<Long> taskIds = taskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList());
      Map<Long, Integer> map = new HashMap<>();
      Map<Long, MesBuildingTask> taskMap = taskList.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity(), (s1, s2) -> s1));
      List<Long> artIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());

      for (Long taskId : taskIds) {
         List<SendPurlinDTO> allSendList = new ArrayList<>();
         List<SendPurlinDTO> assPurlinDTOS = this.baseService.listAssKitByTaskIds(taskId);
         if (CollectionUtils.isNotEmpty(assPurlinDTOS)) {
            List<Long> assIds = assPurlinDTOS.stream().map(SendPurlinDTO::getAssembleOrPartid).collect(Collectors.toList());
            List<Long> needAssIds = this.assembleService
               .listByIds(assIds)
               .stream()
               .filter(s -> !s.getBoolProcess())
               .map(TechAssemble::getId)
               .collect(Collectors.toList());
            assPurlinDTOS = assPurlinDTOS.stream().filter(s -> !needAssIds.contains(s.getAssembleOrPartid())).collect(Collectors.toList());
         }

         List<SendPurlinDTO> parPurlinDTOS = this.baseService.listPartKitByTaskIds(taskId);
         if (CollectionUtils.isNotEmpty(parPurlinDTOS)) {
            List<Long> partIds = parPurlinDTOS.stream().map(SendPurlinDTO::getAssembleOrPartid).collect(Collectors.toList());
            List<Long> unNeedPartIds = this.machinePartService
               .listByIds(partIds)
               .stream()
               .filter(s -> !s.getBoolProcess())
               .map(TechMachinePart::getId)
               .collect(Collectors.toList());
            parPurlinDTOS = parPurlinDTOS.stream().filter(s -> !unNeedPartIds.contains(s.getAssembleOrPartid())).collect(Collectors.toList());
         }

         allSendList.addAll(parPurlinDTOS);
         allSendList.addAll(assPurlinDTOS);
         if (allSendList.stream().anyMatch(s -> s.getAssembleOrPartTaskId() == null)) {
            map.put(taskId, 0);
         } else {
            MesBuildingTask task = taskMap.get(taskId);
            Integer min = Collections.min(
               allSendList.stream().map(s -> (s.getCompleteQuantity() - s.getUseQuantity()) / s.getScale()).collect(Collectors.toList())
            );
            map.put(taskId, min > task.getTaskQuantity() ? task.getTaskQuantity() : min);
         }
      }

      return map;
   }

   @Override
   public Boolean checkBoolChangeWithIdenticalSens(Long id, Integer newQuantity) {
      List<TechMachinePart> sendParList = new ArrayList<>();
      List<TechAssemble> sendAssList = new ArrayList<>();
      List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, id));
      if (CollectionUtils.isNotEmpty(partLinks)) {
         List<TechMachinePart> parList = this.machinePartService
            .listByIds(partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
         sendParList = parList.stream().filter(TechMachinePart::getBoolSendDirectly).filter(s -> s.getRelationType().equals(2)).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(sendParList)) {
            List<TechArtifactMachinePartLink> allSendParDetails = this.artifactMachinePartLinkService
               .list(
                  Wrappers.lambdaQuery(TechArtifactMachinePartLink.class)
                     .in(TechArtifactMachinePartLink::getMachinePartId, sendParList.stream().map(TechMachinePart::getId).collect(Collectors.toList()))
               );
            List<Long> sendLinkArts = allSendParDetails.stream().map(TechArtifactMachinePartLink::getArtifactId).collect(Collectors.toList());
            List<TechArtifactChange> assLinkChanges = this.techArtifactChangeService
               .list(
                  Wrappers.lambdaQuery(TechArtifactChange.class)
                     .in(TechArtifactChange::getArtifactId, sendLinkArts)
                     .eq(TechArtifactChange::getHandleStatusEnum, HandleStatusEnum.UN.getType())
               );
            Preconditions.checkArgument(assLinkChanges.size() == 0, "处理失败!!当前存在与该构件使用同一直发件,且处与变更中的构件,请审核通过后再来处理!!!");
         }
      }

      List<TechAssembleDetail> allAssDetails = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getArtifactId, id));
      if (CollectionUtils.isNotEmpty(allAssDetails)) {
         List<TechAssemble> assList = this.assembleService
            .listByIds(allAssDetails.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
         sendAssList = assList.stream().filter(TechAssemble::getBoolSendDirectly).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(sendAssList)) {
            List<TechAssembleDetail> allSendAssDetails = this.assembleDetailService
               .list(
                  Wrappers.lambdaQuery(TechAssembleDetail.class)
                     .in(TechAssembleDetail::getAssembleId, sendAssList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
               );
            List<Long> sendLinkArts = allSendAssDetails.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList());
            List<TechArtifactChange> assLinkChanges = this.techArtifactChangeService
               .list(
                  Wrappers.lambdaQuery(TechArtifactChange.class)
                     .in(TechArtifactChange::getArtifactId, sendLinkArts)
                     .eq(TechArtifactChange::getHandleStatusEnum, HandleStatusEnum.UN.getType())
               );
            Preconditions.checkArgument(assLinkChanges.size() == 0, "处理失败!!当前存在与该构件使用同一直发件,且处与变更中的构件,请审核通过后再来处理!!!");
         }
      }

      if (CollectionUtils.isEmpty(sendParList) && CollectionUtils.isEmpty(sendAssList)) {
         return true;
      }

      Map<Long, Integer> artShopChangeMap = this.artShopCanChange(id);
      List<MesBuildingTask> taskList = this.baseService
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .eq(MesBuildingTask::getProductId, id)
               .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
               .orderByAsc(MesBuildingTask::getCompleteQuantity)
         );
      List<MesBuildingArtifactScheduling> schedulingList = this.artifactSchedulingBiz
         .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).eq(MesBuildingArtifactScheduling::getProductId, id));
      Integer schedulingQuantity = schedulingList.stream().mapToInt(MesBuildingArtifactScheduling::getQuantity).sum();
      Integer taskQuantity = taskList.stream().mapToInt(MesBuildingTask::getTaskQuantity).sum();
      if (newQuantity > schedulingQuantity) {
         return true;
      }

      if (newQuantity < taskQuantity) {
         AtomicReference<Integer> reduceQuantity = new AtomicReference<>(taskQuantity - newQuantity);
         taskList.stream().filter(filter -> filter.getTaskQuantity() - filter.getInProductionQuantity() > 0).collect(Collectors.toList()).forEach(task -> {
            Integer canChange = artShopChangeMap.get(task.getWorkshopId());
            canChange = canChange == null ? task.getTaskQuantity() - task.getInProductionQuantity() : canChange;
            if (canChange > 0 && reduceQuantity.get() > 0) {
               if (reduceQuantity.get() >= task.getTaskQuantity() - task.getInProductionQuantity()) {
                  int reduce = task.getTaskQuantity() - task.getInProductionQuantity();
                  reduce = reduce <= canChange ? reduce : canChange;
                  reduceQuantity.set(reduceQuantity.get() - reduce);
                  canChange = canChange - reduce;
                  artShopChangeMap.put(task.getWorkshopId(), canChange);
               } else {
                  Integer reduce = reduceQuantity.get();
                  reduce = reduce <= canChange ? reduce : canChange;
                  reduceQuantity.set(reduceQuantity.get() - reduce);
                  canChange = canChange - reduce;
                  artShopChangeMap.put(task.getWorkshopId(), canChange);
               }
            }
         });
         taskList.stream().filter(filter -> filter.getTaskQuantity() > 0).collect(Collectors.toList()).forEach(oldTask -> {
            Integer canChange = artShopChangeMap.get(oldTask.getWorkshopId());
            canChange = canChange == null ? oldTask.getTaskQuantity() : canChange;
            if (canChange > 0 && reduceQuantity.get() > 0) {
               if (reduceQuantity.get() >= oldTask.getTaskQuantity()) {
                  Integer reduce = oldTask.getTaskQuantity();
                  reduce = reduce > canChange ? canChange : reduce;
                  reduceQuantity.set(reduceQuantity.get() - reduce);
                  oldTask.setTaskQuantity(oldTask.getInProductionQuantity());
                  canChange = canChange - reduce;
                  artShopChangeMap.put(oldTask.getWorkshopId(), canChange);
               } else {
                  Integer reduce = reduceQuantity.get();
                  reduce = reduce > canChange ? canChange : reduce;
                  oldTask.setTaskQuantity(oldTask.getTaskQuantity() - reduce);
                  reduceQuantity.set(reduceQuantity.get() - reduce);
                  canChange = canChange - reduce;
                  artShopChangeMap.put(oldTask.getWorkshopId(), canChange);
               }
            }
         });
         if (reduceQuantity.get() != 0) {
            Preconditions.checkArgument(false, "不可操作!!!直发件已装车库存数量不足!!");
         }
      }

      return true;
   }

   private Boolean reduceAssist(MesBuildingTaskProcess taskProcess, Integer reduceQuantity) {
      List<MesBuildingAssist> assistList = this.mesBuildingAssistBiz
         .list(Wrappers.lambdaQuery(MesBuildingAssist.class).eq(MesBuildingAssist::getTaskProcessId, taskProcess.getId()));
      int allUnAssist = assistList.stream().mapToInt(s -> s.getQuantity() - s.getProduceQuantity()).sum();
      int allCanReduce = taskProcess.getTaskQuantity() - taskProcess.getCompleteQuantity() - allUnAssist;
      reduceQuantity = reduceQuantity - allCanReduce;
      if (reduceQuantity > 0) {
         for (MesBuildingAssist assist : assistList) {
            if (reduceQuantity > 0) {
               int canReduce = assist.getQuantity() - assist.getProduceQuantity();
               int trueReduce = reduceQuantity > canReduce ? canReduce : reduceQuantity;
               assist.setQuantity(assist.getQuantity() - trueReduce);
               Preconditions.checkArgument(assist.getQuantity() >= assist.getProduceQuantity(), "操作失败!!!请联系管理员!!!!");
               Preconditions.checkArgument(assist.getQuantity() >= 0, "操作失败!!!请联系管理员!!!!");
               assist.setBoolFinishEnum(assist.getQuantity().equals(assist.getProduceQuantity()));
               reduceQuantity = reduceQuantity - trueReduce;
            }
         }
      }

      List<MesBuildingProduceTeamReport> allReport = this.produceTeamReportService
         .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).eq(MesBuildingProduceTeamReport::getTaskProcessId, taskProcess.getId()));
      if (reduceQuantity > 0) {
         List<MesBuildingProduceTeamReport> teamReports = allReport.stream().filter(s -> s.getAssistId() == null).collect(Collectors.toList());
         int sum = teamReports.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum();
         reduceQuantity = reduceQuantity - sum;
      }

      Map<Long, MesBuildingAssist> assMap = assistList.stream().collect(Collectors.toMap(MesBuildingAssist::getId, Function.identity()));
      if (reduceQuantity > 0) {
         List<MesBuildingProduceTeamReport> assReports = allReport.stream().filter(s -> s.getAssistId() != null).collect(Collectors.toList());

         for (MesBuildingProduceTeamReport assReport : assReports.stream()
            .sorted(Comparator.comparing(MesBuildingProduceTeamReport::getAssistId).thenComparing(Comparator.comparing(BaseEntity::getCreateTime)).reversed())
            .collect(Collectors.toList())) {
            if (reduceQuantity > 0) {
               int canReduce = assReport.getQuantity();
               int trueReduce = reduceQuantity > canReduce ? canReduce : reduceQuantity;
               MesBuildingAssist assist = assMap.get(assReport.getAssistId());
               Preconditions.checkArgument(assist != null, "操作失败!!!请联系管理员");
               assist.setQuantity(assist.getQuantity() - trueReduce);
               assist.setProduceQuantity(assist.getProduceQuantity() - trueReduce);
               assist.setBoolFinishEnum(assist.getQuantity().equals(assist.getProduceQuantity()));
               assMap.put(assReport.getAssistId(), assist);
               reduceQuantity = reduceQuantity - trueReduce;
            }
         }
      }

      if (reduceQuantity > 0) {
         Preconditions.checkArgument(false, "操作失败!!!请联系管理员");
      }

      List<MesBuildingAssist> assists = new ArrayList<>(assMap.values());
      List<MesBuildingAssist> needRemove = assists.stream().filter(s -> s.getQuantity().equals(0)).collect(Collectors.toList());
      List<MesBuildingAssist> needUpdate = assists.stream().filter(s -> !s.getQuantity().equals(0)).collect(Collectors.toList());
      this.mesBuildingAssistService.updateBatchById(needUpdate);
      this.mesBuildingAssistService.removeByIds(needRemove.stream().map(MesBuildingAssist::getId).collect(Collectors.toList()));
      return true;
   }

   @Override
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
         Map<Integer, List<TechMachinePart>> relationTypeMachinePartMap = techMachinePartOther.stream()
            .collect(Collectors.groupingBy(TechMachinePart::getRelationType));
         relationTypeMachinePartMap.forEach(
            (relationType, partList) -> {
               if (MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType().equals(relationType)) {
                  List<Long> productYFBIds = partList.stream().map(TechMachinePart::getId).collect(Collectors.toList());
                  List<TechAssembleMachinePartLink> assemblePartLinks = this.assembleMachinePartLinkService
                     .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getMachinePartId, productYFBIds));
                  Preconditions.checkArgument(CollectionUtils.isNotEmpty(assemblePartLinks), "构件不存在");
                  List<Long> assembleIdsx = assemblePartLinks.stream().map(TechAssembleMachinePartLink::getAssembleId).collect(Collectors.toList());
                  List<TechAssembleDetail> assembleDetailsx = this.assembleDetailService
                     .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getAssembleId, assembleIdsx));
                  List<String> numbersxx = this.artifactService
                     .listByIds(assembleDetailsx.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()))
                     .stream()
                     .filter(s -> !s.getBoolStatusEnum())
                     .map(TechArtifact::getSerialNumber)
                     .collect(Collectors.toList());
                  Preconditions.checkArgument(CollectionUtils.isEmpty(numbersxx), "本部件关联的层级区域:" + String.join(",", numbersxx) + "处于冻结中!!无法操作!!!");
               }

               if (MachinePartRelationTypeEnum.FOR_ARTIFACT.getType().equals(relationType)) {
                  List<Long> productOtherIds = techMachinePartOther.stream().map(TechMachinePart::getId).collect(Collectors.toList());
                  List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
                     .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getMachinePartId, productOtherIds));
                  List<String> numbersx = this.artifactService
                     .listByIds(partLinks.stream().map(TechArtifactMachinePartLink::getArtifactId).collect(Collectors.toList()))
                     .stream()
                     .filter(s -> !s.getBoolStatusEnum())
                     .map(TechArtifact::getSerialNumber)
                     .collect(Collectors.toList());
                  Preconditions.checkArgument(CollectionUtils.isEmpty(numbersx), "本零件关联的构件:" + String.join(",", numbersx) + "处于冻结中!!无法操作!!!");
               }
            }
         );
      } else {
         Preconditions.checkArgument(false, "产品类型不正确!!!!!");
      }

      return true;
   }

   void deleteOldData(Long workShopId, Map<Long, Integer> deleteMap) {
      Set<Long> artIds = deleteMap.keySet();
      List<TechArtifactMachinePartLink> links = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artIds));
      if (CollectionUtils.isNotEmpty(links)) {
         Map<Long, List<TechArtifactMachinePartLink>> linkMap = links.stream().collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         List<Long> partIds = links.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
         List<TechMachinePart> machineParts = this.machinePartService
            .listByIds(partIds)
            .stream()
            .filter(s -> !s.getBoolProcess())
            .filter(TechMachinePart::getBoolSendDirectly)
            .filter(s -> s.getRelationType().equals(2))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(machineParts)) {
            Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(s -> s.getId(), Function.identity()));
            Map<Long, Integer> parReduceMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(machineParts)) {
               for (Long artId : deleteMap.keySet()) {
                  Integer artReduceQunatity = deleteMap.get(artId);
                  List<TechArtifactMachinePartLink> artLinks = linkMap.get(artId);
                  if (CollectionUtils.isNotEmpty(artLinks)) {
                     for (TechArtifactMachinePartLink link : artLinks) {
                        TechMachinePart machinePart = partMap.get(link.getMachinePartId());
                        if (machinePart != null) {
                           Integer reduceQuantity = parReduceMap.get(machinePart.getId());
                           int parReduceQuantity = artReduceQunatity * link.getQuantity();
                           if (reduceQuantity == null) {
                              parReduceMap.put(machinePart.getId(), parReduceQuantity);
                           } else {
                              parReduceMap.put(machinePart.getId(), reduceQuantity + parReduceQuantity);
                           }
                        }
                     }
                  }
               }
            }

            this.oldSendReduceWarehouse(workShopId, parReduceMap, TaskTypeEnum.MACHINE_PART.getType());
         }
      }

      List<TechAssembleDetail> details = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artIds));
      if (CollectionUtils.isNotEmpty(details)) {
         Map<Long, List<TechAssembleDetail>> detailMap = details.stream().collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
         List<Long> assIds = details.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList());
         List<TechAssemble> assembles = this.assembleService
            .listByIds(assIds)
            .stream()
            .filter(s -> !s.getBoolProcess())
            .filter(TechAssemble::getBoolSendDirectly)
            .collect(Collectors.toList());
         Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         Map<Long, Integer> assReduceMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(assembles)) {
            for (Long artId : deleteMap.keySet()) {
               Integer artReduceQunatity = deleteMap.get(artId);
               List<TechAssembleDetail> artDetails = detailMap.get(artId);
               if (CollectionUtils.isNotEmpty(artDetails)) {
                  for (TechAssembleDetail detail : artDetails) {
                     TechAssemble assemble = assembleMap.get(detail.getAssembleId());
                     if (!assemble.getBoolProcess() && assemble.getBoolSendDirectly() && !assemble.getBoolAllPartSendDirectly()) {
                        Integer reduceQuantity = assReduceMap.get(assemble.getId());
                        int parReduceQuantity = artReduceQunatity * detail.getQuantity();
                        if (reduceQuantity == null) {
                           assReduceMap.put(assemble.getId(), parReduceQuantity);
                        } else {
                           assReduceMap.put(assemble.getId(), reduceQuantity + parReduceQuantity);
                        }
                     }
                  }
               }
            }
         }

         this.oldSendReduceWarehouse(workShopId, assReduceMap, TaskTypeEnum.ASSEMBLE.getType());
      }
   }

   private void oldSendReduceWarehouse(Long workShopId, Map<Long, Integer> reduceMap, Integer taskType) {
      if (!reduceMap.isEmpty()) {
         Set<Long> produceIds = reduceMap.keySet();
         List<MesBuildingWarehouseRecord> records = this.warehouseRecordService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                  .in(MesBuildingWarehouseRecord::getProductId, produceIds)
                  .eq(MesBuildingWarehouseRecord::getWorkshopId, workShopId)
                  .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
                  .eq(MesBuildingWarehouseRecord::getProductType, taskType)
                  .isNull(MesBuildingWarehouseRecord::getCompleteId)
            );
         Map<Long, List<MesBuildingWarehouseRecord>> recordMap = records.stream().collect(Collectors.groupingBy(MesBuildingWarehouseRecord::getProductId));
         List<MesBuildingWarehouseSummary> summaries = this.warehouseSummaryService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                  .in(MesBuildingWarehouseSummary::getProductId, produceIds)
                  .eq(MesBuildingWarehouseSummary::getWorkshopId, workShopId)
                  .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                  .eq(MesBuildingWarehouseSummary::getProductType, taskType)
            );
         Map<Long, MesBuildingWarehouseSummary> summaryMap = summaries.stream()
            .collect(Collectors.toMap(MesBuildingWarehouseSummary::getProductId, Function.identity()));
         List<MesBuildingWarehouseRecord> recordList = new ArrayList<>();
         List<MesBuildingWarehouseSummary> summaryList = new ArrayList<>();

         for (Long produceId : reduceMap.keySet()) {
            Integer reduceQuantity = reduceMap.get(produceId);
            MesBuildingWarehouseSummary summary = summaryMap.get(produceId);
            summary.setQuantity(summary.getQuantity().subtract(BigDecimal.valueOf(reduceQuantity.intValue())));
            Preconditions.checkArgument(summary.getQuantity().intValue() >= 0, "操作失败,库存数不支持本次操作请联系管理员!!!");
            summaryList.add(summary);
            List<MesBuildingWarehouseRecord> parLinkReords = recordMap.get(produceId);
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(parLinkReords), "操作失败,库存数不支持本次操作请联系管理员!!!");

            for (MesBuildingWarehouseRecord record : parLinkReords) {
               if (reduceQuantity > 0) {
                  Integer trueReduce = record.getQuantity().intValue() >= reduceQuantity ? reduceQuantity : record.getQuantity().intValue();
                  record.setQuantity(record.getQuantity().subtract(BigDecimal.valueOf(trueReduce.intValue())));
                  reduceQuantity = reduceQuantity - trueReduce;
                  recordList.add(record);
               }
            }

            Preconditions.checkArgument(reduceQuantity == 0, "操作失败,库存数不支持本次操作请联系管理员!!!");
         }

         List<MesBuildingWarehouseRecord> needRemoveRecord = recordList.stream().filter(s -> s.getQuantity().intValue() == 0).collect(Collectors.toList());
         List<MesBuildingWarehouseRecord> needupdateRecord = recordList.stream().filter(s -> s.getQuantity().intValue() > 0).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(needRemoveRecord)) {
            this.warehouseRecordService.removeByIds(needRemoveRecord.stream().map(s -> s.getId()).collect(Collectors.toList()));
         }

         this.warehouseRecordService.updateBatchById(needupdateRecord);
         List<MesBuildingWarehouseSummary> needRemoveSummary = summaryList.stream().filter(s -> s.getQuantity().intValue() == 0).collect(Collectors.toList());
         List<MesBuildingWarehouseSummary> needupdateSummary = summaryList.stream().filter(s -> s.getQuantity().intValue() > 0).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(needRemoveSummary)) {
            this.warehouseSummaryService.removeByIds(needRemoveSummary.stream().map(s -> s.getId()).collect(Collectors.toList()));
         }

         this.warehouseSummaryService.updateBatchById(needupdateSummary);
      }
   }

   private void reducePurlin(MesBuildingTask task, Integer reduceQuantity) {
      Long workshopId = task.getWorkshopId();
      List<MesBuildingSinglePartArtifactPrint> sings = this.singlePartArtifactPrintService
         .list(
            Wrappers.lambdaQuery(MesBuildingSinglePartArtifactPrint.class)
               .eq(MesBuildingSinglePartArtifactPrint::getTaskId, task.getId())
               .orderByDesc(MesBuildingSinglePartArtifactPrint::getNumber)
         );
      Map<Long, Integer> singReduceWarehouse = new HashMap<>();

      for (MesBuildingSinglePartArtifactPrint unReport : sings) {
         int canReportQuantity = unReport.getTaskQuantity() - unReport.getReportQuantity();
         if (canReportQuantity > 0 && reduceQuantity > 0) {
            int trueReduceQuantity = reduceQuantity > canReportQuantity ? canReportQuantity : reduceQuantity;
            unReport.setTaskQuantity(unReport.getTaskQuantity() - trueReduceQuantity);
            unReport.setQuantity(Math.min(unReport.getQuantity(), unReport.getTaskQuantity()));
            unReport.setBoolAllReport(unReport.getTaskQuantity().equals(unReport.getReportQuantity()));
            reduceQuantity = reduceQuantity - trueReduceQuantity;
         }
      }

      for (MesBuildingSinglePartArtifactPrint sing : sings) {
         int canReportQuantity = sing.getTaskQuantity() - sing.getReportQuantity();
         if (canReportQuantity <= 0 && reduceQuantity > 0) {
            int trueReduceQuantity = reduceQuantity > sing.getReportQuantity() ? sing.getReportQuantity() : reduceQuantity;
            sing.setTaskQuantity(sing.getTaskQuantity() - trueReduceQuantity);
            sing.setQuantity(Math.min(sing.getQuantity(), sing.getTaskQuantity()));
            sing.setBoolAllReport(sing.getTaskQuantity().equals(sing.getReportQuantity()));
            singReduceWarehouse.put(sing.getId(), trueReduceQuantity);
            reduceQuantity = reduceQuantity - trueReduceQuantity;
         }
      }

      this.singlePartArtifactPrintService.updateBatchById(sings);
      List<MesBuildingSinglePartArtifactPrint> needRemove = sings.stream().filter(s -> s.getTaskQuantity().equals(0)).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(needRemove)) {
         this.singlePartArtifactPrintService.removeByIds(needRemove.stream().map(MesBuildingSinglePartArtifactPrint::getId).collect(Collectors.toList()));
      }

      if (!singReduceWarehouse.isEmpty()) {
         List<MesBuildingComplete> updateComplete = this.completeService
            .list(
               Wrappers.lambdaQuery(MesBuildingComplete.class)
                  .in(MesBuildingComplete::getSingId, singReduceWarehouse.keySet())
                  .eq(MesBuildingComplete::getWorkshopId, workshopId)
            );
         Map<Long, List<MesBuildingComplete>> completeMap = updateComplete.stream().collect(Collectors.groupingBy(MesBuildingComplete::getSingId));
         List<Long> completeIds = updateComplete.stream().map(MesBuildingComplete::getId).collect(Collectors.toList());
         List<MesBuildingWarehouseRecord> warehouseRecords = this.warehouseRecordService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                  .in(MesBuildingWarehouseRecord::getCompleteId, completeIds)
                  .eq(MesBuildingWarehouseRecord::getWorkshopId, workshopId)
                  .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
            );
         Map<Long, MesBuildingWarehouseRecord> recordMap = warehouseRecords.stream()
            .collect(Collectors.toMap(MesBuildingWarehouseRecord::getCompleteId, Function.identity()));
         List<MesBuildingComplete> updateCompletes = new ArrayList<>();
         List<MesBuildingWarehouseRecord> updateRecords = new ArrayList<>();

         for (Long singId : singReduceWarehouse.keySet()) {
            Integer needReduceQuantity = singReduceWarehouse.get(singId);

            for (MesBuildingComplete complete : completeMap.get(singId)) {
               if (needReduceQuantity > 0) {
                  Integer trueReduce = Math.min(needReduceQuantity, complete.getQuantity());
                  complete.setQuantity(complete.getQuantity() - trueReduce);
                  updateCompletes.add(complete);
                  MesBuildingWarehouseRecord record = recordMap.get(complete.getId());
                  record.setQuantity(BigDecimal.valueOf(complete.getQuantity().intValue()));
                  updateRecords.add(record);
                  Preconditions.checkArgument(record.getQuantity().intValue() >= 0, "操作失败,请联系管理员!!!");
                  needReduceQuantity = needReduceQuantity - trueReduce;
               }
            }

            Preconditions.checkArgument(needReduceQuantity == 0, "操作失败,请联系管理员!!!");
         }

         this.completeService.updateBatchById(updateCompletes);
         List<Long> needRemoveCids = updateCompletes.stream().filter(s -> s.getQuantity().equals(0)).map(s -> s.getId()).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(needRemoveCids)) {
            this.completeService.removeByIds(needRemoveCids);
         }

         this.warehouseRecordService.updateBatchById(updateRecords);
         List<Long> needRemoveRecordIds = updateRecords.stream().filter(s -> s.getQuantity().equals(0)).map(s -> s.getId()).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(needRemoveRecordIds)) {
            this.warehouseRecordService.removeByIds(needRemoveRecordIds);
         }

         MesBuildingWarehouseSummary summary = this.warehouseSummaryService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                  .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                  .eq(MesBuildingWarehouseSummary::getWorkshopId, workshopId)
                  .eq(MesBuildingWarehouseSummary::getProductId, task.getProductId())
                  .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.ARTIFACT.getType())
            );
         summary.setQuantity(summary.getQuantity().subtract(BigDecimal.valueOf(reduceQuantity.intValue())));
         this.warehouseSummaryService.updateById(summary);
         if (summary.getQuantity().equals(0)) {
            this.warehouseSummaryService.removeById(summary.getId());
         }
      }
   }

   @Override
   public PageVO<AppTaskOrderSummaryDTO> taskOrderProcessPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
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
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      List<Long> teams = this.teamService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeam.class)
               .in(MesBuildingTeam::getId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()))
               .eq(MesBuildingTeam::getProcessId, processId)
         )
         .stream()
         .map(MesBuildingTeam::getId)
         .collect(Collectors.toList());
      if (teams != null && teams.size() != 0) {
         List<Long> groupsIdList = this.groupsTeamLinkBiz
            .list(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).in(MesBuildingGroupsTeamLink::getTeamId, teams))
            .stream()
            .map(MesBuildingGroupsTeamLink::getGroupsId)
            .collect(Collectors.toList());
         if (groupsIdList.size() == 0) {
            return new PageVO<>();
         }

         List<MesBuildingGroups> groups = this.groupsBiz
            .getGroupsList(null)
            .stream()
            .filter(e -> groupsIdList.contains(e.getId()))
            .collect(Collectors.toList());
         if (groups.size() == 0) {
            return new PageVO<>();
         }

         if (projectId != null) {
            projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
         }

         if (projectIds.size() == 0) {
            return new PageVO<>();
         }

         List<AppTaskOrderSummaryDTO> summaryDTOS = this.taskProcessService
            .selectTaskOrderIdListByProcess(
               null, projectIds, monomerId, areaId, processId, UserUtil.getCurrentUserId(), taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum
            )
            .stream()
            .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
            .collect(Collectors.toList());
         summaryDTOS = summaryDTOS.stream().filter(s -> !s.getQuantity().equals(s.getCompleteQuantity())).collect(Collectors.toList());
         List<AppTaskOrderSummaryDTO> assistList = this.mesBuildingAssistService
            .findAssistCorrelationOrder(processId, groups.stream().map(MesBuildingGroups::getId).collect(Collectors.toList()));
         assistList = assistList.stream().map(s -> s.setBoolAssist(Boolean.TRUE)).collect(Collectors.toList());
         summaryDTOS.addAll(assistList);
         return new PageVO<>(summaryDTOS);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PageVO<AppTaskOrderSummaryDTO> taskOrderProcessPageAV2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
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
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      List<Long> teams = this.teamService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeam.class)
               .in(MesBuildingTeam::getId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList()))
               .eq(MesBuildingTeam::getProcessId, processId)
         )
         .stream()
         .map(MesBuildingTeam::getId)
         .collect(Collectors.toList());
      if (teams != null && teams.size() != 0) {
         if (projectId != null) {
            projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
         }

         if (projectIds.size() == 0) {
            return new PageVO<>();
         }

         List<AppTaskOrderSummaryDTO> summaryDTOS = this.taskProcessService
            .selectTaskOrderIdListByProcessAV2(
               null,
               projectIds,
               monomerId,
               areaId,
               areaBatchId,
               processId,
               UserUtil.getCurrentUserId(),
               taskTypeEnum,
               serialNumber,
               orderNumber,
               boolLastProcessEnum
            )
            .stream()
            .map(e -> BeanUtil.copy(e, AppTaskOrderSummaryDTO.class))
            .collect(Collectors.toList());
         summaryDTOS = summaryDTOS.stream().filter(s -> !s.getQuantity().equals(s.getCompleteQuantity())).collect(Collectors.toList());
         List<AppTaskOrderSummaryDTO> assistList = this.mesBuildingAssistService
            .findAssistCorrelationOrderV2(
               processId, teamList.stream().map(MesBuildingTeam::getProductionLineId).collect(Collectors.toList()), projectIds, taskTypeEnum
            );
         assistList = assistList.stream().map(s -> s.setBoolAssist(Boolean.TRUE)).collect(Collectors.toList());
         summaryDTOS.addAll(assistList);
         return new PageVO<>(summaryDTOS);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PageVO<AppTaskProcessDTO> pageArtifactProcessByTaskOrderIdAV2(
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Long classId,
      String serialNumber,
      @NotNull Boolean boolAssist,
      Long assistProdLineId,
      Long taskOrderId,
      Integer boolLastProcessEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<Object> startPage = PageHelper.startPage(pageNumber, pageSize);
      new ArrayList();
      List<MesBuildingTeam> teamAllList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (CollectionUtils.isEmpty(teamAllList)) {
         return new PageVO<>();
      }

      List<AppTaskProcessDTO> dtoList;
      if (boolAssist) {
         dtoList = this.taskProcessService
            .listProductAssistTaskByTaskOrderIdAV2(
               Arrays.asList(processId),
               assistProdLineId,
               taskTypeEnum,
               monomerId,
               areaId,
               areaBatchId,
               serialNumber,
               taskOrderId,
               null,
               boolLastProcessEnum,
               classId
            )
            .stream()
            .map(e -> BeanUtil.copy(e, AppTaskProcessDTO.class).setBoolMissingEnum(Boolean.FALSE))
            .collect(Collectors.toList());
      } else {
         MesBuildingTaskOrder taskOrder = this.taskOrderBiz.getById(taskOrderId);
         Preconditions.checkArgument(taskOrder != null, "操作失败：id有误!");
         List<MesBuildingTeam> teamList = teamAllList.stream()
            .filter(team -> team.getProductionLineId().equals(taskOrder.getProductionLineId()))
            .collect(Collectors.toList());
         if (CollectionUtils.isEmpty(teamList)) {
            return new PageVO<>();
         }

         dtoList = this.taskProcessService
            .listProductTaskByTaskOrderId2(
               teamList.stream().map(e -> e.getId()).collect(Collectors.toList()),
               taskOrder.getProductionLineId(),
               taskTypeEnum,
               null,
               monomerId,
               areaId,
               areaBatchId,
               processId,
               null,
               serialNumber,
               taskOrderId,
               null,
               boolLastProcessEnum,
               classId
            )
            .stream()
            .map(e -> BeanUtil.copy(e, AppTaskProcessDTO.class).setBoolMissingEnum(Boolean.FALSE))
            .collect(Collectors.toList());
      }

      dtoList = dtoList.stream().filter(s -> !s.getQuantity().equals(0)).collect(Collectors.toList());
      if (dtoList.size() == 0) {
         return new PageVO<>();
      }

      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType())) {
         Set<Long> artifactIdSet = dtoList.stream().map(AppTaskProcessDTO::getProductId).collect(Collectors.toSet());
         Map<Long, Map<Long, TechArtifactMachinePartLink>> machinePartLinkMap = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIdSet))
            .stream()
            .collect(
               Collectors.groupingBy(
                  TechArtifactMachinePartLink::getArtifactId, Collectors.toMap(TechArtifactMachinePartLink::getMachinePartId, Function.identity())
               )
            );
         Map<Long, Map<Long, TechAssembleDetail>> assembleLinkMap = this.assembleDetailService
            .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIdSet))
            .stream()
            .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId, Collectors.toMap(TechAssembleDetail::getAssembleId, Function.identity())));
         List<Long> machineParIdList = new ArrayList<>();
         machinePartLinkMap.forEach((artifactId, map) -> map.forEach((k, v) -> machineParIdList.add(k)));
         List<Long> assembleParIdList = new ArrayList<>();
         assembleLinkMap.forEach((artifactId, map) -> map.forEach((k, v) -> assembleParIdList.add(k)));
         Map<Long, Integer> machinePartQuantityMap = new HashMap<>();
         if (machineParIdList.size() > 0) {
            this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .in(TechMachinePart::getId, machineParIdList)
                     .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
                     .eq(TechMachinePart::getBoolSendDirectly, Boolean.FALSE)
                     .eq(TechMachinePart::getRelationType, MachinePartRelationTypeEnum.FOR_ARTIFACT.getType())
               )
               .forEach(e -> {
                  Integer var10000 = machinePartQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         Map<Long, Integer> assembleQuantityMap = new HashMap<>();
         if (assembleLinkMap.size() > 0) {
            this.assembleService
               .list(
                  Wrappers.lambdaQuery(TechAssemble.class)
                     .in(TechAssemble::getId, assembleParIdList)
                     .eq(TechAssemble::getBoolProcess, Boolean.TRUE)
                     .eq(TechAssemble::getBoolSendDirectly, Boolean.FALSE)
               )
               .forEach(e -> {
                  Integer var10000 = assembleQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               (Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                  .in(MesBuildingTaskNumberLink::getArtifactTaskProcessId, dtoList.stream().map(AppTaskProcessDTO::getId).collect(Collectors.toList()))
            );
         Map<Long, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = mesBuildingTaskNumberLinks.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskProcessId));
         List<Long> assembleIds = mesBuildingTaskNumberLinks.stream()
            .map(MesBuildingTaskNumberLink::getAssembleId)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap = CollectionUtils.isEmpty(assembleIds)
            ? new HashMap<>()
            : this.mesBuildingTaskNumberLinkService
               .list(
                  (Wrapper<MesBuildingTaskNumberLink>)(((((new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                                    .in(MesBuildingTaskNumberLink::getAssembleId, assembleIds))
                                 .eq(MesBuildingTaskNumberLink::getBoolAssembleComplete, Boolean.TRUE))
                              .eq(MesBuildingTaskNumberLink::getBoolArtifactInspection, Boolean.FALSE))
                           .eq(MesBuildingTaskNumberLink::getBoolArtifactInproduce, Boolean.FALSE))
                        .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, Boolean.FALSE))
                     .eq(MesBuildingTaskNumberLink::getBoolArtifactComplete, Boolean.FALSE)
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
         dtoList.forEach(
            e -> {
               if (e.getSequence().equals(0)) {
                  AtomicReference<Boolean> boolMissingEnum = new AtomicReference<>(Boolean.FALSE);
                  if (machinePartLinkMap.get(e.getProductId()) != null) {
                     machinePartLinkMap.get(e.getProductId()).forEach((partId, part) -> {
                        if (machinePartQuantityMap.get(partId) != null && machinePartQuantityMap.get(partId) < part.getQuantity()) {
                           boolMissingEnum.set(Boolean.TRUE);
                        }
                     });
                  }

                  if (CollectionUtils.isNotEmpty(taskNumberLinkMap.get(e.getId())) && boolMissingEnum.get().equals(Boolean.FALSE)) {
                     List<MesBuildingTaskNumberLink> taskNumberLinkList = taskNumberLinkMap.get(e.getId());
                     if (taskNumberLinkList.stream().anyMatch(link -> link.getAssembleNumber() != null)) {
                        boolMissingEnum.set(Boolean.TRUE);
                        Map<Integer, List<MesBuildingTaskNumberLink>> numberMap = taskNumberLinkList.stream()
                           .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
                        numberMap.forEach(
                           (artifactNumber, numberLinks) -> {
                              if (boolMissingEnum.get().equals(Boolean.TRUE)) {
                                 boolMissingEnum.set(Boolean.FALSE);
                                 numberLinks.stream()
                                    .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
                                    .forEach((assembleId, useTaskNumberLinkList) -> {
                                       List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = assembleTaskNumberLinkMap.get(assembleId);
                                       if (CollectionUtils.isEmpty(assembleTaskNumberLinks) || assembleTaskNumberLinks.size() < useTaskNumberLinkList.size()) {
                                          boolMissingEnum.set(Boolean.TRUE);
                                       }
                                    });
                              }
                           }
                        );
                     }
                  }

                  if (assembleLinkMap.get(e.getProductId()) != null && boolMissingEnum.get().equals(Boolean.FALSE)) {
                     assembleLinkMap.get(e.getProductId()).forEach((assembleId, assemble) -> {
                        if (assembleQuantityMap.get(assembleId) != null && assembleQuantityMap.get(assembleId) < assemble.getQuantity()) {
                           boolMissingEnum.set(Boolean.TRUE);
                        }
                     });
                  }

                  e.setBoolMissingEnum(boolMissingEnum.get());
               } else {
                  e.setBoolMissingEnum(Boolean.FALSE);
               }
            }
         );
      }

      if (taskTypeEnum.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         Set<Long> assembleSet = dtoList.stream()
            .filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()))
            .map(AppTaskProcessDTO::getProductId)
            .collect(Collectors.toSet());
         Map<Long, Map<Long, TechAssembleMachinePartLink>> assembleMachinePartLinkMap = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, assembleSet))
            .stream()
            .collect(
               Collectors.groupingBy(
                  TechAssembleMachinePartLink::getAssembleId, Collectors.toMap(TechAssembleMachinePartLink::getMachinePartId, Function.identity())
               )
            );
         List<Long> assembleMachineParIdList = new ArrayList<>();
         assembleMachinePartLinkMap.forEach((artifactId, map) -> map.forEach((k, v) -> assembleMachineParIdList.add(k)));
         Map<Long, Integer> assembleMachinePartQuantityMap = new HashMap<>();
         if (assembleMachineParIdList.size() > 0) {
            this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .in(TechMachinePart::getId, assembleMachineParIdList)
                     .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
                     .eq(TechMachinePart::getRelationType, TaskTypeEnum.ASSEMBLE.getType())
                     .eq(TechMachinePart::getBoolSendDirectly, Boolean.FALSE)
               )
               .forEach(e -> {
                  Integer var10000 = assembleMachinePartQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         dtoList.stream().filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())).forEach(e -> {
            if (e.getSequence().equals(0)) {
               AtomicReference<Boolean> boolMissingEnum = new AtomicReference<>(Boolean.FALSE);
               if (assembleMachinePartLinkMap.get(e.getProductId()) != null) {
                  assembleMachinePartLinkMap.get(e.getProductId()).forEach((partId, part) -> {
                     if (assembleMachinePartQuantityMap.get(partId) != null && assembleMachinePartQuantityMap.get(partId) < part.getQuantity()) {
                        boolMissingEnum.set(Boolean.TRUE);
                     }
                  });
               }

               e.setBoolMissingEnum(boolMissingEnum.get());
            } else {
               e.setBoolMissingEnum(Boolean.FALSE);
            }
         });
      }

      dtoList = dtoList.stream()
         .sorted(Comparator.comparing(AppTaskProcessDTO::getBoolMissingEnum, Comparator.nullsFirst(Boolean::compareTo)))
         .collect(Collectors.toList());
      dtoList = dtoList.stream().sorted((o1, o2) -> TechUtils.compareSerialNumbers(o1.getSerialNumber(), o2.getSerialNumber())).collect(Collectors.toList());
      return new PageVO<>(startPage, dtoList);
   }

   @Override
   public List<ArtifactStatusDTO> listArtifactStatus(List<Long> artifactIds) {
      Preconditions.checkArgument(artifactIds.size() == 1, "操作失败!!!不支持此操作!!");
      Long artId = artifactIds.get(0);
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .listByIds(artifactIds)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<TechArtifactExt> artifactExtList = this.artifactExtService
         .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getArtifactId, artifactIds));
      List<Integer> schedulingNumbers = artifactExtList.stream()
         .filter(TechArtifactExt::getBoolScheduling)
         .filter(s -> !s.getBoolTask())
         .map(TechArtifactExt::getSortNumber)
         .collect(Collectors.toList());
      List<TechArtifactExt> taskNumbers = artifactExtList.stream().filter(TechArtifactExt::getBoolTask).collect(Collectors.toList());
      List<MesProcessTeamProductionLineListDTO> processTeamProductionLineListDTOS = this.teamService.listProductionLineTrees(null, null);
      Map<Long, List<MesProcessTeamProductionLineListDTO>> processTeamProductionLineListMap = processTeamProductionLineListDTOS.stream()
         .collect(Collectors.groupingBy(MesProcessTeamProductionLineListDTO::getLineId));
      Map<Long, String> teamLeaderNameMap = processTeamProductionLineListDTOS.stream()
         .collect(Collectors.toMap(MesProcessTeamProductionLineListDTO::getTeamId, MesProcessTeamProductionLineListDTO::getLeaderName, (s1, s2) -> s1));
      Map<Long, MesBuildingProductionLine> productionLineMap = this.productionLineBiz
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      Map<Long, MesBuildingProcess> processMap = this.processService.list().stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<Long, MesBuildingTaskProcess> taskProcessMap = this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .eq(MesBuildingTaskProcess::getProductId, artId)
               .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));
      Map<Integer, MesBuildingTaskNumberLink> taskNumberLinkMap = new HashMap<>();
      Map<Integer, List<MesBuildingProduceTeamReport>> reportMap = new HashMap<>();
      Map<Integer, MesBuildingComplete> completeMap = new HashMap<>();
      Map<Integer, MesBuildingPackageNumberLink> packageNumberLinkMap = new HashMap<>();
      Map<Integer, MesBuildingCargoListProductNumberLink> cargoNumberLinkMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(taskNumbers)) {
         List<Integer> numbers = taskNumbers.stream().map(TechArtifactExt::getSortNumber).collect(Collectors.toList());
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactId, artId)
                  .in(MesBuildingTaskNumberLink::getArtifactNumber, numbers)
            );
         taskNumberLinkMap = numberLinks.stream().collect(Collectors.toMap(MesBuildingTaskNumberLink::getArtifactNumber, Function.identity(), (s1, s2) -> s1));
         List<MesBuildingProduceTeamReport> reports = this.produceTeamReportService
            .list(
               Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
                  .eq(MesBuildingProduceTeamReport::getProductId, artId)
                  .in(MesBuildingProduceTeamReport::getNumber, numbers)
                  .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         reportMap = reports.stream().collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getNumber));
         List<MesBuildingComplete> completeList = this.completeService
            .list(
               Wrappers.lambdaQuery(MesBuildingComplete.class)
                  .eq(MesBuildingComplete::getProductId, artId)
                  .in(MesBuildingComplete::getNumber, numbers)
                  .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         completeMap = completeList.stream().collect(Collectors.toMap(MesBuildingComplete::getNumber, Function.identity()));
         List<MesBuildingPackageNumberLink> packageList = this.packageNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingPackageNumberLink.class)
                  .eq(MesBuildingPackageNumberLink::getProductId, artId)
                  .eq(MesBuildingPackageNumberLink::getProductType, TaskTypeEnum.ARTIFACT.getType())
                  .in(MesBuildingPackageNumberLink::getNumber, numbers)
            );
         packageNumberLinkMap = packageList.stream().collect(Collectors.toMap(MesBuildingPackageNumberLink::getNumber, Function.identity()));
         List<MesBuildingCargoListProductNumberLink> cargoLinks = this.cargoListProductNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingCargoListProductNumberLink.class)
                  .eq(MesBuildingCargoListProductNumberLink::getProductId, artId)
                  .eq(MesBuildingCargoListProductNumberLink::getProductType, TaskTypeEnum.ARTIFACT.getType())
                  .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, false)
                  .in(MesBuildingCargoListProductNumberLink::getNumber, numbers)
            );
         cargoNumberLinkMap = cargoLinks.stream().collect(Collectors.toMap(MesBuildingCargoListProductNumberLink::getNumber, Function.identity()));
      }

      List<ArtifactStatusDTO> dtos = new ArrayList<>();

      for (TechArtifactExt ext : artifactExtList) {
         Integer number = ext.getSortNumber();
         ArtifactStatusDTO build = ArtifactStatusDTO.builder().productId(artId).number(number).build();
         if (!ext.getBoolScheduling()) {
            build.setProcessName(OneCodeTaskTypeEnum.UN_SCHEDULING.getName());
            build.setBoolCargo(Boolean.FALSE);
         } else if (schedulingNumbers.contains(number)) {
            build.setProcessName(OneCodeTaskTypeEnum.UN_TASK.getName());
            build.setBoolCargo(Boolean.FALSE);
         } else {
            MesBuildingTaskNumberLink numberLink = taskNumberLinkMap.get(number);
            if (cargoNumberLinkMap.containsKey(number)) {
               build.setProcessName(OneCodeTaskTypeEnum.CARGOLIST.getName());
               build.setBoolCargo(Boolean.TRUE);
            } else if (packageNumberLinkMap.containsKey(number)) {
               build.setProcessName(OneCodeTaskTypeEnum.PACKAGE.getName());
               build.setBoolCargo(Boolean.TRUE);
            } else if (completeMap.containsKey(number)) {
               build.setProcessName(OneCodeTaskTypeEnum.COMPLETE.getName());
               build.setBoolCargo(Boolean.FALSE);
            } else if (artifactMap.get(ext.getArtifactId()).getBoolAllPartSendDirectly()) {
               build.setProcessName(OneCodeTaskTypeEnum.ALL_SEND_DIRECTLY.getName());
               build.setBoolCargo(Boolean.FALSE);
            } else if (numberLink.getBoolArtifactReport()) {
               List<MesBuildingProduceTeamReport> reports = reportMap.get(number);
               List<MesBuildingProduceTeamReport> needreports = reports.stream()
                  .filter(s -> s.getTaskProcessId().equals(numberLink.getArtifactTaskProcessId()))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(needreports)) {
                  MesBuildingProduceTeamReport report = needreports.get(0);
                  String leaderName = teamLeaderNameMap.get(report.getTeamId());
                  String groupName = productionLineMap.get(report.getProductionLineId()).getName();
                  build.setGroupId(report.getProductionLineId());
                  build.setGroupName(groupName);
                  build.setTeamId(report.getTeamId());
                  build.setLeaderName(leaderName);
                  build.setProcessId(report.getProcessId());
                  build.setTaskId(report.getTaskId());
                  build.setProcessName(processMap.get(report.getProcessId()).getName());
                  build.setLineName(groupName);
               }

               build.setBoolCargo(Boolean.FALSE);
            } else {
               MesBuildingTaskProcess taskProcess = taskProcessMap.get(numberLink.getArtifactTaskProcessId());
               MesBuildingProductionLine line = productionLineMap.get(taskProcess.getProductionLineId());
               build.setGroupId(taskProcess.getProductionLineId());
               build.setGroupName(line.getName());
               build.setLineId(taskProcess.getProductionLineId());
               build.setLineName(line.getName());
               String key = taskProcess.getTeamId() + "_" + taskProcess.getProcessId();
               Map<String, MesProcessTeamProductionLineListDTO> teamProductionLineListDTOMap = processTeamProductionLineListMap.getOrDefault(
                     taskProcess.getProductionLineId(), Collections.emptyList()
                  )
                  .stream()
                  .collect(Collectors.toMap(e -> e.getTeamId() + "-" + e.getProcessId(), Function.identity()));
               MesProcessTeamProductionLineListDTO teamProductionLineListDTO = teamProductionLineListDTOMap.get(key);
               if (teamProductionLineListDTO != null) {
                  build.setTeamId(teamProductionLineListDTO.getTeamId());
                  build.setLeaderName(teamProductionLineListDTO.getLeaderName());
               }

               build.setProcessId(taskProcess.getProcessId());
               build.setTaskId(taskProcess.getTaskId());
               build.setProcessName(processMap.get(taskProcess.getProcessId()).getName());
               build.setLineName(line.getName());
               build.setBoolCargo(Boolean.FALSE);
            }
         }

         dtos.add(build);
      }

      return dtos;
   }

   @Override
   public Map<Long, Long> addAllTaskProces(List<MesBuildingTask> tasks, Map<Long, TechArtifact> artifactMap, Map<Long, TechAssemble> assMap, Integer taskType) {
      new HashMap();
      if (taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         Preconditions.checkArgument(!artifactMap.isEmpty(), "构件数据丢失!!!");
      } else if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         Preconditions.checkArgument(!assMap.isEmpty(), "部件数据丢失!!!");
      } else {
         Preconditions.checkArgument(false, "产品类型错误!!!");
      }

      List<Long> allProudProcessLink = tasks.stream()
         .map(MesBuildingTask::getProductProcessId)
         .filter(s -> s == null || s > 0L)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingTaskProcessLinkDTO>> productLinkProcesses = new HashMap<>();
      if (CollectionUtils.isNotEmpty(allProudProcessLink)) {
         productLinkProcesses = this.utilsBiz.getProductLinkProcesses(allProudProcessLink);
      }

      List<MesBuildingTaskProcess> processes = new ArrayList<>();

      for (MesBuildingTask task : tasks) {
         List<MesBuildingTaskProcess> taskProcessList = new ArrayList<>();
         List<MesBuildingTaskProcessLinkDTO> processList = productLinkProcesses.get(task.getProductProcessId());
         if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            TechArtifact artifact = artifactMap.get(task.getProductId());
            if (!artifact.getBoolCoatingEnum()) {
               processList = processList.stream().filter(e -> !e.getType().equals(ProcessTypeEnum.PAINT.getType())).collect(Collectors.toList());
            }

            if (artifact.getBoolAllPartSendDirectly()) {
               processList = new ArrayList<>();
            }

            if (artifact.getBuildingType().equals(InventoryTypeEnum.GRID.getType()) && artifact.getBoolSendDirectly()) {
               processList = new ArrayList<>();
            }
         }

         processList = processList.stream().sorted(Comparator.comparing(MesBuildingTaskProcessLinkDTO::getSequence).reversed()).collect(Collectors.toList());
         LocalDateTime askCompleteTime = task.getAskCompleteTime() == null ? LocalDateTime.now() : task.getAskCompleteTime();

         for (int i = 0; i < processList.size(); i++) {
            MesBuildingTaskProcessLinkDTO process = processList.get(i);
            MesBuildingTaskProcess taskProcess = BeanUtil.copy(task, MesBuildingTaskProcess.class);
            taskProcess.setId(null);
            taskProcess.setTaskId(task.getId());
            taskProcess.setProductProcessId(task.getProductProcessId());
            if (i == processList.size() - 1) {
               taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
            }

            taskProcess.setCompleteQuantity(0);
            taskProcess.setProcessId(process.getProcessId());
            if (askCompleteTime.minusDays(process.getNodeTime().intValue()).isAfter(LocalDateTime.now())) {
               askCompleteTime = askCompleteTime.minusDays(process.getNodeTime().intValue());
            } else {
               askCompleteTime = LocalDateTime.now().with(LocalTime.MIDNIGHT);
            }

            taskProcess.setBoolParallelProcess(process.getBoolParallelProcess());
            taskProcess.setAskCompleteTime(askCompleteTime);
            taskProcess.setSequence(process.getSequence());
            if (processList.size() == 1) {
               taskProcess.setSequence(0);
            }

            taskProcess.setTeamId(process.getTeamId());
            taskProcessList.add(taskProcess);
         }

         if (CollectionUtils.isNotEmpty(taskProcessList)) {
            taskProcessList = taskProcessList.stream().sorted(Comparator.comparing(MesBuildingTaskProcess::getSequence)).collect(Collectors.toList());

            for (int i = 0; i < taskProcessList.size(); i++) {
               MesBuildingTaskProcess taskProcess = taskProcessList.get(i);
               taskProcess.setSequence(i);
            }

            processes.addAll(taskProcessList);
         }
      }

      Preconditions.checkArgument(CollectionUtils.isNotEmpty(processes), "操作失败,工序不存在,请检查清单!");
      processes = processes.stream()
         .sorted(Comparator.comparing(MesBuildingTaskProcess::getTaskId).thenComparing(MesBuildingTaskProcess::getSequence))
         .collect(Collectors.toList());
      this.mesBuildingTaskProcessService.saveBatch(processes);
      Map<Long, List<MesBuildingTaskProcess>> taskProMap = processes.stream().collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      taskProMap.forEach((taskId, process) -> {
         List<MesBuildingTaskProcess> collect = process.stream().sorted(Comparator.comparing(MesBuildingTaskProcess::getSequence)).collect(Collectors.toList());

         for (int ix = 0; ix < collect.size(); ix++) {
            MesBuildingTaskProcess taskProcessx = collect.get(ix);
            if (ix + 1 < collect.size()) {
               MesBuildingTaskProcess nextTaskProcess = collect.get(ix + 1);
               taskProcessx.setNextProcessId(nextTaskProcess.getProcessId());
               this.createAndSaveProcessLink(taskProcessx);
            } else {
               taskProcessx.setNextProcessId(null);
               this.createAndSaveProcessLink(taskProcessx);
            }
         }
      });
      return processes.stream()
         .filter(s -> s.getSequence().equals(0))
         .collect(Collectors.toMap(MesBuildingTaskProcess::getTaskId, MesBuildingTaskProcess::getId));
   }

   public void createAndSaveProcessLink(MesBuildingTaskProcess taskProcess) {
      MesBuildingNextProcessLink processLink = new MesBuildingNextProcessLink();
      processLink.setTaskProcessId(taskProcess.getId());
      processLink.setNextProcessId(taskProcess.getNextProcessId());
      processLink.setSequence(taskProcess.getSequence());
      this.nextProcessLinkService.save(processLink);
   }

   @Override
   public void checkBoolMissing(List<AppTaskProcessDTO> dtoList, MesBuildingTaskOrder taskOrder, Integer taskTypeEnum, Boolean boolAssist) {
      List<Long> taskProcessIds = dtoList.stream().map(AppTaskProcessDTO::getId).collect(Collectors.toList());
      List<MesBuildingAssistNumberDetail> assistNumberDetails = this.numberDetailService
         .list(Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class).in(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcessIds));
      Map<String, List<MesBuildingAssistNumberDetail>> assistNumberMap = assistNumberDetails.stream()
         .collect(Collectors.groupingBy(s -> s.getTaskProcessId() + "_" + s.getGroupsId()));
      Map<Long, List<MesBuildingAssistNumberDetail>> allAssistNumberMap = assistNumberDetails.stream()
         .collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getTaskProcessId));
      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType()) && CollectionUtils.isNotEmpty(dtoList)) {
         Map<Long, Integer> taskProcessMap = dtoList.stream().collect(Collectors.toMap(AppTaskProcessDTO::getId, AppTaskProcessDTO::getQuantity));
         List<Long> artIds = dtoList.stream().map(AppTaskProcessDTO::getProductId).distinct().collect(Collectors.toList());
         List<MesBuildingTaskNumberLink> links = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactComplete, false)
                  .in(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcessMap.keySet())
            );
         Map<Long, Map<Integer, List<MesBuildingTaskNumberLink>>> linkMap = links.stream()
            .collect(
               Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskProcessId, Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber))
            );
         Map<Long, Boolean> assNumberLinkMap = new HashMap<>();

         for (AppTaskProcessDTO dto : dtoList) {
            Long taskProcessId = dto.getId();
            String key = "";
            if (boolAssist) {
               key = taskProcessId + "_" + dto.getAssistGroup().getId();
            }

            List<Integer> assistNumbers = assistNumberMap.getOrDefault(key, new ArrayList<>())
               .stream()
               .map(MesBuildingAssistNumberDetail::getNumber)
               .collect(Collectors.toList());
            List<Integer> allAssistNumbers = allAssistNumberMap.getOrDefault(taskProcessId, new ArrayList<>())
               .stream()
               .map(MesBuildingAssistNumberDetail::getNumber)
               .collect(Collectors.toList());
            Integer integer = dto.getQuantity();
            Map<Integer, List<MesBuildingTaskNumberLink>> numberMap = linkMap.get(taskProcessId);
            Preconditions.checkArgument(numberMap != null, "操作失败请联系管理员!!!!!!");
            if (boolAssist) {
               List<Integer> assNumbers = numberMap.keySet().stream().filter(assistNumbers::contains).collect(Collectors.toList());
               int size = assNumbers.size();
               Preconditions.checkArgument(size == integer, "操作失败请联系管理员!!!!!!");
            } else {
               List<Integer> allNumbers = numberMap.keySet().stream().filter(s -> !allAssistNumbers.contains(s)).collect(Collectors.toList());
               int size = allNumbers.size();
               Preconditions.checkArgument(size == integer, "操作失败请联系管理员!!!!!!");
            }

            assNumberLinkMap.put(taskProcessId, Boolean.TRUE);

            for (Integer number : numberMap.keySet()) {
               if ((boolAssist && assistNumbers.contains(number) || !boolAssist && !assistNumbers.contains(number))
                  && numberMap.get(number).stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                  assNumberLinkMap.put(taskProcessId, Boolean.FALSE);
               }
            }
         }

         new HashMap();
         Map<Long, Integer> machinePartQuantityMap = new HashMap<>();
         Set<Long> artifactIdSet = dtoList.stream().map(AppTaskProcessDTO::getProductId).collect(Collectors.toSet());
         List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIdSet));
         List<Long> machineParIdList = partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
         Map<Long, Map<Long, TechArtifactMachinePartLink>> var28 = partLinks.stream()
            .collect(
               Collectors.groupingBy(
                  TechArtifactMachinePartLink::getArtifactId, Collectors.toMap(TechArtifactMachinePartLink::getMachinePartId, Function.identity())
               )
            );
         if (!machineParIdList.isEmpty()) {
            this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .in(TechMachinePart::getId, machineParIdList)
                     .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
                     .eq(TechMachinePart::getRelationType, TaskTypeEnum.ARTIFACT.getType())
                     .eq(TechMachinePart::getBoolSendDirectly, Boolean.FALSE)
               )
               .forEach(e -> {
                  Integer var10000 = machinePartQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         for (AppTaskProcessDTO dto : dtoList) {
            if (dto.getBoolFirstProcess()) {
               AtomicReference<Boolean> boolMissingEnum = new AtomicReference<>(Boolean.FALSE);
               Map<Long, TechArtifactMachinePartLink> partLinkmap = (Map<Long, TechArtifactMachinePartLink>)var28.get(dto.getProductId());
               if (partLinkmap != null) {
                  partLinkmap.forEach((partId, part) -> {
                     if (machinePartQuantityMap.get(partId) != null && machinePartQuantityMap.get(partId) < part.getQuantity()) {
                        boolMissingEnum.set(Boolean.TRUE);
                     }
                  });
               }

               boolMissingEnum.set(boolMissingEnum.get() || assNumberLinkMap.get(dto.getId()));
               dto.setBoolMissingEnum(boolMissingEnum.get());
            }
         }
      }

      if ((taskTypeEnum & TaskTypeEnum.ASSEMBLE.getType()) > 0) {
         Set<Long> assembleSet = dtoList.stream()
            .filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()))
            .map(AppTaskProcessDTO::getProductId)
            .collect(Collectors.toSet());
         Map<Long, Map<Long, TechAssembleMachinePartLink>> assembleMachinePartLinkMap = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, assembleSet))
            .stream()
            .collect(
               Collectors.groupingBy(
                  TechAssembleMachinePartLink::getAssembleId, Collectors.toMap(TechAssembleMachinePartLink::getMachinePartId, Function.identity())
               )
            );
         List<Long> assembleMachineParIdList = new ArrayList<>();
         assembleMachinePartLinkMap.forEach((artifactId, map) -> map.forEach((k, v) -> assembleMachineParIdList.add(k)));
         Map<Long, Integer> assembleMachinePartQuantityMap = new HashMap<>();
         if (!assembleMachineParIdList.isEmpty()) {
            this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .in(TechMachinePart::getId, assembleMachineParIdList)
                     .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
                     .eq(TechMachinePart::getRelationType, TaskTypeEnum.ASSEMBLE.getType())
                     .eq(TechMachinePart::getBoolSendDirectly, Boolean.FALSE)
               )
               .forEach(e -> {
                  Integer var10000 = assembleMachinePartQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         dtoList.stream().filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())).forEach(e -> {
            if (e.getSequence().equals(0)) {
               AtomicReference<Boolean> boolMissingEnumx = new AtomicReference<>(Boolean.FALSE);
               if (assembleMachinePartLinkMap.get(e.getProductId()) != null) {
                  assembleMachinePartLinkMap.get(e.getProductId()).forEach((partId, part) -> {
                     if (assembleMachinePartQuantityMap.get(partId) != null && assembleMachinePartQuantityMap.get(partId) < part.getQuantity()) {
                        boolMissingEnumx.set(Boolean.TRUE);
                     }
                  });
               }

               e.setBoolMissingEnum(boolMissingEnumx.get());
            } else {
               e.setBoolMissingEnum(Boolean.FALSE);
            }
         });
      }
   }

   @Override
   public void checkBoolMissing2(List<AppTaskProcessDTO> dtoList, MesBuildingTaskOrder taskOrder, Integer taskTypeEnum, Boolean boolAssist) {
      List<Long> taskProcessIds = dtoList.stream().map(AppTaskProcessDTO::getId).collect(Collectors.toList());
      List<MesBuildingAssistNumberDetail> assistNumberDetails = this.numberDetailService
         .list(Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class).in(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcessIds));
      Map<String, List<MesBuildingAssistNumberDetail>> assistNumberMap = assistNumberDetails.stream()
         .collect(Collectors.groupingBy(s -> s.getTaskProcessId() + "_" + s.getProductionLineId()));
      Map<Long, List<MesBuildingAssistNumberDetail>> allAssistNumberMap = assistNumberDetails.stream()
         .collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getTaskProcessId));
      if (taskTypeEnum.equals(TaskTypeEnum.ARTIFACT.getType()) && CollectionUtils.isNotEmpty(dtoList)) {
         List<Long> artIds = dtoList.stream().map(AppTaskProcessDTO::getProductId).distinct().collect(Collectors.toList());
         List<MesBuildingTaskNumberLink> links = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactComplete, false)
                  .in(
                     MesBuildingTaskNumberLink::getArtifactTaskProcessId,
                     dtoList.stream().map(AppTaskProcessDTO::getId).distinct().collect(Collectors.toList())
                  )
            );
         Map<Long, Map<Integer, List<MesBuildingTaskNumberLink>>> linkMap = links.stream()
            .collect(
               Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskProcessId, Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber))
            );
         List<Long> assembleIds = links.stream().map(MesBuildingTaskNumberLink::getAssembleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
         Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap = CollectionUtils.isEmpty(assembleIds)
            ? new HashMap<>()
            : this.mesBuildingTaskNumberLinkService
               .list(
                  (Wrapper<MesBuildingTaskNumberLink>)(((((new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                                    .in(MesBuildingTaskNumberLink::getAssembleId, assembleIds))
                                 .eq(MesBuildingTaskNumberLink::getBoolAssembleComplete, Boolean.TRUE))
                              .eq(MesBuildingTaskNumberLink::getBoolArtifactInspection, Boolean.FALSE))
                           .eq(MesBuildingTaskNumberLink::getBoolArtifactInproduce, Boolean.FALSE))
                        .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, Boolean.FALSE))
                     .eq(MesBuildingTaskNumberLink::getBoolArtifactComplete, Boolean.FALSE)
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
         Map<Long, Boolean> assNumberLinkMap = new HashMap<>();

         for (AppTaskProcessDTO dto : dtoList) {
            Long taskProcessId = dto.getId();
            String key = "";
            if (boolAssist) {
               key = taskProcessId + "_" + dto.getAssistProductionLine().getId();
            }

            List<Integer> assistNumbers = assistNumberMap.getOrDefault(key, new ArrayList<>())
               .stream()
               .map(MesBuildingAssistNumberDetail::getNumber)
               .collect(Collectors.toList());
            List<Integer> allAssistNumbers = allAssistNumberMap.getOrDefault(taskProcessId, new ArrayList<>())
               .stream()
               .map(MesBuildingAssistNumberDetail::getNumber)
               .collect(Collectors.toList());
            Integer integer = dto.getQuantity();
            Map<Integer, List<MesBuildingTaskNumberLink>> numberMap = linkMap.get(taskProcessId);
            Preconditions.checkArgument(numberMap != null, "操作失败请联系管理员!!!!!!");
            if (boolAssist) {
               List<Integer> assNumbers = numberMap.keySet().stream().filter(assistNumbers::contains).distinct().collect(Collectors.toList());
               int size = assNumbers.size();
               Preconditions.checkArgument(size == integer, "操作失败请联系管理员!!!!!!");
            } else {
               List<Integer> allNumbers = numberMap.keySet().stream().filter(s -> !allAssistNumbers.contains(s)).distinct().collect(Collectors.toList());
               int size = allNumbers.size();
               Preconditions.checkArgument(size == integer, "操作失败请联系管理员!!!!!!");
            }

            if (!dto.getBoolFirstProcess()) {
               assNumberLinkMap.put(taskProcessId, Boolean.FALSE);
            } else {
               assNumberLinkMap.put(taskProcessId, Boolean.TRUE);

               for (Integer number : numberMap.keySet()) {
                  if (boolAssist && assistNumbers.contains(number) || !boolAssist && !assistNumbers.contains(number)) {
                     if (numberMap.get(number).stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                        assNumberLinkMap.put(taskProcessId, Boolean.FALSE);
                     }

                     if (assNumberLinkMap.get(taskProcessId)) {
                        List<MesBuildingTaskNumberLink> numberLinks = numberMap.get(number);
                        if (numberLinks.stream().allMatch(e -> e.getAssembleId() != null)) {
                           AtomicReference<Boolean> flag = new AtomicReference<>(Boolean.FALSE);
                           numberLinks.stream()
                              .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
                              .forEach((assembleId, taskNumberLinkList) -> {
                                 List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = assembleTaskNumberLinkMap.get(assembleId);
                                 if (CollectionUtils.isEmpty(assembleTaskNumberLinks) || assembleTaskNumberLinks.size() < taskNumberLinkList.size()) {
                                    flag.set(Boolean.TRUE);
                                 }
                              });
                           assNumberLinkMap.put(taskProcessId, flag.get());
                        }
                     }
                  }
               }
            }
         }

         new HashMap();
         Map<Long, Integer> machinePartQuantityMap = new HashMap<>();
         Set<Long> artifactIdSet = dtoList.stream().map(AppTaskProcessDTO::getProductId).collect(Collectors.toSet());
         List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artifactIdSet));
         List<Long> machineParIdList = partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList());
         Map<Long, Map<Long, TechArtifactMachinePartLink>> var31 = partLinks.stream()
            .collect(
               Collectors.groupingBy(
                  TechArtifactMachinePartLink::getArtifactId, Collectors.toMap(TechArtifactMachinePartLink::getMachinePartId, Function.identity())
               )
            );
         if (!machineParIdList.isEmpty()) {
            this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .in(TechMachinePart::getId, machineParIdList)
                     .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
                     .eq(TechMachinePart::getRelationType, TaskTypeEnum.ARTIFACT.getType())
                     .eq(TechMachinePart::getBoolSendDirectly, Boolean.FALSE)
               )
               .forEach(e -> {
                  Integer var10000 = machinePartQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         for (AppTaskProcessDTO dto : dtoList) {
            if (dto.getBoolFirstProcess()) {
               AtomicReference<Boolean> boolMissingEnum = new AtomicReference<>(Boolean.FALSE);
               Map<Long, TechArtifactMachinePartLink> partLinkmap = (Map<Long, TechArtifactMachinePartLink>)var31.get(dto.getProductId());
               if (partLinkmap != null) {
                  partLinkmap.forEach((partId, part) -> {
                     if (machinePartQuantityMap.get(partId) != null && machinePartQuantityMap.get(partId) < part.getQuantity()) {
                        boolMissingEnum.set(Boolean.TRUE);
                     }
                  });
               }

               boolMissingEnum.set(boolMissingEnum.get() || assNumberLinkMap.get(dto.getId()));
               dto.setBoolMissingEnum(boolMissingEnum.get());
            } else {
               dto.setBoolMissingEnum(Boolean.FALSE);
            }
         }
      }

      if ((taskTypeEnum & TaskTypeEnum.ASSEMBLE.getType()) > 0) {
         Set<Long> assembleSet = dtoList.stream()
            .filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()))
            .map(AppTaskProcessDTO::getProductId)
            .collect(Collectors.toSet());
         Map<Long, Map<Long, TechAssembleMachinePartLink>> assembleMachinePartLinkMap = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, assembleSet))
            .stream()
            .collect(
               Collectors.groupingBy(
                  TechAssembleMachinePartLink::getAssembleId, Collectors.toMap(TechAssembleMachinePartLink::getMachinePartId, Function.identity())
               )
            );
         List<Long> assembleMachineParIdList = new ArrayList<>();
         assembleMachinePartLinkMap.forEach((artifactId, map) -> map.forEach((k, v) -> assembleMachineParIdList.add(k)));
         Map<Long, Integer> assembleMachinePartQuantityMap = new HashMap<>();
         if (!assembleMachineParIdList.isEmpty()) {
            this.machinePartService
               .list(
                  Wrappers.lambdaQuery(TechMachinePart.class)
                     .in(TechMachinePart::getId, assembleMachineParIdList)
                     .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
                     .eq(TechMachinePart::getRelationType, TaskTypeEnum.ASSEMBLE.getType())
                     .eq(TechMachinePart::getBoolSendDirectly, Boolean.FALSE)
               )
               .forEach(e -> {
                  Integer var10000 = assembleMachinePartQuantityMap.put(e.getId(), e.getProducedQuantity() - e.getUsedQuantity());
               });
         }

         dtoList.stream().filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())).forEach(e -> {
            if (e.getSequence().equals(0)) {
               AtomicReference<Boolean> boolMissingEnumx = new AtomicReference<>(Boolean.FALSE);
               if (assembleMachinePartLinkMap.get(e.getProductId()) != null) {
                  assembleMachinePartLinkMap.get(e.getProductId()).forEach((partId, part) -> {
                     if (assembleMachinePartQuantityMap.get(partId) != null && assembleMachinePartQuantityMap.get(partId) < part.getQuantity()) {
                        boolMissingEnumx.set(Boolean.TRUE);
                     }
                  });
               }

               e.setBoolMissingEnum(boolMissingEnumx.get());
            } else {
               e.setBoolMissingEnum(Boolean.FALSE);
            }
         });
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
         record.setUserId(UserUtil.getCurrentUserId());
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

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveProduceInspection(List<InspectionReportSavedDTO> inspectData) {
      List<Long> reportNumberIds = inspectData.stream().map(InspectionReportSavedDTO::getReportNumberId).collect(Collectors.toList());
      int allReportQuantity = inspectData.stream().mapToInt(InspectionReportSavedDTO::getReportQuantity).sum();
      List<MesBuildingProduceTeamReport> allReports = this.produceTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .in(MesBuildingProduceTeamReport::getReportNumber, reportNumberIds)
               .apply("problem_quantity+inspection_quantity=0")
         );
      Map<Long, List<MesBuildingProduceTeamReport>> allReportMap = allReports.stream()
         .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getReportNumber));
      Preconditions.checkArgument(allReportMap.keySet().size() == reportNumberIds.size(), "操作失败!!请刷新页面后重试!!!!");
      List<Long> taskProcessIds = allReports.stream().map(MesBuildingProduceTeamReport::getTaskProcessId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(taskProcessIds.size() == 1, "数据校验失败!!!!");
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(taskProcessIds.get(0));
      taskProcess.setInspectionQuantity(taskProcess.getInspectionQuantity() + allReportQuantity);
      Preconditions.checkArgument(taskProcess.getCompleteQuantity() >= taskProcess.getInspectionQuantity() + taskProcess.getProblemQuantity(), "操作失败!!!");
      Long nextProcessId = 0L;
      this.taskProcessService.updateById(taskProcess);
      MesBuildingTask task = this.baseService.getById(taskProcess.getTaskId());
      this.checkProductStatus(Arrays.asList(taskProcess.getProductId()), taskProcess.getTaskTypeEnum());
      List<MesBuildingProduceInspectionTeamReport> inspectReports = new ArrayList<>();
      List<MesBuildingProduceTeamReport> needUpdateTeamReports = new ArrayList<>();
      MesBuildingInspectionTeam inspectionTeam = this.utilsBiz
         .getInspectionTeamBygroupsIdAndProcessIdAndUserId(taskProcess.getGroupsId(), taskProcess.getProcessId(), UserUtil.getCurrentUserId());
      Preconditions.checkArgument(inspectionTeam != null, "上报失败,用户没有处于可以质检班组内");
      HashMap<Long, Integer> savePriceMap = new HashMap<>();
      Long reportNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);

      for (InspectionReportSavedDTO dto : inspectData) {
         Preconditions.checkArgument(dto.getReportQuantity() > 0, "上报数不能小于零");
         List<MesBuildingProduceTeamReport> reports = allReportMap.get(dto.getReportNumberId());
         Preconditions.checkArgument(reports.size() >= dto.getReportQuantity(), "操作失败!!!!超出可质检数量!!!!");
         List<MesBuildingProduceTeamReport> needInspect = reports.stream().limit(dto.getReportQuantity().intValue()).collect(Collectors.toList());
         List<Integer> needInspectNumbers = needInspect.stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
         Map<Integer, MesBuildingProduceTeamReport> reportMap = needInspect.stream()
            .collect(Collectors.toMap(MesBuildingProduceTeamReport::getNumber, Function.identity()));
         LocalDateTime time = LocalDateTime.now();
         if (!TaskTypeEnum.ARTIFACT.getType().equals(taskProcess.getTaskTypeEnum()) && !TaskTypeEnum.ASSEMBLE.getType().equals(taskProcess.getTaskTypeEnum())) {
            Preconditions.checkArgument(false, "操作失败!!!!");
            MesBuildingProduceTeamReport teamReport = reports.get(0);
            MesBuildingProduceInspectionTeamReport inspectionTeamReport = MesBuildingProduceInspectionTeamReport.builder()
               .productId(taskProcess.getProductId())
               .taskTypeEnum(taskProcess.getTaskTypeEnum())
               .processId(taskProcess.getProcessId())
               .taskId(taskProcess.getTaskId())
               .groupId(teamReport.getGroupsId())
               .teamId(teamReport.getId())
               .userId(UserUtil.getCurrentUserId())
               .inspectionTeamId(inspectionTeam.getId())
               .taskProcessId(taskProcess.getId())
               .inspectionQuantity(dto.getReportQuantity())
               .number(null)
               .inspectReportNumber(reportNumber)
               .schedulingId(taskProcess.getSchedulingId())
               .build();
            inspectReports.add(inspectionTeamReport);
            Integer integer = savePriceMap.get(teamReport.getId());
            if (task.getBoolOneCode()) {
               reportNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
            }

            savePriceMap.merge(teamReport.getId(), 1, Integer::sum);
         } else {
            for (Integer number : needInspectNumbers) {
               MesBuildingProduceTeamReport teamReport = reportMap.get(number);
               MesBuildingProduceInspectionTeamReport inspectionTeamReport = MesBuildingProduceInspectionTeamReport.builder()
                  .teamId(teamReport.getTeamId())
                  .productId(taskProcess.getProductId())
                  .taskTypeEnum(taskProcess.getTaskTypeEnum())
                  .processId(taskProcess.getProcessId())
                  .taskId(taskProcess.getTaskId())
                  .inspectionTeamId(inspectionTeam.getId())
                  .taskProcessId(taskProcess.getId())
                  .groupId(teamReport.getGroupsId())
                  .inspectionQuantity(1)
                  .userId(UserUtil.getCurrentUserId())
                  .number(number)
                  .reportTime(time)
                  .inspectReportTime(time)
                  .inspectReportNumber(reportNumber)
                  .schedulingId(taskProcess.getSchedulingId())
                  .build();
               inspectReports.add(inspectionTeamReport);
               savePriceMap.merge(teamReport.getId(), 1, Integer::sum);
               teamReport.setInspectionQuantity(teamReport.getInspectionQuantity() + 1);
               Preconditions.checkArgument(teamReport.getInspectionQuantity() + teamReport.getProblemQuantity() <= teamReport.getQuantity(), "操作失败!!请刷新页面!!!");
               needUpdateTeamReports.add(teamReport);
               if (task.getBoolOneCode()) {
                  reportNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
                  time = LocalDateTime.now();
               }
            }
         }
      }

      this.produceInspectionTeamReportService.saveBatch(inspectReports);
      this.produceTeamReportService.updateBatchById(needUpdateTeamReports);
      this.teamReportBiz.savePiceByData(savePriceMap);
      List<MesBuildingProduceTeamReportSummary> needUpdateSummarys = new ArrayList<>();
      Map<String, Integer> reportSummaryMap = inspectReports.stream()
         .collect(
            Collectors.toMap(
               s -> s.getTaskProcessId() + "_" + s.getGroupId() + "_" + s.getTeamId(),
               MesBuildingProduceInspectionTeamReport::getInspectionQuantity,
               Integer::sum
            )
         );
      List<MesBuildingReportSummaryDTO> summaryDTOS = new ArrayList<>();

      for (String key : reportSummaryMap.keySet()) {
         String[] split = key.split("_");
         Long taskProcessId = Long.valueOf(split[0]);
         Long groupId = Long.valueOf(split[1]);
         Long teamId = Long.valueOf(split[2]);
         MesBuildingReportSummaryDTO build = MesBuildingReportSummaryDTO.builder().taskProcessId(taskProcessId).groupId(groupId).teamId(teamId).build();
         summaryDTOS.add(build);
      }

      List<MesBuildingProduceTeamReportSummary> summaryList = this.produceTeamReportSummaryService.listReportSummarysByData(summaryDTOS);
      Map<String, MesBuildingProduceTeamReportSummary> summaryMap = summaryList.stream()
         .collect(Collectors.toMap(s -> s.getTaskProcessId() + "_" + s.getGroupsId() + "_" + s.getTeamId(), Function.identity()));

      for (String key : summaryMap.keySet()) {
         Integer inspectQuantity = reportSummaryMap.get(key);
         MesBuildingProduceTeamReportSummary dto = summaryMap.get(key);
         Preconditions.checkArgument(dto.getQuantity() >= dto.getProblemQuantity() + dto.getInspectionQuantity() + inspectQuantity, "操作失败!!请刷新页面后重试!!!!");
         dto.setInspectionQuantity(dto.getInspectionQuantity() + inspectQuantity);
         needUpdateSummarys.add(dto);
      }

      this.produceTeamReportSummaryService.updateBatchById(needUpdateSummarys);
      if (taskProcess.getNextProcessId() != null) {
         MesBuildingTaskProcess nextProcess = this.taskProcessService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId())
                  .eq(MesBuildingTaskProcess::getProcessId, taskProcess.getNextProcessId())
            );
         nextProcessId = nextProcess.getId();
      }

      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<Integer> inspectNumbers = inspectReports.stream().map(MesBuildingProduceInspectionTeamReport::getNumber).collect(Collectors.toList());
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcess.getId())
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, true)
                  .in(MesBuildingTaskNumberLink::getArtifactNumber, inspectNumbers)
            );
         List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList());
         Preconditions.checkArgument(numbers.size() == inspectNumbers.size(), "操作失败!!!请刷新页面后重试!!!!");

         for (MesBuildingTaskNumberLink numberLink : numberLinks) {
            numberLink.setArtifactTaskProcessId(nextProcessId);
            numberLink.setBoolArtifactReport(Boolean.FALSE);
            numberLink.setBoolArtifactInspection(Boolean.FALSE);
            numberLink.setBoolArtifactComplete(nextProcessId == 0L);
         }

         this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
      } else if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<Integer> inspectNumbers = inspectReports.stream().map(MesBuildingProduceInspectionTeamReport::getNumber).collect(Collectors.toList());
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcess.getId())
                  .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, true)
                  .in(MesBuildingTaskNumberLink::getAssembleNumber, inspectNumbers)
            );
         List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
         Preconditions.checkArgument(numbers.size() == inspectNumbers.size(), "操作失败!!!请刷新页面后重试!!!!");

         for (MesBuildingTaskNumberLink numberLink : numberLinks) {
            numberLink.setAssembleTaskProcessId(nextProcessId);
            numberLink.setBoolAssembleReport(Boolean.FALSE);
            numberLink.setBoolAssembleInspection(Boolean.FALSE);
            numberLink.setBoolAssembleComplete(nextProcessId == 0L);
         }

         this.mesBuildingTaskNumberLinkService.updateBatchById(numberLinks);
      } else {
         Preconditions.checkArgument(false, "产品类型不正确!!!");
      }

      List<TeamAndNumberDTO> teamAndNumberDTOS = cn.hutool.core.bean.BeanUtil.copyToList(inspectReports, TeamAndNumberDTO.class);
      this.updateNextTaskInspectionProcess(taskProcess, allReportQuantity, teamAndNumberDTOS);
      return true;
   }

   @Override
   public PageVO<MesBuildingTaskProcessDTO> newProductTaskPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      String material,
      Long taskOrderId,
      String productionLineName,
      String productName,
      Boolean boolCompleteEnum,
      List<LocalDateTime> dateTimeList,
      String sort,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.utilsBiz.selectTeamIdByUserId(UserUtil.getCurrentUserId());
      if (teamList != null && !teamList.isEmpty()) {
         if (projectId != null) {
            projectIds = projectIds.stream().filter(e -> e.equals(projectId)).collect(Collectors.toList());
         }

         if (projectIds.isEmpty()) {
            return new PageVO<>();
         }

         List<Long> teamIds = teamList.stream().map(s -> s.getId()).collect(Collectors.toList());
         PageHelper.startPage(pageNumber, pageSize);
         List<MesBuildingTaskProcessDO> mesBuildingTaskProcessDOS = this.taskProcessService
            .selectListByTeamListAndProjectIdList(
               teamIds,
               projectIds,
               monomerId,
               areaId,
               taskTypeEnum,
               serialNumber,
               material,
               productionLineName,
               productName,
               boolCompleteEnum,
               processId,
               dateTimeList
            );
         PageVO pageVO = new PageVO<>(mesBuildingTaskProcessDOS);
         if (CollectionUtils.isEmpty(mesBuildingTaskProcessDOS)) {
            return pageVO;
         }

         List<Long> taskIds = mesBuildingTaskProcessDOS.stream().map(MesBuildingTaskProcessDO::getTaskId).distinct().collect(Collectors.toList());
         Map<Long, MesBuildingTask> taskMap = this.baseService
            .listByIds(taskIds)
            .stream()
            .collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
         List<Long> productIds = mesBuildingTaskProcessDOS.stream().map(MesBuildingTaskProcessDO::getProductId).distinct().collect(Collectors.toList());
         List<ArtifactAssociationCount> partList = this.artifactMachinePartLinkService.getArtifactPartConvertCounts(productIds);
         Map<Long, List<ArtifactAssociationCount>> assciationMap = partList.stream().collect(Collectors.groupingBy(ArtifactAssociationCount::getArtifactId));
         List<Long> proIdList = mesBuildingTaskProcessDOS.stream().map(MesBuildingTaskProcessDO::getId).collect(Collectors.toList());
         List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .in(MesBuildingTaskNumberLink::getArtifactTaskProcessId, proIdList)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, boolCompleteEnum)
            );
         List<Long> taskids = mesBuildingTaskProcessDOS.stream().map(MesBuildingTaskProcessDO::getTaskId).collect(Collectors.toList());
         Map<Long, List<MesBuildingProduceTeamReport>> reportMap;
         if (boolCompleteEnum) {
            List<MesBuildingProduceTeamReport> allReports = this.produceTeamReportService
               .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class).in(MesBuildingProduceTeamReport::getTaskId, taskids));
            reportMap = allReports.stream().collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskProcessId));
         } else {
            reportMap = new HashMap<>();
         }

         Map<Long, List<MesBuildingTaskNumberLink>> numberLinkMap = canReportNumbers.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskProcessId));
         List<Long> assembleIds = canReportNumbers.stream()
            .map(MesBuildingTaskNumberLink::getAssembleId)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap = CollectionUtils.isEmpty(assembleIds)
            ? new HashMap<>()
            : this.mesBuildingTaskNumberLinkService
               .list(
                  (Wrapper<MesBuildingTaskNumberLink>)(((((new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                                    .in(MesBuildingTaskNumberLink::getAssembleId, assembleIds))
                                 .eq(MesBuildingTaskNumberLink::getBoolAssembleComplete, Boolean.TRUE))
                              .eq(MesBuildingTaskNumberLink::getBoolArtifactInspection, Boolean.FALSE))
                           .eq(MesBuildingTaskNumberLink::getBoolArtifactInproduce, Boolean.FALSE))
                        .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, Boolean.FALSE))
                     .eq(MesBuildingTaskNumberLink::getBoolArtifactComplete, Boolean.FALSE)
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
         List<MesBuildingTaskProcessDTO> dtos = mesBuildingTaskProcessDOS.stream()
            .map(
               e -> {
                  MesBuildingTaskProcessDTO dtox = BeanUtil.copy(e, MesBuildingTaskProcessDTO.class).setTaskType(1);
                  List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = numberLinkMap.get(e.getId());
                  dtox.setBoolTimeRange(Boolean.TRUE);
                  List<AppTaskProcessArtifactNumberDTO> numberDTOS = new ArrayList<>();
                  if (!boolCompleteEnum) {
                     Map<Integer, List<MesBuildingTaskNumberLink>> artNumberLinkMap = mesBuildingTaskNumberLinks.stream()
                        .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
                     if (dtox.getSequence().equals(0) && mesBuildingTaskNumberLinks.stream().allMatch(taskNumberLink -> taskNumberLink.getAssembleId() != null)
                        )
                      {
                        for (Integer number : artNumberLinkMap.keySet()) {
                           List<MesBuildingTaskNumberLink> linkList = artNumberLinkMap.get(number);
                           boolean allGroupsSatisfied = linkList.stream()
                              .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
                              .entrySet()
                              .stream()
                              .allMatch(entry -> {
                                 List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = assembleTaskNumberLinkMap.get(entry.getKey());
                                 return CollectionUtils.isNotEmpty(assembleTaskNumberLinks) && assembleTaskNumberLinks.size() >= entry.getValue().size();
                              });
                           if (allGroupsSatisfied) {
                              numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(number).build());
                              linkList.stream()
                                 .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId))
                                 .forEach((assembleId, taskNumberLinkList) -> {
                                    List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = assembleTaskNumberLinkMap.get(assembleId);
                                    assembleTaskNumberLinks.subList(0, taskNumberLinkList.size()).clear();
                                 });
                           }
                        }
                     } else {
                        for (Integer number : artNumberLinkMap.keySet()) {
                           List<MesBuildingTaskNumberLink> linkList = artNumberLinkMap.get(number);
                           if (CollectionUtils.isNotEmpty(linkList) && linkList.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                              numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(number).build());
                           }
                        }
                     }
                  } else {
                     for (MesBuildingProduceTeamReport report : reportMap.get(e.getId())) {
                        numberDTOS.add(AppTaskProcessArtifactNumberDTO.builder().number(report.getNumber()).build());
                     }
                  }

                  dtox.setArtifactNumberList(numberDTOS);
                  if (dtox.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType()) && dtox.getSequence().equals(0)) {
                     List<ArtifactAssociationCount> artifactAssociationCounts = assciationMap.get(dtox.getProductId());
                     int min = dtox.getArtifactNumberList().size();
                     if (CollectionUtils.isNotEmpty(artifactAssociationCounts)) {
                        for (ArtifactAssociationCount artifactAssociationCount : artifactAssociationCounts) {
                           if (min > artifactAssociationCount.getUnusedQuantity() / artifactAssociationCount.getQuantity()) {
                              min = artifactAssociationCount.getUnusedQuantity() / artifactAssociationCount.getQuantity();
                           }
                        }
                     }

                     dtox.setProducibleQuantity(min);
                  } else {
                     dtox.setProducibleQuantity(dtox.getNeedQuantity() - dtox.getCompleteQuantity());
                  }

                  return dtox;
               }
            )
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(dtos)) {
            for (MesBuildingTaskProcessDTO dto : dtos) {
               MesBuildingTask task = taskMap.get(dto.getTaskId());
               dto.setBoolOneCode(task.getBoolOneCode());
               if (task.getBoolOneCode()) {
                  dto.setBoolFirstProcess(Boolean.FALSE);
                  dto.setSequence(1);
                  dto.setCodingType(CodingTypeEnum.SINGLE.getType());
               } else {
                  dto.setBoolFirstProcess(dto.getSequence().equals(0));
                  dto.setCodingType(CodingTypeEnum.BATCH.getType());
                  dto.setSequence(dto.getSequence());
               }
            }
         }

         pageVO.setContent(dtos);
         return pageVO;
      } else {
         return new PageVO<>();
      }
   }
}
