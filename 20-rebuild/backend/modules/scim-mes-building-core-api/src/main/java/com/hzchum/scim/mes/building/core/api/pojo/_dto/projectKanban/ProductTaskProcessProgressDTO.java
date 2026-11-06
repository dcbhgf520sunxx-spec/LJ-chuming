package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProductTaskProcessProgressDTO", description = "产品工序进度")
public class ProductTaskProcessProgressDTO {
   @ApiModelProperty("产品id")
   private Long id;
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("需要总数量")
   private Integer needQuantity;
   @ApiModelProperty("完成数量")
   private Integer completeQuantity;

   public static ProductTaskProcessProgressDTO.ProductTaskProcessProgressDTOBuilder builder() {
      return new ProductTaskProcessProgressDTO.ProductTaskProcessProgressDTOBuilder();
   }

   public ProductTaskProcessProgressDTO() {
   }

   public ProductTaskProcessProgressDTO(final Long id, final Long processId, final Integer needQuantity, final Integer completeQuantity) {
      this.id = id;
      this.processId = processId;
      this.needQuantity = needQuantity;
      this.completeQuantity = completeQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public ProductTaskProcessProgressDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProductTaskProcessProgressDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public ProductTaskProcessProgressDTO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   public ProductTaskProcessProgressDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProductTaskProcessProgressDTO(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductTaskProcessProgressDTO)) {
         return false;
      }

      ProductTaskProcessProgressDTO other = (ProductTaskProcessProgressDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$needQuantity = this.getNeedQuantity();
            Object other$needQuantity = other.getNeedQuantity();
            if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
               Object this$completeQuantity = this.getCompleteQuantity();
               Object other$completeQuantity = other.getCompleteQuantity();
               return this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity);
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
      return other instanceof ProductTaskProcessProgressDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      return result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
   }

   public static class ProductTaskProcessProgressDTOBuilder {
      private Long id;
      private Long processId;
      private Integer needQuantity;
      private Integer completeQuantity;

      ProductTaskProcessProgressDTOBuilder() {
      }

      public ProductTaskProcessProgressDTO.ProductTaskProcessProgressDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProductTaskProcessProgressDTO.ProductTaskProcessProgressDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public ProductTaskProcessProgressDTO.ProductTaskProcessProgressDTOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      public ProductTaskProcessProgressDTO.ProductTaskProcessProgressDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public ProductTaskProcessProgressDTO build() {
         return new ProductTaskProcessProgressDTO(this.id, this.processId, this.needQuantity, this.completeQuantity);
      }

      @Override
      public String toString() {
         return "ProductTaskProcessProgressDTO.ProductTaskProcessProgressDTOBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", needQuantity="
            + this.needQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ")";
      }
   }
}
