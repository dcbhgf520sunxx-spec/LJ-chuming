package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("零件清单汇总导出")
public class MachinePartSummaryExportDTO {
   @ApiModelProperty(name = "id", value = "id")
   private Long id;
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   @Excel(name = "单体名称", width = 20.0)
   private String monomerName;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaId", value = "批次Id")
   private Long areaBatchId;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   @Excel(name = "区域名称", width = 20.0)
   private String areaName;
   @ApiModelProperty(name = "areaBatchName", value = "批次名称")
   @Excel(name = "批次名称", width = 20.0)
   private String areaBatchName;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   @Excel(name = "项目名称", width = 20.0)
   private String projectName;
   @ApiModelProperty(name = "thick", value = "厚度（mm）")
   @Excel(name = "厚度（mm）", width = 20.0)
   private String thick;
   @ApiModelProperty(name = "relationType", value = "关联类型")
   @Excel(name = "关联类型", width = 20.0, replace = {"2_零件版", "16_翼腹板"})
   private String relationType;
   @ApiModelProperty(name = "material", value = "材质")
   @Excel(name = "材质", width = 20.0)
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @Excel(name = "数量", width = 20.0)
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @Excel(name = "总净重（kg）", width = 20.0)
   private BigDecimal totalNetWeight;

   public static MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder builder() {
      return new MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder();
   }

   public MachinePartSummaryExportDTO() {
   }

   public MachinePartSummaryExportDTO(
      final Long id,
      final String monomerName,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final String areaName,
      final String areaBatchName,
      final String projectName,
      final String thick,
      final String relationType,
      final String material,
      final Integer quantity,
      final BigDecimal totalNetWeight
   ) {
      this.id = id;
      this.monomerName = monomerName;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.areaName = areaName;
      this.areaBatchName = areaBatchName;
      this.projectName = projectName;
      this.thick = thick;
      this.relationType = relationType;
      this.material = material;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
   }

   public Long getId() {
      return this.id;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getThick() {
      return this.thick;
   }

   public String getRelationType() {
      return this.relationType;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public MachinePartSummaryExportDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MachinePartSummaryExportDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   public MachinePartSummaryExportDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MachinePartSummaryExportDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MachinePartSummaryExportDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MachinePartSummaryExportDTO setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public MachinePartSummaryExportDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   public MachinePartSummaryExportDTO setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
      return this;
   }

   public MachinePartSummaryExportDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MachinePartSummaryExportDTO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   public MachinePartSummaryExportDTO setRelationType(final String relationType) {
      this.relationType = relationType;
      return this;
   }

   public MachinePartSummaryExportDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public MachinePartSummaryExportDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MachinePartSummaryExportDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartSummaryExportDTO(id="
         + this.getId()
         + ", monomerName="
         + this.getMonomerName()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaName="
         + this.getAreaName()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", projectName="
         + this.getProjectName()
         + ", thick="
         + this.getThick()
         + ", relationType="
         + this.getRelationType()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartSummaryExportDTO)) {
         return false;
      }

      MachinePartSummaryExportDTO other = (MachinePartSummaryExportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$monomerName = this.getMonomerName();
                        Object other$monomerName = other.getMonomerName();
                        if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                           Object this$areaName = this.getAreaName();
                           Object other$areaName = other.getAreaName();
                           if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                              Object this$areaBatchName = this.getAreaBatchName();
                              Object other$areaBatchName = other.getAreaBatchName();
                              if (this$areaBatchName == null ? other$areaBatchName == null : this$areaBatchName.equals(other$areaBatchName)) {
                                 Object this$projectName = this.getProjectName();
                                 Object other$projectName = other.getProjectName();
                                 if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                    Object this$thick = this.getThick();
                                    Object other$thick = other.getThick();
                                    if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                       Object this$relationType = this.getRelationType();
                                       Object other$relationType = other.getRelationType();
                                       if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$totalNetWeight = this.getTotalNetWeight();
                                             Object other$totalNetWeight = other.getTotalNetWeight();
                                             return this$totalNetWeight == null
                                                ? other$totalNetWeight == null
                                                : this$totalNetWeight.equals(other$totalNetWeight);
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
      return other instanceof MachinePartSummaryExportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   public static class MachinePartSummaryExportDTOBuilder {
      private Long id;
      private String monomerName;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private String areaName;
      private String areaBatchName;
      private String projectName;
      private String thick;
      private String relationType;
      private String material;
      private Integer quantity;
      private BigDecimal totalNetWeight;

      MachinePartSummaryExportDTOBuilder() {
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder areaBatchName(final String areaBatchName) {
         this.areaBatchName = areaBatchName;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder relationType(final String relationType) {
         this.relationType = relationType;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MachinePartSummaryExportDTO build() {
         return new MachinePartSummaryExportDTO(
            this.id,
            this.monomerName,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.areaName,
            this.areaBatchName,
            this.projectName,
            this.thick,
            this.relationType,
            this.material,
            this.quantity,
            this.totalNetWeight
         );
      }

      @Override
      public String toString() {
         return "MachinePartSummaryExportDTO.MachinePartSummaryExportDTOBuilder(id="
            + this.id
            + ", monomerName="
            + this.monomerName
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaName="
            + this.areaName
            + ", areaBatchName="
            + this.areaBatchName
            + ", projectName="
            + this.projectName
            + ", thick="
            + this.thick
            + ", relationType="
            + this.relationType
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ")";
      }
   }
}
