package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfig;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigBasicDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspectConfigMapper extends BaseMapper<MesInspectConfig> {
   List<MesBuildingTeamUserLink> findTeamIdByInspectUserId(Long inpectUserid);

   List<MesInspectConfigDTO> findAllConfig(MesInspectConfigDTO inspectConfig);

   List<MesInspectConfig> queryInspectConfig(
      @Param("workshopId") Long workshopId, @Param("processId") Long processId, @Param("classId") Long classId, @Param("teamId") Long teamId
   );

   List<MesInspectConfig> selectCurrentUserIsInspectUser(
      @Param("workshopId") Long workshopId, @Param("processId") Long processId, @Param("classId") Long classId, @Param("userId") Long userId
   );

   List<MesInspectConfig> findInspectByUserIdAndProcessId(
      @Param("inspectUserIds") List<Long> inspectUserIds,
      @Param("teamLink") List<Long> teamLink,
      @Param("workshopId") Long workshopId,
      @Param("processId") Long processId,
      @Param("id") Long id,
      @Param("artifactType") Integer artifactType,
      @Param("mesProductEnum") Integer mesProductEnum
   );

   List<MesInspectConfig> queryInspectConfigByCondition(@Param("config") MesInspectConfig config, @Param("teamId") Long teamId, @Param("classId") Long classId);

   List<MesInspectConfigBasicDTO> queryAllInspectConfigList();
}
