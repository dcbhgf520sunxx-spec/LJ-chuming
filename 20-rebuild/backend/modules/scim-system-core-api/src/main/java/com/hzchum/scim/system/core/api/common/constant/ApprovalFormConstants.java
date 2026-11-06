package com.hzchum.scim.system.core.api.common.constant;

import com.hzchum.scim.system.core.api.common.enums.ApproveProcessTypeEnum;
import com.hzchum.scim.system.core.api.pojo.dto.DingDing.FormComponentInfo;
import com.hzchum.scim.system.core.api.pojo.dto.DingDing.SaveProcessInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ApprovalFormConstants {
   private static final ConcurrentMap<String, SaveProcessInfo> PROCESS_MAP = new ConcurrentHashMap<>();
   private static final String TextField = "TextField";
   private static final String TableField = "TableField";
   private static final String DDAttachment = "DDAttachment";

   private static SaveProcessInfo getApplyPurchase() {
      SaveProcessInfo processInfo = new SaveProcessInfo(ApproveProcessTypeEnum.APPLY_PURCHASE.getName(), false);
      List<FormComponentInfo> infos = new ArrayList<>();
      infos.add(new FormComponentInfo("TextField", "申请人"));
      infos.add(new FormComponentInfo("TextField", "申请日期"));
      infos.add(new FormComponentInfo("TextField", "申购单号"));
      infos.add(new FormComponentInfo("TextField", "物料类型"));
      infos.add(new FormComponentInfo("TextField", "所属项目"));
      infos.add(new FormComponentInfo("TextField", "到厂日期"));
      infos.add(new FormComponentInfo("DDAttachment", "附件"));
      processInfo.setFormComponentList(infos);
      return processInfo;
   }

   public static SaveProcessInfo getByName(String name) {
      return PROCESS_MAP.get(name);
   }

   static {
      PROCESS_MAP.put(ApproveProcessTypeEnum.APPLY_PURCHASE.getName(), getApplyPurchase());
   }
}
