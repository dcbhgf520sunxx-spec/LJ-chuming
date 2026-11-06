package com.hzchum.scim.plan.core.biz.impl.production_scheduling;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.plan.core.api.biz.production_scheduling.ListSchedulingBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.ListSchedulingProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.ListSchedulingWorkshopDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.ListSchedulingWorkshopSchedulingDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling.NotSchedulingArtifactDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.production_scheduling.ListSchedulingSaveParam;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.mapper.production_scheduling.ListSchedulingMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListSchedulingBizImpl implements ListSchedulingBiz {
   @Autowired
   private ListSchedulingMapper listSchedulingMapper;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechArtifactExtService artifactExtService;

   @Override
   public PageVO<ListSchedulingProjectDTO> projectList(
      Integer year, Integer schedulingStatus, Long projectNoOrName, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ListSchedulingProjectDTO> list = this.listSchedulingMapper.projectList(year, schedulingStatus, projectNoOrName);
      return new PageVO<>(page, list);
   }

   @Override
   public List<ListSchedulingWorkshopDTO> workshopList(Long projectId) {
      return this.listSchedulingMapper.workshopList(projectId, this.getListTotalWeightByProjectId(projectId));
   }

   @Override
   public PageVO<ListSchedulingWorkshopSchedulingDetailDTO> workshopSchedulingDetailPage(
      Long projectId, Integer productionWay, Long workshopId, Boolean boolScheduling, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      if (productionWay.equals(1)) {
         Preconditions.checkArgument(workshopId != null, "车间不能为空");
      }

      if (productionWay.equals(2)) {
         workshopId = null;
      }

      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ListSchedulingWorkshopSchedulingDetailDTO> list = this.listSchedulingMapper
         .workshopSchedulingDetailList(projectId, productionWay, workshopId, boolScheduling);
      return new PageVO<>(page, list);
   }

   @Override
   public PageVO<NotSchedulingArtifactDTO> notSchedulingList(
      Long projectId, Long monomerId, Long areaId, Long artifactClassId, Long artifactNoOrName, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<NotSchedulingArtifactDTO> list = this.listSchedulingMapper.notSchedulingList(projectId, monomerId, areaId, artifactClassId, artifactNoOrName);
      return new PageVO<>(page, list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSave(List<ListSchedulingSaveParam> params) {
      List<Long> artifactIds = CollUtil.getFieldValues(params, "artifactId", Long.class);
      Map<Long, List<TechArtifactExt>> artifactExtGroup = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .eq(TechArtifactExt::getBoolBeforehandScheduling, false)
               .in(TechArtifactExt::getArtifactId, artifactIds)
               .orderByAsc(TechArtifactExt::getSortNumber)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifactExt> updateList = params.stream()
         .map(
            param -> {
               List<TechArtifactExt> artifactExtList = artifactExtGroup.get(param.getArtifactId());
               Preconditions.checkArgument(
                  CollUtil.isNotEmpty(artifactExtList), "构件: " + param.getArtifactName() + "(" + param.getArtifactSerialNumber() + ")不存在, 刷新后重试"
               );
               Preconditions.checkArgument(
                  artifactExtList.size() >= param.getQuantity(), "构件: " + param.getArtifactName() + "(" + param.getArtifactSerialNumber() + "), 数量不能大于未预排期数量"
               );
               return CollUtil.sub(artifactExtList, 0, param.getQuantity())
                  .stream()
                  .map(
                     ae -> TechArtifactExt.builder()
                        .id(ae.getId())
                        .boolBeforehandScheduling(true)
                        .productionWay(param.getProductionWay())
                        .workshopId(param.getWorkshopId())
                        .completeDate(param.getCompleteDate())
                        .build()
                  )
                  .collect(Collectors.toList());
            }
         )
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      this.artifactExtService.updateBatchById(updateList);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean beforehandSchedulingBatchUpdate(List<ListSchedulingSaveParam> params) {
      List<Long> artifactIds = params.stream().map(ListSchedulingSaveParam::getArtifactId).collect(Collectors.toList());
      Map<Long, List<TechArtifactExt>> artifactExtGroup = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .eq(TechArtifactExt::getBoolScheduling, false)
               .eq(TechArtifactExt::getBoolBeforehandScheduling, true)
               .in(TechArtifactExt::getArtifactId, artifactIds)
               .orderByAsc(TechArtifactExt::getSortNumber)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifactExt> updateList = params.stream()
         .map(
            param -> {
               List<TechArtifactExt> artifactExtList = artifactExtGroup.get(param.getArtifactId());
               Preconditions.checkArgument(
                  CollUtil.isNotEmpty(artifactExtList), "构件: " + param.getArtifactName() + "(" + param.getArtifactSerialNumber() + ")不存在, 刷新后重试"
               );
               Preconditions.checkArgument(
                  artifactExtList.size() >= param.getQuantity(), "构件: " + param.getArtifactName() + "(" + param.getArtifactSerialNumber() + "), 数量超出, 刷新后重试"
               );
               List<TechArtifactExt> changeList = CollUtil.sub(artifactExtList, 0, param.getQuantity())
                  .stream()
                  .map(ae -> TechArtifactExt.builder().id(ae.getId()).workshopId(param.getWorkshopId()).completeDate(param.getCompleteDate()).build())
                  .collect(Collectors.toList());
               List<Long> usedArtifactExtIds = changeList.stream().map(TechArtifactExt::getId).collect(Collectors.toList());
               List<TechArtifactExt> unusedList = artifactExtList.stream()
                  .filter(artifactExt -> !usedArtifactExtIds.contains(artifactExt.getId()))
                  .collect(Collectors.toList());
               artifactExtGroup.put(param.getArtifactId(), unusedList);
               return changeList;
            }
         )
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      this.artifactExtService.updateBatchById(updateList);
      return true;
   }

   private BigDecimal getListTotalWeightByProjectId(Long projectId) {
      return this.artifactService
         .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getProjectId, projectId))
         .stream()
         .map(TechArtifact::getTotalNetWeight)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .setScale(2, RoundingMode.HALF_UP);
   }
}
