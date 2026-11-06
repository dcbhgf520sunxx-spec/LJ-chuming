package com.hzchum.scim.cut.core.api.pojo._do;

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

@ApiModel(value = "WmsPlantPart对象", description = "")
@Entity
@TableName("wms_plant_part")
@Table(name = "wms_plant_part")
@org.hibernate.annotations.Table(appliesTo = "wms_plant_part")
public class WmsPlantPart extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "partArea", value = "零件重量g")
   @JsonProperty("partArea")
   @JSONField(name = "partArea")
   @TableField("part_area")
   @Column(name = "part_area")
   private BigDecimal partArea;
   @ApiModelProperty(name = "projectId", value = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "stockGuid", value = "柏楚排样图guid", notes = "柏楚排样图guid")
   @JsonProperty("stockGuid")
   @JSONField(name = "stockGuid")
   @TableField("stock_guid")
   @Column(name = "stock_guid", columnDefinition = "varchar(255)  COMMENT '柏楚板材guid'", nullable = true)
   private String stockGuid;
   @ApiModelProperty(name = "plateGuid", value = "板材guid", notes = "板材guid")
   @JsonProperty("plateGuid")
   @JSONField(name = "plateGuid")
   @TableField("plate_guid")
   @Column(name = "plate_guid", columnDefinition = "varchar(255)  COMMENT '板材guid'", nullable = true)
   private String plateGuid;
   @ApiModelProperty(name = "syncId", value = "板材wms物料仓id", notes = "板材wms物料仓id")
   @JsonProperty("syncId")
   @JSONField(name = "syncId")
   @TableField("sync_id")
   @Column(name = "sync_id", columnDefinition = "bigint  COMMENT '板材wms物料仓id'", nullable = true)
   private Long syncId;
   @ApiModelProperty(name = "syncVirtualId", value = "板材虚拟物料仓id", notes = "板材虚拟物料仓id")
   @JsonProperty("syncVirtualId")
   @JSONField(name = "syncId")
   @TableField("sync_virtual_id")
   @Column(name = "sync_virtual_id", columnDefinition = "varchar(255)  COMMENT '板材虚拟物料仓id'", nullable = true)
   private String syncVirtualId;
   @ApiModelProperty(name = "partGuid", value = "零件guid", notes = "零件guid")
   @JsonProperty("partGuid")
   @JSONField(name = "partGuid")
   @TableField("part_guid")
   @Column(name = "part_guid", columnDefinition = "varchar(255)  COMMENT '零件guid'", nullable = true)
   private String partGuid;
   @ApiModelProperty(name = "mete", value = "核算量(单个零件)", notes = "核算量(单个零件)")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量(单个零件)'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "quantity", value = "排样图使用零件数量", notes = "排样图使用零件数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '排样图使用零件数量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "sumMete", value = "核算量(排样图使用零件数量*核算量(单个零件))", notes = "核算量(排样图使用零件数量*核算量(单个零件))")
   @JsonProperty("sumMete")
   @JSONField(name = "sumMete")
   @TableField("sum_mete")
   @Column(name = "sum_mete", columnDefinition = "decimal(32,8)  COMMENT '核算量(排样图使用零件数量*核算量(单个零件))'", nullable = true)
   private BigDecimal sumMete;
   @ApiModelProperty(name = "thickness", value = "厚度", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = true)
   private BigDecimal thickness;

   public static WmsPlantPart.WmsPlantPartBuilder builder() {
      return new WmsPlantPart.WmsPlantPartBuilder();
   }

   public WmsPlantPart() {
   }

   public WmsPlantPart(
      final Long id,
      final BigDecimal partArea,
      final Long projectId,
      final String stockGuid,
      final String plateGuid,
      final Long syncId,
      final String syncVirtualId,
      final String partGuid,
      final BigDecimal mete,
      final BigDecimal quantity,
      final BigDecimal sumMete,
      final BigDecimal thickness
   ) {
      this.id = id;
      this.partArea = partArea;
      this.projectId = projectId;
      this.stockGuid = stockGuid;
      this.plateGuid = plateGuid;
      this.syncId = syncId;
      this.syncVirtualId = syncVirtualId;
      this.partGuid = partGuid;
      this.mete = mete;
      this.quantity = quantity;
      this.sumMete = sumMete;
      this.thickness = thickness;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getPartArea() {
      return this.partArea;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getStockGuid() {
      return this.stockGuid;
   }

   public String getPlateGuid() {
      return this.plateGuid;
   }

   public Long getSyncId() {
      return this.syncId;
   }

   public String getSyncVirtualId() {
      return this.syncVirtualId;
   }

   public String getPartGuid() {
      return this.partGuid;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getSumMete() {
      return this.sumMete;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public WmsPlantPart setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("partArea")
   public WmsPlantPart setPartArea(final BigDecimal partArea) {
      this.partArea = partArea;
      return this;
   }

   @JsonProperty("projectId")
   public WmsPlantPart setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("stockGuid")
   public WmsPlantPart setStockGuid(final String stockGuid) {
      this.stockGuid = stockGuid;
      return this;
   }

   @JsonProperty("plateGuid")
   public WmsPlantPart setPlateGuid(final String plateGuid) {
      this.plateGuid = plateGuid;
      return this;
   }

   @JsonProperty("syncId")
   public WmsPlantPart setSyncId(final Long syncId) {
      this.syncId = syncId;
      return this;
   }

   @JsonProperty("syncVirtualId")
   public WmsPlantPart setSyncVirtualId(final String syncVirtualId) {
      this.syncVirtualId = syncVirtualId;
      return this;
   }

   @JsonProperty("partGuid")
   public WmsPlantPart setPartGuid(final String partGuid) {
      this.partGuid = partGuid;
      return this;
   }

   @JsonProperty("mete")
   public WmsPlantPart setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("quantity")
   public WmsPlantPart setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("sumMete")
   public WmsPlantPart setSumMete(final BigDecimal sumMete) {
      this.sumMete = sumMete;
      return this;
   }

   @JsonProperty("thickness")
   public WmsPlantPart setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @Override
   public String toString() {
      return "WmsPlantPart(id="
         + this.getId()
         + ", partArea="
         + this.getPartArea()
         + ", projectId="
         + this.getProjectId()
         + ", stockGuid="
         + this.getStockGuid()
         + ", plateGuid="
         + this.getPlateGuid()
         + ", syncId="
         + this.getSyncId()
         + ", syncVirtualId="
         + this.getSyncVirtualId()
         + ", partGuid="
         + this.getPartGuid()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", sumMete="
         + this.getSumMete()
         + ", thickness="
         + this.getThickness()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPlantPart)) {
         return false;
      }

      WmsPlantPart other = (WmsPlantPart)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$syncId = this.getSyncId();
            Object other$syncId = other.getSyncId();
            if (this$syncId == null ? other$syncId == null : this$syncId.equals(other$syncId)) {
               Object this$partArea = this.getPartArea();
               Object other$partArea = other.getPartArea();
               if (this$partArea == null ? other$partArea == null : this$partArea.equals(other$partArea)) {
                  Object this$stockGuid = this.getStockGuid();
                  Object other$stockGuid = other.getStockGuid();
                  if (this$stockGuid == null ? other$stockGuid == null : this$stockGuid.equals(other$stockGuid)) {
                     Object this$plateGuid = this.getPlateGuid();
                     Object other$plateGuid = other.getPlateGuid();
                     if (this$plateGuid == null ? other$plateGuid == null : this$plateGuid.equals(other$plateGuid)) {
                        Object this$syncVirtualId = this.getSyncVirtualId();
                        Object other$syncVirtualId = other.getSyncVirtualId();
                        if (this$syncVirtualId == null ? other$syncVirtualId == null : this$syncVirtualId.equals(other$syncVirtualId)) {
                           Object this$partGuid = this.getPartGuid();
                           Object other$partGuid = other.getPartGuid();
                           if (this$partGuid == null ? other$partGuid == null : this$partGuid.equals(other$partGuid)) {
                              Object this$mete = this.getMete();
                              Object other$mete = other.getMete();
                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$sumMete = this.getSumMete();
                                    Object other$sumMete = other.getSumMete();
                                    if (this$sumMete == null ? other$sumMete == null : this$sumMete.equals(other$sumMete)) {
                                       Object this$thickness = this.getThickness();
                                       Object other$thickness = other.getThickness();
                                       return this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness);
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
      return other instanceof WmsPlantPart;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $syncId = this.getSyncId();
      result = result * 59 + ($syncId == null ? 43 : $syncId.hashCode());
      Object $partArea = this.getPartArea();
      result = result * 59 + ($partArea == null ? 43 : $partArea.hashCode());
      Object $stockGuid = this.getStockGuid();
      result = result * 59 + ($stockGuid == null ? 43 : $stockGuid.hashCode());
      Object $plateGuid = this.getPlateGuid();
      result = result * 59 + ($plateGuid == null ? 43 : $plateGuid.hashCode());
      Object $syncVirtualId = this.getSyncVirtualId();
      result = result * 59 + ($syncVirtualId == null ? 43 : $syncVirtualId.hashCode());
      Object $partGuid = this.getPartGuid();
      result = result * 59 + ($partGuid == null ? 43 : $partGuid.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $sumMete = this.getSumMete();
      result = result * 59 + ($sumMete == null ? 43 : $sumMete.hashCode());
      Object $thickness = this.getThickness();
      return result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
   }

   public static class WmsPlantPartBuilder {
      private Long id;
      private BigDecimal partArea;
      private Long projectId;
      private String stockGuid;
      private String plateGuid;
      private Long syncId;
      private String syncVirtualId;
      private String partGuid;
      private BigDecimal mete;
      private BigDecimal quantity;
      private BigDecimal sumMete;
      private BigDecimal thickness;

      WmsPlantPartBuilder() {
      }

      public WmsPlantPart.WmsPlantPartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("partArea")
      public WmsPlantPart.WmsPlantPartBuilder partArea(final BigDecimal partArea) {
         this.partArea = partArea;
         return this;
      }

      @JsonProperty("projectId")
      public WmsPlantPart.WmsPlantPartBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("stockGuid")
      public WmsPlantPart.WmsPlantPartBuilder stockGuid(final String stockGuid) {
         this.stockGuid = stockGuid;
         return this;
      }

      @JsonProperty("plateGuid")
      public WmsPlantPart.WmsPlantPartBuilder plateGuid(final String plateGuid) {
         this.plateGuid = plateGuid;
         return this;
      }

      @JsonProperty("syncId")
      public WmsPlantPart.WmsPlantPartBuilder syncId(final Long syncId) {
         this.syncId = syncId;
         return this;
      }

      @JsonProperty("syncVirtualId")
      public WmsPlantPart.WmsPlantPartBuilder syncVirtualId(final String syncVirtualId) {
         this.syncVirtualId = syncVirtualId;
         return this;
      }

      @JsonProperty("partGuid")
      public WmsPlantPart.WmsPlantPartBuilder partGuid(final String partGuid) {
         this.partGuid = partGuid;
         return this;
      }

      @JsonProperty("mete")
      public WmsPlantPart.WmsPlantPartBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("quantity")
      public WmsPlantPart.WmsPlantPartBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("sumMete")
      public WmsPlantPart.WmsPlantPartBuilder sumMete(final BigDecimal sumMete) {
         this.sumMete = sumMete;
         return this;
      }

      @JsonProperty("thickness")
      public WmsPlantPart.WmsPlantPartBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public WmsPlantPart build() {
         return new WmsPlantPart(
            this.id,
            this.partArea,
            this.projectId,
            this.stockGuid,
            this.plateGuid,
            this.syncId,
            this.syncVirtualId,
            this.partGuid,
            this.mete,
            this.quantity,
            this.sumMete,
            this.thickness
         );
      }

      @Override
      public String toString() {
         return "WmsPlantPart.WmsPlantPartBuilder(id="
            + this.id
            + ", partArea="
            + this.partArea
            + ", projectId="
            + this.projectId
            + ", stockGuid="
            + this.stockGuid
            + ", plateGuid="
            + this.plateGuid
            + ", syncId="
            + this.syncId
            + ", syncVirtualId="
            + this.syncVirtualId
            + ", partGuid="
            + this.partGuid
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", sumMete="
            + this.sumMete
            + ", thickness="
            + this.thickness
            + ")";
      }
   }
}
