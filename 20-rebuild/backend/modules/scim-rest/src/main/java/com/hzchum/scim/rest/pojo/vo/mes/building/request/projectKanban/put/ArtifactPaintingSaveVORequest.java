package com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "BoxPaintingSaveVORequest", description = "构件面积修改")
public class ArtifactPaintingSaveVORequest {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id")
   private Long id;
   @ApiModelProperty(name = "surfaceArea", value = "清单面积")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @NotNull(message = "清单面积不能为空")
   @Min(0L)
   private BigDecimal surfaceArea;

   public static ArtifactPaintingSaveVORequest.ArtifactPaintingSaveVORequestBuilder builder() {
      return new ArtifactPaintingSaveVORequest.ArtifactPaintingSaveVORequestBuilder();
   }

   public ArtifactPaintingSaveVORequest() {
   }

   public ArtifactPaintingSaveVORequest(final Long id, final BigDecimal surfaceArea) {
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
   public ArtifactPaintingSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("surfaceArea")
   public ArtifactPaintingSaveVORequest setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactPaintingSaveVORequest(id=" + this.getId() + ", surfaceArea=" + this.getSurfaceArea() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactPaintingSaveVORequest)) {
         return false;
      } else {
         ArtifactPaintingSaveVORequest other = (ArtifactPaintingSaveVORequest)o;
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
      return other instanceof ArtifactPaintingSaveVORequest;
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

   public static class ArtifactPaintingSaveVORequestBuilder {
      private Long id;
      private BigDecimal surfaceArea;

      ArtifactPaintingSaveVORequestBuilder() {
      }

      @JsonProperty("id")
      public ArtifactPaintingSaveVORequest.ArtifactPaintingSaveVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("surfaceArea")
      public ArtifactPaintingSaveVORequest.ArtifactPaintingSaveVORequestBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public ArtifactPaintingSaveVORequest build() {
         return new ArtifactPaintingSaveVORequest(this.id, this.surfaceArea);
      }

      @Override
      public String toString() {
         return "ArtifactPaintingSaveVORequest.ArtifactPaintingSaveVORequestBuilder(id=" + this.id + ", surfaceArea=" + this.surfaceArea + ")";
      }
   }
}
