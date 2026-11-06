package com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("入发存报表查询")
public class WarehouseReportDetailDOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("围护产品类型")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典表id")
   private Long dictionaryId;
   @ApiModelProperty("出入库时间")
   private LocalDateTime dateTime;
   @ApiModelProperty("类型 期初库存1 入库2 出库3 期末库存4")
   private Integer type;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 10;
   @ApiModelProperty("排序")
   private List<String> sort;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("批次id")
   private Long enclosurePlanId;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("产品类型")
   private List<Integer> productTypeList;
   @ApiModelProperty("查询时间范围")
   private List<LocalDateTime> dateTimeList;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public List<String> getSort() {
      return this.sort;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<Integer> getProductTypeList() {
      return this.productTypeList;
   }

   public List<LocalDateTime> getDateTimeList() {
      return this.dateTimeList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   public void setSort(final List<String> sort) {
      this.sort = sort;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProductTypeList(final List<Integer> productTypeList) {
      this.productTypeList = productTypeList;
   }

   public void setDateTimeList(final List<LocalDateTime> dateTimeList) {
      this.dateTimeList = dateTimeList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseReportDetailDOParam)) {
         return false;
      }

      WarehouseReportDetailDOParam other = (WarehouseReportDetailDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$dictionaryId = this.getDictionaryId();
                  Object other$dictionaryId = other.getDictionaryId();
                  if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$pageNumber = this.getPageNumber();
                        Object other$pageNumber = other.getPageNumber();
                        if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                           Object this$pageSize = this.getPageSize();
                           Object other$pageSize = other.getPageSize();
                           if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                              Object this$monomerId = this.getMonomerId();
                              Object other$monomerId = other.getMonomerId();
                              if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                 Object this$areaId = this.getAreaId();
                                 Object other$areaId = other.getAreaId();
                                 if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                    Object this$enclosurePlanId = this.getEnclosurePlanId();
                                    Object other$enclosurePlanId = other.getEnclosurePlanId();
                                    if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                                       Object this$dateTime = this.getDateTime();
                                       Object other$dateTime = other.getDateTime();
                                       if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
                                          Object this$sort = this.getSort();
                                          Object other$sort = other.getSort();
                                          if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$productTypeList = this.getProductTypeList();
                                                Object other$productTypeList = other.getProductTypeList();
                                                if (this$productTypeList == null
                                                   ? other$productTypeList == null
                                                   : this$productTypeList.equals(other$productTypeList)) {
                                                   Object this$dateTimeList = this.getDateTimeList();
                                                   Object other$dateTimeList = other.getDateTimeList();
                                                   return this$dateTimeList == null ? other$dateTimeList == null : this$dateTimeList.equals(other$dateTimeList);
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
      return other instanceof WarehouseReportDetailDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $productTypeList = this.getProductTypeList();
      result = result * 59 + ($productTypeList == null ? 43 : $productTypeList.hashCode());
      Object $dateTimeList = this.getDateTimeList();
      return result * 59 + ($dateTimeList == null ? 43 : $dateTimeList.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseReportDetailDOParam(projectId="
         + this.getProjectId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", dateTime="
         + this.getDateTime()
         + ", type="
         + this.getType()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productTypeList="
         + this.getProductTypeList()
         + ", dateTimeList="
         + this.getDateTimeList()
         + ")";
   }
}
