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

@ApiModel(value = "TechCappCraftCardStorehouseMaterialsLink对象", description = "焊接工艺材料信息表")
@Entity
@TableName("tech_capp_craft_card_storehouse_materials_link")
@Table(name = "tech_capp_craft_card_storehouse_materials_link")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_card_storehouse_materials_link", comment = "焊接工艺材料信息表")
public class TechCappCraftCardStorehouseMaterialsLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "weldingMaterialName", value = "焊接/施焊材料", notes = "焊接/施焊材料")
   @TableField("welding_material_name")
   @Column(name = "welding_material_name", columnDefinition = "varchar(255)  COMMENT '焊接/施焊材料'", nullable = true)
   private String weldingMaterialName;
   @ApiModelProperty(name = "weldingMaterialManufacturingPlant", value = "生产厂", notes = "生产厂")
   @TableField("welding_material_manufacturing_plant")
   @Column(name = "welding_material_manufacturing_plant", columnDefinition = "varchar(255)  COMMENT '生产厂'", nullable = true)
   private String weldingMaterialManufacturingPlant;
   @ApiModelProperty(name = "weldingMaterialTrademark", value = "牌号", notes = "牌号")
   @TableField("welding_material_trademark")
   @Column(name = "welding_material_trademark", columnDefinition = "varchar(255)  COMMENT '牌号'", nullable = true)
   private String weldingMaterialTrademark;
   @ApiModelProperty(name = "weldingMaterialModel", value = "型号", notes = "型号")
   @TableField("welding_material_model")
   @Column(name = "welding_material_model", columnDefinition = "varchar(255)  COMMENT '型号'", nullable = true)
   private String weldingMaterialModel;
   @ApiModelProperty(name = "weldingMaterialType", value = "类型", notes = "类型")
   @TableField("welding_material_type")
   @Column(name = "welding_material_type", columnDefinition = "varchar(255)  COMMENT '类型'", nullable = true)
   private String weldingMaterialType;
   @ApiModelProperty(name = "weldingMaterialDryingProcedure", value = "烘干制度(℃×h)", notes = "烘干制度(℃×h)")
   @TableField("welding_material_drying_procedure")
   @Column(name = "welding_material_drying_procedure", columnDefinition = "varchar(255)  COMMENT '烘干制度(℃×h)'", nullable = true)
   private String weldingMaterialDryingProcedure;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "焊接工艺主表id", notes = "焊接工艺主表id")
   @TableField("tech_capp_craft_card_storehouse_id")
   @Column(name = "tech_capp_craft_card_storehouse_id", columnDefinition = "bigint(20)  COMMENT '焊接工艺主表id'", nullable = false)
   private Long techCappCraftCardStorehouseId;

   public static TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder builder() {
      return new TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder();
   }

   public TechCappCraftCardStorehouseMaterialsLink() {
   }

   public TechCappCraftCardStorehouseMaterialsLink(
      final Long id,
      final String weldingMaterialName,
      final String weldingMaterialManufacturingPlant,
      final String weldingMaterialTrademark,
      final String weldingMaterialModel,
      final String weldingMaterialType,
      final String weldingMaterialDryingProcedure,
      final String remark,
      final Long techCappCraftCardStorehouseId
   ) {
      this.id = id;
      this.weldingMaterialName = weldingMaterialName;
      this.weldingMaterialManufacturingPlant = weldingMaterialManufacturingPlant;
      this.weldingMaterialTrademark = weldingMaterialTrademark;
      this.weldingMaterialModel = weldingMaterialModel;
      this.weldingMaterialType = weldingMaterialType;
      this.weldingMaterialDryingProcedure = weldingMaterialDryingProcedure;
      this.remark = remark;
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
   }

   public Long getId() {
      return this.id;
   }

   public String getWeldingMaterialName() {
      return this.weldingMaterialName;
   }

   public String getWeldingMaterialManufacturingPlant() {
      return this.weldingMaterialManufacturingPlant;
   }

   public String getWeldingMaterialTrademark() {
      return this.weldingMaterialTrademark;
   }

   public String getWeldingMaterialModel() {
      return this.weldingMaterialModel;
   }

   public String getWeldingMaterialType() {
      return this.weldingMaterialType;
   }

   public String getWeldingMaterialDryingProcedure() {
      return this.weldingMaterialDryingProcedure;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public TechCappCraftCardStorehouseMaterialsLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftCardStorehouseMaterialsLink setWeldingMaterialName(final String weldingMaterialName) {
      this.weldingMaterialName = weldingMaterialName;
      return this;
   }

   public TechCappCraftCardStorehouseMaterialsLink setWeldingMaterialManufacturingPlant(final String weldingMaterialManufacturingPlant) {
      this.weldingMaterialManufacturingPlant = weldingMaterialManufacturingPlant;
      return this;
   }

   public TechCappCraftCardStorehouseMaterialsLink setWeldingMaterialTrademark(final String weldingMaterialTrademark) {
      this.weldingMaterialTrademark = weldingMaterialTrademark;
      return this;
   }

   public TechCappCraftCardStorehouseMaterialsLink setWeldingMaterialModel(final String weldingMaterialModel) {
      this.weldingMaterialModel = weldingMaterialModel;
      return this;
   }

   public TechCappCraftCardStorehouseMaterialsLink setWeldingMaterialType(final String weldingMaterialType) {
      this.weldingMaterialType = weldingMaterialType;
      return this;
   }

   public TechCappCraftCardStorehouseMaterialsLink setWeldingMaterialDryingProcedure(final String weldingMaterialDryingProcedure) {
      this.weldingMaterialDryingProcedure = weldingMaterialDryingProcedure;
      return this;
   }

   public TechCappCraftCardStorehouseMaterialsLink setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechCappCraftCardStorehouseMaterialsLink setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftCardStorehouseMaterialsLink(id="
         + this.getId()
         + ", weldingMaterialName="
         + this.getWeldingMaterialName()
         + ", weldingMaterialManufacturingPlant="
         + this.getWeldingMaterialManufacturingPlant()
         + ", weldingMaterialTrademark="
         + this.getWeldingMaterialTrademark()
         + ", weldingMaterialModel="
         + this.getWeldingMaterialModel()
         + ", weldingMaterialType="
         + this.getWeldingMaterialType()
         + ", weldingMaterialDryingProcedure="
         + this.getWeldingMaterialDryingProcedure()
         + ", remark="
         + this.getRemark()
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftCardStorehouseMaterialsLink)) {
         return false;
      }

      TechCappCraftCardStorehouseMaterialsLink other = (TechCappCraftCardStorehouseMaterialsLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
         Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
         if (this$techCappCraftCardStorehouseId == null
            ? other$techCappCraftCardStorehouseId == null
            : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
            Object this$weldingMaterialName = this.getWeldingMaterialName();
            Object other$weldingMaterialName = other.getWeldingMaterialName();
            if (this$weldingMaterialName == null ? other$weldingMaterialName == null : this$weldingMaterialName.equals(other$weldingMaterialName)) {
               Object this$weldingMaterialManufacturingPlant = this.getWeldingMaterialManufacturingPlant();
               Object other$weldingMaterialManufacturingPlant = other.getWeldingMaterialManufacturingPlant();
               if (this$weldingMaterialManufacturingPlant == null
                  ? other$weldingMaterialManufacturingPlant == null
                  : this$weldingMaterialManufacturingPlant.equals(other$weldingMaterialManufacturingPlant)) {
                  Object this$weldingMaterialTrademark = this.getWeldingMaterialTrademark();
                  Object other$weldingMaterialTrademark = other.getWeldingMaterialTrademark();
                  if (this$weldingMaterialTrademark == null
                     ? other$weldingMaterialTrademark == null
                     : this$weldingMaterialTrademark.equals(other$weldingMaterialTrademark)) {
                     Object this$weldingMaterialModel = this.getWeldingMaterialModel();
                     Object other$weldingMaterialModel = other.getWeldingMaterialModel();
                     if (this$weldingMaterialModel == null ? other$weldingMaterialModel == null : this$weldingMaterialModel.equals(other$weldingMaterialModel)) {
                        Object this$weldingMaterialType = this.getWeldingMaterialType();
                        Object other$weldingMaterialType = other.getWeldingMaterialType();
                        if (this$weldingMaterialType == null ? other$weldingMaterialType == null : this$weldingMaterialType.equals(other$weldingMaterialType)) {
                           Object this$weldingMaterialDryingProcedure = this.getWeldingMaterialDryingProcedure();
                           Object other$weldingMaterialDryingProcedure = other.getWeldingMaterialDryingProcedure();
                           if (this$weldingMaterialDryingProcedure == null
                              ? other$weldingMaterialDryingProcedure == null
                              : this$weldingMaterialDryingProcedure.equals(other$weldingMaterialDryingProcedure)) {
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
      return other instanceof TechCappCraftCardStorehouseMaterialsLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
      Object $weldingMaterialName = this.getWeldingMaterialName();
      result = result * 59 + ($weldingMaterialName == null ? 43 : $weldingMaterialName.hashCode());
      Object $weldingMaterialManufacturingPlant = this.getWeldingMaterialManufacturingPlant();
      result = result * 59 + ($weldingMaterialManufacturingPlant == null ? 43 : $weldingMaterialManufacturingPlant.hashCode());
      Object $weldingMaterialTrademark = this.getWeldingMaterialTrademark();
      result = result * 59 + ($weldingMaterialTrademark == null ? 43 : $weldingMaterialTrademark.hashCode());
      Object $weldingMaterialModel = this.getWeldingMaterialModel();
      result = result * 59 + ($weldingMaterialModel == null ? 43 : $weldingMaterialModel.hashCode());
      Object $weldingMaterialType = this.getWeldingMaterialType();
      result = result * 59 + ($weldingMaterialType == null ? 43 : $weldingMaterialType.hashCode());
      Object $weldingMaterialDryingProcedure = this.getWeldingMaterialDryingProcedure();
      result = result * 59 + ($weldingMaterialDryingProcedure == null ? 43 : $weldingMaterialDryingProcedure.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechCappCraftCardStorehouseMaterialsLinkBuilder {
      private Long id;
      private String weldingMaterialName;
      private String weldingMaterialManufacturingPlant;
      private String weldingMaterialTrademark;
      private String weldingMaterialModel;
      private String weldingMaterialType;
      private String weldingMaterialDryingProcedure;
      private String remark;
      private Long techCappCraftCardStorehouseId;

      TechCappCraftCardStorehouseMaterialsLinkBuilder() {
      }

      public TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder weldingMaterialName(final String weldingMaterialName) {
         this.weldingMaterialName = weldingMaterialName;
         return this;
      }

      public TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder weldingMaterialManufacturingPlant(
         final String weldingMaterialManufacturingPlant
      ) {
         this.weldingMaterialManufacturingPlant = weldingMaterialManufacturingPlant;
         return this;
      }

      public TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder weldingMaterialTrademark(
         final String weldingMaterialTrademark
      ) {
         this.weldingMaterialTrademark = weldingMaterialTrademark;
         return this;
      }

      public TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder weldingMaterialModel(final String weldingMaterialModel) {
         this.weldingMaterialModel = weldingMaterialModel;
         return this;
      }

      public TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder weldingMaterialType(final String weldingMaterialType) {
         this.weldingMaterialType = weldingMaterialType;
         return this;
      }

      public TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder weldingMaterialDryingProcedure(
         final String weldingMaterialDryingProcedure
      ) {
         this.weldingMaterialDryingProcedure = weldingMaterialDryingProcedure;
         return this;
      }

      public TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder techCappCraftCardStorehouseId(
         final Long techCappCraftCardStorehouseId
      ) {
         this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
         return this;
      }

      public TechCappCraftCardStorehouseMaterialsLink build() {
         return new TechCappCraftCardStorehouseMaterialsLink(
            this.id,
            this.weldingMaterialName,
            this.weldingMaterialManufacturingPlant,
            this.weldingMaterialTrademark,
            this.weldingMaterialModel,
            this.weldingMaterialType,
            this.weldingMaterialDryingProcedure,
            this.remark,
            this.techCappCraftCardStorehouseId
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftCardStorehouseMaterialsLink.TechCappCraftCardStorehouseMaterialsLinkBuilder(id="
            + this.id
            + ", weldingMaterialName="
            + this.weldingMaterialName
            + ", weldingMaterialManufacturingPlant="
            + this.weldingMaterialManufacturingPlant
            + ", weldingMaterialTrademark="
            + this.weldingMaterialTrademark
            + ", weldingMaterialModel="
            + this.weldingMaterialModel
            + ", weldingMaterialType="
            + this.weldingMaterialType
            + ", weldingMaterialDryingProcedure="
            + this.weldingMaterialDryingProcedure
            + ", remark="
            + this.remark
            + ", techCappCraftCardStorehouseId="
            + this.techCappCraftCardStorehouseId
            + ")";
      }
   }
}
