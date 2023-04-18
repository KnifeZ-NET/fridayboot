package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
<#if table.serviceInterface>
    import ${package.Service}.${table.serviceName};
</#if>
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
* <p>
    * ${table.comment!} 服务实现类
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
<#if kotlin>
    open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>()<#if table.serviceInterface>, ${table.serviceName}</#if> {

    }
<#else>
    public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}><#if table.serviceInterface> implements ${table.serviceName}</#if> {
    /**
    * 列表页面查询
    *
    * @param queryRequest 查询请求
    * @return {@link PagedResult}<{@link AppDictionary}>
    */
    @Override
    public PagedResult<${entity}> listByPage(${entity}PagedRequest queryRequest) {
    LambdaQueryWrapper<${entity}> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(StringUtils.hasText(queryRequest.getId()), ${entity}::getId, queryRequest.getId());
    IPage<${entity}> page = new Page<>();
    page.setCurrent(queryRequest.getPage());
    page.setSize(queryRequest.getPageSize());
    page = getBaseMapper().selectPage(page, queryWrapper);
    return PagedResult.builder(page.getRecords(), page.getTotal());
    }
    }
</#if>