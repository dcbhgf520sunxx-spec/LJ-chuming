package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("项目工价预估组焊配置DTO类")
public class ProjectWageEstimateGroupWeldingDTO {
   @ApiModelProperty(name = "assembleConfigName", value = "部件类型名称", notes = "部件类型名称")
   private String assembleConfigName;
   @ApiModelProperty(name = "assembleSpecPrefixList", value = "部件规格前缀列表", notes = "部件规格前缀列表")
   private List<String> assembleSpecPrefixList;
   @ApiModelProperty(name = "processList", value = "工序id列表", notes = "工序id列表")
   private List<Long> processIdList;
   @ApiModelProperty(name = "processNameList", value = "工序名称列表", notes = "工序名称列表")
   private List<String> processNameList;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   private Integer pricingManner;
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
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;
   @ApiModelProperty(name = "provisionalEstimate", value = "暂估价(元)", notes = "暂估价(元)")
   private BigDecimal provisionalEstimate;

   public static ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder builder() {
      return new ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder();
   }

   public String getAssembleConfigName() {
      return this.assembleConfigName;
   }

   public List<String> getAssembleSpecPrefixList() {
      return this.assembleSpecPrefixList;
   }

   public List<Long> getProcessIdList() {
      return this.processIdList;
   }

   public List<String> getProcessNameList() {
      return this.processNameList;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
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

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getProvisionalEstimate() {
      return this.provisionalEstimate;
   }

   public void setAssembleConfigName(final String assembleConfigName) {
      this.assembleConfigName = assembleConfigName;
   }

   public void setAssembleSpecPrefixList(final List<String> assembleSpecPrefixList) {
      this.assembleSpecPrefixList = assembleSpecPrefixList;
   }

   public void setProcessIdList(final List<Long> processIdList) {
      this.processIdList = processIdList;
   }

   public void setProcessNameList(final List<String> processNameList) {
      this.processNameList = processNameList;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
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

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setProvisionalEstimate(final BigDecimal provisionalEstimate) {
      this.provisionalEstimate = provisionalEstimate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectWageEstimateGroupWeldingDTO)) {
         return false;
      }

      ProjectWageEstimateGroupWeldingDTO other = (ProjectWageEstimateGroupWeldingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pricingManner = this.getPricingManner();
      Object other$pricingManner = other.getPricingManner();
      if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
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
                     Object this$assembleConfigName = this.getAssembleConfigName();
                     Object other$assembleConfigName = other.getAssembleConfigName();
                     if (this$assembleConfigName == null ? other$assembleConfigName == null : this$assembleConfigName.equals(other$assembleConfigName)) {
                        Object this$assembleSpecPrefixList = this.getAssembleSpecPrefixList();
                        Object other$assembleSpecPrefixList = other.getAssembleSpecPrefixList();
                        if (this$assembleSpecPrefixList == null
                           ? other$assembleSpecPrefixList == null
                           : this$assembleSpecPrefixList.equals(other$assembleSpecPrefixList)) {
                           Object this$processIdList = this.getProcessIdList();
                           Object other$processIdList = other.getProcessIdList();
                           if (this$processIdList == null ? other$processIdList == null : this$processIdList.equals(other$processIdList)) {
                              Object this$processNameList = this.getProcessNameList();
                              Object other$processNameList = other.getProcessNameList();
                              if (this$processNameList == null ? other$processNameList == null : this$processNameList.equals(other$processNameList)) {
                                 Object this$unit = this.getUnit();
                                 Object other$unit = other.getUnit();
                                 if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                    Object this$inventoryQuantity = this.getInventoryQuantity();
                                    Object other$inventoryQuantity = other.getInventoryQuantity();
                                    if (this$inventoryQuantity == null
                                       ? other$inventoryQuantity == null
                                       : this$inventoryQuantity.equals(other$inventoryQuantity)) {
                                       Object this$price = this.getPrice();
                                       Object other$price = other.getPrice();
                                       if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                          Object this$provisionalEstimate = this.getProvisionalEstimate();
                                          Object other$provisionalEstimate = other.getProvisionalEstimate();
                                          return this$provisionalEstimate == null
                                             ? other$provisionalEstimate == null
                                             : this$provisionalEstimate.equals(other$provisionalEstimate);
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
      return other instanceof ProjectWageEstimateGroupWeldingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $comparisonOperatorOne = this.getComparisonOperatorOne();
      result = result * 59 + ($comparisonOperatorOne == null ? 43 : $comparisonOperatorOne.hashCode());
      Object $numberOne = this.getNumberOne();
      result = result * 59 + ($numberOne == null ? 43 : $numberOne.hashCode());
      Object $comparisonOperatorTwo = this.getComparisonOperatorTwo();
      result = result * 59 + ($comparisonOperatorTwo == null ? 43 : $comparisonOperatorTwo.hashCode());
      Object $numberTwo = this.getNumberTwo();
      result = result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
      Object $assembleConfigName = this.getAssembleConfigName();
      result = result * 59 + ($assembleConfigName == null ? 43 : $assembleConfigName.hashCode());
      Object $assembleSpecPrefixList = this.getAssembleSpecPrefixList();
      result = result * 59 + ($assembleSpecPrefixList == null ? 43 : $assembleSpecPrefixList.hashCode());
      Object $processIdList = this.getProcessIdList();
      result = result * 59 + ($processIdList == null ? 43 : $processIdList.hashCode());
      Object $processNameList = this.getProcessNameList();
      result = result * 59 + ($processNameList == null ? 43 : $processNameList.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $inventoryQuantity = this.getInventoryQuantity();
      result = result * 59 + ($inventoryQuantity == null ? 43 : $inventoryQuantity.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $provisionalEstimate = this.getProvisionalEstimate();
      return result * 59 + ($provisionalEstimate == null ? 43 : $provisionalEstimate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWageEstimateGroupWeldingDTO(assembleConfigName="
         + this.getAssembleConfigName()
         + ", assembleSpecPrefixList="
         + this.getAssembleSpecPrefixList()
         + ", processIdList="
         + this.getProcessIdList()
         + ", processNameList="
         + this.getProcessNameList()
         + ", pricingManner="
         + this.getPricingManner()
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
         + ", price="
         + this.getPrice()
         + ", provisionalEstimate="
         + this.getProvisionalEstimate()
         + ")";
   }

   public ProjectWageEstimateGroupWeldingDTO() {
   }

   public ProjectWageEstimateGroupWeldingDTO(
      final String assembleConfigName,
      final List<String> assembleSpecPrefixList,
      final List<Long> processIdList,
      final List<String> processNameList,
      final Integer pricingManner,
      final Integer comparisonOperatorOne,
      final Integer numberOne,
      final Integer comparisonOperatorTwo,
      final Integer numberTwo,
      final String unit,
      final BigDecimal inventoryQuantity,
      final BigDecimal price,
      final BigDecimal provisionalEstimate
   ) {
      this.assembleConfigName = assembleConfigName;
      this.assembleSpecPrefixList = assembleSpecPrefixList;
      this.processIdList = processIdList;
      this.processNameList = processNameList;
      this.pricingManner = pricingManner;
      this.comparisonOperatorOne = comparisonOperatorOne;
      this.numberOne = numberOne;
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      this.numberTwo = numberTwo;
      this.unit = unit;
      this.inventoryQuantity = inventoryQuantity;
      this.price = price;
      this.provisionalEstimate = provisionalEstimate;
   }

   public static class ProjectWageEstimateGroupWeldingDTOBuilder {
      private String assembleConfigName;
      private List<String> assembleSpecPrefixList;
      private List<Long> processIdList;
      private List<String> processNameList;
      private Integer pricingManner;
      private Integer comparisonOperatorOne;
      private Integer numberOne;
      private Integer comparisonOperatorTwo;
      private Integer numberTwo;
      private String unit;
      private BigDecimal inventoryQuantity;
      private BigDecimal price;
      private BigDecimal provisionalEstimate;

      ProjectWageEstimateGroupWeldingDTOBuilder() {
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder assembleConfigName(final String assembleConfigName) {
         this.assembleConfigName = assembleConfigName;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder assembleSpecPrefixList(final List<String> assembleSpecPrefixList) {
         this.assembleSpecPrefixList = assembleSpecPrefixList;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder processIdList(final List<Long> processIdList) {
         this.processIdList = processIdList;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder processNameList(final List<String> processNameList) {
         this.processNameList = processNameList;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder comparisonOperatorOne(final Integer comparisonOperatorOne) {
         this.comparisonOperatorOne = comparisonOperatorOne;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder numberOne(final Integer numberOne) {
         this.numberOne = numberOne;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder comparisonOperatorTwo(final Integer comparisonOperatorTwo) {
         this.comparisonOperatorTwo = comparisonOperatorTwo;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder numberTwo(final Integer numberTwo) {
         this.numberTwo = numberTwo;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder inventoryQuantity(final BigDecimal inventoryQuantity) {
         this.inventoryQuantity = inventoryQuantity;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder provisionalEstimate(final BigDecimal provisionalEstimate) {
         this.provisionalEstimate = provisionalEstimate;
         return this;
      }

      public ProjectWageEstimateGroupWeldingDTO build() {
         return new ProjectWageEstimateGroupWeldingDTO(
            this.assembleConfigName,
            this.assembleSpecPrefixList,
            this.processIdList,
            this.processNameList,
            this.pricingManner,
            this.comparisonOperatorOne,
            this.numberOne,
            this.comparisonOperatorTwo,
            this.numberTwo,
            this.unit,
            this.inventoryQuantity,
            this.price,
            this.provisionalEstimate
         );
      }

      @Override
      public String toString() {
         return "ProjectWageEstimateGroupWeldingDTO.ProjectWageEstimateGroupWeldingDTOBuilder(assembleConfigName="
            + this.assembleConfigName
            + ", assembleSpecPrefixList="
            + this.assembleSpecPrefixList
            + ", processIdList="
            + this.processIdList
            + ", processNameList="
            + this.processNameList
            + ", pricingManner="
            + this.pricingManner
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
            + ", price="
            + this.price
            + ", provisionalEstimate="
            + this.provisionalEstimate
            + ")";
      }
   }
}
