package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosurePartCheckDrillVORequest", description = "零件验证排产请求类")
public class MesEnclosureCheckDrillVORequest {
   @ApiModelProperty(name = "partList", value = "零件", notes = "零件")
   @JsonProperty("partList")
   @JSONField(name = "partList")
   private List<MesEnclosurePartCheckDrillVORequest> partList;
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

   public static MesEnclosureCheckDrillVORequest.MesEnclosureCheckDrillVORequestBuilder builder() {
      return new MesEnclosureCheckDrillVORequest.MesEnclosureCheckDrillVORequestBuilder();
   }

   public MesEnclosureCheckDrillVORequest(
      final List<MesEnclosurePartCheckDrillVORequest> partList, final Long schedulingId, final Long cutConfigId, final String thick
   ) {
      this.partList = partList;
      this.schedulingId = schedulingId;
      this.cutConfigId = cutConfigId;
      this.thick = thick;
   }

   public MesEnclosureCheckDrillVORequest() {
   }

   public List<MesEnclosurePartCheckDrillVORequest> getPartList() {
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

   @JsonProperty("partList")
   public MesEnclosureCheckDrillVORequest setPartList(final List<MesEnclosurePartCheckDrillVORequest> partList) {
      this.partList = partList;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesEnclosureCheckDrillVORequest setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesEnclosureCheckDrillVORequest setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("thick")
   public MesEnclosureCheckDrillVORequest setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureCheckDrillVORequest)) {
         return false;
      }

      MesEnclosureCheckDrillVORequest other = (MesEnclosureCheckDrillVORequest)o;
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
               return this$thick == null ? other$thick == null : this$thick.equals(other$thick);
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
      return other instanceof MesEnclosureCheckDrillVORequest;
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
      return result * 59 + ($thick == null ? 43 : $thick.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureCheckDrillVORequest(partList="
         + this.getPartList()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", thick="
         + this.getThick()
         + ")";
   }

   public static class MesEnclosureCheckDrillVORequestBuilder {
      private List<MesEnclosurePartCheckDrillVORequest> partList;
      private Long schedulingId;
      private Long cutConfigId;
      private String thick;

      MesEnclosureCheckDrillVORequestBuilder() {
      }

      @JsonProperty("partList")
      public MesEnclosureCheckDrillVORequest.MesEnclosureCheckDrillVORequestBuilder partList(final List<MesEnclosurePartCheckDrillVORequest> partList) {
         this.partList = partList;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesEnclosureCheckDrillVORequest.MesEnclosureCheckDrillVORequestBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesEnclosureCheckDrillVORequest.MesEnclosureCheckDrillVORequestBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("thick")
      public MesEnclosureCheckDrillVORequest.MesEnclosureCheckDrillVORequestBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public MesEnclosureCheckDrillVORequest build() {
         return new MesEnclosureCheckDrillVORequest(this.partList, this.schedulingId, this.cutConfigId, this.thick);
      }

      @Override
      public String toString() {
         return "MesEnclosureCheckDrillVORequest.MesEnclosureCheckDrillVORequestBuilder(partList="
            + this.partList
            + ", schedulingId="
            + this.schedulingId
            + ", cutConfigId="
            + this.cutConfigId
            + ", thick="
            + this.thick
            + ")";
      }
   }
}
