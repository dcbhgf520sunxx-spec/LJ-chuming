package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesStatisticsModeConfig对象", description = "统计模式配置表")
@Entity
@TableName("mes_statistics_mode_config")
@Table(name = "mes_statistics_mode_config")
@org.hibernate.annotations.Table(appliesTo = "mes_statistics_mode_config", comment = "统计模式配置表")
public class MesStatisticsModeConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "mode", value = "统计模式", notes = "统计模式")
   @TableField("mode")
   @Column(name = "mode", columnDefinition = "int(11)  COMMENT '统计模式'", nullable = true)
   private Integer mode;
   @ApiModelProperty(name = "deadline", value = "统计截止日期", notes = "统计截止日期")
   @TableField("deadline")
   @Column(name = "deadline", columnDefinition = "datetime  COMMENT '统计截止日期'", nullable = true)
   private LocalDateTime deadline;

   public static MesStatisticsModeConfig.MesStatisticsModeConfigBuilder builder() {
      return new MesStatisticsModeConfig.MesStatisticsModeConfigBuilder();
   }

   public MesStatisticsModeConfig() {
   }

   public MesStatisticsModeConfig(final Long id, final Integer mode, final LocalDateTime deadline) {
      this.id = id;
      this.mode = mode;
      this.deadline = deadline;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getMode() {
      return this.mode;
   }

   public LocalDateTime getDeadline() {
      return this.deadline;
   }

   public MesStatisticsModeConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesStatisticsModeConfig setMode(final Integer mode) {
      this.mode = mode;
      return this;
   }

   public MesStatisticsModeConfig setDeadline(final LocalDateTime deadline) {
      this.deadline = deadline;
      return this;
   }

   @Override
   public String toString() {
      return "MesStatisticsModeConfig(id=" + this.getId() + ", mode=" + this.getMode() + ", deadline=" + this.getDeadline() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesStatisticsModeConfig)) {
         return false;
      }

      MesStatisticsModeConfig other = (MesStatisticsModeConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$mode = this.getMode();
         Object other$mode = other.getMode();
         if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
            Object this$deadline = this.getDeadline();
            Object other$deadline = other.getDeadline();
            return this$deadline == null ? other$deadline == null : this$deadline.equals(other$deadline);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesStatisticsModeConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $deadline = this.getDeadline();
      return result * 59 + ($deadline == null ? 43 : $deadline.hashCode());
   }

   public static class MesStatisticsModeConfigBuilder {
      private Long id;
      private Integer mode;
      private LocalDateTime deadline;

      MesStatisticsModeConfigBuilder() {
      }

      public MesStatisticsModeConfig.MesStatisticsModeConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesStatisticsModeConfig.MesStatisticsModeConfigBuilder mode(final Integer mode) {
         this.mode = mode;
         return this;
      }

      public MesStatisticsModeConfig.MesStatisticsModeConfigBuilder deadline(final LocalDateTime deadline) {
         this.deadline = deadline;
         return this;
      }

      public MesStatisticsModeConfig build() {
         return new MesStatisticsModeConfig(this.id, this.mode, this.deadline);
      }

      @Override
      public String toString() {
         return "MesStatisticsModeConfig.MesStatisticsModeConfigBuilder(id=" + this.id + ", mode=" + this.mode + ", deadline=" + this.deadline + ")";
      }
   }
}
