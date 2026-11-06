package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingAssembleSchedulingParam", description = "排产请求类")
public class MesBuildingAssembleSchedulingParam {
   @ApiModelProperty(name = "voRequestList", value = "排产构件", notes = "排产构件")
   @JsonProperty("voRequestList")
   @JSONField(name = "voRequestList")
   @NotNull(message = "排产构件不能为空")
   private List<MesBuildingArtifactSchedulingAsssembleVORequest> voRequestList;

   public static MesBuildingAssembleSchedulingParam.MesBuildingAssembleSchedulingParamBuilder builder() {
      return new MesBuildingAssembleSchedulingParam.MesBuildingAssembleSchedulingParamBuilder();
   }

   public MesBuildingAssembleSchedulingParam(final List<MesBuildingArtifactSchedulingAsssembleVORequest> voRequestList) {
      this.voRequestList = voRequestList;
   }

   public MesBuildingAssembleSchedulingParam() {
   }

   public List<MesBuildingArtifactSchedulingAsssembleVORequest> getVoRequestList() {
      return this.voRequestList;
   }

   @JsonProperty("voRequestList")
   public MesBuildingAssembleSchedulingParam setVoRequestList(final List<MesBuildingArtifactSchedulingAsssembleVORequest> voRequestList) {
      this.voRequestList = voRequestList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleSchedulingParam)) {
         return false;
      }

      MesBuildingAssembleSchedulingParam other = (MesBuildingAssembleSchedulingParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$voRequestList = this.getVoRequestList();
      Object other$voRequestList = other.getVoRequestList();
      return this$voRequestList == null ? other$voRequestList == null : this$voRequestList.equals(other$voRequestList);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAssembleSchedulingParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $voRequestList = this.getVoRequestList();
      return result * 59 + ($voRequestList == null ? 43 : $voRequestList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleSchedulingParam(voRequestList=" + this.getVoRequestList() + ")";
   }

   public static class MesBuildingAssembleSchedulingParamBuilder {
      private List<MesBuildingArtifactSchedulingAsssembleVORequest> voRequestList;

      MesBuildingAssembleSchedulingParamBuilder() {
      }

      @JsonProperty("voRequestList")
      public MesBuildingAssembleSchedulingParam.MesBuildingAssembleSchedulingParamBuilder voRequestList(
         final List<MesBuildingArtifactSchedulingAsssembleVORequest> voRequestList
      ) {
         this.voRequestList = voRequestList;
         return this;
      }

      public MesBuildingAssembleSchedulingParam build() {
         return new MesBuildingAssembleSchedulingParam(this.voRequestList);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleSchedulingParam.MesBuildingAssembleSchedulingParamBuilder(voRequestList=" + this.voRequestList + ")";
      }
   }
}
