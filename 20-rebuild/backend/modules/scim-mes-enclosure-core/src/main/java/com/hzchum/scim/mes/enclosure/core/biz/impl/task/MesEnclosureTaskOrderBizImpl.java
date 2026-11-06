package com.hzchum.scim.mes.enclosure.core.biz.impl.task;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskOrderBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeamUserLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureTaskOrderDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.OrderTaskAndCompleteLengthDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.TechEnclosureDetailDTO;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureTeamUserLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskOrderService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.mes.enclosure.core.mapper.task.MesEnclosureTaskOrderMapper;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureFreezeOrNotDTO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesEnclosureTaskOrderBizImpl
   extends IBizImpl<MesEnclosureTaskOrderService, MesEnclosureTaskOrderMapper, MesEnclosureTaskOrder>
   implements MesEnclosureTaskOrderBiz {
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private MesEnclosureTaskService taskService;
   @Resource
   private TechEnclosureService techEnclosureService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private MesBuildingFactoryService factoryService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private MesEnclosureProductionLineService productionLineService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private MesEnclosureTeamUserLinkService teamUserLinkService;
   @Value("${chum.config.url}")
   private String ip;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private UserService userService;

   @Override
   public List<ProjectInfo> getProjectWithOrder(Integer year, String name, Integer projectType, Integer lumpSumSystemType) {
      List<ProjectInfo> dtos = new ArrayList<>();
      List<MesEnclosureTaskOrder> orders = this.baseService.list();
      if (CollectionUtils.isEmpty(orders)) {
         return new ArrayList<>();
      }

      List<MesEnclosureTaskOrder> sorted = new ArrayList<>();
      Map<Long, List<MesEnclosureTaskOrder>> collect = orders.stream().collect(Collectors.groupingBy(MesEnclosureTaskOrder::getProjectId));

      for (Long aLong : collect.keySet()) {
         List<MesEnclosureTaskOrder> mesEnclosureTaskOrders = collect.get(aLong);
         List<LocalDateTime> times = mesEnclosureTaskOrders.stream().map(MesEnclosureTaskOrder::getAskCompleteTime).collect(Collectors.toList());
         LocalDateTime localDateTime = times.stream().max(LocalDateTime::compareTo).get();
         List<MesEnclosureTaskOrder> collect1 = mesEnclosureTaskOrders.stream()
            .filter(s -> s.getAskCompleteTime() == localDateTime)
            .collect(Collectors.toList());
         sorted.add(collect1.get(0));
      }

      sorted = sorted.stream().sorted(Comparator.<MesEnclosureTaskOrder, java.time.LocalDateTime>comparing(BaseEntity::getCreateTime).reversed()).collect(Collectors.toList());
      List<Long> projectIds = orders.stream().map(MesEnclosureTaskOrder::getProjectId).distinct().collect(Collectors.toList());
      List<ContractProject> projects = this.contractProjectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getId, projectIds)
               .and(
                  name != null,
                  i -> {
                     LambdaQueryWrapper var10000 = i.like(ContractProject::getName, name)
                        .or()
                        .like(ContractProject::getShortName, name)
                        .or()
                        .like(ContractProject::getSerialNumber, name);
                  }
               )
               .apply(year != null, "year(create_time) = '" + year + "'")
         );
      List<Long> userProjectIds = this.contractProjectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<ContractProject> projectList = projects.stream().filter(s -> userProjectIds.contains(s.getId())).collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectList)) {
         return new ArrayList<>();
      }

      Map<Long, ContractProject> projectMap = projectList.stream().collect(Collectors.toMap(ContractProject::getId, Function.identity()));

      for (MesEnclosureTaskOrder order : sorted) {
         ContractProject project = projectMap.get(order.getProjectId());
         if (project != null) {
            ProjectInfo copy = BeanUtil.copy(project, ProjectInfo.class);
            dtos.add(copy);
         }
      }

      return dtos;
   }

   @Override
   public PageVO<MesEnclosureTaskOrderDTO> getOrders(String orderNumber, Long projectId, String userName, Integer pageNumber, Integer pageSize) {
      List<MesEnclosureTeamUserLink> list = this.teamUserLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class).eq(MesEnclosureTeamUserLink::getBoolLeaderEnum, 1));
      Map<Long, String> teamLeaderMap = list.stream().collect(Collectors.toMap(MesEnclosureTeamUserLink::getTeamId, MesEnclosureTeamUserLink::getUserName));
      PageHelper.startPage(pageNumber, pageSize);
      List<MesEnclosureTaskOrderDTO> dtos = this.baseMapper.getOrders(orderNumber, projectId, userName);
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isEmpty(dtos)) {
         return new PageVO<>();
      }

      List<Long> orderIds = dtos.stream().map(MesEnclosureTaskOrderDTO::getId).collect(Collectors.toList());
      List<OrderTaskAndCompleteLengthDTO> dtoList = this.baseMapper.getTaskAndCompLength(orderIds);
      Map<Long, OrderTaskAndCompleteLengthDTO> ordMap = dtoList.stream().collect(Collectors.toMap(OrderTaskAndCompleteLengthDTO::getId, Function.identity()));
      List<EnclosureFreezeOrNotDTO> statusByOrderList = this.techEnclosureService
         .findFreezeStatusByOrder(dtos.stream().map(MesEnclosureTaskOrderDTO::getId).collect(Collectors.toList()));
      Map<Long, Integer> freezeOrNotDTOMap = statusByOrderList.stream()
         .collect(
            Collectors.toMap(
               EnclosureFreezeOrNotDTO::getTaskOrderId, dtox -> dtox.getBoolStatusEnum() ? 1 : 0, (oldValue, newValue) -> newValue == 0 ? newValue : oldValue
            )
         );

      for (MesEnclosureTaskOrderDTO dto : dtos) {
         OrderTaskAndCompleteLengthDTO length = ordMap.get(dto.getId());
         dto.setBooleanProduce(dto.getInProductionTime() != null);
         dto.setLeaderName(teamLeaderMap.get(dto.getTeamId()));
         dto.setTotalLength(length.getTaskLength());
         dto.setCompleteLength(length.getCompeteLength());
         Integer freezeOrNot = freezeOrNotDTOMap.get(dto.getId());
         if (freezeOrNot.equals(0)) {
            dto.setBooleanProduce(true);
         }
      }

      return new PageVO<>(dtos);
   }

   @Override
   public PageVO<TechEnclosureDetailDTO> orderDetail(Long id) {
      List<MesEnclosureTask> enclosureTasks = this.taskService.list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
      if (CollectionUtils.isEmpty(enclosureTasks)) {
         return new PageVO<>();
      }

      List<TechEnclosure> enclosureList = this.techEnclosureService
         .listByIds(enclosureTasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList()));
      Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, EnclosurePlan> planMap = this.enclosurePlanService
         .listByIds(enclosureList.stream().map(TechEnclosure::getEnclosurePlanId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(EnclosurePlan::getId, Function.identity()));
      Map<Long, PlanArea> areaMap = this.areaService
         .listByIds(enclosureList.stream().map(TechEnclosure::getAreaId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.contractProjectService
         .listByIds(enclosureList.stream().map(TechEnclosure::getProjectId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      PageVO pageVO = new PageVO<>(enclosureTasks);
      List<TechEnclosureDetailDTO> dtos = new ArrayList<>();
      Map<Long, String> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).in(User::getId, enclosureList.stream().map(TechEnclosure::getUserId).collect(Collectors.toList())))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));
      List<Long> attachmentIds = enclosureList.stream().map(TechEnclosure::getAttachmentId).collect(Collectors.toList());
      Map<Long, String> attachmentMap = new HashMap<>();
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(attachmentIds)) {
         attachmentMap = this.attachmentService
            .listByIds(attachmentIds)
            .stream()
            .collect(Collectors.toMap(Attachment::getId, Attachment::getRelativePath, (s1, s2) -> s1));
      }

      String filePath = this.ip + "files/";
      Map<Long, MesEnclosureTask> enclosureTaskMap = this.taskService
         .findProductReportCountByOrderId(id)
         .stream()
         .collect(Collectors.toMap(MesEnclosureTask::getId, Function.identity()));

      for (Object o : pageVO.getContent()) {
         MesEnclosureTask task = (MesEnclosureTask)o;
         TechEnclosure techEnclosure = enclosureMap.get(task.getProductId());
         Preconditions.checkArgument(techEnclosure != null, "查询失败,请刷新后重试");
         TechEnclosureDetailDTO dto = BeanUtil.copy(techEnclosure, TechEnclosureDetailDTO.class);
         dto.setId(task.getId());
         dto.setProductId(task.getProductId());
         dto.setAreaName(areaMap.get(task.getAreaId()).getName());
         dto.setQuantity(task.getTaskQuantity());
         dto.setTotalLength(dto.getLength().multiply(new BigDecimal(task.getTaskQuantity())));
         dto.setAskCompleteTime(task.getAskCompleteTime());
         dto.setUserName(userMap.get(techEnclosure.getUserId()));
         dto.setWidth(techEnclosure.getWidth());
         dto.setUnfoldedWidth(techEnclosure.getUnfoldedWidth());
         dto.setRelativePath(attachmentMap.get(techEnclosure.getAttachmentId()) == null ? null : filePath + attachmentMap.get(techEnclosure.getAttachmentId()));
         if (enclosureTaskMap.get(task.getId()) != null) {
            dto.setBooleReport(1);
         } else {
            dto.setBooleReport(0);
         }

         dtos.add(dto);
      }

      pageVO.setContent(dtos);
      return pageVO;
   }

   @Override
   public PageVO<TechEnclosureDetailDTO> orderDetail(Long id, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<MesEnclosureTask> enclosureTasks = this.taskService.list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
      if (CollectionUtils.isEmpty(enclosureTasks)) {
         return new PageVO<>();
      }

      List<TechEnclosure> enclosureList = this.techEnclosureService
         .listByIds(enclosureTasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList()));
      Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, EnclosurePlan> planMap = this.enclosurePlanService
         .listByIds(enclosureList.stream().map(TechEnclosure::getEnclosurePlanId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(EnclosurePlan::getId, Function.identity()));
      Map<Long, ContractProject> projectMap = this.contractProjectService
         .listByIds(enclosureList.stream().map(TechEnclosure::getProjectId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      PageVO pageVO = new PageVO<>(enclosureTasks);
      List<TechEnclosureDetailDTO> dtos = new ArrayList<>();
      Map<Long, String> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).in(User::getId, enclosureList.stream().map(TechEnclosure::getUserId).collect(Collectors.toList())))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));

      for (Object o : pageVO.getContent()) {
         MesEnclosureTask task = (MesEnclosureTask)o;
         TechEnclosure techEnclosure = enclosureMap.get(task.getProductId());
         Preconditions.checkArgument(techEnclosure != null, "查询失败,请刷新后重试");
         TechEnclosureDetailDTO dto = BeanUtil.copy(techEnclosure, TechEnclosureDetailDTO.class);
         dto.setId(task.getProductId());
         dto.setPlanName(planMap.get(task.getPlanId()).getName());
         dto.setQuantity(task.getTaskQuantity());
         dto.setTotalLength(dto.getLength().multiply(new BigDecimal(task.getTaskQuantity())));
         dto.setAskCompleteTime(task.getAskCompleteTime());
         dto.setUserName(userMap.get(techEnclosure.getUserId()));
         dtos.add(dto);
      }

      pageVO.setContent(dtos);
      return pageVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> orderDetailPrint(Long id) {
      MesEnclosureTaskOrder order = this.baseService.getById(id);
      Preconditions.checkArgument(order != null, "工单不存在请刷新后重试");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ContractProject project = this.contractProjectService.getById(order.getProjectId());
      ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
      header.put("orderNumber", order.getOrderNumber());
      header.put("projectInfo", projectInfo);
      header.put("factoryId", order.getFactoryId());
      header.put("workshopId", order.getWorkshopId());
      header.put("lineId", order.getProductionLineId());
      header.put("teamId", order.getTeamId());
      MesBuildingFactory factory = this.factoryService.getFactoryById(order.getFactoryId());
      header.put("factoryName", factory.getName());
      MesBuildingWorkshop workshop = this.workshopService.getWorkshopById(order.getWorkshopId());
      header.put("workshopName", workshop.getName());
      MesEnclosureProductionLine line = this.productionLineService.getLineById(order.getProductionLineId());
      String userName = this.teamUserLinkService
         .getOne(
            Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class)
               .eq(MesEnclosureTeamUserLink::getTeamId, order.getTeamId())
               .eq(MesEnclosureTeamUserLink::getBoolLeaderEnum, 1)
         )
         .getUserName();
      header.put("lineName", line.getName() + " / " + userName);
      printVO.setHeader(header);
      List<MesEnclosureTask> enclosureTasks = this.taskService.list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
      List<TechEnclosureDetailDTO> dtos = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(enclosureTasks)) {
         List<TechEnclosure> enclosureList = this.techEnclosureService
            .listByIds(enclosureTasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList()));
         Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
         Map<Long, EnclosurePlan> planMap = this.enclosurePlanService
            .listByIds(enclosureList.stream().map(TechEnclosure::getEnclosurePlanId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(EnclosurePlan::getId, Function.identity()));
         Map<Long, ContractProject> projectMap = this.contractProjectService
            .listByIds(enclosureList.stream().map(TechEnclosure::getProjectId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         Map<Long, String> userMap = this.userService
            .list(Wrappers.lambdaQuery(User.class).in(User::getId, enclosureList.stream().map(TechEnclosure::getUserId).collect(Collectors.toList())))
            .stream()
            .collect(Collectors.toMap(User::getId, User::getName));

         for (MesEnclosureTask task : enclosureTasks) {
            TechEnclosure techEnclosure = enclosureMap.get(task.getProductId());
            Preconditions.checkArgument(techEnclosure != null, "查询失败,请刷新后重试");
            TechEnclosureDetailDTO dto = BeanUtil.copy(techEnclosure, TechEnclosureDetailDTO.class);
            dto.setId(task.getProductId());
            dto.setPlanName(planMap.get(task.getPlanId()).getName());
            dto.setQuantity(task.getTaskQuantity());
            dto.setTotalLength(dto.getLength().multiply(new BigDecimal(task.getTaskQuantity())));
            dto.setAskCompleteTime(task.getAskCompleteTime());
            dto.setUserName(userMap.get(techEnclosure.getUserId()));
            dtos.add(dto);
         }
      }

      printVO.setTable(dtos.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public Boolean orderDetailDownload(Long id, HttpServletResponse response) {
      Map<String, Object> result = new HashMap<>();
      MesEnclosureTaskOrder order = this.baseService.getById(id);
      Preconditions.checkArgument(order != null, "工单不存在请刷新后重试");
      ContractProject project = this.contractProjectService.getById(order.getProjectId());
      MesBuildingFactory factory = this.factoryService.getById(order.getFactoryId());
      MesBuildingWorkshop workshop = this.workshopService.getById(order.getWorkshopId());
      MesEnclosureProductionLine line = this.productionLineService.getById(order.getProductionLineId());
      List<MesEnclosureTask> enclosureTasks = this.taskService.list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
      List<Map> dtos = new ArrayList<>();
      List<TechEnclosure> enclosureList = this.techEnclosureService
         .listByIds(enclosureTasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList()));
      Map<Long, TechEnclosure> enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity(), (s1, s2) -> s1));
      Map<Long, PlanArea> areaMap = this.areaService
         .listByIds(enclosureList.stream().map(TechEnclosure::getAreaId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(PlanArea::getId, Function.identity()));
      Map<Long, String> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).in(User::getId, enclosureList.stream().map(TechEnclosure::getUserId).collect(Collectors.toList())))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));
      List<Long> attachmentIds = enclosureList.stream().map(TechEnclosure::getAttachmentId).collect(Collectors.toList());
      new HashMap();
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(attachmentIds)) {
         Map<Long, String> attachmentMap = this.attachmentService
            .listByIds(attachmentIds)
            .stream()
            .collect(Collectors.toMap(Attachment::getId, Attachment::getRelativePath, (s1, s2) -> s1));
      }

      BigDecimal allLength = BigDecimal.ZERO;
      BigDecimal allWeight = BigDecimal.ZERO;
      Integer allQuantity = 0;

      for (MesEnclosureTask task : enclosureTasks) {
         TechEnclosure techEnclosure = enclosureMap.get(task.getProductId());
         Preconditions.checkArgument(techEnclosure != null, "查询失败,请刷新后重试");
         TechEnclosureDetailDTO dto = BeanUtil.copy(techEnclosure, TechEnclosureDetailDTO.class);
         dto.setId(task.getProductId());
         dto.setAreaName(areaMap.get(task.getAreaId()).getName());
         dto.setQuantity(task.getTaskQuantity());
         dto.setTotalLength(dto.getLength().multiply(new BigDecimal(task.getTaskQuantity())));
         dto.setAskCompleteTime(task.getAskCompleteTime());
         dto.setUserName(userMap.get(techEnclosure.getUserId()));
         dto.setAskCompleteTimeFormat(dto.getAskCompleteTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         dto.setTotalWeight(dto.getWeight().multiply(new BigDecimal(task.getTaskQuantity())).setScale(2, RoundingMode.HALF_UP));
         allQuantity = allQuantity + task.getTaskQuantity();
         Map<String, Object> map = BeanUtil.beanToMap(dto);
         map.put("totalLength", new BigDecimal(map.get("totalLength") + "").divide(new BigDecimal(1000), 3, RoundingMode.HALF_UP));
         allLength = allLength.add(new BigDecimal(map.get("totalLength") + "").setScale(3, RoundingMode.HALF_UP));
         allWeight = allWeight.add(dto.getTotalWeight().setScale(2, RoundingMode.HALF_UP));
         dtos.add(map);
      }

      Map<String, Object> allmap = new HashMap<>();
      allmap.put("totalLength", allLength.setScale(3, RoundingMode.HALF_UP));
      allmap.put("totalWeight", allWeight.setScale(2, RoundingMode.HALF_UP));
      allmap.put("quantity", allQuantity);
      dtos.add(allmap);
      result.put("serialNumber", "工单编号:" + order.getOrderNumber());
      result.put("projectShortName", "项目名:" + project.getShortName());
      result.put("createTime", "下发时间:" + order.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      result.put("factoryName", "工厂:" + factory.getName());
      result.put("whorkshopName", "车间:" + workshop.getName());
      result.put("productLineName", "产线:" + line.getName());
      result.put("enclosureList", dtos);
      String tempFileName = "EnclosureTaskOrderDetail1";
      String resourcePath = "files/EnclosureTaskOrderDetail1.xlsx";
      String exportFileName = "工单详情.xlsx";
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = null;
      File file = null;

      try {
         inputStream = resource.getInputStream();
         file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, result);
         PoiUtils.downLoadExcel(exportFileName, response, workbook);
      } catch (IOException e) {
         Preconditions.checkArgument(false, "文件下载失败");
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePrint(Long id) {
      MesEnclosureTaskOrder order = this.baseService.getById(id);
      Preconditions.checkArgument(order != null, "工单不存在请刷新后重试");
      MesEnclosureTaskOrder taskOrder = order.setPrintQuantity(order.getPrintQuantity() + 1);
      return this.baseService.updateById(taskOrder);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteOrder(List<Long> ids) {
      for (Long id : ids) {
         MesEnclosureTaskOrder order = this.baseService.getById(id);
         Preconditions.checkArgument(order != null, "工单不存在请刷新后重试");
         Preconditions.checkArgument(order.getInProductionTime() == null, "工单已进入生产不可删除,请刷新后重试");
         this.baseService.removeById(id);
         List<MesEnclosureTask> tasks = this.taskService.list(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
         this.taskService.remove(Wrappers.lambdaQuery(MesEnclosureTask.class).eq(MesEnclosureTask::getTaskOrderId, id));
         List<Long> productIds = tasks.stream().map(MesEnclosureTask::getProductId).collect(Collectors.toList());
         Map<Long, Integer> taskMap = tasks.stream().collect(Collectors.toMap(MesEnclosureTask::getProductId, MesEnclosureTask::getTaskQuantity));
         List<TechEnclosure> enclosureList = this.techEnclosureService.listByIds(productIds);
         Preconditions.checkArgument(productIds.size() == enclosureList.size(), "工单数据,与清单数据不符,请联系管理员!!");

         for (TechEnclosure techEnclosure : enclosureList) {
            techEnclosure.setSchedulingQuantity(techEnclosure.getSchedulingQuantity() - taskMap.get(techEnclosure.getId()));
            Preconditions.checkArgument(techEnclosure.getSchedulingQuantity() >= 0, "删除失败,请联系管理员");
         }

         this.techEnclosureService.updateBatchById(enclosureList);
      }

      return true;
   }

   private List<Map<String, ImageEntity>> getImageRowList(List<String> paths, int size) {
      if (paths.size() == 0) {
         return new ArrayList<>();
      }

      int row = paths.size() / size + (paths.size() % size > 0 ? 1 : 0);
      List<Map<String, ImageEntity>> rowList = new ArrayList<>();

      for (int i = 1; i <= row; i++) {
         Map<String, ImageEntity> imageEntityMap = new HashMap<>();

         for (int l = (i - 1) * size; l < i * size && l < paths.size(); l++) {
            ImageEntity image = new ImageEntity();
            image.setWidth(200);
            image.setHeight(200);
            image.setUrl(this.configProperties.getFilePath() + File.separator + paths.get(l));
            image.setType(ImageEntity.URL);
            imageEntityMap.put("a" + l % size, image);
         }

         rowList.add(imageEntityMap);
      }

      return rowList;
   }

   public void changeFile(String into, String out) {
      try {
         BufferedImage bufferedImage = ImageIO.read(new File(into));
         BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 1);
         newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
         ImageIO.write(newBufferedImage, "png", new File(out));
         System.out.println("Done");
      } catch (IOException e) {
         Preconditions.checkArgument(false, "文件下载失败");
      }
   }
}
