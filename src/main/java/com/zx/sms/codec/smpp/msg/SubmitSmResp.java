package com.zx.sms.codec.smpp.msg;

/*
 * #%L
 * ch-smpp
 * %%
 * Copyright (C) 2009 - 2015 Cloudhopper by Twitter
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.zx.sms.codec.smpp.SmppConstants;

public class SubmitSmResp extends BaseSmResp {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5291638876856717604L;

	public SubmitSmResp() {
        super(SmppConstants.CMD_ID_SUBMIT_SM_RESP, "submit_sm_resp");
    }
    @Override
    public int calculateByteSizeOfBody() {

        if(this.getCommandStatus()==0)
        	return super.calculateByteSizeOfBody();
        return 0;
    }
    
}