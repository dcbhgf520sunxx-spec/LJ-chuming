package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("套料成果Query")
public class NestingResultQuery {
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty("cutSendStatus")
   private Integer cutSendStatus;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("车间idList")
   private List<Long> workshopIdList;
   @ApiModelProperty("作业id")
   private Integer jobId;
   @ApiModelProperty("厚度(mm)")
   private BigDecimal thickness;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("切割状态(1:未切割,2:已切割)")
   private Integer cuttingStatus;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("钢板idList")
   private List<Long> nestingResultIdList;
   @ApiModelProperty("设备mid")
   private String mid;
   @ApiModelProperty("切割下发时间开始")
   private LocalDateTime cutSendTimeStart;
   @ApiModelProperty("切割下发时间结束")
   private LocalDateTime cutSendTimeEnd;
   @ApiModelProperty("切割下发时间格式")
   private String cutSendTimeFormat;
   @ApiModelProperty("切割任务状态")
   private Integer cutStatus;

   public String getCutSendTimeFormat() {
      return StrUtil.isBlank(this.cutSendTimeFormat) ? "%Y-%m-%d" : this.cutSendTimeFormat;
   }

   public static NestingResultQuery.NestingResultQueryBuilder builder() {
      return new NestingResultQuery.NestingResultQueryBuilder();
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getCutSendStatus() {
      return this.cutSendStatus;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public List<Long> getWorkshopIdList() {
      return this.workshopIdList;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getCuttingStatus() {
      return this.cuttingStatus;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public List<Long> getNestingResultIdList() {
      return this.nestingResultIdList;
   }

   public String getMid() {
      return this.mid;
   }

   public LocalDateTime getCutSendTimeStart() {
      return this.cutSendTimeStart;
   }

   public LocalDateTime getCutSendTimeEnd() {
      return this.cutSendTimeEnd;
   }

   public Integer getCutStatus() {
      return this.cutStatus;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setCutSendStatus(final Integer cutSendStatus) {
      this.cutSendStatus = cutSendStatus;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWorkshopIdList(final List<Long> workshopIdList) {
      this.workshopIdList = workshopIdList;
   }

   public void setJobId(final Integer jobId) {
      this.jobId = jobId;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setCuttingStatus(final Integer cuttingStatus) {
      this.cuttingStatus = cuttingStatus;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setNestingResultIdList(final List<Long> nestingResultIdList) {
      this.nestingResultIdList = nestingResultIdList;
   }

   public void setMid(final String mid) {
      this.mid = mid;
   }

   public void setCutSendTimeStart(final LocalDateTime cutSendTimeStart) {
      this.cutSendTimeStart = cutSendTimeStart;
   }

   public void setCutSendTimeEnd(final LocalDateTime cutSendTimeEnd) {
      this.cutSendTimeEnd = cutSendTimeEnd;
   }

   public void setCutSendTimeFormat(final String cutSendTimeFormat) {
      this.cutSendTimeFormat = cutSendTimeFormat;
   }

   public void setCutStatus(final Integer cutStatus) {
      this.cutStatus = cutStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestingResultQuery)) {
         return false;
      }

      NestingResultQuery other = (NestingResultQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$cutSendStatus = this.getCutSendStatus();
      Object other$cutSendStatus = other.getCutSendStatus();
      if (this$cutSendStatus == null ? other$cutSendStatus == null : this$cutSendStatus.equals(other$cutSendStatus)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$jobId = this.getJobId();
            Object other$jobId = other.getJobId();
            if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
               Object this$cuttingStatus = this.getCuttingStatus();
               Object other$cuttingStatus = other.getCuttingStatus();
               if (this$cuttingStatus == null ? other$cuttingStatus == null : this$cuttingStatus.equals(other$cuttingStatus)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$cutStatus = this.getCutStatus();
                        Object other$cutStatus = other.getCutStatus();
                        if (this$cutStatus == null ? other$cutStatus == null : this$cutStatus.equals(other$cutStatus)) {
                           Object this$startDate = this.getStartDate();
                           Object other$startDate = other.getStartDate();
                           if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                              Object this$endDate = this.getEndDate();
                              Object other$endDate = other.getEndDate();
                              if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                 Object this$workshopIdList = this.getWorkshopIdList();
                                 Object other$workshopIdList = other.getWorkshopIdList();
                                 if (this$workshopIdList == null ? other$workshopIdList == null : this$workshopIdList.equals(other$workshopIdList)) {
                                    Object this$thickness = this.getThickness();
                                    Object other$thickness = other.getThickness();
                                    if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$nestingResultIdList = this.getNestingResultIdList();
                                          Object other$nestingResultIdList = other.getNestingResultIdList();
                                          if (this$nestingResultIdList == null
                                             ? other$nestingResultIdList == null
                                             : this$nestingResultIdList.equals(other$nestingResultIdList)) {
                                             Object this$mid = this.getMid();
                                             Object other$mid = other.getMid();
                                             if (this$mid == null ? other$mid == null : this$mid.equals(other$mid)) {
                                                Object this$cutSendTimeStart = this.getCutSendTimeStart();
                                                Object other$cutSendTimeStart = other.getCutSendTimeStart();
                                                if (this$cutSendTimeStart == null
                                                   ? other$cutSendTimeStart == null
                                                   : this$cutSendTimeStart.equals(other$cutSendTimeStart)) {
                                                   Object this$cutSendTimeEnd = this.getCutSendTimeEnd();
                                                   Object other$cutSendTimeEnd = other.getCutSendTimeEnd();
                                                   if (this$cutSendTimeEnd == null
                                                      ? other$cutSendTimeEnd == null
                                                      : this$cutSendTimeEnd.equals(other$cutSendTimeEnd)) {
                                                      Object this$cutSendTimeFormat = this.getCutSendTimeFormat();
                                                      Object other$cutSendTimeFormat = other.getCutSendTimeFormat();
                                                      return this$cutSendTimeFormat == null
                                                         ? other$cutSendTimeFormat == null
                                                         : this$cutSendTimeFormat.equals(other$cutSendTimeFormat);
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
      return other instanceof NestingResultQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $cutSendStatus = this.getCutSendStatus();
      result = result * 59 + ($cutSendStatus == null ? 43 : $cutSendStatus.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $cuttingStatus = this.getCuttingStatus();
      result = result * 59 + ($cuttingStatus == null ? 43 : $cuttingStatus.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $cutStatus = this.getCutStatus();
      result = result * 59 + ($cutStatus == null ? 43 : $cutStatus.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $workshopIdList = this.getWorkshopIdList();
      result = result * 59 + ($workshopIdList == null ? 43 : $workshopIdList.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $nestingResultIdList = this.getNestingResultIdList();
      result = result * 59 + ($nestingResultIdList == null ? 43 : $nestingResultIdList.hashCode());
      Object $mid = this.getMid();
      result = result * 59 + ($mid == null ? 43 : $mid.hashCode());
      Object $cutSendTimeStart = this.getCutSendTimeStart();
      result = result * 59 + ($cutSendTimeStart == null ? 43 : $cutSendTimeStart.hashCode());
      Object $cutSendTimeEnd = this.getCutSendTimeEnd();
      result = result * 59 + ($cutSendTimeEnd == null ? 43 : $cutSendTimeEnd.hashCode());
      Object $cutSendTimeFormat = this.getCutSendTimeFormat();
      return result * 59 + ($cutSendTimeFormat == null ? 43 : $cutSendTimeFormat.hashCode());
   }

   @Override
   public String toString() {
      return "NestingResultQuery(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", cutSendStatus="
         + this.getCutSendStatus()
         + ", projectId="
         + this.getProjectId()
         + ", workshopIdList="
         + this.getWorkshopIdList()
         + ", jobId="
         + this.getJobId()
         + ", thickness="
         + this.getThickness()
         + ", material="
         + this.getMaterial()
         + ", cuttingStatus="
         + this.getCuttingStatus()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", nestingResultIdList="
         + this.getNestingResultIdList()
         + ", mid="
         + this.getMid()
         + ", cutSendTimeStart="
         + this.getCutSendTimeStart()
         + ", cutSendTimeEnd="
         + this.getCutSendTimeEnd()
         + ", cutSendTimeFormat="
         + this.getCutSendTimeFormat()
         + ", cutStatus="
         + this.getCutStatus()
         + ")";
   }

   public NestingResultQuery(
      final LocalDate startDate,
      final LocalDate endDate,
      final Integer cutSendStatus,
      final Long projectId,
      final List<Long> workshopIdList,
      final Integer jobId,
      final BigDecimal thickness,
      final String material,
      final Integer cuttingStatus,
      final Long monomerId,
      final Long areaId,
      final List<Long> nestingResultIdList,
      final String mid,
      final LocalDateTime cutSendTimeStart,
      final LocalDateTime cutSendTimeEnd,
      final String cutSendTimeFormat,
      final Integer cutStatus
   ) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.cutSendStatus = cutSendStatus;
      this.projectId = projectId;
      this.workshopIdList = workshopIdList;
      this.jobId = jobId;
      this.thickness = thickness;
      this.material = material;
      this.cuttingStatus = cuttingStatus;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.nestingResultIdList = nestingResultIdList;
      this.mid = mid;
      this.cutSendTimeStart = cutSendTimeStart;
      this.cutSendTimeEnd = cutSendTimeEnd;
      this.cutSendTimeFormat = cutSendTimeFormat;
      this.cutStatus = cutStatus;
   }

   public NestingResultQuery() {
   }

   public static class NestingResultQueryBuilder {
      private LocalDate startDate;
      private LocalDate endDate;
      private Integer cutSendStatus;
      private Long projectId;
      private List<Long> workshopIdList;
      private Integer jobId;
      private BigDecimal thickness;
      private String material;
      private Integer cuttingStatus;
      private Long monomerId;
      private Long areaId;
      private List<Long> nestingResultIdList;
      private String mid;
      private LocalDateTime cutSendTimeStart;
      private LocalDateTime cutSendTimeEnd;
      private String cutSendTimeFormat;
      private Integer cutStatus;

      NestingResultQueryBuilder() {
      }

      public NestingResultQuery.NestingResultQueryBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder cutSendStatus(final Integer cutSendStatus) {
         this.cutSendStatus = cutSendStatus;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder workshopIdList(final List<Long> workshopIdList) {
         this.workshopIdList = workshopIdList;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder cuttingStatus(final Integer cuttingStatus) {
         this.cuttingStatus = cuttingStatus;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder nestingResultIdList(final List<Long> nestingResultIdList) {
         this.nestingResultIdList = nestingResultIdList;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder mid(final String mid) {
         this.mid = mid;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder cutSendTimeStart(final LocalDateTime cutSendTimeStart) {
         this.cutSendTimeStart = cutSendTimeStart;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder cutSendTimeEnd(final LocalDateTime cutSendTimeEnd) {
         this.cutSendTimeEnd = cutSendTimeEnd;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder cutSendTimeFormat(final String cutSendTimeFormat) {
         this.cutSendTimeFormat = cutSendTimeFormat;
         return this;
      }

      public NestingResultQuery.NestingResultQueryBuilder cutStatus(final Integer cutStatus) {
         this.cutStatus = cutStatus;
         return this;
      }

      public NestingResultQuery build() {
         return new NestingResultQuery(
            this.startDate,
            this.endDate,
            this.cutSendStatus,
            this.projectId,
            this.workshopIdList,
            this.jobId,
            this.thickness,
            this.material,
            this.cuttingStatus,
            this.monomerId,
            this.areaId,
            this.nestingResultIdList,
            this.mid,
            this.cutSendTimeStart,
            this.cutSendTimeEnd,
            this.cutSendTimeFormat,
            this.cutStatus
         );
      }

      @Override
      public String toString() {
         return "NestingResultQuery.NestingResultQueryBuilder(startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", cutSendStatus="
            + this.cutSendStatus
            + ", projectId="
            + this.projectId
            + ", workshopIdList="
            + this.workshopIdList
            + ", jobId="
            + this.jobId
            + ", thickness="
            + this.thickness
            + ", material="
            + this.material
            + ", cuttingStatus="
            + this.cuttingStatus
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", nestingResultIdList="
            + this.nestingResultIdList
            + ", mid="
            + this.mid
            + ", cutSendTimeStart="
            + this.cutSendTimeStart
            + ", cutSendTimeEnd="
            + this.cutSendTimeEnd
            + ", cutSendTimeFormat="
            + this.cutSendTimeFormat
            + ", cutStatus="
            + this.cutStatus
            + ")";
      }
   }
}
