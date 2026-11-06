package com.hzchum.scim.mes.enclosure.core.biz.impl.task;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureSchedulingBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.util.MesEnclosureUtilsBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureScheduling;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.IdAndQuantityDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureSchedulingDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.process.MesEnclosureProcessService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureSchedulingService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskOrderService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.system.core.api.common.enums.EnclosureDictionaryTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class MesEnclosureSchedulingBizImpl implements MesEnclosureSchedulingBiz {
   @Autowired
   private MesEnclosureSchedulingService schedulingService;
   @Autowired
   private MesEnclosureProcessService processService;
   @Autowired
   private MesEnclosureUtilsBiz mesEnclosureUtilsBiz;
   @Resource
   private MesEnclosureTaskBiz taskBiz;
   @Resource
   private MesEnclosureTaskService taskService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private MesEnclosureTaskOrderService taskOrderService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveScheduling(MesEnclosureSchedulingDTOParam schedulings) {
      MesEnclosureProcess process = this.processService.list().get(0);
      List<IdAndQuantityDTO> scheduDetail = schedulings.getSchedulings();
      int totalQuantity = scheduDetail.stream().mapToInt(IdAndQuantityDTO::getQuantity).sum();
      List<TechEnclosure> enclosures = this.enclosureService.listByIds(scheduDetail.stream().map(IdAndQuantityDTO::getProductId).collect(Collectors.toList()));
      Map<Long, TechEnclosure> enclosureMap = enclosures.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, Integer> schedulingMap = scheduDetail.stream().collect(Collectors.toMap(IdAndQuantityDTO::getProductId, IdAndQuantityDTO::getQuantity));
      List<TechEnclosure> collect = enclosures.stream()
         .filter(sx -> sx.getQuantity() < schedulingMap.get(sx.getId()) + sx.getSchedulingQuantity())
         .collect(Collectors.toList());
      Preconditions.checkArgument(collect.size() <= 0, "排产数不可大于清单数!");
      schedulingMap.forEach(
         (id, quantity) -> {
            TechEnclosure enclosure = enclosureMap.get(id);
            Preconditions.checkArgument(enclosure != null, "排产的围护数据不存在!");
            Preconditions.checkArgument(
               quantity + enclosure.getSchedulingQuantity() + enclosure.getSubscribeQuantity() <= enclosure.getQuantity(), "围护已申购!排产数量超出限制!"
            );
         }
      );
      Map<Long, BigDecimal> idAndLength = enclosures.stream().collect(Collectors.toMap(TechEnclosure::getId, TechEnclosure::getLength, (s1, s2) -> s1));
      String name = EnclosureDictionaryTypeEnum.getNameByType(schedulings.getCategory());
      String s = "";
      if (schedulings.getCategory().equals(2)) {
         s = "YXCB";
      }

      if (schedulings.getCategory().equals(4)) {
         s = "JXB";
      }

      if (schedulings.getCategory().equals(8)) {
         s = "HJLCB";
      }

      if (schedulings.getCategory().equals(16)) {
         s = "YXLCB";
      }

      if (schedulings.getCategory().equals(32)) {
         s = "ZBJ";
      }

      DateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
      String formatDate = sdf2.format(new Date());
      int size = this.taskOrderService.list(Wrappers.lambdaQuery(MesEnclosureTaskOrder.class).apply("date(create_time) = Date({0})", LocalDate.now())).size()
         + 1;
      String oruderNumber = s + "-" + formatDate + "-" + size;
      MesEnclosureTaskOrder taskOrder = MesEnclosureTaskOrder.builder()
         .projectId(schedulings.getProjectId())
         .factoryId(schedulings.getFactoryId())
         .workshopId(schedulings.getWorkshopId())
         .productionLineId(schedulings.getProductionLineId())
         .teamId(schedulings.getTeamId())
         .quantity(totalQuantity)
         .category(schedulings.getCategory())
         .orderNumber(oruderNumber)
         .askCompleteTime(schedulings.getAskCompleteTime())
         .userId(UserUtil.getCurrentUserId())
         .build();
      this.taskOrderService.save(taskOrder);
      List<MesEnclosureTask> tasks = new ArrayList<>();
      List<TechEnclosure> enclosureList = new ArrayList<>();

      for (IdAndQuantityDTO dto : scheduDetail) {
         MesEnclosureTask task = MesEnclosureTask.builder()
            .factoryId(schedulings.getFactoryId())
            .workshopId(schedulings.getWorkshopId())
            .productionLineId(schedulings.getProductionLineId())
            .teamId(schedulings.getTeamId())
            .taskOrderId(taskOrder.getId())
            .processId(process.getId())
            .projectId(schedulings.getProjectId())
            .planId(enclosureMap.get(dto.getProductId()).getEnclosurePlanId())
            .category(enclosureMap.get(dto.getProductId()).getCategory())
            .taskQuantity(dto.getQuantity())
            .productId(dto.getProductId())
            .userId(UserUtil.getCurrentUserId())
            .askCompleteTime(schedulings.getAskCompleteTime())
            .build();
         tasks.add(task);
         TechEnclosure techEnclosure = enclosureMap.get(dto.getProductId());
         techEnclosure.setSchedulingQuantity(techEnclosure.getSchedulingQuantity() + dto.getQuantity());
         enclosureList.add(techEnclosure);
      }

      this.taskService.saveBatch(tasks);
      this.enclosureService.updateBatchById(enclosureList);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveSchedulingV2(MesEnclosureSchedulingDTOParam schedulings) {
      MesEnclosureProcess process = this.processService.list().get(0);
      List<IdAndQuantityDTO> scheduDetail = schedulings.getSchedulings();
      int totalQuantity = scheduDetail.stream().mapToInt(IdAndQuantityDTO::getQuantity).sum();
      List<TechEnclosure> enclosures = this.enclosureService.listByIds(scheduDetail.stream().map(IdAndQuantityDTO::getProductId).collect(Collectors.toList()));
      Map<Long, TechEnclosure> enclosureMap = enclosures.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, Integer> schedulingMap = scheduDetail.stream().collect(Collectors.toMap(IdAndQuantityDTO::getProductId, IdAndQuantityDTO::getQuantity));
      List<TechEnclosure> collect = enclosures.stream()
         .filter(s -> s.getQuantity() < schedulingMap.get(s.getId()) + s.getSchedulingQuantity())
         .collect(Collectors.toList());
      Preconditions.checkArgument(collect.size() <= 0, "排产数不可大于清单数!");
      ContractProject project = this.contractProjectService.getById(schedulings.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在!");
      schedulingMap.forEach(
         (id, quantity) -> {
            TechEnclosure enclosure = enclosureMap.get(id);
            Preconditions.checkArgument(enclosure != null, "排产的围护数据不存在!");
            Preconditions.checkArgument(
               quantity + enclosure.getSchedulingQuantity() + enclosure.getSubscribeQuantity() <= enclosure.getQuantity(), "围护已申购!排产数量超出限制!"
            );
         }
      );
      DateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
      String formatDate = sdf2.format(new Date());
      int size = this.taskOrderService.list(Wrappers.lambdaQuery(MesEnclosureTaskOrder.class).apply("date(create_time) = Date({0})", LocalDate.now())).size()
         + 1;
      String orderNumber = project.getShortName() + "(围护)-" + formatDate + "-" + size;
      MesEnclosureTaskOrder taskOrder = MesEnclosureTaskOrder.builder()
         .projectId(schedulings.getProjectId())
         .factoryId(schedulings.getFactoryId())
         .workshopId(schedulings.getWorkshopId())
         .productionLineId(schedulings.getProductionLineId())
         .teamId(schedulings.getTeamId())
         .quantity(totalQuantity)
         .dictionaryId(schedulings.getDictionaryId())
         .category(schedulings.getCategory())
         .orderNumber(orderNumber)
         .askCompleteTime(schedulings.getAskCompleteTime())
         .userId(UserUtil.getCurrentUserId())
         .build();
      this.taskOrderService.save(taskOrder);
      List<MesEnclosureTask> tasks = new ArrayList<>();
      List<TechEnclosure> enclosureList = new ArrayList<>();

      for (IdAndQuantityDTO dto : scheduDetail) {
         MesEnclosureTask task = MesEnclosureTask.builder()
            .factoryId(schedulings.getFactoryId())
            .workshopId(schedulings.getWorkshopId())
            .productionLineId(schedulings.getProductionLineId())
            .teamId(schedulings.getTeamId())
            .taskOrderId(taskOrder.getId())
            .processId(process.getId())
            .projectId(schedulings.getProjectId())
            .planId(enclosureMap.get(dto.getProductId()).getEnclosurePlanId())
            .category(enclosureMap.get(dto.getProductId()).getCategory())
            .dictionaryId(enclosureMap.get(dto.getProductId()).getDictionaryId())
            .taskQuantity(dto.getQuantity())
            .productId(dto.getProductId())
            .userId(UserUtil.getCurrentUserId())
            .askCompleteTime(schedulings.getAskCompleteTime())
            .build();
         TechEnclosure techEnclosure = enclosureMap.get(dto.getProductId());
         task.setMonomerId(techEnclosure.getMonomerId());
         task.setAreaId(techEnclosure.getAreaId());
         tasks.add(task);
         techEnclosure.setSchedulingQuantity(techEnclosure.getSchedulingQuantity() + dto.getQuantity());
         enclosureList.add(techEnclosure);
      }

      this.taskService.saveBatch(tasks);
      this.enclosureService.updateBatchById(enclosureList);
      return true;
   }

   @Override
   public List<MesEnclosureScheduling> selectSummaryData(Long lineId, Long projectId) {
      return this.schedulingService
         .list(
            Wrappers.lambdaQuery(MesEnclosureScheduling.class)
               .eq(MesEnclosureScheduling::getProductionLineId, lineId)
               .eq(MesEnclosureScheduling::getProjectId, projectId)
         );
   }

   @Override
   public Map getTotalLength(Long projectId, List<Long> planIds, Integer category) {
      HashMap<String, BigDecimal> map = new HashMap<>();
      List<TechEnclosure> projectList = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getProjectId, projectId)
               .eq(TechEnclosure::getBoolStatusEnum, 1)
               .eq(TechEnclosure::getCategory, category)
         );
      BigDecimal projectLength = projectList.stream()
         .map(s -> s.getLength().multiply(new BigDecimal(s.getQuantity() - s.getSchedulingQuantity())))
         .reduce(BigDecimal::add)
         .get();
      map.put("projectLength", projectLength.divide(BigDecimal.valueOf(1000L)));
      if (CollectionUtils.isNotEmpty(planIds)) {
         List<TechEnclosure> planList = projectList.stream().filter(s -> planIds.contains(s.getEnclosurePlanId())).collect(Collectors.toList());
         BigDecimal planLength = planList.stream()
            .map(s -> s.getLength().multiply(new BigDecimal(s.getQuantity() - s.getSchedulingQuantity())))
            .reduce(BigDecimal::add)
            .get();
         map.put("planLength", planLength.divide(BigDecimal.valueOf(1000L)));
      } else {
         map.put("planLength", BigDecimal.ZERO);
      }

      return map;
   }

   @Override
   public Map getTotalLengthV2(Long projectId, List<Long> areaIds, Integer dictionaryId) {
      HashMap<String, BigDecimal> map = new HashMap<>();
      List<TechEnclosure> projectList = this.enclosureService
         .list(
            Wrappers.lambdaQuery(TechEnclosure.class)
               .eq(TechEnclosure::getProjectId, projectId)
               .eq(TechEnclosure::getBoolStatusEnum, 1)
               .eq(TechEnclosure::getDictionaryId, dictionaryId)
         );
      BigDecimal projectLength = projectList.stream()
         .map(s -> s.getLength().multiply(new BigDecimal(s.getQuantity() - s.getSchedulingQuantity())))
         .reduce(BigDecimal::add)
         .get();
      map.put("projectLength", projectLength.divide(BigDecimal.valueOf(1000L)));
      if (CollectionUtils.isNotEmpty(areaIds)) {
         List<TechEnclosure> planList = projectList.stream().filter(s -> areaIds.contains(s.getAreaId())).collect(Collectors.toList());
         BigDecimal planLength = planList.stream()
            .map(s -> s.getLength().multiply(new BigDecimal(s.getQuantity() - s.getSchedulingQuantity())))
            .reduce(BigDecimal::add)
            .get();
         map.put("planLength", planLength.divide(BigDecimal.valueOf(1000L)));
      } else {
         map.put("planLength", BigDecimal.ZERO);
      }

      return map;
   }
}
