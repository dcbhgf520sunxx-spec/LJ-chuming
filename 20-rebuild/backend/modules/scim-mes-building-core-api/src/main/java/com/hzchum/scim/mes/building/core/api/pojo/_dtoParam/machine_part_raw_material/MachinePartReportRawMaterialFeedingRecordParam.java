package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.machine_part_raw_material;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("零件原料投料Param")
public class MachinePartReportRawMaterialFeedingRecordParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("任务工单id")
   private Long taskOrderId;
   @ApiModelProperty("领料明细排产出库审核id")
   private Long pickingApproveDetailId;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("厚度(㎜)")
   private BigDecimal thickness;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty(name = "mete", value = "核算量(g)")
   private BigDecimal mete;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getPickingApproveDetailId() {
      return this.pickingApproveDetailId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setPickingApproveDetailId(final Long pickingApproveDetailId) {
      this.pickingApproveDetailId = pickingApproveDetailId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartReportRawMaterialFeedingRecordParam)) {
         return false;
      }

      MachinePartReportRawMaterialFeedingRecordParam other = (MachinePartReportRawMaterialFeedingRecordParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$taskOrderId = this.getTaskOrderId();
         Object other$taskOrderId = other.getTaskOrderId();
         if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
            Object this$pickingApproveDetailId = this.getPickingApproveDetailId();
            Object other$pickingApproveDetailId = other.getPickingApproveDetailId();
            if (this$pickingApproveDetailId == null ? other$pickingApproveDetailId == null : this$pickingApproveDetailId.equals(other$pickingApproveDetailId)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$mete = this.getMete();
                        Object other$mete = other.getMete();
                        return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof MachinePartReportRawMaterialFeedingRecordParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $pickingApproveDetailId = this.getPickingApproveDetailId();
      result = result * 59 + ($pickingApproveDetailId == null ? 43 : $pickingApproveDetailId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePartReportRawMaterialFeedingRecordParam(projectId="
         + this.getProjectId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", pickingApproveDetailId="
         + this.getPickingApproveDetailId()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", material="
         + this.getMaterial()
         + ", mete="
         + this.getMete()
         + ")";
   }
}
