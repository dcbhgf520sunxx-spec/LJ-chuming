package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("构件变更 请求类")
public class ArtifactChangeDTOParam {
   @ApiModelProperty(name = "id", value = "构件id")
   @NotNull(message = "构件id不能为空")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @NotBlank(message = "规格不能为空")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   @NotBlank(message = "材质不能为空")
   private String material;
   @ApiModelProperty(name = "surfaceArea", value = "面积（㎡）")
   @NotNull(message = "面积不能为空")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @NotNull(message = "长度不能为空")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "老数量")
   private Integer quantity;
   @ApiModelProperty(name = "quantity", value = "新数量")
   private Integer newQuantity;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "machinePartList", value = "零件列表")
   private List<MachinePartDTOParam> machinePartDTOList;
   @ApiModelProperty(name = "changeReason", value = "变更原因")
   @NotBlank(message = "变更原因不能为空")
   private String changeReason;
   @ApiModelProperty(name = "attachmentIds", value = "附件id数组")
   private Long[] attachmentIds;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getNewQuantity() {
      return this.newQuantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<MachinePartDTOParam> getMachinePartDTOList() {
      return this.machinePartDTOList;
   }

   public String getChangeReason() {
      return this.changeReason;
   }

   public Long[] getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNewQuantity(final Integer newQuantity) {
      this.newQuantity = newQuantity;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMachinePartDTOList(final List<MachinePartDTOParam> machinePartDTOList) {
      this.machinePartDTOList = machinePartDTOList;
   }

   public void setChangeReason(final String changeReason) {
      this.changeReason = changeReason;
   }

   public void setAttachmentIds(final Long[] attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactChangeDTOParam)) {
         return false;
      }

      ArtifactChangeDTOParam other = (ArtifactChangeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$newQuantity = this.getNewQuantity();
            Object other$newQuantity = other.getNewQuantity();
            if (this$newQuantity == null ? other$newQuantity == null : this$newQuantity.equals(other$newQuantity)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$surfaceArea = this.getSurfaceArea();
                        Object other$surfaceArea = other.getSurfaceArea();
                        if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$machinePartDTOList = this.getMachinePartDTOList();
                                 Object other$machinePartDTOList = other.getMachinePartDTOList();
                                 if (this$machinePartDTOList == null
                                    ? other$machinePartDTOList == null
                                    : this$machinePartDTOList.equals(other$machinePartDTOList)) {
                                    Object this$changeReason = this.getChangeReason();
                                    Object other$changeReason = other.getChangeReason();
                                    return (this$changeReason == null ? other$changeReason == null : this$changeReason.equals(other$changeReason))
                                       ? Arrays.deepEquals(this.getAttachmentIds(), other.getAttachmentIds())
                                       : false;
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
      return other instanceof ArtifactChangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $newQuantity = this.getNewQuantity();
      result = result * 59 + ($newQuantity == null ? 43 : $newQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $machinePartDTOList = this.getMachinePartDTOList();
      result = result * 59 + ($machinePartDTOList == null ? 43 : $machinePartDTOList.hashCode());
      Object $changeReason = this.getChangeReason();
      result = result * 59 + ($changeReason == null ? 43 : $changeReason.hashCode());
      return result * 59 + Arrays.deepHashCode(this.getAttachmentIds());
   }

   @Override
   public String toString() {
      return "ArtifactChangeDTOParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", newQuantity="
         + this.getNewQuantity()
         + ", remark="
         + this.getRemark()
         + ", machinePartDTOList="
         + this.getMachinePartDTOList()
         + ", changeReason="
         + this.getChangeReason()
         + ", attachmentIds="
         + Arrays.deepToString(this.getAttachmentIds())
         + ")";
   }
}
