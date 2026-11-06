package com.hzchum.scim.plan.core.api.pojo.dto.change;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("围护数量变更请求类")
public class EnclosureQuantityChangeDTOParam {
   @ApiModelProperty("围护id")
   @NotNull(message = "围护id不能为空")
   private Long id;
   @ApiModelProperty("修改后数量")
   @NotNull(message = "数量不能为空")
   @Min(value = 0L, message = "数量不能为负数!")
   @Max(value = 999999999L, message = "数量太大,超出范围!")
   private Integer quantity;
   @ApiModelProperty("变更类型")
   @NotNull(message = "变更类型")
   private Long reasonId;
   @ApiModelProperty("变更备注")
   private String changeRemark;

   public static EnclosureQuantityChangeDTOParam.EnclosureQuantityChangeDTOParamBuilder builder() {
      return new EnclosureQuantityChangeDTOParam.EnclosureQuantityChangeDTOParamBuilder();
   }

   public EnclosureQuantityChangeDTOParam(final Long id, final Integer quantity, final Long reasonId, final String changeRemark) {
      this.id = id;
      this.quantity = quantity;
      this.reasonId = reasonId;
      this.changeRemark = changeRemark;
   }

   public EnclosureQuantityChangeDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getReasonId() {
      return this.reasonId;
   }

   public String getChangeRemark() {
      return this.changeRemark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setReasonId(final Long reasonId) {
      this.reasonId = reasonId;
   }

   public void setChangeRemark(final String changeRemark) {
      this.changeRemark = changeRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureQuantityChangeDTOParam)) {
         return false;
      }

      EnclosureQuantityChangeDTOParam other = (EnclosureQuantityChangeDTOParam)o;
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
               Object this$changeRemark = this.getChangeRemark();
               Object other$changeRemark = other.getChangeRemark();
               return this$changeRemark == null ? other$changeRemark == null : this$changeRemark.equals(other$changeRemark);
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
      return other instanceof EnclosureQuantityChangeDTOParam;
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
      Object $changeRemark = this.getChangeRemark();
      return result * 59 + ($changeRemark == null ? 43 : $changeRemark.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureQuantityChangeDTOParam(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", reasonId="
         + this.getReasonId()
         + ", changeRemark="
         + this.getChangeRemark()
         + ")";
   }

   public static class EnclosureQuantityChangeDTOParamBuilder {
      private Long id;
      private Integer quantity;
      private Long reasonId;
      private String changeRemark;

      EnclosureQuantityChangeDTOParamBuilder() {
      }

      public EnclosureQuantityChangeDTOParam.EnclosureQuantityChangeDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public EnclosureQuantityChangeDTOParam.EnclosureQuantityChangeDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public EnclosureQuantityChangeDTOParam.EnclosureQuantityChangeDTOParamBuilder reasonId(final Long reasonId) {
         this.reasonId = reasonId;
         return this;
      }

      public EnclosureQuantityChangeDTOParam.EnclosureQuantityChangeDTOParamBuilder changeRemark(final String changeRemark) {
         this.changeRemark = changeRemark;
         return this;
      }

      public EnclosureQuantityChangeDTOParam build() {
         return new EnclosureQuantityChangeDTOParam(this.id, this.quantity, this.reasonId, this.changeRemark);
      }

      @Override
      public String toString() {
         return "EnclosureQuantityChangeDTOParam.EnclosureQuantityChangeDTOParamBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", reasonId="
            + this.reasonId
            + ", changeRemark="
            + this.changeRemark
            + ")";
      }
   }
}
