package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo.dto.config.SteelClassificationProcessConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationDTO;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.mapper.SysSteelClassificationMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysSteelClassificationServiceImpl
   extends ServiceImpl<SysSteelClassificationMapper, SysSteelClassification>
   implements SysSteelClassificationService {
   @Override
   public List<SteelClassificationDTO> listSteel(List<Long> classificationIds) {
      return this.baseMapper.listSteel(classificationIds);
   }

   @Override
   public List<Long> listIdsSteel(Integer productClassificationEnum, Integer mesProductEnum, String sectionAndNameAndType) {
      return this.baseMapper.listIdsSteel(productClassificationEnum, mesProductEnum, sectionAndNameAndType);
   }

   @Override
   public List<SteelClassLinkDTO> listSteelAndClassify() {
      return this.baseMapper.listSteelAndClassify();
   }

   @Override
   public List<SteelClassificationProcessConfigDTO> findSteelConfigList() {
      return this.baseMapper.findSteelConfigList();
   }
}
