package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("涂装配置")
public class MesCoatingConfigSaveDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty(name = "artifactClassificationIdList", value = "构件分类id列表", notes = "构件分类id列表")
   @NotEmpty(groups = {Add.class, Update.class}, message = "构件分类不能为空")
   private List<Long> artifactClassificationIdList;
   @ApiModelProperty(name = "paintType", value = "油漆类型(1: 底漆, 3: 底+中, 7: 底+中+面)", notes = "油漆类型(1: 底漆, 3: 底+中, 7: 底+中+面)")
   @NotNull(groups = {Add.class, Update.class}, message = "油漆类型不能为空")
   private Integer paintType;
   @ApiModelProperty(name = "measurementManner", value = "计量方式", notes = "计量方式")
   @NotNull(groups = {Add.class, Update.class}, message = "计量方式不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = WageQuotaTypeEnum.class, message = "计量方式不存在")
   private Integer measurementManner;
   @ApiModelProperty(name = "price", value = "单价(元/吨)", notes = "单价(元/吨)")
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "单价要大于0")
   private BigDecimal price;
   @ApiModelProperty(name = "status", value = "状态(0: 关闭, 1: 开启)", notes = "状态(0: 关闭, 1: 开启)")
   @NotNull(groups = Update.class, message = "状态不能为空")
   private Boolean status;

   public Long getId() {
      return this.id;
   }

   public List<Long> getArtifactClassificationIdList() {
      return this.artifactClassificationIdList;
   }

   public Integer getPaintType() {
      return this.paintType;
   }

   public Integer getMeasurementManner() {
      return this.measurementManner;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setArtifactClassificationIdList(final List<Long> artifactClassificationIdList) {
      this.artifactClassificationIdList = artifactClassificationIdList;
   }

   public void setPaintType(final Integer paintType) {
      this.paintType = paintType;
   }

   public void setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingConfigSaveDTOParam)) {
         return false;
      }

      MesCoatingConfigSaveDTOParam other = (MesCoatingConfigSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paintType = this.getPaintType();
         Object other$paintType = other.getPaintType();
         if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
            Object this$measurementManner = this.getMeasurementManner();
            Object other$measurementManner = other.getMeasurementManner();
            if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$artifactClassificationIdList = this.getArtifactClassificationIdList();
                  Object other$artifactClassificationIdList = other.getArtifactClassificationIdList();
                  if (this$artifactClassificationIdList == null
                     ? other$artifactClassificationIdList == null
                     : this$artifactClassificationIdList.equals(other$artifactClassificationIdList)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesCoatingConfigSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $artifactClassificationIdList = this.getArtifactClassificationIdList();
      result = result * 59 + ($artifactClassificationIdList == null ? 43 : $artifactClassificationIdList.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesCoatingConfigSaveDTOParam(id="
         + this.getId()
         + ", artifactClassificationIdList="
         + this.getArtifactClassificationIdList()
         + ", paintType="
         + this.getPaintType()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }
}
