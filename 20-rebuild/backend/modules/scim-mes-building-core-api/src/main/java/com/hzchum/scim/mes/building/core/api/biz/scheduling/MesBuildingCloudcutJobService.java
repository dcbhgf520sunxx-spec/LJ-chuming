package com.hzchum.scim.mes.building.core.api.biz.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingCloudcutJob;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingCloudcutJobDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling.MesBuildingCloudcutJobVO;
import java.util.List;

public interface MesBuildingCloudcutJobService extends IService<MesBuildingCloudcutJob> {
   List<MesBuildingCloudcutJobVO> pageMesBuildingCloudcutJob(MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO);

   Integer saveMesBuildingCloudcutJob(MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO);

   Integer updateMesBuildingCloudcutJob(MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO);

   Boolean deleteMesBuildingCloudcutJob(List<Long> idList);

   List<MesBuildingCloudcutJobVO> teamList();
}
