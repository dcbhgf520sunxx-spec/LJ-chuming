package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
public class MesBuildingAreaProductDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名")
   private String projectName;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名")
   private String monomerName;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名")
   private String areaName;
   @ApiModelProperty(name = "listQuantity", value = "清单数")
   private Integer listQuantity;
   @ApiModelProperty(name = "listWeight", value = "清单量")
   private BigDecimal listWeight;
   @ApiModelProperty(name = "completeQuantity", value = "完成数")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeWeight", value = "完成量")
   private BigDecimal completeWeight;

   public static MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder builder() {
      return new MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getListQuantity() {
      return this.listQuantity;
   }

   public BigDecimal getListWeight() {
      return this.listWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteWeight() {
      return this.completeWeight;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setListQuantity(final Integer listQuantity) {
      this.listQuantity = listQuantity;
   }

   public void setListWeight(final BigDecimal listWeight) {
      this.listWeight = listWeight;
   }

   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   public void setCompleteWeight(final BigDecimal completeWeight) {
      this.completeWeight = completeWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAreaProductDTO)) {
         return false;
      }

      MesBuildingAreaProductDTO other = (MesBuildingAreaProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$listQuantity = this.getListQuantity();
               Object other$listQuantity = other.getListQuantity();
               if (this$listQuantity == null ? other$listQuantity == null : this$listQuantity.equals(other$listQuantity)) {
                  Object this$completeQuantity = this.getCompleteQuantity();
                  Object other$completeQuantity = other.getCompleteQuantity();
                  if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                     Object this$projectName = this.getProjectName();
                     Object other$projectName = other.getProjectName();
                     if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                        Object this$monomerName = this.getMonomerName();
                        Object other$monomerName = other.getMonomerName();
                        if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                           Object this$areaName = this.getAreaName();
                           Object other$areaName = other.getAreaName();
                           if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                              Object this$listWeight = this.getListWeight();
                              Object other$listWeight = other.getListWeight();
                              if (this$listWeight == null ? other$listWeight == null : this$listWeight.equals(other$listWeight)) {
                                 Object this$completeWeight = this.getCompleteWeight();
                                 Object other$completeWeight = other.getCompleteWeight();
                                 return this$completeWeight == null ? other$completeWeight == null : this$completeWeight.equals(other$completeWeight);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingAreaProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $listQuantity = this.getListQuantity();
      result = result * 59 + ($listQuantity == null ? 43 : $listQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $listWeight = this.getListWeight();
      result = result * 59 + ($listWeight == null ? 43 : $listWeight.hashCode());
      Object $completeWeight = this.getCompleteWeight();
      return result * 59 + ($completeWeight == null ? 43 : $completeWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAreaProductDTO(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", listQuantity="
         + this.getListQuantity()
         + ", listWeight="
         + this.getListWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeWeight="
         + this.getCompleteWeight()
         + ")";
   }

   public MesBuildingAreaProductDTO(
      final Long projectId,
      final String projectName,
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final Integer listQuantity,
      final BigDecimal listWeight,
      final Integer completeQuantity,
      final BigDecimal completeWeight
   ) {
      this.projectId = projectId;
      this.projectName = projectName;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.listQuantity = listQuantity;
      this.listWeight = listWeight;
      this.completeQuantity = completeQuantity;
      this.completeWeight = completeWeight;
   }

   public MesBuildingAreaProductDTO() {
   }

   public static class MesBuildingAreaProductDTOBuilder {
      private Long projectId;
      private String projectName;
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private Integer listQuantity;
      private BigDecimal listWeight;
      private Integer completeQuantity;
      private BigDecimal completeWeight;

      MesBuildingAreaProductDTOBuilder() {
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder listQuantity(final Integer listQuantity) {
         this.listQuantity = listQuantity;
         return this;
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder listWeight(final BigDecimal listWeight) {
         this.listWeight = listWeight;
         return this;
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder completeWeight(final BigDecimal completeWeight) {
         this.completeWeight = completeWeight;
         return this;
      }

      public MesBuildingAreaProductDTO build() {
         return new MesBuildingAreaProductDTO(
            this.projectId,
            this.projectName,
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.listQuantity,
            this.listWeight,
            this.completeQuantity,
            this.completeWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAreaProductDTO.MesBuildingAreaProductDTOBuilder(projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", listQuantity="
            + this.listQuantity
            + ", listWeight="
            + this.listWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeWeight="
            + this.completeWeight
            + ")";
      }
   }
}
