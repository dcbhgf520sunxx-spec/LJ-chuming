package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureType;
import com.hzchum.scim.system.core.api.pojo.dto.SysStructureTypeDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysStructureTypeSaveParam;
import com.hzchum.scim.system.core.api.pojo.param.SysStructureTypeUpdateParam;
import com.hzchum.scim.system.core.api.pojo.request.SysStructureTypeQueryParam;
import java.util.List;

public interface SysStructureTypeBiz extends IBiz<SysStructureType> {
   List<SysStructureTypeDTO> listAll(SysStructureTypeQueryParam param);

   PageVO<SysStructureTypeDTO> pageList(SysStructureTypeQueryParam param, Integer pageNumber, Integer pageSize);

   Boolean saveList(List<SysStructureTypeSaveParam> paramList);

   Boolean edit(SysStructureTypeUpdateParam param);

   Boolean updateStatus(SysStructureTypeUpdateParam param);

   Boolean delete(List<Long> ids);
}
