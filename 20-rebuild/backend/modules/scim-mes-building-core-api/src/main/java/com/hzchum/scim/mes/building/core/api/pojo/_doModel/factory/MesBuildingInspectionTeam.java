package com.hzchum.scim.mes.building.core.api.pojo._doModel.factory;

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
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingInspectionTeam对象", description = "")
@Entity
@TableName("mes_building_inspection_team")
@Table(name = "mes_building_inspection_team")
public class MesBuildingInspectionTeam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11)  COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @NotNull(message = "生产线id不能为空")
   private Long productionLineId;
   @ApiModelProperty(name = "organizationType", notes = "编制属性[0 编制外,1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @NotNull(message = "编制属性不能为空")
   private Boolean organizationType;

   public static MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder builder() {
      return new MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder();
   }

   public MesBuildingInspectionTeam() {
   }

   public MesBuildingInspectionTeam(
      final Long id,
      final Long factoryId,
      final Long processId,
      final Long userId,
      final Integer productionLineTypeEnum,
      final Long productionLineId,
      final Boolean organizationType
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.processId = processId;
      this.userId = userId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.productionLineId = productionLineId;
      this.organizationType = organizationType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("id")
   public MesBuildingInspectionTeam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingInspectionTeam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingInspectionTeam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingInspectionTeam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingInspectionTeam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingInspectionTeam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingInspectionTeam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingInspectionTeam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", processId="
         + this.getProcessId()
         + ", userId="
         + this.getUserId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", organizationType="
         + this.getOrganizationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingInspectionTeam)) {
         return false;
      }

      MesBuildingInspectionTeam other = (MesBuildingInspectionTeam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                  Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                  if (this$productionLineTypeEnum == null
                     ? other$productionLineTypeEnum == null
                     : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                        Object this$organizationType = this.getOrganizationType();
                        Object other$organizationType = other.getOrganizationType();
                        return this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType);
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
      return other instanceof MesBuildingInspectionTeam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $organizationType = this.getOrganizationType();
      return result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
   }

   public static class MesBuildingInspectionTeamBuilder {
      private Long id;
      private Long factoryId;
      private Long processId;
      private Long userId;
      private Integer productionLineTypeEnum;
      private Long productionLineId;
      private Boolean organizationType;

      MesBuildingInspectionTeamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public MesBuildingInspectionTeam build() {
         return new MesBuildingInspectionTeam(
            this.id, this.factoryId, this.processId, this.userId, this.productionLineTypeEnum, this.productionLineId, this.organizationType
         );
      }

      @Override
      public String toString() {
         return "MesBuildingInspectionTeam.MesBuildingInspectionTeamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", processId="
            + this.processId
            + ", userId="
            + this.userId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", productionLineId="
            + this.productionLineId
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
