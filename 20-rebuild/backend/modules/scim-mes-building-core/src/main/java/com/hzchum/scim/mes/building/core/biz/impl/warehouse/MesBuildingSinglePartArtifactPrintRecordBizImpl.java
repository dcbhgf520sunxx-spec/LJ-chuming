package com.hzchum.scim.mes.building.core.biz.impl.warehouse;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.MesBuildingSinglePartArtifactPrintRecordBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingSinglePartArtifactPrintRecord;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingSinglePartArtifactPrintRecordService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingSinglePartArtifactPrintRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingSinglePartArtifactPrintRecordBizImpl
   extends IBizImpl<MesBuildingSinglePartArtifactPrintRecordService, MesBuildingSinglePartArtifactPrintRecordMapper, MesBuildingSinglePartArtifactPrintRecord>
   implements MesBuildingSinglePartArtifactPrintRecordBiz {
}
