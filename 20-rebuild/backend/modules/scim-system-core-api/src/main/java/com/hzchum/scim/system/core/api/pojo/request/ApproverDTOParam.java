package com.hzchum.scim.system.core.api.pojo.request;

import java.util.List;

public class ApproverDTOParam {
   private Integer type;
   private List<Long> approverIds;

   public static ApproverDTOParam.ApproverDTOParamBuilder builder() {
      return new ApproverDTOParam.ApproverDTOParamBuilder();
   }

   public Integer getType() {
      return this.type;
   }

   public List<Long> getApproverIds() {
      return this.approverIds;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setApproverIds(final List<Long> approverIds) {
      this.approverIds = approverIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ApproverDTOParam)) {
         return false;
      } else {
         ApproverDTOParam other = (ApproverDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$approverIds = this.getApproverIds();
               Object other$approverIds = other.getApproverIds();
               return this$approverIds == null ? other$approverIds == null : this$approverIds.equals(other$approverIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApproverDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $approverIds = this.getApproverIds();
      return result * 59 + ($approverIds == null ? 43 : $approverIds.hashCode());
   }

   @Override
   public String toString() {
      return "ApproverDTOParam(type=" + this.getType() + ", approverIds=" + this.getApproverIds() + ")";
   }

   public ApproverDTOParam(final Integer type, final List<Long> approverIds) {
      this.type = type;
      this.approverIds = approverIds;
   }

   public ApproverDTOParam() {
   }

   public static class ApproverDTOParamBuilder {
      private Integer type;
      private List<Long> approverIds;

      ApproverDTOParamBuilder() {
      }

      public ApproverDTOParam.ApproverDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ApproverDTOParam.ApproverDTOParamBuilder approverIds(final List<Long> approverIds) {
         this.approverIds = approverIds;
         return this;
      }

      public ApproverDTOParam build() {
         return new ApproverDTOParam(this.type, this.approverIds);
      }

      @Override
      public String toString() {
         return "ApproverDTOParam.ApproverDTOParamBuilder(type=" + this.type + ", approverIds=" + this.approverIds + ")";
      }
   }
}
