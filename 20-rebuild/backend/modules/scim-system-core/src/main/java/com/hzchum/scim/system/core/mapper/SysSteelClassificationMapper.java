package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo.dto.config.SteelClassificationProcessConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSteelClassificationMapper extends BaseMapper<SysSteelClassification> {
   List<SteelClassificationDTO> listSteel(@Param("classificationIds") List<Long> classificationIds);

   List<SteelClassLinkDTO> listSteelAndClassify();

   List<SteelClassificationProcessConfigDTO> findSteelConfigList();

   List<Long> listIdsSteel(Integer productClassificationEnum, Integer mesProductEnum, String sectionAndNameAndType);
}
