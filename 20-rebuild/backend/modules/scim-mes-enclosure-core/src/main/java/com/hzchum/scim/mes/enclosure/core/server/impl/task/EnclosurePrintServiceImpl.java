package com.hzchum.scim.mes.enclosure.core.server.impl.task;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.EnclosurePrint;
import com.hzchum.scim.mes.enclosure.core.api.service.task.EnclosurePrintService;
import com.hzchum.scim.mes.enclosure.core.mapper.task.EnclosurePrintMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EnclosurePrintServiceImpl extends ServiceImpl<EnclosurePrintMapper, EnclosurePrint> implements EnclosurePrintService {
   @Override
   public List<EnclosurePrint> getwarehousePrint(Long warehouseId) {
      return this.list(Wrappers.lambdaQuery(EnclosurePrint.class).eq(EnclosurePrint::getWarehouseId, warehouseId).orderByDesc(EnclosurePrint::getPrintTime));
   }
}
