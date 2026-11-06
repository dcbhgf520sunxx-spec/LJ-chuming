package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SteelPlateInventoryDTO;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface WmsCutService {
   List<SteelPlateInventoryDTO> getSteelPlateList(String spec, Double thickness, String teamCode);

   Boolean setMaterialFreeze(
      Outbound outbound, String material, Long thickness, String serialNumber, Long syncId, Integer quantity, Map<Long, BigDecimal> sumFreezeMeteMap
   );
}
