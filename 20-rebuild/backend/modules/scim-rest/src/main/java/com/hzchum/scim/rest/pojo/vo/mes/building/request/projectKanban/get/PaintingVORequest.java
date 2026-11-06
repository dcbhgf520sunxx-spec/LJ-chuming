package com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PaintingVORequest", description = "涂装计算请求类")
public class PaintingVORequest {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "paintingType", notes = "涂装类别")
   @JsonProperty("paintingType")
   @JSONField(name = "paintingType")
   private Integer paintingType;

   public static PaintingVORequest.PaintingVORequestBuilder builder() {
      return new PaintingVORequest.PaintingVORequestBuilder();
   }

   public PaintingVORequest() {
   }

   public PaintingVORequest(final Long projectId, final Long monomerId, final Integer paintingType) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.paintingType = paintingType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getPaintingType() {
      return this.paintingType;
   }

   @JsonProperty("projectId")
   public PaintingVORequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public PaintingVORequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("paintingType")
   public PaintingVORequest setPaintingType(final Integer paintingType) {
      this.paintingType = paintingType;
      return this;
   }

   @Override
   public String toString() {
      return "PaintingVORequest(projectId=" + this.getProjectId() + ", monomerId=" + this.getMonomerId() + ", paintingType=" + this.getPaintingType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintingVORequest)) {
         return false;
      }

      PaintingVORequest other = (PaintingVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$paintingType = this.getPaintingType();
            Object other$paintingType = other.getPaintingType();
            return this$paintingType == null ? other$paintingType == null : this$paintingType.equals(other$paintingType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PaintingVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $paintingType = this.getPaintingType();
      return result * 59 + ($paintingType == null ? 43 : $paintingType.hashCode());
   }

   public static class PaintingVORequestBuilder {
      private Long projectId;
      private Long monomerId;
      private Integer paintingType;

      PaintingVORequestBuilder() {
      }

      @JsonProperty("projectId")
      public PaintingVORequest.PaintingVORequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public PaintingVORequest.PaintingVORequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("paintingType")
      public PaintingVORequest.PaintingVORequestBuilder paintingType(final Integer paintingType) {
         this.paintingType = paintingType;
         return this;
      }

      public PaintingVORequest build() {
         return new PaintingVORequest(this.projectId, this.monomerId, this.paintingType);
      }

      @Override
      public String toString() {
         return "PaintingVORequest.PaintingVORequestBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", paintingType="
            + this.paintingType
            + ")";
      }
   }
}
