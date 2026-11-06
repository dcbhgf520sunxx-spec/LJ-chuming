package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesInspectClassIdTeamIdDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectClassificationConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigTeamLink;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesInspectUserInfoDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesShopInspectUserTreeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.ChangStatusDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectClassificationConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigBasicDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigSaveDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigTeamLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigUpdateParam;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigUserLinkDTO;
import com.hzchum.scim.system.core.api.service.MesInspectClassificationConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigTeamLinkService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigUserLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.MesInspectConfigMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesInspectConfigServiceImpl extends ServiceImpl<MesInspectConfigMapper, MesInspectConfig> implements MesInspectConfigService {
   @Resource
   MesInspectConfigTeamLinkService inspectConfigTeamLinkService;
   @Resource
   MesInspectClassificationConfigLinkService inspectClassificationService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesInspectClassificationConfigLinkService classificationConfigLinkService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesInspectConfigUserLinkService inspectConfigUserLinkService;
   @Resource
   UserService userService;
   @Resource
   private MesBuildingWorkshopService workshopService;

   @Override
   public PageVO<MesInspectConfigDTO> findInspectConfigList(MesInspectConfigDTO inspectConfig, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<MesInspectConfigDTO> configs = this.baseMapper.findAllConfig(inspectConfig);
      if (CollectionUtils.isEmpty(configs)) {
         return new PageVO<>();
      }

      List<Long> idList = configs.stream().map(MesInspectConfigDTO::getId).collect(Collectors.toList());
      List<MesInspectConfigUserLinkDTO> userLinks = this.inspectConfigUserLinkService.findInspectUserInfoByInspectId(idList);
      Map<Long, List<MesInspectConfigUserLinkDTO>> userLinksMap = userLinks.stream()
         .collect(Collectors.groupingBy(MesInspectConfigUserLinkDTO::getInspectConfigId));
      List<MesInspectConfigTeamLinkDTO> teamInfo = this.inspectConfigTeamLinkService.findInspectInfoByInspectId(idList);
      Map<Long, List<MesInspectConfigTeamLinkDTO>> teamMap = teamInfo.stream().collect(Collectors.groupingBy(MesInspectConfigTeamLinkDTO::getInspectConfigId));
      List<MesInspectClassificationConfigLinkDTO> classInfoByInspectId = this.inspectClassificationService.findClassInfoByInspectId(idList);
      Map<Long, List<MesInspectClassificationConfigLinkDTO>> classMap = classInfoByInspectId.stream()
         .collect(Collectors.groupingBy(MesInspectClassificationConfigLinkDTO::getInspectConfigId));

      for (MesInspectConfigDTO config : configs) {
         config.setInsepectUserList(userLinksMap.get(config.getId()));
         config.setTeamLink(teamMap.get(config.getId()));
         config.setClassificationList(classMap.get(config.getId()));
      }

      return new PageVO<>(configs);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveConfig(MesInspectConfigSaveDTO inspectConfig) {
      this.utilsBiz
         .checkBatchClassIdOrProcessIdsOrTeamIds(
            inspectConfig.getClassificationId(),
            inspectConfig.getTaskTypeEnum(),
            Arrays.asList(inspectConfig.getProcessId()),
            inspectConfig.getTeamLink(),
            null
         );
      this.checkSameTeam(
         inspectConfig.getInspectUserIds(),
         inspectConfig.getTeamLink(),
         inspectConfig.getWorkshopId(),
         inspectConfig.getProcessId(),
         null,
         inspectConfig.getArtifactType(),
         inspectConfig.getMesProductEnum()
      );
      MesBuildingWorkshop workshop = this.workshopService.getById(inspectConfig.getWorkshopId());
      Preconditions.checkArgument(workshop != null, "车间不存在!");
      Preconditions.checkArgument(workshop.getType().equals(inspectConfig.getMesProductEnum()), "mes分类不一致!");
      MesInspectConfig config = BeanUtil.copy(inspectConfig, MesInspectConfig.class);
      config.setMesProductEnum(inspectConfig.getMesProductEnum());
      this.baseMapper.insert(config);
      MesInspectConfigTeamLink link = new MesInspectConfigTeamLink();
      link.setInspectConfigId(config.getId());
      inspectConfig.getTeamLink().forEach(e -> {
         link.setTeamId(e);
         this.inspectConfigTeamLinkService.save(link);
      });
      MesInspectClassificationConfigLink classLink = new MesInspectClassificationConfigLink();
      classLink.setInspectConfigId(config.getId());
      classLink.setTaskTypeEnum(config.getTaskTypeEnum());
      inspectConfig.getClassificationId().forEach(e -> {
         classLink.setClassificationId(e);
         this.inspectClassificationService.save(classLink);
      });
      MesInspectConfigUserLink userLink = new MesInspectConfigUserLink();
      userLink.setInspectConfigId(config.getId());
      inspectConfig.getInspectUserIds().forEach(e -> {
         userLink.setInspectUserId(e);
         this.inspectConfigUserLinkService.save(userLink);
      });
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updateConfig(MesInspectConfigUpdateParam inspectConfig) throws CloneNotSupportedException {
      this.utilsBiz
         .checkBatchClassIdOrProcessIdsOrTeamIds(
            inspectConfig.getClassificationId(),
            inspectConfig.getTaskTypeEnum(),
            Arrays.asList(inspectConfig.getProcessId()),
            inspectConfig.getTeamLink(),
            null
         );
      MesInspectConfig mesInspectConfig = this.baseMapper.selectById(inspectConfig.getId());
      Preconditions.checkArgument(mesInspectConfig != null, "质检基础配置信息不存在");
      MesBuildingWorkshop workshop = this.workshopService.getById(inspectConfig.getWorkshopId());
      Preconditions.checkArgument(workshop != null, "车间不存在!");
      Preconditions.checkArgument(workshop.getType().equals(mesInspectConfig.getMesProductEnum()), "mes分类不可修改!");
      this.checkSameTeam(
         inspectConfig.getInspectUserIds(),
         inspectConfig.getTeamLink(),
         inspectConfig.getWorkshopId(),
         inspectConfig.getProcessId(),
         inspectConfig.getId(),
         inspectConfig.getArtifactType(),
         mesInspectConfig.getMesProductEnum()
      );
      BeanUtils.copyProperties(inspectConfig, mesInspectConfig);
      this.baseMapper.updateById(mesInspectConfig);
      List<MesInspectConfigTeamLink> oldTeamList = this.inspectConfigTeamLinkService
         .list(Wrappers.lambdaQuery(MesInspectConfigTeamLink.class).eq(MesInspectConfigTeamLink::getInspectConfigId, inspectConfig.getId()));
      List<MesInspectClassificationConfigLink> oldClassLinks = this.inspectClassificationService
         .list(Wrappers.lambdaQuery(MesInspectClassificationConfigLink.class).eq(MesInspectClassificationConfigLink::getInspectConfigId, inspectConfig.getId()));
      List<MesInspectConfigUserLink> configUserLinks = this.inspectConfigUserLinkService
         .list(Wrappers.lambdaQuery(MesInspectConfigUserLink.class).eq(MesInspectConfigUserLink::getInspectConfigId, inspectConfig.getId()));
      List<Long> oldTeamIds = oldTeamList.stream().map(MesInspectConfigTeamLink::getTeamId).collect(Collectors.toList());
      List<Long> oldClassIds = oldClassLinks.stream().map(MesInspectClassificationConfigLink::getClassificationId).collect(Collectors.toList());
      List<Long> oldUsers = configUserLinks.stream().map(MesInspectConfigUserLink::getInspectUserId).collect(Collectors.toList());
      List<Long> delTeamList = oldTeamIds.stream().filter(e -> !inspectConfig.getTeamLink().contains(e)).collect(Collectors.toList());
      List<Long> addTeamList = inspectConfig.getTeamLink().stream().filter(e -> !oldTeamIds.contains(e)).collect(Collectors.toList());
      List<Long> delClassList = oldClassIds.stream().filter(e -> !inspectConfig.getClassificationId().contains(e)).collect(Collectors.toList());
      List<Long> addClassList = inspectConfig.getClassificationId().stream().filter(e -> !oldClassIds.contains(e)).collect(Collectors.toList());
      List<Long> delUserList = oldUsers.stream().filter(e -> !inspectConfig.getInspectUserIds().contains(e)).collect(Collectors.toList());
      List<Long> addUserList = inspectConfig.getInspectUserIds().stream().filter(e -> !oldUsers.contains(e)).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(delTeamList)) {
         int count = this.taskProcessService
            .count(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .in(MesBuildingTaskProcess::getTeamId, delTeamList)
                  .last("and inspection_quantity < complete_quantity")
            );
         Preconditions.checkArgument(count == 0L, "去除的班组存在未完成的质检任务，无法删除");
         this.inspectConfigTeamLinkService
            .remove(
               Wrappers.lambdaQuery(MesInspectConfigTeamLink.class)
                  .eq(MesInspectConfigTeamLink::getInspectConfigId, mesInspectConfig.getId())
                  .in(MesInspectConfigTeamLink::getTeamId, delTeamList)
            );
      }

      if (CollectionUtils.isNotEmpty(delClassList)) {
         this.inspectClassificationService
            .remove(
               Wrappers.lambdaQuery(MesInspectClassificationConfigLink.class)
                  .eq(MesInspectClassificationConfigLink::getInspectConfigId, mesInspectConfig.getId())
                  .in(MesInspectClassificationConfigLink::getClassificationId, delClassList)
            );
      }

      if (CollectionUtils.isNotEmpty(delUserList)) {
         this.inspectConfigUserLinkService
            .remove(
               Wrappers.lambdaQuery(MesInspectConfigUserLink.class)
                  .eq(MesInspectConfigUserLink::getInspectConfigId, mesInspectConfig.getId())
                  .in(MesInspectConfigUserLink::getInspectUserId, delUserList)
            );
      }

      if (CollectionUtils.isNotEmpty(addTeamList)) {
         ArrayList<MesInspectConfigTeamLink> addList = new ArrayList<>();
         MesInspectConfigTeamLink teamLink = new MesInspectConfigTeamLink();
         teamLink.setInspectConfigId(mesInspectConfig.getId());

         for (Long addTeamId : addTeamList) {
            MesInspectConfigTeamLink link = teamLink.clone();
            link.setTeamId(addTeamId);
            addList.add(link);
         }

         this.inspectConfigTeamLinkService.saveBatch(addList);
      }

      if (CollectionUtils.isNotEmpty(addClassList)) {
         ArrayList<MesInspectClassificationConfigLink> addList = new ArrayList<>();
         MesInspectClassificationConfigLink classLink = new MesInspectClassificationConfigLink();
         classLink.setInspectConfigId(mesInspectConfig.getId());
         classLink.setTaskTypeEnum(mesInspectConfig.getTaskTypeEnum());

         for (Long addClassId : addClassList) {
            MesInspectClassificationConfigLink Link = classLink.clone();
            Link.setClassificationId(addClassId);
            addList.add(Link);
         }

         this.inspectClassificationService.saveBatch(addList);
      }

      if (CollectionUtils.isNotEmpty(addUserList)) {
         ArrayList<MesInspectConfigUserLink> addList = new ArrayList<>();
         MesInspectConfigUserLink userLink = new MesInspectConfigUserLink();
         userLink.setInspectConfigId(mesInspectConfig.getId());

         for (Long userId : addUserList) {
            MesInspectConfigUserLink Link = userLink.clone();
            Link.setInspectUserId(userId);
            addList.add(Link);
         }

         this.inspectConfigUserLinkService.saveBatch(addList);
      }

      return Boolean.TRUE;
   }

   @Override
   public List<Long> getInspectConfigClassIdLink(List<Long> inspectConfigIds) {
      return this.classificationConfigLinkService
         .list(Wrappers.lambdaQuery(MesInspectClassificationConfigLink.class).in(MesInspectClassificationConfigLink::getInspectConfigId, inspectConfigIds))
         .stream()
         .map(MesInspectClassificationConfigLink::getClassificationId)
         .collect(Collectors.toList());
   }

   public void checkSameTeam(
      List<Long> inspectUserId, List<Long> teamLink, Long workshopId, Long processId, Long id, Integer artifactType, Integer mesProductEnum
   ) {
      List<MesInspectConfig> configs = this.baseMapper
         .findInspectByUserIdAndProcessId(inspectUserId, teamLink, workshopId, processId, id, artifactType, mesProductEnum);
      Preconditions.checkArgument(CollectionUtils.isEmpty(configs), "已存在相同配置,工序、生产班组、构件类型、质检人唯一");
   }

   @Transactional
   @Override
   public Boolean delClassConfig(Long inspectConfigId) {
      MesInspectConfig mesInspectConfig = this.baseMapper.selectById(inspectConfigId);
      Preconditions.checkArgument(mesInspectConfig != null, "操作失败,质检班组不存在!");
      List<MesInspectConfigTeamLink> teamLinks = this.inspectConfigTeamLinkService
         .list(Wrappers.lambdaQuery(MesInspectConfigTeamLink.class).eq(MesInspectConfigTeamLink::getInspectConfigId, inspectConfigId));
      List<Long> teamIds = teamLinks.stream().map(e -> e.getTeamId()).collect(Collectors.toList());
      List<MesBuildingProduceInspectionTeamReport> reports = this.inspectionTeamReportService
         .list(Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReport.class).eq(MesBuildingProduceInspectionTeamReport::getTeamId, teamIds));
      Preconditions.checkArgument(CollectionUtils.isEmpty(reports), "当前班组存在质检记录，无法删除");
      List<MesInspectClassificationConfigLink> classificationConfigLinks = this.inspectClassificationService
         .list(Wrappers.lambdaQuery(MesInspectClassificationConfigLink.class).eq(MesInspectClassificationConfigLink::getInspectConfigId, inspectConfigId));
      List<Long> classIds = classificationConfigLinks.stream().map(MesInspectClassificationConfigLink::getClassificationId).collect(Collectors.toList());
      List<MesInspectClassIdTeamIdDTO> taskClassIdandTeamIdList = this.taskProcessService
         .findTaskClassIdandTeamIdByInspectInfo(mesInspectConfig.getWorkshopId(), mesInspectConfig.getProcessId(), teamIds, classIds);
      Preconditions.checkArgument(CollectionUtils.isEmpty(taskClassIdandTeamIdList), "存在上报未质检数据，请先质检完后再进行操作");
      this.baseMapper.deleteById(inspectConfigId);
      this.inspectConfigTeamLinkService
         .remove(Wrappers.lambdaQuery(MesInspectConfigTeamLink.class).eq(MesInspectConfigTeamLink::getInspectConfigId, inspectConfigId));
      this.inspectClassificationService
         .remove(Wrappers.lambdaQuery(MesInspectClassificationConfigLink.class).eq(MesInspectClassificationConfigLink::getInspectConfigId, inspectConfigId));
      this.inspectConfigUserLinkService
         .remove(Wrappers.lambdaQuery(MesInspectConfigUserLink.class).eq(MesInspectConfigUserLink::getInspectConfigId, inspectConfigId));
      return Boolean.TRUE;
   }

   @Override
   public List<MesInspectConfig> queryInspectConfig(Long workshopId, Long processId, Long classId, Long teamId) {
      return this.baseMapper.queryInspectConfig(workshopId, processId, classId, teamId);
   }

   @Override
   public List<MesInspectConfig> selectCurrentUserIsInspectUser(Long workshopId, Long processId, Long classId, Long userId) {
      return this.baseMapper.selectCurrentUserIsInspectUser(workshopId, processId, classId, userId);
   }

   @Override
   public Boolean changeState(ChangStatusDTO classConfig) {
      MesInspectConfig inspectConfig = this.baseMapper.selectById(classConfig.getId());
      List<MesInspectConfigTeamLink> teamLinks = this.inspectConfigTeamLinkService
         .list(Wrappers.lambdaQuery(MesInspectConfigTeamLink.class).eq(MesInspectConfigTeamLink::getInspectConfigId, inspectConfig.getId()));
      List<Long> teamIds = teamLinks.stream().map(MesInspectConfigTeamLink::getTeamId).collect(Collectors.toList());
      List<MesInspectClassificationConfigLink> classificationConfigLinks = this.inspectClassificationService
         .list(Wrappers.lambdaQuery(MesInspectClassificationConfigLink.class).eq(MesInspectClassificationConfigLink::getInspectConfigId, inspectConfig.getId()));
      List<Long> classIds = classificationConfigLinks.stream().map(MesInspectClassificationConfigLink::getClassificationId).collect(Collectors.toList());
      MesInspectConfig config = BeanUtil.copy(classConfig, MesInspectConfig.class);
      return this.updateById(config);
   }

   @Override
   public List<MesShopInspectUserTreeDTO> findAllInspectUserGroupWorkShop() {
      List<MesShopInspectUserTreeDTO> dtos = new ArrayList<>();
      Map<Long, List<MesInspectConfig>> shopMap = this.list().stream().collect(Collectors.groupingBy(e -> e.getWorkshopId()));
      if (CollectionUtils.isEmpty(shopMap)) {
         return dtos;
      }

      List<MesInspectConfigUserLink> userLinks = this.inspectConfigUserLinkService.list();
      if (CollectionUtils.isEmpty(userLinks)) {
         return dtos;
      }

      Map<Long, String> nameMap = this.userService
         .listByIds(userLinks.stream().map(e -> e.getInspectUserId()).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
      Map<Long, List<MesInspectConfigUserLink>> userLinkMap = userLinks.stream().collect(Collectors.groupingBy(e -> e.getInspectConfigId()));
      shopMap.forEach((k, v) -> {
         MesShopInspectUserTreeDTO dto = new MesShopInspectUserTreeDTO();
         dto.setWorkshopId(k);
         Set<IdAndNameDTO> userSet = new HashSet<>();

         for (MesInspectConfig config : v) {
            for (MesInspectConfigUserLink userLink : userLinkMap.get(config.getId())) {
               IdAndNameDTO nameDTO = new IdAndNameDTO();
               nameDTO.setId(userLink.getInspectUserId());
               nameDTO.setName(nameMap.get(userLink.getInspectUserId()));
               userSet.add(nameDTO);
            }
         }

         dto.setInspectUsers(new ArrayList<>(userSet));
         dtos.add(dto);
      });
      return dtos;
   }

   @Override
   public List<MesInspectUserInfoDTO> findInspectUserAttribute() {
      List<MesInspectUserInfoDTO> configList = this.list(Wrappers.lambdaQuery(MesInspectConfig.class).eq(MesInspectConfig::getStatus, 1))
         .stream()
         .map(
            s -> MesInspectUserInfoDTO.builder()
               .id(s.getId())
               .workshopId(s.getWorkshopId())
               .artifactType(s.getArtifactType())
               .taskTypeEnum(s.getTaskTypeEnum())
               .build()
         )
         .collect(Collectors.toList());
      Map<Long, List<Long>> classificationMap = this.inspectClassificationService
         .list()
         .stream()
         .collect(
            Collectors.groupingBy(MesInspectClassificationConfigLink::getInspectConfigId, Collectors.mapping(e -> e.getClassificationId(), Collectors.toList()))
         );
      Map<Long, List<Long>> teamIdsMap = this.inspectConfigTeamLinkService
         .list()
         .stream()
         .collect(Collectors.groupingBy(MesInspectConfigTeamLink::getInspectConfigId, Collectors.mapping(e -> e.getTeamId(), Collectors.toList())));
      Map<Long, List<Long>> inspectUserMap = this.inspectConfigUserLinkService
         .list()
         .stream()
         .collect(Collectors.groupingBy(MesInspectConfigUserLink::getInspectConfigId, Collectors.mapping(e -> e.getInspectUserId(), Collectors.toList())));

      for (MesInspectUserInfoDTO dto : configList) {
         dto.setClassificationIdLinks(classificationMap.get(dto.getId()));
         dto.setTeamIdLinks(teamIdsMap.get(dto.getId()));
         dto.setInspectUsers(inspectUserMap.get(dto.getId()));
      }

      return configList;
   }

   @Override
   public List<MesInspectConfigBasicDTO> queryAllInspectConfigList() {
      return this.baseMapper.queryAllInspectConfigList();
   }
}
