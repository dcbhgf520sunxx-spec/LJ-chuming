package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingQhseRectifyDTO对象", description = "问题曝光整改 ")
public class MesBuildingQhseRectifyDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "qhseId", value = "问题曝光id")
   @JsonProperty("qhseId")
   @JSONField(name = "qhseId")
   private Long qhseId;
   @ApiModelProperty(name = "rectifyDrawing", notes = "问题上报图片ids")
   @JsonProperty("rectifyDrawing")
   @JSONField(name = "rectifyDrawing")
   private String rectifyDrawing;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "refuseRemark", value = "拒绝原因")
   @JsonProperty("refuseRemark")
   @JSONField(name = "refuseRemark")
   private String refuseRemark;
   @ApiModelProperty(name = "userId", value = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "name", value = "操作人姓名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "attachmentDTOS", value = "问题报告附件")
   @JsonProperty("attachmentDTOS")
   @JSONField(name = "attachmentDTOS")
   private List<AttachmentDTO> attachmentDTOS;

   public static MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder builder() {
      return new MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder();
   }

   public MesBuildingQhseRectifyDTO() {
   }

   public MesBuildingQhseRectifyDTO(
      final Long id,
      final Long qhseId,
      final String rectifyDrawing,
      final String remark,
      final String refuseRemark,
      final Long userId,
      final String name,
      final List<AttachmentDTO> attachmentDTOS
   ) {
      this.id = id;
      this.qhseId = qhseId;
      this.rectifyDrawing = rectifyDrawing;
      this.remark = remark;
      this.refuseRemark = refuseRemark;
      this.userId = userId;
      this.name = name;
      this.attachmentDTOS = attachmentDTOS;
   }

   public Long getId() {
      return this.id;
   }

   public Long getQhseId() {
      return this.qhseId;
   }

   public String getRectifyDrawing() {
      return this.rectifyDrawing;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getRefuseRemark() {
      return this.refuseRemark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getName() {
      return this.name;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   @JsonProperty("id")
   public MesBuildingQhseRectifyDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseId")
   public MesBuildingQhseRectifyDTO setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("rectifyDrawing")
   public MesBuildingQhseRectifyDTO setRectifyDrawing(final String rectifyDrawing) {
      this.rectifyDrawing = rectifyDrawing;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingQhseRectifyDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("refuseRemark")
   public MesBuildingQhseRectifyDTO setRefuseRemark(final String refuseRemark) {
      this.refuseRemark = refuseRemark;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingQhseRectifyDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingQhseRectifyDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("attachmentDTOS")
   public MesBuildingQhseRectifyDTO setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseRectifyDTO(id="
         + this.getId()
         + ", qhseId="
         + this.getQhseId()
         + ", rectifyDrawing="
         + this.getRectifyDrawing()
         + ", remark="
         + this.getRemark()
         + ", refuseRemark="
         + this.getRefuseRemark()
         + ", userId="
         + this.getUserId()
         + ", name="
         + this.getName()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseRectifyDTO)) {
         return false;
      }

      MesBuildingQhseRectifyDTO other = (MesBuildingQhseRectifyDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$qhseId = this.getQhseId();
         Object other$qhseId = other.getQhseId();
         if (this$qhseId == null ? other$qhseId == null : this$qhseId.equals(other$qhseId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$rectifyDrawing = this.getRectifyDrawing();
               Object other$rectifyDrawing = other.getRectifyDrawing();
               if (this$rectifyDrawing == null ? other$rectifyDrawing == null : this$rectifyDrawing.equals(other$rectifyDrawing)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                     Object this$refuseRemark = this.getRefuseRemark();
                     Object other$refuseRemark = other.getRefuseRemark();
                     if (this$refuseRemark == null ? other$refuseRemark == null : this$refuseRemark.equals(other$refuseRemark)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingQhseRectifyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $qhseId = this.getQhseId();
      result = result * 59 + ($qhseId == null ? 43 : $qhseId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $rectifyDrawing = this.getRectifyDrawing();
      result = result * 59 + ($rectifyDrawing == null ? 43 : $rectifyDrawing.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $refuseRemark = this.getRefuseRemark();
      result = result * 59 + ($refuseRemark == null ? 43 : $refuseRemark.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      return result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
   }

   public static class MesBuildingQhseRectifyDTOBuilder {
      private Long id;
      private Long qhseId;
      private String rectifyDrawing;
      private String remark;
      private String refuseRemark;
      private Long userId;
      private String name;
      private List<AttachmentDTO> attachmentDTOS;

      MesBuildingQhseRectifyDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseId")
      public MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("rectifyDrawing")
      public MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder rectifyDrawing(final String rectifyDrawing) {
         this.rectifyDrawing = rectifyDrawing;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("refuseRemark")
      public MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder refuseRemark(final String refuseRemark) {
         this.refuseRemark = refuseRemark;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("attachmentDTOS")
      public MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder attachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
         this.attachmentDTOS = attachmentDTOS;
         return this;
      }

      public MesBuildingQhseRectifyDTO build() {
         return new MesBuildingQhseRectifyDTO(
            this.id, this.qhseId, this.rectifyDrawing, this.remark, this.refuseRemark, this.userId, this.name, this.attachmentDTOS
         );
      }

      @Override
      public String toString() {
         return "MesBuildingQhseRectifyDTO.MesBuildingQhseRectifyDTOBuilder(id="
            + this.id
            + ", qhseId="
            + this.qhseId
            + ", rectifyDrawing="
            + this.rectifyDrawing
            + ", remark="
            + this.remark
            + ", refuseRemark="
            + this.refuseRemark
            + ", userId="
            + this.userId
            + ", name="
            + this.name
            + ", attachmentDTOS="
            + this.attachmentDTOS
            + ")";
      }
   }
}
