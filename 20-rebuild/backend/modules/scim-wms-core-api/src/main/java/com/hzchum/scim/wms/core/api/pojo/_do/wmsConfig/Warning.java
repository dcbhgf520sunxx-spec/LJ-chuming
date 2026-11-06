package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@ApiModel(value = "Warning对象", description = "库存预警 ")
@Entity
@TableName("wms_warning")
@Table(name = "wms_warning")
public class Warning extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "科目编码", notes = "科目编码")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(128)  COMMENT '科目编码'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "classificationId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classificationId")
   @JSONField(name = "classificationId")
   @TableField("classification_id")
   @Column(name = "classification_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classificationId;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "unit", value = "单位", notes = "单位")
   @JsonProperty("unit")
   @JSONField(name = "unit")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(128)  COMMENT '单位'", nullable = true)
   private String unit;
   @ApiModelProperty(name = "unitType", value = "单位类型[计量,核算]", notes = "单位类型[计量,核算]")
   @JsonProperty("unitType")
   @JSONField(name = "unitType")
   @TableField("unit_type")
   @Column(name = "unit_type", columnDefinition = "int  COMMENT '单位类型[计量,核算]'", nullable = true)
   private Integer unitType;
   @ApiModelProperty(name = "minimumInventory", value = "预警量", notes = "预警量")
   @JsonProperty("minimumInventory")
   @JSONField(name = "minimumInventory")
   @TableField("minimum_inventory")
   @Column(name = "minimum_inventory", columnDefinition = "decimal(32,8)  COMMENT '预警量'", nullable = true)
   private BigDecimal minimumInventory;
   @ApiModelProperty(name = "enabled", value = "是否使用[0 不使用, 1 使用 ],创建时默认使用", notes = "是否使用[0 不使用, 1 使用 ],创建时默认使用")
   @JsonProperty("enabled")
   @JSONField(name = "enabled")
   @TableField("enabled")
   @Column(name = "enabled", columnDefinition = "tinyint(1) default '1' COMMENT '是否使用[0 不使用, 1 使用 ],创建时默认使用'", nullable = true)
   private Boolean enabled;
   @ApiModelProperty(name = "status", value = "预警状态,当需要预警时修改状态为true,默认为false", notes = "预警状态,当需要预警时修改状态为true,默认为false")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '0' COMMENT '预警状态,当需要预警时修改状态为true,默认为false'", nullable = true)
   private Boolean status;
   @ApiModelProperty(name = "workshopId")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long workshopId;

   public static Warning.WarningBuilder builder() {
      return new Warning.WarningBuilder();
   }

   public Warning() {
   }

   public Warning(
      final Long id,
      final String serialNumber,
      final Long classificationId,
      final String specification,
      final String unit,
      final Integer unitType,
      final BigDecimal minimumInventory,
      final Boolean enabled,
      final Boolean status,
      final Long workshopId
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.classificationId = classificationId;
      this.specification = specification;
      this.unit = unit;
      this.unitType = unitType;
      this.minimumInventory = minimumInventory;
      this.enabled = enabled;
      this.status = status;
      this.workshopId = workshopId;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getUnit() {
      return this.unit;
   }

   public Integer getUnitType() {
      return this.unitType;
   }

   public BigDecimal getMinimumInventory() {
      return this.minimumInventory;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   @JsonProperty("id")
   public Warning setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public Warning setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("classificationId")
   public Warning setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   @JsonProperty("specification")
   public Warning setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("unit")
   public Warning setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   @JsonProperty("unitType")
   public Warning setUnitType(final Integer unitType) {
      this.unitType = unitType;
      return this;
   }

   @JsonProperty("minimumInventory")
   public Warning setMinimumInventory(final BigDecimal minimumInventory) {
      this.minimumInventory = minimumInventory;
      return this;
   }

   @JsonProperty("enabled")
   public Warning setEnabled(final Boolean enabled) {
      this.enabled = enabled;
      return this;
   }

   @JsonProperty("status")
   public Warning setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("workshopId")
   public Warning setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @Override
   public String toString() {
      return "Warning(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", classificationId="
         + this.getClassificationId()
         + ", specification="
         + this.getSpecification()
         + ", unit="
         + this.getUnit()
         + ", unitType="
         + this.getUnitType()
         + ", minimumInventory="
         + this.getMinimumInventory()
         + ", enabled="
         + this.getEnabled()
         + ", status="
         + this.getStatus()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Warning)) {
         return false;
      }

      Warning other = (Warning)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classificationId = this.getClassificationId();
         Object other$classificationId = other.getClassificationId();
         if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
            Object this$unitType = this.getUnitType();
            Object other$unitType = other.getUnitType();
            if (this$unitType == null ? other$unitType == null : this$unitType.equals(other$unitType)) {
               Object this$enabled = this.getEnabled();
               Object other$enabled = other.getEnabled();
               if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$unit = this.getUnit();
                              Object other$unit = other.getUnit();
                              if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                 Object this$minimumInventory = this.getMinimumInventory();
                                 Object other$minimumInventory = other.getMinimumInventory();
                                 return this$minimumInventory == null ? other$minimumInventory == null : this$minimumInventory.equals(other$minimumInventory);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof Warning;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $minimumInventory = this.getMinimumInventory();
      return result * 59 + ($minimumInventory == null ? 43 : $minimumInventory.hashCode());
   }

   public static class WarningBuilder {
      private Long id;
      private String serialNumber;
      private Long classificationId;
      private String specification;
      private String unit;
      private Integer unitType;
      private BigDecimal minimumInventory;
      private Boolean enabled;
      private Boolean status;
      private Long workshopId;

      WarningBuilder() {
      }

      @JsonProperty("id")
      public Warning.WarningBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public Warning.WarningBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("classificationId")
      public Warning.WarningBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      @JsonProperty("specification")
      public Warning.WarningBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("unit")
      public Warning.WarningBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      @JsonProperty("unitType")
      public Warning.WarningBuilder unitType(final Integer unitType) {
         this.unitType = unitType;
         return this;
      }

      @JsonProperty("minimumInventory")
      public Warning.WarningBuilder minimumInventory(final BigDecimal minimumInventory) {
         this.minimumInventory = minimumInventory;
         return this;
      }

      @JsonProperty("enabled")
      public Warning.WarningBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      @JsonProperty("status")
      public Warning.WarningBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("workshopId")
      public Warning.WarningBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public Warning build() {
         return new Warning(
            this.id,
            this.serialNumber,
            this.classificationId,
            this.specification,
            this.unit,
            this.unitType,
            this.minimumInventory,
            this.enabled,
            this.status,
            this.workshopId
         );
      }

      @Override
      public String toString() {
         return "Warning.WarningBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", classificationId="
            + this.classificationId
            + ", specification="
            + this.specification
            + ", unit="
            + this.unit
            + ", unitType="
            + this.unitType
            + ", minimumInventory="
            + this.minimumInventory
            + ", enabled="
            + this.enabled
            + ", status="
            + this.status
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
