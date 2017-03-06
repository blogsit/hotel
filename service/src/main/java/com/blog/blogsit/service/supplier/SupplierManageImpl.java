package com.blog.blogsit.service.supplier;


import com.blog.blogsit.dao.SupplierMapper;
import com.blog.blogsit.model.Supplier;
import com.oracle.tools.packager.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * 供应商管理
 *
 * @author hua.chen
 * @date 2017年03月04 08:52
 */
@Service
public class SupplierManageImpl implements SupplierManage {
    public static Logger logger = LoggerFactory.getLogger("SupplierManageImpl");
    @Resource
    SupplierMapper supplierMapper;

    @Override
    public Supplier querySupplierById(long supplierId) {
        logger.info("供应商查询{}", supplierId);
        return supplierMapper.findById(supplierId);
    }
}
