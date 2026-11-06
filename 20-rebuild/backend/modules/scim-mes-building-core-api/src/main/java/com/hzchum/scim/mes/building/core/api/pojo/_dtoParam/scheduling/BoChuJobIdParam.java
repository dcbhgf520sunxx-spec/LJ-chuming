package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "BoChuJobIdParam", description = "柏楚作业下的排版信息接口请求参数")
public class BoChuJobIdParam {
   private List<Integer> jobid;

   public static BoChuJobIdParam.BoChuJobIdParamBuilder builder() {
      return new BoChuJobIdParam.BoChuJobIdParamBuilder();
   }

   public BoChuJobIdParam(final List<Integer> jobid) {
      this.jobid = jobid;
   }

   public BoChuJobIdParam() {
   }

   public List<Integer> getJobid() {
      return this.jobid;
   }

   public BoChuJobIdParam setJobid(final List<Integer> jobid) {
      this.jobid = jobid;
      return this;
   }

   @Override
   public String toString() {
      return "BoChuJobIdParam(jobid=" + this.getJobid() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoChuJobIdParam)) {
         return false;
      }

      BoChuJobIdParam other = (BoChuJobIdParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jobid = this.getJobid();
      Object other$jobid = other.getJobid();
      return this$jobid == null ? other$jobid == null : this$jobid.equals(other$jobid);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BoChuJobIdParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jobid = this.getJobid();
      return result * 59 + ($jobid == null ? 43 : $jobid.hashCode());
   }

   public static class BoChuJobIdParamBuilder {
      private List<Integer> jobid;

      BoChuJobIdParamBuilder() {
      }

      public BoChuJobIdParam.BoChuJobIdParamBuilder jobid(final List<Integer> jobid) {
         this.jobid = jobid;
         return this;
      }

      public BoChuJobIdParam build() {
         return new BoChuJobIdParam(this.jobid);
      }

      @Override
      public String toString() {
         return "BoChuJobIdParam.BoChuJobIdParamBuilder(jobid=" + this.jobid + ")";
      }
   }
}
