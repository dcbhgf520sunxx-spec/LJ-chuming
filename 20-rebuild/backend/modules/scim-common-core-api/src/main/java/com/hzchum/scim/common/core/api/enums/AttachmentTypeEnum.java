package com.hzchum.scim.common.core.api.enums;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum AttachmentTypeEnum {
   COMMON(1, "common"),
   SECTION(10, "section"),
   SUPPLIER(50, "supplier"),
   PURCHASE_ORDER(100, "purchase_order"),
   CONTRACT(200, "contract"),
   CONTRACT_VISA(201, "contract_visa"),
   CONTRACT_ARCHIVES(202, "contract_archives"),
   IMAGE(201, "image"),
   CONFIG(300, "config"),
   BUSINESS(400, "business"),
   MES_BUILDING_QHSE(601, "mesBuildingQhse"),
   PLAN(700, "plan"),
   TECH_DATA(701, "tech_data"),
   PROCESS_FILE(710, "process_file"),
   TECH_CHANGE(720, "tech_change"),
   CRM_RECORD_ATT(730, "crm"),
   DATA_CONSTRUCTION(801, "data_construction"),
   IMAGE_PROGRESS(802, "image_progress"),
   WMS(900, "wms"),
   BIMFACE(1000, "bimface"),
   PNC(1002, "pnc"),
   TASK_ORDER(1003, "task_order"),
   XML(1004, "xml"),
   ZIP(1029, "zip"),
   CERT(1100, "cert"),
   TECH_WELDING(1110, "tech_welding"),
   TECH_CUTTING(1120, "tech_cutting"),
   TECH_PAINTING(1130, "tech_painting");

   private final int type;
   private final String name;

   AttachmentTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(int typeNum) {
      Optional<String> dirName = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == typeNum).map(AttachmentTypeEnum::getName).findFirst();
      if (dirName.isPresent()) {
         return dirName.get();
      } else {
         throw new BusinessException("附件类型不存在");
      }
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
