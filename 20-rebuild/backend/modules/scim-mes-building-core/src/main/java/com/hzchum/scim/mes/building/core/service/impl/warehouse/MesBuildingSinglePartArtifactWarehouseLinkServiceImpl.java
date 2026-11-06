package com.hzchum.scim.mes.building.core.service.impl.warehouse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingSinglePartArtifactWarehouseLink;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingSinglePartArtifactWarehouseLinkService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingSinglePartArtifactWarehouseLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingSinglePartArtifactWarehouseLinkServiceImpl
   extends ServiceImpl<MesBuildingSinglePartArtifactWarehouseLinkMapper, MesBuildingSinglePartArtifactWarehouseLink>
   implements MesBuildingSinglePartArtifactWarehouseLinkService {
}
