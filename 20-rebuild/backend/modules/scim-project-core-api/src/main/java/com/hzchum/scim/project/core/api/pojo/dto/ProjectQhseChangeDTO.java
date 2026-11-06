package com.hzchum.scim.project.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectQhseChange对象", description = "质安问题整改表 ")
public class ProjectQhseChangeDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "problemId", value = "质安问题表id", notes = "质安问题表id")
   private Long problemId;
   @ApiModelProperty(name = "problemDesc", value = "问题描述", notes = "问题描述")
   private String problemDesc;
   @ApiModelProperty(name = "afterChangeImgs", value = "整改图片对象列表", notes = "整改图片对象列表")
   private List<AttachmentDTO> afterChangeImgs;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核2通过4驳回", notes = "审核状态 1未审核2通过4驳回")
   private Integer auditStatus;

   public static ProjectQhseChangeDTO.ProjectQhseChangeDTOBuilder builder() {
      return new ProjectQhseChangeDTO.ProjectQhseChangeDTOBuilder();
   }

   public ProjectQhseChangeDTO() {
   }

   public ProjectQhseChangeDTO(
      final Long id, final Long problemId, final String problemDesc, final List<AttachmentDTO> afterChangeImgs, final Integer auditStatus
   ) {
      this.id = id;
      this.problemId = problemId;
      this.problemDesc = problemDesc;
      this.afterChangeImgs = afterChangeImgs;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProblemId() {
      return this.problemId;
   }

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public List<AttachmentDTO> getAfterChangeImgs() {
      return this.afterChangeImgs;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProblemId(final Long problemId) {
      this.problemId = problemId;
   }

   public void setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
   }

   public void setAfterChangeImgs(final List<AttachmentDTO> afterChangeImgs) {
      this.afterChangeImgs = afterChangeImgs;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectQhseChangeDTO)) {
         return false;
      }

      ProjectQhseChangeDTO other = (ProjectQhseChangeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$problemId = this.getProblemId();
         Object other$problemId = other.getProblemId();
         if (this$problemId == null ? other$problemId == null : this$problemId.equals(other$problemId)) {
            Object this$auditStatus = this.getAuditStatus();
            Object other$auditStatus = other.getAuditStatus();
            if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
               Object this$problemDesc = this.getProblemDesc();
               Object other$problemDesc = other.getProblemDesc();
               if (this$problemDesc == null ? other$problemDesc == null : this$problemDesc.equals(other$problemDesc)) {
                  Object this$afterChangeImgs = this.getAfterChangeImgs();
                  Object other$afterChangeImgs = other.getAfterChangeImgs();
                  return this$afterChangeImgs == null ? other$afterChangeImgs == null : this$afterChangeImgs.equals(other$afterChangeImgs);
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
      return other instanceof ProjectQhseChangeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $problemId = this.getProblemId();
      result = result * 59 + ($problemId == null ? 43 : $problemId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $problemDesc = this.getProblemDesc();
      result = result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
      Object $afterChangeImgs = this.getAfterChangeImgs();
      return result * 59 + ($afterChangeImgs == null ? 43 : $afterChangeImgs.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectQhseChangeDTO(id="
         + this.getId()
         + ", problemId="
         + this.getProblemId()
         + ", problemDesc="
         + this.getProblemDesc()
         + ", afterChangeImgs="
         + this.getAfterChangeImgs()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   public static class ProjectQhseChangeDTOBuilder {
      private Long id;
      private Long problemId;
      private String problemDesc;
      private List<AttachmentDTO> afterChangeImgs;
      private Integer auditStatus;

      ProjectQhseChangeDTOBuilder() {
      }

      public ProjectQhseChangeDTO.ProjectQhseChangeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectQhseChangeDTO.ProjectQhseChangeDTOBuilder problemId(final Long problemId) {
         this.problemId = problemId;
         return this;
      }

      public ProjectQhseChangeDTO.ProjectQhseChangeDTOBuilder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      public ProjectQhseChangeDTO.ProjectQhseChangeDTOBuilder afterChangeImgs(final List<AttachmentDTO> afterChangeImgs) {
         this.afterChangeImgs = afterChangeImgs;
         return this;
      }

      public ProjectQhseChangeDTO.ProjectQhseChangeDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectQhseChangeDTO build() {
         return new ProjectQhseChangeDTO(this.id, this.problemId, this.problemDesc, this.afterChangeImgs, this.auditStatus);
      }

      @Override
      public String toString() {
         return "ProjectQhseChangeDTO.ProjectQhseChangeDTOBuilder(id="
            + this.id
            + ", problemId="
            + this.problemId
            + ", problemDesc="
            + this.problemDesc
            + ", afterChangeImgs="
            + this.afterChangeImgs
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
