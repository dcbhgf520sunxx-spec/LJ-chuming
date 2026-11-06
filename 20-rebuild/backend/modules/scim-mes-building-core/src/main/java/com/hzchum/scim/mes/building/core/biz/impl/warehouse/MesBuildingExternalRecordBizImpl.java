package com.hzchum.scim.mes.building.core.biz.impl.warehouse;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.MesBuildingExternalRecordBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingExternalRecord;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingExternalRecordService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingExternalRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingExternalRecordBizImpl
   extends IBizImpl<MesBuildingExternalRecordService, MesBuildingExternalRecordMapper, MesBuildingExternalRecord>
   implements MesBuildingExternalRecordBiz {
}
