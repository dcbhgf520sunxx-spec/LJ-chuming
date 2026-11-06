package com.hzchum.scim.mes.building.core.api.pojo._doModel.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingProductProcess对象", description = "总工序表 ")
@Entity
@TableName("mes_building_product_process")
@Table(name = "mes_building_product_process")
public class MesBuildingProductProcess extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "产线id", notes = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "typeId", value = "零构部种类id", notes = "零构部种类id")
   @JsonProperty("typeId")
   @JSONField(name = "typeId")
   @TableField("type_id")
   @Column(name = "type_id", columnDefinition = "int(11)  COMMENT '类型id'", nullable = true)
   private Long typeId;
   @ApiModelProperty(name = "productType", value = "产品类型 [0 零件,1 构件,2 围护]", notes = "产品类型 [0 零件,1 构件,2 围护]")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型 [0 零件,1 构件,2 围护]'", nullable = false)
   private Integer productType;
   @ApiModelProperty("零件类型[1 板材零件 2 型材零件]")
   @JsonProperty("partType")
   @JSONField(name = "partType")
   @TableField("part_type")
   @Column(name = "part_type", columnDefinition = "int(11)  COMMENT '零件类型[1 板材零件 2 型材零件]'")
   private Integer partType;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "boolHistory", value = "是否历史数据")
   @JsonProperty("boolHistory")
   @JSONField(name = "bool_history")
   @TableField("bool_history")
   @Column(name = "bool_history", columnDefinition = "tinyint(1) default '0' COMMENT '是否历史数据 1是 0否'", nullable = false)
   private Boolean boolHistory;

   public static MesBuildingProductProcess.MesBuildingProductProcessBuilder builder() {
      return new MesBuildingProductProcess.MesBuildingProductProcessBuilder();
   }

   public MesBuildingProductProcess() {
   }

   public MesBuildingProductProcess(
      final Long id,
      final Long workshopId,
      final Long productionLineId,
      final Long typeId,
      final Integer productType,
      final Integer partType,
      final Long userId,
      final Boolean boolHistory
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.typeId = typeId;
      this.productType = productType;
      this.partType = partType;
      this.userId = userId;
      this.boolHistory = boolHistory;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTypeId() {
      return this.typeId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getPartType() {
      return this.partType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getBoolHistory() {
      return this.boolHistory;
   }

   @JsonProperty("id")
   public MesBuildingProductProcess setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingProductProcess setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingProductProcess setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("typeId")
   public MesBuildingProductProcess setTypeId(final Long typeId) {
      this.typeId = typeId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingProductProcess setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("partType")
   public MesBuildingProductProcess setPartType(final Integer partType) {
      this.partType = partType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProductProcess setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("boolHistory")
   public MesBuildingProductProcess setBoolHistory(final Boolean boolHistory) {
      this.boolHistory = boolHistory;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductProcess(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", typeId="
         + this.getTypeId()
         + ", productType="
         + this.getProductType()
         + ", partType="
         + this.getPartType()
         + ", userId="
         + this.getUserId()
         + ", boolHistory="
         + this.getBoolHistory()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductProcess)) {
         return false;
      }

      MesBuildingProductProcess other = (MesBuildingProductProcess)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$typeId = this.getTypeId();
               Object other$typeId = other.getTypeId();
               if (this$typeId == null ? other$typeId == null : this$typeId.equals(other$typeId)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$partType = this.getPartType();
                     Object other$partType = other.getPartType();
                     if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$boolHistory = this.getBoolHistory();
                           Object other$boolHistory = other.getBoolHistory();
                           return this$boolHistory == null ? other$boolHistory == null : this$boolHistory.equals(other$boolHistory);
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
      return other instanceof MesBuildingProductProcess;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $typeId = this.getTypeId();
      result = result * 59 + ($typeId == null ? 43 : $typeId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolHistory = this.getBoolHistory();
      return result * 59 + ($boolHistory == null ? 43 : $boolHistory.hashCode());
   }

   public static class MesBuildingProductProcessBuilder {
      private Long id;
      private Long workshopId;
      private Long productionLineId;
      private Long typeId;
      private Integer productType;
      private Integer partType;
      private Long userId;
      private Boolean boolHistory;

      MesBuildingProductProcessBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProductProcess.MesBuildingProductProcessBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingProductProcess.MesBuildingProductProcessBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingProductProcess.MesBuildingProductProcessBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("typeId")
      public MesBuildingProductProcess.MesBuildingProductProcessBuilder typeId(final Long typeId) {
         this.typeId = typeId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingProductProcess.MesBuildingProductProcessBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("partType")
      public MesBuildingProductProcess.MesBuildingProductProcessBuilder partType(final Integer partType) {
         this.partType = partType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProductProcess.MesBuildingProductProcessBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("boolHistory")
      public MesBuildingProductProcess.MesBuildingProductProcessBuilder boolHistory(final Boolean boolHistory) {
         this.boolHistory = boolHistory;
         return this;
      }

      public MesBuildingProductProcess build() {
         return new MesBuildingProductProcess(
            this.id, this.workshopId, this.productionLineId, this.typeId, this.productType, this.partType, this.userId, this.boolHistory
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductProcess.MesBuildingProductProcessBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", typeId="
            + this.typeId
            + ", productType="
            + this.productType
            + ", partType="
            + this.partType
            + ", userId="
            + this.userId
            + ", boolHistory="
            + this.boolHistory
            + ")";
      }
   }
}
