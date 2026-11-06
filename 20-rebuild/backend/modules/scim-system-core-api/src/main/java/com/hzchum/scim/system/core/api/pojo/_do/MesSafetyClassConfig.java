package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "MesSafetyClassConfig对象", description = "安环问题配置")
@Entity
@TableName("mes_safety_class_config")
@Table(name = "mes_safety_class_config")
@org.hibernate.annotations.Table(appliesTo = "mes_safety_class_config", comment = "安环问题配置")
public class MesSafetyClassConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "质量分类名称", notes = "质量分类名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '质量分类名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "质检问题编号", notes = "质检问题编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '质检问题编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "pid", value = "父类id", notes = "父类id")
   @JsonProperty("pid")
   @JSONField(name = "pid")
   @TableField("pid")
   @Column(name = "pid", columnDefinition = "bigint(20) unsigned default '0' COMMENT '父类id'", nullable = false)
   private Long pid;
   @ApiModelProperty(name = "factoryOrConstructionSite", notes = "工厂或工地[0工厂，1工地]")
   @JsonProperty("factoryOrConstructionSite")
   @JSONField(name = "factoryOrConstructionSite")
   @TableField("factory_or_construction_site")
   @Column(name = "factory_or_construction_site", columnDefinition = "tinyint(1)  default '0' COMMENT '工厂或工地[0工厂，1工地]'")
   private Integer factoryOrConstructionSite;
   @ApiModelProperty(name = "type", value = "安环类型2 安全问题，4 环境问题", notes = "安环类型2 安全问题，4 环境问题]")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '2' COMMENT '安环类型2 安全问题，4 环境问题'")
   private Integer type;
   @ApiModelProperty(name = "behaviorScore", notes = "行为分数")
   @JsonProperty("behaviorScore")
   @JSONField(name = "behaviorScore")
   @TableField("behavior_score")
   @Column(name = "behavior_score", columnDefinition = "int(4) default'0'  COMMENT '行为分数'", nullable = false)
   private Integer behaviorScore;
   @ApiModelProperty(name = "penalty", value = "罚金", notes = "罚金")
   @JsonProperty("penalty")
   @JSONField(name = "penalty")
   @TableField("penalty")
   @Column(name = "penalty", columnDefinition = "decimal(8,2)  default '0' COMMENT '罚金'", nullable = true)
   private BigDecimal penalty;
   @ApiModelProperty(name = "status", value = "0  未启用 1 启用'", notes = "0  未启用 1 启用'")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态  0未启用 1启用'", nullable = false)
   private Boolean status;
   @ApiModelProperty(name = "boolUpdate", value = "是否可修改 0  未启用 1 启用'", notes = "0  未启用 1 启用'")
   @JsonProperty("boolUpdate")
   @JSONField(name = "boolUpdate")
   @TableField("bool_update")
   @Column(name = "bool_update", columnDefinition = "tinyint(1) default '0' COMMENT '是否可修改  0未启用 1启用'", nullable = false)
   private Boolean boolUpdate;

   public static MesSafetyClassConfig.MesSafetyClassConfigBuilder builder() {
      return new MesSafetyClassConfig.MesSafetyClassConfigBuilder();
   }

   public MesSafetyClassConfig() {
   }

   public MesSafetyClassConfig(
      final Long id,
      final String name,
      final String serialNumber,
      final Long pid,
      final Integer factoryOrConstructionSite,
      final Integer type,
      final Integer behaviorScore,
      final BigDecimal penalty,
      final Boolean status,
      final Boolean boolUpdate
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.pid = pid;
      this.factoryOrConstructionSite = factoryOrConstructionSite;
      this.type = type;
      this.behaviorScore = behaviorScore;
      this.penalty = penalty;
      this.status = status;
      this.boolUpdate = boolUpdate;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getPid() {
      return this.pid;
   }

   public Integer getFactoryOrConstructionSite() {
      return this.factoryOrConstructionSite;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getBehaviorScore() {
      return this.behaviorScore;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Boolean getBoolUpdate() {
      return this.boolUpdate;
   }

   public MesSafetyClassConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesSafetyClassConfig setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesSafetyClassConfig setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("pid")
   public MesSafetyClassConfig setPid(final Long pid) {
      this.pid = pid;
      return this;
   }

   @JsonProperty("factoryOrConstructionSite")
   public MesSafetyClassConfig setFactoryOrConstructionSite(final Integer factoryOrConstructionSite) {
      this.factoryOrConstructionSite = factoryOrConstructionSite;
      return this;
   }

   @JsonProperty("type")
   public MesSafetyClassConfig setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("behaviorScore")
   public MesSafetyClassConfig setBehaviorScore(final Integer behaviorScore) {
      this.behaviorScore = behaviorScore;
      return this;
   }

   @JsonProperty("penalty")
   public MesSafetyClassConfig setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
      return this;
   }

   @JsonProperty("status")
   public MesSafetyClassConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("boolUpdate")
   public MesSafetyClassConfig setBoolUpdate(final Boolean boolUpdate) {
      this.boolUpdate = boolUpdate;
      return this;
   }

   @Override
   public String toString() {
      return "MesSafetyClassConfig(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", pid="
         + this.getPid()
         + ", factoryOrConstructionSite="
         + this.getFactoryOrConstructionSite()
         + ", type="
         + this.getType()
         + ", behaviorScore="
         + this.getBehaviorScore()
         + ", penalty="
         + this.getPenalty()
         + ", status="
         + this.getStatus()
         + ", boolUpdate="
         + this.getBoolUpdate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSafetyClassConfig)) {
         return false;
      }

      MesSafetyClassConfig other = (MesSafetyClassConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pid = this.getPid();
         Object other$pid = other.getPid();
         if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
            Object this$factoryOrConstructionSite = this.getFactoryOrConstructionSite();
            Object other$factoryOrConstructionSite = other.getFactoryOrConstructionSite();
            if (this$factoryOrConstructionSite == null
               ? other$factoryOrConstructionSite == null
               : this$factoryOrConstructionSite.equals(other$factoryOrConstructionSite)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$behaviorScore = this.getBehaviorScore();
                  Object other$behaviorScore = other.getBehaviorScore();
                  if (this$behaviorScore == null ? other$behaviorScore == null : this$behaviorScore.equals(other$behaviorScore)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$boolUpdate = this.getBoolUpdate();
                        Object other$boolUpdate = other.getBoolUpdate();
                        if (this$boolUpdate == null ? other$boolUpdate == null : this$boolUpdate.equals(other$boolUpdate)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$penalty = this.getPenalty();
                                 Object other$penalty = other.getPenalty();
                                 return this$penalty == null ? other$penalty == null : this$penalty.equals(other$penalty);
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
      return other instanceof MesSafetyClassConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $factoryOrConstructionSite = this.getFactoryOrConstructionSite();
      result = result * 59 + ($factoryOrConstructionSite == null ? 43 : $factoryOrConstructionSite.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $behaviorScore = this.getBehaviorScore();
      result = result * 59 + ($behaviorScore == null ? 43 : $behaviorScore.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $boolUpdate = this.getBoolUpdate();
      result = result * 59 + ($boolUpdate == null ? 43 : $boolUpdate.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $penalty = this.getPenalty();
      return result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
   }

   public static class MesSafetyClassConfigBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private Long pid;
      private Integer factoryOrConstructionSite;
      private Integer type;
      private Integer behaviorScore;
      private BigDecimal penalty;
      private Boolean status;
      private Boolean boolUpdate;

      MesSafetyClassConfigBuilder() {
      }

      public MesSafetyClassConfig.MesSafetyClassConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesSafetyClassConfig.MesSafetyClassConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesSafetyClassConfig.MesSafetyClassConfigBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("pid")
      public MesSafetyClassConfig.MesSafetyClassConfigBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      @JsonProperty("factoryOrConstructionSite")
      public MesSafetyClassConfig.MesSafetyClassConfigBuilder factoryOrConstructionSite(final Integer factoryOrConstructionSite) {
         this.factoryOrConstructionSite = factoryOrConstructionSite;
         return this;
      }

      @JsonProperty("type")
      public MesSafetyClassConfig.MesSafetyClassConfigBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("behaviorScore")
      public MesSafetyClassConfig.MesSafetyClassConfigBuilder behaviorScore(final Integer behaviorScore) {
         this.behaviorScore = behaviorScore;
         return this;
      }

      @JsonProperty("penalty")
      public MesSafetyClassConfig.MesSafetyClassConfigBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      @JsonProperty("status")
      public MesSafetyClassConfig.MesSafetyClassConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("boolUpdate")
      public MesSafetyClassConfig.MesSafetyClassConfigBuilder boolUpdate(final Boolean boolUpdate) {
         this.boolUpdate = boolUpdate;
         return this;
      }

      public MesSafetyClassConfig build() {
         return new MesSafetyClassConfig(
            this.id,
            this.name,
            this.serialNumber,
            this.pid,
            this.factoryOrConstructionSite,
            this.type,
            this.behaviorScore,
            this.penalty,
            this.status,
            this.boolUpdate
         );
      }

      @Override
      public String toString() {
         return "MesSafetyClassConfig.MesSafetyClassConfigBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", pid="
            + this.pid
            + ", factoryOrConstructionSite="
            + this.factoryOrConstructionSite
            + ", type="
            + this.type
            + ", behaviorScore="
            + this.behaviorScore
            + ", penalty="
            + this.penalty
            + ", status="
            + this.status
            + ", boolUpdate="
            + this.boolUpdate
            + ")";
      }
   }
}
