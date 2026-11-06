package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class BranchCompanySimpleVO {
   private Long id;
   private String name;
   private Integer sort;
   private Integer level;
   @ApiModelProperty(name = "branchAttributeEnum", value = "分支机构-属性 1安装 2加工")
   private Integer branchAttributeEnum;
   private List<BankAccountSimpleDTO> bankAccountList;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getBranchAttributeEnum() {
      return this.branchAttributeEnum;
   }

   public List<BankAccountSimpleDTO> getBankAccountList() {
      return this.bankAccountList;
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

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setBranchAttributeEnum(final Integer branchAttributeEnum) {
      this.branchAttributeEnum = branchAttributeEnum;
   }

   public void setBankAccountList(final List<BankAccountSimpleDTO> bankAccountList) {
      this.bankAccountList = bankAccountList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BranchCompanySimpleVO)) {
         return false;
      }

      BranchCompanySimpleVO other = (BranchCompanySimpleVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$level = this.getLevel();
            Object other$level = other.getLevel();
            if (this$level == null ? other$level == null : this$level.equals(other$level)) {
               Object this$branchAttributeEnum = this.getBranchAttributeEnum();
               Object other$branchAttributeEnum = other.getBranchAttributeEnum();
               if (this$branchAttributeEnum == null ? other$branchAttributeEnum == null : this$branchAttributeEnum.equals(other$branchAttributeEnum)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$bankAccountList = this.getBankAccountList();
                     Object other$bankAccountList = other.getBankAccountList();
                     return this$bankAccountList == null ? other$bankAccountList == null : this$bankAccountList.equals(other$bankAccountList);
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
      return other instanceof BranchCompanySimpleVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $branchAttributeEnum = this.getBranchAttributeEnum();
      result = result * 59 + ($branchAttributeEnum == null ? 43 : $branchAttributeEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $bankAccountList = this.getBankAccountList();
      return result * 59 + ($bankAccountList == null ? 43 : $bankAccountList.hashCode());
   }

   @Override
   public String toString() {
      return "BranchCompanySimpleVO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", level="
         + this.getLevel()
         + ", branchAttributeEnum="
         + this.getBranchAttributeEnum()
         + ", bankAccountList="
         + this.getBankAccountList()
         + ")";
   }
}
