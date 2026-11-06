package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("单体信息 响应类")
public class PlanMonomerDTO {
   @ApiModelProperty(name = "id", notes = "单体ID")
   private Long id;
   @ApiModelProperty(name = "name", notes = "单体名称")
   private String name;
   @ApiModelProperty(name = "itemizedType", notes = "分项类型 参考枚举itemizedType：1.其他分类 2.结构分项 4.围护分项 8.涂装分项 16.门窗分项")
   private Integer itemizedType;
   @ApiModelProperty(name = "unitName", notes = "单位名称")
   private String unitName;
   @ApiModelProperty(name = "mete", value = "工程量", notes = "工程量")
   private BigDecimal mete;
   @ApiModelProperty(name = "allDays", notes = "工期")
   private Integer allDays;
   @ApiModelProperty(name = "usedDays", notes = "已用时")
   private Long usedDays;
   @ApiModelProperty(name = "actualCompletion", notes = "实际完成量")
   private BigDecimal actualCompletion;
   @ApiModelProperty(name = "lumpSumSystemType", notes = "包干制项目管理选项 参考枚举：LumpSumSystemEnum 1.无管控，需加工 2.无管控，无加工 3.需加工，需管控 4.需加工，无需管控")
   private Integer lumpSumSystemType;
   @ApiModelProperty(name = "startDate", notes = "计划开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", notes = "计划完成日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "sort", notes = "排序")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注")
   private String remark;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomerDetailList", notes = "单体详情列表")
   private List<PlanMonomerDetailDTO> monomerDetailList;
   @ApiModelProperty(name = "deepenIds", notes = "深化负责人id集合")
   private List<MonomerUserLinkDTO> deepenIdsAndName;
   @ApiModelProperty(name = "areaDTOList", notes = "区域列表")
   private List<PlanAreaDTO> areaDTOList;
   @ApiModelProperty(name = "userId", notes = "用户Id")
   private Long userId;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getItemizedType() {
      return this.itemizedType;
   }

