package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ArtifactPaintingDTOParam", description = "构件面积修改")
public class ArtifactPaintingDTOParam {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id")
   private Long id;
   @ApiModelProperty(name = "surfaceArea", value = "清单面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @NotNull(message = "清单面积不能为空")
   private BigDecimal surfaceArea;

   public static ArtifactPaintingDTOParam.ArtifactPaintingDTOParamBuilder builder() {
      return new ArtifactPaintingDTOParam.ArtifactPaintingDTOParamBuilder();
   }

   public ArtifactPaintingDTOParam() {
   }

   public ArtifactPaintingDTOParam(final Long id, final BigDecimal surfaceArea) {
      this.id = id;
      this.surfaceArea = surfaceArea;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   @JsonProperty("id")
   public ArtifactPaintingDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("surfaceArea")
   public ArtifactPaintingDTOParam setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactPaintingDTOParam(id=" + this.getId() + ", surfaceArea=" + this.getSurfaceArea() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactPaintingDTOParam)) {
         return false;
      } else {
         ArtifactPaintingDTOParam other = (ArtifactPaintingDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$surfaceArea = this.getSurfaceArea();
               Object other$surfaceArea = other.getSurfaceArea();
               return this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactPaintingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      return result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
   }

   public static class ArtifactPaintingDTOParamBuilder {
      private Long id;
      private BigDecimal surfaceArea;

      ArtifactPaintingDTOParamBuilder() {
      }

      @JsonProperty("id")
      public ArtifactPaintingDTOParam.ArtifactPaintingDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("surfaceArea")
      public ArtifactPaintingDTOParam.ArtifactPaintingDTOParamBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ArtifactPaintingDTOParam build() {
         return new ArtifactPaintingDTOParam(this.id, this.surfaceArea);
      }

      @Override
      public String toString() {
         return "ArtifactPaintingDTOParam.ArtifactPaintingDTOParamBuilder(id=" + this.id + ", surfaceArea=" + this.surfaceArea + ")";
      }
   }
}
