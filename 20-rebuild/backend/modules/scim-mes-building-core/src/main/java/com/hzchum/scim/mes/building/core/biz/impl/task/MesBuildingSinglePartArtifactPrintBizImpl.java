package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingSinglePartArtifactPrintBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingSinglePartArtifactPrintRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ExternalArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.PrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SingPringReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartArtifactPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartReportDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSinglePartArtifactPrintService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingSinglePartArtifactPrintRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingSinglePartArtifactWarehouseLinkService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingSinglePartArtifactPrintMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingSinglePartArtifactPrintBizImpl
   extends IBizImpl<MesBuildingSinglePartArtifactPrintService, MesBuildingSinglePartArtifactPrintMapper, MesBuildingSinglePartArtifactPrint>
   implements MesBuildingSinglePartArtifactPrintBiz {
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private MesBuildingWarehouseRecordService recordService;
   @Resource
   private MesBuildingWarehouseSummaryService summaryService;
   @Autowired
   private MesBuildingSinglePartArtifactPrintService singlePartArtifactPrintService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingSinglePartArtifactWarehouseLinkService printLinkService;
   @Resource
   private MesBuildingSinglePartArtifactPrintRecordService partArtifactPrintRecordService;
   @Resource
   private MesBuildingSinglePartArtifactPrintRecordService singlePartArtifactPrintRecordService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private MesBuildingCompleteService mesBuildingCompleteService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingTaskBiz mesBuildingTaskBiz;
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingTaskNumberLinkService numberLinkService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean assistArtifactReport(List<ExternalArtifactDTO> externalArtifactDTOS) {
      if (CollectionUtils.isEmpty(externalArtifactDTOS)) {
         return true;
      }

      List<Long> productIds = externalArtifactDTOS.stream().map(ExternalArtifactDTO::getProductId).collect(Collectors.toList());
      List<TechArtifact> techArtifacts = this.techArtifactService.listByIds(productIds);
      Map<Long, TechArtifact> artifactMap = techArtifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity(), (s1, s2) -> s1));
      List<MesBuildingSinglePartArtifactPrint> prints = new ArrayList<>();
      Map<Long, Integer> idAndCondeType = techArtifacts.stream().collect(Collectors.toMap(TechArtifact::getId, TechArtifact::getCodingType));
      List<Long> singleIds = techArtifacts.stream()
         .filter(s -> s.getCodingType().equals(CodingTypeEnum.SINGLE.getType()))
         .map(TechArtifact::getId)
         .collect(Collectors.toList());
      HashMap<Long, Integer> numberMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(singleIds)) {
         Map<Long, List<MesBuildingSinglePartArtifactPrint>> collect = this.singlePartArtifactPrintService
            .list(Wrappers.lambdaQuery(MesBuildingSinglePartArtifactPrint.class).in(MesBuildingSinglePartArtifactPrint::getProductId, singleIds))
            .stream()
            .collect(Collectors.groupingBy(MesBuildingSinglePartArtifactPrint::getProductId));

         for (Long productId : collect.keySet()) {
            int sum = new ArrayList<>(collect.get(productId)).size();
            numberMap.put(productId, sum);
         }
      }

      for (ExternalArtifactDTO dto : externalArtifactDTOS) {
         if (idAndCondeType.get(dto.getProductId()) != null && idAndCondeType.get(dto.getProductId()).equals(CodingTypeEnum.SINGLE.getType())) {
            Integer number = numberMap.get(dto.getProductId()) == null ? 0 : numberMap.get(dto.getProductId());

            for (int i = 1; i < dto.getQuantity() + 1; i++) {
               prints.add(
                  MesBuildingSinglePartArtifactPrint.builder()
                     .productId(dto.getProductId())
                     .workshopId(dto.getWorkShopId())
                     .quantity(1)
                     .reportQuantity(0)
                     .number(number + i)
                     .warehousingType(dto.getWarehousingType())
                     .boolAllReport(false)
                     .operationId(UserUtil.getCurrentUserId())
                     .boolAssist(true)
                     .build()
               );
            }
         } else if (idAndCondeType.get(dto.getProductId()) != null && idAndCondeType.get(dto.getProductId()).equals(CodingTypeEnum.BATCH.getType())) {
            prints.add(
               MesBuildingSinglePartArtifactPrint.builder()
                  .productId(dto.getProductId())
                  .workshopId(dto.getWorkShopId())
                  .quantity(dto.getQuantity())
                  .reportQuantity(0)
                  .number(null)
                  .warehousingType(dto.getWarehousingType())
                  .boolAllReport(false)
                  .operationId(UserUtil.getCurrentUserId())
                  .boolAssist(true)
                  .build()
            );
         }
      }

      this.singlePartArtifactPrintService.saveBatch(prints);
      List<MesBuildingSinglePartArtifactPrint> outList = prints.stream().filter(s -> s.getWarehousingType().equals(1)).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(outList)) {
         Map<Long, MesBuildingWorkshop> workshopMap = this.workshopService
            .listByIds(outList.stream().map(MesBuildingSinglePartArtifactPrint::getWorkshopId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(s -> s.getId(), Function.identity(), (s1, s2) -> s1));
         List<MesBuildingWarehouseRecord> records = new ArrayList<>();
         new ArrayList();
         List<SinglePartReportDTO> singlePartReportDTOS = new ArrayList<>();

         for (MesBuildingSinglePartArtifactPrint record : outList) {
            TechArtifact techArtifact = artifactMap.get(record.getProductId());
            singlePartReportDTOS.add(
               SinglePartReportDTO.builder()
                  .productId(record.getProductId())
                  .workshopId(record.getWorkshopId())
                  .number(record.getNumber())
                  .quantity(record.getQuantity())
                  .build()
            );
            records.add(
               MesBuildingWarehouseRecord.builder()
                  .projectId(techArtifact.getProjectId())
                  .monomerId(techArtifact.getMonomerId())
                  .areaId(techArtifact.getAreaId())
                  .productId(record.getProductId())
                  .factoryId(workshopMap.get(record.getWorkshopId()).getFactoryId())
                  .workshopId(record.getWorkshopId())
                  .productType(TaskTypeEnum.ARTIFACT.getType())
                  .type(WarehouseTypeEnum.OUT.getType())
                  .quantity(BigDecimal.valueOf(record.getQuantity().intValue()))
                  .userId(UserUtil.getCurrentUserId())
                  .userName(UserUtil.getCurrentName())
                  .number(record.getNumber())
                  .status(WarehouseRecordStatusTypeEnum.OUT.getType())
                  .build()
            );
            MesBuildingWarehouseSummary out = this.summaryService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .eq(MesBuildingWarehouseSummary::getProductId, record.getProductId())
                     .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.ARTIFACT.getType())
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.OUT.getType())
               );
            if (out != null) {
               out.setQuantity(out.getQuantity().add(BigDecimal.valueOf(record.getQuantity().intValue())));
            } else {
               out = MesBuildingWarehouseSummary.builder()
                  .projectId(techArtifact.getProjectId())
                  .monomerId(techArtifact.getMonomerId())
                  .areaId(techArtifact.getAreaId())
                  .productId(record.getProductId())
                  .factoryId(workshopMap.get(record.getWorkshopId()).getFactoryId())
                  .workshopId(record.getWorkshopId())
                  .productType(TaskTypeEnum.ARTIFACT.getType())
                  .type(WarehouseTypeEnum.OUT.getType())
                  .quantity(BigDecimal.valueOf(record.getQuantity().intValue()))
                  .build();
            }

            this.summaryService.saveOrUpdate(out);
         }

         this.recordService.saveBatch(records);
         Map<String, List<SinglePartReportDTO>> singMap = singlePartReportDTOS.stream()
            .collect(Collectors.groupingBy(s -> s.getProductId() + "_" + s.getWorkshopId()));

         for (String str : singMap.keySet()) {
            List<SinglePartReportDTO> dtos = singMap.get(str);
            this.report(
               SinglePartReportDTO.builder()
                  .productId(dtos.get(0).getProductId())
                  .workshopId(dtos.get(0).getWorkshopId())
                  .quantity(dtos.stream().mapToInt(SinglePartReportDTO::getQuantity).sum())
                  .numberList(dtos.stream().map(SinglePartReportDTO::getNumber).collect(Collectors.toList()))
                  .build()
            );
         }
      }

      return true;
   }

   @Override
   public PageVO<SinglePartArtifactPrintDTO> getPrintList(
      Integer printType, Long projectId, Long monomerId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() != 0 && printType != null) {
         List<SinglePartArtifactPrintDTO> printList = this.baseService.getPrintList(printType, projectIds, projectId, monomerId, areaId, serialNumber);
         if (CollectionUtils.isEmpty(printList)) {
            return new PageVO<>();
         }

         Map<String, List<SinglePartArtifactPrintDTO>> singMap = printList.stream().collect(Collectors.groupingBy(e -> e.getProductId() + "_" + e.getTaskId()));
         List<SinglePartArtifactPrintDTO> dtos = new ArrayList<>();
         List<Long> productIds = printList.stream().map(SinglePartArtifactPrintDTO::getProductId).collect(Collectors.toList());
         List<TechArtifact> artifacts = this.techArtifactService.listByIds(productIds);
         Map<Long, TechArtifact> artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity(), (s1, s2) -> s1));
         List<Long> allTaskIds = printList.stream().map(SinglePartArtifactPrintDTO::getTaskId).distinct().collect(Collectors.toList());
         List<MesBuildingTask> tasks = this.taskService.listByIds(allTaskIds);
         Map<Long, MesBuildingTask> taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity(), (s1, s2) -> s1));

         for (String productIdAndTaskId : singMap.keySet()) {
            List<SinglePartArtifactPrintDTO> singList = singMap.get(productIdAndTaskId);
            String[] split = productIdAndTaskId.split("_");
            SinglePartArtifactPrintDTO dto = singList.get(0);
            SinglePartArtifactPrintDTO copy = BeanUtil.copy(dto, SinglePartArtifactPrintDTO.class);
            copy.setNumber(null);
            copy.setBoolOneCode(false);
            if (printType == 0) {
               List<Integer> numberLists = singList.stream()
                  .filter(s -> !s.getBoolAllReport())
                  .filter(s -> s.getCanReportQuantity() > 0)
                  .map(SinglePartArtifactPrintDTO::getNumber)
                  .collect(Collectors.toList());
               copy.setNumberList(numberLists);
            } else {
               List<Integer> numberLists = singList.stream()
                  .filter(SinglePartArtifactPrintDTO::getBoolAllReport)
                  .map(SinglePartArtifactPrintDTO::getNumber)
                  .collect(Collectors.toList());
               copy.setNumberList(numberLists);
            }

            copy.setCanReportQuantity(singList.stream().mapToInt(SinglePartArtifactPrintDTO::getCanReportQuantity).sum());
            copy.setReportQuantity(Math.toIntExact(singList.stream().filter(SinglePartArtifactPrintDTO::getBoolAllReport).count()));
            copy.setBoolOneCode(true);
            if (!taskMap.get(copy.getTaskId()).getBoolOneCode()) {
               copy.setBoolOneCode(Boolean.FALSE);
               copy.setNumberList(new ArrayList<>());
            }

            MesBuildingTask task = this.taskService.getById(split[1]);
            copy.setTaskQuantity(task.getTaskQuantity());
            int sum = this.singlePartArtifactPrintRecordService
               .list(
                  Wrappers.lambdaQuery(MesBuildingSinglePartArtifactPrintRecord.class)
                     .eq(MesBuildingSinglePartArtifactPrintRecord::getProductId, split[0])
                     .eq(MesBuildingSinglePartArtifactPrintRecord::getTaskId, split[1])
               )
               .stream()
               .mapToInt(MesBuildingSinglePartArtifactPrintRecord::getPrintQuantity)
               .sum();
            copy.setPrintQuantity(sum);
            dtos.add(copy);
         }

         if (printType == 0) {
            dtos = dtos.stream().filter(s -> s.getCanReportQuantity() > 0).collect(Collectors.toList());
         } else {
            dtos = dtos.stream().filter(s -> s.getReportQuantity() > 0).collect(Collectors.toList());
         }

         dtos = dtos.stream().sorted(Comparator.comparing(SinglePartArtifactPrintDTO::getProductId)).collect(Collectors.toList());
         return this.getPages(pageNumber, pageSize, dtos);
      } else {
         return new PageVO<>();
      }
   }

   @Override
   public PageVO<SingPringReportDTO> record(Long productId, Long workshopId, Integer pageNumber, Integer pageSize) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      List<SingPringReportDTO> list = this.partArtifactPrintRecordService.listRecord(productId, workshopId);
      Map<String, List<SingPringReportDTO>> singMap = list.stream().collect(Collectors.groupingBy(sx -> sx.getPrintTime() + ""));
      List<SingPringReportDTO> dtos = new ArrayList<>();
      TechArtifact artifact = this.techArtifactService.getById(productId);
      if (artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
         for (String s : singMap.keySet()) {
            List<SingPringReportDTO> singPringReportDTOS = singMap.get(s);
            List<Integer> numbers = singPringReportDTOS.stream().map(SingPringReportDTO::getNumber).collect(Collectors.toList());
            SingPringReportDTO copy = BeanUtil.copy(singPringReportDTOS.get(0), SingPringReportDTO.class);
            copy.setNumber(null);
            copy.setNumbers(numbers);
            dtos.add(copy);
         }
      } else {
         dtos = list;
      }

      return this.getPages(pageNumber, pageSize, dtos);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePrint(PrintDTO dto) {
      List<Integer> numberList = dto.getNumberList();
      int printQuantity = CollectionUtils.isNotEmpty(numberList) ? numberList.size() : dto.getPrintQuantity();
      List<MesBuildingSinglePartArtifactPrintRecord> records = new ArrayList<>();
      TechArtifact artifact = this.techArtifactService.getById(dto.getProductId());
      LocalDateTime printTime = LocalDateTime.now();
      Preconditions.checkArgument(artifact != null, "构件信息不存在");
      if (artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberList), "一物一码产品,必需有一物一码编号");

         for (Integer number : numberList) {
            records.add(
               MesBuildingSinglePartArtifactPrintRecord.builder()
                  .printQuantity(1)
                  .printUserId(UserUtil.getCurrentUserId())
                  .productId(dto.getProductId())
                  .printTime(printTime)
                  .workshopId(dto.getWorkshopId())
                  .taskId(dto.getTaskId())
                  .number(number)
                  .build()
            );
         }
      } else {
         records.add(
            MesBuildingSinglePartArtifactPrintRecord.builder()
               .printQuantity(printQuantity)
               .printTime(printTime)
               .printUserId(UserUtil.getCurrentUserId())
               .productId(dto.getProductId())
               .workshopId(dto.getWorkshopId())
               .taskId(dto.getTaskId())
               .build()
         );
      }

      this.partArtifactPrintRecordService.saveBatch(records);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean report(SinglePartReportDTO report) {
      this.mesBuildingTaskBiz.checkProductStatus(Collections.singletonList(report.getProductId()), TaskTypeEnum.ARTIFACT.getType());
      TechArtifact techArtifact = this.techArtifactService.getById(report.getProductId());
      Integer reportQuantity = CollectionUtils.isNotEmpty(report.getNumberList()) ? report.getNumberList().size() : report.getQuantity();
      techArtifact.setProducedQuantity(techArtifact.getProducedQuantity() + reportQuantity);
      Preconditions.checkArgument(techArtifact.getProducedQuantity() <= techArtifact.getQuantity(), "上报失败,请刷新后重试!!!");
      this.techArtifactService.updateById(techArtifact);
      int unUseQuantity = 0;
      List<TechArtifactMachinePartLink> machinePartLinks = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, techArtifact.getId()));
      if (CollectionUtils.isNotEmpty(machinePartLinks)) {
         List<TechMachinePart> machineParts = this.machinePartService
            .listByIds(machinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList()));
         Map<Long, TechMachinePart> machinePartMap = machineParts.stream()
            .filter(s -> s.getRelationType() == 2)
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         Map<Long, Integer> partMap = machinePartLinks.stream()
            .filter(s -> machinePartMap.containsKey(s.getMachinePartId()))
            .collect(Collectors.toMap(TechArtifactMachinePartLink::getMachinePartId, TechArtifactMachinePartLink::getQuantity));

         for (Long id : partMap.keySet()) {
            TechMachinePart techMachinePart = machinePartMap.get(id);
            techMachinePart.setUsedQuantity(techMachinePart.getUsedQuantity() + partMap.get(id) * reportQuantity);
            unUseQuantity = techMachinePart.getProducedQuantity() - techMachinePart.getUsedQuantity();
            Preconditions.checkArgument(techMachinePart.getProducedQuantity() >= techMachinePart.getUsedQuantity(), "上报失败,请刷新后重试!!!");
            machinePartMap.put(id, techMachinePart);
         }

         this.machinePartService.updateBatchById(machinePartMap.values());
      }

      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).eq(TechAssembleDetail::getArtifactId, techArtifact.getId()));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         Map<Long, Integer> assMap = assembleDetailList.stream().collect(Collectors.toMap(TechAssembleDetail::getAssembleId, TechAssembleDetail::getQuantity));
         Map<Long, TechAssemble> assembleMap = this.assembleService
            .listByIds(assMap.keySet())
            .stream()
            .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

         for (Long id : assMap.keySet()) {
            TechAssemble techAssemble = assembleMap.get(id);
            techAssemble.setUsedQuantity(techAssemble.getUsedQuantity() + assMap.get(id) * reportQuantity);
            unUseQuantity = techAssemble.getProducedQuantity() - techAssemble.getUsedQuantity();
            Preconditions.checkArgument(techAssemble.getProducedQuantity() >= techAssemble.getUsedQuantity(), "上报失败,请刷新后重试!!!");
            assembleMap.put(id, techAssemble);
         }

         List<TechAssemble> assList = new ArrayList<>(assembleMap.values());
         this.assembleService.updateBatchById(assList);
      }

      List<Integer> numberList = report.getNumberList();
      List<MesBuildingSinglePartArtifactPrint> printsList = this.baseService
         .list(
            Wrappers.lambdaQuery(MesBuildingSinglePartArtifactPrint.class)
               .eq(MesBuildingSinglePartArtifactPrint::getProductId, report.getProductId())
               .eq(MesBuildingSinglePartArtifactPrint::getBoolAllReport, false)
               .eq(MesBuildingSinglePartArtifactPrint::getTaskId, report.getTaskId())
               .in(CollectionUtils.isNotEmpty(numberList), MesBuildingSinglePartArtifactPrint::getNumber, numberList)
               .orderByAsc(MesBuildingSinglePartArtifactPrint::getNumber)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(printsList), "上报出错,请刷新后重试");
      if (CollectionUtils.isNotEmpty(numberList)) {
         Preconditions.checkArgument(printsList.size() == numberList.size(), "上报出错,存在无法上报的一物一码编号");
      } else {
         Preconditions.checkArgument(printsList.size() >= reportQuantity, "操作失败,请刷新页面后重试!!!");
         printsList = printsList.stream().limit(reportQuantity.intValue()).collect(Collectors.toList());
      }

      Map<Long, Integer> taskMap = new HashMap<>();
      MesBuildingWorkshop workshop = this.workshopService.getById(report.getWorkshopId());
      new HashMap();

      for (MesBuildingSinglePartArtifactPrint print : printsList) {
         if (reportQuantity > 0) {
            print.setBoolAllReport(true);
            print.setReportQuantity(1);
            print.setQuantity(0);
            this.baseService.updateById(print);
            Long lineId = null;
            if (print.getTaskId() != null) {
               MesBuildingTask task = this.taskService.getById(print.getTaskId());
               task.setCompleteQuantity(task.getCompleteQuantity() + 1);
               if (task.getTaskQuantity().equals(task.getCompleteQuantity())) {
                  task.setCompleteTime(LocalDateTime.now());
               }

               this.taskService.updateById(task);
               lineId = task.getProductionLineId();
               if (techArtifact.getBoolAllPartSendDirectly()) {
                  taskMap.merge(task.getId(), 1, Integer::sum);
               }
            }

            MesBuildingComplete complete = MesBuildingComplete.builder()
               .projectId(techArtifact.getProjectId())
               .monomerId(techArtifact.getMonomerId())
               .areaId(techArtifact.getAreaId())
               .artifactTaskId(techArtifact.getAreaBatchId())
               .factoryId(workshop.getFactoryId())
               .workshopId(workshop.getId())
               .productionLineId(lineId)
               .productId(techArtifact.getId())
               .quantity(1)
               .taskTypeEnum(TaskTypeEnum.ARTIFACT.getType())
               .boolAbnormalEnum(false)
               .taskId(print.getTaskId())
               .number(print.getNumber())
               .userId(UserUtil.getCurrentUserId())
               .singId(print.getId())
               .build();
            this.mesBuildingCompleteService.save(complete);
            MesBuildingWarehouseRecord build = MesBuildingWarehouseRecord.builder()
               .workshopId(print.getWorkshopId())
               .factoryId(workshop.getFactoryId())
               .projectId(techArtifact.getProjectId())
               .monomerId(techArtifact.getMonomerId())
               .areaId(techArtifact.getAreaId())
               .areaBatchId(techArtifact.getAreaBatchId())
               .productId(print.getProductId())
               .completeId(complete.getId())
               .productType(TaskTypeEnum.ARTIFACT.getType())
               .type(WarehouseTypeEnum.INTO.getType())
               .quantity(BigDecimal.ONE)
               .userId(UserUtil.getCurrentUserId())
               .userName(UserUtil.getCurrentName())
               .number(print.getNumber())
               .status(WarehouseRecordStatusTypeEnum.INTO.getType())
               .build();
            this.recordService.save(build);
            MesBuildingWarehouseSummary summary = this.summaryService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .eq(MesBuildingWarehouseSummary::getProductId, report.getProductId())
                     .eq(MesBuildingWarehouseSummary::getWorkshopId, print.getWorkshopId())
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.ARTIFACT.getType())
               );
            if (summary != null) {
               summary.setQuantity(summary.getQuantity().add(BigDecimal.ONE));
            } else {
               summary = MesBuildingWarehouseSummary.builder()
                  .workshopId(print.getWorkshopId())
                  .factoryId(workshop.getFactoryId())
                  .projectId(techArtifact.getProjectId())
                  .monomerId(techArtifact.getMonomerId())
                  .areaId(techArtifact.getAreaId())
                  .areaBatchId(techArtifact.getAreaBatchId())
                  .productId(print.getProductId())
                  .productType(TaskTypeEnum.ARTIFACT.getType())
                  .type(WarehouseTypeEnum.INTO.getType())
                  .quantity(BigDecimal.ONE)
                  .build();
            }

            this.summaryService.saveOrUpdate(summary);
         }
      }

      new ArrayList();
      Map<Long, List<MesBuildingSinglePartArtifactPrint>> artNumberReportMap = printsList.stream()
         .collect(Collectors.groupingBy(MesBuildingSinglePartArtifactPrint::getProductId));

      for (Long artId : artNumberReportMap.keySet()) {
         List<MesBuildingSinglePartArtifactPrint> prints = artNumberReportMap.get(artId);
         List<Integer> artNumberList = prints.stream().map(MesBuildingSinglePartArtifactPrint::getNumber).collect(Collectors.toList());
         List<MesBuildingTaskNumberLink> artNumberLinks = this.numberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactId, artId)
                  .in(MesBuildingTaskNumberLink::getArtifactNumber, artNumberList)
            );
         Preconditions.checkArgument(artNumberLinks.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete), "操作失败!!!");
         artNumberLinks.forEach(s -> s.setBoolArtifactComplete(Boolean.TRUE).setBoolArtifactInproduce(Boolean.TRUE));
         this.numberLinkService.updateBatchById(artNumberLinks);
      }

      return true;
   }

   private PageVO getPages(Integer pageNumber, Integer pageSize, List list) {
      PageVO page = new PageVO();
      if (list == null) {
         return null;
      }

      int size = list.size();
      if (pageSize > size) {
         pageSize = size;
      }

      if (pageSize != 0) {
         int maxPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
         if (pageNumber > maxPage) {
            pageNumber = maxPage;
         }

         page.setHasNextPage(pageNumber < maxPage);
      }

      int curIdx = pageNumber > 1 ? (pageNumber - 1) * pageSize : 0;
      List pageList = new ArrayList();

      for (int i = 0; i < pageSize && curIdx + i < size; i++) {
         pageList.add(list.get(curIdx + i));
      }

      page.setHasPreviousPage(pageNumber > 1);
      page.setContent(pageList);
      page.setTotalElements(list.size());
      return page;
   }
}
