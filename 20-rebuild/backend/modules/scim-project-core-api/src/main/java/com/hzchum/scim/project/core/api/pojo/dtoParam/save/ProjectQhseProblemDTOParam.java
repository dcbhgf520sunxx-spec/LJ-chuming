package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("质安问题新增类")
public class ProjectQhseProblemDTOParam {
   @ApiModelProperty(name = "id", value = "质安问题ID", notes = "质安问题ID")
   private Long id;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @NotNull(message = "单体ID不能为空")
   private Long monomerId;
   @ApiModelProperty(name = "supplierId", value = "分包单位ID", notes = "分包单位ID")
   @NotNull(message = "分包单位(供应商)ID不能为空")
   private Long supplierId;
   @ApiModelProperty(name = "problemTypeId", value = "问题类型ID", notes = "问题类型ID")
   @NotNull(message = "问题类型ID不能为空")
   private Long problemTypeId;
   @ApiModelProperty(name = "beforeChangeImgIds", value = "整改前图片Id列表", notes = "整改前图片Id列表")
   private List<Long> beforeChangeImgIds;
   @ApiModelProperty(name = "penalty", value = "违约金", notes = "违约金")
   private BigDecimal penalty;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty("是否回复 true回复 false不回复")
   private Boolean boolReply;

   public static ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder builder() {
      return new ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder();
   }

   public ProjectQhseProblemDTOParam() {
   }

   public ProjectQhseProblemDTOParam(
      final Long id,
      final Long monomerId,
      final Long supplierId,
      final Long problemTypeId,
      final List<Long> beforeChangeImgIds,
      final BigDecimal penalty,
      final String remark,
      final Boolean boolReply
   ) {
      this.id = id;
      this.monomerId = monomerId;
      this.supplierId = supplierId;
      this.problemTypeId = problemTypeId;
      this.beforeChangeImgIds = beforeChangeImgIds;
      this.penalty = penalty;
      this.remark = remark;
      this.boolReply = boolReply;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getProblemTypeId() {
      return this.problemTypeId;
   }

   public List<Long> getBeforeChangeImgIds() {
      return this.beforeChangeImgIds;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolReply() {
      return this.boolReply;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setProblemTypeId(final Long problemTypeId) {
      this.problemTypeId = problemTypeId;
   }

   public void setBeforeChangeImgIds(final List<Long> beforeChangeImgIds) {
      this.beforeChangeImgIds = beforeChangeImgIds;
   }

   public void setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBoolReply(final Boolean boolReply) {
      this.boolReply = boolReply;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectQhseProblemDTOParam)) {
         return false;
      }

      ProjectQhseProblemDTOParam other = (ProjectQhseProblemDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$problemTypeId = this.getProblemTypeId();
               Object other$problemTypeId = other.getProblemTypeId();
               if (this$problemTypeId == null ? other$problemTypeId == null : this$problemTypeId.equals(other$problemTypeId)) {
                  Object this$boolReply = this.getBoolReply();
                  Object other$boolReply = other.getBoolReply();
                  if (this$boolReply == null ? other$boolReply == null : this$boolReply.equals(other$boolReply)) {
                     Object this$beforeChangeImgIds = this.getBeforeChangeImgIds();
                     Object other$beforeChangeImgIds = other.getBeforeChangeImgIds();
                     if (this$beforeChangeImgIds == null ? other$beforeChangeImgIds == null : this$beforeChangeImgIds.equals(other$beforeChangeImgIds)) {
                        Object this$penalty = this.getPenalty();
                        Object other$penalty = other.getPenalty();
                        if (this$penalty == null ? other$penalty == null : this$penalty.equals(other$penalty)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectQhseProblemDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $problemTypeId = this.getProblemTypeId();
      result = result * 59 + ($problemTypeId == null ? 43 : $problemTypeId.hashCode());
      Object $boolReply = this.getBoolReply();
      result = result * 59 + ($boolReply == null ? 43 : $boolReply.hashCode());
      Object $beforeChangeImgIds = this.getBeforeChangeImgIds();
      result = result * 59 + ($beforeChangeImgIds == null ? 43 : $beforeChangeImgIds.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectQhseProblemDTOParam(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", supplierId="
         + this.getSupplierId()
         + ", problemTypeId="
         + this.getProblemTypeId()
         + ", beforeChangeImgIds="
         + this.getBeforeChangeImgIds()
         + ", penalty="
         + this.getPenalty()
         + ", remark="
         + this.getRemark()
         + ", boolReply="
         + this.getBoolReply()
         + ")";
   }

   public static class ProjectQhseProblemDTOParamBuilder {
      private Long id;
      private Long monomerId;
      private Long supplierId;
      private Long problemTypeId;
      private List<Long> beforeChangeImgIds;
      private BigDecimal penalty;
      private String remark;
      private Boolean boolReply;

      ProjectQhseProblemDTOParamBuilder() {
      }

      public ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder problemTypeId(final Long problemTypeId) {
         this.problemTypeId = problemTypeId;
         return this;
      }

      public ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder beforeChangeImgIds(final List<Long> beforeChangeImgIds) {
         this.beforeChangeImgIds = beforeChangeImgIds;
         return this;
      }

      public ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      public ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder boolReply(final Boolean boolReply) {
         this.boolReply = boolReply;
         return this;
      }

      public ProjectQhseProblemDTOParam build() {
         return new ProjectQhseProblemDTOParam(
            this.id, this.monomerId, this.supplierId, this.problemTypeId, this.beforeChangeImgIds, this.penalty, this.remark, this.boolReply
         );
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemDTOParam.ProjectQhseProblemDTOParamBuilder(id="
            + this.id
            + ", monomerId="
            + this.monomerId
            + ", supplierId="
            + this.supplierId
            + ", problemTypeId="
            + this.problemTypeId
            + ", beforeChangeImgIds="
            + this.beforeChangeImgIds
            + ", penalty="
            + this.penalty
            + ", remark="
            + this.remark
            + ", boolReply="
            + this.boolReply
            + ")";
      }
   }
}
