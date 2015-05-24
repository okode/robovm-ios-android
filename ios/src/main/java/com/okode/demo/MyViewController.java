package com.okode.demo;

import org.robovm.apple.foundation.NSSet;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UITextFieldDelegateAdapter;
import org.robovm.apple.uikit.UITouch;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBOutlet;

import com.okode.demo.common.Common;
import com.okode.demo.common.Data;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
	
	private UITextField textField;
	private UILabel label;
	private String value;

	@Override
	public void viewDidLoad() {
		super.viewDidLoad();
		textField.setDelegate(new UITextFieldDelegateAdapter() {
			@Override
			public boolean shouldReturn(UITextField textField) {
				textField.resignFirstResponder();
				updateString();
				return true;
			}
		});
		label.setText(textField.getPlaceholder());
	}

	private void updateString() {
		value = Common.getValueFromJson(Data.JSON, textField.getText());
		label.setText(value);
	}

	@Override
	public void touchesBegan(NSSet<UITouch> touches, UIEvent event) {
		textField.resignFirstResponder();
		textField.setText(value);
		super.touchesBegan(touches, event);
	}

	@IBOutlet
	public void setTextField(UITextField textField) {
		this.textField = textField;
	}

	@IBOutlet
	public void setLabel(UILabel label) {
		this.label = label;
	}
}
