package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "VirtualWarehouse对象", description = "虚拟仓库 ")
@Entity
@TableName("wms_virtual_warehouse")
@Table(name = "wms_virtual_warehouse")
public class VirtualWarehouse extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "outboundId", value = "出库单ID", notes = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint(20)  COMMENT '出库单ID'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "returnDetailId", value = "退库单详情ID", notes = "退库单详情ID")
   @JsonProperty("returnDetailId")
   @JSONField(name = "returnDetailId")
   @TableField("return_detail_id")
   @Column(name = "return_detail_id", columnDefinition = "bigint(20)  COMMENT '退库单详情ID'", nullable = true)
   private Long returnDetailId;
   @ApiModelProperty(name = "materialId", value = "物料仓ID", notes = "物料仓ID")
   @JsonProperty("materialId")
   @JSONField(name = "materialId")
   @TableField("material_id")
   @Column(name = "material_id", columnDefinition = "bigint(20)  COMMENT '物料仓ID'", nullable = true)
   private Long materialId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete", columnDefinition = "decimal(32,8)  COMMENT '核算量'", nullable = true)
   private BigDecimal mete;
   @ApiModelProperty(name = "quantity", value = "计量量", notes = "计量量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(32,8)  COMMENT '计量量'", nullable = true)
   private BigDecimal quantity;
   @ApiModelProperty(name = "length", value = "长", notes = "长")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽", notes = "宽")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,8)  COMMENT '宽'", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "factoryId", value = "工厂ID", notes = "工厂ID")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂ID'", nullable = true)
   private Long factoryId;
   @ApiModelProperty(name = "warehouseId", value = "仓库ID", notes = "仓库ID")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint(20)  COMMENT '仓库ID'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "recipientId", value = "领用人ID", notes = "领用人ID")
   @JsonProperty("recipientId")
   @JSONField(name = "recipientId")
   @TableField("recipient_id")
   @Column(name = "recipient_id", columnDefinition = "bigint(20)  COMMENT '领用人ID'", nullable = true)
   private Long recipientId;
   @ApiModelProperty(name = "recipientName", value = "领用人名称", notes = "领用人名称")
   @JsonProperty("recipientName")
   @JSONField(name = "recipientName")
   @TableField("recipient_name")
   @Column(name = "recipient_name", columnDefinition = "varchar(255)  COMMENT '领用人名称'", nullable = true)
   private String recipientName;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "boolOutbound", value = "是否出库", notes = "是否出库")
   @JsonProperty("boolOutbound")
   @JSONField(name = "boolOutbound")
   @TableField("bool_outbound")
   @Column(name = "bool_outbound", columnDefinition = "tinyint(1) default '0' COMMENT '是否出库'", nullable = true)
   private Boolean boolOutbound;

   public static VirtualWarehouse.VirtualWarehouseBuilder builder() {
      return new VirtualWarehouse.VirtualWarehouseBuilder();
   }

   public VirtualWarehouse() {
   }

   public VirtualWarehouse(
      final Long id,
      final Long outboundId,
      final Long returnDetailId,
      final Long materialId,
      final Long projectId,
      final BigDecimal mete,
      final BigDecimal quantity,
      final BigDecimal length,
      final BigDecimal width,
      final Long monomerId,
      final Long areaId,
      final Long factoryId,
      final Long warehouseId,
      final Long recipientId,
      final String recipientName,
      final Long workshopId,
      final Boolean boolOutbound
   ) {
      this.id = id;
      this.outboundId = outboundId;
      this.returnDetailId = returnDetailId;
      this.materialId = materialId;
      this.projectId = projectId;
      this.mete = mete;
      this.quantity = quantity;
      this.length = length;
      this.width = width;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.factoryId = factoryId;
      this.warehouseId = warehouseId;
      this.recipientId = recipientId;
      this.recipientName = recipientName;
      this.workshopId = workshopId;
      this.boolOutbound = boolOutbound;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public Long getReturnDetailId() {
      return this.returnDetailId;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getRecipientId() {
      return this.recipientId;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Boolean getBoolOutbound() {
      return this.boolOutbound;
   }

   @JsonProperty("id")
   public VirtualWarehouse setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("outboundId")
   public VirtualWarehouse setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("returnDetailId")
   public VirtualWarehouse setReturnDetailId(final Long returnDetailId) {
      this.returnDetailId = returnDetailId;
      return this;
   }

   @JsonProperty("materialId")
   public VirtualWarehouse setMaterialId(final Long materialId) {
      this.materialId = materialId;
      return this;
   }

   @JsonProperty("projectId")
   public VirtualWarehouse setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("mete")
   public VirtualWarehouse setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("quantity")
   public VirtualWarehouse setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public VirtualWarehouse setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public VirtualWarehouse setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("monomerId")
   public VirtualWarehouse setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public VirtualWarehouse setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("factoryId")
   public VirtualWarehouse setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("warehouseId")
   public VirtualWarehouse setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("recipientId")
   public VirtualWarehouse setRecipientId(final Long recipientId) {
      this.recipientId = recipientId;
      return this;
   }

   @JsonProperty("recipientName")
   public VirtualWarehouse setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
      return this;
   }

   @JsonProperty("workshopId")
   public VirtualWarehouse setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("boolOutbound")
   public VirtualWarehouse setBoolOutbound(final Boolean boolOutbound) {
      this.boolOutbound = boolOutbound;
      return this;
   }

   @Override
   public String toString() {
      return "VirtualWarehouse(id="
         + this.getId()
         + ", outboundId="
         + this.getOutboundId()
         + ", returnDetailId="
         + this.getReturnDetailId()
         + ", materialId="
         + this.getMaterialId()
         + ", projectId="
         + this.getProjectId()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", factoryId="
         + this.getFactoryId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", recipientId="
         + this.getRecipientId()
         + ", recipientName="
         + this.getRecipientName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", boolOutbound="
         + this.getBoolOutbound()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof VirtualWarehouse)) {
         return false;
      }

      VirtualWarehouse other = (VirtualWarehouse)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$outboundId = this.getOutboundId();
         Object other$outboundId = other.getOutboundId();
         if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
            Object this$returnDetailId = this.getReturnDetailId();
            Object other$returnDetailId = other.getReturnDetailId();
            if (this$returnDetailId == null ? other$returnDetailId == null : this$returnDetailId.equals(other$returnDetailId)) {
               Object this$materialId = this.getMaterialId();
               Object other$materialId = other.getMaterialId();
               if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$factoryId = this.getFactoryId();
                           Object other$factoryId = other.getFactoryId();
                           if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                              Object this$warehouseId = this.getWarehouseId();
                              Object other$warehouseId = other.getWarehouseId();
                              if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                 Object this$recipientId = this.getRecipientId();
                                 Object other$recipientId = other.getRecipientId();
                                 if (this$recipientId == null ? other$recipientId == null : this$recipientId.equals(other$recipientId)) {
                                    Object this$workshopId = this.getWorkshopId();
                                    Object other$workshopId = other.getWorkshopId();
                                    if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                       Object this$boolOutbound = this.getBoolOutbound();
                                       Object other$boolOutbound = other.getBoolOutbound();
                                       if (this$boolOutbound == null ? other$boolOutbound == null : this$boolOutbound.equals(other$boolOutbound)) {
                                          Object this$mete = this.getMete();
                                          Object other$mete = other.getMete();
                                          if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                             Object this$quantity = this.getQuantity();
                                             Object other$quantity = other.getQuantity();
                                             if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                Object this$length = this.getLength();
                                                Object other$length = other.getLength();
                                                if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                   Object this$width = this.getWidth();
                                                   Object other$width = other.getWidth();
                                                   if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                      Object this$recipientName = this.getRecipientName();
                                                      Object other$recipientName = other.getRecipientName();
                                                      return this$recipientName == null
                                                         ? other$recipientName == null
                                                         : this$recipientName.equals(other$recipientName);
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
      return other instanceof VirtualWarehouse;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $returnDetailId = this.getReturnDetailId();
      result = result * 59 + ($returnDetailId == null ? 43 : $returnDetailId.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $recipientId = this.getRecipientId();
      result = result * 59 + ($recipientId == null ? 43 : $recipientId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $boolOutbound = this.getBoolOutbound();
      result = result * 59 + ($boolOutbound == null ? 43 : $boolOutbound.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $recipientName = this.getRecipientName();
      return result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
   }

   public static class VirtualWarehouseBuilder {
      private Long id;
      private Long outboundId;
      private Long returnDetailId;
      private Long materialId;
      private Long projectId;
      private BigDecimal mete;
      private BigDecimal quantity;
      private BigDecimal length;
      private BigDecimal width;
      private Long monomerId;
      private Long areaId;
      private Long factoryId;
      private Long warehouseId;
      private Long recipientId;
      private String recipientName;
      private Long workshopId;
      private Boolean boolOutbound;

      VirtualWarehouseBuilder() {
      }

      @JsonProperty("id")
      public VirtualWarehouse.VirtualWarehouseBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("outboundId")
      public VirtualWarehouse.VirtualWarehouseBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("returnDetailId")
      public VirtualWarehouse.VirtualWarehouseBuilder returnDetailId(final Long returnDetailId) {
         this.returnDetailId = returnDetailId;
         return this;
      }

      @JsonProperty("materialId")
      public VirtualWarehouse.VirtualWarehouseBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      @JsonProperty("projectId")
      public VirtualWarehouse.VirtualWarehouseBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("mete")
      public VirtualWarehouse.VirtualWarehouseBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("quantity")
      public VirtualWarehouse.VirtualWarehouseBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public VirtualWarehouse.VirtualWarehouseBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public VirtualWarehouse.VirtualWarehouseBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("monomerId")
      public VirtualWarehouse.VirtualWarehouseBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public VirtualWarehouse.VirtualWarehouseBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("factoryId")
      public VirtualWarehouse.VirtualWarehouseBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("warehouseId")
      public VirtualWarehouse.VirtualWarehouseBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("recipientId")
      public VirtualWarehouse.VirtualWarehouseBuilder recipientId(final Long recipientId) {
         this.recipientId = recipientId;
         return this;
      }

      @JsonProperty("recipientName")
      public VirtualWarehouse.VirtualWarehouseBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      @JsonProperty("workshopId")
      public VirtualWarehouse.VirtualWarehouseBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("boolOutbound")
      public VirtualWarehouse.VirtualWarehouseBuilder boolOutbound(final Boolean boolOutbound) {
         this.boolOutbound = boolOutbound;
         return this;
      }

      public VirtualWarehouse build() {
         return new VirtualWarehouse(
            this.id,
            this.outboundId,
            this.returnDetailId,
            this.materialId,
            this.projectId,
            this.mete,
            this.quantity,
            this.length,
            this.width,
            this.monomerId,
            this.areaId,
            this.factoryId,
            this.warehouseId,
            this.recipientId,
            this.recipientName,
            this.workshopId,
            this.boolOutbound
         );
      }

      @Override
      public String toString() {
         return "VirtualWarehouse.VirtualWarehouseBuilder(id="
            + this.id
            + ", outboundId="
            + this.outboundId
            + ", returnDetailId="
            + this.returnDetailId
            + ", materialId="
            + this.materialId
            + ", projectId="
            + this.projectId
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", factoryId="
            + this.factoryId
            + ", warehouseId="
            + this.warehouseId
            + ", recipientId="
            + this.recipientId
            + ", recipientName="
            + this.recipientName
            + ", workshopId="
            + this.workshopId
            + ", boolOutbound="
            + this.boolOutbound
            + ")";
      }
   }
}
