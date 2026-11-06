package com.hzchum.scim.cut.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.cut.core.api.pojo._do.CutMachine;
import java.util.List;

public interface CutMachineService extends IService<CutMachine> {
   ResultVO getMachine(
      Integer pageNumber,
      Integer pageSize,
      String machineNumber,
      String machineName,
      Integer state,
      String machineType,
      Long factoryId,
      Long workshopInfId,
      List<String> sort,
      String online
   );
}
