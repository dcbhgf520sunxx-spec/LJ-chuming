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

@ApiModel(value = "SysAuxiliarySerialNumber对象", description = "配套件编号表 ")
@Entity
@TableName("sys_auxiliary_serial_number")
@Table(name = "sys_auxiliary_serial_number")
@org.hibernate.annotations.Table(appliesTo = "sys_auxiliary_serial_number", comment = "配套件编号表 ")
public class SysAuxiliarySerialNumber extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "auxiliaryClassId", value = "配套件类型ID", notes = "配套件类型ID")
   @TableField("auxiliary_class_id")
   @Column(name = "auxiliary_class_id", columnDefinition = "bigint(20)  COMMENT '配套件类型ID'", nullable = false)
   private Long auxiliaryClassId;

   public static SysAuxiliarySerialNumber.SysAuxiliarySerialNumberBuilder builder() {
      return new SysAuxiliarySerialNumber.SysAuxiliarySerialNumberBuilder();
   }

   public SysAuxiliarySerialNumber() {
   }

   public SysAuxiliarySerialNumber(final Long id, final String serialNumber, final Long auxiliaryClassId) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.auxiliaryClassId = auxiliaryClassId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getAuxiliaryClassId() {
      return this.auxiliaryClassId;
   }

   public SysAuxiliarySerialNumber setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysAuxiliarySerialNumber setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public SysAuxiliarySerialNumber setAuxiliaryClassId(final Long auxiliaryClassId) {
      this.auxiliaryClassId = auxiliaryClassId;
      return this;
   }

   @Override
   public String toString() {
      return "SysAuxiliarySerialNumber(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", auxiliaryClassId="
         + this.getAuxiliaryClassId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAuxiliarySerialNumber)) {
         return false;
      }

      SysAuxiliarySerialNumber other = (SysAuxiliarySerialNumber)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auxiliaryClassId = this.getAuxiliaryClassId();
         Object other$auxiliaryClassId = other.getAuxiliaryClassId();
         if (this$auxiliaryClassId == null ? other$auxiliaryClassId == null : this$auxiliaryClassId.equals(other$auxiliaryClassId)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysAuxiliarySerialNumber;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auxiliaryClassId = this.getAuxiliaryClassId();
      result = result * 59 + ($auxiliaryClassId == null ? 43 : $auxiliaryClassId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class SysAuxiliarySerialNumberBuilder {
      private Long id;
      private String serialNumber;
      private Long auxiliaryClassId;

      SysAuxiliarySerialNumberBuilder() {
      }

      public SysAuxiliarySerialNumber.SysAuxiliarySerialNumberBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysAuxiliarySerialNumber.SysAuxiliarySerialNumberBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SysAuxiliarySerialNumber.SysAuxiliarySerialNumberBuilder auxiliaryClassId(final Long auxiliaryClassId) {
         this.auxiliaryClassId = auxiliaryClassId;
         return this;
      }

      public SysAuxiliarySerialNumber build() {
         return new SysAuxiliarySerialNumber(this.id, this.serialNumber, this.auxiliaryClassId);
      }

      @Override
      public String toString() {
         return "SysAuxiliarySerialNumber.SysAuxiliarySerialNumberBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", auxiliaryClassId="
            + this.auxiliaryClassId
            + ")";
      }
   }
}
