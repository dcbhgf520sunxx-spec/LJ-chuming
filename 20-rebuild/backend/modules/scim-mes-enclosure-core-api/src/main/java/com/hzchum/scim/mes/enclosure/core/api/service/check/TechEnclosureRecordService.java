package com.hzchum.scim.mes.enclosure.core.api.service.check;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureRecord;
import com.hzchum.scim.plan.core.api.biz.check.TechEnclosureChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechEnclosureChangeRecordQueryVoParam;
import java.util.List;

public interface TechEnclosureRecordService extends IService<TechEnclosureRecord> {
   List<TechEnclosureChangeRecordDTO> listChangeRecord(TechEnclosureChangeRecordQueryVoParam param);
}
