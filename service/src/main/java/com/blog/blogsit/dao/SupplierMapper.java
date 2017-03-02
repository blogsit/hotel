
package com.blog.blogsit.dao;


import com.blog.blogsit.modle.Supplier;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 供应商
 *
 * @author hua.chen
 * @date 2017年03月02 11:08
 */
@Repository
public interface SupplierMapper {
    Supplier findById(@Param("id") long id);
    int insert(Supplier supplier);
}
