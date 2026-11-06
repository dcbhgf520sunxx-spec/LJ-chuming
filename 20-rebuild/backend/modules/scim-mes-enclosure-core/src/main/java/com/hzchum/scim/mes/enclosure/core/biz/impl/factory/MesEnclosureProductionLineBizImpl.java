package com.hzchum.scim.mes.enclosure.core.biz.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureInspectionTeamBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureLineInspectionTeamLinkBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureLineTeamLinkBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureProductionLineBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureTeamBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.process.MesEnclosureProcessBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.util.MesEnclosureUtilsBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineSumDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineTypeLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeamUserLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureLineInspectionTeamLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureLineTeamLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeamUserLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureInspectionTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureInspectionTeamUserLinkDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureProductionLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureTeamUserLinkDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.ProductionLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamsForLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process.MesEnclosureProcessDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.util.IdAndNameDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureProductionLineDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureInspectionTeamUserLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineTypeLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureTeamUserLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureProductionLineMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesEnclosureProductionLineBizImpl
   extends IBizImpl<MesEnclosureProductionLineService, MesEnclosureProductionLineMapper, MesEnclosureProductionLine>
   implements MesEnclosureProductionLineBiz {
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingFactoryService factoryService;
   @Autowired
   private MesEnclosureUtilsBiz utilsBiz;
   @Autowired
   private MesEnclosureTaskService taskService;
   @Autowired
   private SysAssembleConfigService sysAssembleConfigService;
   @Autowired
   private SysStructureClassificationService sysStructureClassificationService;
   @Autowired
   private SysSteelClassificationService sysSteelClassificationService;
   @Autowired
   private MesEnclosureLineTeamLinkBiz teamLinkBiz;
   @Autowired
   private MesEnclosureLineInspectionTeamLinkBiz inspectionTeamLinkBiz;
   @Autowired
   private MesEnclosureTeamBiz teamBiz;
   @Autowired
   private MesEnclosureInspectionTeamBiz inspectionTeamBiz;
   @Autowired
   private MesEnclosureProcessBiz processBiz;
   @Autowired
   private MesEnclosureTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesEnclosureInspectionTeamUserLinkService inspectionTeamUserLinkService;
   @Autowired
   private MesEnclosureProductionLineTypeLinkService productionLineTypeLinkService;

   @Override
   public Boolean productionLineUpdateState(MesEnclosureProductionLineDTOParam dtoParam) {
      Preconditions.checkArgument(dtoParam.getId() != null & dtoParam.getBoolEnabledEnum() != null, "传入数据有误");
      MesEnclosureProductionLine productionLine = this.baseService.getById(dtoParam.getId());
      productionLine.setBoolEnabledEnum(dtoParam.getBoolEnabledEnum());
      if (dtoParam.getBoolEnabledEnum()) {
         Preconditions.checkArgument(this.workshopService.getById(productionLine.getWorkshopId()).getBoolEnabledEnum(), "操作失败，请先启用车间");
      }

      Preconditions.checkArgument(
         this.baseService
               .list(
                  (Wrapper<MesEnclosureProductionLine>)(Wrappers.<MesEnclosureProductionLine>lambdaQuery()
                        .eq(MesEnclosureProductionLine::getWorkshopId, productionLine.getWorkshopId()))
                     .eq(MesEnclosureProductionLine::getName, productionLine.getName())
               )
               .size()
            <= 1,
         "操作失败，该车间下不允许有重名生产线"
      );
      this.baseService.updateById(productionLine);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveProductionLine(MesEnclosureProductionLineDTOParam dtoParam) {
      MesBuildingWorkshop workshop = this.workshopService
         .getOne(Wrappers.lambdaQuery(MesBuildingWorkshop.class).eq(MesBuildingWorkshop::getId, dtoParam.getWorkshopId()));
      dtoParam.setFactoryId(workshop.getFactoryId());
      MesEnclosureProductionLine productionLine = BeanUtil.copy(dtoParam, MesEnclosureProductionLine.class);
      long count = this.baseService
         .count(
            (Wrapper<MesEnclosureProductionLine>)((Wrappers.<MesEnclosureProductionLine>lambdaQuery()
                     .eq(MesEnclosureProductionLine::getWorkshopId, productionLine.getWorkshopId()))
                  .eq(MesEnclosureProductionLine::getFactoryId, productionLine.getFactoryId()))
               .eq(MesEnclosureProductionLine::getName, productionLine.getName())
         );
      Preconditions.checkArgument(count == 0L, "操作失败，该车间下不允许有重名生产线");
      productionLine.setBoolEnabledEnum(true);
      this.baseService.save(productionLine);
      List<MesEnclosureProductionLineTypeLink> typeLinks = dtoParam.getLinkIdList()
         .stream()
         .map(dictionaryId -> MesEnclosureProductionLineTypeLink.builder().productionLineId(productionLine.getId()).dictionaryId(dictionaryId).build())
         .collect(Collectors.toList());
      this.productionLineTypeLinkService.saveBatch(typeLinks);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removeByIds(List<Long> ids) {
      ids.forEach(
         e -> {
            Preconditions.checkArgument(
               this.teamLinkBiz.list(Wrappers.lambdaQuery(MesEnclosureLineTeamLink.class).eq(MesEnclosureLineTeamLink::getLineId, e)).size() == 0,
               "操作失败，该生产线下有班组，不可删除"
            );
            Preconditions.checkArgument(
               this.taskService
                     .list(
                        Wrappers.lambdaQuery(MesEnclosureTask.class)
                           .eq(MesEnclosureTask::getProductionLineId, e)
                           .eq(MesEnclosureTask::getBoolCompleteEnum, false)
                     )
                     .size()
                  == 0,
               "操作失败，该生产线下有分配的排产，不可删除"
            );
         }
      );
      this.baseService.removeByIds(ids);
      this.productionLineTypeLinkService
         .remove(Wrappers.lambdaQuery(MesEnclosureProductionLineTypeLink.class).in(MesEnclosureProductionLineTypeLink::getProductionLineId, ids));
      return Boolean.TRUE;
   }

   @Override
   public List<ProductionLineDTO> productionLineList(Long factoryId, Long workshopId, Long productionLineId, Integer productType) {
      return this.baseService
         .productionLineList(factoryId, workshopId, productionLineId, productType)
         .stream()
         .map(e -> BeanUtil.copy(e, ProductionLineDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<IdAndNameDTO> getTypeByProductType(Integer productType, Integer productionLineType) {
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         return this.sysStructureClassificationService
            .list(Wrappers.lambdaQuery())
            .stream()
            .map(e -> IdAndNameDTO.builder().id(e.getId()).name(e.getClassificationName()).build())
            .collect(Collectors.toList());
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         return this.sysAssembleConfigService
            .list()
            .stream()
            .map(e -> IdAndNameDTO.builder().id(e.getId()).name(e.getName()).build())
            .collect(Collectors.toList());
      } else if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         return this.sysSteelClassificationService
            .list()
            .stream()
            .map(e -> IdAndNameDTO.builder().id(e.getId()).name(e.getName()).build())
            .collect(Collectors.toList());
      } else {
         throw new IllegalArgumentException("操作失败：暂时不支持的类型");
      }
   }

   @Override
   public PageVO<MesEnclosureProductionLineDTO> productionLinePage(
      MesEnclosureProductionLineDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listByCondition(dtoParam));
   }

   @Override
   public List<MesEnclosureProductionLineDTO> listByCondition(MesEnclosureProductionLineDTOParam dtoParam) {
      Map<Long, List<Long>> lineMap = this.productionLineTypeLinkService
         .list()
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProductionLineId(), Collectors.mapping(e -> e.getDictionaryId(), Collectors.toList())));
      return this.baseService
         .list(
            (Wrapper<MesEnclosureProductionLine>)((((((Wrappers.<MesEnclosureProductionLine>lambdaQuery()
                                 .like(dtoParam.getName() != null, MesEnclosureProductionLine::getName, dtoParam.getName()))
                              .eq(dtoParam.getFactoryId() != null, MesEnclosureProductionLine::getFactoryId, dtoParam.getFactoryId()))
                           .eq(dtoParam.getWorkshopId() != null, MesEnclosureProductionLine::getWorkshopId, dtoParam.getWorkshopId()))
                        .eq(dtoParam.getBoolEnabledEnum() != null, MesEnclosureProductionLine::getBoolEnabledEnum, dtoParam.getBoolEnabledEnum()))
                     .apply(dtoParam.getType() != null, dtoParam.getType() + "& type>0"))
                  .orderByDesc(MesEnclosureProductionLine::getBoolEnabledEnum))
               .orderByAsc(MesEnclosureProductionLine::getSort)
         )
         .stream()
         .map(e -> {
            MesEnclosureProductionLineDTO dto = BeanUtil.copy(e, MesEnclosureProductionLineDTO.class);
            dto.setFactoryName(this.factoryService.getById(dto.getFactoryId()).getName());
            dto.setWorkshopName(this.workshopService.getById(dto.getWorkshopId()).getName());
            dto.setLinkIdList(lineMap.get(e.getId()));
            return dto;
         })
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean update(MesEnclosureProductionLineDTOParam dtoParam) {
      MesEnclosureProductionLine productionLine = BeanUtil.copy(dtoParam, MesEnclosureProductionLine.class).setUserId(UserUtil.getCurrentUserId());
      Preconditions.checkArgument(this.baseService.getById(dtoParam.getId()) != null, "操作失败，id不正确");
      this.baseService.updateById(productionLine);
      this.productionLineTypeLinkService
         .remove(
            Wrappers.lambdaQuery(MesEnclosureProductionLineTypeLink.class).eq(MesEnclosureProductionLineTypeLink::getProductionLineId, productionLine.getId())
         );
      List<MesEnclosureProductionLineTypeLink> typeLinks = dtoParam.getLinkIdList()
         .stream()
         .map(dictionaryId -> MesEnclosureProductionLineTypeLink.builder().productionLineId(productionLine.getId()).dictionaryId(dictionaryId).build())
         .collect(Collectors.toList());
      this.productionLineTypeLinkService.saveBatch(typeLinks);
      return Boolean.TRUE;
   }

   @Override
   public List<MesEnclosureProductionLineSumDO> selectProductLine(
      String factoryId, String workShopId, String productionLineId, Integer pageNumber, Integer pageSize, int type
   ) {
      return this.baseService.selectProductLine(factoryId, workShopId, productionLineId, type);
   }

   @Override
   public MesEnclosureProductionLine selectByid(Long productionLineId) {
      return this.baseService.getById(productionLineId);
   }

   @Override
   public List<MesEnclosureProductionLineSumDO> selectProductLineByids(Set<Long> lineIds) {
      return this.baseService.selectProductLineByids(lineIds);
   }

   @Override
   public List<String> productionLineByNameList(MesEnclosureProductionLineDTOParam dtoParam) {
      List<MesEnclosureProductionLineDTO> mesEnclosureProductionLineDTOS = this.listByCondition(dtoParam);
      return mesEnclosureProductionLineDTOS.stream().map(MesEnclosureProductionLineDO::getName).distinct().collect(Collectors.toList());
   }

   @Override
   public TeamsForLineDTO getTeamsByLine(Long id) {
      MesEnclosureProductionLine line = this.baseService.getById(id);
      Preconditions.checkArgument(line != null, "产线不存在请刷新后重试");
      List<MesEnclosureLineTeamLink> teamLinks = this.teamLinkBiz
         .list(Wrappers.lambdaQuery(MesEnclosureLineTeamLink.class).eq(MesEnclosureLineTeamLink::getLineId, id));
      List<MesEnclosureLineInspectionTeamLink> inspectionTeamLinks = this.inspectionTeamLinkBiz
         .list(Wrappers.lambdaQuery(MesEnclosureLineInspectionTeamLink.class).eq(MesEnclosureLineInspectionTeamLink::getLineId, id));
      TeamsForLineDTO dto = TeamsForLineDTO.builder().lineId(id).lineName(line.getName()).build();
      List<MesEnclosureTeamDTO> teanDtos = new ArrayList<>();
      List<MesEnclosureInspectionTeamDTO> inspectionTeamDtos = new ArrayList<>();
      Map<Long, MesEnclosureProcessDTO> processMap = this.processBiz
         .list()
         .stream()
         .collect(Collectors.toMap(MesEnclosureProcessDTO::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(teamLinks)) {
         List<Long> teamIds = teamLinks.stream().map(MesEnclosureLineTeamLink::getTeamId).collect(Collectors.toList());
         List<MesEnclosureTeam> teams = this.teamBiz.listByIds(teamIds);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(teams), "生产班组不存在");
         Map<Long, List<MesEnclosureTeamUserLink>> teamUserMap = this.teamUserLinkService
            .list(
               Wrappers.lambdaQuery(MesEnclosureTeamUserLink.class)
                  .in(MesEnclosureTeamUserLink::getTeamId, teams.stream().map(MesEnclosureTeam::getId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.groupingBy(MesEnclosureTeamUserLink::getTeamId));

         for (MesEnclosureTeam team : teams) {
            MesEnclosureTeamDTO build = MesEnclosureTeamDTO.builder()
               .processId(team.getProcessId())
               .processName(processMap.get(team.getProcessId()).getName())
               .factoryId(team.getFactoryId())
               .build();
            List<MesEnclosureTeamUserLink> mesEnclosureTeamUserLinks = teamUserMap.get(team.getId());
            List<MesEnclosureTeamUserLinkDTO> userLinkList = new ArrayList<>();

            for (MesEnclosureTeamUserLink link : mesEnclosureTeamUserLinks) {
               MesEnclosureTeamUserLinkDTO copy = BeanUtil.copy(link, MesEnclosureTeamUserLinkDTO.class);
               userLinkList.add(copy);
            }

            build.setUserLinks(userLinkList);
            teanDtos.add(build);
         }
      }

      if (CollectionUtils.isNotEmpty(inspectionTeamLinks)) {
         List<Long> inspectionTeamIds = inspectionTeamLinks.stream().map(MesEnclosureLineInspectionTeamLink::getInspectionTeamId).collect(Collectors.toList());
         List<MesEnclosureInspectionTeam> inspectionTeams = this.inspectionTeamBiz.listByIds(inspectionTeamIds);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(inspectionTeams), "质检班组不存在");
         Map<Long, List<MesEnclosureInspectionTeamUserLink>> teamUserMap = this.inspectionTeamUserLinkService
            .list(Wrappers.lambdaQuery(MesEnclosureInspectionTeamUserLink.class).in(MesEnclosureInspectionTeamUserLink::getInspectionTeamId, inspectionTeamIds))
            .stream()
            .collect(Collectors.groupingBy(MesEnclosureInspectionTeamUserLink::getInspectionTeamId));

         for (MesEnclosureInspectionTeam team : inspectionTeams) {
            MesEnclosureInspectionTeamDTO build = MesEnclosureInspectionTeamDTO.builder()
               .processId(team.getProcessId())
               .processName(processMap.get(team.getProcessId()).getName())
               .factoryId(team.getFactoryId())
               .build();
            List<MesEnclosureInspectionTeamUserLink> mesEnclosureInspectionTeamUserLinks = teamUserMap.get(team.getId());
            List<MesEnclosureInspectionTeamUserLinkDTO> userLinkList = new ArrayList<>();

            for (MesEnclosureInspectionTeamUserLink link : mesEnclosureInspectionTeamUserLinks) {
               MesEnclosureInspectionTeamUserLinkDTO copy = BeanUtil.copy(link, MesEnclosureInspectionTeamUserLinkDTO.class);
               userLinkList.add(copy);
            }

            build.setUserLinkList(userLinkList);
            inspectionTeamDtos.add(build);
         }
      }

      dto.setTeams(teanDtos);
      dto.setInspectionTeams(inspectionTeamDtos);
      return dto;
   }

   @Override
   public Boolean saveTeamLink(Long id, List<Long> teamIds) {
      MesEnclosureProductionLine line = this.baseService.getById(id);
      Preconditions.checkArgument(line != null, "操作失败,产线不存在!!!");
      List<MesEnclosureLineTeamLink> teamLinks = this.teamLinkBiz
         .list((Wrapper<MesEnclosureLineTeamLink>)Wrappers.<MesEnclosureLineTeamLink>lambdaQuery().eq(MesEnclosureLineTeamLink::getLineId, id));
      if (CollectionUtils.isEmpty(teamIds)) {
         teamIds = new ArrayList<>();
      }

      List<Long> finalTeamIds = teamIds;
      List<Long> collect = teamLinks.stream().map(MesEnclosureLineTeamLink::getTeamId).filter(s -> !finalTeamIds.contains(s)).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(collect)) {
         List<MesEnclosureTask> tasks = this.taskService
            .list(
               Wrappers.lambdaQuery(MesEnclosureTask.class)
                  .eq(MesEnclosureTask::getProductionLineId, id)
                  .in(MesEnclosureTask::getTeamId, collect)
                  .eq(MesEnclosureTask::getBoolCompleteEnum, false)
            );
         Preconditions.checkArgument(tasks.size() == 0, "修改失败,该产线下班组,存在与该产线相关任务无法删除");
      }

      this.teamLinkBiz.remove((Wrapper<MesEnclosureLineTeamLink>)Wrappers.<MesEnclosureLineTeamLink>lambdaQuery().eq(MesEnclosureLineTeamLink::getLineId, id));
      if (teamIds != null && teamIds.size() > 0) {
         List<MesEnclosureTeam> teams = this.teamBiz.listByIds(teamIds);
         Preconditions.checkArgument(teamIds.size() == teams.size(), "操作失败，id有误");
         teamIds.forEach(e -> this.teamLinkBiz.save(MesEnclosureLineTeamLink.builder().lineId(id).teamId(e).build()));
      }

      return Boolean.TRUE;
   }

   @Override
   public Boolean saveInspectTeam(Long id, List<Long> teamIds) {
      MesEnclosureProductionLine line = this.baseService.getById(id);
      Preconditions.checkArgument(line != null, "操作失败,生产线不存在!!!");
      List<Long> inspectionTeamLinkList = this.inspectionTeamLinkBiz
         .list(Wrappers.lambdaQuery(MesEnclosureLineInspectionTeamLink.class).eq(MesEnclosureLineInspectionTeamLink::getLineId, id))
         .stream()
         .map(MesEnclosureLineInspectionTeamLink::getInspectionTeamId)
         .collect(Collectors.toList());
      new HashSet();
      if (inspectionTeamLinkList.size() != 0) {
         Set<Long> removeProcessIdSet = this.inspectionTeamBiz
            .listByIds(inspectionTeamLinkList)
            .stream()
            .map(MesEnclosureInspectionTeam::getProcessId)
            .collect(Collectors.toSet());
      }

      this.inspectionTeamLinkBiz
         .remove((Wrapper<MesEnclosureLineInspectionTeamLink>)Wrappers.<MesEnclosureLineInspectionTeamLink>lambdaQuery().eq(MesEnclosureLineInspectionTeamLink::getLineId, id));
      if (teamIds != null && teamIds.size() > 0) {
         teamIds.forEach(e -> this.inspectionTeamLinkBiz.save(MesEnclosureLineInspectionTeamLink.builder().lineId(id).inspectionTeamId(e).build()));
      }

      return Boolean.TRUE;
   }
}
