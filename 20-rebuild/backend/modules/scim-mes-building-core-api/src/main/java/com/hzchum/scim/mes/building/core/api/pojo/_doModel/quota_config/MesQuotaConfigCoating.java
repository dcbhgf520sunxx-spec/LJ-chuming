package com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config;

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

@ApiModel(value = "MesQuotaConfigCoating对象", description = "定额配置涂装表")
@Entity
@TableName("mes_quota_config_coating")
@Table(name = "mes_quota_config_coating")
@org.hibernate.annotations.Table(appliesTo = "mes_quota_config_coating", comment = "定额配置涂装表")
public class MesQuotaConfigCoating extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("定额编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) COMMENT '定额编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty("机构ids")
   @TableField("branch_company_ids")
   @Column(name = "branch_company_ids", columnDefinition = "varchar(255) COMMENT '机构ids'", nullable = true)
   private String branchCompanyIds;
   @ApiModelProperty("车间ids")
   @TableField("workshop_ids")
   @Column(name = "workshop_ids", columnDefinition = "varchar(255) COMMENT '车间ids'", nullable = true)
   private String workshopIds;
   @ApiModelProperty("构件种类ids")
   @TableField("artifact_class_ids")
   @Column(name = "artifact_class_ids", columnDefinition = "varchar(500) COMMENT '构件种类ids'", nullable = true)
   private String artifactClassIds;
   @ApiModelProperty("工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20) COMMENT '工序id'", nullable = true)
   private Long processId;
   @ApiModelProperty("计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255) COMMENT '计量单位'", nullable = true)
   private String measureUnit;
   @ApiModelProperty("漆膜厚度基数(µm)")
   @TableField("paint_film_thickness_base")
   @Column(name = "paint_film_thickness_base", columnDefinition = "decimal(32,8) COMMENT '漆膜厚度基数(µm)'", nullable = true)
   private BigDecimal paintFilmThicknessBase;
   @ApiModelProperty("起步编制内单价(元)")
   @TableField("start_organization_inside_price")
   @Column(name = "start_organization_inside_price", columnDefinition = "decimal(32,8) COMMENT '起步编制内单价(元)'", nullable = true)
   private BigDecimal startOrganizationInsidePrice;
   @ApiModelProperty("起步编制外单价(元)")
   @TableField("start_organization_outside_price")
   @Column(name = "start_organization_outside_price", columnDefinition = "decimal(32,8) COMMENT '起步编制外单价(元)'", nullable = true)
   private BigDecimal startOrganizationOutsidePrice;
   @ApiModelProperty("起加漆膜厚度(µm)")
   @TableField("start_add_paint_film_thickness")
   @Column(name = "start_add_paint_film_thickness", columnDefinition = "decimal(32,8) COMMENT '起加漆膜厚度(µm)'", nullable = true)
   private BigDecimal startAddPaintFilmThickness;
   @ApiModelProperty("起加编制内单价(元)")
   @TableField("start_add_organization_inside_price")
   @Column(name = "start_add_organization_inside_price", columnDefinition = "decimal(32,8) COMMENT '起加编制内单价(元)'", nullable = true)
   private BigDecimal startAddOrganizationInsidePrice;
   @ApiModelProperty("起加编制外单价(元)")
   @TableField("start_add_organization_outside_price")
   @Column(name = "start_add_organization_outside_price", columnDefinition = "decimal(32,8) COMMENT '起加编制外单价(元)'", nullable = true)
   private BigDecimal startAddOrganizationOutsidePrice;

   public static MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder builder() {
      return new MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder();
   }

   public MesQuotaConfigCoating() {
   }

   public MesQuotaConfigCoating(
      final Long id,
      final String serialNumber,
      final String branchCompanyIds,
      final String workshopIds,
      final String artifactClassIds,
      final Long processId,
      final String measureUnit,
      final BigDecimal paintFilmThicknessBase,
      final BigDecimal startOrganizationInsidePrice,
      final BigDecimal startOrganizationOutsidePrice,
      final BigDecimal startAddPaintFilmThickness,
      final BigDecimal startAddOrganizationInsidePrice,
      final BigDecimal startAddOrganizationOutsidePrice
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.branchCompanyIds = branchCompanyIds;
      this.workshopIds = workshopIds;
      this.artifactClassIds = artifactClassIds;
      this.processId = processId;
      this.measureUnit = measureUnit;
      this.paintFilmThicknessBase = paintFilmThicknessBase;
      this.startOrganizationInsidePrice = startOrganizationInsidePrice;
      this.startOrganizationOutsidePrice = startOrganizationOutsidePrice;
      this.startAddPaintFilmThickness = startAddPaintFilmThickness;
      this.startAddOrganizationInsidePrice = startAddOrganizationInsidePrice;
      this.startAddOrganizationOutsidePrice = startAddOrganizationOutsidePrice;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getBranchCompanyIds() {
      return this.branchCompanyIds;
   }

   public String getWorkshopIds() {
      return this.workshopIds;
   }

   public String getArtifactClassIds() {
      return this.artifactClassIds;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getPaintFilmThicknessBase() {
      return this.paintFilmThicknessBase;
   }

   public BigDecimal getStartOrganizationInsidePrice() {
      return this.startOrganizationInsidePrice;
   }

   public BigDecimal getStartOrganizationOutsidePrice() {
      return this.startOrganizationOutsidePrice;
   }

   public BigDecimal getStartAddPaintFilmThickness() {
      return this.startAddPaintFilmThickness;
   }

   public BigDecimal getStartAddOrganizationInsidePrice() {
      return this.startAddOrganizationInsidePrice;
   }

   public BigDecimal getStartAddOrganizationOutsidePrice() {
      return this.startAddOrganizationOutsidePrice;
   }

   public MesQuotaConfigCoating setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesQuotaConfigCoating setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MesQuotaConfigCoating setBranchCompanyIds(final String branchCompanyIds) {
      this.branchCompanyIds = branchCompanyIds;
      return this;
   }

   public MesQuotaConfigCoating setWorkshopIds(final String workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public MesQuotaConfigCoating setArtifactClassIds(final String artifactClassIds) {
      this.artifactClassIds = artifactClassIds;
      return this;
   }

   public MesQuotaConfigCoating setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesQuotaConfigCoating setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public MesQuotaConfigCoating setPaintFilmThicknessBase(final BigDecimal paintFilmThicknessBase) {
      this.paintFilmThicknessBase = paintFilmThicknessBase;
      return this;
   }

   public MesQuotaConfigCoating setStartOrganizationInsidePrice(final BigDecimal startOrganizationInsidePrice) {
      this.startOrganizationInsidePrice = startOrganizationInsidePrice;
      return this;
   }

   public MesQuotaConfigCoating setStartOrganizationOutsidePrice(final BigDecimal startOrganizationOutsidePrice) {
      this.startOrganizationOutsidePrice = startOrganizationOutsidePrice;
      return this;
   }

   public MesQuotaConfigCoating setStartAddPaintFilmThickness(final BigDecimal startAddPaintFilmThickness) {
      this.startAddPaintFilmThickness = startAddPaintFilmThickness;
      return this;
   }

   public MesQuotaConfigCoating setStartAddOrganizationInsidePrice(final BigDecimal startAddOrganizationInsidePrice) {
      this.startAddOrganizationInsidePrice = startAddOrganizationInsidePrice;
      return this;
   }

   public MesQuotaConfigCoating setStartAddOrganizationOutsidePrice(final BigDecimal startAddOrganizationOutsidePrice) {
      this.startAddOrganizationOutsidePrice = startAddOrganizationOutsidePrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesQuotaConfigCoating(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", branchCompanyIds="
         + this.getBranchCompanyIds()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", artifactClassIds="
         + this.getArtifactClassIds()
         + ", processId="
         + this.getProcessId()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", paintFilmThicknessBase="
         + this.getPaintFilmThicknessBase()
         + ", startOrganizationInsidePrice="
         + this.getStartOrganizationInsidePrice()
         + ", startOrganizationOutsidePrice="
         + this.getStartOrganizationOutsidePrice()
         + ", startAddPaintFilmThickness="
         + this.getStartAddPaintFilmThickness()
         + ", startAddOrganizationInsidePrice="
         + this.getStartAddOrganizationInsidePrice()
         + ", startAddOrganizationOutsidePrice="
         + this.getStartAddOrganizationOutsidePrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigCoating)) {
         return false;
      }

      MesQuotaConfigCoating other = (MesQuotaConfigCoating)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$branchCompanyIds = this.getBranchCompanyIds();
               Object other$branchCompanyIds = other.getBranchCompanyIds();
               if (this$branchCompanyIds == null ? other$branchCompanyIds == null : this$branchCompanyIds.equals(other$branchCompanyIds)) {
                  Object this$workshopIds = this.getWorkshopIds();
                  Object other$workshopIds = other.getWorkshopIds();
                  if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
                     Object this$artifactClassIds = this.getArtifactClassIds();
                     Object other$artifactClassIds = other.getArtifactClassIds();
                     if (this$artifactClassIds == null ? other$artifactClassIds == null : this$artifactClassIds.equals(other$artifactClassIds)) {
                        Object this$measureUnit = this.getMeasureUnit();
                        Object other$measureUnit = other.getMeasureUnit();
                        if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                           Object this$paintFilmThicknessBase = this.getPaintFilmThicknessBase();
                           Object other$paintFilmThicknessBase = other.getPaintFilmThicknessBase();
                           if (this$paintFilmThicknessBase == null
                              ? other$paintFilmThicknessBase == null
                              : this$paintFilmThicknessBase.equals(other$paintFilmThicknessBase)) {
                              Object this$startOrganizationInsidePrice = this.getStartOrganizationInsidePrice();
                              Object other$startOrganizationInsidePrice = other.getStartOrganizationInsidePrice();
                              if (this$startOrganizationInsidePrice == null
                                 ? other$startOrganizationInsidePrice == null
                                 : this$startOrganizationInsidePrice.equals(other$startOrganizationInsidePrice)) {
                                 Object this$startOrganizationOutsidePrice = this.getStartOrganizationOutsidePrice();
                                 Object other$startOrganizationOutsidePrice = other.getStartOrganizationOutsidePrice();
                                 if (this$startOrganizationOutsidePrice == null
                                    ? other$startOrganizationOutsidePrice == null
                                    : this$startOrganizationOutsidePrice.equals(other$startOrganizationOutsidePrice)) {
                                    Object this$startAddPaintFilmThickness = this.getStartAddPaintFilmThickness();
                                    Object other$startAddPaintFilmThickness = other.getStartAddPaintFilmThickness();
                                    if (this$startAddPaintFilmThickness == null
                                       ? other$startAddPaintFilmThickness == null
                                       : this$startAddPaintFilmThickness.equals(other$startAddPaintFilmThickness)) {
                                       Object this$startAddOrganizationInsidePrice = this.getStartAddOrganizationInsidePrice();
                                       Object other$startAddOrganizationInsidePrice = other.getStartAddOrganizationInsidePrice();
                                       if (this$startAddOrganizationInsidePrice == null
                                          ? other$startAddOrganizationInsidePrice == null
                                          : this$startAddOrganizationInsidePrice.equals(other$startAddOrganizationInsidePrice)) {
                                          Object this$startAddOrganizationOutsidePrice = this.getStartAddOrganizationOutsidePrice();
                                          Object other$startAddOrganizationOutsidePrice = other.getStartAddOrganizationOutsidePrice();
                                          return this$startAddOrganizationOutsidePrice == null
                                             ? other$startAddOrganizationOutsidePrice == null
                                             : this$startAddOrganizationOutsidePrice.equals(other$startAddOrganizationOutsidePrice);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigCoating;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $branchCompanyIds = this.getBranchCompanyIds();
      result = result * 59 + ($branchCompanyIds == null ? 43 : $branchCompanyIds.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $artifactClassIds = this.getArtifactClassIds();
      result = result * 59 + ($artifactClassIds == null ? 43 : $artifactClassIds.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $paintFilmThicknessBase = this.getPaintFilmThicknessBase();
      result = result * 59 + ($paintFilmThicknessBase == null ? 43 : $paintFilmThicknessBase.hashCode());
      Object $startOrganizationInsidePrice = this.getStartOrganizationInsidePrice();
      result = result * 59 + ($startOrganizationInsidePrice == null ? 43 : $startOrganizationInsidePrice.hashCode());
      Object $startOrganizationOutsidePrice = this.getStartOrganizationOutsidePrice();
      result = result * 59 + ($startOrganizationOutsidePrice == null ? 43 : $startOrganizationOutsidePrice.hashCode());
      Object $startAddPaintFilmThickness = this.getStartAddPaintFilmThickness();
      result = result * 59 + ($startAddPaintFilmThickness == null ? 43 : $startAddPaintFilmThickness.hashCode());
      Object $startAddOrganizationInsidePrice = this.getStartAddOrganizationInsidePrice();
      result = result * 59 + ($startAddOrganizationInsidePrice == null ? 43 : $startAddOrganizationInsidePrice.hashCode());
      Object $startAddOrganizationOutsidePrice = this.getStartAddOrganizationOutsidePrice();
      return result * 59 + ($startAddOrganizationOutsidePrice == null ? 43 : $startAddOrganizationOutsidePrice.hashCode());
   }

   public static class MesQuotaConfigCoatingBuilder {
      private Long id;
      private String serialNumber;
      private String branchCompanyIds;
      private String workshopIds;
      private String artifactClassIds;
      private Long processId;
      private String measureUnit;
      private BigDecimal paintFilmThicknessBase;
      private BigDecimal startOrganizationInsidePrice;
      private BigDecimal startOrganizationOutsidePrice;
      private BigDecimal startAddPaintFilmThickness;
      private BigDecimal startAddOrganizationInsidePrice;
      private BigDecimal startAddOrganizationOutsidePrice;

      MesQuotaConfigCoatingBuilder() {
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder branchCompanyIds(final String branchCompanyIds) {
         this.branchCompanyIds = branchCompanyIds;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder workshopIds(final String workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder artifactClassIds(final String artifactClassIds) {
         this.artifactClassIds = artifactClassIds;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder paintFilmThicknessBase(final BigDecimal paintFilmThicknessBase) {
         this.paintFilmThicknessBase = paintFilmThicknessBase;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder startOrganizationInsidePrice(final BigDecimal startOrganizationInsidePrice) {
         this.startOrganizationInsidePrice = startOrganizationInsidePrice;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder startOrganizationOutsidePrice(final BigDecimal startOrganizationOutsidePrice) {
         this.startOrganizationOutsidePrice = startOrganizationOutsidePrice;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder startAddPaintFilmThickness(final BigDecimal startAddPaintFilmThickness) {
         this.startAddPaintFilmThickness = startAddPaintFilmThickness;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder startAddOrganizationInsidePrice(final BigDecimal startAddOrganizationInsidePrice) {
         this.startAddOrganizationInsidePrice = startAddOrganizationInsidePrice;
         return this;
      }

      public MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder startAddOrganizationOutsidePrice(final BigDecimal startAddOrganizationOutsidePrice) {
         this.startAddOrganizationOutsidePrice = startAddOrganizationOutsidePrice;
         return this;
      }

      public MesQuotaConfigCoating build() {
         return new MesQuotaConfigCoating(
            this.id,
            this.serialNumber,
            this.branchCompanyIds,
            this.workshopIds,
            this.artifactClassIds,
            this.processId,
            this.measureUnit,
            this.paintFilmThicknessBase,
            this.startOrganizationInsidePrice,
            this.startOrganizationOutsidePrice,
            this.startAddPaintFilmThickness,
            this.startAddOrganizationInsidePrice,
            this.startAddOrganizationOutsidePrice
         );
      }

      @Override
      public String toString() {
         return "MesQuotaConfigCoating.MesQuotaConfigCoatingBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", branchCompanyIds="
            + this.branchCompanyIds
            + ", workshopIds="
            + this.workshopIds
            + ", artifactClassIds="
            + this.artifactClassIds
            + ", processId="
            + this.processId
            + ", measureUnit="
            + this.measureUnit
            + ", paintFilmThicknessBase="
            + this.paintFilmThicknessBase
            + ", startOrganizationInsidePrice="
            + this.startOrganizationInsidePrice
            + ", startOrganizationOutsidePrice="
            + this.startOrganizationOutsidePrice
            + ", startAddPaintFilmThickness="
            + this.startAddPaintFilmThickness
            + ", startAddOrganizationInsidePrice="
            + this.startAddOrganizationInsidePrice
            + ", startAddOrganizationOutsidePrice="
            + this.startAddOrganizationOutsidePrice
            + ")";
      }
   }
}
