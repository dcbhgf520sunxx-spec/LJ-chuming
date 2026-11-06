package com.hzchum.scim.scm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractMonomerLink;
import com.hzchum.scim.scm.core.api.pojo.dto.SubOrderMonomerDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubcontractMonomerLinkMapper extends BaseMapper<SubcontractMonomerLink> {
   List<SubOrderMonomerDTO> listByCondition(
      @Param("projectId") Long projectId, @Param("supplierId") Long supplierId, @Param("subcontractClassId") Long subcontractClassId
   );
}
