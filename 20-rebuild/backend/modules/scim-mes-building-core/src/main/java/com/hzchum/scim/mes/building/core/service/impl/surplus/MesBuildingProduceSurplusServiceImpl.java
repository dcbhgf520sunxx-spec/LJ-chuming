package com.hzchum.scim.mes.building.core.service.impl.surplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.ProduceSurplusDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.surplus.MesBuildingProduceSurplus;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.abnormal.ProduceSurplusDOParam;
import com.hzchum.scim.mes.building.core.api.service.surplus.MesBuildingProduceSurplusService;
import com.hzchum.scim.mes.building.core.mapper.surplus.MesBuildingProduceSurplusMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProduceSurplusServiceImpl
   extends ServiceImpl<MesBuildingProduceSurplusMapper, MesBuildingProduceSurplus>
   implements MesBuildingProduceSurplusService {
   @Override
   public List<ProduceSurplusDO> surplusList(ProduceSurplusDOParam dtoParam) {
      return this.baseMapper.surplusList(dtoParam);
   }
}
