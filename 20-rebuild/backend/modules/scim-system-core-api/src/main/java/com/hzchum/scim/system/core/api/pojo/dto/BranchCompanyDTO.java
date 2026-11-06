package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("分支机构响应类")
public class BranchCompanyDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "enabled")
   private Integer enabled;
   @ApiModelProperty(name = "isParent")
   private Integer isParent;
   @ApiModelProperty(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "remark")
   private String remark;
   @ApiModelProperty(name = "socialCode")
   private String socialCode;
   @ApiModelProperty(name = "sort")
   private Integer sort;
   @ApiModelProperty("开户行信息列表")
   private List<BankAccountVO> bankAccounts;
   @ApiModelProperty("单位层级(1: 一级单位, 2: 二级单位)")
   private Integer level;
   @ApiModelProperty(name = "branchAttributeEnum", value = "分支机构-属性 1安装 2制造")
   private Integer branchAttributeEnum;

   public Long getId() {
      return this.id;
   }

   public Integer getEnabled() {
      return this.enabled;
   }

   public Integer getIsParent() {
      return this.isParent;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<BankAccountVO> getBankAccounts() {
      return this.bankAccounts;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getBranchAttributeEnum() {
      return this.branchAttributeEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setEnabled(final Integer enabled) {
      this.enabled = enabled;
   }

   public void setIsParent(final Integer isParent) {
      this.isParent = isParent;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setBankAccounts(final List<BankAccountVO> bankAccounts) {
      this.bankAccounts = bankAccounts;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setBranchAttributeEnum(final Integer branchAttributeEnum) {
      this.branchAttributeEnum = branchAttributeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BranchCompanyDTO)) {
         return false;
      }

      BranchCompanyDTO other = (BranchCompanyDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$enabled = this.getEnabled();
         Object other$enabled = other.getEnabled();
         if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
            Object this$isParent = this.getIsParent();
            Object other$isParent = other.getIsParent();
            if (this$isParent == null ? other$isParent == null : this$isParent.equals(other$isParent)) {
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
                           Object this$shortName = this.getShortName();
                           Object other$shortName = other.getShortName();
                           if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$socialCode = this.getSocialCode();
                                 Object other$socialCode = other.getSocialCode();
                                 if (this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode)) {
                                    Object this$bankAccounts = this.getBankAccounts();
                                    Object other$bankAccounts = other.getBankAccounts();
                                    return this$bankAccounts == null ? other$bankAccounts == null : this$bankAccounts.equals(other$bankAccounts);
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
      return other instanceof BranchCompanyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $isParent = this.getIsParent();
      result = result * 59 + ($isParent == null ? 43 : $isParent.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $branchAttributeEnum = this.getBranchAttributeEnum();
      result = result * 59 + ($branchAttributeEnum == null ? 43 : $branchAttributeEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $bankAccounts = this.getBankAccounts();
      return result * 59 + ($bankAccounts == null ? 43 : $bankAccounts.hashCode());
   }

   @Override
   public String toString() {
      return "BranchCompanyDTO(id="
         + this.getId()
         + ", enabled="
         + this.getEnabled()
         + ", isParent="
         + this.getIsParent()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", remark="
         + this.getRemark()
         + ", socialCode="
         + this.getSocialCode()
         + ", sort="
         + this.getSort()
         + ", bankAccounts="
         + this.getBankAccounts()
         + ", level="
         + this.getLevel()
         + ", branchAttributeEnum="
         + this.getBranchAttributeEnum()
         + ")";
   }
}
