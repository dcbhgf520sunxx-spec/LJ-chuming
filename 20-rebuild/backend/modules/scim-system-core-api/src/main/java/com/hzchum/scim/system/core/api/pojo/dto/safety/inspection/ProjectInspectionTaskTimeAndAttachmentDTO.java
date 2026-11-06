package com.hzchum.scim.system.core.api.pojo.dto.safety.inspection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("人员打卡信息DTO")
public class ProjectInspectionTaskTimeAndAttachmentDTO {
   @ApiModelProperty(name = "id", notes = "点位id")
   private Long id;
   @ApiModelProperty(name = "inspectionName", notes = "点位名称")
   private String inspectionName;
   @ApiModelProperty(name = "sortNumber", notes = "点位排序")
   private Integer sortNumber;
   @ApiModelProperty(name = "point", notes = "巡检点经纬度")
   private String point;
   @ApiModelProperty(name = "aroundRadius", notes = "巡检半径(米)")
   private Long aroundRadius;
   @ApiModelProperty(name = "patrolsTime", notes = "每日巡检次数")
   private Integer patrolsTime;
   @ApiModelProperty(name = "nfcSoleId", value = "nfc唯一id", notes = "nfc唯一id")
   private String nfcSoleId;
   @ApiModelProperty(name = "taskTimeAndAttachmentList", notes = "巡检记录信息")
   private List<TaskTimeAndAttachmentDTO> taskTimeAndAttachmentList;

