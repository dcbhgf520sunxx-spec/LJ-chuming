package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingNextProcessLinkDTO对象", description = "任务工序关联下一道工序DTO")
public class MesBuildingNextProcessLinkDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   private Long id;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序表id", notes = "任务工序表id")
   @JsonProperty("taskProcessId")
   @TableField("task_process_id")
   private Long taskProcessId;
   @ApiModelProperty(name = "nextProcessId", value = "下一道工序id", notes = "下一道工序id")
   @JsonProperty("nextProcessId")
   @TableField("next_process_id")
   private Long nextProcessId;
   @ApiModelProperty(name = "sequence", value = "工序顺序", notes = "工序顺序")
   @JsonProperty("sequence")
   @TableField("sequence")
   @NotNull(message = "工序顺序不能为空")
   private Integer sequence;

   public static MesBuildingNextProcessLinkDTO.MesBuildingNextProcessLinkDTOBuilder builder() {
      return new MesBuildingNextProcessLinkDTO.MesBuildingNextProcessLinkDTOBuilder();
   }

   public MesBuildingNextProcessLinkDTO() {
   }

   public MesBuildingNextProcessLinkDTO(final Long id, final Long taskProcessId, final Long nextProcessId, final Integer sequence) {
      this.id = id;
      this.taskProcessId = taskProcessId;
      this.nextProcessId = nextProcessId;
      this.sequence = sequence;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getNextProcessId() {
      return this.nextProcessId;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   @JsonProperty("id")
   public MesBuildingNextProcessLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingNextProcessLinkDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("nextProcessId")
   public MesBuildingNextProcessLinkDTO setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingNextProcessLinkDTO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNextProcessLinkDTO(id="
         + this.getId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", nextProcessId="
         + this.getNextProcessId()
         + ", sequence="
         + this.getSequence()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNextProcessLinkDTO)) {
         return false;
      }

      MesBuildingNextProcessLinkDTO other = (MesBuildingNextProcessLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskProcessId = this.getTaskProcessId();
         Object other$taskProcessId = other.getTaskProcessId();
         if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
            Object this$nextProcessId = this.getNextProcessId();
            Object other$nextProcessId = other.getNextProcessId();
            if (this$nextProcessId == null ? other$nextProcessId == null : this$nextProcessId.equals(other$nextProcessId)) {
               Object this$sequence = this.getSequence();
               Object other$sequence = other.getSequence();
               return this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingNextProcessLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $nextProcessId = this.getNextProcessId();
      result = result * 59 + ($nextProcessId == null ? 43 : $nextProcessId.hashCode());
      Object $sequence = this.getSequence();
      return result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
   }

   public static class MesBuildingNextProcessLinkDTOBuilder {
      private Long id;
      private Long taskProcessId;
      private Long nextProcessId;
      private Integer sequence;

      MesBuildingNextProcessLinkDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNextProcessLinkDTO.MesBuildingNextProcessLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingNextProcessLinkDTO.MesBuildingNextProcessLinkDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("nextProcessId")
      public MesBuildingNextProcessLinkDTO.MesBuildingNextProcessLinkDTOBuilder nextProcessId(final Long nextProcessId) {
         this.nextProcessId = nextProcessId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingNextProcessLinkDTO.MesBuildingNextProcessLinkDTOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      public MesBuildingNextProcessLinkDTO build() {
         return new MesBuildingNextProcessLinkDTO(this.id, this.taskProcessId, this.nextProcessId, this.sequence);
      }

      @Override
      public String toString() {
         return "MesBuildingNextProcessLinkDTO.MesBuildingNextProcessLinkDTOBuilder(id="
            + this.id
            + ", taskProcessId="
            + this.taskProcessId
            + ", nextProcessId="
            + this.nextProcessId
            + ", sequence="
            + this.sequence
            + ")";
      }
   }
}
