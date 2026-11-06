package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("成本汇总")
public class CostSummaryDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("排序编号")
   private Integer indexNumber;
   @ApiModelProperty("成本汇总名称")
   private String name;
   @ApiModelProperty("成本汇总序号")
   private String indexName;
   @ApiModelProperty("成本汇总值")
   private List<CostSummaryValueDTO> costSummaryValueDTO;
   @ApiModelProperty("合计")
   private BigDecimal total;
   @ApiModelProperty("分项展示")
   private BigDecimal subItemDisplay;
   @ApiModelProperty("成本占比")
   private BigDecimal costProportion;

   public static CostSummaryDTO.CostSummaryDTOBuilder builder() {
      return new CostSummaryDTO.CostSummaryDTOBuilder();
   }

   public Integer getIndexNumber() {
      return this.indexNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getIndexName() {
      return this.indexName;
   }

   public List<CostSummaryValueDTO> getCostSummaryValueDTO() {
      return this.costSummaryValueDTO;
   }

   public BigDecimal getTotal() {
      return this.total;
   }

   public BigDecimal getSubItemDisplay() {
      return this.subItemDisplay;
   }

   public BigDecimal getCostProportion() {
      return this.costProportion;
   }

   public void setIndexNumber(final Integer indexNumber) {
      this.indexNumber = indexNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setIndexName(final String indexName) {
      this.indexName = indexName;
   }

   public void setCostSummaryValueDTO(final List<CostSummaryValueDTO> costSummaryValueDTO) {
      this.costSummaryValueDTO = costSummaryValueDTO;
   }

   public void setTotal(final BigDecimal total) {
      this.total = total;
   }

   public void setSubItemDisplay(final BigDecimal subItemDisplay) {
      this.subItemDisplay = subItemDisplay;
   }

   public void setCostProportion(final BigDecimal costProportion) {
      this.costProportion = costProportion;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CostSummaryDTO)) {
         return false;
      }

      CostSummaryDTO other = (CostSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$indexNumber = this.getIndexNumber();
      Object other$indexNumber = other.getIndexNumber();
      if (this$indexNumber == null ? other$indexNumber == null : this$indexNumber.equals(other$indexNumber)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$indexName = this.getIndexName();
            Object other$indexName = other.getIndexName();
            if (this$indexName == null ? other$indexName == null : this$indexName.equals(other$indexName)) {
               Object this$costSummaryValueDTO = this.getCostSummaryValueDTO();
               Object other$costSummaryValueDTO = other.getCostSummaryValueDTO();
               if (this$costSummaryValueDTO == null ? other$costSummaryValueDTO == null : this$costSummaryValueDTO.equals(other$costSummaryValueDTO)) {
                  Object this$total = this.getTotal();
                  Object other$total = other.getTotal();
                  if (this$total == null ? other$total == null : this$total.equals(other$total)) {
                     Object this$subItemDisplay = this.getSubItemDisplay();
                     Object other$subItemDisplay = other.getSubItemDisplay();
                     if (this$subItemDisplay == null ? other$subItemDisplay == null : this$subItemDisplay.equals(other$subItemDisplay)) {
                        Object this$costProportion = this.getCostProportion();
                        Object other$costProportion = other.getCostProportion();
                        return this$costProportion == null ? other$costProportion == null : this$costProportion.equals(other$costProportion);
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
      return other instanceof CostSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $indexNumber = this.getIndexNumber();
      result = result * 59 + ($indexNumber == null ? 43 : $indexNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $indexName = this.getIndexName();
      result = result * 59 + ($indexName == null ? 43 : $indexName.hashCode());
      Object $costSummaryValueDTO = this.getCostSummaryValueDTO();
      result = result * 59 + ($costSummaryValueDTO == null ? 43 : $costSummaryValueDTO.hashCode());
      Object $total = this.getTotal();
      result = result * 59 + ($total == null ? 43 : $total.hashCode());
      Object $subItemDisplay = this.getSubItemDisplay();
      result = result * 59 + ($subItemDisplay == null ? 43 : $subItemDisplay.hashCode());
      Object $costProportion = this.getCostProportion();
      return result * 59 + ($costProportion == null ? 43 : $costProportion.hashCode());
   }

   @Override
   public String toString() {
      return "CostSummaryDTO(indexNumber="
         + this.getIndexNumber()
         + ", name="
         + this.getName()
         + ", indexName="
         + this.getIndexName()
         + ", costSummaryValueDTO="
         + this.getCostSummaryValueDTO()
         + ", total="
         + this.getTotal()
         + ", subItemDisplay="
         + this.getSubItemDisplay()
         + ", costProportion="
         + this.getCostProportion()
         + ")";
   }

   public CostSummaryDTO() {
   }

   public CostSummaryDTO(
      final Integer indexNumber,
      final String name,
      final String indexName,
      final List<CostSummaryValueDTO> costSummaryValueDTO,
      final BigDecimal total,
      final BigDecimal subItemDisplay,
      final BigDecimal costProportion
   ) {
      this.indexNumber = indexNumber;
      this.name = name;
      this.indexName = indexName;
      this.costSummaryValueDTO = costSummaryValueDTO;
      this.total = total;
      this.subItemDisplay = subItemDisplay;
      this.costProportion = costProportion;
   }

   public static class CostSummaryDTOBuilder {
      private Integer indexNumber;
      private String name;
      private String indexName;
      private List<CostSummaryValueDTO> costSummaryValueDTO;
      private BigDecimal total;
      private BigDecimal subItemDisplay;
      private BigDecimal costProportion;

      CostSummaryDTOBuilder() {
      }

      public CostSummaryDTO.CostSummaryDTOBuilder indexNumber(final Integer indexNumber) {
         this.indexNumber = indexNumber;
         return this;
      }

      public CostSummaryDTO.CostSummaryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CostSummaryDTO.CostSummaryDTOBuilder indexName(final String indexName) {
         this.indexName = indexName;
         return this;
      }

      public CostSummaryDTO.CostSummaryDTOBuilder costSummaryValueDTO(final List<CostSummaryValueDTO> costSummaryValueDTO) {
         this.costSummaryValueDTO = costSummaryValueDTO;
         return this;
      }

      public CostSummaryDTO.CostSummaryDTOBuilder total(final BigDecimal total) {
         this.total = total;
         return this;
      }

      public CostSummaryDTO.CostSummaryDTOBuilder subItemDisplay(final BigDecimal subItemDisplay) {
         this.subItemDisplay = subItemDisplay;
         return this;
      }

      public CostSummaryDTO.CostSummaryDTOBuilder costProportion(final BigDecimal costProportion) {
         this.costProportion = costProportion;
         return this;
      }

      public CostSummaryDTO build() {
         return new CostSummaryDTO(this.indexNumber, this.name, this.indexName, this.costSummaryValueDTO, this.total, this.subItemDisplay, this.costProportion);
      }

      @Override
      public String toString() {
         return "CostSummaryDTO.CostSummaryDTOBuilder(indexNumber="
            + this.indexNumber
            + ", name="
            + this.name
            + ", indexName="
            + this.indexName
            + ", costSummaryValueDTO="
            + this.costSummaryValueDTO
            + ", total="
            + this.total
            + ", subItemDisplay="
            + this.subItemDisplay
            + ", costProportion="
            + this.costProportion
            + ")";
      }
   }
}
