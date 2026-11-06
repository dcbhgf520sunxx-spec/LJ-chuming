package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ReturnManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryReturnManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnManufacturedService;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnManufacturedMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ReturnManufacturedServiceImpl extends ServiceImpl<ReturnManufacturedMapper, ReturnManufactured> implements ReturnManufacturedService {
   @Resource
   ReturnDetailManufacturedService returnDetailManufacturedService;
   @Resource
   QueryUtilService queryUtil;

   @Override
   public Integer getCount(LocalDateTime dateTime) {
      return this.baseMapper.getCount(dateTime);
   }

   @Override
   public PageVO<ReturnManufacturedDTO> pageInfo(QueryReturnManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<ReturnManufactured> returnManufactureds = this.baseMapper.list(param);
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      List<ReturnManufacturedDTO> returnManufacturedDTOS = new ArrayList<>();

      for (ReturnManufactured returnManufactured : returnManufactureds) {
         ReturnManufacturedDTO bean = BeanUtil.toBean(returnManufactured, ReturnManufacturedDTO.class);
         if (StrUtil.isNotBlank(returnManufactured.getProjectIds())) {
            List<Long> idList = Arrays.stream(org.apache.commons.lang3.StringUtils.split(returnManufactured.getProjectIds(), ","))
               .map(Long::parseLong)
               .collect(Collectors.toList());
            List<ContractProject> list = new ArrayList<>();
            idList.forEach(id -> {
               if (projectMap.containsKey(id)) {
                  list.add(projectMap.get(id));
               }
            });
            List<ProjectInfo> collect = list.stream()
               .map(project -> com.hzchum.pangu.common.util.BeanUtil.copy(project, ProjectInfo.class))
               .collect(Collectors.toList());
            bean.setProjects(collect);
         }

         returnManufacturedDTOS.add(bean);
      }

      return new PageVO<>(page, returnManufacturedDTOS);
   }

   @Override
   public PageVO<ReturnDetailManufacturedDTO> pageInfoDetail(QueryReturnManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<InboundDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<ReturnDetailManufactured> returnDetailManufactureds = this.returnDetailManufacturedService.selectList(param);
      if (CollectionUtil.isEmpty(returnDetailManufactureds)) {
         return new PageVO<>();
      }

      List<ReturnDetailManufacturedDTO> returnDetailManufacturedDTOS = this.returnDetailManufacturedService.convertDetailDto(returnDetailManufactureds);
      return new PageVO<>(page, returnDetailManufacturedDTOS);
   }

   @Override
   public ReturnManufacturedDTO getReturnById(Long id) {
      ReturnManufactured returnManufactured = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(returnManufactured), "退库单不存在！！！");
      ReturnManufacturedDTO returnManufacturedDTO = BeanUtil.toBean(returnManufactured, ReturnManufacturedDTO.class);
      List<ReturnDetailManufactured> returnDetailManufactureds = this.returnDetailManufacturedService
         .list((Wrapper<ReturnDetailManufactured>)new LambdaQueryWrapper<ReturnDetailManufactured>().eq(ReturnDetailManufactured::getReturnManufacturedId, returnManufactured.getId()));
      List<ReturnDetailManufacturedDTO> list = this.returnDetailManufacturedService.convertDetailDto(returnDetailManufactureds);
      returnManufacturedDTO.setList(list);
      return returnManufacturedDTO;
   }
}
