package com.hzchum.scim.mes.building.core.biz.impl.warehouse;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.MesBuildingSinglePartArtifactWarehouseLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingSinglePartArtifactWarehouseLink;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingSinglePartArtifactWarehouseLinkService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingSinglePartArtifactWarehouseLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingSinglePartArtifactWarehouseLinkBizImpl
   extends IBizImpl<MesBuildingSinglePartArtifactWarehouseLinkService, MesBuildingSinglePartArtifactWarehouseLinkMapper, MesBuildingSinglePartArtifactWarehouseLink>
   implements MesBuildingSinglePartArtifactWarehouseLinkBiz {
}
