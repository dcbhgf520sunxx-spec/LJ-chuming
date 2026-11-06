package com.hzchum.scim.system.core.api.biz;

import com.hzchum.scim.system.core.api.pojo.dto.ModuleDecimalScaleSimpleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysModuleDecimalScaleDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysModuleDecimalScaleDtoParam;
import java.util.List;

public interface SysModuleDecimalScaleBiz {
   List<ModuleDecimalScaleSimpleDTO> listModuleDecimalScale();

   List<SysModuleDecimalScaleDTO> list();

   Boolean save(List<SysModuleDecimalScaleDtoParam> paramList);

   Boolean remove(List<Long> ids);
}
