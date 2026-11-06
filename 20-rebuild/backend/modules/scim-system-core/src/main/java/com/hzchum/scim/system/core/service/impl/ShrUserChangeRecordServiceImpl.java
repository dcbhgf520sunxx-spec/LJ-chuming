package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.ShrUserChangeRecord;
import com.hzchum.scim.system.core.api.service.ShrUserChangeRecordService;
import com.hzchum.scim.system.core.mapper.ShrUserChangeRecordMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ShrUserChangeRecordServiceImpl extends ServiceImpl<ShrUserChangeRecordMapper, ShrUserChangeRecord> implements ShrUserChangeRecordService {
   @Override
   public PageVO<ShrUserChangeRecord> getAll(
      String deptName, String jobName, String name, String phone, Integer userType, Integer crudType, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ShrUserChangeRecord> shrUserChangeRecord = this.baseMapper.getAll(deptName, jobName, name, phone, userType, crudType);
      return new PageVO<>(shrUserChangeRecord);
   }
}
