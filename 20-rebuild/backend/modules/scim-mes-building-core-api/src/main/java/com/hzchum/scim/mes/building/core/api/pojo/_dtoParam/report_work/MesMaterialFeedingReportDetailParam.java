package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("投料填报详情新增编辑Param")
public class MesMaterialFeedingReportDetailParam {
   @ApiModelProperty("项目id")
   @NotNull(groups = {Add.class, Update.class}, message = "项目不能为空")
   private String projectId;
   @ApiModelProperty("单体id")
   @NotNull(groups = {Add.class, Update.class}, message = "单体不能为空")
   private Long monomerId;
   @ApiModelProperty("批次id")
   @NotNull(groups = {Add.class, Update.class}, message = "批次不能为空")
   private Long areaBatchId;
   @ApiModelProperty("构件类别")
   @NotBlank(groups = {Add.class, Update.class}, message = "构件类别不能为空")
   private String structureType;
   @ApiModelProperty("投料量(㎏)")
   private BigDecimal feedingQuantity;
   @ApiModelProperty("车间id")
   @NotNull(groups = {Add.class, Update.class}, message = "车间不能为空")
   private Long workshopId;

   @AssertTrue(groups = {Add.class, Update.class}, message = "投料量不能为空或0")
   public boolean isFeedingQuantityNotNullOrZero() {
      return this.feedingQuantity != null && this.feedingQuantity.compareTo(BigDecimal.ZERO) != 0;
   }

   public String getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public BigDecimal getFeedingQuantity() {
      return this.feedingQuantity;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public void setProjectId(final String projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
   }

   public void setFeedingQuantity(final BigDecimal feedingQuantity) {
      this.feedingQuantity = feedingQuantity;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesMaterialFeedingReportDetailParam)) {
         return false;
      }

      MesMaterialFeedingReportDetailParam other = (MesMaterialFeedingReportDetailParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaBatchId = this.getAreaBatchId();
         Object other$areaBatchId = other.getAreaBatchId();
         if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$structureType = this.getStructureType();
                  Object other$structureType = other.getStructureType();
                  if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
                     Object this$feedingQuantity = this.getFeedingQuantity();
                     Object other$feedingQuantity = other.getFeedingQuantity();
                     return this$feedingQuantity == null ? other$feedingQuantity == null : this$feedingQuantity.equals(other$feedingQuantity);
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
      return other instanceof MesMaterialFeedingReportDetailParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $feedingQuantity = this.getFeedingQuantity();
      return result * 59 + ($feedingQuantity == null ? 43 : $feedingQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesMaterialFeedingReportDetailParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", structureType="
         + this.getStructureType()
         + ", feedingQuantity="
         + this.getFeedingQuantity()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }
}
