package com.hzchum.scim.common.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;

@ApiModel("审批Param")
public class ApprovalParam {
   private Long id;
   private Integer status;
   private String opinion;

   public Long getId() {
      return this.id;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getOpinion() {
      return this.opinion;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setOpinion(final String opinion) {
      this.opinion = opinion;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApprovalParam)) {
         return false;
      }

      ApprovalParam other = (ApprovalParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$opinion = this.getOpinion();
            Object other$opinion = other.getOpinion();
            return this$opinion == null ? other$opinion == null : this$opinion.equals(other$opinion);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApprovalParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $opinion = this.getOpinion();
      return result * 59 + ($opinion == null ? 43 : $opinion.hashCode());
   }

   @Override
   public String toString() {
      return "ApprovalParam(id=" + this.getId() + ", status=" + this.getStatus() + ", opinion=" + this.getOpinion() + ")";
   }
}
