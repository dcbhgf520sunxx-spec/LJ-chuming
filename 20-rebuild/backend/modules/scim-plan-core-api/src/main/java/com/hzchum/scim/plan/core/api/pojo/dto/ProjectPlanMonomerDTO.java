package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

@ApiModel(description = "项目计划详单体DTO")
public class ProjectPlanMonomerDTO {
   @ApiModelProperty("ID")
   private Long id;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("计划开始日期")
   private LocalDate startDate;
   @ApiModelProperty("计划完成日期")
   private LocalDate endDate;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("交货开始日期")
   private LocalDate deliveryStartDate;
   @ApiModelProperty("交货结束日期")
   private LocalDate deliveryEndDate;
   private Integer deliveryDuration;
   @ApiModelProperty("深化工期(天)")
   private Integer deepenDuration;
   @ApiModelProperty("采购工期(天)")
   private Integer purchaseDuration;
   @ApiModelProperty("加工工期(天)")
   private Integer processDuration;
   @ApiModelProperty("发运工期(天)")
   private Integer shippedDuration;
   @ApiModelProperty("安装工期(天)")
   private Integer installDuration;
   @ApiModelProperty("创建人")
   private String createUserName;
   @ApiModelProperty("区域列表")
   private List<ProjectPlanAreaDTO> areaList;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getSort() {
      return this.sort;
   }

   public LocalDate getDeliveryStartDate() {
      return this.deliveryStartDate;
   }

   public LocalDate getDeliveryEndDate() {
      return this.deliveryEndDate;
   }

   public Integer getDeliveryDuration() {
      return this.deliveryDuration;
   }

   public Integer getDeepenDuration() {
      return this.deepenDuration;
   }

   public Integer getPurchaseDuration() {
      return this.purchaseDuration;
   }

   public Integer getProcessDuration() {
      return this.processDuration;
   }

   public Integer getShippedDuration() {
      return this.shippedDuration;
   }

