package com.hzchum.scim.mes.building.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InspectionTeamReportSummaryDetailsDO", description = "")
public class InspectionTeamReportSummaryDetailsDO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "areaDetail", notes = "区域")
   @JsonProperty("areaDetail")
   @JSONField(name = "areaDetail")
   private AreaDetailDO areaDetail;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productType", notes = "类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Long productType;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "qhseQuantity", notes = "问题数量")
   @JsonProperty("qhseQuantity")
   @JSONField(name = "qhseQuantity")
   private Integer qhseQuantity;
   @ApiModelProperty(name = "date", notes = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "number", notes = "码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private String number;

   public static InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder builder() {
      return new InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder();
   }

   public InspectionTeamReportSummaryDetailsDO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO areaDetail,
      final String name,
      final String serialNumber,
      final Long processId,
      final String processName,
      final Long productType,
      final Integer inspectionQuantity,
      final Integer qhseQuantity,
      final String date,
      final String number
   ) {
      this.project = project;
      this.monomer = monomer;
      this.areaDetail = areaDetail;
      this.name = name;
      this.serialNumber = serialNumber;
      this.processId = processId;
      this.processName = processName;
      this.productType = productType;
      this.inspectionQuantity = inspectionQuantity;
      this.qhseQuantity = qhseQuantity;
      this.date = date;
      this.number = number;
   }

   public InspectionTeamReportSummaryDetailsDO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getAreaDetail() {
      return this.areaDetail;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Long getProductType() {
      return this.productType;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getQhseQuantity() {
      return this.qhseQuantity;
   }

   public String getDate() {
      return this.date;
   }

   public String getNumber() {
      return this.number;
   }

   @JsonProperty("project")
   public InspectionTeamReportSummaryDetailsDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public InspectionTeamReportSummaryDetailsDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("areaDetail")
   public InspectionTeamReportSummaryDetailsDO setAreaDetail(final AreaDetailDO areaDetail) {
      this.areaDetail = areaDetail;
      return this;
   }

   @JsonProperty("name")
   public InspectionTeamReportSummaryDetailsDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public InspectionTeamReportSummaryDetailsDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("processId")
   public InspectionTeamReportSummaryDetailsDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("processName")
   public InspectionTeamReportSummaryDetailsDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productType")
   public InspectionTeamReportSummaryDetailsDO setProductType(final Long productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public InspectionTeamReportSummaryDetailsDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("qhseQuantity")
   public InspectionTeamReportSummaryDetailsDO setQhseQuantity(final Integer qhseQuantity) {
      this.qhseQuantity = qhseQuantity;
      return this;
   }

   @JsonProperty("date")
   public InspectionTeamReportSummaryDetailsDO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("number")
   public InspectionTeamReportSummaryDetailsDO setNumber(final String number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionTeamReportSummaryDetailsDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", areaDetail="
         + this.getAreaDetail()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", productType="
         + this.getProductType()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", qhseQuantity="
         + this.getQhseQuantity()
         + ", date="
         + this.getDate()
         + ", number="
         + this.getNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionTeamReportSummaryDetailsDO)) {
         return false;
      }

      InspectionTeamReportSummaryDetailsDO other = (InspectionTeamReportSummaryDetailsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processId = this.getProcessId();
      Object other$processId = other.getProcessId();
      if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$inspectionQuantity = this.getInspectionQuantity();
            Object other$inspectionQuantity = other.getInspectionQuantity();
            if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
               Object this$qhseQuantity = this.getQhseQuantity();
               Object other$qhseQuantity = other.getQhseQuantity();
               if (this$qhseQuantity == null ? other$qhseQuantity == null : this$qhseQuantity.equals(other$qhseQuantity)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$areaDetail = this.getAreaDetail();
                        Object other$areaDetail = other.getAreaDetail();
                        if (this$areaDetail == null ? other$areaDetail == null : this$areaDetail.equals(other$areaDetail)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$processName = this.getProcessName();
                                 Object other$processName = other.getProcessName();
                                 if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                                    Object this$date = this.getDate();
                                    Object other$date = other.getDate();
                                    if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                                       Object this$number = this.getNumber();
                                       Object other$number = other.getNumber();
                                       return this$number == null ? other$number == null : this$number.equals(other$number);
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
      return other instanceof InspectionTeamReportSummaryDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $qhseQuantity = this.getQhseQuantity();
      result = result * 59 + ($qhseQuantity == null ? 43 : $qhseQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $areaDetail = this.getAreaDetail();
      result = result * 59 + ($areaDetail == null ? 43 : $areaDetail.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $number = this.getNumber();
      return result * 59 + ($number == null ? 43 : $number.hashCode());
   }

   public static class InspectionTeamReportSummaryDetailsDOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO areaDetail;
      private String name;
      private String serialNumber;
      private Long processId;
      private String processName;
      private Long productType;
      private Integer inspectionQuantity;
      private Integer qhseQuantity;
      private String date;
      private String number;

      InspectionTeamReportSummaryDetailsDOBuilder() {
      }

      @JsonProperty("project")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("areaDetail")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder areaDetail(final AreaDetailDO areaDetail) {
         this.areaDetail = areaDetail;
         return this;
      }

      @JsonProperty("name")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("processId")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("processName")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productType")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder productType(final Long productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("qhseQuantity")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder qhseQuantity(final Integer qhseQuantity) {
         this.qhseQuantity = qhseQuantity;
         return this;
      }

      @JsonProperty("date")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      @JsonProperty("number")
      public InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public InspectionTeamReportSummaryDetailsDO build() {
         return new InspectionTeamReportSummaryDetailsDO(
            this.project,
            this.monomer,
            this.areaDetail,
            this.name,
            this.serialNumber,
            this.processId,
            this.processName,
            this.productType,
            this.inspectionQuantity,
            this.qhseQuantity,
            this.date,
            this.number
         );
      }

      @Override
      public String toString() {
         return "InspectionTeamReportSummaryDetailsDO.InspectionTeamReportSummaryDetailsDOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", areaDetail="
            + this.areaDetail
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", productType="
            + this.productType
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", qhseQuantity="
            + this.qhseQuantity
            + ", date="
            + this.date
            + ", number="
            + this.number
            + ")";
      }
   }
}
