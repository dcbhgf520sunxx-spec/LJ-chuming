package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.DTO;
import java.time.LocalDateTime;

public class MoveMaterialDO {
   private Long id;
   private String serialNumber;
   private DTO source;
   private DTO direction;
   private String applicantName;
   private String reviewerName;
   private LocalDateTime createTime;
   private LocalDateTime reviewTime;
   private ProjectInfo project;

   public static MoveMaterialDO.MoveMaterialDOBuilder builder() {
      return new MoveMaterialDO.MoveMaterialDOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public DTO getSource() {
      return this.source;
   }

   public DTO getDirection() {
      return this.direction;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSource(final DTO source) {
      this.source = source;
   }

   public void setDirection(final DTO direction) {
      this.direction = direction;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveMaterialDO)) {
         return false;
      }

      MoveMaterialDO other = (MoveMaterialDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$source = this.getSource();
            Object other$source = other.getSource();
            if (this$source == null ? other$source == null : this$source.equals(other$source)) {
               Object this$direction = this.getDirection();
               Object other$direction = other.getDirection();
               if (this$direction == null ? other$direction == null : this$direction.equals(other$direction)) {
                  Object this$applicantName = this.getApplicantName();
                  Object other$applicantName = other.getApplicantName();
                  if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                     Object this$reviewerName = this.getReviewerName();
                     Object other$reviewerName = other.getReviewerName();
                     if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$reviewTime = this.getReviewTime();
                           Object other$reviewTime = other.getReviewTime();
                           if (this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              return this$project == null ? other$project == null : this$project.equals(other$project);
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
      return other instanceof MoveMaterialDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $direction = this.getDirection();
      result = result * 59 + ($direction == null ? 43 : $direction.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   @Override
   public String toString() {
      return "MoveMaterialDO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", source="
         + this.getSource()
         + ", direction="
         + this.getDirection()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerName="
         + this.getReviewerName()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", project="
         + this.getProject()
         + ")";
   }

   public MoveMaterialDO(
      final Long id,
      final String serialNumber,
      final DTO source,
      final DTO direction,
      final String applicantName,
      final String reviewerName,
      final LocalDateTime createTime,
      final LocalDateTime reviewTime,
      final ProjectInfo project
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.source = source;
      this.direction = direction;
      this.applicantName = applicantName;
      this.reviewerName = reviewerName;
      this.createTime = createTime;
      this.reviewTime = reviewTime;
      this.project = project;
   }

   public MoveMaterialDO() {
   }

   public static class MoveMaterialDOBuilder {
      private Long id;
      private String serialNumber;
      private DTO source;
      private DTO direction;
      private String applicantName;
      private String reviewerName;
      private LocalDateTime createTime;
      private LocalDateTime reviewTime;
      private ProjectInfo project;

      MoveMaterialDOBuilder() {
      }

      public MoveMaterialDO.MoveMaterialDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MoveMaterialDO.MoveMaterialDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MoveMaterialDO.MoveMaterialDOBuilder source(final DTO source) {
         this.source = source;
         return this;
      }

      public MoveMaterialDO.MoveMaterialDOBuilder direction(final DTO direction) {
         this.direction = direction;
         return this;
      }

      public MoveMaterialDO.MoveMaterialDOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public MoveMaterialDO.MoveMaterialDOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public MoveMaterialDO.MoveMaterialDOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public MoveMaterialDO.MoveMaterialDOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public MoveMaterialDO.MoveMaterialDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public MoveMaterialDO build() {
         return new MoveMaterialDO(
            this.id, this.serialNumber, this.source, this.direction, this.applicantName, this.reviewerName, this.createTime, this.reviewTime, this.project
         );
      }

      @Override
      public String toString() {
         return "MoveMaterialDO.MoveMaterialDOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", source="
            + this.source
            + ", direction="
            + this.direction
            + ", applicantName="
            + this.applicantName
            + ", reviewerName="
            + this.reviewerName
            + ", createTime="
            + this.createTime
            + ", reviewTime="
            + this.reviewTime
            + ", project="
            + this.project
            + ")";
      }
   }
}
