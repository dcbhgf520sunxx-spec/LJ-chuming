package com.hzchum.scim.mes.building.core.service.impl.warehouse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingExternalRecord;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingExternalRecordService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingExternalRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingExternalRecordServiceImpl
   extends ServiceImpl<MesBuildingExternalRecordMapper, MesBuildingExternalRecord>
   implements MesBuildingExternalRecordService {
}
