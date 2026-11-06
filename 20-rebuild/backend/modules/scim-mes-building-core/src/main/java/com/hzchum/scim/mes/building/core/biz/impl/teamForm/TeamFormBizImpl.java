package com.hzchum.scim.mes.building.core.biz.impl.teamForm;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.mes.building.core.api.biz.teamForm.TeamFormBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProcessSummaryDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormArtifactAssembleProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormProcessDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.teamForm.TeamFormDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormArtifactAssembleProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.teamForm.TeamFormEnclosureDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.teamForm.TeamFormDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.biz.impl.utils.MesBuildingUtilsBizImpl;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamFormBizImpl implements TeamFormBiz {
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingUtilsBizImpl utilsBiz;

   @Override
   public List<TeamFormDTO> teamFormProcessSummary(TeamFormDTOParam dtoParam) {
      List<TeamFormDTO> dtoList = this.taskService
         .teamFormProcessSummary(BeanUtil.copy(dtoParam, TeamFormDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, TeamFormDTO.class))
         .collect(Collectors.toList());
      if (dtoList.size() == 0) {
         return new ArrayList<>();
      }

      List<TeamFormProcessDetailsDO> processDetailsList = this.taskService
         .teamFormSummary(
            dtoParam.getProjectId(),
            dtoParam.getProjectIds(),
            dtoList.stream().map(e -> e.getProductionLine().getId()).collect(Collectors.toList()),
            dtoList.stream().map(TeamFormDTO::getProductType).collect(Collectors.toList()),
            dtoParam.getStartDate(),
            dtoParam.getEndDate()
         );
      dtoList.forEach(
         e -> e.setProcessSummaryList(
            processDetailsList.stream()
               .filter(temp -> temp.getProductionLineId().equals(e.getProductionLine().getId()) && temp.getProductType().equals(e.getProductType()))
               .collect(Collectors.toList())
         )
      );
      return dtoList;
   }

   @Override
   public List<TeamFormDetailsDTO> teamFormProcessDetails(TeamFormDTOParam dtoParam) {
      if (!dtoParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
         && !dtoParam.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())
         && !dtoParam.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      } else {
         return this.taskService
            .teamFormProcessDetails(BeanUtil.copy(dtoParam, TeamFormDOParam.class))
            .stream()
            .map(e -> BeanUtil.copy(e, TeamFormDetailsDTO.class))
            .collect(Collectors.toList());
      }
   }

   @Override
   public PageVO<TeamFormDetailsDTO> teamFormProcessDetailsPage(TeamFormDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.teamFormProcessDetails(dtoParam));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> teamFormProcessDetailsPrint(TeamFormDTOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      MesBuildingProductionLine productionLine = this.productionLineService.getById(param.getProductionLineId());
      MesBuildingWorkshop workshop = this.workshopService.getById(productionLine.getWorkshopId());
      header.put(
         "name",
         workshop.getName()
            + ">"
            + (param.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()) ? "一次工序>" : "二次工序")
            + productionLine.getName()
            + (param.getProcessId() == null ? "" : ">" + this.processService.getById(param.getProcessId()).getName())
      );
      String date = param.getStartDate() != null && param.getEndDate() != null
         ? DateTimeUtil.getLocalDateStr(param.getStartDate()) + "-" + DateTimeUtil.getLocalDateStr(param.getEndDate())
         : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      if (!param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
         && !param.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())
         && !param.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      }

      printVO.setTable(
         this.taskService
            .teamFormProcessDetails(BeanUtil.copy(param, TeamFormDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<TeamFormEnclosureDTO> teamFormEnclosure(TeamFormDTOParam dtoParam) {
      return this.taskService
         .teamFormEnclosure(BeanUtil.copy(dtoParam, TeamFormDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
         .stream()
         .map(e -> BeanUtil.copy(e, TeamFormEnclosureDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<TeamFormEnclosureDetailsDTO> teamFormEnclosureDetails(TeamFormDTOParam dtoParam) {
      return this.taskService
         .teamFormEnclosureDetails(BeanUtil.copy(dtoParam, TeamFormDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
         .stream()
         .map(e -> BeanUtil.copy(e, TeamFormEnclosureDetailsDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> teamFormEnclosureDetailsPrint(TeamFormDTOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(
         this.taskService
            .teamFormEnclosureDetails(BeanUtil.copy(param, TeamFormDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<TeamFormArtifactAssembleProcessDTO> teamFormProcess(TeamFormDTOParam copy) {
      List<TeamFormArtifactAssembleProcessDTO> dtoList = this.taskService
         .teamFormProcess(BeanUtil.copy(copy, TeamFormDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, TeamFormArtifactAssembleProcessDTO.class))
         .collect(Collectors.toList());
      dtoList.forEach(e -> e.setProcessSummaryDetailsDOList(this.getProcessSummary(e.getId(), e.getProductProcessId(), copy.getStartDate(), copy.getEndDate())));
      return dtoList;
   }

   @Override
   public PageVO<TeamFormArtifactAssembleProcessDTO> teamFormProcessPage(TeamFormDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.teamFormProcess(dtoParam));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> teamFormProcessPrint(TeamFormDTOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      MesBuildingProductionLine productionLine = this.productionLineService.getById(param.getProductionLineId());
      MesBuildingWorkshop workshop = this.workshopService.getById(productionLine.getWorkshopId());
      header.put(
         "name",
         workshop.getName()
            + ">"
            + (param.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()) ? "一次工序>" : "二次工序")
            + productionLine.getName()
            + (param.getProcessId() == null ? "" : ">" + this.processService.getById(param.getProcessId()).getName())
      );
      String date = param.getStartDate() != null && param.getEndDate() != null
         ? DateTimeUtil.getLocalDateStr(param.getStartDate()) + "-" + DateTimeUtil.getLocalDateStr(param.getEndDate())
         : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      List<TeamFormArtifactAssembleProcessDO> dtoList = this.taskService
         .teamFormProcess(BeanUtil.copy(param, TeamFormDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()));
      printVO.setTable(dtoList.stream().map(e -> {
         Map<String, Object> result = BeanUtil.beanToMap(e);
         result.put("processSummaryDetailsDOList", this.getProcessSummary(e.getId(), e.getProductProcessId(), param.getStartDate(), param.getEndDate()));
         result.put("productType", param.getProductType());
         return result;
      }).collect(Collectors.toList()));
      return printVO;
   }

   private List<ProcessSummaryDetailsDO> getProcessSummary(Long taskId, Long productProcessId, LocalDateTime startDate, LocalDateTime endDate) {
      if (productProcessId == 0L) {
         List<ProcessSummaryDetailsDO> list = new ArrayList<>();
         MesBuildingTask task = this.taskService.getById(taskId);
         this.utilsBiz
            .getProcessByProduct(task.getProductId(), task.getTaskTypeEnum(), true)
            .forEach(
               e -> list.add(
                  ProcessSummaryDetailsDO.builder()
                     .processId(e.getId())
                     .name(e.getName())
                     .completeQuantity(
                        this.taskService.processSummary(taskId, e.getId(), startDate, endDate) != null
                           ? this.taskService.processSummary(taskId, e.getId(), startDate, endDate).getCompleteQuantity()
                           : 0
                     )
                     .build()
               )
            );
         return list;
      } else {
         List<ProcessSummaryDetailsDO> list = this.productProcessLinkService
            .list(
               (Wrapper<MesBuildingProductProcessLink>)(Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                     .eq(MesBuildingProductProcessLink::getProductProcessId, productProcessId))
                  .orderByAsc(MesBuildingProductProcessLink::getSequence)
            )
            .stream()
            .map(e -> {
               MesBuildingProcess process = this.processService.getById(e.getProcessId());
               ProcessSummaryDetailsDO detailsDO = ProcessSummaryDetailsDO.builder().build();
               detailsDO.setProcessId(process.getId());
               detailsDO.setName(process.getName());
               return detailsDO;
            })
            .collect(Collectors.toList());
         list.forEach(e -> {
            if (this.taskService.processSummary(taskId, e.getProcessId(), startDate, endDate) != null) {
               e.setCompleteQuantity(this.taskService.processSummary(taskId, e.getProcessId(), startDate, endDate).getCompleteQuantity());
            } else {
               e.setCompleteQuantity(0);
            }
         });
         return list;
      }
   }
}
