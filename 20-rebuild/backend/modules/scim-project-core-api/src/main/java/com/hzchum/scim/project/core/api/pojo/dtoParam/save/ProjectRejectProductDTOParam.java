package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProjectRejectProductDTOParam", description = "退货请求类")
public class ProjectRejectProductDTOParam {
   @ApiModelProperty(name = "收货记录id")
   @NotNull(message = "收货记录id不能为空!!!")
   private Long receivedId;
   @ApiModelProperty(name = "receivedQuantity", value = "退货数量", notes = "退货数量")
   @NotNull(message = "退货数量不能为空!!!")
   private BigDecimal rejectQuantity;
   @ApiModelProperty(name = "rejectActualReceivedMete", value = "实际退货量", notes = "实际退货量")
   @NotNull(message = "实际退货量不能为空!!!")
   private BigDecimal rejectActualReceivedMete;

   public static ProjectRejectProductDTOParam.ProjectRejectProductDTOParamBuilder builder() {
      return new ProjectRejectProductDTOParam.ProjectRejectProductDTOParamBuilder();
   }

   public ProjectRejectProductDTOParam() {
   }

   public ProjectRejectProductDTOParam(final Long receivedId, final BigDecimal rejectQuantity, final BigDecimal rejectActualReceivedMete) {
      this.receivedId = receivedId;
      this.rejectQuantity = rejectQuantity;
      this.rejectActualReceivedMete = rejectActualReceivedMete;
   }

   public Long getReceivedId() {
      return this.receivedId;
   }

   public BigDecimal getRejectQuantity() {
      return this.rejectQuantity;
   }

   public BigDecimal getRejectActualReceivedMete() {
      return this.rejectActualReceivedMete;
   }

   public void setReceivedId(final Long receivedId) {
      this.receivedId = receivedId;
   }

   public void setRejectQuantity(final BigDecimal rejectQuantity) {
      this.rejectQuantity = rejectQuantity;
   }

   public void setRejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
      this.rejectActualReceivedMete = rejectActualReceivedMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectRejectProductDTOParam)) {
         return false;
      }

      ProjectRejectProductDTOParam other = (ProjectRejectProductDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$receivedId = this.getReceivedId();
      Object other$receivedId = other.getReceivedId();
      if (this$receivedId == null ? other$receivedId == null : this$receivedId.equals(other$receivedId)) {
         Object this$rejectQuantity = this.getRejectQuantity();
         Object other$rejectQuantity = other.getRejectQuantity();
         if (this$rejectQuantity == null ? other$rejectQuantity == null : this$rejectQuantity.equals(other$rejectQuantity)) {
            Object this$rejectActualReceivedMete = this.getRejectActualReceivedMete();
            Object other$rejectActualReceivedMete = other.getRejectActualReceivedMete();
            return this$rejectActualReceivedMete == null
               ? other$rejectActualReceivedMete == null
               : this$rejectActualReceivedMete.equals(other$rejectActualReceivedMete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectRejectProductDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $receivedId = this.getReceivedId();
      result = result * 59 + ($receivedId == null ? 43 : $receivedId.hashCode());
      Object $rejectQuantity = this.getRejectQuantity();
      result = result * 59 + ($rejectQuantity == null ? 43 : $rejectQuantity.hashCode());
      Object $rejectActualReceivedMete = this.getRejectActualReceivedMete();
      return result * 59 + ($rejectActualReceivedMete == null ? 43 : $rejectActualReceivedMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectRejectProductDTOParam(receivedId="
         + this.getReceivedId()
         + ", rejectQuantity="
         + this.getRejectQuantity()
         + ", rejectActualReceivedMete="
         + this.getRejectActualReceivedMete()
         + ")";
   }

   public static class ProjectRejectProductDTOParamBuilder {
      private Long receivedId;
      private BigDecimal rejectQuantity;
      private BigDecimal rejectActualReceivedMete;

      ProjectRejectProductDTOParamBuilder() {
      }

      public ProjectRejectProductDTOParam.ProjectRejectProductDTOParamBuilder receivedId(final Long receivedId) {
         this.receivedId = receivedId;
         return this;
      }

      public ProjectRejectProductDTOParam.ProjectRejectProductDTOParamBuilder rejectQuantity(final BigDecimal rejectQuantity) {
         this.rejectQuantity = rejectQuantity;
         return this;
      }

      public ProjectRejectProductDTOParam.ProjectRejectProductDTOParamBuilder rejectActualReceivedMete(final BigDecimal rejectActualReceivedMete) {
         this.rejectActualReceivedMete = rejectActualReceivedMete;
         return this;
      }

      public ProjectRejectProductDTOParam build() {
         return new ProjectRejectProductDTOParam(this.receivedId, this.rejectQuantity, this.rejectActualReceivedMete);
      }

      @Override
      public String toString() {
         return "ProjectRejectProductDTOParam.ProjectRejectProductDTOParamBuilder(receivedId="
            + this.receivedId
            + ", rejectQuantity="
            + this.rejectQuantity
            + ", rejectActualReceivedMete="
            + this.rejectActualReceivedMete
            + ")";
      }
   }
}
