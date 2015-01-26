package com.inter.info.server;

import java.util.List;

import com.inter.info.model.view.MenuViewModel;

public interface IMenuService {
	
	public List<MenuViewModel> getNodeTree(String id);
}
