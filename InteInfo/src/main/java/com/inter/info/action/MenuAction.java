package com.inter.info.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.inter.info.model.view.MenuViewModel;
import com.inter.info.server.IMenuService;
import com.opensymphony.xwork2.ModelDriven;


@Namespace("/Menu")
@Action(value = "menuAction")
public class MenuAction extends BaseAction implements
		ModelDriven<MenuViewModel> {

	private static final long serialVersionUID = 1128662830362638919L;
	private MenuViewModel menuViewModel = new MenuViewModel();
	private IMenuService menuService;

	public IMenuService getMenuService() {
		return menuService;
	}

	@Autowired
	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public MenuViewModel getModel() {
		return menuViewModel;
	}
	
	public void getNodeTree(){
		super.writeJson(menuService.getNodeTree(menuViewModel.getId()));
	}

}
