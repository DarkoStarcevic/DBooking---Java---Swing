package com.comtrade.proxy.login;

import java.io.IOException;
import javax.swing.JOptionPane;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.User;
import com.comtrade.user.view.UserForm;
import com.comtrade.view.adminforme.OwnerForm;
import com.comtrade.view.adminforme.SuperAdminForm;


public class ProxyLogin implements IProxy {
	
	private static final String OWNER = "owner";
	private static final String USER = "user";
	private static final String SUPER_ADMIN = "superAdmin";
	

	@Override
	public void login(User user) throws ClassNotFoundException, IOException {
		User user2 =(User) ControlerUI.getInstanca().login(user).getServer_object_response();
		if(user2.getUsername() != null && user2.getPassword() != null && user2.getStatus().equals(OWNER)) {
			OwnerForm ownerForma = new OwnerForm(user2);
			ownerForma.setVisible(true);
			
			
		}else if((user2.getUsername() != null && user2.getPassword() != null && user2.getStatus().equals(USER))) {
				UserForm userForma = new UserForm(user2);
				userForma.setVisible(true);
				
			
		}else if(user2.getUsername() != null && user2.getPassword() != null && user2.getStatus().equals(SUPER_ADMIN)) {
			SuperAdminForm superAForma = new SuperAdminForm();
			superAForma.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(null, "Login Error");
		}
		
		

	}

	
}

