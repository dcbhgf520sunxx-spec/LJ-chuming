package com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("制成品入发存查询类")
public class FinishProductWarehouseDOParam {
   @ApiModelProperty(name = "project", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(notes = "车间id")
   private Long workShopId;
   @ApiModelProperty(notes = "出入库时间")
   private LocalDateTime dateTime;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(notes = "项目ids")
   private List<Long> projectIds;
   @ApiModelProperty("类型 期初库存1 入库2 出库3 期末库存4")
   private Integer type;

   FinishProductWarehouseDOParam(
      final Long projectId, final Long workShopId, final LocalDateTime dateTime, final Integer productType, final List<Long> projectIds, final Integer type
   ) {
      this.projectId = projectId;
      this.workShopId = workShopId;
      this.dateTime = dateTime;
      this.productType = productType;
      this.projectIds = projectIds;
      this.type = type;
   }

   public static FinishProductWarehouseDOParam.FinishProductWarehouseDOParamBuilder builder() {
      return new FinishProductWarehouseDOParam.FinishProductWarehouseDOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public Integer getType() {
      return this.type;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   public void setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FinishProductWarehouseDOParam)) {
         return false;
      }

      FinishProductWarehouseDOParam other = (FinishProductWarehouseDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$dateTime = this.getDateTime();
                  Object other$dateTime = other.getDateTime();
                  if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
                     Object this$projectIds = this.getProjectIds();
                     Object other$projectIds = other.getProjectIds();
                     return this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds);
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
      return other instanceof FinishProductWarehouseDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   @Override
   public String toString() {
      return "FinishProductWarehouseDOParam(projectId="
         + this.getProjectId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", dateTime="
         + this.getDateTime()
         + ", productType="
         + this.getProductType()
         + ", projectIds="
         + this.getProjectIds()
         + ", type="
         + this.getType()
         + ")";
   }

   public static class FinishProductWarehouseDOParamBuilder {
      private Long projectId;
      private Long workShopId;
      private LocalDateTime dateTime;
      private Integer productType;
      private List<Long> projectIds;
      private Integer type;

      FinishProductWarehouseDOParamBuilder() {
      }

      public FinishProductWarehouseDOParam.FinishProductWarehouseDOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public FinishProductWarehouseDOParam.FinishProductWarehouseDOParamBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      public FinishProductWarehouseDOParam.FinishProductWarehouseDOParamBuilder dateTime(final LocalDateTime dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public FinishProductWarehouseDOParam.FinishProductWarehouseDOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public FinishProductWarehouseDOParam.FinishProductWarehouseDOParamBuilder projectIds(final List<Long> projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public FinishProductWarehouseDOParam.FinishProductWarehouseDOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public FinishProductWarehouseDOParam build() {
         return new FinishProductWarehouseDOParam(this.projectId, this.workShopId, this.dateTime, this.productType, this.projectIds, this.type);
      }

      @Override
      public String toString() {
         return "FinishProductWarehouseDOParam.FinishProductWarehouseDOParamBuilder(projectId="
            + this.projectId
            + ", workShopId="
            + this.workShopId
            + ", dateTime="
            + this.dateTime
            + ", productType="
            + this.productType
            + ", projectIds="
            + this.projectIds
            + ", type="
            + this.type
            + ")";
      }
   }
}
