package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "计划管理-项目执行动态DTO类")
public class ProjectExecutionDynamicsDetailDTO {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("单体ID")
   private Long monomerId;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("区域ID")
   private Long areaId;
   @ApiModelProperty("区域名称")
   private String areaName;
   @ApiModelProperty("清单总量(吨)")
   private BigDecimal totalWeight;
   @ApiModelProperty("完成量(吨)")
   private BigDecimal weight;
   @ApiModelProperty("比率")
   private BigDecimal ratio;
   @ApiModelProperty("区域数据")
   private List<ProjectExecutionDynamicsDetailDTO> areaList;

   public Long getProjectId() {
      return this.projectId;
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

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   public List<ProjectExecutionDynamicsDetailDTO> getAreaList() {
      return this.areaList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
   }

   public void setAreaList(final List<ProjectExecutionDynamicsDetailDTO> areaList) {
      this.areaList = areaList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectExecutionDynamicsDetailDTO)) {
         return false;
      }

      ProjectExecutionDynamicsDetailDTO other = (ProjectExecutionDynamicsDetailDTO)o;
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
               Object this$monomerName = this.getMonomerName();
               Object other$monomerName = other.getMonomerName();
               if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                  Object this$areaName = this.getAreaName();
                  Object other$areaName = other.getAreaName();
                  if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                     Object this$totalWeight = this.getTotalWeight();
                     Object other$totalWeight = other.getTotalWeight();
                     if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                        Object this$weight = this.getWeight();
                        Object other$weight = other.getWeight();
                        if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                           Object this$ratio = this.getRatio();
                           Object other$ratio = other.getRatio();
                           if (this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio)) {
                              Object this$areaList = this.getAreaList();
                              Object other$areaList = other.getAreaList();
                              return this$areaList == null ? other$areaList == null : this$areaList.equals(other$areaList);
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
      return other instanceof ProjectExecutionDynamicsDetailDTO;
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
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $ratio = this.getRatio();
      result = result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
      Object $areaList = this.getAreaList();
      return result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectExecutionDynamicsDetailDTO(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", weight="
         + this.getWeight()
         + ", ratio="
         + this.getRatio()
         + ", areaList="
         + this.getAreaList()
         + ")";
   }
}
