package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("")
public class ProductWarehouseDTO {
   @ApiModelProperty("班组id")
   private Long teamId;
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("生产线名称")
   private String productionLineName;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("项目简称")
   private String shortName;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("任务id")
   private Long taskId;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("产品名称")
   private String productName;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("区域名称")
   private String areaName;
   @ApiModelProperty("产品编号")
   private String serialNumber;
   @ApiModelProperty("入库数量")
   private BigDecimal quantity;
   @ApiModelProperty("打印数量")
   private BigDecimal printQuantity;

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getPrintQuantity() {
      return this.printQuantity;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setPrintQuantity(final BigDecimal printQuantity) {
      this.printQuantity = printQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductWarehouseDTO)) {
         return false;
      }

      ProductWarehouseDTO other = (ProductWarehouseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamId = this.getTeamId();
      Object other$teamId = other.getTeamId();
      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$taskId = this.getTaskId();
                     Object other$taskId = other.getTaskId();
                     if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$productionLineName = this.getProductionLineName();
                           Object other$productionLineName = other.getProductionLineName();
                           if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
                              Object this$projectName = this.getProjectName();
                              Object other$projectName = other.getProjectName();
                              if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                 Object this$shortName = this.getShortName();
                                 Object other$shortName = other.getShortName();
                                 if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                    Object this$productName = this.getProductName();
                                    Object other$productName = other.getProductName();
                                    if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                       Object this$monomerName = this.getMonomerName();
                                       Object other$monomerName = other.getMonomerName();
                                       if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                          Object this$areaName = this.getAreaName();
                                          Object other$areaName = other.getAreaName();
                                          if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$quantity = this.getQuantity();
                                                Object other$quantity = other.getQuantity();
                                                if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                   Object this$printQuantity = this.getPrintQuantity();
                                                   Object other$printQuantity = other.getPrintQuantity();
                                                   return this$printQuantity == null
                                                      ? other$printQuantity == null
                                                      : this$printQuantity.equals(other$printQuantity);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductWarehouseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      return result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "ProductWarehouseDTO(teamId="
         + this.getTeamId()
         + ", productId="
         + this.getProductId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", projectName="
         + this.getProjectName()
         + ", shortName="
         + this.getShortName()
         + ", projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
         + ", monomerId="
         + this.getMonomerId()
         + ", taskId="
         + this.getTaskId()
         + ", productType="
         + this.getProductType()
         + ", productName="
         + this.getProductName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ")";
   }
}
