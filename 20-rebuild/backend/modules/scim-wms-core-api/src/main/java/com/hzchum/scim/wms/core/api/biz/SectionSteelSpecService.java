package com.hzchum.scim.wms.core.api.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpec;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecStandardDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SectionSteelSpecDTOParam;
import java.util.List;

public interface SectionSteelSpecService extends IService<SectionSteelSpec> {
   PageVO<SectionSteelSpecDetailDTO> listByClassificationId(Long classificationId, String specification);

   Boolean add(Long sectionSteelId, List<SectionSteelSpecDTOParam> dtoParams);

   Boolean updateStandard(SectionSteelSpecDTOParam param);

   PrintVO download(Long sectionSteelId, Long standardId);

   SectionSteelSpecDTO getWeightByClassifyId(Long id, String spec);

   Boolean delete(List<Long> ids);

   Boolean batchSave(Long sectionSteelId, List<SectionSteelSpecDTOParam> params);

   List<SectionSteelSpecStandardDetailDTO> getStandardDetail(Long classificationId, String specification);

   Boolean updateStatus(List<Long> ids, Boolean status);
}
