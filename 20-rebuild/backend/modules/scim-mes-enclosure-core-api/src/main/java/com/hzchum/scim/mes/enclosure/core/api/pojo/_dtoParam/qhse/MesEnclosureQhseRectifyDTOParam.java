package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.dtoPatamUtils.IdsDtoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureQhseRectifyDTOParam", description = "问题曝光整改 ")
public class MesEnclosureQhseRectifyDTOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "qhseId", value = "问题曝光id")
   @JsonProperty("qhseId")
   @JSONField(name = "qhseId")
   @NotNull(message = "问题曝光id不能为空")
   private Long qhseId;
   @ApiModelProperty(name = "rectifyDrawing", notes = "问题上报图片ids")
   @JsonProperty("rectifyDrawing")
   @JSONField(name = "rectifyDrawing")
   private String rectifyDrawing;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @NotNull(message = "整改备注不能为空")
   private String remark;
   @ApiModelProperty(name = "refuseRemark", value = "拒绝原因")
   @JsonProperty("refuseRemark")
   @JSONField(name = "refuseRemark")
   private String refuseRemark;
   @ApiModelProperty(name = "userId", value = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "drawingIds", value = "整改图片ids")
   @JsonProperty("drawingIds")
   @JSONField(name = "drawingIds")
   private IdsDtoParam drawingIds;

   public static MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder builder() {
      return new MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder();
   }

   public MesEnclosureQhseRectifyDTOParam() {
   }

   public MesEnclosureQhseRectifyDTOParam(
      final Long id,
      final Long qhseId,
      final String rectifyDrawing,
      final String remark,
      final String refuseRemark,
      final Long userId,
      final IdsDtoParam drawingIds
   ) {
      this.id = id;
      this.qhseId = qhseId;
      this.rectifyDrawing = rectifyDrawing;
      this.remark = remark;
      this.refuseRemark = refuseRemark;
      this.userId = userId;
      this.drawingIds = drawingIds;
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

   public IdsDtoParam getDrawingIds() {
      return this.drawingIds;
   }

   @JsonProperty("id")
   public MesEnclosureQhseRectifyDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseId")
   public MesEnclosureQhseRectifyDTOParam setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("rectifyDrawing")
   public MesEnclosureQhseRectifyDTOParam setRectifyDrawing(final String rectifyDrawing) {
      this.rectifyDrawing = rectifyDrawing;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureQhseRectifyDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("refuseRemark")
   public MesEnclosureQhseRectifyDTOParam setRefuseRemark(final String refuseRemark) {
      this.refuseRemark = refuseRemark;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureQhseRectifyDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("drawingIds")
   public MesEnclosureQhseRectifyDTOParam setDrawingIds(final IdsDtoParam drawingIds) {
      this.drawingIds = drawingIds;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureQhseRectifyDTOParam(id="
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
         + ", drawingIds="
         + this.getDrawingIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureQhseRectifyDTOParam)) {
         return false;
      }

      MesEnclosureQhseRectifyDTOParam other = (MesEnclosureQhseRectifyDTOParam)o;
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
                        Object this$drawingIds = this.getDrawingIds();
                        Object other$drawingIds = other.getDrawingIds();
                        return this$drawingIds == null ? other$drawingIds == null : this$drawingIds.equals(other$drawingIds);
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
      return other instanceof MesEnclosureQhseRectifyDTOParam;
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
      Object $drawingIds = this.getDrawingIds();
      return result * 59 + ($drawingIds == null ? 43 : $drawingIds.hashCode());
   }

   public static class MesEnclosureQhseRectifyDTOParamBuilder {
      private Long id;
      private Long qhseId;
      private String rectifyDrawing;
      private String remark;
      private String refuseRemark;
      private Long userId;
      private IdsDtoParam drawingIds;

      MesEnclosureQhseRectifyDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseId")
      public MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("rectifyDrawing")
      public MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder rectifyDrawing(final String rectifyDrawing) {
         this.rectifyDrawing = rectifyDrawing;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("refuseRemark")
      public MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder refuseRemark(final String refuseRemark) {
         this.refuseRemark = refuseRemark;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("drawingIds")
      public MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder drawingIds(final IdsDtoParam drawingIds) {
         this.drawingIds = drawingIds;
         return this;
      }

      public MesEnclosureQhseRectifyDTOParam build() {
         return new MesEnclosureQhseRectifyDTOParam(this.id, this.qhseId, this.rectifyDrawing, this.remark, this.refuseRemark, this.userId, this.drawingIds);
      }

      @Override
      public String toString() {
         return "MesEnclosureQhseRectifyDTOParam.MesEnclosureQhseRectifyDTOParamBuilder(id="
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
            + ", drawingIds="
            + this.drawingIds
            + ")";
      }
   }
}
