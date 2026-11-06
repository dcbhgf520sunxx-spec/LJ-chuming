package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(description = "CAPP 工艺卡字典项 响应参数")
public class CappCraftCardDictItemVO {
   @ApiModelProperty(name = "id", value = "CAPP 工艺卡字典项 id", notes = "CAPP 工艺卡字典项 id")
   private Long id;
   @ApiModelProperty(name = "dictType", value = "字典类型", notes = "字典类型")
   private String dictType;
   @ApiModelProperty(name = "dictValue", value = "字典值", notes = "字典值")
   private String dictValue;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;
   @ApiModelProperty(name = "enabledFlag", value = "是否启用：0 未启用；1 启用", notes = "是否启用：0 未启用；1 启用")
   private Boolean enabledFlag;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   private String createUserName;
   @ApiModelProperty(name = "updateUserName", value = "更新人姓名", notes = "更新人姓名")
   private String updateUserName;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "updateTime", value = "更新时间", notes = "更新时间")
   private LocalDateTime updateTime;

   public Long getId() {
      return this.id;
   }

   public String getDictType() {
      return this.dictType;
   }

   public String getDictValue() {
      return this.dictValue;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getEnabledFlag() {
      return this.enabledFlag;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getUpdateUserName() {
      return this.updateUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setDictType(final String dictType) {
      this.dictType = dictType;
   }

   public void setDictValue(final String dictValue) {
      this.dictValue = dictValue;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setEnabledFlag(final Boolean enabledFlag) {
      this.enabledFlag = enabledFlag;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setUpdateUserName(final String updateUserName) {
      this.updateUserName = updateUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardDictItemVO)) {
         return false;
      }

      CappCraftCardDictItemVO other = (CappCraftCardDictItemVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$enabledFlag = this.getEnabledFlag();
            Object other$enabledFlag = other.getEnabledFlag();
            if (this$enabledFlag == null ? other$enabledFlag == null : this$enabledFlag.equals(other$enabledFlag)) {
               Object this$dictType = this.getDictType();
               Object other$dictType = other.getDictType();
               if (this$dictType == null ? other$dictType == null : this$dictType.equals(other$dictType)) {
                  Object this$dictValue = this.getDictValue();
                  Object other$dictValue = other.getDictValue();
                  if (this$dictValue == null ? other$dictValue == null : this$dictValue.equals(other$dictValue)) {
                     Object this$createUserName = this.getCreateUserName();
                     Object other$createUserName = other.getCreateUserName();
                     if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                        Object this$updateUserName = this.getUpdateUserName();
                        Object other$updateUserName = other.getUpdateUserName();
                        if (this$updateUserName == null ? other$updateUserName == null : this$updateUserName.equals(other$updateUserName)) {
                           Object this$createTime = this.getCreateTime();
                           Object other$createTime = other.getCreateTime();
                           if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                              Object this$updateTime = this.getUpdateTime();
                              Object other$updateTime = other.getUpdateTime();
                              return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof CappCraftCardDictItemVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enabledFlag = this.getEnabledFlag();
      result = result * 59 + ($enabledFlag == null ? 43 : $enabledFlag.hashCode());
      Object $dictType = this.getDictType();
      result = result * 59 + ($dictType == null ? 43 : $dictType.hashCode());
      Object $dictValue = this.getDictValue();
      result = result * 59 + ($dictValue == null ? 43 : $dictValue.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $updateUserName = this.getUpdateUserName();
      result = result * 59 + ($updateUserName == null ? 43 : $updateUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardDictItemVO(id="
         + this.getId()
         + ", dictType="
         + this.getDictType()
         + ", dictValue="
         + this.getDictValue()
         + ", sort="
         + this.getSort()
         + ", enabledFlag="
         + this.getEnabledFlag()
         + ", createUserName="
         + this.getCreateUserName()
         + ", updateUserName="
         + this.getUpdateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }
}
