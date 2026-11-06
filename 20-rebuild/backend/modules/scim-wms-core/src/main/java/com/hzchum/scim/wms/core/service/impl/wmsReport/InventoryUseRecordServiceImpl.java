package com.hzchum.scim.wms.core.service.impl.wmsReport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InventoryUseRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InventoryUseRecordDTO;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseRecordService;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsReport.InventoryUseRecordMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class InventoryUseRecordServiceImpl extends ServiceImpl<InventoryUseRecordMapper, InventoryUseRecord> implements InventoryUseRecordService {
   @Resource
   private WmsUtil wmsUtil;

   @Override
   public List<InventoryUseRecordDTO> getDetailDTOList(Long id, LocalDateTime startTime, LocalDateTime endTime, Integer formType) {
      return this.baseMapper.getDetailDTOList(id, startTime, endTime, formType);
   }

   @Override
   public List<InventoryUseRecordDTO> getDetailDTOListNew(List<Long> ids, LocalDateTime startTime, LocalDateTime endTime, Integer formType) {
      return this.baseMapper.getDetailDTOListNew(ids, startTime, endTime, formType);
   }

   @Override
   public void saveUseRecord(
      MaterialInventory materialInventory,
      BigDecimal quantity,
      BigDecimal mete,
      ReceiptTypeEnum receiptTypeEnum,
      Long dataId,
      String serialNumber,
      Integer embodyType,
      Boolean positiveValue
   ) {
      this.wmsUtil.setInventoryUse(materialInventory, quantity, mete, receiptTypeEnum, dataId, serialNumber, embodyType, positiveValue);
   }
}
