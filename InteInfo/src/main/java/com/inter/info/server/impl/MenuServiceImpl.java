package com.inter.info.server.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inter.info.dao.IBaseDao;
import com.inter.info.model.Commonlymenu;
import com.inter.info.model.Menu;
import com.inter.info.model.view.MenuViewModel;
import com.inter.info.server.IMenuService;
import com.inter.info.utils.HandleSessionInfo;
import com.opensymphony.xwork2.ActionContext;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	private IBaseDao<Menu> menuDao;
	private IBaseDao<Commonlymenu> commonlymenuDao;

	public IBaseDao<Commonlymenu> getCommonlymenuDao() {
		return commonlymenuDao;
	}

	@Autowired
	public void setCommonlymenuDao(IBaseDao<Commonlymenu> commonlymenuDao) {
		this.commonlymenuDao = commonlymenuDao;
	}

	public IBaseDao<Menu> getMenuDao() {
		return menuDao;
	}

	@Autowired
	public void setMenuDao(IBaseDao<Menu> menuDao) {
		this.menuDao = menuDao;
	}

	public List<MenuViewModel> getNodeTree(String id) {

		List<MenuViewModel> listMenuViewModel = new ArrayList<MenuViewModel>();
		MenuViewModel menuViewModel = null;
		String hql = null;
		Map<String, Object> params = new HashMap<String, Object>();
		if (id == null || id.equals("")) {
			// 查询所有根节点
			hql = "from Menu t where t.menu is null";
		} else {
			// 异步加载当前id下的子节点
			int menuId = Integer.valueOf(id).intValue();
			hql = "from Menu t where t.menu.menuId = :id ";
			params.put("id", menuId);
		}

		// 获取普通节点数据
		List<Menu> listMenu = menuDao.find(hql, params);
		if (listMenu != null && listMenu.size() > 0) {
			for (Menu menu : listMenu) {
				menuViewModel = new MenuViewModel(menu);
				Set<Menu> set = menu.getMenus();
				if ((set != null && !set.isEmpty()) || (menu.getMenuName().equals("常用功能") && this.getCommonNodeTree().size() > 0)) {
					menuViewModel.setState("closed");// 节点以文件夹的形式体现
				} else {
					menuViewModel.setState("open");// 节点以文件的形式体现
				}

				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", menu.getUrlAction());
				menuViewModel.setAttributes(attributes);

				listMenuViewModel.add(menuViewModel);
			}
		}
		if (id != null && id.equals("1") && this.getCommonNodeTree().size() > 0) {
			listMenuViewModel.addAll(0, this.getCommonNodeTree());
		}

		return listMenuViewModel;
	}

	public List<MenuViewModel> getCommonNodeTree() {
		List<MenuViewModel> listMenuViewModel = new ArrayList<MenuViewModel>();
		MenuViewModel menuViewModel = null;
		int userid = 0;
		// 获取常用功能节点数据
		HandleSessionInfo sessionInfo = (HandleSessionInfo) ActionContext.getContext().getSession().get("sessionInfo");
		List<Commonlymenu> listCommonlymenu = new ArrayList<Commonlymenu>();
		if (sessionInfo != null && sessionInfo.getUser() != null) {
			userid = sessionInfo.getUser().getUserid();
			listCommonlymenu = commonlymenuDao.find("from Commonlymenu t where t.user = " + userid);
			if (listCommonlymenu.size() > 0) {
				for (Commonlymenu commonlymenu : listCommonlymenu) {
					menuViewModel = new MenuViewModel(commonlymenu);

					Map<String, Object> attributes = new HashMap<String, Object>();
					attributes.put("url", commonlymenu.getMenu().getUrlAction());
					menuViewModel.setAttributes(attributes);
					listMenuViewModel.add(menuViewModel);
				}
			}
		}

		return listMenuViewModel;
	}
}
