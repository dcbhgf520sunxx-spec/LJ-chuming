package com.hzchum.scim.cut.core.api.request;

public class ProjectInformation {
   private Integer projectNum;
   private Integer nestingNum;
   private Integer partialNesting;
   private Integer noNesting;
   private Integer cuttingNum;
   private Integer partialNum;
   private Integer noCuttingNum;

   public static ProjectInformation.ProjectInformationBuilder builder() {
      return new ProjectInformation.ProjectInformationBuilder();
   }

   public ProjectInformation() {
   }

   public ProjectInformation(
      final Integer projectNum,
      final Integer nestingNum,
      final Integer partialNesting,
      final Integer noNesting,
      final Integer cuttingNum,
      final Integer partialNum,
      final Integer noCuttingNum
   ) {
      this.projectNum = projectNum;
      this.nestingNum = nestingNum;
      this.partialNesting = partialNesting;
      this.noNesting = noNesting;
      this.cuttingNum = cuttingNum;
      this.partialNum = partialNum;
      this.noCuttingNum = noCuttingNum;
   }

   public Integer getProjectNum() {
      return this.projectNum;
   }

   public Integer getNestingNum() {
      return this.nestingNum;
   }

   public Integer getPartialNesting() {
      return this.partialNesting;
   }

   public Integer getNoNesting() {
      return this.noNesting;
   }

   public Integer getCuttingNum() {
      return this.cuttingNum;
   }

   public Integer getPartialNum() {
      return this.partialNum;
   }

   public Integer getNoCuttingNum() {
      return this.noCuttingNum;
   }

   public void setProjectNum(final Integer projectNum) {
      this.projectNum = projectNum;
   }

   public void setNestingNum(final Integer nestingNum) {
      this.nestingNum = nestingNum;
   }

   public void setPartialNesting(final Integer partialNesting) {
      this.partialNesting = partialNesting;
   }

   public void setNoNesting(final Integer noNesting) {
      this.noNesting = noNesting;
   }

   public void setCuttingNum(final Integer cuttingNum) {
      this.cuttingNum = cuttingNum;
   }

   public void setPartialNum(final Integer partialNum) {
      this.partialNum = partialNum;
   }

   public void setNoCuttingNum(final Integer noCuttingNum) {
      this.noCuttingNum = noCuttingNum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInformation)) {
         return false;
      }

      ProjectInformation other = (ProjectInformation)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectNum = this.getProjectNum();
      Object other$projectNum = other.getProjectNum();
      if (this$projectNum == null ? other$projectNum == null : this$projectNum.equals(other$projectNum)) {
         Object this$nestingNum = this.getNestingNum();
         Object other$nestingNum = other.getNestingNum();
         if (this$nestingNum == null ? other$nestingNum == null : this$nestingNum.equals(other$nestingNum)) {
            Object this$partialNesting = this.getPartialNesting();
            Object other$partialNesting = other.getPartialNesting();
            if (this$partialNesting == null ? other$partialNesting == null : this$partialNesting.equals(other$partialNesting)) {
               Object this$noNesting = this.getNoNesting();
               Object other$noNesting = other.getNoNesting();
               if (this$noNesting == null ? other$noNesting == null : this$noNesting.equals(other$noNesting)) {
                  Object this$cuttingNum = this.getCuttingNum();
                  Object other$cuttingNum = other.getCuttingNum();
                  if (this$cuttingNum == null ? other$cuttingNum == null : this$cuttingNum.equals(other$cuttingNum)) {
                     Object this$partialNum = this.getPartialNum();
                     Object other$partialNum = other.getPartialNum();
                     if (this$partialNum == null ? other$partialNum == null : this$partialNum.equals(other$partialNum)) {
                        Object this$noCuttingNum = this.getNoCuttingNum();
                        Object other$noCuttingNum = other.getNoCuttingNum();
                        return this$noCuttingNum == null ? other$noCuttingNum == null : this$noCuttingNum.equals(other$noCuttingNum);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInformation;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectNum = this.getProjectNum();
      result = result * 59 + ($projectNum == null ? 43 : $projectNum.hashCode());
      Object $nestingNum = this.getNestingNum();
      result = result * 59 + ($nestingNum == null ? 43 : $nestingNum.hashCode());
      Object $partialNesting = this.getPartialNesting();
      result = result * 59 + ($partialNesting == null ? 43 : $partialNesting.hashCode());
      Object $noNesting = this.getNoNesting();
      result = result * 59 + ($noNesting == null ? 43 : $noNesting.hashCode());
      Object $cuttingNum = this.getCuttingNum();
      result = result * 59 + ($cuttingNum == null ? 43 : $cuttingNum.hashCode());
      Object $partialNum = this.getPartialNum();
      result = result * 59 + ($partialNum == null ? 43 : $partialNum.hashCode());
      Object $noCuttingNum = this.getNoCuttingNum();
      return result * 59 + ($noCuttingNum == null ? 43 : $noCuttingNum.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInformation(projectNum="
         + this.getProjectNum()
         + ", nestingNum="
         + this.getNestingNum()
         + ", partialNesting="
         + this.getPartialNesting()
         + ", noNesting="
         + this.getNoNesting()
         + ", cuttingNum="
         + this.getCuttingNum()
         + ", partialNum="
         + this.getPartialNum()
         + ", noCuttingNum="
         + this.getNoCuttingNum()
         + ")";
   }

   public static class ProjectInformationBuilder {
      private Integer projectNum;
      private Integer nestingNum;
      private Integer partialNesting;
      private Integer noNesting;
      private Integer cuttingNum;
      private Integer partialNum;
      private Integer noCuttingNum;

      ProjectInformationBuilder() {
      }

      public ProjectInformation.ProjectInformationBuilder projectNum(final Integer projectNum) {
         this.projectNum = projectNum;
         return this;
      }

      public ProjectInformation.ProjectInformationBuilder nestingNum(final Integer nestingNum) {
         this.nestingNum = nestingNum;
         return this;
      }

      public ProjectInformation.ProjectInformationBuilder partialNesting(final Integer partialNesting) {
         this.partialNesting = partialNesting;
         return this;
      }

      public ProjectInformation.ProjectInformationBuilder noNesting(final Integer noNesting) {
         this.noNesting = noNesting;
         return this;
      }

      public ProjectInformation.ProjectInformationBuilder cuttingNum(final Integer cuttingNum) {
         this.cuttingNum = cuttingNum;
         return this;
      }

      public ProjectInformation.ProjectInformationBuilder partialNum(final Integer partialNum) {
         this.partialNum = partialNum;
         return this;
      }

      public ProjectInformation.ProjectInformationBuilder noCuttingNum(final Integer noCuttingNum) {
         this.noCuttingNum = noCuttingNum;
         return this;
      }

      public ProjectInformation build() {
         return new ProjectInformation(
            this.projectNum, this.nestingNum, this.partialNesting, this.noNesting, this.cuttingNum, this.partialNum, this.noCuttingNum
         );
      }

      @Override
      public String toString() {
         return "ProjectInformation.ProjectInformationBuilder(projectNum="
            + this.projectNum
            + ", nestingNum="
            + this.nestingNum
            + ", partialNesting="
            + this.partialNesting
            + ", noNesting="
            + this.noNesting
            + ", cuttingNum="
            + this.cuttingNum
            + ", partialNum="
            + this.partialNum
            + ", noCuttingNum="
            + this.noCuttingNum
            + ")";
      }
   }
}
