package com.zx.sms.handler.api;

import com.zx.sms.connect.manager.EndpointEntity;

import io.netty.channel.ChannelDuplexHandler;

public abstract class AbstractBusinessHandler extends ChannelDuplexHandler implements BusinessHandlerInterface, Cloneable {

	private EndpointEntity entity;

	public void setEndpointEntity(EndpointEntity entity) {
		this.entity = entity;
	}

	public EndpointEntity getEndpointEntity() {
		return entity;
	}

	public String name() {
		 return this.getClass().getSimpleName();
	}

	public AbstractBusinessHandler clone() throws CloneNotSupportedException {
		return (AbstractBusinessHandler) super.clone();
	}
}
