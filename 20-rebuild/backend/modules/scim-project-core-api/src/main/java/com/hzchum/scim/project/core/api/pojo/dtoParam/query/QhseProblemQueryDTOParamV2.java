package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.project.core.api.enums.QhseStatusEnumV2;
import com.hzchum.scim.project.core.api.enums.QhseTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("质安问题列表查询类")
public class QhseProblemQueryDTOParamV2 {
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "boolChangeStatusV2", value = "整改状态", notes = "整改状态")
   @EnumValidator(value = QhseStatusEnumV2.class, message = "问题状态类型不正确！")
   private Integer boolChangeStatusV2;
   @ApiModelProperty(name = "isInternal", value = "true内部 false外部")
   private Boolean isInternal;
   @ApiModelProperty(name = "type", value = "问题类型", notes = "问题类型")
   @EnumValidator(value = QhseTypeEnum.class, message = "问题类型不正确！")
   private Integer type;

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBoolChangeStatusV2() {
      return this.boolChangeStatusV2;
   }

   public Boolean getIsInternal() {
      return this.isInternal;
   }

   public Integer getType() {
      return this.type;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBoolChangeStatusV2(final Integer boolChangeStatusV2) {
      this.boolChangeStatusV2 = boolChangeStatusV2;
   }

   public void setIsInternal(final Boolean isInternal) {
      this.isInternal = isInternal;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseProblemQueryDTOParamV2)) {
         return false;
      }

      QhseProblemQueryDTOParamV2 other = (QhseProblemQueryDTOParamV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$boolChangeStatusV2 = this.getBoolChangeStatusV2();
         Object other$boolChangeStatusV2 = other.getBoolChangeStatusV2();
         if (this$boolChangeStatusV2 == null ? other$boolChangeStatusV2 == null : this$boolChangeStatusV2.equals(other$boolChangeStatusV2)) {
            Object this$isInternal = this.getIsInternal();
            Object other$isInternal = other.getIsInternal();
            if (this$isInternal == null ? other$isInternal == null : this$isInternal.equals(other$isInternal)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof QhseProblemQueryDTOParamV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $boolChangeStatusV2 = this.getBoolChangeStatusV2();
      result = result * 59 + ($boolChangeStatusV2 == null ? 43 : $boolChangeStatusV2.hashCode());
      Object $isInternal = this.getIsInternal();
      result = result * 59 + ($isInternal == null ? 43 : $isInternal.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "QhseProblemQueryDTOParamV2(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", boolChangeStatusV2="
         + this.getBoolChangeStatusV2()
         + ", isInternal="
         + this.getIsInternal()
         + ", type="
         + this.getType()
         + ")";
   }
}
