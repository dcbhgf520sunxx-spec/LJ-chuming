package com.hzchum.scim.system.core.api.pojo.dto.safety;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("质安人员提报问题排名DTO")
public class SubmitProblemRankDTO {
   @ApiModelProperty(name = "name", notes = "提报人员名字")
   private String name;
   @ApiModelProperty(name = "submitCount", notes = "提报问题总数")
   private Integer submitCount;

   public static SubmitProblemRankDTO.SubmitProblemRankDTOBuilder builder() {
      return new SubmitProblemRankDTO.SubmitProblemRankDTOBuilder();
   }

   public SubmitProblemRankDTO() {
   }

   public SubmitProblemRankDTO(final String name, final Integer submitCount) {
      this.name = name;
      this.submitCount = submitCount;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSubmitCount() {
      return this.submitCount;
   }

   public SubmitProblemRankDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public SubmitProblemRankDTO setSubmitCount(final Integer submitCount) {
      this.submitCount = submitCount;
      return this;
   }

   @Override
   public String toString() {
      return "SubmitProblemRankDTO(name=" + this.getName() + ", submitCount=" + this.getSubmitCount() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SubmitProblemRankDTO)) {
         return false;
      } else {
         SubmitProblemRankDTO other = (SubmitProblemRankDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$submitCount = this.getSubmitCount();
            Object other$submitCount = other.getSubmitCount();
            if (this$submitCount == null ? other$submitCount == null : this$submitCount.equals(other$submitCount)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubmitProblemRankDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $submitCount = this.getSubmitCount();
      result = result * 59 + ($submitCount == null ? 43 : $submitCount.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SubmitProblemRankDTOBuilder {
      private String name;
      private Integer submitCount;

      SubmitProblemRankDTOBuilder() {
      }

      public SubmitProblemRankDTO.SubmitProblemRankDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SubmitProblemRankDTO.SubmitProblemRankDTOBuilder submitCount(final Integer submitCount) {
         this.submitCount = submitCount;
         return this;
      }

      public SubmitProblemRankDTO build() {
         return new SubmitProblemRankDTO(this.name, this.submitCount);
      }

      @Override
      public String toString() {
         return "SubmitProblemRankDTO.SubmitProblemRankDTOBuilder(name=" + this.name + ", submitCount=" + this.submitCount + ")";
      }
   }
}
