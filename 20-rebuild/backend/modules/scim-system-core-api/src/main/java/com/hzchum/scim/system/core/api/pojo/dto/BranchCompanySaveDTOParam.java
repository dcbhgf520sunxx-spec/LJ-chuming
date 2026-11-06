package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.BranchAttributeEnum;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

@ApiModel("分支机构保存请求类")
public class BranchCompanySaveDTOParam {
   @NotNull(message = "子公司名称不能为空")
   @ApiModelProperty("子分公司名称")
   private String name;
   @NotNull(message = "子分公司简称不能为空")
   @ApiModelProperty("子分公司简称")
   private String shortName;
   @NotNull(message = "是否母公司不能为空")
   @Range(min = 0L, max = 1L, message = "类型错误")
   @ApiModelProperty("是否母公司 1是 0否")
   private Integer isParent;
   @ApiModelProperty("社会统一信用代码")
   private String socialCode;
   @Range(min = 0L, max = 1L, message = "启用状态类型错误")
   @ApiModelProperty("启用状态 1 启用 0禁用")
   private Integer enabled;
   @NotNull(message = "排序不能为空")
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("备注")
   private String remark;
   @NotEmpty(message = "开户信息列表不能为空")
   @ApiModelProperty("开户信息列表")
   private List<BankAccountSaveDTOParam> bankAccounts;
   @ApiModelProperty(name = "level", value = "单位层级(1: 一级单位, 2: 二级单位)")
   @EnumValidator(value = BranchCompanyLevelEnum.class, message = "单位层级不存在")
   private Integer level;
   @NotNull(message = "分支机构属性不能为空!")
   @EnumValidator(value = BranchAttributeEnum.class, message = "分支机构属性有误!")
   @ApiModelProperty(name = "branchAttributeEnum", value = "分支机构-属性 1安装 2加工 4其他")
   private Integer branchAttributeEnum;

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getIsParent() {
      return this.isParent;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public Integer getEnabled() {
      return this.enabled;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<BankAccountSaveDTOParam> getBankAccounts() {
      return this.bankAccounts;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getBranchAttributeEnum() {
      return this.branchAttributeEnum;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setIsParent(final Integer isParent) {
      this.isParent = isParent;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setEnabled(final Integer enabled) {
      this.enabled = enabled;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBankAccounts(final List<BankAccountSaveDTOParam> bankAccounts) {
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

      if (!(o instanceof BranchCompanySaveDTOParam)) {
         return false;
      }

      BranchCompanySaveDTOParam other = (BranchCompanySaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isParent = this.getIsParent();
      Object other$isParent = other.getIsParent();
      if (this$isParent == null ? other$isParent == null : this$isParent.equals(other$isParent)) {
         Object this$enabled = this.getEnabled();
         Object other$enabled = other.getEnabled();
         if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
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
                           Object this$socialCode = this.getSocialCode();
                           Object other$socialCode = other.getSocialCode();
                           if (this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BranchCompanySaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isParent = this.getIsParent();
      result = result * 59 + ($isParent == null ? 43 : $isParent.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
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
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $bankAccounts = this.getBankAccounts();
      return result * 59 + ($bankAccounts == null ? 43 : $bankAccounts.hashCode());
   }

   @Override
   public String toString() {
      return "BranchCompanySaveDTOParam(name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", isParent="
         + this.getIsParent()
         + ", socialCode="
         + this.getSocialCode()
         + ", enabled="
         + this.getEnabled()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", bankAccounts="
         + this.getBankAccounts()
         + ", level="
         + this.getLevel()
         + ", branchAttributeEnum="
         + this.getBranchAttributeEnum()
         + ")";
   }
}
