package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.AreaSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProjectSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProjectSchedulingTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingAreaScheduling;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingAreaSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingAreaSchedulingMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAreaSchedulingServiceImpl
   extends ServiceImpl<MesBuildingAreaSchedulingMapper, MesBuildingAreaScheduling>
   implements MesBuildingAreaSchedulingService {
   @Override
   public List<ProjectSchedulingDO> getProjectScheduling(
      LocalDateTime dateTime, Integer status, LocalDateTime endDate, List<LocalDateTime> endTimeList, List<Long> projectIds
   ) {
      return this.baseMapper.getProjectScheduling(dateTime, status, endDate, endTimeList, projectIds);
   }

   @Override
   public List<AreaSchedulingDO> getAreaSchedulingList(Integer projectId, Integer projectType) {
      return this.baseMapper.getAreaSchedulingList(projectId, projectType);
   }

   @Override
   public ProductMeteDTO getSumMeteByCondition(Long projectId, Integer productType) {
      return this.baseMapper.getSumMeteByCondition(projectId, productType);
   }

   @Override
   public List<ProjectSchedulingTreeDO> getScheduling(LocalDateTime dateTime, Integer projectType, Long workshopId) {
      return this.baseMapper.getScheduling(dateTime, projectType, workshopId);
   }
}
