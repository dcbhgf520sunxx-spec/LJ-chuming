package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractExpenseType对象", description = "费用分类表")
@Entity
@TableName("contract_expense_type")
@Table(name = "contract_expense_type")
public class ContractExpenseType extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "分类名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '分类名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "sort", value = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) comment '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "category", value = "类别")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11) default 1 comment '类别'", nullable = true)
   private Integer category;

   public static ContractExpenseType.ContractExpenseTypeBuilder builder() {
      return new ContractExpenseType.ContractExpenseTypeBuilder();
   }

   public ContractExpenseType() {
   }

   public ContractExpenseType(final Long id, final String name, final Integer sort, final Integer category) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.category = category;
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

   public Integer getCategory() {
      return this.category;
   }

   public ContractExpenseType setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractExpenseType setName(final String name) {
      this.name = name;
      return this;
   }

   public ContractExpenseType setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public ContractExpenseType setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @Override
   public String toString() {
      return "ContractExpenseType(id=" + this.getId() + ", name=" + this.getName() + ", sort=" + this.getSort() + ", category=" + this.getCategory() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractExpenseType)) {
         return false;
      }

      ContractExpenseType other = (ContractExpenseType)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractExpenseType;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ContractExpenseTypeBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Integer category;

      ContractExpenseTypeBuilder() {
      }

      public ContractExpenseType.ContractExpenseTypeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractExpenseType.ContractExpenseTypeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ContractExpenseType.ContractExpenseTypeBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public ContractExpenseType.ContractExpenseTypeBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ContractExpenseType build() {
         return new ContractExpenseType(this.id, this.name, this.sort, this.category);
      }

      @Override
      public String toString() {
         return "ContractExpenseType.ContractExpenseTypeBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", category="
            + this.category
            + ")";
      }
   }
}
