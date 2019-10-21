
package com.pinyougou.service.impl;

import com.pinyougou.mapper.SpecificationDao;


import java.util.HashMap;
import java.util.List;

import java.util.Map;


import com.pinyougou.OperatorService.SpecificationService;

import com.pinyougou.mapper.OperatorDao.TbSpecificationMapper;
import com.pinyougou.mapper.OperatorDao.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.pojo.group.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;




import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
@Component
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;
	
	@Autowired
    private SpecificationDao specificationDao;

    @Override
    public HashMap<String, Object> querySpecificationPageData(TbSpecification tbSpecification, int page, int rows) {
        HashMap<String, Object> map=new HashMap<>();
        int count=specificationDao.querySpecificationCount(tbSpecification);
        map.put("total",count);
        int start=(page-1)*rows;
        List<TbSpecification> list=specificationDao.querySpecificationPageData(start,rows,tbSpecification);
        map.put("rows",list);
        return map;
    }
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
	@Autowired
	private TbSpecificationOptionMapper specificationOptionMapper ;
	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		// 保存规格TbSpecificationOption
		specificationMapper.insert(specification.getSpecification());
		// 保存规格选项
		for(TbSpecificationOption specificationOption: specification.getSpecificationOptionList()){
			// 设置规格的ID:
			specificationOption.setSpecId(specification.getSpecification().getId());
			
			specificationOptionMapper.insert(specificationOption);
		}
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification){
		// 修改规格
		specificationMapper.updateByPrimaryKey(specification.getSpecification());
		
		// 先删除规格选项，再添加规格选项
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(specification.getSpecification().getId());
		specificationOptionMapper.deleteByExample(example);
		
		// 保存规格选项
		for(TbSpecificationOption specificationOption: specification.getSpecificationOptionList()){
			// 设置规格的ID:
			specificationOption.setSpecId(specification.getSpecification().getId());
			
			specificationOptionMapper.insert(specificationOption);
		}
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		Specification specification = new Specification();
		// 根据规格ID查询规格对象
		TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
		specification.setSpecification(tbSpecification);
		
		// 根据规格的ID查询规格选项
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<TbSpecificationOption> list = specificationOptionMapper.selectByExample(example);
		specification.setSpecificationOptionList(list);
		
		return specification;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			// 删除规格
			specificationMapper.deleteByPrimaryKey(id);
			
			// 删除规格选项:
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			specificationOptionMapper.deleteByExample(example);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		TbSpecificationExample.Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

		@Override
		public List<Map> selectOptionList() {
			return specificationMapper.selectOptionList();
		}
	
}
