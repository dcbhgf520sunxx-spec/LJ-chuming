package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProjectConvertDTO {
   private Long classifyId;
   private String classifyName;
   private ProjectInfo project;
   private BigDecimal amountExcludingVat;
   private BigDecimal mete;
   private BigDecimal quantity;
   private LocalDateTime startTime;
   private LocalDateTime endTime;

   public static ProjectConvertDTO.ProjectConvertDTOBuilder builder() {
      return new ProjectConvertDTO.ProjectConvertDTOBuilder();
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectConvertDTO)) {
         return false;
      }

      ProjectConvertDTO other = (ProjectConvertDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$classifyName = this.getClassifyName();
         Object other$classifyName = other.getClassifyName();
         if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$amountExcludingVat = this.getAmountExcludingVat();
               Object other$amountExcludingVat = other.getAmountExcludingVat();
               if (this$amountExcludingVat == null ? other$amountExcludingVat == null : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$startTime = this.getStartTime();
                        Object other$startTime = other.getStartTime();
                        if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                           Object this$endTime = this.getEndTime();
                           Object other$endTime = other.getEndTime();
                           return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
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
      return other instanceof ProjectConvertDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectConvertDTO(classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", project="
         + this.getProject()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ")";
   }

   public ProjectConvertDTO(
      final Long classifyId,
      final String classifyName,
      final ProjectInfo project,
      final BigDecimal amountExcludingVat,
      final BigDecimal mete,
      final BigDecimal quantity,
      final LocalDateTime startTime,
      final LocalDateTime endTime
   ) {
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.project = project;
      this.amountExcludingVat = amountExcludingVat;
      this.mete = mete;
      this.quantity = quantity;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public ProjectConvertDTO() {
   }

   public static class ProjectConvertDTOBuilder {
      private Long classifyId;
      private String classifyName;
      private ProjectInfo project;
      private BigDecimal amountExcludingVat;
      private BigDecimal mete;
      private BigDecimal quantity;
      private LocalDateTime startTime;
      private LocalDateTime endTime;

      ProjectConvertDTOBuilder() {
      }

      public ProjectConvertDTO.ProjectConvertDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ProjectConvertDTO.ProjectConvertDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ProjectConvertDTO.ProjectConvertDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectConvertDTO.ProjectConvertDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public ProjectConvertDTO.ProjectConvertDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectConvertDTO.ProjectConvertDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectConvertDTO.ProjectConvertDTOBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public ProjectConvertDTO.ProjectConvertDTOBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public ProjectConvertDTO build() {
         return new ProjectConvertDTO(
            this.classifyId, this.classifyName, this.project, this.amountExcludingVat, this.mete, this.quantity, this.startTime, this.endTime
         );
      }

      @Override
      public String toString() {
         return "ProjectConvertDTO.ProjectConvertDTOBuilder(classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", project="
            + this.project
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ")";
      }
   }
}
