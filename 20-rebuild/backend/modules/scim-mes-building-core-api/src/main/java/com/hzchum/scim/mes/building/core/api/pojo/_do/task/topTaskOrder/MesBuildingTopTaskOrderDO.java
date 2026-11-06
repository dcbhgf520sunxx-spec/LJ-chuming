package com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingTopTaskOrderDO", description = "")
public class MesBuildingTopTaskOrderDO {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private NameInfo area;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "totalMete", value = "总清单量", notes = "总清单量")
   @JsonProperty("totalMete")
   @JSONField(name = "totalMete")
   private QuantityAndWeightDetailDO totalMete;
   @ApiModelProperty(name = "totalCompleteMete", value = "总完成量", notes = "总完成量")
   @JsonProperty("totalCompleteMete")
   @JSONField(name = "totalCompleteMete")
   private QuantityAndWeightDetailDO totalCompleteMete;
   @ApiModelProperty(name = "totalCanAssistMete", value = "总可协同量", notes = "总可协同量")
   @JsonProperty("totalCanAssistMete")
   @JSONField(name = "totalCanAssistMete")
   private QuantityAndWeightDetailDO totalCanAssistMete;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", notes = "生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;

   public static MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder builder() {
      return new MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder();
   }

   public MesBuildingTopTaskOrderDO() {
   }

   public MesBuildingTopTaskOrderDO(
      final Long id,
      final LocalDateTime createTime,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final NameInfo area,
      final String orderNumber,
      final QuantityAndWeightDetailDO totalMete,
      final QuantityAndWeightDetailDO totalCompleteMete,
      final QuantityAndWeightDetailDO totalCanAssistMete,
      final Integer productionLineTypeEnum,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime
   ) {
      this.id = id;
      this.createTime = createTime;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.orderNumber = orderNumber;
      this.totalMete = totalMete;
      this.totalCompleteMete = totalCompleteMete;
      this.totalCanAssistMete = totalCanAssistMete;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public QuantityAndWeightDetailDO getTotalMete() {
      return this.totalMete;
   }

   public QuantityAndWeightDetailDO getTotalCompleteMete() {
      return this.totalCompleteMete;
   }

   public QuantityAndWeightDetailDO getTotalCanAssistMete() {
      return this.totalCanAssistMete;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   @JsonProperty("id")
   public MesBuildingTopTaskOrderDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("createTime")
   public MesBuildingTopTaskOrderDO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingTopTaskOrderDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingTopTaskOrderDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingTopTaskOrderDO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingTopTaskOrderDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("totalMete")
   public MesBuildingTopTaskOrderDO setTotalMete(final QuantityAndWeightDetailDO totalMete) {
      this.totalMete = totalMete;
      return this;
   }

   @JsonProperty("totalCompleteMete")
   public MesBuildingTopTaskOrderDO setTotalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
      this.totalCompleteMete = totalCompleteMete;
      return this;
   }

   @JsonProperty("totalCanAssistMete")
   public MesBuildingTopTaskOrderDO setTotalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
      this.totalCanAssistMete = totalCanAssistMete;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTopTaskOrderDO setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTopTaskOrderDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingTopTaskOrderDO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTopTaskOrderDO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", totalMete="
         + this.getTotalMete()
         + ", totalCompleteMete="
         + this.getTotalCompleteMete()
         + ", totalCanAssistMete="
         + this.getTotalCanAssistMete()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTopTaskOrderDO)) {
         return false;
      }

      MesBuildingTopTaskOrderDO other = (MesBuildingTopTaskOrderDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
         Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
         if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$area = this.getArea();
                     Object other$area = other.getArea();
                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                        Object this$orderNumber = this.getOrderNumber();
                        Object other$orderNumber = other.getOrderNumber();
                        if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                           Object this$totalMete = this.getTotalMete();
                           Object other$totalMete = other.getTotalMete();
                           if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
                              Object this$totalCompleteMete = this.getTotalCompleteMete();
                              Object other$totalCompleteMete = other.getTotalCompleteMete();
                              if (this$totalCompleteMete == null ? other$totalCompleteMete == null : this$totalCompleteMete.equals(other$totalCompleteMete)) {
                                 Object this$totalCanAssistMete = this.getTotalCanAssistMete();
                                 Object other$totalCanAssistMete = other.getTotalCanAssistMete();
                                 if (this$totalCanAssistMete == null
                                    ? other$totalCanAssistMete == null
                                    : this$totalCanAssistMete.equals(other$totalCanAssistMete)) {
                                    Object this$askCompleteTime = this.getAskCompleteTime();
                                    Object other$askCompleteTime = other.getAskCompleteTime();
                                    if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                                       Object this$completeTime = this.getCompleteTime();
                                       Object other$completeTime = other.getCompleteTime();
                                       return this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTopTaskOrderDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $totalCompleteMete = this.getTotalCompleteMete();
      result = result * 59 + ($totalCompleteMete == null ? 43 : $totalCompleteMete.hashCode());
      Object $totalCanAssistMete = this.getTotalCanAssistMete();
      result = result * 59 + ($totalCanAssistMete == null ? 43 : $totalCanAssistMete.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   public static class MesBuildingTopTaskOrderDOBuilder {
      private Long id;
      private LocalDateTime createTime;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private NameInfo area;
      private String orderNumber;
      private QuantityAndWeightDetailDO totalMete;
      private QuantityAndWeightDetailDO totalCompleteMete;
      private QuantityAndWeightDetailDO totalCanAssistMete;
      private Integer productionLineTypeEnum;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;

      MesBuildingTopTaskOrderDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("createTime")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("totalMete")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder totalMete(final QuantityAndWeightDetailDO totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      @JsonProperty("totalCompleteMete")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder totalCompleteMete(final QuantityAndWeightDetailDO totalCompleteMete) {
         this.totalCompleteMete = totalCompleteMete;
         return this;
      }

      @JsonProperty("totalCanAssistMete")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder totalCanAssistMete(final QuantityAndWeightDetailDO totalCanAssistMete) {
         this.totalCanAssistMete = totalCanAssistMete;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      public MesBuildingTopTaskOrderDO build() {
         return new MesBuildingTopTaskOrderDO(
            this.id,
            this.createTime,
            this.project,
            this.monomer,
            this.area,
            this.orderNumber,
            this.totalMete,
            this.totalCompleteMete,
            this.totalCanAssistMete,
            this.productionLineTypeEnum,
            this.askCompleteTime,
            this.completeTime
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTopTaskOrderDO.MesBuildingTopTaskOrderDOBuilder(id="
            + this.id
            + ", createTime="
            + this.createTime
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", orderNumber="
            + this.orderNumber
            + ", totalMete="
            + this.totalMete
            + ", totalCompleteMete="
            + this.totalCompleteMete
            + ", totalCanAssistMete="
            + this.totalCanAssistMete
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ")";
      }
   }
}
