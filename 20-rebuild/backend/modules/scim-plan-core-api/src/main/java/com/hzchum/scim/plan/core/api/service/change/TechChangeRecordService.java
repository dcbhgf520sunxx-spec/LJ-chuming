package com.hzchum.scim.plan.core.api.service.change;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechChangeRecordQueryVoParam;
import java.util.List;

public interface TechChangeRecordService extends IService<TechChangeRecord> {
   List<TechChangeRecordDTO> listChangeRecord(TechChangeRecordQueryVoParam param);

   void checkChangeRecordByMonomerId(Long monomerId);

   int getSortNumber(Long projectId, String yearMonthDay);

   void checkExistsChangeRecord(Long monomerId);
}
