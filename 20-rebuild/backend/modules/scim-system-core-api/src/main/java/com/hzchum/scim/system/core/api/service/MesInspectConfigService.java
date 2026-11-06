package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesInspectUserInfoDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesShopInspectUserTreeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.ChangStatusDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigBasicDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigSaveDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigUpdateParam;
import java.util.List;

public interface MesInspectConfigService extends IService<MesInspectConfig> {
   PageVO<MesInspectConfigDTO> findInspectConfigList(MesInspectConfigDTO inspectConfig, Integer pageNumber, Integer pageSize);

   Boolean saveConfig(MesInspectConfigSaveDTO inspectConfig);

   Boolean updateConfig(MesInspectConfigUpdateParam inspectConfig) throws CloneNotSupportedException;

   List<Long> getInspectConfigClassIdLink(List<Long> inspectConfigIds);

   Boolean delClassConfig(Long inspectConfigId);

   List<MesInspectConfig> queryInspectConfig(Long workshopId, Long processId, Long classId, Long teamId);

   List<MesInspectConfig> selectCurrentUserIsInspectUser(Long workshopId, Long processId, Long classId, Long userId);

   Boolean changeState(ChangStatusDTO classConfig);

   List<MesShopInspectUserTreeDTO> findAllInspectUserGroupWorkShop();

   List<MesInspectUserInfoDTO> findInspectUserAttribute();

   List<MesInspectConfigBasicDTO> queryAllInspectConfigList();
}
