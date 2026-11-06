package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("成本汇总名称和序号")
public class CostSummaryNameDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("排序编号")
   private Integer indexNumber;
   @ApiModelProperty("成本汇总名称")
   private String name;
   @ApiModelProperty("成本汇总序号")
   private String indexName;

   public Integer getIndexNumber() {
      return this.indexNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getIndexName() {
      return this.indexName;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CostSummaryNameDTO)) {
         return false;
      }

      CostSummaryNameDTO other = (CostSummaryNameDTO)o;
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
            return this$indexName == null ? other$indexName == null : this$indexName.equals(other$indexName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CostSummaryNameDTO;
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
      return result * 59 + ($indexName == null ? 43 : $indexName.hashCode());
   }

   @Override
   public String toString() {
      return "CostSummaryNameDTO(indexNumber=" + this.getIndexNumber() + ", name=" + this.getName() + ", indexName=" + this.getIndexName() + ")";
   }

   public CostSummaryNameDTO() {
   }

   public CostSummaryNameDTO(final Integer indexNumber, final String name, final String indexName) {
      this.indexNumber = indexNumber;
      this.name = name;
      this.indexName = indexName;
   }
}
