package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import org.springframework.stereotype.Component;

/** Reuse each material family's existing read leaves for the current stock export. */
@Component("inventoryExportAccess")
public class InventoryExportAccess {
   public boolean read(List<Integer> basicClasses) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null) return false;
      if (user.isAdmin()) return true;
      if (basicClasses == null || basicClasses.isEmpty() || user.getPermissions() == null) return false;
      for (Integer basicClass : basicClasses) {
         String family = family(basicClass);
         if (family == null) return false;
         String prefix = "wms_matWarehouse_" + family;
         if (!user.getPermissions().contains(prefix + ":get")
               && !user.getPermissions().contains(prefix + "_self:get")
               && !user.getPermissions().contains(prefix + "_partyA:get")) return false;
      }
      return true;
   }

   private String family(Integer basicClass) {
      if (basicClass == null) return null;
      switch (basicClass) {
         case 1: case 2: case 4: case 256: return "steel";
         case 8: return "auxMaterial";
         case 16: return "gas";
         case 128: return "other";
         default: return null;
      }
   }
}
