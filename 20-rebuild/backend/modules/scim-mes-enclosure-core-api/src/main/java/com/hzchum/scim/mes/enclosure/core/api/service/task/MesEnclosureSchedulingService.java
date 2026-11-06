package com.hzchum.scim.mes.enclosure.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureScheduling;

public interface MesEnclosureSchedulingService extends IService<MesEnclosureScheduling> {
   Boolean checkStatus(Long productionLine);
}
