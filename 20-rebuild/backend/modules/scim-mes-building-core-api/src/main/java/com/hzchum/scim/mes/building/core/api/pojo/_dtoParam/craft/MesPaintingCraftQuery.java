package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("涂装工艺Query")
public class MesPaintingCraftQuery {
   @ApiModelProperty("开始日期")
   private LocalDateTime startDateTime;
   @ApiModelProperty("结束日期")
   private LocalDateTime endDateTime;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("涂装类型")
   private Integer paintingTypeEnum;
   @ApiModelProperty("油漆品牌")
   private String paintBrand;
   @ApiModelProperty("项目idList")
   private List<Long> projectIdList;

   public static MesPaintingCraftQuery.MesPaintingCraftQueryBuilder builder() {
      return new MesPaintingCraftQuery.MesPaintingCraftQueryBuilder();
   }

   public LocalDateTime getStartDateTime() {
      return this.startDateTime;
   }

   public LocalDateTime getEndDateTime() {
      return this.endDateTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public String getPaintBrand() {
      return this.paintBrand;
   }

   public List<Long> getProjectIdList() {
      return this.projectIdList;
   }

   public void setStartDateTime(final LocalDateTime startDateTime) {
      this.startDateTime = startDateTime;
   }

   public void setEndDateTime(final LocalDateTime endDateTime) {
      this.endDateTime = endDateTime;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
   }

   public void setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
   }

   public void setProjectIdList(final List<Long> projectIdList) {
      this.projectIdList = projectIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintingCraftQuery)) {
         return false;
      }

      MesPaintingCraftQuery other = (MesPaintingCraftQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$paintingTypeEnum = this.getPaintingTypeEnum();
         Object other$paintingTypeEnum = other.getPaintingTypeEnum();
         if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
            Object this$startDateTime = this.getStartDateTime();
            Object other$startDateTime = other.getStartDateTime();
            if (this$startDateTime == null ? other$startDateTime == null : this$startDateTime.equals(other$startDateTime)) {
               Object this$endDateTime = this.getEndDateTime();
               Object other$endDateTime = other.getEndDateTime();
               if (this$endDateTime == null ? other$endDateTime == null : this$endDateTime.equals(other$endDateTime)) {
                  Object this$paintBrand = this.getPaintBrand();
                  Object other$paintBrand = other.getPaintBrand();
                  if (this$paintBrand == null ? other$paintBrand == null : this$paintBrand.equals(other$paintBrand)) {
                     Object this$projectIdList = this.getProjectIdList();
                     Object other$projectIdList = other.getProjectIdList();
                     return this$projectIdList == null ? other$projectIdList == null : this$projectIdList.equals(other$projectIdList);
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
      return other instanceof MesPaintingCraftQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $startDateTime = this.getStartDateTime();
      result = result * 59 + ($startDateTime == null ? 43 : $startDateTime.hashCode());
      Object $endDateTime = this.getEndDateTime();
      result = result * 59 + ($endDateTime == null ? 43 : $endDateTime.hashCode());
      Object $paintBrand = this.getPaintBrand();
      result = result * 59 + ($paintBrand == null ? 43 : $paintBrand.hashCode());
      Object $projectIdList = this.getProjectIdList();
      return result * 59 + ($projectIdList == null ? 43 : $projectIdList.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintingCraftQuery(startDateTime="
         + this.getStartDateTime()
         + ", endDateTime="
         + this.getEndDateTime()
         + ", projectId="
         + this.getProjectId()
         + ", paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", paintBrand="
         + this.getPaintBrand()
         + ", projectIdList="
         + this.getProjectIdList()
         + ")";
   }

   public MesPaintingCraftQuery() {
   }

   public MesPaintingCraftQuery(
      final LocalDateTime startDateTime,
      final LocalDateTime endDateTime,
      final Long projectId,
      final Integer paintingTypeEnum,
      final String paintBrand,
      final List<Long> projectIdList
   ) {
      this.startDateTime = startDateTime;
      this.endDateTime = endDateTime;
      this.projectId = projectId;
      this.paintingTypeEnum = paintingTypeEnum;
      this.paintBrand = paintBrand;
      this.projectIdList = projectIdList;
   }

   public static class MesPaintingCraftQueryBuilder {
      private LocalDateTime startDateTime;
      private LocalDateTime endDateTime;
      private Long projectId;
      private Integer paintingTypeEnum;
      private String paintBrand;
      private List<Long> projectIdList;

      MesPaintingCraftQueryBuilder() {
      }

      public MesPaintingCraftQuery.MesPaintingCraftQueryBuilder startDateTime(final LocalDateTime startDateTime) {
         this.startDateTime = startDateTime;
         return this;
      }

      public MesPaintingCraftQuery.MesPaintingCraftQueryBuilder endDateTime(final LocalDateTime endDateTime) {
         this.endDateTime = endDateTime;
         return this;
      }

      public MesPaintingCraftQuery.MesPaintingCraftQueryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesPaintingCraftQuery.MesPaintingCraftQueryBuilder paintingTypeEnum(final Integer paintingTypeEnum) {
         this.paintingTypeEnum = paintingTypeEnum;
         return this;
      }

      public MesPaintingCraftQuery.MesPaintingCraftQueryBuilder paintBrand(final String paintBrand) {
         this.paintBrand = paintBrand;
         return this;
      }

      public MesPaintingCraftQuery.MesPaintingCraftQueryBuilder projectIdList(final List<Long> projectIdList) {
         this.projectIdList = projectIdList;
         return this;
      }

      public MesPaintingCraftQuery build() {
         return new MesPaintingCraftQuery(this.startDateTime, this.endDateTime, this.projectId, this.paintingTypeEnum, this.paintBrand, this.projectIdList);
      }

      @Override
      public String toString() {
         return "MesPaintingCraftQuery.MesPaintingCraftQueryBuilder(startDateTime="
            + this.startDateTime
            + ", endDateTime="
            + this.endDateTime
            + ", projectId="
            + this.projectId
            + ", paintingTypeEnum="
            + this.paintingTypeEnum
            + ", paintBrand="
            + this.paintBrand
            + ", projectIdList="
            + this.projectIdList
            + ")";
      }
   }
}
