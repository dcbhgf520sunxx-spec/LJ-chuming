package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingNeedMachinePartScheduling对象", description = "")
@Entity
@TableName("mes_building_need_machine_part_scheduling")
@Table(name = "mes_building_need_machine_part_scheduling")
public class MesBuildingNeedMachinePartScheduling extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "needSchedulingTime", value = "需要排产的日期", notes = "需要排产的日期")
   @JsonProperty("needSchedulingTime")
   @JSONField(name = "needSchedulingTime")
   @TableField(value = "need_scheduling_time", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "need_scheduling_time", columnDefinition = "datetime  COMMENT '开始时间'")
   private LocalDateTime needSchedulingTime;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) default '1' COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "needQuantity", value = "需要排产数量", notes = "需要排产数量")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   @TableField("need_quantity")
   @Column(name = "need_quantity", columnDefinition = "int(11) default '0' COMMENT '需要排产数量'", nullable = false)
   private Integer needQuantity;
   @ApiModelProperty(name = "schedulingQuantity", value = "已排产数量", notes = "已排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   @TableField("scheduling_quantity")
   @Column(name = "scheduling_quantity", columnDefinition = "int(11) default '0' COMMENT '已排产数量'", nullable = false)
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "useId", value = "用户id", notes = "用户id")
   @JsonProperty("useId")
   @JSONField(name = "useId")
   @TableField("use_id")
   @Column(name = "use_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = false)
   private Long useId;

   public static MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder builder() {
      return new MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder();
   }

   public MesBuildingNeedMachinePartScheduling() {
   }

   public MesBuildingNeedMachinePartScheduling(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final LocalDateTime needSchedulingTime,
      final Long productId,
      final Integer needQuantity,
      final Integer schedulingQuantity,
      final Long useId
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.needSchedulingTime = needSchedulingTime;
      this.productId = productId;
      this.needQuantity = needQuantity;
      this.schedulingQuantity = schedulingQuantity;
      this.useId = useId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public LocalDateTime getNeedSchedulingTime() {
      return this.needSchedulingTime;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Long getUseId() {
      return this.useId;
   }

   @JsonProperty("id")
   public MesBuildingNeedMachinePartScheduling setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingNeedMachinePartScheduling setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingNeedMachinePartScheduling setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingNeedMachinePartScheduling setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("needSchedulingTime")
   public MesBuildingNeedMachinePartScheduling setNeedSchedulingTime(final LocalDateTime needSchedulingTime) {
      this.needSchedulingTime = needSchedulingTime;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingNeedMachinePartScheduling setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("needQuantity")
   public MesBuildingNeedMachinePartScheduling setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingNeedMachinePartScheduling setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("useId")
   public MesBuildingNeedMachinePartScheduling setUseId(final Long useId) {
      this.useId = useId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNeedMachinePartScheduling(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", needSchedulingTime="
         + this.getNeedSchedulingTime()
         + ", productId="
         + this.getProductId()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", useId="
         + this.getUseId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNeedMachinePartScheduling)) {
         return false;
      }

      MesBuildingNeedMachinePartScheduling other = (MesBuildingNeedMachinePartScheduling)o;
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
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$needQuantity = this.getNeedQuantity();
                     Object other$needQuantity = other.getNeedQuantity();
                     if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
                        Object this$schedulingQuantity = this.getSchedulingQuantity();
                        Object other$schedulingQuantity = other.getSchedulingQuantity();
                        if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                           Object this$useId = this.getUseId();
                           Object other$useId = other.getUseId();
                           if (this$useId == null ? other$useId == null : this$useId.equals(other$useId)) {
                              Object this$needSchedulingTime = this.getNeedSchedulingTime();
                              Object other$needSchedulingTime = other.getNeedSchedulingTime();
                              return this$needSchedulingTime == null
                                 ? other$needSchedulingTime == null
                                 : this$needSchedulingTime.equals(other$needSchedulingTime);
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
      return other instanceof MesBuildingNeedMachinePartScheduling;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $useId = this.getUseId();
      result = result * 59 + ($useId == null ? 43 : $useId.hashCode());
      Object $needSchedulingTime = this.getNeedSchedulingTime();
      return result * 59 + ($needSchedulingTime == null ? 43 : $needSchedulingTime.hashCode());
   }

   public static class MesBuildingNeedMachinePartSchedulingBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private LocalDateTime needSchedulingTime;
      private Long productId;
      private Integer needQuantity;
      private Integer schedulingQuantity;
      private Long useId;

      MesBuildingNeedMachinePartSchedulingBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("needSchedulingTime")
      public MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder needSchedulingTime(final LocalDateTime needSchedulingTime) {
         this.needSchedulingTime = needSchedulingTime;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("needQuantity")
      public MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("useId")
      public MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder useId(final Long useId) {
         this.useId = useId;
         return this;
      }

      public MesBuildingNeedMachinePartScheduling build() {
         return new MesBuildingNeedMachinePartScheduling(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.needSchedulingTime,
            this.productId,
            this.needQuantity,
            this.schedulingQuantity,
            this.useId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNeedMachinePartScheduling.MesBuildingNeedMachinePartSchedulingBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", needSchedulingTime="
            + this.needSchedulingTime
            + ", productId="
            + this.productId
            + ", needQuantity="
            + this.needQuantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", useId="
            + this.useId
            + ")";
      }
   }
}
