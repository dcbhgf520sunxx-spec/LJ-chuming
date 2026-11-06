package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("构件编号变更请求类")
public class ArtifactNumberChangeDTOParam {
   @ApiModelProperty("单体id（单体区域任意一个必传）")
   private Long monomerId;
   @ApiModelProperty("区域id（单体区域任意一个必传）")
   private Long areaId;
   @ApiModelProperty("构件旧编号")
   @NotNull(message = "构件旧编号不能为空")
   private String oldSerialNumber;
   @ApiModelProperty("构件新编号")
   @NotNull(message = "编号新不能为空")
   private String newSerialNumber;
   @ApiModelProperty("数量")
   @NotNull(message = "数量不能为空")
   private Integer quantity;
   @ApiModelProperty("规格")
   @NotEmpty(message = "规格不能为空")
   private String specification;
   @ApiModelProperty("长度（mm）")
   @NotNull(message = "长度")
   private BigDecimal length;
   @ApiModelProperty("单面积（mm2）")
   @NotNull(message = "单面积不能为空")
   private BigDecimal surfaceArea;
   @ApiModelProperty("图号")
   private String drawingNumber;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("零件信息")
   @NotEmpty(message = "零件信息不能为空")
   private List<PartChangeDTOParam> parts;
   @ApiModelProperty("变更理由")
   @NotNull(message = "变更理由")
   private Long reasonId;
   @ApiModelProperty("变更备注")
   private String changeRemark;
   @ApiModelProperty("附件")
   private List<Long> attachments;

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getOldSerialNumber() {
      return this.oldSerialNumber;
   }

   public String getNewSerialNumber() {
      return this.newSerialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<PartChangeDTOParam> getParts() {
      return this.parts;
   }

   public Long getReasonId() {
      return this.reasonId;
   }

   public String getChangeRemark() {
      return this.changeRemark;
   }

   public List<Long> getAttachments() {
      return this.attachments;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setOldSerialNumber(final String oldSerialNumber) {
      this.oldSerialNumber = oldSerialNumber;
   }

   public void setNewSerialNumber(final String newSerialNumber) {
      this.newSerialNumber = newSerialNumber;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setParts(final List<PartChangeDTOParam> parts) {
      this.parts = parts;
   }

   public void setReasonId(final Long reasonId) {
      this.reasonId = reasonId;
   }

   public void setChangeRemark(final String changeRemark) {
      this.changeRemark = changeRemark;
   }

   public void setAttachments(final List<Long> attachments) {
      this.attachments = attachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactNumberChangeDTOParam)) {
         return false;
      }

      ArtifactNumberChangeDTOParam other = (ArtifactNumberChangeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$reasonId = this.getReasonId();
               Object other$reasonId = other.getReasonId();
               if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
                  Object this$oldSerialNumber = this.getOldSerialNumber();
                  Object other$oldSerialNumber = other.getOldSerialNumber();
                  if (this$oldSerialNumber == null ? other$oldSerialNumber == null : this$oldSerialNumber.equals(other$oldSerialNumber)) {
                     Object this$newSerialNumber = this.getNewSerialNumber();
                     Object other$newSerialNumber = other.getNewSerialNumber();
                     if (this$newSerialNumber == null ? other$newSerialNumber == null : this$newSerialNumber.equals(other$newSerialNumber)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$surfaceArea = this.getSurfaceArea();
                              Object other$surfaceArea = other.getSurfaceArea();
                              if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                 Object this$drawingNumber = this.getDrawingNumber();
                                 Object other$drawingNumber = other.getDrawingNumber();
                                 if (this$drawingNumber == null ? other$drawingNumber == null : this$drawingNumber.equals(other$drawingNumber)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$parts = this.getParts();
                                       Object other$parts = other.getParts();
                                       if (this$parts == null ? other$parts == null : this$parts.equals(other$parts)) {
                                          Object this$changeRemark = this.getChangeRemark();
                                          Object other$changeRemark = other.getChangeRemark();
                                          if (this$changeRemark == null ? other$changeRemark == null : this$changeRemark.equals(other$changeRemark)) {
                                             Object this$attachments = this.getAttachments();
                                             Object other$attachments = other.getAttachments();
                                             return this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactNumberChangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $oldSerialNumber = this.getOldSerialNumber();
      result = result * 59 + ($oldSerialNumber == null ? 43 : $oldSerialNumber.hashCode());
      Object $newSerialNumber = this.getNewSerialNumber();
      result = result * 59 + ($newSerialNumber == null ? 43 : $newSerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $parts = this.getParts();
      result = result * 59 + ($parts == null ? 43 : $parts.hashCode());
      Object $changeRemark = this.getChangeRemark();
      result = result * 59 + ($changeRemark == null ? 43 : $changeRemark.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactNumberChangeDTOParam(monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", oldSerialNumber="
         + this.getOldSerialNumber()
         + ", newSerialNumber="
         + this.getNewSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", parts="
         + this.getParts()
         + ", reasonId="
         + this.getReasonId()
         + ", changeRemark="
         + this.getChangeRemark()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }
}
