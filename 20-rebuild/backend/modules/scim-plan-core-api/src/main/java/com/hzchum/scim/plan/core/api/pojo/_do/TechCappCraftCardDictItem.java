package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechCappCraftCardDictItem对象", description = "CAPP 工艺卡字典项表")
@Entity
@TableName("tech_capp_craft_card_dict_item")
@Table(name = "tech_capp_craft_card_dict_item")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_card_dict_item", comment = "CAPP 工艺卡字典项表")
public class TechCappCraftCardDictItem extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "CAPP 工艺卡字典项 id", notes = "CAPP 工艺卡字典项 id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "dictType", value = "字典类型", notes = "字典类型")
   @TableField("dict_type")
   @Column(name = "dict_type", columnDefinition = "varchar(256)  COMMENT '字典类型'", nullable = false)
   private String dictType;
   @ApiModelProperty(name = "dictValue", value = "字典值", notes = "字典值")
   @TableField("dict_value")
   @Column(name = "dict_value", columnDefinition = "varchar(256)  COMMENT '字典值'", nullable = false)
   private String dictValue;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11)  COMMENT '排序'", nullable = true)
   private Integer sort;
   @ApiModelProperty(name = "enabledFlag", value = "是否启用：0 未启用；1 启用", notes = "是否启用：0 未启用；1 启用")
   @TableField("enabled_flag")
   @Column(name = "enabled_flag", columnDefinition = "bit(1) default 1 COMMENT '是否启用：0 未启用；1 启用'", nullable = false)
   private Boolean enabledFlag;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(64)  COMMENT '创建人姓名'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "createUserId", value = "创建人 id", notes = "创建人 id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人 id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "updateUserName", value = "更新人姓名", notes = "更新人姓名")
   @TableField("update_user_name")
   @Column(name = "update_user_name", columnDefinition = "varchar(64)  COMMENT '更新人姓名'", nullable = true)
   private String updateUserName;
   @ApiModelProperty(name = "updateUserId", value = "更新人 id", notes = "更新人 id")
   @TableField("update_user_id")
   @Column(name = "update_user_id", columnDefinition = "bigint(20)  COMMENT '更新人 id'", nullable = true)
   private Long updateUserId;

   public static TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder builder() {
      return new TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder();
   }

   public TechCappCraftCardDictItem() {
   }

   public TechCappCraftCardDictItem(
      final Long id,
      final String dictType,
      final String dictValue,
      final Integer sort,
      final Boolean enabledFlag,
      final String createUserName,
      final Long createUserId,
      final String updateUserName,
      final Long updateUserId
   ) {
      this.id = id;
      this.dictType = dictType;
      this.dictValue = dictValue;
      this.sort = sort;
      this.enabledFlag = enabledFlag;
      this.createUserName = createUserName;
      this.createUserId = createUserId;
      this.updateUserName = updateUserName;
      this.updateUserId = updateUserId;
   }

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

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getUpdateUserName() {
      return this.updateUserName;
   }

   public Long getUpdateUserId() {
      return this.updateUserId;
   }

   public TechCappCraftCardDictItem setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftCardDictItem setDictType(final String dictType) {
      this.dictType = dictType;
      return this;
   }

   public TechCappCraftCardDictItem setDictValue(final String dictValue) {
      this.dictValue = dictValue;
      return this;
   }

   public TechCappCraftCardDictItem setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public TechCappCraftCardDictItem setEnabledFlag(final Boolean enabledFlag) {
      this.enabledFlag = enabledFlag;
      return this;
   }

   public TechCappCraftCardDictItem setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public TechCappCraftCardDictItem setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public TechCappCraftCardDictItem setUpdateUserName(final String updateUserName) {
      this.updateUserName = updateUserName;
      return this;
   }

   public TechCappCraftCardDictItem setUpdateUserId(final Long updateUserId) {
      this.updateUserId = updateUserId;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftCardDictItem(id="
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
         + ", createUserId="
         + this.getCreateUserId()
         + ", updateUserName="
         + this.getUpdateUserName()
         + ", updateUserId="
         + this.getUpdateUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftCardDictItem)) {
         return false;
      }

      TechCappCraftCardDictItem other = (TechCappCraftCardDictItem)o;
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
            Object this$enabledFlag = this.getEnabledFlag();
            Object other$enabledFlag = other.getEnabledFlag();
            if (this$enabledFlag == null ? other$enabledFlag == null : this$enabledFlag.equals(other$enabledFlag)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$updateUserId = this.getUpdateUserId();
                  Object other$updateUserId = other.getUpdateUserId();
                  if (this$updateUserId == null ? other$updateUserId == null : this$updateUserId.equals(other$updateUserId)) {
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
                              return this$updateUserName == null ? other$updateUserName == null : this$updateUserName.equals(other$updateUserName);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechCappCraftCardDictItem;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enabledFlag = this.getEnabledFlag();
      result = result * 59 + ($enabledFlag == null ? 43 : $enabledFlag.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $updateUserId = this.getUpdateUserId();
      result = result * 59 + ($updateUserId == null ? 43 : $updateUserId.hashCode());
      Object $dictType = this.getDictType();
      result = result * 59 + ($dictType == null ? 43 : $dictType.hashCode());
      Object $dictValue = this.getDictValue();
      result = result * 59 + ($dictValue == null ? 43 : $dictValue.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $updateUserName = this.getUpdateUserName();
      return result * 59 + ($updateUserName == null ? 43 : $updateUserName.hashCode());
   }

   public static class TechCappCraftCardDictItemBuilder {
      private Long id;
      private String dictType;
      private String dictValue;
      private Integer sort;
      private Boolean enabledFlag;
      private String createUserName;
      private Long createUserId;
      private String updateUserName;
      private Long updateUserId;

      TechCappCraftCardDictItemBuilder() {
      }

      public TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder dictType(final String dictType) {
         this.dictType = dictType;
         return this;
      }

      public TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder dictValue(final String dictValue) {
         this.dictValue = dictValue;
         return this;
      }

      public TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder enabledFlag(final Boolean enabledFlag) {
         this.enabledFlag = enabledFlag;
         return this;
      }

      public TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder updateUserName(final String updateUserName) {
         this.updateUserName = updateUserName;
         return this;
      }

      public TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder updateUserId(final Long updateUserId) {
         this.updateUserId = updateUserId;
         return this;
      }

      public TechCappCraftCardDictItem build() {
         return new TechCappCraftCardDictItem(
            this.id, this.dictType, this.dictValue, this.sort, this.enabledFlag, this.createUserName, this.createUserId, this.updateUserName, this.updateUserId
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftCardDictItem.TechCappCraftCardDictItemBuilder(id="
            + this.id
            + ", dictType="
            + this.dictType
            + ", dictValue="
            + this.dictValue
            + ", sort="
            + this.sort
            + ", enabledFlag="
            + this.enabledFlag
            + ", createUserName="
            + this.createUserName
            + ", createUserId="
            + this.createUserId
            + ", updateUserName="
            + this.updateUserName
            + ", updateUserId="
            + this.updateUserId
            + ")";
      }
   }
}
