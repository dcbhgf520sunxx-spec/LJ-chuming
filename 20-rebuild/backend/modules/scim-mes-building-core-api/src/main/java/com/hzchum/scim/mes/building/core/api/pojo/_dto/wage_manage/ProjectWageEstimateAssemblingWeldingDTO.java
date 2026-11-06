package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("项目工价预估装焊配置DTO类")
public class ProjectWageEstimateAssemblingWeldingDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "subId", value = "子ID", notes = "子ID")
   private Long detailId;
   @ApiModelProperty(name = "artifactClassificationName", value = "构件分类名称", notes = "构件分类名称")
   private String artifactClassificationName;
   @ApiModelProperty(name = "typeIndexNameList", value = "规格类型", notes = "规格类型")
   private List<String> SpecificationTypeNameList;
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
   @ApiModelProperty(name = "listWeight", value = "清单量", notes = "清单量")
   private BigDecimal inventoryQuantity;
   @ApiModelProperty(name = "listQuantity", value = "清单数量", notes = "清单数量")
   private BigDecimal totalQuantity;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   private BigDecimal price;
   @ApiModelProperty(name = "provisionalEstimate", value = "暂估价(元)", notes = "暂估价(元)")
   private BigDecimal provisionalEstimate;

   public static ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder builder() {
      return new ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getDetailId() {
      return this.detailId;
   }

   public String getArtifactClassificationName() {
      return this.artifactClassificationName;
   }

   public List<String> getSpecificationTypeNameList() {
      return this.SpecificationTypeNameList;
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

   public BigDecimal getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getProvisionalEstimate() {
      return this.provisionalEstimate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setDetailId(final Long detailId) {
      this.detailId = detailId;
   }

   public void setArtifactClassificationName(final String artifactClassificationName) {
      this.artifactClassificationName = artifactClassificationName;
   }

   public void setSpecificationTypeNameList(final List<String> SpecificationTypeNameList) {
      this.SpecificationTypeNameList = SpecificationTypeNameList;
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

   public void setTotalQuantity(final BigDecimal totalQuantity) {
      this.totalQuantity = totalQuantity;
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

      if (!(o instanceof ProjectWageEstimateAssemblingWeldingDTO)) {
         return false;
      }

      ProjectWageEstimateAssemblingWeldingDTO other = (ProjectWageEstimateAssemblingWeldingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$detailId = this.getDetailId();
         Object other$detailId = other.getDetailId();
         if (this$detailId == null ? other$detailId == null : this$detailId.equals(other$detailId)) {
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
                     if (this$comparisonOperatorTwo == null
                        ? other$comparisonOperatorTwo == null
                        : this$comparisonOperatorTwo.equals(other$comparisonOperatorTwo)) {
                        Object this$numberTwo = this.getNumberTwo();
                        Object other$numberTwo = other.getNumberTwo();
                        if (this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo)) {
                           Object this$artifactClassificationName = this.getArtifactClassificationName();
                           Object other$artifactClassificationName = other.getArtifactClassificationName();
                           if (this$artifactClassificationName == null
                              ? other$artifactClassificationName == null
                              : this$artifactClassificationName.equals(other$artifactClassificationName)) {
                              Object this$SpecificationTypeNameList = this.getSpecificationTypeNameList();
                              Object other$SpecificationTypeNameList = other.getSpecificationTypeNameList();
                              if (this$SpecificationTypeNameList == null
                                 ? other$SpecificationTypeNameList == null
                                 : this$SpecificationTypeNameList.equals(other$SpecificationTypeNameList)) {
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
                                             Object this$totalQuantity = this.getTotalQuantity();
                                             Object other$totalQuantity = other.getTotalQuantity();
                                             if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
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
      return other instanceof ProjectWageEstimateAssemblingWeldingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $detailId = this.getDetailId();
      result = result * 59 + ($detailId == null ? 43 : $detailId.hashCode());
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
      Object $artifactClassificationName = this.getArtifactClassificationName();
      result = result * 59 + ($artifactClassificationName == null ? 43 : $artifactClassificationName.hashCode());
      Object $SpecificationTypeNameList = this.getSpecificationTypeNameList();
      result = result * 59 + ($SpecificationTypeNameList == null ? 43 : $SpecificationTypeNameList.hashCode());
      Object $processIdList = this.getProcessIdList();
      result = result * 59 + ($processIdList == null ? 43 : $processIdList.hashCode());
      Object $processNameList = this.getProcessNameList();
      result = result * 59 + ($processNameList == null ? 43 : $processNameList.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $inventoryQuantity = this.getInventoryQuantity();
      result = result * 59 + ($inventoryQuantity == null ? 43 : $inventoryQuantity.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $provisionalEstimate = this.getProvisionalEstimate();
      return result * 59 + ($provisionalEstimate == null ? 43 : $provisionalEstimate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWageEstimateAssemblingWeldingDTO(id="
         + this.getId()
         + ", detailId="
         + this.getDetailId()
         + ", artifactClassificationName="
         + this.getArtifactClassificationName()
         + ", SpecificationTypeNameList="
         + this.getSpecificationTypeNameList()
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
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", price="
         + this.getPrice()
         + ", provisionalEstimate="
         + this.getProvisionalEstimate()
         + ")";
   }

   public ProjectWageEstimateAssemblingWeldingDTO() {
   }

   public ProjectWageEstimateAssemblingWeldingDTO(
      final Long id,
      final Long detailId,
      final String artifactClassificationName,
      final List<String> SpecificationTypeNameList,
      final List<Long> processIdList,
      final List<String> processNameList,
      final Integer pricingManner,
      final Integer comparisonOperatorOne,
      final Integer numberOne,
      final Integer comparisonOperatorTwo,
      final Integer numberTwo,
      final String unit,
      final BigDecimal inventoryQuantity,
      final BigDecimal totalQuantity,
      final BigDecimal price,
      final BigDecimal provisionalEstimate
   ) {
      this.id = id;
      this.detailId = detailId;
      this.artifactClassificationName = artifactClassificationName;
      this.SpecificationTypeNameList = SpecificationTypeNameList;
      this.processIdList = processIdList;
      this.processNameList = processNameList;
      this.pricingManner = pricingManner;
      this.comparisonOperatorOne = comparisonOperatorOne;
      this.numberOne = numberOne;
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      this.numberTwo = numberTwo;
      this.unit = unit;
      this.inventoryQuantity = inventoryQuantity;
      this.totalQuantity = totalQuantity;
      this.price = price;
      this.provisionalEstimate = provisionalEstimate;
   }

   public static class ProjectWageEstimateAssemblingWeldingDTOBuilder {
      private Long id;
      private Long detailId;
      private String artifactClassificationName;
      private List<String> SpecificationTypeNameList;
      private List<Long> processIdList;
      private List<String> processNameList;
      private Integer pricingManner;
      private Integer comparisonOperatorOne;
      private Integer numberOne;
      private Integer comparisonOperatorTwo;
      private Integer numberTwo;
      private String unit;
      private BigDecimal inventoryQuantity;
      private BigDecimal totalQuantity;
      private BigDecimal price;
      private BigDecimal provisionalEstimate;

      ProjectWageEstimateAssemblingWeldingDTOBuilder() {
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder detailId(final Long detailId) {
         this.detailId = detailId;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder artifactClassificationName(
         final String artifactClassificationName
      ) {
         this.artifactClassificationName = artifactClassificationName;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder SpecificationTypeNameList(
         final List<String> SpecificationTypeNameList
      ) {
         this.SpecificationTypeNameList = SpecificationTypeNameList;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder processIdList(final List<Long> processIdList) {
         this.processIdList = processIdList;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder processNameList(final List<String> processNameList) {
         this.processNameList = processNameList;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder comparisonOperatorOne(final Integer comparisonOperatorOne) {
         this.comparisonOperatorOne = comparisonOperatorOne;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder numberOne(final Integer numberOne) {
         this.numberOne = numberOne;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder comparisonOperatorTwo(final Integer comparisonOperatorTwo) {
         this.comparisonOperatorTwo = comparisonOperatorTwo;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder numberTwo(final Integer numberTwo) {
         this.numberTwo = numberTwo;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder inventoryQuantity(final BigDecimal inventoryQuantity) {
         this.inventoryQuantity = inventoryQuantity;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder totalQuantity(final BigDecimal totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder provisionalEstimate(final BigDecimal provisionalEstimate) {
         this.provisionalEstimate = provisionalEstimate;
         return this;
      }

      public ProjectWageEstimateAssemblingWeldingDTO build() {
         return new ProjectWageEstimateAssemblingWeldingDTO(
            this.id,
            this.detailId,
            this.artifactClassificationName,
            this.SpecificationTypeNameList,
            this.processIdList,
            this.processNameList,
            this.pricingManner,
            this.comparisonOperatorOne,
            this.numberOne,
            this.comparisonOperatorTwo,
            this.numberTwo,
            this.unit,
            this.inventoryQuantity,
            this.totalQuantity,
            this.price,
            this.provisionalEstimate
         );
      }

      @Override
      public String toString() {
         return "ProjectWageEstimateAssemblingWeldingDTO.ProjectWageEstimateAssemblingWeldingDTOBuilder(id="
            + this.id
            + ", detailId="
            + this.detailId
            + ", artifactClassificationName="
            + this.artifactClassificationName
            + ", SpecificationTypeNameList="
            + this.SpecificationTypeNameList
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
            + ", totalQuantity="
            + this.totalQuantity
            + ", price="
            + this.price
            + ", provisionalEstimate="
            + this.provisionalEstimate
            + ")";
      }
   }
}
