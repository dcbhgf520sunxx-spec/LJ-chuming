package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingCloudcutJob;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingCloudcutJobDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling.MesBuildingCloudcutJobVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingCloudcutJobMapper extends BaseMapper<MesBuildingCloudcutJob> {
   List<MesBuildingCloudcutJobVO> pageMesBuildingCloudcutJob(@Param("mesBuildingCloudcutJobDTO") MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO);

   List<MesBuildingCloudcutJobVO> teamList();
}
