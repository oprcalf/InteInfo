package com.InteInfo.server;

import java.util.List;

import com.InteInfo.model.view.MenuViewModel;

public interface IMenuService {
	
	public List<MenuViewModel> getNodeTree(String id);
}
