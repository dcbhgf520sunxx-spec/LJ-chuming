package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MesQualityClassConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "pid", value = "父类id", notes = "父类id")
   private Long pid;
   @ApiModelProperty(name = "name", value = "质量分类名称", notes = "质量分类名称")
   @NotNull(message = "质量分类名称不能为空")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "质检问题编号", notes = "质检问题编号")
   @Pattern(regexp = "[a-zA-Z0-9]{2}", message = "质检问题编号必须为两个数字或字母")
   private String serialNumber;
   @ApiModelProperty(name = "factoryOrConstructionSite", notes = "工厂或工地[0工厂，1工地]")
   @NotNull(message = "请选择工厂或工地")
   private Integer factoryOrConstructionSite;
   @ApiModelProperty(name = "behaviorScore", notes = "行为分数")
   private Integer behaviorScore;
   @ApiModelProperty(name = "penalty", value = "罚金", notes = "罚金")
   private BigDecimal penalty;
   @ApiModelProperty(name = "status", value = "状态  0 未冻结 1 冻结", notes = "状态  0 未冻结 1 冻结")
   private Boolean status;

   public static MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder builder() {
      return new MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder();
   }

   public MesQualityClassConfigDTO() {
   }

   public MesQualityClassConfigDTO(
      final Long id,
      final Long pid,
      final String name,
      final String serialNumber,
      final Integer factoryOrConstructionSite,
      final Integer behaviorScore,
      final BigDecimal penalty,
      final Boolean status
   ) {
      this.id = id;
      this.pid = pid;
      this.name = name;
      this.serialNumber = serialNumber;
      this.factoryOrConstructionSite = factoryOrConstructionSite;
      this.behaviorScore = behaviorScore;
      this.penalty = penalty;
      this.status = status;
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

   public Integer getBehaviorScore() {
      return this.behaviorScore;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public Boolean getStatus() {
      return this.status;
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

   public void setBehaviorScore(final Integer behaviorScore) {
      this.behaviorScore = behaviorScore;
   }

   public void setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQualityClassConfigDTO)) {
         return false;
      }

      MesQualityClassConfigDTO other = (MesQualityClassConfigDTO)o;
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
               Object this$behaviorScore = this.getBehaviorScore();
               Object other$behaviorScore = other.getBehaviorScore();
               if (this$behaviorScore == null ? other$behaviorScore == null : this$behaviorScore.equals(other$behaviorScore)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesQualityClassConfigDTO;
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
      Object $behaviorScore = this.getBehaviorScore();
      result = result * 59 + ($behaviorScore == null ? 43 : $behaviorScore.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $penalty = this.getPenalty();
      return result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
   }

   @Override
   public String toString() {
      return "MesQualityClassConfigDTO(id="
         + this.getId()
         + ", pid="
         + this.getPid()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", factoryOrConstructionSite="
         + this.getFactoryOrConstructionSite()
         + ", behaviorScore="
         + this.getBehaviorScore()
         + ", penalty="
         + this.getPenalty()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class MesQualityClassConfigDTOBuilder {
      private Long id;
      private Long pid;
      private String name;
      private String serialNumber;
      private Integer factoryOrConstructionSite;
      private Integer behaviorScore;
      private BigDecimal penalty;
      private Boolean status;

      MesQualityClassConfigDTOBuilder() {
      }

      public MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder pid(final Long pid) {
         this.pid = pid;
         return this;
      }

      public MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder factoryOrConstructionSite(final Integer factoryOrConstructionSite) {
         this.factoryOrConstructionSite = factoryOrConstructionSite;
         return this;
      }

      public MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder behaviorScore(final Integer behaviorScore) {
         this.behaviorScore = behaviorScore;
         return this;
      }

      public MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      public MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesQualityClassConfigDTO build() {
         return new MesQualityClassConfigDTO(
            this.id, this.pid, this.name, this.serialNumber, this.factoryOrConstructionSite, this.behaviorScore, this.penalty, this.status
         );
      }

      @Override
      public String toString() {
         return "MesQualityClassConfigDTO.MesQualityClassConfigDTOBuilder(id="
            + this.id
            + ", pid="
            + this.pid
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", factoryOrConstructionSite="
            + this.factoryOrConstructionSite
            + ", behaviorScore="
            + this.behaviorScore
            + ", penalty="
            + this.penalty
            + ", status="
            + this.status
            + ")";
      }
   }
}
