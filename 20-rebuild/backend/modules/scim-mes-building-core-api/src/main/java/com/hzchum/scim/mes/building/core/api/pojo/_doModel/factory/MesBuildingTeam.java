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

@ApiModel(value = "MesBuildingTeam对象", description = "生产班组 ")
@Entity
@TableName("mes_building_team")
@Table(name = "mes_building_team")
public class MesBuildingTeam extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "organizationType", value = "班组属性 [0 编制外, 1 编制内]", notes = "班组属性 [0 编制外, 1 编制内]")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @TableField("organization_type")
   @Column(name = "organization_type", columnDefinition = "tinyint(1) default '1' COMMENT '班组属性 [0 编制外, 1 编制内]'", nullable = false)
   private Boolean organizationType;
   @ApiModelProperty(name = "hasMen", value = "是否有组员0无，1有", notes = "是否有组员0无，1有")
   @JsonProperty("hasMen")
   @JSONField(name = "hasMen")
   @TableField("has_men")
   @Column(name = "has_men", columnDefinition = "tinyint(1) default '1'  COMMENT '是否有组员0无，1有'", nullable = false)
   private Boolean hasMen;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default '1'   COMMENT '生产线类型 1传统线 2智能线'")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "teamStatus", value = "班组状态1开启 0关闭", notes = "班组状态1开启 0关闭")
   @JsonProperty("teamStatus")
   @JSONField(name = "teamStatus")
   @TableField("team_status")
   @Column(name = "team_status", columnDefinition = "tinyint(1) default '1' COMMENT '班组状态1开启 0关闭'", nullable = false)
   private Boolean teamStatus;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static MesBuildingTeam.MesBuildingTeamBuilder builder() {
      return new MesBuildingTeam.MesBuildingTeamBuilder();
   }

   public MesBuildingTeam() {
   }

   public MesBuildingTeam(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long processId,
      final Boolean organizationType,
      final Boolean hasMen,
      final Integer productionLineTypeEnum,
      final Long userId,
      final Boolean teamStatus,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.processId = processId;
      this.organizationType = organizationType;
      this.hasMen = hasMen;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.userId = userId;
      this.teamStatus = teamStatus;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   public Boolean getHasMen() {
      return this.hasMen;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Boolean getTeamStatus() {
      return this.teamStatus;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("id")
   public MesBuildingTeam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingTeam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTeam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTeam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTeam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingTeam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @JsonProperty("hasMen")
   public MesBuildingTeam setHasMen(final Boolean hasMen) {
      this.hasMen = hasMen;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTeam setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTeam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("teamStatus")
   public MesBuildingTeam setTeamStatus(final Boolean teamStatus) {
      this.teamStatus = teamStatus;
      return this;
   }

   public MesBuildingTeam setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTeam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", processId="
         + this.getProcessId()
         + ", organizationType="
         + this.getOrganizationType()
         + ", hasMen="
         + this.getHasMen()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", userId="
         + this.getUserId()
         + ", teamStatus="
         + this.getTeamStatus()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTeam)) {
         return false;
      }

      MesBuildingTeam other = (MesBuildingTeam)o;
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
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$productionLineId = this.getProductionLineId();
               Object other$productionLineId = other.getProductionLineId();
               if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$organizationType = this.getOrganizationType();
                     Object other$organizationType = other.getOrganizationType();
                     if (this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType)) {
                        Object this$hasMen = this.getHasMen();
                        Object other$hasMen = other.getHasMen();
                        if (this$hasMen == null ? other$hasMen == null : this$hasMen.equals(other$hasMen)) {
                           Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                           Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                           if (this$productionLineTypeEnum == null
                              ? other$productionLineTypeEnum == null
                              : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$teamStatus = this.getTeamStatus();
                                 Object other$teamStatus = other.getTeamStatus();
                                 if (this$teamStatus == null ? other$teamStatus == null : this$teamStatus.equals(other$teamStatus)) {
                                    Object this$mesProductEnum = this.getMesProductEnum();
                                    Object other$mesProductEnum = other.getMesProductEnum();
                                    return this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum);
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
      return other instanceof MesBuildingTeam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $hasMen = this.getHasMen();
      result = result * 59 + ($hasMen == null ? 43 : $hasMen.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $teamStatus = this.getTeamStatus();
      result = result * 59 + ($teamStatus == null ? 43 : $teamStatus.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      return result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
   }

   public static class MesBuildingTeamBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long processId;
      private Boolean organizationType;
      private Boolean hasMen;
      private Integer productionLineTypeEnum;
      private Long userId;
      private Boolean teamStatus;
      private Integer mesProductEnum;

      MesBuildingTeamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTeam.MesBuildingTeamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingTeam.MesBuildingTeamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTeam.MesBuildingTeamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTeam.MesBuildingTeamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTeam.MesBuildingTeamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingTeam.MesBuildingTeamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      @JsonProperty("hasMen")
      public MesBuildingTeam.MesBuildingTeamBuilder hasMen(final Boolean hasMen) {
         this.hasMen = hasMen;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTeam.MesBuildingTeamBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTeam.MesBuildingTeamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("teamStatus")
      public MesBuildingTeam.MesBuildingTeamBuilder teamStatus(final Boolean teamStatus) {
         this.teamStatus = teamStatus;
         return this;
      }

      public MesBuildingTeam.MesBuildingTeamBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public MesBuildingTeam build() {
         return new MesBuildingTeam(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.processId,
            this.organizationType,
            this.hasMen,
            this.productionLineTypeEnum,
            this.userId,
            this.teamStatus,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTeam.MesBuildingTeamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", processId="
            + this.processId
            + ", organizationType="
            + this.organizationType
            + ", hasMen="
            + this.hasMen
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", userId="
            + this.userId
            + ", teamStatus="
            + this.teamStatus
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
