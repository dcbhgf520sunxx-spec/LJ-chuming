package com.hzchum.scim.rest.pojo.vo.mes.building.request.qhse.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.dtoPatamUtils.IdsDtoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "RectifySaveRequest", description = "问题曝光整改 ")
public class RectifySaveRequest {
   @ApiModelProperty(name = "qhseId", value = "问题曝光id")
   @JsonProperty("qhseId")
   @JSONField(name = "qhseId")
   @NotNull(message = "问题曝光id不能为空")
   private Long qhseId;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @NotNull(message = "整改备注不能为空")
   private String remark;
   @ApiModelProperty(name = "drawingIds", value = "整改图片ids")
   @JsonProperty("drawingIds")
   @JSONField(name = "drawingIds")
   private IdsDtoParam drawingIds;

   public static RectifySaveRequest.RectifySaveRequestBuilder builder() {
      return new RectifySaveRequest.RectifySaveRequestBuilder();
   }

   public RectifySaveRequest() {
   }

   public RectifySaveRequest(final Long qhseId, final String remark, final IdsDtoParam drawingIds) {
      this.qhseId = qhseId;
      this.remark = remark;
      this.drawingIds = drawingIds;
   }

   public Long getQhseId() {
      return this.qhseId;
   }

   public String getRemark() {
      return this.remark;
   }

   public IdsDtoParam getDrawingIds() {
      return this.drawingIds;
   }

   @JsonProperty("qhseId")
   public RectifySaveRequest setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("remark")
   public RectifySaveRequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("drawingIds")
   public RectifySaveRequest setDrawingIds(final IdsDtoParam drawingIds) {
      this.drawingIds = drawingIds;
      return this;
   }

   @Override
   public String toString() {
      return "RectifySaveRequest(qhseId=" + this.getQhseId() + ", remark=" + this.getRemark() + ", drawingIds=" + this.getDrawingIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RectifySaveRequest)) {
         return false;
      }

      RectifySaveRequest other = (RectifySaveRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$qhseId = this.getQhseId();
      Object other$qhseId = other.getQhseId();
      if (this$qhseId == null ? other$qhseId == null : this$qhseId.equals(other$qhseId)) {
         Object this$remark = this.getRemark();
         Object other$remark = other.getRemark();
         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
            Object this$drawingIds = this.getDrawingIds();
            Object other$drawingIds = other.getDrawingIds();
            return this$drawingIds == null ? other$drawingIds == null : this$drawingIds.equals(other$drawingIds);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RectifySaveRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $qhseId = this.getQhseId();
      result = result * 59 + ($qhseId == null ? 43 : $qhseId.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $drawingIds = this.getDrawingIds();
      return result * 59 + ($drawingIds == null ? 43 : $drawingIds.hashCode());
   }

   public static class RectifySaveRequestBuilder {
      private Long qhseId;
      private String remark;
      private IdsDtoParam drawingIds;

      RectifySaveRequestBuilder() {
      }

      @JsonProperty("qhseId")
      public RectifySaveRequest.RectifySaveRequestBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("remark")
      public RectifySaveRequest.RectifySaveRequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("drawingIds")
      public RectifySaveRequest.RectifySaveRequestBuilder drawingIds(final IdsDtoParam drawingIds) {
         this.drawingIds = drawingIds;
         return this;
      }

      public RectifySaveRequest build() {
         return new RectifySaveRequest(this.qhseId, this.remark, this.drawingIds);
      }

      @Override
      public String toString() {
         return "RectifySaveRequest.RectifySaveRequestBuilder(qhseId=" + this.qhseId + ", remark=" + this.remark + ", drawingIds=" + this.drawingIds + ")";
      }
   }
}
