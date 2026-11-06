package com.hzchum.scim.plan.core.api.pojo.dto.check;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("清单导入状态DTO")
public class MesTechInventoryOperationDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectInfo", value = "项目")
   private ProjectInfo projectInfo;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "monomer", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "monomer", value = "批次")
   private NameInfo areaBatch;
   @ApiModelProperty(name = "importType", value = "导入类型: 1增量导入 2覆盖导入")
   private Integer importType;
   @ApiModelProperty(name = "operationTypeEnum", value = "操作类型: 1清导入单 2清单变更")
   private Integer operationTypeEnum;
   @ApiModelProperty(name = "buildingType", value = "建筑类型 1建钢 2桥梁")
   private Integer buildingType;
   @ApiModelProperty(name = "importUserId", value = "导入人")
   private Long importUserId;
   @ApiModelProperty(name = "createUserName", value = "导入人")
   private String createUserName;
   @ApiModelProperty("是否可测回")
   private Boolean boolRevoke;
   @ApiModelProperty(name = "unit", value = "计量单位")
   private String unit;
   @ApiModelProperty(name = "inventoryReviewedEnum", value = "审核状态", notes = "审核状态")
   private Integer inventoryReviewedEnum;
   @ApiModelProperty(name = "reviewedTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime reviewedTime;
   @ApiModelProperty(name = "createTime", value = "导入时间", notes = "导入时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "reviewedName", value = "审核人名称", notes = "审核人名称")
   private String reviewedName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty("总数量")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalWeight", value = "总重量(kg)")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重(kg)")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "batchNumber", value = "导入批次编号", notes = "导入批次编号")
   @JsonProperty("batchNumber")
   @JSONField(name = "batchNumber")
   private String batchNumber;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProjectInfo() {
      return this.projectInfo;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public NameInfo getAreaBatch() {
      return this.areaBatch;
   }

   public Integer getImportType() {
      return this.importType;
   }

   public Integer getOperationTypeEnum() {
      return this.operationTypeEnum;
   }

   public Integer getBuildingType() {
      return this.buildingType;
   }

   public Long getImportUserId() {
      return this.importUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Boolean getBoolRevoke() {
      return this.boolRevoke;
   }

   public String getUnit() {
      return this.unit;
   }

   public Integer getInventoryReviewedEnum() {
      return this.inventoryReviewedEnum;
   }

   public LocalDateTime getReviewedTime() {
      return this.reviewedTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getReviewedName() {
      return this.reviewedName;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public String getBatchNumber() {
      return this.batchNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectInfo(final ProjectInfo projectInfo) {
      this.projectInfo = projectInfo;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
   }

   public void setImportType(final Integer importType) {
      this.importType = importType;
   }

   public void setOperationTypeEnum(final Integer operationTypeEnum) {
      this.operationTypeEnum = operationTypeEnum;
   }

   public void setBuildingType(final Integer buildingType) {
      this.buildingType = buildingType;
   }

   public void setImportUserId(final Long importUserId) {
      this.importUserId = importUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setBoolRevoke(final Boolean boolRevoke) {
      this.boolRevoke = boolRevoke;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setInventoryReviewedEnum(final Integer inventoryReviewedEnum) {
      this.inventoryReviewedEnum = inventoryReviewedEnum;
   }

   public void setReviewedTime(final LocalDateTime reviewedTime) {
      this.reviewedTime = reviewedTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewedName(final String reviewedName) {
      this.reviewedName = reviewedName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   @JsonProperty("batchNumber")
   public void setBatchNumber(final String batchNumber) {
      this.batchNumber = batchNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTechInventoryOperationDTO)) {
         return false;
      }

      MesTechInventoryOperationDTO other = (MesTechInventoryOperationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$importType = this.getImportType();
         Object other$importType = other.getImportType();
         if (this$importType == null ? other$importType == null : this$importType.equals(other$importType)) {
            Object this$operationTypeEnum = this.getOperationTypeEnum();
            Object other$operationTypeEnum = other.getOperationTypeEnum();
            if (this$operationTypeEnum == null ? other$operationTypeEnum == null : this$operationTypeEnum.equals(other$operationTypeEnum)) {
               Object this$buildingType = this.getBuildingType();
               Object other$buildingType = other.getBuildingType();
               if (this$buildingType == null ? other$buildingType == null : this$buildingType.equals(other$buildingType)) {
                  Object this$importUserId = this.getImportUserId();
                  Object other$importUserId = other.getImportUserId();
                  if (this$importUserId == null ? other$importUserId == null : this$importUserId.equals(other$importUserId)) {
                     Object this$boolRevoke = this.getBoolRevoke();
                     Object other$boolRevoke = other.getBoolRevoke();
                     if (this$boolRevoke == null ? other$boolRevoke == null : this$boolRevoke.equals(other$boolRevoke)) {
                        Object this$inventoryReviewedEnum = this.getInventoryReviewedEnum();
                        Object other$inventoryReviewedEnum = other.getInventoryReviewedEnum();
                        if (this$inventoryReviewedEnum == null
                           ? other$inventoryReviewedEnum == null
                           : this$inventoryReviewedEnum.equals(other$inventoryReviewedEnum)) {
                           Object this$totalQuantity = this.getTotalQuantity();
                           Object other$totalQuantity = other.getTotalQuantity();
                           if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                              Object this$projectInfo = this.getProjectInfo();
                              Object other$projectInfo = other.getProjectInfo();
                              if (this$projectInfo == null ? other$projectInfo == null : this$projectInfo.equals(other$projectInfo)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$area = this.getArea();
                                    Object other$area = other.getArea();
                                    if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                       Object this$areaBatch = this.getAreaBatch();
                                       Object other$areaBatch = other.getAreaBatch();
                                       if (this$areaBatch == null ? other$areaBatch == null : this$areaBatch.equals(other$areaBatch)) {
                                          Object this$createUserName = this.getCreateUserName();
                                          Object other$createUserName = other.getCreateUserName();
                                          if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                             Object this$unit = this.getUnit();
                                             Object other$unit = other.getUnit();
                                             if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                                Object this$reviewedTime = this.getReviewedTime();
                                                Object other$reviewedTime = other.getReviewedTime();
                                                if (this$reviewedTime == null ? other$reviewedTime == null : this$reviewedTime.equals(other$reviewedTime)) {
                                                   Object this$createTime = this.getCreateTime();
                                                   Object other$createTime = other.getCreateTime();
                                                   if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                      Object this$reviewedName = this.getReviewedName();
                                                      Object other$reviewedName = other.getReviewedName();
                                                      if (this$reviewedName == null ? other$reviewedName == null : this$reviewedName.equals(other$reviewedName)
                                                         )
                                                       {
                                                         Object this$remark = this.getRemark();
                                                         Object other$remark = other.getRemark();
                                                         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                            Object this$totalWeight = this.getTotalWeight();
                                                            Object other$totalWeight = other.getTotalWeight();
                                                            if (this$totalWeight == null
                                                               ? other$totalWeight == null
                                                               : this$totalWeight.equals(other$totalWeight)) {
                                                               Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                               Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                               if (this$totalGrossWeight == null
                                                                  ? other$totalGrossWeight == null
                                                                  : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                  Object this$batchNumber = this.getBatchNumber();
                                                                  Object other$batchNumber = other.getBatchNumber();
                                                                  return this$batchNumber == null
                                                                     ? other$batchNumber == null
                                                                     : this$batchNumber.equals(other$batchNumber);
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
      return other instanceof MesTechInventoryOperationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $importType = this.getImportType();
      result = result * 59 + ($importType == null ? 43 : $importType.hashCode());
      Object $operationTypeEnum = this.getOperationTypeEnum();
      result = result * 59 + ($operationTypeEnum == null ? 43 : $operationTypeEnum.hashCode());
      Object $buildingType = this.getBuildingType();
      result = result * 59 + ($buildingType == null ? 43 : $buildingType.hashCode());
      Object $importUserId = this.getImportUserId();
      result = result * 59 + ($importUserId == null ? 43 : $importUserId.hashCode());
      Object $boolRevoke = this.getBoolRevoke();
      result = result * 59 + ($boolRevoke == null ? 43 : $boolRevoke.hashCode());
      Object $inventoryReviewedEnum = this.getInventoryReviewedEnum();
      result = result * 59 + ($inventoryReviewedEnum == null ? 43 : $inventoryReviewedEnum.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $projectInfo = this.getProjectInfo();
      result = result * 59 + ($projectInfo == null ? 43 : $projectInfo.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $reviewedTime = this.getReviewedTime();
      result = result * 59 + ($reviewedTime == null ? 43 : $reviewedTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewedName = this.getReviewedName();
      result = result * 59 + ($reviewedName == null ? 43 : $reviewedName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $batchNumber = this.getBatchNumber();
      return result * 59 + ($batchNumber == null ? 43 : $batchNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MesTechInventoryOperationDTO(id="
         + this.getId()
         + ", projectInfo="
         + this.getProjectInfo()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", importType="
         + this.getImportType()
         + ", operationTypeEnum="
         + this.getOperationTypeEnum()
         + ", buildingType="
         + this.getBuildingType()
         + ", importUserId="
         + this.getImportUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", boolRevoke="
         + this.getBoolRevoke()
         + ", unit="
         + this.getUnit()
         + ", inventoryReviewedEnum="
         + this.getInventoryReviewedEnum()
         + ", reviewedTime="
         + this.getReviewedTime()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewedName="
         + this.getReviewedName()
         + ", remark="
         + this.getRemark()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", batchNumber="
         + this.getBatchNumber()
         + ")";
   }
}
