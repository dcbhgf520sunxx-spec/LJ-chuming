package com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingQhseRectifyDOParam对象", description = "问题曝光整改 ")
public class MesBuildingQhseRectifyDOParam extends BaseEntity<Long> {
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

   public static MesBuildingQhseRectifyDOParam.MesBuildingQhseRectifyDOParamBuilder builder() {
      return new MesBuildingQhseRectifyDOParam.MesBuildingQhseRectifyDOParamBuilder();
   }

   public MesBuildingQhseRectifyDOParam() {
   }

   public MesBuildingQhseRectifyDOParam(
      final Long id, final Long qhseId, final String rectifyDrawing, final String remark, final String refuseRemark, final Long userId
   ) {
      this.id = id;
      this.qhseId = qhseId;
      this.rectifyDrawing = rectifyDrawing;
      this.remark = remark;
      this.refuseRemark = refuseRemark;
      this.userId = userId;
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

   @JsonProperty("id")
   public MesBuildingQhseRectifyDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseId")
   public MesBuildingQhseRectifyDOParam setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("rectifyDrawing")
   public MesBuildingQhseRectifyDOParam setRectifyDrawing(final String rectifyDrawing) {
      this.rectifyDrawing = rectifyDrawing;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingQhseRectifyDOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("refuseRemark")
   public MesBuildingQhseRectifyDOParam setRefuseRemark(final String refuseRemark) {
      this.refuseRemark = refuseRemark;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingQhseRectifyDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseRectifyDOParam(id="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseRectifyDOParam)) {
         return false;
      }

      MesBuildingQhseRectifyDOParam other = (MesBuildingQhseRectifyDOParam)o;
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
                     return this$refuseRemark == null ? other$refuseRemark == null : this$refuseRemark.equals(other$refuseRemark);
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
      return other instanceof MesBuildingQhseRectifyDOParam;
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
      return result * 59 + ($refuseRemark == null ? 43 : $refuseRemark.hashCode());
   }

   public static class MesBuildingQhseRectifyDOParamBuilder {
      private Long id;
      private Long qhseId;
      private String rectifyDrawing;
      private String remark;
      private String refuseRemark;
      private Long userId;

      MesBuildingQhseRectifyDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseRectifyDOParam.MesBuildingQhseRectifyDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseId")
      public MesBuildingQhseRectifyDOParam.MesBuildingQhseRectifyDOParamBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("rectifyDrawing")
      public MesBuildingQhseRectifyDOParam.MesBuildingQhseRectifyDOParamBuilder rectifyDrawing(final String rectifyDrawing) {
         this.rectifyDrawing = rectifyDrawing;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingQhseRectifyDOParam.MesBuildingQhseRectifyDOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("refuseRemark")
      public MesBuildingQhseRectifyDOParam.MesBuildingQhseRectifyDOParamBuilder refuseRemark(final String refuseRemark) {
         this.refuseRemark = refuseRemark;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingQhseRectifyDOParam.MesBuildingQhseRectifyDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingQhseRectifyDOParam build() {
         return new MesBuildingQhseRectifyDOParam(this.id, this.qhseId, this.rectifyDrawing, this.remark, this.refuseRemark, this.userId);
      }

      @Override
      public String toString() {
         return "MesBuildingQhseRectifyDOParam.MesBuildingQhseRectifyDOParamBuilder(id="
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
            + ")";
      }
   }
}
