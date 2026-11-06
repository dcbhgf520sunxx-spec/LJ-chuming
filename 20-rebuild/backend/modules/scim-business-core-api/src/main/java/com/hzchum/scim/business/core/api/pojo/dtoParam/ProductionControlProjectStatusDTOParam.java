package com.hzchum.scim.business.core.api.pojo.dtoParam;

public class ProductionControlProjectStatusDTOParam {
   private Long projectId;
   private Integer status;

   ProductionControlProjectStatusDTOParam(final Long projectId, final Integer status) {
      this.projectId = projectId;
      this.status = status;
   }

   public static ProductionControlProjectStatusDTOParam.ProductionControlProjectStatusDTOParamBuilder builder() {
      return new ProductionControlProjectStatusDTOParam.ProductionControlProjectStatusDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionControlProjectStatusDTOParam)) {
         return false;
      } else {
         ProductionControlProjectStatusDTOParam other = (ProductionControlProjectStatusDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               return this$status == null ? other$status == null : this$status.equals(other$status);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionControlProjectStatusDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      return result * 59 + ($status == null ? 43 : $status.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionControlProjectStatusDTOParam(projectId=" + this.getProjectId() + ", status=" + this.getStatus() + ")";
   }

   public static class ProductionControlProjectStatusDTOParamBuilder {
      private Long projectId;
      private Integer status;

      ProductionControlProjectStatusDTOParamBuilder() {
      }

      public ProductionControlProjectStatusDTOParam.ProductionControlProjectStatusDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProductionControlProjectStatusDTOParam.ProductionControlProjectStatusDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProductionControlProjectStatusDTOParam build() {
         return new ProductionControlProjectStatusDTOParam(this.projectId, this.status);
      }

      @Override
      public String toString() {
         return "ProductionControlProjectStatusDTOParam.ProductionControlProjectStatusDTOParamBuilder(projectId="
            + this.projectId
            + ", status="
            + this.status
            + ")";
      }
   }
}
