package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("InventoryAssembleImportDTO")
public class AssembleExportDTO implements Serializable {
   @Excel(name = "序号", orderNum = "1", width = 5.0)
   private Integer orderNo;
   @Excel(name = "部件号", orderNum = "2", width = 12.0)
   private String assembleNo;
   @Excel(name = "编号", orderNum = "3", width = 15.0)
   private String detailSerialNumber;
   @Excel(name = "规格", orderNum = "4", width = 20.0)
   private String specification;
   @Excel(name = "长度(mm)", orderNum = "5")
   private BigDecimal length;
   @Excel(name = "材质", orderNum = "6")
   private String material;
   @Excel(name = "数量", orderNum = "7", width = 8.0)
   private Integer quantity;
   @Excel(name = "单净重(kg)", orderNum = "8", width = 13.0)
   private BigDecimal netWeight;
   @Excel(name = "总净重(kg)", orderNum = "9", width = 13.0)
   private BigDecimal totalNetWeight;
   @Excel(name = "已生产", orderNum = "10")
   private Integer producedQuantity;
   @Excel(name = "已使用", orderNum = "11")
   private Integer usedQuantity;
   @Excel(name = "备注", orderNum = "11", width = 20.0)
   private String remark;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getAssembleNo() {
      return this.assembleNo;
   }

   public String getDetailSerialNumber() {
      return this.detailSerialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setAssembleNo(final String assembleNo) {
      this.assembleNo = assembleNo;
   }

   public void setDetailSerialNumber(final String detailSerialNumber) {
      this.detailSerialNumber = detailSerialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleExportDTO)) {
         return false;
      }

      AssembleExportDTO other = (AssembleExportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$producedQuantity = this.getProducedQuantity();
            Object other$producedQuantity = other.getProducedQuantity();
            if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
               Object this$usedQuantity = this.getUsedQuantity();
               Object other$usedQuantity = other.getUsedQuantity();
               if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                  Object this$assembleNo = this.getAssembleNo();
                  Object other$assembleNo = other.getAssembleNo();
                  if (this$assembleNo == null ? other$assembleNo == null : this$assembleNo.equals(other$assembleNo)) {
                     Object this$detailSerialNumber = this.getDetailSerialNumber();
                     Object other$detailSerialNumber = other.getDetailSerialNumber();
                     if (this$detailSerialNumber == null ? other$detailSerialNumber == null : this$detailSerialNumber.equals(other$detailSerialNumber)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$netWeight = this.getNetWeight();
                                 Object other$netWeight = other.getNetWeight();
                                 if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                    if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleExportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $assembleNo = this.getAssembleNo();
      result = result * 59 + ($assembleNo == null ? 43 : $assembleNo.hashCode());
      Object $detailSerialNumber = this.getDetailSerialNumber();
      result = result * 59 + ($detailSerialNumber == null ? 43 : $detailSerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleExportDTO(orderNo="
         + this.getOrderNo()
         + ", assembleNo="
         + this.getAssembleNo()
         + ", detailSerialNumber="
         + this.getDetailSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