   public Integer getInstallDuration() {
      return this.installDuration;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public List<ProjectPlanAreaDTO> getAreaList() {
      return this.areaList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setDeliveryStartDate(final LocalDate deliveryStartDate) {
      this.deliveryStartDate = deliveryStartDate;
   }

   public void setDeliveryEndDate(final LocalDate deliveryEndDate) {
      this.deliveryEndDate = deliveryEndDate;
   }

   public void setDeliveryDuration(final Integer deliveryDuration) {
      this.deliveryDuration = deliveryDuration;
   }

   public void setDeepenDuration(final Integer deepenDuration) {
      this.deepenDuration = deepenDuration;
   }

   public void setPurchaseDuration(final Integer purchaseDuration) {
      this.purchaseDuration = purchaseDuration;
   }

   public void setProcessDuration(final Integer processDuration) {
      this.processDuration = processDuration;
   }

   public void setShippedDuration(final Integer shippedDuration) {
      this.shippedDuration = shippedDuration;
   }

   public void setInstallDuration(final Integer installDuration) {
      this.installDuration = installDuration;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setAreaList(final List<ProjectPlanAreaDTO> areaList) {
      this.areaList = areaList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPlanMonomerDTO)) {
         return false;
      }

      ProjectPlanMonomerDTO other = (ProjectPlanMonomerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$deliveryDuration = this.getDeliveryDuration();
               Object other$deliveryDuration = other.getDeliveryDuration();
               if (this$deliveryDuration == null ? other$deliveryDuration == null : this$deliveryDuration.equals(other$deliveryDuration)) {
                  Object this$deepenDuration = this.getDeepenDuration();
                  Object other$deepenDuration = other.getDeepenDuration();
                  if (this$deepenDuration == null ? other$deepenDuration == null : this$deepenDuration.equals(other$deepenDuration)) {
                     Object this$purchaseDuration = this.getPurchaseDuration();
                     Object other$purchaseDuration = other.getPurchaseDuration();
                     if (this$purchaseDuration == null ? other$purchaseDuration == null : this$purchaseDuration.equals(other$purchaseDuration)) {
                        Object this$processDuration = this.getProcessDuration();
                        Object other$processDuration = other.getProcessDuration();
                        if (this$processDuration == null ? other$processDuration == null : this$processDuration.equals(other$processDuration)) {
                           Object this$shippedDuration = this.getShippedDuration();
                           Object other$shippedDuration = other.getShippedDuration();
                           if (this$shippedDuration == null ? other$shippedDuration == null : this$shippedDuration.equals(other$shippedDuration)) {
                              Object this$installDuration = this.getInstallDuration();
                              Object other$installDuration = other.getInstallDuration();
                              if (this$installDuration == null ? other$installDuration == null : this$installDuration.equals(other$installDuration)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$startDate = this.getStartDate();
                                    Object other$startDate = other.getStartDate();
                                    if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                       Object this$endDate = this.getEndDate();
                                       Object other$endDate = other.getEndDate();
                                       if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                             Object this$deliveryStartDate = this.getDeliveryStartDate();
                                             Object other$deliveryStartDate = other.getDeliveryStartDate();
                                             if (this$deliveryStartDate == null
                                                ? other$deliveryStartDate == null
                                                : this$deliveryStartDate.equals(other$deliveryStartDate)) {
                                                Object this$deliveryEndDate = this.getDeliveryEndDate();
                                                Object other$deliveryEndDate = other.getDeliveryEndDate();
                                                if (this$deliveryEndDate == null
                                                   ? other$deliveryEndDate == null
                                                   : this$deliveryEndDate.equals(other$deliveryEndDate)) {
                                                   Object this$createUserName = this.getCreateUserName();
                                                   Object other$createUserName = other.getCreateUserName();
                                                   if (this$createUserName == null
                                                      ? other$createUserName == null
                                                      : this$createUserName.equals(other$createUserName)) {
                                                      Object this$areaList = this.getAreaList();
                                                      Object other$areaList = other.getAreaList();
                                                      return this$areaList == null ? other$areaList == null : this$areaList.equals(other$areaList);
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
      return other instanceof ProjectPlanMonomerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $deliveryDuration = this.getDeliveryDuration();
      result = result * 59 + ($deliveryDuration == null ? 43 : $deliveryDuration.hashCode());
      Object $deepenDuration = this.getDeepenDuration();
      result = result * 59 + ($deepenDuration == null ? 43 : $deepenDuration.hashCode());
      Object $purchaseDuration = this.getPurchaseDuration();
      result = result * 59 + ($purchaseDuration == null ? 43 : $purchaseDuration.hashCode());
      Object $processDuration = this.getProcessDuration();
      result = result * 59 + ($processDuration == null ? 43 : $processDuration.hashCode());
      Object $shippedDuration = this.getShippedDuration();
      result = result * 59 + ($shippedDuration == null ? 43 : $shippedDuration.hashCode());
      Object $installDuration = this.getInstallDuration();
      result = result * 59 + ($installDuration == null ? 43 : $installDuration.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $deliveryStartDate = this.getDeliveryStartDate();
      result = result * 59 + ($deliveryStartDate == null ? 43 : $deliveryStartDate.hashCode());
      Object $deliveryEndDate = this.getDeliveryEndDate();
      result = result * 59 + ($deliveryEndDate == null ? 43 : $deliveryEndDate.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $areaList = this.getAreaList();
      return result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPlanMonomerDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", name="
         + this.getName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", remark="
         + this.getRemark()
         + ", sort="
         + this.getSort()
         + ", deliveryStartDate="
         + this.getDeliveryStartDate()
         + ", deliveryEndDate="
         + this.getDeliveryEndDate()
         + ", deliveryDuration="
         + this.getDeliveryDuration()
         + ", deepenDuration="
         + this.getDeepenDuration()
         + ", purchaseDuration="
         + this.getPurchaseDuration()
         + ", processDuration="
         + this.getProcessDuration()
         + ", shippedDuration="
         + this.getShippedDuration()
         + ", installDuration="
         + this.getInstallDuration()
         + ", createUserName="
         + this.getCreateUserName()
         + ", areaList="
         + this.getAreaList()
         + ")";
   }
}
