package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MonomerAndProductIdVO", description = "单体和构件产品Id列表VO")
public class MonomerAndProductIdVO {
   @ApiModelProperty(name = "monomerId", notes = "单体Id")
   @NotNull(message = "单体Id不能为空!")
   private Long monomerId;
   @NotEmpty(message = "构件ids不能为空!")
   @ApiModelProperty(name = "artifactIds", notes = "构件ids")
   private List<Long> artifactIds;

   public static MonomerAndProductIdVO.MonomerAndProductIdVOBuilder builder() {
      return new MonomerAndProductIdVO.MonomerAndProductIdVOBuilder();
   }

   public MonomerAndProductIdVO() {
   }

   public MonomerAndProductIdVO(final Long monomerId, final List<Long> artifactIds) {
      this.monomerId = monomerId;
      this.artifactIds = artifactIds;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getArtifactIds() {
      return this.artifactIds;
   }

   public MonomerAndProductIdVO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MonomerAndProductIdVO setArtifactIds(final List<Long> artifactIds) {
      this.artifactIds = artifactIds;
      return this;
   }

   @Override
   public String toString() {
      return "MonomerAndProductIdVO(monomerId=" + this.getMonomerId() + ", artifactIds=" + this.getArtifactIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MonomerAndProductIdVO)) {
         return false;
      } else {
         MonomerAndProductIdVO other = (MonomerAndProductIdVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$artifactIds = this.getArtifactIds();
               Object other$artifactIds = other.getArtifactIds();
               return this$artifactIds == null ? other$artifactIds == null : this$artifactIds.equals(other$artifactIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonomerAndProductIdVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $artifactIds = this.getArtifactIds();
      return result * 59 + ($artifactIds == null ? 43 : $artifactIds.hashCode());
   }

   public static class MonomerAndProductIdVOBuilder {
      private Long monomerId;
      private List<Long> artifactIds;

      MonomerAndProductIdVOBuilder() {
      }

      public MonomerAndProductIdVO.MonomerAndProductIdVOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MonomerAndProductIdVO.MonomerAndProductIdVOBuilder artifactIds(final List<Long> artifactIds) {
         this.artifactIds = artifactIds;
         return this;
      }

      public MonomerAndProductIdVO build() {
         return new MonomerAndProductIdVO(this.monomerId, this.artifactIds);
      }

      @Override
      public String toString() {
         return "MonomerAndProductIdVO.MonomerAndProductIdVOBuilder(monomerId=" + this.monomerId + ", artifactIds=" + this.artifactIds + ")";
      }
   }
}
