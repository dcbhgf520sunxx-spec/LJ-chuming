package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("项目工价预估下料DTO类")
public class ProjectWageEstimateLayingOffDTO {
   @ApiModelProperty(name = "steelClassificationId", value = "零件类型分类ID", notes = "零件类型分类ID")
   private Long steelClassificationId;
   @ApiModelProperty(name = "steelClassificationName", value = "零件类型分类名称", notes = "零件类型分类名称")
   private String steelClassificationName;
   @ApiModelProperty(name = "specificationPrefixTypeList", value = "规格前缀类型列表", notes = "规格前缀类型列表")
   private List<String> specificationPrefixTypeList;
   @ApiModelProperty(name = "processNameList", value = "生产工序名称列表", notes = "生产工序名称列表")
   private List<String> processNameList;
   @ApiModelProperty(name = "comparisonOperatorOne", value = "比较运算符1", notes = "比较运算符1")
   private Integer comparisonOperatorOne;
   @ApiModelProperty(name = "numberOne", value = "数字1", notes = "数字1")
   private Integer numberOne;
   @ApiModelProperty(name = "comparisonOperatorTwo", value = "比较运算符2", notes = "比较运算符2")
   private Integer comparisonOperatorTwo;
   @ApiModelProperty(name = "numberTwo", value = "数字2", notes = "数字2")
   private Integer numberTwo;
   @ApiModelProperty(name = "unit", value = "计量单位", notes = "计量单位")
   private String unit;
   @ApiModelProperty(name = "inventoryQuantity", value = "清单量", notes = "清单量")
   private BigDecimal inventoryQuantity;
   @ApiModelProperty(name = "fixedUnitPrice", value = "定额单价", notes = "定额单价")
   private BigDecimal fixedUnitPrice;
   @ApiModelProperty(name = "provisionalEstimate", value = "暂估价", notes = "暂估价")
   private BigDecimal provisionalEstimate;
   @ApiModelProperty(name = "machinePartIdList", value = "零件ID列表", notes = "零件ID列表")
   private List<Long> machinePartIdList;
   @ApiModelProperty(name = "artifactIdList", value = "构件ID列表", notes = "构件ID列表")
   private List<Long> artifactIdList;

   public static ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder builder() {
      return new ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder();
   }

   public Long getSteelClassificationId() {
      return this.steelClassificationId;
   }

   public String getSteelClassificationName() {
      return this.steelClassificationName;
   }

   public List<String> getSpecificationPrefixTypeList() {
      return this.specificationPrefixTypeList;
   }

   public List<String> getProcessNameList() {
      return this.processNameList;
   }

   public Integer getComparisonOperatorOne() {
      return this.comparisonOperatorOne;
   }

   public Integer getNumberOne() {
      return this.numberOne;
   }

   public Integer getComparisonOperatorTwo() {
      return this.comparisonOperatorTwo;
   }

