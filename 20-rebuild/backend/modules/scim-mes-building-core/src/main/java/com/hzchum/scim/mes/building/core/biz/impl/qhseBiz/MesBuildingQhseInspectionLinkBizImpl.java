package com.hzchum.scim.mes.building.core.biz.impl.qhseBiz;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseInspectionLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseInspectionLink;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseInspectionLinkService;
import com.hzchum.scim.mes.building.core.mapper.qhse.MesBuildingQhseInspectionLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingQhseInspectionLinkBizImpl
   extends IBizImpl<MesBuildingQhseInspectionLinkService, MesBuildingQhseInspectionLinkMapper, MesBuildingQhseInspectionLink>
   implements MesBuildingQhseInspectionLinkBiz {
}
