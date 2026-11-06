package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo.dto.config.SteelClassificationProcessConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationDTO;
import java.util.List;

public interface SysSteelClassificationService extends IService<SysSteelClassification> {
   List<SteelClassificationDTO> listSteel(List<Long> classificationIds);

   List<Long> listIdsSteel(Integer productClassificationEnum, Integer mesProductEnum, String sectionAndNameAndType);

   List<SteelClassLinkDTO> listSteelAndClassify();

   List<SteelClassificationProcessConfigDTO> findSteelConfigList();
}
