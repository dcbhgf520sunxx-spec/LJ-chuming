package com.hzchum.scim.system.core.api.biz;

import com.hzchum.scim.system.core.api.pojo.dto.TemplatePanelAssemblyConfigDTO;
import com.hzchum.scim.system.core.api.pojo.vo.TemplatePanelAssemblyConfigVO;
import java.util.List;

public interface TemplatePanelAssemblyConfigBiz {
   List<TemplatePanelAssemblyConfigDTO> listAssemblyTemplateConfigs();

   Boolean updateAssemblyTemplateConfigs(List<TemplatePanelAssemblyConfigVO> panelAssemblyConfigVOS);
}
