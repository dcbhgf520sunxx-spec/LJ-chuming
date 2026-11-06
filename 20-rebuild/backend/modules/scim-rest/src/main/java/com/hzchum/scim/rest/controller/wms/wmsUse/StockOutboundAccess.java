package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchOutboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/** Determine each sale or outsourcing row's existing outbound permission from native stock. */
@Component("stockOutboundAccess")
public class StockOutboundAccess {
   @Resource private MaterialInventoryService inventory;

   public boolean single(Long materialId) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null) return false;
      if (user.isAdmin()) return true;
      if (materialId == null || user.getPermissions() == null) return false;
      MaterialInventory stock = inventory.getById(materialId);
      if (stock == null || stock.getBasicClass() == null) return false;
      String family;
      switch (stock.getBasicClass()) {
         case 1: case 2: case 4: case 256: family = "steel"; break;
         case 8: family = "auxMaterial"; break;
         case 16: family = "gas"; break;
         case 128: family = "other"; break;
         default: return false;
      }
      String prefix = "wms_matWarehouse_" + family;
      return user.getPermissions().contains(prefix + ":outbound")
         || user.getPermissions().contains(prefix + "_self:outbound")
         || user.getPermissions().contains(prefix + "_partyA:outbound");
   }

   public boolean batch(BatchOutboundDTOParam param) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null) return false;
      if (user.isAdmin()) return true;
      if (param == null || param.getList() == null || param.getList().isEmpty()) return false;
      for (BatchOutboundDetailDTOParam row : param.getList()) {
         if (row == null || !single(row.getId())) return false;
      }
      return true;
   }
}
