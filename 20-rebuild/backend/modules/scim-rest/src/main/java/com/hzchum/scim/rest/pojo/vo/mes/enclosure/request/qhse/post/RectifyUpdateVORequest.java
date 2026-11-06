package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.qhse.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureQhseRectifySaveRequest", description = "问题曝光整改 ")
public class RectifyUpdateVORequest {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "refuseRemark", value = "拒绝原因")
   @JsonProperty("refuseRemark")
   @JSONField(name = "refuseRemark")
   @NotNull(message = "拒绝原因不能为空")
   private String refuseRemark;

   public static RectifyUpdateVORequest.RectifyUpdateVORequestBuilder builder() {
      return new RectifyUpdateVORequest.RectifyUpdateVORequestBuilder();
   }

   public RectifyUpdateVORequest(final Long id, final String refuseRemark) {
      this.id = id;
      this.refuseRemark = refuseRemark;
   }

   public RectifyUpdateVORequest() {
   }

   public Long getId() {
      return this.id;
   }

   public String getRefuseRemark() {
      return this.refuseRemark;
   }

   @JsonProperty("id")
   public RectifyUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("refuseRemark")
   public RectifyUpdateVORequest setRefuseRemark(final String refuseRemark) {
      this.refuseRemark = refuseRemark;
      return this;
   }

   @Override
   public String toString() {
      return "RectifyUpdateVORequest(id=" + this.getId() + ", refuseRemark=" + this.getRefuseRemark() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RectifyUpdateVORequest)) {
         return false;
      } else {
         RectifyUpdateVORequest other = (RectifyUpdateVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$refuseRemark = this.getRefuseRemark();
               Object other$refuseRemark = other.getRefuseRemark();
               return this$refuseRemark == null ? other$refuseRemark == null : this$refuseRemark.equals(other$refuseRemark);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RectifyUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $refuseRemark = this.getRefuseRemark();
      return result * 59 + ($refuseRemark == null ? 43 : $refuseRemark.hashCode());
   }

   public static class RectifyUpdateVORequestBuilder {
      private Long id;
      private String refuseRemark;

      RectifyUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public RectifyUpdateVORequest.RectifyUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("refuseRemark")
      public RectifyUpdateVORequest.RectifyUpdateVORequestBuilder refuseRemark(final String refuseRemark) {
         this.refuseRemark = refuseRemark;
         return this;
      }

      public RectifyUpdateVORequest build() {
         return new RectifyUpdateVORequest(this.id, this.refuseRemark);
      }

      @Override
      public String toString() {
         return "RectifyUpdateVORequest.RectifyUpdateVORequestBuilder(id=" + this.id + ", refuseRemark=" + this.refuseRemark + ")";
      }
   }
}
