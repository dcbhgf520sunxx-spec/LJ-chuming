package com.hzchum.scim.system.core.api.common.enums;

import java.util.Arrays;
import java.util.Optional;

public enum NumberTypeEnum {
   MASTER_CONTRACT(1, "主合同"),
   CONTRACT(2, "承包合同"),
   PURCHASE_CONTRACT(3, "原材料采购合同"),
   SUB_CONTRACT(4, "分包合同"),
   FOREIGN_VISA(5, "对外签证"),
   DOMESTIC_VISA(6, "对内签证"),
   BREACH_RECORD(7, "违约记录"),
   REQUISITIONS(8, "申购合同"),
   INBOUND(9, "入库单"),
   OUTBOUND_APPLY(10, "出库申请单"),
   SALES_RETURN(11, "退货单"),
   MATERIAL_RETURN(12, "退库单"),
   WAREHOUSE_VERIFICATION(13, "入库核销单"),
   WITHDRAWAL_VERIFICATION(14, "退货核销单"),
   SUPPLIER(15, "供应商"),
   LOGISTICS_ORDER(16, "物流订单"),
   OUTBOUND_REVIEW(17, "出库审核单"),
   TRANSFER(18, "调拨单"),
   SUPPLEMENT(19, "红冲单"),
   MANUFACTURES_CONTRACT(20, "制成品采购合同"),
   MANUFACTURES_INBOUND(21, "制成品入库单"),
   MANUFACTURES_CONVERT(22, "条板转换单"),
   MANUFACTURES_CROSS(23, "跨组织出库"),
   MANUFACTURES_BORROW(24, "临时借出出库单"),
   MANUFACTURES_BORROW_TH(25, "临时借出归还"),
   MANUFACTURES_BORROW_BS(26, "临时借出报损"),
   FOR_SALE(27, "对外出售出库单"),
   OUTSOURCING_RAW_MATERIALS(28, "外协原料出库单"),
   SCRAPS(29, "废料出库单"),
   MANUFACTURES_CROSS_REVIEW(30, "跨组织出库审核单"),
   MANUFACTURES_BORROW_REVIEW(31, "临时借出出库审核单"),
   MANUFACTURES_BORROW_TH_REVIEW(32, "临时借出归还审核单"),
   MANUFACTURES_BORROW_BS_REVIEW(33, "临时借出报损审核单"),
   FOR_SALE_REVIEW(34, "对外出售出库审核单"),
   OUTSOURCING_RAW_MATERIALS_REVIEW(35, "外协原料出库审核单"),
   SCRAPS_REVIEW(36, "废料出库审核单"),
   PROJECT_REJECT(37, "外购退货单"),
   MANUFACTURES_ADJUST(40, "价格调整单"),
   MANUFACTURES_DEFICIT(41, "盘亏单"),
   SUPPLIER_EVALUATE(42, "供应商评价"),
   MOVE_WAREHOUSE(50, "移库单"),
   SCHEDULING_OUTBOUND(101, "领料排产出库单"),
   INBOUND_MANUFACTURED(155, "制成品入库单"),
   OUTBOUND_MANUFACTURED(156, "制成品出库单"),
   RETURN_MANUFACTURED(157, "制成品退库单"),
   PLANT_CONVERT(158, "钢板转换单"),
   MANUFACTURES_SURPLUS(200, "盘盈单"),
   SHIPMENT_RECEIVE(213, "发货领用单");

   private final int type;
   private final String name;

   NumberTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static boolean isExist(int type) {
      Optional<NumberTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }
}
