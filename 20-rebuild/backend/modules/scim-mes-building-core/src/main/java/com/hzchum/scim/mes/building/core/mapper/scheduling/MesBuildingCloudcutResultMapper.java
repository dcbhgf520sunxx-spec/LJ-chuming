package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingCloudcutResult;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingCloudcutResultDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling.MesBuildingCloudcutResultVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingCloudcutResultMapper extends BaseMapper<MesBuildingCloudcutResult> {
   List<MesBuildingCloudcutResultVO> pageMesBuildingCloudcutResult(
      @Param("mesBuildingCloudcutResultDTO") MesBuildingCloudcutResultDTO mesBuildingCloudcutResultDTO
   );
}
