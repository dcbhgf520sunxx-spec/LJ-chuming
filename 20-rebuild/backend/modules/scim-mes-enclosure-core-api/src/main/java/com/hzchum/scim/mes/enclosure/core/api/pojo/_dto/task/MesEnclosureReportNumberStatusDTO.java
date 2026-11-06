package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModelProperty;

public class MesEnclosureReportNumberStatusDTO {
   @ApiModelProperty(name = "id", notes = "班组生产上报记录表id")
   private Long id;
   @ApiModelProperty(name = "number", notes = "一物一码的构件序号")
   private Long number;
   @ApiModelProperty(name = "processId", notes = "最后上报的工序id")
   private Long processId;
   @ApiModelProperty(name = "status", notes = "构件出入库状态")
   private Integer status;
   @ApiModelProperty(name = "name", notes = "构件状态")
   private String name;

   public static MesEnclosureReportNumberStatusDTO.MesEnclosureReportNumberStatusDTOBuilder builder() {
      return new MesEnclosureReportNumberStatusDTO.MesEnclosureReportNumberStatusDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getNumber() {
      return this.number;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getName() {
      return this.name;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setNumber(final Long number) {
      this.number = number;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureReportNumberStatusDTO)) {
         return false;
      }

      MesEnclosureReportNumberStatusDTO other = (MesEnclosureReportNumberStatusDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MesEnclosureReportNumberStatusDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureReportNumberStatusDTO(id="
         + this.getId()
         + ", number="
         + this.getNumber()
         + ", processId="
         + this.getProcessId()
         + ", status="
         + this.getStatus()
         + ", name="
         + this.getName()
         + ")";
   }

   public MesEnclosureReportNumberStatusDTO(final Long id, final Long number, final Long processId, final Integer status, final String name) {
      this.id = id;
      this.number = number;
      this.processId = processId;
      this.status = status;
      this.name = name;
   }

   public MesEnclosureReportNumberStatusDTO() {
   }

   public static class MesEnclosureReportNumberStatusDTOBuilder {
      private Long id;
      private Long number;
      private Long processId;
      private Integer status;
      private String name;

      MesEnclosureReportNumberStatusDTOBuilder() {
      }

      public MesEnclosureReportNumberStatusDTO.MesEnclosureReportNumberStatusDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureReportNumberStatusDTO.MesEnclosureReportNumberStatusDTOBuilder number(final Long number) {
         this.number = number;
         return this;
      }

      public MesEnclosureReportNumberStatusDTO.MesEnclosureReportNumberStatusDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesEnclosureReportNumberStatusDTO.MesEnclosureReportNumberStatusDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public MesEnclosureReportNumberStatusDTO.MesEnclosureReportNumberStatusDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesEnclosureReportNumberStatusDTO build() {
         return new MesEnclosureReportNumberStatusDTO(this.id, this.number, this.processId, this.status, this.name);
      }

      @Override
      public String toString() {
         return "MesEnclosureReportNumberStatusDTO.MesEnclosureReportNumberStatusDTOBuilder(id="
            + this.id
            + ", number="
            + this.number
            + ", processId="
            + this.processId
            + ", status="
            + this.status
            + ", name="
            + this.name
            + ")";
      }
   }
}
