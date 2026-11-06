package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PartyABorrow;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPartyABorrowDTOParam;
import java.util.List;

public interface PartyABorrowMapper extends BaseMapper<PartyABorrow> {
   List<PartyABorrow> listInfo(QueryPartyABorrowDTOParam param);
}
