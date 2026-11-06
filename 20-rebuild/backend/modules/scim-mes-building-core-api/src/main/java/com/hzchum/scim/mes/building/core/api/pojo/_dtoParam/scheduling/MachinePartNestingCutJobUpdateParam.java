package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MachinePartNestingCutJobUpdateParam", description = "切割任务下发请求类")
public class MachinePartNestingCutJobUpdateParam {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   private String id;
   @ApiModelProperty(name = "cutStatus")
   @JsonProperty("cutStatus")
   private Integer cutStatus;
   @ApiModelProperty(name = "token")
   @JsonProperty("token")
   private String token;
   @ApiModelProperty(name = "taskRate")
   @JsonProperty("taskRate")
   private BigDecimal taskRate;

   public static MachinePartNestingCutJobUpdateParam.MachinePartNestingCutJobUpdateParamBuilder builder() {
      return new MachinePartNestingCutJobUpdateParam.MachinePartNestingCutJobUpdateParamBuilder();
   }

   public MachinePartNestingCutJobUpdateParam(final String id, final Integer cutStatus, final String token, final BigDecimal taskRate) {
      this.id = id;
      this.cutStatus = cutStatus;
      this.token = token;
      this.taskRate = taskRate;
   }

   public MachinePartNestingCutJobUpdateParam() {
   }

   public String getId() {
      return this.id;
   }

   public Integer getCutStatus() {
      return this.cutStatus;
   }

   public String getToken() {
      return this.token;
   }

   public BigDecimal getTaskRate() {
      return this.taskRate;
   }

   @JsonProperty("id")
   public MachinePartNestingCutJobUpdateParam setId(final String id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cutStatus")
   public MachinePartNestingCutJobUpdateParam setCutStatus(final Integer cutStatus) {
      this.cutStatus = cutStatus;
      return this;
   }

   @JsonProperty("token")
   public MachinePartNestingCutJobUpdateParam setToken(final String token) {
      this.token = token;
      return this;
   }

   @JsonProperty("taskRate")
   public MachinePartNestingCutJobUpdateParam setTaskRate(final BigDecimal taskRate) {
      this.taskRate = taskRate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingCutJobUpdateParam)) {
         return false;
      }

      MachinePartNestingCutJobUpdateParam other = (MachinePartNestingCutJobUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$cutStatus = this.getCutStatus();
      Object other$cutStatus = other.getCutStatus();
      if (this$cutStatus == null ? other$cutStatus == null : this$cutStatus.equals(other$cutStatus)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$token = this.getToken();
            Object other$token = other.getToken();
            if (this$token == null ? other$token == null : this$token.equals(other$token)) {
               Object this$taskRate = this.getTaskRate();
               Object other$taskRate = other.getTaskRate();
               return this$taskRate == null ? other$taskRate == null : this$taskRate.equals(other$taskRate);
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
      return other instanceof MachinePartNestingCutJobUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $cutStatus = this.getCutStatus();
      result = result * 59 + ($cutStatus == null ? 43 : $cutStatus.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $token = this.getToken();
      result = result * 59 + ($token == null ? 43 : $token.hashCode());
      Object $taskRate = this.getTaskRate();
      return result * 59 + ($taskRate == null ? 43 : $taskRate.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePartNestingCutJobUpdateParam(id="
         + this.getId()
         + ", cutStatus="
         + this.getCutStatus()
         + ", token="
         + this.getToken()
         + ", taskRate="
         + this.getTaskRate()
         + ")";
   }

   public static class MachinePartNestingCutJobUpdateParamBuilder {
      private String id;
      private Integer cutStatus;
      private String token;
      private BigDecimal taskRate;

      MachinePartNestingCutJobUpdateParamBuilder() {
      }

      @JsonProperty("id")
      public MachinePartNestingCutJobUpdateParam.MachinePartNestingCutJobUpdateParamBuilder id(final String id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cutStatus")
      public MachinePartNestingCutJobUpdateParam.MachinePartNestingCutJobUpdateParamBuilder cutStatus(final Integer cutStatus) {
         this.cutStatus = cutStatus;
         return this;
      }

      @JsonProperty("token")
      public MachinePartNestingCutJobUpdateParam.MachinePartNestingCutJobUpdateParamBuilder token(final String token) {
         this.token = token;
         return this;
      }

      @JsonProperty("taskRate")
      public MachinePartNestingCutJobUpdateParam.MachinePartNestingCutJobUpdateParamBuilder taskRate(final BigDecimal taskRate) {
         this.taskRate = taskRate;
         return this;
      }

      public MachinePartNestingCutJobUpdateParam build() {
         return new MachinePartNestingCutJobUpdateParam(this.id, this.cutStatus, this.token, this.taskRate);
      }

      @Override
      public String toString() {
         return "MachinePartNestingCutJobUpdateParam.MachinePartNestingCutJobUpdateParamBuilder(id="
            + this.id
            + ", cutStatus="
            + this.cutStatus
            + ", token="
            + this.token
            + ", taskRate="
            + this.taskRate
            + ")";
      }
   }
}
