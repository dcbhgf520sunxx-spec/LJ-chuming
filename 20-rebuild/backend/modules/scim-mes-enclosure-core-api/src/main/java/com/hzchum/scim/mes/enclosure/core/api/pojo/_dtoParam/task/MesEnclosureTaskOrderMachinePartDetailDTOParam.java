package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureTaskOrderMachinePartDetailDTOParam", description = "零件任务工单请求类")
public class MesEnclosureTaskOrderMachinePartDetailDTOParam {
   @ApiModelProperty(name = "id", value = "切割指令id", notes = "切割指令id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   private Long groupsId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @NotNull(message = "要求完成日期不能为空")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "drillGroupsId", value = "钻孔生产组id", notes = "钻孔生产组id")
   @JsonProperty("drillGroupsId")
   @JSONField(name = "drillGroupsId")
   private Long drillGroupsId;
   @ApiModelProperty(name = "drillAskCompleteTime", value = "钻孔要求完成日期", notes = "钻孔要求完成日期")
   @JsonProperty("drillAskCompleteTime")
   @JSONField(name = "drillAskCompleteTime")
   private LocalDateTime drillAskCompleteTime;

   public static MesEnclosureTaskOrderMachinePartDetailDTOParam.MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder builder() {
      return new MesEnclosureTaskOrderMachinePartDetailDTOParam.MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder();
   }

   public MesEnclosureTaskOrderMachinePartDetailDTOParam(
      final Long id, final Long groupsId, final LocalDateTime askCompleteTime, final Long drillGroupsId, final LocalDateTime drillAskCompleteTime
   ) {
      this.id = id;
      this.groupsId = groupsId;
      this.askCompleteTime = askCompleteTime;
      this.drillGroupsId = drillGroupsId;
      this.drillAskCompleteTime = drillAskCompleteTime;
   }

   public MesEnclosureTaskOrderMachinePartDetailDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getDrillGroupsId() {
      return this.drillGroupsId;
   }

   public LocalDateTime getDrillAskCompleteTime() {
      return this.drillAskCompleteTime;
   }

   @JsonProperty("id")
   public MesEnclosureTaskOrderMachinePartDetailDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureTaskOrderMachinePartDetailDTOParam setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureTaskOrderMachinePartDetailDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("drillGroupsId")
   public MesEnclosureTaskOrderMachinePartDetailDTOParam setDrillGroupsId(final Long drillGroupsId) {
      this.drillGroupsId = drillGroupsId;
      return this;
   }

   @JsonProperty("drillAskCompleteTime")
   public MesEnclosureTaskOrderMachinePartDetailDTOParam setDrillAskCompleteTime(final LocalDateTime drillAskCompleteTime) {
      this.drillAskCompleteTime = drillAskCompleteTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderMachinePartDetailDTOParam)) {
         return false;
      }

      MesEnclosureTaskOrderMachinePartDetailDTOParam other = (MesEnclosureTaskOrderMachinePartDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$drillGroupsId = this.getDrillGroupsId();
            Object other$drillGroupsId = other.getDrillGroupsId();
            if (this$drillGroupsId == null ? other$drillGroupsId == null : this$drillGroupsId.equals(other$drillGroupsId)) {
               Object this$askCompleteTime = this.getAskCompleteTime();
               Object other$askCompleteTime = other.getAskCompleteTime();
               if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                  Object this$drillAskCompleteTime = this.getDrillAskCompleteTime();
                  Object other$drillAskCompleteTime = other.getDrillAskCompleteTime();
                  return this$drillAskCompleteTime == null ? other$drillAskCompleteTime == null : this$drillAskCompleteTime.equals(other$drillAskCompleteTime);
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
      return other instanceof MesEnclosureTaskOrderMachinePartDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $drillGroupsId = this.getDrillGroupsId();
      result = result * 59 + ($drillGroupsId == null ? 43 : $drillGroupsId.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $drillAskCompleteTime = this.getDrillAskCompleteTime();
      return result * 59 + ($drillAskCompleteTime == null ? 43 : $drillAskCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderMachinePartDetailDTOParam(id="
         + this.getId()
         + ", groupsId="
         + this.getGroupsId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", drillGroupsId="
         + this.getDrillGroupsId()
         + ", drillAskCompleteTime="
         + this.getDrillAskCompleteTime()
         + ")";
   }

   public static class MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder {
      private Long id;
      private Long groupsId;
      private LocalDateTime askCompleteTime;
      private Long drillGroupsId;
      private LocalDateTime drillAskCompleteTime;

      MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTaskOrderMachinePartDetailDTOParam.MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("groupsId")
      public MesEnclosureTaskOrderMachinePartDetailDTOParam.MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureTaskOrderMachinePartDetailDTOParam.MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder askCompleteTime(
         final LocalDateTime askCompleteTime
      ) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("drillGroupsId")
      public MesEnclosureTaskOrderMachinePartDetailDTOParam.MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder drillGroupsId(final Long drillGroupsId) {
         this.drillGroupsId = drillGroupsId;
         return this;
      }

      @JsonProperty("drillAskCompleteTime")
      public MesEnclosureTaskOrderMachinePartDetailDTOParam.MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder drillAskCompleteTime(
         final LocalDateTime drillAskCompleteTime
      ) {
         this.drillAskCompleteTime = drillAskCompleteTime;
         return this;
      }

      public MesEnclosureTaskOrderMachinePartDetailDTOParam build() {
         return new MesEnclosureTaskOrderMachinePartDetailDTOParam(this.id, this.groupsId, this.askCompleteTime, this.drillGroupsId, this.drillAskCompleteTime);
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderMachinePartDetailDTOParam.MesEnclosureTaskOrderMachinePartDetailDTOParamBuilder(id="
            + this.id
            + ", groupsId="
            + this.groupsId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", drillGroupsId="
            + this.drillGroupsId
            + ", drillAskCompleteTime="
            + this.drillAskCompleteTime
            + ")";
      }
   }
}
