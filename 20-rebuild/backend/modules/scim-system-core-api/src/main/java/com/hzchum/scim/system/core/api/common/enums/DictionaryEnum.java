package com.hzchum.scim.system.core.api.common.enums;

import com.hzchum.scim.system.core.api.pojo.dto.SysDictionaryDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum DictionaryEnum {
   MARGIN_TYPE("margin_type", "合同-保证金类型"),
   CURRENCY_TYPE("currency_type", "币种类型"),
   PAYMENT_REASON("payment_reason", "付款事由"),
   ENCLOSURE_TYPE("enclosure_type", "围护类型"),
   MATERIAL_SUPPLIER_FEE_TYPE("material_supplier_fee_type", "物料供应商费用种类"),
   REIMBURSEMENT_TYPE("reimbursement_type", "项目报销类型"),
   LOGISTICS_SUPPLIER_FEE_TYPE("logistics_supplier_fee_type", "物流供应商费用种类"),
   MES_QHSE_PRODUCT_PROBLEM_TYPE("mes_qhse_product_problem_type", "生产QHSE产品问题种类"),
   INVOICE_TAX_RATE("invoice_tax_rate", "发票税率"),
   VISA_REASON("visa_reason", "签证原因"),
   STRUCTURE_STATUS("structure_status", "结构类型"),
   PARTY_TYPE("party_type", "甲方类型"),
   SENDING_MODE("sending_mode", "发包类型"),
   INFO_SOURCE("info_source", "信息来源"),
   INJECTION_TYPE("injection_type", "注资类型"),
   TESTING_FEE_TYPE("testing_fee_type", "检测费类型"),
   EQUIPMENT_DEPRECIATION_CLASSIFICATION("equipment_depreciation_classification", "设备折旧分类"),
   WORK_TYPE("work_type", "工种"),
   CERT_TYPE("cert_type", "证书类型"),
   SITE_WORK_TYPE("site_work_type", "现场工种"),
   SITE_CERT_TYPE("site_cert_type", "现场证书类型"),
   DEVICE_TYPE("device_type", "设备类型"),
   NC_SYSTEM("nc_system", "数控系统类型"),
   NC_FILE_TYPE("nc_file_type", "数控文件格式类型"),
   REASONS_FOR_BID_FAIL("reasons_for_bid_fail", "投标失败原因");

   private final String name;
   private final String remark;

   public static String getRemarkByName(String name) {
      for (DictionaryEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return ele.getRemark();
         }
      }

      return null;
   }

   public static boolean isExist(String name) {
      Optional<DictionaryEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getName().equals(name)).findFirst();
      return optional.isPresent();
   }

   public static boolean checkName(String name) {
      for (DictionaryEnum ele : values()) {
         if (ele.getName().equals(name)) {
            return true;
         }
      }

      return false;
   }

   public static List<SysDictionaryDTO> listAll() {
      List<SysDictionaryDTO> responseVOS = new ArrayList<>();

      for (DictionaryEnum ele : values()) {
         SysDictionaryDTO responseVO = new SysDictionaryDTO();
         responseVO.setRemark(ele.getRemark());
         responseVO.setName(ele.getName());
         responseVOS.add(responseVO);
      }

      return responseVOS;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   DictionaryEnum(final String name, final String remark) {
      this.name = name;
      this.remark = remark;
   }
}
