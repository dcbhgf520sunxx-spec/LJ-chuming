package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("人工填报Query")
public class MesManualReportQuery {
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("产品类型枚举")
   private Integer productType;
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("班组id")
   private Long teamId;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("产品类别id")
   private Long productClassId;
   @ApiModelProperty("产品编号")
   private String productSerialNumber;
   @ApiModelProperty("字典id")
   private Long dictionaryId;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
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

   public Long getProductClassId() {
      return this.productClassId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProductClassId(final Long productClassId) {
      this.productClassId = productClassId;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesManualReportQuery)) {
         return false;
      }

      MesManualReportQuery other = (MesManualReportQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$productClassId = this.getProductClassId();
                           Object other$productClassId = other.getProductClassId();
                           if (this$productClassId == null ? other$productClassId == null : this$productClassId.equals(other$productClassId)) {
                              Object this$dictionaryId = this.getDictionaryId();
                              Object other$dictionaryId = other.getDictionaryId();
                              if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                                 Object this$productSerialNumber = this.getProductSerialNumber();
                                 Object other$productSerialNumber = other.getProductSerialNumber();
                                 return this$productSerialNumber == null
                                    ? other$productSerialNumber == null
                                    : this$productSerialNumber.equals(other$productSerialNumber);
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
      return other instanceof MesManualReportQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productClassId = this.getProductClassId();
      result = result * 59 + ($productClassId == null ? 43 : $productClassId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MesManualReportQuery(workshopId="
         + this.getWorkshopId()
         + ", productType="
         + this.getProductType()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productClassId="
         + this.getProductClassId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ")";
   }
}
