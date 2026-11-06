package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleBasicConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigUpdateDTOParam;
import java.util.List;

public interface SysAssembleConfigBiz {
   PageVO<AssembleConfigDTO> listPage(
      Boolean boolSectionSteel,
      Integer productionLineTypeEnum,
      String name,
      String specPrefix,
      Integer mesProductEnum,
      String sectionAndNameAndType,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean add(AssembleConfigSaveDTOParam param);

   Boolean updateAssembleConfig(AssembleConfigUpdateDTOParam param);

   void checkUpdate(SysAssembleConfig assembleConfig, AssembleConfigUpdateDTOParam param);

   Boolean deleteList(List<Long> ids);

   List<AssembleConfigDTO> listAll(Integer mesProductEnum);

   List<AssembleBasicConfigDTO> listWeldingAll(Integer mesProductEnum);
}
