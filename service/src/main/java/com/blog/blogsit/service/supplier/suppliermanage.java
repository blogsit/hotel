package com.blog.blogsit.service.supplier;

import com.blog.blogsit.model.Supplier;

/**
 * 供应商管理
 *
 * @author hua.chen
 * @date 2017年03月04 08:51
 */
public interface SupplierManage {
    Supplier querySupplierById(long supplierId);
}
