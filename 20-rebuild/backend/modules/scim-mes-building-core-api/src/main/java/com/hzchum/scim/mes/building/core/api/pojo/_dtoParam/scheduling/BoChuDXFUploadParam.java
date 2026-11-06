package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import cn.hutool.json.JSONArray;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "BoChuDXFUploadParam", description = "柏楚作业上传DXF接口参数")
public class BoChuDXFUploadParam {
   @JsonProperty("datas")
   private BoChuDXFUploadDataParam datas;
   @JsonProperty("filename")
   private String filename;
   @JsonProperty("jobId")
   private int jobId;
   @JsonProperty("optimization_parm")
   private JSONArray optimization_parm;

   public static BoChuDXFUploadParam.BoChuDXFUploadParamBuilder builder() {
      return new BoChuDXFUploadParam.BoChuDXFUploadParamBuilder();
   }

   public BoChuDXFUploadParam(final BoChuDXFUploadDataParam datas, final String filename, final int jobId, final JSONArray optimization_parm) {
      this.datas = datas;
      this.filename = filename;
      this.jobId = jobId;
      this.optimization_parm = optimization_parm;
   }

   public BoChuDXFUploadParam() {
   }

   public BoChuDXFUploadDataParam getDatas() {
      return this.datas;
   }

   public String getFilename() {
      return this.filename;
   }

   public int getJobId() {
      return this.jobId;
   }

   public JSONArray getOptimization_parm() {
      return this.optimization_parm;
   }

   @JsonProperty("datas")
   public BoChuDXFUploadParam setDatas(final BoChuDXFUploadDataParam datas) {
      this.datas = datas;
      return this;
   }

   @JsonProperty("filename")
   public BoChuDXFUploadParam setFilename(final String filename) {
      this.filename = filename;
      return this;
   }

   @JsonProperty("jobId")
   public BoChuDXFUploadParam setJobId(final int jobId) {
      this.jobId = jobId;
      return this;
   }

   @JsonProperty("optimization_parm")
   public BoChuDXFUploadParam setOptimization_parm(final JSONArray optimization_parm) {
      this.optimization_parm = optimization_parm;
      return this;
   }

   @Override
   public String toString() {
      return "BoChuDXFUploadParam(datas="
         + this.getDatas()
         + ", filename="
         + this.getFilename()
         + ", jobId="
         + this.getJobId()
         + ", optimization_parm="
         + this.getOptimization_parm()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoChuDXFUploadParam)) {
         return false;
      }

      BoChuDXFUploadParam other = (BoChuDXFUploadParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getJobId() != other.getJobId()) {
         return false;
      }

      Object this$datas = this.getDatas();
      Object other$datas = other.getDatas();
      if (this$datas == null ? other$datas == null : this$datas.equals(other$datas)) {
         Object this$filename = this.getFilename();
         Object other$filename = other.getFilename();
         if (this$filename == null ? other$filename == null : this$filename.equals(other$filename)) {
            Object this$optimization_parm = this.getOptimization_parm();
            Object other$optimization_parm = other.getOptimization_parm();
            return this$optimization_parm == null ? other$optimization_parm == null : this$optimization_parm.equals(other$optimization_parm);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BoChuDXFUploadParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getJobId();
      Object $datas = this.getDatas();
      result = result * 59 + ($datas == null ? 43 : $datas.hashCode());
      Object $filename = this.getFilename();
      result = result * 59 + ($filename == null ? 43 : $filename.hashCode());
      Object $optimization_parm = this.getOptimization_parm();
      return result * 59 + ($optimization_parm == null ? 43 : $optimization_parm.hashCode());
   }

   public static class BoChuDXFUploadParamBuilder {
      private BoChuDXFUploadDataParam datas;
      private String filename;
      private int jobId;
      private JSONArray optimization_parm;

      BoChuDXFUploadParamBuilder() {
      }

      @JsonProperty("datas")
      public BoChuDXFUploadParam.BoChuDXFUploadParamBuilder datas(final BoChuDXFUploadDataParam datas) {
         this.datas = datas;
         return this;
      }

      @JsonProperty("filename")
      public BoChuDXFUploadParam.BoChuDXFUploadParamBuilder filename(final String filename) {
         this.filename = filename;
         return this;
      }

      @JsonProperty("jobId")
      public BoChuDXFUploadParam.BoChuDXFUploadParamBuilder jobId(final int jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("optimization_parm")
      public BoChuDXFUploadParam.BoChuDXFUploadParamBuilder optimization_parm(final JSONArray optimization_parm) {
         this.optimization_parm = optimization_parm;
         return this;
      }

      public BoChuDXFUploadParam build() {
         return new BoChuDXFUploadParam(this.datas, this.filename, this.jobId, this.optimization_parm);
      }

      @Override
      public String toString() {
         return "BoChuDXFUploadParam.BoChuDXFUploadParamBuilder(datas="
            + this.datas
            + ", filename="
            + this.filename
            + ", jobId="
            + this.jobId
            + ", optimization_parm="
            + this.optimization_parm
            + ")";
      }
   }
}
