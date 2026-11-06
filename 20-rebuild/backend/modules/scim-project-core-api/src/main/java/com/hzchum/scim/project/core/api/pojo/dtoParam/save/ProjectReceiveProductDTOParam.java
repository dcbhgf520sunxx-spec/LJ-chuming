package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "ProjectReceiveProductDTOParam对象", description = "确认收货产品类")
public class ProjectReceiveProductDTOParam {
   @ApiModelProperty(name = "linkId")
   @NotNull(message = "车次详情id不能为空!!!")
   private Long linkId;
   @ApiModelProperty(name = "产品数量")
   @NotNull(message = "产品数量不能为空!!!")
   private BigDecimal quantity;
   @Size(max = 1024, message = "问题收货描述超出字数限制")
   @ApiModelProperty(name = "problemDesc", value = "问题收货描述")
   private String problemDesc;

   public static ProjectReceiveProductDTOParam.ProjectReceiveProductDTOParamBuilder builder() {
      return new ProjectReceiveProductDTOParam.ProjectReceiveProductDTOParamBuilder();
   }

   public ProjectReceiveProductDTOParam() {
   }

   public ProjectReceiveProductDTOParam(final Long linkId, final BigDecimal quantity, final String problemDesc) {
      this.linkId = linkId;
      this.quantity = quantity;
      this.problemDesc = problemDesc;
   }

   public Long getLinkId() {
      return this.linkId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public void setLinkId(final Long linkId) {
      this.linkId = linkId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceiveProductDTOParam)) {
         return false;
      }

      ProjectReceiveProductDTOParam other = (ProjectReceiveProductDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$problemDesc = this.getProblemDesc();
            Object other$problemDesc = other.getProblemDesc();
            return this$problemDesc == null ? other$problemDesc == null : this$problemDesc.equals(other$problemDesc);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReceiveProductDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $problemDesc = this.getProblemDesc();
      return result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceiveProductDTOParam(linkId=" + this.getLinkId() + ", quantity=" + this.getQuantity() + ", problemDesc=" + this.getProblemDesc() + ")";
   }

   public static class ProjectReceiveProductDTOParamBuilder {
      private Long linkId;
      private BigDecimal quantity;
      private String problemDesc;

      ProjectReceiveProductDTOParamBuilder() {
      }

      public ProjectReceiveProductDTOParam.ProjectReceiveProductDTOParamBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public ProjectReceiveProductDTOParam.ProjectReceiveProductDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectReceiveProductDTOParam.ProjectReceiveProductDTOParamBuilder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      public ProjectReceiveProductDTOParam build() {
         return new ProjectReceiveProductDTOParam(this.linkId, this.quantity, this.problemDesc);
      }

      @Override
      public String toString() {
         return "ProjectReceiveProductDTOParam.ProjectReceiveProductDTOParamBuilder(linkId="
            + this.linkId
            + ", quantity="
            + this.quantity
            + ", problemDesc="
            + this.problemDesc
            + ")";
      }
   }
}
