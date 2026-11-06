package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("组立导入类")
public class AssembleDTOParam {
   @ApiModelProperty(name = "orderNo", value = "序号")
   private Integer orderNo;
   @ApiModelProperty(name = "artifactNo", value = "构件号")
   private String artifactNo;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "assembleDetailDTOList", value = "腹板翼板列表")
   private List<AssembleMachinePartDTOParam> machinePartParamList;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getArtifactNo() {
      return this.artifactNo;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<AssembleMachinePartDTOParam> getMachinePartParamList() {
      return this.machinePartParamList;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setArtifactNo(final String artifactNo) {
      this.artifactNo = artifactNo;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
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

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMachinePartParamList(final List<AssembleMachinePartDTOParam> machinePartParamList) {
      this.machinePartParamList = machinePartParamList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleDTOParam)) {
         return false;
      }

      AssembleDTOParam other = (AssembleDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$artifactNo = this.getArtifactNo();
            Object other$artifactNo = other.getArtifactNo();
            if (this$artifactNo == null ? other$artifactNo == null : this$artifactNo.equals(other$artifactNo)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
                              Object this$drawingNumber = this.getDrawingNumber();
                              Object other$drawingNumber = other.getDrawingNumber();
                              if (this$drawingNumber == null ? other$drawingNumber == null : this$drawingNumber.equals(other$drawingNumber)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$machinePartParamList = this.getMachinePartParamList();
                                    Object other$machinePartParamList = other.getMachinePartParamList();
                                    return this$machinePartParamList == null
                                       ? other$machinePartParamList == null
                                       : this$machinePartParamList.equals(other$machinePartParamList);
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
      return other instanceof AssembleDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $artifactNo = this.getArtifactNo();
      result = result * 59 + ($artifactNo == null ? 43 : $artifactNo.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $machinePartParamList = this.getMachinePartParamList();
      return result * 59 + ($machinePartParamList == null ? 43 : $machinePartParamList.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleDTOParam(orderNo="
         + this.getOrderNo()
         + ", artifactNo="
         + this.getArtifactNo()
         + ", serialNumber="
         + this.getSerialNumber()
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
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", machinePartParamList="
         + this.getMachinePartParamList()
         + ")";
   }
}
