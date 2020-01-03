package com.bs.fan.myjob.ui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;



/**
 * 
 * @author fanyanghua
 * @since 20190619
 * @version 1.0.0 实现可以根据名称返回子组件的方法
 */
@SuppressWarnings("serial")
public   class JCustPanel extends JPanel {
	protected Map<String, JComponent> map = new HashMap<String, JComponent>();
	public JComponent getComponentByName(String name) {
		return map.get(name);
	}


}
