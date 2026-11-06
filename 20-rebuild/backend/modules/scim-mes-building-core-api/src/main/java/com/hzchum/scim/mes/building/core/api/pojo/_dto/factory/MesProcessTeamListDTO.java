package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesProcessTeamListDTO", description = "")
public class MesProcessTeamListDTO {
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "type", notes = "工序类型[压板、钻孔..]", value = "工序类型[压板、钻孔..]")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "prodLineInfo", notes = "产线详情", value = "产线详情")
   private List<MesSimpleProdLineDTO> prodLineInfos;

   public static MesProcessTeamListDTO.MesProcessTeamListDTOBuilder builder() {
      return new MesProcessTeamListDTO.MesProcessTeamListDTOBuilder();
   }

   public MesProcessTeamListDTO() {
   }

   public MesProcessTeamListDTO(
      final Long workshopId,
      final Long processId,
      final String processName,
      final Integer taskTypeEnum,
      final Integer type,
      final List<MesSimpleProdLineDTO> prodLineInfos
   ) {
      this.workshopId = workshopId;
      this.processId = processId;
      this.processName = processName;
      this.taskTypeEnum = taskTypeEnum;
      this.type = type;
      this.prodLineInfos = prodLineInfos;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getType() {
      return this.type;
   }

   public List<MesSimpleProdLineDTO> getProdLineInfos() {
      return this.prodLineInfos;
   }

   @JsonProperty("workshopId")
   public MesProcessTeamListDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("processId")
   public MesProcessTeamListDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public MesProcessTeamListDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesProcessTeamListDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("type")
   public MesProcessTeamListDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   public MesProcessTeamListDTO setProdLineInfos(final List<MesSimpleProdLineDTO> prodLineInfos) {
      this.prodLineInfos = prodLineInfos;
      return this;
   }

   @Override
   public String toString() {
      return "MesProcessTeamListDTO(workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", type="
         + this.getType()
         + ", prodLineInfos="
         + this.getProdLineInfos()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProcessTeamListDTO)) {
         return false;
      }

      MesProcessTeamListDTO other = (MesProcessTeamListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                     Object this$prodLineInfos = this.getProdLineInfos();
                     Object other$prodLineInfos = other.getProdLineInfos();
                     return this$prodLineInfos == null ? other$prodLineInfos == null : this$prodLineInfos.equals(other$prodLineInfos);
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
      return other instanceof MesProcessTeamListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $prodLineInfos = this.getProdLineInfos();
      return result * 59 + ($prodLineInfos == null ? 43 : $prodLineInfos.hashCode());
   }

   public static class MesProcessTeamListDTOBuilder {
      private Long workshopId;
      private Long processId;
      private String processName;
      private Integer taskTypeEnum;
      private Integer type;
      private List<MesSimpleProdLineDTO> prodLineInfos;

      MesProcessTeamListDTOBuilder() {
      }

      @JsonProperty("workshopId")
      public MesProcessTeamListDTO.MesProcessTeamListDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("processId")
      public MesProcessTeamListDTO.MesProcessTeamListDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public MesProcessTeamListDTO.MesProcessTeamListDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesProcessTeamListDTO.MesProcessTeamListDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("type")
      public MesProcessTeamListDTO.MesProcessTeamListDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesProcessTeamListDTO.MesProcessTeamListDTOBuilder prodLineInfos(final List<MesSimpleProdLineDTO> prodLineInfos) {
         this.prodLineInfos = prodLineInfos;
         return this;
      }

      public MesProcessTeamListDTO build() {
         return new MesProcessTeamListDTO(this.workshopId, this.processId, this.processName, this.taskTypeEnum, this.type, this.prodLineInfos);
      }

      @Override
      public String toString() {
         return "MesProcessTeamListDTO.MesProcessTeamListDTOBuilder(workshopId="
            + this.workshopId
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", type="
            + this.type
            + ", prodLineInfos="
            + this.prodLineInfos
            + ")";
      }
   }
}
