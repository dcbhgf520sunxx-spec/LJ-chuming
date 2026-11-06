package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesAuxiliary对象", description = "MES配套件表")
@Entity
@TableName("mes_auxiliary")
@Table(name = "mes_auxiliary")
@org.hibernate.annotations.Table(appliesTo = "mes_auxiliary", comment = "MES配套件表")
public class MesAuxiliary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "auxiliaryName", value = "配套件名称", notes = "配套件名称")
   @TableField("auxiliary_name")
   @Column(name = "auxiliary_name", columnDefinition = "varchar(2000)  COMMENT '配套件名称'", nullable = true)
   private String auxiliaryName;
   @ApiModelProperty(name = "accountingUnit", value = "配套件核算单位", notes = "配套件核算单位")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit", columnDefinition = "varchar(10)  COMMENT '配套件核算单位'", nullable = true)
   private String accountingUnit;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "核算量误差值（可超过百分比）", value = "核算量误差值（可超过百分比）", notes = "核算量误差值（可超过百分比）")
   @TableField("mete_diff")
   @Column(name = "mete_diff", columnDefinition = "decimal(10,2)  COMMENT '核算量误差值（可超过百分比）'", nullable = true)
   private BigDecimal meteDiff;

   public static MesAuxiliary.MesAuxiliaryBuilder builder() {
      return new MesAuxiliary.MesAuxiliaryBuilder();
   }

   public MesAuxiliary() {
   }

   public MesAuxiliary(final Long id, final String auxiliaryName, final String accountingUnit, final Integer basicClass, final BigDecimal meteDiff) {
      this.id = id;
      this.auxiliaryName = auxiliaryName;
      this.accountingUnit = accountingUnit;
      this.basicClass = basicClass;
      this.meteDiff = meteDiff;
   }

   public Long getId() {
      return this.id;
   }

   public String getAuxiliaryName() {
      return this.auxiliaryName;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getMeteDiff() {
      return this.meteDiff;
   }

   public MesAuxiliary setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesAuxiliary setAuxiliaryName(final String auxiliaryName) {
      this.auxiliaryName = auxiliaryName;
      return this;
   }

   public MesAuxiliary setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   public MesAuxiliary setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public MesAuxiliary setMeteDiff(final BigDecimal meteDiff) {
      this.meteDiff = meteDiff;
      return this;
   }

   @Override
   public String toString() {
      return "MesAuxiliary(id="
         + this.getId()
         + ", auxiliaryName="
         + this.getAuxiliaryName()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", basicClass="
         + this.getBasicClass()
         + ", meteDiff="
         + this.getMeteDiff()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAuxiliary)) {
         return false;
      }

      MesAuxiliary other = (MesAuxiliary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$auxiliaryName = this.getAuxiliaryName();
            Object other$auxiliaryName = other.getAuxiliaryName();
            if (this$auxiliaryName == null ? other$auxiliaryName == null : this$auxiliaryName.equals(other$auxiliaryName)) {
               Object this$accountingUnit = this.getAccountingUnit();
               Object other$accountingUnit = other.getAccountingUnit();
               if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                  Object this$meteDiff = this.getMeteDiff();
                  Object other$meteDiff = other.getMeteDiff();
                  return this$meteDiff == null ? other$meteDiff == null : this$meteDiff.equals(other$meteDiff);
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
      return other instanceof MesAuxiliary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $auxiliaryName = this.getAuxiliaryName();
      result = result * 59 + ($auxiliaryName == null ? 43 : $auxiliaryName.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $meteDiff = this.getMeteDiff();
      return result * 59 + ($meteDiff == null ? 43 : $meteDiff.hashCode());
   }

   public static class MesAuxiliaryBuilder {
      private Long id;
      private String auxiliaryName;
      private String accountingUnit;
      private Integer basicClass;
      private BigDecimal meteDiff;

      MesAuxiliaryBuilder() {
      }

      public MesAuxiliary.MesAuxiliaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesAuxiliary.MesAuxiliaryBuilder auxiliaryName(final String auxiliaryName) {
         this.auxiliaryName = auxiliaryName;
         return this;
      }

      public MesAuxiliary.MesAuxiliaryBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public MesAuxiliary.MesAuxiliaryBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MesAuxiliary.MesAuxiliaryBuilder meteDiff(final BigDecimal meteDiff) {
         this.meteDiff = meteDiff;
         return this;
      }

      public MesAuxiliary build() {
         return new MesAuxiliary(this.id, this.auxiliaryName, this.accountingUnit, this.basicClass, this.meteDiff);
      }

      @Override
      public String toString() {
         return "MesAuxiliary.MesAuxiliaryBuilder(id="
            + this.id
            + ", auxiliaryName="
            + this.auxiliaryName
            + ", accountingUnit="
            + this.accountingUnit
            + ", basicClass="
            + this.basicClass
            + ", meteDiff="
            + this.meteDiff
            + ")";
      }
   }
}
