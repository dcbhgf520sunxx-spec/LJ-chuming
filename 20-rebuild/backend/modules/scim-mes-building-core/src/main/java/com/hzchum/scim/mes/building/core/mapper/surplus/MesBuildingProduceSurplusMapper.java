package com.hzchum.scim.mes.building.core.mapper.surplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.ProduceSurplusDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.surplus.MesBuildingProduceSurplus;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.abnormal.ProduceSurplusDOParam;
import java.util.List;

public interface MesBuildingProduceSurplusMapper extends BaseMapper<MesBuildingProduceSurplus> {
   List<ProduceSurplusDO> surplusList(ProduceSurplusDOParam dtoParam);
}
