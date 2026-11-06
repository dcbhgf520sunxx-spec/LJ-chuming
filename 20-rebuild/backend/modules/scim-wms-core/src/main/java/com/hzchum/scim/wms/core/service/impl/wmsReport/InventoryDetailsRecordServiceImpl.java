package com.hzchum.scim.wms.core.service.impl.wmsReport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryDetailsRecord;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryDetailsRecordService;
import com.hzchum.scim.wms.core.mapper.wmsReport.InventoryDetailsRecordMapper;
import org.springframework.stereotype.Service;

@Service
public class InventoryDetailsRecordServiceImpl
   extends ServiceImpl<InventoryDetailsRecordMapper, InventoryDetailsRecord>
   implements InventoryDetailsRecordService {
}
