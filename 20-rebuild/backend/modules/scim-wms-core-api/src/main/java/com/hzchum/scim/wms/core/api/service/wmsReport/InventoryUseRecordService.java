package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseRecordDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface InventoryUseRecordService extends IService<InventoryUseRecord> {
   List<InventoryUseRecordDTO> getDetailDTOList(Long id, LocalDateTime startTime, LocalDateTime endTime, Integer formType);

   List<InventoryUseRecordDTO> getDetailDTOListNew(List<Long> ids, LocalDateTime startTime, LocalDateTime endTime, Integer formType);

   void saveUseRecord(
      MaterialInventory materialInventory,
      BigDecimal quantity,
      BigDecimal mete,
      ReceiptTypeEnum receiptTypeEnum,
      Long dataId,
      String serialNumber,
      Integer embodyType,
      Boolean positiveValue
   );
}
