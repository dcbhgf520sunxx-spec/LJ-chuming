package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Supplement;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.SupplementDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import java.util.List;

public interface SupplementService extends IService<Supplement> {
   PageVO<SupplementDTO> pageInfo(QueryDetailDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   SupplementDTO selectById(Long id);
}
