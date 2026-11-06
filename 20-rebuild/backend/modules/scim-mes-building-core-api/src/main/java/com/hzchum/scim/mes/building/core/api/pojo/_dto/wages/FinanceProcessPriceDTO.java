package com.hzchum.scim.mes.building.core.api.pojo._dto.wages;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "FinanceProcessPriceDTO", description = "业财工序工资")
public class FinanceProcessPriceDTO {
   @ApiModelProperty(name = "projectId", notes = "项目id", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "id", notes = "工序id", value = "工序id")
   private Long id;
   @ApiModelProperty(name = "process", notes = "工序名称", value = "工序名称")
   private String name;
   @ApiModelProperty(name = "sort", notes = "工序排序", value = "工序排序")
   private Integer sort;
   @ApiModelProperty(name = "mete", notes = "工序产量", value = "工序产量")
   private BigDecimal mete;
   @ApiModelProperty(name = "price", notes = "工序价格", value = "工序价格")
   private BigDecimal price;

   public static FinanceProcessPriceDTO.FinanceProcessPriceDTOBuilder builder() {
      return new FinanceProcessPriceDTO.FinanceProcessPriceDTOBuilder();
   }

   public FinanceProcessPriceDTO(final Long projectId, final Long id, final String name, final Integer sort, final BigDecimal mete, final BigDecimal price) {
      this.projectId = projectId;
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.mete = mete;
      this.price = price;
   }

   public FinanceProcessPriceDTO() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FinanceProcessPriceDTO)) {
         return false;
      }

      FinanceProcessPriceDTO other = (FinanceProcessPriceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof FinanceProcessPriceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "FinanceProcessPriceDTO(projectId="
         + this.getProjectId()
         + ", id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", mete="
         + this.getMete()
         + ", price="
         + this.getPrice()
         + ")";
   }

   public static class FinanceProcessPriceDTOBuilder {
      private Long projectId;
      private Long id;
      private String name;
      private Integer sort;
      private BigDecimal mete;
      private BigDecimal price;

      FinanceProcessPriceDTOBuilder() {
      }

      public FinanceProcessPriceDTO.FinanceProcessPriceDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public FinanceProcessPriceDTO.FinanceProcessPriceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public FinanceProcessPriceDTO.FinanceProcessPriceDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public FinanceProcessPriceDTO.FinanceProcessPriceDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public FinanceProcessPriceDTO.FinanceProcessPriceDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public FinanceProcessPriceDTO.FinanceProcessPriceDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public FinanceProcessPriceDTO build() {
         return new FinanceProcessPriceDTO(this.projectId, this.id, this.name, this.sort, this.mete, this.price);
      }

      @Override
      public String toString() {
         return "FinanceProcessPriceDTO.FinanceProcessPriceDTOBuilder(projectId="
            + this.projectId
            + ", id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", mete="
            + this.mete
            + ", price="
            + this.price
            + ")";
      }
   }
}
