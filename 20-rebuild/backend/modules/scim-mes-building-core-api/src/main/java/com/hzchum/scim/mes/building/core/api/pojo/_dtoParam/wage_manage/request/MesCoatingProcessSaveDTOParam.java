package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("涂装工艺表新增类")
public class MesCoatingProcessSaveDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(groups = Update.class, message = "主键ID不能为空")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   private String serialNumber;
   @ApiModelProperty(name = "contractProjectId", value = "合同项目ID", notes = "合同项目ID")
   @NotNull(groups = Add.class, message = "合同项目ID不能为空")
   private Long contractProjectId;
   @ApiModelProperty(name = "artifactQuantity", value = "构件数量(件)", notes = "构件数量(件)")
   @NotNull(groups = Add.class, message = "构件数量(件)不能为空")
   private Integer artifactQuantity;
   @ApiModelProperty(name = "totalArea", value = "总面积(㎡)", notes = "总面积(㎡)")
   @NotNull(groups = Add.class, message = "总面积(㎡)不能为空")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "createUserId", value = "创建人ID", notes = "创建人ID")
   private Long createUserId;
   @ApiModelProperty(name = "artifactList", value = "构件列表", notes = "构件列表")
   @NotEmpty(groups = Add.class, message = "构件列表不能为空")
   private List<TechArtifact> artifactList;
   @ApiModelProperty(name = "detailList", value = "详情列表", notes = "详情列表")
   @NotEmpty(groups = Add.class, message = "详情列表不能为空")
   private List<MesCoatingProcessDetailSaveDTOParam> detailList;

   public static MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder builder() {
      return new MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder();
   }

   public MesCoatingProcessSaveDTOParam() {
   }

   public MesCoatingProcessSaveDTOParam(
      final Long id,
      final String serialNumber,
      final Long contractProjectId,
      final Integer artifactQuantity,
      final BigDecimal totalArea,
      final Long createUserId,
      final List<TechArtifact> artifactList,
      final List<MesCoatingProcessDetailSaveDTOParam> detailList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.contractProjectId = contractProjectId;
      this.artifactQuantity = artifactQuantity;
      this.totalArea = totalArea;
      this.createUserId = createUserId;
      this.artifactList = artifactList;
      this.detailList = detailList;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
   }

   public Integer getArtifactQuantity() {
      return this.artifactQuantity;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public List<TechArtifact> getArtifactList() {
      return this.artifactList;
   }

   public List<MesCoatingProcessDetailSaveDTOParam> getDetailList() {
      return this.detailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
   }

   public void setArtifactQuantity(final Integer artifactQuantity) {
      this.artifactQuantity = artifactQuantity;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setArtifactList(final List<TechArtifact> artifactList) {
      this.artifactList = artifactList;
   }

   public void setDetailList(final List<MesCoatingProcessDetailSaveDTOParam> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingProcessSaveDTOParam)) {
         return false;
      }

      MesCoatingProcessSaveDTOParam other = (MesCoatingProcessSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$artifactQuantity = this.getArtifactQuantity();
            Object other$artifactQuantity = other.getArtifactQuantity();
            if (this$artifactQuantity == null ? other$artifactQuantity == null : this$artifactQuantity.equals(other$artifactQuantity)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$totalArea = this.getTotalArea();
                     Object other$totalArea = other.getTotalArea();
                     if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                        Object this$artifactList = this.getArtifactList();
                        Object other$artifactList = other.getArtifactList();
                        if (this$artifactList == null ? other$artifactList == null : this$artifactList.equals(other$artifactList)) {
                           Object this$detailList = this.getDetailList();
                           Object other$detailList = other.getDetailList();
                           return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
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
      return other instanceof MesCoatingProcessSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $artifactQuantity = this.getArtifactQuantity();
      result = result * 59 + ($artifactQuantity == null ? 43 : $artifactQuantity.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $artifactList = this.getArtifactList();
      result = result * 59 + ($artifactList == null ? 43 : $artifactList.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesCoatingProcessSaveDTOParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", contractProjectId="
         + this.getContractProjectId()
         + ", artifactQuantity="
         + this.getArtifactQuantity()
         + ", totalArea="
         + this.getTotalArea()
         + ", createUserId="
         + this.getCreateUserId()
         + ", artifactList="
         + this.getArtifactList()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }

   public static class MesCoatingProcessSaveDTOParamBuilder {
      private Long id;
      private String serialNumber;
      private Long contractProjectId;
      private Integer artifactQuantity;
      private BigDecimal totalArea;
      private Long createUserId;
      private List<TechArtifact> artifactList;
      private List<MesCoatingProcessDetailSaveDTOParam> detailList;

      MesCoatingProcessSaveDTOParamBuilder() {
      }

      public MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder artifactQuantity(final Integer artifactQuantity) {
         this.artifactQuantity = artifactQuantity;
         return this;
      }

      public MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder artifactList(final List<TechArtifact> artifactList) {
         this.artifactList = artifactList;
         return this;
      }

      public MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder detailList(final List<MesCoatingProcessDetailSaveDTOParam> detailList) {
         this.detailList = detailList;
         return this;
      }

      public MesCoatingProcessSaveDTOParam build() {
         return new MesCoatingProcessSaveDTOParam(
            this.id, this.serialNumber, this.contractProjectId, this.artifactQuantity, this.totalArea, this.createUserId, this.artifactList, this.detailList
         );
      }

      @Override
      public String toString() {
         return "MesCoatingProcessSaveDTOParam.MesCoatingProcessSaveDTOParamBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", contractProjectId="
            + this.contractProjectId
            + ", artifactQuantity="
            + this.artifactQuantity
            + ", totalArea="
            + this.totalArea
            + ", createUserId="
            + this.createUserId
            + ", artifactList="
            + this.artifactList
            + ", detailList="
            + this.detailList
            + ")";
      }
   }
}
