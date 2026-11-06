package com.hzchum.scim.mes.building.core.api.service.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactNoSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingGroupSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactTypeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingDOParam;
import java.util.List;
import java.util.Map;

public interface MesBuildingArtifactSchedulingService extends IService<MesBuildingArtifactScheduling> {
   List<MesBuildingArtifactSchedulingDO> artifactByConditionList(MesBuildingArtifactSchedulingDOParam doParam);

   MesBuildingArtifactSchedulingSummaryDO artifactByConditionSummary(MesBuildingArtifactSchedulingDOParam doParam);

   List<Integer> getProductionLineTypeList(MesBuildingArtifactSchedulingDOParam copy);

   List<MesBuildingArtifactTypeDO> getArtifactTypeList(MesBuildingArtifactSchedulingDOParam doParam);

   List<MesBuildingArtifactTypeDO> getArtifactNameList(MesBuildingArtifactSchedulingDOParam doParam);

   List<MesBuildingArtifactSchedulingDO> getArtifactSchedulingRecordList(MesBuildingArtifactSchedulingDOParam doParam);

   List<MesBuildingArtifactSchedulingDO> getArtifactSchedulingRecordList2(MesBuildingArtifactSchedulingDOParam doParam);

   List<MesBuildingArtifactSchedulingDO> getArtifactSchedulingRecordListV8(MesBuildingArtifactSchedulingDOParam doParam);

   MesBuildingArtifactSchedulingSummaryDO getArtifactSchedulingRecordSummary(MesBuildingArtifactSchedulingDOParam doParam);

   MesBuildingArtifactSchedulingSummaryDO getArtifactSchedulingRecordSummary2(MesBuildingArtifactSchedulingDOParam doParam);

   List<MesBuildingArtifactSchedulingGroupSummaryDO> getGroupsRecordSummary(MesBuildingArtifactSchedulingDOParam copy);

   List<MesBuildingArtifactTypeDO> getArtifactRecordTypeList(MesBuildingArtifactSchedulingDOParam doParam);

   List<MesBuildingArtifactTypeDO> getArtifactRecordTypeListV8(MesBuildingArtifactSchedulingDOParam doParam);

   List<MesBuildingArtifactTypeDO> getArtifactRecordNameList(MesBuildingArtifactSchedulingDOParam doParam);

   List<Long> getRecordProductionLineTypeList(MesBuildingArtifactSchedulingDOParam copy);

   List<Boolean> getArtifactRecordProductionTypeList(MesBuildingArtifactSchedulingDOParam doParam);

   Map<Long, Integer> getSchedulingQuantityMap(Long areaId);

   List<MesBuildingArtifactNoSchedulingDO> listArtifactNoSchedulingByCondition(
      Long projectId, Long monomerId, Long areaId, String name, String serialNumber, String specification, String material, Long structureClassId
   );
}
