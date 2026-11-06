package com.hzchum.scim.rest.controller.scm;

import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.MenuService;
import com.hzchum.scim.system.core.api.service.RoleMenuLinkService;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/** Shared SCM providers use the stored order's existing page permission. */
@Component("scmPurchaseOrderAccess")
public class ScmPurchaseOrderAccess {
   @Resource private PurchaseOrderService purchaseOrders;
   @Resource private MenuService menus;
   @Resource private RoleMenuLinkService roleMenus;

   public boolean read(Long orderId) {
      return allowed(orderId, "get");
   }

   public boolean edit(Long orderId) {
      return allowed(orderId, "edit");
   }

   private boolean allowed(Long orderId, String action) {
      SecurityUser user = UserUtil.getCurrentUser();
      PurchaseOrder order = orderId == null ? null : purchaseOrders.getById(orderId);
      if (user == null || order == null || Boolean.TRUE.equals(order.getBoolDeleteEnum())) return false;
      Integer attribute = order.getProjectAttribute();
      String page;
      if (Objects.equals(attribute, ProjectAttributeEnum.SELF_SUPPORT.getType())) page = "scm_purchaseOrder_self_v2:";
      else if (Objects.equals(attribute, ProjectAttributeEnum.JOINT_VENTURE.getType())
            || Objects.equals(attribute, ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) page = "scm_purchaseOrder_v2:";
      else return false;
      return user.isAdmin() || user.getPermissions() != null && user.getPermissions().contains(page + action);
   }

   public boolean reconciliationRead() {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null) return false;
      if (user.isAdmin()) return true;
      // SecurityUser.menus contains display modules, not all assigned submenus.
      List<Long> menuIds = roleMenus.listByUserId(user.getId());
      return menuIds != null && !menuIds.isEmpty() && menus.listByIds(menuIds).stream()
         .anyMatch(menu -> "/supply-chain/purchase-manage/index".equals(menu.getComponent())
            || "supply-chain/purchase-manage/index".equals(menu.getComponent()));
   }

   public boolean reconciliationOrderRead(Long orderId) {
      PurchaseOrder order = orderId == null ? null : purchaseOrders.getById(orderId);
      return order != null && !Boolean.TRUE.equals(order.getBoolDeleteEnum())
         && (read(orderId) || reconciliationRead());
   }
}
