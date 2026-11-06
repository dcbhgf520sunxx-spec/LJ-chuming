package com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("损耗及在制品汇总")
public class WastageLossCostSummaryDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("排序编号")
   private Integer indexNumber;
   @ApiModelProperty("损耗及在制品汇总名称")
   private String name;
   @ApiModelProperty("损耗及在制品汇总序号")
   private String indexName;
   @ApiModelProperty("损耗及在制品汇总值")
   private List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTO;
   @ApiModelProperty("合计")
   private BigDecimal total;

   public static WastageLossCostSummaryDTO.WastageLossCostSummaryDTOBuilder builder() {
      return new WastageLossCostSummaryDTO.WastageLossCostSummaryDTOBuilder();
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

   public List<WastageCostSummaryValueDTO> getWastageCostSummaryValueDTO() {
      return this.wastageCostSummaryValueDTO;
   }

   public BigDecimal getTotal() {
      return this.total;
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

   public void setWastageCostSummaryValueDTO(final List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTO) {
      this.wastageCostSummaryValueDTO = wastageCostSummaryValueDTO;
   }

   public void setTotal(final BigDecimal total) {
      this.total = total;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WastageLossCostSummaryDTO)) {
         return false;
      }

      WastageLossCostSummaryDTO other = (WastageLossCostSummaryDTO)o;
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
               Object this$wastageCostSummaryValueDTO = this.getWastageCostSummaryValueDTO();
               Object other$wastageCostSummaryValueDTO = other.getWastageCostSummaryValueDTO();
               if (this$wastageCostSummaryValueDTO == null
                  ? other$wastageCostSummaryValueDTO == null
                  : this$wastageCostSummaryValueDTO.equals(other$wastageCostSummaryValueDTO)) {
                  Object this$total = this.getTotal();
                  Object other$total = other.getTotal();
                  return this$total == null ? other$total == null : this$total.equals(other$total);
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
      return other instanceof WastageLossCostSummaryDTO;
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
      Object $wastageCostSummaryValueDTO = this.getWastageCostSummaryValueDTO();
      result = result * 59 + ($wastageCostSummaryValueDTO == null ? 43 : $wastageCostSummaryValueDTO.hashCode());
      Object $total = this.getTotal();
      return result * 59 + ($total == null ? 43 : $total.hashCode());
   }

   @Override
   public String toString() {
      return "WastageLossCostSummaryDTO(indexNumber="
         + this.getIndexNumber()
         + ", name="
         + this.getName()
         + ", indexName="
         + this.getIndexName()
         + ", wastageCostSummaryValueDTO="
         + this.getWastageCostSummaryValueDTO()
         + ", total="
         + this.getTotal()
         + ")";
   }

   public WastageLossCostSummaryDTO() {
   }

   public WastageLossCostSummaryDTO(
      final Integer indexNumber,
      final String name,
      final String indexName,
      final List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTO,
      final BigDecimal total
   ) {
      this.indexNumber = indexNumber;
      this.name = name;
      this.indexName = indexName;
      this.wastageCostSummaryValueDTO = wastageCostSummaryValueDTO;
      this.total = total;
   }

   public static class WastageLossCostSummaryDTOBuilder {
      private Integer indexNumber;
      private String name;
      private String indexName;
      private List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTO;
      private BigDecimal total;

      WastageLossCostSummaryDTOBuilder() {
      }

      public WastageLossCostSummaryDTO.WastageLossCostSummaryDTOBuilder indexNumber(final Integer indexNumber) {
         this.indexNumber = indexNumber;
         return this;
      }

      public WastageLossCostSummaryDTO.WastageLossCostSummaryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WastageLossCostSummaryDTO.WastageLossCostSummaryDTOBuilder indexName(final String indexName) {
         this.indexName = indexName;
         return this;
      }

      public WastageLossCostSummaryDTO.WastageLossCostSummaryDTOBuilder wastageCostSummaryValueDTO(
         final List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTO
      ) {
         this.wastageCostSummaryValueDTO = wastageCostSummaryValueDTO;
         return this;
      }

      public WastageLossCostSummaryDTO.WastageLossCostSummaryDTOBuilder total(final BigDecimal total) {
         this.total = total;
         return this;
      }

      public WastageLossCostSummaryDTO build() {
         return new WastageLossCostSummaryDTO(this.indexNumber, this.name, this.indexName, this.wastageCostSummaryValueDTO, this.total);
      }

      @Override
      public String toString() {
         return "WastageLossCostSummaryDTO.WastageLossCostSummaryDTOBuilder(indexNumber="
            + this.indexNumber
            + ", name="
            + this.name
            + ", indexName="
            + this.indexName
            + ", wastageCostSummaryValueDTO="
            + this.wastageCostSummaryValueDTO
            + ", total="
            + this.total
            + ")";
      }
   }
}
