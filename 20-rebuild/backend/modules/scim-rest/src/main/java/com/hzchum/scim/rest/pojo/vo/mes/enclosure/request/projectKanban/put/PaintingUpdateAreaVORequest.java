package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.projectKanban.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "PaintingUpdateAreaVORequest", description = "涂装计算清单面积修改请求类")
public class PaintingUpdateAreaVORequest {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @NotNull(message = "单体id不能为空")
   private Long monomerId;
   @ApiModelProperty(name = "paintingType", notes = "涂装类别")
   @JsonProperty("paintingType")
   @JSONField(name = "paintingType")
   @NotNull(message = "涂装类别不能为空")
   private Integer paintingType;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "名称不能为空")
   private String name;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @NotNull(message = "材质不能为空")
   private String material;
   @ApiModelProperty(name = "changeArea", value = "修改后面积")
   @JsonProperty("changeArea")
   @JSONField(name = "changeArea")
   private BigDecimal changeArea;

   public static PaintingUpdateAreaVORequest.PaintingUpdateAreaVORequestBuilder builder() {
      return new PaintingUpdateAreaVORequest.PaintingUpdateAreaVORequestBuilder();
   }

   public PaintingUpdateAreaVORequest() {
   }

   public PaintingUpdateAreaVORequest(
      final Long projectId, final Long monomerId, final Integer paintingType, final String name, final String material, final BigDecimal changeArea
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.paintingType = paintingType;
      this.name = name;
      this.material = material;
      this.changeArea = changeArea;
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

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getChangeArea() {
      return this.changeArea;
   }

   @JsonProperty("projectId")
   public PaintingUpdateAreaVORequest setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public PaintingUpdateAreaVORequest setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("paintingType")
   public PaintingUpdateAreaVORequest setPaintingType(final Integer paintingType) {
      this.paintingType = paintingType;
      return this;
   }

   @JsonProperty("name")
   public PaintingUpdateAreaVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("material")
   public PaintingUpdateAreaVORequest setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("changeArea")
   public PaintingUpdateAreaVORequest setChangeArea(final BigDecimal changeArea) {
      this.changeArea = changeArea;
      return this;
   }

   @Override
   public String toString() {
      return "PaintingUpdateAreaVORequest(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", paintingType="
         + this.getPaintingType()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", changeArea="
         + this.getChangeArea()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintingUpdateAreaVORequest)) {
         return false;
      }

      PaintingUpdateAreaVORequest other = (PaintingUpdateAreaVORequest)o;
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
            if (this$paintingType == null ? other$paintingType == null : this$paintingType.equals(other$paintingType)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$material = this.getMaterial();
                  Object other$material = other.getMaterial();
                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                     Object this$changeArea = this.getChangeArea();
                     Object other$changeArea = other.getChangeArea();
                     return this$changeArea == null ? other$changeArea == null : this$changeArea.equals(other$changeArea);
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
      return other instanceof PaintingUpdateAreaVORequest;
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
      result = result * 59 + ($paintingType == null ? 43 : $paintingType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $changeArea = this.getChangeArea();
      return result * 59 + ($changeArea == null ? 43 : $changeArea.hashCode());
   }

   public static class PaintingUpdateAreaVORequestBuilder {
      private Long projectId;
      private Long monomerId;
      private Integer paintingType;
      private String name;
      private String material;
      private BigDecimal changeArea;

      PaintingUpdateAreaVORequestBuilder() {
      }

      @JsonProperty("projectId")
      public PaintingUpdateAreaVORequest.PaintingUpdateAreaVORequestBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public PaintingUpdateAreaVORequest.PaintingUpdateAreaVORequestBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("paintingType")
      public PaintingUpdateAreaVORequest.PaintingUpdateAreaVORequestBuilder paintingType(final Integer paintingType) {
         this.paintingType = paintingType;
         return this;
      }

      @JsonProperty("name")
      public PaintingUpdateAreaVORequest.PaintingUpdateAreaVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("material")
      public PaintingUpdateAreaVORequest.PaintingUpdateAreaVORequestBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("changeArea")
      public PaintingUpdateAreaVORequest.PaintingUpdateAreaVORequestBuilder changeArea(final BigDecimal changeArea) {
         this.changeArea = changeArea;
         return this;
      }

      public PaintingUpdateAreaVORequest build() {
         return new PaintingUpdateAreaVORequest(this.projectId, this.monomerId, this.paintingType, this.name, this.material, this.changeArea);
      }

      @Override
      public String toString() {
         return "PaintingUpdateAreaVORequest.PaintingUpdateAreaVORequestBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", paintingType="
            + this.paintingType
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", changeArea="
            + this.changeArea
            + ")";
      }
   }
}
