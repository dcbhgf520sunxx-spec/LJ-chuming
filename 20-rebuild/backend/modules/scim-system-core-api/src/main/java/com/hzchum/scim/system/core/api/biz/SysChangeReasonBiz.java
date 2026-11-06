package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.pojo.dto.config.SysChangeReasonDTOParam;
import java.util.List;

public interface SysChangeReasonBiz {
   ListVO list();

   boolean add(SysChangeReasonDTOParam requestVO);

   boolean update(SysChangeReasonDTOParam requestVO);

   boolean delete(List<Long> ids);
}
