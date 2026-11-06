package com.hzchum.scim.mes.building.core.service.impl.wage_quota_management;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesPaintingQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesPaintingQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesPaintingQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesPaintingQuotaConfigMapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesPaintingQuotaConfigServiceImpl
   extends ServiceImpl<MesPaintingQuotaConfigMapper, MesPaintingQuotaConfig>
   implements MesPaintingQuotaConfigService {
   @Autowired
   private MesBuildingWorkshopService workshopService;

   @Override
   public List<MesPaintingQuotaConfigDTO> listInfo() {
      List<MesPaintingQuotaConfigDTO> dtoList = BeanUtil.copyToList(this.list(), MesPaintingQuotaConfigDTO.class);
      if (CollUtil.isNotEmpty(dtoList)) {
         List<Long> workshopIdList = dtoList.stream()
            .map(MesPaintingQuotaConfigDTO::getWorkshopIdList)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(workshopIdList);
         dtoList.forEach(
            dto -> {
               List<String> workshopNameList = workshopList.stream()
                  .filter(workshop -> dto.getWorkshopIdList().contains(workshop.getId()))
                  .map(MesBuildingWorkshop::getName)
                  .collect(Collectors.toList());
               dto.setWorkshopNameList(workshopNameList);
            }
         );
      }

      return dtoList;
   }
}
