package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProjectSummaryDTO", description = "项目汇总信息 ")
public class CutTaskRequestData {
   @ApiModelProperty("工单号")
   private String code;
   @ApiModelProperty("班组名称")
   private String groupName;
   @ApiModelProperty("班组任务层级名称")
   private String groupTaskLevelName;
   @ApiModelProperty("变更的guid")
   private String guid;
   @ApiModelProperty("工单类型,1数控，2云切")
   private Long orderType;
   @ApiModelProperty("工单详情列表")
   private List<CreateDto> createDtos;
   @ApiModelProperty("设备mid")
   private String mid;
   @ApiModelProperty("车间id")
   private String workshopId;
   @ApiModelProperty("车间层级名称")
   private String workshopLevelName;
   @ApiModelProperty("项目层级名称")
   private String projectLevelName;

   public static CutTaskRequestData.CutTaskRequestDataBuilder builder() {
      return new CutTaskRequestData.CutTaskRequestDataBuilder();
   }

   public CutTaskRequestData() {
   }

   public CutTaskRequestData(
      final String code,
      final String groupName,
      final String groupTaskLevelName,
      final String guid,
      final Long orderType,
      final List<CreateDto> createDtos,
      final String mid,
      final String workshopId,
      final String workshopLevelName,
      final String projectLevelName
   ) {
      this.code = code;
      this.groupName = groupName;
      this.groupTaskLevelName = groupTaskLevelName;
      this.guid = guid;
      this.orderType = orderType;
      this.createDtos = createDtos;
      this.mid = mid;
      this.workshopId = workshopId;
      this.workshopLevelName = workshopLevelName;
      this.projectLevelName = projectLevelName;
   }