   public Integer getNumberTwo() {
      return this.numberTwo;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getInventoryQuantity() {
      return this.inventoryQuantity;
   }

   public BigDecimal getFixedUnitPrice() {
      return this.fixedUnitPrice;
   }

   public BigDecimal getProvisionalEstimate() {
      return this.provisionalEstimate;
   }

   public List<Long> getMachinePartIdList() {
      return this.machinePartIdList;
   }

   public List<Long> getArtifactIdList() {
      return this.artifactIdList;
   }

   public void setSteelClassificationId(final Long steelClassificationId) {
      this.steelClassificationId = steelClassificationId;
   }

   public void setSteelClassificationName(final String steelClassificationName) {
      this.steelClassificationName = steelClassificationName;
   }

   public void setSpecificationPrefixTypeList(final List<String> specificationPrefixTypeList) {
      this.specificationPrefixTypeList = specificationPrefixTypeList;
   }

   public void setProcessNameList(final List<String> processNameList) {
      this.processNameList = processNameList;
   }

   public void setComparisonOperatorOne(final Integer comparisonOperatorOne) {
      this.comparisonOperatorOne = comparisonOperatorOne;
   }

   public void setNumberOne(final Integer numberOne) {
      this.numberOne = numberOne;
   }

   public void setComparisonOperatorTwo(final Integer comparisonOperatorTwo) {
      this.comparisonOperatorTwo = comparisonOperatorTwo;
   }

   public void setNumberTwo(final Integer numberTwo) {
      this.numberTwo = numberTwo;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setInventoryQuantity(final BigDecimal inventoryQuantity) {
      this.inventoryQuantity = inventoryQuantity;
   }

   public void setFixedUnitPrice(final BigDecimal fixedUnitPrice) {
      this.fixedUnitPrice = fixedUnitPrice;
   }

   public void setProvisionalEstimate(final BigDecimal provisionalEstimate) {
      this.provisionalEstimate = provisionalEstimate;
   }

   public void setMachinePartIdList(final List<Long> machinePartIdList) {
      this.machinePartIdList = machinePartIdList;
   }

   public void setArtifactIdList(final List<Long> artifactIdList) {
      this.artifactIdList = artifactIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectWageEstimateLayingOffDTO)) {
         return false;
      }

      ProjectWageEstimateLayingOffDTO other = (ProjectWageEstimateLayingOffDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelClassificationId = this.getSteelClassificationId();
      Object other$steelClassificationId = other.getSteelClassificationId();
      if (this$steelClassificationId == null ? other$steelClassificationId == null : this$steelClassificationId.equals(other$steelClassificationId)) {
         Object this$comparisonOperatorOne = this.getComparisonOperatorOne();
         Object other$comparisonOperatorOne = other.getComparisonOperatorOne();
         if (this$comparisonOperatorOne == null ? other$comparisonOperatorOne == null : this$comparisonOperatorOne.equals(other$comparisonOperatorOne)) {
            Object this$numberOne = this.getNumberOne();
            Object other$numberOne = other.getNumberOne();
            if (this$numberOne == null ? other$numberOne == null : this$numberOne.equals(other$numberOne)) {
               Object this$comparisonOperatorTwo = this.getComparisonOperatorTwo();
               Object other$comparisonOperatorTwo = other.getComparisonOperatorTwo();
               if (this$comparisonOperatorTwo == null ? other$comparisonOperatorTwo == null : this$comparisonOperatorTwo.equals(other$comparisonOperatorTwo)) {
                  Object this$numberTwo = this.getNumberTwo();
                  Object other$numberTwo = other.getNumberTwo();
                  if (this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo)) {
                     Object this$steelClassificationName = this.getSteelClassificationName();
                     Object other$steelClassificationName = other.getSteelClassificationName();
                     if (this$steelClassificationName == null
                        ? other$steelClassificationName == null
                        : this$steelClassificationName.equals(other$steelClassificationName)) {
                        Object this$specificationPrefixTypeList = this.getSpecificationPrefixTypeList();
                        Object other$specificationPrefixTypeList = other.getSpecificationPrefixTypeList();
                        if (this$specificationPrefixTypeList == null
                           ? other$specificationPrefixTypeList == null
                           : this$specificationPrefixTypeList.equals(other$specificationPrefixTypeList)) {
                           Object this$processNameList = this.getProcessNameList();
                           Object other$processNameList = other.getProcessNameList();
                           if (this$processNameList == null ? other$processNameList == null : this$processNameList.equals(other$processNameList)) {
                              Object this$unit = this.getUnit();
                              Object other$unit = other.getUnit();
                              if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                 Object this$inventoryQuantity = this.getInventoryQuantity();
                                 Object other$inventoryQuantity = other.getInventoryQuantity();
                                 if (this$inventoryQuantity == null ? other$inventoryQuantity == null : this$inventoryQuantity.equals(other$inventoryQuantity)) {
                                    Object this$fixedUnitPrice = this.getFixedUnitPrice();
                                    Object other$fixedUnitPrice = other.getFixedUnitPrice();
                                    if (this$fixedUnitPrice == null ? other$fixedUnitPrice == null : this$fixedUnitPrice.equals(other$fixedUnitPrice)) {
                                       Object this$provisionalEstimate = this.getProvisionalEstimate();
                                       Object other$provisionalEstimate = other.getProvisionalEstimate();
                                       if (this$provisionalEstimate == null
                                          ? other$provisionalEstimate == null
                                          : this$provisionalEstimate.equals(other$provisionalEstimate)) {
                                          Object this$machinePartIdList = this.getMachinePartIdList();
                                          Object other$machinePartIdList = other.getMachinePartIdList();
                                          if (this$machinePartIdList == null
                                             ? other$machinePartIdList == null
                                             : this$machinePartIdList.equals(other$machinePartIdList)) {
                                             Object this$artifactIdList = this.getArtifactIdList();
                                             Object other$artifactIdList = other.getArtifactIdList();
                                             return this$artifactIdList == null
                                                ? other$artifactIdList == null
                                                : this$artifactIdList.equals(other$artifactIdList);
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
      return other instanceof ProjectWageEstimateLayingOffDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelClassificationId = this.getSteelClassificationId();
      result = result * 59 + ($steelClassificationId == null ? 43 : $steelClassificationId.hashCode());
      Object $comparisonOperatorOne = this.getComparisonOperatorOne();
      result = result * 59 + ($comparisonOperatorOne == null ? 43 : $comparisonOperatorOne.hashCode());
      Object $numberOne = this.getNumberOne();
      result = result * 59 + ($numberOne == null ? 43 : $numberOne.hashCode());
      Object $comparisonOperatorTwo = this.getComparisonOperatorTwo();
      result = result * 59 + ($comparisonOperatorTwo == null ? 43 : $comparisonOperatorTwo.hashCode());
      Object $numberTwo = this.getNumberTwo();
      result = result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
      Object $steelClassificationName = this.getSteelClassificationName();
      result = result * 59 + ($steelClassificationName == null ? 43 : $steelClassificationName.hashCode());
      Object $specificationPrefixTypeList = this.getSpecificationPrefixTypeList();
      result = result * 59 + ($specificationPrefixTypeList == null ? 43 : $specificationPrefixTypeList.hashCode());
      Object $processNameList = this.getProcessNameList();
      result = result * 59 + ($processNameList == null ? 43 : $processNameList.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $inventoryQuantity = this.getInventoryQuantity();
      result = result * 59 + ($inventoryQuantity == null ? 43 : $inventoryQuantity.hashCode());
      Object $fixedUnitPrice = this.getFixedUnitPrice();
      result = result * 59 + ($fixedUnitPrice == null ? 43 : $fixedUnitPrice.hashCode());
      Object $provisionalEstimate = this.getProvisionalEstimate();
      result = result * 59 + ($provisionalEstimate == null ? 43 : $provisionalEstimate.hashCode());
      Object $machinePartIdList = this.getMachinePartIdList();
      result = result * 59 + ($machinePartIdList == null ? 43 : $machinePartIdList.hashCode());
      Object $artifactIdList = this.getArtifactIdList();
      return result * 59 + ($artifactIdList == null ? 43 : $artifactIdList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWageEstimateLayingOffDTO(steelClassificationId="
         + this.getSteelClassificationId()
         + ", steelClassificationName="
         + this.getSteelClassificationName()
         + ", specificationPrefixTypeList="
         + this.getSpecificationPrefixTypeList()
         + ", processNameList="
         + this.getProcessNameList()
         + ", comparisonOperatorOne="
         + this.getComparisonOperatorOne()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwo="
         + this.getComparisonOperatorTwo()
         + ", numberTwo="
         + this.getNumberTwo()
         + ", unit="
         + this.getUnit()
         + ", inventoryQuantity="
         + this.getInventoryQuantity()
         + ", fixedUnitPrice="
         + this.getFixedUnitPrice()
         + ", provisionalEstimate="
         + this.getProvisionalEstimate()
         + ", machinePartIdList="
         + this.getMachinePartIdList()
         + ", artifactIdList="
         + this.getArtifactIdList()
         + ")";
   }

   public ProjectWageEstimateLayingOffDTO() {
   }

   public ProjectWageEstimateLayingOffDTO(
      final Long steelClassificationId,
      final String steelClassificationName,
      final List<String> specificationPrefixTypeList,
      final List<String> processNameList,
      final Integer comparisonOperatorOne,
      final Integer numberOne,
      final Integer comparisonOperatorTwo,
      final Integer numberTwo,
      final String unit,
      final BigDecimal inventoryQuantity,
      final BigDecimal fixedUnitPrice,
      final BigDecimal provisionalEstimate,
      final List<Long> machinePartIdList,
      final List<Long> artifactIdList
   ) {
      this.steelClassificationId = steelClassificationId;
      this.steelClassificationName = steelClassificationName;
      this.specificationPrefixTypeList = specificationPrefixTypeList;
      this.processNameList = processNameList;
      this.comparisonOperatorOne = comparisonOperatorOne;
      this.numberOne = numberOne;
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      this.numberTwo = numberTwo;
      this.unit = unit;
      this.inventoryQuantity = inventoryQuantity;
      this.fixedUnitPrice = fixedUnitPrice;
      this.provisionalEstimate = provisionalEstimate;
      this.machinePartIdList = machinePartIdList;
      this.artifactIdList = artifactIdList;
   }

   public static class ProjectWageEstimateLayingOffDTOBuilder {
      private Long steelClassificationId;
      private String steelClassificationName;
      private List<String> specificationPrefixTypeList;
      private List<String> processNameList;
      private Integer comparisonOperatorOne;
      private Integer numberOne;
      private Integer comparisonOperatorTwo;
      private Integer numberTwo;
      private String unit;
      private BigDecimal inventoryQuantity;
      private BigDecimal fixedUnitPrice;
      private BigDecimal provisionalEstimate;
      private List<Long> machinePartIdList;
      private List<Long> artifactIdList;

      ProjectWageEstimateLayingOffDTOBuilder() {
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder steelClassificationId(final Long steelClassificationId) {
         this.steelClassificationId = steelClassificationId;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder steelClassificationName(final String steelClassificationName) {
         this.steelClassificationName = steelClassificationName;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder specificationPrefixTypeList(final List<String> specificationPrefixTypeList) {
         this.specificationPrefixTypeList = specificationPrefixTypeList;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder processNameList(final List<String> processNameList) {
         this.processNameList = processNameList;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder comparisonOperatorOne(final Integer comparisonOperatorOne) {
         this.comparisonOperatorOne = comparisonOperatorOne;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder numberOne(final Integer numberOne) {
         this.numberOne = numberOne;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder comparisonOperatorTwo(final Integer comparisonOperatorTwo) {
         this.comparisonOperatorTwo = comparisonOperatorTwo;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder numberTwo(final Integer numberTwo) {
         this.numberTwo = numberTwo;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder inventoryQuantity(final BigDecimal inventoryQuantity) {
         this.inventoryQuantity = inventoryQuantity;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder fixedUnitPrice(final BigDecimal fixedUnitPrice) {
         this.fixedUnitPrice = fixedUnitPrice;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder provisionalEstimate(final BigDecimal provisionalEstimate) {
         this.provisionalEstimate = provisionalEstimate;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder machinePartIdList(final List<Long> machinePartIdList) {
         this.machinePartIdList = machinePartIdList;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder artifactIdList(final List<Long> artifactIdList) {
         this.artifactIdList = artifactIdList;
         return this;
      }

      public ProjectWageEstimateLayingOffDTO build() {
         return new ProjectWageEstimateLayingOffDTO(
            this.steelClassificationId,
            this.steelClassificationName,
            this.specificationPrefixTypeList,
            this.processNameList,
            this.comparisonOperatorOne,
            this.numberOne,
            this.comparisonOperatorTwo,
            this.numberTwo,
            this.unit,
            this.inventoryQuantity,
            this.fixedUnitPrice,
            this.provisionalEstimate,
            this.machinePartIdList,
            this.artifactIdList
         );
      }

      @Override
      public String toString() {
         return "ProjectWageEstimateLayingOffDTO.ProjectWageEstimateLayingOffDTOBuilder(steelClassificationId="
            + this.steelClassificationId
            + ", steelClassificationName="
            + this.steelClassificationName
            + ", specificationPrefixTypeList="
            + this.specificationPrefixTypeList
            + ", processNameList="
            + this.processNameList
            + ", comparisonOperatorOne="
            + this.comparisonOperatorOne
            + ", numberOne="
            + this.numberOne
            + ", comparisonOperatorTwo="
            + this.comparisonOperatorTwo
            + ", numberTwo="
            + this.numberTwo
            + ", unit="
            + this.unit
            + ", inventoryQuantity="
            + this.inventoryQuantity
            + ", fixedUnitPrice="
            + this.fixedUnitPrice
            + ", provisionalEstimate="
            + this.provisionalEstimate
            + ", machinePartIdList="
            + this.machinePartIdList
            + ", artifactIdList="
            + this.artifactIdList
            + ")";
      }
   }
}
