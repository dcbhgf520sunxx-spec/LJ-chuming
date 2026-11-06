package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.TransferDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryTransferDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface TransferMapper extends BaseMapper<Transfer> {
   List<TransferDTO> listInfo(QueryTransferDTOParam param);

   @Select("SELECT count(*) FROM wms_transfer WHERE bool_delete_enum = 0 AND date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d')")
   Integer getMaxDayNumber(LocalDateTime date);

   @Select("SELECT count(*) FROM wms_convert WHERE bool_delete_enum = 0 AND date_format(create_time, '%Y-%m-%d') = date_format(#{date}, '%Y-%m-%d')")
   Integer getMaxDayConventNumber(LocalDateTime date);

   TransferDTO getTransfer(Long id);
}
