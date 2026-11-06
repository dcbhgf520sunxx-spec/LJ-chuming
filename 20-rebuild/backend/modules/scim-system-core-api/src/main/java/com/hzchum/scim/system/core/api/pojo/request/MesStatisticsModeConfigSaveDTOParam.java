package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel("统计模式配置新增类")
public class MesStatisticsModeConfigSaveDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotNull(groups = Update.class, message = "统计模式不能为空")
   @EnumValidator(groups = Update.class, value = StatisticsConfigStatisticsModeEnum.class, message = "统计模式不存在")
   @ApiModelProperty(name = "mode", value = "统计模式", notes = "统计模式")
   private Integer mode;
   @ApiModelProperty(name = "deadline", value = "统计截止日期", notes = "统计截止日期")
   private LocalDateTime deadline;

   public static MesStatisticsModeConfigSaveDTOParam.MesStatisticsModeConfigSaveDTOParamBuilder builder() {
      return new MesStatisticsModeConfigSaveDTOParam.MesStatisticsModeConfigSaveDTOParamBuilder();
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMode(final Integer mode) {
      this.mode = mode;
   }

   public void setDeadline(final LocalDateTime deadline) {
      this.deadline = deadline;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesStatisticsModeConfigSaveDTOParam)) {
         return false;
      }

      MesStatisticsModeConfigSaveDTOParam other = (MesStatisticsModeConfigSaveDTOParam)o;
      if (!other.canEqual(this)) {
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesStatisticsModeConfigSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $deadline = this.getDeadline();
      return result * 59 + ($deadline == null ? 43 : $deadline.hashCode());
   }

   @Override
   public String toString() {
      return "MesStatisticsModeConfigSaveDTOParam(id=" + this.getId() + ", mode=" + this.getMode() + ", deadline=" + this.getDeadline() + ")";
   }

   public MesStatisticsModeConfigSaveDTOParam(final Long id, final Integer mode, final LocalDateTime deadline) {
      this.id = id;
      this.mode = mode;
      this.deadline = deadline;
   }

   public MesStatisticsModeConfigSaveDTOParam() {
   }

   public static class MesStatisticsModeConfigSaveDTOParamBuilder {
      private Long id;
      private Integer mode;
      private LocalDateTime deadline;

      MesStatisticsModeConfigSaveDTOParamBuilder() {
      }

      public MesStatisticsModeConfigSaveDTOParam.MesStatisticsModeConfigSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesStatisticsModeConfigSaveDTOParam.MesStatisticsModeConfigSaveDTOParamBuilder mode(final Integer mode) {
         this.mode = mode;
         return this;
      }

      public MesStatisticsModeConfigSaveDTOParam.MesStatisticsModeConfigSaveDTOParamBuilder deadline(final LocalDateTime deadline) {
         this.deadline = deadline;
         return this;
      }

      public MesStatisticsModeConfigSaveDTOParam build() {
         return new MesStatisticsModeConfigSaveDTOParam(this.id, this.mode, this.deadline);
      }

      @Override
      public String toString() {
         return "MesStatisticsModeConfigSaveDTOParam.MesStatisticsModeConfigSaveDTOParamBuilder(id="
            + this.id
            + ", mode="
            + this.mode
            + ", deadline="
            + this.deadline
            + ")";
      }
   }
}
