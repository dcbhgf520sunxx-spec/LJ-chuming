package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "APPQuantityAndMeteDTO", description = "半自动切割任务详情")
public class APPCutTaskProcessDetailDTO {
   private String orderNumber;
   private Integer jobId;
   private BigDecimal totalNetWeight;
   private Integer totalQuantity;
   private List<APPCutTaskProcessPartDetailDTO> semiAutoCutPartDTOList;
   private List<APPAutoCutPlateDTO> appautoCutPlateDTOList;
   List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList;
   private Integer approveStatus;
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;
   private String serialNumber;
   private String projectName;
   private Long projectId;
   private Long workshopId;
   private String workshopName;
   private ProjectInfo project;

   public static APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder builder() {
      return new APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder();
   }

   public APPCutTaskProcessDetailDTO() {
   }

   public APPCutTaskProcessDetailDTO(
      final String orderNumber,
      final Integer jobId,
      final BigDecimal totalNetWeight,
      final Integer totalQuantity,
      final List<APPCutTaskProcessPartDetailDTO> semiAutoCutPartDTOList,
      final List<APPAutoCutPlateDTO> appautoCutPlateDTOList,
      final List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList,
      final Integer approveStatus,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO,
      final String serialNumber,
      final String projectName,
      final Long projectId,
      final Long workshopId,
      final String workshopName,
      final ProjectInfo project
   ) {
      this.orderNumber = orderNumber;
      this.jobId = jobId;
      this.totalNetWeight = totalNetWeight;
      this.totalQuantity = totalQuantity;
      this.semiAutoCutPartDTOList = semiAutoCutPartDTOList;
      this.appautoCutPlateDTOList = appautoCutPlateDTOList;
      this.appAutoCutSchedulingDetailList = appAutoCutSchedulingDetailList;
      this.approveStatus = approveStatus;
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
      this.serialNumber = serialNumber;
      this.projectName = projectName;
      this.projectId = projectId;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.project = project;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public List<APPCutTaskProcessPartDetailDTO> getSemiAutoCutPartDTOList() {
      return this.semiAutoCutPartDTOList;
   }

   public List<APPAutoCutPlateDTO> getAppautoCutPlateDTOList() {
      return this.appautoCutPlateDTOList;
   }

   public List<APPAutoCutSchedulingDetail> getAppAutoCutSchedulingDetailList() {
      return this.appAutoCutSchedulingDetailList;
   }

   public Integer getApproveStatus() {
      return this.approveStatus;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTO() {
      return this.wmsApproveRecordFlowDTO;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public APPCutTaskProcessDetailDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public APPCutTaskProcessDetailDTO setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   public APPCutTaskProcessDetailDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public APPCutTaskProcessDetailDTO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public APPCutTaskProcessDetailDTO setSemiAutoCutPartDTOList(final List<APPCutTaskProcessPartDetailDTO> semiAutoCutPartDTOList) {
      this.semiAutoCutPartDTOList = semiAutoCutPartDTOList;
      return this;
   }

   public APPCutTaskProcessDetailDTO setAppautoCutPlateDTOList(final List<APPAutoCutPlateDTO> appautoCutPlateDTOList) {
      this.appautoCutPlateDTOList = appautoCutPlateDTOList;
      return this;
   }

   public APPCutTaskProcessDetailDTO setAppAutoCutSchedulingDetailList(final List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList) {
      this.appAutoCutSchedulingDetailList = appAutoCutSchedulingDetailList;
      return this;
   }

   public APPCutTaskProcessDetailDTO setApproveStatus(final Integer approveStatus) {
      this.approveStatus = approveStatus;
      return this;
   }

   public APPCutTaskProcessDetailDTO setWmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
      return this;
   }

   public APPCutTaskProcessDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public APPCutTaskProcessDetailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public APPCutTaskProcessDetailDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public APPCutTaskProcessDetailDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public APPCutTaskProcessDetailDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public APPCutTaskProcessDetailDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @Override
   public String toString() {
      return "APPCutTaskProcessDetailDTO(orderNumber="
         + this.getOrderNumber()
         + ", jobId="
         + this.getJobId()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", semiAutoCutPartDTOList="
         + this.getSemiAutoCutPartDTOList()
         + ", appautoCutPlateDTOList="
         + this.getAppautoCutPlateDTOList()
         + ", appAutoCutSchedulingDetailList="
         + this.getAppAutoCutSchedulingDetailList()
         + ", approveStatus="
         + this.getApproveStatus()
         + ", wmsApproveRecordFlowDTO="
         + this.getWmsApproveRecordFlowDTO()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectName="
         + this.getProjectName()
         + ", projectId="
         + this.getProjectId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", project="
         + this.getProject()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPCutTaskProcessDetailDTO)) {
         return false;
      }

      APPCutTaskProcessDetailDTO other = (APPCutTaskProcessDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jobId = this.getJobId();
      Object other$jobId = other.getJobId();
      if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
         Object this$totalQuantity = this.getTotalQuantity();
         Object other$totalQuantity = other.getTotalQuantity();
         if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
            Object this$approveStatus = this.getApproveStatus();
            Object other$approveStatus = other.getApproveStatus();
            if (this$approveStatus == null ? other$approveStatus == null : this$approveStatus.equals(other$approveStatus)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$orderNumber = this.getOrderNumber();
                     Object other$orderNumber = other.getOrderNumber();
                     if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                        Object this$totalNetWeight = this.getTotalNetWeight();
                        Object other$totalNetWeight = other.getTotalNetWeight();
                        if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                           Object this$semiAutoCutPartDTOList = this.getSemiAutoCutPartDTOList();
                           Object other$semiAutoCutPartDTOList = other.getSemiAutoCutPartDTOList();
                           if (this$semiAutoCutPartDTOList == null
                              ? other$semiAutoCutPartDTOList == null
                              : this$semiAutoCutPartDTOList.equals(other$semiAutoCutPartDTOList)) {
                              Object this$appautoCutPlateDTOList = this.getAppautoCutPlateDTOList();
                              Object other$appautoCutPlateDTOList = other.getAppautoCutPlateDTOList();
                              if (this$appautoCutPlateDTOList == null
                                 ? other$appautoCutPlateDTOList == null
                                 : this$appautoCutPlateDTOList.equals(other$appautoCutPlateDTOList)) {
                                 Object this$appAutoCutSchedulingDetailList = this.getAppAutoCutSchedulingDetailList();
                                 Object other$appAutoCutSchedulingDetailList = other.getAppAutoCutSchedulingDetailList();
                                 if (this$appAutoCutSchedulingDetailList == null
                                    ? other$appAutoCutSchedulingDetailList == null
                                    : this$appAutoCutSchedulingDetailList.equals(other$appAutoCutSchedulingDetailList)) {
                                    Object this$wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
                                    Object other$wmsApproveRecordFlowDTO = other.getWmsApproveRecordFlowDTO();
                                    if (this$wmsApproveRecordFlowDTO == null
                                       ? other$wmsApproveRecordFlowDTO == null
                                       : this$wmsApproveRecordFlowDTO.equals(other$wmsApproveRecordFlowDTO)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$projectName = this.getProjectName();
                                          Object other$projectName = other.getProjectName();
                                          if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                             Object this$workshopName = this.getWorkshopName();
                                             Object other$workshopName = other.getWorkshopName();
                                             if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                                                Object this$project = this.getProject();
                                                Object other$project = other.getProject();
                                                return this$project == null ? other$project == null : this$project.equals(other$project);
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
      return other instanceof APPCutTaskProcessDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $approveStatus = this.getApproveStatus();
      result = result * 59 + ($approveStatus == null ? 43 : $approveStatus.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $semiAutoCutPartDTOList = this.getSemiAutoCutPartDTOList();
      result = result * 59 + ($semiAutoCutPartDTOList == null ? 43 : $semiAutoCutPartDTOList.hashCode());
      Object $appautoCutPlateDTOList = this.getAppautoCutPlateDTOList();
      result = result * 59 + ($appautoCutPlateDTOList == null ? 43 : $appautoCutPlateDTOList.hashCode());
      Object $appAutoCutSchedulingDetailList = this.getAppAutoCutSchedulingDetailList();
      result = result * 59 + ($appAutoCutSchedulingDetailList == null ? 43 : $appAutoCutSchedulingDetailList.hashCode());
      Object $wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
      result = result * 59 + ($wmsApproveRecordFlowDTO == null ? 43 : $wmsApproveRecordFlowDTO.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   public static class APPCutTaskProcessDetailDTOBuilder {
      private String orderNumber;
      private Integer jobId;
      private BigDecimal totalNetWeight;
      private Integer totalQuantity;
      private List<APPCutTaskProcessPartDetailDTO> semiAutoCutPartDTOList;
      private List<APPAutoCutPlateDTO> appautoCutPlateDTOList;
      private List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList;
      private Integer approveStatus;
      private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;
      private String serialNumber;
      private String projectName;
      private Long projectId;
      private Long workshopId;
      private String workshopName;
      private ProjectInfo project;

      APPCutTaskProcessDetailDTOBuilder() {
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder semiAutoCutPartDTOList(
         final List<APPCutTaskProcessPartDetailDTO> semiAutoCutPartDTOList
      ) {
         this.semiAutoCutPartDTOList = semiAutoCutPartDTOList;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder appautoCutPlateDTOList(final List<APPAutoCutPlateDTO> appautoCutPlateDTOList) {
         this.appautoCutPlateDTOList = appautoCutPlateDTOList;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder appAutoCutSchedulingDetailList(
         final List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList
      ) {
         this.appAutoCutSchedulingDetailList = appAutoCutSchedulingDetailList;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder approveStatus(final Integer approveStatus) {
         this.approveStatus = approveStatus;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder wmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
         this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public APPCutTaskProcessDetailDTO build() {
         return new APPCutTaskProcessDetailDTO(
            this.orderNumber,
            this.jobId,
            this.totalNetWeight,
            this.totalQuantity,
            this.semiAutoCutPartDTOList,
            this.appautoCutPlateDTOList,
            this.appAutoCutSchedulingDetailList,
            this.approveStatus,
            this.wmsApproveRecordFlowDTO,
            this.serialNumber,
            this.projectName,
            this.projectId,
            this.workshopId,
            this.workshopName,
            this.project
         );
      }

      @Override
      public String toString() {
         return "APPCutTaskProcessDetailDTO.APPCutTaskProcessDetailDTOBuilder(orderNumber="
            + this.orderNumber
            + ", jobId="
            + this.jobId
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalQuantity="
            + this.totalQuantity
            + ", semiAutoCutPartDTOList="
            + this.semiAutoCutPartDTOList
            + ", appautoCutPlateDTOList="
            + this.appautoCutPlateDTOList
            + ", appAutoCutSchedulingDetailList="
            + this.appAutoCutSchedulingDetailList
            + ", approveStatus="
            + this.approveStatus
            + ", wmsApproveRecordFlowDTO="
            + this.wmsApproveRecordFlowDTO
            + ", serialNumber="
            + this.serialNumber
            + ", projectName="
            + this.projectName
            + ", projectId="
            + this.projectId
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", project="
            + this.project
            + ")";
      }
   }
}
