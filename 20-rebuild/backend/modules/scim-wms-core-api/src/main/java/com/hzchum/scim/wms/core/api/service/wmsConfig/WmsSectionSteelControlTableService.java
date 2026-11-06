package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsSectionSteelControlTable;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelControlTableDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SectionSteelControlTableDTOParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface WmsSectionSteelControlTableService extends IService<WmsSectionSteelControlTable> {
   List<SectionSteelControlTableDTO> SectionSteelControlList(Integer mesProductEnum);

   boolean saveSectionSteelControl(SectionSteelControlTableDTOParam param);

   List<Classification> getSectionSteelLastSubjects();

   Map<String, BigDecimal> getPartDeepMete(Long projectId, Long classifyId);
}
