package com.hzchum.scim.system.core.api.pojo.dto.safety;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingQhseRectifyDTO对象", description = "问题整改表 ")
public class ProjectSafetyProblemRectifyDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectSafetyProblemId", value = "问题id")
   @JsonProperty("projectSafetyProblemId")
   @JSONField(name = "projectSafetyProblemId")
   private Long projectSafetyProblemId;
   @ApiModelProperty(name = "afterChangeImgs", value = "整改后图片", notes = "整改后图片")
   @JsonProperty("afterChangeImgs")
   @JSONField(name = "afterChangeImgs")
   private String afterChangeImgs;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "refuseRemark", value = "拒绝原因")
   @JsonProperty("refuseRemark")
   @JSONField(name = "refuseRemark")
   private String refuseRemark;
   @ApiModelProperty(name = "rectifyDate", value = "整改时间")
   @JsonProperty("rectifyDate")
   @JSONField(name = "rectifyDate")
   private LocalDateTime rectifyDate;
   @ApiModelProperty(name = "userId", value = "整改人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "name", value = "整改人名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "rectifyType", value = "整改类型", notes = "整改类型 参考枚举RectifyTypeEnum")
   @JsonProperty("rectifyType")
   @JSONField(name = "rectifyType")
   private Integer rectifyType;
   @ApiModelProperty(name = "attachmentDTOS", value = "问题报告附件")
   @JsonProperty("attachmentDTOS")
   @JSONField(name = "attachmentDTOS")
   private List<AttachmentDTO> attachmentDTOS;

   public static ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder builder() {
      return new ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder();
   }

   public ProjectSafetyProblemRectifyDTO() {
   }

   public ProjectSafetyProblemRectifyDTO(
      final Long id,
      final Long projectSafetyProblemId,
      final String afterChangeImgs,
      final String remark,
      final String refuseRemark,
      final LocalDateTime rectifyDate,
      final Long userId,
      final String name,
      final Integer rectifyType,
      final List<AttachmentDTO> attachmentDTOS
   ) {
      this.id = id;
      this.projectSafetyProblemId = projectSafetyProblemId;
      this.afterChangeImgs = afterChangeImgs;
      this.remark = remark;
      this.refuseRemark = refuseRemark;
      this.rectifyDate = rectifyDate;
      this.userId = userId;
      this.name = name;
      this.rectifyType = rectifyType;
      this.attachmentDTOS = attachmentDTOS;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectSafetyProblemId() {
      return this.projectSafetyProblemId;
   }

   public String getAfterChangeImgs() {
      return this.afterChangeImgs;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getRefuseRemark() {
      return this.refuseRemark;
   }

   public LocalDateTime getRectifyDate() {
      return this.rectifyDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getRectifyType() {
      return this.rectifyType;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   @JsonProperty("id")
   public ProjectSafetyProblemRectifyDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectSafetyProblemId")
   public ProjectSafetyProblemRectifyDTO setProjectSafetyProblemId(final Long projectSafetyProblemId) {
      this.projectSafetyProblemId = projectSafetyProblemId;
      return this;
   }

   @JsonProperty("afterChangeImgs")
   public ProjectSafetyProblemRectifyDTO setAfterChangeImgs(final String afterChangeImgs) {
      this.afterChangeImgs = afterChangeImgs;
      return this;
   }

   @JsonProperty("remark")
   public ProjectSafetyProblemRectifyDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("refuseRemark")
   public ProjectSafetyProblemRectifyDTO setRefuseRemark(final String refuseRemark) {
      this.refuseRemark = refuseRemark;
      return this;
   }

   @JsonProperty("rectifyDate")
   public ProjectSafetyProblemRectifyDTO setRectifyDate(final LocalDateTime rectifyDate) {
      this.rectifyDate = rectifyDate;
      return this;
   }

   @JsonProperty("userId")
   public ProjectSafetyProblemRectifyDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("name")
   public ProjectSafetyProblemRectifyDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("rectifyType")
   public ProjectSafetyProblemRectifyDTO setRectifyType(final Integer rectifyType) {
      this.rectifyType = rectifyType;
      return this;
   }

   @JsonProperty("attachmentDTOS")
   public ProjectSafetyProblemRectifyDTO setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSafetyProblemRectifyDTO)) {
         return false;
      }

      ProjectSafetyProblemRectifyDTO other = (ProjectSafetyProblemRectifyDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectSafetyProblemId = this.getProjectSafetyProblemId();
         Object other$projectSafetyProblemId = other.getProjectSafetyProblemId();
         if (this$projectSafetyProblemId == null ? other$projectSafetyProblemId == null : this$projectSafetyProblemId.equals(other$projectSafetyProblemId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$rectifyType = this.getRectifyType();
               Object other$rectifyType = other.getRectifyType();
               if (this$rectifyType == null ? other$rectifyType == null : this$rectifyType.equals(other$rectifyType)) {
                  Object this$afterChangeImgs = this.getAfterChangeImgs();
                  Object other$afterChangeImgs = other.getAfterChangeImgs();
                  if (this$afterChangeImgs == null ? other$afterChangeImgs == null : this$afterChangeImgs.equals(other$afterChangeImgs)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                        Object this$refuseRemark = this.getRefuseRemark();
                        Object other$refuseRemark = other.getRefuseRemark();
                        if (this$refuseRemark == null ? other$refuseRemark == null : this$refuseRemark.equals(other$refuseRemark)) {
                           Object this$rectifyDate = this.getRectifyDate();
                           Object other$rectifyDate = other.getRectifyDate();
                           if (this$rectifyDate == null ? other$rectifyDate == null : this$rectifyDate.equals(other$rectifyDate)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$attachmentDTOS = this.getAttachmentDTOS();
                                 Object other$attachmentDTOS = other.getAttachmentDTOS();
                                 return this$attachmentDTOS == null ? other$attachmentDTOS == null : this$attachmentDTOS.equals(other$attachmentDTOS);
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
      return other instanceof ProjectSafetyProblemRectifyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectSafetyProblemId = this.getProjectSafetyProblemId();
      result = result * 59 + ($projectSafetyProblemId == null ? 43 : $projectSafetyProblemId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $rectifyType = this.getRectifyType();
      result = result * 59 + ($rectifyType == null ? 43 : $rectifyType.hashCode());
      Object $afterChangeImgs = this.getAfterChangeImgs();
      result = result * 59 + ($afterChangeImgs == null ? 43 : $afterChangeImgs.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $refuseRemark = this.getRefuseRemark();
      result = result * 59 + ($refuseRemark == null ? 43 : $refuseRemark.hashCode());
      Object $rectifyDate = this.getRectifyDate();
      result = result * 59 + ($rectifyDate == null ? 43 : $rectifyDate.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      return result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSafetyProblemRectifyDTO(id="
         + this.getId()
         + ", projectSafetyProblemId="
         + this.getProjectSafetyProblemId()
         + ", afterChangeImgs="
         + this.getAfterChangeImgs()
         + ", remark="
         + this.getRemark()
         + ", refuseRemark="
         + this.getRefuseRemark()
         + ", rectifyDate="
         + this.getRectifyDate()
         + ", userId="
         + this.getUserId()
         + ", name="
         + this.getName()
         + ", rectifyType="
         + this.getRectifyType()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ")";
   }

   public static class ProjectSafetyProblemRectifyDTOBuilder {
      private Long id;
      private Long projectSafetyProblemId;
      private String afterChangeImgs;
      private String remark;
      private String refuseRemark;
      private LocalDateTime rectifyDate;
      private Long userId;
      private String name;
      private Integer rectifyType;
      private List<AttachmentDTO> attachmentDTOS;

      ProjectSafetyProblemRectifyDTOBuilder() {
      }

      @JsonProperty("id")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectSafetyProblemId")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder projectSafetyProblemId(final Long projectSafetyProblemId) {
         this.projectSafetyProblemId = projectSafetyProblemId;
         return this;
      }

      @JsonProperty("afterChangeImgs")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder afterChangeImgs(final String afterChangeImgs) {
         this.afterChangeImgs = afterChangeImgs;
         return this;
      }

      @JsonProperty("remark")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("refuseRemark")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder refuseRemark(final String refuseRemark) {
         this.refuseRemark = refuseRemark;
         return this;
      }

      @JsonProperty("rectifyDate")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder rectifyDate(final LocalDateTime rectifyDate) {
         this.rectifyDate = rectifyDate;
         return this;
      }

      @JsonProperty("userId")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("name")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("rectifyType")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder rectifyType(final Integer rectifyType) {
         this.rectifyType = rectifyType;
         return this;
      }

      @JsonProperty("attachmentDTOS")
      public ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder attachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
         this.attachmentDTOS = attachmentDTOS;
         return this;
      }

      public ProjectSafetyProblemRectifyDTO build() {
         return new ProjectSafetyProblemRectifyDTO(
            this.id,
            this.projectSafetyProblemId,
            this.afterChangeImgs,
            this.remark,
            this.refuseRemark,
            this.rectifyDate,
            this.userId,
            this.name,
            this.rectifyType,
            this.attachmentDTOS
         );
      }

      @Override
      public String toString() {
         return "ProjectSafetyProblemRectifyDTO.ProjectSafetyProblemRectifyDTOBuilder(id="
            + this.id
            + ", projectSafetyProblemId="
            + this.projectSafetyProblemId
            + ", afterChangeImgs="
            + this.afterChangeImgs
            + ", remark="
            + this.remark
            + ", refuseRemark="
            + this.refuseRemark
            + ", rectifyDate="
            + this.rectifyDate
            + ", userId="
            + this.userId
            + ", name="
            + this.name
            + ", rectifyType="
            + this.rectifyType
            + ", attachmentDTOS="
            + this.attachmentDTOS
            + ")";
      }
   }
}
