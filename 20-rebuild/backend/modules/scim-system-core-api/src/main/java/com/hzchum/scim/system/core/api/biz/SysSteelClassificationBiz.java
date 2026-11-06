package com.hzchum.scim.system.core.api.biz;

import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationMatchDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationUpdateDTOParam;
import java.util.List;

public interface SysSteelClassificationBiz {
   List<SteelClassificationDTO> list(Integer productClassificationEnum, Integer mesProductEnum, String sectionAndNameAndType);

   boolean add(SteelClassificationSaveDTOParam requestVO);

   boolean update(SteelClassificationUpdateDTOParam requestVO);

   boolean delete(List<Long> ids);

   SteelClassificationMatchDTO getSteelInfo(String spec);

   void setPartSteelInfo(TechMachinePart machinePart);

   Integer getBasicClass(String steelId);
}
