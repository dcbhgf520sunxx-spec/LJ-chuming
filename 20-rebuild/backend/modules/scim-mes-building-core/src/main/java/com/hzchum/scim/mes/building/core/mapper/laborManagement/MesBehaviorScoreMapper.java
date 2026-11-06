package com.hzchum.scim.mes.building.core.mapper.laborManagement;

import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesBehaviorScoreDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.ViolationRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesBehaviorScoreQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBehaviorScoreMapper {
   List<MesBehaviorScoreDTO> listInfo(MesBehaviorScoreQuery query);

   List<ViolationRecordDTO> violationRecord(@Param("userId") Long userId, @Param("year") Integer year);
}
