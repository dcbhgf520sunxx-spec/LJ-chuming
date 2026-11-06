package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferBuyIn;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferBuyInDTOParam;
import java.util.List;

public interface TransferBuyInMapper extends BaseMapper<TransferBuyIn> {
   List<TransferBuyIn> getBuyIn(QueryTransferBuyInDTOParam param);

   List<DownLoadDetailDO> getDownLoadDetail(QueryDetailDTOParam build);
}
