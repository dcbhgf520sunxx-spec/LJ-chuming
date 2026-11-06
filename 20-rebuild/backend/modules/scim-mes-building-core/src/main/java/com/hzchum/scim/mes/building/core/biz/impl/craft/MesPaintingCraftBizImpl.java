package com.hzchum.scim.mes.building.core.biz.impl.craft;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dtoParam.ApprovalParam;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.biz.craft.MesPaintingCraftBiz;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraft;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintingCraftDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.PaintingCalculationExcel;
import com.hzchum.scim.mes.building.core.api.service.craft.MesPaintingCraftService;
import com.hzchum.scim.mes.building.core.mapper.craft.MesPaintingCraftMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesPaintingCraftBizImpl extends IBizImpl<MesPaintingCraftService, MesPaintingCraftMapper, MesPaintingCraft> implements MesPaintingCraftBiz {
   @Autowired
   private TechArtifactService artifactService;

   @Override
   public PageVO<MesPaintingCraftDTO> pageInfo(MesPaintingCraftQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesPaintingCraftDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesPaintingCraftParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesPaintingCraftParam param) {
      return this.baseService.edit(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approval(ApprovalParam param) {
      return this.baseService.approval(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean cancelApproval(Long id) {
      return this.baseService.cancelApproval(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean invalid(Long id) {
      return this.baseService.invalid(id);
   }

   @Override
   public MesPaintingCraftDTO detailById(Long id) {
      return this.baseService.detailById(id, false);
   }

   @Override
   public MesPaintingCraftDTO approvalDetail(Long id) {
      return this.baseService.detailById(id, true);
   }

   @Override
   public void paintingCalculationDownload(List<PaintingCalculationExcel> excelList, HttpServletResponse response) {
      Preconditions.checkArgument(CollUtil.isNotEmpty(excelList), "无下载数据");
      AtomicInteger orderNo = new AtomicInteger(1);
      excelList.forEach(i -> {
         i.setOrderNo(orderNo.getAndIncrement());
         if (StrUtil.isNotBlank(i.getPaintingTypeEnum()) && NumberUtil.isInteger(i.getPaintingTypeEnum())) {
            i.setPaintingTypeEnum(PaintingTypeEnum.getNameByType(Integer.valueOf(i.getPaintingTypeEnum())));
         }

         i.setUnit(i.getUnit() + "/" + i.getPackageUnit());
         if (i.getPracticalSpreadingRate() != null) {
            i.setPracticalSpreadingRate(i.getPracticalSpreadingRate().setScale(2, RoundingMode.HALF_UP));
         }

         if (i.getQuantity() != null) {
            i.setQuantity(i.getQuantity().setScale(2, RoundingMode.HALF_UP));
         }

         if (i.getWeight() != null) {
            i.setWeight(i.getWeight().setScale(2, RoundingMode.HALF_UP));
         }

         if (i.getPrice() != null) {
            i.setPrice(i.getPrice().setScale(2, RoundingMode.HALF_UP));
         }

         if (i.getTotalPrice() != null) {
            i.setTotalPrice(i.getTotalPrice().setScale(2, RoundingMode.HALF_UP));
         }
      });
      String name = "涂装计算";
      PoiUtils.wmsExportExcel(excelList, name, name, PaintingCalculationExcel.class, name + "." + "xlsx", response);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> listPrint(MesPaintingCraftQuery query) {
      List<MesPaintingCraftDTO> list = this.baseService.listInfo(query);
      list = CollUtil.sort(list, Comparator.<MesPaintingCraftDTO, Long>comparing(MesPaintingCraft::getId).reversed());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "涂装工艺");
      printVO.setHeader(header);
      List<Map<String, Object>> table = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> detailPrint(Long id) {
      MesPaintingCraftDTO detail = this.baseService.detailById(id, false);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "涂装工艺明细单");
      header.put("project", detail.getProject() != null ? detail.getProject().getSerialNumber() + " - " + detail.getProject().getShortName() : null);
      header.put("monomer", CollUtil.isNotEmpty(detail.getMonomerList()) ? detail.getMonomerList() : null);
      header.put("serialNumber", detail.getSerialNumber());
      header.put("createUser", detail.getCreateUser() != null ? detail.getCreateUser().getName() : null);
      header.put("createDate", detail.getCreateDate());
      header.put("approvalUser", detail.getApprovalUser() != null ? detail.getApprovalUser().getName() : null);
      header.put("approvalTime", detail.getApprovalTime());
      printVO.setHeader(header);
      List<Map<String, Object>> table = new ArrayList<>();
      Map<String, Object> dataMap = BeanUtil.beanToMap(detail);
      table.add(dataMap);
      printVO.setTable(table);
      printVO.setFooter(MapUtil.of("remark", detail.getRemark()));
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> approvalDetailPrint(Long id) {
      MesPaintingCraftDTO detail = this.baseService.detailById(id, true);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "涂装工艺明细单");
      header.put("project", detail.getProject() != null ? detail.getProject().getSerialNumber() + " - " + detail.getProject().getShortName() : null);
      header.put("monomer", CollUtil.isNotEmpty(detail.getMonomerList()) ? detail.getMonomerList() : null);
      header.put("serialNumber", detail.getSerialNumber());
      header.put("createUser", detail.getCreateUser() != null ? detail.getCreateUser().getName() : null);
      header.put("createDate", detail.getCreateDate());
      header.put("approvalUser", detail.getApprovalUser() != null ? detail.getApprovalUser().getName() : null);
      header.put("approvalTime", detail.getApprovalTime());
      printVO.setHeader(header);
      List<Map<String, Object>> table = new ArrayList<>();
      Map<String, Object> dataMap = BeanUtil.beanToMap(detail);
      table.add(dataMap);
      printVO.setTable(table);
      printVO.setFooter(MapUtil.of("remark", detail.getRemark()));
      return printVO;
   }

   @Override
   public BigDecimal getSurfaceArea(Long projectId, List<Long> monomerIdList) {
      return this.artifactService
         .list(
            (new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getProjectId, projectId))
               .in(CollUtil.isNotEmpty(monomerIdList), TechArtifact::getMonomerId, monomerIdList)
         )
         .stream()
         .map(artifact -> artifact.getSurfaceArea().multiply(new BigDecimal(artifact.getQuantity())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public List<NameInfo> getApprovedList() {
      return this.baseService
         .list(
            (Wrapper<MesPaintingCraft>)(new LambdaQueryWrapper<MesPaintingCraft>()
                  .eq(MesPaintingCraft::getApprovalStatus, ReviewStatusEnum.REVIEWED.getType()))
               .eq(MesPaintingCraft::getBoolInvalid, false)
         )
         .stream()
         .map(i -> NameInfo.builder().id(i.getId()).name(i.getSerialNumber()).build())
         .collect(Collectors.toList());
   }
}
