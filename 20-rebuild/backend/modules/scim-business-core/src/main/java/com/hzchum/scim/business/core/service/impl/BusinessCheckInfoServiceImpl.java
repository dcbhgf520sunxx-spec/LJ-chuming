package com.hzchum.scim.business.core.service.impl;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.business.core.api.pojo._do.CheckInfoDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessCheckAuxiliaryMaterialExcelDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessCheckEnclosureExcelDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessCheckExcelDTO;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessCheckStructuralAndDispersedExcelDTO;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.mapper.BusinessCheckInfoMapper;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCheckInfoServiceImpl extends ServiceImpl<BusinessCheckInfoMapper, BusinessCheckInfo> implements BusinessCheckInfoService {
   @Autowired
   private ContractProjectService projectService;

   @Override
   public PageVO<CheckInfoDO> listInfo(Long projectId, Integer type, Integer status, List<LocalDateTime> dateTimeList, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.baseMapper.listInfo(projectId, type, status, dateTimeList));
   }

   @Override
   public Integer countList() {
      return this.baseMapper.countList();
   }

   @Override
   public void listExcel(Long projectId, Integer type, HttpServletResponse response) {
      List<BusinessCheckExcelDTO> list = this.baseMapper.listExcel(projectId, type);
      if (CollUtil.isEmpty(list)) {
         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("无变更记录", StandardCharsets.UTF_8.toString()));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
         }

         throw new BusinessException("无变更记录");
      } else {
         switch (type) {
            case 1: {
               List<BusinessCheckStructuralAndDispersedExcelDTO> structuralExcelDTOS = BeanUtil.copyToList(
                  list, BusinessCheckStructuralAndDispersedExcelDTO.class
               );
               String title = "散发制品";
               String sheetName = title + "变更记录表";
               String fileName = sheetName + ".xlsx";
               this.exportExcel(structuralExcelDTOS, title, sheetName, BusinessCheckStructuralAndDispersedExcelDTO.class, fileName, response);
               break;
            }
            case 2: {
               List<BusinessCheckStructuralAndDispersedExcelDTO> dispersedExcelDTOS = BeanUtil.copyToList(
                  list, BusinessCheckStructuralAndDispersedExcelDTO.class
               );
               String title = "结构制品";
               String sheetName = title + "变更记录表";
               String fileName = sheetName + ".xlsx";
               this.exportExcel(dispersedExcelDTOS, title, sheetName, BusinessCheckStructuralAndDispersedExcelDTO.class, fileName, response);
            }
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               break;
            case 4: {
               List<BusinessCheckEnclosureExcelDTO> enclosureExcelDTOS = BeanUtil.copyToList(list, BusinessCheckEnclosureExcelDTO.class);
               String title = "围护";
               String sheetName = title + "变更记录表";
               String fileName = sheetName + ".xlsx";
               this.exportExcel(enclosureExcelDTOS, title, sheetName, BusinessCheckEnclosureExcelDTO.class, fileName, response);
               break;
            }
            case 8: {
               List<BusinessCheckAuxiliaryMaterialExcelDTO> auxiliaryMaterialExcelDTOS = BeanUtil.copyToList(list, BusinessCheckAuxiliaryMaterialExcelDTO.class);
               String title = "配套制品";
               String sheetName = title + "变更记录表";
               String fileName = sheetName + ".xlsx";
               this.exportExcel(auxiliaryMaterialExcelDTOS, title, sheetName, BusinessCheckAuxiliaryMaterialExcelDTO.class, fileName, response);
            }
         }
      }
   }

   private void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) {
      try {
         response.setHeader("result", "code=20000;message=" + URLEncoder.encode("成功", StandardCharsets.UTF_8.toString()));
         response.setHeader("Access-Control-Expose-Headers", "result");
      } catch (UnsupportedEncodingException e) {
         throw new RuntimeException(e);
      }

      PoiUtils.exportExcel(list, title, sheetName, pojoClass, fileName, ExcelType.XSSF, response);
   }
}
