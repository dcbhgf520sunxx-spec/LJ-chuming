package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProcessReportListDTO", description = "工序报工项目列表DTO")
public class ProcessReportListDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", value = "简称")
   private String shortName;
   @ApiModelProperty(name = "taskQuantity", value = "总任务数")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", value = "完成任务数")
   private Integer completeQuantity;
   @ApiModelProperty(name = "InCompleteQuantity", value = "未完成任务数")
   private Integer inCompleteQuantity;
   @ApiModelProperty(name = "taskProcessIds", value = "工序任务Ids,多个以逗号分隔")
   private String taskProcessIds;

   public static ProcessReportListDTO.ProcessReportListDTOBuilder builder() {
      return new ProcessReportListDTO.ProcessReportListDTOBuilder();
   }

   public ProcessReportListDTO() {
   }

   public ProcessReportListDTO(
      final Long id,
      final String serialNumber,
      final String name,
      final String shortName,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final Integer inCompleteQuantity,
      final String taskProcessIds
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.inCompleteQuantity = inCompleteQuantity;
      this.taskProcessIds = taskProcessIds;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getInCompleteQuantity() {
      return this.inCompleteQuantity;
   }

   public String getTaskProcessIds() {
      return this.taskProcessIds;
   }

   public ProcessReportListDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProcessReportListDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProcessReportListDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ProcessReportListDTO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   public ProcessReportListDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   public ProcessReportListDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   public ProcessReportListDTO setInCompleteQuantity(final Integer inCompleteQuantity) {
      this.inCompleteQuantity = inCompleteQuantity;
      return this;
   }

   public ProcessReportListDTO setTaskProcessIds(final String taskProcessIds) {
      this.taskProcessIds = taskProcessIds;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessReportListDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", inCompleteQuantity="
         + this.getInCompleteQuantity()
         + ", taskProcessIds="
         + this.getTaskProcessIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessReportListDTO)) {
         return false;
      }

      ProcessReportListDTO other = (ProcessReportListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$inCompleteQuantity = this.getInCompleteQuantity();
               Object other$inCompleteQuantity = other.getInCompleteQuantity();
               if (this$inCompleteQuantity == null ? other$inCompleteQuantity == null : this$inCompleteQuantity.equals(other$inCompleteQuantity)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$shortName = this.getShortName();
                        Object other$shortName = other.getShortName();
                        if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                           Object this$taskProcessIds = this.getTaskProcessIds();
                           Object other$taskProcessIds = other.getTaskProcessIds();
                           return this$taskProcessIds == null ? other$taskProcessIds == null : this$taskProcessIds.equals(other$taskProcessIds);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessReportListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inCompleteQuantity = this.getInCompleteQuantity();
      result = result * 59 + ($inCompleteQuantity == null ? 43 : $inCompleteQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $taskProcessIds = this.getTaskProcessIds();
      return result * 59 + ($taskProcessIds == null ? 43 : $taskProcessIds.hashCode());
   }

   public static class ProcessReportListDTOBuilder {
      private Long id;
      private String serialNumber;
      private String name;
      private String shortName;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private Integer inCompleteQuantity;
      private String taskProcessIds;

      ProcessReportListDTOBuilder() {
      }

      public ProcessReportListDTO.ProcessReportListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProcessReportListDTO.ProcessReportListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProcessReportListDTO.ProcessReportListDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProcessReportListDTO.ProcessReportListDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProcessReportListDTO.ProcessReportListDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public ProcessReportListDTO.ProcessReportListDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public ProcessReportListDTO.ProcessReportListDTOBuilder inCompleteQuantity(final Integer inCompleteQuantity) {
         this.inCompleteQuantity = inCompleteQuantity;
         return this;
      }

      public ProcessReportListDTO.ProcessReportListDTOBuilder taskProcessIds(final String taskProcessIds) {
         this.taskProcessIds = taskProcessIds;
         return this;
      }

      public ProcessReportListDTO build() {
         return new ProcessReportListDTO(
            this.id, this.serialNumber, this.name, this.shortName, this.taskQuantity, this.completeQuantity, this.inCompleteQuantity, this.taskProcessIds
         );
      }

      @Override
      public String toString() {
         return "ProcessReportListDTO.ProcessReportListDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", inCompleteQuantity="
            + this.inCompleteQuantity
            + ", taskProcessIds="
            + this.taskProcessIds
            + ")";
      }
   }
}
