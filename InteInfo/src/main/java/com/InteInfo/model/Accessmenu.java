package com.InteInfo.model;

// Generated 2014-2-22 21:58:09 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Accessmenu generated by hbm2java
 */
@Entity
@Table(name = "accessmenu", catalog = "interinfo")
public class Accessmenu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer accessMenuId;
	private Menu menuBySubMenuId;
	private Menu menuByParMenuId;
	private User user;
	private Boolean isCommonMenu;

	public Accessmenu() {
	}

	public Accessmenu(Menu menuBySubMenuId, Menu menuByParMenuId, User user, Boolean isCommonMenu) {
		this.menuBySubMenuId = menuBySubMenuId;
		this.menuByParMenuId = menuByParMenuId;
		this.user = user;
		this.isCommonMenu = isCommonMenu;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AccessMenuID", unique = true, nullable = false)
	public Integer getAccessMenuId() {
		return this.accessMenuId;
	}

	public void setAccessMenuId(Integer accessMenuId) {
		this.accessMenuId = accessMenuId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubMenuID")
	public Menu getMenuBySubMenuId() {
		return this.menuBySubMenuId;
	}

	public void setMenuBySubMenuId(Menu menuBySubMenuId) {
		this.menuBySubMenuId = menuBySubMenuId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ParMenuID")
	public Menu getMenuByParMenuId() {
		return this.menuByParMenuId;
	}

	public void setMenuByParMenuId(Menu menuByParMenuId) {
		this.menuByParMenuId = menuByParMenuId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "IsCommonMenu")
	public Boolean getIsCommonMenu() {
		return this.isCommonMenu;
	}

	public void setIsCommonMenu(Boolean isCommonMenu) {
		this.isCommonMenu = isCommonMenu;
	}

}