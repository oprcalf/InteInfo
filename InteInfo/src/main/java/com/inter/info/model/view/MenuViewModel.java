package com.inter.info.model.view;

import java.util.Map;

import com.inter.info.model.Commonlymenu;
import com.inter.info.model.Menu;

/**
 * 
 * @author OprCalf
 * @Date 2013/12/27
 * 
 * */

public class MenuViewModel {

	private String id;
	private String text;
	private String state;
	private boolean checked;
	private String url;
	private String iconCls;
	private Map<String, Object> attributes;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public MenuViewModel(){
		
	}
	
	public MenuViewModel(Menu menu) {
		this.setId(Integer.toString(menu.getMenuId()));
		this.setText(menu.getMenuName());
		this.setUrl(menu.getUrlAction());
	}
	
	public MenuViewModel(Commonlymenu commonlymenu){
		this.setId(Integer.toString(commonlymenu.getMenu().getMenuId()));
		this.setText(commonlymenu.getMenu().getMenuName());
		this.setUrl(commonlymenu.getMenu().getUrlAction());
	}
}
