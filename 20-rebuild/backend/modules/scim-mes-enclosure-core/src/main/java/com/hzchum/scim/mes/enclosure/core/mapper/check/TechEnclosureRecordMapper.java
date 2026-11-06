package com.hzchum.scim.mes.enclosure.core.mapper.check;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureRecord;
import com.hzchum.scim.plan.core.api.biz.check.TechEnclosureChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechEnclosureChangeRecordQueryVoParam;
import java.util.List;

public interface TechEnclosureRecordMapper extends BaseMapper<TechEnclosureRecord> {
   List<TechEnclosureChangeRecordDTO> listChangeRecord(TechEnclosureChangeRecordQueryVoParam param);
}
