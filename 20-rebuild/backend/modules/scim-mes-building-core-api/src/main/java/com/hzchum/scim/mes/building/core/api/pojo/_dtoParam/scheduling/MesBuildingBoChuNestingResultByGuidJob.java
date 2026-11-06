package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingBoChuNestingResultByGuidJob", description = "零件套料排版查询")
public class MesBuildingBoChuNestingResultByGuidJob {
   private Integer job_id;
   private String job_name;

   public static MesBuildingBoChuNestingResultByGuidJob.MesBuildingBoChuNestingResultByGuidJobBuilder builder() {
      return new MesBuildingBoChuNestingResultByGuidJob.MesBuildingBoChuNestingResultByGuidJobBuilder();
   }

   public MesBuildingBoChuNestingResultByGuidJob(final Integer job_id, final String job_name) {
      this.job_id = job_id;
      this.job_name = job_name;
   }

   public MesBuildingBoChuNestingResultByGuidJob() {
   }

   public Integer getJob_id() {
      return this.job_id;
   }

   public String getJob_name() {
      return this.job_name;
   }

   public MesBuildingBoChuNestingResultByGuidJob setJob_id(final Integer job_id) {
      this.job_id = job_id;
      return this;
   }

   public MesBuildingBoChuNestingResultByGuidJob setJob_name(final String job_name) {
      this.job_name = job_name;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBoChuNestingResultByGuidJob(job_id=" + this.getJob_id() + ", job_name=" + this.getJob_name() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingBoChuNestingResultByGuidJob)) {
         return false;
      } else {
         MesBuildingBoChuNestingResultByGuidJob other = (MesBuildingBoChuNestingResultByGuidJob)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$job_id = this.getJob_id();
            Object other$job_id = other.getJob_id();
            if (this$job_id == null ? other$job_id == null : this$job_id.equals(other$job_id)) {
               Object this$job_name = this.getJob_name();
               Object other$job_name = other.getJob_name();
               return this$job_name == null ? other$job_name == null : this$job_name.equals(other$job_name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingBoChuNestingResultByGuidJob;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $job_id = this.getJob_id();
      result = result * 59 + ($job_id == null ? 43 : $job_id.hashCode());
      Object $job_name = this.getJob_name();
      return result * 59 + ($job_name == null ? 43 : $job_name.hashCode());
   }

   public static class MesBuildingBoChuNestingResultByGuidJobBuilder {
      private Integer job_id;
      private String job_name;

      MesBuildingBoChuNestingResultByGuidJobBuilder() {
      }

      public MesBuildingBoChuNestingResultByGuidJob.MesBuildingBoChuNestingResultByGuidJobBuilder job_id(final Integer job_id) {
         this.job_id = job_id;
         return this;
      }

      public MesBuildingBoChuNestingResultByGuidJob.MesBuildingBoChuNestingResultByGuidJobBuilder job_name(final String job_name) {
         this.job_name = job_name;
         return this;
      }

      public MesBuildingBoChuNestingResultByGuidJob build() {
         return new MesBuildingBoChuNestingResultByGuidJob(this.job_id, this.job_name);
      }

      @Override
      public String toString() {
         return "MesBuildingBoChuNestingResultByGuidJob.MesBuildingBoChuNestingResultByGuidJobBuilder(job_id="
            + this.job_id
            + ", job_name="
            + this.job_name
            + ")";
      }
   }
}
