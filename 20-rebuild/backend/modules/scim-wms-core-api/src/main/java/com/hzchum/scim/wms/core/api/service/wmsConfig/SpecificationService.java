package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Specification;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SpecificationDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SpecificationDTOParam;
import java.util.List;
import java.util.Map;

public interface SpecificationService extends IService<Specification> {
   PageVO<SpecificationDTO> getByClassificationId(Long subjectId);

   Boolean batchSave(SpecificationDTOParam specificationDTOParam);

   Boolean deleteByIds(List<Long> ids);

   Boolean updateSpecification(SpecificationDTOParam specificationDTOParam);

   Map<String, String> checkClassifySpec(Long classifyId, String spec);

   String getJoinSpec(Long classifyId, String spec);
}
