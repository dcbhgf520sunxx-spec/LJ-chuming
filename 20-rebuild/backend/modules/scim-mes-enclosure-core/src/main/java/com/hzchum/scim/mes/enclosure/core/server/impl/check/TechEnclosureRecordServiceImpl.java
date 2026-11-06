package com.hzchum.scim.mes.enclosure.core.server.impl.check;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureRecord;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureRecordService;
import com.hzchum.scim.mes.enclosure.core.mapper.check.TechEnclosureRecordMapper;
import com.hzchum.scim.plan.core.api.biz.check.TechEnclosureChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechEnclosureChangeRecordQueryVoParam;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechEnclosureRecordServiceImpl extends ServiceImpl<TechEnclosureRecordMapper, TechEnclosureRecord> implements TechEnclosureRecordService {
   @Override
   public List<TechEnclosureChangeRecordDTO> listChangeRecord(TechEnclosureChangeRecordQueryVoParam param) {
      return this.baseMapper.listChangeRecord(param);
   }
}