   public String getCode() {
      return this.code;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public String getGroupTaskLevelName() {
      return this.groupTaskLevelName;
   }

   public String getGuid() {
      return this.guid;
   }

   public Long getOrderType() {
      return this.orderType;
   }

   public List<CreateDto> getCreateDtos() {
      return this.createDtos;
   }

   public String getMid() {
      return this.mid;
   }

   public String getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopLevelName() {
      return this.workshopLevelName;
   }

   public String getProjectLevelName() {
      return this.projectLevelName;
   }

   public CutTaskRequestData setCode(final String code) {
      this.code = code;
      return this;
   }

   public CutTaskRequestData setGroupName(final String groupName) {
      this.groupName = groupName;
      return this;
   }

   public CutTaskRequestData setGroupTaskLevelName(final String groupTaskLevelName) {
      this.groupTaskLevelName = groupTaskLevelName;
      return this;
   }

   public CutTaskRequestData setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public CutTaskRequestData setOrderType(final Long orderType) {
      this.orderType = orderType;
      return this;
   }

   public CutTaskRequestData setCreateDtos(final List<CreateDto> createDtos) {
      this.createDtos = createDtos;
      return this;
   }

   public CutTaskRequestData setMid(final String mid) {
      this.mid = mid;
      return this;
   }

   public CutTaskRequestData setWorkshopId(final String workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public CutTaskRequestData setWorkshopLevelName(final String workshopLevelName) {
      this.workshopLevelName = workshopLevelName;
      return this;
   }

   public CutTaskRequestData setProjectLevelName(final String projectLevelName) {
      this.projectLevelName = projectLevelName;
      return this;
   }

   @Override
   public String toString() {
      return "CutTaskRequestData(code="
         + this.getCode()
         + ", groupName="
         + this.getGroupName()
         + ", groupTaskLevelName="
         + this.getGroupTaskLevelName()
         + ", guid="
         + this.getGuid()
         + ", orderType="
         + this.getOrderType()
         + ", createDtos="
         + this.getCreateDtos()
         + ", mid="
         + this.getMid()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopLevelName="
         + this.getWorkshopLevelName()
         + ", projectLevelName="
         + this.getProjectLevelName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutTaskRequestData)) {
         return false;
      }

      CutTaskRequestData other = (CutTaskRequestData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderType = this.getOrderType();
      Object other$orderType = other.getOrderType();
      if (this$orderType == null ? other$orderType == null : this$orderType.equals(other$orderType)) {
         Object this$code = this.getCode();
         Object other$code = other.getCode();
         if (this$code == null ? other$code == null : this$code.equals(other$code)) {
            Object this$groupName = this.getGroupName();
            Object other$groupName = other.getGroupName();
            if (this$groupName == null ? other$groupName == null : this$groupName.equals(other$groupName)) {
               Object this$groupTaskLevelName = this.getGroupTaskLevelName();
               Object other$groupTaskLevelName = other.getGroupTaskLevelName();
               if (this$groupTaskLevelName == null ? other$groupTaskLevelName == null : this$groupTaskLevelName.equals(other$groupTaskLevelName)) {
                  Object this$guid = this.getGuid();
                  Object other$guid = other.getGuid();
                  if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                     Object this$createDtos = this.getCreateDtos();
                     Object other$createDtos = other.getCreateDtos();
                     if (this$createDtos == null ? other$createDtos == null : this$createDtos.equals(other$createDtos)) {
                        Object this$mid = this.getMid();
                        Object other$mid = other.getMid();
                        if (this$mid == null ? other$mid == null : this$mid.equals(other$mid)) {
                           Object this$workshopId = this.getWorkshopId();
                           Object other$workshopId = other.getWorkshopId();
                           if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                              Object this$workshopLevelName = this.getWorkshopLevelName();
                              Object other$workshopLevelName = other.getWorkshopLevelName();
                              if (this$workshopLevelName == null ? other$workshopLevelName == null : this$workshopLevelName.equals(other$workshopLevelName)) {
                                 Object this$projectLevelName = this.getProjectLevelName();
                                 Object other$projectLevelName = other.getProjectLevelName();
                                 return this$projectLevelName == null ? other$projectLevelName == null : this$projectLevelName.equals(other$projectLevelName);
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
      return other instanceof CutTaskRequestData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderType = this.getOrderType();
      result = result * 59 + ($orderType == null ? 43 : $orderType.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $groupTaskLevelName = this.getGroupTaskLevelName();
      result = result * 59 + ($groupTaskLevelName == null ? 43 : $groupTaskLevelName.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $createDtos = this.getCreateDtos();
      result = result * 59 + ($createDtos == null ? 43 : $createDtos.hashCode());
      Object $mid = this.getMid();
      result = result * 59 + ($mid == null ? 43 : $mid.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $workshopLevelName = this.getWorkshopLevelName();
      result = result * 59 + ($workshopLevelName == null ? 43 : $workshopLevelName.hashCode());
      Object $projectLevelName = this.getProjectLevelName();
      return result * 59 + ($projectLevelName == null ? 43 : $projectLevelName.hashCode());
   }

   public static class CutTaskRequestDataBuilder {
      private String code;
      private String groupName;
      private String groupTaskLevelName;
      private String guid;
      private Long orderType;
      private List<CreateDto> createDtos;
      private String mid;
      private String workshopId;
      private String workshopLevelName;
      private String projectLevelName;

      CutTaskRequestDataBuilder() {
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder groupTaskLevelName(final String groupTaskLevelName) {
         this.groupTaskLevelName = groupTaskLevelName;
         return this;
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder orderType(final Long orderType) {
         this.orderType = orderType;
         return this;
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder createDtos(final List<CreateDto> createDtos) {
         this.createDtos = createDtos;
         return this;
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder mid(final String mid) {
         this.mid = mid;
         return this;
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder workshopId(final String workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder workshopLevelName(final String workshopLevelName) {
         this.workshopLevelName = workshopLevelName;
         return this;
      }

      public CutTaskRequestData.CutTaskRequestDataBuilder projectLevelName(final String projectLevelName) {
         this.projectLevelName = projectLevelName;
         return this;
      }

      public CutTaskRequestData build() {
         return new CutTaskRequestData(
            this.code,
            this.groupName,
            this.groupTaskLevelName,
            this.guid,
            this.orderType,
            this.createDtos,
            this.mid,
            this.workshopId,
            this.workshopLevelName,
            this.projectLevelName
         );
      }

      @Override
      public String toString() {
         return "CutTaskRequestData.CutTaskRequestDataBuilder(code="
            + this.code
            + ", groupName="
            + this.groupName
            + ", groupTaskLevelName="
            + this.groupTaskLevelName
            + ", guid="
            + this.guid
            + ", orderType="
            + this.orderType
            + ", createDtos="
            + this.createDtos
            + ", mid="
            + this.mid
            + ", workshopId="
            + this.workshopId
            + ", workshopLevelName="
            + this.workshopLevelName
            + ", projectLevelName="
            + this.projectLevelName
            + ")";
      }
   }
}
