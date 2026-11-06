package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProjectPurchaseReceiveDTOParam", description = "确认外购收货请求类")
public class ProjectPurchaseReceiveDTOParam {
   @ApiModelProperty(name = "产品id")
   @NotNull(message = "采购单详情id不能为空!!!")
   private Long detailId;
   @ApiModelProperty(name = "receivedQuantity", value = "收货数量", notes = "收货数量")
   @NotNull(message = "收货数量不能为空!!!")
   private BigDecimal receivedQuantity;
   @ApiModelProperty(name = "receivedQuantity", value = "实际收货核算量", notes = "实际收货核算量")
   @NotNull(message = "实际收货核算量不能为空!!!")
   private BigDecimal actualReceivedMete;

   public static ProjectPurchaseReceiveDTOParam.ProjectPurchaseReceiveDTOParamBuilder builder() {
      return new ProjectPurchaseReceiveDTOParam.ProjectPurchaseReceiveDTOParamBuilder();
   }

   public ProjectPurchaseReceiveDTOParam() {
   }

   public ProjectPurchaseReceiveDTOParam(final Long detailId, final BigDecimal receivedQuantity, final BigDecimal actualReceivedMete) {
      this.detailId = detailId;
      this.receivedQuantity = receivedQuantity;
      this.actualReceivedMete = actualReceivedMete;
   }

   public Long getDetailId() {
      return this.detailId;
   }

   public BigDecimal getReceivedQuantity() {
      return this.receivedQuantity;
   }

   public BigDecimal getActualReceivedMete() {
      return this.actualReceivedMete;
   }

   public void setDetailId(final Long detailId) {
      this.detailId = detailId;
   }

   public void setReceivedQuantity(final BigDecimal receivedQuantity) {
      this.receivedQuantity = receivedQuantity;
   }

   public void setActualReceivedMete(final BigDecimal actualReceivedMete) {
      this.actualReceivedMete = actualReceivedMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPurchaseReceiveDTOParam)) {
         return false;
      }

      ProjectPurchaseReceiveDTOParam other = (ProjectPurchaseReceiveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$detailId = this.getDetailId();
      Object other$detailId = other.getDetailId();
      if (this$detailId == null ? other$detailId == null : this$detailId.equals(other$detailId)) {
         Object this$receivedQuantity = this.getReceivedQuantity();
         Object other$receivedQuantity = other.getReceivedQuantity();
         if (this$receivedQuantity == null ? other$receivedQuantity == null : this$receivedQuantity.equals(other$receivedQuantity)) {
            Object this$actualReceivedMete = this.getActualReceivedMete();
            Object other$actualReceivedMete = other.getActualReceivedMete();
            return this$actualReceivedMete == null ? other$actualReceivedMete == null : this$actualReceivedMete.equals(other$actualReceivedMete);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectPurchaseReceiveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $detailId = this.getDetailId();
      result = result * 59 + ($detailId == null ? 43 : $detailId.hashCode());
      Object $receivedQuantity = this.getReceivedQuantity();
      result = result * 59 + ($receivedQuantity == null ? 43 : $receivedQuantity.hashCode());
      Object $actualReceivedMete = this.getActualReceivedMete();
      return result * 59 + ($actualReceivedMete == null ? 43 : $actualReceivedMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPurchaseReceiveDTOParam(detailId="
         + this.getDetailId()
         + ", receivedQuantity="
         + this.getReceivedQuantity()
         + ", actualReceivedMete="
         + this.getActualReceivedMete()
         + ")";
   }

   public static class ProjectPurchaseReceiveDTOParamBuilder {
      private Long detailId;
      private BigDecimal receivedQuantity;
      private BigDecimal actualReceivedMete;

      ProjectPurchaseReceiveDTOParamBuilder() {
      }

      public ProjectPurchaseReceiveDTOParam.ProjectPurchaseReceiveDTOParamBuilder detailId(final Long detailId) {
         this.detailId = detailId;
         return this;
      }

      public ProjectPurchaseReceiveDTOParam.ProjectPurchaseReceiveDTOParamBuilder receivedQuantity(final BigDecimal receivedQuantity) {
         this.receivedQuantity = receivedQuantity;
         return this;
      }

      public ProjectPurchaseReceiveDTOParam.ProjectPurchaseReceiveDTOParamBuilder actualReceivedMete(final BigDecimal actualReceivedMete) {
         this.actualReceivedMete = actualReceivedMete;
         return this;
      }

      public ProjectPurchaseReceiveDTOParam build() {
         return new ProjectPurchaseReceiveDTOParam(this.detailId, this.receivedQuantity, this.actualReceivedMete);
      }

      @Override
      public String toString() {
         return "ProjectPurchaseReceiveDTOParam.ProjectPurchaseReceiveDTOParamBuilder(detailId="
            + this.detailId
            + ", receivedQuantity="
            + this.receivedQuantity
            + ", actualReceivedMete="
            + this.actualReceivedMete
            + ")";
      }
   }
}