   public String getUnitName() {
      return this.unitName;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public Long getUsedDays() {
      return this.usedDays;
   }

   public BigDecimal getActualCompletion() {
      return this.actualCompletion;
   }

   public Integer getLumpSumSystemType() {
      return this.lumpSumSystemType;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<PlanMonomerDetailDTO> getMonomerDetailList() {
      return this.monomerDetailList;
   }

   public List<MonomerUserLinkDTO> getDeepenIdsAndName() {
      return this.deepenIdsAndName;
   }

   public List<PlanAreaDTO> getAreaDTOList() {
      return this.areaDTOList;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setItemizedType(final Integer itemizedType) {
      this.itemizedType = itemizedType;
   }

   public void setUnitName(final String unitName) {
      this.unitName = unitName;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   public void setUsedDays(final Long usedDays) {
      this.usedDays = usedDays;
   }

   public void setActualCompletion(final BigDecimal actualCompletion) {
      this.actualCompletion = actualCompletion;
   }

   public void setLumpSumSystemType(final Integer lumpSumSystemType) {
      this.lumpSumSystemType = lumpSumSystemType;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMonomerDetailList(final List<PlanMonomerDetailDTO> monomerDetailList) {
      this.monomerDetailList = monomerDetailList;
   }

   public void setDeepenIdsAndName(final List<MonomerUserLinkDTO> deepenIdsAndName) {
      this.deepenIdsAndName = deepenIdsAndName;
   }

   public void setAreaDTOList(final List<PlanAreaDTO> areaDTOList) {
      this.areaDTOList = areaDTOList;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanMonomerDTO)) {
         return false;
      }

      PlanMonomerDTO other = (PlanMonomerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$itemizedType = this.getItemizedType();
         Object other$itemizedType = other.getItemizedType();
         if (this$itemizedType == null ? other$itemizedType == null : this$itemizedType.equals(other$itemizedType)) {
            Object this$allDays = this.getAllDays();
            Object other$allDays = other.getAllDays();
            if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
               Object this$usedDays = this.getUsedDays();
               Object other$usedDays = other.getUsedDays();
               if (this$usedDays == null ? other$usedDays == null : this$usedDays.equals(other$usedDays)) {
                  Object this$lumpSumSystemType = this.getLumpSumSystemType();
                  Object other$lumpSumSystemType = other.getLumpSumSystemType();
                  if (this$lumpSumSystemType == null ? other$lumpSumSystemType == null : this$lumpSumSystemType.equals(other$lumpSumSystemType)) {
                     Object this$sort = this.getSort();
                     Object other$sort = other.getSort();
                     if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$unitName = this.getUnitName();
                              Object other$unitName = other.getUnitName();
                              if (this$unitName == null ? other$unitName == null : this$unitName.equals(other$unitName)) {
                                 Object this$mete = this.getMete();
                                 Object other$mete = other.getMete();
                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                    Object this$actualCompletion = this.getActualCompletion();
                                    Object other$actualCompletion = other.getActualCompletion();
                                    if (this$actualCompletion == null ? other$actualCompletion == null : this$actualCompletion.equals(other$actualCompletion)) {
                                       Object this$startDate = this.getStartDate();
                                       Object other$startDate = other.getStartDate();
                                       if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                          Object this$endDate = this.getEndDate();
                                          Object other$endDate = other.getEndDate();
                                          if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                Object this$monomerDetailList = this.getMonomerDetailList();
                                                Object other$monomerDetailList = other.getMonomerDetailList();
                                                if (this$monomerDetailList == null
                                                   ? other$monomerDetailList == null
                                                   : this$monomerDetailList.equals(other$monomerDetailList)) {
                                                   Object this$deepenIdsAndName = this.getDeepenIdsAndName();
                                                   Object other$deepenIdsAndName = other.getDeepenIdsAndName();
                                                   if (this$deepenIdsAndName == null
                                                      ? other$deepenIdsAndName == null
                                                      : this$deepenIdsAndName.equals(other$deepenIdsAndName)) {
                                                      Object this$areaDTOList = this.getAreaDTOList();
                                                      Object other$areaDTOList = other.getAreaDTOList();
                                                      return this$areaDTOList == null ? other$areaDTOList == null : this$areaDTOList.equals(other$areaDTOList);
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
      return other instanceof PlanMonomerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $itemizedType = this.getItemizedType();
      result = result * 59 + ($itemizedType == null ? 43 : $itemizedType.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $usedDays = this.getUsedDays();
      result = result * 59 + ($usedDays == null ? 43 : $usedDays.hashCode());
      Object $lumpSumSystemType = this.getLumpSumSystemType();
      result = result * 59 + ($lumpSumSystemType == null ? 43 : $lumpSumSystemType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $unitName = this.getUnitName();
      result = result * 59 + ($unitName == null ? 43 : $unitName.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $actualCompletion = this.getActualCompletion();
      result = result * 59 + ($actualCompletion == null ? 43 : $actualCompletion.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $monomerDetailList = this.getMonomerDetailList();
      result = result * 59 + ($monomerDetailList == null ? 43 : $monomerDetailList.hashCode());
      Object $deepenIdsAndName = this.getDeepenIdsAndName();
      result = result * 59 + ($deepenIdsAndName == null ? 43 : $deepenIdsAndName.hashCode());
      Object $areaDTOList = this.getAreaDTOList();
      return result * 59 + ($areaDTOList == null ? 43 : $areaDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "PlanMonomerDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", itemizedType="
         + this.getItemizedType()
         + ", unitName="
         + this.getUnitName()
         + ", mete="
         + this.getMete()
         + ", allDays="
         + this.getAllDays()
         + ", usedDays="
         + this.getUsedDays()
         + ", actualCompletion="
         + this.getActualCompletion()
         + ", lumpSumSystemType="
         + this.getLumpSumSystemType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", monomerDetailList="
         + this.getMonomerDetailList()
         + ", deepenIdsAndName="
         + this.getDeepenIdsAndName()
         + ", areaDTOList="
         + this.getAreaDTOList()
         + ", userId="
         + this.getUserId()
         + ")";
   }
}
