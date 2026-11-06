package com.hzchum.scim.mes.building.core.api.service.record;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingPrintRecord;

public interface MesBuildingPrintRecordService extends IService<MesBuildingPrintRecord> {
   ListVO<MesBuildingPrintRecord> listPrintRecord(Long id, Integer type);
}
