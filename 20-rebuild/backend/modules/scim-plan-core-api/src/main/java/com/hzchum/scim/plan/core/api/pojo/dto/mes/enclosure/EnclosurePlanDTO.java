package com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "EnclosurePlanDTO", description = "围护可排产批次返回类")
public class EnclosurePlanDTO {
   @ApiModelProperty("批次id")
   private Long id;
   @ApiModelProperty("批次名")
   private String name;
   @ApiModelProperty(name = "date", notes = "交货日期")
   private LocalDate date;
   @ApiModelProperty(name = "quantityWork", notes = "工程量")
   private BigDecimal quantityWork;
   @ApiModelProperty(name = "techId", notes = "计划id")
   private Long techId;
   @ApiModelProperty("项目id")
   private Long projectId;

   public static EnclosurePlanDTO.EnclosurePlanDTOBuilder builder() {
      return new EnclosurePlanDTO.EnclosurePlanDTOBuilder();
   }

   public EnclosurePlanDTO() {
   }

   public EnclosurePlanDTO(final Long id, final String name, final LocalDate date, final BigDecimal quantityWork, final Long techId, final Long projectId) {
      this.id = id;
      this.name = name;
      this.date = date;
      this.quantityWork = quantityWork;
      this.techId = techId;
      this.projectId = projectId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public Long getTechId() {
      return this.techId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public EnclosurePlanDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public EnclosurePlanDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public EnclosurePlanDTO setDate(final LocalDate date) {
      this.date = date;
      return this;
   }

   public EnclosurePlanDTO setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
      return this;
   }

   public EnclosurePlanDTO setTechId(final Long techId) {
      this.techId = techId;
      return this;
   }

   public EnclosurePlanDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosurePlanDTO)) {
         return false;
      }

      EnclosurePlanDTO other = (EnclosurePlanDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$techId = this.getTechId();
         Object other$techId = other.getTechId();
         if (this$techId == null ? other$techId == null : this$techId.equals(other$techId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$date = this.getDate();
                  Object other$date = other.getDate();
                  if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                     Object this$quantityWork = this.getQuantityWork();
                     Object other$quantityWork = other.getQuantityWork();
                     return this$quantityWork == null ? other$quantityWork == null : this$quantityWork.equals(other$quantityWork);
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
      return other instanceof EnclosurePlanDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $techId = this.getTechId();
      result = result * 59 + ($techId == null ? 43 : $techId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $quantityWork = this.getQuantityWork();
      return result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosurePlanDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", quantityWork="
         + this.getQuantityWork()
         + ", techId="
         + this.getTechId()
         + ", projectId="
         + this.getProjectId()
         + ")";
   }

   public static class EnclosurePlanDTOBuilder {
      private Long id;
      private String name;
      private LocalDate date;
      private BigDecimal quantityWork;
      private Long techId;
      private Long projectId;

      EnclosurePlanDTOBuilder() {
      }

      public EnclosurePlanDTO.EnclosurePlanDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public EnclosurePlanDTO.EnclosurePlanDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public EnclosurePlanDTO.EnclosurePlanDTOBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public EnclosurePlanDTO.EnclosurePlanDTOBuilder quantityWork(final BigDecimal quantityWork) {
         this.quantityWork = quantityWork;
         return this;
      }

      public EnclosurePlanDTO.EnclosurePlanDTOBuilder techId(final Long techId) {
         this.techId = techId;
         return this;
      }

      public EnclosurePlanDTO.EnclosurePlanDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public EnclosurePlanDTO build() {
         return new EnclosurePlanDTO(this.id, this.name, this.date, this.quantityWork, this.techId, this.projectId);
      }

      @Override
      public String toString() {
         return "EnclosurePlanDTO.EnclosurePlanDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", date="
            + this.date
            + ", quantityWork="
            + this.quantityWork
            + ", techId="
            + this.techId
            + ", projectId="
            + this.projectId
            + ")";
      }
   }
}
