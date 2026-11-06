package com.hzchum.scim.mes.building.core.biz.impl._package;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz._package.MesBuildingPackageNumberLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageNumberLinkService;
import com.hzchum.scim.mes.building.core.mapper._package.MesBuildingPackageNumberLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingPackageNumberLinkBizImpl
   extends IBizImpl<MesBuildingPackageNumberLinkService, MesBuildingPackageNumberLinkMapper, MesBuildingPackageNumberLink>
   implements MesBuildingPackageNumberLinkBiz {
}
