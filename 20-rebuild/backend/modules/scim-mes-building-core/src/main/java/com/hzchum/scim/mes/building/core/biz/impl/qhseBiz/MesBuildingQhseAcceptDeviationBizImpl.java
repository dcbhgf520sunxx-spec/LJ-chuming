package com.hzchum.scim.mes.building.core.biz.impl.qhseBiz;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseAcceptDeviationBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseAcceptDeviation;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseAcceptDeviationService;
import com.hzchum.scim.mes.building.core.mapper.qhse.MesBuildingQhseAcceptDeviationMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingQhseAcceptDeviationBizImpl
   extends IBizImpl<MesBuildingQhseAcceptDeviationService, MesBuildingQhseAcceptDeviationMapper, MesBuildingQhseAcceptDeviation>
   implements MesBuildingQhseAcceptDeviationBiz {
}
