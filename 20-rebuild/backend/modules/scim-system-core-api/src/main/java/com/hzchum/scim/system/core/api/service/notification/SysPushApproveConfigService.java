package com.hzchum.scim.system.core.api.service.notification;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushApproveConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushApproveConfigDTO;
import java.util.List;

public interface SysPushApproveConfigService extends IService<SysPushApproveConfig> {
   List<SysPushApproveConfigDTO> getPushApproveList(String appKey, Integer status, Integer appType);

   ResultVO save(SysPushApproveConfigDTO sysPushApproveConfigDTOs);

   ResultVO update(SysPushApproveConfigDTO sysPushApproveConfigDTOs);

   ResultVO delete(List<Long> ids);

   boolean setEnabled(Long id, Integer status);
}
