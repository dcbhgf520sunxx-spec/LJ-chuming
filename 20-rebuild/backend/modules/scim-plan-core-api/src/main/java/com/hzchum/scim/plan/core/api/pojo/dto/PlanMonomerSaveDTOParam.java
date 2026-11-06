package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("新增单体 请求类")
public class PlanMonomerSaveDTOParam {
   @ApiModelProperty(name = "id", notes = "单体id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "单体名字")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "startDate", notes = "计划开始日期")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "计划结束日期", notes = "计划结束日期")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   private LocalDate endDate;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "deepenStartDate", value = "深化开始日期", notes = "深化开始日期")
   @JsonProperty("deepenStartDate")
   @JSONField(name = "deepenStartDate")
   private LocalDate deepenStartDate;
   @ApiModelProperty(name = "deepenEndDate", value = "深化结束日期", notes = "深化结束日期")
   @JsonProperty("deepenEndDate")
   @JSONField(name = "deepenEndDate")
   private LocalDate deepenEndDate;
   @ApiModelProperty(name = "purchaseStartDate", value = "采购开始日期", notes = "采购开始日期")
   @JsonProperty("purchaseStartDate")
   @JSONField(name = "purchaseStartDate")
   private LocalDate purchaseStartDate;
   @ApiModelProperty(name = "purchaseEndDate", value = "采购结束日期", notes = "采购结束日期")
   @JsonProperty("purchaseEndDate")
   @JSONField(name = "purchaseEndDate")
   private LocalDate purchaseEndDate;
   @ApiModelProperty(name = "processStartDate", value = "加工开始日期", notes = "加工开始日期")
   @JsonProperty("processStartDate")
   @JSONField(name = "processStartDate")
   private LocalDate processStartDate;
   @ApiModelProperty(name = "processEndDate", value = "加工结束日期", notes = "加工结束日期")
   @JsonProperty("processEndDate")
   @JSONField(name = "processEndDate")
   private LocalDate processEndDate;
   @ApiModelProperty(name = "despatchStartDate", value = "发运开始时间", notes = "发运开始时间")
   @JsonProperty("despatchStartDate")
   @JSONField(name = "despatchStartDate")
   private LocalDate despatchStartDate;
   @ApiModelProperty(name = "despatchEndDate", value = "发运结束时间", notes = "发运结束时间")
   @JsonProperty("despatchEndDate")
   @JSONField(name = "despatchEndDate")
   private LocalDate despatchEndDate;
   @ApiModelProperty(name = "installStartDate", value = "安装开始日期", notes = "安装开始日期")
   @JsonProperty("installStartDate")
   @JSONField(name = "installStartDate")
   private LocalDate installStartDate;
   @ApiModelProperty(name = "installEndDate", value = "安装结束日期", notes = "安装结束日期")
   @JsonProperty("installEndDate")
   @JSONField(name = "installEndDate")
   private LocalDate installEndDate;
   @ApiModelProperty(name = "mete", value = "工程量", notes = "工程量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "lumpSumSystemType", notes = "包干制项目管理选项 参考枚举：LumpSumSystemEnum 1.无管控，需加工 2.无管控，无加工 3.需加工，需管控 4.需加工，无需管控")
   @JsonProperty("lumpSumSystemType")
   @JSONField(name = "lumpSumSystemType")
   private Integer lumpSumSystemType;
   @ApiModelProperty(name = "itemizedType", notes = "分项类型")
   @JsonProperty("itemizedType")
   @JSONField(name = "itemizedType")
   private Integer itemizedType;
   @ApiModelProperty(name = "allDays", notes = "工期")
   @JsonProperty("allDays")
   @JSONField(name = "allDays")
   private Integer allDays;
   @ApiModelProperty(name = "areaList", value = "区域集合", notes = "区域")
   @JsonProperty("areaList")
   @JSONField(name = "areaList")
   private List<AreaSaveDTOParam> areaList;

   public Long getId() {
      return this.id;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDate getDeepenStartDate() {
      return this.deepenStartDate;
   }

   public LocalDate getDeepenEndDate() {
      return this.deepenEndDate;
   }

   public LocalDate getPurchaseStartDate() {
      return this.purchaseStartDate;
   }

   public LocalDate getPurchaseEndDate() {
      return this.purchaseEndDate;
   }

   public LocalDate getProcessStartDate() {
      return this.processStartDate;
   }

   public LocalDate getProcessEndDate() {
      return this.processEndDate;
   }

   public LocalDate getDespatchStartDate() {
      return this.despatchStartDate;
   }

   public LocalDate getDespatchEndDate() {
      return this.despatchEndDate;
   }

   public LocalDate getInstallStartDate() {
      return this.installStartDate;
   }

   public LocalDate getInstallEndDate() {
      return this.installEndDate;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getLumpSumSystemType() {
      return this.lumpSumSystemType;
   }

   public Integer getItemizedType() {
      return this.itemizedType;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public List<AreaSaveDTOParam> getAreaList() {
      return this.areaList;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("startDate")
   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   @JsonProperty("endDate")
   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("sort")
   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("deepenStartDate")
   public void setDeepenStartDate(final LocalDate deepenStartDate) {
      this.deepenStartDate = deepenStartDate;
   }

   @JsonProperty("deepenEndDate")
   public void setDeepenEndDate(final LocalDate deepenEndDate) {
      this.deepenEndDate = deepenEndDate;
   }

   @JsonProperty("purchaseStartDate")
   public void setPurchaseStartDate(final LocalDate purchaseStartDate) {
      this.purchaseStartDate = purchaseStartDate;
   }

   @JsonProperty("purchaseEndDate")
   public void setPurchaseEndDate(final LocalDate purchaseEndDate) {
      this.purchaseEndDate = purchaseEndDate;
   }

   @JsonProperty("processStartDate")
   public void setProcessStartDate(final LocalDate processStartDate) {
      this.processStartDate = processStartDate;
   }

   @JsonProperty("processEndDate")
   public void setProcessEndDate(final LocalDate processEndDate) {
      this.processEndDate = processEndDate;
   }

   @JsonProperty("despatchStartDate")
   public void setDespatchStartDate(final LocalDate despatchStartDate) {
      this.despatchStartDate = despatchStartDate;
   }

   @JsonProperty("despatchEndDate")
   public void setDespatchEndDate(final LocalDate despatchEndDate) {
      this.despatchEndDate = despatchEndDate;
   }

   @JsonProperty("installStartDate")
   public void setInstallStartDate(final LocalDate installStartDate) {
      this.installStartDate = installStartDate;
   }

   @JsonProperty("installEndDate")
   public void setInstallEndDate(final LocalDate installEndDate) {
      this.installEndDate = installEndDate;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("lumpSumSystemType")
   public void setLumpSumSystemType(final Integer lumpSumSystemType) {
      this.lumpSumSystemType = lumpSumSystemType;
   }

   @JsonProperty("itemizedType")
   public void setItemizedType(final Integer itemizedType) {
      this.itemizedType = itemizedType;
   }

   @JsonProperty("allDays")
   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   @JsonProperty("areaList")
   public void setAreaList(final List<AreaSaveDTOParam> areaList) {
      this.areaList = areaList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanMonomerSaveDTOParam)) {
         return false;
      }

      PlanMonomerSaveDTOParam other = (PlanMonomerSaveDTOParam)o;
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
               Object this$lumpSumSystemType = this.getLumpSumSystemType();
               Object other$lumpSumSystemType = other.getLumpSumSystemType();
               if (this$lumpSumSystemType == null ? other$lumpSumSystemType == null : this$lumpSumSystemType.equals(other$lumpSumSystemType)) {
                  Object this$itemizedType = this.getItemizedType();
                  Object other$itemizedType = other.getItemizedType();
                  if (this$itemizedType == null ? other$itemizedType == null : this$itemizedType.equals(other$itemizedType)) {
                     Object this$allDays = this.getAllDays();
                     Object other$allDays = other.getAllDays();
                     if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
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
                                    Object this$deepenStartDate = this.getDeepenStartDate();
                                    Object other$deepenStartDate = other.getDeepenStartDate();
                                    if (this$deepenStartDate == null ? other$deepenStartDate == null : this$deepenStartDate.equals(other$deepenStartDate)) {
                                       Object this$deepenEndDate = this.getDeepenEndDate();
                                       Object other$deepenEndDate = other.getDeepenEndDate();
                                       if (this$deepenEndDate == null ? other$deepenEndDate == null : this$deepenEndDate.equals(other$deepenEndDate)) {
                                          Object this$purchaseStartDate = this.getPurchaseStartDate();
                                          Object other$purchaseStartDate = other.getPurchaseStartDate();
                                          if (this$purchaseStartDate == null
                                             ? other$purchaseStartDate == null
                                             : this$purchaseStartDate.equals(other$purchaseStartDate)) {
                                             Object this$purchaseEndDate = this.getPurchaseEndDate();
                                             Object other$purchaseEndDate = other.getPurchaseEndDate();
                                             if (this$purchaseEndDate == null
                                                ? other$purchaseEndDate == null
                                                : this$purchaseEndDate.equals(other$purchaseEndDate)) {
                                                Object this$processStartDate = this.getProcessStartDate();
                                                Object other$processStartDate = other.getProcessStartDate();
                                                if (this$processStartDate == null
                                                   ? other$processStartDate == null
                                                   : this$processStartDate.equals(other$processStartDate)) {
                                                   Object this$processEndDate = this.getProcessEndDate();
                                                   Object other$processEndDate = other.getProcessEndDate();
                                                   if (this$processEndDate == null
                                                      ? other$processEndDate == null
                                                      : this$processEndDate.equals(other$processEndDate)) {
                                                      Object this$despatchStartDate = this.getDespatchStartDate();
                                                      Object other$despatchStartDate = other.getDespatchStartDate();
                                                      if (this$despatchStartDate == null
                                                         ? other$despatchStartDate == null
                                                         : this$despatchStartDate.equals(other$despatchStartDate)) {
                                                         Object this$despatchEndDate = this.getDespatchEndDate();
                                                         Object other$despatchEndDate = other.getDespatchEndDate();
                                                         if (this$despatchEndDate == null
                                                            ? other$despatchEndDate == null
                                                            : this$despatchEndDate.equals(other$despatchEndDate)) {
                                                            Object this$installStartDate = this.getInstallStartDate();
                                                            Object other$installStartDate = other.getInstallStartDate();
                                                            if (this$installStartDate == null
                                                               ? other$installStartDate == null
                                                               : this$installStartDate.equals(other$installStartDate)) {
                                                               Object this$installEndDate = this.getInstallEndDate();
                                                               Object other$installEndDate = other.getInstallEndDate();
                                                               if (this$installEndDate == null
                                                                  ? other$installEndDate == null
                                                                  : this$installEndDate.equals(other$installEndDate)) {
                                                                  Object this$mete = this.getMete();
                                                                  Object other$mete = other.getMete();
                                                                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                     Object this$areaList = this.getAreaList();
                                                                     Object other$areaList = other.getAreaList();
                                                                     return this$areaList == null
                                                                        ? other$areaList == null
                                                                        : this$areaList.equals(other$areaList);
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
      return other instanceof PlanMonomerSaveDTOParam;
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
      Object $lumpSumSystemType = this.getLumpSumSystemType();
      result = result * 59 + ($lumpSumSystemType == null ? 43 : $lumpSumSystemType.hashCode());
      Object $itemizedType = this.getItemizedType();
      result = result * 59 + ($itemizedType == null ? 43 : $itemizedType.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $deepenStartDate = this.getDeepenStartDate();
      result = result * 59 + ($deepenStartDate == null ? 43 : $deepenStartDate.hashCode());
      Object $deepenEndDate = this.getDeepenEndDate();
      result = result * 59 + ($deepenEndDate == null ? 43 : $deepenEndDate.hashCode());
      Object $purchaseStartDate = this.getPurchaseStartDate();
      result = result * 59 + ($purchaseStartDate == null ? 43 : $purchaseStartDate.hashCode());
      Object $purchaseEndDate = this.getPurchaseEndDate();
      result = result * 59 + ($purchaseEndDate == null ? 43 : $purchaseEndDate.hashCode());
      Object $processStartDate = this.getProcessStartDate();
      result = result * 59 + ($processStartDate == null ? 43 : $processStartDate.hashCode());
      Object $processEndDate = this.getProcessEndDate();
      result = result * 59 + ($processEndDate == null ? 43 : $processEndDate.hashCode());
      Object $despatchStartDate = this.getDespatchStartDate();
      result = result * 59 + ($despatchStartDate == null ? 43 : $despatchStartDate.hashCode());
      Object $despatchEndDate = this.getDespatchEndDate();
      result = result * 59 + ($despatchEndDate == null ? 43 : $despatchEndDate.hashCode());
      Object $installStartDate = this.getInstallStartDate();
      result = result * 59 + ($installStartDate == null ? 43 : $installStartDate.hashCode());
      Object $installEndDate = this.getInstallEndDate();
      result = result * 59 + ($installEndDate == null ? 43 : $installEndDate.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $areaList = this.getAreaList();
      return result * 59 + ($areaList == null ? 43 : $areaList.hashCode());
   }

   @Override
   public String toString() {
      return "PlanMonomerSaveDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", deepenStartDate="
         + this.getDeepenStartDate()
         + ", deepenEndDate="
         + this.getDeepenEndDate()
         + ", purchaseStartDate="
         + this.getPurchaseStartDate()
         + ", purchaseEndDate="
         + this.getPurchaseEndDate()
         + ", processStartDate="
         + this.getProcessStartDate()
         + ", processEndDate="
         + this.getProcessEndDate()
         + ", despatchStartDate="
         + this.getDespatchStartDate()
         + ", despatchEndDate="
         + this.getDespatchEndDate()
         + ", installStartDate="
         + this.getInstallStartDate()
         + ", installEndDate="
         + this.getInstallEndDate()
         + ", mete="
         + this.getMete()
         + ", lumpSumSystemType="
         + this.getLumpSumSystemType()
         + ", itemizedType="
         + this.getItemizedType()
         + ", allDays="
         + this.getAllDays()
         + ", areaList="
         + this.getAreaList()
         + ")";
   }
}
