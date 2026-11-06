package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("构件数量变更请求类")
public class ArtifactQuantityChangeDTOParam {
   @ApiModelProperty("构件id")
   @NotNull(message = "构件id不能为空")
   private Long id;
   @ApiModelProperty("修改后数量")
   @NotNull(message = "数量不能为空")
   @Min(value = 0L, message = "数量不能为负数!")
   @Max(value = 999999999L, message = "数量太大,超出范围!")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "变更单净重(kg)")
   @NotNull(message = "单净重不能为空")
   @DecimalMax(value = "9999999999", message = "单净重太大!")
   @DecimalMin(value = "0.000001", message = "单净重太小!")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "变更单毛重(kg)")
   @DecimalMax(value = "9999999999", message = "单毛重太大!")
   @DecimalMin(value = "0", message = "单毛重太小!")
   private BigDecimal grossWeight;
   @ApiModelProperty("变更理由")
   @NotNull(message = "变更理由")
   private Long reasonId;
   @ApiModelProperty("变更备注")
   private String changeRemark;
   @ApiModelProperty("附件")
   private List<Long> attachments;

   public static ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder builder() {
      return new ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder();
   }

   public ArtifactQuantityChangeDTOParam(
      final Long id,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final Long reasonId,
      final String changeRemark,
      final List<Long> attachments
   ) {
      this.id = id;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.reasonId = reasonId;
      this.changeRemark = changeRemark;
      this.attachments = attachments;
   }

   public ArtifactQuantityChangeDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
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

      if (!(o instanceof ArtifactQuantityChangeDTOParam)) {
         return false;
      }

      ArtifactQuantityChangeDTOParam other = (ArtifactQuantityChangeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$reasonId = this.getReasonId();
            Object other$reasonId = other.getReasonId();
            if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
               Object this$netWeight = this.getNetWeight();
               Object other$netWeight = other.getNetWeight();
               if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                  Object this$grossWeight = this.getGrossWeight();
                  Object other$grossWeight = other.getGrossWeight();
                  if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactQuantityChangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $changeRemark = this.getChangeRemark();
      result = result * 59 + ($changeRemark == null ? 43 : $changeRemark.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactQuantityChangeDTOParam(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", reasonId="
         + this.getReasonId()
         + ", changeRemark="
         + this.getChangeRemark()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }

   public static class ArtifactQuantityChangeDTOParamBuilder {
      private Long id;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private Long reasonId;
      private String changeRemark;
      private List<Long> attachments;

      ArtifactQuantityChangeDTOParamBuilder() {
      }

      public ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder reasonId(final Long reasonId) {
         this.reasonId = reasonId;
         return this;
      }

      public ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder changeRemark(final String changeRemark) {
         this.changeRemark = changeRemark;
         return this;
      }

      public ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder attachments(final List<Long> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ArtifactQuantityChangeDTOParam build() {
         return new ArtifactQuantityChangeDTOParam(this.id, this.quantity, this.netWeight, this.grossWeight, this.reasonId, this.changeRemark, this.attachments);
      }

      @Override
      public String toString() {
         return "ArtifactQuantityChangeDTOParam.ArtifactQuantityChangeDTOParamBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", reasonId="
            + this.reasonId
            + ", changeRemark="
            + this.changeRemark
            + ", attachments="
            + this.attachments
            + ")";
      }
   }
}
