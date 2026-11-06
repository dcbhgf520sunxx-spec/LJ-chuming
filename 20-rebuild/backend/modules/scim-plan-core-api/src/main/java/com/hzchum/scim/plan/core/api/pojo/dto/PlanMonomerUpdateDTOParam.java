package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("修改单体请求类")
public class PlanMonomerUpdateDTOParam {
   @ApiModelProperty(name = "id", value = "单体id")
   @NotNull(message = "单体id不能为空")
   private Long id;
   @ApiModelProperty(name = "name", value = "单体名称")
   @NotBlank(message = "单体名称不能为空")
   private String name;
   @ApiModelProperty(name = "startDate", notes = "计划开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "date", value = "单体完成日期")
   @NotNull(message = "单体完成日期不能为空")
   private LocalDate date;
   @Valid
   @ApiModelProperty(name = "detailUpdateDTOParamList", value = "单体详情修改列表")
   private List<PlanMonomerDetailDTOParam> detailSaveDTOParamList;
   @ApiModelProperty(name = "sort", value = "排序")
   @NotNull(message = "排序不能为空")
   private Integer sort;
   @ApiModelProperty(name = "remark", value = "单体备注")
   @Size(max = 200, message = "单体备注字数过多")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public List<PlanMonomerDetailDTOParam> getDetailSaveDTOParamList() {
      return this.detailSaveDTOParamList;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setDetailSaveDTOParamList(final List<PlanMonomerDetailDTOParam> detailSaveDTOParamList) {
      this.detailSaveDTOParamList = detailSaveDTOParamList;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanMonomerUpdateDTOParam)) {
         return false;
      }

      PlanMonomerUpdateDTOParam other = (PlanMonomerUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$startDate = this.getStartDate();
               Object other$startDate = other.getStartDate();
               if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                  Object this$date = this.getDate();
                  Object other$date = other.getDate();
                  if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                     Object this$detailSaveDTOParamList = this.getDetailSaveDTOParamList();
                     Object other$detailSaveDTOParamList = other.getDetailSaveDTOParamList();
                     if (this$detailSaveDTOParamList == null
                        ? other$detailSaveDTOParamList == null
                        : this$detailSaveDTOParamList.equals(other$detailSaveDTOParamList)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof PlanMonomerUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $detailSaveDTOParamList = this.getDetailSaveDTOParamList();
      result = result * 59 + ($detailSaveDTOParamList == null ? 43 : $detailSaveDTOParamList.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "PlanMonomerUpdateDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", startDate="
         + this.getStartDate()
         + ", date="
         + this.getDate()
         + ", detailSaveDTOParamList="
         + this.getDetailSaveDTOParamList()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
