package com.hzchum.scim.plan.core.api.pojo.dtoParam.craft;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.RangeTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TechPaintTechnologySaveParam {
   @ApiModelProperty(name = "id", value = "涂装工艺id", notes = "涂装工艺id")
   private Long id;
   @Size(max = 255, message = "编号字数过多!")
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   private String serialNumber;
   @NotNull(message = "涂装工艺适用范围未传值!")
   @EnumValidator(value = RangeTypeEnum.class, message = "涂装工艺适用范围有误!")
   @ApiModelProperty(name = "rangeTypeEnum", value = "范围类型 1手动选择 2整个项目 4整个单体", notes = "范围类型 1手动选择 2整个项目 4整个单体")
   private Integer rangeTypeEnum;
   @NotNull(message = "未选择项目!")
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @Size(max = 255, message = "备注字数过多!")
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @Valid
   @NotEmpty(message = "油漆类型列表不能为空!")
   @ApiModelProperty(name = "paintTechnologyDetailList", value = "详情列表", notes = "详情列表")
   private List<TechPaintTechnologyDetailParam> paintTechnologyDetailList;
   @ApiModelProperty(name = "artifactIdList", value = "构件id列表", notes = "构件id列表")
   private Set<Long> artifactIdList;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getRangeTypeEnum() {
      return this.rangeTypeEnum;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<TechPaintTechnologyDetailParam> getPaintTechnologyDetailList() {
      return this.paintTechnologyDetailList;
   }

   public Set<Long> getArtifactIdList() {
      return this.artifactIdList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setRangeTypeEnum(final Integer rangeTypeEnum) {
      this.rangeTypeEnum = rangeTypeEnum;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPaintTechnologyDetailList(final List<TechPaintTechnologyDetailParam> paintTechnologyDetailList) {
      this.paintTechnologyDetailList = paintTechnologyDetailList;
   }

   public void setArtifactIdList(final Set<Long> artifactIdList) {
      this.artifactIdList = artifactIdList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechPaintTechnologySaveParam)) {
         return false;
      }

      TechPaintTechnologySaveParam other = (TechPaintTechnologySaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$rangeTypeEnum = this.getRangeTypeEnum();
         Object other$rangeTypeEnum = other.getRangeTypeEnum();
         if (this$rangeTypeEnum == null ? other$rangeTypeEnum == null : this$rangeTypeEnum.equals(other$rangeTypeEnum)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                        Object this$paintTechnologyDetailList = this.getPaintTechnologyDetailList();
                        Object other$paintTechnologyDetailList = other.getPaintTechnologyDetailList();
                        if (this$paintTechnologyDetailList == null
                           ? other$paintTechnologyDetailList == null
                           : this$paintTechnologyDetailList.equals(other$paintTechnologyDetailList)) {
                           Object this$artifactIdList = this.getArtifactIdList();
                           Object other$artifactIdList = other.getArtifactIdList();
                           return this$artifactIdList == null ? other$artifactIdList == null : this$artifactIdList.equals(other$artifactIdList);
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
      return other instanceof TechPaintTechnologySaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $rangeTypeEnum = this.getRangeTypeEnum();
      result = result * 59 + ($rangeTypeEnum == null ? 43 : $rangeTypeEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $paintTechnologyDetailList = this.getPaintTechnologyDetailList();
      result = result * 59 + ($paintTechnologyDetailList == null ? 43 : $paintTechnologyDetailList.hashCode());
      Object $artifactIdList = this.getArtifactIdList();
      return result * 59 + ($artifactIdList == null ? 43 : $artifactIdList.hashCode());
   }

   @Override
   public String toString() {
      return "TechPaintTechnologySaveParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", rangeTypeEnum="
         + this.getRangeTypeEnum()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", remark="
         + this.getRemark()
         + ", paintTechnologyDetailList="
         + this.getPaintTechnologyDetailList()
         + ", artifactIdList="
         + this.getArtifactIdList()
         + ")";
   }
}
