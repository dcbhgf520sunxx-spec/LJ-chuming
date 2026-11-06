package com.hzchum.scim.mes.building.core.service.impl.qhse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingSpotCheckQhse;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingSpotStatisticsCountDetailDTO;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingSpotCheckQhseService;
import com.hzchum.scim.mes.building.core.mapper.qhse.MesBuildingSpotCheckQhseMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingSpotCheckQhseServiceImpl
   extends ServiceImpl<MesBuildingSpotCheckQhseMapper, MesBuildingSpotCheckQhse>
   implements MesBuildingSpotCheckQhseService {
   @Override
   public List<MesBuildingSpotStatisticsCountDTO> findSpotCheckList(Long projectId, String projectName, String userName) {
      return this.baseMapper.findSpotCheckList(projectId, projectName, userName);
   }

   @Override
   public List<MesBuildingSpotStatisticsCountDTO> findMonomerSpotCheckList(List<Long> projectIds, String userName) {
      return this.baseMapper.findMonomerSpotCheckList(projectIds, userName);
   }

   @Override
   public List<MesBuildingSpotStatisticsCountDetailDTO> findSpotCheckDetailList(
      Long projectId, Long monomerId, String userName, String monomerName, String name, String serialNumber, String specification
   ) {
      return this.baseMapper.findSpotCheckDetailList(projectId, monomerId, userName, monomerName, name, serialNumber, specification);
   }
}
