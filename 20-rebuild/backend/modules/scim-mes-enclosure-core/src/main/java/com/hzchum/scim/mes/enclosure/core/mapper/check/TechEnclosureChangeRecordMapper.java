package com.hzchum.scim.mes.enclosure.core.mapper.check;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureChangeRecord;
import com.hzchum.scim.plan.core.api.biz.check.TechEnclosureChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechChangeRecordQueryVoParam;
import java.util.List;

public interface TechEnclosureChangeRecordMapper extends BaseMapper<TechEnclosureChangeRecord> {
   List<TechEnclosureChangeRecordDTO> selectChangeRecord(TechChangeRecordQueryVoParam param);
}
