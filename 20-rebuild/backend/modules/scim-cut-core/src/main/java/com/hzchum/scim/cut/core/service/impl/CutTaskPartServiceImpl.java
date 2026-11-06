package com.hzchum.scim.cut.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.cut.core.api.pojo._do.CutTaskPart;
import com.hzchum.scim.cut.core.api.service.CutTaskPartService;
import com.hzchum.scim.cut.core.mapper.CutTaskPartMapper;
import org.springframework.stereotype.Service;

@Service
public class CutTaskPartServiceImpl extends ServiceImpl<CutTaskPartMapper, CutTaskPart> implements CutTaskPartService {
}
