package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.business.core.api.pojo._do.CheckInfoDO;
import com.hzchum.scim.business.core.api.pojo.dto.CheckInfoDTO;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.SubBusinessCheckInfo;
import com.hzchum.scim.project.core.api.service.SubBusinessCheckInfoService;
import com.hzchum.scim.project.core.mapper.SubBusinessCheckInfoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SubBusinessCheckInfoServiceImpl extends ServiceImpl<SubBusinessCheckInfoMapper, SubBusinessCheckInfo> implements SubBusinessCheckInfoService {
   @Override
   public List<CheckInfoDO> listInfo(Long projectId, Integer status) {
      return this.baseMapper.listInfo(projectId, status);
   }

   @Override
   public PageVO<CheckInfoDTO> pageInfo(Long projectId, Integer status, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.<CheckInfoDTO>startPage(pageNumber, pageSize).doSelectPage(() -> {
         List var10000 = this.listInfo(projectId, status).stream().map(e -> BeanUtil.copy(e, CheckInfoDTO.class)).collect(Collectors.toList());
      }));
   }

   @Override
   public Integer countList() {
      return this.baseMapper
         .selectCount((Wrapper<SubBusinessCheckInfo>)Wrappers.<SubBusinessCheckInfo>lambdaQuery().eq(SubBusinessCheckInfo::getStatus, CheckStatusEnum.PENDING.getType()));
   }
}
