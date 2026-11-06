package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactNoSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingGroupSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactTypeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.TeamScheduledInfoDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingArtifactSchedulingMapper extends BaseMapper<MesBuildingArtifactScheduling> {
   List<MesBuildingArtifactSchedulingDO> artifactByConditionList(MesBuildingArtifactSchedulingDOParam doParam);

   MesBuildingArtifactSchedulingSummaryDO artifactByConditionSummary(MesBuildingArtifactSchedulingDOParam doParam);

   List<Integer> getProductionLineTypeList(MesBuildingArtifactSchedulingDOParam doParam);

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

   List<Long> getRecordProductionLineTypeList(MesBuildingArtifactSchedulingDOParam copy);

   List<Boolean> getArtifactRecordProductionTypeList(MesBuildingArtifactSchedulingDOParam doParam);

   List<MesBuildingArtifactNoSchedulingDO> getArtifactNoSchedulingByConditionList(
      Long projectId, Long monomerId, Long areaId, String name, String serialNumber, String specification, String material, Long structureClassId
   );

   List<TeamScheduledInfoDTO> findTeamScheduledQuantity(@Param("workshopId") Long workshopId, @Param("projectId") Long projectId);

   List<MesBuildingArtifactTypeDO> getArtifactRecordNameList(MesBuildingArtifactSchedulingDOParam doParam);
}
