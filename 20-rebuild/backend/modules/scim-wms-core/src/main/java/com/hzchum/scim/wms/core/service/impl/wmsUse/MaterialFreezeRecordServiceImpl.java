package com.hzchum.scim.wms.core.service.impl.wmsUse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeRecordService;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialFreezeRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class MaterialFreezeRecordServiceImpl extends ServiceImpl<MaterialFreezeRecordMapper, MaterialFreezeRecord> implements MaterialFreezeRecordService {
}
