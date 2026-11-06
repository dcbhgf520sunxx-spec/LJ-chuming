package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingPartCheckDrillVORequest", description = "零件验证排产请求类")
public class MesBuildingCheckDrillVORequest {
   @ApiModelProperty(name = "partList", value = "零件", notes = "零件")
   @JsonProperty("partList")
   @JSONField(name = "partList")
   private List<MesBuildingPartCheckDrillVORequest> partList;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "cutConfigId", value = "切割方式id", notes = "切割方式id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   @NotNull(message = "切分方式不能为空")
   private Long cutConfigId;
   @ApiModelProperty(name = "thick", value = "厚度", notes = "厚度")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @NotNull(message = "厚度不能为空")
   private String thick;
   @ApiModelProperty("厚度List")
   private List<String> thickList;

   public static MesBuildingCheckDrillVORequest.MesBuildingCheckDrillVORequestBuilder builder() {
      return new MesBuildingCheckDrillVORequest.MesBuildingCheckDrillVORequestBuilder();
   }

   public MesBuildingCheckDrillVORequest(
      final List<MesBuildingPartCheckDrillVORequest> partList,
      final Long schedulingId,
      final Long cutConfigId,
      final String thick,
      final List<String> thickList
   ) {
      this.partList = partList;
      this.schedulingId = schedulingId;
      this.cutConfigId = cutConfigId;
      this.thick = thick;
      this.thickList = thickList;
   }

   public MesBuildingCheckDrillVORequest() {
   }

   public List<MesBuildingPartCheckDrillVORequest> getPartList() {
      return this.partList;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public String getThick() {
      return this.thick;
   }

   public List<String> getThickList() {
      return this.thickList;
   }

   @JsonProperty("partList")
   public MesBuildingCheckDrillVORequest setPartList(final List<MesBuildingPartCheckDrillVORequest> partList) {
      this.partList = partList;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingCheckDrillVORequest setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingCheckDrillVORequest setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingCheckDrillVORequest setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   public MesBuildingCheckDrillVORequest setThickList(final List<String> thickList) {
      this.thickList = thickList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCheckDrillVORequest)) {
         return false;
      }

      MesBuildingCheckDrillVORequest other = (MesBuildingCheckDrillVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$schedulingId = this.getSchedulingId();
      Object other$schedulingId = other.getSchedulingId();
      if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
         Object this$cutConfigId = this.getCutConfigId();
         Object other$cutConfigId = other.getCutConfigId();
         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
            Object this$partList = this.getPartList();
            Object other$partList = other.getPartList();
            if (this$partList == null ? other$partList == null : this$partList.equals(other$partList)) {
               Object this$thick = this.getThick();
               Object other$thick = other.getThick();
               if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                  Object this$thickList = this.getThickList();
                  Object other$thickList = other.getThickList();
                  return this$thickList == null ? other$thickList == null : this$thickList.equals(other$thickList);
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
      return other instanceof MesBuildingCheckDrillVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $partList = this.getPartList();
      result = result * 59 + ($partList == null ? 43 : $partList.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $thickList = this.getThickList();
      return result * 59 + ($thickList == null ? 43 : $thickList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingCheckDrillVORequest(partList="
         + this.getPartList()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", thick="
         + this.getThick()
         + ", thickList="
         + this.getThickList()
         + ")";
   }

   public static class MesBuildingCheckDrillVORequestBuilder {
      private List<MesBuildingPartCheckDrillVORequest> partList;
      private Long schedulingId;
      private Long cutConfigId;
      private String thick;
      private List<String> thickList;

      MesBuildingCheckDrillVORequestBuilder() {
      }

      @JsonProperty("partList")
      public MesBuildingCheckDrillVORequest.MesBuildingCheckDrillVORequestBuilder partList(final List<MesBuildingPartCheckDrillVORequest> partList) {
         this.partList = partList;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingCheckDrillVORequest.MesBuildingCheckDrillVORequestBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingCheckDrillVORequest.MesBuildingCheckDrillVORequestBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingCheckDrillVORequest.MesBuildingCheckDrillVORequestBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public MesBuildingCheckDrillVORequest.MesBuildingCheckDrillVORequestBuilder thickList(final List<String> thickList) {
         this.thickList = thickList;
         return this;
      }

      public MesBuildingCheckDrillVORequest build() {
         return new MesBuildingCheckDrillVORequest(this.partList, this.schedulingId, this.cutConfigId, this.thick, this.thickList);
      }

      @Override
      public String toString() {
         return "MesBuildingCheckDrillVORequest.MesBuildingCheckDrillVORequestBuilder(partList="
            + this.partList
            + ", schedulingId="
            + this.schedulingId
            + ", cutConfigId="
            + this.cutConfigId
            + ", thick="
            + this.thick
            + ", thickList="
            + this.thickList
            + ")";
      }
   }
}
