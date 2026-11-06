package com.hzchum.scim.plan.core.api.pojo.dtoParam.change;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class TechChangeArtifactUseDtoParam {
   @NotNull(message = "原构件ID不能为空!")
   @ApiModelProperty("原构件ID不能为空")
   private Long lastArtifactId;
   @NotNull(message = "原序号不能为空!")
   @ApiModelProperty("原序号不能为空")
   private Integer lastSortNumber;
   @NotNull(message = "新构件ID不能为空!")
   @ApiModelProperty("新构件ID不能为空")
   private Long newArtifactId;
   @NotNull(message = "新序号不能为空")
   @ApiModelProperty("新序号不能为空")
   private Integer newSortNumber;

   public static TechChangeArtifactUseDtoParam.TechChangeArtifactUseDtoParamBuilder builder() {
      return new TechChangeArtifactUseDtoParam.TechChangeArtifactUseDtoParamBuilder();
   }

   public Long getLastArtifactId() {
      return this.lastArtifactId;
   }

   public Integer getLastSortNumber() {
      return this.lastSortNumber;
   }

   public Long getNewArtifactId() {
      return this.newArtifactId;
   }

   public Integer getNewSortNumber() {
      return this.newSortNumber;
   }

   public void setLastArtifactId(final Long lastArtifactId) {
      this.lastArtifactId = lastArtifactId;
   }

   public void setLastSortNumber(final Integer lastSortNumber) {
      this.lastSortNumber = lastSortNumber;
   }

   public void setNewArtifactId(final Long newArtifactId) {
      this.newArtifactId = newArtifactId;
   }

   public void setNewSortNumber(final Integer newSortNumber) {
      this.newSortNumber = newSortNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeArtifactUseDtoParam)) {
         return false;
      }

      TechChangeArtifactUseDtoParam other = (TechChangeArtifactUseDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$lastArtifactId = this.getLastArtifactId();
      Object other$lastArtifactId = other.getLastArtifactId();
      if (this$lastArtifactId == null ? other$lastArtifactId == null : this$lastArtifactId.equals(other$lastArtifactId)) {
         Object this$lastSortNumber = this.getLastSortNumber();
         Object other$lastSortNumber = other.getLastSortNumber();
         if (this$lastSortNumber == null ? other$lastSortNumber == null : this$lastSortNumber.equals(other$lastSortNumber)) {
            Object this$newArtifactId = this.getNewArtifactId();
            Object other$newArtifactId = other.getNewArtifactId();
            if (this$newArtifactId == null ? other$newArtifactId == null : this$newArtifactId.equals(other$newArtifactId)) {
               Object this$newSortNumber = this.getNewSortNumber();
               Object other$newSortNumber = other.getNewSortNumber();
               return this$newSortNumber == null ? other$newSortNumber == null : this$newSortNumber.equals(other$newSortNumber);
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
      return other instanceof TechChangeArtifactUseDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $lastArtifactId = this.getLastArtifactId();
      result = result * 59 + ($lastArtifactId == null ? 43 : $lastArtifactId.hashCode());
      Object $lastSortNumber = this.getLastSortNumber();
      result = result * 59 + ($lastSortNumber == null ? 43 : $lastSortNumber.hashCode());
      Object $newArtifactId = this.getNewArtifactId();
      result = result * 59 + ($newArtifactId == null ? 43 : $newArtifactId.hashCode());
      Object $newSortNumber = this.getNewSortNumber();
      return result * 59 + ($newSortNumber == null ? 43 : $newSortNumber.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeArtifactUseDtoParam(lastArtifactId="
         + this.getLastArtifactId()
         + ", lastSortNumber="
         + this.getLastSortNumber()
         + ", newArtifactId="
         + this.getNewArtifactId()
         + ", newSortNumber="
         + this.getNewSortNumber()
         + ")";
   }

   public TechChangeArtifactUseDtoParam(final Long lastArtifactId, final Integer lastSortNumber, final Long newArtifactId, final Integer newSortNumber) {
      this.lastArtifactId = lastArtifactId;
      this.lastSortNumber = lastSortNumber;
      this.newArtifactId = newArtifactId;
      this.newSortNumber = newSortNumber;
   }

   public TechChangeArtifactUseDtoParam() {
   }

   public static class TechChangeArtifactUseDtoParamBuilder {
      private Long lastArtifactId;
      private Integer lastSortNumber;
      private Long newArtifactId;
      private Integer newSortNumber;

      TechChangeArtifactUseDtoParamBuilder() {
      }

      public TechChangeArtifactUseDtoParam.TechChangeArtifactUseDtoParamBuilder lastArtifactId(final Long lastArtifactId) {
         this.lastArtifactId = lastArtifactId;
         return this;
      }

      public TechChangeArtifactUseDtoParam.TechChangeArtifactUseDtoParamBuilder lastSortNumber(final Integer lastSortNumber) {
         this.lastSortNumber = lastSortNumber;
         return this;
      }

      public TechChangeArtifactUseDtoParam.TechChangeArtifactUseDtoParamBuilder newArtifactId(final Long newArtifactId) {
         this.newArtifactId = newArtifactId;
         return this;
      }

      public TechChangeArtifactUseDtoParam.TechChangeArtifactUseDtoParamBuilder newSortNumber(final Integer newSortNumber) {
         this.newSortNumber = newSortNumber;
         return this;
      }

      public TechChangeArtifactUseDtoParam build() {
         return new TechChangeArtifactUseDtoParam(this.lastArtifactId, this.lastSortNumber, this.newArtifactId, this.newSortNumber);
      }

      @Override
      public String toString() {
         return "TechChangeArtifactUseDtoParam.TechChangeArtifactUseDtoParamBuilder(lastArtifactId="
            + this.lastArtifactId
            + ", lastSortNumber="
            + this.lastSortNumber
            + ", newArtifactId="
            + this.newArtifactId
            + ", newSortNumber="
            + this.newSortNumber
            + ")";
      }
   }
}
