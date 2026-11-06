package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.TransferDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.DTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferBuyInDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferBuyInDTOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransferDetailMapper extends BaseMapper<TransferDetail> {
   List<TransferDetailDO> getTransferDetailList(QueryDetailDTOParam param);

   TransferDetailDO getTransferDetailListCount(QueryDetailDTOParam param);

   List<DTO> getDtoById(Long id);

   List<TransferDetail> getA(QueryTransferBuyInDTOParam param);

   List<TransferBuyInDTO> getReturn(QueryTransferBuyInDTOParam param);

   List<MaterialInventoryDTO> getByTrId(Long id);

   List<DownLoadDetailDO> getDownLoadDetail(@Param("param") QueryDetailDTOParam param, @Param("transferType") Integer transferType);
}
