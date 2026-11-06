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

@ApiModel(value = "MesContractProjectOddJobConfigLink对象", description = "项目零工配置关联表")
@Entity
@TableName("mes_contract_project_odd_job_config_link")
@Table(name = "mes_contract_project_odd_job_config_link")
@org.hibernate.annotations.Table(appliesTo = "mes_contract_project_odd_job_config_link", comment = "项目零工配置关联表")
public class MesContractProjectOddJobConfigLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   @TableField("contract_project_id")
   @Column(name = "contract_project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long contractProjectId;
   @ApiModelProperty(name = "oddJobType", value = "零工类型", notes = "零工类型")
   @TableField("odd_job_type")
   @Column(name = "odd_job_type", columnDefinition = "varchar(255)  COMMENT '零工类型'", nullable = true)
   private String oddJobType;
   @ApiModelProperty(name = "unit", value = "计算单位", notes = "计算单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255)  COMMENT '计算单位'", nullable = true)
   private String unit;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8)  COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default 1 COMMENT '状态'", nullable = true)
   private Boolean status;

   public static MesContractProjectOddJobConfigLink.MesContractProjectOddJobConfigLinkBuilder builder() {
      return new MesContractProjectOddJobConfigLink.MesContractProjectOddJobConfigLinkBuilder();
   }

   public MesContractProjectOddJobConfigLink() {
   }

   public MesContractProjectOddJobConfigLink(
      final Long id, final Long contractProjectId, final String oddJobType, final String unit, final BigDecimal price, final Boolean status
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
      this.oddJobType = oddJobType;
      this.unit = unit;
      this.price = price;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public String getOddJobType() {
      return this.oddJobType;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public MesContractProjectOddJobConfigLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesContractProjectOddJobConfigLink setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesContractProjectOddJobConfigLink setOddJobType(final String oddJobType) {
      this.oddJobType = oddJobType;
      return this;
   }

   public MesContractProjectOddJobConfigLink setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesContractProjectOddJobConfigLink setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesContractProjectOddJobConfigLink setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "MesContractProjectOddJobConfigLink(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", oddJobType="
         + this.getOddJobType()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectOddJobConfigLink)) {
         return false;
      }

      MesContractProjectOddJobConfigLink other = (MesContractProjectOddJobConfigLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$oddJobType = this.getOddJobType();
               Object other$oddJobType = other.getOddJobType();
               if (this$oddJobType == null ? other$oddJobType == null : this$oddJobType.equals(other$oddJobType)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesContractProjectOddJobConfigLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $oddJobType = this.getOddJobType();
      result = result * 59 + ($oddJobType == null ? 43 : $oddJobType.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesContractProjectOddJobConfigLinkBuilder {
      private Long id;
      private Long contractProjectId;
      private String oddJobType;
      private String unit;
      private BigDecimal price;
      private Boolean status;

      MesContractProjectOddJobConfigLinkBuilder() {
      }

      public MesContractProjectOddJobConfigLink.MesContractProjectOddJobConfigLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectOddJobConfigLink.MesContractProjectOddJobConfigLinkBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectOddJobConfigLink.MesContractProjectOddJobConfigLinkBuilder oddJobType(final String oddJobType) {
         this.oddJobType = oddJobType;
         return this;
      }

      public MesContractProjectOddJobConfigLink.MesContractProjectOddJobConfigLinkBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesContractProjectOddJobConfigLink.MesContractProjectOddJobConfigLinkBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesContractProjectOddJobConfigLink.MesContractProjectOddJobConfigLinkBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesContractProjectOddJobConfigLink build() {
         return new MesContractProjectOddJobConfigLink(this.id, this.contractProjectId, this.oddJobType, this.unit, this.price, this.status);
      }

      @Override
      public String toString() {
         return "MesContractProjectOddJobConfigLink.MesContractProjectOddJobConfigLinkBuilder(id="
            + this.id
            + ", contractProjectId="
            + this.contractProjectId
            + ", oddJobType="
            + this.oddJobType
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ")";
      }
   }
}
