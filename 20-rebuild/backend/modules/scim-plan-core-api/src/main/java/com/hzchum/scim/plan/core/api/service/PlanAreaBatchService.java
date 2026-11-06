package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaBatchDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.AreaBatchUpdateVORequest;
import java.util.List;

public interface PlanAreaBatchService extends IService<PlanAreaBatch> {
   PageVO<PlanAreaBatchDTO> appPageByMonomerIdAndAreaBatchType(
      Long projectId, Long monomerId, Integer productType, Integer itemizedType, Integer pageNumber, Integer pageSize
   );

   Boolean updateAreaBatch(AreaBatchUpdateVORequest voRequest);

   List<PlanAreaBatchDTO> getList(Long projectId, Long monomerId, Integer productType, Integer itemizedType, String name);
}
