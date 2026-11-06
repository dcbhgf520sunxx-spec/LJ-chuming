package com.hzchum.scim.system.core.api.pojo.dto.safety.inspection;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("打卡信息DTO")
public class TaskTimeAndAttachmentDTO {
   @ApiModelProperty(name = "point", notes = "巡检人员巡检定位坐标")
   private String point;
   @ApiModelProperty(name = "inspectionTime", notes = "巡检扫码时间")
   private LocalDateTime inspectionTime;
   @ApiModelProperty(name = "inspectionAttachmentList", notes = "巡检附件")
   private List<AttachmentDTO> inspectionAttachmentList;
   @ApiModelProperty(name = "备注", notes = "备注")
   private String remark;

   public static TaskTimeAndAttachmentDTO.TaskTimeAndAttachmentDTOBuilder builder() {
      return new TaskTimeAndAttachmentDTO.TaskTimeAndAttachmentDTOBuilder();
   }

   public TaskTimeAndAttachmentDTO() {
   }

   public TaskTimeAndAttachmentDTO(
      final String point, final LocalDateTime inspectionTime, final List<AttachmentDTO> inspectionAttachmentList, final String remark
   ) {
      this.point = point;
      this.inspectionTime = inspectionTime;
      this.inspectionAttachmentList = inspectionAttachmentList;
      this.remark = remark;
   }

   public String getPoint() {
      return this.point;
   }

   public LocalDateTime getInspectionTime() {
      return this.inspectionTime;
   }

   public List<AttachmentDTO> getInspectionAttachmentList() {
      return this.inspectionAttachmentList;
   }

   public String getRemark() {
      return this.remark;
   }

   public TaskTimeAndAttachmentDTO setPoint(final String point) {
      this.point = point;
      return this;
   }

   public TaskTimeAndAttachmentDTO setInspectionTime(final LocalDateTime inspectionTime) {
      this.inspectionTime = inspectionTime;
      return this;
   }

   public TaskTimeAndAttachmentDTO setInspectionAttachmentList(final List<AttachmentDTO> inspectionAttachmentList) {
      this.inspectionAttachmentList = inspectionAttachmentList;
      return this;
   }

   public TaskTimeAndAttachmentDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "TaskTimeAndAttachmentDTO(point="
         + this.getPoint()
         + ", inspectionTime="
         + this.getInspectionTime()
         + ", inspectionAttachmentList="
         + this.getInspectionAttachmentList()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskTimeAndAttachmentDTO)) {
         return false;
      }

      TaskTimeAndAttachmentDTO other = (TaskTimeAndAttachmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$point = this.getPoint();
      Object other$point = other.getPoint();
      if (this$point == null ? other$point == null : this$point.equals(other$point)) {
         Object this$inspectionTime = this.getInspectionTime();
         Object other$inspectionTime = other.getInspectionTime();
         if (this$inspectionTime == null ? other$inspectionTime == null : this$inspectionTime.equals(other$inspectionTime)) {
            Object this$inspectionAttachmentList = this.getInspectionAttachmentList();
            Object other$inspectionAttachmentList = other.getInspectionAttachmentList();
            if (this$inspectionAttachmentList == null
               ? other$inspectionAttachmentList == null
               : this$inspectionAttachmentList.equals(other$inspectionAttachmentList)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof TaskTimeAndAttachmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $point = this.getPoint();
      result = result * 59 + ($point == null ? 43 : $point.hashCode());
      Object $inspectionTime = this.getInspectionTime();
      result = result * 59 + ($inspectionTime == null ? 43 : $inspectionTime.hashCode());
      Object $inspectionAttachmentList = this.getInspectionAttachmentList();
      result = result * 59 + ($inspectionAttachmentList == null ? 43 : $inspectionAttachmentList.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TaskTimeAndAttachmentDTOBuilder {
      private String point;
      private LocalDateTime inspectionTime;
      private List<AttachmentDTO> inspectionAttachmentList;
      private String remark;

      TaskTimeAndAttachmentDTOBuilder() {
      }

      public TaskTimeAndAttachmentDTO.TaskTimeAndAttachmentDTOBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public TaskTimeAndAttachmentDTO.TaskTimeAndAttachmentDTOBuilder inspectionTime(final LocalDateTime inspectionTime) {
         this.inspectionTime = inspectionTime;
         return this;
      }

      public TaskTimeAndAttachmentDTO.TaskTimeAndAttachmentDTOBuilder inspectionAttachmentList(final List<AttachmentDTO> inspectionAttachmentList) {
         this.inspectionAttachmentList = inspectionAttachmentList;
         return this;
      }

      public TaskTimeAndAttachmentDTO.TaskTimeAndAttachmentDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TaskTimeAndAttachmentDTO build() {
         return new TaskTimeAndAttachmentDTO(this.point, this.inspectionTime, this.inspectionAttachmentList, this.remark);
      }

      @Override
      public String toString() {
         return "TaskTimeAndAttachmentDTO.TaskTimeAndAttachmentDTOBuilder(point="
            + this.point
            + ", inspectionTime="
            + this.inspectionTime
            + ", inspectionAttachmentList="
            + this.inspectionAttachmentList
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
