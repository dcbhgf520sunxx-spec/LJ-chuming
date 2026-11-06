package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactNoSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingGroupSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactTypeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingArtifactSchedulingMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingArtifactSchedulingServiceImpl
   extends ServiceImpl<MesBuildingArtifactSchedulingMapper, MesBuildingArtifactScheduling>
   implements MesBuildingArtifactSchedulingService {
   @Override
   public List<MesBuildingArtifactSchedulingDO> artifactByConditionList(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.artifactByConditionList(doParam);
   }

   @Override
   public MesBuildingArtifactSchedulingSummaryDO artifactByConditionSummary(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.artifactByConditionSummary(doParam);
   }

   @Override
   public List<Integer> getProductionLineTypeList(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getProductionLineTypeList(doParam);
   }

   @Override
   public List<MesBuildingArtifactTypeDO> getArtifactTypeList(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactTypeList(doParam);
   }

   @Override
   public List<MesBuildingArtifactTypeDO> getArtifactNameList(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactNameList(doParam);
   }

   @Override
   public List<MesBuildingArtifactSchedulingDO> getArtifactSchedulingRecordList(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactSchedulingRecordList(doParam);
   }

   @Override
   public List<MesBuildingArtifactSchedulingDO> getArtifactSchedulingRecordList2(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactSchedulingRecordList2(doParam);
   }

   @Override
   public List<MesBuildingArtifactSchedulingDO> getArtifactSchedulingRecordListV8(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactSchedulingRecordListV8(doParam);
   }

   @Override
   public MesBuildingArtifactSchedulingSummaryDO getArtifactSchedulingRecordSummary(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactSchedulingRecordSummary(doParam);
   }

   @Override
   public MesBuildingArtifactSchedulingSummaryDO getArtifactSchedulingRecordSummary2(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactSchedulingRecordSummary2(doParam);
   }

   @Override
   public List<MesBuildingArtifactSchedulingGroupSummaryDO> getGroupsRecordSummary(MesBuildingArtifactSchedulingDOParam copy) {
      return this.baseMapper.getGroupsRecordSummary(copy);
   }

   @Override
   public List<MesBuildingArtifactTypeDO> getArtifactRecordTypeList(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactRecordTypeList(doParam);
   }

   @Override
   public List<MesBuildingArtifactTypeDO> getArtifactRecordTypeListV8(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactRecordTypeListV8(doParam);
   }

   @Override
   public List<MesBuildingArtifactTypeDO> getArtifactRecordNameList(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactRecordNameList(doParam);
   }

   @Override
   public List<Long> getRecordProductionLineTypeList(MesBuildingArtifactSchedulingDOParam copy) {
      return this.baseMapper.getRecordProductionLineTypeList(copy);
   }

   @Override
   public List<Boolean> getArtifactRecordProductionTypeList(MesBuildingArtifactSchedulingDOParam doParam) {
      return this.baseMapper.getArtifactRecordProductionTypeList(doParam);
   }

   @Override
   public Map<Long, Integer> getSchedulingQuantityMap(Long areaId) {
      Map<Long, List<MesBuildingArtifactScheduling>> listMap = this.baseMapper
         .selectList(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.builder().areaId(areaId).build()))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingArtifactScheduling::getProductId));
      Map<Long, Integer> map = new HashMap<>(1024);
      listMap.forEach((id, list) -> {
         int sum = list.stream().mapToInt(MesBuildingArtifactScheduling::getQuantity).sum();
         map.put(id, sum);
      });
      return map;
   }

   @Override
   public List<MesBuildingArtifactNoSchedulingDO> listArtifactNoSchedulingByCondition(
      Long projectId, Long monomerId, Long areaId, String name, String serialNumber, String specification, String material, Long structureClassId
   ) {
      return this.baseMapper
         .getArtifactNoSchedulingByConditionList(projectId, monomerId, areaId, name, serialNumber, specification, material, structureClassId);
   }
}
