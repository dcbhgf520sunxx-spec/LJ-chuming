package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.UnitDTOParam;
import java.util.List;

public interface UnitService extends IService<Unit> {
   PageVO<Unit> pageInfo(Integer pageNumber, Integer pageSize, List<String> sort, String name, Integer type, Boolean enabled);

   List<Unit> listInfo(String name, Integer type, Boolean enabled);

   Boolean updateUnitStatus(Integer id, Boolean enabled);

   Boolean addUnit(List<UnitDTOParam> dtoParams);

   Boolean delete(List<Long> ids);
}
