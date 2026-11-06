package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MesSafetyClassConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "pid", value = "父类id", notes = "父类id")
   private Long pid;
   @ApiModelProperty(name = "name", value = "安环分类名称", notes = "安环分类名称")
   @NotNull(message = "安环分类名称不能为空")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "安环分类编号", notes = "安环分类编号")
   @Pattern(regexp = "[a-zA-Z0-9]{2}", message = "安环分类编号必须为两个数字或字母")
   private String serialNumber;
   @ApiModelProperty(name = "factoryOrConstructionSite", notes = "工厂或工地[0工厂，1工地]")
   @NotNull(message = "请选择工厂或工地")
   private Integer factoryOrConstructionSite;
   @ApiModelProperty(name = "type", value = "安环类型2 安全问题，4 环境问题", notes = "安环类型2 安全问题，4 环境问题")
   private Integer type;
   @ApiModelProperty(name = "behaviorScore", notes = "行为分数")
   private Integer behaviorScore;
   @ApiModelProperty(name = "penalty", value = "罚金", notes = "罚金")
   private BigDecimal penalty;
   @ApiModelProperty(name = "status", value = "状态  0 未冻结 1 冻结", notes = "状态  0 未冻结 1 冻结")
   private Boolean status;
   @ApiModelProperty(name = "boolUpdate", value = "是否可修改 0  未启用 1 启用'", notes = "0  未启用 1 启用'")
   @JsonProperty("boolUpdate")
   @JSONField(name = "boolUpdate")
   private Boolean boolUpdate;

   public static MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder builder() {
      return new MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder();
   }

   public MesSafetyClassConfigDTO() {
   }

   public MesSafetyClassConfigDTO(
      final Long id,
      final Long pid,
      final String name,
      final String serialNumber,
      final Integer factoryOrConstructionSite,
      final Integer type,
      final Integer behaviorScore,
      final BigDecimal penalty,
      final Boolean status,
      final Boolean boolUpdate
   ) {
      this.id = id;
      this.pid = pid;
      this.name = name;
      this.serialNumber = serialNumber;
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

   public Long getPid() {
      return this.pid;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPid(final Long pid) {
      this.pid = pid;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setFactoryOrConstructionSite(final Integer factoryOrConstructionSite) {
      this.factoryOrConstructionSite = factoryOrConstructionSite;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setBehaviorScore(final Integer behaviorScore) {
      this.behaviorScore = behaviorScore;
   }

   public void setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @JsonProperty("boolUpdate")
   public void setBoolUpdate(final Boolean boolUpdate) {
      this.boolUpdate = boolUpdate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSafetyClassConfigDTO)) {
         return false;
      }

      MesSafetyClassConfigDTO other = (MesSafetyClassConfigDTO)o;
      if (!other.canEqual(this)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesSafetyClassConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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

   @Override
   public String toString() {
      return "MesSafetyClassConfigDTO(id="
         + this.getId()
         + ", pid="
         + this.getPid()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
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

   public static class MesSafetyClassConfigDTOBuilder {
      private Long id;
      private Long pid;
      private String name;
      private String serialNumber;
      private Integer factoryOrConstructionSite;
      private Integer type;
      private Integer behaviorScore;
      private BigDecimal penalty;
      private Boolean status;
      private Boolean boolUpdate;

      MesSafetyClassConfigDTOBuilder() {
      }

      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder factoryOrConstructionSite(final Integer factoryOrConstructionSite) {
         this.factoryOrConstructionSite = factoryOrConstructionSite;
         return this;
      }

      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder behaviorScore(final Integer behaviorScore) {
         this.behaviorScore = behaviorScore;
         return this;
      }

      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("boolUpdate")
      public MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder boolUpdate(final Boolean boolUpdate) {
         this.boolUpdate = boolUpdate;
         return this;
      }

      public MesSafetyClassConfigDTO build() {
         return new MesSafetyClassConfigDTO(
            this.id,
            this.pid,
            this.name,
            this.serialNumber,
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
         return "MesSafetyClassConfigDTO.MesSafetyClassConfigDTOBuilder(id="
            + this.id
            + ", pid="
            + this.pid
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
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
