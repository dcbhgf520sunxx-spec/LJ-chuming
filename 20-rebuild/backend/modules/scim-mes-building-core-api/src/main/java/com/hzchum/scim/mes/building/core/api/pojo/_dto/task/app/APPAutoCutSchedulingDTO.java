package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "APPAutoCutSchedulingDTO", description = "半自动切割任务详情")
public class APPAutoCutSchedulingDTO {
   @ApiModelProperty(name = "appAutoCutSchedulingDetailList", notes = "半自动切割任务")
   @JsonProperty("appAutoCutSchedulingDetailList")
   @JSONField(name = "appAutoCutSchedulingDetailList")
   List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList;

   public static APPAutoCutSchedulingDTO.APPAutoCutSchedulingDTOBuilder builder() {
      return new APPAutoCutSchedulingDTO.APPAutoCutSchedulingDTOBuilder();
   }

   public APPAutoCutSchedulingDTO() {
   }

   public APPAutoCutSchedulingDTO(final List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList) {
      this.appAutoCutSchedulingDetailList = appAutoCutSchedulingDetailList;
   }

   public List<APPAutoCutSchedulingDetail> getAppAutoCutSchedulingDetailList() {
      return this.appAutoCutSchedulingDetailList;
   }

   @JsonProperty("appAutoCutSchedulingDetailList")
   public APPAutoCutSchedulingDTO setAppAutoCutSchedulingDetailList(final List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList) {
      this.appAutoCutSchedulingDetailList = appAutoCutSchedulingDetailList;
      return this;
   }

   @Override
   public String toString() {
      return "APPAutoCutSchedulingDTO(appAutoCutSchedulingDetailList=" + this.getAppAutoCutSchedulingDetailList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPAutoCutSchedulingDTO)) {
         return false;
      }

      APPAutoCutSchedulingDTO other = (APPAutoCutSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$appAutoCutSchedulingDetailList = this.getAppAutoCutSchedulingDetailList();
      Object other$appAutoCutSchedulingDetailList = other.getAppAutoCutSchedulingDetailList();
      return this$appAutoCutSchedulingDetailList == null
         ? other$appAutoCutSchedulingDetailList == null
         : this$appAutoCutSchedulingDetailList.equals(other$appAutoCutSchedulingDetailList);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof APPAutoCutSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $appAutoCutSchedulingDetailList = this.getAppAutoCutSchedulingDetailList();
      return result * 59 + ($appAutoCutSchedulingDetailList == null ? 43 : $appAutoCutSchedulingDetailList.hashCode());
   }

   public static class APPAutoCutSchedulingDTOBuilder {
      private List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList;

      APPAutoCutSchedulingDTOBuilder() {
      }

      @JsonProperty("appAutoCutSchedulingDetailList")
      public APPAutoCutSchedulingDTO.APPAutoCutSchedulingDTOBuilder appAutoCutSchedulingDetailList(
         final List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList
      ) {
         this.appAutoCutSchedulingDetailList = appAutoCutSchedulingDetailList;
         return this;
      }

      public APPAutoCutSchedulingDTO build() {
         return new APPAutoCutSchedulingDTO(this.appAutoCutSchedulingDetailList);
      }

      @Override
      public String toString() {
         return "APPAutoCutSchedulingDTO.APPAutoCutSchedulingDTOBuilder(appAutoCutSchedulingDetailList=" + this.appAutoCutSchedulingDetailList + ")";
      }
   }
}
