package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.project.core.api.enums.QhseTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("质安问题新增类")
public class ProjectQhseProblemDTOParamV2 {
   @ApiModelProperty(name = "id", value = "质安问题ID", notes = "质安问题ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目", notes = "项目")
   private Long projectId;
   @ApiModelProperty(name = "supplierId", value = "分包单位ID", notes = "分包单位ID")
   private Long supplierId;
   @ApiModelProperty(name = "problemId", value = "问题ID", notes = "问题ID")
   @NotNull(message = "问题ID不能为空")
   private Long problemId;
   @ApiModelProperty(name = "userId", value = "责任人", notes = "责任人")
   private Long userId;
   @ApiModelProperty(name = "isInternal", value = "0外部 1内部 ")
   private Boolean isInternal;
   @ApiModelProperty(name = "type", value = "问题类型", notes = "问题类型")
   @EnumValidator(value = QhseTypeEnum.class, message = "问题类型不正确！")
   private Integer type;
   @ApiModelProperty(name = "beforeChangeImgIds", value = "整改前图片Id列表", notes = "整改前图片Id列表")
   private List<Long> beforeChangeImgIds;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty("是否回复 true回复 false不回复")
   private Boolean boolReply;

   public static ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder builder() {
      return new ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder();
   }

   public ProjectQhseProblemDTOParamV2() {
   }

   public ProjectQhseProblemDTOParamV2(
      final Long id,
      final Long projectId,
      final Long supplierId,
      final Long problemId,
      final Long userId,
      final Boolean isInternal,
      final Integer type,
      final List<Long> beforeChangeImgIds,
      final String remark,
      final Boolean boolReply
   ) {
      this.id = id;
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.problemId = problemId;
      this.userId = userId;
      this.isInternal = isInternal;
      this.type = type;
      this.beforeChangeImgIds = beforeChangeImgIds;
      this.remark = remark;
      this.boolReply = boolReply;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getProblemId() {
      return this.problemId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getIsInternal() {
      return this.isInternal;
   }

   public Integer getType() {
      return this.type;
   }

   public List<Long> getBeforeChangeImgIds() {
      return this.beforeChangeImgIds;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setProblemId(final Long problemId) {
      this.problemId = problemId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setIsInternal(final Boolean isInternal) {
      this.isInternal = isInternal;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setBeforeChangeImgIds(final List<Long> beforeChangeImgIds) {
      this.beforeChangeImgIds = beforeChangeImgIds;
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

      if (!(o instanceof ProjectQhseProblemDTOParamV2)) {
         return false;
      }

      ProjectQhseProblemDTOParamV2 other = (ProjectQhseProblemDTOParamV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$problemId = this.getProblemId();
               Object other$problemId = other.getProblemId();
               if (this$problemId == null ? other$problemId == null : this$problemId.equals(other$problemId)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$isInternal = this.getIsInternal();
                     Object other$isInternal = other.getIsInternal();
                     if (this$isInternal == null ? other$isInternal == null : this$isInternal.equals(other$isInternal)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$boolReply = this.getBoolReply();
                           Object other$boolReply = other.getBoolReply();
                           if (this$boolReply == null ? other$boolReply == null : this$boolReply.equals(other$boolReply)) {
                              Object this$beforeChangeImgIds = this.getBeforeChangeImgIds();
                              Object other$beforeChangeImgIds = other.getBeforeChangeImgIds();
                              if (this$beforeChangeImgIds == null ? other$beforeChangeImgIds == null : this$beforeChangeImgIds.equals(other$beforeChangeImgIds)
                                 )
                               {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectQhseProblemDTOParamV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $problemId = this.getProblemId();
      result = result * 59 + ($problemId == null ? 43 : $problemId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $isInternal = this.getIsInternal();
      result = result * 59 + ($isInternal == null ? 43 : $isInternal.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $boolReply = this.getBoolReply();
      result = result * 59 + ($boolReply == null ? 43 : $boolReply.hashCode());
      Object $beforeChangeImgIds = this.getBeforeChangeImgIds();
      result = result * 59 + ($beforeChangeImgIds == null ? 43 : $beforeChangeImgIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectQhseProblemDTOParamV2(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", problemId="
         + this.getProblemId()
         + ", userId="
         + this.getUserId()
         + ", isInternal="
         + this.getIsInternal()
         + ", type="
         + this.getType()
         + ", beforeChangeImgIds="
         + this.getBeforeChangeImgIds()
         + ", remark="
         + this.getRemark()
         + ", boolReply="
         + this.getBoolReply()
         + ")";
   }

   public static class ProjectQhseProblemDTOParamV2Builder {
      private Long id;
      private Long projectId;
      private Long supplierId;
      private Long problemId;
      private Long userId;
      private Boolean isInternal;
      private Integer type;
      private List<Long> beforeChangeImgIds;
      private String remark;
      private Boolean boolReply;

      ProjectQhseProblemDTOParamV2Builder() {
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder problemId(final Long problemId) {
         this.problemId = problemId;
         return this;
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder isInternal(final Boolean isInternal) {
         this.isInternal = isInternal;
         return this;
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder beforeChangeImgIds(final List<Long> beforeChangeImgIds) {
         this.beforeChangeImgIds = beforeChangeImgIds;
         return this;
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder boolReply(final Boolean boolReply) {
         this.boolReply = boolReply;
         return this;
      }

      public ProjectQhseProblemDTOParamV2 build() {
         return new ProjectQhseProblemDTOParamV2(
            this.id,
            this.projectId,
            this.supplierId,
            this.problemId,
            this.userId,
            this.isInternal,
            this.type,
            this.beforeChangeImgIds,
            this.remark,
            this.boolReply
         );
      }

      @Override
      public String toString() {
         return "ProjectQhseProblemDTOParamV2.ProjectQhseProblemDTOParamV2Builder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", problemId="
            + this.problemId
            + ", userId="
            + this.userId
            + ", isInternal="
            + this.isInternal
            + ", type="
            + this.type
            + ", beforeChangeImgIds="
            + this.beforeChangeImgIds
            + ", remark="
            + this.remark
            + ", boolReply="
            + this.boolReply
            + ")";
      }
   }
}
