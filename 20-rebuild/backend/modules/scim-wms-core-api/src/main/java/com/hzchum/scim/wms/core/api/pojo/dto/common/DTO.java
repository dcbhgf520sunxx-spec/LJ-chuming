package com.hzchum.scim.wms.core.api.pojo.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;

public class DTO {
   private ProjectInfo project;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO warehouse;
   @JsonInclude(Include.NON_NULL)
   private Long monomerId;
   @JsonInclude(Include.NON_NULL)
   private Long areaId;
   private String monomerName;
   private String areaName;

   public static DTO.DTOBuilder builder() {
      return new DTO.DTOBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DTO)) {
         return false;
      }

      DTO other = (DTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$workshop = this.getWorkshop();
               Object other$workshop = other.getWorkshop();
               if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                  Object this$warehouse = this.getWarehouse();
                  Object other$warehouse = other.getWarehouse();
                  if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
                     Object this$monomerName = this.getMonomerName();
                     Object other$monomerName = other.getMonomerName();
                     if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                        Object this$areaName = this.getAreaName();
                        Object other$areaName = other.getAreaName();
                        return this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName);
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
      return other instanceof DTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      return result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
   }

   @Override
   public String toString() {
      return "DTO(project="
         + this.getProject()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ")";
   }

   public DTO(
      final ProjectInfo project,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO warehouse,
      final Long monomerId,
      final Long areaId,
      final String monomerName,
      final String areaName
   ) {
      this.project = project;
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.monomerName = monomerName;
      this.areaName = areaName;
   }

   public DTO() {
   }

   public static class DTOBuilder {
      private ProjectInfo project;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO warehouse;
      private Long monomerId;
      private Long areaId;
      private String monomerName;
      private String areaName;

      DTOBuilder() {
      }

      public DTO.DTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public DTO.DTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public DTO.DTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public DTO.DTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public DTO.DTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public DTO.DTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public DTO.DTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public DTO build() {
         return new DTO(this.project, this.workshop, this.warehouse, this.monomerId, this.areaId, this.monomerName, this.areaName);
      }

      @Override
      public String toString() {
         return "DTO.DTOBuilder(project="
            + this.project
            + ", workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ")";
      }
   }
}
