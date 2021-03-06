package com.inter.info.model;

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
 * WfLine generated by hbm2java
 */
@Entity
@Table(name = "wf_line", catalog = "interinfo")
public class WfLine implements java.io.Serializable {

	private Integer lineId;
	private WfNode wfNodeByBeforeNodeId;
	private WfCondition wfCondition;
	private WfNode wfNodeByAfterNodeId;
	private String lineName;
	private Boolean lineStatus;

	public WfLine() {
	}

	public WfLine(WfNode wfNodeByBeforeNodeId, WfCondition wfCondition, WfNode wfNodeByAfterNodeId, String lineName,
			Boolean lineStatus) {
		this.wfNodeByBeforeNodeId = wfNodeByBeforeNodeId;
		this.wfCondition = wfCondition;
		this.wfNodeByAfterNodeId = wfNodeByAfterNodeId;
		this.lineName = lineName;
		this.lineStatus = lineStatus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "LineID", unique = true, nullable = false)
	public Integer getLineId() {
		return this.lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BeforeNodeID")
	public WfNode getWfNodeByBeforeNodeId() {
		return this.wfNodeByBeforeNodeId;
	}

	public void setWfNodeByBeforeNodeId(WfNode wfNodeByBeforeNodeId) {
		this.wfNodeByBeforeNodeId = wfNodeByBeforeNodeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ConditionID")
	public WfCondition getWfCondition() {
		return this.wfCondition;
	}

	public void setWfCondition(WfCondition wfCondition) {
		this.wfCondition = wfCondition;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AfterNodeID")
	public WfNode getWfNodeByAfterNodeId() {
		return this.wfNodeByAfterNodeId;
	}

	public void setWfNodeByAfterNodeId(WfNode wfNodeByAfterNodeId) {
		this.wfNodeByAfterNodeId = wfNodeByAfterNodeId;
	}

	@Column(name = "LineName", length = 100)
	public String getLineName() {
		return this.lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	@Column(name = "LineStatus")
	public Boolean getLineStatus() {
		return this.lineStatus;
	}

	public void setLineStatus(Boolean lineStatus) {
		this.lineStatus = lineStatus;
	}

}
