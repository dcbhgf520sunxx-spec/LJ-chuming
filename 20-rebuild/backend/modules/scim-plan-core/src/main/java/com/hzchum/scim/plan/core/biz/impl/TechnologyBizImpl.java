package com.hzchum.scim.plan.core.biz.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.TechnologyBiz;
import com.hzchum.scim.plan.core.api.enums.ItemizedTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.MonomerUserLinkDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechnologyDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.CreateDeeperLeaderDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TechnologyBizImpl implements TechnologyBiz {
   private static final Logger log = LoggerFactory.getLogger(TechnologyBizImpl.class);
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private UserService userService;
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private TechStandardPartService techStandardPartService;

   @Override
   public PageVO<TechnologyDTO> pageByYearAndName(
      Integer year, String name, Integer projectType, Integer lumpSumSystemType, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      Long userId = UserUtil.getCurrentUser().isAdmin() ? null : UserUtil.getCurrentUserId();
      List<TechnologyDTO> technologyDTOList = this.contractProjectService.pageByYearAndName(year, name, projectType, lumpSumSystemType, userId);
      if (CollectionUtils.isEmpty(technologyDTOList)) {
         return new PageVO<>();
      }

      PageVO<TechnologyDTO> technologyDTOPageVO = new PageVO<>(technologyDTOList);
      List<Long> projectIds = technologyDTOList.stream().map(TechnologyDTO::getId).collect(Collectors.toList());
      Map<Long, List<PlanMonomer>> monomerMap = this.planMonomerService
         .list((Wrapper<PlanMonomer>)new LambdaQueryWrapper<PlanMonomer>().in(PlanMonomer::getProjectId, projectIds))
         .stream()
         .collect(Collectors.groupingBy(PlanMonomer::getProjectId));
      Map<Long, List<MonomerUserLink>> monomerUserLinkMap = this.monomerUserLinkService
         .list((Wrapper<MonomerUserLink>)new LambdaQueryWrapper<MonomerUserLink>().in(MonomerUserLink::getProjectId, projectIds))
         .stream()
         .collect(Collectors.groupingBy(MonomerUserLink::getMonomerId));
      Map<Long, List<PlanArea>> areaMap = this.planAreaService
         .list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().in(PlanArea::getProjectId, projectIds))
         .stream()
         .collect(Collectors.groupingBy(PlanArea::getMonomerId));
      Map<Long, List<TechArtifact>> artifactAreaMap = this.techArtifactService
         .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getProjectId, projectIds))
         .stream()
         .collect(Collectors.groupingBy(TechArtifact::getAreaId));
      Map<Long, List<TechStandardPart>> standardPartMap = this.techStandardPartService
         .list((Wrapper<TechStandardPart>)new LambdaQueryWrapper<TechStandardPart>().in(TechStandardPart::getProjectId, projectIds))
         .stream()
         .collect(Collectors.groupingBy(TechStandardPart::getAreaId));
      technologyDTOPageVO.getContent()
         .forEach(
            projectDTO -> {
               projectDTO.setIsCreateDeepArchivist(Boolean.FALSE);
               List<PlanMonomer> monomerList = monomerMap.get(projectDTO.getId());
               if (CollectionUtils.isNotEmpty(monomerList)) {
                  List<PlanMonomerDTO> planMonomerDTOS = BeanUtil.copyToList(monomerList, PlanMonomerDTO.class);
                  planMonomerDTOS.forEach(
                     monomerDTO -> {
                        if (Objects.nonNull(monomerDTO.getEndDate())) {
                           monomerDTO.setUsedDays(ChronoUnit.DAYS.between(LocalDate.now(), monomerDTO.getEndDate().plusDays(1L)));
                        }

                        List<MonomerUserLink> monomerUserLinks = monomerUserLinkMap.get(monomerDTO.getId());
                        if (CollectionUtils.isNotEmpty(monomerUserLinks)) {
                           monomerDTO.setDeepenIdsAndName(
                              monomerUserLinks.stream()
                                 .map(link -> com.hzchum.pangu.common.util.BeanUtil.copy(link, MonomerUserLinkDTO.class))
                                 .collect(Collectors.toList())
                           );
                        }

                        List<PlanArea> areaList = areaMap.get(monomerDTO.getId());
                        LocalDate earliestStartTime = null;
                        LocalDate latestEndTime = null;

                        for (PlanArea area : areaList) {
                           LocalDate startTime = area.getDeepenStartDate();
                           LocalDate endTime = area.getDeepenEndDate();
                           if (earliestStartTime == null || startTime.isBefore(earliestStartTime)) {
                              earliestStartTime = startTime;
                           }

                           if (latestEndTime == null || endTime.isAfter(latestEndTime)) {
                              latestEndTime = endTime;
                           }
                        }

                        if (earliestStartTime != null && latestEndTime != null) {
                           long between = ChronoUnit.DAYS.between(earliestStartTime, latestEndTime.plusDays(1L));
                           monomerDTO.setAllDays((int)between);
                        }

                        if (CollectionUtils.isNotEmpty(areaList)) {
                           List<PlanAreaDTO> planAreaDTOS = BeanUtil.copyToList(areaList, PlanAreaDTO.class);
                           List<LocalDate> localDates = planAreaDTOS.stream()
                              .map(PlanAreaDTO::getDeepenStartDate)
                              .filter(Objects::nonNull)
                              .collect(Collectors.toList());
                           long totalDays = localDates.stream().mapToLong(date -> ChronoUnit.DAYS.between(date, LocalDate.now().plusDays(1L))).sum();
                           monomerDTO.setUsedDays(totalDays);
                           planAreaDTOS.forEach(
                              planAreaDTO -> {
                                 if (planAreaDTO.getDeepenEndDate() != null) {
                                    planAreaDTO.setUsedDays(ChronoUnit.DAYS.between(planAreaDTO.getDeepenStartDate(), LocalDate.now().plusDays(1L)));
                                    planAreaDTO.setAllDays(
                                       (int)ChronoUnit.DAYS.between(planAreaDTO.getDeepenStartDate(), planAreaDTO.getDeepenEndDate().plusDays(1L))
                                    );
                                 }

                                 if (planAreaDTO.getItemizedType().equals(ItemizedTypeEnum.ARTIFACT.getType())) {
                                    List<TechArtifact> areaArtifactList = artifactAreaMap.get(planAreaDTO.getId());
                                    if (CollectionUtils.isNotEmpty(areaArtifactList)) {
                                       BigDecimal totalNetWeight = areaArtifactList.stream()
                                          .map(TechArtifact::getTotalNetWeight)
                                          .reduce(BigDecimal.ZERO, BigDecimal::add);
                                       planAreaDTO.setActualCompletion(
                                          planAreaDTO.getMete() != null && BigDecimal.ZERO.compareTo(planAreaDTO.getMete()) != 0
                                             ? totalNetWeight.divide(planAreaDTO.getMete(), 2, RoundingMode.HALF_UP)
                                             : BigDecimal.valueOf(0L)
                                       );
                                    }
                                 }

                                 if (planAreaDTO.getItemizedType().equals(ItemizedTypeEnum.OTHER.getType())) {
                                    List<TechStandardPart> techStandardParts = standardPartMap.get(planAreaDTO.getId());
                                    if (CollectionUtils.isNotEmpty(techStandardParts)) {
                                       BigDecimal sum = techStandardParts.stream()
                                          .map(TechStandardPart::getQuantity)
                                          .reduce(BigDecimal.ZERO, BigDecimal::add)
                                          .multiply(BigDecimal.valueOf(100L));
                                       planAreaDTO.setActualCompletion(
                                          planAreaDTO.getMete() != null && BigDecimal.ZERO.compareTo(planAreaDTO.getMete()) != 0
                                             ? sum.divide(planAreaDTO.getMete(), 2, RoundingMode.HALF_UP)
                                             : BigDecimal.valueOf(0L)
                                       );
                                    }
                                 }
                              }
                           );
                           monomerDTO.setAreaDTOList(planAreaDTOS);
                        }
                     }
                  );
                  projectDTO.setMonomerList(planMonomerDTOS);
                  projectDTO.setIsCreateDeepArchivist(
                     planMonomerDTOS.stream().allMatch(monomerDTO -> CollectionUtils.isNotEmpty(monomerDTO.getDeepenIdsAndName()))
                  );
               }
            }
         );
      technologyDTOPageVO.setContent(
         technologyDTOPageVO.getContent()
            .stream()
            .sorted(
               Comparator.comparing(TechnologyDTO::getIsCreateDeepArchivist).thenComparing(Comparator.comparing(TechnologyDTO::getPlanCreateDate).reversed())
            )
            .collect(Collectors.toList())
      );
      return technologyDTOPageVO;
   }

   @Override
   public boolean createDeepArchivist(CreateDeeperLeaderDTOParam createDeeperLeaderDTOParam) {
      Preconditions.checkArgument(createDeeperLeaderDTOParam.getMonomerId() != null, "单体id不能为空");
      PlanMonomerDTO monomer = this.planMonomerService.getMonomerById(createDeeperLeaderDTOParam.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在");
      List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
         .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, createDeeperLeaderDTOParam.getMonomerId()));
      List<Long> monomerUserLinkIds = monomerUserLinkList.stream().map(MonomerUserLink::getId).collect(Collectors.toList());
      monomerUserLinkIds.forEach(p -> this.monomerUserLinkService.removeById(p));
      List<PlanMonomerDTO> planMonomerDTOs = this.planMonomerService.getNoDeepenedPersonId(createDeeperLeaderDTOParam.getProjectId());
      if (CollectionUtils.isNotEmpty(planMonomerDTOs)) {
         List<Long> monomerIds = planMonomerDTOs.stream().map(PlanMonomerDTO::getId).collect(Collectors.toList());
         Map<Long, PlanMonomer> monomerMap = this.planMonomerService
            .listByIds(monomerIds)
            .stream()
            .collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
         Map<Long, List<PlanArea>> areaMap = this.planAreaService
            .list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().in(PlanArea::getMonomerId, monomerIds))
            .stream()
            .collect(Collectors.groupingBy(PlanArea::getMonomerId));
         planMonomerDTOs.forEach(
            monomerDTO -> {
               Set<Long> userIdList = new HashSet<>(createDeeperLeaderDTOParam.getUserIdList());
               PlanMonomer planMonomer = monomerMap.get(monomerDTO.getId());
               List<PlanArea> areaList = areaMap.get(monomerDTO.getId());
               if (planMonomer.getUserId() != null) {
                  userIdList.add(planMonomer.getUserId());
               }

               if (CollectionUtils.isNotEmpty(areaList)) {
                  List<Long> userIds = areaList.stream().map(PlanArea::getUserId).filter(Objects::nonNull).collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(userIds)) {
                     userIdList.addAll(userIds);
                  }
               }

               userIdList.forEach(
                  userId -> {
                     User user = this.userService.getById(userId);
                     Preconditions.checkArgument(user != null, "用户不存在无法添加深化负责人");
                     MonomerUserLink monomerUserLink = MonomerUserLink.builder()
                        .deepenedPersonName(user.getName())
                        .projectId(createDeeperLeaderDTOParam.getProjectId())
                        .monomerId(monomerDTO.getId())
                        .createUserId(UserUtil.getCurrentUser().getId())
                        .deepenedPersonId(userId)
                        .build();
                     this.monomerUserLinkService.save(monomerUserLink);
                  }
               );
            }
         );
      }

      return true;
   }

   @Override
   public boolean addDefaultDeepArchivist(PlanMonomer planMonomer) {
      List<User> userList = this.userService.list(Wrappers.lambdaQuery(User.class).eq(User::getIsDeepen, Boolean.TRUE));
      userList.forEach(
         user -> {
            MonomerUserLink monomerUserLink = MonomerUserLink.builder()
               .deepenedPersonName(user.getName())
               .projectId(planMonomer.getProjectId())
               .monomerId(planMonomer.getId())
               .createUserId(UserUtil.getCurrentUser().getId())
               .deepenedPersonId(user.getId())
               .build();
            this.monomerUserLinkService.save(monomerUserLink);
         }
      );
      return true;
   }
}
