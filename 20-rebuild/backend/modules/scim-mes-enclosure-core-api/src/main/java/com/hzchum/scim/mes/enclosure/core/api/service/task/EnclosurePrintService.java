package com.hzchum.scim.mes.enclosure.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.EnclosurePrint;
import java.util.List;

public interface EnclosurePrintService extends IService<EnclosurePrint> {
   List<EnclosurePrint> getwarehousePrint(Long warehouseId);
}
