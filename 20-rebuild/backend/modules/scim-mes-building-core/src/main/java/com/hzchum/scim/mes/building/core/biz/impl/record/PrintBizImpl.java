package com.hzchum.scim.mes.building.core.biz.impl.record;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.HandleMethodEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.record.PrintBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.record.PrintTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackage;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingPrintRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.PrintReportDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingReportNumberStatusDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProjectReturnRepairArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProjectReturnRepairSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.ProjectReturnRepairQueryDTOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingPrintRecordService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.EnclosurePrint;
import com.hzchum.scim.mes.enclosure.core.api.service.task.EnclosurePrintService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryMaterialService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class PrintBizImpl implements PrintBiz {
   @Autowired
   private MesBuildingPrintRecordService printRecordService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingPackageService packageService;
   @Autowired
   private TechAuxiliaryMaterialService auxiliaryMaterialService;
   @Autowired
   private TechStandardPartService techStandardPartService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Autowired
   private EnclosurePrintService enclosurePrintService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private PlanAreaService areaService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private ProjectReturnProductChildService projectReturnProductChildService;

   @Override
   public Long savePrintRecord(Integer type, PrintReportDTOParam param) {
      Long relateId = null;
      MesBuildingTask task = null;
      if (PrintTypeEnum.TASK.getType().equals(type)) {
         Preconditions.checkArgument(param.getTaskId() != null, "添加打印记录失败，任务id不能为空");
         task = this.taskService.getById(param.getTaskId());
         Preconditions.checkArgument(task != null, "添加打印记录失败，任务不存在");
         relateId = param.getTaskId();
         task.setPrintQuantity(task.getPrintQuantity() + param.getQuantity().intValue());
         task.setPrintTime(LocalDateTime.now());
         this.taskService.updateById(task);
      } else if (PrintTypeEnum.PACKAGE.getType().equals(type)) {
         Preconditions.checkArgument(param.getPackId() != null, "添加打印记录失败，包id不能为空");
         MesBuildingPackage pack = this.packageService.getById(param.getPackId());
         Preconditions.checkArgument(pack != null, "添加打印记录失败，包不存在");
         pack.setPrintQuantity(pack.getPrintQuantity().add(param.getQuantity()));
         pack.setPrintTime(LocalDateTime.now());
         pack.setPrintType(true);
         relateId = param.getPackId();
         this.packageService.updateById(pack);
      } else if (!PrintTypeEnum.WAREHOUSE.getType().equals(type) && !PrintTypeEnum.RETURN_REPAIR.getType().equals(type)) {
         Preconditions.checkArgument(param.getMaterialId() != null, "添加打印记录失败，材料id不能为空");
         TechStandardPart part = this.techStandardPartService.getById(param.getMaterialId());
         Preconditions.checkArgument(part != null, "添加打印记录失败，配套件不存在");
         relateId = param.getMaterialId();
         part.setPrintQuantity(part.getPrintQuantity().add(param.getQuantity()));
         part.setPrintTime(LocalDateTime.now());
         this.techStandardPartService.updateById(part);
      } else {
         MesBuildingWarehouseSummary warehouseSummary = this.warehouseSummaryService.getById(param.getWarehouseId());
         Preconditions.checkArgument(warehouseSummary != null, "添加打印记录失败，入库记录不存在!");
         relateId = warehouseSummary.getId();
         warehouseSummary.setPrintQuantity(warehouseSummary.getPrintQuantity().add(param.getQuantity()));
         warehouseSummary.setPrintTime(LocalDateTime.now());
         warehouseSummary.setBoolPrinted(Boolean.TRUE);
         this.warehouseSummaryService.updateById(warehouseSummary);
      }

      MesBuildingPrintRecord printRecord = MesBuildingPrintRecord.builder()
         .type(type)
         .userId(UserUtil.getCurrentUserId())
         .userName(UserUtil.getCurrentName())
         .quantity(param.getQuantity())
         .relateId(relateId)
         .startTime(param.getStartTime())
         .endTime(param.getEndTime())
         .build();
      if (CollectionUtils.isNotEmpty(param.getNumberList())) {
         printRecord.setNumbers(param.getNumberList().stream().filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(",")));
      }

      this.printRecordService.save(printRecord);
      return printRecord.getId();
   }

   @Override
   public Boolean savePrint(Long warehouseId, BigDecimal quantity) {
      MesBuildingWarehouseSummary warehouseSummary = this.warehouseSummaryService.getById(warehouseId);
      Preconditions.checkArgument(warehouseSummary != null, "库存不存在");
      warehouseSummary.setBoolPrinted(true);
      warehouseSummary.setPrintQuantity(warehouseSummary.getPrintQuantity().add(quantity));
      warehouseSummary.setPrintTime(LocalDateTime.now());
      this.warehouseSummaryService.updateById(warehouseSummary);
      EnclosurePrint print = EnclosurePrint.builder()
         .printTime(LocalDateTime.now())
         .userId(UserUtil.getCurrentUserId())
         .userName(UserUtil.getCurrentName())
         .taskId(warehouseSummary.getId())
         .quantity(quantity.intValue())
         .build();
      this.enclosurePrintService.save(print);
      return true;
   }

   @Override
   public PageVO<ProjectReturnRepairSummaryDTO> listArtifactReturnProject(ProjectReturnRepairQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
               .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
               .eq(param.getProjectId() != null, MesBuildingWarehouseSummary::getProjectId, param.getProjectId())
               .eq(MesBuildingWarehouseSummary::getWarehouseType, WarehouseTypeProductReturnEnum.REPAIR.getType())
               .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
         );
      if (warehouseSummaryList.isEmpty()) {
         return new PageVO<>();
      }

      Map<Long, Integer> projectIdReturnQuantityMap = warehouseSummaryList.stream()
         .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProjectId, Collectors.summingInt(s -> s.getQuantity().intValue())));
      Map<Long, Integer> projectIdShipQuantityMap = warehouseSummaryList.stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingWarehouseSummary::getProjectId, Collectors.summingInt(s -> s.getCargoQuantity().intValue() + s.getPackageQuantity().intValue())
            )
         );
      Map<Long, ProjectInfo> projectMap = this.projectService
         .listByIds(projectIdReturnQuantityMap.keySet())
         .stream()
         .map(cp -> ProjectInfo.builder().id(cp.getId()).name(cp.getName()).shortName(cp.getShortName()).serialNumber(cp.getSerialNumber()).build())
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      List<ProjectReturnRepairSummaryDTO> returnRepairList = new ArrayList<>(projectIdShipQuantityMap.keySet().size() * 2);
      projectIdReturnQuantityMap.forEach(
         (pId, returnQuantity) -> {
            ProjectReturnRepairSummaryDTO dto = ProjectReturnRepairSummaryDTO.builder()
               .project(projectMap.get(pId))
               .productType(ProductTypeEnum.ARTIFACT.getType())
               .handleMethod(HandleMethodEnum.REPAIR.getType())
               .returnQuantity(returnQuantity)
               .shipQuantity(projectIdShipQuantityMap.getOrDefault(pId, 0))
               .build();
            if (dto.getShipQuantity() == 0) {
               dto.setReturnShipStatus(1);
            } else if (dto.getShipQuantity() < dto.getReturnQuantity()) {
               dto.setReturnShipStatus(2);
            } else {
               dto.setReturnShipStatus(4);
            }

            returnRepairList.add(dto);
         }
      );
      List<ProjectReturnRepairSummaryDTO> resultList = returnRepairList.stream()
         .filter(s -> param.getReturnShipStatus() == null || param.getReturnShipStatus().equals(s.getReturnShipStatus()))
         .collect(Collectors.toList());
      return PageUtil.listPage(pageNumber, pageSize, resultList);
   }

   @Override
   public List<ProjectReturnRepairArtifactDTO> listReturnRepairArtifact(Long projectId) {
      List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
               .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
               .eq(MesBuildingWarehouseSummary::getWarehouseType, WarehouseTypeProductReturnEnum.REPAIR.getType())
               .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .eq(MesBuildingWarehouseSummary::getProjectId, projectId)
         );
      if (warehouseSummaryList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, NameInfo> workshopMap = this.workshopService
         .list()
         .stream()
         .map(ws -> NameInfo.builder().id(ws.getId()).name(ws.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, ProjectInfo> projectMap = this.projectService
         .listInfoByIdList(warehouseSummaryList.stream().map(MesBuildingWarehouseSummary::getProjectId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      Map<Long, NameInfo> monomerMap = this.monomerService
         .listNameInfo(warehouseSummaryList.stream().map(MesBuildingWarehouseSummary::getMonomerId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, NameInfo> areaMap = this.areaService
         .listSimpleByIds(warehouseSummaryList.stream().map(MesBuildingWarehouseSummary::getAreaId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Set<Long> productIds = warehouseSummaryList.stream().map(MesBuildingWarehouseSummary::getProductId).collect(Collectors.toSet());
      Map<Long, TechArtifact> artifactMap = this.artifactService
         .listByIds(productIds)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
         .list(
            Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
               .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
               .eq(MesBuildingWarehouseRecord::getWarehouseType, WarehouseTypeProductReturnEnum.REPAIR.getType())
               .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .in(MesBuildingWarehouseRecord::getProductId, productIds)
         );
      Map<Long, Map<Long, List<MesBuildingWarehouseRecord>>> productIdWorkshopIdListMap = warehouseRecordList.stream()
         .collect(Collectors.groupingBy(MesBuildingWarehouseRecord::getProductId, Collectors.groupingBy(MesBuildingWarehouseRecord::getWorkshopId)));
      List<ProjectReturnRepairArtifactDTO> repairArtifactList = new ArrayList<>(warehouseSummaryList.size() * 2);
      warehouseSummaryList.forEach(
         warehouseSummary -> {
            TechArtifact artifact = artifactMap.get(warehouseSummary.getProductId());
            if (artifact != null) {
               ProjectReturnRepairArtifactDTO repairArtifactDTO = BeanUtil.copy(artifact, ProjectReturnRepairArtifactDTO.class);
               repairArtifactDTO.setWarehouseId(warehouseSummary.getId());
               repairArtifactDTO.setProductId(warehouseSummary.getProductId());
               repairArtifactDTO.setProductType(ProductTypeEnum.ARTIFACT.getType());
               repairArtifactDTO.setProject(projectMap.get(warehouseSummary.getProjectId()));
               repairArtifactDTO.setMonomer(monomerMap.get(warehouseSummary.getMonomerId()));
               repairArtifactDTO.setArea(areaMap.get(warehouseSummary.getAreaId()));
               repairArtifactDTO.setWorkshop(workshopMap.get(warehouseSummary.getWorkshopId()));
               repairArtifactDTO.setReturnQuantity(warehouseSummary.getQuantity().intValue());
               repairArtifactDTO.setShipQuantity(warehouseSummary.getCargoQuantity().intValue() + warehouseSummary.getPackageQuantity().intValue());
               repairArtifactDTO.setPrintQuantity(warehouseSummary.getPrintQuantity().intValue());
               repairArtifactDTO.setBoolPrinted(warehouseSummary.getBoolPrinted());
               repairArtifactDTO.setBoolOneCode(artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType()));
               List<MesBuildingWarehouseRecord> recordList = productIdWorkshopIdListMap.getOrDefault(warehouseSummary.getProductId(), Collections.emptyMap())
                  .getOrDefault(warehouseSummary.getWorkshopId(), Collections.emptyList());
               List<MesBuildingReportNumberStatusDTO> numberStatusDTOList = recordList.stream()
                  .map(
                     record -> MesBuildingReportNumberStatusDTO.builder()
                        .number(record.getNumber() != null ? (long)record.getNumber().intValue() : null)
                        .status(record.getStatus())
                        .name(WarehouseRecordStatusTypeEnum.getNameByType(record.getStatus()))
                        .build()
                  )
                  .collect(Collectors.toList());
               repairArtifactDTO.setNumberStatusDTOS(numberStatusDTOList);
               repairArtifactList.add(repairArtifactDTO);
            }
         }
      );
      return repairArtifactList;
   }
}