   public static ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder builder() {
      return new ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder();
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO() {
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO(
      final Long id,
      final String inspectionName,
      final Integer sortNumber,
      final String point,
      final Long aroundRadius,
      final Integer patrolsTime,
      final String nfcSoleId,
      final List<TaskTimeAndAttachmentDTO> taskTimeAndAttachmentList
   ) {
      this.id = id;
      this.inspectionName = inspectionName;
      this.sortNumber = sortNumber;
      this.point = point;
      this.aroundRadius = aroundRadius;
      this.patrolsTime = patrolsTime;
      this.nfcSoleId = nfcSoleId;
      this.taskTimeAndAttachmentList = taskTimeAndAttachmentList;
   }

   public Long getId() {
      return this.id;
   }

   public String getInspectionName() {
      return this.inspectionName;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public String getPoint() {
      return this.point;
   }

   public Long getAroundRadius() {
      return this.aroundRadius;
   }

   public Integer getPatrolsTime() {
      return this.patrolsTime;
   }

   public String getNfcSoleId() {
      return this.nfcSoleId;
   }

   public List<TaskTimeAndAttachmentDTO> getTaskTimeAndAttachmentList() {
      return this.taskTimeAndAttachmentList;
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO setInspectionName(final String inspectionName) {
      this.inspectionName = inspectionName;
      return this;
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
      return this;
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO setPoint(final String point) {
      this.point = point;
      return this;
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO setAroundRadius(final Long aroundRadius) {
      this.aroundRadius = aroundRadius;
      return this;
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO setPatrolsTime(final Integer patrolsTime) {
      this.patrolsTime = patrolsTime;
      return this;
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO setNfcSoleId(final String nfcSoleId) {
      this.nfcSoleId = nfcSoleId;
      return this;
   }

   public ProjectInspectionTaskTimeAndAttachmentDTO setTaskTimeAndAttachmentList(final List<TaskTimeAndAttachmentDTO> taskTimeAndAttachmentList) {
      this.taskTimeAndAttachmentList = taskTimeAndAttachmentList;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectInspectionTaskTimeAndAttachmentDTO(id="
         + this.getId()
         + ", inspectionName="
         + this.getInspectionName()
         + ", sortNumber="
         + this.getSortNumber()
         + ", point="
         + this.getPoint()
         + ", aroundRadius="
         + this.getAroundRadius()
         + ", patrolsTime="
         + this.getPatrolsTime()
         + ", nfcSoleId="
         + this.getNfcSoleId()
         + ", taskTimeAndAttachmentList="
         + this.getTaskTimeAndAttachmentList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInspectionTaskTimeAndAttachmentDTO)) {
         return false;
      }

      ProjectInspectionTaskTimeAndAttachmentDTO other = (ProjectInspectionTaskTimeAndAttachmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sortNumber = this.getSortNumber();
         Object other$sortNumber = other.getSortNumber();
         if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
            Object this$aroundRadius = this.getAroundRadius();
            Object other$aroundRadius = other.getAroundRadius();
            if (this$aroundRadius == null ? other$aroundRadius == null : this$aroundRadius.equals(other$aroundRadius)) {
               Object this$patrolsTime = this.getPatrolsTime();
               Object other$patrolsTime = other.getPatrolsTime();
               if (this$patrolsTime == null ? other$patrolsTime == null : this$patrolsTime.equals(other$patrolsTime)) {
                  Object this$inspectionName = this.getInspectionName();
                  Object other$inspectionName = other.getInspectionName();
                  if (this$inspectionName == null ? other$inspectionName == null : this$inspectionName.equals(other$inspectionName)) {
                     Object this$point = this.getPoint();
                     Object other$point = other.getPoint();
                     if (this$point == null ? other$point == null : this$point.equals(other$point)) {
                        Object this$nfcSoleId = this.getNfcSoleId();
                        Object other$nfcSoleId = other.getNfcSoleId();
                        if (this$nfcSoleId == null ? other$nfcSoleId == null : this$nfcSoleId.equals(other$nfcSoleId)) {
                           Object this$taskTimeAndAttachmentList = this.getTaskTimeAndAttachmentList();
                           Object other$taskTimeAndAttachmentList = other.getTaskTimeAndAttachmentList();
                           return this$taskTimeAndAttachmentList == null
                              ? other$taskTimeAndAttachmentList == null
                              : this$taskTimeAndAttachmentList.equals(other$taskTimeAndAttachmentList);
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
      return other instanceof ProjectInspectionTaskTimeAndAttachmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $aroundRadius = this.getAroundRadius();
      result = result * 59 + ($aroundRadius == null ? 43 : $aroundRadius.hashCode());
      Object $patrolsTime = this.getPatrolsTime();
      result = result * 59 + ($patrolsTime == null ? 43 : $patrolsTime.hashCode());
      Object $inspectionName = this.getInspectionName();
      result = result * 59 + ($inspectionName == null ? 43 : $inspectionName.hashCode());
      Object $point = this.getPoint();
      result = result * 59 + ($point == null ? 43 : $point.hashCode());
      Object $nfcSoleId = this.getNfcSoleId();
      result = result * 59 + ($nfcSoleId == null ? 43 : $nfcSoleId.hashCode());
      Object $taskTimeAndAttachmentList = this.getTaskTimeAndAttachmentList();
      return result * 59 + ($taskTimeAndAttachmentList == null ? 43 : $taskTimeAndAttachmentList.hashCode());
   }

   public static class ProjectInspectionTaskTimeAndAttachmentDTOBuilder {
      private Long id;
      private String inspectionName;
      private Integer sortNumber;
      private String point;
      private Long aroundRadius;
      private Integer patrolsTime;
      private String nfcSoleId;
      private List<TaskTimeAndAttachmentDTO> taskTimeAndAttachmentList;

      ProjectInspectionTaskTimeAndAttachmentDTOBuilder() {
      }

      public ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder inspectionName(final String inspectionName) {
         this.inspectionName = inspectionName;
         return this;
      }

      public ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder point(final String point) {
         this.point = point;
         return this;
      }

      public ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder aroundRadius(final Long aroundRadius) {
         this.aroundRadius = aroundRadius;
         return this;
      }

      public ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder patrolsTime(final Integer patrolsTime) {
         this.patrolsTime = patrolsTime;
         return this;
      }

      public ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder nfcSoleId(final String nfcSoleId) {
         this.nfcSoleId = nfcSoleId;
         return this;
      }

      public ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder taskTimeAndAttachmentList(
         final List<TaskTimeAndAttachmentDTO> taskTimeAndAttachmentList
      ) {
         this.taskTimeAndAttachmentList = taskTimeAndAttachmentList;
         return this;
      }

      public ProjectInspectionTaskTimeAndAttachmentDTO build() {
         return new ProjectInspectionTaskTimeAndAttachmentDTO(
            this.id, this.inspectionName, this.sortNumber, this.point, this.aroundRadius, this.patrolsTime, this.nfcSoleId, this.taskTimeAndAttachmentList
         );
      }

      @Override
      public String toString() {
         return "ProjectInspectionTaskTimeAndAttachmentDTO.ProjectInspectionTaskTimeAndAttachmentDTOBuilder(id="
            + this.id
            + ", inspectionName="
            + this.inspectionName
            + ", sortNumber="
            + this.sortNumber
            + ", point="
            + this.point
            + ", aroundRadius="
            + this.aroundRadius
            + ", patrolsTime="
            + this.patrolsTime
            + ", nfcSoleId="
            + this.nfcSoleId
            + ", taskTimeAndAttachmentList="
            + this.taskTimeAndAttachmentList
            + ")";
      }
   }
}
