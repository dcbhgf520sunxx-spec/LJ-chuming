package com.hzchum.scim.wms.core.service.impl.wmsReport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseStatisticsDate;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsDateService;
import com.hzchum.scim.wms.core.mapper.wmsReport.InventoryUseStatisticsDateMapper;
import org.springframework.stereotype.Service;

@Service
public class InventoryUseStatisticsDateServiceImpl
   extends ServiceImpl<InventoryUseStatisticsDateMapper, InventoryUseStatisticsDate>
   implements InventoryUseStatisticsDateService {
}
