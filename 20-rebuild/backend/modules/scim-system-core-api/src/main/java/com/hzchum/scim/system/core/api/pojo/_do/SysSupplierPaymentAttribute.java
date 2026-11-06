package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysSupplierPaymentAttribute对象", description = "付款属性配置表")
@Entity
@TableName("sys_supplier_payment_attribute")
@Table(name = "sys_supplier_payment_attribute")
@org.hibernate.annotations.Table(appliesTo = "sys_supplier_payment_attribute", comment = "付款属性配置表")
public class SysSupplierPaymentAttribute extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "boolEnableStatus", value = "启用状态 1启用 0禁用", notes = "启用状态 1启用 0禁用")
   @TableField("bool_enable_status")
   @Column(name = "bool_enable_status", columnDefinition = "tinyint(1) default '1' COMMENT '启用状态 1启用 0禁用'", nullable = false)
   private Boolean boolEnableStatus;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default '1' COMMENT '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder builder() {
      return new SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder();
   }

   public SysSupplierPaymentAttribute() {
   }

   public SysSupplierPaymentAttribute(
      final Long id,
      final String name,
      final Boolean boolEnableStatus,
      final Long createUserId,
      final String createUserName,
      final Integer sort,
      final String remark
   ) {
      this.id = id;
      this.name = name;
      this.boolEnableStatus = boolEnableStatus;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.sort = sort;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolEnableStatus() {
      return this.boolEnableStatus;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public SysSupplierPaymentAttribute setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysSupplierPaymentAttribute setName(final String name) {
      this.name = name;
      return this;
   }

   public SysSupplierPaymentAttribute setBoolEnableStatus(final Boolean boolEnableStatus) {
      this.boolEnableStatus = boolEnableStatus;
      return this;
   }

   public SysSupplierPaymentAttribute setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public SysSupplierPaymentAttribute setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public SysSupplierPaymentAttribute setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public SysSupplierPaymentAttribute setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "SysSupplierPaymentAttribute(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", boolEnableStatus="
         + this.getBoolEnableStatus()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysSupplierPaymentAttribute)) {
         return false;
      }

      SysSupplierPaymentAttribute other = (SysSupplierPaymentAttribute)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolEnableStatus = this.getBoolEnableStatus();
         Object other$boolEnableStatus = other.getBoolEnableStatus();
         if (this$boolEnableStatus == null ? other$boolEnableStatus == null : this$boolEnableStatus.equals(other$boolEnableStatus)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$createUserName = this.getCreateUserName();
                     Object other$createUserName = other.getCreateUserName();
                     if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof SysSupplierPaymentAttribute;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolEnableStatus = this.getBoolEnableStatus();
      result = result * 59 + ($boolEnableStatus == null ? 43 : $boolEnableStatus.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class SysSupplierPaymentAttributeBuilder {
      private Long id;
      private String name;
      private Boolean boolEnableStatus;
      private Long createUserId;
      private String createUserName;
      private Integer sort;
      private String remark;

      SysSupplierPaymentAttributeBuilder() {
      }

      public SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder boolEnableStatus(final Boolean boolEnableStatus) {
         this.boolEnableStatus = boolEnableStatus;
         return this;
      }

      public SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SysSupplierPaymentAttribute build() {
         return new SysSupplierPaymentAttribute(this.id, this.name, this.boolEnableStatus, this.createUserId, this.createUserName, this.sort, this.remark);
      }

      @Override
      public String toString() {
         return "SysSupplierPaymentAttribute.SysSupplierPaymentAttributeBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", boolEnableStatus="
            + this.boolEnableStatus
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
