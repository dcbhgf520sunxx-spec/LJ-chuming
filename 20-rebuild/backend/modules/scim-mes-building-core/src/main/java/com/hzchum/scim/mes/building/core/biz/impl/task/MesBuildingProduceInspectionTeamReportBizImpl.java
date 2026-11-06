package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProduceInspectionTeamReportBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductLineDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessArtifactNumberDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTeamReportDetailsDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProduceInspectionTeamReportBizImpl implements MesBuildingProduceInspectionTeamReportBiz {
   @Resource
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Resource
   private UserService userService;
   @Resource
   private MesBuildingTaskOrderService taskOrderService;
   @Resource
   private MesBuildingProcessService processService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private MesBuildingProductionLineService productionLineService;

   @Override
   public AppTeamReportDetailsDTO inspectionReportDetailList(Long id) {
      List<MesBuildingProduceInspectionTeamReport> inspectionTeamReportList = this.inspectionTeamReportService
         .list(Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReport.class).eq(MesBuildingProduceInspectionTeamReport::getInspectReportNumber, id));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(inspectionTeamReportList), "操作失败：传入id不正确");
      MesBuildingProduceInspectionTeamReport inspectionTeamReport = inspectionTeamReportList.get(0);
      Long taskId = inspectionTeamReport.getTaskId();
      MesBuildingTask task = this.taskService.getById(taskId);
      AppTeamReportDetailsDTO dto = AppTeamReportDetailsDTO.builder()
         .taskTypeEnum(inspectionTeamReport.getTaskTypeEnum())
         .quantity(inspectionTeamReport.getInspectionQuantity())
         .productId(inspectionTeamReport.getProductId())
         .taskId(taskId)
         .build();
      Long taskProcessId = inspectionTeamReport.getTaskProcessId();
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(taskProcessId);
      ContractProject project = this.contractProjectService.getById(taskProcess.getProjectId());
      ProjectDetailDO projectDetailDO = new ProjectDetailDO();
      BeanUtils.copyProperties(project, projectDetailDO);
      dto.setProject(projectDetailDO);
      PlanMonomer monomer = this.monomerService.getById(taskProcess.getMonomerId());
      MonomerDetailDO monomerDetailDO = new MonomerDetailDO();
      BeanUtils.copyProperties(monomer, monomerDetailDO);
      dto.setMonomer(monomerDetailDO);
      PlanArea area = this.areaService.getById(taskProcess.getAreaId());
      AreaDetailDO areaDetailDO = new AreaDetailDO();
      BeanUtils.copyProperties(area, areaDetailDO);
      dto.setArea(areaDetailDO);
      MesBuildingTeamUserLink leader = this.teamUserLinkService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .eq(MesBuildingTeamUserLink::getTeamId, inspectionTeamReport.getTeamId())
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, true)
         );
      User user = this.userService.getById(leader.getUserId());
      dto.setTeam(IdAndNameDO.builder().id(inspectionTeamReport.getTeamId()).name(user.getName()).build());
      dto.setInspectionUserNme(
         this.userService.getById(inspectionTeamReport.getUserId()) == null ? "超管" : this.userService.getById(inspectionTeamReport.getUserId()).getName()
      );
      dto.setReportUser(user.getName());
      Long oderderId = taskProcess.getTaskOrderId();
      dto.setOrderNumber(this.taskOrderService.getById(oderderId).getOrderNumber());
      MesBuildingProcess process = this.processService.getById(inspectionTeamReport.getProcessId());
      dto.setProcess(IdAndNameDO.builder().id(process.getId()).name(process.getName()).build());
      dto.setReportType(process.getReportType());
      if (inspectionTeamReport.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact product = this.artifactService.getById(inspectionTeamReport.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
         dto.setCodingType(product.getCodingType());
         if (product.getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
            AppTaskProcessArtifactNumberDTO build = AppTaskProcessArtifactNumberDTO.builder()
               .number(inspectionTeamReport.getNumber())
               .serialNumber(product.getSerialNumber())
               .build();
            List<AppTaskProcessArtifactNumberDTO> arrayList = new ArrayList<>();
            arrayList.add(build);
            dto.setArtifactNumberList(arrayList);
         }
      } else if (inspectionTeamReport.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
         TechAssemble product = this.assembleService.getById(inspectionTeamReport.getProductId());
         dto.setSerialNumber(product.getSerialNumber());
         dto.setSpecification(product.getSpecification());
         dto.setLength(product.getLength());
         dto.setMaterial(product.getMaterial());
         dto.setCodingType(task.getBoolOneCode() ? 1 : 2);
         if (dto.getCodingType().equals(CodingTypeEnum.SINGLE.getType())) {
            AppTaskProcessArtifactNumberDTO build = AppTaskProcessArtifactNumberDTO.builder()
               .number(inspectionTeamReport.getNumber())
               .serialNumber(product.getSerialNumber())
               .build();
            List<AppTaskProcessArtifactNumberDTO> arrayList = new ArrayList<>();
            arrayList.add(build);
            dto.setArtifactNumberList(arrayList);
         }
      }

      ProductLineDetailDTO lineDetailDTO = this.productionLineService.getTreeByLineId(inspectionTeamReport.getProductionLineId());
      IdAndNameDO line = IdAndNameDO.builder().id(lineDetailDTO.getProductionLineId()).name(lineDetailDTO.getProductionLineName()).build();
      IdAndNameDO workShop = IdAndNameDO.builder().id(lineDetailDTO.getWorkshopId()).name(lineDetailDTO.getWorkshopName()).build();
      IdAndNameDO factory = IdAndNameDO.builder().id(lineDetailDTO.getFactoryId()).name(lineDetailDTO.getFactoryName()).build();
      dto.setProductionLine(line);
      dto.setGroups(line);
      dto.setWorkshop(workShop);
      dto.setFactory(factory);
      return dto;
   }
}
