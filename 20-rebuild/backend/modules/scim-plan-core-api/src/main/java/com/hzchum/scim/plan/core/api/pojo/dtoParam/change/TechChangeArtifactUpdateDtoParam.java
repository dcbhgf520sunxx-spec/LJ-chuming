package com.hzchum.scim.plan.core.api.pojo.dtoParam.change;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TechChangeArtifactUpdateDtoParam {
   @NotNull(message = "构件ID不能为空!")
   @ApiModelProperty("构件ID")
   private Long artifactId;
   @NotNull(message = "构件序号(流水号)不能为空!")
   @ApiModelProperty("序号")
   private Integer sortNumber;
   @NotBlank(message = "变更编号不能为空!")
   @ApiModelProperty("变更编号")
   private String changeSerialNumber;

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public String getChangeSerialNumber() {
      return this.changeSerialNumber;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
   }

   public void setChangeSerialNumber(final String changeSerialNumber) {
      this.changeSerialNumber = changeSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeArtifactUpdateDtoParam)) {
         return false;
      }

      TechChangeArtifactUpdateDtoParam other = (TechChangeArtifactUpdateDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$sortNumber = this.getSortNumber();
         Object other$sortNumber = other.getSortNumber();
         if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
            Object this$changeSerialNumber = this.getChangeSerialNumber();
            Object other$changeSerialNumber = other.getChangeSerialNumber();
            return this$changeSerialNumber == null ? other$changeSerialNumber == null : this$changeSerialNumber.equals(other$changeSerialNumber);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechChangeArtifactUpdateDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $changeSerialNumber = this.getChangeSerialNumber();
      return result * 59 + ($changeSerialNumber == null ? 43 : $changeSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeArtifactUpdateDtoParam(artifactId="
         + this.getArtifactId()
         + ", sortNumber="
         + this.getSortNumber()
         + ", changeSerialNumber="
         + this.getChangeSerialNumber()
         + ")";
   }
}
