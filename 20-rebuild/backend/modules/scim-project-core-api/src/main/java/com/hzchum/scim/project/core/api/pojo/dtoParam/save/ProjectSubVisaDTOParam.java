package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

public class ProjectSubVisaDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "visaReasonId", value = "签证原因ID", notes = "签证原因ID")
   @NotNull(message = "签证原因ID不能为空")
   private Long visaReasonId;
   @ApiModelProperty(name = "visaAmount", value = "签证金额", notes = "签证金额")
   @NotNull(message = "签证金额不能为空")
   private BigDecimal visaAmount;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @NotNull(message = "单体id不能为空")
   private Long monomerId;
   @ApiModelProperty(name = "attachmentIds", value = "附件ID列表", notes = "附件ID列表")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static ProjectSubVisaDTOParam.ProjectSubVisaDTOParamBuilder builder() {
      return new ProjectSubVisaDTOParam.ProjectSubVisaDTOParamBuilder();
   }

   public ProjectSubVisaDTOParam() {
   }

   public ProjectSubVisaDTOParam(
      final Long id, final Long visaReasonId, final BigDecimal visaAmount, final Long monomerId, final List<Long> attachmentIds, final String remark
   ) {
      this.id = id;
      this.visaReasonId = visaReasonId;
      this.visaAmount = visaAmount;
      this.monomerId = monomerId;
      this.attachmentIds = attachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getVisaReasonId() {
      return this.visaReasonId;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setVisaReasonId(final Long visaReasonId) {
      this.visaReasonId = visaReasonId;
   }

   public void setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSubVisaDTOParam)) {
         return false;
      }

      ProjectSubVisaDTOParam other = (ProjectSubVisaDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$visaReasonId = this.getVisaReasonId();
         Object other$visaReasonId = other.getVisaReasonId();
         if (this$visaReasonId == null ? other$visaReasonId == null : this$visaReasonId.equals(other$visaReasonId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$visaAmount = this.getVisaAmount();
               Object other$visaAmount = other.getVisaAmount();
               if (this$visaAmount == null ? other$visaAmount == null : this$visaAmount.equals(other$visaAmount)) {
                  Object this$attachmentIds = this.getAttachmentIds();
                  Object other$attachmentIds = other.getAttachmentIds();
                  if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ProjectSubVisaDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $visaReasonId = this.getVisaReasonId();
      result = result * 59 + ($visaReasonId == null ? 43 : $visaReasonId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSubVisaDTOParam(id="
         + this.getId()
         + ", visaReasonId="
         + this.getVisaReasonId()
         + ", visaAmount="
         + this.getVisaAmount()
         + ", monomerId="
         + this.getMonomerId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ProjectSubVisaDTOParamBuilder {
      private Long id;
      private Long visaReasonId;
      private BigDecimal visaAmount;
      private Long monomerId;
      private List<Long> attachmentIds;
      private String remark;

      ProjectSubVisaDTOParamBuilder() {
      }

      public ProjectSubVisaDTOParam.ProjectSubVisaDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectSubVisaDTOParam.ProjectSubVisaDTOParamBuilder visaReasonId(final Long visaReasonId) {
         this.visaReasonId = visaReasonId;
         return this;
      }

      public ProjectSubVisaDTOParam.ProjectSubVisaDTOParamBuilder visaAmount(final BigDecimal visaAmount) {
         this.visaAmount = visaAmount;
         return this;
      }

      public ProjectSubVisaDTOParam.ProjectSubVisaDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectSubVisaDTOParam.ProjectSubVisaDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectSubVisaDTOParam.ProjectSubVisaDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectSubVisaDTOParam build() {
         return new ProjectSubVisaDTOParam(this.id, this.visaReasonId, this.visaAmount, this.monomerId, this.attachmentIds, this.remark);
      }

      @Override
      public String toString() {
         return "ProjectSubVisaDTOParam.ProjectSubVisaDTOParamBuilder(id="
            + this.id
            + ", visaReasonId="
            + this.visaReasonId
            + ", visaAmount="
            + this.visaAmount
            + ", monomerId="
            + this.monomerId
            + ", attachmentIds="
            + this.attachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
