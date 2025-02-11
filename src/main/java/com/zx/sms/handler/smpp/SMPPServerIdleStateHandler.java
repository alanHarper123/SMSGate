package com.zx.sms.handler.smpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zx.sms.codec.smpp.msg.EnquireLink;
import com.zx.sms.common.GlobalConstance;
import com.zx.sms.session.cmpp.SessionState;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

@Sharable
public class SMPPServerIdleStateHandler extends ChannelDuplexHandler {
    private static final Logger logger = LoggerFactory.getLogger(SMPPServerIdleStateHandler.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

	if (evt instanceof IdleStateEvent) {
	    IdleStateEvent e = (IdleStateEvent) evt;
	    if (e.state() == IdleState.ALL_IDLE) {
		// 如果是CMPP连接未建立，直接关闭
		if (ctx.channel().attr(GlobalConstance.attributeKey).get() != SessionState.Connect) {
		    ctx.close();
		} else {

		    ctx.channel().writeAndFlush(new EnquireLink());
		}
	    }
	} else {
	    ctx.fireUserEventTriggered(evt);
	}
    }
}