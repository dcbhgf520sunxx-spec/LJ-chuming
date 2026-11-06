package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("涂装工艺Param")
public class MesPaintingCraftParam {
   @ApiModelProperty("id")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty("编号")
   @NotBlank(groups = {Add.class, Update.class}, message = "编号不能为空")
   private String serialNumber;
   @ApiModelProperty("项目id")
   @NotNull(groups = {Add.class, Update.class}, message = "项目不能为空")
   private Long projectId;
   @ApiModelProperty("单体idList")
   private List<Long> monomerIdList;
   @ApiModelProperty("表面积(㎡)")
   @NotNull(groups = {Add.class, Update.class}, message = "表面积不能为空")
   private BigDecimal surfaceArea;
   @ApiModelProperty("创建人id")
   @NotNull(groups = {Add.class, Update.class}, message = "创建人不能为空")
   private Long createUserId;
   @ApiModelProperty("创建日期")
   @NotNull(groups = {Add.class, Update.class}, message = "创建日期不能为空")
   private LocalDateTime createDate;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("详情list")
   @Valid
   @NotEmpty(groups = {Add.class, Update.class}, message = "配置不能为空")
   private List<MesPaintingCraftDetailParam> detailParamList;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<Long> getMonomerIdList() {
      return this.monomerIdList;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public LocalDateTime getCreateDate() {
      return this.createDate;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<MesPaintingCraftDetailParam> getDetailParamList() {
      return this.detailParamList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerIdList(final List<Long> monomerIdList) {
      this.monomerIdList = monomerIdList;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateDate(final LocalDateTime createDate) {
      this.createDate = createDate;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setDetailParamList(final List<MesPaintingCraftDetailParam> detailParamList) {
      this.detailParamList = detailParamList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintingCraftParam)) {
         return false;
      }

      MesPaintingCraftParam other = (MesPaintingCraftParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$monomerIdList = this.getMonomerIdList();
                  Object other$monomerIdList = other.getMonomerIdList();
                  if (this$monomerIdList == null ? other$monomerIdList == null : this$monomerIdList.equals(other$monomerIdList)) {
                     Object this$surfaceArea = this.getSurfaceArea();
                     Object other$surfaceArea = other.getSurfaceArea();
                     if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                        Object this$createDate = this.getCreateDate();
                        Object other$createDate = other.getCreateDate();
                        if (this$createDate == null ? other$createDate == null : this$createDate.equals(other$createDate)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$detailParamList = this.getDetailParamList();
                              Object other$detailParamList = other.getDetailParamList();
                              return this$detailParamList == null ? other$detailParamList == null : this$detailParamList.equals(other$detailParamList);
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
      return other instanceof MesPaintingCraftParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $monomerIdList = this.getMonomerIdList();
      result = result * 59 + ($monomerIdList == null ? 43 : $monomerIdList.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $createDate = this.getCreateDate();
      result = result * 59 + ($createDate == null ? 43 : $createDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $detailParamList = this.getDetailParamList();
      return result * 59 + ($detailParamList == null ? 43 : $detailParamList.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintingCraftParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", monomerIdList="
         + this.getMonomerIdList()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createDate="
         + this.getCreateDate()
         + ", remark="
         + this.getRemark()
         + ", detailParamList="
         + this.getDetailParamList()
         + ")";
   }
}
