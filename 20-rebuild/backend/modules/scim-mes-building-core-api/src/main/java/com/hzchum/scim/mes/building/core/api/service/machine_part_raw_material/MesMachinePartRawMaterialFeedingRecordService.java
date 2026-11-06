package com.hzchum.scim.mes.building.core.api.service.machine_part_raw_material;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.machine_part_raw_material.MesMachinePartRawMaterialFeedingRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.machine_part_raw_material.MachinePartReportRawMaterialFeedingRecordParam;
import java.util.List;

public interface MesMachinePartRawMaterialFeedingRecordService extends IService<MesMachinePartRawMaterialFeedingRecord> {
   Boolean machinePartReportBatchAdd(List<MachinePartReportRawMaterialFeedingRecordParam> recordParamList);
}
