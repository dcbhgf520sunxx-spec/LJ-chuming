package com.hzchum.scim.system.core.api.service.notification;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.system.core.api.pojo._do.notification.SysPushWebhookConfig;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushWebhookConfigDTO;
import java.util.List;

public interface SysPushWebhookConfigService extends IService<SysPushWebhookConfig> {
   List<SysPushWebhookConfigDTO> getWebhookList(String url, String name, Integer status, Integer notificationType);

   ResultVO save(List<SysPushWebhookConfigDTO> sysPushWebhookConfigDTO);

   ResultVO update(SysPushWebhookConfigDTO sysPushWebhookConfigDTO);

   ResultVO delete(List<Long> ids);

   boolean setEnabled(Long id, Integer status);
}
