package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesBuildingPaintCalculateRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintConfig;
import com.hzchum.scim.mes.building.core.api.service.craft.MesBuildingPaintCalculateRecordService;
import com.hzchum.scim.mes.building.core.api.service.craft.MesPaintConfigService;
import com.hzchum.scim.plan.core.api.biz.TechPaintTechnologyBiz;
import com.hzchum.scim.plan.core.api.enums.RangeTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnology;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnologyArtifactLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnologyDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyArtifactQueryParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyDetailParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyQueryParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologySaveParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyUpdateParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechPaintTechnologyArtifactLinkService;
import com.hzchum.scim.plan.core.api.service.TechPaintTechnologyDetailService;
import com.hzchum.scim.plan.core.api.service.TechPaintTechnologyService;
import com.hzchum.scim.plan.core.mapper.TechPaintTechnologyMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechPaintTechnologyBizImpl
   extends IBizImpl<TechPaintTechnologyService, TechPaintTechnologyMapper, TechPaintTechnology>
   implements TechPaintTechnologyBiz {
   private final ContractProjectService projectService;
   private final PlanMonomerService monomerService;
   private final PlanAreaService areaService;
   private final MesPaintConfigService paintConfigService;
   private final TechPaintTechnologyDetailService paintTechnologyDetailService;
   private final TechPaintTechnologyArtifactLinkService paintTechnologyArtifactLinkService;
   private final TechArtifactService artifactService;
   private final MesBuildingPaintCalculateRecordService paintCalculateRecordService;

   @Override
   public PageVO<TechPaintTechnologyArtifactDTO> getUnPaintTechnologyArtifactList(
      TechPaintTechnologyArtifactQueryParam param, Integer pageNumber, Integer pageSize
   ) {
      if (param.getProjectId() == null) {
         return new PageVO<>();
      }

      Preconditions.checkArgument(param.getAreaId() == null || param.getMonomerId() != null, "未选择单体!");
      List<TechPaintTechnology> paintTechnologyList = this.baseService
         .list(Wrappers.lambdaQuery(TechPaintTechnology.class).eq(TechPaintTechnology::getProjectId, param.getProjectId()));
      boolean anyMatch = paintTechnologyList.stream().anyMatch(s -> s.getRangeTypeEnum().equals(RangeTypeEnum.PROJECT.getType()));
      if (anyMatch) {
         return new PageVO<>();
      }

      List<Long> monomerIds = paintTechnologyList.stream()
         .filter(s -> s.getRangeTypeEnum().equals(RangeTypeEnum.MONOMER.getType()))
         .map(TechPaintTechnology::getMonomerId)
         .collect(Collectors.toList());
      if (param.getMonomerId() != null && monomerIds.contains(param.getMonomerId())) {
         return new PageVO<>();
      }

      List<TechArtifact> artifactList = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getProjectId, param.getProjectId())
               .notIn(CollectionUtils.isNotEmpty(monomerIds), TechArtifact::getMonomerId, monomerIds)
               .eq(param.getMonomerId() != null, TechArtifact::getMonomerId, param.getMonomerId())
               .eq(param.getAreaId() != null, TechArtifact::getAreaId, param.getAreaId())
               .like(StringUtils.isNotBlank(param.getSerialNumber()), TechArtifact::getSerialNumber, param.getSerialNumber())
         );
      if (CollectionUtils.isNotEmpty(artifactList)) {
         List<Long> artifactIds = this.paintTechnologyArtifactLinkService
            .list(
               Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.class)
                  .eq(TechPaintTechnologyArtifactLink::getProjectId, param.getProjectId())
                  .eq(param.getMonomerId() != null, TechPaintTechnologyArtifactLink::getMonomerId, param.getMonomerId())
                  .eq(param.getAreaId() != null, TechPaintTechnologyArtifactLink::getAreaId, param.getAreaId())
            )
            .stream()
            .map(TechPaintTechnologyArtifactLink::getArtifactId)
            .collect(Collectors.toList());
         artifactList = artifactList.stream().filter(artifact -> !artifactIds.contains(artifact.getId())).collect(Collectors.toList());
      }

      if (artifactList.isEmpty()) {
         return new PageVO<>();
      }

      PageVO<TechArtifact> pageVO = PageUtil.listPage(pageNumber, pageSize, artifactList);
      List<TechPaintTechnologyArtifactDTO> dtoList = this.getArtifactResultList(
         pageVO.getContent(), param.getProjectId(), param.getMonomerId(), param.getAreaId()
      );
      PageVO<TechPaintTechnologyArtifactDTO> resultPageVO = new PageVO<>();
      resultPageVO.setContent(dtoList);
      resultPageVO.setTotalElements(pageVO.getTotalElements());
      resultPageVO.setHasNextPage(pageVO.isHasNextPage());
      resultPageVO.setHasPreviousPage(pageVO.isHasPreviousPage());
      return resultPageVO;
   }

   @Override
   public PageVO<TechPaintTechnologyProjectGroupDTO> pageList(TechPaintTechnologyQueryParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<TechPaintTechnologyProjectGroupDTO> paintTechnologyProjectGroupList = this.baseService.listPaintTechnologyGroupByProject(param);
      if (CollectionUtils.isNotEmpty(paintTechnologyProjectGroupList)) {
         List<Long> projectIds = paintTechnologyProjectGroupList.stream().map(TechPaintTechnologyProjectGroupDTO::getProjectId).collect(Collectors.toList());
         Map<Long, Map<Long, Map<Long, Integer>>> projectIdMonomerIdArtifactIdQuantityMap = this.artifactService
            .list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getProjectId, projectIds))
            .stream()
            .collect(
               Collectors.groupingBy(
                  TechArtifact::getProjectId,
                  Collectors.groupingBy(TechArtifact::getMonomerId, Collectors.toMap(TechArtifact::getId, TechArtifact::getQuantity))
               )
            );
         List<Long> paintTechnologyIds = new ArrayList<>(128);
         paintTechnologyProjectGroupList.forEach(
            cp -> paintTechnologyIds.addAll(cp.getPaintTechnologyList().stream().map(TechPaintTechnologyDTO::getId).collect(Collectors.toList()))
         );
         Map<Long, List<TechPaintTechnologyDetailDTO>> paintTechnologyIdDetailsMap = this.paintTechnologyDetailService
            .list(Wrappers.lambdaQuery(TechPaintTechnologyDetail.class).in(TechPaintTechnologyDetail::getPaintTechnologyId, paintTechnologyIds))
            .stream()
            .map(s -> BeanUtil.copy(s, TechPaintTechnologyDetailDTO.class))
            .collect(Collectors.groupingBy(TechPaintTechnologyDetailDTO::getPaintTechnologyId));
         Map<Long, List<TechPaintTechnologyArtifactLink>> paintTechnologyIdLinksMap = this.paintTechnologyArtifactLinkService
            .list(Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.class).in(TechPaintTechnologyArtifactLink::getPaintTechnologyId, paintTechnologyIds))
            .stream()
            .collect(Collectors.groupingBy(TechPaintTechnologyArtifactLink::getPaintTechnologyId));
         paintTechnologyProjectGroupList.forEach(
            project -> {
               Map<Long, Map<Long, Integer>> monomerIdArtifactIdQuantityMap = projectIdMonomerIdArtifactIdQuantityMap.getOrDefault(
                  project.getProjectId(), Collections.emptyMap()
               );
               int sum = monomerIdArtifactIdQuantityMap.values().stream().mapToInt(map -> map.values().stream().mapToInt(Integer::intValue).sum()).sum();
               project.setTotalQuantity(sum);
               project.getPaintTechnologyList()
                  .forEach(
                     dto -> {
                        if (dto.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
                           List<TechPaintTechnologyArtifactLink> links = paintTechnologyIdLinksMap.get(dto.getId());
                           int quantity = links.stream()
                              .mapToInt(
                                 link -> projectIdMonomerIdArtifactIdQuantityMap.getOrDefault(link.getProjectId(), Collections.emptyMap())
                                    .getOrDefault(link.getMonomerId(), Collections.emptyMap())
                                    .getOrDefault(link.getArtifactId(), 0)
                              )
                              .sum();
                           dto.setQuantity(quantity);
                        } else if (dto.getRangeTypeEnum().equals(RangeTypeEnum.PROJECT.getType())) {
                           dto.setQuantity(sum);
                        } else {
                           Map<Long, Integer> artifactIdQuantityMap = projectIdMonomerIdArtifactIdQuantityMap.getOrDefault(
                                 dto.getProjectId(), Collections.emptyMap()
                              )
                              .getOrDefault(dto.getMonomerId(), Collections.emptyMap());
                           int quantity = artifactIdQuantityMap.values().stream().mapToInt(Integer::intValue).sum();
                           dto.setQuantity(quantity);
                        }

                        dto.setPaintTechnologyDetailList(paintTechnologyIdDetailsMap.get(dto.getId()));
                     }
                  );
            }
         );
      }

      return new PageVO<>(paintTechnologyProjectGroupList);
   }

   @Override
   public PageVO<TechPaintTechnologyArtifactDTO> getPaintTechnologyArtifactList(
      TechPaintTechnologyArtifactQueryParam param, Integer pageNumber, Integer pageSize
   ) {
      Preconditions.checkArgument(param.getPaintTechnologyId() != null, "涂装工艺id未传值!");
      TechPaintTechnology paintTechnology = this.baseService.getById(param.getPaintTechnologyId());
      Preconditions.checkArgument(paintTechnology != null, "涂装工艺未创建!");
      List<Long> artifactIds = null;
      if (paintTechnology.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
         List<TechPaintTechnologyArtifactLink> linkList = this.paintTechnologyArtifactLinkService
            .list(
               Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.class)
                  .eq(TechPaintTechnologyArtifactLink::getPaintTechnologyId, param.getPaintTechnologyId())
                  .eq(param.getMonomerId() != null, TechPaintTechnologyArtifactLink::getMonomerId, param.getMonomerId())
                  .eq(param.getAreaId() != null, TechPaintTechnologyArtifactLink::getAreaId, param.getAreaId())
            );
         if (linkList.isEmpty()) {
            return new PageVO<>();
         }

         artifactIds = linkList.stream().map(TechPaintTechnologyArtifactLink::getArtifactId).collect(Collectors.toList());
      }

      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<TechArtifact> artifactList = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .in(artifactIds != null, TechArtifact::getId, artifactIds)
               .eq(TechArtifact::getProjectId, paintTechnology.getProjectId())
               .eq(paintTechnology.getRangeTypeEnum().equals(RangeTypeEnum.MONOMER.getType()), TechArtifact::getMonomerId, paintTechnology.getMonomerId())
               .like(StringUtils.isNotBlank(param.getSerialNumber()), TechArtifact::getSerialNumber, param.getSerialNumber())
         );
      if (artifactList.isEmpty()) {
         return new PageVO<>();
      }

      List<TechPaintTechnologyArtifactDTO> dtoList = this.getArtifactResultList(artifactList, param.getProjectId(), param.getMonomerId(), param.getAreaId());
      return new PageVO<>(page, dtoList);
   }

   @Override
   public PrintVO<List<TechPaintTechnologyArtifactDTO>> printPaintTechnologyArtifactList(Long paintTechnologyId) {
      TechPaintTechnology paintTechnology = this.baseService.getById(paintTechnologyId);
      Preconditions.checkArgument(paintTechnology != null, "涂装工艺未创建!");
      ProjectInfo projectInfo = this.projectService.getSimpleById(paintTechnology.getProjectId());
      PrintVO<List<TechPaintTechnologyArtifactDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("project", projectInfo);
      header.put("serialNumber", paintTechnology.getSerialNumber());
      header.put("createUserName", paintTechnology.getCreateUserName());
      header.put("createTime", paintTechnology.getCreateTime());
      printVO.setHeader(header);
      List<TechArtifact> artifactList;
      if (paintTechnology.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
         List<TechPaintTechnologyArtifactLink> linkList = this.paintTechnologyArtifactLinkService
            .list(
               Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.class).eq(TechPaintTechnologyArtifactLink::getPaintTechnologyId, paintTechnology.getId())
            );
         List<Long> artifactIds = linkList.stream().map(TechPaintTechnologyArtifactLink::getArtifactId).collect(Collectors.toList());
         artifactList = this.artifactService.listByIds(artifactIds);
      } else if (paintTechnology.getRangeTypeEnum().equals(RangeTypeEnum.PROJECT.getType())) {
         artifactList = this.artifactService.list(Wrappers.lambdaQuery(TechArtifact.builder().projectId(paintTechnology.getProjectId()).build()));
      } else {
         artifactList = this.artifactService.list(Wrappers.lambdaQuery(TechArtifact.builder().monomerId(paintTechnology.getMonomerId()).build()));
      }

      List<TechPaintTechnologyArtifactDTO> artifactResultList = this.getArtifactResultList(artifactList, paintTechnology.getProjectId(), null, null);
      printVO.setTable(artifactResultList);
      return printVO;
   }

   @Override
   public List<TechPaintTechnologyDTO> getProjectPaintTechnologyList(Long projectId) {
      List<TechPaintTechnology> paintTechnologyList = this.baseService.list(Wrappers.lambdaQuery(TechPaintTechnology.builder().projectId(projectId).build()));
      if (paintTechnologyList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, List<TechPaintTechnologyDetail>> paintTechnologyIdDetailsMap = this.paintTechnologyDetailService
         .list(
            Wrappers.lambdaQuery(TechPaintTechnologyDetail.class)
               .in(TechPaintTechnologyDetail::getPaintTechnologyId, paintTechnologyList.stream().map(TechPaintTechnology::getId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.groupingBy(TechPaintTechnologyDetail::getPaintTechnologyId));
      List<TechPaintTechnologyDTO> dtoList = new ArrayList<>(paintTechnologyList.size());
      paintTechnologyList.forEach(
         paintTechnology -> {
            TechPaintTechnologyDTO paintTechnologyDTO = BeanUtil.copy(paintTechnology, TechPaintTechnologyDTO.class);
            List<TechPaintTechnologyDetail> paintTechnologyDetailList = paintTechnologyIdDetailsMap.get(paintTechnology.getId());
            List<TechPaintTechnologyDetailDTO> detailDTOList = paintTechnologyDetailList.stream()
               .map(detail -> BeanUtil.copy(detail, TechPaintTechnologyDetailDTO.class))
               .collect(Collectors.toList());
            paintTechnologyDTO.setPaintTechnologyDetailList(detailDTOList);
            dtoList.add(paintTechnologyDTO);
         }
      );
      return dtoList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePaintTechnology(TechPaintTechnologySaveParam param) {
      if (param.getId() != null) {
         TechPaintTechnology paintTechnology = this.baseService.getById(param.getId() != null);
         Preconditions.checkArgument(paintTechnology != null, "选择涂装工艺不存在!");
         Preconditions.checkArgument(paintTechnology.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType()), "选择涂装工艺有误!");
         Preconditions.checkArgument(
            StringUtils.isBlank(param.getSerialNumber()) || paintTechnology.getSerialNumber().equals(param.getSerialNumber()), "工艺编号有误!"
         );
         this.checkManualRangeType(paintTechnology.getProjectId(), param.getArtifactIdList(), null);
         this.saveLink(param.getId(), paintTechnology.getProjectId(), param.getArtifactIdList());
      } else {
         Preconditions.checkArgument(StringUtils.isNotBlank(param.getSerialNumber()), "工艺编号不能为空!");
         long count = this.baseService
            .count(
               Wrappers.lambdaQuery(TechPaintTechnology.class)
                  .eq(TechPaintTechnology::getProjectId, param.getProjectId())
                  .eq(TechPaintTechnology::getSerialNumber, param.getSerialNumber())
            );
         Preconditions.checkArgument(count == 0L, "同一项目下,涂装工艺编号不能重复!");
         this.checkPaintType(param.getPaintTechnologyDetailList());
         if (param.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
            this.checkManualRangeType(param.getProjectId(), param.getArtifactIdList(), null);
         } else if (param.getRangeTypeEnum().equals(RangeTypeEnum.PROJECT.getType())) {
            this.checkProjectRangeType(param.getProjectId(), null);
         } else {
            this.checkMonomerRangeType(param.getProjectId(), param.getMonomerId(), null);
         }

         TechPaintTechnology paintTechnology = BeanUtil.copy(param, TechPaintTechnology.class);
         paintTechnology.setCreateUserId(UserUtil.getCurrentUserId());
         paintTechnology.setCreateUserName(UserUtil.getCurrentName());
         this.baseService.save(paintTechnology);
         this.saveDetail(paintTechnology.getId(), null, param.getPaintTechnologyDetailList());
         if (param.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
            this.saveLink(paintTechnology.getId(), param.getProjectId(), param.getArtifactIdList());
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updatePaintTechnology(TechPaintTechnologyUpdateParam param) {
      TechPaintTechnology paintTechnology = this.baseService.getById(param.getId());
      Preconditions.checkArgument(paintTechnology != null, "涂装工艺不存在!");
      if (!param.getSerialNumber().equals(paintTechnology.getSerialNumber())) {
         long count = this.baseService
            .count(Wrappers.lambdaQuery(TechPaintTechnology.builder().projectId(paintTechnology.getProjectId()).serialNumber(param.getSerialNumber()).build()));
         Preconditions.checkArgument(count == 0L, "同一项目下,涂装工艺编号不能重复!");
      }

      if (!param.getRangeTypeEnum().equals(paintTechnology.getRangeTypeEnum())) {
         if (param.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
            this.checkManualRangeType(paintTechnology.getProjectId(), param.getArtifactIdList(), param.getId());
         }

         if (param.getRangeTypeEnum().equals(RangeTypeEnum.PROJECT.getType())) {
            this.checkProjectRangeType(paintTechnology.getProjectId(), param.getId());
         }

         if (param.getRangeTypeEnum().equals(RangeTypeEnum.MONOMER.getType())) {
            this.checkMonomerRangeType(paintTechnology.getProjectId(), param.getMonomerId(), param.getId());
         }
      } else if (param.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
         this.checkManualRangeType(paintTechnology.getProjectId(), param.getArtifactIdList(), param.getId());
      } else if (param.getRangeTypeEnum().equals(RangeTypeEnum.MONOMER.getType())) {
         this.checkMonomerRangeType(paintTechnology.getProjectId(), param.getMonomerId(), param.getId());
      }

      this.checkPaintType(param.getPaintTechnologyDetailList());
      List<TechPaintTechnologyDetail> paintTechnologyDetailList = this.paintTechnologyDetailService
         .list(Wrappers.lambdaQuery(TechPaintTechnologyDetail.class).eq(TechPaintTechnologyDetail::getPaintTechnologyId, param.getId()));
      List<MesBuildingPaintCalculateRecord> paintCalculateRecordList = this.paintCalculateRecordService
         .list(Wrappers.lambdaQuery(MesBuildingPaintCalculateRecord.class).eq(MesBuildingPaintCalculateRecord::getPaintTechnologyId, param.getId()));
      if (CollectionUtils.isNotEmpty(paintCalculateRecordList)) {
         Preconditions.checkArgument(param.getRangeTypeEnum().equals(paintTechnology.getRangeTypeEnum()), "油漆用量已计算!");
         if (param.getRangeTypeEnum().equals(RangeTypeEnum.MONOMER.getType())) {
            Preconditions.checkArgument(param.getMonomerId().equals(paintTechnology.getMonomerId()), "油漆用量已计算!");
         }

         if (param.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
            Set<Long> oldArtifactList = this.paintTechnologyArtifactLinkService
               .list(Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.class).eq(TechPaintTechnologyArtifactLink::getPaintTechnologyId, param.getId()))
               .stream()
               .map(TechPaintTechnologyArtifactLink::getArtifactId)
               .collect(Collectors.toSet());
            Preconditions.checkArgument(oldArtifactList.size() == param.getArtifactIdList().size(), "油漆用量已计算!");
            Preconditions.checkArgument(oldArtifactList.containsAll(param.getArtifactIdList()), "油漆用量已计算!");
            Preconditions.checkArgument(param.getArtifactIdList().containsAll(oldArtifactList), "油漆用量已计算!");
         }

         Preconditions.checkArgument(param.getPaintTechnologyDetailList().size() == paintTechnologyDetailList.size(), "油漆用量已计算!");
         Map<Integer, TechPaintTechnologyDetail> paintingTypeEnumDetailMap = paintTechnologyDetailList.stream()
            .collect(Collectors.toMap(TechPaintTechnologyDetail::getPaintingTypeEnum, Function.identity()));
         Map<Integer, TechPaintTechnologyDetailParam> paintingTypeEnumDetailParamMap = param.getPaintTechnologyDetailList()
            .stream()
            .collect(Collectors.toMap(TechPaintTechnologyDetailParam::getPaintingTypeEnum, Function.identity()));
         Preconditions.checkArgument(paintingTypeEnumDetailMap.keySet().containsAll(paintingTypeEnumDetailParamMap.keySet()), "油漆用量已计算!");
         Preconditions.checkArgument(paintingTypeEnumDetailParamMap.keySet().containsAll(paintingTypeEnumDetailMap.keySet()), "油漆用量已计算!");
         paintingTypeEnumDetailMap.forEach((paintingTypeEnum, detail) -> {
            TechPaintTechnologyDetailParam detailParam = paintingTypeEnumDetailParamMap.get(paintingTypeEnum);
            Preconditions.checkArgument(detailParam.getPaintConfigId().equals(detail.getPaintConfigId()), "油漆用量已计算!");
            Preconditions.checkArgument(detailParam.getPaintColor().equals(detail.getPaintColor()), "油漆用量已计算!");
            Preconditions.checkArgument(detailParam.getPaintFilmThickness().compareTo(detail.getPaintFilmThickness()) == 0, "油漆用量已计算!");
         });
      }

      BeanUtil.copy(param, paintTechnology);
      this.baseService.updateById(paintTechnology);
      this.paintTechnologyDetailService.remove(Wrappers.lambdaQuery(TechPaintTechnologyDetail.builder().paintTechnologyId(param.getId()).build()));
      this.saveDetail(param.getId(), paintTechnologyDetailList, param.getPaintTechnologyDetailList());
      this.paintTechnologyArtifactLinkService.remove(Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.builder().paintTechnologyId(param.getId()).build()));
      if (param.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
         this.saveLink(param.getId(), paintTechnology.getProjectId(), param.getArtifactIdList());
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean removePaintTechnology(Long id) {
      TechPaintTechnology paintTechnology = this.baseService.getById(id);
      Preconditions.checkArgument(paintTechnology != null, "涂装工艺未创建!");
      List<MesBuildingPaintCalculateRecord> paintCalculateRecordList = this.paintCalculateRecordService
         .list(Wrappers.lambdaQuery(MesBuildingPaintCalculateRecord.class).eq(MesBuildingPaintCalculateRecord::getPaintTechnologyId, id));
      Preconditions.checkArgument(paintCalculateRecordList.isEmpty(), "涂装工艺已被引用!");
      this.paintTechnologyDetailService.remove(Wrappers.lambdaQuery(TechPaintTechnologyDetail.builder().paintTechnologyId(id).build()));
      if (paintTechnology.getRangeTypeEnum().equals(RangeTypeEnum.MANUAL.getType())) {
         this.paintTechnologyArtifactLinkService.remove(Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.builder().paintTechnologyId(id).build()));
      }

      this.baseService.removeById(id);
      return true;
   }

   private List<TechPaintTechnologyArtifactDTO> getArtifactResultList(List<TechArtifact> artifactList, Long projectId, Long monomerId, Long areaId) {
      Map<Long, NameInfo> monomerMap = this.monomerService
         .list(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId).eq(monomerId != null, PlanMonomer::getId, monomerId))
         .stream()
         .map(monomer -> NameInfo.builder().id(monomer.getId()).name(monomer.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      Map<Long, NameInfo> areaMap = this.areaService
         .list(
            Wrappers.lambdaQuery(PlanArea.class)
               .eq(PlanArea::getProjectId, projectId)
               .eq(monomerId != null, PlanArea::getMonomerId, monomerId)
               .eq(areaId != null, PlanArea::getId, areaId)
         )
         .stream()
         .map(area -> NameInfo.builder().id(area.getId()).name(area.getName()).build())
         .collect(Collectors.toMap(NameInfo::getId, Function.identity()));
      List<TechPaintTechnologyArtifactDTO> dtoList = new ArrayList<>(artifactList.size());
      artifactList.forEach(
         artifact -> {
            TechPaintTechnologyArtifactDTO dto = BeanUtil.copy(artifact, TechPaintTechnologyArtifactDTO.class);
            dto.setArtifactId(artifact.getId());
            dto.setMonomer(monomerMap.get(artifact.getMonomerId()));
            dto.setArea(areaMap.get(artifact.getAreaId()));
            dto.setSurfaceArea(artifact.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP));
            dto.setTotalArea(
               artifact.getSurfaceArea()
                  .multiply(BigDecimal.valueOf(artifact.getQuantity().intValue()))
                  .divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP)
            );
            dtoList.add(dto);
         }
      );
      return dtoList;
   }

   private void checkManualRangeType(Long projectId, Set<Long> artifactIds, Long paintTechnologyId) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactIds), "未选择构件!!");
      long count = this.baseService
         .count(
            Wrappers.lambdaQuery(TechPaintTechnology.class)
               .eq(TechPaintTechnology::getRangeTypeEnum, RangeTypeEnum.PROJECT.getType())
               .eq(TechPaintTechnology::getProjectId, projectId)
               .ne(paintTechnologyId != null, TechPaintTechnology::getId, paintTechnologyId)
         );
      Preconditions.checkArgument(count == 0L, "已存在整个项目的涂装工艺!");
      List<TechArtifact> artifactList = this.artifactService
         .list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getId, artifactIds).eq(TechArtifact::getProjectId, projectId));
      Preconditions.checkArgument(artifactList.size() == artifactIds.size(), "构件列表选择有误!");
      Set<Long> projectIds = artifactList.stream().map(TechArtifact::getProjectId).collect(Collectors.toSet());
      Preconditions.checkArgument(projectIds.size() == 1 && projectIds.iterator().next().equals(projectId), "构件列表选择有误!");
      Set<Long> monomerIds = artifactList.stream().map(TechArtifact::getMonomerId).collect(Collectors.toSet());
      count = this.baseService
         .count(
            Wrappers.lambdaQuery(TechPaintTechnology.class)
               .eq(TechPaintTechnology::getRangeTypeEnum, RangeTypeEnum.MONOMER.getType())
               .in(TechPaintTechnology::getMonomerId, monomerIds)
               .ne(paintTechnologyId != null, TechPaintTechnology::getId, paintTechnologyId)
         );
      Preconditions.checkArgument(count == 0L, "选择构件已创建整个单体的涂装工艺!");
      count = this.paintTechnologyArtifactLinkService
         .count(
            Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.class)
               .in(TechPaintTechnologyArtifactLink::getArtifactId, artifactIds)
               .ne(paintTechnologyId != null, TechPaintTechnologyArtifactLink::getPaintTechnologyId, paintTechnologyId)
         );
      Preconditions.checkArgument(count == 0L, "选择构件已创建涂装工艺!");
   }

   private void checkProjectRangeType(Long projectId, Long paintTechnologyId) {
      long count = this.baseService
         .count(
            Wrappers.lambdaQuery(TechPaintTechnology.class)
               .eq(TechPaintTechnology::getProjectId, projectId)
               .ne(paintTechnologyId != null, TechPaintTechnology::getId, paintTechnologyId)
         );
      Preconditions.checkArgument(count == 0L, "该项目已创建涂装工艺!");
   }

   private void checkMonomerRangeType(Long projectId, Long monomerId, Long paintTechnologyId) {
      Preconditions.checkArgument(monomerId != null, "未选择单体!");
      PlanMonomer monomer = this.monomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "选择单体不存在!");
      Preconditions.checkArgument(monomer.getProjectId().equals(projectId), "选择单体有误!");
      long count = this.baseService
         .count(
            Wrappers.lambdaQuery(TechPaintTechnology.class)
               .eq(TechPaintTechnology::getRangeTypeEnum, RangeTypeEnum.PROJECT.getType())
               .eq(TechPaintTechnology::getProjectId, projectId)
               .ne(paintTechnologyId != null, TechPaintTechnology::getId, paintTechnologyId)
         );
      Preconditions.checkArgument(count == 0L, "已创建整个项目的涂装工艺!");
      count = this.baseService
         .count(
            Wrappers.lambdaQuery(TechPaintTechnology.class)
               .eq(TechPaintTechnology::getRangeTypeEnum, RangeTypeEnum.MONOMER.getType())
               .eq(TechPaintTechnology::getMonomerId, monomerId)
               .ne(paintTechnologyId != null, TechPaintTechnology::getId, paintTechnologyId)
         );
      Preconditions.checkArgument(count == 0L, "已创建整个单体的涂装工艺!");
      count = this.paintTechnologyArtifactLinkService
         .count(
            Wrappers.lambdaQuery(TechPaintTechnologyArtifactLink.class)
               .eq(TechPaintTechnologyArtifactLink::getMonomerId, monomerId)
               .ne(paintTechnologyId != null, TechPaintTechnologyArtifactLink::getPaintTechnologyId, paintTechnologyId)
         );
      Preconditions.checkArgument(count == 0L, "该单体构件已创建涂装工艺!");
   }

   private void checkPaintType(Collection<TechPaintTechnologyDetailParam> paintTechnologyDetailList) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(paintTechnologyDetailList), "油漆类型列表不能为空!");
      Map<Integer, List<TechPaintTechnologyDetailParam>> paintingTypeEnumListMap = paintTechnologyDetailList.stream()
         .collect(Collectors.groupingBy(TechPaintTechnologyDetailParam::getPaintingTypeEnum));
      Preconditions.checkArgument(paintingTypeEnumListMap.containsKey(PaintingTypeEnum.PRIMER.getType()), "喷漆类型未包含底漆!");
      Preconditions.checkArgument(paintingTypeEnumListMap.values().stream().allMatch(s -> s.size() == 1), "喷漆类型出现重复!");
   }

   private void saveLink(Long paintTechnologyId, Long projectId, Set<Long> artifactIds) {
      List<TechArtifact> artifactList = this.artifactService
         .list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getId, artifactIds).eq(TechArtifact::getProjectId, projectId));
      List<TechPaintTechnologyArtifactLink> newLinks = new ArrayList<>(artifactIds.size());
      artifactList.forEach(
         artifact -> {
            TechPaintTechnologyArtifactLink link = TechPaintTechnologyArtifactLink.builder()
               .paintTechnologyId(paintTechnologyId)
               .artifactId(artifact.getId())
               .projectId(artifact.getProjectId())
               .monomerId(artifact.getMonomerId())
               .areaId(artifact.getAreaId())
               .build();
            newLinks.add(link);
         }
      );
      this.paintTechnologyArtifactLinkService.saveBatch(newLinks);
   }

   private void saveDetail(
      Long paintTechnologyId,
      List<TechPaintTechnologyDetail> paintTechnologyDetailList,
      Collection<TechPaintTechnologyDetailParam> paintTechnologyDetailParamList
   ) {
      List<TechPaintTechnologyDetail> paintTechnologyDetails = new ArrayList<>(16);
      Map<Integer, TechPaintTechnologyDetail> oldPaintingTypeEnumDetailMap = new HashMap<>(16);
      if (CollectionUtils.isNotEmpty(paintTechnologyDetailList)) {
         Map<Integer, TechPaintTechnologyDetail> collect = paintTechnologyDetailList.stream()
            .collect(Collectors.toMap(TechPaintTechnologyDetail::getPaintingTypeEnum, Function.identity()));
         oldPaintingTypeEnumDetailMap.putAll(collect);
      }

      paintTechnologyDetailParamList.forEach(s -> {
         TechPaintTechnologyDetail craftDetail = BeanUtil.copy(s, TechPaintTechnologyDetail.class);
         craftDetail.setPaintTechnologyId(paintTechnologyId);
         TechPaintTechnologyDetail detail = oldPaintingTypeEnumDetailMap.get(s.getPaintingTypeEnum());
         if (detail != null && detail.getPaintConfigId().equals(s.getPaintConfigId())) {
            craftDetail.setPaintType(detail.getPaintType());
            craftDetail.setPaintBrand(detail.getPaintBrand());
         } else {
            MesPaintConfig paintConfig = this.paintConfigService.getById(s.getPaintConfigId());
            Preconditions.checkArgument(paintConfig != null, "油漆配置不存在!");
            Preconditions.checkArgument(s.getPaintingTypeEnum().equals(paintConfig.getPaintingTypeEnum()), "喷漆配置类型有误!");
            craftDetail.setPaintType(paintConfig.getPaintType());
            craftDetail.setPaintBrand(paintConfig.getPaintBrand());
         }

         paintTechnologyDetails.add(craftDetail);
      });
      this.paintTechnologyDetailService.saveBatch(paintTechnologyDetails);
   }

   public TechPaintTechnologyBizImpl(
      final ContractProjectService projectService,
      final PlanMonomerService monomerService,
      final PlanAreaService areaService,
      final MesPaintConfigService paintConfigService,
      final TechPaintTechnologyDetailService paintTechnologyDetailService,
      final TechPaintTechnologyArtifactLinkService paintTechnologyArtifactLinkService,
      final TechArtifactService artifactService,
      final MesBuildingPaintCalculateRecordService paintCalculateRecordService
   ) {
      this.projectService = projectService;
      this.monomerService = monomerService;
      this.areaService = areaService;
      this.paintConfigService = paintConfigService;
      this.paintTechnologyDetailService = paintTechnologyDetailService;
      this.paintTechnologyArtifactLinkService = paintTechnologyArtifactLinkService;
      this.artifactService = artifactService;
      this.paintCalculateRecordService = paintCalculateRecordService;
   }
}
