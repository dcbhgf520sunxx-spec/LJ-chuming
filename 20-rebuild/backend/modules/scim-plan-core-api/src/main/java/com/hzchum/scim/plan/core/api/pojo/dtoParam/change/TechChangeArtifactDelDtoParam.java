package com.hzchum.scim.plan.core.api.pojo.dtoParam.change;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class TechChangeArtifactDelDtoParam {
   @NotNull(message = "构件ID不能为空!")
   @ApiModelProperty("构件ID")
   private Long artifactId;
   @NotNull(message = "构件序号(流水号)不能为空!")
   @ApiModelProperty("序号")
   private Integer sortNumber;

   public static TechChangeArtifactDelDtoParam.TechChangeArtifactDelDtoParamBuilder builder() {
      return new TechChangeArtifactDelDtoParam.TechChangeArtifactDelDtoParamBuilder();
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TechChangeArtifactDelDtoParam)) {
         return false;
      } else {
         TechChangeArtifactDelDtoParam other = (TechChangeArtifactDelDtoParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$artifactId = this.getArtifactId();
            Object other$artifactId = other.getArtifactId();
            if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
               Object this$sortNumber = this.getSortNumber();
               Object other$sortNumber = other.getSortNumber();
               return this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechChangeArtifactDelDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $sortNumber = this.getSortNumber();
      return result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeArtifactDelDtoParam(artifactId=" + this.getArtifactId() + ", sortNumber=" + this.getSortNumber() + ")";
   }

   public TechChangeArtifactDelDtoParam(final Long artifactId, final Integer sortNumber) {
      this.artifactId = artifactId;
      this.sortNumber = sortNumber;
   }

   public TechChangeArtifactDelDtoParam() {
   }

   public static class TechChangeArtifactDelDtoParamBuilder {
      private Long artifactId;
      private Integer sortNumber;

      TechChangeArtifactDelDtoParamBuilder() {
      }

      public TechChangeArtifactDelDtoParam.TechChangeArtifactDelDtoParamBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechChangeArtifactDelDtoParam.TechChangeArtifactDelDtoParamBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public TechChangeArtifactDelDtoParam build() {
         return new TechChangeArtifactDelDtoParam(this.artifactId, this.sortNumber);
      }

      @Override
      public String toString() {
         return "TechChangeArtifactDelDtoParam.TechChangeArtifactDelDtoParamBuilder(artifactId=" + this.artifactId + ", sortNumber=" + this.sortNumber + ")";
      }
   }
}
