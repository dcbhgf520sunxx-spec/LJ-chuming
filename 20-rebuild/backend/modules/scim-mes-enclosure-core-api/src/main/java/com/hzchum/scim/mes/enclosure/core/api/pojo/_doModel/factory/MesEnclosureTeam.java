package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory;

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

@ApiModel(value = "MesEnclosureTeam对象", description = "生产班组 ")
@Entity
@TableName("mes_enclosure_team")
@Table(name = "mes_enclosure_team")
public class MesEnclosureTeam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "productionLineId", notes = "产线id", value = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "hasMen", value = "是否有组员0无，1有", notes = "是否有组员0无，1有")
   @JsonProperty("hasMen")
   @JSONField(name = "hasMen")
   @TableField("has_men")
   @Column(name = "has_men", columnDefinition = "tinyint(1) default '1'  COMMENT '是否有组员0无，1有'", nullable = false)
   private Boolean hasMen;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "price", value = "工价 每米")
   @JsonProperty("price")
   @JSONField(name = "price")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '工价 每米'")
   private BigDecimal price;

   public static MesEnclosureTeam.MesEnclosureTeamBuilder builder() {
      return new MesEnclosureTeam.MesEnclosureTeamBuilder();
   }

   public MesEnclosureTeam() {
   }

   public MesEnclosureTeam(
      final Long id, final Long processId, final Long factoryId, final Long productionLineId, final Boolean hasMen, final Long userId, final BigDecimal price
   ) {
      this.id = id;
      this.processId = processId;
      this.factoryId = factoryId;
      this.productionLineId = productionLineId;
      this.hasMen = hasMen;
      this.userId = userId;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Boolean getHasMen() {
      return this.hasMen;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("id")
   public MesEnclosureTeam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureTeam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureTeam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureTeam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("hasMen")
   public MesEnclosureTeam setHasMen(final Boolean hasMen) {
      this.hasMen = hasMen;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTeam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("price")
   public MesEnclosureTeam setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTeam(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", factoryId="
         + this.getFactoryId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", hasMen="
         + this.getHasMen()
         + ", userId="
         + this.getUserId()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTeam)) {
         return false;
      }

      MesEnclosureTeam other = (MesEnclosureTeam)o;
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
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$hasMen = this.getHasMen();
                  Object other$hasMen = other.getHasMen();
                  if (this$hasMen == null ? other$hasMen == null : this$hasMen.equals(other$hasMen)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTeam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $hasMen = this.getHasMen();
      result = result * 59 + ($hasMen == null ? 43 : $hasMen.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesEnclosureTeamBuilder {
      private Long id;
      private Long processId;
      private Long factoryId;
      private Long productionLineId;
      private Boolean hasMen;
      private Long userId;
      private BigDecimal price;

      MesEnclosureTeamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTeam.MesEnclosureTeamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureTeam.MesEnclosureTeamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureTeam.MesEnclosureTeamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureTeam.MesEnclosureTeamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("hasMen")
      public MesEnclosureTeam.MesEnclosureTeamBuilder hasMen(final Boolean hasMen) {
         this.hasMen = hasMen;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTeam.MesEnclosureTeamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("price")
      public MesEnclosureTeam.MesEnclosureTeamBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesEnclosureTeam build() {
         return new MesEnclosureTeam(this.id, this.processId, this.factoryId, this.productionLineId, this.hasMen, this.userId, this.price);
      }

      @Override
      public String toString() {
         return "MesEnclosureTeam.MesEnclosureTeamBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", factoryId="
            + this.factoryId
            + ", productionLineId="
            + this.productionLineId
            + ", hasMen="
            + this.hasMen
            + ", userId="
            + this.userId
            + ", price="
            + this.price
            + ")";
      }
   }
}
