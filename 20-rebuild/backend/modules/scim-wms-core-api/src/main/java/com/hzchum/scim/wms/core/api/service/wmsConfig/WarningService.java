package com.hzchum.scim.wms.core.api.service.wmsConfig;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warning;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WarningDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InventoryNotifyConfDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InventoryReminderDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarningDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InventoryNotifyConfDTOParam;
import java.math.BigDecimal;
import java.util.List;

public interface WarningService extends IService<Warning> {
   PageVO<WarningDTO> pageInfo(Long factoryId, Long classificationId, String spec, Integer pageNumber, Integer pageSize, List<String> sorts);

   List<WarningDTO> listInfo(Long factoryId, Long subjectId, List<Long> ids, String spec);

   Boolean saveWarning(List<WarningDTOParam> warningRequest);

   Boolean delete(List<Long> ids);

   Boolean updateEnabled(Long id, Boolean enabled);

   Boolean updateWarning(Long id, BigDecimal minimumInventory, Long workshopId);

   ListVO<InventoryNotifyConfDTO> getInventoryNotifyConf();

   Boolean setInventoryNotifyConf(List<InventoryNotifyConfDTOParam> dtoParams);

   PageVO<InventoryReminderDTO> getReminder();

   void updateStatus(MaterialInventory materialInventory, int type);
}
