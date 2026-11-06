package com.hzchum.scim.mes.building.core.api.service.surplus;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.ProduceSurplusDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.surplus.MesBuildingProduceSurplus;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.abnormal.ProduceSurplusDOParam;
import java.util.List;

public interface MesBuildingProduceSurplusService extends IService<MesBuildingProduceSurplus> {
   List<ProduceSurplusDO> surplusList(ProduceSurplusDOParam dtoParam);
}
