package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ScrapDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import java.util.List;

public interface ScrapService extends IService<Scrap> {
   PageVO<ScrapDTO> pageInfo(QueryByMaterialDTOParam param, Integer pageNum, Integer size, List<String> sort);
}
