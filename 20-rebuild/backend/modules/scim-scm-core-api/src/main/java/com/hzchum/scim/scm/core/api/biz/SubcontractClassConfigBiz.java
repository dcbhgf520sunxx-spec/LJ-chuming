package com.hzchum.scim.scm.core.api.biz;

import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractClassConfigDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractClassConfigDTOParam;
import java.util.List;

public interface SubcontractClassConfigBiz {
   List<SubcontractClassConfigDTO> list(String name);

   Boolean save(List<SubcontractClassConfigDTOParam> params);

   Boolean update(SubcontractClassConfigDTOParam param);

   Boolean delete(List<Long> ids);
}
