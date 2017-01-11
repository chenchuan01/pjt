package com.yidingliu.pjt.web.ext;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;

/**
 *                       
 * @Filename VelocityToolbox2View.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author chenchuan
 *
 * @Email 329985581@qq.com
 *       
 * @History
 *<li>Author: chenchuan</li>
 *<li>Date: 2017年1月11日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class VelocityToolbox2View extends VelocityToolboxView{
	@Override  
    protected Context createVelocityContext(Map<String, Object> model,  
            HttpServletRequest request,HttpServletResponse response)  
            throws Exception {
        ViewToolContext ctx;  

        ctx = new ViewToolContext(getVelocityEngine(),request, response,  
                getServletContext());  

        ctx.putAll(model);  

        if (this.getToolboxConfigLocation() != null) {  
            ToolManager tm = new ToolManager();  
           tm.setVelocityEngine(getVelocityEngine());  
           tm.configure(getServletContext().getRealPath(  
                   getToolboxConfigLocation()));  
            if (tm.getToolboxFactory().hasTools(Scope.REQUEST)) {  
               ctx.addToolbox(tm.getToolboxFactory().createToolbox(  
                        Scope.REQUEST));  
            }  
            if (tm.getToolboxFactory().hasTools(Scope.APPLICATION)) {  
               ctx.addToolbox(tm.getToolboxFactory().createToolbox(  
                        Scope.APPLICATION));  
            }  
            if (tm.getToolboxFactory().hasTools(Scope.SESSION)) {  
               ctx.addToolbox(tm.getToolboxFactory().createToolbox(  
                        Scope.SESSION));  
            }  
        }  
        return ctx;  
    }  
}
