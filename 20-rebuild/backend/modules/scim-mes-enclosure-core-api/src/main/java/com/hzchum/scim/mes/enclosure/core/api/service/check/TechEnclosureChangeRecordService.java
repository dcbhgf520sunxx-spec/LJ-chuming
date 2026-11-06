package com.hzchum.scim.mes.enclosure.core.api.service.check;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureChangeRecord;
import com.hzchum.scim.plan.core.api.biz.check.TechEnclosureChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechChangeRecordQueryVoParam;
import java.util.List;

public interface TechEnclosureChangeRecordService extends IService<TechEnclosureChangeRecord> {
   void checkChangeRecordByAreaId(Long areaId);

   void checkChangeRecordByEnclosureId(Long enclosureId);

   int getSortNumber(Long projectId, String yearMonthDay);

   List<TechEnclosureChangeRecordDTO> listChangeRecord(TechChangeRecordQueryVoParam param);
}
