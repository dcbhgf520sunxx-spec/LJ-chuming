package com.hzchum.scim.mes.building.core.biz.impl.wages;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.biz.wages.MesBuildingProduceTeamReportPriceBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProcessPriceDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProjectPainingPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.TeamProcessPriceDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProcessPriceDateDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProcessPriceDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProductionPriceSummaryDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.mes.building.core.mapper.wages.MesBuildingProduceTeamReportPriceMapper;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProduceTeamReportPriceBizImpl
   extends IBizImpl<MesBuildingProduceTeamReportPriceService, MesBuildingProduceTeamReportPriceMapper, MesBuildingProduceTeamReportPrice>
   implements MesBuildingProduceTeamReportPriceBiz {
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;

   @Override
   public ProductionPriceSummaryDTO getProductionPriceSummary(LocalDateTime dateTime) {
      return ProductionPriceSummaryDTO.builder()
         .mete(this.taskProcessService.getMeteSummaryByCondition(dateTime, 1, TaskTypeEnum.ARTIFACT.getType()))
         .price(this.baseService.getPriceSummaryByCondition(dateTime, 1, null))
         .build();
   }

   @Override
   public List<ProcessPriceDTO> getProcessPriceList(LocalDateTime startTime, LocalDateTime endTime, Long workshopId) {
      return this.baseService
         .getProcessPriceList(startTime, endTime, workshopId)
         .stream()
         .map(e -> BeanUtil.copy(e, ProcessPriceDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProcessPriceDetailsDTO> getProcessPriceDetailsList(
      LocalDateTime startTime, LocalDateTime endTime, Long workshopId, Long processId, String userName
   ) {
      MesBuildingProcess process = this.processService.getById(processId);
      List<ProcessPriceDetailsDO> detailsDOList = this.baseService.getProcessPriceDayDetailsList(startTime, endTime, workshopId, processId, userName);
      Map<Long, Map<Long, List<ProcessPriceDetailsDO>>> detailsDOListMap = detailsDOList.stream()
         .collect(Collectors.groupingBy(ProcessPriceDetailsDO::getProductionLineId, Collectors.groupingBy(ProcessPriceDetailsDO::getTeamId)));
      List<ProcessPriceDetailsDTO> detailsDTOList = new ArrayList<>();
      detailsDOListMap.forEach(
         (LineId, map) -> map.forEach(
            (teamId, list) -> detailsDTOList.add(
               ProcessPriceDetailsDTO.builder()
                  .workshop(WorkshopDetailDO.builder().id(list.get(0).getWorkshopId()).name(list.get(0).getWorkshopName()).build())
                  .productionLine(ProductionLineDetailDO.builder().id(list.get(0).getProductionLineId()).name(list.get(0).getProductionLineName()).build())
                  .team(IdAndNameDO.builder().id(list.get(0).getTeamId()).name(list.get(0).getTeamName()).build())
                  .process(IdAndNameDO.builder().id(processId).name(process.getName()).build())
                  .priceList(list.stream().map(e -> BeanUtil.copy(e, ProcessPriceDateDetailsDTO.class)).collect(Collectors.toList()))
                  .build()
            )
         )
      );
      return detailsDTOList.stream()
         .map(e -> e.setTotalPrice(e.getPriceList().stream().map(ProcessPriceDateDetailsDTO::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add)))
         .collect(Collectors.toList());
   }

   @Override
   public void exportPriceExcel(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Long workshopId,
      Long processId,
      String userName,
      HttpServletRequest request,
      HttpServletResponse response
   ) {
      List<String> dayList = getBetweenDate(startTime, endTime);

      try (OutputStream out = response.getOutputStream()) {
         response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
         response.setCharacterEncoding("utf-8");
         String fileName = URLEncoder.encode("工资汇总", "UTF-8").replaceAll("\\+", "%20");
         response.setHeader("Content-disposition", "attachment;filename*=" + fileName + ".xlsx");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Access-Control-Expose-Headers", "*");
         WriteCellStyle headWriteCellStyle = new WriteCellStyle();
         WriteFont headWriteFont = new WriteFont();
         headWriteFont.setFontHeightInPoints((short)14);
         headWriteFont.setBold(true);
         headWriteCellStyle.setWriteFont(headWriteFont);
         headWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
         WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
         contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
         WriteFont contentWriteFont = new WriteFont();
         contentWriteFont.setFontHeightInPoints((short)10);
         contentWriteCellStyle.setWriteFont(contentWriteFont);
         contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
         contentWriteCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
         contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
         contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
         contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
         HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

         try (ExcelWriter excelWriter = EasyExcelFactory.write(out).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("工资表")
               .registerWriteHandler(new SimpleColumnWidthStyleStrategy(10))
               .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
               .registerWriteHandler(horizontalCellStyleStrategy)
               .head(this.excelPriceSummaryHead(dayList))
               .build();
            excelWriter.write(
               this.priceSummaryDataList(this.getProcessPriceDetailsList(startTime, endTime, workshopId, processId, userName), dayList), writeSheet
            );
            List<TeamProcessPriceDetailsDO> teamProductionPrice = this.baseService
               .getTeamProcessPriceDayDetailsList(startTime, endTime, workshopId, processId, userName);
            Map<Long, Map<Long, List<TeamProcessPriceDetailsDO>>> teamProductionPriceListMap = teamProductionPrice.stream()
               .collect(Collectors.groupingBy(TeamProcessPriceDetailsDO::getGroupsId, Collectors.groupingBy(TeamProcessPriceDetailsDO::getTeamId)));
            teamProductionPriceListMap.forEach(
               (groupId, map) -> map.forEach(
                  (teamId, list) -> {
                     WriteSheet teamSheet = EasyExcel.writerSheet(
                           "产量工资表" + list.get(0).getWorkshopName() + ">" + list.get(0).getProductionLineName() + ">" + list.get(0).getTeamName()
                        )
                        .registerWriteHandler(new SimpleColumnWidthStyleStrategy(16))
                        .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                        .registerWriteHandler(horizontalCellStyleStrategy)
                        .head(
                           this.teamProductionPriceHead(
                              list.get(0).getWorkshopName(), list.get(0).getProductionLineName(), list.get(0).getGroupsName(), list.get(0).getTeamName()
                           )
                        )
                        .build();
                     excelWriter.write(this.teamProductionDataList((List<TeamProcessPriceDetailsDO>)list), teamSheet);
                  }
               )
            );
         }

         out.flush();
      } catch (Exception e) {
         this.log.error(e.getMessage());
      }
   }

   @Override
   public List<ProjectPainingPriceDO> getProjectPaintingPrice(LocalDateTime dateTime) {
      return this.baseService.getProjectPaintingPrice(dateTime);
   }

   public static List<String> getBetweenDate(LocalDateTime startTime, LocalDateTime endTime) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      List<String> list = new ArrayList<>();
      Date startDate = Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant());
      Date endDate = Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant());

      for (Calendar calendar = Calendar.getInstance(); startDate.getTime() <= endDate.getTime(); startDate = calendar.getTime()) {
         list.add(sdf.format(startDate));
         calendar.setTime(startDate);
         calendar.add(5, 1);
      }

      return list;
   }

   private List<List<String>> excelPriceSummaryHead(List<String> dayList) {
      List<List<String>> list = new ArrayList<>();
      List<String> head0 = new ArrayList<>();
      head0.add(" 工资表");
      head0.add("序号");
      list.add(head0);
      List<String> head1 = new ArrayList<>();
      head1.add(" 工资表");
      head1.add("车间");
      list.add(head1);
      List<String> head2 = new ArrayList<>();
      head2.add(" 工资表");
      head2.add("生产线");
      list.add(head2);
      List<String> head3 = new ArrayList<>();
      head3.add(" 工资表");
      head3.add("生产组");
      list.add(head3);
      List<String> head4 = new ArrayList<>();
      head4.add(" 工资表");
      head4.add("班组长");
      list.add(head4);
      List<String> head5 = new ArrayList<>();
      head5.add(" 工资表");
      head5.add("工序");
      list.add(head5);
      List<String> head6 = new ArrayList<>();
      head6.add(" 工资表");
      head6.add("总额");
      list.add(head6);

      for (String day : dayList) {
         List<String> dayHead = new ArrayList<>();
         dayHead.add(" 工资表");
         dayHead.add("统计时间(" + dayList.get(0) + "~" + dayList.get(dayList.size() - 1) + ")");
         dayHead.add(day.substring(5));
         list.add(dayHead);
      }

      return list;
   }

   private List<List<String>> teamProductionPriceHead(String workshorpName, String productionLine, String groupsName, String teamName) {
      List<List<String>> list = new ArrayList<>();
      List<String> head01 = new ArrayList<>();
      head01.add("产量和工资");
      head01.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head01.add("序号");
      list.add(head01);
      List<String> head0 = new ArrayList<>();
      head0.add("产量和工资");
      head0.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head0.add("项目");
      list.add(head0);
      List<String> head1 = new ArrayList<>();
      head1.add("产量和工资");
      head1.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head1.add("名称");
      list.add(head1);
      List<String> head2 = new ArrayList<>();
      head2.add("产量和工资");
      head2.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head2.add("编号");
      list.add(head2);
      List<String> head3 = new ArrayList<>();
      head3.add("产量和工资");
      head3.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head3.add("规格");
      list.add(head3);
      List<String> head03 = new ArrayList<>();
      head03.add("产量和工资");
      head03.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head03.add("数量");
      list.add(head03);
      List<String> head4 = new ArrayList<>();
      head4.add("产量和工资");
      head4.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head4.add("单重(kg)");
      list.add(head4);
      List<String> head5 = new ArrayList<>();
      head5.add("产量和工资");
      head5.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head5.add("核算单位");
      list.add(head5);
      List<String> head6 = new ArrayList<>();
      head6.add("产量和工资");
      head6.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head6.add("核算量");
      list.add(head6);
      List<String> head7 = new ArrayList<>();
      head7.add("产量和工资");
      head7.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head7.add("工价");
      list.add(head7);
      List<String> head8 = new ArrayList<>();
      head8.add("产量和工资");
      head8.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head8.add("工资");
      list.add(head8);
      List<String> head9 = new ArrayList<>();
      head9.add("产量和工资");
      head9.add("班组信息:" + workshorpName + ">" + productionLine + ">" + groupsName + ">" + teamName);
      head9.add("日期");
      list.add(head9);
      return list;
   }

   private List<List<Object>> priceSummaryDataList(List<ProcessPriceDetailsDTO> priceSummaryList, List<String> dayList) {
      List<List<Object>> list = ListUtils.newArrayList();

      for (int i = 0; i < priceSummaryList.size(); i++) {
         List<Object> data = ListUtils.newArrayList();
         data.add(i + 1);
         data.add(priceSummaryList.get(i).getWorkshop().getName());
         data.add(priceSummaryList.get(i).getProductionLine().getName());
         data.add(priceSummaryList.get(i).getGroups().getName());
         data.add(priceSummaryList.get(i).getTeam().getName());
         data.add(priceSummaryList.get(i).getProcess().getName());
         data.add(
            priceSummaryList.get(i)
               .getPriceList()
               .stream()
               .map(ProcessPriceDateDetailsDTO::getPrice)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .setScale(2, RoundingMode.HALF_UP)
         );

         for (int dayIndex = 0; dayIndex < dayList.size(); dayIndex++) {
            BigDecimal price = BigDecimal.ZERO;

            for (int dataPriceIndex = 0; dataPriceIndex < priceSummaryList.get(i).getPriceList().size(); dataPriceIndex++) {
               if (priceSummaryList.get(i).getPriceList().get(dataPriceIndex).getDayTime().equals(dayList.get(dayIndex))) {
                  price = priceSummaryList.get(i).getPriceList().get(dataPriceIndex).getPrice();
               }
            }

            if (price.compareTo(BigDecimal.ZERO) == 0) {
               data.add("/");
            } else {
               data.add(price);
            }
         }

         list.add(data);
      }

      return list;
   }

   private List<List<Object>> teamProductionDataList(List<TeamProcessPriceDetailsDO> dataList) {
      List<List<Object>> list = ListUtils.newArrayList();

      for (int i = 0; i < dataList.size(); i++) {
         List<Object> data = ListUtils.newArrayList();
         data.add(i + 1);
         data.add(dataList.get(i).getProjectSerialNumber() + " " + dataList.get(i).getProjectName());
         data.add(dataList.get(i).getProductName());
         data.add(dataList.get(i).getSerialNumber());
         data.add(dataList.get(i).getSpecification());
         data.add(dataList.get(i).getQuantity());
         data.add(dataList.get(i).getNetWeight());
         if (dataList.get(i).getWageQuotaType().equals(WageQuotaTypeEnum.WEIGHT_PRICE.getType())) {
            data.add("吨");
         }

         if (dataList.get(i).getWageQuotaType().equals(WageQuotaTypeEnum.LENGTH_PRICE.getType())) {
            data.add("m");
         }

         if (dataList.get(i).getWageQuotaType().equals(WageQuotaTypeEnum.AREA_PRICE.getType())) {
            data.add("㎡");
         }

         if (dataList.get(i).getWageQuotaType().equals(WageQuotaTypeEnum.QUANTITY_PRICE.getType())) {
            data.add("件");
         }

         data.add(dataList.get(i).getMete());
         data.add(dataList.get(i).getWage());
         data.add(dataList.get(i).getPrice());
         data.add(dataList.get(i).getDayTime());
         list.add(data);
      }

      return list;
   }
}
