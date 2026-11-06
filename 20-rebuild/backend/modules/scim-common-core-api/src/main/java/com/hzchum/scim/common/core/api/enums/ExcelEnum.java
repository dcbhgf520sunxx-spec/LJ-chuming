package com.hzchum.scim.common.core.api.enums;

import com.google.common.base.Preconditions;

public enum ExcelEnum {
   INBOUND_RECORD_EXCEL(1, "files/templateV2/inboundDetail", "inboundDetail", "入库记录"),
   OUTBOUND_RECORD_EXCEL(2, "files/templateV2/templateV2/outboundDetail", "outboundDetail", "出库记录"),
   TRANSFER_RECORD_EXCEL(3, "files/templateV2/transferDetail", "transferDetail", "调拨记录"),
   RETURN_WAREHOUSE_RECORD_EXCEL(4, "files/templateV2/returnDetail", "returnDetail", "退库记录"),
   RDRATE_EXCEL(5, "files/templateV2/RDFeeDetail", "RDFeeDetail", "高新研发费"),
   RECEIVE_SEND_STORAGE_RECORD_EXCEL(6, "files/templateV2/statistics", " statistics", "收发存记录"),
   RECORD_EXCEL(7, "files/templateV2/statisticsDetail", "statisticsDetail", "记录"),
   MATERIAL_INVENTORY_EXCEL(8, "files/templateV2/materialInventory", "materialInventory", "物料库存记录"),
   PURCHASE_SELL_STOCK_DETAIL_EXCEL(9, "files/templateV2/PSIDetail", "PSIDetail", "进销存详情"),
   INVENTORY_DETAIL_BILL_EXCEL(10, "files/templateV2/inventoryDetails", "inventoryDetails", "存货明细账"),
   STEEL_PLATE_APPLY_PURCHASE_EXCEL(11, "files/templateV2/申购单模版", "申购单模版", "申购单模版"),
   SECTION_STEEL_APPLY_PURCHASE_EXCEL(12, "files/templateV2/申购单模版", "申购单模版", "申购单模版"),
   COLOR_ROLL_APPLY_PURCHASE_EXCEL(13, "files/templateV2/申购单模版", "申购单模版", "申购单模版"),
   GENERAL_MATERIAL_APPLY_PURCHASE_EXCEL(14, "files/templateV2/申购单模版", "申购单模版", "申购单模版"),
   STEEL_PLATE_PURCHASE_ORDER_EXCEL(15, "files/templateV2/钢板采购清单导入模版", "钢板采购清单导入模版", "钢板采购清单导入模版"),
   SECTION_STEEL_PURCHASE_ORDER_EXCEL(16, "files/templateV2/型材采购清单导入模版", "型材采购清单导入模版", "型材采购清单导入模版"),
   COLOR_ROLL_PURCHASE_ORDER_EXCEL(17, "files/templateV2/钢卷采购清单导入模版", "钢卷采购清单导入模版", "钢卷采购清单导入模版"),
   GENERAL_MATERIAL_PURCHASE_ORDER_EXCEL(18, "files/templateV2/辅材采购清单导入模版", "辅材采购清单导入模版", "辅材采购清单导入模版"),
   RETURN_WAREHOUSE_DETAIL_EXCEL(19, "files/templateV2/rejectDetail", "rejectDetail", "退货详情"),
   OTHER_PURCHASE_ORDER_EXCEL(21, "files/templateV2/办公用品采购清单导入模版", "办公用品采购清单导入模版", "办公用品采购清单导入模版"),
   GAS_PURCHASE_ORDER_EXCEL(22, "files/templateV2/气体采购清单导入模版", "气体采购清单导入模版", "气体采购清单导入模版"),
   OTHER_STEEL_MATERIALS_PURCHASE_ORDER_EXCEL(23, "files/templateV2/其它钢材采购清单导入模版", "其它钢材采购清单导入模版", "其它钢材采购清单导入模版"),
   OTHER_APPLY_PURCHASE_EXCEL(24, "files/templateV2/申购单模版", "申购单模版", "申购单模版"),
   GAS_APPLY_PURCHASE_EXCEL(25, "files/templateV2/申购单模版", "申购单模版", "申购单模版"),
   OTHER_STEEL_MATERIALS_APPLY_PURCHASE_EXCEL(26, "files/templateV2/申购单模版", "申购单模版", "申购单模版"),
   LUMP_SUM_SYSTEM_PURCHASE_ORDER_EXCEL(27, "files/templateV2/包干制采购清单导入模版", "包干制采购清单导入模版", "包干制采购清单导入模版"),
   OUTSOURCING_OUTBOUND_EXCEL(28, "files/templateV2/outsourcingOutboundDetail", "outsourcingOutboundDetail", "外协原料出库记录"),
   FOR_SALE_OUTBOUND_EXCEL(29, "files/templateV2/forSaleOutboundDetail", "forSaleOutboundDetail", "对外出售出库记录"),
   FOR_SALE_DIFFERENCE_OUTBOUND_EXCEL(30, "files/templateV2/forSaleDifferenceOutboundDetail", "forSaleDifferenceOutboundDetail", "对外出售价格差异记录"),
   SCRAPS_OUTBOUND_EXCEL(31, "files/templateV2/scrapsOutboundDetail", "scrapsOutboundDetail", "废料出库记录"),
   STEEL_PLATE_INBOUND_SELF_BUYING_EXCEL(32, "files/templateV2/自购钢板入库清单", "自购钢板入库清单", "自购钢板入库清单"),
   SECTION_STEEL_INBOUND_SELF_BUYING_EXCEL(33, "files/templateV2/自购型材入库清单", "自购型材入库清单", "自购型材入库清单"),
   COLOR_ROLL_INBOUND_SELF_BUYING_EXCEL(34, "files/templateV2/自购钢卷入库清单", "自购钢卷入库清单", "自购钢卷入库清单"),
   GENERAL_MATERIAL_INBOUND_SELF_BUYING_EXCEL(35, "files/templateV2/自购辅材入库清单", "自购辅材入库清单", "自购辅材入库清单"),
   OTHER_INBOUND_SELF_BUYING_EXCEL(36, "files/templateV2/自购办公用品入库清单", "自购办公用品入库清单", "自购办公用品入库清单"),
   GAS_INBOUND_SELF_BUYING_EXCEL(37, "files/templateV2/自购气体入库清单", "自购气体入库清单", "自购气体入库清单"),
   OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_EXCEL(38, "files/templateV2/自购其它钢材入库清单", "自购其它钢材入库清单", "自购其它钢材入库清单"),
   STEEL_PLATE_INBOUND_PARTY_A_EXCEL(39, "files/templateV2/甲供钢板入库清单", "甲供钢板入库清单", "甲供钢板入库清单"),
   SECTION_STEEL_INBOUND_PARTY_A_EXCEL(40, "files/templateV2/甲供型材入库清单", "甲供型材入库清单", "甲供型材入库清单"),
   COLOR_ROLL_INBOUND_PARTY_A_EXCEL(41, "files/templateV2/甲供钢卷入库清单", "甲供钢卷入库清单", "甲供钢卷入库清单"),
   GENERAL_MATERIAL_INBOUND_PARTY_A_EXCEL(42, "files/templateV2/甲供辅材入库清单", "甲供辅材入库清单", "甲供辅材入库清单"),
   OTHER_INBOUND_PARTY_A_EXCEL(43, "files/templateV2/甲供办公用品入库清单", "甲供办公用品入库清单", "甲供办公用品入库清单"),
   GAS_INBOUND_PARTY_A_EXCEL(44, "files/templateV2/甲供气体入库清单", "甲供气体入库清单", "甲供气体入库清单"),
   OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_EXCEL(45, "files/templateV2/甲供其它钢材入库清单", "甲供其它钢材入库清单", "甲供其它钢材入库清单"),
   SURPLUS_EXCEL(60, "files/templateV2/wmsSurplus", "wmsSurplus", "盘盈单"),
   STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_TEMPLATE(65, "files/templateV2/自采物料期初导入模板-钢板", "自采物料期初导入模板-钢板", "自采物料期初导入模板-钢板"),
   SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE(66, "files/templateV2/自采物料期初导入模板-型材", "自采物料期初导入模板-型材", "自采物料期初导入模板-型材"),
   COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE(67, "files/templateV2/自采物料期初导入模板-钢卷", "自采物料期初导入模板-钢卷", "自采物料期初导入模板-钢卷"),
   GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_TEMPLATE(68, "files/templateV2/自采物料期初导入模板-辅材", "自采物料期初导入模板-辅材", "自采物料期初导入模板-辅材"),
   OTHER_INBOUND_SELF_BUYING_BEGIN_TEMPLATE(69, "files/templateV2/自采物料期初导入模板-办公用品", "自采物料期初导入模板-办公用品", "自采物料期初导入模板-办公用品"),
   GAS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE(70, "files/templateV2/自采物料期初导入模板-气体", "自采物料期初导入模板-气体", "自采物料期初导入模板-气体"),
   OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_TEMPLATE(71, "files/templateV2/自采物料期初导入模板-其它钢材", "自采物料期初导入模板-其它钢材", "自采物料期初导入模板-其它钢材"),
   STEEL_PLATE_INBOUND_PARTY_A_BEGIN_TEMPLATE(72, "files/templateV2/甲供物料期初导入模板-钢板", "甲供物料期初导入模板-钢板", "甲供物料期初导入模板-钢板"),
   SECTION_STEEL_INBOUND_PARTY_A_BEGIN_TEMPLATE(73, "files/templateV2/甲供物料期初导入模板-型材", "甲供物料期初导入模板-型材", "甲供物料期初导入模板-型材"),
   COLOR_ROLL_INBOUND_PARTY_A_BEGIN_TEMPLATE(74, "files/templateV2/甲供物料期初导入模板-钢卷", "甲供物料期初导入模板-钢卷", "甲供物料期初导入模板-钢卷"),
   GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_TEMPLATE(75, "files/templateV2/甲供物料期初导入模板-辅材", "甲供物料期初导入模板-辅材", "甲供物料期初导入模板-辅材"),
   OTHER_INBOUND_PARTY_A_BEGIN_TEMPLATE(76, "files/templateV2/甲供物料期初导入模板-办公用品", "甲供物料期初导入模板-办公用品", "甲供物料期初导入模板-办公用品"),
   GAS_INBOUND_PARTY_A_BEGIN_TEMPLATE(77, "files/templateV2/甲供物料期初导入模板-气体", "甲供物料期初导入模板-气体", "甲供物料期初导入模板-气体"),
   OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_TEMPLATE(78, "files/templateV2/甲供物料期初导入模板-其它钢材", "甲供物料期初导入模板-其它钢材", "甲供物料期初导入模板-其它钢材"),
   STEEL_PLATE_INBOUND_SELF_BUYING_BEGIN_EXCEL(79, "files/templateV2/自采物料库存-钢板", "自采物料库存-钢板", "自采物料库存-钢板"),
   SECTION_STEEL_INBOUND_SELF_BUYING_BEGIN_EXCEL(80, "files/templateV2/自采物料库存-型材", "自采物料库存-型材", "自采物料库存-型材"),
   COLOR_ROLL_INBOUND_SELF_BUYING_BEGIN_EXCEL(81, "files/templateV2/自采物料库存-钢卷", "自采物料库存-钢卷", "自采物料库存-钢卷"),
   GENERAL_MATERIAL_INBOUND_SELF_BUYING_BEGIN_EXCEL(82, "files/templateV2/自采物料库存-辅材", "自采物料库存-辅材", "自采物料库存-辅材"),
   OTHER_INBOUND_SELF_BUYING_BEGIN_EXCEL(83, "files/templateV2/自采物料库存-办公用品", "自采物料库存-办公用品", "自采物料库存-办公用品"),
   GAS_INBOUND_SELF_BUYING_BEGIN_EXCEL(84, "files/templateV2/自采物料库存-气体", "自采物料库存-气体", "自采物料库存-气体"),
   OTHER_STEEL_MATERIALS_INBOUND_SELF_BUYING_BEGIN_EXCEL(85, "files/templateV2/自采物料库存-其它钢材", "自采物料库存-其它钢材", "自采物料库存-其它钢材"),
   STEEL_PLATE_INBOUND_PARTY_A_BEGIN_EXCEL(86, "files/templateV2/甲供物料库存-钢板", "甲供物料库存-钢板", "甲供物料库存-钢板"),
   SECTION_STEEL_INBOUND_PARTY_A_BEGIN_EXCEL(87, "files/templateV2/甲供物料库存-型材", "甲供物料库存-型材", "甲供物料库存-型材"),
   COLOR_ROLL_INBOUND_PARTY_A_BEGIN_EXCEL(88, "files/templateV2/甲供物料库存-钢卷", "甲供物料库存-钢卷", "甲供物料库存-钢卷"),
   GENERAL_MATERIAL_INBOUND_PARTY_A_BEGIN_EXCEL(89, "files/templateV2/甲供物料库存-辅材", "甲供物料库存-辅材", "甲供物料库存-辅材"),
   OTHER_INBOUND_PARTY_A_BEGIN_EXCEL(90, "files/templateV2/甲供物料库存-办公用品", "甲供物料库存-办公用品", "甲供物料库存-办公用品"),
   GAS_INBOUND_PARTY_A_BEGIN_EXCEL(91, "files/templateV2/甲供物料库存-气体", "甲供物料库存-气体", "甲供物料库存-气体"),
   OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_BEGIN_EXCEL(92, "files/templateV2/甲供物料库存-其它钢材", "甲供物料库存-其它钢材", "甲供物料库存-其它钢材"),
   STEEL_PLATE_INBOUND_SELF_SURPLUS_TEMPLATE(100, "files/templateV2/自采物料盘盈导入模板-钢板", "自采物料盘盈导入模板-钢板", "自采物料盘盈导入模板-钢板"),
   SECTION_STEEL_INBOUND_SELF_SURPLUS_TEMPLATE(101, "files/templateV2/自采物料盘盈导入模板-型材", "自采物料盘盈导入模板-型材", "自采物料盘盈导入模板-型材"),
   COLOR_ROLL_INBOUND_SELF_SURPLUS_TEMPLATE(102, "files/templateV2/自采物料盘盈导入模板-钢卷", "自采物料盘盈导入模板-钢卷", "自采物料盘盈导入模板-钢卷"),
   GENERAL_MATERIAL_INBOUND_SELF_SURPLUS_TEMPLATE(103, "files/templateV2/自采物料盘盈导入模板-辅材", "自采物料盘盈导入模板-辅材", "自采物料盘盈导入模板-辅材"),
   OTHER_INBOUND_SELF_SURPLUS_TEMPLATE(104, "files/templateV2/自采物料盘盈导入模板-办公用品", "自采物料盘盈导入模板-办公用品", "自采物料盘盈导入模板-办公用品"),
   GAS_INBOUND_SELF_SURPLUS_TEMPLATE(105, "files/templateV2/自采物料盘盈导入模板-气体", "自采物料盘盈导入模板-气体", "自采物料盘盈导入模板-气体"),
   OTHER_STEEL_MATERIALS_INBOUND_SELF_SURPLUS_TEMPLATE(106, "files/templateV2/自采物料盘盈导入模板-其它钢材", "自采物料盘盈导入模板-其它钢材", "自采物料盘盈导入模板-其它钢材"),
   STEEL_PLATE_INBOUND_PARTY_A_SURPLUS_TEMPLATE(107, "files/templateV2/甲供物料盘盈导入模板-钢板", "甲供物料盘盈导入模板-钢板", "甲供物料盘盈导入模板-钢板"),
   SECTION_STEEL_INBOUND_PARTY_A_SURPLUS_TEMPLATE(108, "files/templateV2/甲供物料盘盈导入模板-型材", "甲供物料盘盈导入模板-型材", "甲供物料盘盈导入模板-型材"),
   COLOR_ROLL_INBOUND_PARTY_A_SURPLUS_TEMPLATE(109, "files/templateV2/甲供物料盘盈导入模板-钢卷", "甲供物料盘盈导入模板-钢卷", "甲供物料盘盈导入模板-钢卷"),
   GENERAL_MATERIAL_INBOUND_PARTY_A_SURPLUS_TEMPLATE(110, "files/templateV2/甲供物料盘盈导入模板-辅材", "甲供物料盘盈导入模板-辅材", "甲供物料盘盈导入模板-辅材"),
   OTHER_INBOUND_PARTY_A_SURPLUS_TEMPLATE(111, "files/templateV2/甲供物料盘盈导入模板-办公用品", "甲供物料盘盈导入模板-办公用品", "甲供物料盘盈导入模板-办公用品"),
   GAS_INBOUND_PARTY_A_SURPLUS_TEMPLATE(112, "files/templateV2/甲供物料盘盈导入模板-气体", "甲供物料盘盈导入模板-气体", "甲供物料盘盈导入模板-气体"),
   OTHER_STEEL_MATERIALS_INBOUND_PARTY_A_SURPLUS_TEMPLATE(113, "files/templateV2/甲供物料盘盈导入模板-其它钢材", "甲供物料盘盈导入模板-其它钢材", "甲供物料盘盈导入模板-其它钢材"),
   STEEL_PLATE_CAN_LOSS_EXCEL(120, "files/templateV2/自采可盘亏物料库存-钢板", "自采可盘亏物料库存-钢板", "盘亏物料库存-钢板"),
   SECTION_STEEL_CAN_LOSS_EXCEL(121, "files/templateV2/自采可盘亏物料库存-型材", "自采可盘亏物料库存-型材", "盘亏物料库存-型材"),
   COLOR_ROLL_CAN_LOSS_EXCEL(122, "files/templateV2/自采可盘亏物料库存-钢卷", "自采可盘亏物料库存-钢卷", "盘亏物料库存-钢卷"),
   GENERAL_MATERIAL_CAN_LOSS_EXCEL(123, "files/templateV2/自采可盘亏物料库存-辅材", "自采可盘亏物料库存-辅材", "盘亏物料库存-辅材"),
   OTHER_CAN_LOSS_EXCEL(124, "files/templateV2/自采可盘亏物料库存-办公用品", "自采可盘亏物料库存-办公用品", "盘亏物料库存-办公用品"),
   GAS_CAN_LOSS_EXCEL(125, "files/templateV2/自采可盘亏物料库存-气体", "自采可盘亏物料库存-气体", "盘亏物料库存-气体"),
   OTHER_STEEL_CAN_LOSS_EXCEL(126, "files/templateV2/自采可盘亏物料库存-其它钢材", "自采可盘亏物料库存-其它钢材", "盘亏物料库存-其它钢材");

   private Integer type;
   private String resourcePath;
   private String tempFileName;
   private String exportFileName;

   ExcelEnum(int type, String resourcePath, String tempFileName, String exportFileName) {
      this.type = type;
      this.resourcePath = resourcePath;
      this.tempFileName = tempFileName;
      this.exportFileName = exportFileName;
   }

   public static ExcelEnum selectType(Integer type) {
      for (ExcelEnum value : values()) {
         if (value.type.equals(type)) {
            return value;
         }
      }

      Preconditions.checkArgument(false, "枚举类未查询到!!");
      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getResourcePath() {
      return this.resourcePath;
   }

   public String getTempFileName() {
      return this.tempFileName;
   }

   public String getExportFileName() {
      return this.exportFileName;
   }
}
