package com.hzchum.scim.contract.core.api.enums;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum ContractAttachmentTypeEnum {
   PROJECT_INFO(1, "project-info", "合同"),
   MACHINE_PART_CHART(2, "machine-part-chart", "零件结构图"),
   ARTIFACT_CHART(3, "artifact-chart", "构件结构图"),
   CHANGE_LIST(4, "change-list", "变更清单附件"),
   PROBLEM_REPORT(5, "problem-report", "报告问题附件"),
   PRODUCT_DRAWING(6, "product-drawing", "产品图纸"),
   SUPPLIER(7, "supplier", "供应商附件"),
   SECTION(8, "section", "型材表单附件"),
   CONTRACT_BUSINESS_SETTLEMENT(9, "contract-business-settlement", "合同商务结算附件"),
   LOGO(11, "logo", "logo图"),
   ORDER(12, "order", "采购订单附件");

   private final int typeNum;
   private final String dirName;
   private final String desc;

   public static String getDirNameByNum(int typeNum) {
      Optional<String> dirName = Arrays.stream(values())
         .filter(typeEnum -> typeEnum.getTypeNum() == typeNum)
         .map(ContractAttachmentTypeEnum::getDirName)
         .findFirst();
      if (dirName.isPresent()) {
         return dirName.get();
      } else {
         throw new BusinessException("附件类型错误");
      }
   }

   public static String getDescByNum(int typeNum) {
      Optional<String> desc = Arrays.stream(values()).filter(typeEnum -> typeEnum.getTypeNum() == typeNum).map(ContractAttachmentTypeEnum::getDesc).findFirst();
      if (desc.isPresent()) {
         return desc.get();
      } else {
         throw new BusinessException("附件类型编号有误");
      }
   }

   public static ContractAttachmentTypeEnum getByNum(int typeNum) {
      ContractAttachmentTypeEnum[] values = values();

      for (ContractAttachmentTypeEnum contractAttachmentTypeEnum : values) {
         if (contractAttachmentTypeEnum.getTypeNum() == typeNum) {
            return contractAttachmentTypeEnum;
         }
      }

      throw new BusinessException("附件类型错误");
   }

   public int getTypeNum() {
      return this.typeNum;
   }

   public String getDirName() {
      return this.dirName;
   }

   public String getDesc() {
      return this.desc;
   }

   ContractAttachmentTypeEnum(final int typeNum, final String dirName, final String desc) {
      this.typeNum = typeNum;
      this.dirName = dirName;
      this.desc = desc;
   }
}
