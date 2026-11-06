package com.hzchum.scim.plan.core.mapper.change;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechChangeRecordQueryVoParam;
import java.util.List;

public interface TechChangeRecordMapper extends BaseMapper<TechChangeRecord> {
   List<TechChangeRecordDTO> selectChangeRecord(TechChangeRecordQueryVoParam param);
}
