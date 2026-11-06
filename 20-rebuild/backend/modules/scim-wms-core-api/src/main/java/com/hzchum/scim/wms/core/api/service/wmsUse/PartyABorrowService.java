package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PartyABorrow;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PartyAReturnDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PartyABorrowDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPartyABorrowDTOParam;
import java.util.List;

public interface PartyABorrowService extends IService<PartyABorrow> {
   PageVO<PartyABorrowDTO> pageInfo(QueryPartyABorrowDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<PartyABorrow> listInfo(QueryPartyABorrowDTOParam param);

   ListVO<MaterialInventoryDTO> getMat(Long id);

   Boolean setReturn(PartyAReturnDTOParam param);
}
