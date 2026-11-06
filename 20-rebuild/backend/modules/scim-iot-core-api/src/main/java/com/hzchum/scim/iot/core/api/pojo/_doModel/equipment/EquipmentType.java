package com.hzchum.scim.iot.core.api.pojo._doModel.equipment;

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

@ApiModel(value = "EquipmentType对象", description = "设备分类配置表")
@Entity
@TableName("equipment_type")
@Table(name = "equipment_type")
@org.hibernate.annotations.Table(appliesTo = "equipment_type", comment = "设备分类配置表")
public class EquipmentType extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "业务主键", notes = "业务主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "iotId", value = "物联主键", notes = "物联主键")
   @TableField("iot_id")
   @Column(name = "iot_id", columnDefinition = "bigint(20)  COMMENT '物联主键'", nullable = true)
   private Long iotId;
   @ApiModelProperty(name = "typeCode", value = "分类编码", notes = "分类编码")
   @TableField("type_code")
   @Column(name = "type_code", columnDefinition = "varchar(64)  COMMENT '分类编码'", nullable = true)
   private String typeCode;
   @ApiModelProperty(name = "typeName", value = "分类名称", notes = "分类名称")
   @TableField("type_name")
   @Column(name = "type_name", columnDefinition = "varchar(64)  COMMENT '分类名称'", nullable = false)
   private String typeName;
   @ApiModelProperty(name = "orderNum", value = "排序编号", notes = "排序编号")
   @TableField("order_num")
   @Column(name = "order_num", columnDefinition = "int(11)  COMMENT '排序编号'", nullable = true)
   private Integer orderNum;
   @ApiModelProperty(name = "parentTypeCode", value = "上级分类编码", notes = "上级分类编码")
   @TableField("parent_type_code")
   @Column(name = "parent_type_code", columnDefinition = "varchar(32)  COMMENT '上级分类编码'", nullable = true)
   private String parentTypeCode;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "createBy", value = "创建人标识", notes = "创建人标识")
   @TableField("create_by")
   @Column(name = "create_by", columnDefinition = "bigint(20)  COMMENT '创建人标识'", nullable = true)
   private Long createBy;
   @ApiModelProperty(name = "updateBy", value = "更新人标识", notes = "更新人标识")
   @TableField("update_by")
   @Column(name = "update_by", columnDefinition = "bigint(20)  COMMENT '更新人标识'", nullable = true)
   private Long updateBy;

   public static EquipmentType.EquipmentTypeBuilder builder() {
      return new EquipmentType.EquipmentTypeBuilder();
   }

   public EquipmentType() {
   }

   public EquipmentType(
      final Long id,
      final Long iotId,
      final String typeCode,
      final String typeName,
      final Integer orderNum,
      final String parentTypeCode,
      final String remark,
      final Long createBy,
      final Long updateBy
   ) {
      this.id = id;
      this.iotId = iotId;
      this.typeCode = typeCode;
      this.typeName = typeName;
      this.orderNum = orderNum;
      this.parentTypeCode = parentTypeCode;
      this.remark = remark;
      this.createBy = createBy;
      this.updateBy = updateBy;
   }

   public Long getId() {
      return this.id;
   }

   public Long getIotId() {
      return this.iotId;
   }

   public String getTypeCode() {
      return this.typeCode;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public Integer getOrderNum() {
      return this.orderNum;
   }

   public String getParentTypeCode() {
      return this.parentTypeCode;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateBy() {
      return this.createBy;
   }

   public Long getUpdateBy() {
      return this.updateBy;
   }

   public EquipmentType setId(final Long id) {
      this.id = id;
      return this;
   }

   public EquipmentType setIotId(final Long iotId) {
      this.iotId = iotId;
      return this;
   }

   public EquipmentType setTypeCode(final String typeCode) {
      this.typeCode = typeCode;
      return this;
   }

   public EquipmentType setTypeName(final String typeName) {
      this.typeName = typeName;
      return this;
   }

   public EquipmentType setOrderNum(final Integer orderNum) {
      this.orderNum = orderNum;
      return this;
   }

   public EquipmentType setParentTypeCode(final String parentTypeCode) {
      this.parentTypeCode = parentTypeCode;
      return this;
   }

   public EquipmentType setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public EquipmentType setCreateBy(final Long createBy) {
      this.createBy = createBy;
      return this;
   }

   public EquipmentType setUpdateBy(final Long updateBy) {
      this.updateBy = updateBy;
      return this;
   }

   @Override
   public String toString() {
      return "EquipmentType(id="
         + this.getId()
         + ", iotId="
         + this.getIotId()
         + ", typeCode="
         + this.getTypeCode()
         + ", typeName="
         + this.getTypeName()
         + ", orderNum="
         + this.getOrderNum()
         + ", parentTypeCode="
         + this.getParentTypeCode()
         + ", remark="
         + this.getRemark()
         + ", createBy="
         + this.getCreateBy()
         + ", updateBy="
         + this.getUpdateBy()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EquipmentType)) {
         return false;
      }

      EquipmentType other = (EquipmentType)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$iotId = this.getIotId();
         Object other$iotId = other.getIotId();
         if (this$iotId == null ? other$iotId == null : this$iotId.equals(other$iotId)) {
            Object this$orderNum = this.getOrderNum();
            Object other$orderNum = other.getOrderNum();
            if (this$orderNum == null ? other$orderNum == null : this$orderNum.equals(other$orderNum)) {
               Object this$createBy = this.getCreateBy();
               Object other$createBy = other.getCreateBy();
               if (this$createBy == null ? other$createBy == null : this$createBy.equals(other$createBy)) {
                  Object this$updateBy = this.getUpdateBy();
                  Object other$updateBy = other.getUpdateBy();
                  if (this$updateBy == null ? other$updateBy == null : this$updateBy.equals(other$updateBy)) {
                     Object this$typeCode = this.getTypeCode();
                     Object other$typeCode = other.getTypeCode();
                     if (this$typeCode == null ? other$typeCode == null : this$typeCode.equals(other$typeCode)) {
                        Object this$typeName = this.getTypeName();
                        Object other$typeName = other.getTypeName();
                        if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
                           Object this$parentTypeCode = this.getParentTypeCode();
                           Object other$parentTypeCode = other.getParentTypeCode();
                           if (this$parentTypeCode == null ? other$parentTypeCode == null : this$parentTypeCode.equals(other$parentTypeCode)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof EquipmentType;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $iotId = this.getIotId();
      result = result * 59 + ($iotId == null ? 43 : $iotId.hashCode());
      Object $orderNum = this.getOrderNum();
      result = result * 59 + ($orderNum == null ? 43 : $orderNum.hashCode());
      Object $createBy = this.getCreateBy();
      result = result * 59 + ($createBy == null ? 43 : $createBy.hashCode());
      Object $updateBy = this.getUpdateBy();
      result = result * 59 + ($updateBy == null ? 43 : $updateBy.hashCode());
      Object $typeCode = this.getTypeCode();
      result = result * 59 + ($typeCode == null ? 43 : $typeCode.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $parentTypeCode = this.getParentTypeCode();
      result = result * 59 + ($parentTypeCode == null ? 43 : $parentTypeCode.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class EquipmentTypeBuilder {
      private Long id;
      private Long iotId;
      private String typeCode;
      private String typeName;
      private Integer orderNum;
      private String parentTypeCode;
      private String remark;
      private Long createBy;
      private Long updateBy;

      EquipmentTypeBuilder() {
      }

      public EquipmentType.EquipmentTypeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public EquipmentType.EquipmentTypeBuilder iotId(final Long iotId) {
         this.iotId = iotId;
         return this;
      }

      public EquipmentType.EquipmentTypeBuilder typeCode(final String typeCode) {
         this.typeCode = typeCode;
         return this;
      }

      public EquipmentType.EquipmentTypeBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      public EquipmentType.EquipmentTypeBuilder orderNum(final Integer orderNum) {
         this.orderNum = orderNum;
         return this;
      }

      public EquipmentType.EquipmentTypeBuilder parentTypeCode(final String parentTypeCode) {
         this.parentTypeCode = parentTypeCode;
         return this;
      }

      public EquipmentType.EquipmentTypeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public EquipmentType.EquipmentTypeBuilder createBy(final Long createBy) {
         this.createBy = createBy;
         return this;
      }

      public EquipmentType.EquipmentTypeBuilder updateBy(final Long updateBy) {
         this.updateBy = updateBy;
         return this;
      }

      public EquipmentType build() {
         return new EquipmentType(
            this.id, this.iotId, this.typeCode, this.typeName, this.orderNum, this.parentTypeCode, this.remark, this.createBy, this.updateBy
         );
      }

      @Override
      public String toString() {
         return "EquipmentType.EquipmentTypeBuilder(id="
            + this.id
            + ", iotId="
            + this.iotId
            + ", typeCode="
            + this.typeCode
            + ", typeName="
            + this.typeName
            + ", orderNum="
            + this.orderNum
            + ", parentTypeCode="
            + this.parentTypeCode
            + ", remark="
            + this.remark
            + ", createBy="
            + this.createBy
            + ", updateBy="
            + this.updateBy
            + ")";
      }
   }
}
