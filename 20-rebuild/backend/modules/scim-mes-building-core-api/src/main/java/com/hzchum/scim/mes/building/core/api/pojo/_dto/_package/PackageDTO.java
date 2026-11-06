package com.hzchum.scim.mes.building.core.api.pojo._dto._package;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.PackageDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "包 ")
public class PackageDTO extends PackageDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("包内数量")
   private BigDecimal quantity;
   @ApiModelProperty("包内核算量")
   private BigDecimal mete;
   @ApiModelProperty("围护长度")
   private BigDecimal enclLength;
   @ApiModelProperty("总长度")
   private BigDecimal totalLength;
   @ApiModelProperty("结构毛重")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("结构净重")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "attachmentIds", value = "附件ids", notes = "附件ids")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentDTOS", value = "附件")
   private List<AttachmentDTO> attachmentDTOS;

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getEnclLength() {
      return this.enclLength;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   @Override
   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setEnclLength(final BigDecimal enclLength) {
      this.enclLength = enclLength;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public void setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PackageDTO)) {
         return false;
      }

      PackageDTO other = (PackageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$enclLength = this.getEnclLength();
            Object other$enclLength = other.getEnclLength();
            if (this$enclLength == null ? other$enclLength == null : this$enclLength.equals(other$enclLength)) {
               Object this$totalLength = this.getTotalLength();
               Object other$totalLength = other.getTotalLength();
               if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                  Object this$totalGrossWeight = this.getTotalGrossWeight();
                  Object other$totalGrossWeight = other.getTotalGrossWeight();
                  if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                     Object this$totalNetWeight = this.getTotalNetWeight();
                     Object other$totalNetWeight = other.getTotalNetWeight();
                     if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                        Object this$attachmentIds = this.getAttachmentIds();
                        Object other$attachmentIds = other.getAttachmentIds();
                        if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                           Object this$attachmentDTOS = this.getAttachmentDTOS();
                           Object other$attachmentDTOS = other.getAttachmentDTOS();
                           return this$attachmentDTOS == null ? other$attachmentDTOS == null : this$attachmentDTOS.equals(other$attachmentDTOS);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof PackageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $enclLength = this.getEnclLength();
      result = result * 59 + ($enclLength == null ? 43 : $enclLength.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      return result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "PackageDTO(quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", enclLength="
         + this.getEnclLength()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ")";
   }
}
