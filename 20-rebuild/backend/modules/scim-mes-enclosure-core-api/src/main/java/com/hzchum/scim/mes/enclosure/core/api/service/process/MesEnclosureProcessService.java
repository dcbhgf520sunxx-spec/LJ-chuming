package com.hzchum.scim.mes.enclosure.core.api.service.process;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process.MesEnclosureProcessDTO;
import java.util.List;

public interface MesEnclosureProcessService extends IService<MesEnclosureProcess> {
   List<MesEnclosureProcess> listByCondition(Boolean type, Long userId);

   List<MesEnclosureProcess> selectProcessByLine(Long ProductionLineId);

   List<MesEnclosureProcessDTO> getWorkshopByProcessList(Long workshopId);
}
